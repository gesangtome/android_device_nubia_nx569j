# Copyright (C) 2017 The LineageOS Project
# Copyright (c) 2018, Flowertome
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

$(call inherit-product-if-exists, vendor/nubia/nx569j/nx569j-vendor.mk)
$(call inherit-product, $(SRC_TARGET_DIR)/product/full_base_telephony.mk)

$(call inherit-product, frameworks/native/build/phone-xxhdpi-3072-dalvik-heap.mk)
$(call inherit-product, frameworks/native/build/phone-xxhdpi-3072-hwui-memory.mk)

DEVICE_PACKAGE_OVERLAYS += $(LOCAL_PATH)/overlay

# Density of the display
PRODUCT_AAPT_CONFIG := normal
PRODUCT_AAPT_PREF_CONFIG := xxhdpi

# Boot animation
TARGET_SCREEN_HEIGHT := 1920
TARGET_SCREEN_WIDTH := 1080

# Permissions
PRODUCT_COPY_FILES += \
    frameworks/native/data/etc/android.hardware.audio.low_latency.xml:system/etc/permissions/android.hardware.audio.low_latency.xml \
    frameworks/native/data/etc/android.hardware.bluetooth.xml:system/etc/permissions/android.hardware.bluetooth.xml \
    frameworks/native/data/etc/android.hardware.bluetooth_le.xml:system/etc/permissions/android.hardware.bluetooth_le.xml \
    frameworks/native/data/etc/android.hardware.camera.flash-autofocus.xml:system/etc/permissions/android.hardware.camera.flash-autofocus.xml \
    frameworks/native/data/etc/android.hardware.camera.front.xml:system/etc/permissions/android.hardware.camera.front.xml \
    frameworks/native/data/etc/android.hardware.camera.full.xml:system/etc/permissions/android.hardware.camera.full.xml\
    frameworks/native/data/etc/android.hardware.camera.raw.xml:system/etc/permissions/android.hardware.camera.raw.xml\
    frameworks/native/data/etc/android.hardware.fingerprint.xml:system/etc/permissions/android.hardware.fingerprint.xml \
    frameworks/native/data/etc/android.hardware.ethernet.xml:system/etc/permissions/android.hardware.ethernet.xml \
    frameworks/native/data/etc/android.hardware.location.gps.xml:system/etc/permissions/android.hardware.location.gps.xml \
    frameworks/native/data/etc/android.hardware.opengles.aep.xml:system/etc/permissions/android.hardware.opengles.aep.xml \
    frameworks/native/data/etc/android.hardware.nfc.hce.xml:system/etc/permissions/android.hardware.nfc.hce.xml \
    frameworks/native/data/etc/android.hardware.nfc.xml:system/etc/permissions/android.hardware.nfc.xml \
    frameworks/native/data/etc/android.hardware.sensor.accelerometer.xml:system/etc/permissions/android.hardware.sensor.accelerometer.xml \
    frameworks/native/data/etc/android.hardware.sensor.compass.xml:system/etc/permissions/android.hardware.sensor.compass.xml \
    frameworks/native/data/etc/android.hardware.sensor.gyroscope.xml:system/etc/permissions/android.hardware.sensor.gyroscope.xml \
    frameworks/native/data/etc/android.hardware.sensor.light.xml:system/etc/permissions/android.hardware.sensor.light.xml \
    frameworks/native/data/etc/android.hardware.sensor.proximity.xml:system/etc/permissions/android.hardware.sensor.proximity.xml \
    frameworks/native/data/etc/android.hardware.sensor.stepcounter.xml:system/etc/permissions/android.hardware.sensor.stepcounter.xml \
    frameworks/native/data/etc/android.hardware.sensor.stepdetector.xml:system/etc/permissions/android.hardware.sensor.stepdetector.xml \
    frameworks/native/data/etc/android.hardware.telephony.cdma.xml:system/etc/permissions/android.hardware.telephony.cdma.xml \
    frameworks/native/data/etc/android.hardware.telephony.gsm.xml:system/etc/permissions/android.hardware.telephony.gsm.xml \
    frameworks/native/data/etc/android.hardware.touchscreen.multitouch.jazzhand.xml:system/etc/permissions/android.hardware.touchscreen.multitouch.jazzhand.xml \
    frameworks/native/data/etc/android.hardware.usb.accessory.xml:system/etc/permissions/android.hardware.usb.accessory.xml \
    frameworks/native/data/etc/android.hardware.usb.host.xml:system/etc/permissions/android.hardware.usb.host.xml \
    frameworks/native/data/etc/android.hardware.wifi.xml:system/etc/permissions/android.hardware.wifi.xml \
    frameworks/native/data/etc/android.hardware.wifi.direct.xml:system/etc/permissions/android.hardware.wifi.direct.xml \
    frameworks/native/data/etc/android.software.midi.xml:system/etc/permissions/android.software.midi.xml \
    frameworks/native/data/etc/android.software.sip.voip.xml:system/etc/permissions/android.software.sip.voip.xml \
    frameworks/native/data/etc/android.software.webview.xml:system/etc/permissions/android.software.webview.xml \
    frameworks/native/data/etc/handheld_core_hardware.xml:system/etc/permissions/handheld_core_hardware.xml

# ANT+
PRODUCT_PACKAGES += \
    AntHalService \
    com.dsi.ant.antradio_library \
    libantradio

PRODUCT_COPY_FILES += \
    external/ant-wireless/antradio-library/com.dsi.ant.antradio_library.xml:system/etc/permissions/com.dsi.ant.antradio_library.xml

# Audio
PRODUCT_PACKAGES += \
    android.hardware.audio@2.0-impl \
    android.hardware.audio@2.0-service \
    android.hardware.audio.effect@2.0-impl \
    android.hardware.broadcastradio@1.0-impl \
    android.hardware.soundtrigger@2.0-impl \
    audio.a2dp.default \
    audio.primary.msm8952 \
    audio.r_submix.default \
    audio.usb.default \
    libaudio-resampler \
    libqcompostprocbundle \
    libqcomvisualizer \
    libqcomvoiceprocessing \
    libvolumelistener \
    tinymix

# Audio
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/audio/aanc_tuning_mixer.txt:system/etc/aanc_tuning_mixer.txt \
    $(LOCAL_PATH)/audio/audio_effects.conf:system/etc/audio_effects.conf \
    $(LOCAL_PATH)/audio/vendor/audio_effects.conf:system/vendor/etc/audio_effects.conf \
    $(LOCAL_PATH)/audio/vendor/audio_output_policy.conf:system/vendor/etc/audio_output_policy.conf \
    $(LOCAL_PATH)/audio/audio_policy.conf:system/etc/audio_policy.conf \
    $(LOCAL_PATH)/audio/audio_platform_info/audio_platform_info.xml:system/vendor/etc/audio_platform_info.xml \
    $(LOCAL_PATH)/audio/audio_platform_info/audio_platform_info_extcodec.xml:system/vendor/etc/audio_platform_info_extcodec.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths.xml:system/vendor/etc/mixer_paths.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_mtp.xml:system/vendor/etc/mixer_paths_mtp.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_skuk.xml:system/vendor/etc/mixer_paths_skuk.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_wcd9306.xml:system/vendor/etc/mixer_paths_wcd9306.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_wcd9326.xml:system/vendor/etc/mixer_paths_wcd9326.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_wcd9330.xml:system/vendor/etc/mixer_paths_wcd9330.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_wcd9335.xml:system/vendor/etc/mixer_paths_wcd9335.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_qrd_skuh.xml:system/vendor/etc/mixer_paths_qrd_skuh.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_qrd_skui.xml:system/vendor/etc/mixer_paths_qrd_skui.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_qrd_skum.xml:system/vendor/etc/mixer_paths_qrd_skum.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_qrd_skun.xml:system/vendor/etc/mixer_paths_qrd_skun.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_qrd_skuhf.xml:system/vendor/etc/mixer_paths_qrd_skuhf.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_qrd_skun_cajon.xml:system/vendor/etc/mixer_paths_qrd_skun_cajon.xml \
    $(LOCAL_PATH)/audio/soundtrigger/sound_trigger_mixer_paths.xml:system/etc/sound_trigger_mixer_paths.xml \
    $(LOCAL_PATH)/audio/soundtrigger/sound_trigger_mixer_paths_wcd9306.xml:system/etc/sound_trigger_mixer_paths_wcd9306.xml \
    $(LOCAL_PATH)/audio/soundtrigger/sound_trigger_mixer_paths_wcd9330.xml:system/etc/sound_trigger_mixer_paths_wcd9330.xml \
    $(LOCAL_PATH)/audio/soundtrigger/sound_trigger_mixer_paths_wcd9335.xml:system/etc/sound_trigger_mixer_paths_wcd9335.xml \
    $(LOCAL_PATH)/audio/soundtrigger/sound_trigger_platform_info.xml:system/etc/sound_trigger_platform_info.xml

# Bluetooth
PRODUCT_PACKAGES += \
    android.hardware.bluetooth@1.0-impl \
    android.hardware.bluetooth@1.0-service \
    libbt-vendor

# Camera
PRODUCT_PACKAGES += \
    android.hardware.camera.provider@2.4-impl \
    android.hardware.camera.provider@2.4-service \
    camera.device@1.0-impl \
    camera.device@3.2-impl \
    camera.msm8952 \
    libmm-qcamera \
    vendor.qti.hardware.camera.device@1.0 \
    vendor.qti.hardware.camera.device@1.0_vendor

# CDMA
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/Configs/CDMA/cdma_call_conf.xml:system/etc/cdma_call_conf.xml

# Configstore
PRODUCT_PACKAGES += \
    android.hardware.configstore@1.0-service

# CNE
PRODUCT_PACKAGES += \
    libcnefeatureconfig

PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/Configs/CNE/andsfCne.xml:system/etc/cne/andsfCne.xml \
    $(LOCAL_PATH)/Configs/CNE/SwimConfig.xml:system/etc/cne/SwimConfig.xml

# Capability
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/Configs/Capability/capability.xml:system/etc/capability.xml

# Data Service
PRODUCT_PACKAGES += \
    librmnetctl \
    datatop \
    sockev

# DSI
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/Configs/DSI/netmgr_config.xml:system/etc/data/netmgr_config.xml \
    $(LOCAL_PATH)/Configs/DSI/dsi_config.xml:system/etc/data/dsi_config.xml \
    $(LOCAL_PATH)/Configs/DSI/qmi_config.xml:system/etc/data/qmi_config.xml

# DRC
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/Configs/DRC/drc_cfg_5.1.txt:system/etc/drc/drc_cfg_5.1.txt \
    $(LOCAL_PATH)/Configs/DRC/drc_cfg_AZ.txt:system/etc/drc/drc_cfg_AZ.txt

# DPM
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/Configs/DPM/NsrmConfiguration.xml:system/etc/dpm/nsrm/NsrmConfiguration.xml \
    $(LOCAL_PATH)/Configs/DPM/dpm.conf:system/etc/dpm/dpm.conf

# Display
PRODUCT_PACKAGES += \
    android.hardware.graphics.allocator@2.0-impl \
    android.hardware.graphics.allocator@2.0-service \
    android.hardware.graphics.composer@2.1-impl \
    android.hardware.graphics.composer@2.1-service \
    android.hardware.graphics.mapper@2.0-impl \
    android.hardware.memtrack@1.0-impl \
    android.hardware.memtrack@1.0-service \
    gralloc.msm8952 \
    hwcomposer.msm8952 \
    copybit.msm8952 \
    memtrack.msm8952 \
    libdisplayconfig \
    liboverlay \
    libgenlock \
    liboverlay

# DRM
PRODUCT_PACKAGES += \
    android.hardware.drm@1.0-impl \
    android.hardware.drm@1.0-service \
    android.hardware.drm@1.0-service.widevine

# Ebtables
PRODUCT_PACKAGES += \
    ebtables \
    ethertypes \
    libebtc

# Fingerprint
PRODUCT_PACKAGES += \
    android.hardware.biometrics.fingerprint@2.0-service-custom

# FM
PRODUCT_PACKAGES += \
    FMRadio \
    libfmjni

# Gatekeeper
PRODUCT_PACKAGES += \
    android.hardware.gatekeeper@1.0-impl \
    android.hardware.gatekeeper@1.0-service

# GPS
PRODUCT_PACKAGES += \
    android.hardware.gnss@1.0-impl-qti \
    android.hardware.gnss@1.0-service-qti \
    gps.msm8952 \
    libcurl \
    libgnss \
    libgnsspps \
    libgps.utils \
    libloc_core \
    libloc_pla \
    liblocation_api

PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/Configs/GPS/cacert_location.pem:system/etc/cacert_location.pem \
    $(LOCAL_PATH)/Configs/GPS/xtra_root_cert.pem:system/etc/xtra_root_cert.pem

# Health
PRODUCT_PACKAGES += \
    android.hardware.health@1.0-impl \
    android.hardware.health@1.0-convert \
    android.hardware.health@1.0-service

# HIDL
PRODUCT_PACKAGES += \
    android.hidl.base@1.0 \
    android.hidl.manager@1.0

# Hostapd
PRODUCT_PACKAGES += \
    hostapd

PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/Configs/Hostapd/hostapd_default.conf:system/etc/hostapd/hostapd_default.conf \
    $(LOCAL_PATH)/Configs/Hostapd/hostapd.accept:system/etc/hostapd/hostapd.accept \
    $(LOCAL_PATH)/Configs/Hostapd/hostapd.deny:system/etc/hostapd/hostapd.deny

# IMS
PRODUCT_PACKAGES += \
    ims-ext-common

# Input
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/input/ft5x06_ts.kl:system/usr/keylayout/ft5x06_ts.kl \
    $(LOCAL_PATH)/input/Generic.kl:system/usr/keylayout/Generic.kl \
    $(LOCAL_PATH)/input/gpio-keys.kl:system/usr/keylayout/gpio-keys.kl \
    $(LOCAL_PATH)/input/synaptics_dsx.kl:system/usr/keylayout/synaptics_dsx.kl \
    $(LOCAL_PATH)/input/synaptics_rmi4_i2c.kl:system/usr/keylayout/synaptics_rmi4_i2c.kl \
    $(LOCAL_PATH)/input/input_proxy.idc:system/usr/idc/input_proxy.idc

# IPA Manager
PRODUCT_PACKAGES += \
    ipacm \
    libipanat

# IRSC
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/Configs/sec-config/sec_config:system/etc/sec_config

# Keymaster
PRODUCT_PACKAGES += \
    android.hardware.keymaster@3.0-impl \
    android.hardware.keymaster@3.0-service

# Lights
PRODUCT_PACKAGES += \
    android.hardware.light@2.0-impl \
    android.hardware.light@2.0-service \
    lights.msm8952

# Media
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/Configs/media_codecs/media_codecs.xml:system/etc/media_codecs.xml \
    $(LOCAL_PATH)/Configs/media_codecs/media_codecs_8956_v1.xml:system/etc/media_codecs_8956_v1.xml \
    $(LOCAL_PATH)/Configs/media_codecs/media_codecs_8956.xml:system/etc/media_codecs_8956.xml \
    $(LOCAL_PATH)/Configs/media_codecs/media_codecs_performance.xml:system/etc/media_codecs_performance.xml \
    $(LOCAL_PATH)/Configs/media_codecs/media_codecs_performance_8956.xml:system/etc/media_codecs_performance_8956.xml \
    $(LOCAL_PATH)/Configs/media_codecs/media_codecs_performance_8956_v1.xml:system/etc/media_codecs_performance_8956_v1.xml \

PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/Configs/media_profiles/media_profiles.xml:system/etc/media_profiles.xml \
    $(LOCAL_PATH)/Configs/media_profiles/media_profiles_8956.xml:system/etc/media_profiles_8956.xml

PRODUCT_COPY_FILES += \
    frameworks/av/media/libstagefright/data/media_codecs_google_audio.xml:system/etc/media_codecs_google_audio.xml \
    frameworks/av/media/libstagefright/data/media_codecs_google_telephony.xml:system/etc/media_codecs_google_telephony.xml \
    frameworks/av/media/libstagefright/data/media_codecs_google_video.xml:system/etc/media_codecs_google_video.xml

# Media Extensions
PRODUCT_PACKAGES += \
    libavmediaserviceextensions \
    libmediametrics \
    libregistermsext \
    mediametrics

# Netutils
PRODUCT_PACKAGES += \
    android.system.net.netd@1.0 \
    libandroid_net \
    netutils-wrapper-1.0

# NFC
PRODUCT_PACKAGES += \
    com.android.nfc_extras \
    NfcNci \
    Tag

PRODUCT_COPY_FILES += \
    frameworks/base/nfc-extras/com.android.nfc_extras.xml:system/etc/permissions/com.android.nfc_extras.xml

PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/Configs/NFC/libnfc-brcm-20797b00.conf:system/etc/libnfc-brcm-20797b00.conf \
    $(LOCAL_PATH)/Configs/NFC/libnfc-brcm.conf:system/etc/libnfc-brcm.conf \
    $(LOCAL_PATH)/Configs/NFC/nfcee_access.xml:system/etc/nfcee_access.xml

# Offline charging animation
PRODUCT_PACKAGES += \
    charger_res_images

# OpenGL
PRODUCT_PACKAGES += \
    libGLES_android

# OMX
PRODUCT_PACKAGES += \
    libc2dcolorconvert \
    libOmxAacEnc \
    libOmxAmrEnc \
    libOmxCore \
    libOmxEvrcEnc \
    libOmxQcelp13Enc \
    libOmxSwVencHevc \
    libOmxVdec \
    libOmxVenc \
    libstagefrighthw

# Power
PRODUCT_PACKAGES += \
    android.hardware.power@1.1-service-qti

# QMI
PRODUCT_PACKAGES += \
    libjson

# QCOM SOC
PRODUCT_PACKAGES += \
    libtinyxml \
    libxml2

# Ramdisk
PRODUCT_PACKAGES += \
    fstab.qcom \
    init.bt.config.service.rc \
    init.class_main.sh \
    init.nubia.extension.rc \
    init.nubia.usb.rc \
    init.project.rc \
    init.qcom.bms.sh \
    init.qcom.bt.sh \
    init.qcom.class_core.sh \
    init.qcom.early_boot.sh \
    init.qcom.rc \
    init.qcom.sh \
    init.qcom.usb.rc \
    init.recovery.qcom.rc \
    init.target.rc \
    ueventd.qcom.rc

# RenderScript HAL
PRODUCT_PACKAGES += \
    android.hardware.renderscript@1.0-impl

# Sensors
PRODUCT_PACKAGES += \
    android.hardware.sensors@1.0-impl \
    android.hardware.sensors@1.0-service

PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/Configs/Sensors/hals.conf:system/etc/sensors/hals.conf \
    $(LOCAL_PATH)/Configs/Sensors/sensor_def_qcomdev.conf:system/etc/sensors/sensor_def_qcomdev.conf

# SRS
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/Configs/SRS/srs_processing.cfg:system/etc/srs/srs_processing.cfg \
    $(LOCAL_PATH)/Configs/SRS/dts.lic:system/etc/srs/dts.lic

# surround
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/Configs/Surround/surround_sound_rec_5.1.cfg:system/etc/surround_sound_3mic/surround_sound_rec_5.1.cfg \
    $(LOCAL_PATH)/Configs/Surround/surround_sound_rec_AZ.cfg:system/etc/surround_sound_3mic/surround_sound_rec_AZ.cfg

# Scripts
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/scripts/hcidump.sh:system/etc/hcidump.sh \
    $(LOCAL_PATH)/scripts/hsic.control.bt.sh:system/etc/hsic.control.bt.sh \
    $(LOCAL_PATH)/scripts/init.ath3k.bt.sh:system/etc/init.ath3k.bt.sh \
    $(LOCAL_PATH)/scripts/init.crda.sh:system/etc/init.crda.sh \
    $(LOCAL_PATH)/scripts/init.qcom.audio.sh:system/etc/init.qcom.audio.sh \
    $(LOCAL_PATH)/scripts/init.qcom.coex.sh:system/etc/init.qcom.coex.sh \
    $(LOCAL_PATH)/scripts/init.qcom.debug.sh:system/etc/init.qcom.debug.sh \
    $(LOCAL_PATH)/scripts/init.qcom.efs.sync.sh:system/etc/init.qcom.efs.sync.sh \
    $(LOCAL_PATH)/scripts/init.qcom.fm.sh:system/etc/init.qcom.fm.sh \
    $(LOCAL_PATH)/scripts/init.qcom.post_boot.sh:system/etc/init.qcom.post_boot.sh \
    $(LOCAL_PATH)/scripts/init.qcom.sdio.sh:system/etc/init.qcom.sdio.sh \
    $(LOCAL_PATH)/scripts/init.qcom.uicc.sh:system/etc/init.qcom.uicc.sh \
    $(LOCAL_PATH)/scripts/init.qcom.wifi.sh:system/etc/init.qcom.wifi.sh \
    $(LOCAL_PATH)/scripts/init.qcom.zram.sh:system/etc/init.qcom.zram.sh \
    $(LOCAL_PATH)/scripts/init.qti.ims.sh:system/etc/init.qti.ims.sh \
    $(LOCAL_PATH)/scripts/qca6234-service.sh:system/etc/qca6234-service.sh

# Telephony
PRODUCT_PACKAGES += \
    telephony-ext

PRODUCT_BOOT_JARS += \
    telephony-ext

PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/Configs/Telephony/config.xml:system/etc/telephony/config.xml

# Thermal
PRODUCT_PACKAGES += \
    android.hardware.thermal@1.0-impl \
    android.hardware.thermal@1.0-service

PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/Configs/Thermal/01.conf:system/etc/.tp/.thermal-mode-00-01.conf \
    $(LOCAL_PATH)/Configs/Thermal/02.conf:system/etc/.tp/.thermal-mode-00-02.conf \
    $(LOCAL_PATH)/Configs/Thermal/03.conf:system/etc/.tp/.thermal-mode-00-03.conf \
    $(LOCAL_PATH)/Configs/Thermal/04.conf:system/etc/.tp/.thermal-mode-00-04.conf

PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/Configs/Thermal/msm_irqbalance.conf:system/vendor/etc/msm_irqbalance.conf \
    $(LOCAL_PATH)/Configs/Thermal/msm_irqbalance_little_big.conf:system/vendor/etc/msm_irqbalance_little_big.conf

# USB
PRODUCT_PACKAGES += \
    android.hardware.usb@1.0-service

PRODUCT_PROPERTY_OVERRIDES += \
    persist.sys.usb.config=mtp,adb

# Vibrator
PRODUCT_PACKAGES += \
    android.hardware.vibrator@1.0-impl \
    android.hardware.vibrator@1.0-service

# WCNSS
PRODUCT_PACKAGES += \
    wcnss_service

PRODUCT_PACKAGES += \
    libwifi-hal-qcom \
    libwpa_client \
    libcld80211

PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/Configs/WCNSS/WCNSS_cfg.dat:system/etc/firmware/wlan/prima/WCNSS_cfg.dat \
    $(LOCAL_PATH)/Configs/WCNSS/WCNSS_qcom_cfg.ini:system/etc/wifi/WCNSS_qcom_cfg.ini

# WDF
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/Configs/Configs(WFD)/wfdconfig640_480.xml:system/etc/wfdconfig640_480.xml \
    $(LOCAL_PATH)/Configs/Configs(WFD)/wfdconfig800_480.xml:system/etc/wfdconfig800_480.xml \
    $(LOCAL_PATH)/Configs/Configs(WFD)/wfdconfig960_540.xml:system/etc/wfdconfig960_540.xml \
    $(LOCAL_PATH)/Configs/Configs(WFD)/wfdconfig1280_720.xml:system/etc/wfdconfig1280_720.xml \
    $(LOCAL_PATH)/Configs/Configs(WFD)/wfdconfigsink.xml:system/etc/wfdconfigsink.xml \
    $(LOCAL_PATH)/Configs/Configs(WFD)/wfdconfig.xml:system/etc/wfdconfig.xml

# Wi-Fi
PRODUCT_PACKAGES += \
    android.hardware.wifi@1.0-service \
    libQWiFiSoftApCfg \
    libqsap_sdk \
    wificond \
    wifilogd

PRODUCT_PACKAGES += \
    wpa_supplicant

PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/Configs/WLAN/wpa_supplicant.conf:system/etc/wifi/wpa_supplicant.conf \
    $(LOCAL_PATH)/Configs/WLAN/p2p_supplicant_overlay.conf:system/etc/wifi/p2p_supplicant_overlay.conf \
    $(LOCAL_PATH)/Configs/WLAN/wpa_supplicant_overlay.conf:system/etc/wifi/wpa_supplicant_overlay.conf
