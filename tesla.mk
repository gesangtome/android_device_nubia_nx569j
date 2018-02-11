# Release name
PRODUCT_RELEASE_NAME := nx569j

# Inherit some common Tesla stuff.
$(call inherit-product, vendor/tesla/config/common_full_phone.mk)

# Inherit device configuration
$(call inherit-product, device/nubia/nx569j/device_nx569j.mk)

## Device identifier. This must come after all inclusions
PRODUCT_DEVICE := nx569j
PRODUCT_NAME := tesla_nx569j
PRODUCT_BRAND := nubia
PRODUCT_MODEL := nx569j
PRODUCT_MANUFACTURER := nubia
