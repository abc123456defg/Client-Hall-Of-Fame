// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import java.awt.Stroke;
import java.awt.BasicStroke;
import com.bulenkov.iconloader.util.UIUtil;
import java.awt.Paint;
import java.awt.GradientPaint;
import com.bulenkov.iconloader.util.Gray;
import java.awt.RenderingHints;
import com.bulenkov.iconloader.util.GraphicsConfig;
import java.awt.Graphics2D;
import java.awt.Color;
import sun.swing.MenuItemLayoutHelper;
import java.awt.Graphics;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;

public class DarculaCheckBoxMenuItemUI extends DarculaMenuItemUIBase
{
    public static ComponentUI createUI(final JComponent c) {
        return new DarculaCheckBoxMenuItemUI();
    }
    
    @Override
    protected String getPropertyPrefix() {
        return "CheckBoxMenuItem";
    }
    
    @Override
    protected void paintCheckIcon(final Graphics g2, final MenuItemLayoutHelper lh, final MenuItemLayoutHelper.LayoutResult lr, final Color holdc, final Color foreground) {
        final Graphics2D g3 = (Graphics2D)g2;
        final GraphicsConfig config = new GraphicsConfig(g3);
        g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g3.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_DEFAULT);
        g3.translate(lr.getCheckRect().x + 2, lr.getCheckRect().y + 2);
        final int sz = 13;
        g3.setPaint(new GradientPaint(6.0f, 1.0f, Gray._110, 6.0f, 13.0f, Gray._95));
        g3.fillRoundRect(0, 0, 13, 12, 4, 4);
        g3.setPaint(new GradientPaint(6.0f, 1.0f, Gray._120.withAlpha(90), 6.0f, 13.0f, Gray._105.withAlpha(90)));
        g3.drawRoundRect(0, UIUtil.isUnderDarcula() ? 1 : 0, 13, 12, 4, 4);
        g3.setPaint(Gray._40.withAlpha(180));
        g3.drawRoundRect(0, 0, 13, 12, 4, 4);
        if (lh.getMenuItem().isSelected()) {
            g3.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            g3.setStroke(new BasicStroke(2.0f, 1, 1));
            g3.setPaint(Gray._30);
            g3.drawLine(4, 7, 7, 10);
            g3.drawLine(7, 10, 13, 2);
            g3.setPaint(Gray._170);
            g3.drawLine(4, 5, 7, 8);
            g3.drawLine(7, 8, 13, 0);
        }
        g3.translate(-lr.getCheckRect().x - 2, -lr.getCheckRect().y - 2);
        config.restore();
        g3.setColor(foreground);
    }
}
