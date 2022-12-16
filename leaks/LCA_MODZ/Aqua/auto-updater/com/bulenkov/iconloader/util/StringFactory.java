// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import sun.reflect.ConstructorAccessor;

public class StringFactory
{
    private static final ConstructorAccessor ourConstructorAccessor;
    
    public static String createShared(final char[] chars) {
        if (StringFactory.ourConstructorAccessor != null) {
            try {
                return (String)StringFactory.ourConstructorAccessor.newInstance(new Object[] { chars, Boolean.TRUE });
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return new String(chars);
    }
    
    static {
        ConstructorAccessor constructorAccessor = null;
        try {
            final Constructor<String> newC = String.class.getDeclaredConstructor(char[].class, Boolean.TYPE);
            newC.setAccessible(true);
            final Method accessor = Constructor.class.getDeclaredMethod("acquireConstructorAccessor", (Class<?>[])new Class[0]);
            accessor.setAccessible(true);
            constructorAccessor = (ConstructorAccessor)accessor.invoke(newC, new Object[0]);
        }
        catch (Exception ex) {}
        ourConstructorAccessor = constructorAccessor;
    }
}
