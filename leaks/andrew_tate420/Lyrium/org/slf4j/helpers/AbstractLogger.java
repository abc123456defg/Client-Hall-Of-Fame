// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j.helpers;

import org.slf4j.Marker;
import org.slf4j.event.Level;
import java.io.ObjectStreamException;
import org.slf4j.LoggerFactory;
import java.io.Serializable;
import org.slf4j.Logger;

public abstract class AbstractLogger implements Logger, Serializable
{
    private static final long serialVersionUID = -2529255052481744503L;
    protected String name;
    
    @Override
    public String getName() {
        return this.name;
    }
    
    protected Object readResolve() throws ObjectStreamException {
        return LoggerFactory.getLogger(this.getName());
    }
    
    @Override
    public void trace(final String msg) {
        if (this.isTraceEnabled()) {
            this.handle_0ArgsCall(Level.TRACE, null, msg, null);
        }
    }
    
    @Override
    public void trace(final String format, final Object arg) {
        if (this.isTraceEnabled()) {
            this.handle_1ArgsCall(Level.TRACE, null, format, arg);
        }
    }
    
    @Override
    public void trace(final String format, final Object arg1, final Object arg2) {
        if (this.isTraceEnabled()) {
            this.handle2ArgsCall(Level.TRACE, null, format, arg1, arg2);
        }
    }
    
    @Override
    public void trace(final String format, final Object... arguments) {
        if (this.isTraceEnabled()) {
            this.handleArgArrayCall(Level.TRACE, null, format, arguments);
        }
    }
    
    @Override
    public void trace(final String msg, final Throwable t) {
        if (this.isTraceEnabled()) {
            this.handle_0ArgsCall(Level.TRACE, null, msg, t);
        }
    }
    
    @Override
    public void trace(final Marker marker, final String msg) {
        if (this.isTraceEnabled(marker)) {
            this.handle_0ArgsCall(Level.TRACE, marker, msg, null);
        }
    }
    
    @Override
    public void trace(final Marker marker, final String format, final Object arg) {
        if (this.isTraceEnabled(marker)) {
            this.handle_1ArgsCall(Level.TRACE, marker, format, arg);
        }
    }
    
    @Override
    public void trace(final Marker marker, final String format, final Object arg1, final Object arg2) {
        if (this.isTraceEnabled(marker)) {
            this.handle2ArgsCall(Level.TRACE, marker, format, arg1, arg2);
        }
    }
    
    @Override
    public void trace(final Marker marker, final String format, final Object... argArray) {
        if (this.isTraceEnabled(marker)) {
            this.handleArgArrayCall(Level.TRACE, marker, format, argArray);
        }
    }
    
    @Override
    public void trace(final Marker marker, final String msg, final Throwable t) {
        if (this.isTraceEnabled(marker)) {
            this.handle_0ArgsCall(Level.TRACE, marker, msg, t);
        }
    }
    
    @Override
    public void debug(final String msg) {
        if (this.isDebugEnabled()) {
            this.handle_0ArgsCall(Level.DEBUG, null, msg, null);
        }
    }
    
    @Override
    public void debug(final String format, final Object arg) {
        if (this.isDebugEnabled()) {
            this.handle_1ArgsCall(Level.DEBUG, null, format, arg);
        }
    }
    
    @Override
    public void debug(final String format, final Object arg1, final Object arg2) {
        if (this.isDebugEnabled()) {
            this.handle2ArgsCall(Level.DEBUG, null, format, arg1, arg2);
        }
    }
    
    @Override
    public void debug(final String format, final Object... arguments) {
        if (this.isDebugEnabled()) {
            this.handleArgArrayCall(Level.DEBUG, null, format, arguments);
        }
    }
    
    @Override
    public void debug(final String msg, final Throwable t) {
        if (this.isDebugEnabled()) {
            this.handle_0ArgsCall(Level.DEBUG, null, msg, t);
        }
    }
    
    @Override
    public void debug(final Marker marker, final String msg) {
        if (this.isDebugEnabled(marker)) {
            this.handle_0ArgsCall(Level.DEBUG, marker, msg, null);
        }
    }
    
    @Override
    public void debug(final Marker marker, final String format, final Object arg) {
        if (this.isDebugEnabled(marker)) {
            this.handle_1ArgsCall(Level.DEBUG, marker, format, arg);
        }
    }
    
    @Override
    public void debug(final Marker marker, final String format, final Object arg1, final Object arg2) {
        if (this.isDebugEnabled(marker)) {
            this.handle2ArgsCall(Level.DEBUG, marker, format, arg1, arg2);
        }
    }
    
    @Override
    public void debug(final Marker marker, final String format, final Object... arguments) {
        if (this.isDebugEnabled(marker)) {
            this.handleArgArrayCall(Level.DEBUG, marker, format, arguments);
        }
    }
    
    @Override
    public void debug(final Marker marker, final String msg, final Throwable t) {
        if (this.isDebugEnabled(marker)) {
            this.handle_0ArgsCall(Level.DEBUG, marker, msg, t);
        }
    }
    
    @Override
    public void info(final String msg) {
        if (this.isInfoEnabled()) {
            this.handle_0ArgsCall(Level.INFO, null, msg, null);
        }
    }
    
    @Override
    public void info(final String format, final Object arg) {
        if (this.isInfoEnabled()) {
            this.handle_1ArgsCall(Level.INFO, null, format, arg);
        }
    }
    
    @Override
    public void info(final String format, final Object arg1, final Object arg2) {
        if (this.isInfoEnabled()) {
            this.handle2ArgsCall(Level.INFO, null, format, arg1, arg2);
        }
    }
    
    @Override
    public void info(final String format, final Object... arguments) {
        if (this.isInfoEnabled()) {
            this.handleArgArrayCall(Level.INFO, null, format, arguments);
        }
    }
    
    @Override
    public void info(final String msg, final Throwable t) {
        if (this.isInfoEnabled()) {
            this.handle_0ArgsCall(Level.INFO, null, msg, t);
        }
    }
    
    @Override
    public void info(final Marker marker, final String msg) {
        if (this.isInfoEnabled(marker)) {
            this.handle_0ArgsCall(Level.INFO, marker, msg, null);
        }
    }
    
    @Override
    public void info(final Marker marker, final String format, final Object arg) {
        if (this.isInfoEnabled(marker)) {
            this.handle_1ArgsCall(Level.INFO, marker, format, arg);
        }
    }
    
    @Override
    public void info(final Marker marker, final String format, final Object arg1, final Object arg2) {
        if (this.isInfoEnabled(marker)) {
            this.handle2ArgsCall(Level.INFO, marker, format, arg1, arg2);
        }
    }
    
    @Override
    public void info(final Marker marker, final String format, final Object... arguments) {
        if (this.isInfoEnabled(marker)) {
            this.handleArgArrayCall(Level.INFO, marker, format, arguments);
        }
    }
    
    @Override
    public void info(final Marker marker, final String msg, final Throwable t) {
        if (this.isInfoEnabled(marker)) {
            this.handle_0ArgsCall(Level.INFO, marker, msg, t);
        }
    }
    
    @Override
    public void warn(final String msg) {
        if (this.isWarnEnabled()) {
            this.handle_0ArgsCall(Level.WARN, null, msg, null);
        }
    }
    
    @Override
    public void warn(final String format, final Object arg) {
        if (this.isWarnEnabled()) {
            this.handle_1ArgsCall(Level.WARN, null, format, arg);
        }
    }
    
    @Override
    public void warn(final String format, final Object arg1, final Object arg2) {
        if (this.isWarnEnabled()) {
            this.handle2ArgsCall(Level.WARN, null, format, arg1, arg2);
        }
    }
    
    @Override
    public void warn(final String format, final Object... arguments) {
        if (this.isWarnEnabled()) {
            this.handleArgArrayCall(Level.WARN, null, format, arguments);
        }
    }
    
    @Override
    public void warn(final String msg, final Throwable t) {
        if (this.isWarnEnabled()) {
            this.handle_0ArgsCall(Level.WARN, null, msg, t);
        }
    }
    
    @Override
    public void warn(final Marker marker, final String msg) {
        if (this.isWarnEnabled(marker)) {
            this.handle_0ArgsCall(Level.WARN, marker, msg, null);
        }
    }
    
    @Override
    public void warn(final Marker marker, final String format, final Object arg) {
        if (this.isWarnEnabled(marker)) {
            this.handle_1ArgsCall(Level.WARN, marker, format, arg);
        }
    }
    
    @Override
    public void warn(final Marker marker, final String format, final Object arg1, final Object arg2) {
        if (this.isWarnEnabled(marker)) {
            this.handle2ArgsCall(Level.WARN, marker, format, arg1, arg2);
        }
    }
    
    @Override
    public void warn(final Marker marker, final String format, final Object... arguments) {
        if (this.isWarnEnabled(marker)) {
            this.handleArgArrayCall(Level.WARN, marker, format, arguments);
        }
    }
    
    @Override
    public void warn(final Marker marker, final String msg, final Throwable t) {
        if (this.isWarnEnabled(marker)) {
            this.handle_0ArgsCall(Level.WARN, marker, msg, t);
        }
    }
    
    @Override
    public void error(final String msg) {
        if (this.isErrorEnabled()) {
            this.handle_0ArgsCall(Level.ERROR, null, msg, null);
        }
    }
    
    @Override
    public void error(final String format, final Object arg) {
        if (this.isErrorEnabled()) {
            this.handle_1ArgsCall(Level.ERROR, null, format, arg);
        }
    }
    
    @Override
    public void error(final String format, final Object arg1, final Object arg2) {
        if (this.isErrorEnabled()) {
            this.handle2ArgsCall(Level.ERROR, null, format, arg1, arg2);
        }
    }
    
    @Override
    public void error(final String format, final Object... arguments) {
        if (this.isErrorEnabled()) {
            this.handleArgArrayCall(Level.ERROR, null, format, arguments);
        }
    }
    
    @Override
    public void error(final String msg, final Throwable t) {
        if (this.isErrorEnabled()) {
            this.handle_0ArgsCall(Level.ERROR, null, msg, t);
        }
    }
    
    @Override
    public void error(final Marker marker, final String msg) {
        if (this.isErrorEnabled(marker)) {
            this.handle_0ArgsCall(Level.ERROR, marker, msg, null);
        }
    }
    
    @Override
    public void error(final Marker marker, final String format, final Object arg) {
        if (this.isErrorEnabled(marker)) {
            this.handle_1ArgsCall(Level.ERROR, marker, format, arg);
        }
    }
    
    @Override
    public void error(final Marker marker, final String format, final Object arg1, final Object arg2) {
        if (this.isErrorEnabled(marker)) {
            this.handle2ArgsCall(Level.ERROR, marker, format, arg1, arg2);
        }
    }
    
    @Override
    public void error(final Marker marker, final String format, final Object... arguments) {
        if (this.isErrorEnabled(marker)) {
            this.handleArgArrayCall(Level.ERROR, marker, format, arguments);
        }
    }
    
    @Override
    public void error(final Marker marker, final String msg, final Throwable t) {
        if (this.isErrorEnabled(marker)) {
            this.handle_0ArgsCall(Level.ERROR, marker, msg, t);
        }
    }
    
    private void handle_0ArgsCall(final Level level, final Marker marker, final String msg, final Throwable t) {
        this.handleNormalizedLoggingCall(level, marker, msg, null, t);
    }
    
    private void handle_1ArgsCall(final Level level, final Marker marker, final String msg, final Object arg1) {
        this.handleNormalizedLoggingCall(level, marker, msg, new Object[] { arg1 }, null);
    }
    
    private void handle2ArgsCall(final Level level, final Marker marker, final String msg, final Object arg1, final Object arg2) {
        if (arg2 instanceof Throwable) {
            this.handleNormalizedLoggingCall(level, marker, msg, new Object[] { arg1 }, (Throwable)arg2);
        }
        else {
            this.handleNormalizedLoggingCall(level, marker, msg, new Object[] { arg1, arg2 }, null);
        }
    }
    
    private void handleArgArrayCall(final Level level, final Marker marker, final String msg, final Object[] args) {
        final Throwable throwableCandidate = MessageFormatter.getThrowableCandidate(args);
        if (throwableCandidate != null) {
            final Object[] trimmedCopy = MessageFormatter.trimmedCopy(args);
            this.handleNormalizedLoggingCall(level, marker, msg, trimmedCopy, throwableCandidate);
        }
        else {
            this.handleNormalizedLoggingCall(level, marker, msg, args, null);
        }
    }
    
    protected abstract String getFullyQualifiedCallerName();
    
    protected abstract void handleNormalizedLoggingCall(final Level p0, final Marker p1, final String p2, final Object[] p3, final Throwable p4);
}
