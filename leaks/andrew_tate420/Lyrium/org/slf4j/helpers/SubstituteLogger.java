// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j.helpers;

import java.lang.reflect.InvocationTargetException;
import org.slf4j.event.LoggingEvent;
import org.slf4j.Marker;
import org.slf4j.spi.LoggingEventBuilder;
import org.slf4j.event.Level;
import org.slf4j.event.SubstituteLoggingEvent;
import java.util.Queue;
import org.slf4j.event.EventRecordingLogger;
import java.lang.reflect.Method;
import org.slf4j.Logger;

public class SubstituteLogger implements Logger
{
    private final String name;
    private volatile Logger _delegate;
    private Boolean delegateEventAware;
    private Method logMethodCache;
    private EventRecordingLogger eventRecordingLogger;
    private final Queue<SubstituteLoggingEvent> eventQueue;
    public final boolean createdPostInitialization;
    
    public SubstituteLogger(final String name, final Queue<SubstituteLoggingEvent> eventQueue, final boolean createdPostInitialization) {
        this.name = name;
        this.eventQueue = eventQueue;
        this.createdPostInitialization = createdPostInitialization;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public LoggingEventBuilder makeLoggingEventBuilder(final Level level) {
        return this.delegate().makeLoggingEventBuilder(level);
    }
    
    @Override
    public LoggingEventBuilder atLevel(final Level level) {
        return this.delegate().atLevel(level);
    }
    
    @Override
    public boolean isEnabledForLevel(final Level level) {
        return this.delegate().isEnabledForLevel(level);
    }
    
    @Override
    public boolean isTraceEnabled() {
        return this.delegate().isTraceEnabled();
    }
    
    @Override
    public void trace(final String msg) {
        this.delegate().trace(msg);
    }
    
    @Override
    public void trace(final String format, final Object arg) {
        this.delegate().trace(format, arg);
    }
    
    @Override
    public void trace(final String format, final Object arg1, final Object arg2) {
        this.delegate().trace(format, arg1, arg2);
    }
    
    @Override
    public void trace(final String format, final Object... arguments) {
        this.delegate().trace(format, arguments);
    }
    
    @Override
    public void trace(final String msg, final Throwable t) {
        this.delegate().trace(msg, t);
    }
    
    @Override
    public boolean isTraceEnabled(final Marker marker) {
        return this.delegate().isTraceEnabled(marker);
    }
    
    @Override
    public void trace(final Marker marker, final String msg) {
        this.delegate().trace(marker, msg);
    }
    
    @Override
    public void trace(final Marker marker, final String format, final Object arg) {
        this.delegate().trace(marker, format, arg);
    }
    
    @Override
    public void trace(final Marker marker, final String format, final Object arg1, final Object arg2) {
        this.delegate().trace(marker, format, arg1, arg2);
    }
    
    @Override
    public void trace(final Marker marker, final String format, final Object... arguments) {
        this.delegate().trace(marker, format, arguments);
    }
    
    @Override
    public void trace(final Marker marker, final String msg, final Throwable t) {
        this.delegate().trace(marker, msg, t);
    }
    
    @Override
    public LoggingEventBuilder atTrace() {
        return this.delegate().atTrace();
    }
    
    @Override
    public boolean isDebugEnabled() {
        return this.delegate().isDebugEnabled();
    }
    
    @Override
    public void debug(final String msg) {
        this.delegate().debug(msg);
    }
    
    @Override
    public void debug(final String format, final Object arg) {
        this.delegate().debug(format, arg);
    }
    
    @Override
    public void debug(final String format, final Object arg1, final Object arg2) {
        this.delegate().debug(format, arg1, arg2);
    }
    
    @Override
    public void debug(final String format, final Object... arguments) {
        this.delegate().debug(format, arguments);
    }
    
    @Override
    public void debug(final String msg, final Throwable t) {
        this.delegate().debug(msg, t);
    }
    
    @Override
    public boolean isDebugEnabled(final Marker marker) {
        return this.delegate().isDebugEnabled(marker);
    }
    
    @Override
    public void debug(final Marker marker, final String msg) {
        this.delegate().debug(marker, msg);
    }
    
    @Override
    public void debug(final Marker marker, final String format, final Object arg) {
        this.delegate().debug(marker, format, arg);
    }
    
    @Override
    public void debug(final Marker marker, final String format, final Object arg1, final Object arg2) {
        this.delegate().debug(marker, format, arg1, arg2);
    }
    
    @Override
    public void debug(final Marker marker, final String format, final Object... arguments) {
        this.delegate().debug(marker, format, arguments);
    }
    
    @Override
    public void debug(final Marker marker, final String msg, final Throwable t) {
        this.delegate().debug(marker, msg, t);
    }
    
    @Override
    public LoggingEventBuilder atDebug() {
        return this.delegate().atDebug();
    }
    
    @Override
    public boolean isInfoEnabled() {
        return this.delegate().isInfoEnabled();
    }
    
    @Override
    public void info(final String msg) {
        this.delegate().info(msg);
    }
    
    @Override
    public void info(final String format, final Object arg) {
        this.delegate().info(format, arg);
    }
    
    @Override
    public void info(final String format, final Object arg1, final Object arg2) {
        this.delegate().info(format, arg1, arg2);
    }
    
    @Override
    public void info(final String format, final Object... arguments) {
        this.delegate().info(format, arguments);
    }
    
    @Override
    public void info(final String msg, final Throwable t) {
        this.delegate().info(msg, t);
    }
    
    @Override
    public boolean isInfoEnabled(final Marker marker) {
        return this.delegate().isInfoEnabled(marker);
    }
    
    @Override
    public void info(final Marker marker, final String msg) {
        this.delegate().info(marker, msg);
    }
    
    @Override
    public void info(final Marker marker, final String format, final Object arg) {
        this.delegate().info(marker, format, arg);
    }
    
    @Override
    public void info(final Marker marker, final String format, final Object arg1, final Object arg2) {
        this.delegate().info(marker, format, arg1, arg2);
    }
    
    @Override
    public void info(final Marker marker, final String format, final Object... arguments) {
        this.delegate().info(marker, format, arguments);
    }
    
    @Override
    public void info(final Marker marker, final String msg, final Throwable t) {
        this.delegate().info(marker, msg, t);
    }
    
    @Override
    public LoggingEventBuilder atInfo() {
        return this.delegate().atInfo();
    }
    
    @Override
    public boolean isWarnEnabled() {
        return this.delegate().isWarnEnabled();
    }
    
    @Override
    public void warn(final String msg) {
        this.delegate().warn(msg);
    }
    
    @Override
    public void warn(final String format, final Object arg) {
        this.delegate().warn(format, arg);
    }
    
    @Override
    public void warn(final String format, final Object arg1, final Object arg2) {
        this.delegate().warn(format, arg1, arg2);
    }
    
    @Override
    public void warn(final String format, final Object... arguments) {
        this.delegate().warn(format, arguments);
    }
    
    @Override
    public void warn(final String msg, final Throwable t) {
        this.delegate().warn(msg, t);
    }
    
    @Override
    public boolean isWarnEnabled(final Marker marker) {
        return this.delegate().isWarnEnabled(marker);
    }
    
    @Override
    public void warn(final Marker marker, final String msg) {
        this.delegate().warn(marker, msg);
    }
    
    @Override
    public void warn(final Marker marker, final String format, final Object arg) {
        this.delegate().warn(marker, format, arg);
    }
    
    @Override
    public void warn(final Marker marker, final String format, final Object arg1, final Object arg2) {
        this.delegate().warn(marker, format, arg1, arg2);
    }
    
    @Override
    public void warn(final Marker marker, final String format, final Object... arguments) {
        this.delegate().warn(marker, format, arguments);
    }
    
    @Override
    public void warn(final Marker marker, final String msg, final Throwable t) {
        this.delegate().warn(marker, msg, t);
    }
    
    @Override
    public LoggingEventBuilder atWarn() {
        return this.delegate().atWarn();
    }
    
    @Override
    public boolean isErrorEnabled() {
        return this.delegate().isErrorEnabled();
    }
    
    @Override
    public void error(final String msg) {
        this.delegate().error(msg);
    }
    
    @Override
    public void error(final String format, final Object arg) {
        this.delegate().error(format, arg);
    }
    
    @Override
    public void error(final String format, final Object arg1, final Object arg2) {
        this.delegate().error(format, arg1, arg2);
    }
    
    @Override
    public void error(final String format, final Object... arguments) {
        this.delegate().error(format, arguments);
    }
    
    @Override
    public void error(final String msg, final Throwable t) {
        this.delegate().error(msg, t);
    }
    
    @Override
    public boolean isErrorEnabled(final Marker marker) {
        return this.delegate().isErrorEnabled(marker);
    }
    
    @Override
    public void error(final Marker marker, final String msg) {
        this.delegate().error(marker, msg);
    }
    
    @Override
    public void error(final Marker marker, final String format, final Object arg) {
        this.delegate().error(marker, format, arg);
    }
    
    @Override
    public void error(final Marker marker, final String format, final Object arg1, final Object arg2) {
        this.delegate().error(marker, format, arg1, arg2);
    }
    
    @Override
    public void error(final Marker marker, final String format, final Object... arguments) {
        this.delegate().error(marker, format, arguments);
    }
    
    @Override
    public void error(final Marker marker, final String msg, final Throwable t) {
        this.delegate().error(marker, msg, t);
    }
    
    @Override
    public LoggingEventBuilder atError() {
        return this.delegate().atError();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final SubstituteLogger that = (SubstituteLogger)o;
        return this.name.equals(that.name);
    }
    
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
    
    public Logger delegate() {
        if (this._delegate != null) {
            return this._delegate;
        }
        if (this.createdPostInitialization) {
            return NOPLogger.NOP_LOGGER;
        }
        return this.getEventRecordingLogger();
    }
    
    private Logger getEventRecordingLogger() {
        if (this.eventRecordingLogger == null) {
            this.eventRecordingLogger = new EventRecordingLogger(this, this.eventQueue);
        }
        return this.eventRecordingLogger;
    }
    
    public void setDelegate(final Logger delegate) {
        this._delegate = delegate;
    }
    
    public boolean isDelegateEventAware() {
        if (this.delegateEventAware != null) {
            return this.delegateEventAware;
        }
        try {
            this.logMethodCache = this._delegate.getClass().getMethod("log", LoggingEvent.class);
            this.delegateEventAware = Boolean.TRUE;
        }
        catch (NoSuchMethodException e) {
            this.delegateEventAware = Boolean.FALSE;
        }
        return this.delegateEventAware;
    }
    
    public void log(final LoggingEvent event) {
        if (this.isDelegateEventAware()) {
            try {
                this.logMethodCache.invoke(this._delegate, event);
            }
            catch (IllegalAccessException ex) {}
            catch (IllegalArgumentException ex2) {}
            catch (InvocationTargetException ex3) {}
        }
    }
    
    public boolean isDelegateNull() {
        return this._delegate == null;
    }
    
    public boolean isDelegateNOP() {
        return this._delegate instanceof NOPLogger;
    }
}
