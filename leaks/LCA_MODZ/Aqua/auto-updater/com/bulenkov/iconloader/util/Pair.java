// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

public class Pair<FIRST, SECOND>
{
    public final FIRST first;
    public final SECOND second;
    private static final Pair EMPTY;
    
    public static <F, S> Pair<F, S> empty() {
        return (Pair<F, S>)Pair.EMPTY;
    }
    
    public Pair(final FIRST first, final SECOND second) {
        this.first = first;
        this.second = second;
    }
    
    public final FIRST getFirst() {
        return this.first;
    }
    
    public final SECOND getSecond() {
        return this.second;
    }
    
    @Override
    public final boolean equals(final Object o) {
        return o instanceof Pair && ComparingUtils.equal(this.first, ((Pair)o).first) && ComparingUtils.equal(this.second, ((Pair)o).second);
    }
    
    @Override
    public int hashCode() {
        int result = (this.first != null) ? this.first.hashCode() : 0;
        result = 31 * result + ((this.second != null) ? this.second.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "<" + this.first + ", " + this.second + ">";
    }
    
    public static <F, S> Pair<F, S> create(final F first, final S second) {
        return new Pair<F, S>(first, second);
    }
    
    public static <T> T getFirst(final Pair<T, ?> pair) {
        return (pair != null) ? pair.first : null;
    }
    
    public static <T> T getSecond(final Pair<?, T> pair) {
        return (pair != null) ? pair.second : null;
    }
    
    static {
        EMPTY = create((Object)null, (Object)null);
    }
}
