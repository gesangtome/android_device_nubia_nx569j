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
 * The Class PublicMediaMessage.
 */
public class PublicMediaMessage extends PublicMessage implements Parcelable {

    /** The media. */
    private PublicMediaContent media;

    /**
     * Instantiates a new public media message.
     */
    public PublicMediaMessage() {
    }

    /**
     * Instantiates a new public media message.
     *
     * @param source the source
     */
    public PublicMediaMessage(Parcel source) {
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
        dest.writeValue(media);
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
        media = (PublicMediaContent)source.readValue(this.getClass().getClassLoader());
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<PublicMediaMessage> CREATOR =
            new Parcelable.Creator<PublicMediaMessage>() {
        @Override
        public PublicMediaMessage createFromParcel(Parcel source) {
            return new PublicMediaMessage(source);
        }

        @Override
        public PublicMediaMessage[] newArray(int size) {
            return new PublicMediaMessage[size];
        }
    };

    /**
     * Gets the media.
     *
     * @return the media
     */
    public PublicMediaContent getMedia() {
        return media;
    }

    /**
     * Sets the media.
     *
     * @param media the new media
     */
    public void setMedia(PublicMediaContent media) {
        this.media = media;
    }

    /**
     * The Class PublicMediaContent.
     */
    public static class PublicMediaContent implements Parcelable {

        /** The thumb link. */
        private String thumbLink;

        /** The original link. */
        private String originalLink;

        /** The title. */
        private String title;

        /** The file size. */
        private String fileSize;

        /** The duration. */
        private String duration;

        /** The file type. */
        private String fileType;

        /** The createtime. */
        // private String createtime;

        /** The media uuid. */
        private String mediaUuid;

        /**
         * Instantiates a new public media content.
         */
        public PublicMediaContent() {
        }

        /**
         * Instantiates a new public media content.
         *
         * @param source the source
         */
        public PublicMediaContent(Parcel source) {
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
            dest.writeString(thumbLink);
            dest.writeString(originalLink);
            dest.writeString(title);
            dest.writeString(fileSize);
            dest.writeString(duration);
            dest.writeString(fileType);
            // dest.writeString( createtime );
            dest.writeString(mediaUuid);
        }

        /**
         * Read from parcel.
         *
         * @param source the source
         */
        public void readFromParcel(Parcel source) {
            thumbLink = source.readString();
            originalLink = source.readString();
            title = source.readString();
            fileSize = source.readString();
            duration = source.readString();
            fileType = source.readString();
            // createtime = source.readString();
            mediaUuid = source.readString();
        }

        /** The parcel creator. */
        public static final Parcelable.Creator<PublicMediaContent> CREATOR =
                new Parcelable.Creator<PublicMediaContent>() {
            @Override
            public PublicMediaContent createFromParcel(Parcel source) {
                return new PublicMediaContent(source);
            }

            @Override
            public PublicMediaContent[] newArray(int size) {
                return new PublicMediaContent[size];
            }
        };

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
         * Gets the createtime.
         *
         * @return the createtime public String getCreatetime() { return
         *         createtime; }
         */

        /**
         * Sets the createtime.
         *
         * @param createtime the new createtime public void setCreatetime(String
         *            createtime) { this.createtime = createtime; }
         */

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

    }
}
