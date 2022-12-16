// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.input;

import java.time.temporal.Temporal;
import java.time.Duration;
import java.io.IOException;
import java.time.Instant;

public class TimestampedObserver extends ObservableInputStream.Observer
{
    private volatile Instant closeInstant;
    private final Instant openInstant;
    
    public TimestampedObserver() {
        this.openInstant = Instant.now();
    }
    
    @Override
    public void closed() throws IOException {
        this.closeInstant = Instant.now();
    }
    
    public Instant getCloseInstant() {
        return this.closeInstant;
    }
    
    public Duration getOpenToCloseDuration() {
        return Duration.between(this.openInstant, this.closeInstant);
    }
    
    public Duration getOpenToNowDuration() {
        return Duration.between(this.openInstant, Instant.now());
    }
    
    public Instant getOpenInstant() {
        return this.openInstant;
    }
    
    @Override
    public String toString() {
        return "TimestampedObserver [openInstant=" + this.openInstant + ", closeInstant=" + this.closeInstant + "]";
    }
}
