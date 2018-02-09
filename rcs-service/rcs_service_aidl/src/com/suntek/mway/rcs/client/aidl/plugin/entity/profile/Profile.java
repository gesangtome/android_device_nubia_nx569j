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

public class Profile extends BaseModel implements Parcelable, Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8351378268771321120L;

    /** The home address. */
    private String homeAddress;

    /** The email. */
    private String email;

    /** The birthday. */
    private String birthday;

    /** The company name. */
    private String companyName;

    /** The company duty. */
    private String companyDuty;

    /** The company tel. */
    private String companyTel;

    /** The company address. */
    private String companyAddress;

    /** The company fax. */
    private String companyFax;

    /** The first name. */
    private String firstName;

    /** The last name. */
    private String lastName;

    /** The other tels. */
    private ArrayList<TelephoneModel> otherTels;

    /**
     * Instantiates a new profile.
     */
    public Profile() {
    }

    /**
     * Instantiates a new profile.
     *
     * @param source the source
     */
    public Profile(Parcel source) {
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
     * Write the profile entity to parcel stream. Pay attention to read and
     * write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param dest the dest
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(homeAddress);
        dest.writeString(email);
        dest.writeString(birthday);
        dest.writeString(companyName);
        dest.writeString(companyDuty);
        dest.writeString(companyTel);
        dest.writeString(companyAddress);
        dest.writeString(companyFax);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeList(otherTels);
    }

    /**
     * Create the profile entity from parcel stream. Pay attention to read and
     * write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        super.readFromParcel(source);
        homeAddress = source.readString();
        email = source.readString();
        birthday = source.readString();
        companyName = source.readString();
        companyDuty = source.readString();
        companyTel = source.readString();
        companyAddress = source.readString();
        companyFax = source.readString();
        firstName = source.readString();
        lastName = source.readString();

        otherTels = new ArrayList<TelephoneModel>();
        source.readList(otherTels, this.getClass().getClassLoader());
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<Profile> CREATOR =
            new Parcelable.Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel source) {
            return new Profile(source);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };

    /**
     * Gets the home address.
     *
     * @return the home address
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * Sets the home address.
     *
     * @param homeAddress the new home address
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the birthday.
     *
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Sets the birthday.
     *
     * @param birthday the new birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * Gets the company name.
     *
     * @return the company name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the company name.
     *
     * @param companyName the new company name
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Gets the company duty.
     *
     * @return the company duty
     */
    public String getCompanyDuty() {
        return companyDuty;
    }

    /**
     * Sets the company duty.
     *
     * @param companyDuty the new company duty
     */
    public void setCompanyDuty(String companyDuty) {
        this.companyDuty = companyDuty;
    }

    /**
     * Gets the company tel.
     *
     * @return the company tel
     */
    public String getCompanyTel() {
        return companyTel;
    }

    /**
     * Sets the company tel.
     *
     * @param companyTel the new company tel
     */
    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    /**
     * Gets the company address.
     *
     * @return the company address
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * Sets the company address.
     *
     * @param companyAddress the new company address
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    /**
     * Gets the company fax.
     *
     * @return the company fax
     */
    public String getCompanyFax() {
        return companyFax;
    }

    /**
     * Sets the company fax.
     *
     * @param companyFax the new company fax
     */
    public void setCompanyFax(String companyFax) {
        this.companyFax = companyFax;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Combine the first name and the last name.
     *
     * @return displayName
     */
    public String getDisplayName() {
        String first = firstName; // given name.
        String last = lastName; // family name.

        boolean isLettersOnly = true;

        isLettersOnly = isLettersOnly && isNullOrLettersOnly(first);
        isLettersOnly = isLettersOnly && isNullOrLettersOnly(last);

        // Avoid "null" to show in the UI.
        if (first == null) {
            first = "";
        }
        if (last == null) {
            last = "";
        }

        if (isLettersOnly) {
            return first + " " + last;
        } else {
            return last + first;
        }
    }

    private boolean isNullOrLettersOnly(String text) {
        if (text == null) {
            return true;
        }

        return isLettersOnly(text.trim());
    }

    /**
     * Returns whether the given CharSequence contains only letters.
     */
    public static boolean isLettersOnly(CharSequence str) {
        final int len = str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the other tels.
     *
     * @return the other tels
     */
    public ArrayList<TelephoneModel> getOtherTels() {
        if (otherTels == null) {
            return new ArrayList<TelephoneModel>();
        }
        return otherTels;
    }

    /**
     * Sets the other tels.
     *
     * @param otherTels the new other tels
     */
    public void setOtherTels(ArrayList<TelephoneModel> otherTels) {
        this.otherTels = otherTels;
    }

    /*
     * @see
     * com.suntek.mway.rcs.client.api.plugin.entity.profile.BaseModel#toString()
     */
    @Override
    public String toString() {
        List<String> list = new ArrayList<String>();
        list.add("homeAddress=" + this.homeAddress);
        list.add("email=" + this.email);
        list.add("birthday=" + this.birthday);
        list.add("companyName=" + this.companyName);
        list.add("companyDuty=" + this.companyDuty);
        list.add("companyTel=" + this.companyTel);
        list.add("companyAddress=" + this.companyAddress);
        list.add("companyFax=" + this.companyFax);
        list.add("firstName=" + this.firstName);
        list.add("lastName=" + this.lastName);
        list.add("otherTels=" + (this.otherTels == null ? null : this.otherTels.toString()));
        list.add("account=" + getAccount());
        list.add("etag=" + getEtag());
        return list.toString();
    }
}
