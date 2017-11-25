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

package com.suntek.mway.rcs.client.api.groupchat;

import android.os.RemoteException;

import com.suntek.mway.rcs.client.aidl.constant.Constants.GroupChatConstants;
import com.suntek.mway.rcs.client.aidl.service.entity.GroupChat;
import com.suntek.mway.rcs.client.aidl.service.entity.GroupChatMember;
import com.suntek.mway.rcs.client.api.ServiceApi;
import com.suntek.mway.rcs.client.api.exception.InviteTooManyUserException;
import com.suntek.mway.rcs.client.api.exception.ServiceDisconnectedException;
import com.suntek.mway.rcs.client.api.log.LogHelper;
import com.suntek.mway.rcs.client.api.util.VerificationUtil;

import java.util.List;

public class GroupChatApi {

    private static GroupChatApi instance;

    private GroupChatApi() {

    }

    public synchronized static GroupChatApi getInstance() {
        if (instance == null) {
            instance = new GroupChatApi();
        }
        return instance;
    }

    public List<GroupChat> getAllGroupChat() throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().getAllGroupChat();
    }

    public GroupChat getGroupChatById(long groupChatId) throws RemoteException,
            ServiceDisconnectedException {
        return ServiceApi.getServiceApi().getGroupChatById(groupChatId);
    }

    public GroupChat getGroupChatByThreadId(long threadId) throws RemoteException,
            ServiceDisconnectedException {
        return ServiceApi.getServiceApi().getGroupChatByThreadId(threadId);
    }

    public GroupChatMember getMember(long groupChatId, String number) throws RemoteException,
            ServiceDisconnectedException {
        return ServiceApi.getServiceApi().getMember(groupChatId, number);
    }

    public List<GroupChatMember> getMembers(long groupChatId) throws RemoteException,
            ServiceDisconnectedException {
        return ServiceApi.getServiceApi().getMembers(groupChatId);
    }

    public List<GroupChatMember> getMembersAllowChairman(long groupChatId) throws RemoteException,
            ServiceDisconnectedException {
        return ServiceApi.getServiceApi().getMembersAllowChairman(groupChatId);
    }

    public void getMemberAvatarFromServer(long groupChatId, String number, int pixel,
            GroupChatCallback callback) throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().getMemberAvatarFromServer(groupChatId, number, pixel, callback);
    }

    public void getMemberAvatar(long groupChatId, String number, int pixel,
            GroupChatCallback callback) throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().getMemberAvatar(groupChatId, number, pixel, callback);
    }

    public int deleteGroupChat(long[] threadIds) throws RemoteException
        , ServiceDisconnectedException {
        return ServiceApi.getServiceApi().deleteGroupChat(threadIds);
    }

    public int deleteAllGroupChat() throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().deleteAllGroupChat();
    }

    public long create(String subject, List<String> users) throws RemoteException,
            ServiceDisconnectedException, InviteTooManyUserException {
        if (!VerificationUtil.isAllNumber(users)) {
            LogHelper.i("number field value error");
            return GroupChatConstants.CONST_OTHRE_ERROR;
        }

        int maxSize = getMaxAdhocGroupSize();
        if (users.size() > maxSize) {
            throw new InviteTooManyUserException(String.valueOf(maxSize));
        }

        users = VerificationUtil.formatNumbers(users);
        return ServiceApi.getServiceApi().create(subject, users);
    }

    public int acceptToJoin(long groupChatId)
            throws RemoteException, ServiceDisconnectedException {
        return acceptToJoin(groupChatId, "");
    }

    public int acceptToJoin(long groupChatId, String inviteNumber)
            throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().acceptToJoin(groupChatId, inviteNumber);
    }

    public int rejectToJoin(long groupChatId)
            throws RemoteException, ServiceDisconnectedException {
        return rejectToJoin(groupChatId, "");
    }

    public int rejectToJoin(long groupChatId, String inviteNumber)
            throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().rejectToJoin(groupChatId, inviteNumber);
    }

    public int assignChairman(long groupChatId, String number) throws RemoteException,
            ServiceDisconnectedException {
        return ServiceApi.getServiceApi().assignChairman(groupChatId, number);
    }

    public int disband(long groupChatId) throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().disband(groupChatId);
    }

    public int invite(long groupChatId, List<String> numberList) throws RemoteException,
            ServiceDisconnectedException {
        if (!VerificationUtil.isAllNumber(numberList)) {
            LogHelper.i("number field value error");
            return GroupChatConstants.CONST_OTHRE_ERROR;
        }

        numberList = VerificationUtil.formatNumbers(numberList);
        return ServiceApi.getServiceApi().invite(groupChatId, numberList);
    }

    public int kickOut(long groupChatId, String number) throws RemoteException,
            ServiceDisconnectedException {
        return ServiceApi.getServiceApi().kickOut(groupChatId, number);
    }

    public int quit(long groupChatId) throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().quit(groupChatId);
    }

    public int setMyAlias(long groupChatId, String alias) throws RemoteException,
            ServiceDisconnectedException {
        return ServiceApi.getServiceApi().setMyAlias(groupChatId, alias);
    }

    public int setSubject(long groupChatId, String subject) throws RemoteException,
            ServiceDisconnectedException {
        return ServiceApi.getServiceApi().setSubject(groupChatId, subject);
    }

    public int setRemarks(long groupChatId, String remarks) throws RemoteException,
            ServiceDisconnectedException {
        return ServiceApi.getServiceApi().setRemarks(groupChatId, remarks);
    }

    public void setGroupChatRemindPolicy(long groupChatId, int policy) throws RemoteException,
            ServiceDisconnectedException {
        ServiceApi.getServiceApi().setGroupChatRemindPolicy(groupChatId, policy);
    }

    public int getMyGroupChat() throws RemoteException, ServiceDisconnectedException{
        return ServiceApi.getServiceApi().getMyGroupChat();
    }

    public int rejoin(long groupChatId) throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().rejoin(groupChatId);
    }

    public int getMaxAdhocGroupSize() throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().getMaxAdhocGroupSize();
    }
}
