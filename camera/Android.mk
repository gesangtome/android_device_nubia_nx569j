# Copyright (c) 2018, Flowertome. All rights reserved.
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

LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE := NubiaCamera
LOCAL_MODULE_OWNER := nubia
LOCAL_SRC_FILES := $(LOCAL_MODULE)
LOCAL_MODULE_SUFFIX := .apk
LOCAL_CERTIFICATE := platform
LOCAL_MODULE_TAGS := optional
LOCAL_MODULE_CLASS := APPS
LOCAL_PRIVILEGED_MODULE := true

LOCAL_ADDITIONAL_DEPENDENCIES := \
    camera_config.xml \
    imx214_chromatix.xml \
    imx230_chromatix.xml \
    imx230_qc2002_chromatix.xml \
    imx230_qc2002_with_gyro_chromatix.xml \
    imx258_aux_chromatix.xml \
    imx258_bear_chromatix.xml \
    imx258_chromatix.xml \
    imx258_main_chromatix.xml \
    imx258_mono_bear_chromatix.xml \
    imx258_mono_chromatix.xml \
    imx362_chromatix_bear.xml \
    imx362_chromatix.xml \
    imx378_chromatix.xml \
    msm8976pro_camera_imx258dual_s5k3p3.xml \
    ov13850_chromatix.xml \
    ov13850_q13v06k_chromatix.xml \
    ov4688_chromatix.xml \
    ov5670_chromatix.xml \
    ov8858_chromatix.xml \
    ov8865_chromatix.xml \
    s5k2l7_8976_chromatix.xml \
    s5k2l7_chromatix.xml \
    s5k3m2xm_chromatix.xml \
    s5k3m2xx_chromatix.xml \
    s5k3p3_chromatix.xml \
    s5k3p3sm_chromatix.xml

include $(BUILD_PREBUILT)

###########################################################################

include $(CLEAR_VARS)
LOCAL_MODULE       := camera_config
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := imx214_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := imx230_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := imx230_qc2002_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := imx230_qc2002_with_gyro_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := imx258_aux_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := imx258_bear_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := imx258_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := imx258_main_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := imx258_mono_bear_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := imx258_mono_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := imx362_chromatix_bear
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := imx362_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := imx378_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := msm8976pro_camera_imx258dual_s5k3p3
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := ov13850_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := ov13850_q13v06k_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := ov4688_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := ov5670_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := ov8858_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := ov8865_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := s5k2l7_8976_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := s5k2l7_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := s5k3m2xm_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := s5k3m2xx_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := s5k3p3_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := s5k3p3sm_chromatix
LOCAL_MODULE_SUFFIX := .xml
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := $(LOCAL_MODULE)
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/camera
include $(BUILD_PREBUILT)
