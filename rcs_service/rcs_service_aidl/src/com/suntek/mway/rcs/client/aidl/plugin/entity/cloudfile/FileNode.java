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

import java.util.Map;

public class FileNode implements Parcelable {
    private boolean isFile;

    private boolean isShared;

    private boolean isFixed;

    private boolean isNeedUpdate;

    private boolean isNeedUpload;

    private boolean isSuccess;

    private long uploadSize;

    private FileType type;

    private int dirLevel;

    private long eTag;

    private String name;

    private String suffix;

    private ShareType shareType;

    private String createTime;

    private String updateTime;

    private long size;

    private String digest;

    private String remotePath;

    private String oldName;

    private String oldRemotePath;

    private String localPath;

    private String parentPath;

    private String thumbnailURL;

    private String localThumbPath;

    private String bigThumbURL;

    private String localBigThumbPath;

    private long version;

    private String id;

    private String parentID;

    private String fullPathInID;

    private String shareParentID;

    private Map<String, String> fields;

    public FileNode() {
    }

    public FileNode(Parcel source) {
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
     * Write the mcloud result entity to parcel stream. Pay attention to read
     * and write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param dest the dest parcel stream
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(suffix);
        dest.writeString(createTime);
        dest.writeString(updateTime);
        dest.writeString(digest);
        dest.writeString(remotePath);
        dest.writeString(oldName);
        dest.writeString(oldRemotePath);
        dest.writeString(localPath);
        dest.writeString(parentPath);
        dest.writeString(thumbnailURL);
        dest.writeString(localThumbPath);
        dest.writeString(bigThumbURL);
        dest.writeString(localBigThumbPath);
        dest.writeString(id);
        dest.writeString(parentID);
        dest.writeString(fullPathInID);
        dest.writeString(shareParentID);

        dest.writeBooleanArray(new boolean[] {
            isFile
        });
        dest.writeBooleanArray(new boolean[] {
            isShared
        });
        dest.writeBooleanArray(new boolean[] {
            isFixed
        });
        dest.writeBooleanArray(new boolean[] {
            isNeedUpdate
        });
        dest.writeBooleanArray(new boolean[] {
            isNeedUpload
        });
        dest.writeBooleanArray(new boolean[] {
            isSuccess
        });

        dest.writeLong(uploadSize);
        dest.writeInt(dirLevel);
        dest.writeLong(eTag);
        dest.writeLong(size);
        dest.writeLong(version);

        dest.writeInt(shareType.ordinal());
        dest.writeInt(type.ordinal());

        dest.writeMap(fields);
    }

    /**
     * Create the mcloud result entity from parcel stream. Pay attention to read
     * and write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param source The parcel stream
     */
    @SuppressWarnings("unchecked")
    public void readFromParcel(Parcel source) {
        name = source.readString();
        suffix = source.readString();
        createTime = source.readString();
        updateTime = source.readString();
        digest = source.readString();
        remotePath = source.readString();
        oldName = source.readString();
        oldRemotePath = source.readString();
        localPath = source.readString();
        parentPath = source.readString();
        thumbnailURL = source.readString();
        localThumbPath = source.readString();
        bigThumbURL = source.readString();
        localBigThumbPath = source.readString();
        id = source.readString();
        parentID = source.readString();
        fullPathInID = source.readString();
        shareParentID = source.readString();

        isFile = source.createBooleanArray()[0];
        isShared = source.createBooleanArray()[0];
        isFixed = source.createBooleanArray()[0];
        isNeedUpdate = source.createBooleanArray()[0];
        isNeedUpload = source.createBooleanArray()[0];
        isSuccess = source.createBooleanArray()[0];

        uploadSize = source.readLong();
        dirLevel = source.readInt();
        eTag = source.readLong();
        size = source.readLong();
        version = source.readLong();

        shareType = ShareType.valueOf(source.readInt());
        type = FileType.valueOf(source.readInt());

        fields = source.readHashMap(this.getClass().getClassLoader());
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<FileNode> CREATOR =
            new Parcelable.Creator<FileNode>() {
        @Override
        public FileNode createFromParcel(Parcel source) {
            return new FileNode(source);
        }

        @Override
        public FileNode[] newArray(int size) {
            return new FileNode[size];
        }
    };

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean isFile) {
        this.isFile = isFile;
    }

    public boolean isShared() {
        return isShared;
    }

    public void setShared(boolean isShared) {
        this.isShared = isShared;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public void setFixed(boolean isFixed) {
        this.isFixed = isFixed;
    }

    public boolean isNeedUpdate() {
        return isNeedUpdate;
    }

    public void setNeedUpdate(boolean isNeedUpdate) {
        this.isNeedUpdate = isNeedUpdate;
    }

    public boolean isNeedUpload() {
        return isNeedUpload;
    }

    public void setNeedUpload(boolean isNeedUpload) {
        this.isNeedUpload = isNeedUpload;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public long getUploadSize() {
        return uploadSize;
    }

    public void setUploadSize(long uploadSize) {
        this.uploadSize = uploadSize;
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    public int getDirLevel() {
        return dirLevel;
    }

    public void setDirLevel(int dirLevel) {
        this.dirLevel = dirLevel;
    }

    public long geteTag() {
        return eTag;
    }

    public void seteTag(long eTag) {
        this.eTag = eTag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public ShareType getShareType() {
        return shareType;
    }

    public void setShareType(ShareType shareType) {
        this.shareType = shareType;
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

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getRemotePath() {
        return remotePath;
    }

    public void setRemotePath(String remotePath) {
        this.remotePath = remotePath;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getOldRemotePath() {
        return oldRemotePath;
    }

    public void setOldRemotePath(String oldRemotePath) {
        this.oldRemotePath = oldRemotePath;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getLocalThumbPath() {
        return localThumbPath;
    }

    public void setLocalThumbPath(String localThumbPath) {
        this.localThumbPath = localThumbPath;
    }

    public String getBigThumbURL() {
        return bigThumbURL;
    }

    public void setBigThumbURL(String bigThumbURL) {
        this.bigThumbURL = bigThumbURL;
    }

    public String getLocalBigThumbPath() {
        return localBigThumbPath;
    }

    public void setLocalBigThumbPath(String localBigThumbPath) {
        this.localBigThumbPath = localBigThumbPath;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public String getFullPathInID() {
        return fullPathInID;
    }

    public void setFullPathInID(String fullPathInID) {
        this.fullPathInID = fullPathInID;
    }

    public String getShareParentID() {
        return shareParentID;
    }

    public void setShareParentID(String shareParentID) {
        this.shareParentID = shareParentID;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    public static enum FileType {
        photo,

        audio,

        video,

        document,

        application,

        all,

        searchByName,

        searchByExt;

        public static FileType valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }

            return values()[ordinal];
        }
    }

    public static enum ShareType {
        outlink,

        p2pshare,

        both;

        public static ShareType valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }

            return values()[ordinal];
        }
    }

    public static enum Order {
        name,

        name_revers,

        createdate,

        createdate_revers,

        updatedate,

        updatedate_revers;

        public static Order valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }

            return values()[ordinal];
        }
    }

    public static enum SyncType {
        noSync,

        autoSync,

        forceSync;

        public static SyncType valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }

            return values()[ordinal];
        }
    }

    /**
     * The Enum ThumbType.
     */
    public static enum ThumbType {

        /** The big thumb. */
        bigThumb,

        /** The middle thumb. */
        middleThumb,

        /** The small thumb. */
        smallThumb;

        /**
         * Value of.
         *
         * @param ordinal the ordinal
         * @return the thumb type
         */
        public static ThumbType valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }

            return values()[ordinal];
        }
    }
}
