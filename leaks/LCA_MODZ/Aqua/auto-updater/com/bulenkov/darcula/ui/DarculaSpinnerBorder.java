// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import javax.swing.plaf.InsetsUIResource;
import java.awt.Insets;
import com.bulenkov.iconloader.util.GraphicsConfig;
import com.bulenkov.iconloader.util.DoubleColor;
import com.bulenkov.darcula.DarculaUIUtil;
import java.awt.Composite;
import java.awt.AlphaComposite;
import java.awt.Color;
import com.bulenkov.iconloader.util.Gray;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.UIManager;
import com.bulenkov.iconloader.util.GraphicsUtil;
import javax.swing.JComponent;
import com.bulenkov.iconloader.util.UIUtil;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import java.awt.Graphics;
import java.awt.Component;
import javax.swing.plaf.UIResource;
import javax.swing.border.Border;

public class DarculaSpinnerBorder implements Border, UIResource
{
    @Override
    public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
        final JSpinner spinner = (JSpinner)c;
        final JFormattedTextField editor = UIUtil.findComponentOfType(spinner, JFormattedTextField.class);
        final int x2 = x + 1;
        final int y2 = y + 3;
        final int width2 = width - 2;
        final int height2 = height - 6;
        final boolean focused = c.isEnabled() && c.isVisible() && editor != null && editor.hasFocus();
        final GraphicsConfig config = GraphicsUtil.setupAAPainting(g);
        if (c.isOpaque()) {
            g.setColor(UIUtil.getPanelBackground());
            g.fillRect(x, y, width, height);
        }
        g.setColor(UIUtil.getTextFieldBackground());
        g.fillRoundRect(x2, y2, width2, height2, 5, 5);
        g.setColor(UIManager.getColor(spinner.isEnabled() ? "Spinner.darcula.enabledButtonColor" : "Spinner.darcula.disabledButtonColor"));
        if (editor != null) {
            final int off = editor.getBounds().x + editor.getWidth() + ((JSpinner)c).getInsets().left + 1;
            final Area rect = new Area(new RoundRectangle2D.Double(x2, y2, width2, height2, 5.0, 5.0));
            final Area blueRect = new Area(new Rectangle(off, y2, 22, height2));
            rect.intersect(blueRect);
            ((Graphics2D)g).fill(rect);
            if (UIUtil.isUnderDarcula()) {
                g.setColor(Gray._100);
                g.drawLine(off, y2, off, height2 + 2);
            }
        }
        if (!c.isEnabled()) {
            ((Graphics2D)g).setComposite(AlphaComposite.getInstance(3, 0.4f));
        }
        if (focused) {
            DarculaUIUtil.paintFocusRing(g, x2 + 2, y2, width2 - 3, height2);
        }
        else {
            g.setColor(new DoubleColor(Gray._149, Gray._100));
            g.drawRoundRect(x2, y2, width2, height2, 5, 5);
        }
        config.restore();
    }
    
    @Override
    public Insets getBorderInsets(final Component c) {
        return new InsetsUIResource(5, 7, 5, 7);
    }
    
    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
