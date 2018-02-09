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

import com.suntek.mway.rcs.client.aidl.plugin.entity.pubacct.PublicTopicMessage;
import com.suntek.mway.rcs.client.aidl.plugin.entity.pubacct.PublicTopicMessage.PublicTopicContent;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * <p>
 * Title:Public topic message parser.
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
public class PublicTopicMessageParser extends DefaultHandler {

    /*
     * <?xml version="1.0" encoding="UTF-8"?> <resource-lists
     * xmlns="urn:ietf:params:xml:ns:resource-lists"
     * xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     * xmlns:cp="urn:ietf:params:xml:ns:capacity"> <msg_content>
     * <media_type>51</media_type>
     * <create_time>2014-11-16T14:37:18+8:00</create_time>
     * <activeStatus>0</activeStatus> <forwardable>0</forwardable> <article>
     * <mediaarticle> <author>1002407519</author>
     * <main_text>single_text</main_text> <media_uuid>2411</media_uuid>
     * <original_link
     * >http://60.194.14.154/Public/Uploads/user/7/5/19/9/1002407519
     * /imgs/54125a77b1dff.jpg</original_link>
     * <source_link>http://60.194.14.154/</source_link>
     * <thumb_link>http://60.194
     * .14.154/Public/Uploads/user/7/5/19/9/1002407519/imgs
     * /54125a77b1dff.jpg</thumb_link> <title>single_title</title>
     * </mediaarticle> </article>
     * <pa_uuid>125200024018244177@as1.pa.rcs.chinamobile.com</pa_uuid>
     * </msg_content> </resource-lists> <?xml version="1.0" encoding="utf-8"?>
     * <resource-lists xmlns="urn:ietf:params:xml:ns:resource-lists"
     * xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     * xmlns:cp="urn:ietf:params:xml:ns:capacity"> <msg_content>
     * <media_type>52</media_type>
     * <create_time>2014-11-16T14:39:39+8:00</create_time>
     * <activeStatus>0</activeStatus> <forwardable>0</forwardable> <article>
     * <mediaarticle> <author>1002407519</author> <main_text/>
     * <media_uuid>2400</media_uuid>
     * <original_link>http://60.194.14.154/Public/Uploads
     * /user/7/5/19/9/1002407519/imgs/54125d38942ec.jpg</original_link>
     * <source_link>http://60.194.14.154/</source_link>
     * <thumb_link>http://60.194
     * .14.154/Public/Uploads/user/7/5/19/9/1002407519/imgs
     * /54125d38942ec.jpg</thumb_link> <title>more1_title</title>
     * </mediaarticle> <mediaarticle> <author>1002407519</author> <main_text/>
     * <media_uuid>2400</media_uuid>
     * <original_link>http://60.194.14.154/Public/Uploads
     * /user/7/5/19/9/1002407519/imgs/54125cdcaec52.jpg</original_link>
     * <source_link>http://60.194.14.154/</source_link>
     * <thumb_link>http://60.194
     * .14.154/Public/Uploads/user/7/5/19/9/1002407519/imgs
     * /54125cdcaec52.jpg</thumb_link> <title>more2_title</title>
     * </mediaarticle> </article>
     * <pa_uuid>125200024018244177@as1.pa.rcs.chinamobile.com</pa_uuid>
     * </msg_content> </resource-lists>
     */
    /** The message. */
    private PublicTopicMessage message;

    /** The contents. */
    private List<PublicTopicContent> contents;

    /** The content. */
    private PublicTopicContent content;

    /** The builder. */
    private StringBuilder builder;

    /**
     * Instantiates a new public topic message parser.
     */
    public PublicTopicMessageParser() {
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
        } else if (localName.equals("activeStatus")) {
            message.setActiveStatus(Integer.parseInt(s));
        } else if (localName.equals("pa_uuid")) {
            message.setPaUuid(s);
        }

        else if (localName.equals("title")) {
            content.setTitle(s);
        } else if (localName.equals("author")) {
            content.setAuthor(s);
        } else if (localName.equals("thumb_link")) {
            content.setThumbLink(s);
        } else if (localName.equals("original_link")) {
            content.setOriginalLink(s);
        } else if (localName.equals("source_link")) {
            content.setSourceLink(s);
        } else if (localName.equals("media_uuid")) {
            content.setMediaUuid(s);
        } else if (localName.equals("main_text")) {
            content.setMainText(s);
        } else if (localName.equals("body_link")) {
            content.setBodyLink(s);
        }

        else if (localName.equals("mediaarticle")) {
            contents.add(content);
        } else if (localName.equals("article")) {
            message.setTopics(contents);
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
            message = new PublicTopicMessage();
        } else if (localName.equals("article")) {
            contents = new ArrayList<PublicTopicContent>();
        } else if (localName.equals("mediaarticle")) {
            content = new PublicTopicContent();
        }
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public PublicTopicMessage getMessage() {
        return message;
    }
}
