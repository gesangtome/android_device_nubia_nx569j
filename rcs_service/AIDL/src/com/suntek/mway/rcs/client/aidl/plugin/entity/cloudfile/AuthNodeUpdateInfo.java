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

public class AuthNodeUpdateInfo implements Parcelable {
    private String name;

    private String version;

    private String description;

    private String url;

    private String forceupdate;

    private String md5;

    private String size;

    private String updateMode;

    public AuthNodeUpdateInfo() {
    }

    public AuthNodeUpdateInfo(Parcel source) {
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
     * Write the auth node update info entity to parcel stream. Pay attention to
     * read and write variables variables sequence should be consistent or not
     * the correct results
     * @param dest the dest parcel stream
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(version);
        dest.writeString(description);
        dest.writeString(url);
        dest.writeString(forceupdate);
        dest.writeString(md5);
        dest.writeString(size);
        dest.writeString(updateMode);
    }

    /**
     * Create the auth node update info entity from parcel stream. Pay attention
     * to read and write variables variables sequence should be consistent or
     * not the correct results
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        name = source.readString();
        version = source.readString();
        description = source.readString();
        url = source.readString();
        forceupdate = source.readString();
        md5 = source.readString();
        size = source.readString();
        updateMode = source.readString();
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<AuthNodeUpdateInfo> CREATOR =
            new Parcelable.Creator<AuthNodeUpdateInfo>() {
        @Override
        public AuthNodeUpdateInfo createFromParcel(Parcel source) {
            return new AuthNodeUpdateInfo(source);
        }

        @Override
        public AuthNodeUpdateInfo[] newArray(int size) {
            return new AuthNodeUpdateInfo[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getForceupdate() {
        return forceupdate;
    }

    public void setForceupdate(String forceupdate) {
        this.forceupdate = forceupdate;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUpdateMode() {
        return updateMode;
    }

    public void setUpdateMode(String updateMode) {
        this.updateMode = updateMode;
    }
}
