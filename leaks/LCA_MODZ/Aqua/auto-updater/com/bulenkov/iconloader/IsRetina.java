// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader;

import java.awt.image.BufferedImage;
import apple.awt.CImage;
import com.bulenkov.iconloader.util.Ref;

public class IsRetina
{
    public static boolean isRetina() {
        try {
            final Ref<Boolean> isRetina = Ref.create(false);
            new CImage.HiDPIScaledImage(1, 1, 2) {
                public void drawIntoImage(final BufferedImage image, final float v) {
                    isRetina.set(v > 1.0f);
                }
            };
            return isRetina.get();
        }
        catch (Throwable ignore) {
            return false;
        }
    }
}
