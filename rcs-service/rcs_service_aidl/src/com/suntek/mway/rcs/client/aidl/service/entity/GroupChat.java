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

package com.suntek.mway.rcs.client.aidl.service.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class GroupChat implements Parcelable {

    public static final int STATUS_INITIATED = 1;

    public static final int STATUS_INVITED = 2;

    public static final int STATUS_STARTED = 3;

    public static final int STATUS_QUITED = 10;

    public static final int STATUS_BOOTED = 11;

    public static final int STATUS_TERMINATED = 12;

    public static final int STATUS_FAILED = 13;

    public static final int STATUS_REJECT = 14;

    public static final int STATUS_PAUSE = 15;

    public static final int STATUS_GROUP_FULL = 16;

    public static final int INCOMING = 1;

    public static final int OUTGOING = 2;

    public static final int MESSAGE_RECEIVE_AND_REMIND = 0;

    public static final int MESSAGE_NOT_REMIND = 1;

    public static final int MESSAGE_NOT_RECEIVE = 2;

    private long id;

    private long threadId;

    private String subject;

    private String chatUri;

    private int status;

    private String chairman;

    private int direction;

    private int maxCount;

    private String remark;

    private int policy;

    private long date;

    private String conversationId;

    private String contributionId;

    private String owner;

    public GroupChat() {
    }

    public GroupChat(Parcel in) {
        readFromParcel(in);
    }

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // TODO Auto-generated method stub
        dest.writeLong(id);
        dest.writeLong(threadId);
        dest.writeString(subject);
        dest.writeString(chatUri);
        dest.writeInt(status);
        dest.writeString(chairman);
        dest.writeInt(direction);
        dest.writeInt(maxCount);
        dest.writeString(remark);
        dest.writeInt(policy);
        dest.writeLong(date);
        dest.writeString(conversationId);
        dest.writeString(contributionId);
        dest.writeString(owner);
    }

    public void readFromParcel(Parcel source) {
        id = source.readLong();
        threadId = source.readLong();
        subject = source.readString();
        chatUri = source.readString();
        status = source.readInt();
        chairman = source.readString();
        direction = source.readInt();
        maxCount = source.readInt();
        remark = source.readString();
        policy = source.readInt();
        date = source.readLong();
        conversationId = source.readString();
        contributionId = source.readString();
        owner = source.readString();
    }

    public static final Parcelable.Creator<GroupChat> CREATOR =
            new Parcelable.Creator<GroupChat>() {
        public GroupChat createFromParcel(Parcel in) {
            return new GroupChat(in);
        }

        @Override
        public GroupChat[] newArray(int size) {
            return new GroupChat[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getThreadId() {
        return threadId;
    }

    public void setThreadId(long threadId) {
        this.threadId = threadId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getChatUri() {
        return chatUri;
    }

    public void setChatUri(String chatUri) {
        this.chatUri = chatUri;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getChairman() {
        return chairman;
    }

    public void setChairman(String chairman) {
        this.chairman = chairman;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPolicy() {
        return policy;
    }

    public void setPolicy(int policy) {
        this.policy = policy;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getContributionId() {
        return contributionId;
    }

    public void setContributionId(String contributionId) {
        this.contributionId = contributionId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isGroupChatValid() {
        if (status == GroupChat.STATUS_INITIATED ||
                status == GroupChat.STATUS_INVITED ||
                status == GroupChat.STATUS_STARTED) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("GroupChat{").append("id=").append(id).append(",threadId=").append(threadId)
                .append(",subject=").append(subject).append(",chatUri=").append(chatUri)
                .append(",status=").append(status).append(",chairman=").append(chairman)
                .append(",direction=").append(direction).append(",maxCount=").append(maxCount)
                .append(",remark=").append(remark).append(",policy=").append(policy)
                .append(",date=").append(date).append(",conversationId=").append(conversationId)
                .append(",contributionId=").append(contributionId)
                .append(",owner=").append(owner).append("}");
        return buf.toString();
    }

}
