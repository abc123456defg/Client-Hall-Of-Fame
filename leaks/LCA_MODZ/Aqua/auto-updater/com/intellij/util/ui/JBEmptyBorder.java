// 
// Decompiled by Procyon v0.5.36
// 

package com.intellij.util.ui;

import javax.swing.plaf.UIResource;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;

public class JBEmptyBorder extends EmptyBorder
{
    public JBEmptyBorder(final int top, final int left, final int bottom, final int right) {
        super(JBUI.insets(top, left, bottom, right));
    }
    
    public JBEmptyBorder(final Insets insets) {
        super(JBUI.insets(insets));
    }
    
    public JBEmptyBorder(final int offset) {
        this(offset, offset, offset, offset);
    }
    
    public JBEmptyBorderUIResource asUIResource() {
        return new JBEmptyBorderUIResource(this);
    }
    
    public static class JBEmptyBorderUIResource extends JBEmptyBorder implements UIResource
    {
        public JBEmptyBorderUIResource(final JBEmptyBorder border) {
            super(0, 0, 0, 0);
            this.top = border.top;
            this.left = border.left;
            this.bottom = border.bottom;
            this.right = border.right;
        }
    }
}
