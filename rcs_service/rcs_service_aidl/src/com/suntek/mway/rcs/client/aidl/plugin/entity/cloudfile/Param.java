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

package com.suntek.mway.rcs.client.aidl.plugin.entity.cloudfile;

import android.os.Parcel;
import android.os.Parcelable;

public class Param implements Parcelable {
    private int[] paramInt;

    private long[] paramLong;

    private String[] paramString;

    public Param() {
    }

    public Param(Parcel source) {
        readFromParcel(source);
    }

    /**
     * The parcel describe contents, defaul is 0.
     * @return the int
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Write the param entity to parcel stream. Pay attention to read and write
     * variables variables sequence should be consistent or not the correct
     * results
     * @param dest the dest parcel stream
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(paramInt);
        dest.writeLongArray(paramLong);
        dest.writeStringArray(paramString);
    }

    /**
     * Create the param entity from parcel stream. Pay attention to read and
     * write variables variables sequence should be consistent or not the
     * correct results
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        paramInt = source.createIntArray();
        paramLong = source.createLongArray();
        paramString = source.createStringArray();
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<Param> CREATOR =
            new Parcelable.Creator<Param>() {
        @Override
        public Param createFromParcel(Parcel source) {
            return new Param(source);
        }

        @Override
        public Param[] newArray(int size) {
            return new Param[size];
        }
    };

    public int[] getParamInt() {
        return paramInt;
    }

    public void setParamInt(int[] paramInt) {
        this.paramInt = paramInt;
    }

    public long[] getParamLong() {
        return paramLong;
    }

    public void setParamLong(long[] paramLong) {
        this.paramLong = paramLong;
    }

    public String[] getParamString() {
        return paramString;
    }

    public void setParamString(String[] paramString) {
        this.paramString = paramString;
    }
}
