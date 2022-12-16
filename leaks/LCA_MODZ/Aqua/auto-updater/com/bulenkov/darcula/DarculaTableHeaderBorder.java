// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula;

import java.awt.Insets;
import java.awt.Graphics;
import java.awt.Component;
import javax.swing.plaf.UIResource;
import javax.swing.border.Border;

public class DarculaTableHeaderBorder implements Border, UIResource
{
    @Override
    public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
    }
    
    @Override
    public Insets getBorderInsets(final Component c) {
        return new Insets(0, 0, 0, 0);
    }
    
    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
