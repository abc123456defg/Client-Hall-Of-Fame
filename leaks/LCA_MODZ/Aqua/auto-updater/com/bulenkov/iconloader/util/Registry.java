// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

public class Registry
{
    public static boolean is(final String key) {
        final String value = System.getProperty(key);
        return "true".equalsIgnoreCase(value);
    }
    
    public static Float getFloat(final String key) {
        try {
            return Float.parseFloat(System.getProperty(key));
        }
        catch (Exception e) {
            return null;
        }
    }
}
