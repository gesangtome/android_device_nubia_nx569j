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

package com.suntek.mway.rcs.client.api.emoticon;

import android.os.RemoteException;

import com.suntek.mway.rcs.client.aidl.plugin.entity.emoticon.EmojiPackageBO;
import com.suntek.mway.rcs.client.aidl.plugin.entity.emoticon.EmoticonBO;
import com.suntek.mway.rcs.client.api.PluginApi;
import com.suntek.mway.rcs.client.api.exception.ServiceDisconnectedException;

import java.util.List;

public class EmoticonApi {

    private static EmoticonApi instance;

    private EmoticonApi() {

    }

    public synchronized static EmoticonApi getInstance() {
        if (instance == null) {
            instance = new EmoticonApi();
        }
        return instance;
    }

    public byte[] decrypt2Bytes(String emoticonId, int emoFileType) throws RemoteException,
            ServiceDisconnectedException {
        return PluginApi.getPluginApi().decrypt2Bytes(emoticonId, emoFileType);
    }

    public EmojiPackageBO getEmojiPackage(String packageId) throws RemoteException,
            ServiceDisconnectedException {
        return PluginApi.getPluginApi().getEmojiPackage(packageId);
    }

    public EmojiPackageBO getEmojiPackageWithDetail(String packageId) throws RemoteException,
            ServiceDisconnectedException {
        return PluginApi.getPluginApi().getEmojiPackageWithDetail(packageId);
    }

    public EmoticonBO getEmoticon(String emoticonId) throws RemoteException,
            ServiceDisconnectedException {
        return PluginApi.getPluginApi().getEmoticon(emoticonId);
    }

    public String getStorageRootPath() throws RemoteException, ServiceDisconnectedException {
        return PluginApi.getPluginApi().getStorageRootPath();
    }

    public boolean isCanSend(String emoticonId) throws RemoteException,
            ServiceDisconnectedException {
        return PluginApi.getPluginApi().isCanSend(emoticonId);
    }

    public boolean isEmojiPackageExist(String packageId) throws RemoteException,
            ServiceDisconnectedException {
        return PluginApi.getPluginApi().isEmojiPackageExist(packageId);
    }

    public boolean isEmojiStoreInstall() throws RemoteException, ServiceDisconnectedException {
        return PluginApi.getPluginApi().isEmojiStoreInstall();
    }

    public List<EmojiPackageBO> queryEmojiPackages() throws RemoteException,
            ServiceDisconnectedException {
        return PluginApi.getPluginApi().queryEmojiPackages();
    }

    public List<EmojiPackageBO> queryEmojiPackagesWithDetail() throws RemoteException,
            ServiceDisconnectedException {
        return PluginApi.getPluginApi().queryEmojiPackagesWithDetail();
    }

    public List<EmoticonBO> queryEmoticonName(String emoticonName) throws RemoteException,
            ServiceDisconnectedException {
        return PluginApi.getPluginApi().queryEmoticonName(emoticonName);
    }

    public List<EmoticonBO> queryEmoticons(String packageId) throws RemoteException,
            ServiceDisconnectedException {
        return PluginApi.getPluginApi().queryEmoticons(packageId);
    }

    public void startEmojiStoreApp() throws RemoteException, ServiceDisconnectedException {
        PluginApi.getPluginApi().startEmojiStoreApp();
    }

    public void downloadEmoticon(String emoticonId, long messageRowId)
            throws RemoteException, ServiceDisconnectedException{
        PluginApi.getPluginApi().downloadEmoticon(emoticonId, messageRowId);
    }
}
