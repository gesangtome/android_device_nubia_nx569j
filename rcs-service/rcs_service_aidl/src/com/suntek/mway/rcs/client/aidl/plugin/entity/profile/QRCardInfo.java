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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QRCardInfo extends BaseModel implements Parcelable, Serializable {
    private static final long serialVersionUID = 5140344570754052168L;

    private String name;

    private String tel;

    // private String imgUrl;
    private String companyTel;

    private String companyFax;

    private String companyName;

    private String companyDuty;

    private String companyEmail;

    public QRCardInfo() {
    }

    public QRCardInfo(Parcel source) {
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
     * Write the qr card entity to parcel stream. Pay attention to read and
     * write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param dest the dest
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(name);
        dest.writeString(tel);
        // dest.writeString( imgUrl );
        dest.writeString(companyTel);
        dest.writeString(companyFax);
        dest.writeString(companyName);
        dest.writeString(companyDuty);
        dest.writeString(companyEmail);
    }

    /**
     * Create the qr card entity from parcel stream. Pay attention to read and
     * write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        super.readFromParcel(source);
        name = source.readString();
        tel = source.readString();
        // imgUrl = source.readString();
        companyTel = source.readString();
        companyFax = source.readString();
        companyName = source.readString();
        companyDuty = source.readString();
        companyEmail = source.readString();
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<QRCardInfo> CREATOR =
            new Parcelable.Creator<QRCardInfo>() {
        @Override
        public QRCardInfo createFromParcel(Parcel source) {
            return new QRCardInfo(source);
        }

        @Override
        public QRCardInfo[] newArray(int size) {
            return new QRCardInfo[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    /*
     * public String getImgUrl() { return imgUrl; } public void setImgUrl(
     * String imgUrl ) { this.imgUrl = imgUrl; }
     */
    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    public String getCompanyFax() {
        return companyFax;
    }

    public void setCompanyFax(String companyFax) {
        this.companyFax = companyFax;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDuty() {
        return companyDuty;
    }

    public void setCompanyDuty(String companyDuty) {
        this.companyDuty = companyDuty;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    @Override
    public String toString() {
        List<String> list = new ArrayList<String>();
        list.add("name=" + this.name);
        list.add("tel=" + this.tel);
        // list.add("imgUrl="+ this.imgUrl);
        list.add("companyTel=" + this.companyTel);
        list.add("companyFax=" + this.companyFax);
        list.add("companyName=" + this.companyName);
        list.add("companyDuty=" + this.companyDuty);
        list.add("companyEmail=" + this.companyEmail);
        list.add("account=" + getAccount());
        list.add("etag=" + getEtag());
        return list.toString();
    }
}
