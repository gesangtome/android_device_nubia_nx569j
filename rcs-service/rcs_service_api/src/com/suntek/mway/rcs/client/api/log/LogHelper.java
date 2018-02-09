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

package com.suntek.mway.rcs.client.api.log;

import android.util.Log;

public final class LogHelper {

    /** The Constant OPEN_DEBUG. */
    public static final String OPEN_DEBUG = "_SETTING_SERVICE_OPEN_DEBUG";

    /** Is debug mode. */
    private static boolean mIsDebugMode = true;

    /** The log tag name. */
    private static String TAG = "RCS_Service_API";

    /** The Constant CLASS_METHOD_LINE_FORMAT. */
    private static final String CLASS_METHOD_LINE_FORMAT = "%s.%s()  Line:%d";

    /** The log's level. */
    private final static int logLevel = Log.VERBOSE;

    private static boolean isSensitiveLog = false;

    /**
     * Log.
     *
     * @param str the str
     * @param level the level
     */
    private static void log(String str, int level) {
        log(str, level, null);
    }

    /**
     * Log.
     *
     * @param str the str
     * @param level the level
     * @param throwable the throwable
     */
    private static void log(String str, int level, Throwable throwable) {
        if (mIsDebugMode) {
            if (logLevel <= level) {
                // Get the method name from the stackTrace.
                StackTraceElement[] array = Thread.currentThread().getStackTrace();
                StackTraceElement traceElement = (array != null && array.length > 5 ? array[5]
                        : array[array.length - 1]);
                String logText = String.format(CLASS_METHOD_LINE_FORMAT,
                        traceElement.getClassName(), traceElement.getMethodName(),
                        traceElement.getLineNumber());
                // ERROR, WARN, INFO, DEBUG, VERBOSE
                if (level == Log.VERBOSE) {
                    Log.v(TAG, logText + "->" + str);
                } else if (level == Log.DEBUG) {
                    Log.d(TAG, logText + "->" + str);
                } else if (level == Log.INFO) {
                    Log.i(TAG, logText + "->" + str);
                } else if (level == Log.WARN) {
                    Log.w(TAG, logText + "->" + str);
                } else if (level == Log.ERROR) {
                    if (throwable != null) {
                        Log.e(TAG, logText + "->" + str, throwable);
                    } else {
                        Log.e(TAG, logText + "->" + str);
                    }
                }
            }

        }
    }

    /**
     * Trace.
     *
     * @param str the str
     */
    public static void trace(String str) {
        log(str, Log.DEBUG);
    }

    /**
     * VERBOSE.
     *
     * @param str the str
     */
    public static void v(String str) {
        log(str, Log.VERBOSE);
    }

    /**
     * DEBUG.
     *
     * @param str the str
     */
    public static void d(String str) {
        log(str, Log.DEBUG);
    }

    /**
     * WARN.
     *
     * @param str the str
     */
    public static void w(String str) {
        log(str, Log.WARN);
    }

    /**
     * INFO.
     *
     * @param str the str
     */
    public static void i(String str) {
        log(str, Log.INFO);
    }

    /**
     * ERROR.
     *
     * @param str the str
     */
    public static void e(String str) {
        log(str, Log.ERROR);
    }

    /**
     * ERROR.
     *
     * @param str the str
     * @param throwable the throwable
     */
    public static void e(String str, Throwable throwable) {
        log(str, Log.ERROR, throwable);
    }

    public static String sensitive(String str) {
        if (isSensitiveLog) {
            return "*****";
        } else {
            return str;
        }
    }

    /**
     * Prints the stack trace.
     *
     * @param throwable the throwable
     */
    public static void printStackTrace(Throwable throwable) {
        if (mIsDebugMode) {
            Log.w(TAG, "", throwable);
        }
    }

}
