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

package com.suntek.mway.rcs.client.api.contact;

import android.os.RemoteException;

import com.suntek.mway.rcs.client.aidl.plugin.callback.IContactSyncListener;
import com.suntek.mway.rcs.client.aidl.plugin.entity.contact.IntervalAction;
import com.suntek.mway.rcs.client.aidl.plugin.entity.contact.SyncAction;
import com.suntek.mway.rcs.client.api.PluginApi;
import com.suntek.mway.rcs.client.api.exception.ServiceDisconnectedException;

public class ContactApi {

    private static ContactApi instance;

    private ContactApi() {

    }

    public synchronized static ContactApi getInstance() {
        if (instance == null) {
            instance = new ContactApi();
        }
        return instance;
    }

    public void cancelIntervalSync() throws RemoteException, ServiceDisconnectedException {
        PluginApi.getPluginApi().cancelIntervalSync();
    }

    public void doSync(SyncAction syncAction, IContactSyncListener listener) throws RemoteException,
            ServiceDisconnectedException {
        PluginApi.getPluginApi().doSync(syncAction.ordinal(), listener);
    }

    public int getAutoSync() throws RemoteException, ServiceDisconnectedException {
        return PluginApi.getPluginApi().getAutoSync();
    }

    public boolean getEnableAutoSync() throws RemoteException, ServiceDisconnectedException {
        return PluginApi.getPluginApi().getEnableAutoSync();
    }

    public int getIntervalSyncMode() throws RemoteException, ServiceDisconnectedException {
        return PluginApi.getPluginApi().getIntervalSyncMode();
    }

    public int getLocalContactCounts() throws RemoteException, ServiceDisconnectedException {
        return PluginApi.getPluginApi().getLocalContactCounts();
    }

    public boolean getOnlySyncEnableViaWifi()
            throws RemoteException, ServiceDisconnectedException {
        return PluginApi.getPluginApi().getOnlySyncEnableViaWifi();
    }

    public int getRemoteContactCounts() throws RemoteException, ServiceDisconnectedException {
        return PluginApi.getPluginApi().getRemoteContactCounts();
    }

    public void setEnableAutoSync(boolean status, SyncAction syncAction) throws RemoteException,
            ServiceDisconnectedException {
        PluginApi.getPluginApi().setEnableAutoSync(status, syncAction.ordinal());
    }

    public void setOnlySyncEnableViaWifi(boolean status) throws RemoteException,
            ServiceDisconnectedException {
        PluginApi.getPluginApi().setOnlySyncEnableViaWifi(status);
    }

    public void startIntervalSync(SyncAction syncAction, IntervalAction intervalAction, long time)
            throws RemoteException, ServiceDisconnectedException {
        PluginApi.getPluginApi().startIntervalSync(syncAction.ordinal(), intervalAction.ordinal(), time);
    }
}
