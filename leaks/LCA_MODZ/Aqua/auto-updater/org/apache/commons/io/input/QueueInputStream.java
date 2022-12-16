// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.input;

import org.apache.commons.io.output.QueueOutputStream;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.io.InputStream;

public class QueueInputStream extends InputStream
{
    private final BlockingQueue<Integer> blockingQueue;
    
    public QueueInputStream() {
        this(new LinkedBlockingQueue<Integer>());
    }
    
    public QueueInputStream(final BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = Objects.requireNonNull(blockingQueue, "blockingQueue");
    }
    
    public QueueOutputStream newQueueOutputStream() {
        return new QueueOutputStream(this.blockingQueue);
    }
    
    @Override
    public int read() {
        final Integer value = this.blockingQueue.poll();
        return (value == null) ? -1 : (0xFF & value);
    }
}
