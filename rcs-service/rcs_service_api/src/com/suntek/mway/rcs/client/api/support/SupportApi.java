/*
 * Copyright (c) 2014-2015 pci-suntektech Technologies, Inc.  All Rights Reserved.
 * pci-suntektech Technologies Proprietary and Confidential.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to
 * deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */

package com.suntek.mway.rcs.client.api.support;

import com.suntek.mway.rcs.client.aidl.constant.Constants.PluginConstants;
import com.suntek.mway.rcs.client.aidl.constant.Main;
import com.suntek.mway.rcs.client.api.log.LogHelper;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.util.Log;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Dynamically detect the installation status of RCS components during runtime.
 *
 * @author lrb
 */
public class SupportApi {
    /**
     * The Profile plug-in that provided by CMCC.
     */
    public static final int PLUGIN_PROFILE = 0;

    /**
     * The Public Account plug-in that provided by CMCC.
     */
    public static final int PLUGIN_PUBLIC_ACCOUNT = 1;

    /**
     * The QR-Code plug-in that provided by CMCC.
     */
    public static final int PLUGIN_QR_CODE = 2;

    /**
     * The Enhance Call Screen plug-in that provided by CMCC.
     */
    public static final int PLUGIN_ENHANCE_CALL_SCREEN = 3;

    /**
     * The Cloud File Sharing plug-in that provided by CMCC.
     */
    public static final int PLUGIN_CLOUD_FILE_SHARING = 4;

    /**
     * The Emotions Store plug-in that provided by CMCC.
     */
    public static final int PLUGIN_EMOTIONS_STORE = 5;

    /**
     * The Plug-in Center plug-in that provided by CMCC.
     */
    public static final int PLUGIN_PLUGIN_CENTER = 6;

    private static final String TAG = "RCS_UI";

    private static final int DMS_VERSION_UNKNOWN = -999;

    private static final String PROPERTY_NAME_RCS_ENABLED = "persist.sys.rcs.enabled";

    private static final String PROPERTY_NAME_DM_VERSION = "persist.sys.rcs.dm.version";

    private static SupportApi instance;

    private SupportApi() {

    }

    public synchronized static SupportApi getInstance() {
        if (instance == null) {
            instance = new SupportApi();
        }
        return instance;
    }

    /**
     * Check that the RcsService module is been installed.
     *
     * @param context
     * @return true if RcsService module is installed.
     */
    public boolean isServiceInstalled(Context context) {
        return isPackageInstalled(context, Main.PACKAGE_NAME);
    }

    /**
     * Check that the RcsService module is been installed.
     *
     * @param context
     * @return true if RcsService module is installed.
     */
    public boolean isPluginInstalled(Context context) {
        return isPackageInstalled(context, PluginConstants.CONST_PLUGIN_PACKAGE_NAME);
    }

    public boolean isPluginCenterInstalled(Context context) {
        return isPackageInstalled(context, PluginConstants.CONST_PLUGIN_CENTER_PACKAGE_NAME);
    }

    public void startPluginCenterApp(Context context) throws RemoteException {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setComponent(new ComponentName(PluginConstants.CONST_PLUGIN_CENTER_PACKAGE_NAME,
                PluginConstants.CONST_PLUGIN_CENTER_MAIN_ACTIVITY));
        context.startActivity(intent);
    }

    private boolean isPackageInstalled(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        List<ApplicationInfo> installedApps = pm
                .getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);

        for (ApplicationInfo info : installedApps) {
            if (packageName.equals(info.packageName)) {
                return true;
            }
        }

        return false;
    }

    private boolean mIsRcsServiceInstalled;

    public void initApi(Context context) {
        mIsRcsServiceInstalled = isServiceInstalled(context);
    }

    /**
     * Return whether the RCS is support. In general, use this method to define
     * whether the RCS related UI entrance should display. The result might not
     * accurate when it is still initializing. This is a compromise for
     * performance.
     *
     * @param context
     * @return Whether RCS is supported.
     */
    public boolean isRcsSupported() {
        return isRcsEnabled() && mIsRcsServiceInstalled && isSimAvailableForRcs();
    }

    public boolean isRcsSupported(int slotId){
        LogHelper.d("slotId:" + slotId);
        boolean result = false;

        try {
            // get default slot id
            int ddsSlotid = getDefaultDataSlotId();

            if (ddsSlotid == slotId) {
                result = isRcsSupported();
            }
        } catch (Exception e) {
            LogHelper.e(e.getMessage(), e);
        }

        return result;
    }

    public int getDefaultDataSlotId() {
        int slotId = -1;
        try {
            // get default sub id
            Object dataSubId = getDefaultDataSubId();

            // get slot id by sub id
            Class<?> subscriptionMgrClass = Class
                    .forName("android.telephony.SubscriptionManager");
            if (dataSubId instanceof Long) {
                Method getSlotIdMethod = subscriptionMgrClass.getMethod("getSlotId", long.class);
                slotId = (Integer)getSlotIdMethod.invoke(subscriptionMgrClass, (Long)dataSubId);
            } else if (dataSubId instanceof Integer) {
                Method getSlotIdMethod = subscriptionMgrClass.getMethod("getSlotId", int.class);
                slotId = (Integer)getSlotIdMethod.invoke(subscriptionMgrClass, (Integer)dataSubId);
            }

            LogHelper.d("slotId:" + slotId);
        } catch (Exception e) {
            LogHelper.e(e.getMessage(), e);
        }

        return slotId;
    }

    private Object getDefaultDataSubId() {
        Object dataSubId = null;
        try {
            Class<?> subscriptionMgrClass = Class.forName("android.telephony.SubscriptionManager");
            Method getDefaultDataSubIdMethod = subscriptionMgrClass
                    .getMethod("getDefaultDataSubId");
            dataSubId = getDefaultDataSubIdMethod.invoke(subscriptionMgrClass);
            LogHelper.d("dataSubId:" + dataSubId);
        } catch (Exception e) {
            LogHelper.e(e.getMessage(), e);
        }

        return dataSubId;
    }

    private boolean isSimAvailableForRcs() {
        int dmVersion = getDmVersion();
        Log.d(TAG, "DM version is " + dmVersion);

        // If the version is larger than 0, the SIM is available for RCS.
        return dmVersion > 0;
    }

    private int getDmVersion() {
        try {
            int dmVersion = SystemProperties.getInt(PROPERTY_NAME_DM_VERSION, DMS_VERSION_UNKNOWN);
            return dmVersion;
        } catch (Exception e) {
            Log.w(TAG, "Failed getting DM version. " + e.getMessage());
            return DMS_VERSION_UNKNOWN;
        }
    }

    private boolean isRcsEnabled() {
        boolean isRcsEnabled = SystemProperties.getBoolean(PROPERTY_NAME_RCS_ENABLED, false);
        Log.d(TAG, "isRcsEnabled(): " + isRcsEnabled);
        return isRcsEnabled;
    }
}
