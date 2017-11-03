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

package com.suntek.mway.rcs.client.aidl.constant;

public class Actions {

    public static final String ACTION_ERROR = Main.PACKAGE_NAME + ".ACTION_ERROR";

    public static class RegisterAction {
        // status changed broadcast
        public final static String ACTION_REGISTER_STATUS_CHANGED = Main.PACKAGE_NAME
                + ".ACTION_REGISTER_STATUS_CHANGED";
        // unRegister finished broadcast
        public final static String ACTION_UNREGISTER_FINISHED = Main.PACKAGE_NAME
                + ".ACTION_UNREGISTER_FINISHED";

    }

    public static class DmsAction {

        public static final String ACTION_DMS_OPEN_PS = Main.PACKAGE_NAME + ".ACTION_DMS_OPEN_PS";

        public static final String ACTION_DMS_CONFIRM_USE_NEW_IMSI = Main.PACKAGE_NAME
                + ".ACTION_DMS_CONFIRM_USE_NEW_IMSI";

        public static final String ACTION_DMS_NEW_CONFIG = Main.PACKAGE_NAME
                + ".ACTION_DMS_NEW_CONFIG";

        public static final String ACTION_DMS_OPEN_ACCOUNT = Main.PACKAGE_NAME
                + ".ACTION_DMS_OPEN_ACCOUNT";

        public static final String ACTION_DMS_OPEN_ACCOUNT_RESULT = Main.PACKAGE_NAME
                + ".ACTION_DMS_OPEN_ACCOUNT_RESULT";

        public static final String ACTION_DMS_UPDATE_CONFIG = Main.PACKAGE_NAME
                + ".ACTION_DMS_UPDATE_CONFIG";

        public static final String ACTION_DMS_USER_STATUS_CHANGED = Main.PACKAGE_NAME
                + ".ACTION_DMS_USER_STATUS_CHANGED";

        public static final String ACTION_DMS_INPUT_SMS_VERIFY_CODE = Main.PACKAGE_NAME
                + ".ACTION_DMS_INPUT_SMS_VERIFY_CODE";

        public static final String ACTION_DMS_SHOW_DIALOG_INFO = Main.PACKAGE_NAME
                + ".ACTION_DMS_SHOW_DIALOG_INFO";

        /** The Constant ACTION_DMS_FETCH_CONFIG_FINISH. */
        public static final String ACTION_DMS_FETCH_CONFIG_FINISH = Main.PACKAGE_NAME
                + ".ACTION_DMS_FETCH_CONFIG_FINISH";

        /** The Constant ACTION_DMS_FETCH_CONFIG_ERROR. */
        public static final String ACTION_DMS_FETCH_CONFIG_ERROR = Main.PACKAGE_NAME
                + ".ACTION_DMS_FETCH_CONFIG_ERROR";

        public static final String ACTION_DMS_VERSION_REFRESH =
                "com.suntek.mway.rcs.ACTION_UI_RCS_DM_VERSION_REFRESH";

        public static final String ACTION_UI_SIM_NOT_BELONG_CMCC = Main.PACKAGE_NAME
                + ".ACTION_UI_SIM_NOT_BELONG_CMCC";

        /** The Constant ACTION_RCS_ENABLE_CHANGED. */
        public static final String ACTION_RCS_ENABLE_CHANGED =
                "com.suntek.mway.rcs.ACTION_RCS_ENABLE_CHANGED";
    }

    public static class GroupChatAction {
        public static final String ACTION_GROUP_CHAT_MANAGE_NOTIFY = Main.PACKAGE_NAME
                + ".ACTION_GROUP_CHAT_MANAGE_NOTIFY";

        public static final String ACTION_GROUP_CHAT_MANAGE_FAILED = Main.PACKAGE_NAME
                + ".ACTION_GROUP_CHAT_MANAGE_FAILED";

        public static final String ACTION_GROUP_CHAT_INVITE = Main.PACKAGE_NAME
                + ".ACTION_GROUP_CHAT_INVITE";
    }

    public static class MessageAction {

        public static final String ACTION_MESSAGE_BACKUP = Main.PACKAGE_NAME
                + ".ACTION_MESSAGE_BACKUP";

        public static final String ACTION_MESSAGE_FILE_TRANSFER_PROGRESS = Main.ACTION_NAME
                + ".ACTION_MESSAGE_FILE_TRANSFER_PROGRESS";

        public static final String ACTION_MESSAGE_RESTORE = Main.PACKAGE_NAME
                + ".ACTION_MESSAGE_RESTORE";

        public static final String ACTION_MESSAGE_SEND_FAILED = Main.PACKAGE_NAME
                + ".ACTION_MESSAGE_SEND_FAILED";

        public static final String ACTION_MESSAGE_EMOTICON_DOWNLOAD_RESULT = Main.PACKAGE_NAME
                + ".ACTION_MESSAGE_EMOTICON_DOWNLOAD_RESULT";

        public static final String ACTION_MESSAGE_STATUS_CHANGED = Main.ACTION_NAME
                + ".ACTION_MESSAGE_STATUS_CHANGED";

        public static final String ACTION_O2M_DETAIL_MESSAGE_STATUS_CHANGED = Main.PACKAGE_NAME
                + ".ACTION_O2M_DETAIL_MESSAGE_STATUS_CHANGED";

        public static final String ACTION_MESSAGE_TRANSFERED_SMS = Main.PACKAGE_NAME
                + ".ACTION_MESSAGE_TRANSFERED_SMS";

        public static final String ACTION_MESSAGE_SHOW_COMPOSING = Main.PACKAGE_NAME
                + ".ACTION_MESSAGE_SHOW_COMPOSING";

        public static final String ACTION_MESSAGE_NOTIFY = Main.ACTION_NAME
                + ".ACTION_MESSAGE_NOTIFY";

        public static final String ACTION_MESSAGE_GROUP_CHAT_NOTIFY = Main.PACKAGE_NAME
                + ".ACTION_MESSAGE_GROUP_CHAT_NOTIFY";

        public static final String ACTION_MESSAGE_REPORT = Main.PACKAGE_NAME
                + ".ACTION_MESSAGE_REPORT";

        public static final String ACTION_MESSAGE_DOWNLOAD_EMOTICON_RESULT = Main.PACKAGE_NAME
                + ".ACTION_MESSAGE_DOWNLOAD_EMOTICON_RESULT";

        public static final String ACTION_MESSAGE_FIREWALL_BLOCK_RECORD = Main.PACKAGE_NAME
                + ".ACTION_MESSAGE_FIREWALL_BLOCK_RECORD";

        public static final String ACTION_MESSAGE_SMS_POLICY_NOT_SET = Main.ACTION_NAME
                + ".ACTION_MESSAGE_SMS_POLICY_NOT_SET";
    }

    public static class PluginAction {

        public static final String ACTION_PLUGIN_APK_UNINSTALLED = Main.PACKAGE_NAME
                + ".ACTION_PLUGIN_APK_UNINSTALLED";

        public static final String ACTION_PLUGIN_INIT_START = Main.PACKAGE_NAME
                + ".ACTION_PLUGIN_INIT_START";

        public static final String ACTION_PLUGIN_INIT_SUCCESS = Main.PACKAGE_NAME
                + ".ACTION_PLUGIN_INIT_SUCCESS";

        public static final String ACTION_PLUGIN_INIT_FAILED = Main.PACKAGE_NAME
                + ".ACTION_PLUGIN_INIT_FAILED";

        // profile
        public static final String ACTION_PROFILE_UPDATE_CONTACT = Main.PACKAGE_NAME
                + ".ACTION_PROFILE_UPDATE_CONTACT";

        // cloud file
        public static final String ACTION_MCLOUD_DOWNLOAD_FILE_FROM_URL = Main.PACKAGE_NAME
                + ".ACTION_MCLOUD_DOWNLOAD_FILE_FROM_URL";

        public static final String ACTION_MCLOUD_GET_REMOTE_FILE_LIST = Main.PACKAGE_NAME
                + ".ACTION_MCLOUD_GET_REMOTE_FILE_LIST";

        public static final String ACTION_MCLOUD_GET_SHARE_FILE_LIST = Main.PACKAGE_NAME
                + ".ACTION_MCLOUD_GET_SHARE_FILE_LIST";

        public static final String ACTION_MCLOUD_PUT_FILE = Main.PACKAGE_NAME
                + ".ACTION_MCLOUD_PUT_FILE";

        public static final String ACTION_MCLOUD_SHARE_AND_SEND_FILE = Main.PACKAGE_NAME
                + ".ACTION_MCLOUD_SHARE_AND_SEND_FILE";

        public static final String ACTION_MCLOUD_SHARE_FILE = Main.PACKAGE_NAME
                + ".ACTION_MCLOUD_SHARE_FILE";
    }

    public static class PermissionAction {

        public static final String ACTION_PERMISSION_NO_GRANTED_SERVICE = Main.PACKAGE_NAME
                + ".ACTION_PERMISSION_NO_GRANTED";

        public static final String ACTION_PERMISSION_NO_GRANTED_PLUGIN
                = "com.suntek.mway.rcs.app.plugin.ACTION_PERMISSION_NO_GRANTED";

        public static final String ACTION_PERMISSION_NO_GRANTED_GBA
                = "com.cmcc.proxy.ACTION_PERMISSION_NO_GRANTED";
    }
}
