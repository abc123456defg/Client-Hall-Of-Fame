// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import javax.swing.JSplitPane;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Color;
import com.bulenkov.iconloader.util.DoubleColor;
import com.bulenkov.iconloader.util.UIUtil;
import com.bulenkov.iconloader.util.Gray;
import javax.swing.border.Border;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Graphics;
import com.bulenkov.iconloader.IconLoader;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.Icon;
import javax.swing.plaf.basic.BasicSplitPaneDivider;

public class DarculaSplitPaneDivider extends BasicSplitPaneDivider
{
    private Icon splitGlueV;
    private Icon splitGlueH;
    
    public DarculaSplitPaneDivider(final DarculaSplitPaneUI ui) {
        super(ui);
        this.splitGlueV = IconLoader.findIcon("/com/bulenkov/darcula/icons/splitGlueV.png", DarculaSplitPaneDivider.class, true);
        this.splitGlueH = IconLoader.findIcon("/com/bulenkov/darcula/icons/splitGlueH.png", DarculaSplitPaneDivider.class, true);
    }
    
    @Override
    public void paint(final Graphics g) {
        super.paint(g);
        if (this.splitPane.getOrientation() == 0) {
            this.splitGlueV.paintIcon(this, g, this.getWidth() / 2, (this.getHeight() - this.splitGlueV.getIconHeight()) / 2);
        }
        else {
            this.splitGlueH.paintIcon(this, g, (this.getWidth() - this.splitGlueH.getIconWidth()) / 2, this.getHeight() / 2);
        }
    }
    
    @Override
    protected JButton createLeftOneTouchButton() {
        final JButton b = new JButton() {
            @Override
            public void setBorder(final Border b) {
            }
            
            @Override
            public void paint(final Graphics g) {
                if (DarculaSplitPaneDivider.this.splitPane != null) {
                    final int[] xs = new int[3];
                    final int[] ys = new int[3];
                    g.setColor(this.getBackground());
                    g.fillRect(0, 0, this.getWidth(), this.getHeight());
                    g.setColor(new DoubleColor(Gray._255, UIUtil.getLabelForeground()));
                    if (DarculaSplitPaneDivider.this.orientation == 0) {
                        final int blockSize = Math.min(this.getHeight(), 6);
                        xs[0] = blockSize;
                        xs[1] = 0;
                        xs[2] = blockSize << 1;
                        ys[0] = 0;
                        ys[1] = (ys[2] = blockSize);
                        g.drawPolygon(xs, ys, 3);
                    }
                    else {
                        final int blockSize = Math.min(this.getWidth(), 6);
                        xs[0] = (xs[2] = blockSize);
                        ys[xs[1] = 0] = 0;
                        ys[2] = (ys[1] = blockSize) << 1;
                    }
                    g.fillPolygon(xs, ys, 3);
                }
            }
            
            @Override
            public boolean isFocusTraversable() {
                return false;
            }
        };
        b.setMinimumSize(new Dimension(6, 6));
        b.setCursor(Cursor.getPredefinedCursor(0));
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setRequestFocusEnabled(false);
        return b;
    }
    
    @Override
    protected JButton createRightOneTouchButton() {
        final JButton b = new JButton() {
            @Override
            public void setBorder(final Border border) {
            }
            
            @Override
            public void paint(final Graphics g) {
                if (DarculaSplitPaneDivider.this.splitPane != null) {
                    final int[] xs = new int[3];
                    final int[] ys = new int[3];
                    g.setColor(this.getBackground());
                    g.fillRect(0, 0, this.getWidth(), this.getHeight());
                    if (DarculaSplitPaneDivider.this.orientation == 0) {
                        final int blockSize = Math.min(this.getHeight(), 6);
                        xs[1] = (xs[0] = blockSize) << 1;
                        ys[xs[2] = 0] = blockSize;
                        ys[1] = (ys[2] = 0);
                    }
                    else {
                        final int blockSize = Math.min(this.getWidth(), 6);
                        xs[0] = (xs[2] = 0);
                        xs[1] = blockSize;
                        ys[0] = 0;
                        ys[2] = (ys[1] = blockSize) << 1;
                    }
                    g.setColor(new DoubleColor(Gray._255, UIUtil.getLabelForeground()));
                    g.fillPolygon(xs, ys, 3);
                }
            }
            
            @Override
            public boolean isFocusTraversable() {
                return false;
            }
        };
        b.setMinimumSize(new Dimension(6, 6));
        b.setCursor(Cursor.getPredefinedCursor(0));
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setRequestFocusEnabled(false);
        return b;
    }
}
