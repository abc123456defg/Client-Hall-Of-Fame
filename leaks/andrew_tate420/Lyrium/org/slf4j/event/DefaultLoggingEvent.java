// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j.event;

import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;
import org.slf4j.Marker;
import java.util.List;
import org.slf4j.Logger;

public class DefaultLoggingEvent implements LoggingEvent
{
    Logger logger;
    Level level;
    String message;
    List<Marker> markers;
    List<Object> arguments;
    List<KeyValuePair> keyValuePairs;
    Throwable throwable;
    String threadName;
    long timeStamp;
    String callerBoundary;
    
    public DefaultLoggingEvent(final Level level, final Logger logger) {
        this.logger = logger;
        this.level = level;
    }
    
    public void addMarker(final Marker marker) {
        if (this.markers == null) {
            this.markers = new ArrayList<Marker>(2);
        }
        this.markers.add(marker);
    }
    
    @Override
    public List<Marker> getMarkers() {
        return this.markers;
    }
    
    public void addArgument(final Object p) {
        this.getNonNullArguments().add(p);
    }
    
    public void addArguments(final Object... args) {
        this.getNonNullArguments().addAll(Arrays.asList(args));
    }
    
    private List<Object> getNonNullArguments() {
        if (this.arguments == null) {
            this.arguments = new ArrayList<Object>(3);
        }
        return this.arguments;
    }
    
    @Override
    public List<Object> getArguments() {
        return this.arguments;
    }
    
    @Override
    public Object[] getArgumentArray() {
        if (this.arguments == null) {
            return null;
        }
        return this.arguments.toArray();
    }
    
    public void addKeyValue(final String key, final Object value) {
        this.getNonnullKeyValuePairs().add(new KeyValuePair(key, value));
    }
    
    private List<KeyValuePair> getNonnullKeyValuePairs() {
        if (this.keyValuePairs == null) {
            this.keyValuePairs = new ArrayList<KeyValuePair>(4);
        }
        return this.keyValuePairs;
    }
    
    @Override
    public List<KeyValuePair> getKeyValuePairs() {
        return this.keyValuePairs;
    }
    
    public void setThrowable(final Throwable cause) {
        this.throwable = cause;
    }
    
    @Override
    public Level getLevel() {
        return this.level;
    }
    
    @Override
    public String getLoggerName() {
        return this.logger.getName();
    }
    
    @Override
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    @Override
    public Throwable getThrowable() {
        return this.throwable;
    }
    
    @Override
    public String getThreadName() {
        return this.threadName;
    }
    
    @Override
    public long getTimeStamp() {
        return this.timeStamp;
    }
    
    public void setCallerBoundary(final String fqcn) {
        this.callerBoundary = fqcn;
    }
    
    @Override
    public String getCallerBoundary() {
        return this.callerBoundary;
    }
}
