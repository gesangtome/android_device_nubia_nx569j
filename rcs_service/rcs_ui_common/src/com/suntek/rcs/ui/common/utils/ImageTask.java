/*
 * Copyright (c) 2015 pci-suntektech Technologies, Inc.  All Rights Reserved.
 * pci-suntektech Technologies Proprietary and Confidential.

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

import android.widget.ImageView;

public class ImageTask {
    private String url;
    private ImageView imageView;
    private int emptyImgID = -1;
    private int errorImgID = -1;
    private boolean canceled;
    private boolean loading;

    public ImageTask(String url, ImageView imageView) {
        this(url, imageView, -1, -1);
    }

    public ImageTask(String url, ImageView imageView, int emptyImgID, int errorImgID) {
        super();
        this.url = url;
        this.imageView = imageView;
        this.emptyImgID = emptyImgID;
        this.errorImgID = errorImgID;
        this.canceled = false;
        this.loading = false;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public int getEmptyImgID() {
        return emptyImgID;
    }

    public void setEmptyImgID(int emptyImgID) {
        this.emptyImgID = emptyImgID;
    }

    public int getErrorImgID() {
        return errorImgID;
    }

    public void setErrorImgID(int errorImgID) {
        this.errorImgID = errorImgID;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public boolean isLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

}
