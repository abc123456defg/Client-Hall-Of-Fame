// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.input;

import java.io.IOException;
import java.io.Reader;
import java.util.function.IntPredicate;
import java.io.FilterReader;

public abstract class AbstractCharacterFilterReader extends FilterReader
{
    protected static final IntPredicate SKIP_NONE;
    private final IntPredicate skip;
    
    protected AbstractCharacterFilterReader(final Reader reader) {
        this(reader, AbstractCharacterFilterReader.SKIP_NONE);
    }
    
    protected AbstractCharacterFilterReader(final Reader reader, final IntPredicate skip) {
        super(reader);
        this.skip = ((skip == null) ? AbstractCharacterFilterReader.SKIP_NONE : skip);
    }
    
    protected boolean filter(final int ch) {
        return this.skip.test(ch);
    }
    
    @Override
    public int read() throws IOException {
        int ch;
        do {
            ch = this.in.read();
        } while (ch != -1 && this.filter(ch));
        return ch;
    }
    
    @Override
    public int read(final char[] cbuf, final int off, final int len) throws IOException {
        final int read = super.read(cbuf, off, len);
        if (read == -1) {
            return -1;
        }
        int pos = off - 1;
        for (int readPos = off; readPos < off + read; ++readPos) {
            if (!this.filter(cbuf[readPos])) {
                if (++pos < readPos) {
                    cbuf[pos] = cbuf[readPos];
                }
            }
        }
        return pos - off + 1;
    }
    
    static {
        SKIP_NONE = (ch -> false);
    }
}
