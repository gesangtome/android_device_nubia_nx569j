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
package com.suntek.rcs.ui.common.provider;

import android.content.UriMatcher;
import android.provider.BaseColumns;
import android.provider.Telephony.CanonicalAddressesColumns;
import android.provider.Telephony.Mms;
import android.provider.Telephony.MmsSms;
import android.provider.Telephony.MmsSms.PendingMessages;
import android.provider.Telephony.Sms;
import android.provider.Telephony.Sms.Conversations;
import android.provider.Telephony.Threads;
import android.provider.Telephony.ThreadsColumns;
import android.telephony.SubscriptionManager;

import com.suntek.mway.rcs.client.aidl.common.RcsColumns;
import com.suntek.mway.rcs.client.aidl.common.DeviceApiConstant;
import com.suntek.mway.rcs.client.aidl.constant.Constants.MessageConstants;

import java.util.HashSet;
import java.util.Set;

public class RcsMessageProviderConstants {

    public static final String TABLE_GROUP_STATUS = "group_status";
    public static final boolean isRcs = true;

    // These are the columns that appear in both the MMS ("pdu") and
    // SMS ("sms") message tables.
    private static final String[] MMS_SMS_COLUMNS =
            { BaseColumns._ID, Mms.DATE, Mms.DATE_SENT, Mms.READ, Mms.THREAD_ID, Mms.LOCKED,
                     Mms.SUBSCRIPTION_ID, Mms.PHONE_ID};

    // These are the columns that appear only in the MMS message
    // table.
    private static final String[] MMS_ONLY_COLUMNS = {
        Mms.CONTENT_CLASS, Mms.CONTENT_LOCATION, Mms.CONTENT_TYPE,
        Mms.DELIVERY_REPORT, Mms.EXPIRY, Mms.MESSAGE_CLASS, Mms.MESSAGE_ID,
        Mms.MESSAGE_SIZE, Mms.MESSAGE_TYPE, Mms.MESSAGE_BOX, Mms.PRIORITY,
        Mms.READ_STATUS, Mms.RESPONSE_STATUS, Mms.RESPONSE_TEXT,
        Mms.RETRIEVE_STATUS, Mms.RETRIEVE_TEXT_CHARSET, Mms.REPORT_ALLOWED,
        Mms.READ_REPORT, Mms.STATUS, Mms.SUBJECT, Mms.SUBJECT_CHARSET,
        Mms.TRANSACTION_ID, Mms.MMS_VERSION, Mms.TEXT_ONLY };
    // These are the columns that appear only in the SMS message
    // table.
    public static final String[] RCS_SMS_ONLY_COLUMNS = {
        "address", "body", "person", "reply_path_present",
        "service_center", "status", "subject", "type", "error_code", "priority",
        RcsColumns.SmsRcsColumns.RCS_FILENAME, RcsColumns.SmsRcsColumns.RCS_THUMB_PATH,
        RcsColumns.SmsRcsColumns.RCS_MIME_TYPE, RcsColumns.SmsRcsColumns.RCS_MSG_TYPE,
        RcsColumns.SmsRcsColumns.RCS_CHAT_TYPE, RcsColumns.SmsRcsColumns.RCS_FAVOURITE,
        RcsColumns.SmsRcsColumns.RCS_MSG_STATE, RcsColumns.SmsRcsColumns.RCS_BURN,
        RcsColumns.SmsRcsColumns.RCS_IS_DOWNLOAD, RcsColumns.SmsRcsColumns.RCS_FILE_SIZE,
        RcsColumns.SmsRcsColumns.RCS_BURN_BODY, RcsColumns.SmsRcsColumns.RCS_MESSAGE_ID,
        RcsColumns.SmsRcsColumns.RCS_MEDIA_PLAYED, RcsColumns.SmsRcsColumns.RCS_EXT_CONTACT,
        RcsColumns.SmsRcsColumns.RCS_FILE_RECORD
};

    // These are all the columns that appear in the MMS and SMS
    // message tables.
    private static final String[] UNION_COLUMNS =
            new String[MMS_SMS_COLUMNS.length
                       + MMS_ONLY_COLUMNS.length
                       + RCS_SMS_ONLY_COLUMNS.length];

    private static final String[] ID_PROJECTION = { BaseColumns._ID };

    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    private static final String[] SEARCH_STRING = new String[1];

    private static final String RCS_SMS_PROJECTION =
            "rcs_file_path,"
            + "rcs_thumb_path,"
            + "rcs_msg_type, "
            + "rcs_burn,"
            + "rcs_is_download,"
            + "rcs_msg_state,"
            + "rcs_mime_type,"
            + "favourite,"
            + "rcs_file_size,"
            + "rcs_message_id,"
            + "rcs_chat_type,";

    private static final String RCS_OTHER_PROJECTION =
             "NULL AS rcs_file_path,"
            + "NULL AS rcs_thumb_path,"
            + "NULL AS rcs_msg_type,"
            + "NULL AS rcs_burn,"
            + "NULL AS rcs_is_download,"
            + "NULL AS rcs_msg_state, "
            + "NULL AS rcs_mime_type, "
            + "NULL AS favourite,"
            + "NULL AS rcs_file_size,"
            + "NULL AS rcs_message_id,"
            + "NULL AS rcs_chat_type,";

    private static final String SMS_PROJECTION = "'sms' AS transport_type, _id, thread_id,"
            + "address, body, phone_id,"
            + RCS_SMS_PROJECTION
            + "date, date_sent, read, type,"
            + "status, locked, NULL AS error_code,"
            + "NULL AS sub, NULL AS sub_cs, date, date_sent, read,"
            + "NULL as m_type,"
            + "NULL AS msg_box,"
            + "NULL AS d_rpt, NULL AS rr, NULL AS err_type,"
            + "locked, NULL AS st, NULL AS text_only,"
            + "phone_id, NULL AS recipient_ids";

    private static final String MMS_PROJECTION = "'mms' AS transport_type, pdu._id, thread_id,"
            + "addr.address AS address, part.text as body, phone_id,"
            + RCS_OTHER_PROJECTION
            + "pdu.date * 1000 AS date, date_sent, read, NULL AS type,"
            + "NULL AS status, locked, NULL AS error_code,"
            + "sub, sub_cs, date, date_sent, read,"
            + "m_type,"
            + "pdu.msg_box AS msg_box,"
            + "d_rpt, rr, NULL AS err_type,"
            + "locked, NULL AS st, NULL AS text_only,"
            + "phone_id, NULL AS recipient_ids";

    private static final String MMS_PROJECTION_FOR_SUBJECT_SEARCH =
            "'mms' AS transport_type, pdu._id, thread_id,"
            + "addr.address AS address, pdu.sub as body, phone_id,"
            + RCS_OTHER_PROJECTION
            + "pdu.date * 1000 AS date, date_sent, read, NULL AS type,"
            + "NULL AS status, locked, NULL AS error_code,"
            + "sub, sub_cs, date, date_sent, read,"
            + "m_type,"
            + "pdu.msg_box AS msg_box,"
            + "d_rpt, rr, NULL AS err_type,"
            + "locked, NULL AS st, NULL AS text_only,"
            + "phone_id, NULL AS recipient_ids";

    private static final String MMS_PROJECTION_FOR_NUMBER_SEARCH =
            "'mms' AS transport_type, pdu._id, thread_id,"
            + "addr.address AS address, NULL AS body, phone_id,"
            + RCS_OTHER_PROJECTION
            + "pdu.date * 1000 AS date, date_sent, read, NULL AS type,"
            + "NULL AS status, locked, NULL AS error_code,"
            + "sub, sub_cs, date, date_sent, read,"
            + "m_type,"
            + "pdu.msg_box AS msg_box,"
            + "d_rpt, rr, NULL AS err_type,"
            + "locked, NULL AS st, NULL AS text_only,"
            + "phone_id, NULL AS recipient_ids";

    public static final String SMS_UPDATE_THREAD_RCS_MESSAGE_INFO_ON_NEW =
            "BEGIN " +
            "  UPDATE threads SET " + RcsColumns.ThreadColumns.RCS_CHAT_TYPE + " = " +
            "    (CASE WHEN " + RcsColumns.ThreadColumns.RCS_CHAT_TYPE + " != -1 " +
            "    THEN " + RcsColumns.ThreadColumns.RCS_CHAT_TYPE +" WHEN " +
                 RcsColumns.ThreadColumns.RCS_CHAT_TYPE + "= -1 AND new." +
                 RcsColumns.SmsRcsColumns.RCS_CHAT_TYPE + "!= -1 THEN new." +
                 RcsColumns.SmsRcsColumns.RCS_CHAT_TYPE + " ELSE "+
                 RcsColumns.ThreadColumns.RCS_CHAT_TYPE +
                 " END)," +
                 RcsColumns.ThreadColumns.RCS_NUMBER + " = " +
            "    (CASE WHEN new."+ RcsColumns.SmsRcsColumns.RCS_CHAT_TYPE + "= 1" +
            "    or new."+ RcsColumns.SmsRcsColumns.RCS_CHAT_TYPE +" = 2" +
            "    or new." + RcsColumns.SmsRcsColumns.RCS_CHAT_TYPE +"= 4 " +
            "    THEN new.address ELSE " + RcsColumns.ThreadColumns.RCS_NUMBER +
            "    END) " +
            "    WHERE threads._id = new." + Sms.THREAD_ID +
            "    AND new." + RcsColumns.SmsRcsColumns.RCS_MSG_TYPE +" != -1; " +
            "  UPDATE threads SET " + RcsColumns.ThreadColumns.RCS_MSG_ID + " = " +
            "    new." + Sms._ID + "," +
                 RcsColumns.ThreadColumns.RCS_MSG_TYPE +
            "    = new."+ RcsColumns.SmsRcsColumns.RCS_MSG_TYPE +
            "    WHERE threads . _id = new . thread_id;" +
            " END;";

    public static final String SMS_DELETE_DUPLICATE_RECORD_BEFORE_INSERT =
            "when new." + Sms.TYPE + "= 1 and new." + RcsColumns.SmsRcsColumns.RCS_MESSAGE_ID +
            "!= -1 and new." + RcsColumns.SmsRcsColumns.RCS_MESSAGE_ID + " IS NOT NULL " +
            " BEGIN  select raise(rollback,'') " +
            " where (select " + Sms._ID + " from sms where " +
            RcsColumns.SmsRcsColumns.RCS_MESSAGE_ID + " = new." +
            RcsColumns.SmsRcsColumns.RCS_MESSAGE_ID + " and " + Sms.TYPE +  "= 1 and "
            + Sms.SUBSCRIPTION_ID + " = new." + "sub_id)" +
            " is not null; END;";

    public final static String[] RCS_ICC_COLUMNS = new String[] {
        // N.B.: These columns must appear in the same order as the
        // calls to add appear in convertIccToSms.
        "service_center_address",       // getServiceCenterAddress
        "address",                      // getDisplayOriginatingAddress
        "message_class",                // getMessageClass
        "body",                         // getDisplayMessageBody
        "date",                         // getTimestampMillis
        "status",                       // getStatusOnIcc
        "index_on_icc",                 // getIndexOnIcc
        "is_status_report",             // isStatusReportMessage
        "transport_type",               // Always "sms".
        "type",                         // Always MESSAGE_TYPE_ALL.
        "locked",                       // Always 0 (false).
        "error_code",                   // Always 0
        "_id",
        "sub_id",
        //RCS column
        RcsColumns.SmsRcsColumns.RCS_FILENAME,
        RcsColumns.SmsRcsColumns.RCS_THUMB_PATH,
        RcsColumns.SmsRcsColumns.RCS_MSG_TYPE,
        RcsColumns.SmsRcsColumns.RCS_BURN,
        RcsColumns.SmsRcsColumns.RCS_MSG_STATE,
        RcsColumns.SmsRcsColumns.RCS_IS_DOWNLOAD,
        RcsColumns.SmsRcsColumns.RCS_MIME_TYPE,
        RcsColumns.SmsRcsColumns.RCS_FAVOURITE,
        RcsColumns.SmsRcsColumns.RCS_FILE_SIZE,
        RcsColumns.SmsRcsColumns.RCS_MESSAGE_ID,
        RcsColumns.SmsRcsColumns.RCS_CHAT_TYPE
    };

    // Those Strings are copied form TelephonyProvider,
    // should update when TelephonyProvider update.
    public static final String SMS_UPDATE_THREAD_READ_BODY =
            "  UPDATE threads SET read = " +
            "    CASE (SELECT COUNT(*)" +
            "          FROM sms" +
            "          WHERE " + Sms.READ + " = 0" +
            "            AND " + Sms.THREAD_ID + " = threads._id)" +
            "      WHEN 0 THEN 1" +
            "      ELSE 0" +
            "    END" +
            "  WHERE threads._id = new." + Sms.THREAD_ID + "; ";

    public static final String UPDATE_THREAD_COUNT_ON_NEW =
            "  UPDATE threads SET message_count = " +
            "     (SELECT COUNT(sms._id) FROM sms LEFT JOIN threads " +
            "      ON threads._id = " + Sms.THREAD_ID +
            "      WHERE " + Sms.THREAD_ID + " = new.thread_id" +
            "        AND sms." + Sms.TYPE + " != 3) + " +
            "     (SELECT COUNT(pdu._id) FROM pdu LEFT JOIN threads " +
            "      ON threads._id = " + Mms.THREAD_ID +
            "      WHERE " + Mms.THREAD_ID + " = new.thread_id" +
            "        AND (m_type=132 OR m_type=130 OR m_type=128)" +
            "        AND " + Mms.MESSAGE_BOX + " != 3) " +
            "  WHERE threads._id = new.thread_id; ";

    public static final String SMS_UPDATE_THREAD_DATE_SNIPPET_COUNT_ON_UPDATE =
            "BEGIN" +
            "  UPDATE threads SET" +
            "    date = (strftime('%s','now') * 1000), " +
            "    snippet = new." + Sms.BODY + ", " +
            "    snippet_cs = 0" +
            "  WHERE threads._id = new." + Sms.THREAD_ID + "; " +
            UPDATE_THREAD_COUNT_ON_NEW +
            SMS_UPDATE_THREAD_READ_BODY +
            "END;";

    public interface DeviceApiViews {
        public final String DEVICE_API_MESSAGES = "device_api_messages";
        public final String MESSAGE_CONVERSATION = "message_conversation";
        public final String PUBLIC_ACCOUNT_MESSAGES = "public_account_messages";
        public final String FILE_TRANSFER_MESSAGE = "file_transfer_message";
        public final String BLOCKED_CALLLOGS = "blocked_callog_view";
    }

    public final static String TABLE_SMS = "sms";

    public final static String TABLE_THREADS = "threads";

    private final static String TABLE_PDU = "pdu";

    private final static String FILE_TRANSFER_STATE =
            "(CASE WHEN " + Sms.TYPE + " = 2 AND " + RcsColumns.SmsRcsColumns.RCS_MSG_STATE
            + " = " + MessageConstants.CONST_STATUS_SENDING + " THEN "
            + DeviceApiConstant.FileTransferProvider.STARTED + " WHEN "
            + Sms.TYPE + " = 2 AND " + RcsColumns.SmsRcsColumns.RCS_MSG_STATE
            + " = " + MessageConstants.CONST_STATUS_SENDED
            + " OR " + RcsColumns.SmsRcsColumns.RCS_MSG_STATE
            + " = " + MessageConstants.CONST_STATUS_SEND_RECEIVED + " THEN "
            + DeviceApiConstant.FileTransferProvider.TRANSFERRED + " WHEN ("
            + Sms.TYPE + " = 2 OR " + Sms.TYPE + " = 5) AND "
            + RcsColumns.SmsRcsColumns.RCS_MSG_STATE
            + " = " + MessageConstants.CONST_STATUS_SEND_FAIL + " THEN "
            + DeviceApiConstant.FileTransferProvider.FAILED + " WHEN "
            + Sms.TYPE + " = 1 AND (" + RcsColumns.SmsRcsColumns.RCS_MSG_TYPE + " = "
            + MessageConstants.CONST_MESSAGE_IMAGE + " OR " + RcsColumns.SmsRcsColumns.RCS_MSG_TYPE
            + " = " + MessageConstants.CONST_MESSAGE_VIDEO + " ) AND "
            + RcsColumns.SmsRcsColumns.RCS_FILE_TRANSFERED + " = 0 " + " THEN "
            + DeviceApiConstant.FileTransferProvider.INVITED + " WHEN "
            + Sms.TYPE + " = 1 AND (" + RcsColumns.SmsRcsColumns.RCS_MSG_TYPE + " = "
            + MessageConstants.CONST_MESSAGE_IMAGE + " OR " + RcsColumns.SmsRcsColumns.RCS_MSG_TYPE
            + " = " + MessageConstants.CONST_MESSAGE_VIDEO + " ) AND "
            + RcsColumns.SmsRcsColumns.RCS_FILE_TRANSFERED + " = "
            + RcsColumns.SmsRcsColumns.RCS_FILE_SIZE + " THEN "
            + DeviceApiConstant.FileTransferProvider.TRANSFERRED + " WHEN "
            + Sms.TYPE + " = 1 AND (" + RcsColumns.SmsRcsColumns.RCS_MSG_TYPE + " = "
            + MessageConstants.CONST_MESSAGE_IMAGE + " OR " + RcsColumns.SmsRcsColumns.RCS_MSG_TYPE
            + " = " + MessageConstants.CONST_MESSAGE_VIDEO + " ) AND ("
            + RcsColumns.SmsRcsColumns.RCS_FILE_TRANSFERED + " < "
            + RcsColumns.SmsRcsColumns.RCS_FILE_SIZE + " AND "
            + RcsColumns.SmsRcsColumns.RCS_FILE_TRANSFERED + " > 0 ) THEN "
            + DeviceApiConstant.FileTransferProvider.STARTED + " WHEN "
            + Sms.TYPE + " = 1 AND (" + RcsColumns.SmsRcsColumns.RCS_MSG_TYPE + " <> "
            + MessageConstants.CONST_MESSAGE_IMAGE + " AND " + RcsColumns.SmsRcsColumns.RCS_MSG_TYPE
            + " <> " + MessageConstants.CONST_MESSAGE_VIDEO + " ) THEN "
            + DeviceApiConstant.FileTransferProvider.TRANSFERRED + " ELSE 0 END)";

    public static final String MESSAGE_CONVERSATION_VIEW_CLOUMNS =
            "select "
            + TABLE_THREADS + "." + Threads.SNIPPET
            + " as " + DeviceApiConstant.ChatProvider.BODY + ","
            + TABLE_THREADS + "." + Threads.DATE
            + " as " + DeviceApiConstant.ChatProvider.TIMESTAMP + ","
            + TABLE_THREADS + "." + Threads.MESSAGE_COUNT
            + " as " + DeviceApiConstant.ChatProvider.MESSAGE_COUNT + ","
            + "(select COUNT(*) FROM (select " + TABLE_SMS + "." + Sms.READ + " FROM "
            + TABLE_SMS + " inner join " + TABLE_THREADS + " on " + TABLE_SMS + "." + Sms.THREAD_ID
            + " = " + TABLE_THREADS + "." + Threads._ID + " WHERE " + TABLE_SMS + "." + Sms.READ
            + " = 0 " + " UNION ALL SELECT " + TABLE_PDU + "." + Mms.READ + " FROM " + TABLE_PDU
            + " inner join " + TABLE_THREADS + " on " + TABLE_PDU + "." + Mms.THREAD_ID + " = "
            + TABLE_THREADS + "." + Threads._ID +" WHERE " + TABLE_PDU + "." + Mms.READ + " = 0))"
            + " as " + DeviceApiConstant.ChatProvider.UNREAD_COUNT + ","
            + TABLE_THREADS + "." + RcsColumns.ThreadColumns.RCS_CHAT_TYPE
            + " as " + DeviceApiConstant.ChatProvider.FLAG + ","
            + "(CASE WHEN " + TABLE_THREADS + "." + RcsColumns.ThreadColumns.RCS_CHAT_TYPE + " = "
            + DeviceApiConstant.ChatProvider.OFFICIAL
            + " then NULL ELSE " + TABLE_THREADS + "." + Threads._ID + " END )"
            + " as " + DeviceApiConstant.ChatProvider.CONVERSATION_ID + ","
            + "(CASE WHEN " + TABLE_THREADS + "." + RcsColumns.ThreadColumns.RCS_CHAT_TYPE + " = "
            + DeviceApiConstant.ChatProvider.MTM
            + " THEN (select " + TABLE_SMS + "." + Sms.ADDRESS + " from " + TABLE_SMS
            + " where " + TABLE_THREADS + "." + Threads._ID + " = " + TABLE_SMS + "."
            + Sms.THREAD_ID + " AND " + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_CHAT_TYPE
            + " = " + DeviceApiConstant.ChatProvider.MTM + " AND "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MSG_TYPE + " = 7" + ") ELSE "
            + TABLE_SMS + "." + Sms.ADDRESS + " END)"
            + " as " + DeviceApiConstant.ChatProvider.RECIPIENTS + ","
            + "(CASE WHEN " + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_FILE_TRANSFER_ID
            + " >= 0 AND " + TABLE_THREADS + "." + RcsColumns.ThreadColumns.RCS_MSG_ID
            + "=" + TABLE_SMS + "." + Sms._ID + " THEN " + DeviceApiConstant.ChatProvider.FT
            +" ELSE (CASE WHEN "
            + TABLE_THREADS + "." + RcsColumns.ThreadColumns.RCS_CHAT_TYPE
            + " = " + DeviceApiConstant.ChatProvider.OFFICIAL + " THEN "
            + DeviceApiConstant.ChatProvider.XML + " ELSE (CASE WHEN "
            + TABLE_THREADS + "." + RcsColumns.ThreadColumns.RCS_CHAT_TYPE + " = "
            + DeviceApiConstant.ChatProvider.OTO + " OR "
            + TABLE_THREADS + "." + RcsColumns.ThreadColumns.RCS_CHAT_TYPE + " = "
            + DeviceApiConstant.ChatProvider.OTM + " OR "
            + TABLE_THREADS + "." + RcsColumns.ThreadColumns.RCS_CHAT_TYPE + " = "
            + DeviceApiConstant.ChatProvider.MTM
            + " THEN " + DeviceApiConstant.ChatProvider.IM + " ELSE "
            + DeviceApiConstant.ChatProvider.SMSMMS + " END)END)END)"
            + " as " + DeviceApiConstant.ChatProvider.TYPE + ","
            + "(CASE WHEN " + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_FILE_TRANSFER_ID
            + " >= 0 AND " + TABLE_THREADS + "." + RcsColumns.ThreadColumns.RCS_MSG_ID
            + "=" + TABLE_SMS + "." + Sms._ID + " THEN "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MIME_TYPE + " ELSE NULL END)"
            + " as " + DeviceApiConstant.ChatProvider.MIME_TYPE
            + " from " + TABLE_THREADS + " inner join " + TABLE_SMS + " on "
            + TABLE_THREADS + "." + RcsColumns.ThreadColumns.RCS_MSG_ID
            + " = " + TABLE_SMS + "." + Sms._ID + " and " + TABLE_SMS + "."
            + RcsColumns.SmsRcsColumns.RCS_MSG_TYPE + " <> 7";

    public static final String MESSAGES_VIEW_CLOUMN =
            "select "
            + TABLE_SMS + "." + Sms._ID + " as " + DeviceApiConstant.ChatProvider.MESSAGE_ID + ","
            + "(CASE WHEN " + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_CHAT_TYPE + " = "
            + DeviceApiConstant.ChatProvider.MTM + " THEN (select " + "a." + Sms.ADDRESS
            + " from " + TABLE_SMS + " a where " + "a." + Sms.THREAD_ID
            + " = " + TABLE_SMS + "." + Sms.THREAD_ID + " AND "
            + "a." + RcsColumns.SmsRcsColumns.RCS_MSG_TYPE + " = 7" + ") ELSE NULL END) "
            + " as " + DeviceApiConstant.ChatProvider.CHAT_ID + ","
            + TABLE_SMS + "." + Sms.DATE
            + " as " + DeviceApiConstant.ChatProvider.TIMESTAMP + ","
            + TABLE_SMS + "." + Sms.THREAD_ID
            + " as " + DeviceApiConstant.ChatProvider.CONVERSATION + ","
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_CHAT_TYPE
            + " as " + DeviceApiConstant.ChatProvider.FLAG + ","
            + " 0 " + " as " + DeviceApiConstant.ChatProvider.ISBLOCKED + ","
            + "(CASE WHEN " + TABLE_SMS + "." + Sms.TYPE + " = 1 THEN "
            + DeviceApiConstant.ChatProvider.INCOMING + " ELSE "
            + DeviceApiConstant.ChatProvider.OUTGOING
            + " END) as " + DeviceApiConstant.ChatProvider.DIRECTION + ","
            + "(CASE WHEN " + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_CHAT_TYPE + " = "
            + DeviceApiConstant.ChatProvider.MTM + " THEN "
            + " (select a." + Sms.ADDRESS + " from sms a where a." + Sms._ID + " = "
            + TABLE_SMS + "." + Sms._ID + " AND a." + RcsColumns.SmsRcsColumns.RCS_MSG_TYPE
            + " <> 7 ) " + " ELSE " + TABLE_SMS + "." + Sms.ADDRESS + " END) "
            + " as " + DeviceApiConstant.ChatProvider.CONTACT_NUMBER + ","
            + "(CASE WHEN " + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_FILE_TRANSFER_ID
            + " >= 0 THEN " + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_FILE_TRANSFER_ID
            + " ELSE (CASE WHEN " + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MESSAGE_ID
            + "  is not null THEN " + TABLE_SMS + "." + Sms.BODY + " ELSE NULL END)END)"
            + " as " + DeviceApiConstant.ChatProvider.BODY + ","
            + "(CASE WHEN " + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_FILE_TRANSFER_ID
            + " >= 0 THEN "+ DeviceApiConstant.ChatProvider.FT + " ELSE "
            + DeviceApiConstant.ChatProvider.IM + " END)"
            + " as " + DeviceApiConstant.ChatProvider.TYPE + ","
            + " (CASE WHEN " + TABLE_SMS + "." + Sms.TYPE + " = 1 AND "
            + TABLE_SMS + "." + Sms.READ + " = 0 THEN "
            + DeviceApiConstant.ChatProvider.UNREAD + " ELSE (CASE WHEN "
            + TABLE_SMS + "." + Sms.TYPE + " = 1 AND "
            + TABLE_SMS + "." + Sms.READ + " = 1 THEN " + DeviceApiConstant.ChatProvider.READ
            + " ELSE (CASE WHEN "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MESSAGE_ID + " is null AND "
            + TABLE_SMS + "." + Sms.TYPE + " = "+ Sms.MESSAGE_TYPE_QUEUED + " THEN "
            + DeviceApiConstant.ChatProvider.SENDING + " WHEN "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MESSAGE_ID + " is null AND "
            + TABLE_SMS + "." + Sms.TYPE + " = "+ Sms.MESSAGE_TYPE_SENT + " THEN "
            + DeviceApiConstant.ChatProvider.SENT + " WHEN "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MESSAGE_ID + " is null AND "
            + TABLE_SMS + "." + Sms.TYPE + " = "+ Sms.MESSAGE_TYPE_FAILED + " THEN "
            + DeviceApiConstant.ChatProvider.FAILED + " ELSE (CASE WHEN "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MESSAGE_ID + " is not null AND "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MSG_STATE + " = "
            + MessageConstants.CONST_STATUS_SENDING + " THEN "
            + DeviceApiConstant.ChatProvider.SENDING + " WHEN "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MESSAGE_ID + " is not null AND "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MSG_STATE + " = "
            + MessageConstants.CONST_STATUS_SENDED + " THEN "
            + DeviceApiConstant.ChatProvider.SENT + " WHEN "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MESSAGE_ID + " is not null AND "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MSG_STATE + " = "
            + MessageConstants.CONST_STATUS_SEND_FAIL + " THEN "
            + DeviceApiConstant.ChatProvider.FAILED + " WHEN "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MESSAGE_ID + " is not null AND "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MSG_STATE + " = "
            + MessageConstants.CONST_STATUS_SEND_RECEIVED + " THEN "
            + DeviceApiConstant.ChatProvider.DELIVERED + " ELSE "
            + DeviceApiConstant.ChatProvider.TO_SEND + " END)END)END)END)"
            + " as " + DeviceApiConstant.ChatProvider.MESSAGE_STATUS
            + " from " + TABLE_SMS + " WHERE " + TABLE_SMS + "."
            + RcsColumns.SmsRcsColumns.RCS_CHAT_TYPE + " in (1,2,3) and "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MSG_TYPE + " <> 7";

    public static final String PUBLIC_ACCOUNT_MESSAGES_VIEW_CLOUMN =
            "select "
            + TABLE_SMS + "." + Sms.ADDRESS
            + " as " + DeviceApiConstant.PublicAccountProvider.ACCOUNT + ","
            + TABLE_SMS + "." + Sms.BODY
            + " as " + DeviceApiConstant.PublicAccountProvider.BODY + ","
            + TABLE_SMS + "." + Sms.DATE
            + " as " + DeviceApiConstant.PublicAccountProvider.TIMESTAMP + ","
            + "(CASE WHEN " + TABLE_SMS + "." + Sms.TYPE + " = 1 THEN "
            + DeviceApiConstant.PublicAccountProvider.INCOMING + " ELSE "
            + DeviceApiConstant.PublicAccountProvider.OUTGOING
            + " END) as " + DeviceApiConstant.PublicAccountProvider.DIRECTION + ","
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MIME_TYPE
            + " as " + DeviceApiConstant.PublicAccountProvider.MIME_TYPE + ","
            + "(CASE WHEN " + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_FILE_TRANSFER_ID
            + " >= 0 THEN "+ DeviceApiConstant.PublicAccountProvider.FT + " ELSE "
            + DeviceApiConstant.PublicAccountProvider.XML+ " END)"
            + " as " + DeviceApiConstant.PublicAccountProvider.TYPE + ","
            + " (CASE WHEN " + TABLE_SMS + "." + Sms.TYPE + " = 1 AND "
            + TABLE_SMS + "." + Sms.READ + " = 0 THEN "
            + DeviceApiConstant.PublicAccountProvider.UNREAD + " ELSE (CASE WHEN "
            + TABLE_SMS + "." + Sms.TYPE + " = 1 AND "
            + TABLE_SMS + "." + Sms.READ + " = 1 THEN "
            + DeviceApiConstant.PublicAccountProvider.READ + " ELSE (CASE WHEN "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MESSAGE_ID + " is null AND "
            + TABLE_SMS + "." + Sms.TYPE + " = "+ Sms.MESSAGE_TYPE_QUEUED + " THEN "
            + DeviceApiConstant.PublicAccountProvider.SENDING + " WHEN "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MESSAGE_ID + " is null AND "
            + TABLE_SMS + "." + Sms.TYPE + " = "+ Sms.MESSAGE_TYPE_SENT + " THEN "
            + DeviceApiConstant.PublicAccountProvider.SENT + " WHEN "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MESSAGE_ID + " is null AND "
            + TABLE_SMS + "." + Sms.TYPE + " = "+ Sms.MESSAGE_TYPE_FAILED + " THEN "
            + DeviceApiConstant.PublicAccountProvider.FAILED + " ELSE (CASE WHEN "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MESSAGE_ID + " is not null AND "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MSG_STATE + " = "
            + MessageConstants.CONST_STATUS_SENDING + " THEN "
            + DeviceApiConstant.PublicAccountProvider.SENDING + " WHEN "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MESSAGE_ID + " is not null AND "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MSG_STATE + " = "
            + MessageConstants.CONST_STATUS_SENDED + " THEN "
            + DeviceApiConstant.PublicAccountProvider.SENT + " WHEN "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MESSAGE_ID + " is not null AND "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MSG_STATE + " = "
            + MessageConstants.CONST_STATUS_SEND_FAIL + " THEN "
            + DeviceApiConstant.PublicAccountProvider.FAILED + " WHEN "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MESSAGE_ID + " is not null AND "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MSG_STATE + " = "
            + MessageConstants.CONST_STATUS_SEND_RECEIVED + " THEN "
            + DeviceApiConstant.PublicAccountProvider.DELIVERED + " ELSE "
            + DeviceApiConstant.PublicAccountProvider.TO_SEND + " END)END)END)END)"
            + " as " + DeviceApiConstant.PublicAccountProvider.MESSAGE_STATUS + ","
            + "(CASE WHEN " + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_FILE_TRANSFER_ID
            + " >= 0 THEN "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_FILE_TRANSFER_ID + " ELSE "
            + TABLE_SMS + "." + Sms._ID + " END)"
            + " as " + DeviceApiConstant.PublicAccountProvider.MESSAGE_ID
            + " from " + TABLE_SMS + " WHERE "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_CHAT_TYPE
            + " = " + DeviceApiConstant.ChatProvider.OFFICIAL;

    public static final String FILE_TRANSFER_MESSAGE_VIEW_CLOUMN =
            "select "
            + TABLE_SMS + "." + Sms.DATE
            + " as " + DeviceApiConstant.FileTransferProvider.TIMESTAMP + ","
            + TABLE_SMS + "." + Sms.ADDRESS
            + " as " + DeviceApiConstant.FileTransferProvider.CONTACT_NUMBER + ","
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_FILE_TRANSFER_ID
            + " as " + DeviceApiConstant.FileTransferProvider.FT_ID + ","
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_FILENAME
            + " as " + DeviceApiConstant.FileTransferProvider.FILENAME + ","
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_THUMB_PATH
            + " as " + DeviceApiConstant.FileTransferProvider.FILEICON + ","
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_FILE_SIZE
            + " as " + DeviceApiConstant.FileTransferProvider.FILE_SIZE + ","
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_FILE_TRANSFERED
            + " as " + DeviceApiConstant.FileTransferProvider.TRANSFERRED_SIZE + ","
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_MIME_TYPE
            + " as " + DeviceApiConstant.FileTransferProvider.TYPE + ","
            + "(CASE WHEN " + TABLE_SMS + "." + Sms.TYPE + " = 1 THEN "
            + DeviceApiConstant.ChatProvider.INCOMING + " ELSE "
            + DeviceApiConstant.ChatProvider.OUTGOING
            + " END) as " + DeviceApiConstant.FileTransferProvider.DIRECTION + ","
            + FILE_TRANSFER_STATE
            + " as " + DeviceApiConstant.FileTransferProvider.STATE
            + " from " + TABLE_SMS + " WHERE "
            + TABLE_SMS + "." + RcsColumns.SmsRcsColumns.RCS_FILE_TRANSFER_ID + " >= 0 ";

    public static final String BLOCKED_CALLOG_CLOUMNS =
            "select "
            + " _id as " + DeviceApiConstant.BlacklistProvider.CALL_ID + ","
            + " contact as " + DeviceApiConstant.BlacklistProvider.PHONE_NUMBER + ","
            + " name as " + DeviceApiConstant.BlacklistProvider.NAME
            + " from blockrecorditems where block_type = 0";
}
