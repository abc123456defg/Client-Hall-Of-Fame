// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import javax.swing.plaf.InsetsUIResource;
import java.awt.Insets;
import javax.swing.UIManager;
import java.awt.Graphics;
import java.awt.Component;
import javax.swing.plaf.UIResource;
import javax.swing.border.Border;

public class DarculaMenuBarBorder implements Border, UIResource
{
    @Override
    public void paintBorder(final Component c, final Graphics g, final int x, final int y, int w, int h) {
        g.translate(x, y);
        --w;
        --h;
        g.setColor(UIManager.getColor("MenuBar.darcula.borderColor"));
        g.drawLine(0, h, w, h);
        --h;
        g.setColor(UIManager.getColor("MenuBar.darcula.borderShadowColor"));
        g.drawLine(0, h, w, h);
        g.translate(-x, -y);
    }
    
    @Override
    public Insets getBorderInsets(final Component c) {
        return new InsetsUIResource(0, 0, 2, 0);
    }
    
    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
