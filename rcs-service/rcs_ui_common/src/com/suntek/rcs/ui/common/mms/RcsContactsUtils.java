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

package com.suntek.rcs.ui.common.mms;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.provider.ContactsContract.RawContacts;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.text.TextUtils;

import com.suntek.mway.rcs.client.aidl.service.entity.GroupChatMember;
import com.suntek.mway.rcs.client.api.groupchat.GroupChatApi;
import com.suntek.mway.rcs.client.api.exception.ServiceDisconnectedException;

public class RcsContactsUtils {
    public static final String NOTIFY_CONTACT_PHOTO_CHANGE =
            "com.suntek.mway.rcs.NOTIFY_CONTACT_PHOTO_CHANGE";
    public static final String LOCAL_PHOTO_SETTED = "local_photo_setted";
    public static final String MIMETYPE_RCS = "vnd.android.cursor.item/rcs";
    public static final String PHONE_PRE_CODE = "+86";

    public static String getMyRcsRawContactId(Context context){
        String rawContactId = null;
        Uri uri = Uri.parse("content://com.android.contacts/profile/data/");
        Cursor cursor = context.getContentResolver().query(
                uri,
                new String[] {"raw_contact_id"}, null,null, null);
        if(cursor != null){
            if(cursor.moveToNext()){
                rawContactId = cursor.getString(0);
                cursor.close();
                cursor = null;
            }
        }
       return rawContactId;
    }

    public static String getRawContactId(Context context,String contactId) {
        String rawContactId = null;
        Cursor cursor = context.getContentResolver()
                .query(RawContacts.CONTENT_URI,
                        new String[] { RawContacts._ID },
                        RawContacts.CONTACT_ID + "=?",
                        new String[] { contactId }, null);
        if (null != cursor) {
            if (cursor.moveToNext())
                rawContactId = cursor.getString(0);
            cursor.close();
            cursor = null;
        }
        return rawContactId;
    }

    public static String getGroupChatMemberDisplayName(Context context, long groupId,
            String number) {
        List<GroupChatMember> list = null;
        try {
            list = GroupChatApi.getInstance().getMembers(groupId);
            if (list == null || list.size() == 0) {
                return number;
            }
        } catch (ServiceDisconnectedException e) {
            e.printStackTrace();
        } catch (RemoteException e){
            e.printStackTrace();
        }

        for (GroupChatMember groupChatMember : list) {
            if (groupChatMember.getNumber().equals(number)) {
                if (!TextUtils.isEmpty(groupChatMember.getAlias())) {
                    return groupChatMember.getAlias();
                } else {
                    return getContactNameFromPhoneBook(context, number);
                }
            }
        }
        return number;
    }

    public static String getContactNameFromPhoneBook(Context context, String phoneNum) {
        String contactName = phoneNum;
        String numberW86;
        if (!phoneNum.startsWith(PHONE_PRE_CODE)) {
            numberW86 = PHONE_PRE_CODE + phoneNum;
        } else {
            numberW86 = phoneNum;
            phoneNum = phoneNum.substring(3);
        }
        String formatNumber = getAndroidFormatNumber(phoneNum);

        ContentResolver cr = context.getContentResolver();
        Cursor pCur = cr.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[] {
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                },
                ContactsContract.CommonDataKinds.Phone.NUMBER + " = ? OR "
                        + ContactsContract.CommonDataKinds.Phone.NUMBER + " = ? OR "
                        + ContactsContract.CommonDataKinds.Phone.NUMBER + " = ? ",
                new String[] {
                        phoneNum, numberW86, formatNumber
                }, null);
        try {
            if (pCur != null && pCur.moveToFirst()) {
                contactName = pCur.getString(pCur
                        .getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            }
        } finally {
            if (pCur != null) {
                pCur.close();
            }
        }
        return contactName;
    }

    public static String getAndroidFormatNumber(String number) {
        if (TextUtils.isEmpty(number)) {
            return number;
        }

        number = number.replaceAll(" ", "");

        if (number.startsWith(PHONE_PRE_CODE)) {
            number = number.substring(3);
        }

        if (number.length() != 11) {
            return number;
        }

        StringBuilder builder = new StringBuilder();
        // builder.append("+86 ");
        builder.append(number.substring(0, 3));
        builder.append(" ");
        builder.append(number.substring(3, 7));
        builder.append(" ");
        builder.append(number.substring(7));
        return builder.toString();
    }

    private static class UpdatePhotosTask extends AsyncTask<Void, Void, Void> {

        private Context mContext;
        private String mNumber;

        private Handler mHandler = new Handler();

        UpdatePhotosTask(Context context, String number) {
            mContext = context;
            mNumber = number;
        }

        @Override
        protected Void doInBackground(Void... params) {
            long aContactId =getContactIdByNumber(mContext, mNumber);
            ContentResolver resolver= mContext.getContentResolver();
            Cursor c = resolver.query(RawContacts.CONTENT_URI, new String[] {
                    RawContacts._ID
            }, RawContacts.CONTACT_ID + "=" + String.valueOf(aContactId), null, null);
            final ArrayList<Long> rawContactIdList = new ArrayList<Long>();
            if(c != null){
                try {
                    if (c.moveToFirst()) {
                        // boolean hasTryToGet = false;
                        do {
                            long rawContactId = c.getLong(0);
                            if (!hasLocalSetted(resolver, rawContactId)) {
                                rawContactIdList.add(rawContactId);
                            }
                        } while (c.moveToNext());
                    }
                } finally {
                    if(c != null)
                        c.close();
                }
            }
//            if (rawContactIdList.size() > 0) {
//                try {
//                    ProfileApi.getInstance().getHeadPicByContact(aContactId,
//                            new ProfileListener() {
//
//                                @Override
//                                public void onAvatarGet(final Avatar photo,
//                                        final int resultCode, final String resultDesc)
//                                        throws RemoteException {
//                                    mHandler.post(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            if (resultCode == 0) {
//                                                if (photo != null) {
//                                                    byte[] contactPhoto = Base64.decode(
//                                                            photo.getImgBase64Str(),
//                                                            android.util.Base64.DEFAULT);
//                                                    for (long rawContactId : rawContactIdList) {
//                                                        final Uri outputUri = Uri.withAppendedPath(
//                                                                ContentUris
//                                                                        .withAppendedId(
//                                                                                RawContacts.CONTENT_URI,
//                                                                                rawContactId),
//                                                                RawContacts.DisplayPhoto.CONTENT_DIRECTORY);
//                                                        setContactPhoto(mContext,
//                                                                contactPhoto, outputUri);
//                                                    }
//                                                    //notify mms list
//                                                    mContext.sendBroadcast(new Intent(NOTIFY_CONTACT_PHOTO_CHANGE));
//                                                }
//                                            } else {
//                                            }
//                                        }
//                                    });
//                                }
//
//                                @Override
//                                public void onAvatarUpdated(int arg0, String arg1)
//                                        throws RemoteException {
//                                }
//
//                                @Override
//                                public void onProfileGet(Profile arg0, int arg1, String arg2)
//                                        throws RemoteException {
//                                }
//
//                                @Override
//                                public void onProfileUpdated(int arg0, String arg1)
//                                        throws RemoteException {
//                                }
//
//                                @Override
//                                public void onQRImgDecode(QRCardInfo imgObj, int resultCode,
//                                        String arg2) throws RemoteException {
//                                }
//                            });
//                } catch (ServiceDisconnectedException e) {
//                    e.printStackTrace();
//                }
//            }
            return null;
        }

    }

    public static void updateContactPhotosByNumber(Context context,String number) {
        new UpdatePhotosTask(context,number).execute();
    }

    public static void setContactPhoto(Context context, byte[] input,
            Uri outputUri) {
        FileOutputStream outputStream = null;

        try {
            outputStream = context.getContentResolver().openAssetFileDescriptor(outputUri, "rw")
                    .createOutputStream();
            outputStream.write(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                outputStream.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean hasLocalSetted(ContentResolver resolver, long rawContactId) {
        Cursor c = resolver.query(ContactsContract.RawContacts.CONTENT_URI, new String[] {
                LOCAL_PHOTO_SETTED
        }, RawContacts._ID + " = ? ", new String[] {
                String.valueOf(rawContactId)
        }, null);
        long localSetted = 0;
        try {
            if (c != null && c.moveToFirst()) {
                localSetted = c.getLong(0);
            }
        } finally {
            c.close();
        }
        return (localSetted == 1) ? true : false;
    }

    public static long getContactIdByNumber(Context context, String number) {
        if (TextUtils.isEmpty(number)) {
            return -1;
        }
        String numberW86 = number;
        if (!number.startsWith("+86")) {
            numberW86 = "+86" + number;
        } else {
            numberW86 = number.substring(3);
        }
        Cursor cursor = context.getContentResolver().query(Phone.CONTENT_URI, new String[] {
                Phone.CONTACT_ID
        }, Phone.NUMBER + "=? OR " + Phone.NUMBER + "=?", new String[] {
                number, numberW86
        }, null);
        if (cursor != null) {
            try{
                if (cursor.moveToFirst()) {
                    return cursor.getInt(0);
                }
            } finally {
                cursor.close();
            }
        }
        return -1;
    }
}
