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

package com.suntek.mway.rcs.client.api.cloudfile;

import android.os.RemoteException;
import android.text.TextUtils;

import com.suntek.mway.rcs.client.aidl.plugin.callback.ICloudOperationCtrl;
import com.suntek.mway.rcs.client.aidl.plugin.entity.cloudfile.FileNode;
import com.suntek.mway.rcs.client.aidl.plugin.entity.cloudfile.TransNode;
import com.suntek.mway.rcs.client.api.PluginApi;
import com.suntek.mway.rcs.client.api.exception.ServiceDisconnectedException;
import com.suntek.mway.rcs.client.api.log.LogHelper;
import com.suntek.mway.rcs.client.api.util.VerificationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CloudFileApi {

    private static CloudFileApi instance;

    private CloudFileApi() {

    }

    public synchronized static CloudFileApi getInstance() {
        if (instance == null) {
            instance = new CloudFileApi();
        }
        return instance;
    }

    public ICloudOperationCtrl downloadFileFromUrl(String remoteUrl, String fileName,
            TransNode.TransOper transOper, long chatMessageId) throws RemoteException,
            ServiceDisconnectedException {
        return PluginApi.getPluginApi().downloadFileFromUrl(remoteUrl, fileName, transOper.ordinal(),
                chatMessageId);
    }

    public String getLocalRootPath() throws RemoteException, ServiceDisconnectedException {
        return PluginApi.getPluginApi().getLocalRootPath();
    }

    public void getRemoteFileList(String remotePath, int beginIndex,
            int endIndex, FileNode.Order fileOrder)
            throws RemoteException, ServiceDisconnectedException {
        PluginApi.getPluginApi().getRemoteFileList(
                remotePath, beginIndex, endIndex, fileOrder.ordinal());
    }

    public void getShareFileList(int beginIndex, int endIndex) throws RemoteException,
            ServiceDisconnectedException {
        PluginApi.getPluginApi().getShareFileList(beginIndex, endIndex);
    }

    public ICloudOperationCtrl putFile(String localPath, String remotePath, TransNode.TransOper transOper)
            throws RemoteException, ServiceDisconnectedException {
        return PluginApi.getPluginApi().putFile(localPath, remotePath, transOper.ordinal());
    }

    public void shareFile(String fileId, String shareDesc) throws RemoteException,
            ServiceDisconnectedException {
        PluginApi.getPluginApi().shareFile(fileId, shareDesc);
    }

    public void shareFileAndSend(String fileId, String shareDesc, String number,
            long threadId, String smsContentTemp, int barCycle) throws RemoteException,
            ServiceDisconnectedException {
        LogHelper
        .i(String.format(
                Locale.getDefault(),
                "enter method shareFileAndSend. [fileId,shareDesc,number,threadId,"
                        + "smsContentTemp,barCycle]=%s,%s,%s,%d,%s,%d",
                        fileId, shareDesc, number, threadId, smsContentTemp, barCycle));
        if (!VerificationUtil.isNumber(number)) {
            LogHelper.i("number field value error");
        }
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
        }
        if (TextUtils.isEmpty(fileId)) {
            LogHelper.i("fileId is empty");
        }

        number = VerificationUtil.formatNumber(number);
        List<String> numberList = new ArrayList<String>();
        numberList.add(number);
        PluginApi.getPluginApi().shareFileAndSend(fileId, shareDesc, numberList, threadId,
                smsContentTemp, barCycle);
    }

    public void shareFileAndSend(String fileId, String shareDesc, List<String> numberList,
            long threadId, String smsContentTemp, int barCycle) throws RemoteException,
            ServiceDisconnectedException {
        LogHelper
        .i(String.format(
                Locale.getDefault(),
                "enter method shareFileAndSend. [fileId,shareDesc,numberList,threadId,"
                + "smsContentTemp,barCycle]=%s,%s,%s,%d,%s,%d",
                fileId, shareDesc, VerificationUtil.getNumberListString(numberList),
                threadId, smsContentTemp, barCycle));
        if (!VerificationUtil.isAllNumber(numberList)) {
            LogHelper.i("number field value error");
        }
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
        }
        if (TextUtils.isEmpty(fileId)) {
            LogHelper.i("fileId is empty");
        }

        numberList = VerificationUtil.formatNumbers(numberList);
        PluginApi.getPluginApi().shareFileAndSend(fileId, shareDesc, numberList, threadId,
                smsContentTemp, barCycle);
    }

    public void shareFileAndSendGroup(String fileId, String shareDesc, long threadId, long groupId)
            throws RemoteException, ServiceDisconnectedException  {
        LogHelper
        .i(String.format(
                Locale.getDefault(),
                "enter method shareFileAndSendGroup. [fileId,shareDesc,threadId,groupId]" +
                "=%s,%s,%d,%d",
                fileId, shareDesc, threadId, groupId));
        if (TextUtils.isEmpty(fileId)) {
            LogHelper.i("fileId is empty");
        }
        PluginApi.getPluginApi().shareFileAndSendGroup(fileId, shareDesc, threadId, groupId);
    }
}
