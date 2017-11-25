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

public class EmojiPackageBO implements Parcelable {

    /** The package id. */
    private String packageId;

    /** The package name. */
    private String packageName;

    /** The package icon. */
    private String packageIcon;

    /** The package size. */
    private String packageSize;

    /** The package state. 1 had buyed, 0 havnt buyed */
    private String packageState;

    /** The package price. */
    private String packagePrice;

    /** The package use limited time. */
    private String packageUseTime;

    /** The package cp id. */
    private String packageCpId;

    /** The package cp name. */
    private String packageCpName;

    /** The package description. */
    private String packageDesc;

    /** The package zip icon. */
    private String packageZipIcon;

    /** The package zip name. */
    private String packageZipName;

    /** The package zip path. */
    private String packageZipPath;

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
     * Write the emoticon package entity to parcel stream. Pay attention to read
     * and write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param dest the dest
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(packageId);
        dest.writeString(packageName);
        dest.writeString(packageIcon);
        dest.writeString(packageSize);
        dest.writeString(packageState);
        dest.writeString(packagePrice);
        dest.writeString(packageUseTime);
        dest.writeString(packageCpId);
        dest.writeString(packageCpName);
        dest.writeString(packageDesc);
        dest.writeString(packageZipIcon);
        dest.writeString(packageZipName);
        dest.writeString(packageZipPath);
    }

    /**
     * Create the emoticon package entity from parcel stream. Pay attention to
     * read and write variables variables sequence should be consistent or not
     * the correct results
     *
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        packageId = source.readString();
        packageName = source.readString();
        packageIcon = source.readString();
        packageSize = source.readString();
        packageState = source.readString();
        packagePrice = source.readString();
        packageUseTime = source.readString();
        packageCpId = source.readString();
        packageCpName = source.readString();
        packageDesc = source.readString();
        packageZipIcon = source.readString();
        packageZipName = source.readString();
        packageZipPath = source.readString();
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<EmojiPackageBO> CREATOR =
            new Parcelable.Creator<EmojiPackageBO>() {
        @Override
        public EmojiPackageBO createFromParcel(Parcel source) {
            return new EmojiPackageBO(source);
        }

        @Override
        public EmojiPackageBO[] newArray(int size) {
            return new EmojiPackageBO[size];
        }
    };

    /**
     * Instantiates a new emoji package bo.
     */
    public EmojiPackageBO() {
    }

    /**
     * Instantiates a new emoji package bo.
     *
     * @param source the source
     */
    public EmojiPackageBO(Parcel source) {
        readFromParcel(source);
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
     * Gets the package name.
     *
     * @return the package name
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * Sets the package name.
     *
     * @param packageName the new package name
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * Gets the package icon.
     *
     * @return the package icon
     */
    public String getPackageIcon() {
        return packageIcon;
    }

    /**
     * Sets the package icon.
     *
     * @param packageIcon the new package icon
     */
    public void setPackageIcon(String packageIcon) {
        this.packageIcon = packageIcon;
    }

    /**
     * Gets the package size.
     *
     * @return the package size
     */
    public String getPackageSize() {
        return packageSize;
    }

    /**
     * Sets the package size.
     *
     * @param packageSize the new package size
     */
    public void setPackageSize(String packageSize) {
        this.packageSize = packageSize;
    }

    /**
     * Gets the package state.
     *
     * @return the package state
     */
    public String getPackageState() {
        return packageState;
    }

    /**
     * Sets the package state.
     *
     * @param packageState the new package state
     */
    public void setPackageState(String packageState) {
        this.packageState = packageState;
    }

    /**
     * Gets the package price.
     *
     * @return the package price
     */
    public String getPackagePrice() {
        return packagePrice;
    }

    /**
     * Sets the package price.
     *
     * @param packagePrice the new package price
     */
    public void setPackagePrice(String packagePrice) {
        this.packagePrice = packagePrice;
    }

    /**
     * Gets the package use limited time.
     *
     * @return the package use limited time
     */
    public String getPackageUseTime() {
        return packageUseTime;
    }

    /**
     * Sets the package use limited time.
     *
     * @param packageUseTime the new package use limited time
     */
    public void setPackageUseTime(String packageUseTime) {
        this.packageUseTime = packageUseTime;
    }

    /**
     * Gets the package cp id.
     *
     * @return the package cp id
     */
    public String getPackageCpId() {
        return packageCpId;
    }

    /**
     * Sets the package cp id.
     *
     * @param packageCpId the new package cp id
     */
    public void setPackageCpId(String packageCpId) {
        this.packageCpId = packageCpId;
    }

    /**
     * Gets the package cp name.
     *
     * @return the package cp name
     */
    public String getPackageCpName() {
        return packageCpName;
    }

    /**
     * Sets the package cp name.
     *
     * @param packageCpName the new package cp name
     */
    public void setPackageCpName(String packageCpName) {
        this.packageCpName = packageCpName;
    }

    /**
     * Gets the package description.
     *
     * @return the package description
     */
    public String getPackageDesc() {
        return packageDesc;
    }

    /**
     * Sets the package description.
     *
     * @param packageDesc the new package description
     */
    public void setPackageDesc(String packageDesc) {
        this.packageDesc = packageDesc;
    }

    /**
     * Gets the package zip icon.
     *
     * @return the package zip icon
     */
    public String getPackageZipIcon() {
        return packageZipIcon;
    }

    /**
     * Sets the package zip icon.
     *
     * @param packageZipIcon the new package zip icon
     */
    public void setPackageZipIcon(String packageZipIcon) {
        this.packageZipIcon = packageZipIcon;
    }

    /**
     * Gets the package zip name.
     *
     * @return the package zip name
     */
    public String getPackageZipName() {
        return packageZipName;
    }

    /**
     * Sets the package zip name.
     *
     * @param packageZipName the new package zip name
     */
    public void setPackageZipName(String packageZipName) {
        this.packageZipName = packageZipName;
    }

    /**
     * Gets the package zip path.
     *
     * @return the package zip path
     */
    public String getPackageZipPath() {
        return packageZipPath;
    }

    /**
     * Sets the package zip path.
     *
     * @param packageZipPath the new package zip path
     */
    public void setPackageZipPath(String packageZipPath) {
        this.packageZipPath = packageZipPath;
    }

}
