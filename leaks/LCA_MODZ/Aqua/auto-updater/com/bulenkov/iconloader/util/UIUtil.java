// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.Font;
import com.bulenkov.iconloader.RetinaImage;
import java.awt.image.BufferedImage;
import java.lang.reflect.Field;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import com.bulenkov.iconloader.IsRetina;
import java.awt.Graphics2D;
import com.bulenkov.iconloader.JBHiDPIScaledImage;
import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.UIManager;
import org.jetbrains.annotations.Nullable;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.GrayFilter;
import java.awt.Color;

public class UIUtil
{
    public static final Color TRANSPARENT_COLOR;
    private static volatile Pair<String, Integer> ourSystemFontData;
    public static final float DEF_SYSTEM_FONT_SIZE = 12.0f;
    private static final Color DECORATED_ROW_BG_COLOR;
    private static final Ref<Boolean> ourRetina;
    private static final GrayFilter DEFAULT_GRAY_FILTER;
    private static final GrayFilter DARCULA_GRAY_FILTER;
    
    public static <T extends JComponent> T findComponentOfType(final JComponent parent, final Class<T> cls) {
        if (parent == null || cls.isAssignableFrom(parent.getClass())) {
            final T t = (T)parent;
            return t;
        }
        for (final Component component : parent.getComponents()) {
            if (component instanceof JComponent) {
                final T comp = (T)findComponentOfType((JComponent)component, (Class<JComponent>)cls);
                if (comp != null) {
                    return comp;
                }
            }
        }
        return null;
    }
    
    @Nullable
    public static Pair<String, Integer> getSystemFontData() {
        return UIUtil.ourSystemFontData;
    }
    
    public static <T> T getParentOfType(final Class<? extends T> cls, final Component c) {
        for (Component eachParent = c; eachParent != null; eachParent = eachParent.getParent()) {
            if (cls.isAssignableFrom(eachParent.getClass())) {
                final T t = (T)eachParent;
                return t;
            }
        }
        return null;
    }
    
    public static boolean isAppleRetina() {
        return isRetina() && SystemInfo.isAppleJvm;
    }
    
    public static Color getControlColor() {
        return UIManager.getColor("control");
    }
    
    public static Color getPanelBackground() {
        return UIManager.getColor("Panel.background");
    }
    
    public static boolean isUnderDarcula() {
        return UIManager.getLookAndFeel().getName().equals("Darcula");
    }
    
    public static Color getListBackground() {
        return UIManager.getColor("List.background");
    }
    
    public static Color getListForeground() {
        return UIManager.getColor("List.foreground");
    }
    
    public static Color getLabelForeground() {
        return UIManager.getColor("Label.foreground");
    }
    
    public static Color getTextFieldBackground() {
        return UIManager.getColor("TextField.background");
    }
    
    public static Color getTreeSelectionForeground() {
        return UIManager.getColor("Tree.selectionForeground");
    }
    
    public static Color getTreeForeground() {
        return UIManager.getColor("Tree.foreground");
    }
    
    public static Color getDecoratedRowColor() {
        return UIUtil.DECORATED_ROW_BG_COLOR;
    }
    
    public static Color getTreeSelectionBackground(final boolean focused) {
        return focused ? getTreeSelectionBackground() : getTreeUnfocusedSelectionBackground();
    }
    
    private static Color getTreeSelectionBackground() {
        return UIManager.getColor("Tree.selectionBackground");
    }
    
    public static Color getTreeUnfocusedSelectionBackground() {
        final Color background = getTreeTextBackground();
        return ColorUtil.isDark(background) ? new DoubleColor(Gray._30, new Color(13, 41, 62)) : Gray._212;
    }
    
    public static Color getTreeTextBackground() {
        return UIManager.getColor("Tree.textBackground");
    }
    
    public static void drawImage(final Graphics g, final Image image, final int x, final int y, final ImageObserver observer) {
        if (image instanceof JBHiDPIScaledImage) {
            final Graphics2D newG = (Graphics2D)g.create(x, y, image.getWidth(observer), image.getHeight(observer));
            newG.scale(0.5, 0.5);
            Image img = ((JBHiDPIScaledImage)image).getDelegate();
            if (img == null) {
                img = image;
            }
            newG.drawImage(img, 0, 0, observer);
            newG.scale(1.0, 1.0);
            newG.dispose();
        }
        else {
            g.drawImage(image, x, y, observer);
        }
    }
    
    public static boolean isRetina() {
        synchronized (UIUtil.ourRetina) {
            if (UIUtil.ourRetina.isNull()) {
                UIUtil.ourRetina.set(false);
                if (SystemInfo.isJavaVersionAtLeast("1.6.0_33") && SystemInfo.isAppleJvm) {
                    if (!"false".equals(System.getProperty("ide.mac.retina"))) {
                        UIUtil.ourRetina.set(IsRetina.isRetina());
                        return UIUtil.ourRetina.get();
                    }
                }
                else if (SystemInfo.isJavaVersionAtLeast("1.7.0_40") && (SystemInfo.isOracleJvm || SystemInfo.isJetbrainsJvm)) {
                    final GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
                    final GraphicsDevice device = env.getDefaultScreenDevice();
                    try {
                        final Field field = device.getClass().getDeclaredField("scale");
                        if (field != null) {
                            field.setAccessible(true);
                            final Object scale = field.get(device);
                            if (scale instanceof Integer && (int)scale == 2) {
                                UIUtil.ourRetina.set(true);
                                return true;
                            }
                        }
                    }
                    catch (Exception ex) {}
                }
                UIUtil.ourRetina.set(false);
            }
            return UIUtil.ourRetina.get();
        }
    }
    
    public static BufferedImage createImage(final int width, final int height, final int type) {
        if (isRetina()) {
            return RetinaImage.create(width, height, type);
        }
        return new BufferedImage(width, height, type);
    }
    
    public static GrayFilter getGrayFilter() {
        return isUnderDarcula() ? UIUtil.DARCULA_GRAY_FILTER : UIUtil.DEFAULT_GRAY_FILTER;
    }
    
    public static Font getLabelFont() {
        return UIManager.getFont("Label.font");
    }
    
    public static float getFontSize(final FontSize size) {
        final int defSize = getLabelFont().getSize();
        switch (size) {
            case SMALL: {
                return Math.max(defSize - JBUI.scale(2.0f), JBUI.scale(11.0f));
            }
            case MINI: {
                return Math.max(defSize - JBUI.scale(4.0f), JBUI.scale(9.0f));
            }
            default: {
                return (float)defSize;
            }
        }
    }
    
    public static void initSystemFontData() {
        if (UIUtil.ourSystemFontData != null) {
            return;
        }
        Font font = getLabelFont();
        Float forcedScale = null;
        if (Registry.is("ide.ui.scale.override")) {
            forcedScale = Registry.getFloat("ide.ui.scale");
        }
        else if (SystemInfo.isLinux && !SystemInfo.isJetbrainsJvm) {
            final float scale = getScreenScale();
            if (scale > 1.0f) {
                forcedScale = scale;
            }
        }
        else if (SystemInfo.isWindows) {
            final Font winFont = (Font)Toolkit.getDefaultToolkit().getDesktopProperty("win.messagebox.font");
            if (winFont != null) {
                font = winFont;
            }
        }
        if (forcedScale != null) {
            font = font.deriveFont(12.0f * forcedScale);
        }
        UIUtil.ourSystemFontData = Pair.create(font.getName(), font.getSize());
    }
    
    private static float getScreenScale() {
        int dpi = 96;
        try {
            dpi = Toolkit.getDefaultToolkit().getScreenResolution();
        }
        catch (HeadlessException ex) {}
        float scale = 1.0f;
        if (dpi < 120) {
            scale = 1.0f;
        }
        else if (dpi < 144) {
            scale = 1.25f;
        }
        else if (dpi < 168) {
            scale = 1.5f;
        }
        else if (dpi < 192) {
            scale = 1.75f;
        }
        else {
            scale = 2.0f;
        }
        return scale;
    }
    
    static {
        TRANSPARENT_COLOR = new Color(0, 0, 0, 0);
        DECORATED_ROW_BG_COLOR = new DoubleColor(new Color(242, 245, 249), new Color(65, 69, 71));
        ourRetina = Ref.create(SystemInfo.isMac ? null : Boolean.valueOf(false));
        DEFAULT_GRAY_FILTER = new GrayFilter(true, 65);
        DARCULA_GRAY_FILTER = new GrayFilter(true, 30);
    }
    
    public enum FontSize
    {
        NORMAL, 
        SMALL, 
        MINI;
    }
}
