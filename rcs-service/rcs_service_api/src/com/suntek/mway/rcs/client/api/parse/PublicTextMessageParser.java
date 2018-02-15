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

import com.suntek.mway.rcs.client.aidl.plugin.entity.pubacct.PublicTextMessage;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * <p>
 * Title:Public text message parser.
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
public class PublicTextMessageParser extends DefaultHandler {

    /*
     * <?xml version="1.0" encoding="UTF-8"?> <resource-lists
     * xmlns="urn:ietf:params:xml:ns:resource-lists"
     * xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     * xmlns:cp="urn:ietf:params:xml:ns:capacity"> <msg_content>
     * <media_type>10</media_type>
     * <create_time>2014-11-16T15:28:59+8:00</create_time>
     * <activeStatus>0</activeStatus> <forwardable>0</forwardable>
     * <text>content</text>
     * <pa_uuid>125200024018244177@as1.pa.rcs.chinamobile.com</pa_uuid>
     * </msg_content> </resource-lists>
     */

    /** The message. */
    private PublicTextMessage message;

    /** The builder. */
    private StringBuilder builder;

    /**
     * Instantiates a new public text message parser.
     */
    public PublicTextMessageParser() {
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

        if (localName.equals("create_time")) {
            message.setCreatetime(s);
        } else if (localName.equals("forwardable")) {
            message.setForwardable(Integer.parseInt(s));
        } else if (localName.equals("media_type")) {
            message.setMsgtype(s);
        } else if (localName.equals("text")) {
            message.setContent(s);
        } else if (localName.equals("activeStatus")) {
            message.setActiveStatus(Integer.parseInt(s));
        } else if (localName.equals("pa_uuid")) {
            message.setPaUuid(s);
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

        if (localName.equals("msg_content")) {
            message = new PublicTextMessage();
        }
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public PublicTextMessage getMessage() {
        return message;
    }
}
