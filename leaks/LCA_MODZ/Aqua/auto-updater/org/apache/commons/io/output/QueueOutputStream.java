// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.output;

import java.io.InterruptedIOException;
import org.apache.commons.io.input.QueueInputStream;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.io.OutputStream;

public class QueueOutputStream extends OutputStream
{
    private final BlockingQueue<Integer> blockingQueue;
    
    public QueueOutputStream() {
        this(new LinkedBlockingQueue<Integer>());
    }
    
    public QueueOutputStream(final BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = Objects.requireNonNull(blockingQueue, "blockingQueue");
    }
    
    public QueueInputStream newQueueInputStream() {
        return new QueueInputStream(this.blockingQueue);
    }
    
    @Override
    public void write(final int b) throws InterruptedIOException {
        try {
            this.blockingQueue.put(0xFF & b);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            final InterruptedIOException interruptedIoException = new InterruptedIOException();
            interruptedIoException.initCause(e);
            throw interruptedIoException;
        }
    }
}
