// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.output;

import java.io.Writer;

public class CloseShieldWriter extends ProxyWriter
{
    public static CloseShieldWriter wrap(final Writer writer) {
        return new CloseShieldWriter(writer);
    }
    
    @Deprecated
    public CloseShieldWriter(final Writer writer) {
        super(writer);
    }
    
    @Override
    public void close() {
        this.out = ClosedWriter.CLOSED_WRITER;
    }
}
