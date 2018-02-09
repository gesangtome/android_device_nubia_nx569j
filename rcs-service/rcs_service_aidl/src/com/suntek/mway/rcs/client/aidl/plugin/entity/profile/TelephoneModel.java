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

public class TelephoneModel implements Parcelable, Serializable {

    private static final long serialVersionUID = 2509804884372655920L;

    public static int TYPE_HOME = 1;

    public static int TYPE_MOBILE = 2;

    public static int TYPE_FIXED = 3;

    public static int TYPE_WORK = 4;

    public static int TYPE_OTHER = 5;

    private int type;

    private String telephone;

    public TelephoneModel() {
    }

    public TelephoneModel(Parcel source) {
        this.type = source.readInt();
        this.telephone = source.readString();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int arg1) {
        dest.writeInt(this.type);
        dest.writeString(this.telephone);
    }

    public static final Parcelable.Creator<TelephoneModel> CREATOR =
            new Parcelable.Creator<TelephoneModel>() {
        @Override
        public TelephoneModel createFromParcel(Parcel source) {
            return new TelephoneModel(source);
        }

        @Override
        public TelephoneModel[] newArray(int size) {
            return new TelephoneModel[size];
        }
    };

    @Override
    public String toString() {
        List<String> list = new ArrayList<String>();
        list.add("type=" + type);
        list.add("telephone=" + telephone);
        return list.toString();
    }

}
