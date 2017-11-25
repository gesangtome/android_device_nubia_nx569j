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

public class MediaArticle implements Parcelable {

    /** The title. */
    private String title;

    /** The author. */
    private String author;

    /** The thumb picture link. */
    private String thumbLink;

    /** The original picture link. */
    private String originalLink;

    /** The source link. */
    private String sourceLink;

    /** The main text. */
    private String mainText;

    /** The media uuid. */
    private String mediaUuid;

    /** The middle link. */
    // private String middleLink;

    /** The media type. */
    // private String mediaType;

    /** The digest. */
    private String digest;

    /** The view type. */
    // private String viewType;

    /** The major article. */
    // private int majorArticle;

    /** The child articles. */
    // private List<MediaArticle> childArticles;

    private String bodyLink;

    /**
     * Instantiates a new media article.
     */
    public MediaArticle() {
    }

    /**
     * Instantiates a new media article.
     *
     * @param source the source
     */
    public MediaArticle(Parcel source) {
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
     * Write the media article entity to parcel stream. Pay attention to read
     * and write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param dest the dest parcel stream
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(author);
        dest.writeString(thumbLink);
        dest.writeString(originalLink);
        dest.writeString(sourceLink);
        dest.writeString(mainText);
        dest.writeString(mediaUuid);
        // dest.writeString( middleLink );
        // dest.writeString( mediaType );
        dest.writeString(digest);
        // dest.writeString( viewType );
        // dest.writeInt(majorArticle);
        // dest.writeList( childArticles );
        dest.writeString(bodyLink);
    }

    /**
     * Create the media article entity from parcel stream. Pay attention to read
     * and write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        title = source.readString();
        author = source.readString();
        thumbLink = source.readString();
        originalLink = source.readString();
        sourceLink = source.readString();
        mainText = source.readString();
        mediaUuid = source.readString();
        // middleLink = source.readString();
        // mediaType = source.readString();
        digest = source.readString();
        // viewType = source.readString();
        // majorArticle = source.readInt();
        // childArticles = new LinkedList<MediaArticle>();
        // source.readList( childArticles, this.getClass().getClassLoader() );
        bodyLink = source.readString();
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<MediaArticle> CREATOR =
            new Parcelable.Creator<MediaArticle>() {
        @Override
        public MediaArticle createFromParcel(Parcel source) {
            return new MediaArticle(source);
        }

        @Override
        public MediaArticle[] newArray(int size) {
            return new MediaArticle[size];
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
     * Gets the thumb picture link.
     *
     * @return the thumb picture link
     */
    public String getThumbLink() {
        return thumbLink;
    }

    /**
     * Sets the thumb picture link.
     *
     * @param thumbLink the new thumb picture link
     */
    public void setThumbLink(String thumbLink) {
        this.thumbLink = thumbLink;
    }

    /**
     * Gets the original picture link.
     *
     * @return the original picture link
     */
    public String getOriginalLink() {
        return originalLink;
    }

    /**
     * Sets the original picture link.
     *
     * @param originalLink the new original picture link
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
     * Gets the middle link.
     *
     * @return the middle link
     */
    // public String getMiddleLink()
    // {
    // return middleLink;
    // }

    /**
     * Sets the middle link.
     *
     * @param middleLink the new middle link
     */
    // public void setMiddleLink( String middleLink )
    // {
    // this.middleLink = middleLink;
    // }

    /**
     * Gets the media type.
     *
     * @return the media type
     */
    // public String getMediaType()
    // {
    // return mediaType;
    // }

    /**
     * Sets the media type.
     *
     * @param mediaType the new media type
     */
    // public void setMediaType( String mediaType )
    // {
    // this.mediaType = mediaType;
    // }

    /**
     * Gets the digest.
     *
     * @return the digest
     */
    public String getDigest() {
        return digest;
    }

    /**
     * Sets the digest.
     *
     * @param digest the new digest
     */
    public void setDigest(String digest) {
        this.digest = digest;
    }

    /**
     * Gets the view type.
     *
     * @return the view type
     */
    // public String getViewType()
    // {
    // return viewType;
    // }

    /**
     * Sets the view type.
     *
     * @param viewType the new view type
     */
    // public void setViewType( String viewType )
    // {
    // this.viewType = viewType;
    // }

    /**
     * Gets the major article.
     *
     * @return the major article
     */
    // public int getMajorArticle() {
    // return majorArticle;
    // }

    /**
     * Sets the major article.
     *
     * @param majorArticle the new major article
     */
    // public void setMajorArticle(int majorArticle) {
    // this.majorArticle = majorArticle;
    // }

    /**
     * Gets the child articles.
     *
     * @return the child articles
     */
    // public List<MediaArticle> getChildArticles()
    // {
    // return childArticles;
    // }

    public String getBodyLink() {
        return bodyLink;
    }

    public void setBodyLink(String bodyLink) {
        this.bodyLink = bodyLink;
    }

    /**
     * Sets the child articles.
     *
     * @return the string
     */
    // public void setChildArticles( List<MediaArticle> childArticles )
    // {
    // this.childArticles = childArticles;
    // }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        if (null != this.title) {
            sbuffer.append(",title=").append(this.title);
        }
        if (null != this.thumbLink) {
            sbuffer.append(",thumbLink=").append(this.thumbLink);
        }
        if (null != this.originalLink) {
            sbuffer.append(",originalLink=").append(this.originalLink);
        }
        if (null != this.sourceLink) {
            sbuffer.append(",sourceLink=").append(this.sourceLink);
        }
        if (null != this.mainText) {
            sbuffer.append(",mainText=").append(this.mainText);
        }
        if (null != this.mediaUuid) {
            sbuffer.append(",mediaUuid=").append(this.mediaUuid);
        }
        if (null != this.digest) {
            sbuffer.append(",digest=").append(this.digest);
        }
        if (null != this.bodyLink) {
            sbuffer.append(",bodyLink=").append(this.bodyLink);
        }
        // sbuffer.append(",majorArticle=").append(this.majorArticle);

        if (sbuffer.length() > 1) {
            return sbuffer.substring(1).toString();
        } else {
            return "";
        }

    }
}
