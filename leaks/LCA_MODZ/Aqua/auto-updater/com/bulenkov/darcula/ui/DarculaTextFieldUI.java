// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.border.Border;
import java.awt.Container;
import com.bulenkov.iconloader.IconLoader;
import javax.swing.UIManager;
import com.bulenkov.darcula.DarculaUIUtil;
import java.awt.Color;
import com.bulenkov.iconloader.util.Gray;
import java.awt.RenderingHints;
import com.bulenkov.iconloader.util.GraphicsConfig;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.geom.Point2D;
import javax.swing.JPopupMenu;
import javax.swing.text.JTextComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.awt.event.MouseAdapter;
import java.awt.Cursor;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusAdapter;
import javax.swing.JLabel;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.FocusListener;
import javax.swing.plaf.basic.BasicTextFieldUI;

public class DarculaTextFieldUI extends BasicTextFieldUI
{
    private final FocusListener myFocusListener;
    private final MouseMotionListener myMouseMotionListener;
    private final MouseListener myMouseListener;
    protected JLabel myClearIcon;
    protected JLabel myRecentIcon;
    
    public DarculaTextFieldUI() {
        this.myFocusListener = new FocusAdapter() {
            @Override
            public void focusGained(final FocusEvent e) {
                BasicTextUI.this.getComponent().repaint();
            }
            
            @Override
            public void focusLost(final FocusEvent e) {
                BasicTextUI.this.getComponent().repaint();
            }
        };
        this.myMouseMotionListener = new MouseMotionAdapter() {
            @Override
            public void mouseMoved(final MouseEvent e) {
                if (BasicTextUI.this.getComponent() != null && DarculaTextFieldUI.isSearchField(BasicTextUI.this.getComponent())) {
                    if (DarculaTextFieldUI.this.getActionUnder(e) != null) {
                        BasicTextUI.this.getComponent().setCursor(Cursor.getPredefinedCursor(12));
                    }
                    else {
                        BasicTextUI.this.getComponent().setCursor(Cursor.getPredefinedCursor(2));
                    }
                }
            }
        };
        this.myMouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                if (DarculaTextFieldUI.isSearchField(BasicTextUI.this.getComponent())) {
                    final SearchAction action = DarculaTextFieldUI.this.getActionUnder(e);
                    if (action != null) {
                        switch (action) {
                            case POPUP: {
                                DarculaTextFieldUI.this.showSearchPopup();
                                break;
                            }
                            case CLEAR: {
                                BasicTextUI.this.getComponent().setText("");
                                break;
                            }
                        }
                        e.consume();
                    }
                }
            }
        };
    }
    
    public static ComponentUI createUI(final JComponent c) {
        return new DarculaTextFieldUI();
    }
    
    @Override
    protected void installListeners() {
        super.installListeners();
        final JTextComponent c = this.getComponent();
        c.addFocusListener(this.myFocusListener);
        c.addMouseMotionListener(this.myMouseMotionListener);
        c.addMouseListener(this.myMouseListener);
    }
    
    @Override
    protected void uninstallListeners() {
        final JTextComponent c = this.getComponent();
        c.removeMouseListener(this.myMouseListener);
        c.removeMouseMotionListener(this.myMouseMotionListener);
        c.removeFocusListener(this.myFocusListener);
        super.uninstallListeners();
    }
    
    protected void showSearchPopup() {
        final Object value = this.getComponent().getClientProperty("JTextField.Search.FindPopup");
        if (value instanceof JPopupMenu) {
            final JPopupMenu popup = (JPopupMenu)value;
            popup.show(this.getComponent(), this.getSearchIconCoord().x, this.getComponent().getHeight());
        }
    }
    
    private SearchAction getActionUnder(final MouseEvent e) {
        final Point cPoint = this.getClearIconCoord();
        final Point sPoint = this.getSearchIconCoord();
        final Point point = cPoint;
        point.x += 8;
        final Point point2 = cPoint;
        point2.y += 8;
        final Point point3 = sPoint;
        point3.x += 8;
        final Point point4 = sPoint;
        point4.y += 8;
        final Point ePoint = e.getPoint();
        return (cPoint.distance(ePoint) <= 8.0) ? SearchAction.CLEAR : ((sPoint.distance(ePoint) <= 8.0) ? SearchAction.POPUP : null);
    }
    
    protected Rectangle getDrawingRect() {
        final JTextComponent c = this.getComponent();
        final Insets i = c.getInsets();
        final int x = i.right - 4 - 16;
        final int y = i.top - 3;
        final int w = c.getWidth() - i.left - i.right + 32 + 14 - 5;
        int h = c.getBounds().height - i.top - i.bottom + 8 - 3;
        if (h % 2 == 1) {
            ++h;
        }
        return new Rectangle(x, y, w, h);
    }
    
    protected Point getSearchIconCoord() {
        final Rectangle r = this.getDrawingRect();
        return new Point(r.x + 3, r.y + (r.height - 16) / 2 + 1);
    }
    
    protected Point getClearIconCoord() {
        final Rectangle r = this.getDrawingRect();
        return new Point(r.x + r.width - 16 - 1, r.y + (r.height - 16) / 2);
    }
    
    @Override
    protected void paintBackground(final Graphics graphics) {
        final Graphics2D g = (Graphics2D)graphics;
        final JTextComponent c = this.getComponent();
        final Container parent = c.getParent();
        final Rectangle r = this.getDrawingRect();
        if (c.isOpaque() && parent != null) {
            g.setColor(parent.getBackground());
            g.fillRect(0, 0, c.getWidth(), c.getHeight());
        }
        final GraphicsConfig config = new GraphicsConfig(g);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        final Border border = c.getBorder();
        if (isSearchField(c)) {
            g.setColor(c.getBackground());
            final int radius = r.height - 1;
            g.fillRoundRect(r.x, r.y, r.width, r.height - 1, radius, radius);
            g.setColor(c.isEnabled() ? Gray._100 : new Color(5460819));
            if (c.getClientProperty("JTextField.Search.noBorderRing") != Boolean.TRUE) {
                if (c.hasFocus()) {
                    DarculaUIUtil.paintSearchFocusRing(g, r);
                }
                else {
                    g.drawRoundRect(r.x, r.y, r.width, r.height - 1, radius, radius);
                }
            }
            Point p = this.getSearchIconCoord();
            Icon searchIcon = (this.getComponent().getClientProperty("JTextField.Search.FindPopup") instanceof JPopupMenu) ? UIManager.getIcon("TextField.darcula.searchWithHistory.icon") : UIManager.getIcon("TextField.darcula.search.icon");
            if (searchIcon == null) {
                searchIcon = IconLoader.findIcon("/com/bulenkov/darcula/icons/search.png", DarculaTextFieldUI.class, true);
            }
            searchIcon.paintIcon(null, g, p.x, p.y);
            if (this.getComponent().hasFocus() && this.getComponent().getText().length() > 0) {
                p = this.getClearIconCoord();
                Icon clearIcon = UIManager.getIcon("TextField.darcula.clear.icon");
                if (clearIcon == null) {
                    clearIcon = IconLoader.findIcon("/com/bulenkov/darcula/icons/clear.png", DarculaTextFieldUI.class, true);
                }
                clearIcon.paintIcon(null, g, p.x, p.y);
            }
        }
        else if (border instanceof DarculaTextBorder) {
            if (c.isEnabled() && c.isEditable()) {
                g.setColor(c.getBackground());
            }
            final int width = c.getWidth();
            final int height = c.getHeight();
            final Insets i = border.getBorderInsets(c);
            if (c.hasFocus()) {
                g.fillRoundRect(i.left - 5, i.top - 2, width - i.right - i.left + 10, height - i.top - i.bottom + 6, 5, 5);
            }
            else {
                g.fillRect(i.left - 5, i.top - 2, width - i.right - i.left + 12, height - i.top - i.bottom + 6);
            }
        }
        else {
            super.paintBackground(g);
        }
        config.restore();
    }
    
    @Override
    protected void paintSafely(final Graphics g) {
        this.paintBackground(g);
        super.paintSafely(g);
    }
    
    public static boolean isSearchField(final Component c) {
        return c instanceof JTextField && "search".equals(((JTextField)c).getClientProperty("JTextField.variant"));
    }
    
    public static boolean isSearchFieldWithHistoryPopup(final Component c) {
        return isSearchField(c) && ((JTextField)c).getClientProperty("JTextField.Search.FindPopup") instanceof JPopupMenu;
    }
    
    private enum SearchAction
    {
        POPUP, 
        CLEAR;
    }
}
