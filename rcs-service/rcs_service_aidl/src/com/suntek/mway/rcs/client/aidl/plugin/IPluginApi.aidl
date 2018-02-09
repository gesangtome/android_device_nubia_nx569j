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
package com.suntek.mway.rcs.client.aidl.plugin;

//profile
import com.suntek.mway.rcs.client.aidl.plugin.callback.IProfileListener;
import com.suntek.mway.rcs.client.aidl.plugin.entity.profile.Profile;
import com.suntek.mway.rcs.client.aidl.plugin.entity.profile.Avatar;

//public account
import com.suntek.mway.rcs.client.aidl.plugin.callback.IPublicAccountCallbackAPI;
import com.suntek.mway.rcs.client.aidl.plugin.entity.pubacct.PublicAccountsDetail;
import com.suntek.mway.rcs.client.aidl.plugin.entity.pubacct.PublicAccounts;

//contact
import com.suntek.mway.rcs.client.aidl.plugin.callback.IContactSyncListener;

//cloud file
import com.suntek.mway.rcs.client.aidl.plugin.callback.ICloudOperationCtrl;

//emoticon
import com.suntek.mway.rcs.client.aidl.plugin.entity.emoticon.EmojiPackageBO;
import com.suntek.mway.rcs.client.aidl.plugin.entity.emoticon.EmoticonBO;

//rich screen
import com.suntek.mway.rcs.client.aidl.plugin.entity.richscrn.ResultInfo;
import com.suntek.mway.rcs.client.aidl.plugin.entity.richscrn.ResultUtil;
import com.suntek.mway.rcs.client.aidl.plugin.entity.richscrn.PhoneList;

interface IPluginApi
{
    /*
     * profile
     */
    void setMyProfile(in Profile profile, IProfileListener listener);

    void setMyHeadPic(in Avatar avatar, IProfileListener listener);

    void getMyProfile(IProfileListener listener);

    void getMyHeadPic(IProfileListener listener);

    void getHeadPicByContact(long contactId, IProfileListener listener);

    void getHeadPicByNumber(String number, int pixel, IProfileListener listener);

    void refreshMyQRImg(in Profile profile, boolean includeEInfo, IProfileListener listener);

    void updateContactsHeadPicAtFixedRateEveryDay(String hhmm,IProfileListener listener);

    String getUpdateTimeOfContactsHeadPic();

    /*
     * public account
     */
    void addSubscribe( String uuid );

    void cancelSubscribe( String uuid );

    void complainPublic( String uuid, String reason, String description, int type, String data );

    void getPreMessage( String uuid, String timestamp, int order, int pageSize, int pageNum );

    void getPublicDetail( String uuid );

    void getPublicList( String keywords, int pageSize, int pageNum, int order );

    void getPublicMenuInfo( String uuid );

    void getUserSubscribePublicList();

    void registerCallback( IPublicAccountCallbackAPI callback );

    void unregisterCallback( IPublicAccountCallbackAPI callback );

    void getRecommendPublic(int type, int pageSize, int pageNum);

    void setAcceptStatus(String uuid, int acceptStatus);

    /*
     * contact
     */
    void doSync(int syncAction, IContactSyncListener listener);

    void startIntervalSync(int syncAction, int intervalAction, long time);

    void cancelIntervalSync();

    int getIntervalSyncMode();

    void setEnableAutoSync(boolean status,int syncAction);

    boolean getEnableAutoSync();

    int getAutoSync();

    void setOnlySyncEnableViaWifi(boolean status);

    boolean getOnlySyncEnableViaWifi();

    int getLocalContactCounts();

    int getRemoteContactCounts();

    /*
     * cloud file
     */
    ICloudOperationCtrl putFile(String localPath, String remotePath, int transOper);

    ICloudOperationCtrl downloadFileFromUrl(String remoteUrl, String fileName, int transOper, long chatMessageId);

    void shareFile(String fileId, String shareDesc);

    void getRemoteFileList(String remotePath, int beginIndex, int endIndex, int fileNodeOrder);

    void getShareFileList(int beginIndex, int endIndex);

    String getLocalRootPath();

    void shareFileAndSend(String fileId, String shareDesc, in List<String> contacts,
            long threadId, String smsContentTemp, int barCycle);

    void shareFileAndSendGroup(String fileId, String shareDesc, long threadId, long groupId);

    /*
     * emoticon
     */
    List<EmojiPackageBO> queryEmojiPackages();

    List<EmojiPackageBO> queryEmojiPackagesWithDetail();

    List<EmoticonBO> queryEmoticons( String packageId);

    List<EmoticonBO> queryEmoticonName(String emoticonName);

    EmojiPackageBO getEmojiPackage( String packageId);

    EmojiPackageBO getEmojiPackageWithDetail( String packageId);

    EmoticonBO getEmoticon( String emoticonId );

    boolean isEmojiPackageExist( String packageId);//todo  emojiPackageExist-->isEmojiPackageExist

    boolean isCanSend(String emoticonId);

    byte[] decrypt2Bytes(String emoticonId, int emoFileType);

    String getStorageRootPath();

    boolean isEmojiStoreInstall();

    void startEmojiStoreApp();

    void downloadEmoticon(String emoticonId, long messageRowId);

    /*
     * rich screen
     */
    ResultUtil getRichScrnObj( String missdn, String phoneEvent );

    ResultInfo downloadRichScrnObj(String missdn, String phoneEvent );

    ResultInfo clearRichScrnLocalCache(String phoneEvent );

    ResultInfo downloadHomeLocRules(String phoneEvent );

    ResultInfo richScrnChangeNetWork();

    ResultInfo collectRichScrnObj (String sourceType, String cId);

    void startRichScreenApp(in List<String> mobileList);
}
