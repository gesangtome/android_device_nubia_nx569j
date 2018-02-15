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

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.ImageView;

import com.suntek.mway.rcs.client.aidl.constant.Parameter;
import com.suntek.mway.rcs.client.aidl.plugin.entity.profile.Avatar;
import com.suntek.mway.rcs.client.aidl.plugin.entity.profile.Profile;
import com.suntek.mway.rcs.client.aidl.plugin.entity.profile.QRCardImg;
import com.suntek.mway.rcs.client.aidl.plugin.entity.profile.QRCardInfo;
import com.suntek.mway.rcs.client.api.exception.ServiceDisconnectedException;
import com.suntek.mway.rcs.client.api.groupchat.GroupChatCallback;
import com.suntek.mway.rcs.client.api.groupchat.GroupChatApi;
import com.suntek.mway.rcs.client.api.profile.ProfileApi;
import com.suntek.mway.rcs.client.api.profile.ProfileListener;
import com.suntek.rcs.ui.common.RcsLog;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class RcsMyProfileCache {
    private final static int IMAGE_PIXEL = 120;
    private HashMap<String, SoftReference<Bitmap>> mImageCache;
    private boolean mIsRuning = false;
    private static RcsMyProfileCache sInstance;
    private ImageView mImageView;

    private RcsMyProfileCache(ImageView imageView) {
        RcsLog.i("new RcsMyProfileCache");
        mImageView = imageView;
        new Thread(runnable).start();
    }

    public Bitmap getMyHeadPic() {
        if (mImageCache != null) {
            SoftReference<Bitmap> rf = mImageCache.get("me");
            return rf.get();
        }
        return null;
    }

    public static RcsMyProfileCache getInstance(ImageView photoView) {
        if (sInstance == null) {
            sInstance = new RcsMyProfileCache(photoView);
        }
        return sInstance;
    }

    private void getbitmap() {
        try {
            ProfileApi.getInstance().getMyHeadPic(new ProfileListener() {

                @Override
                public void onAvatarGet(final Avatar photo, final int resultCode,
                        final String resultDesc) throws RemoteException {
                    RcsLog.i("RcsMyProfileCache get my photo from service");
                    if (photo != null) {
                        String str = photo.getImgBase64Str();
                        if (str != null) {
                            byte[] imageByte = Base64.decode(str, Base64.DEFAULT);
                            Bitmap bitmap = BitmapFactory.decodeByteArray(imageByte, 0,
                                    imageByte.length);
                            if (mHandler != null) {
                                Message msg = new Message();
                                msg.obj = bitmap;
                                mHandler.sendMessage(msg);
                            }
                        }
                    }
                }

                @Override
                public void onAvatarUpdated(int arg0, String arg1) throws RemoteException {
                }

                @Override
                public void onProfileGet(Profile arg0, int arg1, String arg2)
                        throws RemoteException {
                }

                @Override
                public void onProfileUpdated(int arg0, String arg1) throws RemoteException {
                }

                @Override
                public void onQRImgDecode(QRCardInfo imgObj, int resultCode, String arg2)
                        throws RemoteException {
                }
            });
        } catch (ServiceDisconnectedException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            getbitmap();
        }
    };

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            RcsLog.i("handler receiver message");
            mImageCache = new HashMap<String, SoftReference<Bitmap>>();
            Bitmap bitmap = (Bitmap)msg.obj;
            mImageView.setImageBitmap(bitmap);
            if (bitmap != null) {
                addBitmapCache("me", bitmap);
            }
        }
    };

    public void removeCache(String number){
        mImageCache.remove(number);
    }

    public void addBitmapCache(String number, Bitmap bitmap) {
        if (bitmap != null) {
            RcsLog.i("RcsMyProfileCache add bitmap to cache, number="
                + number);
            mImageCache.put(number, new SoftReference<Bitmap>(bitmap));
        }
    }
}
