// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.Set;
import java.lang.ref.ReferenceQueue;
import org.jetbrains.annotations.NotNull;
import java.util.Map;

public final class ConcurrentSoftValueHashMap<K, V> extends ConcurrentRefValueHashMap<K, V>
{
    public ConcurrentSoftValueHashMap(@NotNull final Map<K, V> map) {
        if (map == null) {
            $$$reportNull$$$0(0);
        }
        super(map);
    }
    
    public ConcurrentSoftValueHashMap() {
    }
    
    public ConcurrentSoftValueHashMap(final int initialCapacity, final float loadFactor, final int concurrencyLevel) {
        super(initialCapacity, loadFactor, concurrencyLevel);
    }
    
    @NotNull
    @Override
    protected ValueReference<K, V> createValueReference(@NotNull final K key, @NotNull final V value) {
        if (key == null) {
            $$$reportNull$$$0(1);
        }
        if (value == null) {
            $$$reportNull$$$0(2);
        }
        final MySoftReference mySoftReference = new MySoftReference<K, V>((Object)key, (Object)value, (ReferenceQueue)this.myQueue);
        if (mySoftReference == null) {
            $$$reportNull$$$0(3);
        }
        return (ValueReference<K, V>)mySoftReference;
    }
    
    private static /* synthetic */ void $$$reportNull$$$0(final int n) {
        String format = null;
        switch (n) {
            default: {
                format = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
            }
            case 3: {
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
            case 3: {
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
            case 1: {
                args[0] = "key";
                break;
            }
            case 2: {
                args[0] = "value";
                break;
            }
            case 3: {
                args[0] = "com/bulenkov/iconloader/util/ConcurrentSoftValueHashMap";
                break;
            }
        }
        switch (n) {
            default: {
                args[1] = "com/bulenkov/iconloader/util/ConcurrentSoftValueHashMap";
                break;
            }
            case 3: {
                args[1] = "createValueReference";
                break;
            }
        }
        switch (n) {
            default: {
                args[2] = "<init>";
                break;
            }
            case 1:
            case 2: {
                args[2] = "createValueReference";
                break;
            }
            case 3: {
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
            case 3: {
                ex = new IllegalStateException(format2);
                break;
            }
        }
        throw ex;
    }
    
    private static class MySoftReference<K, V> extends SoftReference<V> implements ValueReference<K, V>
    {
        private final K key;
        
        private MySoftReference(@NotNull final K key, @NotNull final V referent, @NotNull final ReferenceQueue<V> q) {
            if (key == null) {
                $$$reportNull$$$0(0);
            }
            if (referent == null) {
                $$$reportNull$$$0(1);
            }
            if (q == null) {
                $$$reportNull$$$0(2);
            }
            super(referent, q);
            this.key = key;
        }
        
        @NotNull
        @Override
        public K getKey() {
            final K key = this.key;
            if (key == null) {
                $$$reportNull$$$0(3);
            }
            return key;
        }
        
        @Override
        public final boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            final ValueReference<K, V> that = (ValueReference<K, V>)o;
            final V v = this.get();
            final V thatV = that.get();
            return this.key.equals(that.getKey()) && v != null && thatV != null && v.equals(thatV);
        }
        
        private static /* synthetic */ void $$$reportNull$$$0(final int n) {
            String format = null;
            switch (n) {
                default: {
                    format = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
                }
                case 3: {
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
                case 3: {
                    n2 = 2;
                    break;
                }
            }
            final Object[] args = new Object[n2];
            switch (n) {
                default: {
                    args[0] = "key";
                    break;
                }
                case 1: {
                    args[0] = "referent";
                    break;
                }
                case 2: {
                    args[0] = "q";
                    break;
                }
                case 3: {
                    args[0] = "com/bulenkov/iconloader/util/ConcurrentSoftValueHashMap$MySoftReference";
                    break;
                }
            }
            switch (n) {
                default: {
                    args[1] = "com/bulenkov/iconloader/util/ConcurrentSoftValueHashMap$MySoftReference";
                    break;
                }
                case 3: {
                    args[1] = "getKey";
                    break;
                }
            }
            switch (n) {
                default: {
                    args[2] = "<init>";
                    break;
                }
                case 3: {
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
                case 3: {
                    ex = new IllegalStateException(format2);
                    break;
                }
            }
            throw ex;
        }
    }
}
