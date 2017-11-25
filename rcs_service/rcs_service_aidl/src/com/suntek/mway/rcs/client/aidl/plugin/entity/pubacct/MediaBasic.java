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

package com.suntek.mway.rcs.client.aidl.plugin.entity.pubacct;

import android.os.Parcel;
import android.os.Parcelable;

public class MediaBasic implements Parcelable {
    /** The thumb picture link. */
    private String thumbLink;

    /** The original picture link. */
    private String originalLink;

    /** The title. */
    private String title;

    /** The file size. */
    private String fileSize;

    /** The duration. */
    private String duration;

    /** The file type. */
    private String fileType;

    /** The create time. */
    private String createTime;

    /** The media uuid. */
    private String mediaUuid;

    /** The pa uuid. */
    private String paUuid;

    /**
     * Instantiates a new media basic.
     */
    public MediaBasic() {
    }

    /**
     * Instantiates a new media basic.
     *
     * @param source the source
     */
    public MediaBasic(Parcel source) {
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
     * Write the media basic entity to parcel stream. Pay attention to read and
     * write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param dest the dest parcel stream
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(thumbLink);
        dest.writeString(originalLink);
        dest.writeString(title);
        dest.writeString(fileSize);
        dest.writeString(duration);
        dest.writeString(fileType);
        dest.writeString(createTime);
        dest.writeString(mediaUuid);
        dest.writeString(paUuid);
    }

    /**
     * Create the media basic entity from parcel stream. Pay attention to read
     * and write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        thumbLink = source.readString();
        originalLink = source.readString();
        title = source.readString();
        fileSize = source.readString();
        duration = source.readString();
        fileType = source.readString();
        createTime = source.readString();
        mediaUuid = source.readString();
        paUuid = source.readString();
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<MediaBasic> CREATOR =
            new Parcelable.Creator<MediaBasic>() {
        @Override
        public MediaBasic createFromParcel(Parcel source) {
            return new MediaBasic(source);
        }

        @Override
        public MediaBasic[] newArray(int size) {
            return new MediaBasic[size];
        }
    };

    /**
     * Gets the thumb picture link.
     *
     * @return the thumb picture link
     */
    public String getThumbLink() {
        return thumbLink;
    }

    /**
     * Sets the thumb picture link.
     *
     * @param thumbLink the new thumb picture link
     */
    public void setThumbLink(String thumbLink) {
        this.thumbLink = thumbLink;
    }

    /**
     * Gets the original link.
     *
     * @return the original link
     */
    public String getOriginalLink() {
        return originalLink;
    }

    /**
     * Sets the original link.
     *
     * @param originalLink the new original link
     */
    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the file size.
     *
     * @return the file size
     */
    public String getFileSize() {
        return fileSize;
    }

    /**
     * Sets the file size.
     *
     * @param fileSize the new file size
     */
    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * Gets the duration.
     *
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets the duration.
     *
     * @param duration the new duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Gets the file type.
     *
     * @return the file type
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * Sets the file type.
     *
     * @param fileType the new file type
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * Gets the creates the time.
     *
     * @return the creates the time
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * Sets the creates the time.
     *
     * @param createTime the new creates the time
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * Gets the media uuid.
     *
     * @return the media uuid
     */
    public String getMediaUuid() {
        return mediaUuid;
    }

    /**
     * Sets the media uuid.
     *
     * @param mediaUuid the new media uuid
     */
    public void setMediaUuid(String mediaUuid) {
        this.mediaUuid = mediaUuid;
    }

    /**
     * Gets the pa uuid.
     *
     * @return the pa uuid
     */
    public String getPaUuid() {
        return paUuid;
    }

    /**
     * Sets the pa uuid.
     *
     * @param paUuid the new pa uuid
     */
    public void setPaUuid(String paUuid) {
        this.paUuid = paUuid;
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        if (null != this.thumbLink) {
            sbuffer.append(",thumbLink=").append(this.thumbLink);
        }
        if (null != this.originalLink) {
            sbuffer.append(",originalLink=").append(this.originalLink);
        }
        if (null != this.title) {
            sbuffer.append(",title=").append(this.title);
        }
        if (null != this.fileSize) {
            sbuffer.append(",fileSize=").append(this.fileSize);
        }
        if (null != this.duration) {
            sbuffer.append(",duration=").append(this.duration);
        }
        if (null != this.fileType) {
            sbuffer.append(",fileType=").append(this.fileType);
        }
        if (null != this.createTime) {
            sbuffer.append(",createTime=").append(this.createTime);
        }
        if (null != this.mediaUuid) {
            sbuffer.append(",mediaUuid=").append(this.mediaUuid);
        }
        if (null != this.paUuid) {
            sbuffer.append(",paUuid=").append(this.paUuid);
        }

        if (sbuffer.length() > 1) {
            return sbuffer.substring(1).toString();
        } else {
            return "";
        }
    }
}
