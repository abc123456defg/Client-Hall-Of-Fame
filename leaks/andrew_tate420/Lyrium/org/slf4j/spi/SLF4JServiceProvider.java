// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j.spi;

import org.slf4j.IMarkerFactory;
import org.slf4j.ILoggerFactory;

public interface SLF4JServiceProvider
{
    ILoggerFactory getLoggerFactory();
    
    IMarkerFactory getMarkerFactory();
    
    MDCAdapter getMDCAdapter();
    
    String getRequestedApiVersion();
    
    void initialize();
}
