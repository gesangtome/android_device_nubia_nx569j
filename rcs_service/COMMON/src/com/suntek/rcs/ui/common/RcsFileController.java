/*
 * Copyright (c) 2015 pci-suntektech Technologies, Inc.  All Rights Reserved.
 * pci-suntektech Technologies Proprietary and Confidential.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to
 * deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */

package com.suntek.rcs.ui.common;

import java.io.File;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.RemoteException;
import android.provider.DocumentsContract;
import android.provider.MediaStore;

import android.text.TextUtils;

import com.suntek.rcs.ui.common.RcsLog;
import com.suntek.mway.rcs.client.aidl.constant.Constants.MessageConstants;
import com.suntek.mway.rcs.client.api.exception.ServiceDisconnectedException;
import com.suntek.mway.rcs.client.api.message.MessageApi;

public class RcsFileController {

    public static final int FILE_NOT_EXCEEDED_RCS_LIMIT = 0;

    public static final int FILE_EXCEEDED_RCS_LIMIT = 1;

    public static final int FILE_ERROR = 2;

    private static final int BYTE_TRANSFER_TO_KB = 1024;

    private static final String EXTRNAL_STORAGE_DOCUMENT_URI =
            "com.android.externalstorage.documents";

    private static final String DOWNLOAD_DOCUMENT_URI =
            "com.android.providers.downloads.documents";

    private static final String MEDIA_DOCUMENT_URI = "com.android.providers.media.documents";

    private static final Uri PUBLIC_DOWNLOAD_URI =
            Uri.parse("content://downloads/public_downloads");

    private static final String MEDIA_STORE_IMAGE = "image";

    private static final String MEDIA_STORE_VIDEO = "video";

    private static final String MEDIA_STORE_AUDIO = "audio";

    private static final String CONTENT = "content";

    private static final String FILE = "file";

    private static final String PRIMARY = "primary";

    private static final int DATA_COLUMN_INDEX = 0;

    private static final String[] DATA_DOCUMENT_PROJECTION = {
        "_data"
    };

    /**
     * @param filePath the file patch
     * @param fileType file type image or video
     * @return 0 file not exceed rcs file limit
     * @return 1 file exceed rcs file limit
     * @return 2 file error
     */
    public static int checkFileLegality(String filePath, int fileType) {
        if (TextUtils.isEmpty(filePath)) {
            return FILE_ERROR;
        }
        File file = new File(filePath);
        if (file.exists()) {
            long rcsFileLimit = getRcsTransferFileMaxSize(fileType);
            long fileLength = file.length()/BYTE_TRANSFER_TO_KB;
            RcsLog.d("file limit size:" + fileLength+ "::" + rcsFileLimit);
            if (fileLength > rcsFileLimit) {
                return FILE_EXCEEDED_RCS_LIMIT;
            } else {
                return FILE_NOT_EXCEEDED_RCS_LIMIT;
            }
        } else {
            return FILE_ERROR;
        }

    }

    public static long getFileSizes(Context context, Uri uri) {
        File file = new File(getFilePath(context, uri));
        long length = 0;
        if (file != null && file.exists()) {
            length = file.length();
        }
        return length;
    }

    public static long getRcsTransferFileMaxSize(int fileType) {
        try {
            switch(fileType) {
                case MessageConstants.CONST_MESSAGE_IMAGE:
                    return MessageApi.getInstance().getImageMaxSize();
                case MessageConstants.CONST_MESSAGE_VIDEO:
                case MessageConstants.CONST_MESSAGE_AUDIO:
                    return MessageApi.getInstance().getVideoMaxSize();
                default:
                    return 0;
            }
        } catch (ServiceDisconnectedException exception) {
            exception.printStackTrace();
        } catch (RemoteException e) {
            RcsLog.w(e);
        }
        return 0;
    }

    public static long getRcsTransferFileMaxDuration(int fileType) {
        try {
            switch(fileType) {
                case MessageConstants.CONST_MESSAGE_AUDIO:
                    return MessageApi.getInstance().getAudioMaxDuration();
                case MessageConstants.CONST_MESSAGE_VIDEO:
                    return MessageApi.getInstance().getVideoMaxDuration();
                default:
                    return 0;
            }
        } catch (ServiceDisconnectedException exception) {
            exception.printStackTrace();
        } catch (RemoteException e) {
            RcsLog.w(e);
        }
        return 0;
    }

    /**
     * @param context The context.
     * @param uri The Uri to query.
     */
    public static String getFilePath(final Context context, final Uri uri) {

        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
        final String authority = uri.getAuthority();
        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
            if (EXTRNAL_STORAGE_DOCUMENT_URI.equals(authority)) {
                final String[] split = getTypeString(uri);
                if (PRIMARY.equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                } else {
                    return "";
                }
            } else if (MEDIA_DOCUMENT_URI.equals(authority)) {
                return getMediaStoreFilePath(context, uri);
            } else if (DOWNLOAD_DOCUMENT_URI.equals(authority)) {
                final Uri contentUri = ContentUris.withAppendedId(PUBLIC_DOWNLOAD_URI,
                        Long.valueOf(DocumentsContract.getDocumentId(uri)));
                return getDataColumnFilePath(context, contentUri, null, null);
            }
        } else if (FILE.equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        } else if (CONTENT.equalsIgnoreCase(uri.getScheme())) {
            return getDataColumnFilePath(context, uri, null, null);
        }
        return null;
    }

    private static String[] getTypeString(Uri uri) {
        final String docId = DocumentsContract.getDocumentId(uri);
        return docId.split(":");
    }

    private static String getMediaStoreFilePath(Context context, Uri uri) {
        final String[] split = getTypeString(uri);
        Uri contentUri = null;
        if (MEDIA_STORE_IMAGE.equals(split[0])) {
            contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if (MEDIA_STORE_AUDIO.equals(split[0])) {
            contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        } else if (MEDIA_STORE_VIDEO.equals(split[0])) {
            contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        final String selection = "_id = ?";
        final String[] selectionArgs = new String[] {
            split[1]
        };
        return getDataColumnFilePath(context, contentUri, selection, selectionArgs);
    }

    public static String getDataColumnFilePath(Context context, Uri uri, String selection,
            String[] selectionArgs) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, DATA_DOCUMENT_PROJECTION, selection,
                    selectionArgs, null);
            if (cursor != null && cursor.moveToFirst()) {
                return cursor.getString(DATA_COLUMN_INDEX);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }
}
