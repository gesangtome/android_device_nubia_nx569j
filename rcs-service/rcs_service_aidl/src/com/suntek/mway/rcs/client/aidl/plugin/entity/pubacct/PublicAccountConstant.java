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

/**
 * The Class PublicAccountConstant.
 */
public class PublicAccountConstant {

    /** account pre number. */
    public static final int ACCOUNT_PRE_NUMBER = 8;

    /** order type: 0 is desc order by the follow time. */
    public static final int ACCOUNTLIST_ORDER_TYPE_FOLLOWTIME_DESC = 0;

    /** order type: 1 is asc order by the public account. */
    public static final int ACCOUNTLIST_ORDER_TYPE_ACCOUNT_NAME_ASC = 1;

    /** order type: 0 is Forward from a time. */
    public static final int PREMESSAGE_ORDER_TYPE_TIME_FORWARD = 0;

    /** order type: 1 is Backward from a time. */
    public static final int PREMESSAGE_ORDER_TYPE_TIME_BACKWARD = 1;

    /** complain type: 1 is complain account. */
    public static final int COMPLAIN_TYPE_ACCOUNT = 1;

    /** complain type: 2 is complain content. */
    public static final int COMPLAIN_TYPE_CONTENT = 2;

    /** The Constant ACCEPT_STATUS_ACCEPT. */
    public static final int ACCEPT_STATUS_ACCEPT = 1;

    /** The Constant ACCEPT_STATUS_NOT. */
    public static final int ACCEPT_STATUS_NOT = 0;

    /** The Constant SUBSCRIBE_STATUS_FOLLOWED. */
    public static final int SUBSCRIBE_STATUS_FOLLOWED = 1;

    /** The Constant SUBSCRIBE_STATUS_UNFOLLOWED. */
    public static final int SUBSCRIBE_STATUS_UNFOLLOWED = 0;

    /** The Constant MENU_HAVE_YES. */
    public static final int MENU_HAVE_YES = 1;

    /** The Constant MENU_HAVE_NO. */
    public static final int MENU_HAVE_NO = 0;

    /** The Constant ACCOUNT_STATUS_NORMAL. */
    public static final int ACCOUNT_STATUS_NORMAL = 0;

    /** The Constant ACCOUNT_STATUS_PAUSE. */
    public static final int ACCOUNT_STATUS_PAUSE = 1;

    /** The Constant ACCOUNT_STATUS_CLOSE. */
    public static final int ACCOUNT_STATUS_CLOSE = 2;

    /** The Constant MENU_TYPE_SEND_MESSAGE. */
    public static final int MENU_TYPE_SEND_MESSAGE = 0;

    /** The Constant MENU_TYPE_URL. */
    public static final int MENU_TYPE_URL = 1;

    /** The Constant MENU_TYPE_DEVICE_API. */
    public static final int MENU_TYPE_DEVICE_API = 2;

    /** The Constant MENU_TYPE_APPLICATION. */
    public static final int MENU_TYPE_APPLICATION = 3;

    /** The Constant MESSAGE_FORWARD_ABLE. */
    public static final int MESSAGE_FORWARD_ABLE = 0;

    /** The Constant MESSAGE_FORWARD_UNABLE. */
    public static final int MESSAGE_FORWARD_UNABLE = 1;

}
