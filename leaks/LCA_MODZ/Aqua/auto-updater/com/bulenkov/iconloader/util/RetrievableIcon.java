// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import org.jetbrains.annotations.Nullable;
import javax.swing.Icon;

public interface RetrievableIcon extends Icon
{
    @Nullable
    Icon retrieveIcon();
}
