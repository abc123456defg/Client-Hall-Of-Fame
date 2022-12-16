// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import java.awt.PaintContext;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.image.ColorModel;
import java.awt.color.ColorSpace;
import java.awt.Color;

public class DoubleColor extends Color
{
    private static volatile boolean DARK;
    private final Color darkColor;
    public static final DoubleColor red;
    public static final DoubleColor RED;
    public static final DoubleColor blue;
    public static final DoubleColor BLUE;
    public static final DoubleColor white;
    public static final DoubleColor WHITE;
    public static final DoubleColor black;
    public static final DoubleColor BLACK;
    public static final DoubleColor gray;
    public static final DoubleColor GRAY;
    public static final DoubleColor lightGray;
    public static final DoubleColor LIGHT_GRAY;
    public static final DoubleColor darkGray;
    public static final DoubleColor DARK_GRAY;
    public static final DoubleColor pink;
    public static final DoubleColor PINK;
    public static final DoubleColor orange;
    public static final DoubleColor ORANGE;
    public static final DoubleColor yellow;
    public static final DoubleColor YELLOW;
    public static final DoubleColor green;
    public static final DoubleColor GREEN;
    public static final Color magenta;
    public static final Color MAGENTA;
    public static final Color cyan;
    public static final Color CYAN;
    
    public DoubleColor(final int rgb, final int darkRGB) {
        this(new Color(rgb), new Color(darkRGB));
    }
    
    public DoubleColor(final Color regular, final Color dark) {
        super(regular.getRGB(), regular.getAlpha() != 255);
        this.darkColor = dark;
        DoubleColor.DARK = UIUtil.isUnderDarcula();
    }
    
    public static void setDark(final boolean dark) {
        DoubleColor.DARK = dark;
    }
    
    Color getDarkVariant() {
        return this.darkColor;
    }
    
    @Override
    public int getRed() {
        return DoubleColor.DARK ? this.getDarkVariant().getRed() : super.getRed();
    }
    
    @Override
    public int getGreen() {
        return DoubleColor.DARK ? this.getDarkVariant().getGreen() : super.getGreen();
    }
    
    @Override
    public int getBlue() {
        return DoubleColor.DARK ? this.getDarkVariant().getBlue() : super.getBlue();
    }
    
    @Override
    public int getAlpha() {
        return DoubleColor.DARK ? this.getDarkVariant().getAlpha() : super.getAlpha();
    }
    
    @Override
    public int getRGB() {
        return DoubleColor.DARK ? this.getDarkVariant().getRGB() : super.getRGB();
    }
    
    @Override
    public Color brighter() {
        return new DoubleColor(super.brighter(), this.getDarkVariant().brighter());
    }
    
    @Override
    public Color darker() {
        return new DoubleColor(super.darker(), this.getDarkVariant().darker());
    }
    
    @Override
    public int hashCode() {
        return DoubleColor.DARK ? this.getDarkVariant().hashCode() : super.hashCode();
    }
    
    @Override
    public boolean equals(final Object obj) {
        return DoubleColor.DARK ? this.getDarkVariant().equals(obj) : super.equals(obj);
    }
    
    @Override
    public String toString() {
        return DoubleColor.DARK ? this.getDarkVariant().toString() : super.toString();
    }
    
    @Override
    public float[] getRGBComponents(final float[] compArray) {
        return DoubleColor.DARK ? this.getDarkVariant().getRGBComponents(compArray) : super.getRGBComponents(compArray);
    }
    
    @Override
    public float[] getRGBColorComponents(final float[] compArray) {
        return DoubleColor.DARK ? this.getDarkVariant().getRGBColorComponents(compArray) : super.getRGBComponents(compArray);
    }
    
    @Override
    public float[] getComponents(final float[] compArray) {
        return DoubleColor.DARK ? this.getDarkVariant().getComponents(compArray) : super.getComponents(compArray);
    }
    
    @Override
    public float[] getColorComponents(final float[] compArray) {
        return DoubleColor.DARK ? this.getDarkVariant().getColorComponents(compArray) : super.getColorComponents(compArray);
    }
    
    @Override
    public float[] getComponents(final ColorSpace cspace, final float[] compArray) {
        return DoubleColor.DARK ? this.getDarkVariant().getComponents(cspace, compArray) : super.getComponents(cspace, compArray);
    }
    
    @Override
    public float[] getColorComponents(final ColorSpace cspace, final float[] compArray) {
        return DoubleColor.DARK ? this.getDarkVariant().getColorComponents(cspace, compArray) : super.getColorComponents(cspace, compArray);
    }
    
    @Override
    public ColorSpace getColorSpace() {
        return DoubleColor.DARK ? this.getDarkVariant().getColorSpace() : super.getColorSpace();
    }
    
    @Override
    public synchronized PaintContext createContext(final ColorModel cm, final Rectangle r, final Rectangle2D r2d, final AffineTransform xform, final RenderingHints hints) {
        return DoubleColor.DARK ? this.getDarkVariant().createContext(cm, r, r2d, xform, hints) : super.createContext(cm, r, r2d, xform, hints);
    }
    
    @Override
    public int getTransparency() {
        return DoubleColor.DARK ? this.getDarkVariant().getTransparency() : super.getTransparency();
    }
    
    public static Color foreground() {
        return UIUtil.getLabelForeground();
    }
    
    public static Color background() {
        return UIUtil.getListBackground();
    }
    
    static {
        DoubleColor.DARK = UIUtil.isUnderDarcula();
        red = new DoubleColor(Color.red, new Color(255, 100, 100));
        RED = DoubleColor.red;
        blue = new DoubleColor(Color.blue, new Color(5807606));
        BLUE = DoubleColor.blue;
        white = new DoubleColor(Color.white, UIUtil.getListBackground()) {
            @Override
            Color getDarkVariant() {
                return UIUtil.getListBackground();
            }
        };
        WHITE = DoubleColor.white;
        black = new DoubleColor(Color.black, UIUtil.getListForeground()) {
            @Override
            Color getDarkVariant() {
                return UIUtil.getListForeground();
            }
        };
        BLACK = DoubleColor.black;
        gray = new DoubleColor(Gray._128, Gray._128);
        GRAY = DoubleColor.gray;
        lightGray = new DoubleColor(Gray._192, Gray._64);
        LIGHT_GRAY = DoubleColor.lightGray;
        darkGray = new DoubleColor(Gray._64, Gray._192);
        DARK_GRAY = DoubleColor.darkGray;
        pink = new DoubleColor(Color.pink, Color.pink);
        PINK = DoubleColor.pink;
        orange = new DoubleColor(Color.orange, new Color(159, 107, 0));
        ORANGE = DoubleColor.orange;
        yellow = new DoubleColor(Color.yellow, new Color(138, 138, 0));
        YELLOW = DoubleColor.yellow;
        green = new DoubleColor(Color.green, new Color(98, 150, 85));
        GREEN = DoubleColor.green;
        magenta = new DoubleColor(Color.magenta, new Color(151, 118, 169));
        MAGENTA = DoubleColor.magenta;
        cyan = new DoubleColor(Color.cyan, new Color(0, 137, 137));
        CYAN = DoubleColor.cyan;
    }
}
