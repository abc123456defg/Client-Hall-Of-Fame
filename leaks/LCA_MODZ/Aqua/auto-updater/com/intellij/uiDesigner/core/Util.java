// 
// Decompiled by Procyon v0.5.36
// 

package com.intellij.uiDesigner.core;

import java.util.ArrayList;
import java.awt.Component;
import java.awt.Dimension;

public final class Util
{
    private static final Dimension MAX_SIZE;
    public static final int DEFAULT_INDENT = 10;
    
    public static Dimension getMinimumSize(final Component component, final GridConstraints constraints, final boolean addIndent) {
        try {
            final Dimension size = getSize(constraints.myMinimumSize, component.getMinimumSize());
            if (addIndent) {
                final Dimension dimension = size;
                dimension.width += 10 * constraints.getIndent();
            }
            return size;
        }
        catch (NullPointerException npe) {
            return new Dimension(0, 0);
        }
    }
    
    public static Dimension getMaximumSize(final Component component, final GridConstraints constraints, final boolean addIndent) {
        try {
            final Dimension size = getSize(constraints.myMaximumSize, Util.MAX_SIZE);
            if (addIndent && size.width < Util.MAX_SIZE.width) {
                final Dimension dimension = size;
                dimension.width += 10 * constraints.getIndent();
            }
            return size;
        }
        catch (NullPointerException e) {
            return new Dimension(0, 0);
        }
    }
    
    public static Dimension getPreferredSize(final Component component, final GridConstraints constraints, final boolean addIndent) {
        try {
            final Dimension size = getSize(constraints.myPreferredSize, component.getPreferredSize());
            if (addIndent) {
                final Dimension dimension = size;
                dimension.width += 10 * constraints.getIndent();
            }
            return size;
        }
        catch (NullPointerException e) {
            return new Dimension(0, 0);
        }
    }
    
    private static Dimension getSize(final Dimension overridenSize, final Dimension ownSize) {
        final int overridenWidth = (overridenSize.width >= 0) ? overridenSize.width : ownSize.width;
        final int overridenHeight = (overridenSize.height >= 0) ? overridenSize.height : ownSize.height;
        return new Dimension(overridenWidth, overridenHeight);
    }
    
    public static void adjustSize(final Component component, final GridConstraints constraints, final Dimension size) {
        final Dimension minimumSize = getMinimumSize(component, constraints, false);
        final Dimension maximumSize = getMaximumSize(component, constraints, false);
        size.width = Math.max(size.width, minimumSize.width);
        size.height = Math.max(size.height, minimumSize.height);
        size.width = Math.min(size.width, maximumSize.width);
        size.height = Math.min(size.height, maximumSize.height);
    }
    
    public static int eliminate(final int[] cellIndices, final int[] spans, final ArrayList elimitated) {
        final int size = cellIndices.length;
        if (size != spans.length) {
            throw new IllegalArgumentException("size mismatch: " + size + ", " + spans.length);
        }
        if (elimitated != null && elimitated.size()) {
            throw new IllegalArgumentException("eliminated must be empty");
        }
        int cellCount = 0;
        for (int i = 0; i < size; ++i) {
            cellCount = Math.max(cellCount, cellIndices[i] + spans[i]);
        }
        for (int cell = cellCount - 1; cell >= 0; --cell) {
            boolean starts = false;
            boolean ends = false;
            for (int j = 0; j < size; ++j) {
                if (cellIndices[j] == cell) {
                    starts = true;
                }
                if (cellIndices[j] + spans[j] - 1 == cell) {
                    ends = true;
                }
            }
            if (!starts || !ends) {
                if (elimitated != null) {
                    elimitated.add(new Integer(cell));
                }
                for (int j = 0; j < size; ++j) {
                    final boolean decreaseSpan = cellIndices[j] <= cell && cell < cellIndices[j] + spans[j];
                    final boolean decreaseIndex = cellIndices[j] > cell;
                    if (decreaseSpan) {
                        final int n = j;
                        --spans[n];
                    }
                    if (decreaseIndex) {
                        final int n2 = j;
                        --cellIndices[n2];
                    }
                }
                --cellCount;
            }
        }
        return cellCount;
    }
    
    static {
        MAX_SIZE = new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
}
