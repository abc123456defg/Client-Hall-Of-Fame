// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j.impl;

import java.util.Map;
import java.util.HashMap;

public class CopyOnInheritThreadLocal extends InheritableThreadLocal<HashMap<String, String>>
{
    @Override
    protected HashMap<String, String> childValue(final HashMap<String, String> parentValue) {
        if (parentValue == null) {
            return null;
        }
        final HashMap<String, String> hm = new HashMap<String, String>(parentValue);
        return hm;
    }
}
