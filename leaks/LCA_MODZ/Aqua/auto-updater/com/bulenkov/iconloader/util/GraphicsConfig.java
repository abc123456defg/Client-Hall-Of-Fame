// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import java.awt.RenderingHints;
import java.awt.Graphics;
import java.util.Map;
import java.awt.Graphics2D;

public class GraphicsConfig
{
    private final Graphics2D myG;
    private final Map myHints;
    
    public GraphicsConfig(final Graphics g) {
        this.myG = (Graphics2D)g;
        this.myHints = (Map)this.myG.getRenderingHints().clone();
    }
    
    public GraphicsConfig setAntialiasing(final boolean on) {
        this.myG.setRenderingHint(RenderingHints.KEY_ANTIALIASING, on ? RenderingHints.VALUE_ANTIALIAS_ON : RenderingHints.VALUE_ANTIALIAS_OFF);
        return this;
    }
    
    public Graphics2D getG() {
        return this.myG;
    }
    
    public void restore() {
        this.myG.setRenderingHints(this.myHints);
    }
}
