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
import javax.swing.border.AbstractBorder;

public class DarculaPopupMenuBorder extends AbstractBorder implements UIResource
{
    @Override
    public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
        g.setColor(UIManager.getDefaults().getColor("Separator.foreground"));
        g.drawRect(0, 0, width - 1, height - 1);
    }
    
    @Override
    public Insets getBorderInsets(final Component c) {
        return new InsetsUIResource(1, 1, 1, 1);
    }
}
