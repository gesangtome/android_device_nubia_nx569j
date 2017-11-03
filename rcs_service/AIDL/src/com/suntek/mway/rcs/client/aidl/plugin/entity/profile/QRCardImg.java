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

public class QRCardImg extends BaseModel implements Parcelable, Serializable {
    private static final long serialVersionUID = 4674425471217216710L;

    private boolean businessFlag;

    private IMAGE_TYPE imgType = IMAGE_TYPE.PNG;

    private String imgEncoding = "BASE64";

    private String description;

    private String imgBase64Str;

    public QRCardImg() {
    }

    public QRCardImg(Parcel source) {
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
     * Write the qr card image entity to parcel stream. Pay attention to read
     * and write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param dest the dest
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeBooleanArray(new boolean[] {
            businessFlag
        });
        dest.writeInt(imgType.ordinal());
        dest.writeString(imgEncoding);
        dest.writeString(description);
        dest.writeString(imgBase64Str);
    }

    /**
     * Create the qr card image entity from parcel stream. Pay attention to read
     * and write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        super.readFromParcel(source);
        boolean[] val = new boolean[1];
        source.readBooleanArray(val);
        businessFlag = val[0];
        imgType = IMAGE_TYPE.valueOf(source.readInt());
        imgEncoding = source.readString();
        description = source.readString();
        imgBase64Str = source.readString();
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<QRCardImg> CREATOR =
            new Parcelable.Creator<QRCardImg>() {
        @Override
        public QRCardImg createFromParcel(Parcel source) {
            return new QRCardImg(source);
        }

        @Override
        public QRCardImg[] newArray(int size) {
            return new QRCardImg[size];
        }
    };

    public boolean isBusinessFlag() {
        return businessFlag;
    }

    public void setBusinessFlag(boolean businessFlag) {
        this.businessFlag = businessFlag;
    }

    public IMAGE_TYPE getImgType() {
        return imgType;
    }

    public void setImgType(IMAGE_TYPE imgType) {
        this.imgType = imgType;
    }

    public String getImgEncoding() {
        return imgEncoding;
    }

    public void setImgEncoding(String imgEncoding) {
        this.imgEncoding = imgEncoding;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgBase64Str() {
        return imgBase64Str;
    }

    public void setImgBase64Str(String imgBase64Str) {
        this.imgBase64Str = imgBase64Str;
    }

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
        list.add("businessFlag=" + this.businessFlag);
        list.add("imgEncoding=" + this.imgEncoding);
        list.add("imgBase64Str=" + this.imgBase64Str);
        list.add("imgType=" + this.imgType);
        list.add("description=" + this.description);
        list.add("account=" + getAccount());
        list.add("etag=" + getEtag());
        return list.toString();
    }
}
