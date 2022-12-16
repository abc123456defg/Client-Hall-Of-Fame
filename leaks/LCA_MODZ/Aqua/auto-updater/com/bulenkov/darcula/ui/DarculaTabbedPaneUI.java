// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class DarculaTabbedPaneUI extends BasicTabbedPaneUI
{
    public static ComponentUI createUI(final JComponent c) {
        return new DarculaTabbedPaneUI();
    }
}
