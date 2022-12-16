// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import javax.swing.plaf.InsetsUIResource;
import com.bulenkov.iconloader.util.UIUtil;
import javax.swing.CellRendererPane;
import com.bulenkov.iconloader.util.SystemInfo;
import java.awt.Insets;
import java.awt.Graphics;
import java.awt.Component;
import javax.swing.plaf.UIResource;
import javax.swing.border.Border;

public class DarculaCheckBoxBorder implements Border, UIResource
{
    @Override
    public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
    }
    
    @Override
    public Insets getBorderInsets(final Component c) {
        final int a = (SystemInfo.isMac || UIUtil.getParentOfType((Class<?>)CellRendererPane.class, c) != null) ? 0 : 2;
        return new InsetsUIResource(a, a, a, a);
    }
    
    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
