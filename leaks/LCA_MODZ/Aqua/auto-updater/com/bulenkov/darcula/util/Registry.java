// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.util;

public class Registry
{
    public static boolean is(final String key) {
        return "true".equalsIgnoreCase(System.getProperty(key));
    }
    
    public static float getFloat(final String key) {
        try {
            return Float.parseFloat(System.getProperty(key));
        }
        catch (Exception e) {
            return 0.0f;
        }
    }
}
