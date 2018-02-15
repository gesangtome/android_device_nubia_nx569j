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

public class QRCardBusinessFlag extends BaseModel implements Parcelable {
    private boolean businessFlag;

    public QRCardBusinessFlag() {
    }

    public QRCardBusinessFlag(Parcel source) {
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
     * Write the qr card business flag entity to parcel stream. Pay attention to
     * read and write variables variables sequence should be consistent or not
     * the correct results
     *
     * @param dest the dest
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeBooleanArray(new boolean[] {
            businessFlag
        });
    }

    /**
     * Create the qr card business flag entity from parcel stream. Pay attention
     * to read and write variables variables sequence should be consistent or
     * not the correct results
     *
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        super.readFromParcel(source);
        boolean[] val = new boolean[1];
        source.readBooleanArray(val);
        businessFlag = val[0];
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<QRCardBusinessFlag> CREATOR =
            new Parcelable.Creator<QRCardBusinessFlag>() {
        @Override
        public QRCardBusinessFlag createFromParcel(Parcel source) {
            return new QRCardBusinessFlag(source);
        }

        @Override
        public QRCardBusinessFlag[] newArray(int size) {
            return new QRCardBusinessFlag[size];
        }
    };

    public boolean isBusinessFlag() {
        return businessFlag;
    }

    public void setBusinessFlag(boolean businessFlag) {
        this.businessFlag = businessFlag;
    }

    @Override
    public String toString() {
        List<String> list = new ArrayList<String>();
        list.add("businessFlag=" + this.businessFlag);
        list.add("account=" + getAccount());
        list.add("etag=" + getEtag());
        return list.toString();
    }
}
