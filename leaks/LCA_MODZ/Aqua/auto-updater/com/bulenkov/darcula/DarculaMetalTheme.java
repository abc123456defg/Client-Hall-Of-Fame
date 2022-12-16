// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula;

import java.awt.Color;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;

public class DarculaMetalTheme extends DefaultMetalTheme
{
    private final ColorUIResource myControlHighlightColor;
    private final ColorUIResource myControlDarkShadowColor;
    private final ColorUIResource myControlColor;
    private static final ColorUIResource white;
    private static final ColorUIResource darkBlue;
    private static final ColorUIResource lightGray;
    private final ColorUIResource mySeparatorForeground;
    public static final ColorUIResource primary1;
    private static final ColorUIResource primary2;
    private static final ColorUIResource primary3;
    
    public DarculaMetalTheme() {
        this.myControlHighlightColor = new ColorUIResource(108, 111, 113);
        this.myControlDarkShadowColor = new ColorUIResource(39, 42, 44);
        this.myControlColor = new ColorUIResource(3948353);
        this.mySeparatorForeground = new ColorUIResource(53, 56, 58);
    }
    
    @Override
    public String getName() {
        return "Darcula theme";
    }
    
    @Override
    public ColorUIResource getControl() {
        return this.myControlColor;
    }
    
    @Override
    public ColorUIResource getControlHighlight() {
        return this.myControlHighlightColor;
    }
    
    @Override
    public ColorUIResource getControlDarkShadow() {
        return this.myControlDarkShadowColor;
    }
    
    @Override
    public ColorUIResource getSeparatorBackground() {
        return this.getControl();
    }
    
    @Override
    public ColorUIResource getSeparatorForeground() {
        return this.mySeparatorForeground;
    }
    
    @Override
    public ColorUIResource getMenuBackground() {
        return DarculaMetalTheme.lightGray;
    }
    
    @Override
    public ColorUIResource getMenuSelectedBackground() {
        return DarculaMetalTheme.darkBlue;
    }
    
    @Override
    public ColorUIResource getMenuSelectedForeground() {
        return DarculaMetalTheme.white;
    }
    
    @Override
    public ColorUIResource getAcceleratorSelectedForeground() {
        return DarculaMetalTheme.white;
    }
    
    @Override
    public ColorUIResource getFocusColor() {
        return new ColorUIResource(Color.black);
    }
    
    @Override
    protected ColorUIResource getPrimary1() {
        return DarculaMetalTheme.primary1;
    }
    
    @Override
    protected ColorUIResource getPrimary2() {
        return DarculaMetalTheme.primary2;
    }
    
    @Override
    protected ColorUIResource getPrimary3() {
        return DarculaMetalTheme.primary3;
    }
    
    static {
        white = new ColorUIResource(128, 128, 128);
        darkBlue = new ColorUIResource(0, 44, 63);
        lightGray = new ColorUIResource(109, 109, 109);
        primary1 = new ColorUIResource(53, 56, 58);
        primary2 = new ColorUIResource(50, 66, 114);
        primary3 = new ColorUIResource(53, 69, 91);
    }
}
