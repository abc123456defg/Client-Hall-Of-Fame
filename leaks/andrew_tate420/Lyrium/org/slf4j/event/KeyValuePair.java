// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j.event;

public class KeyValuePair
{
    public final String key;
    public final Object value;
    
    public KeyValuePair(final String key, final Object value) {
        this.key = key;
        this.value = value;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.key) + "=\"" + String.valueOf(this.value) + "\"";
    }
}
