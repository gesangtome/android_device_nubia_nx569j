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
import java.util.HashMap;
import java.util.List;

public class OtherTels implements Parcelable {
    // private String homeTel;

    // private String mobilePhone;

    // private String fixedTel;

    private HashMap<String, String> otherTels;

    public OtherTels() {
        otherTels = new HashMap<String, String>();
    }

    public OtherTels(Parcel source) {
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
        // dest.writeString( homeTel );
        // dest.writeString( mobilePhone );
        // dest.writeString( fixedTel );
        dest.writeMap(otherTels);
    }

    /**
     * Create the avatar entity from parcel stream. Pay attention to read and
     * write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param source The parcel stream
     */
    @SuppressWarnings("unchecked")
    public void readFromParcel(Parcel source) {
        // homeTel = source.readString();
        // mobilePhone = source.readString();
        // fixedTel = source.readString();
        source.readMap(otherTels, this.getClass().getClassLoader());
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<OtherTels> CREATOR =
            new Parcelable.Creator<OtherTels>() {
        @Override
        public OtherTels createFromParcel(Parcel source) {
            return new OtherTels(source);
        }

        @Override
        public OtherTels[] newArray(int size) {
            return new OtherTels[size];
        }
    };

    /*
     * public String getHomeTel() { return homeTel; } public void setHomeTel(
     * String homeTel ) { this.homeTel = homeTel; } public String
     * getMobilePhone() { return mobilePhone; } public void setMobilePhone(
     * String mobilePhone ) { this.mobilePhone = mobilePhone; } public String
     * getFixedTel() { return fixedTel; } public void setFixedTel( String
     * fixedTel ) { this.fixedTel = fixedTel; }
     */
    public HashMap<String, String> getOtherTels() {
        return otherTels;
    }

    public void setOtherTels(HashMap<String, String> otherTels) {
        this.otherTels = otherTels;
    }

    @Override
    public String toString() {
        List<String> list = new ArrayList<String>();
        // list.add("homeTel="+ this.homeTel);
        // list.add("mobilePhone="+ this.mobilePhone);
        // list.add("fixedTel="+ this.fixedTel);
        list.add("otherTels=" + otherTels);
        return list.toString();
    }
}
