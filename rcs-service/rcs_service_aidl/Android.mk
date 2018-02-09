LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_AIDL_INCLUDES := $(LOCAL_PATH)/src

# Important: Must not contain any aidl files for parcelables
LOCAL_SRC_FILES := \
    $(call all-java-files-under, src) \
    src/com/suntek/mway/rcs/client/aidl/plugin/IPluginApi.aidl \
    src/com/suntek/mway/rcs/client/aidl/plugin/callback/ICloudOperationCtrl.aidl \
    src/com/suntek/mway/rcs/client/aidl/plugin/callback/IContactSyncListener.aidl \
    src/com/suntek/mway/rcs/client/aidl/plugin/callback/IProfileListener.aidl \
    src/com/suntek/mway/rcs/client/aidl/plugin/callback/IPublicAccountCallbackAPI.aidl \
    src/com/suntek/mway/rcs/client/aidl/service/IServiceApi.aidl \
    src/com/suntek/mway/rcs/client/aidl/service/IServiceListener.aidl \
    src/com/suntek/mway/rcs/client/aidl/service/callback/ICapabiltyListener.aidl \
    src/com/suntek/mway/rcs/client/aidl/service/callback/IGroupChatCallback.aidl \

LOCAL_MODULE_TAGS := optional
LOCAL_MODULE := rcs_service_aidl

include $(BUILD_JAVA_LIBRARY)

include $(CLEAR_VARS)

LOCAL_AIDL_INCLUDES := $(LOCAL_PATH)/src

# Important: Must not contain any aidl files for parcelables
LOCAL_SRC_FILES := \
    $(call all-java-files-under, src) \
    src/com/suntek/mway/rcs/client/aidl/plugin/IPluginApi.aidl \
    src/com/suntek/mway/rcs/client/aidl/plugin/callback/ICloudOperationCtrl.aidl \
    src/com/suntek/mway/rcs/client/aidl/plugin/callback/IContactSyncListener.aidl \
    src/com/suntek/mway/rcs/client/aidl/plugin/callback/IProfileListener.aidl \
    src/com/suntek/mway/rcs/client/aidl/plugin/callback/IPublicAccountCallbackAPI.aidl \
    src/com/suntek/mway/rcs/client/aidl/service/IServiceApi.aidl \
    src/com/suntek/mway/rcs/client/aidl/service/IServiceListener.aidl \
    src/com/suntek/mway/rcs/client/aidl/service/callback/ICapabiltyListener.aidl \
    src/com/suntek/mway/rcs/client/aidl/service/callback/IGroupChatCallback.aidl \

LOCAL_MODULE_TAGS := optional
LOCAL_MODULE := rcs_service_aidl_static

include $(BUILD_STATIC_JAVA_LIBRARY)


#MAKE_XML
include $(CLEAR_VARS)
LOCAL_MODULE := rcs_service_aidl.xml
LOCAL_MODULE_CLASS := ETC
LOCAL_MODULE_PATH := $(TARGET_OUT_ETC)/permissions
LOCAL_SRC_FILES := $(LOCAL_MODULE)
LOCAL_MODULE_TAGS := optional
include $(BUILD_PREBUILT)
