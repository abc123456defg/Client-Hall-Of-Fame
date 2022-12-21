// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j.helpers;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.MDCAdapter;
import org.slf4j.IMarkerFactory;
import org.slf4j.spi.SLF4JServiceProvider;

public class SubstituteServiceProvider implements SLF4JServiceProvider
{
    private final SubstituteLoggerFactory loggerFactory;
    private final IMarkerFactory markerFactory;
    private final MDCAdapter mdcAdapter;
    
    public SubstituteServiceProvider() {
        this.loggerFactory = new SubstituteLoggerFactory();
        this.markerFactory = new BasicMarkerFactory();
        this.mdcAdapter = new BasicMDCAdapter();
    }
    
    @Override
    public ILoggerFactory getLoggerFactory() {
        return this.loggerFactory;
    }
    
    public SubstituteLoggerFactory getSubstituteLoggerFactory() {
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
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void initialize() {
    }
}
