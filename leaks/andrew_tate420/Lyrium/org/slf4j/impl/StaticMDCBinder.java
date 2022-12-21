// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j.impl;

import org.slf4j.spi.MDCAdapter;

public class StaticMDCBinder
{
    public static final StaticMDCBinder SINGLETON;
    
    private StaticMDCBinder() {
    }
    
    public MDCAdapter getMDCA() {
        return new LogbackMDCAdapter();
    }
    
    public String getMDCAdapterClassStr() {
        return LogbackMDCAdapter.class.getName();
    }
    
    static {
        SINGLETON = new StaticMDCBinder();
    }
}
