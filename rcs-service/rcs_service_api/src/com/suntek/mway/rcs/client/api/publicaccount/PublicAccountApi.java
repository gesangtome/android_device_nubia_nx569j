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

package com.suntek.mway.rcs.client.api.publicaccount;

import android.os.RemoteException;

import com.suntek.mway.rcs.client.aidl.plugin.callback.IPublicAccountCallbackAPI;
import com.suntek.mway.rcs.client.api.PluginApi;
import com.suntek.mway.rcs.client.api.exception.ServiceDisconnectedException;

public class PublicAccountApi {

    private static PublicAccountApi instance;

    private PublicAccountApi() {

    }

    public synchronized static PublicAccountApi getInstance() {
        if (instance == null) {
            instance = new PublicAccountApi();
        }
        return instance;
    }

    public void addSubscribe(String uuid, PublicAccountCallback callback) throws RemoteException,
            ServiceDisconnectedException {
        PluginApi.getPluginApi().registerCallback(callback);
        PluginApi.getPluginApi().addSubscribe(uuid);
    }

    public void cancelSubscribe(String uuid, PublicAccountCallback callback)
            throws RemoteException, ServiceDisconnectedException {
        PluginApi.getPluginApi().registerCallback(callback);
        PluginApi.getPluginApi().cancelSubscribe(uuid);
    }

    public void complainPublic(String uuid, String reason, String description, int type,
            String data, PublicAccountCallback callback) throws RemoteException,
            ServiceDisconnectedException {
        PluginApi.getPluginApi().registerCallback(callback);
        PluginApi.getPluginApi().complainPublic(uuid, reason, description, type, data);
    }

    public void getPreMessage(String uuid, String timestamp, int order, int pageSize, int pageNum,
            PublicAccountCallback callback) throws RemoteException, ServiceDisconnectedException {
        PluginApi.getPluginApi().registerCallback(callback);
        PluginApi.getPluginApi().getPreMessage(uuid, timestamp, order, pageSize, pageNum);
    }

    public void getPublicDetail(String uuid, PublicAccountCallback callback)
            throws RemoteException, ServiceDisconnectedException {
        PluginApi.getPluginApi().registerCallback(callback);
        PluginApi.getPluginApi().getPublicDetail(uuid);
    }

    public void getPublicList(String keywords, int pageSize, int pageNum, int order,
            PublicAccountCallback callback) throws RemoteException, ServiceDisconnectedException {
        PluginApi.getPluginApi().registerCallback(callback);
        PluginApi.getPluginApi().getPublicList(keywords, pageSize, pageNum, order);
    }

    public void getPublicMenuInfo(String uuid, PublicAccountCallback callback)
            throws RemoteException, ServiceDisconnectedException {
        PluginApi.getPluginApi().registerCallback(callback);
        PluginApi.getPluginApi().getPublicMenuInfo(uuid);
    }

    public void getRecommendPublic(int type, int pageSize, int pageNum,
            PublicAccountCallback callback) throws RemoteException, ServiceDisconnectedException {
        PluginApi.getPluginApi().registerCallback(callback);
        PluginApi.getPluginApi().getRecommendPublic(type, pageSize, pageNum);
    }

    public void getUserSubscribePublicList(PublicAccountCallback callback) throws RemoteException,
            ServiceDisconnectedException {
        PluginApi.getPluginApi().registerCallback(callback);
        PluginApi.getPluginApi().getUserSubscribePublicList();
    }

    public void setAcceptStatus(String uuid, int acceptStatus, PublicAccountCallback callback)
            throws RemoteException, ServiceDisconnectedException {
        PluginApi.getPluginApi().registerCallback(callback);
        PluginApi.getPluginApi().setAcceptStatus(uuid, acceptStatus);
    }

    public void unregisterCallback(IPublicAccountCallbackAPI callback) throws RemoteException,
            ServiceDisconnectedException {
        PluginApi.getPluginApi().unregisterCallback(callback);
    }
}
