// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j.spi;

import java.util.function.Supplier;
import org.slf4j.Marker;
import org.slf4j.helpers.CheckReturnValue;

public interface LoggingEventBuilder
{
    @CheckReturnValue
    LoggingEventBuilder setCause(final Throwable p0);
    
    @CheckReturnValue
    LoggingEventBuilder addMarker(final Marker p0);
    
    @CheckReturnValue
    LoggingEventBuilder addArgument(final Object p0);
    
    @CheckReturnValue
    LoggingEventBuilder addArgument(final Supplier<?> p0);
    
    @CheckReturnValue
    LoggingEventBuilder addKeyValue(final String p0, final Object p1);
    
    @CheckReturnValue
    LoggingEventBuilder addKeyValue(final String p0, final Supplier<Object> p1);
    
    @CheckReturnValue
    LoggingEventBuilder setMessage(final String p0);
    
    @CheckReturnValue
    LoggingEventBuilder setMessage(final Supplier<String> p0);
    
    void log();
    
    void log(final String p0);
    
    void log(final String p0, final Object p1);
    
    void log(final String p0, final Object p1, final Object p2);
    
    void log(final String p0, final Object... p1);
    
    void log(final Supplier<String> p0);
}
