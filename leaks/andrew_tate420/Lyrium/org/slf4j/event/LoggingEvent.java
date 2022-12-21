// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j.event;

import org.slf4j.Marker;
import java.util.List;

public interface LoggingEvent
{
    Level getLevel();
    
    String getLoggerName();
    
    String getMessage();
    
    List<Object> getArguments();
    
    Object[] getArgumentArray();
    
    List<Marker> getMarkers();
    
    List<KeyValuePair> getKeyValuePairs();
    
    Throwable getThrowable();
    
    long getTimeStamp();
    
    String getThreadName();
    
    default String getCallerBoundary() {
        return null;
    }
}
