// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader;

import java.awt.Image;
import apple.awt.CImage;
import java.awt.image.BufferedImage;

public class AppleHiDPIScaledImage
{
    public static BufferedImage create(final int width, final int height, final int imageType) {
        return (BufferedImage)new CImage.HiDPIScaledImage(width, height, imageType) {
            protected void drawIntoImage(final BufferedImage image, final float scale) {
            }
        };
    }
    
    public static boolean is(final Image image) {
        return image instanceof CImage.HiDPIScaledImage;
    }
}
