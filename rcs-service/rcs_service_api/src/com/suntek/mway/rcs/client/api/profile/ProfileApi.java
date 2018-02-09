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

package com.suntek.mway.rcs.client.api.profile;

import android.os.RemoteException;

import com.suntek.mway.rcs.client.aidl.plugin.entity.profile.Avatar;
import com.suntek.mway.rcs.client.aidl.plugin.entity.profile.Profile;
import com.suntek.mway.rcs.client.api.PluginApi;
import com.suntek.mway.rcs.client.api.exception.ServiceDisconnectedException;

public class ProfileApi {

    private static ProfileApi instance;

    private ProfileApi() {

    }

    public synchronized static ProfileApi getInstance() {
        if (instance == null) {
            instance = new ProfileApi();
        }
        return instance;
    }

    public void getHeadPicByContact(long contactId, ProfileListener listener)
            throws RemoteException, ServiceDisconnectedException {
        PluginApi.getPluginApi().getHeadPicByContact(contactId, listener);
    }

    public void getHeadPicByNumber(String number, int pixel, ProfileListener listener)
            throws RemoteException, ServiceDisconnectedException {
        PluginApi.getPluginApi().getHeadPicByNumber(number, pixel, listener);
    }

    public void getMyHeadPic(ProfileListener listener) throws RemoteException,
            ServiceDisconnectedException {
        PluginApi.getPluginApi().getMyHeadPic(listener);
    }

    public void getMyProfile(ProfileListener listener) throws RemoteException,
            ServiceDisconnectedException {
        PluginApi.getPluginApi().getMyProfile(listener);
    }

    public String getUpdateTimeOfContactsHeadPic() throws RemoteException,
            ServiceDisconnectedException {
        return PluginApi.getPluginApi().getUpdateTimeOfContactsHeadPic();
    }

    public void refreshMyQRImg(Profile profile, boolean includeEInfo, ProfileListener listener)
            throws RemoteException, ServiceDisconnectedException {
        PluginApi.getPluginApi().refreshMyQRImg(profile, includeEInfo, listener);
    }

    public void setMyHeadPic(Avatar avatar, ProfileListener listener) throws RemoteException,
            ServiceDisconnectedException {
        PluginApi.getPluginApi().setMyHeadPic(avatar, listener);
    }

    public void setMyProfile(Profile profile, ProfileListener listener) throws RemoteException,
            ServiceDisconnectedException {
        PluginApi.getPluginApi().setMyProfile(profile, listener);
    }

    public void updateContactsHeadPicAtFixedRateEveryDay(String hhmm, ProfileListener listener)
            throws RemoteException, ServiceDisconnectedException {
        PluginApi.getPluginApi().updateContactsHeadPicAtFixedRateEveryDay(hhmm, listener);
    }
}
