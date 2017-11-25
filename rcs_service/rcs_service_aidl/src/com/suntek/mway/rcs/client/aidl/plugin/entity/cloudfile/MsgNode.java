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

public class MsgNode implements Parcelable {
    private String content;

    private String sender;

    private String receiver;

    private String time;

    private String id;

    private MsgType msgType;

    private BoxType boxType;

    private MsgResult result;

    private boolean isSend;

    private boolean isRead;

    private int size;

    private int number;

    private int locked;

    private byte[] attachment;

    private Map<String, String> fields;

    public MsgNode() {
    }

    public MsgNode(Parcel source) {
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
     * Write the configure node entity to parcel stream. Pay attention to read
     * and write variables variables sequence should be consistent or not the
     * correct results
     * @param dest the dest parcel stream
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(content);
        dest.writeString(sender);
        dest.writeString(receiver);
        dest.writeString(time);
        dest.writeString(id);

        dest.writeInt(size);
        dest.writeInt(number);
        dest.writeInt(locked);

        dest.writeInt(msgType.ordinal());
        dest.writeInt(boxType.ordinal());
        dest.writeInt(result.ordinal());

        dest.writeBooleanArray(new boolean[] {
            isSend
        });
        dest.writeBooleanArray(new boolean[] {
            isRead
        });

        dest.writeByteArray(attachment);

        dest.writeMap(fields);
    }

    /**
     * Create the configure node entity from parcel stream. Pay attention to
     * read and write variables variables sequence should be consistent or not
     * the correct results
     * @param source The parcel stream
     */
    @SuppressWarnings("unchecked")
    public void readFromParcel(Parcel source) {
        content = source.readString();
        sender = source.readString();
        receiver = source.readString();
        time = source.readString();
        id = source.readString();

        size = source.readInt();
        number = source.readInt();
        locked = source.readInt();

        msgType = MsgType.valueOf(source.readInt());
        boxType = BoxType.valueOf(source.readInt());
        result = MsgResult.valueOf(source.readInt());

        isSend = source.createBooleanArray()[0];
        isRead = source.createBooleanArray()[0];

        attachment = source.createByteArray();

        fields = source.readHashMap(this.getClass().getClassLoader());
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<MsgNode> CREATOR =
            new Parcelable.Creator<MsgNode>() {
        @Override
        public MsgNode createFromParcel(Parcel source) {
            return new MsgNode(source);
        }

        @Override
        public MsgNode[] newArray(int size) {
            return new MsgNode[size];
        }
    };

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MsgType getMsgType() {
        return msgType;
    }

    public void setMsgType(MsgType msgType) {
        this.msgType = msgType;
    }

    public BoxType getBoxType() {
        return boxType;
    }

    public void setBoxType(BoxType boxType) {
        this.boxType = boxType;
    }

    public MsgResult getResult() {
        return result;
    }

    public void setResult(MsgResult result) {
        this.result = result;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean isSend) {
        this.isSend = isSend;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    public static enum BoxType {
        inbox,

        outbox,

        draft;

        public static BoxType valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }

            return values()[ordinal];
        }
    }

    public static enum MsgType {
        sms,

        mms;

        public static MsgType valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }

            return values()[ordinal];
        }
    }

    public static enum Order {
        date,

        date_Reverse,

        sender,

        sender_Reverse,

        receiver,

        receiver_Reverse,

        thread,

        thread_Reverse;

        public static Order valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }

            return values()[ordinal];
        }
    }

    public static enum MsgResult {
        success,

        duplication,

        fail,

        ignor;

        public static MsgResult valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }

            return values()[ordinal];
        }
    }
}
