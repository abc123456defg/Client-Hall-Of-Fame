// 
// Decompiled by Procyon v0.5.36
// 

package com.intellij.util.ui;

import javax.swing.plaf.UIResource;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Insets;

public class JBInsets extends Insets
{
    public JBInsets(final int top, final int left, final int bottom, final int right) {
        super(JBUI.scale(top), JBUI.scale(left), JBUI.scale(bottom), JBUI.scale(right));
    }
    
    public int width() {
        return this.left + this.right;
    }
    
    public int height() {
        return this.top + this.bottom;
    }
    
    public static JBInsets create(final Insets insets) {
        if (insets instanceof JBInsets) {
            final JBInsets copy = new JBInsets(0, 0, 0, 0);
            copy.top = insets.top;
            copy.left = insets.left;
            copy.bottom = insets.bottom;
            copy.right = insets.right;
            return copy;
        }
        return new JBInsets(insets.top, insets.left, insets.bottom, insets.right);
    }
    
    public JBInsetsUIResource asUIResource() {
        return new JBInsetsUIResource(this);
    }
    
    public static void addTo(final Dimension dimension, final Insets insets) {
        if (insets != null) {
            dimension.width += insets.left + insets.right;
            dimension.height += insets.top + insets.bottom;
        }
    }
    
    public static void removeFrom(final Dimension dimension, final Insets insets) {
        if (insets != null) {
            dimension.width -= insets.left + insets.right;
            dimension.height -= insets.top + insets.bottom;
        }
    }
    
    public static void addTo(final Rectangle rectangle, final Insets insets) {
        if (insets != null) {
            rectangle.x -= insets.left;
            rectangle.y -= insets.top;
            rectangle.width += insets.left + insets.right;
            rectangle.height += insets.top + insets.bottom;
        }
    }
    
    public static void removeFrom(final Rectangle rectangle, final Insets insets) {
        if (insets != null) {
            rectangle.x += insets.left;
            rectangle.y += insets.top;
            rectangle.width -= insets.left + insets.right;
            rectangle.height -= insets.top + insets.bottom;
        }
    }
    
    public static class JBInsetsUIResource extends JBInsets implements UIResource
    {
        public JBInsetsUIResource(final JBInsets insets) {
            super(0, 0, 0, 0);
            this.top = insets.top;
            this.left = insets.left;
            this.bottom = insets.bottom;
            this.right = insets.right;
        }
    }
}
