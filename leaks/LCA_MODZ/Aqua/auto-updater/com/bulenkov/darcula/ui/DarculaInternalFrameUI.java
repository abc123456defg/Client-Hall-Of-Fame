// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import com.bulenkov.iconloader.util.GraphicsConfig;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import com.bulenkov.iconloader.util.GraphicsUtil;
import java.awt.Graphics2D;
import java.awt.Component;
import javax.swing.BorderFactory;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import javax.swing.border.Border;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class DarculaInternalFrameUI extends BasicInternalFrameUI
{
    public DarculaInternalFrameUI(final JInternalFrame b) {
        super(b);
    }
    
    public static ComponentUI createUI(final JComponent c) {
        return new DarculaInternalFrameUI((JInternalFrame)c);
    }
    
    @Override
    protected JComponent createNorthPane(final JInternalFrame w) {
        (this.titlePane = new BasicInternalFrameTitlePane(w) {
            @Override
            protected void installDefaults() {
                super.installDefaults();
                this.closeIcon = new CloseIcon();
                this.maxIcon = new MaximizeIcon();
                this.minIcon = new MinimizeIcon();
                this.iconIcon = new IconifyIcon();
                this.selectedTitleColor = UIManager.getColor("InternalFrameTitlePane.darcula.selected.backgroundColor");
                this.selectedTextColor = UIManager.getColor("darcula.textForeground");
                this.notSelectedTitleColor = UIManager.getColor("InternalFrameTitlePane.darcula.backgroundColor");
                this.notSelectedTextColor = UIManager.getColor("darcula.textForeground");
            }
            
            @Override
            protected void createButtons() {
                super.createButtons();
                final MouseListener listener = new MouseAdapter() {
                    @Override
                    public void mouseEntered(final MouseEvent e) {
                        final Icon icon = ((JButton)e.getComponent()).getIcon();
                        if (icon instanceof FrameIcon) {
                            final Color c = ((FrameIcon)icon).getColor();
                            ((FrameIcon)icon).setColor(c.brighter());
                            e.getComponent().repaint();
                        }
                    }
                    
                    @Override
                    public void mouseExited(final MouseEvent e) {
                        final Icon icon = ((JButton)e.getComponent()).getIcon();
                        if (icon instanceof FrameIcon) {
                            ((FrameIcon)icon).setColor(UIManager.getColor("InternalFrameTitlePane.darcula.buttonColor"));
                            e.getComponent().repaint();
                        }
                    }
                };
                this.closeButton.setBorder(null);
                this.closeButton.setOpaque(false);
                this.closeButton.addMouseListener(listener);
                this.maxButton.setBorder(null);
                this.maxButton.setOpaque(false);
                this.maxButton.addMouseListener(listener);
                this.iconButton.setBorder(null);
                this.iconButton.setOpaque(false);
                this.iconButton.addMouseListener(listener);
            }
            
            @Override
            protected void paintBorder(final Graphics g) {
                final int w = this.getWidth();
                final int h = this.getHeight();
                Color top = UIManager.getColor("InternalFrameTitlePane.darcula.borderColorTop");
                Color left = UIManager.getColor("InternalFrameTitlePane.darcula.borderColorLeft");
                Color bottom = UIManager.getColor("InternalFrameTitlePane.darcula.borderColorBottom");
                if (this.frame.isSelected()) {
                    top = UIManager.getColor("InternalFrameTitlePane.darcula.selected.borderColorTop");
                    left = UIManager.getColor("InternalFrameTitlePane.darcula.selected.borderColorLeft");
                    bottom = UIManager.getColor("InternalFrameTitlePane.darcula.selected.borderColorBottom");
                }
                g.setColor(top);
                g.drawLine(2, 0, w, 0);
                g.setColor(left);
                g.drawLine(0, 1, 0, h);
                g.setColor(bottom);
                g.drawLine(2, h, w, h);
            }
        }).setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 0));
        return this.titlePane;
    }
    
    @Override
    protected void installDefaults() {
        super.installDefaults();
    }
    
    private abstract static class FrameIcon implements Icon
    {
        private Color mColor;
        
        public FrameIcon(final Color c) {
            this.mColor = c;
        }
        
        public Color getColor() {
            return this.mColor;
        }
        
        public void setColor(final Color c) {
            this.mColor = c;
        }
        
        @Override
        public int getIconWidth() {
            return 16;
        }
        
        @Override
        public int getIconHeight() {
            return 16;
        }
    }
    
    private static class CloseIcon extends FrameIcon
    {
        public CloseIcon() {
            this(UIManager.getColor("InternalFrameTitlePane.darcula.buttonColor"));
        }
        
        public CloseIcon(final Color c) {
            super(c);
        }
        
        @Override
        public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
            final Graphics2D g2 = (Graphics2D)g;
            final GraphicsConfig config = GraphicsUtil.setupAAPainting(g2);
            g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            g2.setStroke(new BasicStroke(1.5f));
            g2.setPaint(this.getColor());
            g.drawLine(5, 4, 11, 10);
            g.drawLine(11, 4, 5, 10);
            config.restore();
        }
    }
    
    private static class MaximizeIcon extends FrameIcon
    {
        public MaximizeIcon() {
            this(UIManager.getColor("InternalFrameTitlePane.darcula.buttonColor"));
        }
        
        public MaximizeIcon(final Color c) {
            super(c);
        }
        
        @Override
        public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
            final Graphics2D g2 = (Graphics2D)g;
            final GraphicsConfig config = GraphicsUtil.setupAAPainting(g2);
            g2.setStroke(new BasicStroke(2.0f));
            g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            g2.setPaint(this.getColor());
            g2.setStroke(new BasicStroke(2.0f));
            g2.drawRect(3, 3, 10, 9);
            config.restore();
        }
    }
    
    private static class MinimizeIcon extends FrameIcon
    {
        public MinimizeIcon() {
            this(UIManager.getColor("InternalFrameTitlePane.darcula.buttonColor"));
        }
        
        public MinimizeIcon(final Color c) {
            super(c);
        }
        
        @Override
        public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
            final Graphics2D g2 = (Graphics2D)g;
            final GraphicsConfig config = GraphicsUtil.setupAAPainting(g2);
            g2.setStroke(new BasicStroke(2.0f));
            g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            g2.setPaint(this.getColor());
            g2.setStroke(new BasicStroke(2.0f));
            g2.drawRect(1, 5, 8, 8);
            g2.drawLine(4, 2, 12, 2);
            g2.drawLine(12, 3, 12, 10);
            config.restore();
        }
    }
    
    private static class IconifyIcon extends FrameIcon
    {
        public IconifyIcon() {
            this(UIManager.getColor("InternalFrameTitlePane.darcula.buttonColor"));
        }
        
        public IconifyIcon(final Color c) {
            super(c);
        }
        
        @Override
        public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
            final Graphics2D g2 = (Graphics2D)g;
            final GraphicsConfig config = GraphicsUtil.setupAAPainting(g2);
            g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            g2.setPaint(this.getColor());
            g2.setStroke(new BasicStroke(2.0f));
            g2.drawLine(4, 12, 12, 12);
            config.restore();
        }
    }
}
