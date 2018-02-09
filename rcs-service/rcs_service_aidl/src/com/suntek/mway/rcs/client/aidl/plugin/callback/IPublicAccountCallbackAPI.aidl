/*
 * Copyright (c) 2014-2015 pci-suntektech Technologies, Inc.  All Rights Reserved.
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
package com.suntek.mway.rcs.client.aidl.plugin.callback;

import com.suntek.mway.rcs.client.aidl.plugin.entity.pubacct.MsgContent;
import com.suntek.mway.rcs.client.aidl.plugin.entity.pubacct.MenuInfo;
import com.suntek.mway.rcs.client.aidl.plugin.entity.pubacct.MenuInfoMode;
import com.suntek.mway.rcs.client.aidl.plugin.entity.pubacct.PublicAccounts;
import com.suntek.mway.rcs.client.aidl.plugin.entity.pubacct.PublicAccountsDetail;
import com.suntek.mway.rcs.client.aidl.plugin.entity.pubacct.PublicAccounts;

/**
 * <p>Title: Public account callback api</p>
 * <p>Description: The public account callback api need the client app to implement, The plugin center will invoke the client app by this interface</p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: pci-suntek</p>
 *
 * @author zrq
 * @version 1.0
 *
 */
interface IPublicAccountCallbackAPI
{
    /**
     * response the follow public account result
     *
     * @param result
     *            if follow success
     */
    //void respAddSubscribe( boolean result );

    /**
     * response the cancel public account result
     *
     * @param result
     *            if cancel success
     */
    //void respCancelSubscribe( boolean result );

    /**
     * response the complain public account result
     * @param result if complain success
     */
    //void respComplainPublic( boolean result );

    /**
     * response the query public account history message result
     * @param result if query success
     * @param msgContent the message content entity list
     */
    void respGetPreMessage( boolean result, in List<MsgContent> msgContent );

    /**
     * response the query public account menu info
     * @param result if query success
     * @param menus the menu's entity
     */
    void respGetPublicMenuInfo( boolean result, in MenuInfoMode menuInfoMode );

    /**
     * response the query user follow public account list
     * @param result if query success
     * @param pubAcctList the public accounts entity list
     */
    void respGetUserSubscribePublicList( boolean result, in List<PublicAccounts> pubAcctList );

    /**
     * response the query public account detail
     * @param result if query success
     * @param accountDetail the public account detail entity
     */
    void respGetPublicDetail( boolean result, in PublicAccountsDetail accountDetail );

    /**
     * response the query public accounts
     * @param result if query success
     * @param accountList the public account entity list
     */
    void respGetPublicList( boolean result, in List<PublicAccounts> accountList );

    /**
     * response the follow public account entity
     * @param result if query success
     * @param account public account
     */
    void respAddSubscribeAccount(boolean result, in PublicAccounts account);

    /**
     * response the follow public account
     * @param result if query success
     * @param account public account
     */
    void respCancelSubscribeAccount(boolean result, in PublicAccounts account);

    /**
     * response the follow public account
     * @param result if query success
     * @param account public account
     */
    void respComplainPublicAccount(boolean result, in PublicAccounts account);

    /**
     * response the follow public account
     * @param result if query success
     * @param account public account
     */
    //void respGetPreMessageAccount(boolean result, in PublicAccounts account);

    /**
     * response the follow public menu info xml string
     * @param result if query success
     * @param xmlString public menu info xml string
     */
    //void respGetPublicMenuInfoString(boolean result, String xmlString);

    /**
     * response the follow public account
     * @param result if query success
     * @param account public account
     */
    //void respGetPublicMenuInfoAccount(boolean result, in PublicAccounts account);

    /**
     * response the query recommend public accounts
     * @param result if query success
     * @param accountList the public account entity list
     */
    void respGetPublicRecommend(boolean result, in List<PublicAccounts> accountList);

    /**
     * response the set accept status
     * @param result if query success
     * @param uuid the public account uuid
     */
    void respSetAcceptStatus(boolean result, String uuid);
}
