// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import java.awt.Color;
import com.bulenkov.iconloader.util.Gray;
import javax.swing.text.JTextComponent;
import com.bulenkov.darcula.DarculaUIUtil;
import com.bulenkov.iconloader.util.GraphicsConfig;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.JPasswordField;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.plaf.UIResource;
import javax.swing.border.Border;

public class DarculaTextBorder implements Border, UIResource
{
    @Override
    public Insets getBorderInsets(final Component c) {
        int vOffset = (c instanceof JPasswordField) ? 3 : 4;
        if (DarculaTextFieldUI.isSearchField(c)) {
            vOffset += 2;
        }
        if (DarculaTextFieldUI.isSearchFieldWithHistoryPopup(c)) {
            return new InsetsUIResource(vOffset, 26, vOffset, 23);
        }
        if (DarculaTextFieldUI.isSearchField(c)) {
            return new InsetsUIResource(vOffset, 23, vOffset, 23);
        }
        return new InsetsUIResource(vOffset, 7, vOffset, 7);
    }
    
    @Override
    public boolean isBorderOpaque() {
        return false;
    }
    
    @Override
    public void paintBorder(final Component c, final Graphics g2, final int x, final int y, final int width, final int height) {
        if (DarculaTextFieldUI.isSearchField(c)) {
            return;
        }
        final Graphics2D g3 = (Graphics2D)g2;
        final GraphicsConfig config = new GraphicsConfig(g3);
        g3.translate(x, y);
        if (c.hasFocus()) {
            DarculaUIUtil.paintFocusRing(g3, 2, 2, width - 4, height - 4);
        }
        else {
            final boolean editable = !(c instanceof JTextComponent) || ((JTextComponent)c).isEditable();
            g3.setColor((c.isEnabled() && editable) ? Gray._100 : new Color(5460819));
            g3.drawRect(1, 1, width - 2, height - 2);
        }
        g3.translate(-x, -y);
        config.restore();
    }
}
