/*
 * Copyright (c) 2015 pci-suntektech Technologies, Inc.  All Rights Reserved.
 * pci-suntektech Technologies Proprietary and Confidential.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to
 * deal the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * THE SOFTWARE.
 */

package com.suntek.mway.rcs.client.api.message;

import android.os.RemoteException;
import android.text.TextUtils;

import com.suntek.mway.rcs.client.aidl.constant.Constants.MessageConstants;
import com.suntek.mway.rcs.client.aidl.plugin.entity.cloudfile.CloudFileMessage;
import com.suntek.mway.rcs.client.aidl.plugin.entity.pubacct.PublicMessage;
import com.suntek.mway.rcs.client.aidl.service.entity.SimpleMessage;
import com.suntek.mway.rcs.client.api.ServiceApi;
import com.suntek.mway.rcs.client.api.exception.FileDurationException;
import com.suntek.mway.rcs.client.api.exception.FileNotExistsException;
import com.suntek.mway.rcs.client.api.exception.FileSuffixException;
import com.suntek.mway.rcs.client.api.exception.FileTooLargeException;
import com.suntek.mway.rcs.client.api.exception.ServiceDisconnectedException;
import com.suntek.mway.rcs.client.api.log.LogHelper;
import com.suntek.mway.rcs.client.api.parse.CloudFileMessageParser;
import com.suntek.mway.rcs.client.api.parse.PublicMediaMessageParser;
import com.suntek.mway.rcs.client.api.parse.PublicTextMessageParser;
import com.suntek.mway.rcs.client.api.parse.PublicTopicMessageParser;
import com.suntek.mway.rcs.client.api.util.VerificationUtil;
import com.suntek.mway.rcs.client.api.util.XmlUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MessageApi {

    private static MessageApi instance;

    private MessageApi() {

    }

    public synchronized static MessageApi getInstance() {
        if (instance == null) {
            instance = new MessageApi();
        }
        return instance;
    }

    public void download(long id) throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().download(id);
    }

    public void complain(long id) throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().complain(id);
    }

    public void backupAll() throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().backupAll();
    }

    public void backUpFavouriteAll() throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().backUpFavouriteAll();
    }

    public void backup(List<SimpleMessage> simpleMessageList) throws RemoteException,
            ServiceDisconnectedException {
        ServiceApi.getServiceApi().backup(simpleMessageList);
    }

    public void burnAll() throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().burnAll();
    }

    public void burn(long id) throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().burn(id, 0);
    }

    public void burn(long id, int delaySeconds) throws RemoteException,
            ServiceDisconnectedException {
        ServiceApi.getServiceApi().burn(id, delaySeconds);
    }

    public void cancelBackup() throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().cancelBackup();
    }

    public void cancelCollect(List<SimpleMessage> simpleMessageList) throws RemoteException,
            ServiceDisconnectedException {
        ServiceApi.getServiceApi().cancelCollect(simpleMessageList);
    }

    public void cancelTopConversation(long threadId) throws RemoteException,
            ServiceDisconnectedException {
        ServiceApi.getServiceApi().cancelTopConversation(threadId);
    }

    public void collect(List<SimpleMessage> simpleMessageList) throws RemoteException,
            ServiceDisconnectedException {
        ServiceApi.getServiceApi().collect(simpleMessageList);
    }

    public long forward(long id, long threadId, String number, int barCycle)
            throws RemoteException, ServiceDisconnectedException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method forward. [id,threadId,number,barCycle]=%d,%d,%s,%d", id,
                threadId, number, barCycle));
        if (!VerificationUtil.isNumber(number)) {
            LogHelper.i("number field value error");
            return 0L;
        }
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }
        number = VerificationUtil.formatNumber(number);
        List<String> numberList = new ArrayList<String>();
        numberList.add(number);
        return ServiceApi.getServiceApi().forward(id, threadId, numberList, barCycle);
    }

    public long forward(long id, long threadId, List<String> numberList, int barCycle)
            throws RemoteException, ServiceDisconnectedException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method forward. [id,threadId,numberList,barCycle]=%d,%d,%s,%d", id,
                threadId, VerificationUtil.getNumberListString(numberList), barCycle));
        if (!VerificationUtil.isAllNumber(numberList)) {
            LogHelper.i("number field value error");
            return 0L;
        }
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }

        numberList = VerificationUtil.formatNumbers(numberList);
        return ServiceApi.getServiceApi().forward(id, threadId, numberList, barCycle);
    }

    public long forwardToGroupChat(long id, long threadId, long groupId) throws RemoteException,
            ServiceDisconnectedException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method forwardToGroupChat. [id,threadId,groupId]=%d,%d,%d", id,
                threadId, groupId));
        return ServiceApi.getServiceApi().forwardToGroupChat(id, threadId, groupId);
    }

    public long getThreadId(String number) throws RemoteException, ServiceDisconnectedException {
        LogHelper.i(String.format(Locale.getDefault(), "enter method getThreadId. [number]=%s",
                number));
        if (!VerificationUtil.isNumber(number)) {
            LogHelper.i("number field value error");
            return 0L;
        }
        number = VerificationUtil.formatNumber(number);
        List<String> numberList = new ArrayList<String>();
        numberList.add(number);
        return ServiceApi.getServiceApi().getThreadId(numberList);
    }

    public long getThreadId(List<String> numberList) throws RemoteException,
            ServiceDisconnectedException {
        LogHelper.i(String.format(Locale.getDefault(), "enter method getThreadId. [numberList]=%s",
                VerificationUtil.getNumberListString(numberList)));
        if (!VerificationUtil.isAllNumber(numberList)) {
            LogHelper.i("number field value error");
            return 0L;
        }
        numberList = VerificationUtil.formatNumbers(numberList);
        return ServiceApi.getServiceApi().getThreadId(numberList);
    }

    public long getThreadIdForPublicAccount(String publicAccountId) throws RemoteException,
            ServiceDisconnectedException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method getThreadId. [publicAccountId]=%s", publicAccountId));
        publicAccountId = VerificationUtil.getNumberFromUri(publicAccountId);
        if (!VerificationUtil.isNumber(publicAccountId)) {
            LogHelper.i("number field value error");
            return 0L;
        }
        List<String> numberList = new ArrayList<String>();
        numberList.add(publicAccountId);
        return ServiceApi.getServiceApi().getThreadId(numberList);
    }

    public int getAudioMaxDuration() throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().getAudioMaxDuration();
    }

    public long getImageMaxSize() throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().getImageMaxSize();
    }

    public int getVideoMaxDuration() throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().getVideoMaxDuration();
    }

    public long getVideoMaxSize() throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().getVideoMaxSize();
    }

    public int getRemindPolicy() throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().getRemindPolicy();
    }

    public int getSendPolicy() throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().getSendPolicy();
    }

    public void pauseDownload(long id) throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().pauseDownload(id);
    }

    public int recoverBlockedMessage(long blockedMessageId) throws RemoteException,
            ServiceDisconnectedException {
        return ServiceApi.getServiceApi().recoverBlockedMessage(blockedMessageId);
    }

    public int recoverBlockedMessageByThreadId(long threadId) throws RemoteException,
            ServiceDisconnectedException {
        return ServiceApi.getServiceApi().recoverBlockedMessageByThreadId(threadId);
    }

    public int deleteAllMessage() throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().deleteAllMessage();
    }

    public int deleteMessageByThreadId(long threadId) throws RemoteException,
            ServiceDisconnectedException {
        return ServiceApi.getServiceApi().deleteMessageByThreadId(threadId);
    }

    public int deleteMessage(long id) throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().deleteMessage(id);
    }

    public void restoreAll() throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().restoreAll();
    }

    public void restoreAllFavourite() throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().restoreAllFavourite();
    }

    public void startComposing(long threadId, String number, String contentType, int seconds)
            throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().startComposing(threadId, number, contentType, seconds);
    }

    public void stopComposing(long threadId, String number, String contentType, long lastActive)
            throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().stopComposing(threadId, number, contentType, lastActive);
    }

    public void resend(long id) throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().resend(id);
    }

    public long sendText(String number, long threadId, String text, int barCycle)
            throws RemoteException, ServiceDisconnectedException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method sendText. [number,threadId,text,barCycle]=%s,%d,%s,%d", number,
                threadId, text, barCycle));
        if ("".equals(text.trim())) {
            LogHelper.i("text value is null/Space");
            return 0L;
        }
        if (!VerificationUtil.isNumber(number)) {
            LogHelper.i("number field value error");
            return 0L;
        }
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }
        number = VerificationUtil.formatNumber(number);
        List<String> numberList = new ArrayList<String>();
        numberList.add(number);
        return ServiceApi.getServiceApi().sendText(numberList, threadId, text, barCycle);
    }

    public long sendText(List<String> numberList, long threadId, String text, int barCycle)
            throws RemoteException, ServiceDisconnectedException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method sendText. [numberList,threadId,text,barCycle]=%s,%d,%s,%d",
                VerificationUtil.getNumberListString(numberList), threadId, text, barCycle));
        if ("".equals(text.trim())) {
            LogHelper.i("text value is null/Space");
            return 0L;
        }
        if (!VerificationUtil.isAllNumber(numberList)) {
            LogHelper.i("number field value error");
            return 0L;
        }
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }

        numberList = VerificationUtil.formatNumbers(numberList);
        return ServiceApi.getServiceApi().sendText(numberList, threadId, text, barCycle);
    }

    public long sendImage(String number, long threadId, String filepath, int quality,
            boolean isRecord, int barCycle) throws RemoteException, ServiceDisconnectedException,
            FileSuffixException, FileNotExistsException, FileTooLargeException {
        return sendImage(number, threadId, filepath, quality,
                isRecord, barCycle, null);
    }

    public long sendImage(String number, long threadId, String filepath, int quality,
            boolean isRecord, int barCycle, String thumbnailPath) throws RemoteException,
            ServiceDisconnectedException, FileSuffixException, FileNotExistsException,
            FileTooLargeException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method sendImage. [number,threadId,filepath,quality,isRecord,barCycle" +
                ",thumbnailPath]=%s,%d,%s,%d,%b,%d,%s",
                        number, threadId, filepath, quality, isRecord, barCycle, thumbnailPath));
        if (!VerificationUtil.isNumber(number)) {
            LogHelper.i("number field value error");
            return 0L;
        }
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }
        if (quality < MessageConstants.CONST_MIN_QUALITY
                || quality > MessageConstants.CONST_MAX_QUALITY) {
            LogHelper.i("quality field value must be between " + MessageConstants.CONST_MIN_QUALITY
                    + " to " + MessageConstants.CONST_MAX_QUALITY);
            return 0L;
        }

        VerificationUtil.isImageFile(filepath);
        VerificationUtil.isFileExists(filepath);
        if (thumbnailPath != null) {
            VerificationUtil.isImageFile(thumbnailPath);
            VerificationUtil.isFileExists(thumbnailPath);
        }

        if (quality == MessageConstants.CONST_MAX_QUALITY) {
            VerificationUtil.isFileSizeToLarge(filepath, this.getImageMaxSize());
        }

        number = VerificationUtil.formatNumber(number);
        List<String> numberList = new ArrayList<String>();
        numberList.add(number);
        return ServiceApi.getServiceApi().sendImage(numberList, threadId, filepath, quality,
                isRecord, barCycle, thumbnailPath);
    }

    public long sendImage(List<String> numberList, long threadId, String filepath, int quality,
            boolean isRecord, int barCycle) throws RemoteException, ServiceDisconnectedException,
            FileSuffixException, FileNotExistsException, FileTooLargeException {
        return sendImage(numberList, threadId, filepath, quality,
                isRecord, barCycle, null);
    }

    public long sendImage(List<String> numberList, long threadId, String filepath, int quality,
            boolean isRecord, int barCycle, String thumbnailPath) throws RemoteException,
            ServiceDisconnectedException, FileSuffixException,
            FileNotExistsException, FileTooLargeException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method sendImage. [numberList,threadId,filepath,quality,isRecord,barCycle" +
                ",thumbnailPath]=%s,%d,%s,%d,%b,%d,%s",
                        VerificationUtil.getNumberListString(numberList), threadId, filepath,
                        quality, isRecord, barCycle, thumbnailPath));
        if (!VerificationUtil.isAllNumber(numberList)) {
            LogHelper.i("number field value error");
            return 0L;
        }
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }
        if (quality < MessageConstants.CONST_MIN_QUALITY
                || quality > MessageConstants.CONST_MAX_QUALITY) {
            LogHelper.i("quality field value must be between " + MessageConstants.CONST_MIN_QUALITY
                    + " to " + MessageConstants.CONST_MAX_QUALITY);
            return 0L;
        }

        VerificationUtil.isImageFile(filepath);
        VerificationUtil.isFileExists(filepath);
        if (thumbnailPath != null) {
            VerificationUtil.isImageFile(thumbnailPath);
            VerificationUtil.isFileExists(thumbnailPath);
        }
        if (quality == MessageConstants.CONST_MAX_QUALITY) {
            VerificationUtil.isFileSizeToLarge(filepath, this.getImageMaxSize());
        }

        numberList = VerificationUtil.formatNumbers(numberList);
        return ServiceApi.getServiceApi().sendImage(numberList, threadId, filepath, quality,
                isRecord, barCycle, thumbnailPath);
    }

    public long sendAudio(String number, long threadId, String filepath, int duration,
            boolean isRecord, int barCycle) throws RemoteException, ServiceDisconnectedException,
            FileSuffixException, FileNotExistsException, FileTooLargeException,
            FileDurationException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method sendAudio. [number,threadId,filepath,duration,isRecord,barCycle]="
                        + "%s,%d,%s,%d,%b,%d",
                        number, threadId, filepath, duration, isRecord, barCycle));
        if (!VerificationUtil.isNumber(number)) {
            LogHelper.i("number field value error");
            return 0L;
        }
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }

        VerificationUtil.isAudioFile(filepath);
        VerificationUtil.isFileExists(filepath);
        if (isRecord) {
            VerificationUtil.isAudioDurationToLong(ServiceApi.getInstance().getContext(),
                    filepath, this.getAudioMaxDuration(), duration);
        }
        VerificationUtil.isFileSizeToLarge(filepath, this.getVideoMaxSize());

        number = VerificationUtil.formatNumber(number);
        List<String> numberList = new ArrayList<String>();
        numberList.add(number);
        return ServiceApi.getServiceApi().sendAudio(numberList, threadId, filepath, duration,
                isRecord, barCycle);
    }

    public long sendAudio(List<String> numberList, long threadId, String filepath, int duration,
            boolean isRecord, int barCycle) throws RemoteException, ServiceDisconnectedException,
            FileSuffixException, FileNotExistsException, FileTooLargeException,
            FileDurationException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method sendAudio. [numberList,threadId,filepath,duration,isRecord,barCycle]"
                        + "=%s,%d,%s,%d,%b,%d",
                 VerificationUtil.getNumberListString(numberList), threadId, filepath,
                        duration, isRecord, barCycle));
        if (!VerificationUtil.isAllNumber(numberList)) {
            LogHelper.i("number field value error");
            return 0L;
        }
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }

        VerificationUtil.isAudioFile(filepath);
        VerificationUtil.isFileExists(filepath);
        if (isRecord) {
            VerificationUtil.isAudioDurationToLong(ServiceApi.getInstance().getContext(),
                    filepath, this.getAudioMaxDuration(), duration);
        }
        VerificationUtil.isFileSizeToLarge(filepath, this.getVideoMaxSize());

        numberList = VerificationUtil.formatNumbers(numberList);
        return ServiceApi.getServiceApi().sendAudio(numberList, threadId, filepath, duration,
                isRecord, barCycle);
    }

    public long sendVideo(String number, long threadId, String filepath, int duration,
            boolean isRecord, int barCycle) throws RemoteException, ServiceDisconnectedException,
            FileSuffixException, FileNotExistsException, FileTooLargeException,
            FileDurationException {
        return sendVideo(number, threadId, filepath, duration,
                isRecord, barCycle, null);
    }

    public long sendVideo(String number, long threadId, String filepath, int duration,
            boolean isRecord, int barCycle, String thumbnailPath) throws RemoteException,
            ServiceDisconnectedException, FileSuffixException, FileNotExistsException,
            FileTooLargeException, FileDurationException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method sendVideo. [number,threadId,filepath,duration,isRecord,barCycle" +
                ",thumbnailPath]=%s,%d,%s,%d,%b,%d,%s",
                        number, threadId, filepath, duration, isRecord, barCycle, thumbnailPath));
        if (!VerificationUtil.isNumber(number)) {
            LogHelper.i("number field value error");
            return 0L;
        }
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }

        VerificationUtil.isVideoFile(filepath);
        VerificationUtil.isFileExists(filepath);
        if (thumbnailPath != null) {
            VerificationUtil.isImageFile(thumbnailPath);
            VerificationUtil.isFileExists(thumbnailPath);
        }
        if (isRecord) {
            VerificationUtil.isVideoDurationToLong(ServiceApi.getInstance().getContext(),
                    filepath,this.getVideoMaxDuration(), duration);
        }
        VerificationUtil.isFileSizeToLarge(filepath, this.getVideoMaxSize());

        number = VerificationUtil.formatNumber(number);
        List<String> numberList = new ArrayList<String>();
        numberList.add(number);
        return ServiceApi.getServiceApi().sendVideo(numberList, threadId, filepath, duration,
                isRecord, barCycle, thumbnailPath);
    }

    public long sendVideo(List<String> numberList, long threadId, String filepath, int duration,
            boolean isRecord, int barCycle) throws RemoteException, ServiceDisconnectedException,
            FileSuffixException, FileNotExistsException, FileTooLargeException,
            FileDurationException {
        return sendVideo(numberList, threadId, filepath, duration,
                isRecord, barCycle, null);
    }

    public long sendVideo(List<String> numberList, long threadId, String filepath, int duration,
            boolean isRecord, int barCycle, String thumbnailPath) throws RemoteException,
            ServiceDisconnectedException, FileSuffixException, FileNotExistsException,
            FileTooLargeException, FileDurationException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method sendVideo. [numberList,threadId,filepath,duration,isRecord,barCycle" +
                ",thumbnailPath]=%s,%d,%s,%d,%b,%d,%s",
                        VerificationUtil.getNumberListString(numberList), threadId, filepath,
                        duration, isRecord, barCycle, thumbnailPath));
        if (!VerificationUtil.isAllNumber(numberList)) {
            LogHelper.i("number field value error");
            return 0L;
        }
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }

        VerificationUtil.isVideoFile(filepath);
        VerificationUtil.isFileExists(filepath);
        if (thumbnailPath != null) {
            VerificationUtil.isImageFile(thumbnailPath);
            VerificationUtil.isFileExists(thumbnailPath);
        }
        if (isRecord) {
            VerificationUtil.isVideoDurationToLong(ServiceApi.getInstance().getContext(), filepath,
                    this.getVideoMaxDuration(), duration);
        }
        VerificationUtil.isFileSizeToLarge(filepath, this.getVideoMaxSize());

        numberList = VerificationUtil.formatNumbers(numberList);
        return ServiceApi.getServiceApi().sendVideo(numberList, threadId, filepath, duration,
                isRecord, barCycle, thumbnailPath);
    }

    public long sendLocation(String number, long threadId, double lat, double lng, String label,
            int barCycle) throws RemoteException, ServiceDisconnectedException {
        LogHelper
                .i(String.format(
                        Locale.getDefault(),
                        "enter method sendLocation. [number,threadId,lat,lng,text,barCycle]="
                        + "%s,%d,%f,%f,%s,%d",
                        number, threadId, lat, lng, label, barCycle));
        if (!VerificationUtil.isNumber(number)) {
            LogHelper.i("number field value error");
            return 0L;
        }
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }

        number = VerificationUtil.formatNumber(number);
        List<String> numberList = new ArrayList<String>();
        numberList.add(number);
        return ServiceApi.getServiceApi().sendLocation(numberList, threadId, lat, lng, label,
                barCycle);
    }

    public long sendLocation(List<String> numberList, long threadId, double lat, double lng,
            String label, int barCycle) throws RemoteException, ServiceDisconnectedException {
        LogHelper
                .i(String.format(
                        Locale.getDefault(),
                        "enter method sendLocation. [numberList,threadId,lat,lng,text,barCycle]="
                        + "%s,%d,%f,%f,%s,%d",
                        VerificationUtil.getNumberListString(numberList), threadId, lat, lng,
                        label, barCycle));
        if (!VerificationUtil.isAllNumber(numberList)) {
            LogHelper.i("number field value error");
            return 0L;
        }
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }

        numberList = VerificationUtil.formatNumbers(numberList);
        return ServiceApi.getServiceApi().sendLocation(numberList, threadId, lat, lng, label,
                barCycle);
    }

    public long sendVcard(String number, long threadId, String filepath, int barCycle)
            throws RemoteException, ServiceDisconnectedException, FileSuffixException,
            FileNotExistsException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method sendVcard. [number,threadId,filepath,barCycle]=%s,%d,%s,%d", number,
                threadId, filepath, barCycle));
        if (!VerificationUtil.isNumber(number)) {
            LogHelper.i("number field value error");
            return 0L;
        }
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }
        VerificationUtil.isVcardFile(filepath);
        VerificationUtil.isFileExists(filepath);

        number = VerificationUtil.formatNumber(number);
        List<String> numberList = new ArrayList<String>();
        numberList.add(number);
        return ServiceApi.getServiceApi().sendVcard(numberList, threadId, filepath, barCycle);
    }

    public long sendVcard(List<String> numberList, long threadId, String filepath, int barCycle)
            throws RemoteException, ServiceDisconnectedException, FileSuffixException,
            FileNotExistsException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method sendVcard. [numberList,threadId,filepath,barCycle]=%s,%d,%s,%d",
                VerificationUtil.getNumberListString(numberList), threadId, filepath, barCycle));
        if (!VerificationUtil.isAllNumber(numberList)) {
            LogHelper.i("number field value error");
            return 0L;
        }
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }
        VerificationUtil.isVcardFile(filepath);
        VerificationUtil.isFileExists(filepath);

        numberList = VerificationUtil.formatNumbers(numberList);
        return ServiceApi.getServiceApi().sendVcard(numberList, threadId, filepath, barCycle);
    }

    public long sendTextToGroupChat(long groupId, long threadId, String text)
            throws RemoteException, ServiceDisconnectedException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method sendTextToGroupChat. [groupId,threadId,text]=%d,%d,%s", groupId,
                threadId, text));
        if ("".equals(text.trim())) {
            LogHelper.i("text value is null/Space");
            return 0L;
        }

        return ServiceApi.getServiceApi().sendTextToGroupChat(groupId, threadId, text);
    }

    public long sendImageToGroupChat(long groupId, long threadId, String filepath, int quality,
            boolean isRecord) throws RemoteException, ServiceDisconnectedException,
            FileSuffixException, FileNotExistsException, FileTooLargeException {
        return sendImageToGroupChat(groupId, threadId, filepath,
                quality, isRecord, null);
    }

    public long sendImageToGroupChat(long groupId, long threadId, String filepath, int quality,
            boolean isRecord, String thumbnailPath) throws RemoteException,
            ServiceDisconnectedException, FileSuffixException, FileNotExistsException,
            FileTooLargeException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method sendImageToGroupChat. [groupId,threadId,filepath,quality,isRecord" +
                ",thumbnailPath]=%d,%d,%s,%d,%b,%s",
                        groupId, threadId, filepath, quality, isRecord, thumbnailPath));
        if (quality < MessageConstants.CONST_MIN_QUALITY
                || quality > MessageConstants.CONST_MAX_QUALITY) {
            LogHelper.i("quality field value must be between " + MessageConstants.CONST_MIN_QUALITY
                    + " to " + MessageConstants.CONST_MAX_QUALITY);
            return 0L;
        }

        VerificationUtil.isImageFile(filepath);
        VerificationUtil.isFileExists(filepath);
        if (thumbnailPath != null) {
            VerificationUtil.isImageFile(thumbnailPath);
            VerificationUtil.isFileExists(thumbnailPath);
        }
        if (quality == MessageConstants.CONST_MAX_QUALITY) {
            VerificationUtil.isFileSizeToLarge(filepath, this.getImageMaxSize());
        }

        return ServiceApi.getServiceApi().sendImageToGroupChat(groupId, threadId, filepath,
                quality, isRecord, thumbnailPath);
    }

    public long sendAudioToGroupChat(long groupId, long threadId, String filepath, int duration,
            boolean isRecord) throws RemoteException, ServiceDisconnectedException,
            FileSuffixException, FileNotExistsException, FileTooLargeException,
            FileDurationException {
        LogHelper.i(String.format(Locale.getDefault(),
             "enter method sendAudioToGroupChat. [groupId,threadId,filepath,duration,isRecord]="
                     + "%d,%d,%s,%d,%b",
                        groupId, threadId, filepath, duration, isRecord));
        VerificationUtil.isAudioFile(filepath);
        VerificationUtil.isFileExists(filepath);
        if (isRecord) {
            VerificationUtil.isAudioDurationToLong(ServiceApi.getInstance().getContext(),
                    filepath, this.getAudioMaxDuration(), duration);
        }
        VerificationUtil.isFileSizeToLarge(filepath, this.getVideoMaxSize());

        return ServiceApi.getServiceApi().sendAudioToGroupChat(groupId, threadId, filepath,
                duration, isRecord);
    }

    public long sendVideoToGroupChat(long groupId, long threadId, String filepath, int duration,
            boolean isRecord) throws RemoteException, ServiceDisconnectedException,
            FileSuffixException, FileNotExistsException, FileTooLargeException,
            FileDurationException {
        return sendVideoToGroupChat(groupId, threadId, filepath,
                duration, isRecord, null);
    }

    public long sendVideoToGroupChat(long groupId, long threadId, String filepath, int duration,
            boolean isRecord, String thumbnailPath) throws RemoteException,
            ServiceDisconnectedException, FileSuffixException, FileNotExistsException,
            FileTooLargeException, FileDurationException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method sendVideoToGroupChat. [groupId,threadId,filepath,duration,isRecord" +
                ",thumbnailPath]=%d,%d,%s,%d,%b,%s",
                        groupId, threadId, filepath, duration, isRecord, thumbnailPath));
        VerificationUtil.isVideoFile(filepath);
        VerificationUtil.isFileExists(filepath);
        if (thumbnailPath != null) {
            VerificationUtil.isImageFile(thumbnailPath);
            VerificationUtil.isFileExists(thumbnailPath);
        }
        if (isRecord) {
            VerificationUtil.isVideoDurationToLong(ServiceApi.getInstance().getContext(),
                    filepath, this.getVideoMaxDuration(), duration);
        }
        VerificationUtil.isFileSizeToLarge(filepath, this.getVideoMaxSize());

        return ServiceApi.getServiceApi().sendVideoToGroupChat(groupId, threadId, filepath,
                duration, isRecord, thumbnailPath);
    }

    public long sendLocationToGroupChat(long groupId, long threadId, double lat, double lng,
            String label) throws RemoteException, ServiceDisconnectedException {
        LogHelper.i(String.format(Locale.getDefault(),
            "enter method sendLocationToGroupChat. [groupId,threadId,lat,lng,text,barCycle]="
                    + "%d,%d,%f,%f,%s",
                        groupId, threadId, lat, lng, label));
        return ServiceApi.getServiceApi().sendLocationToGroupChat(groupId, threadId, lat, lng,
                label);
    }

    public long sendVcardToGroupChat(long groupId, long threadId, String filepath)
            throws RemoteException, ServiceDisconnectedException, FileSuffixException,
            FileNotExistsException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method sendVcardToGroupChat. [groupId,threadId,filepath]=%d,%d,%s",
                groupId, threadId, filepath));
        VerificationUtil.isVcardFile(filepath);
        VerificationUtil.isFileExists(filepath);

        return ServiceApi.getServiceApi().sendVcardToGroupChat(groupId, threadId, filepath);
    }

    public long sendTextToPc(long threadId, String text, int barCycle)
            throws RemoteException, ServiceDisconnectedException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method sendTextToPc. [threadId,text,barCycle]=%d,%s,%d",
                threadId, text, barCycle));
        if ("".equals(text.trim())) {
            LogHelper.i("text value is null/Space");
            return 0L;
        }
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }
        return ServiceApi.getServiceApi().sendTextToPc(threadId, text, barCycle);
    }

    public long sendImageToPc(long threadId, String filepath, int quality,
            boolean isRecord, int barCycle) throws RemoteException, ServiceDisconnectedException,
            FileSuffixException, FileNotExistsException, FileTooLargeException {
        return sendImageToPc(threadId, filepath, quality,
                isRecord, barCycle, null);
    }

    public long sendImageToPc(long threadId, String filepath, int quality,
            boolean isRecord, int barCycle, String thumbnailPath) throws RemoteException,
            ServiceDisconnectedException, FileSuffixException, FileNotExistsException,
            FileTooLargeException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method sendImageToPc. [threadId,filepath,quality,isRecord,barCycle" +
                ",thumbnailPath]=%d,%s,%d,%b,%d,%s",
                        threadId, filepath, quality, isRecord, barCycle, thumbnailPath));
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }
        if (quality < MessageConstants.CONST_MIN_QUALITY
                || quality > MessageConstants.CONST_MAX_QUALITY) {
            LogHelper.i("quality field value must be between " + MessageConstants.CONST_MIN_QUALITY
                    + " to " + MessageConstants.CONST_MAX_QUALITY);
            return 0L;
        }

        VerificationUtil.isImageFile(filepath);
        VerificationUtil.isFileExists(filepath);
        if (thumbnailPath != null) {
            VerificationUtil.isImageFile(thumbnailPath);
            VerificationUtil.isFileExists(thumbnailPath);
        }

        if (quality == MessageConstants.CONST_MAX_QUALITY) {
            VerificationUtil.isFileSizeToLarge(filepath, this.getImageMaxSize());
        }

        return ServiceApi.getServiceApi().sendImageToPc(threadId, filepath, quality,
                isRecord, barCycle, thumbnailPath);
    }

    public long sendAudioToPc(long threadId, String filepath, int duration,
            boolean isRecord, int barCycle) throws RemoteException, ServiceDisconnectedException,
            FileSuffixException, FileNotExistsException, FileTooLargeException,
            FileDurationException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method sendAudioToPc. [threadId,filepath,duration,isRecord,barCycle]"
                        + "=%d,%s,%d,%b,%d",
                 threadId, filepath, duration, isRecord, barCycle));
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }

        VerificationUtil.isAudioFile(filepath);
        VerificationUtil.isFileExists(filepath);
        if (isRecord) {
            VerificationUtil.isAudioDurationToLong(ServiceApi.getInstance().getContext(),
                    filepath, this.getAudioMaxDuration(), duration);
        }
        VerificationUtil.isFileSizeToLarge(filepath, this.getVideoMaxSize());

        return ServiceApi.getServiceApi().sendAudioToPc(threadId, filepath, duration,
                isRecord, barCycle);
    }

    public long sendVideoToPc(long threadId, String filepath, int duration,
            boolean isRecord, int barCycle) throws RemoteException, ServiceDisconnectedException,
            FileSuffixException, FileNotExistsException, FileTooLargeException,
            FileDurationException {
        return sendVideoToPc(threadId, filepath, duration,
                isRecord, barCycle, null);
    }

    public long sendVideoToPc(long threadId, String filepath, int duration,
            boolean isRecord, int barCycle, String thumbnailPath) throws RemoteException,
            ServiceDisconnectedException, FileSuffixException, FileNotExistsException,
            FileTooLargeException, FileDurationException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method sendVideoToPc. [threadId,filepath,duration,isRecord,barCycle" +
                ",thumbnailPath]=%d,%s,%d,%b,%d,%s",
                        threadId, filepath, duration, isRecord, barCycle, thumbnailPath));
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }

        VerificationUtil.isVideoFile(filepath);
        VerificationUtil.isFileExists(filepath);
        if (thumbnailPath != null) {
            VerificationUtil.isImageFile(thumbnailPath);
            VerificationUtil.isFileExists(thumbnailPath);
        }
        if (isRecord) {
            VerificationUtil.isVideoDurationToLong(ServiceApi.getInstance().getContext(),
                    filepath,this.getVideoMaxDuration(), duration);
        }
        VerificationUtil.isFileSizeToLarge(filepath, this.getVideoMaxSize());

        return ServiceApi.getServiceApi().sendVideoToPc(threadId, filepath, duration,
                isRecord, barCycle, thumbnailPath);
    }

    public long sendLocationToPc(long threadId, double lat, double lng, String label,
            int barCycle) throws RemoteException, ServiceDisconnectedException {
        LogHelper
                .i(String.format(
                        Locale.getDefault(),
                        "enter method sendLocationToPc. [threadId,lat,lng,text,barCycle]="
                        + "%d,%f,%f,%s,%d",
                        threadId, lat, lng, label, barCycle));
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }

        return ServiceApi.getServiceApi().sendLocationToPc(threadId, lat, lng, label, barCycle);
    }

    public long sendVcardToPc(long threadId, String filepath, int barCycle)
            throws RemoteException, ServiceDisconnectedException, FileSuffixException,
            FileNotExistsException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method sendVcardToPc. [threadId,filepath,barCycle]=%d,%s,%d",
                threadId, filepath, barCycle));
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }
        VerificationUtil.isVcardFile(filepath);
        VerificationUtil.isFileExists(filepath);

        return ServiceApi.getServiceApi().sendVcardToPc(threadId, filepath, barCycle);
    }

    public void setRemindPolicy(int policy) throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().setRemindPolicy(policy);
    }

    public void setSendPolicy(int policy) throws RemoteException, ServiceDisconnectedException {
        ServiceApi.getServiceApi().setSendPolicy(policy);
    }

    public int topConversation(long threadId) throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().topConversation(threadId);
    }

    public int markMessageAsReaded(long id) throws RemoteException, ServiceDisconnectedException {
        return ServiceApi.getServiceApi().markMessageAsReaded(id);
    }

    // emoticon
    public long sendEmoticon(String number, long threadId, String emoticonId, String emoticonName,
            int barCycle) throws RemoteException, ServiceDisconnectedException {
        LogHelper.i(String.format(Locale.getDefault(),
            "enter method sendEmoticon. [number,threadId,emoticonId,emoticonName,barCycle]="
                    + "%s,%d,%s,%s,%d",
                        number, threadId, emoticonId, emoticonName, barCycle));
        if (!VerificationUtil.isNumber(number)) {
            LogHelper.i("number field value error");
            return 0L;
        }
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }
        if (TextUtils.isEmpty(emoticonId) || TextUtils.isEmpty(emoticonName)) {
            LogHelper.i("emoticonId or emoticonName is empty");
            return 0L;
        }

        List<String> numberList = new ArrayList<String>();
        numberList.add(number);
        return ServiceApi.getServiceApi().sendEmoticon(numberList, threadId, emoticonId,
                emoticonName, barCycle);
    }

    public long sendEmoticon(List<String> numberList, long threadId, String emoticonId,
            String emoticonName, int barCycle)
                    throws RemoteException, ServiceDisconnectedException {
        LogHelper.i(String.format(Locale.getDefault(),
            "enter method sendEmoticon. [numberList,threadId,emoticonId,emoticonName,barCycle]="
                    + "%s,%d,%s,%s,%d",
                        VerificationUtil.getNumberListString(numberList), threadId, emoticonId,
                        emoticonName, barCycle));
        if (!VerificationUtil.isAllNumber(numberList)) {
            LogHelper.i("number field value error");
            return 0L;
        }
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }
        if (TextUtils.isEmpty(emoticonId) || TextUtils.isEmpty(emoticonName)) {
            LogHelper.i("emoticonId or emoticonName is empty");
            return 0L;
        }

        return ServiceApi.getServiceApi().sendEmoticon(numberList, threadId, emoticonId,
                emoticonName, barCycle);
    }

    public long sendEmoticonToGroupChat(long groupId, long threadId, String emoticonId,
            String emoticonName) throws RemoteException, ServiceDisconnectedException {
        LogHelper.i(String.format(Locale.getDefault(),
             "enter method sendEmoticonToGroupChat. [groupId,threadId,emoticonId,emoticonName]="
                     + "%d,%d,%s,%s",
                        groupId, threadId, emoticonId, emoticonName));
        if (TextUtils.isEmpty(emoticonId) || TextUtils.isEmpty(emoticonName)) {
            LogHelper.i("emoticonId or emoticonName is empty");
            return 0L;
        }

        return ServiceApi.getServiceApi().sendEmoticonToGroupChat(groupId, threadId, emoticonId,
                emoticonName);
    }

    public long sendEmoticonToPc(long threadId, String emoticonId, String emoticonName,
            int barCycle) throws RemoteException, ServiceDisconnectedException {
        LogHelper.i(String.format(Locale.getDefault(),
            "enter method sendEmoticonToPc. [threadId,emoticonId,emoticonName,barCycle]="
                    + "%d,%s,%s,%d",
                        threadId, emoticonId, emoticonName, barCycle));
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }
        if (TextUtils.isEmpty(emoticonId) || TextUtils.isEmpty(emoticonName)) {
            LogHelper.i("emoticonId or emoticonName is empty");
            return 0L;
        }

        return ServiceApi.getServiceApi().sendEmoticonToPc(threadId, emoticonId,
                emoticonName, barCycle);
    }

    // cloud
    public long sendCloud(String number, long threadId, String fileName, long fileSize,
            String shareUrl, String smsContent, int barCycle) throws RemoteException,
            ServiceDisconnectedException {
        LogHelper.i(String.format(Locale.getDefault(),
            "enter method sendCloud. [number,threadId,fileName,fileSize,shareUrl,smsContent,"
                    + "barCycle]=%s,%d,%s,%d,%s,%s,%d",
                        number, threadId, fileName, fileSize, shareUrl, smsContent, barCycle));
        if (!VerificationUtil.isNumber(number)) {
            LogHelper.i("number field value error");
            return 0L;
        }
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }
        if (TextUtils.isEmpty(fileName) || TextUtils.isEmpty(shareUrl)
                || TextUtils.isEmpty(smsContent)) {
            LogHelper.i("fileName or shareUrl or smsContent is empty");
            return 0L;
        }

        List<String> numberList = new ArrayList<String>();
        numberList.add(number);
        return ServiceApi.getServiceApi().sendCloud(numberList, threadId, fileName, fileSize,
                shareUrl, smsContent, barCycle);
    }

    public long sendCloud(List<String> numberList, long threadId, String fileName, long fileSize,
            String shareUrl, String smsContent, int barCycle) throws RemoteException,
            ServiceDisconnectedException {
        LogHelper
                .i(String.format(
                        Locale.getDefault(),
                        "enter method sendCloud. [numberList,threadId,fileName,fileSize,"
                        + "shareUrl,smsContent,barCycle]=%s,%d,%s,%d,%s,%s,%d",
                        VerificationUtil.getNumberListString(numberList), threadId, fileName,
                        fileSize, shareUrl, smsContent, barCycle));
        if (!VerificationUtil.isAllNumber(numberList)) {
            LogHelper.i("number field value error");
            return 0L;
        }
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }
        if (TextUtils.isEmpty(fileName) || TextUtils.isEmpty(shareUrl)
                || TextUtils.isEmpty(smsContent)) {
            LogHelper.i("fileName or shareUrl or smsContent is empty");
            return 0L;
        }

        return ServiceApi.getServiceApi().sendCloud(numberList, threadId, fileName, fileSize,
                shareUrl, smsContent, barCycle);
    }

    public long sendCloudToGroupChat(long groupId, long threadId, String fileName, long fileSize,
            String shareUrl) throws RemoteException, ServiceDisconnectedException {
        LogHelper
                .i(String.format(
                        Locale.getDefault(),
                        "enter method sendCloudToGroupChat. [groupId,threadId,fileName,"
                        + "fileSize,shareUrl]=%d,%d,%s,%d,%s",
                        groupId, threadId, fileName, fileSize, shareUrl));
        if (TextUtils.isEmpty(fileName) || TextUtils.isEmpty(shareUrl)) {
            LogHelper.i("fileName or shareUrl is empty");
            return 0L;
        }
        return ServiceApi.getServiceApi().sendCloudToGroupChat(groupId, threadId, fileName,
                fileSize, shareUrl);
    }

    public long sendCloudToPc(long threadId, String fileName, long fileSize,
            String shareUrl, String smsContent, int barCycle) throws RemoteException,
            ServiceDisconnectedException {
        LogHelper.i(String.format(Locale.getDefault(),
            "enter method sendCloudToPc. [threadId,fileName,fileSize,shareUrl,smsContent,"
                    + "barCycle]=%d,%s,%d,%s,%s,%d",
                        threadId, fileName, fileSize, shareUrl, smsContent, barCycle));
        if (barCycle < -1) {
            LogHelper.i("barCycle field must be greater than -1");
            return 0L;
        }
        if (TextUtils.isEmpty(fileName) || TextUtils.isEmpty(shareUrl)
                || TextUtils.isEmpty(smsContent)) {
            LogHelper.i("fileName or shareUrl or smsContent is empty");
            return 0L;
        }

        return ServiceApi.getServiceApi().sendCloudToPc(threadId, fileName, fileSize,
                shareUrl, smsContent, barCycle);
    }

    // public account
    public long sendTextToPublicAccount(String publicAccountId, long threadId, String text)
            throws RemoteException, ServiceDisconnectedException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method sendTextToPublicAccount. [publicAccountId,threadId,text]=%s,%d,%s",
                publicAccountId, threadId, text));
        if ("".equals(text.trim())) {
            LogHelper.i("text value is null/Space");
            return 0L;
        }
        return ServiceApi.getServiceApi().sendTextToPublicAccount(publicAccountId, threadId, text);
    }

    public long sendImageToPublicAccount(String publicAccountId, long threadId, String filepath,
            int quality, boolean isRecord) throws RemoteException, ServiceDisconnectedException,
            FileSuffixException, FileNotExistsException, FileTooLargeException {
        return sendImageToPublicAccount(publicAccountId, threadId,
                filepath, quality, isRecord, null);
    }

    public long sendImageToPublicAccount(String publicAccountId, long threadId, String filepath,
            int quality, boolean isRecord, String thumbnailPath) throws RemoteException,
            ServiceDisconnectedException, FileSuffixException, FileNotExistsException,
            FileTooLargeException {
        LogHelper
        .i(String.format(
                Locale.getDefault(),
                "enter method sendImageToPublicAccount. [publicAccountId,"
                        + "threadId,filepath,quality,isRecord,thumbnailPath]=%s,%d,%s,%d,%b,%s",
                        publicAccountId, threadId, filepath, quality, isRecord, thumbnailPath));
        if (quality < MessageConstants.CONST_MIN_QUALITY
                || quality > MessageConstants.CONST_MAX_QUALITY) {
            LogHelper.i("quality field value must be between " + MessageConstants.CONST_MIN_QUALITY
                    + " to " + MessageConstants.CONST_MAX_QUALITY);
            return 0L;
        }

        VerificationUtil.isImageFile(filepath);
        VerificationUtil.isFileExists(filepath);
        if (thumbnailPath != null) {
            VerificationUtil.isImageFile(thumbnailPath);
            VerificationUtil.isFileExists(thumbnailPath);
        }
        if (quality == MessageConstants.CONST_MAX_QUALITY) {
            VerificationUtil.isFileSizeToLarge(filepath, this.getImageMaxSize());
        }
        return ServiceApi.getServiceApi().sendImageToPublicAccount(publicAccountId, threadId,
                filepath, quality, isRecord, thumbnailPath);
    }

    public long sendAudioToPublicAccount(String publicAccountId, long threadId, String filepath,
            int duration, boolean isRecord) throws RemoteException, ServiceDisconnectedException,
            FileSuffixException, FileNotExistsException, FileTooLargeException,
            FileDurationException {
        LogHelper
                .i(String.format(
                        Locale.getDefault(),
                        "enter method sendAudioToPublicAccount. [publicAccountId,threadId,"
                        + "filepath,duration,isRecord]=%s,%d,%s,%d,%b",
                        publicAccountId, threadId, filepath, duration, isRecord));

        VerificationUtil.isAudioFile(filepath);
        VerificationUtil.isFileExists(filepath);
        if (isRecord) {
            VerificationUtil.isAudioDurationToLong(ServiceApi.getInstance().getContext(), filepath,
                    this.getAudioMaxDuration(), duration);
        }
        VerificationUtil.isFileSizeToLarge(filepath, this.getVideoMaxSize());
        return ServiceApi.getServiceApi().sendAudioToPublicAccount(publicAccountId, threadId,
                filepath, duration, isRecord);
    }

    public long sendVideoToPublicAccount(String publicAccountId, long threadId, String filepath,
            int duration, boolean isRecord) throws RemoteException, ServiceDisconnectedException,
            FileSuffixException, FileNotExistsException, FileTooLargeException,
            FileDurationException {
        return sendVideoToPublicAccount(publicAccountId, threadId,
                filepath, duration, isRecord, null);
    }

    public long sendVideoToPublicAccount(String publicAccountId, long threadId, String filepath,
            int duration, boolean isRecord, String thumbnailPath) throws RemoteException,
            ServiceDisconnectedException, FileSuffixException, FileNotExistsException,
            FileTooLargeException, FileDurationException {
        LogHelper
        .i(String.format(
                Locale.getDefault(),
                "enter method sendVideoToPublicAccount. [publicAccountId,threadId,"
                        + "filepath,duration,isRecord,thumbnailPath]=%s,%d,%s,%d,%b,%s",
                        publicAccountId, threadId, filepath, duration, isRecord, thumbnailPath));
        VerificationUtil.isVideoFile(filepath);
        VerificationUtil.isFileExists(filepath);
        if (thumbnailPath != null) {
            VerificationUtil.isImageFile(thumbnailPath);
            VerificationUtil.isFileExists(thumbnailPath);
        }
        if (isRecord) {
            VerificationUtil.isVideoDurationToLong(ServiceApi.getInstance().getContext(),
                    filepath, this.getVideoMaxDuration(), duration);
        }
        VerificationUtil.isFileSizeToLarge(filepath, this.getVideoMaxSize());
        return ServiceApi.getServiceApi().sendVideoToPublicAccount(publicAccountId, threadId,
                filepath, duration, isRecord, thumbnailPath);
    }

    public long sendLocationToPublicAccount(String publicAccountId, long threadId, double lat,
            double lng, String label) throws RemoteException, ServiceDisconnectedException {
        LogHelper
                .i(String.format(
                        Locale.getDefault(),
                        "enter method sendLocationToPublicAccount. [publicAccountId,"
                        + "threadId,lat,lng,text]=%s,%d,%f,%f,%s",
                        publicAccountId, threadId, lat, lng, label));
        return ServiceApi.getServiceApi().sendLocationToPublicAccount(publicAccountId, threadId,
                lat, lng, label);
    }

    public long sendVcardToPublicAccount(String publicAccountId, long threadId, String filepath)
            throws RemoteException, ServiceDisconnectedException, FileSuffixException,
            FileNotExistsException {
        LogHelper
                .i(String.format(
                        Locale.getDefault(),
                        "enter method sendVcardToPublicAccount. [publicAccountId,"
                        + "threadId,filepath,barCycle]=%s,%d,%s",
                        publicAccountId, threadId, filepath));
        VerificationUtil.isVcardFile(filepath);
        VerificationUtil.isFileExists(filepath);
        return ServiceApi.getServiceApi().sendVcardToPublicAccount(publicAccountId, threadId,
                filepath);
    }

    public long sendCommandToPublicAccount(String publicAccountId, long threadId, String text)
            throws RemoteException, ServiceDisconnectedException {
        LogHelper.i(String.format(Locale.getDefault(),
                "enter method sendCommandToPublicAccount. [publicAccountId,text]=%s,%s",
                publicAccountId, text));
        if ("".equals(text.trim())) {
            LogHelper.i("text value is null/Space");
            return 0L;
        }
        return ServiceApi.getServiceApi().sendCommandToPublicAccount(publicAccountId, threadId,
                text);
    }

    /**
     * Parses the public message.
     * @param msgType the message type
     * @param content the message content
     * @return the public message
     */
    public static PublicMessage parsePublicMessage(int msgType, String content) {
        PublicMessage message = null;
        switch (msgType) {
            case MessageConstants.CONST_MESSAGE_TEXT:
            case MessageConstants.CONST_MESSAGE_MAP:
            case MessageConstants.CONST_MESSAGE_CONTACT:
                PublicTextMessageParser textHandler = new PublicTextMessageParser();
                XmlUtil.parse(content, textHandler);
                message = textHandler.getMessage();
                break;
            case MessageConstants.CONST_MESSAGE_IMAGE:
            case MessageConstants.CONST_MESSAGE_AUDIO:
            case MessageConstants.CONST_MESSAGE_VIDEO:
                PublicMediaMessageParser Mediahandler = new PublicMediaMessageParser();
                XmlUtil.parse(content, Mediahandler);
                message = Mediahandler.getMessage();
                break;
            case MessageConstants.CONST_MESSAGE_PUBLIC_ACCOUNT_ARTICLE:
                PublicTopicMessageParser Topichandler = new PublicTopicMessageParser();
                XmlUtil.parse(content, Topichandler);
                message = Topichandler.getMessage();
                break;
            default:
                break;
        }

        return message;
    }

    /**
     * Parses the cloud file message.
     * @param content the message content
     * @return the cloud file message
     */
    public static CloudFileMessage parseCloudFileMessage(String content) {
        CloudFileMessageParser handler = new CloudFileMessageParser();
        XmlUtil.parse(content, handler);
        return handler.getMessage();
    }
}
