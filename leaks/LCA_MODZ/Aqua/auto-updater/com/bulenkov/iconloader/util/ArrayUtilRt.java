// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import java.util.Iterator;
import java.util.Collection;

public class ArrayUtilRt
{
    private static final int ARRAY_COPY_THRESHOLD = 20;
    public static final String[] EMPTY_STRING_ARRAY;
    
    public static String[] toStringArray(final Collection<String> collection) {
        return (collection == null || collection.isEmpty()) ? ArrayUtilRt.EMPTY_STRING_ARRAY : toArray(collection, new String[collection.size()]);
    }
    
    public static <T> T[] toArray(final Collection<T> c, final T[] sample) {
        final int size = c.size();
        if (size == sample.length && size < 20) {
            int i = 0;
            for (final T t : c) {
                sample[i++] = t;
            }
            return sample;
        }
        return c.toArray(sample);
    }
    
    public static <T> int find(final T[] src, final T obj) {
        for (int i = 0; i < src.length; ++i) {
            final T o = src[i];
            if (o == null) {
                if (obj == null) {
                    return i;
                }
            }
            else if (o.equals(obj)) {
                return i;
            }
        }
        return -1;
    }
    
    static {
        EMPTY_STRING_ARRAY = new String[0];
    }
}
