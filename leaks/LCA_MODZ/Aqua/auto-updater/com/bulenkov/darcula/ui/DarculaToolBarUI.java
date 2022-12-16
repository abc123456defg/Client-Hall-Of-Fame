// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import java.awt.Component;
import javax.swing.UIManager;
import java.awt.Graphics;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import javax.swing.plaf.metal.MetalToolBarUI;

public class DarculaToolBarUI extends MetalToolBarUI
{
    public static ComponentUI createUI(final JComponent c) {
        return new DarculaToolBarUI();
    }
    
    @Override
    public void paint(final Graphics g, final JComponent c) {
        g.setColor(UIManager.getColor("ToolBar.background"));
        g.fillRect(0, 0, c.getWidth(), c.getHeight());
    }
    
    @Override
    protected void setBorderToNonRollover(final Component c) {
    }
}
