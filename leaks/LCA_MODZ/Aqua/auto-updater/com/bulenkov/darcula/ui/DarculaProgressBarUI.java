// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import java.awt.Rectangle;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import sun.swing.SwingUtilities2;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.Shape;
import java.awt.geom.Path2D;
import com.bulenkov.iconloader.util.GraphicsUtil;
import java.awt.Color;
import com.bulenkov.iconloader.util.DoubleColor;
import com.bulenkov.iconloader.util.Gray;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class DarculaProgressBarUI extends BasicProgressBarUI
{
    protected volatile int offset;
    
    public DarculaProgressBarUI() {
        this.offset = 0;
    }
    
    public static ComponentUI createUI(final JComponent c) {
        c.setBorder(new BorderUIResource(new EmptyBorder(0, 0, 0, 0)));
        return new DarculaProgressBarUI();
    }
    
    @Override
    protected void paintIndeterminate(final Graphics g, final JComponent c) {
        if (!(g instanceof Graphics2D)) {
            return;
        }
        final Insets b = this.progressBar.getInsets();
        final int barRectWidth = this.progressBar.getWidth() - (b.right + b.left);
        final int barRectHeight = this.progressBar.getHeight() - (b.top + b.bottom);
        if (barRectWidth <= 0 || barRectHeight <= 0) {
            return;
        }
        g.setColor(new DoubleColor(Gray._240, Gray._128));
        final int w = c.getWidth();
        final int h = c.getPreferredSize().height;
        g.fillRect(0, (c.getHeight() - h) / 2, w, h);
        g.setColor(new DoubleColor(Gray._165, Gray._88));
        GraphicsUtil.setupAAPainting(g);
        final Path2D.Double path = new Path2D.Double();
        final int ww = this.getPeriodLength() / 2;
        g.translate(0, (c.getHeight() - h) / 2);
        path.moveTo(0.0, 0.0);
        path.lineTo(ww, 0.0);
        path.lineTo(ww - h / 2, h);
        path.lineTo(-h / 2, h);
        path.lineTo(0.0, 0.0);
        path.closePath();
        for (int x = -this.offset; x < Math.max(c.getWidth(), c.getHeight()); x += this.getPeriodLength()) {
            g.translate(x, 0);
            ((Graphics2D)g).fill(path);
            g.translate(-x, 0);
        }
        this.offset = (this.offset + 1) % this.getPeriodLength();
        final Area area = new Area(new Rectangle2D.Double(0.0, 0.0, w, h));
        area.subtract(new Area(new RoundRectangle2D.Double(1.0, 1.0, w - 2, h - 2, 8.0, 8.0)));
        ((Graphics2D)g).setPaint(Gray._128);
        ((Graphics2D)g).fill(area);
        area.subtract(new Area(new RoundRectangle2D.Double(0.0, 0.0, w, h, 9.0, 9.0)));
        ((Graphics2D)g).setPaint(c.getParent().getBackground());
        ((Graphics2D)g).fill(area);
        g.drawRoundRect(1, 1, w - 3, h - 3, 8, 8);
        g.translate(0, -(c.getHeight() - h) / 2);
        if (this.progressBar.isStringPainted()) {
            if (this.progressBar.getOrientation() == 0) {
                this.paintString(g, b.left, b.top, barRectWidth, barRectHeight, this.boxRect.x, this.boxRect.width);
            }
            else {
                this.paintString(g, b.left, b.top, barRectWidth, barRectHeight, this.boxRect.y, this.boxRect.height);
            }
        }
    }
    
    @Override
    protected void paintDeterminate(final Graphics g, final JComponent c) {
        if (!(g instanceof Graphics2D)) {
            return;
        }
        if (this.progressBar.getOrientation() != 0 || !c.getComponentOrientation().isLeftToRight()) {
            super.paintDeterminate(g, c);
            return;
        }
        GraphicsUtil.setupAAPainting(g);
        final Insets b = this.progressBar.getInsets();
        final int w = this.progressBar.getWidth();
        final int h = this.progressBar.getPreferredSize().height;
        final int barRectWidth = w - (b.right + b.left);
        final int barRectHeight = h - (b.top + b.bottom);
        if (barRectWidth <= 0 || barRectHeight <= 0) {
            return;
        }
        final int amountFull = this.getAmountFull(b, barRectWidth, barRectHeight);
        g.setColor(c.getParent().getBackground());
        final Graphics2D g2 = (Graphics2D)g;
        g.fillRect(0, 0, w, h);
        g2.translate(0, (c.getHeight() - h) / 2);
        g2.setColor(this.progressBar.getForeground());
        g2.fill(new RoundRectangle2D.Double(0.0, 0.0, w - 1, h - 1, 9.0, 9.0));
        g2.setColor(c.getParent().getBackground());
        g2.fill(new RoundRectangle2D.Double(1.0, 1.0, w - 3, h - 3, 8.0, 8.0));
        g2.setColor(this.progressBar.getForeground());
        g2.fill(new RoundRectangle2D.Double(2.0, 2.0, amountFull - 5, h - 5, 7.0, 7.0));
        g2.translate(0, -(c.getHeight() - h) / 2);
        if (this.progressBar.isStringPainted()) {
            this.paintString(g, b.left, b.top, barRectWidth, barRectHeight, amountFull, b);
        }
    }
    
    private void paintString(final Graphics g, final int x, final int y, final int w, final int h, final int fillStart, final int amountFull) {
        if (!(g instanceof Graphics2D)) {
            return;
        }
        final Graphics2D g2 = (Graphics2D)g;
        final String progressString = this.progressBar.getString();
        g2.setFont(this.progressBar.getFont());
        Point renderLocation = this.getStringPlacement(g2, progressString, x, y, w, h);
        final Rectangle oldClip = g2.getClipBounds();
        if (this.progressBar.getOrientation() == 0) {
            g2.setColor(this.getSelectionBackground());
            SwingUtilities2.drawString(this.progressBar, g2, progressString, renderLocation.x, renderLocation.y);
            g2.setColor(this.getSelectionForeground());
            g2.clipRect(fillStart, y, amountFull, h);
            SwingUtilities2.drawString(this.progressBar, g2, progressString, renderLocation.x, renderLocation.y);
        }
        else {
            g2.setColor(this.getSelectionBackground());
            final AffineTransform rotate = AffineTransform.getRotateInstance(1.5707963267948966);
            g2.setFont(this.progressBar.getFont().deriveFont(rotate));
            renderLocation = this.getStringPlacement(g2, progressString, x, y, w, h);
            SwingUtilities2.drawString(this.progressBar, g2, progressString, renderLocation.x, renderLocation.y);
            g2.setColor(this.getSelectionForeground());
            g2.clipRect(x, fillStart, w, amountFull);
            SwingUtilities2.drawString(this.progressBar, g2, progressString, renderLocation.x, renderLocation.y);
        }
        g2.setClip(oldClip);
    }
    
    @Override
    protected int getBoxLength(final int availableLength, final int otherDimension) {
        return availableLength;
    }
    
    protected int getPeriodLength() {
        return 16;
    }
}
