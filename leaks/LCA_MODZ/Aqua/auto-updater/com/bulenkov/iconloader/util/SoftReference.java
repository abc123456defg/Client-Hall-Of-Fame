// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import org.jetbrains.annotations.Nullable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class SoftReference<T> extends java.lang.ref.SoftReference<T> implements Getter<T>
{
    public SoftReference(final T referent) {
        super(referent);
    }
    
    public SoftReference(final T referent, final ReferenceQueue<? super T> q) {
        super(referent, q);
    }
    
    @Nullable
    public static <T> T dereference(@Nullable final Reference<T> ref) {
        return (ref == null) ? null : ref.get();
    }
    
    @Nullable
    public static <T> T deref(@Nullable final Getter<T> ref) {
        return (ref == null) ? null : ref.get();
    }
}
