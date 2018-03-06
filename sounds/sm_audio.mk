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

CUSTOM_ALARM_PATH := device/nubia/nx569j/sounds/alarms
CUSTOM_NOTIFICATION_PATH := device/nubia/nx569j/sounds/notifications
CUSTOM_RINGTONE_PATH := device/nubia/nx569j/sounds/ringtones

# Ringtone
PRODUCT_COPY_FILES += \
    $(CUSTOM_ALARM_PATH)/sounds/alarms/Beautiful.ogg:system/media/alarms/Beautiful.ogg \
    $(CUSTOM_ALARM_PATH)/sounds/alarms/Kalimbell.ogg:system/media/alarms/Kalimbell.ogg \
    $(CUSTOM_ALARM_PATH)/sounds/alarms/OpenForest.ogg:system/media/alarms/OpenForest.ogg \
    $(CUSTOM_ALARM_PATH)/sounds/alarms/Twlight.ogg:system/media/alarms/Twlight.ogg

PRODUCT_COPY_FILES += \
    $(CUSTOM_NOTIFICATION_PATH)/sounds/notifications/Default.ogg:system/media/notifications/Default.ogg \
    $(CUSTOM_NOTIFICATION_PATH)/sounds/notifications/Europa.ogg:system/media/notifications/Europa.ogg \
    $(CUSTOM_NOTIFICATION_PATH)/sounds/notifications/Hello.ogg:system/media/notifications/Hello.ogg \
    $(CUSTOM_NOTIFICATION_PATH)/sounds/notifications/Jingle.ogg:system/media/notifications/Jingle.ogg \
    $(CUSTOM_NOTIFICATION_PATH)/sounds/notifications/MagicBell.ogg:system/media/notifications/MagicBell.ogg \
    $(CUSTOM_NOTIFICATION_PATH)/sounds/notifications/MusicBox.ogg:system/media/notifications/MusicBox.ogg \
    $(CUSTOM_NOTIFICATION_PATH)/sounds/notifications/Piano.ogg:system/media/notifications/Piano.ogg \
    $(CUSTOM_NOTIFICATION_PATH)/sounds/notifications/Promote.ogg:system/media/notifications/Promote.ogg \
    $(CUSTOM_NOTIFICATION_PATH)/sounds/notifications/Rhea.ogg:system/media/notifications/Rhea.ogg \
    $(CUSTOM_NOTIFICATION_PATH)/sounds/notifications/Tethys.ogg:system/media/notifications/Tethys.ogg \
    $(CUSTOM_NOTIFICATION_PATH)/sounds/notifications/Tinnitus.ogg:system/media/notifications/Tinnitus.ogg \
    $(CUSTOM_NOTIFICATION_PATH)/sounds/notifications/Unobtrusive.ogg:system/media/notifications/Unobtrusive.ogg \
    $(CUSTOM_NOTIFICATION_PATH)/sounds/notifications/WindChime.ogg:system/media/notifications/WindChime.ogg

PRODUCT_COPY_FILES += \
    $(CUSTOM_RINGTONE_PATH)/sounds/ringtones/Castle.ogg:system/media/ringtones/Castle.ogg \
    $(CUSTOM_RINGTONE_PATH)/sounds/ringtones/Chanson.ogg:system/media/ringtones/Chanson.ogg \
    $(CUSTOM_RINGTONE_PATHH)/sounds/ringtones/Classical.ogg:system/media/ringtones/Classical.ogg \
    $(CUSTOM_RINGTONE_PATH)/sounds/ringtones/Dance.ogg:system/media/ringtones/Dance.ogg \
    $(CUSTOM_RINGTONE_PATH)/sounds/ringtones/Funtouch.ogg:system/media/ringtones/Funtouch.ogg \
    $(CUSTOM_RINGTONE_PATH)/sounds/ringtones/Greenery.ogg:system/media/ringtones/Greenery.ogg \
    $(CUSTOM_RINGTONE_PATH)/sounds/ringtones/Harp.ogg:system/media/ringtones/Harp.ogg \
    $(CUSTOM_RINGTONE_PATH)/sounds/ringtones/HuaweiTune.ogg:system/media/ringtones/HuaweiTune.ogg \
    $(CUSTOM_RINGTONE_PATH)/sounds/ringtones/Mile.ogg:system/media/ringtones/Mile.ogg \
    $(CUSTOM_RINGTONE_PATH)/sounds/ringtones/Rain.ogg:system/media/ringtones/Rain.ogg \
    $(CUSTOM_RINGTONE_PATH)/sounds/ringtones/Rainbow.ogg:system/media/ringtones/Rainbow.ogg \
    $(CUSTOM_RINGTONE_PATH)/sounds/ringtones/Rhythm.ogg:system/media/ringtones/Rhythm.ogg \
    $(CUSTOM_RINGTONE_PATH)/sounds/ringtones/Sunshine.ogg:system/media/ringtones/Sunshine.ogg \
    $(CUSTOM_RINGTONE_PATH)/sounds/ringtones/Wooden.ogg:system/media/ringtones/Wooden.ogg
