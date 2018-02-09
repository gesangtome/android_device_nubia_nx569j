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

public class BaseModel implements Parcelable, Serializable {

    private static final long serialVersionUID = -1599075631882399753L;

    /** The account. */
    private String account;

    /** The etag. */
    private String etag;

    public BaseModel() {

    }

    /**
     * Instantiates a new BaseModel.
     *
     * @param source the source
     */
    public BaseModel(Parcel source) {
        readFromParcel(source);
    }

    @Override
    public void writeToParcel(Parcel dest, int arg1) {
        dest.writeString(account);
        dest.writeString(etag);
    }

    /**
     * Read from parcel.
     *
     * @param source the source parcel
     */
    public void readFromParcel(Parcel source) {
        account = source.readString();
        etag = source.readString();
    }

    /**
     * Gets the account.
     *
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets the account.
     *
     * @param account the new account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * Gets the etag.
     *
     * @return the etag
     */
    public String getEtag() {
        return etag;
    }

    /**
     * Sets the etag.
     *
     * @param etag the new etag
     */
    public void setEtag(String etag) {
        this.etag = etag;
    }

    @Override
    public String toString() {
        List<String> list = new ArrayList<String>();
        list.add("account=" + this.account);
        list.add("etag=" + this.etag);
        return list.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<BaseModel> CREATOR =
            new Parcelable.Creator<BaseModel>() {
        @Override
        public BaseModel createFromParcel(Parcel source) {
            return new BaseModel(source);
        }

        @Override
        public BaseModel[] newArray(int size) {
            return new BaseModel[size];
        }
    };

}
