LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_SRC_FILES := $(call all-java-files-under, src)

LOCAL_JAVA_STATIC_LIBRARIES := android-common

LOCAL_PACKAGE_NAME := Sai

include $(BUILD_PACKAGE)

include $(call all-makefiles-under,$(LOCAL_PATH))
