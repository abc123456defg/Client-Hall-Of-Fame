// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.plaf.basic.BasicEditorPaneUI;

public class DarculaEditorPaneUI extends BasicEditorPaneUI
{
    private final JEditorPane myEditorPane;
    
    public DarculaEditorPaneUI(final JComponent comp) {
        this.myEditorPane = (JEditorPane)comp;
    }
    
    public static ComponentUI createUI(final JComponent comp) {
        return new DarculaEditorPaneUI(comp);
    }
    
    @Override
    protected void installDefaults() {
        super.installDefaults();
    }
}
