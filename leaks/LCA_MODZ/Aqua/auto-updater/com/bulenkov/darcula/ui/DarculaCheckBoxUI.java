// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import javax.swing.plaf.IconUIResource;
import com.bulenkov.iconloader.util.EmptyIcon;
import javax.swing.Icon;
import javax.swing.UIManager;
import com.bulenkov.iconloader.util.Gray;
import java.awt.Color;
import java.awt.Insets;
import java.awt.FontMetrics;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.ButtonModel;
import java.awt.Shape;
import javax.swing.text.View;
import java.awt.Stroke;
import java.awt.BasicStroke;
import com.bulenkov.darcula.DarculaUIUtil;
import java.awt.Paint;
import java.awt.RenderingHints;
import com.bulenkov.iconloader.util.GraphicsConfig;
import java.awt.GradientPaint;
import javax.swing.SwingUtilities;
import java.awt.Rectangle;
import sun.swing.SwingUtilities2;
import javax.swing.JCheckBox;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.border.Border;
import java.awt.Component;
import com.bulenkov.iconloader.util.UIUtil;
import javax.swing.CellRendererPane;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import javax.swing.plaf.metal.MetalCheckBoxUI;

public class DarculaCheckBoxUI extends MetalCheckBoxUI
{
    public static ComponentUI createUI(final JComponent c) {
        if (UIUtil.getParentOfType((Class<?>)CellRendererPane.class, (Component)c) != null) {
            c.setBorder(null);
        }
        return new DarculaCheckBoxUI();
    }
    
    @Override
    public synchronized void paint(final Graphics g2d, final JComponent c) {
        final Graphics2D g = (Graphics2D)g2d;
        final JCheckBox b = (JCheckBox)c;
        final ButtonModel model = b.getModel();
        final Dimension size = c.getSize();
        final Font font = c.getFont();
        g.setFont(font);
        final FontMetrics fm = SwingUtilities2.getFontMetrics(c, g, font);
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
        if (b.isSelected() && b.getSelectedIcon() != null) {
            b.getSelectedIcon().paintIcon(b, g, iconRect.x + 4, iconRect.y + 2);
        }
        else if (!b.isSelected() && b.getIcon() != null) {
            b.getIcon().paintIcon(b, g, iconRect.x + 4, iconRect.y + 2);
        }
        else {
            final int x = iconRect.x + 3;
            final int y = iconRect.y + 3;
            final int w = iconRect.width - 6;
            final int h = iconRect.height - 6;
            g.translate(x, y);
            final Paint paint = new GradientPaint((float)(w / 2), 0.0f, b.getBackground().brighter(), (float)(w / 2), (float)h, b.getBackground());
            g.setPaint(paint);
            g.fillRect(1, 1, w - 2, h - 2);
            final GraphicsConfig config = new GraphicsConfig(g);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_DEFAULT);
            final boolean armed = b.getModel().isArmed();
            if (c.hasFocus()) {
                g.setPaint(new GradientPaint((float)(w / 2), 1.0f, this.getFocusedBackgroundColor1(armed), (float)(w / 2), (float)h, this.getFocusedBackgroundColor2(armed)));
                g.fillRoundRect(0, 0, w - 2, h - 2, 4, 4);
                DarculaUIUtil.paintFocusRing(g, 1, 1, w - 2, h - 2);
            }
            else {
                g.setPaint(new GradientPaint((float)(w / 2), 1.0f, this.getBackgroundColor1(), (float)(w / 2), (float)h, this.getBackgroundColor2()));
                g.fillRoundRect(0, 0, w, h - 1, 4, 4);
                g.setPaint(new GradientPaint((float)(w / 2), 1.0f, this.getBorderColor1(b.isEnabled()), (float)(w / 2), (float)h, this.getBorderColor2(b.isEnabled())));
                g.drawRoundRect(0, UIUtil.isUnderDarcula() ? 1 : 0, w, h - 1, 4, 4);
                g.setPaint(this.getInactiveFillColor());
                g.drawRoundRect(0, 0, w, h - 1, 4, 4);
            }
            if (b.getModel().isSelected()) {
                g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
                g.setStroke(new BasicStroke(2.0f, 1, 1));
                g.setPaint(this.getShadowColor(b.isEnabled()));
                g.drawLine(4, 7, 7, 11);
                g.drawLine(7, 11, w, 2);
                g.setPaint(this.getCheckSignColor(b.isEnabled()));
                g.drawLine(4, 5, 7, 9);
                g.drawLine(7, 9, w, 0);
            }
            g.translate(-x, -y);
            config.restore();
        }
        if (text != null) {
            final View view = (View)c.getClientProperty("html");
            if (view != null) {
                view.paint(g, textRect);
            }
            else {
                g.setColor(model.isEnabled() ? b.getForeground() : this.getDisabledTextColor());
                SwingUtilities2.drawStringUnderlineCharAt(c, g, text, b.getDisplayedMnemonicIndex(), textRect.x, textRect.y + fm.getAscent());
            }
        }
    }
    
    protected Color getInactiveFillColor() {
        return getColor("inactiveFillColor", Gray._40.withAlpha(180));
    }
    
    protected Color getBorderColor1(final boolean enabled) {
        return enabled ? getColor("borderColor1", Gray._120.withAlpha(90)) : getColor("disabledBorderColor1", Gray._120.withAlpha(90));
    }
    
    protected Color getBorderColor2(final boolean enabled) {
        return enabled ? getColor("borderColor2", Gray._105.withAlpha(90)) : getColor("disabledBorderColor2", Gray._105.withAlpha(90));
    }
    
    protected Color getBackgroundColor1() {
        return getColor("backgroundColor1", Gray._110);
    }
    
    protected Color getBackgroundColor2() {
        return getColor("backgroundColor2", Gray._95);
    }
    
    protected Color getCheckSignColor(final boolean enabled) {
        return enabled ? getColor("checkSignColor", Gray._170) : getColor("checkSignColorDisabled", Gray._120);
    }
    
    protected Color getShadowColor(final boolean enabled) {
        return enabled ? getColor("shadowColor", Gray._30) : getColor("shadowColorDisabled", Gray._60);
    }
    
    protected Color getFocusedBackgroundColor1(final boolean armed) {
        return armed ? getColor("focusedArmed.backgroundColor1", Gray._100) : getColor("focused.backgroundColor1", Gray._120);
    }
    
    protected Color getFocusedBackgroundColor2(final boolean armed) {
        return armed ? getColor("focusedArmed.backgroundColor2", Gray._55) : getColor("focused.backgroundColor2", Gray._75);
    }
    
    protected static Color getColor(final String shortPropertyName, final Color defaultValue) {
        final Color color = UIManager.getColor("CheckBox.darcula." + shortPropertyName);
        return (color == null) ? defaultValue : color;
    }
    
    @Override
    public Icon getDefaultIcon() {
        return new IconUIResource(EmptyIcon.create(20));
    }
}
