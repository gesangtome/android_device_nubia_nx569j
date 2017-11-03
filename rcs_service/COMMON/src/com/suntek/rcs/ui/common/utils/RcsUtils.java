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
package com.suntek.rcs.ui.common.utils;

import com.suntek.rcs.ui.common.RcsEmojiGifView;
import com.suntek.rcs.ui.common.RcsLog;

import java.io.Closeable;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class RcsUtils {

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dipValue * scale + 0.5f);
    }

    @SuppressWarnings("static-access")
    public static void closeKB(Activity activity) {
        if (activity.getCurrentFocus() != null) {
            ((InputMethodManager)activity.getSystemService(activity.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public static void openKB(Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager)context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public static void openPopupWindow(Context context, View view, byte[] data,
            int emojiPopupBgResId) {
        LinearLayout.LayoutParams mGifParam = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        if(bitmap == null){
            return;
        }
        int windowWidth = bitmap.getWidth() + RcsUtils.dip2px(context, 40);
        int windowHeight = bitmap.getHeight() + RcsUtils.dip2px(context, 40);
        ColorDrawable transparent = new ColorDrawable(Color.TRANSPARENT);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout
                .setLayoutParams(new LinearLayout.LayoutParams(windowWidth, windowHeight));
        relativeLayout.setBackgroundResource(emojiPopupBgResId);
        relativeLayout.setGravity(Gravity.CENTER);
        RcsEmojiGifView emojiGifView = new RcsEmojiGifView(context);
        emojiGifView.setLayoutParams(mGifParam);
        emojiGifView.setBackground(transparent);
        emojiGifView.setMonieByteData(data);
        relativeLayout.addView(emojiGifView);
        PopupWindow popupWindow = new PopupWindow(view, windowWidth, windowHeight);
        popupWindow.setBackgroundDrawable(transparent);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setContentView(relativeLayout);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        popupWindow.update();
    }

    public static void closeSilently(Closeable c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch(IOException e) {
            RcsLog.e(e);
        }
    }
}
