// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j.helpers;

import java.util.Deque;
import java.util.Map;
import org.slf4j.spi.MDCAdapter;

public class NOPMDCAdapter implements MDCAdapter
{
    @Override
    public void clear() {
    }
    
    @Override
    public String get(final String key) {
        return null;
    }
    
    @Override
    public void put(final String key, final String val) {
    }
    
    @Override
    public void remove(final String key) {
    }
    
    @Override
    public Map<String, String> getCopyOfContextMap() {
        return null;
    }
    
    @Override
    public void setContextMap(final Map<String, String> contextMap) {
    }
    
    @Override
    public void pushByKey(final String key, final String value) {
    }
    
    @Override
    public String popByKey(final String key) {
        return null;
    }
    
    @Override
    public Deque<String> getCopyOfDequeByKey(final String key) {
        return null;
    }
    
    @Override
    public void clearDequeByKey(final String key) {
    }
}
