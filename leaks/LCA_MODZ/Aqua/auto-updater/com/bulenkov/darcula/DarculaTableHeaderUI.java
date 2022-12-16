// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula;

import java.util.Enumeration;
import java.awt.Color;
import javax.swing.table.TableColumn;
import com.bulenkov.iconloader.util.Gray;
import javax.swing.table.JTableHeader;
import java.awt.Paint;
import java.awt.GradientPaint;
import com.bulenkov.iconloader.util.ColorUtil;
import com.bulenkov.iconloader.util.GraphicsConfig;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicTableHeaderUI;

public class DarculaTableHeaderUI extends BasicTableHeaderUI
{
    public static ComponentUI createUI(final JComponent c) {
        return new DarculaTableHeaderUI();
    }
    
    @Override
    public void paint(final Graphics g2, final JComponent c) {
        final Graphics2D g3 = (Graphics2D)g2;
        final GraphicsConfig config = new GraphicsConfig(g3);
        final Color bg = c.getBackground();
        g3.setPaint(new GradientPaint(0.0f, 0.0f, ColorUtil.shift(bg, 1.4), 0.0f, (float)c.getHeight(), ColorUtil.shift(bg, 0.9)));
        final int h = c.getHeight();
        final int w = c.getWidth();
        g3.fillRect(0, 0, w, h);
        g3.setPaint(ColorUtil.shift(bg, 0.75));
        g3.drawLine(0, h - 1, w, h - 1);
        g3.drawLine(w - 1, 0, w - 1, h - 1);
        final Enumeration<TableColumn> columns = ((JTableHeader)c).getColumnModel().getColumns();
        final Color lineColor = ColorUtil.shift(bg, 0.7);
        final Color shadow = Gray._255.withAlpha(30);
        int offset = 0;
        while (columns.hasMoreElements()) {
            final TableColumn column = columns.nextElement();
            if (columns.hasMoreElements() && column.getWidth() > 0) {
                offset += column.getWidth();
                g3.setColor(lineColor);
                g3.drawLine(offset - 1, 1, offset - 1, h - 3);
                g3.setColor(shadow);
                g3.drawLine(offset, 1, offset, h - 3);
            }
        }
        config.restore();
        super.paint(g3, c);
    }
}
