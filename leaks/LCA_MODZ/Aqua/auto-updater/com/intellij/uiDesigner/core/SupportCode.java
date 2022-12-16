// 
// Decompiled by Procyon v0.5.36
// 

package com.intellij.uiDesigner.core;

import java.lang.reflect.Method;
import javax.swing.JComponent;

public final class SupportCode
{
    public static TextWithMnemonic parseText(final String textWithMnemonic) {
        if (textWithMnemonic == null) {
            throw new IllegalArgumentException("textWithMnemonic cannot be null");
        }
        int index = -1;
        final StringBuffer plainText = new StringBuffer();
        for (int i = 0; i < textWithMnemonic.length(); ++i) {
            char ch = textWithMnemonic.charAt(i);
            if (ch == '&') {
                if (++i >= textWithMnemonic.length()) {
                    break;
                }
                ch = textWithMnemonic.charAt(i);
                if (ch != '&') {
                    index = plainText.length();
                }
            }
            plainText.append(ch);
        }
        return new TextWithMnemonic(plainText.toString(), index, null);
    }
    
    public static void setDisplayedMnemonicIndex(final JComponent component, final int index) {
        try {
            final Method method = component.getClass().getMethod("setDisplayedMnemonicIndex", Integer.TYPE);
            method.setAccessible(true);
            method.invoke(component, new Integer(index));
        }
        catch (Exception ex) {}
    }
    
    public static final class TextWithMnemonic
    {
        public final String myText;
        public final int myMnemonicIndex;
        
        private TextWithMnemonic(final String text, final int index) {
            if (text == null) {
                throw new IllegalArgumentException("text cannot be null");
            }
            if (index != -1 && (index < 0 || index >= text.length())) {
                throw new IllegalArgumentException("wrong index: " + index + "; text = '" + text + "'");
            }
            this.myText = text;
            this.myMnemonicIndex = index;
        }
        
        public char getMnemonicChar() {
            if (this.myMnemonicIndex == -1) {
                throw new IllegalStateException("text doesn't contain mnemonic");
            }
            return Character.toUpperCase(this.myText.charAt(this.myMnemonicIndex));
        }
    }
}
