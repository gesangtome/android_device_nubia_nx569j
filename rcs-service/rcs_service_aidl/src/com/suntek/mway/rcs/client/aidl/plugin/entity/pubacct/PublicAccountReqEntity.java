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

public class PublicAccountReqEntity implements Parcelable {
    /** the public account uuid. */
    private String paUuid;

    /** the public account name. */
    private String name;

    /**
     * the public account recommend level. the value range is 1-5, default value
     * is 1.
     */
    private int recommendLevel;

    /** the public account logo url. */
    private String logo;

    /**
     * Instantiates a new public account request entity.
     */
    public PublicAccountReqEntity() {
    }

    /**
     * Instantiates a new public account request entity.
     *
     * @param source the parcel source
     */
    public PublicAccountReqEntity(Parcel source) {
        readFromParcel(source);
    }

    /**
     * The parcel describe contents, defaul is 0.
     *
     * @return the int
     */
    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * write the public account request entity to parcel stream. Pay attention
     * to read and write variables variables sequence should be consistent or
     * not the correct results
     *
     * @param dest the dest
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(paUuid);
        dest.writeString(name);
        dest.writeInt(recommendLevel);
        dest.writeString(logo);
    }

    /**
     * Create the public account request entity from parcel stream. Pay
     * attention to read and write variables variables sequence should be
     * consistent or not the correct results
     *
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        paUuid = source.readString();
        name = source.readString();
        recommendLevel = source.readInt();
        logo = source.readString();
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<PublicAccountReqEntity> CREATOR =
            new Parcelable.Creator<PublicAccountReqEntity>() {
        @Override
        public PublicAccountReqEntity createFromParcel(Parcel source) {
            return new PublicAccountReqEntity(source);
        }

        @Override
        public PublicAccountReqEntity[] newArray(int size) {
            return new PublicAccountReqEntity[size];
        }
    };

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
     * Gets the public account name.
     *
     * @return the public account name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the public account name.
     *
     * @param name the new public account name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the recommend level.
     *
     * @return the recommend level
     */
    public int getRecommendLevel() {
        return recommendLevel;
    }

    /**
     * Sets the recommend level.
     *
     * @param recommendLevel the new recommend level
     */
    public void setRecommendLevel(int recommendLevel) {
        this.recommendLevel = recommendLevel;
    }

    /**
     * Gets the logo url.
     *
     * @return the logo url
     */
    public String getLogo() {
        return logo;
    }

    /**
     * Sets the logo url.
     *
     * @param logo the new logo url
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }
}
