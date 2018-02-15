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

package com.suntek.mway.rcs.client.aidl.service.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class RCSCapabilities implements Parcelable, Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5516256269504150135L;

    /**
     * Image sharing support, "urn%3Aurn-7%3A3gpp-application.ims.iari.gsma-is"
     */
    // private boolean imageSharingSupported = false;

    /**
     * Video sharing support +g.3gpp.cs-voice
     */
    // private boolean videoSharingSupported = false;

    /**
     * IP voice call support "urn%3Aurn-7%3A3gpp-service.ims.icsi.mmtel"
     */
    // private boolean ipVoiceCallSupported = false;

    /**
     * IP video call support "urn%3Aurn-7%3A3gpp-service.ims.icsi.mmtel";video
     */
    // private boolean ipVideoCallSupported = false;

    /**
     * IM session support "urn%3Aurn-7%3A3gpp-service.ims.icsi.oma.cpm.session"
     */
    private boolean imSessionSupported = false;

    /**
     * File transfer support "urn%3Aurn-7%3A3gpp-application.ims.iari.rcse.ft"
     * "urn%3Aurn-7%3A3gppservice.ims.icsi.oma.cpm.filetransfer"
     */
    private boolean fileTransferSupported = false;

    /**
     * CS video support +g.3gpp.cs-voice
     */
    // private boolean csVideoSupported = false;

    /**
     * Presence discovery support
     * "urn%3Aurn-7%3A3gpp-application.ims.iari.rcse.dp"
     */
    // private boolean presenceDiscoverySupported = false;

    /**
     * Social presence support "urn%3Aurn-7%3A3gpp-application.ims.iari.rcse.sp"
     */
    // private boolean socialPresenceSupported = false;

    /**
     * File transfer over HTTP support
     * "urn%3Aurn-7%3A3gpp-application.ims.iari.rcs.fthttp"
     */
    // private boolean fileTransferHttpSupported = false;

    /**
     * Geolocation push support
     * "urn%3Aurn-7%3A3gpp-application.ims.iari.rcs.geopush"
     */
    private boolean geolocationPushSupported = false;

    /**
     * Geolocation pull support
     * "urn%3Aurn-7%3A3gpp-application.ims.iari.rcs.geopullft"
     */
    private boolean geolocationPullSupported = false;

    /**
     * File Transfer Thumbnail support
     * "urn%3Aurn-7%3A3gpp-application.ims.iari.rcs.ftthumb"
     */
    private boolean fileTransferThumbnailSupported = false;

    /**
     * File Transfer S&F "urn%3Aurn-7%3A3gpp-application.ims.iari.rcs.ftstandfw"
     */
    private boolean fileTransferStoreForwardSupported = false;

    /**
     * Group chat S&F
     * "urn%3Aurn-7%3A3gpp-application.ims.iari.rcs.fullsfgroupchat"
     */
    private boolean groupChatStoreForwardSupported = false;

    /**
     * SIP automata (@see RFC 3840) +g.oma.sip-im
     */
    //

    /**
     * page mode message
     */
    private boolean pageModeMsgSupported = false;

    /** large mode message. */
    private boolean largeModeMsgSupported = false;

    /** public message. */
    private boolean publicMsgSupported = false;

    /** vemotion. */
    private boolean vemotionSupported = false;

    /** cloudFile. */
    private boolean cloudFileSupported = false;

    /** cmcc. */
    private boolean cmccSupported = false;

    /** The burn after reading. */
    private boolean burnAfterReading = false;

    /** Last capabilities update. */
    private long timestamp = System.currentTimeMillis();

    /**
     * Constructor.
     */
    public RCSCapabilities() {
    }

    /**
     * Construct a new RCSCapabilities() with another specified instance of
     * RCSCapabilities.
     * @param source another instance of RCSCapabilities.
     */
    public RCSCapabilities(Parcel source) {
        // this.imageSharingSupported = source.readInt() != 0;
        // this.videoSharingSupported = source.readInt() != 0;
        // this.ipVoiceCallSupported = source.readInt() != 0;
        // this.ipVideoCallSupported = source.readInt() != 0;
        this.imSessionSupported = source.readInt() != 0;
        this.fileTransferSupported = source.readInt() != 0;
        // this.csVideoSupported = source.readInt() != 0;
        // this.presenceDiscoverySupported = source.readInt() != 0;
        // this.socialPresenceSupported = source.readInt() != 0;
        // this.fileTransferHttpSupported = source.readInt() != 0;
        this.geolocationPushSupported = source.readInt() != 0;
        this.geolocationPullSupported = source.readInt() != 0;
        this.fileTransferThumbnailSupported = source.readInt() != 0;
        this.fileTransferStoreForwardSupported = source.readInt() != 0;
        this.groupChatStoreForwardSupported = source.readInt() != 0;
        this.pageModeMsgSupported = source.readInt() != 0;
        this.largeModeMsgSupported = source.readInt() != 0;
        this.publicMsgSupported = source.readInt() != 0;
        this.vemotionSupported = source.readInt() != 0;
        this.cloudFileSupported = source.readInt() != 0;
        this.cmccSupported = source.readInt() != 0;
        this.burnAfterReading = source.readInt() != 0;
        // this.sipAutomata = source.readInt() != 0;
        this.timestamp = source.readLong();
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable's
     * marshalled representation.
     * @return Integer
     */
    public int describeContents() {
        return 0;
    }

    /**
     * Write parcelable object.
     * @param dest The Parcel in which the object should be written
     * @param flags Additional flags about how the object should be written
     */
    public void writeToParcel(Parcel dest, int flags) {
        // dest.writeInt(imageSharingSupported ? 1 : 0);
        // dest.writeInt(videoSharingSupported ? 1 : 0);
        // dest.writeInt(ipVoiceCallSupported ? 1 : 0);
        // dest.writeInt(ipVideoCallSupported ? 1 : 0);
        dest.writeInt(imSessionSupported ? 1 : 0);
        dest.writeInt(fileTransferSupported ? 1 : 0);
        // dest.writeInt(csVideoSupported ? 1 : 0);
        // dest.writeInt(presenceDiscoverySupported ? 1 : 0);
        // dest.writeInt(socialPresenceSupported ? 1 : 0);
        // dest.writeInt(fileTransferHttpSupported ? 1 : 0);
        dest.writeInt(geolocationPushSupported ? 1 : 0);
        dest.writeInt(geolocationPullSupported ? 1 : 0);
        dest.writeInt(fileTransferThumbnailSupported ? 1 : 0);
        dest.writeInt(fileTransferStoreForwardSupported ? 1 : 0);
        dest.writeInt(groupChatStoreForwardSupported ? 1 : 0);
        dest.writeInt(pageModeMsgSupported ? 1 : 0);
        dest.writeInt(largeModeMsgSupported ? 1 : 0);
        dest.writeInt(publicMsgSupported ? 1 : 0);
        dest.writeInt(vemotionSupported ? 1 : 0);
        dest.writeInt(cloudFileSupported ? 1 : 0);
        dest.writeInt(cmccSupported ? 1 : 0);
        dest.writeInt(burnAfterReading ? 1 : 0);
        // dest.writeInt(sipAutomata ? 1 : 0);
        dest.writeLong(timestamp);
    }

    /**
     * a fast way to get a Parcelable creator.
     */
    public static final Parcelable.Creator<RCSCapabilities> CREATOR =
            new Parcelable.Creator<RCSCapabilities>() {
        public RCSCapabilities createFromParcel(Parcel source) {
            return new RCSCapabilities(source);
        }

        public RCSCapabilities[] newArray(int size) {
            return new RCSCapabilities[size];
        }
    };

    /**
     * Is image sharing supported.
     * @return Boolean
     */
    /*
     * public boolean isImageSharingSupported() { return imageSharingSupported;
     * }
     */
    /**
     * Set the image sharing support
     * @param supported Supported
     */
    /*
     * public void setImageSharingSupported(boolean supported) {
     * this.imageSharingSupported = supported; }
     */
    /**
     * Is video sharing supported
     * @return Boolean
     */
    /*
     * public boolean isVideoSharingSupported() { return videoSharingSupported;
     * }
     */
    /**
     * Set the video sharing support
     * @param supported Supported
     */
    /*
     * public void setVideoSharingSupported(boolean supported) {
     * this.videoSharingSupported = supported; }
     */

    /**
     * Is IP voice call supported
     * @return Boolean
     */
    /*
     * public boolean isIpVoiceCallSupported() { return ipVoiceCallSupported; }
     */
    /**
     * Is IP video call supported
     * @return Boolean
     */
    /*
     * public boolean isIpVideoCallSupported() { return ipVideoCallSupported; }
     */
    /**
     * Set the IP voice call support
     * @param supported Supported
     */
    /*
     * public void setIpVoiceCallSupported(boolean supported) {
     * this.ipVoiceCallSupported = supported; }
     */
    /**
     * Set the IP video call support
     * @param supported Supported
     */
    /*
     * public void setIpVideoCallSupported(boolean supported) {
     * this.ipVideoCallSupported = supported; }
     */
    /**
     * Is IM session supported
     * @return Boolean
     */
    public boolean isImSessionSupported() {
        return imSessionSupported;
    }

    /**
     * Set the IM session support.
     * @param supported Supported
     */
    public void setImSessionSupported(boolean supported) {
        this.imSessionSupported = supported;
    }

    /**
     * Is file transfer supported.
     * @return Boolean
     */
    public boolean isFileTransferSupported() {
        return fileTransferSupported;
    }

    /**
     * Set the file transfer support.
     * @param supported Supported
     */
    public void setFileTransferSupported(boolean supported) {
        this.fileTransferSupported = supported;
    }

    /**
     * Is CS video supported.
     *
     * @return Boolean
     */
    /*
     * public boolean isCsVideoSupported() { return csVideoSupported; }
     */
    /**
     * Set the CS video support
     *
     * @param supported Supported
     */
    /*
     * public void setCsVideoSupported(boolean supported) {
     * this.csVideoSupported = supported; }
     */
    /**
     * Is presence discovery supported
     *
     * @return Boolean
     */
    /*
     * public boolean isPresenceDiscoverySupported() { return
     * presenceDiscoverySupported; }
     */

    /**
     * Set the presence discovery support
     *
     * @param supported Supported
     */
    /*
     * public void setPresenceDiscoverySupported(boolean supported) {
     * this.presenceDiscoverySupported = supported; }
     */

    /**
     * Is social presence supported
     *
     * @return Boolean
     */
    /*
     * public boolean isSocialPresenceSupported() { return
     * socialPresenceSupported; }
     */

    /**
     * Set the social presence support
     *
     * @param supported Supported
     */
    /*
     * public void setSocialPresenceSupported(boolean supported) {
     * this.socialPresenceSupported = supported; }
     */

    /**
     * Is file transfer over HTTP supported
     *
     * @return Boolean
     */
    /*
     * public boolean isFileTransferHttpSupported() { return
     * fileTransferHttpSupported; }
     */
    /**
     * Set the file transfer over HTTP support
     *
     * @param supported Supported
     */
    /*
     * public void setFileTransferHttpSupported(boolean supported) {
     * this.fileTransferHttpSupported = supported; }
     */
    /**
     * Is Geolocation Push supported
     * @return Boolean
     */
    public boolean isGeolocationPushSupported() {
        return geolocationPushSupported;
    }

    /**
     * Set the Geolocation Pull support.
     * @param supported Supported
     */
    public void setGeolocationPullSupported(boolean supported) {
        this.geolocationPullSupported = supported;
    }

    /**
     * Is Geolocation Pull supported.
     * @return Boolean
     */
    public boolean isGeolocationPullSupported() {
        return geolocationPullSupported;
    }

    /**
     * Set the Geolocation Push support.
     * @param supported Supported
     */
    public void setGeolocationPushSupported(boolean supported) {
        this.geolocationPushSupported = supported;
    }

    /**
     * Is file transfer thumbnail supported.
     * @return Boolean
     */
    public boolean isFileTransferThumbnailSupported() {
        return fileTransferThumbnailSupported;
    }

    /**
     * Set the file transfer thumbnail support.
     * @param supported Supported
     */
    public void setFileTransferThumbnailSupported(boolean supported) {
        this.fileTransferThumbnailSupported = supported;
    }

    /**
     * Is file transfer S&F supported.
     * @return Boolean
     */
    public boolean isFileTransferStoreForwardSupported() {
        return fileTransferStoreForwardSupported;
    }

    /**
     * Set the file transfer S&F support.
     * @param supported Supported
     */
    public void setFileTransferStoreForwardSupported(boolean supported) {
        this.fileTransferStoreForwardSupported = supported;
    }

    /**
     * Is group chat S&F supported.
     * @return Boolean
     */
    public boolean isGroupChatStoreForwardSupported() {
        return groupChatStoreForwardSupported;
    }

    /**
     * Set the group chat S&F support.
     * @param supported Supported
     */
    public void setGroupChatStoreForwardSupported(boolean supported) {
        this.groupChatStoreForwardSupported = supported;
    }

    /**
     * page mode message or not
     * @return
     */
    public boolean isPageModeMsgSupported() {
        return pageModeMsgSupported;
    }

    /**
     * Set page mode message.
     * @param pageModeMsg the new page mode msg supported
     */
    public void setPageModeMsgSupported(boolean pageModeMsg) {
        this.pageModeMsgSupported = pageModeMsg;
    }

    /**
     * large mode message or not.
     * @return true, if is large mode msg supported
     */
    public boolean isLargeModeMsgSupported() {
        return largeModeMsgSupported;
    }

    /**
     * set large mode message.
     * @param largeModeMsg the new large mode msg supported
     */
    public void setLargeModeMsgSupported(boolean largeModeMsg) {
        this.largeModeMsgSupported = largeModeMsg;
    }

    /**
     * public message or not.
     * @return true, if is public msg supported
     */
    public boolean isPublicMsgSupported() {
        return publicMsgSupported;
    }

    /**
     * set public message.
     * @param publicMsg the new public msg supported
     */
    public void setPublicMsgSupported(boolean publicMsg) {
        this.publicMsgSupported = publicMsg;
    }

    /**
     * ve motion or not.
     * @return true, if is vemotion supported
     */
    public boolean isVemotionSupported() {
        return vemotionSupported;
    }

    /**
     * set ve motion.
     * @param vemotion the new vemotion supported
     */
    public void setVemotionSupported(boolean vemotion) {
        this.vemotionSupported = vemotion;
    }

    /**
     * Checks if is cloud file supported.
     * @return true, if is cloud file supported
     */
    public boolean isCloudFileSupported() {
        return cloudFileSupported;
    }

    /**
     * Sets the cloud file supported.
     * @param cloudFileSupported the new cloud file supported
     */
    public void setCloudFileSupported(boolean cloudFileSupported) {
        this.cloudFileSupported = cloudFileSupported;
    }

    /**
     * group management(modify group name, kick people, transfer the group) nor
     * not.
     * @return true, if is cmcc supported
     */
    public boolean isCmccSupported() {
        return cmccSupported;
    }

    /**
     * set group management.
     * @param cmcc the new cmcc supported
     */
    public void setCmccSupported(boolean cmcc) {
        this.cmccSupported = cmcc;
    }

    /**
     * Checks is burn after reading.
     * @return true, if is burn after reading
     */
    public boolean isBurnAfterReading() {
        return burnAfterReading;
    }

    /**
     * Set burn after reading.
     * @param burnAfterReading the new burn after reading
     */
    public void setBurnAfterReading(boolean burnAfterReading) {
        this.burnAfterReading = burnAfterReading;
    }

    /**
     * Get the capabilities timestamp.
     * @return Timestamp (in milliseconds)
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Set capabilities timestamp.
     * @param timestamp the new timestamp
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}
