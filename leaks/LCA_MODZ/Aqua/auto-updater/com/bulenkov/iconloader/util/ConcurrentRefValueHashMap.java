// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import java.util.Map;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ConcurrentMap;

abstract class ConcurrentRefValueHashMap<K, V> implements ConcurrentMap<K, V>
{
    private final ConcurrentMap<K, ValueReference<K, V>> myMap;
    protected final ReferenceQueue<V> myQueue;
    
    public ConcurrentRefValueHashMap(@NotNull final Map<K, V> map) {
        if (map == null) {
            $$$reportNull$$$0(0);
        }
        this();
        this.putAll((Map<? extends K, ? extends V>)map);
    }
    
    public ConcurrentRefValueHashMap() {
        this.myQueue = new ReferenceQueue<V>();
        this.myMap = new ConcurrentHashMap<K, ValueReference<K, V>>();
    }
    
    public ConcurrentRefValueHashMap(final int initialCapacity, final float loadFactor, final int concurrencyLevel) {
        this.myQueue = new ReferenceQueue<V>();
        this.myMap = new ConcurrentHashMap<K, ValueReference<K, V>>(initialCapacity, loadFactor, concurrencyLevel);
    }
    
    boolean processQueue() {
        boolean processed = false;
        while (true) {
            final ValueReference<K, V> ref = (ValueReference<K, V>)(ValueReference)this.myQueue.poll();
            if (ref == null) {
                break;
            }
            this.myMap.remove(ref.getKey(), ref);
            processed = true;
        }
        return processed;
    }
    
    @Override
    public V get(@NotNull final Object key) {
        if (key == null) {
            $$$reportNull$$$0(1);
        }
        final ValueReference<K, V> ref = this.myMap.get(key);
        if (ref == null) {
            return null;
        }
        return ref.get();
    }
    
    @Override
    public V put(@NotNull final K key, @NotNull final V value) {
        if (key == null) {
            $$$reportNull$$$0(2);
        }
        if (value == null) {
            $$$reportNull$$$0(3);
        }
        this.processQueue();
        final ValueReference<K, V> oldRef = this.myMap.put(key, this.createValueReference(key, value));
        return (oldRef != null) ? oldRef.get() : null;
    }
    
    @NotNull
    protected abstract ValueReference<K, V> createValueReference(@NotNull final K p0, @NotNull final V p1);
    
    @Override
    public V putIfAbsent(@NotNull final K key, @NotNull final V value) {
        if (key == null) {
            $$$reportNull$$$0(4);
        }
        if (value == null) {
            $$$reportNull$$$0(5);
        }
        final ValueReference<K, V> newRef = this.createValueReference(key, value);
        while (true) {
            this.processQueue();
            final ValueReference<K, V> oldRef = this.myMap.putIfAbsent(key, newRef);
            if (oldRef == null) {
                return null;
            }
            final V oldVal = oldRef.get();
            if (oldVal != null) {
                return oldVal;
            }
            if (this.myMap.replace(key, oldRef, newRef)) {
                return null;
            }
        }
    }
    
    @Override
    public boolean remove(@NotNull final Object key, @NotNull final Object value) {
        if (key == null) {
            $$$reportNull$$$0(6);
        }
        if (value == null) {
            $$$reportNull$$$0(7);
        }
        this.processQueue();
        return this.myMap.remove(key, this.createValueReference(key, value));
    }
    
    @Override
    public boolean replace(@NotNull final K key, @NotNull final V oldValue, @NotNull final V newValue) {
        if (key == null) {
            $$$reportNull$$$0(8);
        }
        if (oldValue == null) {
            $$$reportNull$$$0(9);
        }
        if (newValue == null) {
            $$$reportNull$$$0(10);
        }
        this.processQueue();
        return this.myMap.replace(key, this.createValueReference(key, oldValue), this.createValueReference(key, newValue));
    }
    
    @Override
    public V replace(@NotNull final K key, @NotNull final V value) {
        if (key == null) {
            $$$reportNull$$$0(11);
        }
        if (value == null) {
            $$$reportNull$$$0(12);
        }
        this.processQueue();
        final ValueReference<K, V> ref = this.myMap.replace(key, this.createValueReference(key, value));
        return (ref == null) ? null : ref.get();
    }
    
    @Override
    public V remove(@NotNull final Object key) {
        if (key == null) {
            $$$reportNull$$$0(13);
        }
        this.processQueue();
        final ValueReference<K, V> ref = this.myMap.remove(key);
        return (ref == null) ? null : ref.get();
    }
    
    @Override
    public void putAll(@NotNull final Map<? extends K, ? extends V> t) {
        if (t == null) {
            $$$reportNull$$$0(14);
        }
        this.processQueue();
        for (final Map.Entry<? extends K, ? extends V> entry : t.entrySet()) {
            final V v = (V)entry.getValue();
            if (v != null) {
                final K key = (K)entry.getKey();
                this.put(key, v);
            }
        }
    }
    
    @Override
    public void clear() {
        this.myMap.clear();
        this.processQueue();
    }
    
    @Override
    public int size() {
        this.processQueue();
        return this.myMap.size();
    }
    
    @Override
    public boolean isEmpty() {
        this.processQueue();
        return this.myMap.isEmpty();
    }
    
    @Override
    public boolean containsKey(@NotNull final Object key) {
        if (key == null) {
            $$$reportNull$$$0(15);
        }
        return this.get(key) != null;
    }
    
    @Override
    public boolean containsValue(@NotNull final Object value) {
        if (value == null) {
            $$$reportNull$$$0(16);
        }
        throw new UnsupportedOperationException();
    }
    
    @NotNull
    @Override
    public Set<K> keySet() {
        final Set<Object> keySet = (Set<Object>)this.myMap.keySet();
        if (keySet == null) {
            $$$reportNull$$$0(17);
        }
        return (Set<K>)keySet;
    }
    
    @NotNull
    @Override
    public Collection<V> values() {
        final Collection<V> result = new ArrayList<V>();
        final Collection<ValueReference<K, V>> refs = this.myMap.values();
        for (final ValueReference<K, V> ref : refs) {
            final V value = ref.get();
            if (value != null) {
                result.add(value);
            }
        }
        final Collection<V> collection = result;
        if (collection == null) {
            $$$reportNull$$$0(18);
        }
        return collection;
    }
    
    @NotNull
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        final Set<K> keys = this.keySet();
        final Set<Map.Entry<K, V>> entries = new HashSet<Map.Entry<K, V>>();
        for (final K key : keys) {
            final V value = this.get(key);
            if (value != null) {
                entries.add(new Map.Entry<K, V>() {
                    @Override
                    public K getKey() {
                        return key;
                    }
                    
                    @Override
                    public V getValue() {
                        return value;
                    }
                    
                    @Override
                    public V setValue(@NotNull final V value) {
                        if (value == null) {
                            $$$reportNull$$$0(0);
                        }
                        throw new UnsupportedOperationException("setValue is not implemented");
                    }
                    
                    @Override
                    public String toString() {
                        return "(" + this.getKey() + " : " + this.getValue() + ")";
                    }
                    
                    private static /* synthetic */ void $$$reportNull$$$0(final int n) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "value", "com/bulenkov/iconloader/util/ConcurrentRefValueHashMap$1", "setValue"));
                    }
                });
            }
        }
        final Set<Map.Entry<K, V>> set = entries;
        if (set == null) {
            $$$reportNull$$$0(19);
        }
        return set;
    }
    
    @Override
    public String toString() {
        return "map size:" + this.size() + " [" + StringUtil.join(this.entrySet(), ",") + "]";
    }
    
    int underlyingMapSize() {
        return this.myMap.size();
    }
    
    private static /* synthetic */ void $$$reportNull$$$0(final int n) {
        String format = null;
        switch (n) {
            default: {
                format = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
            }
            case 17:
            case 18:
            case 19: {
                format = "@NotNull method %s.%s must not return null";
                break;
            }
        }
        int n2 = 0;
        switch (n) {
            default: {
                n2 = 3;
                break;
            }
            case 17:
            case 18:
            case 19: {
                n2 = 2;
                break;
            }
        }
        final Object[] args = new Object[n2];
        switch (n) {
            default: {
                args[0] = "map";
                break;
            }
            case 1:
            case 2:
            case 4:
            case 6:
            case 8:
            case 11:
            case 13:
            case 15: {
                args[0] = "key";
                break;
            }
            case 3:
            case 5:
            case 7:
            case 12:
            case 16: {
                args[0] = "value";
                break;
            }
            case 9: {
                args[0] = "oldValue";
                break;
            }
            case 10: {
                args[0] = "newValue";
                break;
            }
            case 14: {
                args[0] = "t";
                break;
            }
            case 17:
            case 18:
            case 19: {
                args[0] = "com/bulenkov/iconloader/util/ConcurrentRefValueHashMap";
                break;
            }
        }
        switch (n) {
            default: {
                args[1] = "com/bulenkov/iconloader/util/ConcurrentRefValueHashMap";
                break;
            }
            case 17: {
                args[1] = "keySet";
                break;
            }
            case 18: {
                args[1] = "values";
                break;
            }
            case 19: {
                args[1] = "entrySet";
                break;
            }
        }
        switch (n) {
            default: {
                args[2] = "<init>";
                break;
            }
            case 1: {
                args[2] = "get";
                break;
            }
            case 2:
            case 3: {
                args[2] = "put";
                break;
            }
            case 4:
            case 5: {
                args[2] = "putIfAbsent";
                break;
            }
            case 6:
            case 7:
            case 13: {
                args[2] = "remove";
                break;
            }
            case 8:
            case 9:
            case 10:
            case 11:
            case 12: {
                args[2] = "replace";
                break;
            }
            case 14: {
                args[2] = "putAll";
                break;
            }
            case 15: {
                args[2] = "containsKey";
                break;
            }
            case 16: {
                args[2] = "containsValue";
                break;
            }
            case 17:
            case 18:
            case 19: {
                break;
            }
        }
        final String format2 = String.format(format, args);
        RuntimeException ex = null;
        switch (n) {
            default: {
                ex = new IllegalArgumentException(format2);
                break;
            }
            case 17:
            case 18:
            case 19: {
                ex = new IllegalStateException(format2);
                break;
            }
        }
        throw ex;
    }
    
    protected interface ValueReference<K, V>
    {
        @NotNull
        K getKey();
        
        V get();
    }
}
