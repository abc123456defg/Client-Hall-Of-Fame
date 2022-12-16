// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import javax.swing.plaf.IconUIResource;
import com.bulenkov.iconloader.util.EmptyIcon;
import javax.swing.Icon;
import com.bulenkov.iconloader.util.GraphicsConfig;
import java.awt.Insets;
import java.awt.FontMetrics;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.ButtonModel;
import java.awt.Shape;
import javax.swing.text.View;
import javax.swing.UIManager;
import com.bulenkov.iconloader.util.Gray;
import com.bulenkov.darcula.DarculaUIUtil;
import com.bulenkov.iconloader.util.UIUtil;
import java.awt.Paint;
import java.awt.GradientPaint;
import com.bulenkov.iconloader.util.ColorUtil;
import com.bulenkov.iconloader.util.GraphicsUtil;
import javax.swing.SwingUtilities;
import java.awt.Rectangle;
import sun.swing.SwingUtilities2;
import javax.swing.AbstractButton;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import javax.swing.plaf.metal.MetalRadioButtonUI;

public class DarculaRadioButtonUI extends MetalRadioButtonUI
{
    public static ComponentUI createUI(final JComponent c) {
        return new DarculaRadioButtonUI();
    }
    
    @Override
    public synchronized void paint(final Graphics g2d, final JComponent c) {
        final Graphics2D g = (Graphics2D)g2d;
        final AbstractButton b = (AbstractButton)c;
        final ButtonModel model = b.getModel();
        final Dimension size = c.getSize();
        final Font f = c.getFont();
        g.setFont(f);
        final FontMetrics fm = SwingUtilities2.getFontMetrics(c, g, f);
        final Rectangle viewRect = new Rectangle(size);
        final Rectangle iconRect = new Rectangle();
        final Rectangle textRect = new Rectangle();
        final Insets i = c.getInsets();
        final Rectangle rectangle = viewRect;
        rectangle.x += i.left;
        final Rectangle rectangle2 = viewRect;
        rectangle2.y += i.top;
        final Rectangle rectangle3 = viewRect;
        rectangle3.width -= i.right + viewRect.x;
        final Rectangle rectangle4 = viewRect;
        rectangle4.height -= i.bottom + viewRect.y;
        final String text = SwingUtilities.layoutCompoundLabel(c, fm, b.getText(), this.getDefaultIcon(), b.getVerticalAlignment(), b.getHorizontalAlignment(), b.getVerticalTextPosition(), b.getHorizontalTextPosition(), viewRect, iconRect, textRect, b.getIconTextGap());
        if (c.isOpaque()) {
            g.setColor(b.getBackground());
            g.fillRect(0, 0, size.width, size.height);
        }
        final int rad = 5;
        final int x = iconRect.x + (rad - 1) / 2;
        final int y = iconRect.y + (rad - 1) / 2;
        final int w = iconRect.width - (rad + 5) / 2;
        final int h = iconRect.height - (rad + 5) / 2;
        g.translate(x, y);
        final GraphicsConfig config = GraphicsUtil.setupAAPainting(g);
        final boolean focus = b.hasFocus();
        g.setPaint(new GradientPaint(0.0f, 0.0f, ColorUtil.shift(c.getBackground(), 1.5), 0.0f, (float)c.getHeight(), ColorUtil.shift(c.getBackground(), 1.2)));
        if (focus) {
            g.fillOval(0, 1, w, h);
        }
        else {
            g.fillOval(0, 1, w - 1, h - 1);
        }
        if (focus) {
            if (UIUtil.isRetina()) {
                DarculaUIUtil.paintFocusOval(g, 1, 2, w - 2, h - 2);
            }
            else {
                DarculaUIUtil.paintFocusOval(g, 0, 1, w, h);
            }
        }
        else if (UIUtil.isUnderDarcula()) {
            g.setPaint(new GradientPaint((float)(w / 2), 1.0f, Gray._160.withAlpha(90), (float)(w / 2), (float)h, Gray._100.withAlpha(90)));
            g.drawOval(0, 2, w - 1, h - 1);
            g.setPaint(Gray._40.withAlpha(200));
            g.drawOval(0, 1, w - 1, h - 1);
        }
        else {
            g.setPaint(b.isEnabled() ? Gray._30 : Gray._130);
            g.drawOval(0, 1, w - 1, h - 1);
        }
        if (b.isSelected()) {
            final boolean enabled = b.isEnabled();
            g.setColor(UIManager.getColor(enabled ? "RadioButton.darcula.selectionEnabledShadowColor" : "RadioButton.darcula.selectionDisabledShadowColor"));
            g.fillOval(w / 2 - rad / 2, h / 2, rad, rad);
            g.setColor(UIManager.getColor(enabled ? "RadioButton.darcula.selectionEnabledColor" : "RadioButton.darcula.selectionDisabledColor"));
            g.fillOval(w / 2 - rad / 2, h / 2 - 1, rad, rad);
        }
        config.restore();
        g.translate(-x, -y);
        if (text != null) {
            final View v = (View)c.getClientProperty("html");
            if (v != null) {
                v.paint(g, textRect);
            }
            else {
                final int mnemIndex = b.getDisplayedMnemonicIndex();
                if (model.isEnabled()) {
                    g.setColor(b.getForeground());
                }
                else {
                    g.setColor(this.getDisabledTextColor());
                }
                SwingUtilities2.drawStringUnderlineCharAt(c, g, text, mnemIndex, textRect.x, textRect.y + fm.getAscent());
            }
        }
    }
    
    @Override
    public Icon getDefaultIcon() {
        return new IconUIResource(EmptyIcon.create(20));
    }
}
