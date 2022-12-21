// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j.helpers;

import java.util.Deque;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.spi.MDCAdapter;

public class BasicMDCAdapter implements MDCAdapter
{
    private final ThreadLocalMapOfStacks threadLocalMapOfDeques;
    private final InheritableThreadLocal<Map<String, String>> inheritableThreadLocalMap;
    
    public BasicMDCAdapter() {
        this.threadLocalMapOfDeques = new ThreadLocalMapOfStacks();
        this.inheritableThreadLocalMap = new InheritableThreadLocal<Map<String, String>>() {
            @Override
            protected Map<String, String> childValue(final Map<String, String> parentValue) {
                if (parentValue == null) {
                    return null;
                }
                return new HashMap<String, String>(parentValue);
            }
        };
    }
    
    @Override
    public void put(final String key, final String val) {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        Map<String, String> map = this.inheritableThreadLocalMap.get();
        if (map == null) {
            map = new HashMap<String, String>();
            this.inheritableThreadLocalMap.set(map);
        }
        map.put(key, val);
    }
    
    @Override
    public String get(final String key) {
        final Map<String, String> map = this.inheritableThreadLocalMap.get();
        if (map != null && key != null) {
            return map.get(key);
        }
        return null;
    }
    
    @Override
    public void remove(final String key) {
        final Map<String, String> map = this.inheritableThreadLocalMap.get();
        if (map != null) {
            map.remove(key);
        }
    }
    
    @Override
    public void clear() {
        final Map<String, String> map = this.inheritableThreadLocalMap.get();
        if (map != null) {
            map.clear();
            this.inheritableThreadLocalMap.remove();
        }
    }
    
    public Set<String> getKeys() {
        final Map<String, String> map = this.inheritableThreadLocalMap.get();
        if (map != null) {
            return map.keySet();
        }
        return null;
    }
    
    @Override
    public Map<String, String> getCopyOfContextMap() {
        final Map<String, String> oldMap = this.inheritableThreadLocalMap.get();
        if (oldMap != null) {
            return new HashMap<String, String>(oldMap);
        }
        return null;
    }
    
    @Override
    public void setContextMap(final Map<String, String> contextMap) {
        Map<String, String> copy = null;
        if (contextMap != null) {
            copy = new HashMap<String, String>(contextMap);
        }
        this.inheritableThreadLocalMap.set(copy);
    }
    
    @Override
    public void pushByKey(final String key, final String value) {
        this.threadLocalMapOfDeques.pushByKey(key, value);
    }
    
    @Override
    public String popByKey(final String key) {
        return this.threadLocalMapOfDeques.popByKey(key);
    }
    
    @Override
    public Deque<String> getCopyOfDequeByKey(final String key) {
        return this.threadLocalMapOfDeques.getCopyOfDequeByKey(key);
    }
    
    @Override
    public void clearDequeByKey(final String key) {
        this.threadLocalMapOfDeques.clearDequeByKey(key);
    }
}
