// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import javax.swing.UIManager;
import java.awt.Graphics;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import javax.swing.plaf.metal.MetalMenuBarUI;

public class DarculaMenuBarUI extends MetalMenuBarUI
{
    public static ComponentUI createUI(final JComponent c) {
        return new DarculaMenuBarUI();
    }
    
    @Override
    public void paint(final Graphics g, final JComponent c) {
        g.setColor(UIManager.getColor("MenuItem.background"));
        g.fillRect(0, 0, c.getWidth(), c.getHeight());
    }
}
