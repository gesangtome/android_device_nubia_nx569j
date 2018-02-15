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

public class MenuInfo implements Parcelable {

    /** The command id. */
    private String commandId;

    /** The title. */
    private String title;

    /** The type. */
    private int type;

    /** The priority. */
    private int priority;

    /** The sub menu list. */
    private List<MenuInfo> subMenuList;

    /**
     * Instantiates a new menu info.
     */
    public MenuInfo() {
    }

    /**
     * Instantiates a new menu info.
     *
     * @param source the source
     */
    public MenuInfo(Parcel source) {
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
     * Write the menu entity to parcel stream. Pay attention to read and write
     * variables variables sequence should be consistent or not the correct
     * results
     *
     * @param dest the dest parcel stream
     * @param flags the flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(commandId);
        dest.writeString(title);
        dest.writeInt(type);
        dest.writeInt(priority);
        dest.writeList(subMenuList);
    }

    /**
     * Create the menu entity from parcel stream. Pay attention to read and
     * write variables variables sequence should be consistent or not the
     * correct results
     *
     * @param source The parcel stream
     */
    public void readFromParcel(Parcel source) {
        commandId = source.readString();
        title = source.readString();
        type = source.readInt();
        priority = source.readInt();
        subMenuList = new LinkedList<MenuInfo>();
        source.readList(subMenuList, this.getClass().getClassLoader());
    }

    /** The parcel creator. */
    public static final Parcelable.Creator<MenuInfo> CREATOR =
            new Parcelable.Creator<MenuInfo>() {
        @Override
        public MenuInfo createFromParcel(Parcel source) {
            return new MenuInfo(source);
        }

        @Override
        public MenuInfo[] newArray(int size) {
            return new MenuInfo[size];
        }
    };

    /**
     * Gets the command id.
     *
     * @return the command id
     */
    public String getCommandId() {
        return commandId;
    }

    /**
     * Sets the command id.
     *
     * @param commandId the new command id
     */
    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Gets the priority.
     *
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Sets the priority.
     *
     * @param priority the new priority
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Gets the sub menu list.
     *
     * @return the sub menu list
     */
    public List<MenuInfo> getSubMenuList() {
        return subMenuList;
    }

    /**
     * Sets the sub menu list.
     *
     * @param subMenuList the new sub menu list
     */
    public void setSubMenuList(List<MenuInfo> subMenuList) {
        this.subMenuList = subMenuList;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append("commandId=").append(this.commandId).append(",title=").append(this.title)
                .append(",type=").append(this.type).append(",priority=").append(this.priority);
        if (null != this.subMenuList && this.subMenuList.size() > 0) {
            sbuffer.append(",subMenuList=").append("[");
            for (MenuInfo menu : this.subMenuList) {
                sbuffer.append(menu.toString());
            }
            sbuffer.append("]");
        }

        return sbuffer.toString();
    }

}
