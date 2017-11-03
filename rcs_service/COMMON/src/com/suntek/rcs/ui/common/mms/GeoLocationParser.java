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

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.suntek.rcs.ui.common.mms.GeoLocation;

public class GeoLocationParser extends DefaultHandler {

    /** The accumulator. */
    private StringBuffer accumulator;

    /** The geo location. */
    private GeoLocation geoLocation = new GeoLocation();

    /**
     * Instantiates a new geo location parser.
     *
     * @param input
     *            the input
     * @throws Exception
     *             the exception
     */
    public GeoLocationParser(InputStream input) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(input, this);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
     */
    @Override
    public void characters(char buffer[], int start, int length) {
        accumulator.append(buffer, start, length);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.xml.sax.helpers.DefaultHandler#endDocument()
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
     * java.lang.String, java.lang.String)
     */
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        super.endElement(uri, localName, qName);

        String value = accumulator.toString();

        if (localName.equals("pos")) {
            String geoLocs[] = value.split(" ");
            double lat = 0;
            double lng = 0;
            if (geoLocs.length >= 2) {
                try {
                    lat = Double.parseDouble(geoLocs[0]);
                    lng = Double.parseDouble(geoLocs[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            geoLocation.setLng(lng);
            geoLocation.setLat(lat);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.xml.sax.helpers.DefaultHandler#startDocument()
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        accumulator = new StringBuffer();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
     * java.lang.String, java.lang.String, org.xml.sax.Attributes)
     */
    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        accumulator.setLength(0);
        if (localName.equals("rcspushlocation")) {
            String label = attributes.getValue("label");
            geoLocation.setLabel(label);
        }

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.xml.sax.helpers.DefaultHandler#warning(org.xml.sax.SAXParseException)
     */
    public void warning(SAXParseException exception) {
        // do nothing.
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.xml.sax.helpers.DefaultHandler#error(org.xml.sax.SAXParseException)
     */
    public void error(SAXParseException exception) {
        // do nothing.
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.xml.sax.helpers.DefaultHandler#fatalError(org.xml.sax.SAXParseException
     * )
     */
    public void fatalError(SAXParseException exception) throws SAXException {
        throw exception;
    }

    /**
     * Gets the geo location.
     *
     * @return the geo location
     */
    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

}
