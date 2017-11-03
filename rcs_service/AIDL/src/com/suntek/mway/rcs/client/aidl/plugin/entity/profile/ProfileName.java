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

package com.suntek.mway.rcs.client.aidl.plugin.entity.profile;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class ProfileName implements Parcelable {
    private String displayName = null;

    private String nickName = null;

    private String familyName = null;

    private String firstName = null;

    private String givenName = null;

    private String middleName = null;

    private String nameSuffix = null;

    private String namePrefix = null;

    public ProfileName() {
    }

    public ProfileName(Parcel source) {
        readFromParcel(source);
    }

    /**
     * The parcel describe contents, defaul is 0.
     *
     * @return the int
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Write the avatar entity to parcel stream. Pay attention to read and write
     * variables variables sequence should be consistent or not the correct
     * results
     *
     * @param dest the dest
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(displayName);
        dest.writeString(nickName);
        dest.writeString(familyName);
        dest.writeString(firstName);
        dest.writeString(givenName);
        dest.writeString(middleName);
        dest.writeString(nameSuffix);
        dest.writeString(namePrefix);
    }

    /**
     * Create the avatar entity from parcel stream. Pay attention to read and
     * write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        displayName = source.readString();
        nickName = source.readString();
        familyName = source.readString();
        firstName = source.readString();
        givenName = source.readString();
        middleName = source.readString();
        nameSuffix = source.readString();
        namePrefix = source.readString();
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<ProfileName> CREATOR =
            new Parcelable.Creator<ProfileName>() {
        @Override
        public ProfileName createFromParcel(Parcel source) {
            return new ProfileName(source);
        }

        @Override
        public ProfileName[] newArray(int size) {
            return new ProfileName[size];
        }
    };

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getNameSuffix() {
        return nameSuffix;
    }

    public void setNameSuffix(String nameSuffix) {
        this.nameSuffix = nameSuffix;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    @Override
    public String toString() {
        List<String> list = new ArrayList<String>();
        list.add("displayName=" + this.displayName);
        list.add("nickName=" + this.nickName);
        list.add("familyName=" + this.familyName);
        list.add("firstName=" + this.firstName);
        list.add("givenName=" + this.givenName);
        list.add("middleName=" + this.middleName);
        list.add("nameSuffix=" + this.nameSuffix);
        list.add("namePrefix=" + this.namePrefix);
        return list.toString();
    }
}
