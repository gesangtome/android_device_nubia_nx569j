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

package com.suntek.mway.rcs.client.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.suntek.mway.rcs.client.aidl.constant.Main;
import com.suntek.mway.rcs.client.aidl.service.IServiceApi;
import com.suntek.mway.rcs.client.api.exception.ServiceDisconnectedException;
import com.suntek.mway.rcs.client.api.log.LogHelper;
import com.suntek.mway.rcs.client.api.util.VerificationUtil;

public class ServiceApi {

    /** check whether the service is binded or not */
    private boolean isBinded = false;

    private String SERVICE_BIND_AIDL = Main.SERVICE_BIND_AIDL;

    protected ServiceListener rcsListener = null;

    protected Context context = null;

    protected boolean isNormallyClosed = false;

    protected int reconnectionTimes = 1;

    protected final int MAX_RECONECTION_TIMES = 5;

    private static ServiceApi instance;

    private static IServiceApi serviceApi;

    private ServiceApi() {
    }

    public synchronized static ServiceApi getInstance() {
        if (null == instance) {
            instance = new ServiceApi();
        }
        return instance;
    }

    public Context getContext() {
        return context;
    }

    public static IServiceApi getServiceApi() throws ServiceDisconnectedException {
        VerificationUtil.ApiIsNull(serviceApi);
        return serviceApi;
    }

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            if (isNormallyClosed || reconnectionTimes > MAX_RECONECTION_TIMES) {
                LogHelper.d("service api disconnect service");
                serviceApi = null;

                reconnectionTimes = 1;
                notifyServiceDisconnected();
            } else {
                LogHelper.d("illegal call serviceApi api disconnect service :" + reconnectionTimes);
                init(context, rcsListener);
                if (!isBinded()) {
                    // app is uninstalled
                    serviceApi = null;

                    notifyServiceDisconnected();
                }
                reconnectionTimes++;
            }
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            serviceApi = IServiceApi.Stub.asInterface(service);

            reconnectionTimes = 1;
            notifyServiceConnected();
            LogHelper.d("IServiceApi have success connect");
        }
    };

    /**
     * judge the bind state about remote service.
     *
     * @return true if binded, return false if unbinded.
     */
    public boolean isBinded() {
        return isBinded;
    }

    public void init(Context context, ServiceListener listener) {
        this.rcsListener = listener;
        this.context = context;
        Intent intent = new Intent();
        // intent.setAction(serviceName);
        intent.setClassName(Main.PACKAGE_NAME, SERVICE_BIND_AIDL);
        isBinded = context.bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
        LogHelper.d("bind " + SERVICE_BIND_AIDL + "--> result:" + isBinded);
    }

    public void destory(Context context) {
        try {
            if (isBinded) {
                LogHelper.d("destory()--> to destroy service : " + SERVICE_BIND_AIDL);
                isNormallyClosed = true;
                context.unbindService(mConnection);
            } else {
                LogHelper.i("destory()--> service(" + SERVICE_BIND_AIDL
                        + ") already unbinded, do not need to destroy.");
            }
        } catch (Exception e) {
            LogHelper.e("unbind " + SERVICE_BIND_AIDL + "--> result:" + e.getMessage(), e);
        } finally {
            isBinded = false;
        }
    }

    protected void notifyServiceConnected() {
        if (rcsListener != null) {
            try {
                rcsListener.onServiceConnected();
            } catch (RemoteException e) {
                LogHelper.e(e.getMessage(), e);
            }
        }
    }

    protected void notifyServiceDisconnected() {
        if (rcsListener != null) {
            try {
                rcsListener.onServiceDisconnected();
            } catch (RemoteException e) {
                LogHelper.e(e.getMessage(), e);
            }
        }
    }
}
