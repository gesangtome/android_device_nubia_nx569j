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

package com.suntek.mway.rcs.client.api.specialnumber;

import android.os.RemoteException;

import com.suntek.mway.rcs.client.api.ServiceApi;
import com.suntek.mway.rcs.client.api.exception.ServiceDisconnectedException;

import java.util.List;

public class SpecialServiceNumApi {

    private static SpecialServiceNumApi instance;

    private SpecialServiceNumApi() {

    }

    public synchronized static SpecialServiceNumApi getInstance() {
        if (instance == null) {
            instance = new SpecialServiceNumApi();
        }
        return instance;
    }

    public boolean addSsn(String number) throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().addSsn(number);
    }

    public boolean disableSsn() throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().disableSsn();
    }

    public String deleteSsnPrefix(String number) throws RemoteException,
            ServiceDisconnectedException {
        return ServiceApi.getServiceApi().deleteSsnPrefix(number);
    }

    public List<String> getSsnList() throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().getSsnList();
    }

    public boolean enableSsn() throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().enableSsn();
    }

    public boolean deleteSsn(String number) throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().deleteSsn(number);
    }

    public boolean deleteAllSsn() throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().deleteAllSsn();
    }
}
