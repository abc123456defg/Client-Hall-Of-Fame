// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import java.awt.image.ImageObserver;
import java.awt.Graphics;
import java.awt.Component;
import org.jetbrains.annotations.NotNull;
import java.awt.Image;
import javax.swing.ImageIcon;

public class JBImageIcon extends ImageIcon
{
    public JBImageIcon(@NotNull final Image image) {
        if (image == null) {
            $$$reportNull$$$0(0);
        }
        super(image);
    }
    
    @Override
    public synchronized void paintIcon(final Component c, final Graphics g, final int x, final int y) {
        final ImageObserver observer = this.getImageObserver();
        UIUtil.drawImage(g, this.getImage(), x, y, (observer == null) ? c : observer);
    }
    
    private static /* synthetic */ void $$$reportNull$$$0(final int n) {
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "image", "com/bulenkov/iconloader/util/JBImageIcon", "<init>"));
    }
}
