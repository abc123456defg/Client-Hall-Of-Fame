// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Component;
import javax.swing.Icon;

public class CenteredIcon implements Icon
{
    private final Icon myIcon;
    private final int myWidth;
    private final int myHight;
    private final boolean myCenteredInComponent;
    
    public CenteredIcon(final Icon icon) {
        this(icon, icon.getIconWidth(), icon.getIconHeight(), true);
    }
    
    public CenteredIcon(final Icon icon, final int width, final int height) {
        this(icon, width, height, true);
    }
    
    public CenteredIcon(final Icon icon, final int width, final int height, final boolean centeredInComponent) {
        this.myIcon = icon;
        this.myWidth = width;
        this.myHight = height;
        this.myCenteredInComponent = centeredInComponent;
    }
    
    @Override
    public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
        int offsetX;
        int offsetY;
        if (this.myCenteredInComponent) {
            final Dimension size = c.getSize();
            offsetX = size.width / 2 - this.myIcon.getIconWidth() / 2;
            offsetY = size.height / 2 - this.myIcon.getIconHeight() / 2;
        }
        else {
            offsetX = (this.myWidth - this.myIcon.getIconWidth()) / 2;
            offsetY = (this.myHight - this.myIcon.getIconHeight()) / 2;
        }
        this.myIcon.paintIcon(c, g, x + offsetX, y + offsetY);
    }
    
    @Override
    public int getIconWidth() {
        return this.myWidth;
    }
    
    @Override
    public int getIconHeight() {
        return this.myHight;
    }
}
