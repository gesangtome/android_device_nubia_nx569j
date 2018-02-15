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

/**
 * The Class PublicMessage.
 */
public class PublicMessage implements Parcelable {

    /** The Constant TEXT. */
    public static final String TEXT = "10";

    /** The Constant IMAGE. */
    public static final String IMAGE = "20";

    /** The Constant AUDIO. */
    public static final String AUDIO = "40";

    /** The Constant VIDEO. */
    public static final String VEDIO = "30";

    /** The Constant TOPIC. */
    public static final String TOPIC = "50";

    /** The Constant TOPIC SINGLE. */
    public static final String TOPIC_SINGLE = "51";

    /** The Constant TOPIC MORE. */
    public static final String TOPIC_MORE = "52";

    /** The Constant LOCATION. */
    public static final String LOCATION = "19";

    /** The Constant VCARD. */
    public static final String VCARD = "18";

    /** The Constant SYNC_SUBSCRIBE. */
    public static final String SYNC_SUBSCRIBE = "71";

    /** The Constant SYNC_DETAIL. */
    public static final String SYNC_DETAIL = "72";

    /** The createtime. */
    protected String createtime;

    /** The forwardable. */
    protected int forwardable;

    /** The msgtype. */
    protected String msgtype;

    /** The activeStatus. */
    protected int activeStatus;

    /** The paUuid. */
    protected String paUuid;

    /**
     * Instantiates a new public message.
     */
    public PublicMessage() {

    }

    /**
     * Instantiates a new public message.
     *
     * @param source the source
     */
    public PublicMessage(Parcel source) {
        readFromParcel(source);
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getForwardable() {
        return forwardable;
    }

    public void setForwardable(int forwardable) {
        this.forwardable = forwardable;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public int getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(int activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getPaUuid() {
        return paUuid;
    }

    public void setPaUuid(String paUuid) {
        this.paUuid = paUuid;
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

    }

    /**
     * Read from parcel.
     *
     * @param source the source
     */
    public void readFromParcel(Parcel source) {

    }

    /** The Constant CREATOR. */
    public static final Parcelable.Creator<PublicMessage> CREATOR =
            new Parcelable.Creator<PublicMessage>() {
        public PublicMessage createFromParcel(Parcel in) {
            return new PublicMessage(in);
        }

        @Override
        public PublicMessage[] newArray(int size) {
            return new PublicMessage[size];
        }

    };

}
