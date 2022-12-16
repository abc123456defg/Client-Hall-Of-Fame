// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import java.util.regex.Matcher;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.io.File;
import java.util.zip.ZipEntry;
import java.io.FilterInputStream;
import java.util.zip.ZipFile;
import java.net.MalformedURLException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.regex.Pattern;

public class URLUtil
{
    public static final String SCHEME_SEPARATOR = "://";
    public static final String FILE_PROTOCOL = "file";
    public static final String HTTP_PROTOCOL = "http";
    public static final String JAR_PROTOCOL = "jar";
    public static final String JAR_SEPARATOR = "!/";
    public static final Pattern DATA_URI_PATTERN;
    
    private URLUtil() {
    }
    
    public static InputStream openStream(final URL url) throws IOException {
        final String protocol = url.getProtocol();
        final boolean isFile = protocol.equals("jar") && !url.getFile().startsWith("http");
        return isFile ? openJarStream(url) : url.openStream();
    }
    
    public static InputStream openResourceStream(final URL url) throws IOException {
        try {
            return openStream(url);
        }
        catch (FileNotFoundException ex) {
            final String protocol = url.getProtocol();
            String file = null;
            if (protocol.equals("file")) {
                file = url.getFile();
            }
            else if (protocol.equals("jar")) {
                final int pos = url.getFile().indexOf("!");
                if (pos >= 0) {
                    file = url.getFile().substring(pos + 1);
                }
            }
            if (file != null && file.startsWith("/")) {
                final InputStream resourceStream = URLUtil.class.getResourceAsStream(file);
                if (resourceStream != null) {
                    return resourceStream;
                }
            }
            throw ex;
        }
    }
    
    private static InputStream openJarStream(final URL url) throws IOException {
        final Pair<String, String> paths = splitJarUrl(url.getFile());
        if (paths == null) {
            throw new MalformedURLException(url.getFile());
        }
        final ZipFile zipFile = new ZipFile(unquote(paths.first));
        final ZipEntry zipEntry = zipFile.getEntry(paths.second);
        if (zipEntry == null) {
            throw new FileNotFoundException("Entry " + paths.second + " not found in " + paths.first);
        }
        return new FilterInputStream(zipFile.getInputStream(zipEntry)) {
            @Override
            public void close() throws IOException {
                super.close();
                zipFile.close();
            }
        };
    }
    
    public static String unquote(String urlString) {
        urlString = urlString.replace('/', File.separatorChar);
        return unescapePercentSequences(urlString);
    }
    
    public static Pair<String, String> splitJarUrl(final String fullPath) {
        final int delimiter = fullPath.indexOf("!/");
        if (delimiter >= 0) {
            final String resourcePath = fullPath.substring(delimiter + 2);
            String jarPath = fullPath.substring(0, delimiter);
            if (StringUtil.startsWithConcatenation(jarPath, "file", ":")) {
                jarPath = jarPath.substring("file".length() + 1);
                return Pair.create(jarPath, resourcePath);
            }
        }
        return null;
    }
    
    public static String unescapePercentSequences(final String s) {
        if (s.indexOf(37) == -1) {
            return s;
        }
        final StringBuilder decoded = new StringBuilder();
        final int len = s.length();
        int i = 0;
        while (i < len) {
            final char c = s.charAt(i);
            if (c == '%') {
                final ArrayList<Integer> bytes = new ArrayList<Integer>();
                while (i + 2 < len && s.charAt(i) == '%') {
                    final int d1 = decode(s.charAt(i + 1));
                    final int d2 = decode(s.charAt(i + 2));
                    if (d1 == -1 || d2 == -1) {
                        break;
                    }
                    bytes.add((d1 & 0xF) << 4 | (d2 & 0xF));
                    i += 3;
                }
                if (!bytes.isEmpty()) {
                    final byte[] bytesArray = new byte[bytes.size()];
                    for (int j = 0; j < bytes.size(); ++j) {
                        bytesArray[j] = bytes.get(j).byteValue();
                    }
                    decoded.append(new String(bytesArray, Charset.forName("UTF-8")));
                    continue;
                }
            }
            decoded.append(c);
            ++i;
        }
        return decoded.toString();
    }
    
    private static int decode(final char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'a' + 10;
        }
        if (c >= 'A' && c <= 'F') {
            return c - 'A' + 10;
        }
        return -1;
    }
    
    public static boolean containsScheme(final String url) {
        return url.contains("://");
    }
    
    public static boolean isDataUri(final String value) {
        return !value.isEmpty() && value.startsWith("data:", (value.charAt(0) == '\"' || value.charAt(0) == '\'') ? 1 : 0);
    }
    
    public static byte[] getBytesFromDataUri(final String dataUrl) {
        final Matcher matcher = URLUtil.DATA_URI_PATTERN.matcher(StringUtil.stripQuotesAroundValue(dataUrl));
        if (matcher.matches()) {
            try {
                final String content = matcher.group(4);
                final Charset charset = Charset.forName("UTF-8");
                final byte[] bytes = content.getBytes(charset);
                return ";base64".equalsIgnoreCase(matcher.group(3)) ? Base64Converter.decode(bytes) : bytes;
            }
            catch (IllegalArgumentException e) {
                return null;
            }
        }
        return null;
    }
    
    static {
        DATA_URI_PATTERN = Pattern.compile("data:([^,;]+/[^,;]+)(;charset=[^,;]+)?(;base64)?,(.+)");
    }
}
