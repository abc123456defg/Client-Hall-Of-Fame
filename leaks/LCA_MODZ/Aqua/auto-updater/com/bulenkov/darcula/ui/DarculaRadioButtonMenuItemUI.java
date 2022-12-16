// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import javax.swing.UIManager;
import com.bulenkov.iconloader.util.Gray;
import java.awt.Paint;
import java.awt.GradientPaint;
import com.bulenkov.iconloader.util.ColorUtil;
import java.awt.RenderingHints;
import com.bulenkov.iconloader.util.GraphicsConfig;
import java.awt.Graphics2D;
import java.awt.Color;
import sun.swing.MenuItemLayoutHelper;
import java.awt.Graphics;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;

public class DarculaRadioButtonMenuItemUI extends DarculaMenuItemUIBase
{
    public static ComponentUI createUI(final JComponent c) {
        return new DarculaRadioButtonMenuItemUI();
    }
    
    @Override
    protected String getPropertyPrefix() {
        return "RadioButtonMenuItem";
    }
    
    @Override
    protected void paintCheckIcon(final Graphics g2, final MenuItemLayoutHelper lh, final MenuItemLayoutHelper.LayoutResult lr, final Color holdc, final Color foreground) {
        final Graphics2D g3 = (Graphics2D)g2;
        final GraphicsConfig config = new GraphicsConfig(g3);
        g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g3.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_DEFAULT);
        g3.translate(lr.getCheckRect().x + 1, lr.getCheckRect().y + 1);
        final int rad = 5;
        final int x = 0;
        final int y = 0;
        final int w = 13;
        final int h = 13;
        g3.translate(0, 0);
        final Color bg = lh.getMenuItem().getBackground();
        g3.setPaint(new GradientPaint(0.0f, 0.0f, ColorUtil.shift(bg, 1.5), 0.0f, 16.0f, ColorUtil.shift(bg, 1.2)));
        g3.fillOval(0, 1, 12, 12);
        g3.setPaint(new GradientPaint(6.0f, 1.0f, Gray._160.withAlpha(90), 6.0f, 13.0f, Gray._100.withAlpha(90)));
        g3.drawOval(0, 2, 12, 12);
        g3.setPaint(Gray._40.withAlpha(200));
        g3.drawOval(0, 1, 12, 12);
        if (lh.getMenuItem().isSelected()) {
            final boolean enabled = lh.getMenuItem().isEnabled();
            g3.setColor(UIManager.getColor(enabled ? "RadioButton.darcula.selectionEnabledShadowColor" : "RadioButton.darcula.selectionDisabledShadowColor"));
            g3.fillOval((13 - rad) / 2, 6, rad, rad);
            g3.setColor(UIManager.getColor(enabled ? "RadioButton.darcula.selectionEnabledColor" : "RadioButton.darcula.selectionDisabledColor"));
            g3.fillOval((13 - rad) / 2, 5, rad, rad);
        }
        config.restore();
        g3.translate(0, 0);
        g3.translate(-lr.getCheckRect().x - 1, -lr.getCheckRect().y - 1);
        config.restore();
    }
}
