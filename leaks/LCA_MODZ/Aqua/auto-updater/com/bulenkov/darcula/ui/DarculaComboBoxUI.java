// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import javax.swing.SwingUtilities;
import java.awt.KeyboardFocusManager;
import com.bulenkov.darcula.DarculaUIUtil;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.KeyListener;
import java.awt.AWTEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.ComboBoxEditor;
import javax.swing.ListCellRenderer;
import javax.swing.JPanel;
import sun.swing.DefaultLookup;
import javax.swing.JList;
import java.awt.Rectangle;
import java.awt.Container;
import java.awt.Component;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.BorderFactory;
import javax.swing.plaf.DimensionUIResource;
import java.awt.Dimension;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import com.bulenkov.iconloader.util.DoubleColor;
import com.bulenkov.iconloader.util.Gray;
import com.bulenkov.iconloader.util.UIUtil;
import com.bulenkov.iconloader.util.GraphicsConfig;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class DarculaComboBoxUI extends BasicComboBoxUI implements Border
{
    private final JComboBox myComboBox;
    private Insets myPadding;
    
    public DarculaComboBoxUI(final JComboBox comboBox) {
        (this.myComboBox = comboBox).setBorder(this);
    }
    
    public static ComponentUI createUI(final JComponent c) {
        return new DarculaComboBoxUI((JComboBox)c);
    }
    
    @Override
    protected void installDefaults() {
        super.installDefaults();
        this.myPadding = UIManager.getInsets("ComboBox.padding");
    }
    
    @Override
    protected JButton createArrowButton() {
        final Color bg = this.myComboBox.getBackground();
        final Color fg = this.myComboBox.getForeground();
        final JButton button = new BasicArrowButton(5, bg, fg, fg, fg) {
            @Override
            public void paint(final Graphics g2) {
                final Graphics2D g3 = (Graphics2D)g2;
                final GraphicsConfig config = new GraphicsConfig(g3);
                final int w = this.getWidth();
                final int h = this.getHeight();
                if (!isTableCellEditor(DarculaComboBoxUI.this.myComboBox)) {
                    g3.setColor(DarculaComboBoxUI.this.getArrowButtonFillColor(UIUtil.getControlColor()));
                    g3.fillRect(0, 0, w, h);
                }
                g3.setColor(DarculaComboBoxUI.this.comboBox.isEnabled() ? new DoubleColor(Gray._255, this.getForeground()) : new DoubleColor(Gray._255, this.getForeground().darker()));
                g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g3.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
                g3.setStroke(new BasicStroke(1.0f, 0, 2));
                final int xU = w / 4;
                final int yU = h / 4;
                final Path2D.Double path = new Path2D.Double();
                g3.translate(2, 0);
                path.moveTo(xU + 1, yU + 2);
                path.lineTo(3 * xU + 1, yU + 2);
                path.lineTo(2 * xU + 1, 3 * yU);
                path.lineTo(xU + 1, yU + 2);
                path.closePath();
                g3.fill(path);
                g3.translate(-2, 0);
                if (!isTableCellEditor(DarculaComboBoxUI.this.myComboBox)) {
                    g3.setColor(DarculaComboBoxUI.this.getArrowButtonFillColor(getBorderColor()));
                    g3.drawLine(0, -1, 0, h);
                }
                config.restore();
            }
            
            @Override
            public Dimension getPreferredSize() {
                int size = this.getFont().getSize() + 4;
                if (size % 2 == 1) {
                    ++size;
                }
                return new DimensionUIResource(size, size);
            }
        };
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setOpaque(false);
        return button;
    }
    
    protected Color getArrowButtonFillColor(final Color defaultColor) {
        final Color color = this.myComboBox.hasFocus() ? UIManager.getColor("ComboBox.darcula.arrowFocusedFillColor") : UIManager.getColor("ComboBox.darcula.arrowFillColor");
        return (color == null) ? defaultColor : ((this.comboBox != null && !this.comboBox.isEnabled()) ? UIUtil.getControlColor() : color);
    }
    
    @Override
    protected Insets getInsets() {
        return new InsetsUIResource(4, 7, 4, 5);
    }
    
    @Override
    protected Dimension getSizeForComponent(final Component comp) {
        this.currentValuePane.add(comp);
        comp.setFont(this.comboBox.getFont());
        final Dimension d = comp.getPreferredSize();
        this.currentValuePane.remove(comp);
        return d;
    }
    
    @Override
    public void paint(final Graphics g, final JComponent c) {
        final Container parent = c.getParent();
        if (parent != null) {
            g.setColor(parent.getBackground());
            g.fillRect(0, 0, c.getWidth(), c.getHeight());
        }
        final Rectangle r = this.rectangleForCurrentValue();
        if (!isTableCellEditor(c)) {
            this.paintBorder(c, g, 0, 0, c.getWidth(), c.getHeight());
            this.paintCurrentValueBackground(g, r, this.hasFocus = this.comboBox.hasFocus());
        }
        this.paintCurrentValue(g, r, this.hasFocus);
    }
    
    private static boolean isTableCellEditor(final JComponent c) {
        return Boolean.TRUE.equals(c.getClientProperty("JComboBox.isTableCellEditor"));
    }
    
    @Override
    protected Rectangle rectangleForCurrentValue() {
        final Rectangle rectangleForCurrentValue;
        final Rectangle r = rectangleForCurrentValue = super.rectangleForCurrentValue();
        rectangleForCurrentValue.x -= 2;
        final Rectangle rectangle = r;
        rectangle.y -= (isTableCellEditor(this.myComboBox) ? 0 : 1);
        return r;
    }
    
    @Override
    public void paintCurrentValue(final Graphics g, final Rectangle bounds, final boolean hasFocus) {
        final ListCellRenderer renderer = this.comboBox.getRenderer();
        Component c;
        if (hasFocus && !this.isPopupVisible(this.comboBox)) {
            c = renderer.getListCellRendererComponent(this.listBox, this.comboBox.getSelectedItem(), -1, false, false);
        }
        else {
            c = renderer.getListCellRendererComponent(this.listBox, this.comboBox.getSelectedItem(), -1, false, false);
            c.setBackground(UIManager.getColor("ComboBox.background"));
        }
        c.setFont(this.comboBox.getFont());
        if (hasFocus && !this.isPopupVisible(this.comboBox)) {
            c.setForeground(this.listBox.getForeground());
            c.setBackground(this.listBox.getBackground());
        }
        else if (this.comboBox.isEnabled()) {
            c.setForeground(this.comboBox.getForeground());
            c.setBackground(this.comboBox.getBackground());
        }
        else {
            c.setForeground(DefaultLookup.getColor(this.comboBox, this, "ComboBox.disabledForeground", null));
            c.setBackground(DefaultLookup.getColor(this.comboBox, this, "ComboBox.disabledBackground", null));
        }
        final boolean changeOpaque = c instanceof JComponent && isTableCellEditor(this.comboBox) && c.isOpaque();
        if (changeOpaque) {
            ((JComponent)c).setOpaque(false);
        }
        boolean shouldValidate = false;
        if (c instanceof JPanel) {
            shouldValidate = true;
        }
        final Rectangle r = new Rectangle(bounds);
        if (this.myPadding != null) {
            final Rectangle rectangle = r;
            rectangle.x += this.myPadding.left;
            final Rectangle rectangle2 = r;
            rectangle2.y += this.myPadding.top;
            final Rectangle rectangle3 = r;
            rectangle3.width -= this.myPadding.left + this.myPadding.right;
            final Rectangle rectangle4 = r;
            rectangle4.height -= this.myPadding.top + this.myPadding.bottom;
        }
        this.currentValuePane.paintComponent(g, c, this.comboBox, r.x, r.y, r.width, r.height, shouldValidate);
        if (changeOpaque) {
            ((JComponent)c).setOpaque(true);
        }
    }
    
    @Override
    protected void installKeyboardActions() {
        super.installKeyboardActions();
    }
    
    @Override
    protected ComboBoxEditor createEditor() {
        final ComboBoxEditor comboBoxEditor = super.createEditor();
        if (comboBoxEditor != null && comboBoxEditor.getEditorComponent() != null) {
            comboBoxEditor.getEditorComponent().addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(final KeyEvent e) {
                    this.process(e);
                }
                
                private void process(final KeyEvent e) {
                    final int code = e.getKeyCode();
                    if ((code == 38 || code == 40) && e.getModifiers() == 0) {
                        DarculaComboBoxUI.this.comboBox.dispatchEvent(e);
                    }
                }
                
                @Override
                public void keyReleased(final KeyEvent e) {
                    this.process(e);
                }
            });
            comboBoxEditor.getEditorComponent().addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(final FocusEvent e) {
                    DarculaComboBoxUI.this.comboBox.revalidate();
                    DarculaComboBoxUI.this.comboBox.repaint();
                }
                
                @Override
                public void focusLost(final FocusEvent e) {
                    DarculaComboBoxUI.this.comboBox.revalidate();
                    DarculaComboBoxUI.this.comboBox.repaint();
                }
            });
        }
        return comboBoxEditor;
    }
    
    @Override
    public void paintBorder(final Component c, final Graphics g2, final int x, final int y, final int width, final int height) {
        if (this.comboBox == null || this.arrowButton == null) {
            return;
        }
        this.hasFocus = false;
        this.checkFocus();
        final Graphics2D g3 = (Graphics2D)g2;
        final Rectangle arrowButtonBounds = this.arrowButton.getBounds();
        final int xxx = arrowButtonBounds.x - 5;
        final GraphicsConfig config = new GraphicsConfig(g3);
        g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g3.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        if (this.editor != null && this.comboBox.isEditable()) {
            ((JComponent)this.editor).setBorder(null);
            g3.setColor(this.editor.getBackground());
            g3.fillRoundRect(x + 1, y + 1, width - 2, height - 4, 5, 5);
            g3.setColor(this.getArrowButtonFillColor(this.arrowButton.getBackground()));
            g3.fillRoundRect(xxx, y + 1, width - xxx, height - 4, 5, 5);
            g3.setColor(this.editor.getBackground());
            g3.fillRect(xxx, y + 1, 5, height - 4);
        }
        else {
            g3.setColor(UIUtil.getPanelBackground());
            g3.fillRoundRect(x + 1, y + 1, width - 2, height - 4, 5, 5);
            g3.setColor(this.getArrowButtonFillColor(this.arrowButton.getBackground()));
            g3.fillRoundRect(xxx, y + 1, width - xxx, height - 4, 5, 5);
            g3.setColor(UIUtil.getPanelBackground());
            g3.fillRect(xxx, y + 1, 5, height - 4);
        }
        final Color borderColor = getBorderColor();
        g3.setColor(this.getArrowButtonFillColor(borderColor));
        final int off = this.hasFocus ? 1 : 0;
        g3.drawLine(xxx + 5, y + 1 + off, xxx + 5, height - 3);
        final Rectangle r = this.rectangleForCurrentValue();
        this.paintCurrentValueBackground(g3, r, this.hasFocus);
        this.paintCurrentValue(g3, r, false);
        if (this.hasFocus) {
            DarculaUIUtil.paintFocusRing(g3, 2, 2, width - 4, height - 5);
        }
        else {
            g3.setColor(borderColor);
            g3.drawRoundRect(1, 1, width - 2, height - 4, 5, 5);
        }
        config.restore();
    }
    
    private void checkFocus() {
        this.hasFocus = hasFocus(this.comboBox);
        if (this.hasFocus) {
            return;
        }
        final ComboBoxEditor ed = this.comboBox.getEditor();
        this.editor = ((ed == null) ? null : ed.getEditorComponent());
        if (this.editor != null) {
            this.hasFocus = hasFocus(this.editor);
        }
    }
    
    private static boolean hasFocus(final Component c) {
        final Component owner = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
        return owner != null && SwingUtilities.isDescendingFrom(owner, c);
    }
    
    private static Color getBorderColor() {
        return new DoubleColor(Gray._150, Gray._100);
    }
    
    @Override
    public Insets getBorderInsets(final Component c) {
        return new InsetsUIResource(4, 7, 4, 5);
    }
    
    @Override
    public boolean isBorderOpaque() {
        return false;
    }
    
    @Override
    public Component.BaselineResizeBehavior getBaselineResizeBehavior(final JComponent c) {
        return super.getBaselineResizeBehavior(c);
    }
    
    @Override
    public int getBaseline(final JComponent c, final int width, final int height) {
        return super.getBaseline(c, width, height);
    }
}
