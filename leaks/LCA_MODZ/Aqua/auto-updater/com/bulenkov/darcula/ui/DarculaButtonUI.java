// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import com.bulenkov.iconloader.util.SystemInfo;
import java.awt.FontMetrics;
import java.awt.Color;
import sun.swing.SwingUtilities2;
import javax.swing.UIManager;
import javax.swing.plaf.UIResource;
import java.awt.Rectangle;
import java.awt.Insets;
import com.bulenkov.iconloader.util.GraphicsConfig;
import javax.swing.border.Border;
import javax.swing.ButtonModel;
import java.awt.Paint;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import javax.swing.JToggleButton;
import com.bulenkov.iconloader.util.GraphicsUtil;
import javax.swing.AbstractButton;
import java.awt.Graphics;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

public class DarculaButtonUI extends BasicButtonUI
{
    public static ComponentUI createUI(final JComponent c) {
        return new DarculaButtonUI();
    }
    
    public static boolean isSquare(final Component c) {
        return c instanceof JButton && "square".equals(((JButton)c).getClientProperty("JButton.buttonType"));
    }
    
    @Override
    public void paint(final Graphics g, final JComponent c) {
        final AbstractButton button = (AbstractButton)c;
        final ButtonModel model = button.getModel();
        final Border border = c.getBorder();
        final GraphicsConfig config = GraphicsUtil.setupAAPainting(g);
        final boolean square = isSquare(c);
        if (c.isEnabled() && border != null && button.isContentAreaFilled() && !(c instanceof JToggleButton)) {
            final Insets ins = border.getBorderInsets(c);
            final int yOff = (ins.top + ins.bottom) / 4;
            if (!square) {
                if ((c instanceof JButton && ((JButton)c).isDefaultButton()) || model.isSelected()) {
                    ((Graphics2D)g).setPaint(new GradientPaint(0.0f, 0.0f, this.getSelectedButtonColor1(), 0.0f, (float)c.getHeight(), this.getSelectedButtonColor2()));
                }
                else {
                    ((Graphics2D)g).setPaint(new GradientPaint(0.0f, 0.0f, this.getButtonColor1(), 0.0f, (float)c.getHeight(), this.getButtonColor2()));
                }
            }
            g.fillRoundRect(square ? 2 : 4, yOff, c.getWidth() - 8, c.getHeight() - 2 * yOff, square ? 3 : 5, square ? 3 : 5);
        }
        config.restore();
        super.paint(g, c);
    }
    
    @Override
    protected void paintText(final Graphics g, final JComponent c, final Rectangle textRect, final String text) {
        final AbstractButton button = (AbstractButton)c;
        final ButtonModel model = button.getModel();
        Color fg = button.getForeground();
        if (fg instanceof UIResource && button instanceof JButton && ((JButton)button).isDefaultButton()) {
            final Color selectedFg = UIManager.getColor("Button.darcula.selectedButtonForeground");
            if (selectedFg != null) {
                fg = selectedFg;
            }
        }
        g.setColor(fg);
        final FontMetrics metrics = SwingUtilities2.getFontMetrics(c, g);
        final int mnemonicIndex = button.getDisplayedMnemonicIndex();
        if (model.isEnabled()) {
            SwingUtilities2.drawStringUnderlineCharAt(c, g, text, mnemonicIndex, textRect.x + this.getTextShiftOffset(), textRect.y + metrics.getAscent() + this.getTextShiftOffset());
        }
        else {
            g.setColor(UIManager.getColor("Button.darcula.disabledText.shadow"));
            SwingUtilities2.drawStringUnderlineCharAt(c, g, text, -1, textRect.x + this.getTextShiftOffset() + 1, textRect.y + metrics.getAscent() + this.getTextShiftOffset() + 1);
            g.setColor(UIManager.getColor("Button.disabledText"));
            SwingUtilities2.drawStringUnderlineCharAt(c, g, text, -1, textRect.x + this.getTextShiftOffset(), textRect.y + metrics.getAscent() + this.getTextShiftOffset());
        }
    }
    
    @Override
    public void update(final Graphics g, final JComponent c) {
        super.update(g, c);
        if (c instanceof JButton && ((JButton)c).isDefaultButton() && !SystemInfo.isMac && !c.getFont().isBold()) {
            c.setFont(c.getFont().deriveFont(1));
        }
    }
    
    protected Color getButtonColor1() {
        return UIManager.getColor("Button.darcula.color1");
    }
    
    protected Color getButtonColor2() {
        return UIManager.getColor("Button.darcula.color2");
    }
    
    protected Color getSelectedButtonColor1() {
        return UIManager.getColor("Button.darcula.selection.color1");
    }
    
    protected Color getSelectedButtonColor2() {
        return UIManager.getColor("Button.darcula.selection.color2");
    }
}
