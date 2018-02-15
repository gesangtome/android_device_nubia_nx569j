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

import android.text.InputFilter;
import android.text.Spanned;

public class RcsEditTextInputFilter implements InputFilter {
    private int unicodeLength = 0;

    public RcsEditTextInputFilter(int length) {
        this.unicodeLength = length;
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart,
            int dend) {
        if (source == null) {
            return "";
        }
        CharSequence result = null;
        int sourceCount = getWordCount(source.toString());
        int destCount = getWordCount(dest.toString());
        int keepCount = unicodeLength - destCount;
        int count = destCount + sourceCount;
        if (keepCount <= 0) {
            result= "";
        } else if (count <= unicodeLength) {
            result = source;
        } else {
            char[] sourceString = source.toString().toCharArray();
            int sourceStringLenght = sourceString.length;
            int charCount = keepCount;
            keepCount = 0;
            for (int i = 0; i < sourceStringLenght; i++) {
                if (getWordCount(sourceString[i]) == 3) {
                    charCount = charCount - 3;
                } else {
                    charCount--;
                }
                if (charCount <= 0) {
                    break;
                }
                keepCount++;
            }
            result = source.subSequence(start, start + keepCount);
        }
        return result;

    }

    public int getWordCount(CharSequence s) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int ascii = Character.codePointAt(s, i);
            if (isAsciiCode(ascii))
                length++;
            else
                length += 3;
        }
        return length;

    }

    private int getWordCount(char ascii) {
        if (ascii >= 0 && ascii <= 255)
            return 1;
        else
            return 3;
    }

    private boolean isAsciiCode(int ascii) {
        return ascii >= 0 && ascii < 0x80;
    }
}
