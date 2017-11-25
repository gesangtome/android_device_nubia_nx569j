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

/**
 * The Class PublicTopicMessage.
 */
public class PublicTopicMessage extends PublicMessage implements Parcelable {

    /** The topics. */
    private List<PublicTopicContent> topics;

    /**
     * Instantiates a new public topic message.
     */
    public PublicTopicMessage() {
    }

    /**
     * Instantiates a new public topic message.
     *
     * @param source the source
     */
    public PublicTopicMessage(Parcel source) {
        readFromParcel(source);
    }

    /*
     * (non-Javadoc)
     * @see
     * com.suntek.mway.rcs.client.api.provider.model.PublicMessage#describeContents
     * ()
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.suntek.mway.rcs.client.api.provider.model.PublicMessage#writeToParcel
     * (android.os.Parcel, int)
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(createtime);
        dest.writeInt(forwardable);
        dest.writeString(msgtype);
        dest.writeInt(activeStatus);
        dest.writeString(paUuid);
        dest.writeList(topics);
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
        activeStatus = source.readInt();
        paUuid = source.readString();
        topics = new LinkedList<PublicTopicContent>();
        source.readList(topics, this.getClass().getClassLoader());
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<PublicTopicMessage> CREATOR =
            new Parcelable.Creator<PublicTopicMessage>() {
        @Override
        public PublicTopicMessage createFromParcel(Parcel source) {
            return new PublicTopicMessage(source);
        }

        @Override
        public PublicTopicMessage[] newArray(int size) {
            return new PublicTopicMessage[size];
        }
    };

    /**
     * Gets the topics.
     *
     * @return the topics
     */
    public List<PublicTopicContent> getTopics() {
        return topics;
    }

    /**
     * Sets the topics.
     *
     * @param topics the new topics
     */
    public void setTopics(List<PublicTopicContent> topics) {
        this.topics = topics;
    }

    /**
     * The Class PublicTopicContent.
     */
    public static class PublicTopicContent implements Parcelable {

        /** The title. */
        private String title;

        /** The author. */
        private String author;

        /** The thumb link. */
        private String thumbLink;

        /** The original link. */
        private String originalLink;

        /** The source link. */
        private String sourceLink;

        /** The media uuid. */
        private String mediaUuid;

        /** The main text. */
        private String mainText;

        /** The body link. */
        private String bodyLink;

        /**
         * Instantiates a new public topic content.
         */
        public PublicTopicContent() {
        }

        /**
         * Instantiates a new public topic content.
         *
         * @param source the source
         */
        public PublicTopicContent(Parcel source) {
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
            dest.writeString(title);
            dest.writeString(author);
            dest.writeString(thumbLink);
            dest.writeString(originalLink);
            dest.writeString(sourceLink);
            dest.writeString(mediaUuid);
            dest.writeString(mainText);
            dest.writeString(bodyLink);
        }

        /**
         * Read from parcel.
         *
         * @param source the source
         */
        public void readFromParcel(Parcel source) {
            title = source.readString();
            author = source.readString();
            thumbLink = source.readString();
            originalLink = source.readString();
            sourceLink = source.readString();
            mediaUuid = source.readString();
            mainText = source.readString();
            bodyLink = source.readString();
        }

        /** The parcel creator. */
        public static final Parcelable.Creator<PublicTopicContent> CREATOR =
                new Parcelable.Creator<PublicTopicContent>() {
            @Override
            public PublicTopicContent createFromParcel(Parcel source) {
                return new PublicTopicContent(source);
            }

            @Override
            public PublicTopicContent[] newArray(int size) {
                return new PublicTopicContent[size];
            }
        };

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
         * Gets the author.
         *
         * @return the author
         */
        public String getAuthor() {
            return author;
        }

        /**
         * Sets the author.
         *
         * @param author the new author
         */
        public void setAuthor(String author) {
            this.author = author;
        }

        /**
         * Gets the thumb link.
         *
         * @return the thumb link
         */
        public String getThumbLink() {
            return thumbLink;
        }

        /**
         * Sets the thumb link.
         *
         * @param thumbLink the new thumb link
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
         * Gets the source link.
         *
         * @return the source link
         */
        public String getSourceLink() {
            return sourceLink;
        }

        /**
         * Sets the source link.
         *
         * @param sourceLink the new source link
         */
        public void setSourceLink(String sourceLink) {
            this.sourceLink = sourceLink;
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
         * Gets the main text.
         *
         * @return the main text
         */
        public String getMainText() {
            return mainText;
        }

        /**
         * Sets the main text.
         *
         * @param mainText the new main text
         */
        public void setMainText(String mainText) {
            this.mainText = mainText;
        }

        /**
         * Gets the body link.
         *
         * @return the body link
         */
        public String getBodyLink() {
            return bodyLink;
        }

        /**
         * Sets the body link.
         *
         * @param bodyLink the new body link
         */
        public void setBodyLink(String bodyLink) {
            this.bodyLink = bodyLink;
        }

    }
}
