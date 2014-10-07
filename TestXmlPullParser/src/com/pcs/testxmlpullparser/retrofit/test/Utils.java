package com.pcs.testxmlpullparser.retrofit.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;

import android.util.Log;

public class Utils {
    /** The Constant UTF8. */
    public static final String UTF8 = "UTF-8";
    /** The Constant DEFAULT_BUFFER_SIZE. */
    public static final int DEFAULT_BUFFER_SIZE = 1024;
    private static final String TAG = Utils.class.getSimpleName();

    /**
     * To string.
     * @param input the input
     * @return the string
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static String toString(final InputStream input) throws IOException {
        final StringWriter sw = new StringWriter();
        copy(input, sw);
        return sw.toString();
    }

    /**
     * Copy.
     * @param input the input
     * @param output the output
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @SuppressWarnings("resource")
    private static void copy(final InputStream input, final Writer output) throws IOException {
        InputStreamReader in = null;
        try {
            in = new InputStreamReader(input);
            final char[] buffer = new char[DEFAULT_BUFFER_SIZE];
            long count = 0;
            int n = 0;
            while (-1 != (n = in.read(buffer))) {
                output.write(buffer, 0, n);
                count += n;
            }
            Log.i(TAG, "Read bytes : " + count);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                }
            }
        }
    }
}
