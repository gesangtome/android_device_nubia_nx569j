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

package com.suntek.mway.rcs.client.api.profile;

import com.suntek.mway.rcs.client.aidl.plugin.callback.IProfileListener;
import com.suntek.mway.rcs.client.aidl.plugin.entity.profile.Avatar;
import com.suntek.mway.rcs.client.aidl.plugin.entity.profile.Profile;
import com.suntek.mway.rcs.client.api.log.LogHelper;

public abstract class QRImgListener extends IProfileListener.Stub {

    /**
     * The default implementation of this interface, the method did not want to
     * expose upward.
     */
    public void onProfileUpdated(int resultCode, String resultDesc) {
        LogHelper.d("onProfileUpdated(): resultCode --> " + resultCode + "resultDesc = "
                + resultDesc);
    }

    /**
     * The default implementation of this interface, the method did not want to
     * expose upward.
     */
    public void onAvatarUpdated(int resultCode, String resultDesc) {
        LogHelper.d("onAvatarUpdated(): resultCode --> " + resultCode + "resultDesc = "
                + resultDesc);
    }

    /**
     * The default implementation of this interface, the method did not want to
     * expose upward.
     */
    public void onAvatarGet(Avatar avatar, int resultCode, String resultDesc) {
        LogHelper.d("onAvatarGet(): resultCode --> " + resultCode + "resultDesc = " + resultDesc);
    }

    /**
     * The default implementation of this interface, the method did not want to
     * expose upward.
     */
    public void onProfileGet(Profile profile, int resultCode, String resultDesc) {
        LogHelper.d("onProfileGet(): resultCode --> " + resultCode + "resultDesc = " + resultDesc);
    }

}
