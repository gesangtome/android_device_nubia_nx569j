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

public class PublicAccountsDetail implements Parcelable {
    /** The public account uuid. */
    private String paUuid;

    /** The name. */
    private String name;

    /** The company. */
    private String company;

    /** The introduce. */
    private String intro;

    /** The type. */
    private String type;

    /** The recommend level. */
    private int recommendLevel;

    /** The update time. */
    private String updateTime;

    /** The menu type. */
    private int menuType;

    /** The menu timestamp. */
    private String menuTimestamp;

    /** The subscribe status. */
    private int subscribeStatus;

    /** The accept status. */
    private int acceptstatus;

    /** The active status. */
    private int activeStatus;

    /** The tel. */
    private String tel;

    /** The email. */
    private String email;

    /** The zip. */
    private String zip;

    /** The addr. */
    private String addr;

    /** The field. */
    private String field;

    /** The qr code. */
    private String qrCode;

    /** The logo url. */
    private String logoUrl;

    /** The sip uri. */
    private String sipUri;

    /** The number. */
    private String number;

    /** The logoType. */
    private String logoType;

    /** The menuString. */
    private String menuString;

    /**
     * Instantiates a new public accounts detail.
     */
    public PublicAccountsDetail() {
    }

    /**
     * Instantiates a new public accounts detail.
     *
     * @param source the source
     */
    public PublicAccountsDetail(Parcel source) {
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
     * write the public account detail entity to parcel stream. Pay attention to
     * read and write variables variables sequence should be consistent or not
     * the correct results
     *
     * @param dest the dest
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(paUuid);
        dest.writeString(name);
        dest.writeString(company);
        dest.writeString(intro);
        dest.writeString(type);
        dest.writeInt(recommendLevel);
        dest.writeString(updateTime);
        dest.writeInt(menuType);
        dest.writeString(menuTimestamp);
        dest.writeInt(subscribeStatus);
        dest.writeInt(acceptstatus);
        dest.writeInt(activeStatus);
        dest.writeString(tel);
        dest.writeString(email);
        dest.writeString(zip);
        dest.writeString(addr);
        dest.writeString(field);
        dest.writeString(qrCode);
        dest.writeString(logoUrl);
        dest.writeString(sipUri);
        dest.writeString(number);
        dest.writeString(logoType);
        dest.writeString(menuString);
    }

    /**
     * Create the public account detail entity from parcel stream. Pay attention
     * to read and write variables variables sequence should be consistent or
     * not the correct results
     *
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        paUuid = source.readString();
        name = source.readString();
        company = source.readString();
        intro = source.readString();
        type = source.readString();
        recommendLevel = source.readInt();
        updateTime = source.readString();
        menuType = source.readInt();
        menuTimestamp = source.readString();
        subscribeStatus = source.readInt();
        acceptstatus = source.readInt();
        activeStatus = source.readInt();
        tel = source.readString();
        email = source.readString();
        zip = source.readString();
        addr = source.readString();
        field = source.readString();
        qrCode = source.readString();
        logoUrl = source.readString();
        sipUri = source.readString();
        number = source.readString();
        logoType = source.readString();
        menuString = source.readString();
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<PublicAccountsDetail> CREATOR =
            new Parcelable.Creator<PublicAccountsDetail>() {
        @Override
        public PublicAccountsDetail createFromParcel(Parcel source) {
            return new PublicAccountsDetail(source);
        }

        @Override
        public PublicAccountsDetail[] newArray(int size) {
            return new PublicAccountsDetail[size];
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
     * Gets the company.
     *
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the company.
     *
     * @param company the new company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Gets the introduce.
     *
     * @return the introduce
     */
    public String getIntro() {
        return intro;
    }

    /**
     * Sets the introduce.
     *
     * @param intro the new introduce
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
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
     * Gets the update time.
     *
     * @return the update time
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * Sets the update time.
     *
     * @param updateTime the new update time
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * Gets the menu type.
     *
     * @return the menu type
     */
    public int getMenuType() {
        return menuType;
    }

    /**
     * Sets the menu type.
     *
     * @param menuType the new menu type
     */
    public void setMenuType(int menuType) {
        this.menuType = menuType;
    }

    /**
     * Gets the menu timestamp.
     *
     * @return the menu timestamp
     */
    public String getMenuTimestamp() {
        return menuTimestamp;
    }

    /**
     * Sets the menu timestamp.
     *
     * @param menuTimestamp the new menu timestamp
     */
    public void setMenuTimestamp(String menuTimestamp) {
        this.menuTimestamp = menuTimestamp;
    }

    /**
     * Gets the subscribe status.
     *
     * @return the subscribe status
     */
    public int getSubscribeStatus() {
        return subscribeStatus;
    }

    /**
     * Sets the subscribe status.
     *
     * @param subscribeStatus the new subscribe status
     */
    public void setSubscribeStatus(int subscribeStatus) {
        this.subscribeStatus = subscribeStatus;
    }

    /**
     * Gets the acceptstatus.
     *
     * @return the acceptstatus
     */
    public int getAcceptstatus() {
        return acceptstatus;
    }

    /**
     * Sets the acceptstatus.
     *
     * @param acceptstatus the new acceptstatus
     */
    public void setAcceptstatus(int acceptstatus) {
        this.acceptstatus = acceptstatus;
    }

    /**
     * Gets the active status.
     *
     * @return the active status
     */
    public int getActiveStatus() {
        return activeStatus;
    }

    /**
     * Sets the active status.
     *
     * @param activeStatus the new active status
     */
    public void setActiveStatus(int activeStatus) {
        this.activeStatus = activeStatus;
    }

    /**
     * Gets the tel.
     *
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * Sets the tel.
     *
     * @param tel the new tel
     */
    public void setTel(String tel) {
        this.tel = tel;
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
     * Gets the zip.
     *
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets the zip.
     *
     * @param zip the new zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Gets the addr.
     *
     * @return the addr
     */
    public String getAddr() {
        return addr;
    }

    /**
     * Sets the addr.
     *
     * @param addr the new addr
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * Gets the field.
     *
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * Sets the field.
     *
     * @param field the new field
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * Gets the qr code.
     *
     * @return the qr code
     */
    public String getQrCode() {
        return qrCode;
    }

    /**
     * Sets the qr code.
     *
     * @param qrCode the new qr code
     */
    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    /**
     * Gets the logo url.
     *
     * @return the logo url
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * Sets the logo url.
     *
     * @param logoUrl the new logo url
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
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
     * @return the logoType
     */
    public String getLogoType() {
        return logoType;
    }

    /**
     * @param logoType the logoType to set
     */
    public void setLogoType(String logoType) {
        this.logoType = logoType;
    }

    /**
     * @return the menuString
     */
    public String getMenuString() {
        return menuString;
    }

    /**
     * @param menuString the menuString to set
     */
    public void setMenuString(String menuString) {
        this.menuString = menuString;
    }

    /**
     * toString
     *
     * @return the gson string
     */
    @Override
    public String toString() {
        // return new Gson().toJson( this );
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append("paUuid=").append(this.paUuid).append(",name=").append(this.name)
                .append(",number=").append(this.number).append(",logoUrl=").append(this.logoUrl)
                .append(",recommendLevel=").append(this.recommendLevel).append(",sipUri=")
                .append(this.sipUri).append(",company=").append(this.company).append(",intro=")
                .append(this.intro).append(",type=").append(this.type).append(",updateTime=")
                .append(this.updateTime).append(",menuType=").append(this.menuType)
                .append(",menuTimestamp=").append(this.menuTimestamp).append(",subscribeStatus=")
                .append(this.subscribeStatus).append(",acceptstatus=").append(this.acceptstatus)
                .append(",activeStatus=").append(this.activeStatus).append(",tel=")
                .append(this.tel).append(",email=").append(this.email).append(",zip=")
                .append(this.zip).append(",addr=").append(this.addr).append(",field=")
                .append(this.field).append(",qrCode=").append(this.qrCode).append(",logoType=")
                .append(this.logoType).append(",menuString=").append(this.menuString);

        return sbuffer.toString();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
