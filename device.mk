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

$(call inherit-product, $(SRC_TARGET_DIR)/product/languages_full.mk)

$(call inherit-product-if-exists, vendor/nubia/nx569j/nx569j-vendor.mk)

DEVICE_PACKAGE_OVERLAYS += device/nubia/nx569j/overlay

# audio
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/audio/vendor/audio_effects.conf:system/vendor/etc/audio_effects.conf \
    $(LOCAL_PATH)/audio/vendor/audio_output_policy.conf:system/vendor/etc/audio_output_policy.conf \
    $(LOCAL_PATH)/audio/audio_effects.conf:system/etc/audio_effects.conf \
    $(LOCAL_PATH)/audio/audio_policy.conf:system/etc/audio_policy.conf \
    $(LOCAL_PATH)/audio/audio_platform_info/audio_platform_info.xml:system/etc/audio_platform_info.xml \
    $(LOCAL_PATH)/audio/audio_platform_info/audio_platform_info_extcodec.xml:system/etc/audio_platform_info_extcodec.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths.xml:system/etc/mixer_paths.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_mtp.xml:system/etc/mixer_paths_mtp.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_skuk.xml:system/etc/mixer_paths_skuk.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_wcd9306.xml:system/etc/mixer_paths_wcd9306.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_wcd9326.xml:system/etc/mixer_paths_wcd9326.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_wcd9330.xml:system/etc/mixer_paths_wcd9330.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_wcd9335.xml:system/etc/mixer_paths_wcd9335.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_qrd_skuh.xml:system/etc/mixer_paths_qrd_skuh.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_qrd_skui.xml:system/etc/mixer_paths_qrd_skui.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_qrd_skum.xml:system/etc/mixer_paths_qrd_skum.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_qrd_skun.xml:system/etc/mixer_paths_qrd_skun.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_qrd_skuhf.xml:system/etc/mixer_paths_qrd_skuhf.xml \
    $(LOCAL_PATH)/audio/mixerpaths/mixer_paths_qrd_skun_cajon.xml:system/etc/mixer_paths_qrd_skun_cajon.xml

# CNE
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/configs/CNE/andsfCne.xml:system/etc/cne/andsfCne.xml \
    $(LOCAL_PATH)/configs/CNE/SwimConfig.xml:system/etc/cne/SwimConfig.xml

# CDMA
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/configs/cdmaconfig/cdma_call_conf.xml:system/etc/cdma_call_conf.xml

# Certificates
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/config/certificates/cacert_location.pem:system/etc/cacert_location.pem \
    $(LOCAL_PATH)/config/certificates/xtra_root_cert.pem:system/etc/xtra_root_cert.pem

# DSI
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/configs/DSI/dsi_config.xml:system/etc/data/dsi_config.xml \
    $(LOCAL_PATH)/configs/DSI/netmgr_config.xml:system/etc/data/netmgr_config.xml \
    $(LOCAL_PATH)/configs/DSI/qmi_config.xml:system/etc/data/qmi_config.xml

# DPM
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/configs/DPM/dpm.conf:system/etc/dpm/dpm.conf \
    $(LOCAL_PATH)/configs/DPM/nsrm/NsrmConfiguration.xml:system/etc/dpm/nsrm/NsrmConfiguration.xml

# DRC
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/configs/DRC/drc_cfg_5.1.txt:system/etc/drc/drc_cfg_5.1.txt \
    $(LOCAL_PATH)/configs/DRC/drc_cfg_AZ.txt:system/etc/drc/drc_cfg_AZ.txt

# GPS
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/configs/sec_config:system/etc/sec_config

# Hostpad
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/configs/hostapd/hostapd.accept:system/etc/hostapd/hostapd.accept \
    $(LOCAL_PATH)/configs/hostapd/hostapd.deny:system/etc/hostapd/hostapd.deny \
    $(LOCAL_PATH)/configs/hostapd/hostapd_default.conf:system/etc/hostapd/hostapd_default.conf

# Keylayout
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/config/keylayout/Generic.kl:system/usr/keylayout/Generic.kl \
    $(LOCAL_PATH)/config/keylayout/synaptics_dsx.kl:system/usr/keylayout/synaptics_dsx.kl \
    $(LOCAL_PATH)/config/keylayout/ft5x06_ts.kl:system/usr/keylayout/ft5x06_ts.kl \
    $(LOCAL_PATH)/config/keylayout/gpio-keys.kl:system/usr/keylayout/gpio-keys.kl \
    $(LOCAL_PATH)/config/keylayout/synaptics_rmi4_i2c.kl:system/usr/keylayout/synaptics_rmi4_i2c.kl \
    $(LOCAL_PATH)/config/keylayout/input_proxy.idc:system/usr/idc/input_proxy.idc

# Media
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/configs/mediacodecs/media_codecs.xml:system/etc/media_codecs.xml \
    $(LOCAL_PATH)/configs/mediacodecs/media_codecs_8956_v1.xml:system/etc/media_codecs_8956_v1.xml \
    $(LOCAL_PATH)/configs/mediacodecs/media_codecs_8956.xml:system/etc/media_codecs_8956.xml \
    $(LOCAL_PATH)/configs/mediacodecs/media_codecs_performance.xml:system/etc/media_codecs_performance.xml \
    $(LOCAL_PATH)/configs/mediacodecs/media_codecs_performance_8956.xml:system/etc/media_codecs_performance_8956.xml \
    $(LOCAL_PATH)/configs/mediacodecs/media_codecs_performance_8956_v1.xml:system/etc/media_codecs_performance_8956_v1.xml

PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/configs/mediaprofiles/media_profiles.xml:system/etc/media_profiles.xml \
    $(LOCAL_PATH)/configs/mediaprofiles/media_profiles_8956.xml:system/etc/media_profiles_8956.xml

PRODUCT_COPY_FILES += \
    frameworks/av/media/libstagefright/data/media_codecs_google_audio.xml:system/etc/media_codecs_google_audio.xml \
    frameworks/av/media/libstagefright/data/media_codecs_google_telephony.xml:system/etc/media_codecs_google_telephony.xml \
    frameworks/av/media/libstagefright/data/media_codecs_google_video.xml:system/etc/media_codecs_google_video.xml

# NFC
PRODUCT_PACKAGES += \
    com.android.nfc_extras \
    NfcNci \
    Tag

PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/configs/NFC/libnfc-brcm.conf:system/etc/libnfc-brcm.conf \
    $(LOCAL_PATH)/configs/NFC/libnfc-brcm-20797b00.conf:system/etc/libnfc-brcm-20797b00.conf

PRODUCT_COPY_FILES += \
    frameworks/base/nfc-extras/com.android.nfc_extras.xml:system/etc/permissions/com.android.nfc_extras.xml

# Soundtrigger
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/audio/soundtrigger/sound_trigger_mixer_paths.xml:system/etc/sound_trigger_mixer_paths.xml \
    $(LOCAL_PATH)/audio/soundtrigger/sound_trigger_mixer_paths_wcd9306.xml:system/etc/sound_trigger_mixer_paths_wcd9306.xml \
    $(LOCAL_PATH)/audio/soundtrigger/sound_trigger_mixer_paths_wcd9330.xml:system/etc/sound_trigger_mixer_paths_wcd9330.xml \
    $(LOCAL_PATH)/audio/soundtrigger/sound_trigger_mixer_paths_wcd9335.xml:system/etc/sound_trigger_mixer_paths_wcd9335.xml \
    $(LOCAL_PATH)/audio/soundtrigger/sound_trigger_platform_info.xml:system/etc/sound_trigger_platform_info.xml

# Scripts
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/etc/hcidump.sh:system/etc/hcidump.sh \
    $(LOCAL_PATH)/etc/hsic.control.bt.sh:system/etc/hsic.control.bt.sh \
    $(LOCAL_PATH)/etc/init.ath3k.bt.sh:system/etc/init.ath3k.bt.sh \
    $(LOCAL_PATH)/etc/init.crda.sh:system/etc/init.crda.sh \
    $(LOCAL_PATH)/etc/init.qcom.audio.sh:system/etc/init.qcom.audio.sh \
    $(LOCAL_PATH)/etc/init.qcom.coex.sh:system/etc/init.qcom.coex.sh \
    $(LOCAL_PATH)/etc/init.qcom.debug.sh:system/etc/init.qcom.debug.sh \
    $(LOCAL_PATH)/etc/init.qcom.efs.sync.sh:system/etc/init.qcom.efs.sync.sh \
    $(LOCAL_PATH)/etc/init.qcom.fm.sh:system/etc/init.qcom.fm.sh \
    $(LOCAL_PATH)/etc/init.qcom.post_boot.sh:system/etc/init.qcom.post_boot.sh \
    $(LOCAL_PATH)/etc/init.qcom.sdio.sh:system/etc/init.qcom.sdio.sh \
    $(LOCAL_PATH)/etc/init.qcom.uicc.sh:system/etc/init.qcom.uicc.sh \
    $(LOCAL_PATH)/etc/init.qcom.wifi.sh:system/etc/init.qcom.wifi.sh \
    $(LOCAL_PATH)/etc/init.qcom.zram.sh:system/etc/init.qcom.zram.sh \
    $(LOCAL_PATH)/etc/init.qti.ims.sh:system/etc/init.qti.ims.sh \
    $(LOCAL_PATH)/etc/qca6234-service.sh:system/etc/qca6234-service.sh

# Sensors
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/configs/sensors/hals.conf:system/etc/sensors/hals.conf \
    $(LOCAL_PATH)/configs/sensors/sensor_def_qcomdev.conf:system/etc/sensors/sensor_def_qcomdev.conf

# SRS
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/configs/srs/dts.lic:system/etc/srs/dts.lic \
    $(LOCAL_PATH)/configs/srs/srs_processing.cfg:system/etc/srs/srs_processing.cfg

# surround
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/configs/surround/surround_sound_rec_5.1.cfg:system/etc/surround_sound_3mic/surround_sound_rec_5.1.cfg \
    $(LOCAL_PATH)/configs/surround/surround_sound_rec_AZ.cfg:system/etc/surround_sound_3mic/surround_sound_rec_AZ.cfg

# Thermal
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/configs/thermal/thermal-mode-00-01.conf:system/etc/.tp/.thermal-mode-00-01.conf \
    $(LOCAL_PATH)/configs/thermal/thermal-mode-00-02.conf:system/etc/.tp/.thermal-mode-00-02.conf \
    $(LOCAL_PATH)/configs/thermal/thermal-mode-00-03.conf:system/etc/.tp/.thermal-mode-00-03.conf \
    $(LOCAL_PATH)/configs/thermal/thermal-mode-00-04.conf:system/etc/.tp/.thermal-mode-00-04.conf

PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/configs/thermalengine/msm_irqbalance.conf:system/vendor/etc/msm_irqbalance.conf \
    $(LOCAL_PATH)/configs/thermalengine/msm_irqbalance_little_big.conf:system/vendor/etc/msm_irqbalance_little_big.conf

# Telephony
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/configs/telephony/config.xml:system/etc/telephony/config.xml

# WDFCONFIG
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/configs/wdfconfig/wfdconfig.xml:system/etc/wfdconfig.xml \
    $(LOCAL_PATH)/configs/wdfconfig/wfdconfig640_480.xml:system/etc/wfdconfig640_480.xml \
    $(LOCAL_PATH)/configs/wdfconfig/wfdconfig800_480.xml:system/etc/wfdconfig800_480.xml \
    $(LOCAL_PATH)/configs/wdfconfig/wfdconfig960_540.xml:system/etc/wfdconfig960_540.xml \
    $(LOCAL_PATH)/configs/wdfconfig/wfdconfig1280_720.xml:system/etc/wfdconfig1280_720.xml \
    $(LOCAL_PATH)/configs/wdfconfig/wfdconfigsink.xml:system/etc/wfdconfigsink.xml

# Dalvik / HWUI
$(call inherit-product, device/nubia/nx569j/frameworks/native/build/phone-xxhdpi-3072-dalvik-heap.mk)
$(call inherit-product, device/nubia/nx569j/frameworks/native/build/phone-xxhdpi-3072-hwui-memory.mk)
