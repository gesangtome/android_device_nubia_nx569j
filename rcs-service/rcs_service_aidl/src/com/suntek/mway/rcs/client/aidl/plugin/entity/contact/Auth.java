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

package com.suntek.mway.rcs.client.aidl.plugin.entity.contact;

import android.os.Parcel;
import android.os.Parcelable;

public class Auth implements Parcelable {

    private String username;

    private String session;

    private String userId;

    private String sessionkey;

    private String message;

    private String imei;

    private String deviceId;

    private String token;

    private String version;

    private String contact_session;

    private boolean enableSync;

    private boolean isAutoSync;

    private String syncSn;

    private String aoiToken;

    private String contactUserId;

    private boolean isLocalIntent;

    private String channelId;

    private boolean isThirdPart = false;

    private int error_code;

    private String error_message;

    private String syncFrequency;

    private int result_code;

    public Auth() {
    }

    public Auth(Parcel source) {
        readFromParcel(source);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.username);
        paramParcel.writeString(this.session);
        paramParcel.writeString(this.userId);
        paramParcel.writeString(this.sessionkey);
        paramParcel.writeString(this.message);
        paramParcel.writeString(this.imei);
        paramParcel.writeString(this.deviceId);
        paramParcel.writeString(this.token);
        paramParcel.writeString(this.version);
        paramParcel.writeString(this.contact_session);
        paramParcel.writeInt(this.enableSync == true ? 1 : 0);
        paramParcel.writeInt(this.isAutoSync == true ? 1 : 0);
        paramParcel.writeString(this.syncSn);
        paramParcel.writeString(this.aoiToken);
        paramParcel.writeString(this.contactUserId);
        paramParcel.writeInt(this.isLocalIntent == true ? 1 : 0);
        paramParcel.writeString(this.channelId);
        paramParcel.writeInt(this.isThirdPart == true ? 1 : 0);
        paramParcel.writeInt(this.error_code);
        paramParcel.writeString(this.error_message);
        paramParcel.writeString(this.syncFrequency);
        paramParcel.writeInt(this.result_code);
    }

    public void readFromParcel(Parcel paramParcel) {
        String str1 = paramParcel.readString();
        setUsername(str1);
        String str2 = paramParcel.readString();
        setSession(str2);
        String str3 = paramParcel.readString();
        setUserId(str3);
        String str4 = paramParcel.readString();
        setSessionkey(str4);
        String str5 = paramParcel.readString();
        setMessage(str5);
        String str6 = paramParcel.readString();
        setImei(str6);
        String str7 = paramParcel.readString();
        setDeviceId(str7);
        String str8 = paramParcel.readString();
        setToken(str8);
        String str9 = paramParcel.readString();
        setVersion(str9);
        String str10 = paramParcel.readString();
        setContact_session(str10);
        boolean bool1 = paramParcel.readInt() > 0;
        setEnableSync(bool1);
        boolean bool2 = paramParcel.readInt() > 0;
        setAutoSync(bool2);
        String str11 = paramParcel.readString();
        setSyncSn(str11);
        String str12 = paramParcel.readString();
        setAoiToken(str12);
        String str13 = paramParcel.readString();
        setContactUserId(str13);
        boolean bool3 = paramParcel.readInt() > 0;
        setLocalIntent(bool3);
        String str14 = paramParcel.readString();
        setChannelId(str14);
        boolean bool4 = paramParcel.readInt() > 0;
        setThirdPart(bool4);
        int i = paramParcel.readInt();
        setError_code(i);
        String str15 = paramParcel.readString();
        setError_message(str15);
        String str16 = paramParcel.readString();
        setSyncFrequency(str16);
        setResult_code(paramParcel.readInt());

    }

    /** The parcel creator. */
    public static final Parcelable.Creator<Auth> CREATOR =
            new Parcelable.Creator<Auth>() {
        @Override
        public Auth createFromParcel(Parcel source) {
            return new Auth(source);
        }

        @Override
        public Auth[] newArray(int size) {
            return new Auth[size];
        }
    };

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSessionkey() {
        return sessionkey;
    }

    public void setSessionkey(String sessionkey) {
        this.sessionkey = sessionkey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getContact_session() {
        return contact_session;
    }

    public void setContact_session(String Contact_session) {
        this.contact_session = Contact_session;
    }

    public boolean isEnableSync() {
        return enableSync;
    }

    public void setEnableSync(boolean enableSync) {
        this.enableSync = enableSync;
    }

    public boolean isAutoSync() {
        return isAutoSync;
    }

    public void setAutoSync(boolean isAutoSync) {
        this.isAutoSync = isAutoSync;
    }

    public String getSyncSn() {
        return syncSn;
    }

    public void setSyncSn(String syncSn) {
        this.syncSn = syncSn;
    }

    public String getAoiToken() {
        return aoiToken;
    }

    public void setAoiToken(String aoiToken) {
        this.aoiToken = aoiToken;
    }

    public String getContactUserId() {
        return contactUserId;
    }

    public void setContactUserId(String contactUserId) {
        this.contactUserId = contactUserId;
    }

    public boolean isLocalIntent() {
        return isLocalIntent;
    }

    public void setLocalIntent(boolean isLocalIntent) {
        this.isLocalIntent = isLocalIntent;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public boolean isThirdPart() {
        return isThirdPart;
    }

    public void setThirdPart(boolean isThirdPart) {
        this.isThirdPart = isThirdPart;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public String getSyncFrequency() {
        return syncFrequency;
    }

    public void setSyncFrequency(String syncFrequency) {
        this.syncFrequency = syncFrequency;
    }

    public int getResult_code() {
        return result_code;
    }

    public void setResult_code(int result_code) {
        this.result_code = result_code;
    }

}
