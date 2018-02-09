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

import com.suntek.mway.rcs.client.aidl.plugin.entity.pubacct.PublicMediaMessage;
import com.suntek.mway.rcs.client.aidl.plugin.entity.pubacct.PublicMediaMessage.PublicMediaContent;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * <p>
 * Title:Public media message parser.
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
public class PublicMediaMessageParser extends DefaultHandler {

    /*
     * <?xml version="1.0" encoding="UTF-8"?> <resource-lists
     * xmlns="urn:ietf:params:xml:ns:resource-lists"
     * xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     * xmlns:cp="urn:ietf:params:xml:ns:capacity"> <msg_content>
     * <media_type>20</media_type>
     * <create_time>2014-11-16T14:44:14+8:00</create_time>
     * <activeStatus>0</activeStatus> <forwardable>0</forwardable> <pic>
     * <filesize>48828</filesize> <filetype>jpg</filetype>
     * <media_uuid>3290</media_uuid>
     * <original_link>http://60.194.14.154/Public/Uploads
     * /user/7/5/19/9/1002407519/imgs/54125d38942ecSRC.jpg</original_link>
     * <thumb_link
     * >http://60.194.14.154/Public/Uploads/user/7/5/19/9/1002407519/imgs
     * /54125d38942ec.jpg</thumb_link> <title>a.jpg</title> </pic>
     * <pa_uuid>125200024018244177@as1.pa.rcs.chinamobile.com</pa_uuid>
     * </msg_content> </resource-lists> <?xml version="1.0" encoding="UTF-8"?>
     * <resource-lists xmlns="urn:ietf:params:xml:ns:resource-lists"
     * xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     * xmlns:cp="urn:ietf:params:xml:ns:capacity"> <msg_content>
     * <media_type>40</media_type>
     * <create_time>2014-11-16T14:32:50+8:00</create_time>
     * <activeStatus>0</activeStatus> <forwardable>0</forwardable> <audio>
     * <duration>2</duration> <filesize>3238</filesize> <filetype>mp3</filetype>
     * <media_uuid>4105</media_uuid>
     * <original_link>http://60.194.14.154/Public/Uploads
     * /user/7/5/19/9/1002407519/audio/54630e41cb5a3SRC.amr</original_link>
     * <thumb_link
     * >http://60.194.14.154/Public/Uploads/user/7/5/19/9/1002407519/audio
     * /54630e41cb5a3.mp3</thumb_link> <title>audio.amr</title> </audio>
     * <pa_uuid>125200024018244177@as1.pa.rcs.chinamobile.com</pa_uuid>
     * </msg_content> </resource-lists> <?xml version="1.0" encoding="UTF-8"?>
     * <resource-lists xmlns="urn:ietf:params:xml:ns:resource-lists"
     * xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     * xmlns:cp="urn:ietf:params:xml:ns:capacity"> <msg_content>
     * <media_type>30</media_type>
     * <create_time>2014-11-16T14:34:38+8:00</create_time>
     * <activeStatus>0</activeStatus> <forwardable>0</forwardable> <video>
     * <duration>0</duration> <filesize>0</filesize> <filetype>mp4</filetype>
     * <media_uuid>4166</media_uuid>
     * <original_link>http://60.194.14.154/Public/Uploads
     * /user/7/5/19/9/1002407519/video/546844dee1b82.mp4</original_link>
     * <thumb_link
     * >http://60.194.14.154/Public/Uploads/user/7/5/19/9/1002407519/video
     * /546844dee1b82.jpg</thumb_link> <title>r1412834140513169658.mp4</title>
     * </video> <pa_uuid>125200024018244177@as1.pa.rcs.chinamobile.com</pa_uuid>
     * </msg_content> </resource-lists>
     */
    /** The message. */
    private PublicMediaMessage message;

    /** The content. */
    private PublicMediaContent content;

    /** The builder. */
    private StringBuilder builder;

    /**
     * Instantiates a new public media message parser.
     */
    public PublicMediaMessageParser() {
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

        else if (localName.equals("thumb_link")) {
            content.setThumbLink(s);
        } else if (localName.equals("original_link")) {
            content.setOriginalLink(s);
        } else if (localName.equals("title")) {
            content.setTitle(s);
        } else if (localName.equals("filesize")) {
            content.setFileSize(s);
        } else if (localName.equals("duration")) {
            content.setDuration(s);
        } else if (localName.equals("filetype")) {
            content.setFileType(s);
            // } else if (localName.equals("createtime")) {
            // content.setCreatetime(s);
        } else if (localName.equals("media_uuid")) {
            content.setMediaUuid(s);
        }

        else if (localName.equals("pic") ||
                localName.equals("audio") || localName.equals("video")) {
            message.setMedia(content);
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
            message = new PublicMediaMessage();
        } else if (localName.equals("pic") || localName.equals("audio")
                || localName.equals("video")) {
            content = new PublicMediaContent();
        }
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public PublicMediaMessage getMessage() {
        return message;
    }
}
