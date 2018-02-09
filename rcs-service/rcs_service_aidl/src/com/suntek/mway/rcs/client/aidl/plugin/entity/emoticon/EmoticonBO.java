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

package com.suntek.mway.rcs.client.aidl.plugin.entity.emoticon;

import android.os.Parcel;
import android.os.Parcelable;

public class EmoticonBO implements Parcelable {
    /** The emoticon id. */
    private String emoticonId;

    /** The emoticon name. */
    private String emoticonName;

    /** The emoticon static url. */
    private String emoticonStatic;

    /** The emoticon dynamic url. */
    private String emoticonDynamic;

    /** The package id. */
    private String packageId;

    /** The static emoticon bytes. */
    private byte[] emoticonStaticByte;

    /** The dynamic emoticon bytes. */
    private byte[] emoticonDynamicByte;

    /** The user phone number. */
    private String userPhone;

    /** The is only browse. */
    private boolean isOnlyBrowse;

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
     * Write the emoticon entity to parcel stream. Pay attention to read and
     * write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param dest the dest
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(emoticonId);
        dest.writeString(emoticonName);
        dest.writeString(emoticonStatic);
        dest.writeString(emoticonDynamic);
        dest.writeString(packageId);
        dest.writeByteArray(emoticonStaticByte);
        dest.writeByteArray(emoticonDynamicByte);
        dest.writeString(userPhone);
        dest.writeBooleanArray(new boolean[] {
            isOnlyBrowse
        });
    }

    /**
     * Create the emoticon entity from parcel stream. Pay attention to read and
     * write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        emoticonId = source.readString();
        emoticonName = source.readString();
        emoticonStatic = source.readString();
        emoticonDynamic = source.readString();
        packageId = source.readString();
        emoticonStaticByte = source.createByteArray();
        emoticonDynamicByte = source.createByteArray();
        userPhone = source.readString();
        boolean[] val = new boolean[1];
        source.readBooleanArray(val);
        isOnlyBrowse = val[0];
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<EmoticonBO> CREATOR =
            new Parcelable.Creator<EmoticonBO>() {
        @Override
        public EmoticonBO createFromParcel(Parcel source) {
            return new EmoticonBO(source);
        }

        @Override
        public EmoticonBO[] newArray(int size) {
            return new EmoticonBO[size];
        }
    };

    /**
     * Instantiates a new emoticon entity.
     */
    public EmoticonBO() {
    }

    /**
     * Instantiates a new emoticon entity.
     *
     * @param source the source parcel
     */
    public EmoticonBO(Parcel source) {
        readFromParcel(source);
    }

    /**
     * Gets the emoticon id.
     *
     * @return the emoticon id
     */
    public String getEmoticonId() {
        return emoticonId;
    }

    /**
     * Sets the emoticon id.
     *
     * @param emoticonId the new emoticon id
     */
    public void setEmoticonId(String emoticonId) {
        this.emoticonId = emoticonId;
    }

    /**
     * Gets the emoticon name.
     *
     * @return the emoticon name
     */
    public String getEmoticonName() {
        return emoticonName;
    }

    /**
     * Sets the emoticon name.
     *
     * @param emoticonName the new emoticon name
     */
    public void setEmoticonName(String emoticonName) {
        this.emoticonName = emoticonName;
    }

    /**
     * Gets the emoticon static url.
     *
     * @return the emoticon static url
     */
    public String getEmoticonStatic() {
        return emoticonStatic;
    }

    /**
     * Sets the emoticon static url.
     *
     * @param emoticonStatic the new emoticon static url
     */
    public void setEmoticonStatic(String emoticonStatic) {
        this.emoticonStatic = emoticonStatic;
    }

    /**
     * Gets the emoticon dynamic url.
     *
     * @return the emoticon dynamic url
     */
    public String getEmoticonDynamic() {
        return emoticonDynamic;
    }

    /**
     * Sets the emoticon dynamic url.
     *
     * @param emoticonDynamic the new emoticon dynamic url
     */
    public void setEmoticonDynamic(String emoticonDynamic) {
        this.emoticonDynamic = emoticonDynamic;
    }

    /**
     * Gets the package id.
     *
     * @return the package id
     */
    public String getPackageId() {
        return packageId;
    }

    /**
     * Sets the package id.
     *
     * @param packageId the new package id
     */
    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    /**
     * Gets the static emoticon bytes.
     *
     * @return the static emoticon bytes
     */
    public byte[] getEmoticonStaticByte() {
        return emoticonStaticByte;
    }

    /**
     * Sets the static emoticon bytes.
     *
     * @param emoticonStaticByte the new static emoticon bytes
     */
    public void setEmoticonStaticByte(byte[] emoticonStaticByte) {
        this.emoticonStaticByte = emoticonStaticByte;
    }

    /**
     * Gets the dynamic emoticon bytes.
     *
     * @return the dynamic emoticon bytes
     */
    public byte[] getEmoticonDynamicByte() {
        return emoticonDynamicByte;
    }

    /**
     * Sets the dynamic emoticon bytes.
     *
     * @param emoticonDynamicByte the new dynamic emoticon bytes
     */
    public void setEmoticonDynamicByte(byte[] emoticonDynamicByte) {
        this.emoticonDynamicByte = emoticonDynamicByte;
    }

    /**
     * Gets the user phone number.
     *
     * @return the user phone number
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * Sets the user phone number.
     *
     * @param userPhone the new user phone number
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * Checks if is only browse.
     *
     * @return true, if is only browse
     */
    public boolean isOnlyBrowse() {
        return isOnlyBrowse;
    }

    /**
     * Sets the only browse.
     *
     * @param isOnlyBrowse the new only browse
     */
    public void setOnlyBrowse(boolean isOnlyBrowse) {
        this.isOnlyBrowse = isOnlyBrowse;
    }

}
