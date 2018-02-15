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

public class Result implements Parcelable {
    private Error mcloudError;

    private String mcloudDesc;

    private String socketCode;

    private String httpCode;

    private String serverCode;

    public Result() {
    }

    public Result(Parcel source) {
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
     * Write the mcloud result entity to parcel stream. Pay attention to read
     * and write variables variables sequence should be consistent or not the
     * correct results
     * @param dest the dest parcel stream
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mcloudError.ordinal());
        dest.writeString(mcloudDesc);
        dest.writeString(socketCode);
        dest.writeString(httpCode);
        dest.writeString(serverCode);
    }

    /**
     * Create the mcloud result entity from parcel stream. Pay attention to read
     * and write variables variables sequence should be consistent or not the
     * correct results
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        mcloudError = Error.valueOf(source.readInt());
        mcloudDesc = source.readString();
        socketCode = source.readString();
        httpCode = source.readString();
        serverCode = source.readString();
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<Result> CREATOR =
            new Parcelable.Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel source) {
            return new Result(source);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    public Error getMcloudError() {
        return mcloudError;
    }

    public void setMcloudError(Error mcloudError) {
        this.mcloudError = mcloudError;
    }

    public String getMcloudDesc() {
        return mcloudDesc;
    }

    public void setMcloudDesc(String mcloudDesc) {
        this.mcloudDesc = mcloudDesc;
    }

    public String getSocketCode() {
        return socketCode;
    }

    public void setSocketCode(String socketCode) {
        this.socketCode = socketCode;
    }

    public String getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(String httpCode) {
        this.httpCode = httpCode;
    }

    public String getServerCode() {
        return serverCode;
    }

    public void setServerCode(String serverCode) {
        this.serverCode = serverCode;
    }
}
