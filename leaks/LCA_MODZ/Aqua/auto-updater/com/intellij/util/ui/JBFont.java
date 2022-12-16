// 
// Decompiled by Procyon v0.5.36
// 

package com.intellij.util.ui;

import javax.swing.plaf.UIResource;
import java.awt.Font;

public class JBFont extends Font
{
    private JBFont(final Font font) {
        super(font);
    }
    
    public static JBFont create(final Font font) {
        return create(font, true);
    }
    
    public static JBFont create(final Font font, final boolean tryToScale) {
        if (font instanceof JBFont) {
            return (JBFont)font;
        }
        Font scaled = font;
        if (tryToScale) {
            scaled = font.deriveFont(font.getSize() * JBUI.scale(1.0f));
        }
        if (font instanceof UIResource) {
            return new JBFontUIResource(scaled);
        }
        return new JBFont(scaled);
    }
    
    public JBFont asBold() {
        return this.deriveFont(1, (float)this.getSize());
    }
    
    public JBFont asItalic() {
        return this.deriveFont(2, (float)this.getSize());
    }
    
    public JBFont asPlain() {
        return this.deriveFont(0, (float)this.getSize());
    }
    
    @Override
    public JBFont deriveFont(final int style, final float size) {
        return create(super.deriveFont(style, size), false);
    }
    
    @Override
    public JBFont deriveFont(final float size) {
        return create(super.deriveFont(size), false);
    }
    
    public JBFont biggerOn(final float size) {
        return this.deriveFont(this.getSize() + JBUI.scale(size));
    }
    
    public JBFont lessOn(final float size) {
        return this.deriveFont(this.getSize() - JBUI.scale(size));
    }
    
    private static class JBFontUIResource extends JBFont implements UIResource
    {
        private JBFontUIResource(final Font font) {
            super(font, null);
        }
    }
}
