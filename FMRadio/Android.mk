# Copyright (c) 2017, 格桑花給我的. All rights reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions are
# met:
#     * Redistributions of source code must retain the above copyright
#       notice, this list of conditions and the following disclaimer.
#     * Redistributions in binary form must reproduce the above
#       copyright notice, this list of conditions and the following
#       disclaimer in the documentation and/or other materials provided
#       with the distribution.
#     * Neither the name of The Linux Foundation nor the names of its
#       contributors may be used to endorse or promote products derived
#       from this software without specific prior written permission.
#
# THIS SOFTWARE IS PROVIDED "AS IS" AND ANY EXPRESS OR IMPLIED
# WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
# MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT
# ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS
# BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
# CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
# SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR
# BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
# WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
# OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN
# IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

LOCAL_PATH := $(call my-dir)

# =================================================
# make the qcom.fmradio.jar <-- <gesangtome@189.cn>
# =================================================

include $(CLEAR_VARS)
LOCAL_MODULE := qcom.fmradio
LOCAL_MODULE_OWNER := nubia
LOCAL_SRC_FILES := $(LOCAL_MODULE)
LOCAL_CERTIFICATE := platform
LOCAL_MODULE_TAGS := optional
LOCAL_MODULE_CLASS := JAVA_LIBRARIES
LOCAL_MODULE_SUFFIX := .jar
include $(BUILD_PREBUILT)

# =========================================
# make the NubiaFM <-- <gesangtome@189.cn>
# =========================================
include $(CLEAR_VARS)

LOCAL_MODULE := NubiaFM
LOCAL_MODULE_OWNER := nubia
LOCAL_SRC_FILES := $(LOCAL_MODULE)
LOCAL_CERTIFICATE := platform
LOCAL_MODULE_TAGS := optional
LOCAL_MODULE_CLASS := APPS
LOCAL_MODULE_SUFFIX := .apk
LOCAL_PRIVILEGED_MODULE := true

LOCAL_ADDITIONAL_DEPENDENCIES := \
    libqcomfm_jni \
    libfmjni \

LOCAL_ADDITIONAL_DEPENDENCIES += \
    qcom.fmradio

include $(BUILD_PREBUILT)

# +++++++++++++++++++++++++++++++++++++++++++++++++++++
# Make the dependencies
# +++++++++++++++++++++++++++++++++++++++++++++++++++++
include $(CLEAR_VARS)
LOCAL_MODULE := libfmjni
LOCAL_MODULE_OWNER := nubia
LOCAL_SRC_FILES_64 := arm64/libfmjni.so
LOCAL_SRC_FILES_32 := arm/libfmjni.so
LOCAL_MULTILIB := both
LOCAL_MODULE_TAGS := optional
LOCAL_MODULE_CLASS := SHARED_LIBRARIES
LOCAL_MODULE_SUFFIX := .so
LOCAL_PROPRIETARY_MODULE := true
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE := libqcomfm_jni
LOCAL_MODULE_OWNER := nubia
LOCAL_SRC_FILES_64 := arm64/libqcomfm_jni.so
LOCAL_SRC_FILES_32 := arm/libqcomfm_jni.so
LOCAL_MULTILIB := both
LOCAL_MODULE_TAGS := optional
LOCAL_MODULE_CLASS := SHARED_LIBRARIES
LOCAL_MODULE_SUFFIX := .so
LOCAL_PROPRIETARY_MODULE := true
include $(BUILD_PREBUILT)
