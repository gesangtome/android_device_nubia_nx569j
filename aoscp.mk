# Copyright (c) 2017, 格桑花給我的
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

# Inherit from those products. Most specific first.
$(call inherit-product, $(SRC_TARGET_DIR)/product/core_64_bit.mk)
$(call inherit-product, $(SRC_TARGET_DIR)/product/full_base_telephony.mk)

$(call inherit-product, device/nubia/nx569j/sounds/audio.mk)

# VIPER4AndroidFX
WITH_V4A := true

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
PRODUCT_NAME := aoscp_nx569j
PRODUCT_MANUFACTURER := nubia
PRODUCT_MODEL := nx569j
TARGET_VENDOR := nubia

PRODUCT_GMS_CLIENTID_BASE := android-nubia

PRODUCT_DEFAULT_PROPERTY_OVERRIDES += \
    persist.sys.timezone=Asia/Shanghai
