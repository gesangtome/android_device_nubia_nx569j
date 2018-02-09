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

package com.suntek.mway.rcs.client.aidl.service.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class GroupChatMember implements Parcelable {

    /**
     * Chairman role
     */
    public static final int CHAIRMAN = 1;

    /**
     * Member role
     */
    public static final int MEMBER = 0;

    /**
     * Represents members allowed to become administrator
     */
    public static final String ALLOWED_TO_BE_CHAIRMAN = "gpmanage";

    private long id;

    private long groupId;

    private String number;

    private String alias;

    private int role = -1;

    private String etype;

    private String etag;

    private String imageType;

    private String imageCode;

    private long date;

    public GroupChatMember() {
    }

    public GroupChatMember(Parcel source) {
        readFromParcel(source);
    }

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // TODO Auto-generated method stub
        dest.writeLong(id);
        dest.writeLong(groupId);
        dest.writeString(number);
        dest.writeString(alias);
        dest.writeInt(role);
        dest.writeString(etype);
        dest.writeString(etag);
        dest.writeString(imageType);
        dest.writeString(imageCode);
        dest.writeLong(date);
    }

    public void readFromParcel(Parcel source) {
        id = source.readLong();
        groupId = source.readLong();
        number = source.readString();
        alias = source.readString();
        role = source.readInt();
        etype = source.readString();
        etag = source.readString();
        imageType = source.readString();
        imageCode = source.readString();
        date = source.readLong();
    }

    public static final Parcelable.Creator<GroupChatMember> CREATOR =
            new Parcelable.Creator<GroupChatMember>() {
        public GroupChatMember createFromParcel(Parcel in) {
            return new GroupChatMember(in);
        }

        @Override
        public GroupChatMember[] newArray(int size) {
            return new GroupChatMember[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getEtype() {
        return etype;
    }

    public void setEtype(String etype) {
        this.etype = etype;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

}
