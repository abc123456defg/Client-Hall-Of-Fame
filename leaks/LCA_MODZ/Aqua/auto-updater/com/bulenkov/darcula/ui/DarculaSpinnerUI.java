// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import java.awt.Dimension;
import javax.swing.JSpinner;
import javax.swing.border.CompoundBorder;
import javax.swing.plaf.UIResource;
import javax.swing.UIManager;
import com.bulenkov.iconloader.util.GraphicsConfig;
import com.bulenkov.iconloader.util.GraphicsUtil;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.Color;
import com.bulenkov.iconloader.util.DoubleColor;
import com.bulenkov.iconloader.util.Gray;
import com.bulenkov.iconloader.util.UIUtil;
import java.awt.Rectangle;
import java.awt.Container;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.FocusListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusAdapter;
import javax.swing.plaf.basic.BasicSpinnerUI;

public class DarculaSpinnerUI extends BasicSpinnerUI
{
    private FocusAdapter myFocusListener;
    
    public DarculaSpinnerUI() {
        this.myFocusListener = new FocusAdapter() {
            @Override
            public void focusGained(final FocusEvent e) {
                DarculaSpinnerUI.this.spinner.repaint();
            }
            
            @Override
            public void focusLost(final FocusEvent e) {
                DarculaSpinnerUI.this.spinner.repaint();
            }
        };
    }
    
    public static ComponentUI createUI(final JComponent c) {
        return new DarculaSpinnerUI();
    }
    
    @Override
    protected void replaceEditor(final JComponent oldEditor, final JComponent newEditor) {
        super.replaceEditor(oldEditor, newEditor);
        if (oldEditor != null && oldEditor.getComponents().length > 0) {
            oldEditor.getComponents()[0].removeFocusListener(this.myFocusListener);
        }
        if (newEditor != null && newEditor.getComponents().length > 0) {
            newEditor.getComponents()[0].addFocusListener(this.myFocusListener);
        }
    }
    
    @Override
    protected JComponent createEditor() {
        final JComponent editor = super.createEditor();
        editor.getComponents()[0].addFocusListener(this.myFocusListener);
        return editor;
    }
    
    @Override
    public void paint(final Graphics g, final JComponent c) {
        super.paint(g, c);
        final Border border = this.spinner.getBorder();
        if (border != null) {
            border.paintBorder(c, g, 0, 0, this.spinner.getWidth(), this.spinner.getHeight());
        }
    }
    
    @Override
    protected Component createPreviousButton() {
        final JButton button = this.createArrow(5);
        button.setName("Spinner.previousButton");
        button.setBorder(new EmptyBorder(1, 1, 1, 1));
        this.installPreviousButtonListeners(button);
        return button;
    }
    
    @Override
    protected Component createNextButton() {
        final JButton button = this.createArrow(1);
        button.setName("Spinner.nextButton");
        button.setBorder(new EmptyBorder(1, 1, 1, 1));
        this.installNextButtonListeners(button);
        return button;
    }
    
    @Override
    protected LayoutManager createLayout() {
        return new LayoutManagerDelegate(super.createLayout()) {
            @Override
            public void layoutContainer(final Container parent) {
                super.layoutContainer(parent);
                final JComponent editor = DarculaSpinnerUI.this.spinner.getEditor();
                if (editor != null) {
                    final Rectangle bounds = editor.getBounds();
                    editor.setBounds(bounds.x, bounds.y, bounds.width - 6, bounds.height);
                }
            }
        };
    }
    
    private JButton createArrow(final int direction) {
        final Color shadow = UIUtil.getPanelBackground();
        final Color enabledColor = new DoubleColor(Gray._255, UIUtil.getLabelForeground());
        final Color disabledColor = new DoubleColor(Gray._200, UIUtil.getLabelForeground().darker());
        final JButton b = new BasicArrowButton(direction, shadow, shadow, enabledColor, shadow) {
            @Override
            public void paint(final Graphics g) {
                final int y = (this.direction == 1) ? (this.getHeight() - 6) : 2;
                this.paintTriangle(g, (this.getWidth() - 8) / 2 - 1, y, 0, this.direction, DarculaSpinnerUI.this.spinner.isEnabled());
            }
            
            @Override
            public boolean isOpaque() {
                return false;
            }
            
            @Override
            public void paintTriangle(final Graphics g, final int x, final int y, final int size, final int direction, final boolean isEnabled) {
                final GraphicsConfig config = GraphicsUtil.setupAAPainting(g);
                final int w = 8;
                final int h = 6;
                final int mid = 4;
                g.setColor(isEnabled ? enabledColor : disabledColor);
                g.translate(x, y);
                switch (direction) {
                    case 5: {
                        g.fillPolygon(new int[] { 0, 8, mid }, new int[] { 1, 1, 6 }, 3);
                        break;
                    }
                    case 1: {
                        g.fillPolygon(new int[] { 0, 8, mid }, new int[] { 5, 5, 0 }, 3);
                        break;
                    }
                }
                g.translate(-x, -y);
                config.restore();
            }
        };
        final Border buttonBorder = UIManager.getBorder("Spinner.arrowButtonBorder");
        if (buttonBorder instanceof UIResource) {
            b.setBorder(new CompoundBorder(buttonBorder, null));
        }
        else {
            b.setBorder(buttonBorder);
        }
        b.setInheritsPopupMenu(true);
        return b;
    }
    
    static class LayoutManagerDelegate implements LayoutManager
    {
        protected final LayoutManager myDelegate;
        
        LayoutManagerDelegate(final LayoutManager delegate) {
            this.myDelegate = delegate;
        }
        
        @Override
        public void addLayoutComponent(final String name, final Component comp) {
            this.myDelegate.addLayoutComponent(name, comp);
        }
        
        @Override
        public void removeLayoutComponent(final Component comp) {
            this.myDelegate.removeLayoutComponent(comp);
        }
        
        @Override
        public Dimension preferredLayoutSize(final Container parent) {
            return this.myDelegate.preferredLayoutSize(parent);
        }
        
        @Override
        public Dimension minimumLayoutSize(final Container parent) {
            return this.myDelegate.minimumLayoutSize(parent);
        }
        
        @Override
        public void layoutContainer(final Container parent) {
            this.myDelegate.layoutContainer(parent);
        }
    }
}
