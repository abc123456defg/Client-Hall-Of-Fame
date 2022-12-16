// 
// Decompiled by Procyon v0.5.36
// 

package com.intellij.util.ui;

import javax.swing.border.Border;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Insets;
import com.bulenkov.iconloader.util.EmptyIcon;
import javax.swing.plaf.UIResource;
import java.awt.Dimension;
import com.bulenkov.iconloader.IconLoader;
import com.bulenkov.iconloader.util.Pair;
import com.bulenkov.iconloader.util.UIUtil;
import com.bulenkov.iconloader.util.SystemInfo;

public class JBUI
{
    private static float scaleFactor;
    
    private static void calculateScaleFactor() {
        if (SystemInfo.isMac) {
            JBUI.scaleFactor = 1.0f;
            return;
        }
        if (System.getProperty("hidpi") != null && !"true".equalsIgnoreCase(System.getProperty("hidpi"))) {
            JBUI.scaleFactor = 1.0f;
            return;
        }
        UIUtil.initSystemFontData();
        final Pair<String, Integer> fdata = UIUtil.getSystemFontData();
        int size;
        if (fdata != null) {
            size = fdata.getSecond();
        }
        else {
            size = Fonts.label().getSize();
        }
        setScaleFactor(size / 12.0f);
    }
    
    public static void setScaleFactor(float scale) {
        final String hidpi = System.getProperty("hidpi");
        if (hidpi != null && "false".equalsIgnoreCase(hidpi)) {
            return;
        }
        if (scale < 1.25f) {
            scale = 1.0f;
        }
        else if (scale < 1.5f) {
            scale = 1.25f;
        }
        else if (scale < 1.75f) {
            scale = 1.5f;
        }
        else if (scale < 2.0f) {
            scale = 1.75f;
        }
        else {
            scale = 2.0f;
        }
        if (SystemInfo.isLinux && scale == 1.25f) {
            scale = 1.0f;
        }
        if (JBUI.scaleFactor == scale) {
            return;
        }
        IconLoader.setScale(JBUI.scaleFactor = scale);
    }
    
    public static int scale(final int i) {
        return Math.round(JBUI.scaleFactor * i);
    }
    
    public static int scaleFontSize(final int fontSize) {
        if (JBUI.scaleFactor == 1.25f) {
            return (int)(fontSize * 1.34f);
        }
        if (JBUI.scaleFactor == 1.75f) {
            return (int)(fontSize * 1.67f);
        }
        return scale(fontSize);
    }
    
    public static JBDimension size(final int width, final int height) {
        return new JBDimension(width, height);
    }
    
    public static JBDimension size(final int widthAndHeight) {
        return new JBDimension(widthAndHeight, widthAndHeight);
    }
    
    public static JBDimension size(final Dimension size) {
        if (!(size instanceof JBDimension)) {
            return new JBDimension(size.width, size.height);
        }
        final JBDimension jbSize = (JBDimension)size;
        if (jbSize.originalScale == scale(1.0f)) {
            return jbSize;
        }
        final JBDimension newSize = new JBDimension((int)(jbSize.width / jbSize.originalScale), (int)(jbSize.height / jbSize.originalScale));
        return (size instanceof UIResource) ? newSize.asUIResource() : newSize;
    }
    
    public static JBInsets insets(final int top, final int left, final int bottom, final int right) {
        return new JBInsets(top, left, bottom, right);
    }
    
    public static JBInsets insets(final int all) {
        return insets(all, all, all, all);
    }
    
    public static JBInsets insets(final int topBottom, final int leftRight) {
        return insets(topBottom, leftRight, topBottom, leftRight);
    }
    
    public static JBInsets emptyInsets() {
        return new JBInsets(0, 0, 0, 0);
    }
    
    public static JBInsets insetsTop(final int t) {
        return insets(t, 0, 0, 0);
    }
    
    public static JBInsets insetsLeft(final int l) {
        return insets(0, l, 0, 0);
    }
    
    public static JBInsets insetsBottom(final int b) {
        return insets(0, 0, b, 0);
    }
    
    public static JBInsets insetsRight(final int r) {
        return insets(0, 0, 0, r);
    }
    
    public static EmptyIcon emptyIcon(final int i) {
        return (EmptyIcon)EmptyIcon.create(scale(i));
    }
    
    public static JBDimension emptySize() {
        return new JBDimension(0, 0);
    }
    
    public static float scale(final float f) {
        return f * JBUI.scaleFactor;
    }
    
    public static JBInsets insets(final Insets insets) {
        return JBInsets.create(insets);
    }
    
    public static boolean isHiDPI() {
        return JBUI.scaleFactor > 1.0f;
    }
    
    static {
        JBUI.scaleFactor = 1.0f;
        calculateScaleFactor();
    }
    
    public static class Fonts
    {
        public static JBFont label() {
            return JBFont.create(UIManager.getFont("Label.font"), false);
        }
        
        public static JBFont label(final float size) {
            return label().deriveFont(JBUI.scale(size));
        }
        
        public static JBFont smallFont() {
            return label().deriveFont(UIUtil.getFontSize(UIUtil.FontSize.SMALL));
        }
        
        public static JBFont miniFont() {
            return label().deriveFont(UIUtil.getFontSize(UIUtil.FontSize.MINI));
        }
        
        public static JBFont create(final String fontFamily, final int size) {
            return JBFont.create(new Font(fontFamily, 0, size));
        }
    }
    
    public static class Borders
    {
        public static JBEmptyBorder empty(final int top, final int left, final int bottom, final int right) {
            return new JBEmptyBorder(top, left, bottom, right);
        }
        
        public static JBEmptyBorder empty(final int topAndBottom, final int leftAndRight) {
            return empty(topAndBottom, leftAndRight, topAndBottom, leftAndRight);
        }
        
        public static JBEmptyBorder emptyTop(final int offset) {
            return empty(offset, 0, 0, 0);
        }
        
        public static JBEmptyBorder emptyLeft(final int offset) {
            return empty(0, offset, 0, 0);
        }
        
        public static JBEmptyBorder emptyBottom(final int offset) {
            return empty(0, 0, offset, 0);
        }
        
        public static JBEmptyBorder emptyRight(final int offset) {
            return empty(0, 0, 0, offset);
        }
        
        public static JBEmptyBorder empty() {
            return empty(0, 0, 0, 0);
        }
        
        public static Border empty(final int offsets) {
            return empty(offsets, offsets, offsets, offsets);
        }
    }
}
