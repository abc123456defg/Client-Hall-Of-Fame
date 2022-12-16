// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.input;

import java.io.InputStream;

public class CloseShieldInputStream extends ProxyInputStream
{
    public static CloseShieldInputStream wrap(final InputStream inputStream) {
        return new CloseShieldInputStream(inputStream);
    }
    
    @Deprecated
    public CloseShieldInputStream(final InputStream inputStream) {
        super(inputStream);
    }
    
    @Override
    public void close() {
        this.in = ClosedInputStream.CLOSED_INPUT_STREAM;
    }
}
