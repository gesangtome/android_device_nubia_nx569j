$(call inherit-product, $(SRC_TARGET_DIR)/product/languages_full.mk)

# The gps config appropriate for this device
$(call inherit-product, device/common/gps/gps_us_supl.mk)

$(call inherit-product-if-exists, vendor/nubia/nx569j/nx569j-vendor.mk)

DEVICE_PACKAGE_OVERLAYS += device/nubia/nx569j/overlay


ifeq ($(TARGET_PREBUILT_KERNEL),)
	LOCAL_KERNEL := device/nubia/nx569j/kernel
else
	LOCAL_KERNEL := $(TARGET_PREBUILT_KERNEL)
endif

PRODUCT_COPY_FILES += \
    $(LOCAL_KERNEL):kernel

$(call inherit-product, build/target/product/full.mk)

PRODUCT_BUILD_PROP_OVERRIDES += BUILD_UTC_DATE=0
PRODUCT_NAME := full_nx569j
PRODUCT_DEVICE := nx569j

# Dalvik / HWUI
$(call inherit-product, device/nubia/nx569j/frameworks/native/build/phone-xxhdpi-3072-dalvik-heap.mk)
$(call inherit-product, device/nubia/nx569j/frameworks/native/build/phone-xxhdpi-3072-hwui-memory.mk)
