// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader;

import com.bulenkov.iconloader.util.UIUtil;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import com.bulenkov.iconloader.util.SystemInfo;
import java.awt.image.ImageObserver;
import java.awt.Image;

public class RetinaImage
{
    public static Image createFrom(final Image image) {
        return createFrom(image, 2, IconLoader.ourComponent);
    }
    
    public static Image createFrom(final Image image, final int scale, final ImageObserver observer) {
        final int w = image.getWidth(observer);
        final int h = image.getHeight(observer);
        final Image hidpi = create(image, w / scale, h / scale, 2);
        if (SystemInfo.isAppleJvm) {
            final Graphics2D g = (Graphics2D)hidpi.getGraphics();
            g.scale(1.0f / scale, 1.0f / scale);
            g.drawImage(image, 0, 0, null);
            g.dispose();
        }
        return hidpi;
    }
    
    public static BufferedImage create(final int width, final int height, final int type) {
        return create(null, width, height, type);
    }
    
    private static BufferedImage create(final Image image, final int width, final int height, final int type) {
        if (SystemInfo.isAppleJvm) {
            return AppleHiDPIScaledImage.create(width, height, type);
        }
        if (image == null) {
            return new JBHiDPIScaledImage(width, height, type);
        }
        return new JBHiDPIScaledImage(image, width, height, type);
    }
    
    public static boolean isAppleHiDPIScaledImage(final Image image) {
        return UIUtil.isAppleRetina() && AppleHiDPIScaledImage.is(image);
    }
}
