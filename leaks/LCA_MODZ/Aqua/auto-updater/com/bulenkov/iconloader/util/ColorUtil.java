// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import java.awt.Color;

public class ColorUtil
{
    private static int shift(final int colorComponent, final double d) {
        final int n = (int)(colorComponent * d);
        return (n > 255) ? 255 : ((n < 0) ? 0 : n);
    }
    
    public static Color shift(final Color c, final double d) {
        return new Color(shift(c.getRed(), d), shift(c.getGreen(), d), shift(c.getBlue(), d), c.getAlpha());
    }
    
    public static Color toAlpha(final Color color, final int a) {
        final Color c = (color != null) ? color : Color.black;
        return new Color(c.getRed(), c.getGreen(), c.getBlue(), a);
    }
    
    public static Color fromHex(String str) {
        if (str.startsWith("#")) {
            str = str.substring(1);
        }
        if (str.length() == 3) {
            return new Color(17 * Integer.valueOf(String.valueOf(str.charAt(0)), 16), 17 * Integer.valueOf(String.valueOf(str.charAt(1)), 16), 17 * Integer.valueOf(String.valueOf(str.charAt(2)), 16));
        }
        if (str.length() == 6) {
            return Color.decode("0x" + str);
        }
        throw new IllegalArgumentException("Should be String of 3 or 6 chars length.");
    }
    
    public static Color fromHex(final String str, final Color defaultValue) {
        try {
            return fromHex(str);
        }
        catch (Exception e) {
            return defaultValue;
        }
    }
    
    public static boolean isDark(final Color c) {
        return 1.0 - (0.299 * c.getRed() + 0.587 * c.getGreen() + 0.114 * c.getBlue()) / 255.0 >= 0.5;
    }
}
