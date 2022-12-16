// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.AdjustmentEvent;
import com.bulenkov.iconloader.util.UIUtil;
import java.awt.Color;
import com.bulenkov.iconloader.util.Gray;
import com.bulenkov.iconloader.util.DoubleColor;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import com.bulenkov.darcula.util.Animator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.AdjustmentListener;
import java.awt.BasicStroke;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class DarculaScrollBarUI extends BasicScrollBarUI
{
    private static final BasicStroke BORDER_STROKE;
    private final AdjustmentListener myAdjustmentListener;
    private final MouseMotionAdapter myMouseMotionListener;
    private final MouseAdapter myMouseListener;
    private Animator myAnimator;
    private int myAnimationColorShift;
    private boolean myMouseIsOverThumb;
    public static final int DELAY_FRAMES = 4;
    public static final int FRAMES_COUNT = 14;
    
    public static ComponentUI createUI(final JComponent c) {
        return new DarculaScrollBarUI();
    }
    
    public static DoubleColor getGradientLightColor() {
        return new DoubleColor(Gray._251, Gray._95);
    }
    
    public static DoubleColor getGradientDarkColor() {
        return new DoubleColor(Gray._215, Gray._80);
    }
    
    private static DoubleColor getGradientThumbBorderColor() {
        return new DoubleColor(Gray._201, Gray._85);
    }
    
    public static DoubleColor getTrackBackground() {
        return new DoubleColor(Gray._245, UIUtil.getListBackground());
    }
    
    public static DoubleColor getTrackBorderColor() {
        return new DoubleColor(Gray._230, UIUtil.getListBackground());
    }
    
    private static int getAnimationColorShift() {
        return UIUtil.isUnderDarcula() ? 20 : 40;
    }
    
    protected DarculaScrollBarUI() {
        this.myAnimationColorShift = 0;
        this.myMouseIsOverThumb = false;
        this.myAdjustmentListener = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(final AdjustmentEvent e) {
                DarculaScrollBarUI.this.resetAnimator();
            }
        };
        this.myMouseMotionListener = new MouseMotionAdapter() {
            @Override
            public void mouseMoved(final MouseEvent e) {
                final boolean inside = DarculaScrollBarUI.this.isOverThumb(e.getPoint());
                if (inside != DarculaScrollBarUI.this.myMouseIsOverThumb) {
                    DarculaScrollBarUI.this.myMouseIsOverThumb = inside;
                    DarculaScrollBarUI.this.resetAnimator();
                }
            }
        };
        this.myMouseListener = new MouseAdapter() {
            @Override
            public void mouseExited(final MouseEvent e) {
                if (DarculaScrollBarUI.this.myMouseIsOverThumb) {
                    DarculaScrollBarUI.this.myMouseIsOverThumb = false;
                    DarculaScrollBarUI.this.resetAnimator();
                }
            }
        };
    }
    
    @Override
    public void layoutContainer(final Container scrollbarContainer) {
        try {
            super.layoutContainer(scrollbarContainer);
        }
        catch (NullPointerException ex) {}
    }
    
    @Override
    protected ModelListener createModelListener() {
        return new ModelListener() {
            @Override
            public void stateChanged(final ChangeEvent e) {
                if (DarculaScrollBarUI.this.scrollbar != null) {
                    super.stateChanged(e);
                }
            }
        };
    }
    
    public int getDecrementButtonHeight() {
        return this.decrButton.getHeight();
    }
    
    public int getIncrementButtonHeight() {
        return this.incrButton.getHeight();
    }
    
    private void resetAnimator() {
        this.myAnimator.reset();
        if ((this.scrollbar != null && this.scrollbar.getValueIsAdjusting()) || this.myMouseIsOverThumb) {
            this.myAnimator.suspend();
            this.myAnimationColorShift = getAnimationColorShift();
        }
        else {
            this.myAnimator.resume();
        }
    }
    
    public static BasicScrollBarUI createNormal() {
        return new DarculaScrollBarUI();
    }
    
    @Override
    public void installUI(final JComponent c) {
        super.installUI(c);
        this.scrollbar.setFocusable(false);
    }
    
    @Override
    protected void installDefaults() {
        final int incGap = UIManager.getInt("ScrollBar.incrementButtonGap");
        final int decGap = UIManager.getInt("ScrollBar.decrementButtonGap");
        try {
            UIManager.put("ScrollBar.incrementButtonGap", 0);
            UIManager.put("ScrollBar.decrementButtonGap", 0);
            super.installDefaults();
        }
        finally {
            UIManager.put("ScrollBar.incrementButtonGap", incGap);
            UIManager.put("ScrollBar.decrementButtonGap", decGap);
        }
    }
    
    @Override
    protected void installListeners() {
        if (this.myAnimator == null || this.myAnimator.isDisposed()) {
            this.myAnimator = this.createAnimator();
        }
        super.installListeners();
        this.scrollbar.addAdjustmentListener(this.myAdjustmentListener);
        this.scrollbar.addMouseListener(this.myMouseListener);
        this.scrollbar.addMouseMotionListener(this.myMouseMotionListener);
    }
    
    private Animator createAnimator() {
        return new Animator("Adjustment fadeout", 14, 700, false) {
            @Override
            public void paintNow(final int frame, final int totalFrames, final int cycle) {
                DarculaScrollBarUI.this.myAnimationColorShift = getAnimationColorShift();
                if (frame > 4) {
                    DarculaScrollBarUI.this.myAnimationColorShift *= 1.0 - (frame - 4) / (double)(totalFrames - 4);
                }
                if (DarculaScrollBarUI.this.scrollbar != null) {
                    DarculaScrollBarUI.this.scrollbar.repaint(((DarculaScrollBarUI)DarculaScrollBarUI.this.scrollbar.getUI()).getThumbBounds());
                }
            }
        };
    }
    
    private boolean isOverThumb(final Point p) {
        final Rectangle bounds = this.getThumbBounds();
        return bounds != null && bounds.contains(p);
    }
    
    public Rectangle getThumbBounds() {
        return super.getThumbBounds();
    }
    
    @Override
    protected void uninstallListeners() {
        if (this.scrollTimer != null) {
            super.uninstallListeners();
        }
        this.scrollbar.removeAdjustmentListener(this.myAdjustmentListener);
        this.myAnimator.dispose();
    }
    
    @Override
    protected void paintTrack(final Graphics g, final JComponent c, final Rectangle bounds) {
        g.setColor(getTrackBackground());
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        g.setColor(getTrackBorderColor());
        if (this.isVertical()) {
            g.drawLine(bounds.x, bounds.y, bounds.x, bounds.y + bounds.height);
        }
        else {
            g.drawLine(bounds.x, bounds.y, bounds.x + bounds.width, bounds.y);
        }
    }
    
    @Override
    protected Dimension getMinimumThumbSize() {
        final int thickness = this.getThickness();
        return this.isVertical() ? new Dimension(thickness, thickness * 2) : new Dimension(thickness * 2, thickness);
    }
    
    protected int getThickness() {
        return 13;
    }
    
    @Override
    public Dimension getMaximumSize(final JComponent c) {
        final int thickness = this.getThickness();
        return new Dimension(thickness, thickness);
    }
    
    @Override
    public Dimension getMinimumSize(final JComponent c) {
        return this.getMaximumSize(c);
    }
    
    @Override
    public Dimension getPreferredSize(final JComponent c) {
        return this.getMaximumSize(c);
    }
    
    @Override
    protected void paintThumb(final Graphics g, final JComponent c, final Rectangle thumbBounds) {
        if (thumbBounds.isEmpty() || !this.scrollbar.isEnabled()) {
            return;
        }
        g.translate(thumbBounds.x, thumbBounds.y);
        this.paintMaxiThumb((Graphics2D)g, thumbBounds);
        g.translate(-thumbBounds.x, -thumbBounds.y);
    }
    
    private void paintMaxiThumb(final Graphics2D g, final Rectangle thumbBounds) {
        final boolean vertical = this.isVertical();
        final int hGap = vertical ? 2 : 1;
        final int vGap = vertical ? 1 : 2;
        int w = this.adjustThumbWidth(thumbBounds.width - hGap * 2);
        int h = thumbBounds.height - vGap * 2;
        if (vertical) {
            --h;
        }
        else {
            --w;
        }
        final Color start = this.adjustColor(getGradientLightColor());
        final Color end = this.adjustColor(getGradientDarkColor());
        Paint paint;
        if (vertical) {
            paint = new GradientPaint(1.0f, 0.0f, start, (float)(w + 1), 0.0f, end);
        }
        else {
            paint = new GradientPaint(0.0f, 1.0f, start, 0.0f, (float)(h + 1), end);
        }
        g.setPaint(paint);
        g.fillRect(hGap + 1, vGap + 1, w - 1, h - 1);
        final Stroke stroke = g.getStroke();
        g.setStroke(DarculaScrollBarUI.BORDER_STROKE);
        g.setColor(getGradientThumbBorderColor());
        g.drawRoundRect(hGap, vGap, w, h, 3, 3);
        g.setStroke(stroke);
    }
    
    @Override
    public boolean getSupportsAbsolutePositioning() {
        return true;
    }
    
    protected int adjustThumbWidth(final int width) {
        return width;
    }
    
    protected Color adjustColor(final Color c) {
        if (this.myAnimationColorShift == 0) {
            return c;
        }
        final int sign = UIUtil.isUnderDarcula() ? -1 : 1;
        return Gray.get(Math.max(0, Math.min(255, c.getRed() - sign * this.myAnimationColorShift)));
    }
    
    private boolean isVertical() {
        return this.scrollbar.getOrientation() == 1;
    }
    
    @Override
    protected JButton createIncreaseButton(final int orientation) {
        return new EmptyButton();
    }
    
    @Override
    protected JButton createDecreaseButton(final int orientation) {
        return new EmptyButton();
    }
    
    static {
        BORDER_STROKE = new BasicStroke();
    }
    
    private static class EmptyButton extends JButton
    {
        private EmptyButton() {
            this.setFocusable(false);
            this.setRequestFocusEnabled(false);
        }
        
        @Override
        public Dimension getMaximumSize() {
            return new Dimension(0, 0);
        }
        
        @Override
        public Dimension getPreferredSize() {
            return this.getMaximumSize();
        }
        
        @Override
        public Dimension getMinimumSize() {
            return this.getMaximumSize();
        }
    }
}
