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

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayInputStream;

public class RcsEmojiGifView extends ImageView {

    private Movie mGifMovie;

    private long mMovieStart;

    private int mCurrentMovieTime = 0;

    private float mMovieLeft;

    private float mMovieTop;

    private float mMovieScale;

    private int mMovieWidth;

    private int mMovieHeight;

    private boolean mIsVisible = true;

    public RcsEmojiGifView(Context context) {
        super(context, null, 0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
    }

    public void setMonieByteData(byte[] data) {
        ByteArrayInputStream is = new ByteArrayInputStream(data);
        this.mGifMovie = Movie.decodeStream(is);
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mGifMovie != null) {
            int movieWidth = mGifMovie.width();
            int movieHeight = mGifMovie.height();
            float scaleH = 1f;
            int measureModeWidth = MeasureSpec.getMode(widthMeasureSpec);
            if (measureModeWidth != MeasureSpec.UNSPECIFIED) {
                int maximumWidth = MeasureSpec.getSize(widthMeasureSpec);
                if (movieWidth > maximumWidth)
                    scaleH = (float)movieWidth / (float)maximumWidth;
            }
            float scaleW = 1f;
            int measureModeHeight = MeasureSpec.getMode(heightMeasureSpec);
            if (measureModeHeight != MeasureSpec.UNSPECIFIED) {
                int maximumHeight = MeasureSpec.getSize(heightMeasureSpec);
                if (movieHeight > maximumHeight)
                    scaleW = (float)movieHeight / (float)maximumHeight;
            }
            mMovieScale = 1f / Math.max(scaleH, scaleW);
            mMovieWidth = (int)(movieWidth * mMovieScale);
            mMovieHeight = (int)(movieHeight * mMovieScale);
            setMeasuredDimension(mMovieWidth, mMovieHeight);
        } else {
            setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mMovieLeft = (getWidth() - mMovieWidth) / 2f;
        mMovieTop = (getHeight() - mMovieHeight) / 2f;
        mIsVisible = getVisibility() == View.VISIBLE;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mGifMovie != null) {
            updateMovieTime();
            drawMovieFraming(canvas);
            disableMovieView();
        }
    }

    @Override
    public void onScreenStateChanged(int screenState) {
        super.onScreenStateChanged(screenState);
        mIsVisible = screenState == SCREEN_STATE_ON;
        disableMovieView();
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        mIsVisible = visibility == View.VISIBLE;
        disableMovieView();
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        mIsVisible = visibility == View.VISIBLE;
        disableMovieView();
    }

    private void disableMovieView() {
        if (mIsVisible) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
                postInvalidateOnAnimation();
            else
                invalidate();
        }
    }

    private void updateMovieTime() {
        long now = SystemClock.uptimeMillis();
        if (mMovieStart == 0)
            mMovieStart = now;
        int dur = mGifMovie.duration();
        if (dur == 0)
            dur = 1000;
        mCurrentMovieTime = (int)((now - mMovieStart) % dur);
    }

    private void drawMovieFraming(Canvas canvas) {
        mGifMovie.setTime(mCurrentMovieTime);
        canvas.save(Canvas.MATRIX_SAVE_FLAG);
        canvas.scale(mMovieScale, mMovieScale);
        mGifMovie.draw(canvas, mMovieLeft / mMovieScale, mMovieTop / mMovieScale);
        canvas.restore();
    }

}
