// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.output;

import java.io.OutputStream;

public class CloseShieldOutputStream extends ProxyOutputStream
{
    public static CloseShieldOutputStream wrap(final OutputStream outputStream) {
        return new CloseShieldOutputStream(outputStream);
    }
    
    @Deprecated
    public CloseShieldOutputStream(final OutputStream outputStream) {
        super(outputStream);
    }
    
    @Override
    public void close() {
        this.out = ClosedOutputStream.CLOSED_OUTPUT_STREAM;
    }
}
