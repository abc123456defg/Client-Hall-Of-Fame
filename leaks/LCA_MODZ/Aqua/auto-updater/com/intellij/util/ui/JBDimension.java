// 
// Decompiled by Procyon v0.5.36
// 

package com.intellij.util.ui;

import javax.swing.plaf.UIResource;
import java.awt.Dimension;

public class JBDimension extends Dimension
{
    public final float originalScale;
    
    public JBDimension(final int width, final int height) {
        super(scale(width), scale(height));
        this.originalScale = JBUI.scale(1.0f);
    }
    
    private static int scale(final int size) {
        return (size == -1) ? -1 : JBUI.scale(size);
    }
    
    public static JBDimension create(final Dimension from) {
        if (from instanceof JBDimension) {
            return (JBDimension)from;
        }
        return new JBDimension(from.width, from.height);
    }
    
    public JBDimensionUIResource asUIResource() {
        return new JBDimensionUIResource(this);
    }
    
    public JBDimension withWidth(final int width) {
        final JBDimension size = new JBDimension(0, 0);
        size.width = scale(width);
        size.height = this.height;
        return size;
    }
    
    public JBDimension withHeight(final int height) {
        final JBDimension size = new JBDimension(0, 0);
        size.width = this.width;
        size.height = scale(height);
        return size;
    }
    
    public static class JBDimensionUIResource extends JBDimension implements UIResource
    {
        public JBDimensionUIResource(final JBDimension size) {
            super(0, 0);
            this.width = size.width;
            this.height = size.height;
        }
    }
}
