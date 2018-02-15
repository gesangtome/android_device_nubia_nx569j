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

package com.suntek.mway.rcs.client.aidl.plugin.entity.richscrn;

import android.os.Parcel;
import android.os.Parcelable;

public class ResultInfo implements Parcelable {

    /** The is success flag. */
    private boolean isSuccess;

    /** The result message. */
    private String resultMsg;

    /**
     * Instantiates a new result info.
     */
    public ResultInfo() {
    }

    /**
     * Instantiates a new result info.
     *
     * @param source the source
     */
    public ResultInfo(Parcel source) {
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
     * Write the result entity to parcel stream. Pay attention to read and write
     * variables variables sequence should be consistent or not the correct
     * results
     *
     * @param dest the dest parcel stream
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeBooleanArray(new boolean[] {
            isSuccess
        });
        dest.writeString(resultMsg);
    }

    /**
     * Create the result entity from parcel stream. Pay attention to read and
     * write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        boolean[] value = new boolean[1];

        source.readBooleanArray(value);
        isSuccess = value[0];
        resultMsg = source.readString();
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<ResultInfo> CREATOR =
            new Parcelable.Creator<ResultInfo>() {
        @Override
        public ResultInfo createFromParcel(Parcel source) {
            return new ResultInfo(source);
        }

        @Override
        public ResultInfo[] newArray(int size) {
            return new ResultInfo[size];
        }
    };

    /**
     * Checks if is success flag.
     *
     * @return true, if is success flag
     */
    public boolean isSuccess() {
        return isSuccess;
    }

    /**
     * Sets the success flag.
     *
     * @param isSuccess the new success flag
     */
    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    /**
     * Gets the result message.
     *
     * @return the result message
     */
    public String getResultMsg() {
        return resultMsg;
    }

    /**
     * Sets the result message.
     *
     * @param resultMsg the new result message
     */
    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
