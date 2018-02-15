/*
 * Copyright (c) 2015 pci-suntektech Technologies, Inc.  All Rights Reserved.
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
package com.suntek.rcs.ui.common;

import android.os.SystemProperties;
import android.util.Log;

/**
 * Log utilities class for RCS. Default log level is
 * {@link com.suntek.rcs.ui.common.RcsLog#DEFAULT_LOG_LEVEL}.
 */
public class RcsLog {
    private static final int LOG_LEVEL_NONE = 0;

    private static final int LOG_LEVEL_VERBOSE = 1;

    private static final int LOG_LEVEL_DEBUG = 2;

    private static final int LOG_LEVEL_INFO = 3;

    private static final int LOG_LEVEL_WARNNING = 4;

    private static final int LOG_LEVEL_ERROR = 5;

    private static final int DEFAULT_LOG_LEVEL = LOG_LEVEL_VERBOSE;

    private static final String LOG_LEVEL_PROPERTIES = "persist.sys.rcs.log.level";

    private static String sTag = "RCS_UI";

    public static void v(String msg) {
        int logLevel = getLogLevel();
        if (logLevel > 0 && logLevel <= LOG_LEVEL_VERBOSE) {
            Log.v(sTag, msg);
        }
    }

    public static void d(String msg) {
        int logLevel = getLogLevel();
        if (logLevel > 0 && logLevel <= LOG_LEVEL_DEBUG) {
            Log.d(sTag, msg);
        }
    }

    public static void i(String msg) {
        int logLevel = getLogLevel();
        if (logLevel > 0 && logLevel <= LOG_LEVEL_INFO) {
            Log.i(sTag, msg);
        }
    }

    public static void w(String msg) {
        int logLevel = getLogLevel();
        if (logLevel > 0 && logLevel <= LOG_LEVEL_WARNNING) {
            Log.w(sTag, msg);
        }
    }

    public static void w(Throwable tr) {
        int logLevel = getLogLevel();
        if (logLevel > 0 && logLevel <= LOG_LEVEL_WARNNING) {
            Log.w(sTag, tr);
        }
    }

    public static void w(String msg, Throwable tr) {
        int logLevel = getLogLevel();
        if (logLevel > 0 && logLevel <= LOG_LEVEL_WARNNING) {
            Log.w(sTag, msg, tr);
        }
    }

    public static void e(String msg) {
        int logLevel = getLogLevel();
        if (logLevel > 0 && logLevel <= LOG_LEVEL_ERROR) {
            Log.e(sTag, msg);
        }
    }

    public static void e(Throwable tr) {
        int logLevel = getLogLevel();
        if (logLevel > 0 && logLevel <= LOG_LEVEL_ERROR) {
            Log.e(sTag, "", tr);
        }
    }

    public static void e(String msg, Throwable tr) {
        int logLevel = getLogLevel();
        if (logLevel > 0 && logLevel <= LOG_LEVEL_ERROR) {
            Log.e(sTag, msg, tr);
        }
    }

    private static int getLogLevel() {
        return SystemProperties.getInt(LOG_LEVEL_PROPERTIES, DEFAULT_LOG_LEVEL);
    }

    public static void setTag(String tag) {
        sTag = tag;
    }
}
