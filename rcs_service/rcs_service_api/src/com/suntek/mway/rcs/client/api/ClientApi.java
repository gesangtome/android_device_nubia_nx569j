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

package com.suntek.mway.rcs.client.api;

import android.content.Context;

import com.suntek.mway.rcs.client.api.basic.BasicApi;
import com.suntek.mway.rcs.client.api.blacklist.BlackListApi;
import com.suntek.mway.rcs.client.api.capability.CapabilityApi;
import com.suntek.mway.rcs.client.api.cloudfile.CloudFileApi;
import com.suntek.mway.rcs.client.api.contact.ContactApi;
import com.suntek.mway.rcs.client.api.emoticon.EmoticonApi;
import com.suntek.mway.rcs.client.api.groupchat.GroupChatApi;
import com.suntek.mway.rcs.client.api.message.MessageApi;
import com.suntek.mway.rcs.client.api.profile.ProfileApi;
import com.suntek.mway.rcs.client.api.publicaccount.PublicAccountApi;
import com.suntek.mway.rcs.client.api.richscreen.RichScreenApi;
import com.suntek.mway.rcs.client.api.specialnumber.SpecialServiceNumApi;
import com.suntek.mway.rcs.client.api.support.SupportApi;

public class ClientApi {

    public void init(Context context, ServiceListener serviceListener,
            ServiceListener pluginListener) {
        if (null != serviceListener) {
            ServiceApi.getInstance().init(context, serviceListener);
        }

        if (null != pluginListener) {
            PluginApi.getInstance().init(context, pluginListener);
        }
    }

    public void destory(Context context) {
        ServiceApi.getInstance().destory(context);
        PluginApi.getInstance().destory(context);
    }

    public BasicApi getBasicApi() {
        return BasicApi.getInstance();
    }

    public BlackListApi getBlackListApi() {
        return BlackListApi.getInstance();
    }

    public CapabilityApi getCapabilityApi() {
        return CapabilityApi.getInstance();
    }

    public GroupChatApi getGroupChatApi() {
        return GroupChatApi.getInstance();
    }

    public MessageApi getMessageApi() {
        return MessageApi.getInstance();
    }

    public SpecialServiceNumApi getSpecialServiceNumApi() {
        return SpecialServiceNumApi.getInstance();
    }

    public SupportApi getSupportApi() {
        return SupportApi.getInstance();
    }

    public ProfileApi getProfileApi() {
        return ProfileApi.getInstance();
    }

    public PublicAccountApi getPublicAccountApi() {
        return PublicAccountApi.getInstance();
    }

    public ContactApi getContactApi() {
        return ContactApi.getInstance();
    }

    public CloudFileApi getCloudFileApi() {
        return CloudFileApi.getInstance();
    }

    public EmoticonApi getEmoticonApi() {
        return EmoticonApi.getInstance();
    }

    public RichScreenApi getRichScreenApi() {
        return RichScreenApi.getInstance();
    }
}
