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

public class ResultBO implements Parcelable {
    /** The result succ flag, true is succ, otherwise it is fail. */
    private boolean resultFlag;

    /** The result info. */
    private String resultMsg;

    /**
     * The result additional object, different conditions have different result
     * object.
     */
    private Object resultObj;

    /**
     * The parcel creator
     */
    public static final Parcelable.Creator<ResultBO> CREATOR =
            new Parcelable.Creator<ResultBO>() {
        @Override
        public ResultBO createFromParcel(Parcel source) {
            return new ResultBO(source);
        }

        @Override
        public ResultBO[] newArray(int size) {
            return new ResultBO[size];
        }
    };

    /**
     * Instantiates a new result entity.
     */
    public ResultBO() {
    }

    /**
     * Instantiates a new result entity from parcel.
     *
     * @param source the parcel source.
     */
    public ResultBO(Parcel source) {
        readFromParcel(source);
    }

    /**
     * The result entity write to parcel stream. Pay attention to write
     * variables and read the ordering of the variables should be consistent or
     * not the correct results.
     *
     * @param dest The parcel stream
     * @param flags The write to parcel flag
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeBooleanArray(new boolean[] {
            resultFlag
        });
        dest.writeString(resultMsg);
        dest.writeValue(resultObj);
    }

    /**
     * Create the result entity from parcel stream. Pay attention to read and
     * write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        boolean[] val = new boolean[1];
        source.readBooleanArray(val);
        resultFlag = val[0];
        resultMsg = source.readString();
        resultObj = source.readValue(this.getClass().getClassLoader());
    }

    /**
     * The parcel describe contents, defaul is 0.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Checks if is result succ
     *
     * @return true, if is result succ
     */
    public boolean isResultFlag() {
        return resultFlag;
    }

    /**
     * Sets the result flag.
     *
     * @param resultFlag the new result flag
     */
    public void setResultFlag(boolean resultFlag) {
        this.resultFlag = resultFlag;
    }

    /**
     * Gets the result info.
     *
     * @return the result info
     */
    public String getResultMsg() {
        return resultMsg;
    }

    /**
     * Sets the result info.
     *
     * @param resultMsg the new result info.
     */
    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    /**
     * Gets the result object.
     *
     * @return the result object
     */
    public Object getResultObj() {
        return resultObj;
    }

    /**
     * Sets the result object.
     *
     * @param resultObj the new result object
     */
    public void setResultObj(Object resultObj) {
        this.resultObj = resultObj;
    }

}
