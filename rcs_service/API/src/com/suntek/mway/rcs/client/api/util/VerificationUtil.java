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

package com.suntek.mway.rcs.client.api.util;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;

import com.suntek.mway.rcs.client.aidl.constant.Constants.MessageConstants;
import com.suntek.mway.rcs.client.api.exception.FileDurationException;
import com.suntek.mway.rcs.client.api.exception.FileNotExistsException;
import com.suntek.mway.rcs.client.api.exception.FileSuffixException;
import com.suntek.mway.rcs.client.api.exception.FileTooLargeException;
import com.suntek.mway.rcs.client.api.exception.ServiceDisconnectedException;
import com.suntek.mway.rcs.client.api.log.LogHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class VerificationUtil {

    private static final String SIP_PREFIX = "sip:";

    private static final String TEL_PREFIX = "tel:";

    public static void ApiIsNull(Object api) throws ServiceDisconnectedException {
        if (api == null) {
            throw new ServiceDisconnectedException("Service unavailable, myApi is null");
        }
    }

    public static boolean isNumber(String number) {
        if (number == null) {
            return false;
        }
        return formatWith86(number).matches("[+86]\\d+");
    }

    public static boolean isAllNumber(List<String> numbers) {
        if (null == numbers || numbers.size() == 0) {
            return false;
        }

        boolean sign = true;
        for (String number : numbers) {
            if (!isNumber(number)) {
                sign = false;
            }
        }
        return sign;
    }

    public static String formatNumber(String number) {
        return VerificationUtil.formatWith86(VerificationUtil.getNumberFromUri(number))
                .replaceAll(" ", "").replaceAll("-", "");
    }

    public static List<String> formatNumbers(List<String> numbers) {
        List<String> re = new ArrayList<String>();
        if (numbers != null && numbers.size() > 0) {
            for (String number : numbers) {
                re.add(formatNumber(number));
            }
            Collections.sort(re);
        }
        return re;
    }

    public static String formatWithout86(String mobile) {
        String formatStr = mobile;
        if (formatStr != null) {
            formatStr = formatStr.replaceAll(" ", "");
            if (formatStr.startsWith("+86")) {
                formatStr = formatStr.substring(3);
            }
            if (formatStr.startsWith("86")) {
                formatStr = formatStr.substring(2);
            }
            if (formatStr.startsWith(" 86")) {
                formatStr = formatStr.substring(3);
            }
        }
        if (formatStr == null) {
            formatStr = "";
        }
        return formatStr.trim();
    }

    public static String formatWith86(String number) {
        number = formatWithout86(number);
        return "+86" + number;
    }

    public static String getNumberFromUri(String uriStr) {
        if (uriStr == null) {
            return "";
        }
        int index = uriStr.lastIndexOf("<");
        if (index != -1) {
            int index2 = uriStr.indexOf(">");
            if (index2 != -1) {
                uriStr = uriStr.substring(index + 1, index2);
            } else {
                uriStr = uriStr.substring(index + 1);
            }
        }
        if (uriStr.endsWith(">")) {
            uriStr = uriStr.substring(0, uriStr.length() - 1);
        }
        if (uriStr.startsWith(TEL_PREFIX)) {
            uriStr = uriStr.substring(4);
        } else if (uriStr.startsWith(SIP_PREFIX)) {
            uriStr = uriStr.substring(4, uriStr.indexOf("@"));
        }

        int pos = uriStr.indexOf("@");
        if (pos != -1) {
            uriStr = uriStr.substring(0, pos);
        }
        return uriStr;
    }

    public static String getNumberListString(List<String> numberList) {
        if (null == numberList || numberList.size() == 0) {
            return "";
        }

        StringBuffer sbBuffer = new StringBuffer();
        for (String number : numberList) {
            sbBuffer.append(number).append(",");
        }
        sbBuffer.deleteCharAt(sbBuffer.length() - 1);
        return sbBuffer.toString();
    }

    public static void isFileExists(String filePath) throws FileNotExistsException {
        if (!TextUtils.isEmpty(filePath)) {
            if (new File(filePath).exists()) {
                return;
            }
        }

        throw new FileNotExistsException();
    }

    public static void isImageFile(String fileName) throws FileSuffixException {
        boolean flag = false;
        int suffixIndex = fileName.lastIndexOf(".");
        if (suffixIndex != -1) {
            String suffix = fileName.substring(suffixIndex + 1);
            flag = isImageSuffix(suffix);
        } else {
            flag = false;
        }

        if (!flag) {
            throw new FileSuffixException("File extension is incorrect, the correct extension is '"
                    + MessageConstants.CONST_IMAGE_SUFFIX + "'");
        }
    }

    public static void isAudioFile(String fileName) throws FileSuffixException {
        boolean flag = false;
        if (TextUtils.isEmpty(fileName)) {
            flag = false;
        }

        int suffixIndex = fileName.lastIndexOf(".");
        if (suffixIndex != -1) {
            String suffix = fileName.substring(suffixIndex + 1);
            flag = isAudioSuffix(suffix);
        } else {
            flag = false;
        }

        if (!flag) {
            throw new FileSuffixException("File extension is incorrect, the correct extension is '"
                    + MessageConstants.CONST_AUDIO_SUFFIX + "'");
        }
    }

    public static void isVideoFile(String fileName) throws FileSuffixException {
        boolean flag = false;
        if (TextUtils.isEmpty(fileName)) {
            flag = false;
        }

        int suffixIndex = fileName.lastIndexOf(".");
        if (suffixIndex != -1) {
            String suffix = fileName.substring(suffixIndex + 1);
            flag = isVideoSuffix(suffix);
        } else {
            flag = false;
        }

        if (!flag) {
            throw new FileSuffixException("File extension is incorrect, the correct extension is '"
                    + MessageConstants.CONST_VIDEO_SUFFIX + "'");
        }
    }

    public static void isCloudFile(String filename) throws FileSuffixException {
        if (!isCloudFileAllowedFile(filename)) {
            throw new FileSuffixException(
                    "File extension is incorrect, the incorrect extension is '"
                            + MessageConstants.CONST_CLOUD_FILE_EXCLUDE_SUFFIX + "'");
        }
    }

    public static void isFileSizeToLarge(String filename, long maxSize)
            throws FileTooLargeException {
        File file = new File(filename);
        if (file.exists() && file.isFile() && file.length() > (maxSize * 1024)) {
            throw new FileTooLargeException("File too large " + (file.length() / 1024)
                    + " KB. Max size of file to be transfer is " + maxSize + " KB.");
        }
    }

    public static void isAudioDurationToLong(Context context, String filename, long maxDuration,
            int recordTime) throws FileDurationException {
        File file = new File(filename);
        if (file.exists() && file.isFile()) {
            int duration = getAmrFileDuration(context, file);
            if (duration >= (maxDuration + 1) * 1000 || recordTime >= (maxDuration + 1) * 1000) {
                LogHelper.i("throw FileDurationException, duration=" + duration);
                throw new FileDurationException("File duration too long " + duration
                        + " s. Max duration is " + maxDuration + " s.");
            }
        }
    }

    public static void isVideoDurationToLong(Context context, String filename, long maxDuration,
            int recordTime) throws FileDurationException {
        File file = new File(filename);
        if (file.exists() && file.isFile()) {
            int duration = getVideoFileDuration(context, file);
            if (duration >= (maxDuration + 1) * 1000 || recordTime >= (maxDuration + 1) * 1000) {
                LogHelper.i("throw FileDurationException, duration=" + duration);
                throw new FileDurationException("File duration too long " + duration
                        + " s. Max duration is " + maxDuration + " s.");
            }
        }
    }

    /**
     * Checks if is vcard file.
     *
     * @param fileName the file name
     * @return true, if is vcard file
     */
    public static void isVcardFile(String fileName) throws FileSuffixException {
        boolean flag = false;
        if (TextUtils.isEmpty(fileName)) {
            flag = false;
        }

        int suffixIndex = fileName.lastIndexOf(".");
        if (suffixIndex != -1) {
            String suffix = fileName.substring(suffixIndex + 1);
            flag = isVcardSuffix(suffix);
        } else {
            flag = false;
        }

        if (!flag) {
            throw new FileSuffixException("File extension is incorrect, the correct extension is '"
                    + MessageConstants.CONST_VCARD_SUFFIX + "'");
        }
    }

    /**
     * Checks if is video file.
     *
     * @param fileName the file name
     * @return true, if is video file
     */
    public static boolean isCloudFileAllowedFile(String fileName) {
        if (TextUtils.isEmpty(fileName)) {
            return false;
        }

        int suffixIndex = fileName.lastIndexOf(".");
        if (suffixIndex != -1) {
            String suffix = fileName.substring(suffixIndex + 1);
            return !isCloudFileExcludeSuffix(suffix);
        } else {
            return false;
        }
    }

    /**
     * Checks if is image suffix.
     *
     * @param suffix the suffix
     * @return true, if is image suffix
     */
    public static boolean isImageSuffix(String suffix) {
        if (TextUtils.isEmpty(suffix)) {
            return false;
        }

        return MessageConstants.CONST_IMAGE_SUFFIX.indexOf(
                suffix.toUpperCase(Locale.getDefault())) != -1;
    }

    /**
     * Checks if is audio suffix.
     *
     * @param suffix the suffix
     * @return true, if is audio suffix
     */
    public static boolean isAudioSuffix(String suffix) {
        if (TextUtils.isEmpty(suffix)) {
            return false;
        }

        return MessageConstants.CONST_AUDIO_SUFFIX.indexOf(
                suffix.toUpperCase(Locale.getDefault())) != -1;
    }

    /**
     * Checks if is video suffix.
     *
     * @param suffix the suffix
     * @return true, if is video suffix
     */
    public static boolean isVideoSuffix(String suffix) {
        if (TextUtils.isEmpty(suffix)) {
            return false;
        }

        return MessageConstants.CONST_VIDEO_SUFFIX.indexOf(
                suffix.toUpperCase(Locale.getDefault())) != -1;
    }

    /**
     * Checks if is vcard suffix.
     *
     * @param suffix the suffix
     * @return true, if is vcard suffix
     */
    public static boolean isVcardSuffix(String suffix) {
        if (TextUtils.isEmpty(suffix)) {
            return false;
        }

        return MessageConstants.CONST_VCARD_SUFFIX.indexOf(
                suffix.toUpperCase(Locale.getDefault())) != -1;
    }

    /**
     * Checks if is cloud file exclude suffix.
     *
     * @param suffix the suffix
     * @return true, if is cloud file exclude suffix
     */
    public static boolean isCloudFileExcludeSuffix(String suffix) {
        if (TextUtils.isEmpty(suffix)) {
            return false;
        }

        return MessageConstants.CONST_CLOUD_FILE_EXCLUDE_SUFFIX.indexOf(suffix.toUpperCase(Locale
                .getDefault())) != -1;
    }

    /**
     * Gets the amr file duration.
     *
     * @param context the context
     * @param file the file
     * @return the amr file duration
     */
    public static final int getAmrFileDuration(Context context, File file) {
        MediaPlayer mp = MediaPlayer.create(context, Uri.fromFile(file));
        int duration = mp.getDuration();
        mp.release();
        return duration;
    }

    /**
     * Gets the video file duration.
     *
     * @param context the context
     * @param file the file
     * @return the video file duration
     */
    public static final int getVideoFileDuration(Context context, File file) {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(file.getAbsolutePath());
            mediaPlayer.prepare();
            mediaPlayer.getDuration();
            int duration = mediaPlayer.getDuration();
            mediaPlayer.release();
            return duration;
        } catch (Exception e) {

        }
        return -1;
    }
}
