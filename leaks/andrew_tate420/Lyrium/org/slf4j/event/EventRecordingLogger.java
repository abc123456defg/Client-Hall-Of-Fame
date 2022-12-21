// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j.event;

import org.slf4j.Marker;
import java.util.Queue;
import org.slf4j.helpers.SubstituteLogger;
import org.slf4j.helpers.LegacyAbstractLogger;

public class EventRecordingLogger extends LegacyAbstractLogger
{
    private static final long serialVersionUID = -176083308134819629L;
    String name;
    SubstituteLogger logger;
    Queue<SubstituteLoggingEvent> eventQueue;
    static final boolean RECORD_ALL_EVENTS = true;
    
    public EventRecordingLogger(final SubstituteLogger logger, final Queue<SubstituteLoggingEvent> eventQueue) {
        this.logger = logger;
        this.name = logger.getName();
        this.eventQueue = eventQueue;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public boolean isTraceEnabled() {
        return true;
    }
    
    @Override
    public boolean isDebugEnabled() {
        return true;
    }
    
    @Override
    public boolean isInfoEnabled() {
        return true;
    }
    
    @Override
    public boolean isWarnEnabled() {
        return true;
    }
    
    @Override
    public boolean isErrorEnabled() {
        return true;
    }
    
    @Override
    protected void handleNormalizedLoggingCall(final Level level, final Marker marker, final String msg, final Object[] args, final Throwable throwable) {
        final SubstituteLoggingEvent loggingEvent = new SubstituteLoggingEvent();
        loggingEvent.setTimeStamp(System.currentTimeMillis());
        loggingEvent.setLevel(level);
        loggingEvent.setLogger(this.logger);
        loggingEvent.setLoggerName(this.name);
        if (marker != null) {
            loggingEvent.addMarker(marker);
        }
        loggingEvent.setMessage(msg);
        loggingEvent.setThreadName(Thread.currentThread().getName());
        loggingEvent.setArgumentArray(args);
        loggingEvent.setThrowable(throwable);
        this.eventQueue.add(loggingEvent);
    }
    
    @Override
    protected String getFullyQualifiedCallerName() {
        return null;
    }
}
