// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j.helpers;

import org.slf4j.spi.MDCAdapter;
import org.slf4j.IMarkerFactory;
import org.slf4j.ILoggerFactory;
import org.slf4j.spi.SLF4JServiceProvider;

public class NOP_FallbackServiceProvider implements SLF4JServiceProvider
{
    public static String REQUESTED_API_VERSION;
    private final ILoggerFactory loggerFactory;
    private final IMarkerFactory markerFactory;
    private final MDCAdapter mdcAdapter;
    
    public NOP_FallbackServiceProvider() {
        this.loggerFactory = new NOPLoggerFactory();
        this.markerFactory = new BasicMarkerFactory();
        this.mdcAdapter = new NOPMDCAdapter();
    }
    
    @Override
    public ILoggerFactory getLoggerFactory() {
        return this.loggerFactory;
    }
    
    @Override
    public IMarkerFactory getMarkerFactory() {
        return this.markerFactory;
    }
    
    @Override
    public MDCAdapter getMDCAdapter() {
        return this.mdcAdapter;
    }
    
    @Override
    public String getRequestedApiVersion() {
        return NOP_FallbackServiceProvider.REQUESTED_API_VERSION;
    }
    
    @Override
    public void initialize() {
    }
    
    static {
        NOP_FallbackServiceProvider.REQUESTED_API_VERSION = "2.0.99";
    }
}
