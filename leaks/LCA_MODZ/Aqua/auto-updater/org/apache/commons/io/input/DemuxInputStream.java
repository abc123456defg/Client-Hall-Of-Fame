// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.input;

import java.io.IOException;
import org.apache.commons.io.IOUtils;
import java.io.Closeable;
import java.io.InputStream;

public class DemuxInputStream extends InputStream
{
    private final InheritableThreadLocal<InputStream> inputStreamLocal;
    
    public DemuxInputStream() {
        this.inputStreamLocal = new InheritableThreadLocal<InputStream>();
    }
    
    public InputStream bindStream(final InputStream input) {
        final InputStream oldValue = this.inputStreamLocal.get();
        this.inputStreamLocal.set(input);
        return oldValue;
    }
    
    @Override
    public void close() throws IOException {
        IOUtils.close(this.inputStreamLocal.get());
    }
    
    @Override
    public int read() throws IOException {
        final InputStream inputStream = this.inputStreamLocal.get();
        if (null != inputStream) {
            return inputStream.read();
        }
        return -1;
    }
}
