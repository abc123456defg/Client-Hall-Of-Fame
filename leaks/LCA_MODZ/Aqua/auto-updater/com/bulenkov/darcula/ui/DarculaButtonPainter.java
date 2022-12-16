// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import javax.swing.plaf.InsetsUIResource;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.GradientPaint;
import com.bulenkov.iconloader.util.Gray;
import java.awt.RenderingHints;
import com.bulenkov.iconloader.util.GraphicsConfig;
import com.bulenkov.darcula.DarculaUIUtil;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Component;
import javax.swing.plaf.UIResource;
import javax.swing.border.Border;

public class DarculaButtonPainter implements Border, UIResource
{
    private static final int myOffset = 4;
    
    @Override
    public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
        final Graphics2D g2d = (Graphics2D)g;
        final Insets ins = this.getBorderInsets(c);
        final int yOff = (ins.top + ins.bottom) / 4;
        final boolean square = DarculaButtonUI.isSquare(c);
        final int offset = square ? 1 : this.getOffset();
        if (c.hasFocus()) {
            DarculaUIUtil.paintFocusRing(g2d, offset, yOff, width - 2 * offset, height - 2 * yOff);
        }
        else {
            final GraphicsConfig config = new GraphicsConfig(g);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_DEFAULT);
            g2d.setPaint(new GradientPaint((float)(width / 2), (float)(y + yOff + 1), Gray._80.withAlpha(90), (float)(width / 2), (float)(height - 2 * yOff), Gray._90.withAlpha(90)));
            ((Graphics2D)g).setPaint(Gray._100.withAlpha(180));
            g.drawRoundRect(x + offset, y + yOff, width - 2 * offset, height - 2 * yOff, square ? 3 : 5, square ? 3 : 5);
            config.restore();
        }
    }
    
    @Override
    public Insets getBorderInsets(final Component c) {
        if (DarculaButtonUI.isSquare(c)) {
            return new InsetsUIResource(2, 0, 2, 0);
        }
        return new InsetsUIResource(8, 16, 8, 14);
    }
    
    protected int getOffset() {
        return 4;
    }
    
    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
