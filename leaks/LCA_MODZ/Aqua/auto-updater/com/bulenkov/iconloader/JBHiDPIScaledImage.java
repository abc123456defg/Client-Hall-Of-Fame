// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class JBHiDPIScaledImage extends BufferedImage
{
    private final Image myImage;
    
    public JBHiDPIScaledImage(final int width, final int height, final int type) {
        this(null, 2 * width, 2 * height, type);
    }
    
    public JBHiDPIScaledImage(final Image image, final int width, final int height, final int type) {
        super(width, height, type);
        this.myImage = image;
    }
    
    public Image getDelegate() {
        return this.myImage;
    }
    
    @Override
    public Graphics2D createGraphics() {
        final Graphics2D g = super.createGraphics();
        if (this.myImage == null) {
            return new HiDPIScaledGraphics(g, this);
        }
        return g;
    }
}
