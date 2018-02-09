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

package com.suntek.mway.rcs.client.aidl.plugin.entity.cloudfile;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * The Class CloudFileMessage.
 */
public class CloudFileMessage implements Parcelable {

    /** The file name. */
    private String fileName;

    /** The file size. */
    private long fileSize;

    /** The share url. */
    private String shareUrl;

    /**
     * Instantiates a new cloud file message.
     */
    public CloudFileMessage() {
    }

    /**
     * Instantiates a new cloud file message.
     */
    public CloudFileMessage(String fileName, long fileSize, String shareUrl) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.shareUrl = shareUrl;
    }

    /**
     * Instantiates a new cloud file message.
     * @param source the source
     */
    public CloudFileMessage(Parcel source) {
        readFromParcel(source);
    }

    /*
     * (non-Javadoc)
     * @see android.os.Parcelable#describeContents()
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /*
     * (non-Javadoc)
     * @see android.os.Parcelable#writeToParcel(android.os.Parcel, int)
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fileName);
        dest.writeLong(fileSize);
        dest.writeString(shareUrl);
    }

    /**
     * Read from parcel.
     *
     * @param source the source
     */
    public void readFromParcel(Parcel source) {
        fileName = source.readString();
        fileSize = source.readLong();
        shareUrl = source.readString();
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<CloudFileMessage> CREATOR =
            new Parcelable.Creator<CloudFileMessage>() {
        @Override
        public CloudFileMessage createFromParcel(Parcel source) {
            return new CloudFileMessage(source);
        }

        @Override
        public CloudFileMessage[] newArray(int size) {
            return new CloudFileMessage[size];
        }
    };

    /**
     * Gets the file name.
     * @return the file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the file name.
     * @param fileName the new file name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Gets the file size.
     * @return the file size
     */
    public long getFileSize() {
        return fileSize;
    }

    /**
     * Sets the file size.
     * @param fileSize the new file size
     */
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * Gets the share url.
     * @return the share url
     */
    public String getShareUrl() {
        return shareUrl;
    }

    /**
     * Sets the share url.
     * @param shareUrl the new share url
     */
    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

}
