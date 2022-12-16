// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import java.awt.Composite;
import java.awt.AlphaComposite;
import java.awt.RenderingHints;
import java.util.Map;
import java.awt.Toolkit;
import java.awt.Graphics2D;
import java.awt.Graphics;

public class GraphicsUtil
{
    public static void setupAntialiasing(final Graphics g2) {
        setupAntialiasing(g2, true, false);
    }
    
    public static void setupAntialiasing(final Graphics g2, final boolean enableAA, final boolean ignoreSystemSettings) {
        if (g2 instanceof Graphics2D) {
            final Graphics2D g3 = (Graphics2D)g2;
            final Toolkit tk = Toolkit.getDefaultToolkit();
            final Map map = (Map)tk.getDesktopProperty("awt.font.desktophints");
            if (map != null && !ignoreSystemSettings) {
                g3.addRenderingHints(map);
            }
            else {
                g3.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, enableAA ? RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HBGR : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
            }
        }
    }
    
    public static GraphicsConfig setupAAPainting(final Graphics g) {
        final GraphicsConfig config = new GraphicsConfig(g);
        final Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        return config;
    }
    
    public static GraphicsConfig paintWithAlpha(final Graphics g, final float alpha) {
        assert 0.0f <= alpha && alpha <= 1.0f : "alpha should be in range 0.0f .. 1.0f";
        final GraphicsConfig config = new GraphicsConfig(g);
        final Graphics2D g2 = (Graphics2D)g;
        g2.setComposite(AlphaComposite.getInstance(3, alpha));
        return config;
    }
}
