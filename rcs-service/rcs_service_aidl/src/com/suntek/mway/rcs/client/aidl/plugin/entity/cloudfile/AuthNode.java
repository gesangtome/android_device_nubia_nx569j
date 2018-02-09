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

package com.suntek.mway.rcs.client.aidl.plugin.entity.cloudfile;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Map;

public class AuthNode implements Parcelable {
    private byte[] captcha;

    private boolean isOffline;

    private AuthNodeUpdateInfo updateInfo;

    private int timeout;

    private UserType userType;

    private PwdType pwdType;

    private RegType regType;

    private ResetType resetType;

    private Map<String, String> fields;

    public AuthNode() {
    }

    public AuthNode(Parcel source) {
        readFromParcel(source);
    }

    /**
     * The parcel describe contents, defaul is 0.
     * @return the int
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Write the mcloud result entity to parcel stream. Pay attention to read
     * and write variables variables sequence should be consistent or not the
     * correct results
     * @param dest the dest parcel stream
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByteArray(captcha);
        dest.writeBooleanArray(new boolean[] {
            isOffline
        });
        dest.writeValue(updateInfo);
        dest.writeInt(timeout);
        dest.writeInt(userType.ordinal());
        dest.writeInt(pwdType.ordinal());
        dest.writeInt(regType.ordinal());
        dest.writeInt(resetType.ordinal());
        dest.writeMap(fields);
    }

    /**
     * Create the mcloud result entity from parcel stream. Pay attention to read
     * and write variables variables sequence should be consistent or not the
     * correct results
     * @param source The parcel stream
     */
    @SuppressWarnings("unchecked")
    public void readFromParcel(Parcel source) {
        captcha = source.createByteArray();
        boolean[] val = new boolean[1];
        source.readBooleanArray(val);
        isOffline = val[0];
        updateInfo = (AuthNodeUpdateInfo)source.readValue(this.getClass().getClassLoader());
        userType = UserType.valueOf(source.readInt());
        pwdType = PwdType.valueOf(source.readInt());
        regType = RegType.valueOf(source.readInt());
        resetType = ResetType.valueOf(source.readInt());
        fields = source.readHashMap(this.getClass().getClassLoader());
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<AuthNode> CREATOR =
            new Parcelable.Creator<AuthNode>() {
        @Override
        public AuthNode createFromParcel(Parcel source) {
            return new AuthNode(source);
        }

        @Override
        public AuthNode[] newArray(int size) {
            return new AuthNode[size];
        }
    };

    public byte[] getCaptcha() {
        return captcha;
    }

    public void setCaptcha(byte[] captcha) {
        this.captcha = captcha;
    }

    public boolean isOffline() {
        return isOffline;
    }

    public void setOffline(boolean isOffline) {
        this.isOffline = isOffline;
    }

    public AuthNodeUpdateInfo getUpdateInfo() {
        return updateInfo;
    }

    public void setUpdateInfo(AuthNodeUpdateInfo updateInfo) {
        this.updateInfo = updateInfo;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public PwdType getPwdType() {
        return pwdType;
    }

    public void setPwdType(PwdType pwdType) {
        this.pwdType = pwdType;
    }

    public RegType getRegType() {
        return regType;
    }

    public void setRegType(RegType regType) {
        this.regType = regType;
    }

    public ResetType getResetType() {
        return resetType;
    }

    public void setResetType(ResetType resetType) {
        this.resetType = resetType;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    public static enum PwdType {
        encrypted,

        original,

        dynamic,

        thirdParty;

        public static PwdType valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }

            return values()[ordinal];
        }
    }

    public static enum RegType {
        cellPhone;

        public static RegType valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }

            return values()[ordinal];
        }
    }

    public static enum ResetType {
        cellPhone,

        thirdParty;

        public static ResetType valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }

            return values()[ordinal];
        }
    }

    public static enum UserType {
        account,

        bindMobile,

        bindEmail,

        email;

        public static UserType valueOf(int ordinal) {
            if (ordinal < 0 || ordinal >= values().length) {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }

            return values()[ordinal];
        }
    }
}
