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

# Inherit from those products. Most specific first.
$(call inherit-product, $(SRC_TARGET_DIR)/product/core_64_bit.mk)
$(call inherit-product, $(SRC_TARGET_DIR)/product/full_base_telephony.mk)

# =================================================================================================
# The default language option.
# If you want to add more languages, please add to this and submit it to me using git pull request.
# in which format is as follows:
# 
# TARGET_LOCALES + : $language_$area
# =================================================================================================

# Chinese - The People's Republic of China
TARGET_LOCALES := zh_CN zh_HK zh_TW

# English - The United States of America
TARGET_LOCALES += en_US

# Russia - The Russian federation
TARGET_LOCALES += ru_RU

# Spanish - The kingdom of Spain
TARGET_LOCALES += es_ES

# Inherit some common CM stuff.
$(call inherit-product, vendor/sm/config/common_full_phone.mk)

# Inherit device configuration
$(call inherit-product, device/nubia/nx569j/device.mk)

# Release name
PRODUCT_RELEASE_NAME := nubia Z17mini

# Set those variables here to overwrite the inherited values.
BOARD_VENDOR := nubia
PRODUCT_BRAND := nubia
PRODUCT_DEVICE := nx569j
PRODUCT_NAME := sm_nx569j
PRODUCT_MANUFACTURER := nubia
PRODUCT_MODEL := nx569j
TARGET_VENDOR := nubia

PRODUCT_GMS_CLIENTID_BASE := android-nubia

PRODUCT_DEFAULT_PROPERTY_OVERRIDES += \
    persist.sys.timezone=Asia/Shanghai
