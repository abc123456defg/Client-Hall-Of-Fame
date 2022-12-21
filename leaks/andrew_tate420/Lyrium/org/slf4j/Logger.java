// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j;

import org.slf4j.spi.NOPLoggingEventBuilder;
import org.slf4j.spi.DefaultLoggingEventBuilder;
import org.slf4j.spi.LoggingEventBuilder;
import org.slf4j.event.Level;

public interface Logger
{
    public static final String ROOT_LOGGER_NAME = "ROOT";
    
    String getName();
    
    default LoggingEventBuilder makeLoggingEventBuilder(final Level level) {
        if (this.isEnabledForLevel(level)) {
            return new DefaultLoggingEventBuilder(this, level);
        }
        return NOPLoggingEventBuilder.singleton();
    }
    
    default LoggingEventBuilder atLevel(final Level level) {
        return this.makeLoggingEventBuilder(level);
    }
    
    default boolean isEnabledForLevel(final Level level) {
        final int levelInt = level.toInt();
        switch (levelInt) {
            case 0: {
                return this.isTraceEnabled();
            }
            case 10: {
                return this.isDebugEnabled();
            }
            case 20: {
                return this.isInfoEnabled();
            }
            case 30: {
                return this.isWarnEnabled();
            }
            case 40: {
                return this.isErrorEnabled();
            }
            default: {
                throw new IllegalArgumentException("Level [" + level + "] not recognized.");
            }
        }
    }
    
    boolean isTraceEnabled();
    
    void trace(final String p0);
    
    void trace(final String p0, final Object p1);
    
    void trace(final String p0, final Object p1, final Object p2);
    
    void trace(final String p0, final Object... p1);
    
    void trace(final String p0, final Throwable p1);
    
    boolean isTraceEnabled(final Marker p0);
    
    default LoggingEventBuilder atTrace() {
        if (this.isTraceEnabled()) {
            return this.makeLoggingEventBuilder(Level.TRACE);
        }
        return NOPLoggingEventBuilder.singleton();
    }
    
    void trace(final Marker p0, final String p1);
    
    void trace(final Marker p0, final String p1, final Object p2);
    
    void trace(final Marker p0, final String p1, final Object p2, final Object p3);
    
    void trace(final Marker p0, final String p1, final Object... p2);
    
    void trace(final Marker p0, final String p1, final Throwable p2);
    
    boolean isDebugEnabled();
    
    void debug(final String p0);
    
    void debug(final String p0, final Object p1);
    
    void debug(final String p0, final Object p1, final Object p2);
    
    void debug(final String p0, final Object... p1);
    
    void debug(final String p0, final Throwable p1);
    
    boolean isDebugEnabled(final Marker p0);
    
    void debug(final Marker p0, final String p1);
    
    void debug(final Marker p0, final String p1, final Object p2);
    
    void debug(final Marker p0, final String p1, final Object p2, final Object p3);
    
    void debug(final Marker p0, final String p1, final Object... p2);
    
    void debug(final Marker p0, final String p1, final Throwable p2);
    
    default LoggingEventBuilder atDebug() {
        if (this.isDebugEnabled()) {
            return this.makeLoggingEventBuilder(Level.DEBUG);
        }
        return NOPLoggingEventBuilder.singleton();
    }
    
    boolean isInfoEnabled();
    
    void info(final String p0);
    
    void info(final String p0, final Object p1);
    
    void info(final String p0, final Object p1, final Object p2);
    
    void info(final String p0, final Object... p1);
    
    void info(final String p0, final Throwable p1);
    
    boolean isInfoEnabled(final Marker p0);
    
    void info(final Marker p0, final String p1);
    
    void info(final Marker p0, final String p1, final Object p2);
    
    void info(final Marker p0, final String p1, final Object p2, final Object p3);
    
    void info(final Marker p0, final String p1, final Object... p2);
    
    void info(final Marker p0, final String p1, final Throwable p2);
    
    default LoggingEventBuilder atInfo() {
        if (this.isInfoEnabled()) {
            return this.makeLoggingEventBuilder(Level.INFO);
        }
        return NOPLoggingEventBuilder.singleton();
    }
    
    boolean isWarnEnabled();
    
    void warn(final String p0);
    
    void warn(final String p0, final Object p1);
    
    void warn(final String p0, final Object... p1);
    
    void warn(final String p0, final Object p1, final Object p2);
    
    void warn(final String p0, final Throwable p1);
    
    boolean isWarnEnabled(final Marker p0);
    
    void warn(final Marker p0, final String p1);
    
    void warn(final Marker p0, final String p1, final Object p2);
    
    void warn(final Marker p0, final String p1, final Object p2, final Object p3);
    
    void warn(final Marker p0, final String p1, final Object... p2);
    
    void warn(final Marker p0, final String p1, final Throwable p2);
    
    default LoggingEventBuilder atWarn() {
        if (this.isWarnEnabled()) {
            return this.makeLoggingEventBuilder(Level.WARN);
        }
        return NOPLoggingEventBuilder.singleton();
    }
    
    boolean isErrorEnabled();
    
    void error(final String p0);
    
    void error(final String p0, final Object p1);
    
    void error(final String p0, final Object p1, final Object p2);
    
    void error(final String p0, final Object... p1);
    
    void error(final String p0, final Throwable p1);
    
    boolean isErrorEnabled(final Marker p0);
    
    void error(final Marker p0, final String p1);
    
    void error(final Marker p0, final String p1, final Object p2);
    
    void error(final Marker p0, final String p1, final Object p2, final Object p3);
    
    void error(final Marker p0, final String p1, final Object... p2);
    
    void error(final Marker p0, final String p1, final Throwable p2);
    
    default LoggingEventBuilder atError() {
        if (this.isErrorEnabled()) {
            return this.makeLoggingEventBuilder(Level.ERROR);
        }
        return NOPLoggingEventBuilder.singleton();
    }
}
