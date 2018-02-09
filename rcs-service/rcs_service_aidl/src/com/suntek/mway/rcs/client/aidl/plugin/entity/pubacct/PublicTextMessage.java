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

package com.suntek.mway.rcs.client.aidl.plugin.entity.pubacct;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * The Class PublicTextMessage.
 */
public class PublicTextMessage extends PublicMessage implements Parcelable {

    /** The content. */
    private String content;

    /**
     * Instantiates a new public text message.
     */
    public PublicTextMessage() {
    }

    /**
     * Instantiates a new public text message.
     *
     * @param source the source
     */
    public PublicTextMessage(Parcel source) {
        readFromParcel(source);
    }

    /*
     * (non-Javadoc)
     * @see
     * com.suntek.mway.rcs.client.aidl.provider.model.PublicMessage#describeContents
     * ()
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.suntek.mway.rcs.client.aidl.provider.model.PublicMessage#writeToParcel
     * (android.os.Parcel, int)
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(createtime);
        dest.writeInt(forwardable);
        dest.writeString(msgtype);
        dest.writeString(content);
        dest.writeInt(activeStatus);
        dest.writeString(paUuid);
    }

    /**
     * Read from parcel.
     *
     * @param source the source
     */
    public void readFromParcel(Parcel source) {
        createtime = source.readString();
        forwardable = source.readInt();
        msgtype = source.readString();
        content = source.readString();
        activeStatus = source.readInt();
        paUuid = source.readString();
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<PublicTextMessage> CREATOR =
            new Parcelable.Creator<PublicTextMessage>() {
        @Override
        public PublicTextMessage createFromParcel(Parcel source) {
            return new PublicTextMessage(source);
        }

        @Override
        public PublicTextMessage[] newArray(int size) {
            return new PublicTextMessage[size];
        }
    };

    /**
     * Gets the content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content.
     *
     * @param content the new content
     */
    public void setContent(String content) {
        this.content = content;
    }

}
