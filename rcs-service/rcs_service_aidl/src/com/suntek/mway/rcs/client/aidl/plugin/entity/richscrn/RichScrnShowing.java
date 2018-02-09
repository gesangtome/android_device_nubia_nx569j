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

package com.suntek.mway.rcs.client.aidl.plugin.entity.richscrn;

import android.os.Parcel;
import android.os.Parcelable;

public class RichScrnShowing implements Parcelable {
    /** The missdn. */
    private String missdn;

    /** The cid. */
    private String cid;

    /** The greeting. */
    private String greeting;

    /** The source type. */
    private String sourceType;

    /** The missdn address. */
    private String missdnAddress;

    /** The local source url. */
    private String localSourceUrl;

    /**
     * Instantiates a new rich scrn showing.
     */
    public RichScrnShowing() {
    }

    /**
     * Instantiates a new rich scrn showing.
     *
     * @param source the source
     */
    public RichScrnShowing(Parcel source) {
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
     * Write the rich screen showing entity to parcel stream. Pay attention to
     * read and write variables variables sequence should be consistent or not
     * the correct results
     *
     * @param dest the dest parcel stream
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(missdn);
        dest.writeString(cid);
        dest.writeString(greeting);
        dest.writeString(sourceType);
        dest.writeString(missdnAddress);
        dest.writeString(localSourceUrl);
    }

    /**
     * Create the rich screen showing entity from parcel stream. Pay attention
     * to read and write variables variables sequence should be consistent or
     * not the correct results
     *
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        missdn = source.readString();
        cid = source.readString();
        greeting = source.readString();
        sourceType = source.readString();
        missdnAddress = source.readString();
        localSourceUrl = source.readString();
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<RichScrnShowing> CREATOR =
            new Parcelable.Creator<RichScrnShowing>() {
        @Override
        public RichScrnShowing createFromParcel(Parcel source) {
            return new RichScrnShowing(source);
        }

        @Override
        public RichScrnShowing[] newArray(int size) {
            return new RichScrnShowing[size];
        }
    };

    /**
     * Gets the missdn.
     *
     * @return the missdn
     */
    public String getMissdn() {
        return missdn;
    }

    /**
     * Sets the missdn.
     *
     * @param missdn the new missdn
     */
    public void setMissdn(String missdn) {
        this.missdn = missdn;
    }

    /**
     * Gets the cid.
     *
     * @return the cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * Sets the cid.
     *
     * @param cid the new cid
     */
    public void setCid(String cid) {
        this.cid = cid;
    }

    /**
     * Gets the greeting.
     *
     * @return the greeting
     */
    public String getGreeting() {
        return greeting;
    }

    /**
     * Sets the greeting.
     *
     * @param greeting the new greeting
     */
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    /**
     * Gets the source type.
     *
     * @return the source type
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * Sets the source type.
     *
     * @param sourceType the new source type
     */
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    /**
     * Gets the missdn address.
     *
     * @return the missdn address
     */
    public String getMissdnAddress() {
        return missdnAddress;
    }

    /**
     * Sets the missdn address.
     *
     * @param missdnAddress the new missdn address
     */
    public void setMissdnAddress(String missdnAddress) {
        this.missdnAddress = missdnAddress;
    }

    /**
     * Gets the local source url.
     *
     * @return the local source url
     */
    public String getLocalSourceUrl() {
        return localSourceUrl;
    }

    /**
     * Sets the local source url.
     *
     * @param localSourceUrl the new local source url
     */
    public void setLocalSourceUrl(String localSourceUrl) {
        this.localSourceUrl = localSourceUrl;
    }
}
