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

package com.suntek.mway.rcs.client.aidl.common;

public class RcsColumns {
    /**
     * those columns add for rcs which are add in telephonyProvider sms table.
     */
    public class SmsRcsColumns {
        public final static String RCS_MESSAGE_ID = "rcs_message_id";

        public final static String RCS_FILENAME = "rcs_file_name";

        public final static String RCS_MIME_TYPE = "rcs_mime_type";

        public final static String RCS_MSG_TYPE = "rcs_msg_type";

        public final static String RCS_SEND_RECEIVE = "rcs_send_receive";

        public final static String RCS_MSG_STATE = "rcs_msg_state";

        public final static String RCS_CHAT_TYPE = "rcs_chat_type";

        public final static String RCS_THREAD_ID = "rcs_thread_id";

        public final static String RCS_CONVERSATION_ID = "rcs_conversation_id";

        public final static String RCS_CONTRIBUTION_ID = "rcs_contribution_id";

        public final static String RCS_FILE_SELECTOR = "rcs_file_selector";

        public final static String RCS_FILE_TRANSFERED = "rcs_file_transfered";

        public final static String RCS_FILE_TRANSFER_ID = "rcs_file_transfer_id";

        public final static String RCS_FILE_ICON = "rcs_file_icon";

        public final static String RCS_BURN = "rcs_burn";

        public final static String RCS_HEADER = "rcs_header";

        public final static String RCS_PATH = "rcs_file_path";

        public final static String RCS_IS_DOWNLOAD = "rcs_is_download";

        public final static String RCS_PLAY_TIME = "rcs_play_time";

        public final static String RCS_FILE_SIZE = "rcs_file_size";

        public final static String RCS_THUMB_PATH = "rcs_thumb_path";

        public final static String RCS_BURN_BODY = "rcs_burn_body";

        public final static String RCS_NMSG_STATE = "rcs_nmsg_state";

        public final static String RCS_FAVOURITE = "favourite";

        public final static String RCS_MEDIA_PLAYED = "rcs_media_played";

        public final static String RCS_EXT_CONTACT = "rcs_ext_contact";

        public final static String RCS_FILE_RECORD = "rcs_file_record";

        public final static String PHONE_ID = "phone_id";

        public final static String SUB_ID = "sub_id";
    }

    /**
     * those columns add for rcs which are add in telephonyProvider thread
     * table.
     */
    public class ThreadColumns {
        public final static String RCS_TOP = "rcs_top";

        public final static String RCS_TOP_TIME = "rcs_top_time";

        public final static String RCS_NUMBER = "rcs_number";

        public final static String RCS_MSG_ID = "last_msg_id";

        public final static String RCS_CHAT_TYPE = "msg_chat_type";

        public final static String RCS_MSG_TYPE = "last_msg_type";

        public final static String RCS_UNREAD_COUNT = "rcs_unread_count";
    }

    /**
     * Those columns use to save the 1-N message status
     */
    public class GroupStatusColumns {
        public final static String _ID = "_id";

        public final static String MSG_ID = "msg_id";

        public final static String GROUP_NUMBER = "number";

        public final static String GROUP_STATUS = "status";

        public final static String GROUP_DATE = "date";
    }

    /**
     * Those columns use to query device api.
     */
    public class DeviceApiColumns {
        public final static String MESSAGE_ID = "message_id";

        public final static String BODY = "body";

        public final static String CONTACT_NUMBER = "contact_number";

        public final static String FILENAME = "file_name";

        public final static String TYPE = "mime_type";

        public final static String FILEICON = "file_icon";

        public final static String DIRECTION = "direction";

        public final static String FILE_SIZE = "file_size";

        public final static String TRANSFERRED = "file_transferred";

        public final static String TIMESTAMP = "time_stamp";

        public final static String STATE = "message_status";

    }
}
