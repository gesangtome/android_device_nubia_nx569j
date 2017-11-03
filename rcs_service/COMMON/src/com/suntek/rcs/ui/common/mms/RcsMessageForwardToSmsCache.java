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

package com.suntek.rcs.ui.common.mms;

import java.util.HashMap;
import java.util.Iterator;

public class RcsMessageForwardToSmsCache {

    private static RcsMessageForwardToSmsCache sInstance = new RcsMessageForwardToSmsCache();

    private static HashMap<Long[], String[]> mMessageCache;

    private RcsMessageForwardToSmsCache() {
        mMessageCache = new HashMap<Long[], String[]>();
    }

    public static RcsMessageForwardToSmsCache getInstance() {
        if (sInstance == null) {
            sInstance = new RcsMessageForwardToSmsCache();
        }
        return sInstance;
    }

    public void addSendMessage(Long[] ids, String[] value) {
        mMessageCache.put(ids, value);
    }

    public String[] getCacheVaule(Long[] ids) {
        return mMessageCache.get(ids);
    }

    public void clearCacheMessage() {
        mMessageCache.clear();
    }

    public Iterator<Long[]> getChachIterator() {
        return mMessageCache.keySet().iterator();
    }

    public HashMap<Long[], String[]> getCacheMessage() {
        return mMessageCache;
    }
}
