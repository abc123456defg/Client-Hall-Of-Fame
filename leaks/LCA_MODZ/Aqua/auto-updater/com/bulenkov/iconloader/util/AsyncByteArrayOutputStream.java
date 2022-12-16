// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import java.io.IOException;
import java.util.Arrays;
import java.io.OutputStream;

public class AsyncByteArrayOutputStream extends OutputStream
{
    protected byte[] myBuffer;
    protected int myCount;
    
    public AsyncByteArrayOutputStream() {
        this(32);
    }
    
    public AsyncByteArrayOutputStream(final int size) {
        this.myBuffer = new byte[size];
    }
    
    @Override
    public void write(final int b) {
        final int count = this.myCount + 1;
        if (count > this.myBuffer.length) {
            this.myBuffer = Arrays.copyOf(this.myBuffer, Math.max(this.myBuffer.length << 1, count));
        }
        this.myBuffer[this.myCount] = (byte)b;
        this.myCount = count;
    }
    
    @Override
    public void write(final byte[] b, final int off, final int len) {
        if (off < 0 || off > b.length || len < 0 || off + len > b.length || off + len < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return;
        }
        final int count = this.myCount + len;
        if (count > this.myBuffer.length) {
            this.myBuffer = Arrays.copyOf(this.myBuffer, Math.max(this.myBuffer.length << 1, count));
        }
        System.arraycopy(b, off, this.myBuffer, this.myCount, len);
        this.myCount = count;
    }
    
    public void writeTo(final OutputStream out) throws IOException {
        out.write(this.myBuffer, 0, this.myCount);
    }
    
    public void reset() {
        this.myCount = 0;
    }
    
    public byte[] toByteArray() {
        return Arrays.copyOf(this.myBuffer, this.myCount);
    }
    
    public int size() {
        return this.myCount;
    }
    
    @Override
    public String toString() {
        return new String(this.myBuffer, 0, this.myCount);
    }
}
