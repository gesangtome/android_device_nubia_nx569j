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

package com.suntek.mway.rcs.client.aidl.plugin.entity.richscrn;

public enum PhoneEvent {

    /** Non specific events. */
    DEFAULT_EVENT("0000000000"),

    /** The launch the voice call. */
    LAUNCH_V_CALL("1110000000"),

    /** A voice call incoming, terminal began ringing. */
    V_CALL_IN_RINGING("1220018000"),

    /** Voice call connection ( caller side ). */
    V_CALL_CONN_CALLER("1130020000"),

    /** Voice call connection ( called side ). */
    V_CALL_CONN_CALLED("123 00 20000"),

    /** Voice call hang up ( caller side ). */
    V_CALL_HANG_UP_CALLER("1140020000"),

    /** Voice call hung ( called side ). */
    V_CALL_HANG_UP_CALLED("1240020000"),

    /** Start a video call out. */
    LAUNCH_VD_CALL("2110000000"),

    /** A video call incoming, terminal began ringing. */
    VD_CALL_IN_RINGING("2220000000"),

    /** Video call connection ( caller side ). */
    VD_CALL_CONN_CALLER("2130020000"),

    /** Video call connection ( called side ). */
    VD_CALL_CONN_CALLED("2230020000"),

    /** Video call hang up ( caller side ). */
    VD_CALL_HANG_UP_CALLER("2140020000"),

    /** Video call hung ( called side ). */
    VD_CALL_HANG_UP_CALLED("2240020000"),

    /**
     * Terminal communications, is being viewed, main requirements for
     * reinforced screen.
     */
    CONTACT_READING_REQ_SCRN("9331011000"),

    /**
     * Terminal communications, is viewed, the main requirements set enhanced
     * screen.
     */
    CONTACT_READING_SET_SCRN("9331012000"),

    /**
     * Terminal contacts to complete the update (such as add or revise a
     * contact).
     */
    CONTACT_UPDATE_FINISH("9341020000"),

    /** Terminal is to restore the factory settings. */
    FACTORY_SETTING_READY_RESTORE("9319030000"),

    /** The terminal has been completed to restore factory settings. */
    FACTORY_SETTING_RESTORE_FINISH("9349030000"),

    /** The terminal has replaced the SIM card. */
    SIM_CARD_CHANGED("9449040000");

    /** The ctrl string. */
    private String ctrlString;

    /**
     * Instantiates a new phone event.
     *
     * @param ctrlString the ctrl string
     */
    private PhoneEvent(String ctrlString) {
        this.ctrlString = ctrlString;
    }

    /**
     * Gets the control string.
     *
     * @return the control string
     */
    public String getCtrlStr() {
        return ctrlString;
    }
}
