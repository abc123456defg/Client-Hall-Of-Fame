// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j;

import java.io.Closeable;
import org.slf4j.spi.SLF4JServiceProvider;
import org.slf4j.helpers.NOPMDCAdapter;
import org.slf4j.helpers.Util;
import java.util.Deque;
import java.util.Map;
import org.slf4j.spi.MDCAdapter;

public class MDC
{
    static final String NULL_MDCA_URL = "http://www.slf4j.org/codes.html#null_MDCA";
    private static final String MDC_APAPTER_CANNOT_BE_NULL_MESSAGE = "MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA";
    static final String NO_STATIC_MDC_BINDER_URL = "http://www.slf4j.org/codes.html#no_static_mdc_binder";
    static MDCAdapter mdcAdapter;
    
    private MDC() {
    }
    
    public static void put(final String key, final String val) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        if (MDC.mdcAdapter == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        MDC.mdcAdapter.put(key, val);
    }
    
    public static MDCCloseable putCloseable(final String key, final String val) throws IllegalArgumentException {
        put(key, val);
        return new MDCCloseable(key);
    }
    
    public static String get(final String key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        if (MDC.mdcAdapter == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        return MDC.mdcAdapter.get(key);
    }
    
    public static void remove(final String key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        if (MDC.mdcAdapter == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        MDC.mdcAdapter.remove(key);
    }
    
    public static void clear() {
        if (MDC.mdcAdapter == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        MDC.mdcAdapter.clear();
    }
    
    public static Map<String, String> getCopyOfContextMap() {
        if (MDC.mdcAdapter == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        return MDC.mdcAdapter.getCopyOfContextMap();
    }
    
    public static void setContextMap(final Map<String, String> contextMap) {
        if (MDC.mdcAdapter == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        MDC.mdcAdapter.setContextMap(contextMap);
    }
    
    public static MDCAdapter getMDCAdapter() {
        return MDC.mdcAdapter;
    }
    
    public static void pushByKey(final String key, final String value) {
        if (MDC.mdcAdapter == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        MDC.mdcAdapter.pushByKey(key, value);
    }
    
    public static String popByKey(final String key) {
        if (MDC.mdcAdapter == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        return MDC.mdcAdapter.popByKey(key);
    }
    
    public Deque<String> getCopyOfDequeByKey(final String key) {
        if (MDC.mdcAdapter == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        return MDC.mdcAdapter.getCopyOfDequeByKey(key);
    }
    
    static {
        final SLF4JServiceProvider provider = LoggerFactory.getProvider();
        if (provider != null) {
            MDC.mdcAdapter = provider.getMDCAdapter();
        }
        else {
            Util.report("Failed to find provider.");
            Util.report("Defaulting to no-operation MDCAdapter implementation.");
            MDC.mdcAdapter = new NOPMDCAdapter();
        }
    }
    
    public static class MDCCloseable implements Closeable
    {
        private final String key;
        
        private MDCCloseable(final String key) {
            this.key = key;
        }
        
        @Override
        public void close() {
            MDC.remove(this.key);
        }
    }
}
