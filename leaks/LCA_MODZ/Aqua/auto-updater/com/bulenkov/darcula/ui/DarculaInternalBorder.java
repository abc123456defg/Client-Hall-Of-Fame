// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import javax.swing.plaf.InsetsUIResource;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Component;
import javax.swing.border.Border;
import javax.swing.plaf.UIResource;

public class DarculaInternalBorder implements UIResource, Border
{
    @Override
    public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, width, height);
    }
    
    @Override
    public Insets getBorderInsets(final Component c) {
        return new InsetsUIResource(20, 3, 3, 3);
    }
    
    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
