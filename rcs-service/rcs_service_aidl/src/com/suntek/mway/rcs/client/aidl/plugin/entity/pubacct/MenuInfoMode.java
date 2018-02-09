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

import java.util.LinkedList;
import java.util.List;

/**
 * The Class MenuInfoMode.
 */
public class MenuInfoMode implements Parcelable {

    /** The pa uuid. */
    private String paUuid;

    /** The menutimestamp. */
    private String menutimestamp;

    /** The menu info list. */
    private List<MenuInfo> menuInfoList;

    /**
     * Instantiates a new menu info mode.
     */
    public MenuInfoMode() {

    }

    /**
     * Instantiates a new menu info mode.
     *
     * @param source the source
     */
    public MenuInfoMode(Parcel source) {
        readFromParcel(source);
    }

    /*
     * (non-Javadoc)
     * @see android.os.Parcelable#describeContents()
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Write the menu entity to parcel stream. Pay attention to read and write
     * variables variables sequence should be consistent or not the correct
     * results
     *
     * @param dest the dest parcel stream
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(paUuid);
        dest.writeString(menutimestamp);
        dest.writeList(menuInfoList);
    }

    /**
     * Create the menu entity from parcel stream. Pay attention to read and
     * write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        paUuid = source.readString();
        menutimestamp = source.readString();
        menuInfoList = new LinkedList<MenuInfo>();
        source.readList(menuInfoList, this.getClass().getClassLoader());
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<MenuInfoMode> CREATOR =
            new Parcelable.Creator<MenuInfoMode>() {
        @Override
        public MenuInfoMode createFromParcel(Parcel source) {
            return new MenuInfoMode(source);
        }

        @Override
        public MenuInfoMode[] newArray(int size) {
            return new MenuInfoMode[size];
        }
    };

    /**
     * Gets the pa uuid.
     *
     * @return the pa uuid
     */
    public String getPaUuid() {
        return paUuid;
    }

    /**
     * Sets the pa uuid.
     *
     * @param paUuid the new pa uuid
     */
    public void setPaUuid(String paUuid) {
        this.paUuid = paUuid;
    }

    /**
     * Gets the menutimestamp.
     *
     * @return the menutimestamp
     */
    public String getMenutimestamp() {
        return menutimestamp;
    }

    /**
     * Sets the menutimestamp.
     *
     * @param menutimestamp the new menutimestamp
     */
    public void setMenutimestamp(String menutimestamp) {
        this.menutimestamp = menutimestamp;
    }

    /**
     * Gets the menu info list.
     *
     * @return the menu info list
     */
    public List<MenuInfo> getMenuInfoList() {
        return menuInfoList;
    }

    /**
     * Sets the menu info list.
     *
     * @param menuInfoList the new menu info list
     */
    public void setMenuInfoList(List<MenuInfo> menuInfoList) {
        this.menuInfoList = menuInfoList;
    }

}
