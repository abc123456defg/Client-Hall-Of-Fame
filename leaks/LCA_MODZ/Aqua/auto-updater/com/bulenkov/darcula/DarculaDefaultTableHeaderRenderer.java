// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.plaf.UIResource;
import javax.swing.table.DefaultTableCellRenderer;

public class DarculaDefaultTableHeaderRenderer extends DefaultTableCellRenderer implements UIResource
{
    public DarculaDefaultTableHeaderRenderer() {
        this.setHorizontalAlignment(0);
    }
    
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object value, final boolean isSelected, final boolean hasFocus, final int row, final int column) {
        return this;
    }
}
