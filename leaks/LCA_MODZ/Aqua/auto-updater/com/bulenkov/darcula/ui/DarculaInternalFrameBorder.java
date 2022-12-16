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

public class DarculaInternalFrameBorder implements Border, UIResource
{
    @Override
    public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int w, final int h) {
        g.setColor(UIManager.getColor("InternalFrame.darcula.borderColor"));
        g.drawRect(x, y, w - 1, h - 1);
    }
    
    @Override
    public Insets getBorderInsets(final Component c) {
        return new InsetsUIResource(1, 1, 1, 1);
    }
    
    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
