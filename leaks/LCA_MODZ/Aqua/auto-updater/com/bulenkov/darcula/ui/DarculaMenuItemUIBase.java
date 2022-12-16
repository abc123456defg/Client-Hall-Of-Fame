// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import java.awt.Insets;
import java.awt.Shape;
import sun.swing.SwingUtilities2;
import javax.swing.JMenu;
import javax.swing.ButtonModel;
import java.awt.Component;
import java.awt.Font;
import sun.swing.MenuItemLayoutHelper;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.Icon;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.MenuSelectionManager;
import javax.swing.MenuElement;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicMenuItemUI;

public class DarculaMenuItemUIBase extends BasicMenuItemUI
{
    public static ComponentUI createUI(final JComponent c) {
        return new DarculaMenuItemUIBase();
    }
    
    public void processMouseEvent(final JMenuItem item, final MouseEvent e, final MenuElement[] path, final MenuSelectionManager manager) {
        final Point p = e.getPoint();
        if (p.x >= 0 && p.x < item.getWidth() && p.y >= 0 && p.y < item.getHeight()) {
            if (e.getID() == 502) {
                manager.clearSelectedPath();
                item.doClick(0);
                item.setArmed(false);
            }
            else {
                manager.setSelectedPath(path);
            }
        }
        else if (item.getModel().isArmed()) {
            final MenuElement[] newPath = new MenuElement[path.length - 1];
            for (int i = 0, c = path.length - 1; i < c; ++i) {
                newPath[i] = path[i];
            }
            manager.setSelectedPath(newPath);
        }
    }
    
    @Override
    protected void paintMenuItem(final Graphics g, final JComponent c, final Icon checkIcon, final Icon arrowIcon, final Color background, final Color foreground, final int defaultTextIconGap) {
        final Font holdf = g.getFont();
        final Color holdc = g.getColor();
        final JMenuItem mi = (JMenuItem)c;
        g.setFont(mi.getFont());
        final Rectangle viewRect = new Rectangle(0, 0, mi.getWidth(), mi.getHeight());
        this.applyInsets(viewRect, mi.getInsets());
        final MenuItemLayoutHelper lh = new MenuItemLayoutHelper(mi, checkIcon, arrowIcon, viewRect, defaultTextIconGap, this.acceleratorDelimiter, mi.getComponentOrientation().isLeftToRight(), mi.getFont(), this.acceleratorFont, MenuItemLayoutHelper.useCheckAndArrow(this.menuItem), this.getPropertyPrefix());
        final MenuItemLayoutHelper.LayoutResult lr = lh.layoutMenuItem();
        this.paintBackground(g, mi, background);
        this.paintCheckIcon(g, lh, lr, holdc, foreground);
        this.paintIcon(g, lh, lr, holdc);
        g.setColor(foreground);
        this.paintText(g, lh, lr);
        this.paintAccText(g, lh, lr);
        this.paintArrowIcon(g, lh, lr, foreground);
        g.setColor(holdc);
        g.setFont(holdf);
    }
    
    protected void paintIcon(final Graphics g, final MenuItemLayoutHelper lh, final MenuItemLayoutHelper.LayoutResult lr, final Color holdc) {
        if (lh.getIcon() != null) {
            final ButtonModel model = lh.getMenuItem().getModel();
            Icon icon;
            if (!model.isEnabled()) {
                icon = lh.getMenuItem().getDisabledIcon();
            }
            else if (model.isPressed() && model.isArmed()) {
                icon = lh.getMenuItem().getPressedIcon();
                if (icon == null) {
                    icon = lh.getMenuItem().getIcon();
                }
            }
            else {
                icon = lh.getMenuItem().getIcon();
            }
            if (icon != null) {
                icon.paintIcon(lh.getMenuItem(), g, lr.getIconRect().x, lr.getIconRect().y);
                g.setColor(holdc);
            }
        }
    }
    
    protected void paintCheckIcon(final Graphics g, final MenuItemLayoutHelper lh, final MenuItemLayoutHelper.LayoutResult lr, final Color holdc, final Color foreground) {
        if (lh.getCheckIcon() != null) {
            final ButtonModel model = lh.getMenuItem().getModel();
            if (model.isArmed() || (lh.getMenuItem() instanceof JMenu && model.isSelected())) {
                g.setColor(foreground);
            }
            else {
                g.setColor(holdc);
            }
            if (lh.useCheckAndArrow()) {
                lh.getCheckIcon().paintIcon(lh.getMenuItem(), g, lr.getCheckRect().x, lr.getCheckRect().y);
            }
            g.setColor(holdc);
        }
    }
    
    protected void paintAccText(final Graphics g, final MenuItemLayoutHelper lh, final MenuItemLayoutHelper.LayoutResult lr) {
        if (!lh.getAccText().equals("")) {
            final ButtonModel model = lh.getMenuItem().getModel();
            g.setFont(lh.getAccFontMetrics().getFont());
            if (!model.isEnabled()) {
                if (this.disabledForeground != null) {
                    g.setColor(this.disabledForeground);
                    SwingUtilities2.drawString(lh.getMenuItem(), g, lh.getAccText(), lr.getAccRect().x, lr.getAccRect().y + lh.getAccFontMetrics().getAscent());
                }
                else {
                    g.setColor(lh.getMenuItem().getBackground().brighter());
                    SwingUtilities2.drawString(lh.getMenuItem(), g, lh.getAccText(), lr.getAccRect().x, lr.getAccRect().y + lh.getAccFontMetrics().getAscent());
                    g.setColor(lh.getMenuItem().getBackground().darker());
                    SwingUtilities2.drawString(lh.getMenuItem(), g, lh.getAccText(), lr.getAccRect().x - 1, lr.getAccRect().y + lh.getFontMetrics().getAscent() - 1);
                }
            }
            else {
                if (model.isArmed() || (lh.getMenuItem() instanceof JMenu && model.isSelected())) {
                    g.setColor(this.acceleratorSelectionForeground);
                }
                else {
                    g.setColor(this.acceleratorForeground);
                }
                SwingUtilities2.drawString(lh.getMenuItem(), g, lh.getAccText(), lr.getAccRect().x, lr.getAccRect().y + lh.getAccFontMetrics().getAscent());
            }
        }
    }
    
    protected void paintText(final Graphics g, final MenuItemLayoutHelper lh, final MenuItemLayoutHelper.LayoutResult lr) {
        if (!lh.getText().equals("")) {
            if (lh.getHtmlView() != null) {
                lh.getHtmlView().paint(g, lr.getTextRect());
            }
            else {
                this.paintText(g, lh.getMenuItem(), lr.getTextRect(), lh.getText());
            }
        }
    }
    
    protected void paintArrowIcon(final Graphics g, final MenuItemLayoutHelper lh, final MenuItemLayoutHelper.LayoutResult lr, final Color foreground) {
        if (lh.getArrowIcon() != null) {
            final ButtonModel model = lh.getMenuItem().getModel();
            if (model.isArmed() || (lh.getMenuItem() instanceof JMenu && model.isSelected())) {
                g.setColor(foreground);
            }
            if (lh.useCheckAndArrow()) {
                lh.getArrowIcon().paintIcon(lh.getMenuItem(), g, lr.getArrowRect().x, lr.getArrowRect().y);
            }
        }
    }
    
    protected void applyInsets(final Rectangle rect, final Insets insets) {
        if (insets != null) {
            rect.x += insets.left;
            rect.y += insets.top;
            rect.width -= insets.right + rect.x;
            rect.height -= insets.bottom + rect.y;
        }
    }
}
