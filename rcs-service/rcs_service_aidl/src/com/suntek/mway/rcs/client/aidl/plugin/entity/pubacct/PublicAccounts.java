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

import java.io.UnsupportedEncodingException;

public class PublicAccounts implements Parcelable, Comparable<PublicAccounts> {
    /** The logo url. */
    private String logo;

    /** The name. */
    private String name;

    /** The public account uuid. */
    private String paUuid;

    /** The recommend level. */
    private int recommendLevel;

    /** The sip uri. */
    private String sipUri;

    /** The subscribestatus. */
    private int subscribestatus;

    /**
     * Instantiates a new public accounts.
     */
    public PublicAccounts() {
    }

    /**
     * Instantiates a new public accounts.
     *
     * @param source the source
     */
    public PublicAccounts(Parcel source) {
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
     * write the public account entity to parcel stream. Pay attention to read
     * and write variables variables sequence should be consistent or not the
     * correct results
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
        dest.writeString(sipUri);
        dest.writeInt(subscribestatus);
    }

    /**
     * Create the public account entity from parcel stream. Pay attention to
     * read and write variables variables sequence should be consistent or not
     * the correct results
     *
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        paUuid = source.readString();
        name = source.readString();
        recommendLevel = source.readInt();
        logo = source.readString();
        sipUri = source.readString();
        subscribestatus = source.readInt();
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<PublicAccounts> CREATOR =
            new Parcelable.Creator<PublicAccounts>() {
        @Override
        public PublicAccounts createFromParcel(Parcel source) {
            return new PublicAccounts(source);
        }

        @Override
        public PublicAccounts[] newArray(int size) {
            return new PublicAccounts[size];
        }
    };

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

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
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
     * Gets the sip uri.
     *
     * @return the sip uri
     */
    public String getSipUri() {
        return sipUri;
    }

    /**
     * Sets the sip uri.
     *
     * @param sipUri the new sip uri
     */
    public void setSipUri(String sipUri) {
        this.sipUri = sipUri;
    }

    /**
     * Gets the subscribestatus.
     *
     * @return the subscribestatus
     */
    public int getSubscribestatus() {
        return subscribestatus;
    }

    /**
     * Sets the subscribestatus.
     *
     * @param subscribestatus the new subscribestatus
     */
    public void setSubscribestatus(int subscribestatus) {
        this.subscribestatus = subscribestatus;
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append("paUuid=").append(this.paUuid).append(",name=").append(this.name)
                .append(",logo=").append(this.logo).append(",recommendLevel=")
                .append(this.recommendLevel).append(",sipUri=").append(this.sipUri);

        return sbuffer.toString();
    }

    @Override
    public int compareTo(PublicAccounts account) {
        int lenA = name.length();
        int lenB = account.getName().length();
        int lenComp = lenA >= lenB ? lenB : lenA;
        int result = 0;
        for (int i = 0; i < lenComp; i++) {
            result = getHexString(name.charAt(0)).compareTo(
                    getHexString(account.getName().charAt(0)));
            if (result == 0) {
                continue;
            } else {
                return result;
            }
        }
        if (lenA > lenB) {
            return 1;
        } else if (lenA == lenB) {
            return 0;
        } else {
            return -1;
        }
    }

    public static String getHexString(char c) {
        byte[] b = null;
        StringBuffer sb = new StringBuffer();
        try {
            b = new String(new char[] {
                c
            }).getBytes("gb2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < b.length; i++) {
            sb.append(Integer.toHexString(b[i] & 0xFF));
        }
        return sb.toString();
    }
}
