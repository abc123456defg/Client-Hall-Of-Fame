// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import javax.swing.event.MouseInputAdapter;
import java.security.PrivilegedActionException;
import java.security.AccessController;
import java.awt.Dialog;
import java.awt.event.MouseEvent;
import java.awt.HeadlessException;
import java.awt.MouseInfo;
import java.security.PrivilegedExceptionAction;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.LayoutManager2;
import java.beans.PropertyChangeEvent;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JLayeredPane;
import javax.swing.JFrame;
import java.awt.Rectangle;
import java.awt.GraphicsDevice;
import java.awt.Point;
import java.awt.GraphicsEnvironment;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentAdapter;
import javax.swing.JInternalFrame;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.HierarchyEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;
import java.awt.Component;
import javax.swing.LookAndFeel;
import javax.swing.plaf.ComponentUI;
import java.beans.PropertyChangeListener;
import java.awt.GraphicsConfiguration;
import java.awt.event.ComponentListener;
import java.awt.event.HierarchyListener;
import java.awt.event.WindowListener;
import javax.swing.JRootPane;
import java.awt.LayoutManager;
import javax.swing.event.MouseInputListener;
import javax.swing.JComponent;
import java.awt.Window;
import java.awt.Cursor;
import javax.swing.plaf.basic.BasicRootPaneUI;

public class DarculaRootPaneUI extends BasicRootPaneUI
{
    private Cursor myLastCursor;
    private static final int CORNER_DRAG_WIDTH = 16;
    private static final int BORDER_DRAG_THICKNESS = 5;
    private Window myWindow;
    private JComponent myTitlePane;
    private MouseInputListener myMouseInputListener;
    private MouseInputListener myTitleMouseInputListener;
    private LayoutManager myLayoutManager;
    private LayoutManager myOldLayout;
    protected JRootPane myRootPane;
    protected WindowListener myWindowListener;
    protected Window myCurrentWindow;
    protected HierarchyListener myHierarchyListener;
    protected ComponentListener myWindowComponentListener;
    protected GraphicsConfiguration currentRootPaneGC;
    protected PropertyChangeListener myPropertyChangeListener;
    private static final int[] cursorMapping;
    
    public static ComponentUI createUI(final JComponent comp) {
        return new DarculaRootPaneUI();
    }
    
    @Override
    public void installUI(final JComponent c) {
        super.installUI(c);
        this.myRootPane = (JRootPane)c;
        final int style = this.myRootPane.getWindowDecorationStyle();
        if (style != 0) {
            this.installClientDecorations(this.myRootPane);
        }
    }
    
    @Override
    public void uninstallUI(final JComponent c) {
        super.uninstallUI(c);
        this.uninstallClientDecorations(this.myRootPane);
        this.myLayoutManager = null;
        this.myMouseInputListener = null;
        this.myRootPane = null;
    }
    
    public void installBorder(final JRootPane root) {
        final int style = root.getWindowDecorationStyle();
        if (style == 0) {
            LookAndFeel.uninstallBorder(root);
        }
        else {
            LookAndFeel.installBorder(root, "RootPane.border");
        }
    }
    
    private static void uninstallBorder(final JRootPane root) {
        LookAndFeel.uninstallBorder(root);
    }
    
    private void installWindowListeners(final JRootPane root, final Component parent) {
        if (parent instanceof Window) {
            this.myWindow = (Window)parent;
        }
        else {
            this.myWindow = SwingUtilities.getWindowAncestor(parent);
        }
        if (this.myWindow != null) {
            if (this.myMouseInputListener == null) {
                this.myMouseInputListener = this.createWindowMouseInputListener(root);
            }
            this.myWindow.addMouseListener(this.myMouseInputListener);
            this.myWindow.addMouseMotionListener(this.myMouseInputListener);
            if (this.myTitlePane != null) {
                if (this.myTitleMouseInputListener == null) {
                    this.myTitleMouseInputListener = new TitleMouseInputHandler();
                }
                this.myTitlePane.addMouseMotionListener(this.myTitleMouseInputListener);
                this.myTitlePane.addMouseListener(this.myTitleMouseInputListener);
            }
            this.setMaximized();
        }
    }
    
    private void uninstallWindowListeners(final JRootPane root) {
        if (this.myWindow != null) {
            this.myWindow.removeMouseListener(this.myMouseInputListener);
            this.myWindow.removeMouseMotionListener(this.myMouseInputListener);
        }
        if (this.myTitlePane != null) {
            this.myTitlePane.removeMouseListener(this.myTitleMouseInputListener);
            this.myTitlePane.removeMouseMotionListener(this.myTitleMouseInputListener);
        }
    }
    
    private void installLayout(final JRootPane root) {
        if (this.myLayoutManager == null) {
            this.myLayoutManager = this.createLayoutManager();
        }
        this.myOldLayout = root.getLayout();
        root.setLayout(this.myLayoutManager);
    }
    
    @Override
    protected void installListeners(final JRootPane root) {
        super.installListeners(root);
        root.addHierarchyListener(this.myHierarchyListener = new HierarchyListener() {
            @Override
            public void hierarchyChanged(final HierarchyEvent e) {
                final Component parent = root.getParent();
                if (parent == null) {
                    return;
                }
                if (parent.getClass().getName().startsWith("org.jdesktop.jdic.tray") || parent.getClass().getName().compareTo("javax.swing.Popup$HeavyWeightWindow") == 0) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            root.removeHierarchyListener(DarculaRootPaneUI.this.myHierarchyListener);
                            DarculaRootPaneUI.this.myHierarchyListener = null;
                        }
                    });
                }
                Window currWindow;
                if (parent instanceof Window) {
                    currWindow = (Window)parent;
                }
                else {
                    currWindow = SwingUtilities.getWindowAncestor(parent);
                }
                if (DarculaRootPaneUI.this.myWindowListener != null) {
                    DarculaRootPaneUI.this.myCurrentWindow.removeWindowListener(DarculaRootPaneUI.this.myWindowListener);
                    DarculaRootPaneUI.this.myWindowListener = null;
                }
                if (DarculaRootPaneUI.this.myWindowComponentListener != null) {
                    DarculaRootPaneUI.this.myCurrentWindow.removeComponentListener(DarculaRootPaneUI.this.myWindowComponentListener);
                    DarculaRootPaneUI.this.myWindowComponentListener = null;
                }
                if (currWindow != null) {
                    DarculaRootPaneUI.this.myWindowListener = new WindowAdapter() {
                        @Override
                        public void windowClosed(final WindowEvent e) {
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    final Frame[] frames2;
                                    final Frame[] frames = frames2 = Frame.getFrames();
                                    for (final Frame frame : frames2) {
                                        if (frame.isDisplayable()) {
                                            return;
                                        }
                                    }
                                }
                            });
                        }
                    };
                    if (!(parent instanceof JInternalFrame)) {
                        currWindow.addWindowListener(DarculaRootPaneUI.this.myWindowListener);
                    }
                    DarculaRootPaneUI.this.myWindowComponentListener = new ComponentAdapter() {
                        @Override
                        public void componentMoved(final ComponentEvent e) {
                            this.processNewPosition();
                        }
                        
                        @Override
                        public void componentResized(final ComponentEvent e) {
                            this.processNewPosition();
                        }
                        
                        private void processNewPosition() {
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    if (DarculaRootPaneUI.this.myWindow == null) {
                                        return;
                                    }
                                    if (!DarculaRootPaneUI.this.myWindow.isShowing() || !DarculaRootPaneUI.this.myWindow.isDisplayable()) {
                                        DarculaRootPaneUI.this.currentRootPaneGC = null;
                                        return;
                                    }
                                    final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                                    final GraphicsDevice[] gds = ge.getScreenDevices();
                                    if (gds.length == 1) {
                                        return;
                                    }
                                    final Point midLoc = new Point(DarculaRootPaneUI.this.myWindow.getLocationOnScreen().x + DarculaRootPaneUI.this.myWindow.getWidth() / 2, DarculaRootPaneUI.this.myWindow.getLocationOnScreen().y + DarculaRootPaneUI.this.myWindow.getHeight() / 2);
                                    final GraphicsDevice[] array = gds;
                                    final int length = array.length;
                                    int i = 0;
                                    while (i < length) {
                                        final GraphicsDevice gd = array[i];
                                        final GraphicsConfiguration gc = gd.getDefaultConfiguration();
                                        final Rectangle bounds = gc.getBounds();
                                        if (bounds.contains(midLoc)) {
                                            if (gc != DarculaRootPaneUI.this.currentRootPaneGC) {
                                                DarculaRootPaneUI.this.currentRootPaneGC = gc;
                                                DarculaRootPaneUI.this.setMaximized();
                                                break;
                                            }
                                            break;
                                        }
                                        else {
                                            ++i;
                                        }
                                    }
                                }
                            });
                        }
                    };
                    if (parent instanceof JFrame) {
                        currWindow.addComponentListener(DarculaRootPaneUI.this.myWindowComponentListener);
                    }
                    DarculaRootPaneUI.this.myWindow = currWindow;
                }
                DarculaRootPaneUI.this.myCurrentWindow = currWindow;
            }
        });
        root.addPropertyChangeListener(this.myPropertyChangeListener);
    }
    
    @Override
    protected void uninstallListeners(final JRootPane root) {
        if (this.myWindow != null) {
            this.myWindow.removeWindowListener(this.myWindowListener);
            this.myWindowListener = null;
            this.myWindow.removeComponentListener(this.myWindowComponentListener);
            this.myWindowComponentListener = null;
        }
        root.removeHierarchyListener(this.myHierarchyListener);
        this.myHierarchyListener = null;
        root.removePropertyChangeListener(this.myPropertyChangeListener);
        this.myPropertyChangeListener = null;
        super.uninstallListeners(root);
    }
    
    private void uninstallLayout(final JRootPane root) {
        if (this.myOldLayout != null) {
            root.setLayout(this.myOldLayout);
            this.myOldLayout = null;
        }
    }
    
    private void installClientDecorations(final JRootPane root) {
        this.installBorder(root);
        final JComponent titlePane = this.createTitlePane(root);
        this.setTitlePane(root, titlePane);
        this.installWindowListeners(root, root.getParent());
        this.installLayout(root);
        if (this.myWindow != null) {
            root.revalidate();
            root.repaint();
        }
    }
    
    private void uninstallClientDecorations(final JRootPane root) {
        uninstallBorder(root);
        this.uninstallWindowListeners(root);
        this.setTitlePane(root, null);
        this.uninstallLayout(root);
        final int style = root.getWindowDecorationStyle();
        if (style == 0) {
            root.repaint();
            root.revalidate();
        }
        if (this.myWindow != null) {
            this.myWindow.setCursor(Cursor.getPredefinedCursor(0));
        }
        this.myWindow = null;
    }
    
    protected JComponent createTitlePane(final JRootPane root) {
        return new DarculaTitlePane(root, this);
    }
    
    private MouseInputListener createWindowMouseInputListener(final JRootPane root) {
        return new MouseInputHandler();
    }
    
    protected LayoutManager createLayoutManager() {
        return new SubstanceRootLayout();
    }
    
    private void setTitlePane(final JRootPane root, final JComponent titlePane) {
        final JLayeredPane layeredPane = root.getLayeredPane();
        final JComponent oldTitlePane = this.getTitlePane();
        if (oldTitlePane != null) {
            layeredPane.remove(oldTitlePane);
        }
        if (titlePane != null) {
            layeredPane.add(titlePane, JLayeredPane.FRAME_CONTENT_LAYER);
            titlePane.setVisible(true);
        }
        this.myTitlePane = titlePane;
    }
    
    public void setMaximized() {
        final Component tla = this.myRootPane.getTopLevelAncestor();
        final GraphicsConfiguration gc = (this.currentRootPaneGC != null) ? this.currentRootPaneGC : tla.getGraphicsConfiguration();
        final Rectangle screenBounds = gc.getBounds();
        screenBounds.x = 0;
        screenBounds.y = 0;
        final Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(gc);
        final Rectangle maxBounds = new Rectangle(screenBounds.x + screenInsets.left, screenBounds.y + screenInsets.top, screenBounds.width - (screenInsets.left + screenInsets.right), screenBounds.height - (screenInsets.top + screenInsets.bottom));
        if (tla instanceof JFrame) {
            ((JFrame)tla).setMaximizedBounds(maxBounds);
        }
    }
    
    public JComponent getTitlePane() {
        return this.myTitlePane;
    }
    
    protected JRootPane getRootPane() {
        return this.myRootPane;
    }
    
    @Override
    public void propertyChange(final PropertyChangeEvent e) {
        super.propertyChange(e);
        final String propertyName = e.getPropertyName();
        if (propertyName == null) {
            return;
        }
        if (propertyName.equals("windowDecorationStyle")) {
            final JRootPane root = (JRootPane)e.getSource();
            final int style = root.getWindowDecorationStyle();
            this.uninstallClientDecorations(root);
            if (style != 0) {
                this.installClientDecorations(root);
            }
        }
        if (propertyName.equals("ancestor")) {
            this.uninstallWindowListeners(this.myRootPane);
            if (((JRootPane)e.getSource()).getWindowDecorationStyle() != 0) {
                this.installWindowListeners(this.myRootPane, this.myRootPane.getParent());
            }
        }
    }
    
    static {
        cursorMapping = new int[] { 6, 6, 8, 7, 7, 6, 0, 0, 0, 7, 10, 0, 0, 0, 11, 4, 0, 0, 0, 5, 4, 4, 9, 5, 5 };
    }
    
    private enum CursorState
    {
        EXITED, 
        ENTERED, 
        NIL;
    }
    
    protected class SubstanceRootLayout implements LayoutManager2
    {
        @Override
        public Dimension preferredLayoutSize(final Container parent) {
            int cpWidth = 0;
            int cpHeight = 0;
            int mbWidth = 0;
            int mbHeight = 0;
            int tpWidth = 0;
            int tpHeight = 0;
            final Insets i = parent.getInsets();
            final JRootPane root = (JRootPane)parent;
            Dimension cpd;
            if (root.getContentPane() != null) {
                cpd = root.getContentPane().getPreferredSize();
            }
            else {
                cpd = root.getSize();
            }
            if (cpd != null) {
                cpWidth = cpd.width;
                cpHeight = cpd.height;
            }
            if (root.getJMenuBar() != null) {
                final Dimension mbd = root.getJMenuBar().getPreferredSize();
                if (mbd != null) {
                    mbWidth = mbd.width;
                    mbHeight = mbd.height;
                }
            }
            if (root.getWindowDecorationStyle() != 0 && root.getUI() instanceof DarculaRootPaneUI) {
                final JComponent titlePane = ((DarculaRootPaneUI)root.getUI()).getTitlePane();
                if (titlePane != null) {
                    final Dimension tpd = titlePane.getPreferredSize();
                    if (tpd != null) {
                        tpWidth = tpd.width;
                        tpHeight = tpd.height;
                    }
                }
            }
            return new Dimension(Math.max(Math.max(cpWidth, mbWidth), tpWidth) + i.left + i.right, cpHeight + mbHeight + tpHeight + i.top + i.bottom);
        }
        
        @Override
        public Dimension minimumLayoutSize(final Container parent) {
            int cpWidth = 0;
            int cpHeight = 0;
            int mbWidth = 0;
            int mbHeight = 0;
            int tpWidth = 0;
            int tpHeight = 0;
            final Insets i = parent.getInsets();
            final JRootPane root = (JRootPane)parent;
            Dimension cpd;
            if (root.getContentPane() != null) {
                cpd = root.getContentPane().getMinimumSize();
            }
            else {
                cpd = root.getSize();
            }
            if (cpd != null) {
                cpWidth = cpd.width;
                cpHeight = cpd.height;
            }
            if (root.getJMenuBar() != null) {
                final Dimension mbd = root.getJMenuBar().getMinimumSize();
                if (mbd != null) {
                    mbWidth = mbd.width;
                    mbHeight = mbd.height;
                }
            }
            if (root.getWindowDecorationStyle() != 0 && root.getUI() instanceof DarculaRootPaneUI) {
                final JComponent titlePane = ((DarculaRootPaneUI)root.getUI()).getTitlePane();
                if (titlePane != null) {
                    final Dimension tpd = titlePane.getMinimumSize();
                    if (tpd != null) {
                        tpWidth = tpd.width;
                        tpHeight = tpd.height;
                    }
                }
            }
            return new Dimension(Math.max(Math.max(cpWidth, mbWidth), tpWidth) + i.left + i.right, cpHeight + mbHeight + tpHeight + i.top + i.bottom);
        }
        
        @Override
        public Dimension maximumLayoutSize(final Container target) {
            int cpWidth = Integer.MAX_VALUE;
            int cpHeight = Integer.MAX_VALUE;
            int mbWidth = Integer.MAX_VALUE;
            int mbHeight = Integer.MAX_VALUE;
            int tpWidth = Integer.MAX_VALUE;
            int tpHeight = Integer.MAX_VALUE;
            final Insets i = target.getInsets();
            final JRootPane root = (JRootPane)target;
            if (root.getContentPane() != null) {
                final Dimension cpd = root.getContentPane().getMaximumSize();
                if (cpd != null) {
                    cpWidth = cpd.width;
                    cpHeight = cpd.height;
                }
            }
            if (root.getJMenuBar() != null) {
                final Dimension mbd = root.getJMenuBar().getMaximumSize();
                if (mbd != null) {
                    mbWidth = mbd.width;
                    mbHeight = mbd.height;
                }
            }
            if (root.getWindowDecorationStyle() != 0 && root.getUI() instanceof DarculaRootPaneUI) {
                final JComponent titlePane = ((DarculaRootPaneUI)root.getUI()).getTitlePane();
                if (titlePane != null) {
                    final Dimension tpd = titlePane.getMaximumSize();
                    if (tpd != null) {
                        tpWidth = tpd.width;
                        tpHeight = tpd.height;
                    }
                }
            }
            int maxHeight = Math.max(Math.max(cpHeight, mbHeight), tpHeight);
            if (maxHeight != Integer.MAX_VALUE) {
                maxHeight = cpHeight + mbHeight + tpHeight + i.top + i.bottom;
            }
            int maxWidth = Math.max(Math.max(cpWidth, mbWidth), tpWidth);
            if (maxWidth != Integer.MAX_VALUE) {
                maxWidth += i.left + i.right;
            }
            return new Dimension(maxWidth, maxHeight);
        }
        
        @Override
        public void layoutContainer(final Container parent) {
            final JRootPane root = (JRootPane)parent;
            final Rectangle b = root.getBounds();
            final Insets i = root.getInsets();
            int nextY = 0;
            final int w = b.width - i.right - i.left;
            final int h = b.height - i.top - i.bottom;
            if (root.getLayeredPane() != null) {
                root.getLayeredPane().setBounds(i.left, i.top, w, h);
            }
            if (root.getGlassPane() != null) {
                root.getGlassPane().setBounds(i.left, i.top, w, h);
            }
            if (root.getWindowDecorationStyle() != 0 && root.getUI() instanceof DarculaRootPaneUI) {
                final JComponent titlePane = ((DarculaRootPaneUI)root.getUI()).getTitlePane();
                if (titlePane != null) {
                    final Dimension tpd = titlePane.getPreferredSize();
                    if (tpd != null) {
                        final int tpHeight = tpd.height;
                        titlePane.setBounds(0, 0, w, tpHeight);
                        nextY += tpHeight;
                    }
                }
            }
            if (root.getJMenuBar() != null) {
                final Dimension mbd = root.getJMenuBar().getPreferredSize();
                root.getJMenuBar().setBounds(0, nextY, w, mbd.height);
                nextY += mbd.height;
            }
            if (root.getContentPane() != null) {
                root.getContentPane().setBounds(0, nextY, w, (h < nextY) ? 0 : (h - nextY));
            }
        }
        
        @Override
        public void addLayoutComponent(final String name, final Component comp) {
        }
        
        @Override
        public void removeLayoutComponent(final Component comp) {
        }
        
        @Override
        public void addLayoutComponent(final Component comp, final Object constraints) {
        }
        
        @Override
        public float getLayoutAlignmentX(final Container target) {
            return 0.0f;
        }
        
        @Override
        public float getLayoutAlignmentY(final Container target) {
            return 0.0f;
        }
        
        @Override
        public void invalidateLayout(final Container target) {
        }
    }
    
    private class MouseInputHandler implements MouseInputListener
    {
        private boolean isMovingWindow;
        private int dragCursor;
        private int dragOffsetX;
        private int dragOffsetY;
        private int dragWidth;
        private int dragHeight;
        private final PrivilegedExceptionAction getLocationAction;
        private CursorState cursorState;
        
        private MouseInputHandler() {
            this.getLocationAction = new PrivilegedExceptionAction() {
                @Override
                public Object run() throws HeadlessException {
                    return MouseInfo.getPointerInfo().getLocation();
                }
            };
            this.cursorState = CursorState.NIL;
        }
        
        @Override
        public void mousePressed(final MouseEvent ev) {
            final JRootPane rootPane = DarculaRootPaneUI.this.getRootPane();
            if (rootPane.getWindowDecorationStyle() == 0) {
                return;
            }
            final Point dragWindowOffset = ev.getPoint();
            final Window w = (Window)ev.getSource();
            if (w != null) {
                w.toFront();
            }
            final Point convertedDragWindowOffset = SwingUtilities.convertPoint(w, dragWindowOffset, DarculaRootPaneUI.this.getTitlePane());
            Frame f = null;
            Dialog d = null;
            if (w instanceof Frame) {
                f = (Frame)w;
            }
            else if (w instanceof Dialog) {
                d = (Dialog)w;
            }
            final int frameState = (f != null) ? f.getExtendedState() : 0;
            if (DarculaRootPaneUI.this.getTitlePane() != null && DarculaRootPaneUI.this.getTitlePane().contains(convertedDragWindowOffset)) {
                if (((f != null && (frameState & 0x6) == 0x0) || d != null) && dragWindowOffset.y >= 5 && dragWindowOffset.x >= 5 && dragWindowOffset.x < w.getWidth() - 5) {
                    this.isMovingWindow = true;
                    this.dragOffsetX = dragWindowOffset.x;
                    this.dragOffsetY = dragWindowOffset.y;
                }
            }
            else if ((f != null && f.isResizable() && (frameState & 0x6) == 0x0) || (d != null && d.isResizable())) {
                this.dragOffsetX = dragWindowOffset.x;
                this.dragOffsetY = dragWindowOffset.y;
                this.dragWidth = w.getWidth();
                this.dragHeight = w.getHeight();
                this.dragCursor = this.getCursor(this.calculateCorner(w, dragWindowOffset.x, dragWindowOffset.y));
            }
        }
        
        @Override
        public void mouseReleased(final MouseEvent ev) {
            if (this.dragCursor != 0 && DarculaRootPaneUI.this.myWindow != null && !DarculaRootPaneUI.this.myWindow.isValid()) {
                DarculaRootPaneUI.this.myWindow.validate();
                DarculaRootPaneUI.this.getRootPane().repaint();
            }
            this.isMovingWindow = false;
            this.dragCursor = 0;
        }
        
        @Override
        public void mouseMoved(final MouseEvent ev) {
            final JRootPane root = DarculaRootPaneUI.this.getRootPane();
            if (root.getWindowDecorationStyle() == 0) {
                return;
            }
            final Window w = (Window)ev.getSource();
            Frame f = null;
            Dialog d = null;
            if (w instanceof Frame) {
                f = (Frame)w;
            }
            else if (w instanceof Dialog) {
                d = (Dialog)w;
            }
            final int cursor = this.getCursor(this.calculateCorner(w, ev.getX(), ev.getY()));
            if (cursor != 0 && ((f != null && f.isResizable() && (f.getExtendedState() & 0x6) == 0x0) || (d != null && d.isResizable()))) {
                w.setCursor(Cursor.getPredefinedCursor(cursor));
            }
            else {
                w.setCursor(DarculaRootPaneUI.this.myLastCursor);
            }
        }
        
        private void adjust(final Rectangle bounds, final Dimension min, final int deltaX, final int deltaY, final int deltaWidth, final int deltaHeight) {
            bounds.x += deltaX;
            bounds.y += deltaY;
            bounds.width += deltaWidth;
            bounds.height += deltaHeight;
            if (min != null) {
                if (bounds.width < min.width) {
                    final int correction = min.width - bounds.width;
                    if (deltaX != 0) {
                        bounds.x -= correction;
                    }
                    bounds.width = min.width;
                }
                if (bounds.height < min.height) {
                    final int correction = min.height - bounds.height;
                    if (deltaY != 0) {
                        bounds.y -= correction;
                    }
                    bounds.height = min.height;
                }
            }
        }
        
        @Override
        public void mouseDragged(final MouseEvent ev) {
            final Window w = (Window)ev.getSource();
            final Point pt = ev.getPoint();
            if (this.isMovingWindow) {
                try {
                    final Point windowPt = AccessController.doPrivileged((PrivilegedExceptionAction<Point>)this.getLocationAction);
                    windowPt.x -= this.dragOffsetX;
                    windowPt.y -= this.dragOffsetY;
                    w.setLocation(windowPt);
                }
                catch (PrivilegedActionException ex) {}
            }
            else if (this.dragCursor != 0) {
                final Rectangle r = w.getBounds();
                final Rectangle startBounds = new Rectangle(r);
                final Dimension min = w.getMinimumSize();
                switch (this.dragCursor) {
                    case 11: {
                        this.adjust(r, min, 0, 0, pt.x + (this.dragWidth - this.dragOffsetX) - r.width, 0);
                        break;
                    }
                    case 9: {
                        this.adjust(r, min, 0, 0, 0, pt.y + (this.dragHeight - this.dragOffsetY) - r.height);
                        break;
                    }
                    case 8: {
                        this.adjust(r, min, 0, pt.y - this.dragOffsetY, 0, -(pt.y - this.dragOffsetY));
                        break;
                    }
                    case 10: {
                        this.adjust(r, min, pt.x - this.dragOffsetX, 0, -(pt.x - this.dragOffsetX), 0);
                        break;
                    }
                    case 7: {
                        this.adjust(r, min, 0, pt.y - this.dragOffsetY, pt.x + (this.dragWidth - this.dragOffsetX) - r.width, -(pt.y - this.dragOffsetY));
                        break;
                    }
                    case 5: {
                        this.adjust(r, min, 0, 0, pt.x + (this.dragWidth - this.dragOffsetX) - r.width, pt.y + (this.dragHeight - this.dragOffsetY) - r.height);
                        break;
                    }
                    case 6: {
                        this.adjust(r, min, pt.x - this.dragOffsetX, pt.y - this.dragOffsetY, -(pt.x - this.dragOffsetX), -(pt.y - this.dragOffsetY));
                        break;
                    }
                    case 4: {
                        this.adjust(r, min, pt.x - this.dragOffsetX, 0, -(pt.x - this.dragOffsetX), pt.y + (this.dragHeight - this.dragOffsetY) - r.height);
                        break;
                    }
                }
                if (!r.equals(startBounds)) {
                    w.setBounds(r);
                    if (Toolkit.getDefaultToolkit().isDynamicLayoutActive()) {
                        w.validate();
                        DarculaRootPaneUI.this.getRootPane().repaint();
                    }
                }
            }
        }
        
        @Override
        public void mouseEntered(final MouseEvent ev) {
            final Window w = (Window)ev.getSource();
            if (this.cursorState == CursorState.EXITED || this.cursorState == CursorState.NIL) {
                DarculaRootPaneUI.this.myLastCursor = w.getCursor();
            }
            this.cursorState = CursorState.ENTERED;
            this.mouseMoved(ev);
        }
        
        @Override
        public void mouseExited(final MouseEvent ev) {
            final Window w = (Window)ev.getSource();
            w.setCursor(DarculaRootPaneUI.this.myLastCursor);
            this.cursorState = CursorState.EXITED;
        }
        
        @Override
        public void mouseClicked(final MouseEvent ev) {
            final Window w = (Window)ev.getSource();
            if (!(w instanceof Frame)) {
                return;
            }
            final Frame f = (Frame)w;
            final JComponent windowTitlePane = DarculaRootPaneUI.this.getTitlePane();
            if (windowTitlePane == null) {
                return;
            }
            final Point convertedPoint = SwingUtilities.convertPoint(w, ev.getPoint(), windowTitlePane);
            final int state = f.getExtendedState();
            if (windowTitlePane.contains(convertedPoint) && ev.getClickCount() % 2 == 0 && (ev.getModifiers() & 0x10) != 0x0 && f.isResizable()) {
                if ((state & 0x6) != 0x0) {
                    DarculaRootPaneUI.this.setMaximized();
                    f.setExtendedState(state & 0xFFFFFFF9);
                }
                else {
                    DarculaRootPaneUI.this.setMaximized();
                    f.setExtendedState(state | 0x6);
                }
            }
        }
        
        private int calculateCorner(final Window w, final int x, final int y) {
            final Insets insets = w.getInsets();
            final int xPosition = this.calculatePosition(x - insets.left, w.getWidth() - insets.left - insets.right);
            final int yPosition = this.calculatePosition(y - insets.top, w.getHeight() - insets.top - insets.bottom);
            if (xPosition == -1 || yPosition == -1) {
                return -1;
            }
            return yPosition * 5 + xPosition;
        }
        
        private int getCursor(final int corner) {
            if (corner == -1) {
                return 0;
            }
            return DarculaRootPaneUI.cursorMapping[corner];
        }
        
        private int calculatePosition(final int spot, final int width) {
            if (spot < 5) {
                return 0;
            }
            if (spot < 16) {
                return 1;
            }
            if (spot >= width - 5) {
                return 4;
            }
            if (spot >= width - 16) {
                return 3;
            }
            return 2;
        }
    }
    
    private class TitleMouseInputHandler extends MouseInputAdapter
    {
        private Point dragOffset;
        
        private TitleMouseInputHandler() {
            this.dragOffset = new Point(0, 0);
        }
        
        @Override
        public void mousePressed(final MouseEvent ev) {
            final JRootPane rootPane = DarculaRootPaneUI.this.getRootPane();
            if (rootPane.getWindowDecorationStyle() == 0) {
                return;
            }
            Point dragWindowOffset = ev.getPoint();
            final Component source = (Component)ev.getSource();
            final Point convertedDragWindowOffset = SwingUtilities.convertPoint(source, dragWindowOffset, DarculaRootPaneUI.this.getTitlePane());
            dragWindowOffset = SwingUtilities.convertPoint(source, dragWindowOffset, DarculaRootPaneUI.this.myWindow);
            if (DarculaRootPaneUI.this.getTitlePane() != null && DarculaRootPaneUI.this.getTitlePane().contains(convertedDragWindowOffset) && DarculaRootPaneUI.this.myWindow != null) {
                DarculaRootPaneUI.this.myWindow.toFront();
                this.dragOffset = dragWindowOffset;
            }
        }
        
        @Override
        public void mouseDragged(final MouseEvent ev) {
            final Component source = (Component)ev.getSource();
            Point eventLocationOnScreen = ev.getLocationOnScreen();
            if (eventLocationOnScreen == null) {
                eventLocationOnScreen = new Point(ev.getX() + source.getLocationOnScreen().x, ev.getY() + source.getLocationOnScreen().y);
            }
            if (DarculaRootPaneUI.this.myWindow instanceof Frame) {
                final Frame f = (Frame)DarculaRootPaneUI.this.myWindow;
                final int frameState = f.getExtendedState();
                if ((frameState & 0x6) == 0x0) {
                    DarculaRootPaneUI.this.myWindow.setLocation(eventLocationOnScreen.x - this.dragOffset.x, eventLocationOnScreen.y - this.dragOffset.y);
                }
            }
            else {
                DarculaRootPaneUI.this.myWindow.setLocation(eventLocationOnScreen.x - this.dragOffset.x, eventLocationOnScreen.y - this.dragOffset.y);
            }
        }
        
        @Override
        public void mouseClicked(final MouseEvent e) {
            if (DarculaRootPaneUI.this.myWindow instanceof Frame) {
                final Frame f = (Frame)DarculaRootPaneUI.this.myWindow;
                final Point convertedPoint = SwingUtilities.convertPoint(DarculaRootPaneUI.this.myWindow, e.getPoint(), DarculaRootPaneUI.this.getTitlePane());
                final int state = f.getExtendedState();
                if (DarculaRootPaneUI.this.getTitlePane() != null && DarculaRootPaneUI.this.getTitlePane().contains(convertedPoint) && e.getClickCount() % 2 == 0 && (e.getModifiers() & 0x10) != 0x0 && f.isResizable()) {
                    if ((state & 0x6) != 0x0) {
                        DarculaRootPaneUI.this.setMaximized();
                        f.setExtendedState(state & 0xFFFFFFF9);
                    }
                    else {
                        DarculaRootPaneUI.this.setMaximized();
                        f.setExtendedState(state | 0x6);
                    }
                }
            }
        }
    }
}
