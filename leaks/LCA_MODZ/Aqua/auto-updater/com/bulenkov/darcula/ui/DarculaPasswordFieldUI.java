// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import java.awt.Insets;
import javax.swing.border.Border;
import java.awt.Container;
import javax.swing.text.JTextComponent;
import java.awt.RenderingHints;
import com.bulenkov.iconloader.util.GraphicsConfig;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusListener;
import javax.swing.plaf.basic.BasicPasswordFieldUI;

public class DarculaPasswordFieldUI extends BasicPasswordFieldUI
{
    private FocusListener myFocusListener;
    
    public DarculaPasswordFieldUI() {
        this.myFocusListener = new FocusAdapter() {
            @Override
            public void focusGained(final FocusEvent e) {
                BasicTextUI.this.getComponent().repaint();
            }
            
            @Override
            public void focusLost(final FocusEvent e) {
                BasicTextUI.this.getComponent().repaint();
            }
        };
    }
    
    public static ComponentUI createUI(final JComponent c) {
        return new DarculaPasswordFieldUI();
    }
    
    @Override
    protected void installListeners() {
        super.installListeners();
        this.getComponent().addFocusListener(this.myFocusListener);
    }
    
    @Override
    protected void uninstallListeners() {
        this.getComponent().removeFocusListener(this.myFocusListener);
        super.uninstallListeners();
    }
    
    @Override
    protected void paintBackground(final Graphics graphics) {
        final Graphics2D g = (Graphics2D)graphics;
        final JTextComponent c = this.getComponent();
        final Container parent = c.getParent();
        if (parent != null) {
            g.setColor(parent.getBackground());
            g.fillRect(0, 0, c.getWidth(), c.getHeight());
        }
        final Border border = c.getBorder();
        if (border instanceof DarculaTextBorder) {
            g.setColor(c.getBackground());
            final int width = c.getWidth();
            final int height = c.getHeight();
            final Insets i = border.getBorderInsets(c);
            if (c.hasFocus()) {
                final GraphicsConfig config = new GraphicsConfig(g);
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
                g.fillRoundRect(i.left - 5, i.top - 2, width - i.left - i.right + 10, height - i.top - i.bottom + 6, 5, 5);
                config.restore();
            }
            else {
                g.fillRect(i.left - 5, i.top - 2, width - i.left - i.right + 12, height - i.top - i.bottom + 6);
            }
        }
        else {
            super.paintBackground(g);
        }
    }
}
