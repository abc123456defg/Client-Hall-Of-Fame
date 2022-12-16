// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import java.awt.image.ImageProducer;
import java.awt.image.FilteredImageSource;
import java.awt.Toolkit;
import java.awt.image.ImageFilter;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import com.bulenkov.iconloader.JBHiDPIScaledImage;
import java.awt.image.BufferedImage;
import org.jetbrains.annotations.NotNull;
import java.awt.Image;

public class ImageUtil
{
    public static BufferedImage toBufferedImage(@NotNull Image image) {
        if (image == null) {
            $$$reportNull$$$0(0);
        }
        if (image instanceof JBHiDPIScaledImage) {
            final Image img = ((JBHiDPIScaledImage)image).getDelegate();
            if (img != null) {
                image = img;
            }
        }
        if (image instanceof BufferedImage) {
            return (BufferedImage)image;
        }
        final BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), 2);
        final Graphics2D g = bufferedImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return bufferedImage;
    }
    
    public static int getRealWidth(@NotNull Image image) {
        if (image == null) {
            $$$reportNull$$$0(1);
        }
        if (image instanceof JBHiDPIScaledImage) {
            final Image img = ((JBHiDPIScaledImage)image).getDelegate();
            if (img != null) {
                image = img;
            }
        }
        return image.getWidth(null);
    }
    
    public static int getRealHeight(@NotNull Image image) {
        if (image == null) {
            $$$reportNull$$$0(2);
        }
        if (image instanceof JBHiDPIScaledImage) {
            final Image img = ((JBHiDPIScaledImage)image).getDelegate();
            if (img != null) {
                image = img;
            }
        }
        return image.getHeight(null);
    }
    
    public static Image filter(final Image image, final ImageFilter filter) {
        if (image == null || filter == null) {
            return image;
        }
        return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(toBufferedImage(image).getSource(), filter));
    }
    
    private static /* synthetic */ void $$$reportNull$$$0(final int n) {
        final String format = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        final Object[] args = { "image", "com/bulenkov/iconloader/util/ImageUtil", null };
        switch (n) {
            default: {
                args[2] = "toBufferedImage";
                break;
            }
            case 1: {
                args[2] = "getRealWidth";
                break;
            }
            case 2: {
                args[2] = "getRealHeight";
                break;
            }
        }
        throw new IllegalArgumentException(String.format(format, args));
    }
}
