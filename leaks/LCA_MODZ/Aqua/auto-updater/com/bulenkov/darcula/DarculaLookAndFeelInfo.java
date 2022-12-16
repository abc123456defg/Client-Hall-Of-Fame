// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula;

import javax.swing.UIManager;

public class DarculaLookAndFeelInfo extends UIManager.LookAndFeelInfo
{
    public static final String CLASS_NAME = "idea.dark.laf.classname";
    
    public DarculaLookAndFeelInfo() {
        super("Darcula", "idea.dark.laf.classname");
    }
    
    @Override
    public boolean equals(final Object obj) {
        return obj instanceof DarculaLookAndFeelInfo;
    }
    
    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }
}
