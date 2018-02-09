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
package com.suntek.mway.rcs.client.aidl.service;

import android.net.Uri;

import com.suntek.mway.rcs.client.aidl.service.callback.ICapabiltyListener;
import com.suntek.mway.rcs.client.aidl.service.callback.IGroupChatCallback;
import com.suntek.mway.rcs.client.aidl.service.entity.GroupChat;
import com.suntek.mway.rcs.client.aidl.service.entity.GroupChatMember;
import com.suntek.mway.rcs.client.aidl.service.entity.SimpleMessage;

interface IServiceApi {

    // basicApi
    void login(String account);
    void logout();

    void startPluginCenter();

    void openAccount();
    void rejectOpenAccount();
    void getConfiguration();
    void getConfigurationWithOtp(String otpCode);
    String getAccount();
    boolean isOnline();
    void startService();

    // messageApi
    void download(long id);
    void complain(long id);
    void backupAll();
    void backUpFavouriteAll();
    void backup(in List<SimpleMessage> simpleMessageList);
    void burnAll();
    //void burn(long id);
    void burn(long id, int delaySeconds);
    void cancelBackup();
    void cancelCollect(in List<SimpleMessage> simpleMessageList);
    void cancelTopConversation(long threadId);
    void collect(in List<SimpleMessage> simpleMessageList);
    //void forward(long id, String number);
    long forward(long id, long threadId, in List<String> numberList, int barCycle);
    long forwardToGroupChat(long id, long threadId, long groupId);
    long getThreadId(in List<String> numberList);
    int getAudioMaxDuration();
    long getImageMaxSize();
    int getVideoMaxDuration();
    long getVideoMaxSize();
    int getRemindPolicy();
    int getSendPolicy();
    void pauseDownload(long id);
    int recoverBlockedMessage(long blockedMessageId);
    int recoverBlockedMessageByThreadId(long threadId);
    int deleteAllMessage();
    int deleteMessageByThreadId(long threadId);
    int deleteMessage(long id);
    void restoreAll();
    void restoreAllFavourite();
    void startComposing(long threadId, String number, String contentType, int seconds);
    void stopComposing(long threadId, String number, String contentType, long lastActive);
    void resend(long id);
    long sendText(in List<String> numberList, long threadId, String text, int barCycle);
    long sendImage(in List<String> numberList, long threadId, String filepath, int quality, boolean isRecord, int barCycle, String thumbnailPath);
    long sendAudio(in List<String> numberList, long threadId, String filepath, int duration, boolean isRecord, int barCycle);
    long sendVideo(in List<String> numberList, long threadId, String filepath, int duration, boolean isRecord, int barCycle, String thumbnailPath);
    long sendLocation(in List<String> numberList, long threadId, double lat, double lng, String label, int barCycle);
    long sendVcard(in List<String> numberList, long threadId, String filepath, int barCycle);
    long sendTextToGroupChat(long groupId, long threadId, String text);
    long sendImageToGroupChat(long groupId, long threadId, String filepath, int quality, boolean isRecord, String thumbnailPath);
    long sendAudioToGroupChat(long groupId, long threadId, String filepath, int duration, boolean isRecord);
    long sendVideoToGroupChat(long groupId, long threadId, String filepath, int duration, boolean isRecord, String thumbnailPath);
    long sendLocationToGroupChat(long groupId, long threadId, double lat, double lng, String label);
    long sendVcardToGroupChat(long groupId, long threadId, String filepath);
    long sendTextToPc(long threadId, String text, int barCycle);
    long sendImageToPc(long threadId, String filepath, int quality, boolean isRecord, int barCycle, String thumbnailPath);
    long sendAudioToPc(long threadId, String filepath, int duration, boolean isRecord, int barCycle);
    long sendVideoToPc(long threadId, String filepath, int duration, boolean isRecord, int barCycle, String thumbnailPath);
    long sendLocationToPc(long threadId, double lat, double lng, String label, int barCycle);
    long sendVcardToPc(long threadId, String filepath, int barCycle);
    void setRemindPolicy(int policy);
    void setSendPolicy(int policy);
    int topConversation(long threadId);
    int markMessageAsReaded(long id);

    // specialServiceNumApi
    boolean addSsn(String number);
    boolean disableSsn();
    String deleteSsnPrefix(String number);
    List<String> getSsnList();
    boolean enableSsn();
    boolean deleteSsn(String number);
    boolean deleteAllSsn();

    // blacklistApi
    boolean addBlacklist(String number, String name);
    boolean isBlacklist(String number);
    void clearBlacklist();
    List<String> getBlacklist();
    boolean deleteBlacklist(String number);
    void setBlacklistProvider(in Uri uri);

    // capabilityApi
    void getCapability(String number, boolean fromServer, ICapabiltyListener listener);

    // groupChatApi
    List<GroupChat> getAllGroupChat();
    GroupChat getGroupChatById(long groupChatId);
    GroupChat getGroupChatByThreadId(long threadId);
    GroupChatMember getMember(long groupChatId, String number);
    List<GroupChatMember> getMembers(long groupChatId);
    List<GroupChatMember> getMembersAllowChairman(long groupChatId);
    void getMemberAvatarFromServer(long groupChatId, String number, int pixel, in IGroupChatCallback callback);
    void getMemberAvatar(long groupChatId, String number, int pixel, in IGroupChatCallback callback);
    long create(String subject, in List<String> users);
    int acceptToJoin(long groupChatId, String inviteNumber);
    int rejectToJoin(long groupChatId, String inviteNumber);
    int assignChairman(long groupChatId, String number);
    int disband(long groupChatId);
    int invite(long groupChatId, in List<String> numberList);
    int kickOut(long groupChatId, String number);
    int quit(long groupChatId);
    int setMyAlias(long groupChatId, String alias);
    int setSubject(long groupChatId, String subject);
    int setRemarks(long groupChatId, String remarks);
    void setGroupChatRemindPolicy(long groupChatId, int policy);
    int deleteGroupChat(in long[] threadIds);
    int deleteAllGroupChat();
    int getMyGroupChat();
    int rejoin(long groupChatId);
    int getMaxAdhocGroupSize();

    // send message of plugin
    // emoticon
    long sendEmoticon(in List<String> numberList, long threadId, String emoticonId, String emoticonName, int barCycle);
    long sendEmoticonToGroupChat(long groupId, long threadId, String emoticonId, String emoticonName);
    long sendEmoticonToPc(long threadId, String emoticonId, String emoticonName, int barCycle);
    // cloud
    long sendCloud(in List<String> numberList, long threadId, String fileName, long fileSize, String shareUrl, String smsContent, int barCycle);
    long sendCloudToGroupChat(long groupId, long threadId, String fileName, long fileSize, String shareUrl);
    long sendCloudToPc(long threadId, String fileName, long fileSize, String shareUrl, String smsContent, int barCycle);
    // public account
    long sendTextToPublicAccount(String publicAccountId, long threadId, String text);
    long sendImageToPublicAccount(String publicAccountId, long threadId, String filepath, int quality, boolean isRecord, String thumbnailPath);
    long sendAudioToPublicAccount(String publicAccountId, long threadId, String filepath, int duration, boolean isRecord);
    long sendVideoToPublicAccount(String publicAccountId, long threadId, String filepath, int duration, boolean isRecord, String thumbnailPath);
    long sendLocationToPublicAccount(String publicAccountId, long threadId, double lat, double lng, String label);
    long sendVcardToPublicAccount(String publicAccountId, long threadId, String filepath);
    long sendCommandToPublicAccount(String publicAccountId, long threadId, String text);

}
