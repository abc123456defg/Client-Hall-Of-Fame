// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import java.util.HashMap;
import java.awt.Graphics;
import java.awt.Component;
import java.util.Map;
import javax.swing.Icon;

public class EmptyIcon implements Icon
{
    private static final Map<Integer, Icon> cache;
    private final int width;
    private final int height;
    
    public static Icon create(final int size) {
        Icon icon = EmptyIcon.cache.get(size);
        if (icon == null && size < 129) {
            EmptyIcon.cache.put(size, icon = new EmptyIcon(size, size));
        }
        return (icon == null) ? new EmptyIcon(size, size) : icon;
    }
    
    public static Icon create(final int width, final int height) {
        return (width == height) ? create(width) : new EmptyIcon(width, height);
    }
    
    public static Icon create(final Icon base) {
        return create(base.getIconWidth(), base.getIconHeight());
    }
    
    @Deprecated
    public EmptyIcon(final int size) {
        this(size, size);
    }
    
    public EmptyIcon(final int width, final int height) {
        this.width = width;
        this.height = height;
    }
    
    @Deprecated
    public EmptyIcon(final Icon base) {
        this(base.getIconWidth(), base.getIconHeight());
    }
    
    @Override
    public int getIconWidth() {
        return this.width;
    }
    
    @Override
    public int getIconHeight() {
        return this.height;
    }
    
    @Override
    public void paintIcon(final Component component, final Graphics g, final int i, final int j) {
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmptyIcon)) {
            return false;
        }
        final EmptyIcon icon = (EmptyIcon)o;
        return this.height == icon.height && this.width == icon.width;
    }
    
    @Override
    public int hashCode() {
        final int sum = this.width + this.height;
        return sum * (sum + 1) / 2 + this.width;
    }
    
    static {
        cache = new HashMap<Integer, Icon>();
    }
}
