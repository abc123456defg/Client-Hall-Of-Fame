// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicSplitPaneUI;

public class DarculaSplitPaneUI extends BasicSplitPaneUI
{
    public static ComponentUI createUI(final JComponent c) {
        return new DarculaSplitPaneUI();
    }
    
    @Override
    public BasicSplitPaneDivider createDefaultDivider() {
        return new DarculaSplitPaneDivider(this);
    }
}
