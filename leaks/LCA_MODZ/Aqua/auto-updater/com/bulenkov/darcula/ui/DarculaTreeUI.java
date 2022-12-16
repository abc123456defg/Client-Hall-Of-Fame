// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.ui;

import javax.swing.plaf.UIResource;
import javax.swing.AbstractAction;
import com.bulenkov.darcula.DarculaUIUtil;
import java.awt.Container;
import javax.swing.CellRendererPane;
import java.awt.Component;
import java.awt.Shape;
import java.awt.Graphics2D;
import javax.swing.JViewport;
import com.bulenkov.iconloader.util.UIUtil;
import java.awt.Color;
import com.bulenkov.iconloader.util.SystemInfo;
import java.awt.Insets;
import java.awt.Graphics;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.awt.Rectangle;
import javax.swing.tree.TreePath;
import javax.swing.SwingUtilities;
import javax.swing.JTree;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicTreeUI;

public class DarculaTreeUI extends BasicTreeUI
{
    public static final String TREE_TABLE_TREE_KEY = "TreeTableTree";
    public static final String SOURCE_LIST_CLIENT_PROPERTY = "mac.ui.source.list";
    public static final String STRIPED_CLIENT_PROPERTY = "mac.ui.striped";
    private static final Border LIST_BACKGROUND_PAINTER;
    private static final Border LIST_SELECTION_BACKGROUND_PAINTER;
    private static final Border LIST_FOCUSED_SELECTION_BACKGROUND_PAINTER;
    private boolean myOldRepaintAllRowValue;
    private boolean invertLineColor;
    private boolean myForceDontPaintLines;
    private final MouseListener mySelectionListener;
    
    public DarculaTreeUI() {
        this.myForceDontPaintLines = false;
        this.mySelectionListener = new MouseAdapter() {
            boolean handled = false;
            
            @Override
            public void mousePressed(final MouseEvent e) {
                this.handled = false;
                if (!this.isSelected(e)) {
                    this.handled = true;
                    this.handle(e);
                }
            }
            
            @Override
            public void mouseReleased(final MouseEvent e) {
                if (!this.handled) {
                    this.handle(e);
                }
            }
            
            private boolean isSelected(final MouseEvent e) {
                final JTree tree = (JTree)e.getSource();
                final int selected = tree.getClosestRowForLocation(e.getX(), e.getY());
                final int[] rows = tree.getSelectionRows();
                if (rows != null) {
                    for (final int row : rows) {
                        if (row == selected) {
                            return true;
                        }
                    }
                }
                return false;
            }
            
            private void handle(final MouseEvent e) {
                final JTree tree = (JTree)e.getSource();
                if (SwingUtilities.isLeftMouseButton(e) && !e.isPopupTrigger()) {
                    if (DarculaTreeUI.this.isEditing(tree) && tree.getInvokesStopCellEditing() && !DarculaTreeUI.this.stopEditing(tree)) {
                        return;
                    }
                    final TreePath pressedPath = DarculaTreeUI.this.getClosestPathForLocation(tree, e.getX(), e.getY());
                    if (pressedPath != null) {
                        final Rectangle bounds = DarculaTreeUI.this.getPathBounds(tree, pressedPath);
                        if (e.getY() >= bounds.y + bounds.height) {
                            return;
                        }
                        if (bounds.contains(e.getPoint()) || BasicTreeUI.this.isLocationInExpandControl(pressedPath, e.getX(), e.getY())) {
                            return;
                        }
                        if (tree.getDragEnabled() || !BasicTreeUI.this.startEditing(pressedPath, e)) {
                            BasicTreeUI.this.selectPathForEvent(pressedPath, e);
                        }
                    }
                }
            }
        };
    }
    
    public static ComponentUI createUI(final JComponent c) {
        return new DarculaTreeUI();
    }
    
    @Override
    public int getRightChildIndent() {
        return isSkinny() ? 8 : super.getRightChildIndent();
    }
    
    private static boolean isSkinny() {
        return true;
    }
    
    @Override
    protected void completeUIInstall() {
        super.completeUIInstall();
        this.myOldRepaintAllRowValue = UIManager.getBoolean("Tree.repaintWholeRow");
        UIManager.put("Tree.repaintWholeRow", true);
        this.tree.setShowsRootHandles(true);
        this.tree.addMouseListener(this.mySelectionListener);
    }
    
    @Override
    public void uninstallUI(final JComponent c) {
        super.uninstallUI(c);
        UIManager.put("Tree.repaintWholeRow", this.myOldRepaintAllRowValue);
        c.removeMouseListener(this.mySelectionListener);
    }
    
    @Override
    protected void installKeyboardActions() {
        super.installKeyboardActions();
        if (Boolean.TRUE.equals(this.tree.getClientProperty("MacTreeUi.actionsInstalled"))) {
            return;
        }
        this.tree.putClientProperty("MacTreeUi.actionsInstalled", Boolean.TRUE);
        final InputMap inputMap = this.tree.getInputMap(0);
        inputMap.put(KeyStroke.getKeyStroke("pressed LEFT"), "collapse_or_move_up");
        inputMap.put(KeyStroke.getKeyStroke("pressed RIGHT"), "expand");
        final ActionMap actionMap = this.tree.getActionMap();
        final Action expandAction = actionMap.get("expand");
        if (expandAction != null) {
            actionMap.put("expand", new TreeUIAction() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    final Object source = e.getSource();
                    if (source instanceof JTree) {
                        final JTree tree = (JTree)source;
                        final int selectionRow = tree.getLeadSelectionRow();
                        if (selectionRow != -1) {
                            final TreePath selectionPath = tree.getPathForRow(selectionRow);
                            if (selectionPath != null) {
                                final boolean leaf = tree.getModel().isLeaf(selectionPath.getLastPathComponent());
                                int toSelect = -1;
                                int toScroll = -1;
                                if (!leaf && tree.isExpanded(selectionRow)) {
                                    if (selectionRow + 1 < tree.getRowCount()) {
                                        toSelect = (toScroll = selectionRow + 1);
                                    }
                                }
                                else if (leaf) {
                                    toScroll = selectionRow;
                                }
                                if (toSelect != -1) {
                                    tree.setSelectionInterval(toSelect, toSelect);
                                }
                                if (toScroll != -1) {
                                    tree.scrollRowToVisible(toScroll);
                                }
                                if (toSelect != -1 || toScroll != -1) {
                                    return;
                                }
                            }
                        }
                    }
                    expandAction.actionPerformed(e);
                }
            });
        }
        actionMap.put("collapse_or_move_up", new TreeUIAction() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final Object source = e.getSource();
                if (source instanceof JTree) {
                    final JTree tree = (JTree)source;
                    final int selectionRow = tree.getLeadSelectionRow();
                    if (selectionRow == -1) {
                        return;
                    }
                    final TreePath selectionPath = tree.getPathForRow(selectionRow);
                    if (selectionPath == null) {
                        return;
                    }
                    if (tree.getModel().isLeaf(selectionPath.getLastPathComponent()) || tree.isCollapsed(selectionRow)) {
                        final TreePath parentPath = tree.getPathForRow(selectionRow).getParentPath();
                        if (parentPath != null && (parentPath.getParentPath() != null || tree.isRootVisible())) {
                            final int parentRow = tree.getRowForPath(parentPath);
                            tree.scrollRowToVisible(parentRow);
                            tree.setSelectionInterval(parentRow, parentRow);
                        }
                    }
                    else {
                        tree.collapseRow(selectionRow);
                    }
                }
            }
        });
    }
    
    public void setForceDontPaintLines() {
        this.myForceDontPaintLines = true;
    }
    
    @Override
    protected int getRowX(final int row, final int depth) {
        return isSkinny() ? (8 * depth + 8) : super.getRowX(row, depth);
    }
    
    @Override
    protected void paintHorizontalPartOfLeg(final Graphics g, final Rectangle clipBounds, final Insets insets, final Rectangle bounds, final TreePath path, final int row, final boolean isExpanded, final boolean hasBeenExpanded, final boolean isLeaf) {
    }
    
    private boolean shouldPaintLines() {
        return this.myForceDontPaintLines || !"None".equals(this.tree.getClientProperty("JTree.lineStyle"));
    }
    
    @Override
    protected boolean isToggleSelectionEvent(final MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            if (SystemInfo.isMac) {
                if (!e.isMetaDown()) {
                    return false;
                }
            }
            else if (!e.isControlDown()) {
                return false;
            }
            if (!e.isPopupTrigger()) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    protected void paintVerticalPartOfLeg(final Graphics g, final Rectangle clipBounds, final Insets insets, final TreePath path) {
    }
    
    @Override
    protected void paintVerticalLine(final Graphics g, final JComponent c, final int x, final int top, final int bottom) {
    }
    
    @Override
    protected Color getHashColor() {
        if (this.invertLineColor && !equalsNullable(UIUtil.getTreeSelectionForeground(), UIUtil.getTreeForeground())) {
            final Color c = UIUtil.getTreeSelectionForeground();
            if (c != null) {
                return c.darker();
            }
        }
        return super.getHashColor();
    }
    
    private static <T> boolean equalsNullable(final T a, final T b) {
        if (a == null) {
            return b == null;
        }
        return b != null && a.equals(b);
    }
    
    @Override
    protected void paintRow(final Graphics g, final Rectangle clipBounds, final Insets insets, final Rectangle bounds, final TreePath path, final int row, final boolean isExpanded, final boolean hasBeenExpanded, final boolean isLeaf) {
        final int containerWidth = (this.tree.getParent() instanceof JViewport) ? this.tree.getParent().getWidth() : this.tree.getWidth();
        final int xOffset = (this.tree.getParent() instanceof JViewport) ? ((JViewport)this.tree.getParent()).getViewPosition().x : 0;
        if (path != null) {
            final boolean selected = this.tree.isPathSelected(path);
            final Graphics2D rowGraphics = (Graphics2D)g.create();
            rowGraphics.setClip(clipBounds);
            final Object sourceList = this.tree.getClientProperty("mac.ui.source.list");
            Color background = this.tree.getBackground();
            if (row % 2 == 0 && Boolean.TRUE.equals(this.tree.getClientProperty("mac.ui.striped"))) {
                background = UIUtil.getDecoratedRowColor();
            }
            if (sourceList != null && (boolean)sourceList) {
                if (selected) {
                    if (this.tree.hasFocus()) {
                        DarculaTreeUI.LIST_FOCUSED_SELECTION_BACKGROUND_PAINTER.paintBorder(this.tree, rowGraphics, xOffset, bounds.y, containerWidth, bounds.height);
                    }
                    else {
                        DarculaTreeUI.LIST_SELECTION_BACKGROUND_PAINTER.paintBorder(this.tree, rowGraphics, xOffset, bounds.y, containerWidth, bounds.height);
                    }
                }
                else {
                    rowGraphics.setColor(background);
                    rowGraphics.fillRect(xOffset, bounds.y, containerWidth, bounds.height);
                }
            }
            else if (selected) {
                final Color bg = UIUtil.getTreeSelectionBackground(this.tree.hasFocus() || Boolean.TRUE.equals(this.tree.getClientProperty("TreeTableTree")));
                rowGraphics.setColor(bg);
                rowGraphics.fillRect(xOffset, bounds.y, containerWidth, bounds.height);
            }
            if (this.shouldPaintExpandControl(path, row, isExpanded, hasBeenExpanded, isLeaf)) {
                this.paintExpandControl(rowGraphics, bounds, insets, bounds, path, row, isExpanded, hasBeenExpanded, isLeaf);
            }
            super.paintRow(rowGraphics, clipBounds, insets, bounds, path, row, isExpanded, hasBeenExpanded, isLeaf);
            rowGraphics.dispose();
        }
        else {
            super.paintRow(g, clipBounds, insets, bounds, path, row, isExpanded, hasBeenExpanded, isLeaf);
        }
    }
    
    @Override
    public void paint(final Graphics g, final JComponent c) {
        final int containerWidth = (this.tree.getParent() instanceof JViewport) ? this.tree.getParent().getWidth() : this.tree.getWidth();
        final int xOffset = (this.tree.getParent() instanceof JViewport) ? ((JViewport)this.tree.getParent()).getViewPosition().x : 0;
        final Rectangle bounds = g.getClipBounds();
        final Object sourceList = this.tree.getClientProperty("mac.ui.source.list");
        if (sourceList != null && (boolean)sourceList) {
            final Graphics2D backgroundGraphics = (Graphics2D)g.create();
            backgroundGraphics.setClip(xOffset, bounds.y, containerWidth, bounds.height);
            DarculaTreeUI.LIST_BACKGROUND_PAINTER.paintBorder(this.tree, backgroundGraphics, xOffset, bounds.y, containerWidth, bounds.height);
            backgroundGraphics.dispose();
        }
        super.paint(g, c);
    }
    
    protected void paintSelectedRows(final Graphics g, final JTree tr) {
        final Rectangle rect = tr.getVisibleRect();
        final int firstVisibleRow = tr.getClosestRowForLocation(rect.x, rect.y);
        for (int lastVisibleRow = tr.getClosestRowForLocation(rect.x, rect.y + rect.height), row = firstVisibleRow; row <= lastVisibleRow; ++row) {
            if (tr.getSelectionModel().isRowSelected(row)) {
                final Rectangle bounds = tr.getRowBounds(row);
                final Color color = UIUtil.getTreeSelectionBackground(tr.hasFocus());
                if (color != null) {
                    g.setColor(color);
                    g.fillRect(0, bounds.y, tr.getWidth(), bounds.height);
                }
            }
        }
    }
    
    @Override
    protected CellRendererPane createCellRendererPane() {
        return new CellRendererPane() {
            @Override
            public void paintComponent(final Graphics g, final Component c, final Container p, final int x, final int y, final int w, final int h, final boolean shouldValidate) {
                if (c instanceof JComponent) {
                    ((JComponent)c).setOpaque(false);
                }
                super.paintComponent(g, c, p, x, y, w, h, shouldValidate);
            }
        };
    }
    
    @Override
    protected void paintExpandControl(final Graphics g, final Rectangle clipBounds, final Insets insets, final Rectangle bounds, final TreePath path, final int row, final boolean isExpanded, final boolean hasBeenExpanded, final boolean isLeaf) {
        final boolean isPathSelected = this.tree.getSelectionModel().isPathSelected(path);
        if (!this.isLeaf(row)) {
            this.setExpandedIcon(DarculaUIUtil.getTreeNodeIcon(true, isPathSelected, this.tree.hasFocus()));
            this.setCollapsedIcon(DarculaUIUtil.getTreeNodeIcon(false, isPathSelected, this.tree.hasFocus()));
        }
        super.paintExpandControl(g, clipBounds, insets, bounds, path, row, isExpanded, hasBeenExpanded, isLeaf);
    }
    
    static {
        LIST_BACKGROUND_PAINTER = UIManager.getBorder("List.sourceListBackgroundPainter");
        LIST_SELECTION_BACKGROUND_PAINTER = UIManager.getBorder("List.sourceListSelectionBackgroundPainter");
        LIST_FOCUSED_SELECTION_BACKGROUND_PAINTER = UIManager.getBorder("List.sourceListFocusedSelectionBackgroundPainter");
    }
    
    private abstract static class TreeUIAction extends AbstractAction implements UIResource
    {
    }
}
