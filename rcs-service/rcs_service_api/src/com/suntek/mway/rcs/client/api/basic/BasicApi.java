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

package com.suntek.mway.rcs.client.api.basic;

import android.os.RemoteException;

import com.suntek.mway.rcs.client.api.ServiceApi;
import com.suntek.mway.rcs.client.api.exception.ServiceDisconnectedException;

public class BasicApi {

    private static BasicApi instance;

    private BasicApi() {

    }

    public synchronized static BasicApi getInstance() {
        if (instance == null) {
            instance = new BasicApi();
        }
        return instance;
    }

    public void login(String account) throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().login(account);
    }

    public void logout() throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().logout();
    }

    public void startPluginCenter() throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().startPluginCenter();
    }

    public void openAccount() throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().openAccount();
    }

    public void rejectOpenAccount() throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().rejectOpenAccount();
    }

    public void getConfiguration() throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().getConfiguration();
    }

    public void getConfigurationWithOtp(String otpCode) throws RemoteException,
            ServiceDisconnectedException {
        ServiceApi.getServiceApi().getConfigurationWithOtp(otpCode);
    }

    public String getAccount() throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().getAccount();
    }

    public boolean isOnline() throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().isOnline();
    }

    public void startService() throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().startService();
    }

}
