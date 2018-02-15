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

public interface DeviceApiConstant {
    public static interface ChatProvider {
        public static final int INCOMING = 0;

        public static final int OUTGOING = 1;

        public static final int UNREAD = 0;

        public static final int READ = 2;

        public static final int SENDING = 3;

        public static final int SENT = 4;

        public static final int FAILED = 5;

        public static final int TO_SEND = 6;
        public static final int DELIVERED = 7;

        public static final int OTO = 1;

        public static final int OTM = 2;

        public static final int MTM = 3;

        public static final int OFFICIAL = 4;
        public static final int SMSMMS = 0;
        public static final int SMS = 1;

        public static final int MMS = 2;

        public static final int IM = 3;

        public static final int FT = 5;

        public static final int XML = 4;

        public static final String MESSAGE_ID = "CHATMESSAGE_MESSAGE_ID";

        public static final String CHAT_ID = "CHATMESSAGE_CHAT_ID";

        public static final String CONTACT_NUMBER = "CHATMESSAGE_CONTACT_NUMBER";

        public static final String BODY = "CHATMESSAGE_BODY";

        public static final String TIMESTAMP = "CHATMESSAGE_TIMESTAMP";

        public static final String MIME_TYPE = "CHATMESSAGE_MIME_TYPE";

        public static final String MESSAGE_STATUS = "CHATMESSAGE_MESSAGE_STATUS";

        public static final String DIRECTION = "CHATMESSAGE_DIRECTION";

        public static final String TYPE = "CHATMESSAGE_TYPE";

        public static final String FLAG = "CHATMESSAGE_FLAG";

        public static final String FAVORITE = "CHATMESSAGE_FAVORITE";

        public static final String ISBLOCKED = "CHATMESSAGE_ISBLOCKED";

        public static final String CONVERSATION_ID = "CHATMESSAGE_CONVERSATION_ID";
        public static final String CONVERSATION = "CHATMESSAGE_CONVERSATION";
        public static final String UNREAD_COUNT = "CHATMESSAGE_UNREAD_COUNT";
        public static final String MESSAGE_COUNT = "CHATMESSAGE_MESSAGE_COUNT";
        //public static final String DELIVERED = "CHATMESSAGE_DELIVERED";
        public static final String FILENAME = "CHATMESSAGE_FILENAME";
        public static final String FILEICON = "CHATMESSAGE_FILEICON";
        public static final String FILESIZE  = "CHATMESSAGE_FILESIZE";
        public static final String RECIPIENTS = "CHATMESSAGE_RECIPIENTS";
    }

    public static interface CapabilityProvider {

        public final static String CONTACT_NUMBER = "CONTACT_NUMBER";

        public final static String CAPABILITY_IMAGE_SHARING = "CAPABILITY_IMAGE_SHARING";

        public final static String CAPABILITY_VIDEO_SHARING = "CAPABILITY_VIDEO_SHARING";

        public final static String CAPABILITY_IM_SESSION = "CAPABILITY_IM_SESSION";

        public final static String CAPABILITY_FILE_TRANSFER = "CAPABILITY_FILE_TRANSFER";

        public final static String CAPABILITY_GEOLOC_PUSH = "CAPABILITY_GEOLOC_PUSH";

        public final static String CAPABILITY_IP_VOICE_CALL = "CAPABILITY_IP_VOICE_CALL";

        public final static String CAPABILITY_IP_VIDEO_CALL = "CAPABILITY_IP_VIDEO_CALL";

        public final static String CAPABILITY_EXTENSIONS = "CAPABILITY_EXTENSIONS";
    }

    public static interface ProfileProvider {
        public final static String PHONE_NUMBER = "PROFILE_PHONENUMBER";

        public final static String FIRST_NAME = "PROFILE_FIRST_NAME";

        public final static String LAST_NAME = "PROFILE_LAST_NAME";

        public final static String PROTRAIT = "PROFILE_PORTRAIT";

        public final static String PROTRAIT_TYPE = "PROFILE_PORTRAIT_TYPE";

        public final static String ADDRESS = "PROFILE_ADDRESS";

        public final static String PHONE_NUMBER_SECOND = "PROFILE_PHONE_NUMBER_SECOND";

        public final static String EMAIL = "PROFILE_EMAIL";

        public final static String BIRTHDAY = "PROFILE_BIRTHDAY";

        public final static String COMPANY = "PROFILE_COMPANY";

        public final static String COMPANY_TEL = "PROFILE_COMPANY_TEL";

        public final static String TITLE = "PROFILE_TITLE";

        public final static String COMPANY_ADDR = "PROFILE_COMPANY_ADDR";

        public final static String COMPANY_FAX = "PROFILE_COMPANY_FAX";

        public final static String HOME1 = "PROFILE_HOME1";

        public final static String HOME2 = "PROFILE_HOME2";

        public final static String HOME3 = "PROFILE_HOME3";

        public final static String HOME4 = "PROFILE_HOME4";

        public final static String HOME5 = "PROFILE_HOME5";

        public final static String HOME6 = "PROFILE_HOME6";

        public final static String WORK1 = "PROFILE_WORK1";

        public final static String WORK2 = "PROFILE_WORK2";

        public final static String WORK3 = "PROFILE_WORK3";

        public final static String WORK4 = "PROFILE_WORK4";

        public final static String WORK5 = "PROFILE_WORK5";

        public final static String WORK6 = "PROFILE_WORK6";

        public final static String OTHER1 = "PROFILE_OTHER1";

        public final static String OTHER2 = "PROFILE_OTHER2";

        public final static String OTHER3 = "PROFILE_OTHER3";

        public final static String OTHER4 = "PROFILE_OTHER4";

        public final static String OTHER5 = "PROFILE_OTHER5";

        public final static String OTHER6 = "PROFILE_OTHER6";

        public final static String JPEG = "JPEG";

        public final static String BMP = "BMP";

        public final static String PNG = "PNG";

        public final static String GIF = "GIF";

        public final static String JPG = "JPG";
    }

    public static interface GroupChatProvider {
        public static final String CHAT_ID = "GROUPCHATSERVICE_CHAT_ID";

        public static final String STATE = "GROUPCHATSERVICE_STATE";

        public static final String SUBJECT = "GROUPCHATSERVICE_SUBJECT";

        public static final String CHAIRMEN = "GROUPCHATSERVICE_CHAIRMEN";

        public static final String NICK_NAME = "GROUPCHATSERVICE_NICK_NAME";

        public static final String TIME_STAMP = "GROUPCHATSERVICE_TIME_STAMP";

        public static final String DIRECTION = "GROUPCHATSERVICE_DIRECTION";

        public static final String PHONE_NUMBER = "GROUPCHATSERVICE_PHONE_NUMBER";

        public static final String MEMBER_NAME = "GROUPCHATSERVICE_MEMBER_NAME";

        public static final String PROTRAIT = "GROUPCHATSERVICE_PORTRAIT";

        public static final String PROTRAIT_TYPE = "GROUPCHATSERVICE_PORTRAIT_TYPE";

        public static final int INVITED = 1;

        public static final int INITIATED = 2;

        public static final int STARTED = 3;

        public static final int TERMINATED = 4;

        public static final int CLOSED_BY_USER = 5;

        public static final int ABORTED = 6;

        public static final int FAILED = 7;

    }

    public static interface PublicAccountProvider {
        public static final int UNREAD = 0;

        public static final int READ = 2;

        public static final int SENDING = 3;

        public static final int SENT = 4;

        public static final int FAILED = 5;

        public static final int TO_SEND = 6;

        public static final int DELIVERED = 7;

        public static final int INCOMING = 0;

        public static final int OUTGOING = 1;

        public static final int FT = 5;

        public static final int XML = 4;

        public static final String MESSAGE_ID = "PUBLICACCOUNTSERVICE_MESSAGE_ID";

        public static final String ACCOUNT = "PUBLICACCOUNTSERVICE_ACCOUNT";

        public static final String BODY = "PUBLICACCOUNTSERVICE_BODY";

        public static final String TIMESTAMP = "PUBLICACCOUNTSERVICE_TIMESTAMP";

        public static final String MIME_TYPE = "PUBLICACCOUNTSERVICE_MIME_TYPE";

        public static final String MESSAGE_STATUS = "PUBLICACCOUNTSERVICE_MESSAGE_STATUS";

        public static final String DIRECTION = "PUBLICACCOUNTSERVICE_DIRECTION";

        public static final String ID = "PUBLICACCOUNTSERVICE_ID";

        public static final String NAME = "PUBLICACCOUNTSERVICE_NAME";

        public static final String PORTRAIT = "PUBLICACCOUNTSERVICE_PORTRAIT";

        public static final String PORTRAIT_TYPE = "PUBLICACCOUNTSERVICE_PORTRAIT_TYPE";

        public static final String STATE = "PUBLICACCOUNTSERVICE_STATE";

        public static final String BRIEF_INTRODUCTION = "PUBLICACCOUNTSERVICE_BRIEF_INTRODUCTION";

        public static final String CONFIG = "PUBLICACCOUNTSERVICE_CONFIG";

        public static final String TYPE = "PUBLICACCOUNTSERVICE_TYPE";

        public static final String JPEG = "JPEG";

        public static final String BMP = "BMP";

        public static final String PNG = "PNG";

        public static final String GIF = "GIF";

    }

    public static interface BlacklistProvider {
        public static final String PHONE_NUMBER = "BLACKLIST_PHONE_NUMBER";

        public static final String NAME = "BLACKLIST_NAME";

        public static final String CALL_ID = "BLACKLIST_CALL_ID";
    }

    public static interface FileTransferProvider {
        public static final String FT_ID = "FT_ID";

        public static final String CONTACT_NUMBER = "CONTACT_NUMBER";

        public static final String FILENAME = "FILENAME";

        public static final String TYPE = "TYPE";

        public static final String FILEICON = "FILEICON";

        public static final String DIRECTION = "DIRECTION";

        public static final String FILE_SIZE = "FILE_SIZE";

        public static final String TRANSFERRED_SIZE = "TRANSFERRED";

        public static final String TIMESTAMP = "TIMESTAMP";

        public static final String STATE = "STATE";

        public final static int INVITED = 0;

        public final static int INITIATED = 1;

        public final static int STARTED = 2;

        public final static int TRANSFERRED = 3;

        public final static int ABORTED = 4;

        public final static int FAILED = 5;

        public final static int PAUSED = 6;
    }
}
