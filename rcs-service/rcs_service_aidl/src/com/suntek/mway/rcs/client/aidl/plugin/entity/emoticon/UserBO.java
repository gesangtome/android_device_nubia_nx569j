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

package com.suntek.mway.rcs.client.aidl.plugin.entity.emoticon;

import android.os.Parcel;
import android.os.Parcelable;

public class UserBO implements Parcelable {
    /** The user's phone number. */
    private String userPhone;

    /** The user's nickname. */
    private String userNick;

    /** The user login time. */
    private String userLoginTime;

    /** The user current state. */
    private String userState;

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
     * Write the user entity to parcel stream. Pay attention to read and write
     * variables variables sequence should be consistent or not the correct
     * results
     *
     * @param dest the dest
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userPhone);
        dest.writeString(userNick);
        dest.writeString(userLoginTime);
        dest.writeString(userState);
    }

    /**
     * Create the user entity from parcel stream. Pay attention to read and
     * write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        userPhone = source.readString();
        userNick = source.readString();
        userLoginTime = source.readString();
        userState = source.readString();
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<UserBO> CREATOR =
            new Parcelable.Creator<UserBO>() {
        @Override
        public UserBO createFromParcel(Parcel source) {
            return new UserBO(source);
        }

        @Override
        public UserBO[] newArray(int size) {
            return new UserBO[size];
        }
    };

    /**
     * Instantiates a new user entity.
     */
    public UserBO() {
    }

    /**
     * Instantiates a new user entity from parcel.
     *
     * @param source the parcel source
     */
    public UserBO(Parcel source) {
        readFromParcel(source);
    }

    /**
     * Gets the user phone number.
     *
     * @return the user phone number
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * Sets the user phone number.
     *
     * @param userPhone the new user phone number
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * Gets the user nickname.
     *
     * @return the user nickname
     */
    public String getUserNick() {
        return userNick;
    }

    /**
     * Sets the user nickname.
     *
     * @param userNick the new user nickname
     */
    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    /**
     * Gets the user login time.
     *
     * @return the user login time
     */
    public String getUserLoginTime() {
        return userLoginTime;
    }

    /**
     * Sets the user login time.
     *
     * @param userLoginTime the new user login time
     */
    public void setUserLoginTime(String userLoginTime) {
        this.userLoginTime = userLoginTime;
    }

    /**
     * Gets the user state.
     *
     * @return the user state
     */
    public String getUserState() {
        return userState;
    }

    /**
     * Sets the user state.
     *
     * @param userState the new user state
     */
    public void setUserState(String userState) {
        this.userState = userState;
    }

}
