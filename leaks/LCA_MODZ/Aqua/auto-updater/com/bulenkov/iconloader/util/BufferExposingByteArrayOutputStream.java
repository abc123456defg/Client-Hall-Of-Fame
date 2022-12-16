// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

public class BufferExposingByteArrayOutputStream extends AsyncByteArrayOutputStream
{
    public BufferExposingByteArrayOutputStream() {
    }
    
    public BufferExposingByteArrayOutputStream(final int size) {
        super(size);
    }
    
    public byte[] getInternalBuffer() {
        return this.myBuffer;
    }
    
    public int backOff(final int size) {
        assert size >= 0 : size;
        this.myCount -= size;
        assert this.myCount >= 0 : this.myCount;
        return this.myCount;
    }
}
