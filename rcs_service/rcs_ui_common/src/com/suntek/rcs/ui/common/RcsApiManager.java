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

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;

import com.suntek.mway.rcs.client.api.ClientApi;
import com.suntek.mway.rcs.client.api.ServiceListener;
import com.suntek.mway.rcs.client.api.support.SupportApi;
import com.suntek.rcs.ui.common.RcsLog;

public class RcsApiManager {

    private static ServiceListener mServiceApiListener = new ServiceListener() {
            @Override
            public void onServiceDisconnected() {
                RcsLog.d("serviceApi disconnected");
            }

            @Override
            public void onServiceConnected() {
                RcsLog.d("serviceApi connected");
            }
        };

    private static ServiceListener mPluginApiListener = new ServiceListener() {
            @Override
            public void onServiceDisconnected() {
                RcsLog.d("pluginApi disconnected");
            }

            @Override
            public void onServiceConnected() {
                RcsLog.d("pluginApi connected");
            }
        };

    public static void init(Context context) {
        SupportApi.getInstance().initApi(context);
        new ClientApi().init(context, mServiceApiListener, mPluginApiListener);
    }
}

