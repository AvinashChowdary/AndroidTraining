/*
 * Copyright 2014 Synchronoss Technologies, Inc.  All Rights Reserved.
 *
 * This source code is the confidential and proprietary information of
 * Synchronoss Technologies, Inc.
 *
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Synchronoss Technologies.
 */
package com.pcs.testxmlpullparser.retrofit.test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

import org.simpleframework.xml.Serializer;

import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.MimeUtil;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;


/**
 * A {@link retrofit.converter.Converter} which uses Simple XML for serialization and deserialization of entities.
 * @see <a href="http://simple.sourceforge.net/">http://simple.sourceforge.net/</a>
 */
public class SimpleXmlConverter implements Converter {

    /** The mime type. */
    private String mimeType = "application/xml; charset=UTF-8";

    /** The serializer. */
    private final Serializer serializer;

    /**
     * Constructs a SimpleXmlConverter using the given serializer.
     * @param serializer custom serializer
     */
    public SimpleXmlConverter(final Serializer serializer) {
        this.serializer = serializer;
    }

    /**
     * Instantiates a new simple xml converter.
     * @param mimetype the mimetype
     * @param serializer the serializer
     */
    public SimpleXmlConverter(final String mimetype, final Serializer serializer) {
        this.mimeType = mimetype;
        this.serializer = serializer;
    }

    /**
     * @see retrofit.converter.Converter#fromBody(retrofit.mime.TypedInput, java.lang.reflect.Type)
     */
    @SuppressWarnings("resource")
    @Override
    public Object fromBody(final TypedInput body, final Type type) throws ConversionException {
        String charset = Utils.UTF8;
        if (body.mimeType() != null) {
            charset = MimeUtil.parseCharset(body.mimeType());
        }
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(body.in(), charset);
            return serializer.read((Class<?>) type, isr, true);
        } catch (final Exception e) {
            throw new ConversionException(e);
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException ex) {

                }
            }
        }
    }

    /**
     * @see retrofit.converter.Converter#toBody(java.lang.Object)
     */
    @Override
    public TypedOutput toBody(final Object object) {
        final StringWriter stringWriter = new StringWriter();
        try {
            serializer.write(object, stringWriter);
            return new XmlTypedOutput(stringWriter.toString().getBytes(Utils.UTF8), mimeType);
        } catch (final UnsupportedEncodingException e) {
            throw new AssertionError(e);
        } catch (final Exception e) {

            return null;
        }
    }

    /**
     * The Class XmlTypedOutput.
     */
    private static class XmlTypedOutput implements TypedOutput {

        /** The mime type. */
        private final String mimeType;

        /** The xml bytes. */
        private final byte[] xmlBytes;

        /**
         * Instantiates a new xml typed output.
         * @param xmlBytes the xml bytes
         * @param mimeType the mime type
         */
        XmlTypedOutput(final byte[] xmlBytes, final String mimeType) {
            this.xmlBytes = xmlBytes;
            this.mimeType = mimeType;
        }

        /**
         * @see retrofit.mime.TypedOutput#fileName()
         */
        @Override
        public String fileName() {
            return null;
        }

        /**
         * @see retrofit.mime.TypedOutput#length()
         */
        @Override
        public long length() {
            return xmlBytes.length;
        }

        /**
         * @see retrofit.mime.TypedOutput#mimeType()
         */
        @Override
        public String mimeType() {
            return mimeType;
        }

        /**
         * @see retrofit.mime.TypedOutput#writeTo(java.io.OutputStream)
         */
        @Override
        public void writeTo(final OutputStream out) throws IOException {
            out.write(xmlBytes);
        }
    }

}
