/*
 * Copyright (c) 2015, The Linux Foundation. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 *       copyright notice, this list of conditions and the following
 *       disclaimer in the documentation and/or other materials provided
 *       with the distribution.
 *     * Neither the name of The Linux Foundation nor the names of its
 *       contributors may be used to endorse or promote products derived
 *       from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR
 * BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN
 * IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.suntek.mway.rcs.client.aidl.plugin.entity.cloudfile;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Map;

public class TransNode implements Parcelable {
    private String id;

    private long completeSize;

    private String url;

    private String localPath;

    private TransType type;

    private FileNode file;

    private Status status;

    private boolean isSuccess;

    private String uploadID;

    private String batchID;

    private int speed;

    private int percent;

    private FileNode.FileType mode;

    private String param;

    private long order;

    private Result result;

    private Map<String, String> fields;

    public TransNode() {
    }

    public TransNode(Parcel source) {
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
        dest.writeString(id);
        dest.writeString(url);
        dest.writeString(localPath);
        dest.writeString(param);
        dest.writeString(uploadID);
        dest.writeString(batchID);

        dest.writeLong(completeSize);
        dest.writeLong(order);
        dest.writeInt(speed);
        dest.writeInt(percent);

        dest.writeBooleanArray(new boolean[] {
            isSuccess
        });

        dest.writeInt(type.ordinal());
        dest.writeInt(mode.ordinal());
        dest.writeInt(status.ordinal());

        dest.writeValue(file);
        dest.writeValue(result);

        dest.writeMap(fields);
    }

    /**
     * Create the mcloud result entity from parcel stream. Pay attention to read
     * and write variables variables sequence should be consistent or not the
     * correct results
     * @param source The parcel stream
     */
    @SuppressWarnings("unchecked")
    public void readFromParcel(Parcel source) {
        id = source.readString();
        url = source.readString();
        localPath = source.readString();
        param = source.readString();
        uploadID = source.readString();
        batchID = source.readString();

        completeSize = source.readLong();
        order = source.readLong();
        speed = source.readInt();
        percent = source.readInt();

        isSuccess = source.createBooleanArray()[0];

        type = TransType.valueOf(source.readInt());
        mode = FileNode.FileType.valueOf(source.readInt());
        status = Status.valueOf(source.readInt());

        file = (FileNode)source.readValue(this.getClass().getClassLoader());
        result = (Result)source.readValue(this.getClass().getClassLoader());

        fields = source.readHashMap(this.getClass().getClassLoader());
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<TransNode> CREATOR =
            new Parcelable.Creator<TransNode>() {
        @Override
        public TransNode createFromParcel(Parcel source) {
            return new TransNode(source);
        }

        @Override
        public TransNode[] newArray(int size) {
            return new TransNode[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCompleteSize() {
        return completeSize;
    }

    public void setCompleteSize(long completeSize) {
        this.completeSize = completeSize;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public TransType getType() {
        return type;
    }

    public void setType(TransType type) {
        this.type = type;
    }

    public FileNode getFile() {
        return file;
    }

    public void setFile(FileNode file) {
        this.file = file;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getUploadID() {
        return uploadID;
    }

    public void setUploadID(String uploadID) {
        this.uploadID = uploadID;
    }

    public String getBatchID() {
        return batchID;
    }

    public void setBatchID(String batchID) {
        this.batchID = batchID;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public FileNode.FileType getMode() {
        return mode;
    }

    public void setMode(FileNode.FileType mode) {
        this.mode = mode;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    public static enum TransOper {
        NEW,

        OVER_WRITE,

        RESUME,

        GET_INFO;

        public static TransOper valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }

            return values()[ordinal];
        }
    }

    public static enum TransType {
        UPLOAD,

        DOWNLOAD,

        DOWNLOADTHUMBNAIL,

        DOWNLOADURL,

        BACKUP,

        RESTORE,

        SHOOT;

        public static TransType valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }

            return values()[ordinal];
        }
    }
}
