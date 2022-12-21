// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j.helpers;

import java.util.Collection;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Deque;
import java.util.Map;

public class ThreadLocalMapOfStacks
{
    final ThreadLocal<Map<String, Deque<String>>> tlMapOfStacks;
    
    public ThreadLocalMapOfStacks() {
        this.tlMapOfStacks = new ThreadLocal<Map<String, Deque<String>>>();
    }
    
    public void pushByKey(final String key, final String value) {
        if (key == null) {
            return;
        }
        Map<String, Deque<String>> map = this.tlMapOfStacks.get();
        if (map == null) {
            map = new HashMap<String, Deque<String>>();
            this.tlMapOfStacks.set(map);
        }
        Deque<String> deque = map.get(key);
        if (deque == null) {
            deque = new ArrayDeque<String>();
        }
        deque.push(value);
        map.put(key, deque);
    }
    
    public String popByKey(final String key) {
        if (key == null) {
            return null;
        }
        final Map<String, Deque<String>> map = this.tlMapOfStacks.get();
        if (map == null) {
            return null;
        }
        final Deque<String> deque = map.get(key);
        if (deque == null) {
            return null;
        }
        return deque.pop();
    }
    
    public Deque<String> getCopyOfDequeByKey(final String key) {
        if (key == null) {
            return null;
        }
        final Map<String, Deque<String>> map = this.tlMapOfStacks.get();
        if (map == null) {
            return null;
        }
        final Deque<String> deque = map.get(key);
        if (deque == null) {
            return null;
        }
        return new ArrayDeque<String>(deque);
    }
    
    public void clearDequeByKey(final String key) {
        if (key == null) {
            return;
        }
        final Map<String, Deque<String>> map = this.tlMapOfStacks.get();
        if (map == null) {
            return;
        }
        final Deque<String> deque = map.get(key);
        if (deque == null) {
            return;
        }
        deque.clear();
    }
}
