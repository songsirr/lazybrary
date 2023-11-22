package com.lazybrary.file;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

public class StreamUtil {

    public static final int DEFAULT_BUFFER_SIZE = 4096;

    public static final int DEFAULT_CONNECT_TIMEOUT = 10000;

    public static final int DEFAULT_READ_TIMEOUT = 60000;

    public static InputStream getInputStream(final Object obj)
            throws IOException, IllegalArgumentException {
        InputStream stream = null;
        byte[] bytes = null;

        if (obj instanceof InputStream) {
            stream = (InputStream) obj;
        } else if (obj instanceof URL) {
            stream = getURLInputStream((URL) obj);
        } else if (obj instanceof File) {
            stream = new BufferedInputStream(new FileInputStream((File) obj));
        } else if (obj instanceof byte[]) {
            bytes = (byte[]) obj;
        } else if (obj instanceof String) {
            File file = new File((String)obj);
            if (file.isFile()) {
                stream = new BufferedInputStream(new FileInputStream(file));
            } else {
                bytes = ((String) obj).getBytes();
            }
        } else {
            throw new IllegalArgumentException(
                    "Unsupported type, please input URL or File or byte[] or String");
        }

        if (bytes != null) {
            stream = new ByteArrayInputStream(bytes);
        }

        return stream;
    }

    public static InputStream getURLInputStream(final URL url)
            throws IOException {
        return getURLInputStream(url, DEFAULT_CONNECT_TIMEOUT,
                DEFAULT_READ_TIMEOUT);
    }

    public static InputStream getURLInputStream(final URL url, final int connectTimeout, final int readTimeout)
            throws IOException {
        InputStream in = null;

        URLConnection conn = url.openConnection();
        conn.setRequestProperty("Accept-Encoding", "gzip");
        conn.setConnectTimeout(connectTimeout);
        conn.setReadTimeout(readTimeout);

        // connect
        conn.connect();

        // get response
        in = conn.getInputStream();
        String contentEncoding = conn.getContentEncoding();
        if (contentEncoding != null && contentEncoding.equals("gzip")) {
            in = new GZIPInputStream(in);
        }

        return in;
    }

    public static OutputStream getOutputStream(final Object obj, final boolean append)
            throws IOException {
        OutputStream stream = null;

        if (obj instanceof OutputStream) {
            stream = (OutputStream) obj;
        } else if (obj instanceof File) {
            File file = (File) obj;
            // create parent directory first, if needed
            File parent = file.getAbsoluteFile().getParentFile();
            if (!parent.exists() && !parent.mkdirs()) {
                throw new IOException("Unable to create directory "
                        + parent.getAbsolutePath());
            }
            if (!parent.canWrite()) {
                throw new IOException(
                        "Do not have write permission for directory "
                                + parent.getAbsolutePath());
            }

            stream = new BufferedOutputStream(
                    new FileOutputStream(file, append));
        } else {
            throw new IllegalArgumentException(
                    "Expected an OutputStream or File");
        }

        return stream;
    }
}
