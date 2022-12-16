// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import java.awt.event.WindowAdapter;
import java.beans.PropertyChangeEvent;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.image.ImageObserver;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import java.util.List;
import sun.awt.SunToolkit;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import sun.swing.SwingUtilities2;
import java.awt.Graphics;
import java.awt.Dialog;
import javax.swing.plaf.UIResource;
import java.awt.LayoutManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import javax.swing.JMenu;
import java.awt.AWTEvent;
import java.awt.event.WindowEvent;
import java.awt.Frame;
import java.awt.Component;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRootPane;
import java.awt.Window;
import java.awt.event.WindowListener;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.Action;
import javax.swing.JMenuBar;
import java.beans.PropertyChangeListener;
import javax.swing.JComponent;

public class DarculaTitlePane extends JComponent
{
    private static final int IMAGE_HEIGHT = 16;
    private static final int IMAGE_WIDTH = 16;
    private PropertyChangeListener myPropertyChangeListener;
    private JMenuBar myMenuBar;
    private Action myCloseAction;
    private Action myIconifyAction;
    private Action myRestoreAction;
    private Action myMaximizeAction;
    private JButton myToggleButton;
    private JButton myIconifyButton;
    private JButton myCloseButton;
    private Icon myMaximizeIcon;
    private Icon myMinimizeIcon;
    private Image mySystemIcon;
    private WindowListener myWindowListener;
    private Window myWindow;
    private JRootPane myRootPane;
    private int myState;
    private DarculaRootPaneUI rootPaneUI;
    private Color myInactiveBackground;
    private Color myInactiveForeground;
    private Color myInactiveShadow;
    private Color myActiveBackground;
    private Color myActiveForeground;
    private Color myActiveShadow;
    
    public DarculaTitlePane(final JRootPane root, final DarculaRootPaneUI ui) {
        this.myInactiveBackground = UIManager.getColor("inactiveCaption");
        this.myInactiveForeground = UIManager.getColor("inactiveCaptionText");
        this.myInactiveShadow = UIManager.getColor("inactiveCaptionBorder");
        this.myActiveBackground = null;
        this.myActiveForeground = null;
        this.myActiveShadow = null;
        this.myRootPane = root;
        this.rootPaneUI = ui;
        this.myState = -1;
        this.installSubcomponents();
        this.determineColors();
        this.installDefaults();
        this.setLayout(this.createLayout());
    }
    
    private void uninstall() {
        this.uninstallListeners();
        this.myWindow = null;
        this.removeAll();
    }
    
    private void installListeners() {
        if (this.myWindow != null) {
            this.myWindowListener = this.createWindowListener();
            this.myWindow.addWindowListener(this.myWindowListener);
            this.myPropertyChangeListener = this.createWindowPropertyChangeListener();
            this.myWindow.addPropertyChangeListener(this.myPropertyChangeListener);
        }
    }
    
    private void uninstallListeners() {
        if (this.myWindow != null) {
            this.myWindow.removeWindowListener(this.myWindowListener);
            this.myWindow.removePropertyChangeListener(this.myPropertyChangeListener);
        }
    }
    
    private WindowListener createWindowListener() {
        return new WindowHandler();
    }
    
    private PropertyChangeListener createWindowPropertyChangeListener() {
        return new PropertyChangeHandler();
    }
    
    @Override
    public JRootPane getRootPane() {
        return this.myRootPane;
    }
    
    private int getWindowDecorationStyle() {
        return this.getRootPane().getWindowDecorationStyle();
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        this.uninstallListeners();
        this.myWindow = SwingUtilities.getWindowAncestor(this);
        if (this.myWindow != null) {
            if (this.myWindow instanceof Frame) {
                this.setState(((Frame)this.myWindow).getExtendedState());
            }
            else {
                this.setState(0);
            }
            this.setActive(this.myWindow.isActive());
            this.installListeners();
            this.updateSystemIcon();
        }
    }
    
    @Override
    public void removeNotify() {
        super.removeNotify();
        this.uninstallListeners();
        this.myWindow = null;
    }
    
    private void installSubcomponents() {
        final int decorationStyle = this.getWindowDecorationStyle();
        if (decorationStyle == 1) {
            this.createActions();
            this.add(this.myMenuBar = this.createMenuBar());
            this.createButtons();
            this.add(this.myIconifyButton);
            this.add(this.myToggleButton);
            this.add(this.myCloseButton);
        }
        else if (decorationStyle == 2 || decorationStyle == 3 || decorationStyle == 4 || decorationStyle == 5 || decorationStyle == 6 || decorationStyle == 7 || decorationStyle == 8) {
            this.createActions();
            this.createButtons();
            this.add(this.myCloseButton);
        }
    }
    
    private void determineColors() {
        switch (this.getWindowDecorationStyle()) {
            case 1: {
                this.myActiveBackground = UIManager.getColor("activeCaption");
                this.myActiveForeground = UIManager.getColor("activeCaptionText");
                this.myActiveShadow = UIManager.getColor("activeCaptionBorder");
                break;
            }
            case 4: {
                this.myActiveBackground = UIManager.getColor("OptionPane.errorDialog.titlePane.background");
                this.myActiveForeground = UIManager.getColor("OptionPane.errorDialog.titlePane.foreground");
                this.myActiveShadow = UIManager.getColor("OptionPane.errorDialog.titlePane.shadow");
                break;
            }
            case 5:
            case 6:
            case 7: {
                this.myActiveBackground = UIManager.getColor("OptionPane.questionDialog.titlePane.background");
                this.myActiveForeground = UIManager.getColor("OptionPane.questionDialog.titlePane.foreground");
                this.myActiveShadow = UIManager.getColor("OptionPane.questionDialog.titlePane.shadow");
                break;
            }
            case 8: {
                this.myActiveBackground = UIManager.getColor("OptionPane.warningDialog.titlePane.background");
                this.myActiveForeground = UIManager.getColor("OptionPane.warningDialog.titlePane.foreground");
                this.myActiveShadow = UIManager.getColor("OptionPane.warningDialog.titlePane.shadow");
                break;
            }
            default: {
                this.myActiveBackground = UIManager.getColor("activeCaption");
                this.myActiveForeground = UIManager.getColor("activeCaptionText");
                this.myActiveShadow = UIManager.getColor("activeCaptionBorder");
                break;
            }
        }
    }
    
    private void installDefaults() {
        this.setFont(UIManager.getFont("InternalFrame.titleFont", this.getLocale()));
    }
    
    protected JMenuBar createMenuBar() {
        (this.myMenuBar = new SystemMenuBar()).setFocusable(false);
        this.myMenuBar.setBorderPainted(true);
        this.myMenuBar.add(this.createMenu());
        return this.myMenuBar;
    }
    
    private void close() {
        final Window window = this.getWindow();
        if (window != null) {
            window.dispatchEvent(new WindowEvent(window, 201));
        }
    }
    
    private void iconify() {
        final Frame frame = this.getFrame();
        if (frame != null) {
            frame.setExtendedState(this.myState | 0x1);
        }
    }
    
    private void maximize() {
        final Frame frame = this.getFrame();
        if (frame != null) {
            frame.setExtendedState(this.myState | 0x6);
        }
    }
    
    private void restore() {
        final Frame frame = this.getFrame();
        if (frame == null) {
            return;
        }
        if ((this.myState & 0x1) != 0x0) {
            frame.setExtendedState(this.myState & 0xFFFFFFFE);
        }
        else {
            frame.setExtendedState(this.myState & 0xFFFFFFF9);
        }
    }
    
    private void createActions() {
        this.myCloseAction = new CloseAction();
        if (this.getWindowDecorationStyle() == 1) {
            this.myIconifyAction = new IconifyAction();
            this.myRestoreAction = new RestoreAction();
            this.myMaximizeAction = new MaximizeAction();
        }
    }
    
    private JMenu createMenu() {
        final JMenu menu = new JMenu("");
        if (this.getWindowDecorationStyle() == 1) {
            this.addMenuItems(menu);
        }
        return menu;
    }
    
    private void addMenuItems(final JMenu menu) {
        menu.add(this.myRestoreAction);
        menu.add(this.myIconifyAction);
        if (Toolkit.getDefaultToolkit().isFrameStateSupported(6)) {
            menu.add(this.myMaximizeAction);
        }
        menu.add(new JSeparator());
        menu.add(this.myCloseAction);
    }
    
    private static JButton createButton(final String accessibleName, final Icon icon, final Action action) {
        final JButton button = new JButton();
        button.setFocusPainted(false);
        button.setFocusable(false);
        button.setOpaque(true);
        button.putClientProperty("paintActive", Boolean.TRUE);
        button.putClientProperty("AccessibleName", accessibleName);
        button.setBorder(new EmptyBorder(0, 0, 0, 0));
        button.setText(null);
        button.setAction(action);
        button.setIcon(icon);
        return button;
    }
    
    private void createButtons() {
        this.myCloseButton = createButton("Close", UIManager.getIcon("InternalFrame.closeIcon"), this.myCloseAction);
        if (this.getWindowDecorationStyle() == 1) {
            this.myMaximizeIcon = UIManager.getIcon("InternalFrame.maximizeIcon");
            this.myMinimizeIcon = UIManager.getIcon("InternalFrame.minimizeIcon");
            this.myIconifyButton = createButton("Iconify", UIManager.getIcon("InternalFrame.iconifyIcon"), this.myIconifyAction);
            this.myToggleButton = createButton("Maximize", this.myMaximizeIcon, this.myRestoreAction);
        }
    }
    
    private LayoutManager createLayout() {
        return new TitlePaneLayout();
    }
    
    private void setActive(final boolean active) {
        this.myCloseButton.putClientProperty("paintActive", active);
        if (this.getWindowDecorationStyle() == 1) {
            this.myIconifyButton.putClientProperty("paintActive", active);
            this.myToggleButton.putClientProperty("paintActive", active);
        }
        this.getRootPane().repaint();
    }
    
    private void setState(final int state) {
        this.setState(state, false);
    }
    
    private void setState(final int state, final boolean updateRegardless) {
        final Window wnd = this.getWindow();
        if (wnd != null && this.getWindowDecorationStyle() == 1) {
            if (this.myState == state && !updateRegardless) {
                return;
            }
            final Frame frame = this.getFrame();
            if (frame != null) {
                final JRootPane rootPane = this.getRootPane();
                if ((state & 0x6) != 0x0 && (rootPane.getBorder() == null || rootPane.getBorder() instanceof UIResource) && frame.isShowing()) {
                    rootPane.setBorder(null);
                }
                else if ((state & 0x6) == 0x0) {
                    this.rootPaneUI.installBorder(rootPane);
                }
                if (frame.isResizable()) {
                    if ((state & 0x6) != 0x0) {
                        this.updateToggleButton(this.myRestoreAction, this.myMinimizeIcon);
                        this.myMaximizeAction.setEnabled(false);
                        this.myRestoreAction.setEnabled(true);
                    }
                    else {
                        this.updateToggleButton(this.myMaximizeAction, this.myMaximizeIcon);
                        this.myMaximizeAction.setEnabled(true);
                        this.myRestoreAction.setEnabled(false);
                    }
                    if (this.myToggleButton.getParent() == null || this.myIconifyButton.getParent() == null) {
                        this.add(this.myToggleButton);
                        this.add(this.myIconifyButton);
                        this.revalidate();
                        this.repaint();
                    }
                    this.myToggleButton.setText(null);
                }
                else {
                    this.myMaximizeAction.setEnabled(false);
                    this.myRestoreAction.setEnabled(false);
                    if (this.myToggleButton.getParent() != null) {
                        this.remove(this.myToggleButton);
                        this.revalidate();
                        this.repaint();
                    }
                }
            }
            else {
                this.myMaximizeAction.setEnabled(false);
                this.myRestoreAction.setEnabled(false);
                this.myIconifyAction.setEnabled(false);
                this.remove(this.myToggleButton);
                this.remove(this.myIconifyButton);
                this.revalidate();
                this.repaint();
            }
            this.myCloseAction.setEnabled(true);
            this.myState = state;
        }
    }
    
    private void updateToggleButton(final Action action, final Icon icon) {
        this.myToggleButton.setAction(action);
        this.myToggleButton.setIcon(icon);
        this.myToggleButton.setText(null);
    }
    
    private Frame getFrame() {
        final Window window = this.getWindow();
        if (window instanceof Frame) {
            return (Frame)window;
        }
        return null;
    }
    
    private Window getWindow() {
        return this.myWindow;
    }
    
    private String getTitle() {
        final Window w = this.getWindow();
        if (w instanceof Frame) {
            return ((Frame)w).getTitle();
        }
        if (w instanceof Dialog) {
            return ((Dialog)w).getTitle();
        }
        return null;
    }
    
    public void paintComponent(final Graphics g) {
        if (this.getFrame() != null) {
            this.setState(this.getFrame().getExtendedState());
        }
        final JRootPane rootPane = this.getRootPane();
        final Window window = this.getWindow();
        final boolean leftToRight = (window == null) ? rootPane.getComponentOrientation().isLeftToRight() : window.getComponentOrientation().isLeftToRight();
        final boolean isSelected = window == null || window.isActive();
        final int width = this.getWidth();
        final int height = this.getHeight();
        Color background;
        Color foreground;
        Color darkShadow;
        if (isSelected) {
            background = this.myActiveBackground;
            foreground = this.myActiveForeground;
            darkShadow = this.myActiveShadow;
        }
        else {
            background = this.myInactiveBackground;
            foreground = this.myInactiveForeground;
            darkShadow = this.myInactiveShadow;
        }
        g.setColor(background);
        g.fillRect(0, 0, width, height);
        g.setColor(darkShadow);
        g.drawLine(0, height - 1, width, height - 1);
        g.drawLine(0, 0, 0, 0);
        g.drawLine(width - 1, 0, width - 1, 0);
        int xOffset = leftToRight ? 5 : (width - 5);
        if (this.getWindowDecorationStyle() == 1) {
            xOffset += (leftToRight ? 21 : -21);
        }
        String theTitle = this.getTitle();
        if (theTitle != null) {
            final FontMetrics fm = SwingUtilities2.getFontMetrics(rootPane, g);
            g.setColor(foreground);
            final int yOffset = (height - fm.getHeight()) / 2 + fm.getAscent();
            Rectangle rect = new Rectangle(0, 0, 0, 0);
            if (this.myIconifyButton != null && this.myIconifyButton.getParent() != null) {
                rect = this.myIconifyButton.getBounds();
            }
            if (leftToRight) {
                if (rect.x == 0) {
                    rect.x = window.getWidth() - window.getInsets().right - 2;
                }
                final int titleW = rect.x - xOffset - 4;
                theTitle = SwingUtilities2.clipStringIfNecessary(rootPane, fm, theTitle, titleW);
            }
            else {
                final int titleW = xOffset - rect.x - rect.width - 4;
                theTitle = SwingUtilities2.clipStringIfNecessary(rootPane, fm, theTitle, titleW);
                xOffset -= SwingUtilities2.stringWidth(rootPane, fm, theTitle);
            }
            final int titleLength = SwingUtilities2.stringWidth(rootPane, fm, theTitle);
            SwingUtilities2.drawString(rootPane, g, theTitle, xOffset, yOffset);
            xOffset += (leftToRight ? (titleLength + 5) : -5);
        }
    }
    
    private void updateSystemIcon() {
        final Window window = this.getWindow();
        if (window == null) {
            this.mySystemIcon = null;
            return;
        }
        final List<Image> icons = window.getIconImages();
        assert icons != null;
        if (icons.size() == 0) {
            this.mySystemIcon = null;
        }
        else if (icons.size() == 1) {
            this.mySystemIcon = icons.get(0);
        }
        else {
            this.mySystemIcon = SunToolkit.getScaledIconImage(icons, 16, 16);
        }
    }
    
    private class CloseAction extends AbstractAction
    {
        public CloseAction() {
            super(UIManager.getString("DarculaTitlePane.closeTitle", DarculaTitlePane.this.getLocale()));
        }
        
        @Override
        public void actionPerformed(final ActionEvent e) {
            DarculaTitlePane.this.close();
        }
    }
    
    private class IconifyAction extends AbstractAction
    {
        public IconifyAction() {
            super(UIManager.getString("DarculaTitlePane.iconifyTitle", DarculaTitlePane.this.getLocale()));
        }
        
        @Override
        public void actionPerformed(final ActionEvent e) {
            DarculaTitlePane.this.iconify();
        }
    }
    
    private class RestoreAction extends AbstractAction
    {
        public RestoreAction() {
            super(UIManager.getString("DarculaTitlePane.restoreTitle", DarculaTitlePane.this.getLocale()));
        }
        
        @Override
        public void actionPerformed(final ActionEvent e) {
            DarculaTitlePane.this.restore();
        }
    }
    
    private class MaximizeAction extends AbstractAction
    {
        public MaximizeAction() {
            super(UIManager.getString("DarculaTitlePane.maximizeTitle", DarculaTitlePane.this.getLocale()));
        }
        
        @Override
        public void actionPerformed(final ActionEvent e) {
            DarculaTitlePane.this.maximize();
        }
    }
    
    private class SystemMenuBar extends JMenuBar
    {
        @Override
        public void paint(final Graphics g) {
            if (this.isOpaque()) {
                g.setColor(this.getBackground());
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
            }
            if (DarculaTitlePane.this.mySystemIcon != null) {
                g.drawImage(DarculaTitlePane.this.mySystemIcon, 0, 0, 16, 16, null);
            }
            else {
                final Icon icon = UIManager.getIcon("InternalFrame.icon");
                if (icon != null) {
                    icon.paintIcon(this, g, 0, 0);
                }
            }
        }
        
        @Override
        public Dimension getMinimumSize() {
            return this.getPreferredSize();
        }
        
        @Override
        public Dimension getPreferredSize() {
            final Dimension size = super.getPreferredSize();
            return new Dimension(Math.max(16, size.width), Math.max(size.height, 16));
        }
    }
    
    private class TitlePaneLayout implements LayoutManager
    {
        @Override
        public void addLayoutComponent(final String name, final Component c) {
        }
        
        @Override
        public void removeLayoutComponent(final Component c) {
        }
        
        @Override
        public Dimension preferredLayoutSize(final Container c) {
            final int height = this.computeHeight();
            return new Dimension(height, height);
        }
        
        @Override
        public Dimension minimumLayoutSize(final Container c) {
            return this.preferredLayoutSize(c);
        }
        
        private int computeHeight() {
            final FontMetrics fm = DarculaTitlePane.this.myRootPane.getFontMetrics(DarculaTitlePane.this.getFont());
            int fontHeight = fm.getHeight();
            fontHeight += 7;
            int iconHeight = 0;
            if (DarculaTitlePane.this.getWindowDecorationStyle() == 1) {
                iconHeight = 16;
            }
            return Math.max(fontHeight, iconHeight);
        }
        
        @Override
        public void layoutContainer(final Container c) {
            final boolean leftToRight = (DarculaTitlePane.this.myWindow == null) ? DarculaTitlePane.this.getRootPane().getComponentOrientation().isLeftToRight() : DarculaTitlePane.this.myWindow.getComponentOrientation().isLeftToRight();
            final int w = DarculaTitlePane.this.getWidth();
            final int y = 3;
            int buttonHeight;
            int buttonWidth;
            if (DarculaTitlePane.this.myCloseButton != null && DarculaTitlePane.this.myCloseButton.getIcon() != null) {
                buttonHeight = DarculaTitlePane.this.myCloseButton.getIcon().getIconHeight();
                buttonWidth = DarculaTitlePane.this.myCloseButton.getIcon().getIconWidth();
            }
            else {
                buttonHeight = 16;
                buttonWidth = 16;
            }
            int x = leftToRight ? w : 0;
            int spacing = 5;
            x = (leftToRight ? spacing : (w - buttonWidth - spacing));
            if (DarculaTitlePane.this.myMenuBar != null) {
                DarculaTitlePane.this.myMenuBar.setBounds(x, y, buttonWidth, buttonHeight);
            }
            x = (leftToRight ? w : 0);
            spacing = 4;
            x += (leftToRight ? (-spacing - buttonWidth) : spacing);
            if (DarculaTitlePane.this.myCloseButton != null) {
                DarculaTitlePane.this.myCloseButton.setBounds(x, y, buttonWidth, buttonHeight);
            }
            if (!leftToRight) {
                x += buttonWidth;
            }
            if (DarculaTitlePane.this.getWindowDecorationStyle() == 1) {
                if (Toolkit.getDefaultToolkit().isFrameStateSupported(6) && DarculaTitlePane.this.myToggleButton.getParent() != null) {
                    spacing = 10;
                    x += (leftToRight ? (-spacing - buttonWidth) : spacing);
                    DarculaTitlePane.this.myToggleButton.setBounds(x, y, buttonWidth, buttonHeight);
                    if (!leftToRight) {
                        x += buttonWidth;
                    }
                }
                if (DarculaTitlePane.this.myIconifyButton != null && DarculaTitlePane.this.myIconifyButton.getParent() != null) {
                    spacing = 2;
                    x += (leftToRight ? (-spacing - buttonWidth) : spacing);
                    DarculaTitlePane.this.myIconifyButton.setBounds(x, y, buttonWidth, buttonHeight);
                    if (!leftToRight) {
                        x += buttonWidth;
                    }
                }
            }
        }
    }
    
    private class PropertyChangeHandler implements PropertyChangeListener
    {
        @Override
        public void propertyChange(final PropertyChangeEvent pce) {
            final String name = pce.getPropertyName();
            if ("resizable".equals(name) || "state".equals(name)) {
                final Frame frame = DarculaTitlePane.this.getFrame();
                if (frame != null) {
                    DarculaTitlePane.this.setState(frame.getExtendedState(), true);
                }
                if ("resizable".equals(name)) {
                    DarculaTitlePane.this.getRootPane().repaint();
                }
            }
            else if ("title".equals(name)) {
                DarculaTitlePane.this.repaint();
            }
            else if ("componentOrientation" == name) {
                DarculaTitlePane.this.revalidate();
                DarculaTitlePane.this.repaint();
            }
            else if ("iconImage" == name) {
                DarculaTitlePane.this.updateSystemIcon();
                DarculaTitlePane.this.revalidate();
                DarculaTitlePane.this.repaint();
            }
        }
    }
    
    private class WindowHandler extends WindowAdapter
    {
        @Override
        public void windowActivated(final WindowEvent ev) {
            DarculaTitlePane.this.setActive(true);
        }
        
        @Override
        public void windowDeactivated(final WindowEvent ev) {
            DarculaTitlePane.this.setActive(false);
        }
    }
}
