// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.awt.Component;
import org.jetbrains.annotations.NotNull;
import javax.swing.UIManager;
import com.intellij.util.ui.JBDimension;
import java.awt.Dimension;
import java.awt.Color;
import com.bulenkov.iconloader.util.GraphicsConfig;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import com.bulenkov.iconloader.util.GraphicsUtil;
import com.intellij.util.ui.JBUI;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

public class DarculaSliderUI extends BasicSliderUI
{
    public DarculaSliderUI(final JSlider b) {
        super(b);
    }
    
    public static ComponentUI createUI(final JComponent c) {
        return new DarculaSliderUI((JSlider)c);
    }
    
    @Override
    public void paintFocus(final Graphics g) {
        super.paintFocus(g);
    }
    
    @Override
    public void paintTrack(final Graphics g2d) {
        final Graphics2D g = (Graphics2D)g2d;
        final Rectangle trackBounds = this.trackRect;
        final int arc = JBUI.scale(6);
        final int trackSize = JBUI.scale(6);
        final GraphicsConfig config = GraphicsUtil.setupAAPainting(g);
        final Color bg = this.getTrackBackground();
        final Color selection = this.getThumbColor();
        if (this.slider.getOrientation() == 0) {
            final int cy = trackBounds.height / 2 - trackSize / 2;
            final int cw = trackBounds.width;
            g.translate(trackBounds.x, trackBounds.y + cy);
            final Area shape = new Area(new RoundRectangle2D.Double(0.0, 0.0, cw, trackSize, arc, arc));
            g.setColor(bg);
            g.fill(shape);
            final int x = this.thumbRect.x;
            shape.intersect(new Area(new Rectangle2D.Double(0.0, 0.0, x, trackSize)));
            g.setColor(selection);
            g.fill(shape);
            g.translate(-trackBounds.x, -(trackBounds.y + cy));
        }
        else {
            final int cx = trackBounds.width / 2 - trackSize / 2;
            final int ch = trackBounds.height;
            g.translate(trackBounds.x + cx, trackBounds.y);
            final Area shape = new Area(new RoundRectangle2D.Double(0.0, 0.0, cx, ch, arc, arc));
            g.setColor(bg);
            g.fill(shape);
            final int y = this.thumbRect.y;
            shape.intersect(new Area(new Rectangle2D.Double(0.0, y, cx, ch)));
            g.setColor(selection);
            g.fill(shape);
            g.translate(-(trackBounds.x + cx), -trackBounds.y);
        }
        config.restore();
    }
    
    @Override
    protected Dimension getThumbSize() {
        if (this.isPlainThumb()) {
            return new Dimension(JBUI.scale(20), JBUI.scale(20));
        }
        return (this.slider.getOrientation() == 0) ? new JBDimension(12, 20) : new JBDimension(20, 12);
    }
    
    @NotNull
    protected Color getTrackBackground() {
        final Color color = UIManager.getColor("Slider.trackBackground");
        if (color == null) {
            $$$reportNull$$$0(0);
        }
        return color;
    }
    
    @NotNull
    protected Color getSelectedTrackColor() {
        final Color color = UIManager.getColor("Slider.selectedTrackColor");
        if (color == null) {
            $$$reportNull$$$0(1);
        }
        return color;
    }
    
    @NotNull
    protected Color getDisabledTickColor() {
        final Color color = UIManager.getColor("Slider.disabledTickColor");
        if (color == null) {
            $$$reportNull$$$0(2);
        }
        return color;
    }
    
    @Override
    protected void paintMinorTickForHorizSlider(final Graphics g, final Rectangle tickBounds, final int x) {
        this.checkDisabled(g);
        super.paintMinorTickForHorizSlider(g, tickBounds, x);
    }
    
    private void checkDisabled(final Graphics g) {
        if (!this.slider.isEnabled()) {
            g.setColor(this.getDisabledTickColor());
        }
    }
    
    @Override
    protected void paintMajorTickForHorizSlider(final Graphics g, final Rectangle tickBounds, final int x) {
        this.checkDisabled(g);
        super.paintMajorTickForHorizSlider(g, tickBounds, x);
    }
    
    @Override
    protected void paintMinorTickForVertSlider(final Graphics g, final Rectangle tickBounds, final int y) {
        this.checkDisabled(g);
        super.paintMinorTickForVertSlider(g, tickBounds, y);
    }
    
    @Override
    protected void paintMajorTickForVertSlider(final Graphics g, final Rectangle tickBounds, final int y) {
        this.checkDisabled(g);
        super.paintMajorTickForVertSlider(g, tickBounds, y);
    }
    
    @Override
    public void paintLabels(final Graphics g) {
        this.checkDisabled(g);
        super.paintLabels(g);
    }
    
    @Override
    protected void paintHorizontalLabel(final Graphics g, final int value, final Component label) {
        this.checkDisabled(g);
        super.paintHorizontalLabel(g, value, label);
    }
    
    @Override
    protected void paintVerticalLabel(final Graphics g, final int value, final Component label) {
        this.checkDisabled(g);
        super.paintVerticalLabel(g, value, label);
    }
    
    @Override
    public void paintThumb(final Graphics g) {
        final GraphicsConfig config = GraphicsUtil.setupAAPainting(g);
        final Rectangle knobBounds = this.thumbRect;
        final int w = knobBounds.width;
        final int h = knobBounds.height;
        g.translate(knobBounds.x, knobBounds.y);
        if (this.slider.isEnabled()) {
            g.setColor(this.slider.getBackground());
        }
        else {
            g.setColor(this.slider.getBackground().darker());
        }
        if (this.isPlainThumb()) {
            final double r = (this.slider.getOrientation() == 0) ? h : ((double)w);
            final Ellipse2D.Double thumb = new Ellipse2D.Double(0.0, 0.0, r, r);
            final Ellipse2D.Double innerThumb = new Ellipse2D.Double(1.0, 1.0, r - 2.0, r - 2.0);
            g.setColor(this.getThumbBorderColor());
            ((Graphics2D)g).fill(thumb);
            g.setColor(this.getThumbColor());
            ((Graphics2D)g).fill(innerThumb);
        }
        else if (this.slider.getOrientation() == 0) {
            final int cw = w / 2;
            g.setColor(this.getThumbBorderColor());
            Polygon p = new Polygon();
            p.addPoint(0, 0);
            p.addPoint(w - 1, 0);
            p.addPoint(w - 1, h - cw);
            p.addPoint(cw, h - 1);
            p.addPoint(0, h - cw);
            g.fillPolygon(p);
            g.setColor(this.getThumbColor());
            p = new Polygon();
            p.addPoint(1, 1);
            p.addPoint(w - 2, 1);
            p.addPoint(w - 2, h - cw - 1);
            p.addPoint(cw, h - 2);
            p.addPoint(1, h - cw - 1);
            g.fillPolygon(p);
        }
        else {
            final int cw = h / 2;
            if (this.slider.getComponentOrientation().isLeftToRight()) {
                g.setColor(this.getThumbBorderColor());
                Polygon p = new Polygon();
                p.addPoint(0, 0);
                p.addPoint(w - cw, 0);
                p.addPoint(w - 1, h - cw);
                p.addPoint(w - cw, h - 1);
                p.addPoint(0, h - 1);
                g.fillPolygon(p);
                g.setColor(this.getThumbColor());
                p = new Polygon();
                p.addPoint(1, 1);
                p.addPoint(w - cw, 1);
                p.addPoint(w - 2, h - cw);
                p.addPoint(w - cw, h - 2);
                p.addPoint(1, h - 2);
                g.fillPolygon(p);
            }
            else {
                g.setColor(this.getThumbBorderColor());
                Polygon p = new Polygon();
                p.addPoint(w - 1, 0);
                p.addPoint(cw, 0);
                p.addPoint(0, h - cw);
                p.addPoint(cw, h - 1);
                p.addPoint(w - 1, h - 1);
                g.fillPolygon(p);
                g.setColor(this.getThumbColor());
                p = new Polygon();
                p.addPoint(w - 2, 1);
                p.addPoint(cw + 1, 1);
                p.addPoint(1, h - cw);
                p.addPoint(cw + 1, h - 2);
                p.addPoint(w - 2, h - 2);
                g.fillPolygon(p);
            }
        }
        g.translate(-knobBounds.x, -knobBounds.y);
        config.restore();
    }
    
    @NotNull
    protected Color getThumbColor() {
        final Color color = this.slider.isEnabled() ? this.getSelectedTrackColor() : this.getDisabledTickColor();
        if (color == null) {
            $$$reportNull$$$0(3);
        }
        return color;
    }
    
    @NotNull
    protected Color getThumbBorderColor() {
        final Color color = this.slider.isEnabled() ? UIManager.getColor("Slider.thumbBorderColor") : UIManager.getColor("Slider.thumbBorderColorDisabled");
        if (color == null) {
            $$$reportNull$$$0(4);
        }
        return color;
    }
    
    protected boolean isPlainThumb() {
        final Boolean paintThumbArrowShape = (Boolean)this.slider.getClientProperty("Slider.paintThumbArrowShape");
        return (!this.slider.getPaintTicks() && paintThumbArrowShape == null) || paintThumbArrowShape == Boolean.FALSE;
    }
    
    private static /* synthetic */ void $$$reportNull$$$0(final int n) {
        final String format = "@NotNull method %s.%s must not return null";
        final Object[] args = { "com/bulenkov/darcula/ui/DarculaSliderUI", null };
        switch (n) {
            default: {
                args[1] = "getTrackBackground";
                break;
            }
            case 1: {
                args[1] = "getSelectedTrackColor";
                break;
            }
            case 2: {
                args[1] = "getDisabledTickColor";
                break;
            }
            case 3: {
                args[1] = "getThumbColor";
                break;
            }
            case 4: {
                args[1] = "getThumbBorderColor";
                break;
            }
        }
        throw new IllegalStateException(String.format(format, args));
    }
}
