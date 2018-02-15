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

package com.suntek.mway.rcs.client.aidl.plugin.entity.profile;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Avatar extends BaseModel implements Parcelable, Serializable {
    private static final long serialVersionUID = -47856440160432L;

    public static final String PNG = "PNG";

    public static final String JPG = "JPG";

    public static final String GIF = "GIF";

    /** The avatar image type. */
    private IMAGE_TYPE avatarImgType = IMAGE_TYPE.PNG;

    /** The image encoding. */
    private String imgEncoding = "BASE64";

    /** The image base64 str. */
    private String imgBase64Str;

    /**
     * Instantiates a new avatar.
     */
    public Avatar() {
    }

    /**
     * Instantiates a new avatar.
     *
     * @param source the source
     */
    public Avatar(Parcel source) {
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
     * Write the avatar entity to parcel stream. Pay attention to read and write
     * variables variables sequence should be consistent or not the correct
     * results
     *
     * @param dest the dest
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(avatarImgType.ordinal());
        dest.writeString(imgEncoding);
        dest.writeString(imgBase64Str);
    }

    /**
     * Create the avatar entity from parcel stream. Pay attention to read and
     * write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        super.readFromParcel(source);
        avatarImgType = IMAGE_TYPE.valueOf(source.readInt());
        imgEncoding = source.readString();
        imgBase64Str = source.readString();
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<Avatar> CREATOR =
            new Parcelable.Creator<Avatar>() {
        @Override
        public Avatar createFromParcel(Parcel source) {
            return new Avatar(source);
        }

        @Override
        public Avatar[] newArray(int size) {
            return new Avatar[size];
        }
    };

    /**
     * Gets the avatar image type.
     *
     * @return the avatar image type
     */
    public IMAGE_TYPE getAvatarImgType() {
        return avatarImgType;
    }

    /**
     * Sets the avatar image type.
     *
     * @param avatarImgType the new avatar image type
     */
    public void setAvatarImgType(IMAGE_TYPE avatarImgType) {
        this.avatarImgType = avatarImgType;
    }

    /**
     * Gets the image base64 string.
     *
     * @return the image base64 string
     */
    public String getImgBase64Str() {
        return imgBase64Str;
    }

    /**
     * Sets the image base64 string.
     *
     * @param imgBase64Str the new image base64 string
     */
    public void setImgBase64Str(String imgBase64Str) {
        this.imgBase64Str = imgBase64Str;
    }

    /**
     * The Enum IMAGE_TYPE.
     */
    public static enum IMAGE_TYPE {
        PNG, JPG, GIF;

        public static IMAGE_TYPE valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }

            return values()[ordinal];
        }
    }

    @Override
    public String toString() {
        List<String> list = new ArrayList<String>();
        list.add("avatarImgType=" + this.avatarImgType);
        list.add("account=" + getAccount());
        list.add("etag=" + getEtag());
        list.add("imgEncoding=" + this.imgEncoding);
        list.add("imgBase64Str=" + this.imgBase64Str);

        return list.toString();
    }

}
