// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j.impl;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import org.slf4j.spi.MDCAdapter;

public class LogbackMDCAdapter implements MDCAdapter
{
    final CopyOnInheritThreadLocal copyOnInheritThreadLocal;
    
    LogbackMDCAdapter() {
        this.copyOnInheritThreadLocal = new CopyOnInheritThreadLocal();
    }
    
    public void put(final String key, final String val) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        final HashMap<String, String> oldMap = this.copyOnInheritThreadLocal.get();
        final HashMap<String, String> newMap = new HashMap<String, String>();
        if (oldMap != null) {
            newMap.putAll(oldMap);
        }
        this.copyOnInheritThreadLocal.set(newMap);
        newMap.put(key, val);
    }
    
    public String get(final String key) {
        final HashMap<String, String> hashMap = this.copyOnInheritThreadLocal.get();
        if (hashMap != null && key != null) {
            return hashMap.get(key);
        }
        return null;
    }
    
    public void remove(final String key) {
        final HashMap<String, String> oldMap = this.copyOnInheritThreadLocal.get();
        final HashMap<String, String> newMap = new HashMap<String, String>();
        if (oldMap != null) {
            newMap.putAll(oldMap);
        }
        this.copyOnInheritThreadLocal.set(newMap);
        newMap.remove(key);
    }
    
    public void clear() {
        final HashMap<String, String> hashMap = this.copyOnInheritThreadLocal.get();
        if (hashMap != null) {
            hashMap.clear();
            this.copyOnInheritThreadLocal.remove();
        }
    }
    
    public Map<String, String> getPropertyMap() {
        return ((ThreadLocal<Map<String, String>>)this.copyOnInheritThreadLocal).get();
    }
    
    public Map getCopyOfContextMap() {
        final HashMap<String, String> hashMap = this.copyOnInheritThreadLocal.get();
        if (hashMap == null) {
            return null;
        }
        return new HashMap(hashMap);
    }
    
    public Set<String> getKeys() {
        final HashMap<String, String> hashMap = this.copyOnInheritThreadLocal.get();
        if (hashMap != null) {
            return hashMap.keySet();
        }
        return null;
    }
    
    public void setContextMap(final Map contextMap) {
        HashMap<String, String> oldMap = this.copyOnInheritThreadLocal.get();
        final HashMap<String, String> newMap = new HashMap<String, String>();
        newMap.putAll(contextMap);
        this.copyOnInheritThreadLocal.set(newMap);
        if (oldMap != null) {
            oldMap.clear();
            oldMap = null;
        }
    }
}
