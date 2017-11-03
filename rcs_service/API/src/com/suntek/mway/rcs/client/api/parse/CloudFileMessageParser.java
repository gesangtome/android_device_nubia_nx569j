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

package com.suntek.mway.rcs.client.api.parse;

import com.suntek.mway.rcs.client.aidl.plugin.entity.cloudfile.CloudFileMessage;

import java.math.BigDecimal;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * <p>
 * Title:Cloud file message parser.
 * </p>
 * <p>
 * Description:none
 * </p>
 * <p>
 * Copyright:Copyright (c) 2014
 * </p>
 * <p>
 * Company:pci-suntek
 * </p>
 *
 * @author yzx
 * @version 1.0
 */
public class CloudFileMessageParser extends DefaultHandler {

    /*
     * <?xml version="1.0" encoding="UTF-8"?> <cloudfile
     * xmlns="http://cloudfile.cmcc.com/types"> <filename>aa.xls</filename>
     * <filesize>36KB</filesize> <downloadurl>http://abc.com</downloadurl>
     * </cloudfile>
     */
    /** The message. */
    private CloudFileMessage message;

    /** The builder. */
    private StringBuilder builder;

    /**
     * Instantiates a new cloud file message parser.
     */
    public CloudFileMessageParser() {
        builder = new StringBuilder();
    }

    /*
     * (non-Javadoc)
     * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        builder.append(ch, start, length);
    }

    /*
     * (non-Javadoc)
     * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
     * java.lang.String, java.lang.String)
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        String s = builder.toString();

        if (localName.equals("filename")) {
            message.setFileName(s);
        } else if (localName.equals("filesize")) {
            int index = s.indexOf("KB");
            long l = 0L;
            if (index != -1) {
                s = s.substring(0, index);
                l = Long.parseLong(s);
            } else {
                try {
                    l = new BigDecimal(Double.parseDouble(s)/1024)
                        .setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
                } catch (Exception e) {
                    l = 0L;
                }
            }
            message.setFileSize(l);
        } else if (localName.equals("downloadurl")) {
            message.setShareUrl(s);
        }
    }

    /*
     * (non-Javadoc)
     * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
     * java.lang.String, java.lang.String, org.xml.sax.Attributes)
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        builder.setLength(0);

        if (localName.equals("cloudfile")) {
            message = new CloudFileMessage();
        }
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public CloudFileMessage getMessage() {
        return message;
    }
}
