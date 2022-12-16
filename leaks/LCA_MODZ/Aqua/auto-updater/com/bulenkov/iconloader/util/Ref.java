// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

public class Ref<T>
{
    private T myValue;
    
    public Ref() {
    }
    
    public Ref(final T value) {
        this.myValue = value;
    }
    
    public boolean isNull() {
        return this.myValue == null;
    }
    
    public T get() {
        return this.myValue;
    }
    
    public void set(final T value) {
        this.myValue = value;
    }
    
    public boolean setIfNull(final T value) {
        if (this.myValue == null) {
            this.myValue = value;
            return true;
        }
        return false;
    }
    
    public static <V> Ref<V> create() {
        return new Ref<V>();
    }
    
    public static <V> Ref<V> create(final V value) {
        return new Ref<V>(value);
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.myValue);
    }
}
