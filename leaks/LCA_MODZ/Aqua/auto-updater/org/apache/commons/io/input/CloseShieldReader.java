// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.input;

import java.io.Reader;

public class CloseShieldReader extends ProxyReader
{
    public static CloseShieldReader wrap(final Reader reader) {
        return new CloseShieldReader(reader);
    }
    
    @Deprecated
    public CloseShieldReader(final Reader reader) {
        super(reader);
    }
    
    @Override
    public void close() {
        this.in = ClosedReader.CLOSED_READER;
    }
}
