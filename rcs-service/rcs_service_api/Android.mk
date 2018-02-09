LOCAL_PATH := $(call my-dir)

# Make rcs_service_api.jar
include $(CLEAR_VARS)
LOCAL_SRC_FILES := $(call all-java-files-under, src)
LOCAL_SRC_FILES += $(call all-java-files-under, ../rcs_ui_common/src)
LOCAL_MODULE_TAGS := optional
LOCAL_MODULE := rcs_service_api
LOCAL_STATIC_JAVA_LIBRARIES := rcs_service_aidl_static com.android.vcard
LOCAL_JAVA_LIBRARIES := telephony-common
include $(BUILD_JAVA_LIBRARY)

# MAKE_XML
include $(CLEAR_VARS)
LOCAL_MODULE := rcs_service_api.xml
LOCAL_MODULE_CLASS := ETC
LOCAL_MODULE_PATH := $(TARGET_OUT_ETC)/permissions
LOCAL_SRC_FILES := $(LOCAL_MODULE)
LOCAL_MODULE_TAGS := optional
include $(BUILD_PREBUILT)
