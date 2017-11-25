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

import java.util.Arrays;
import java.util.Map;

public class ShareNode implements Parcelable {
    private String url;

    private String thumbUrl;

    private String createTime;

    private String updateTime;

    private ShareType type;

    private String desc;

    private int downloads;

    private FileNode[] file;

    private ShareNode[] subShares;

    private String id;

    private boolean isSuccess;

    private Order order;

    private Map<String, String> fields;

    public ShareNode() {
    }

    public ShareNode(Parcel source) {
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
     * Write the configure node entity to parcel stream. Pay attention to read
     * and write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param dest the dest parcel stream
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(thumbUrl);
        dest.writeString(createTime);
        dest.writeString(updateTime);
        dest.writeInt(type.ordinal());
        dest.writeString(desc);
        dest.writeInt(downloads);
        dest.writeParcelableArray(file, flags);
        dest.writeParcelableArray(subShares, flags);
        dest.writeString(id);
        dest.writeInt(isSuccess ? 1 : 0);
        dest.writeInt(order.ordinal());
        dest.writeMap(fields);
    }

    /**
     * Create the share node entity from parcel stream. Pay attention to read
     * and write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param source The parcel stream
     */
    @SuppressWarnings("unchecked")
    public void readFromParcel(Parcel source) {
        url = source.readString();
        thumbUrl = source.readString();
        createTime = source.readString();
        updateTime = source.readString();
        type = ShareType.valueOf(source.readInt());
        desc = source.readString();
        downloads = source.readInt();
        // file = (FileNode[])source.readParcelableArray(
        // this.getClass().getClassLoader() );
        // subShares = (ShareNode[])source.readParcelableArray(
        // this.getClass().getClassLoader() );
        Parcelable[] fileParcelableArray = source.readParcelableArray(this.getClass()
                .getClassLoader());
        file = new FileNode[] {};
        if (fileParcelableArray != null) {
            file = Arrays.copyOf(fileParcelableArray,
                    fileParcelableArray.length, FileNode[].class);
        }

        Parcelable[] subSharesParcelableArray = source.readParcelableArray(this.getClass()
                .getClassLoader());
        subShares = new ShareNode[] {};
        if (subSharesParcelableArray != null) {
            subShares = Arrays.copyOf(subSharesParcelableArray, subSharesParcelableArray.length,
                    ShareNode[].class);
        }
        id = source.readString();
        isSuccess = source.readInt() == 1 ? true : false;
        order = Order.valueOf(source.readInt());
        fields = source.readHashMap(this.getClass().getClassLoader());
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<ShareNode> CREATOR =
            new Parcelable.Creator<ShareNode>() {
        @Override
        public ShareNode createFromParcel(Parcel source) {
            return new ShareNode(source);
        }

        @Override
        public ShareNode[] newArray(int size) {
            return new ShareNode[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public ShareType getType() {
        return type;
    }

    public void setType(ShareType type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public FileNode[] getFile() {
        return file;
    }

    public void setFile(FileNode[] file) {
        this.file = file;
    }

    public ShareNode[] getSubShares() {
        return subShares;
    }

    public void setSubShares(ShareNode[] subShares) {
        this.subShares = subShares;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    public static enum Order {
        createTime,

        createTime_Reverse,

        UpdateTime,

        UpdateTime_Reverse,

        Downloads,

        Downloads_Reverse;

        public static Order valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }

            return values()[ordinal];
        }
    }

    public static enum ShareType {
        sharedFile,

        sharedFolder,

        sharedGroup;

        public static ShareType valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }

            return values()[ordinal];
        }
    }
}
