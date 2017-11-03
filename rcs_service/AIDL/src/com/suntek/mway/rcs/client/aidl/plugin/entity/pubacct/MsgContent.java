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

import java.util.LinkedList;
import java.util.List;

public class MsgContent implements Parcelable {
    /** The media type. */
    private String mediaType;

    /** The create time. */
    private String createTime;

    /** The message uuid. */
    private String msgUuid;

    /** The sms digest. */
    private String smsDigest;

    /** The text. */
    private String text;

    /** The public account uuid. */
    private String paUuid;

    /** The basic. */
    private MediaBasic basic;

    /** The article list. */
    private List<MediaArticle> articleList;

    /**
     * Instantiates a new message content.
     */
    public MsgContent() {
    }

    /**
     * Instantiates a new message content.
     *
     * @param source the source parcel stream
     */
    public MsgContent(Parcel source) {
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
     * Write the message content entity to parcel stream. Pay attention to read
     * and write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param dest the dest parcel stream
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mediaType);
        dest.writeString(createTime);
        dest.writeString(msgUuid);
        dest.writeString(smsDigest);
        dest.writeString(text);
        dest.writeString(paUuid);
        dest.writeValue(basic);
        dest.writeList(articleList);
    }

    /**
     * Create the message content entity from parcel stream. Pay attention to
     * read and write variables variables sequence should be consistent or not
     * the correct results
     *
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        mediaType = source.readString();
        createTime = source.readString();
        msgUuid = source.readString();
        smsDigest = source.readString();
        text = source.readString();
        paUuid = source.readString();
        basic = (MediaBasic)source.readValue(this.getClass().getClassLoader());
        articleList = new LinkedList<MediaArticle>();
        source.readList(articleList, this.getClass().getClassLoader());
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<MsgContent> CREATOR =
            new Parcelable.Creator<MsgContent>() {
        @Override
        public MsgContent createFromParcel(Parcel source) {
            return new MsgContent(source);
        }

        @Override
        public MsgContent[] newArray(int size) {
            return new MsgContent[size];
        }
    };

    /**
     * Gets the media type.
     *
     * @return the media type
     */
    public String getMediaType() {
        return mediaType;
    }

    /**
     * Sets the media type.
     *
     * @param mediaType the new media type
     */
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    /**
     * Gets the creates time.
     *
     * @return the creates time
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * Sets the creates time.
     *
     * @param createTime the new creates time
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * Gets the msg_ uuid.
     *
     * @return the message uuid
     */
    public String getMsgUuid() {
        return msgUuid;
    }

    /**
     * Sets the message uuid.
     *
     * @param msg_Uuid the new message uuid
     */
    public void setMsgUuid(String msgUuid) {
        this.msgUuid = msgUuid;
    }

    /**
     * Gets the sms digest.
     *
     * @return the sms digest
     */
    public String getSmsDigest() {
        return smsDigest;
    }

    /**
     * Sets the sms digest.
     *
     * @param smsDigest the new sms digest
     */
    public void setSmsDigest(String smsDigest) {
        this.smsDigest = smsDigest;
    }

    /**
     * Gets the text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text.
     *
     * @param text the new text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets the public account uuid.
     *
     * @return the public account uuid
     */
    public String getPaUuid() {
        return paUuid;
    }

    /**
     * Sets the public account uuid.
     *
     * @param paUuid the new public account uuid
     */
    public void setPaUuid(String paUuid) {
        this.paUuid = paUuid;
    }

    /**
     * Gets the basic.
     *
     * @return the basic
     */
    public MediaBasic getBasic() {
        return basic;
    }

    /**
     * Sets the basic.
     *
     * @param basic the new basic
     */
    public void setBasic(MediaBasic basic) {
        this.basic = basic;
    }

    /**
     * Gets the article list.
     *
     * @return the article list
     */
    public List<MediaArticle> getArticleList() {
        return articleList;
    }

    /**
     * Sets the article list.
     *
     * @param articleList the new article list
     */
    public void setArticleList(List<MediaArticle> articleList) {
        this.articleList = articleList;
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        if (null != this.mediaType) {
            sbuffer.append(",mediaType=").append(this.mediaType);
        }
        if (null != this.createTime) {
            sbuffer.append(",createTime=").append(this.createTime);
        }
        if (null != this.msgUuid) {
            sbuffer.append(",msgUuid=").append(this.msgUuid);
        }
        if (null != this.smsDigest) {
            sbuffer.append(",smsDigest=").append(this.smsDigest);
        }
        if (null != this.text) {
            sbuffer.append(",text=").append(this.text);
        }
        if (null != this.paUuid) {
            sbuffer.append(",paUuid=").append(this.paUuid);
        }
        if (null != this.basic) {
            sbuffer.append(",basic=").append("{").append(this.basic.toString()).append("}");
        }

        if (null != this.articleList && this.articleList.size() > 0) {
            sbuffer.append(",articleList=").append("[");
            for (MediaArticle article : this.articleList) {
                sbuffer.append(article.toString());
            }
            sbuffer.append("]");
        }

        if (sbuffer.length() > 1) {
            return sbuffer.substring(1).toString();
        } else {
            return "";
        }
    }
}
