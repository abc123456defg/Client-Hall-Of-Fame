// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j.spi;

import java.util.Iterator;
import org.slf4j.event.KeyValuePair;
import org.slf4j.event.LoggingEvent;
import java.util.function.Supplier;
import org.slf4j.Marker;
import org.slf4j.event.Level;
import org.slf4j.Logger;
import org.slf4j.event.DefaultLoggingEvent;

public class DefaultLoggingEventBuilder implements LoggingEventBuilder, CallerBoundaryAware
{
    static String DLEB_FQCN;
    protected DefaultLoggingEvent loggingEvent;
    protected Logger logger;
    
    public DefaultLoggingEventBuilder(final Logger logger, final Level level) {
        this.logger = logger;
        this.loggingEvent = new DefaultLoggingEvent(level, logger);
    }
    
    @Override
    public LoggingEventBuilder addMarker(final Marker marker) {
        this.loggingEvent.addMarker(marker);
        return this;
    }
    
    @Override
    public LoggingEventBuilder setCause(final Throwable t) {
        this.loggingEvent.setThrowable(t);
        return this;
    }
    
    @Override
    public LoggingEventBuilder addArgument(final Object p) {
        this.loggingEvent.addArgument(p);
        return this;
    }
    
    @Override
    public LoggingEventBuilder addArgument(final Supplier<?> objectSupplier) {
        this.loggingEvent.addArgument(objectSupplier.get());
        return this;
    }
    
    @Override
    public void setCallerBoundary(final String fqcn) {
        this.loggingEvent.setCallerBoundary(fqcn);
    }
    
    @Override
    public void log() {
        this.log(this.loggingEvent);
    }
    
    @Override
    public LoggingEventBuilder setMessage(final String message) {
        this.loggingEvent.setMessage(message);
        return this;
    }
    
    @Override
    public LoggingEventBuilder setMessage(final Supplier<String> messageSupplier) {
        this.loggingEvent.setMessage(messageSupplier.get());
        return this;
    }
    
    @Override
    public void log(final String message) {
        this.loggingEvent.setMessage(message);
        this.log(this.loggingEvent);
    }
    
    @Override
    public void log(final String message, final Object arg) {
        this.loggingEvent.setMessage(message);
        this.loggingEvent.addArgument(arg);
        this.log(this.loggingEvent);
    }
    
    @Override
    public void log(final String message, final Object arg0, final Object arg1) {
        this.loggingEvent.setMessage(message);
        this.loggingEvent.addArgument(arg0);
        this.loggingEvent.addArgument(arg1);
        this.log(this.loggingEvent);
    }
    
    @Override
    public void log(final String message, final Object... args) {
        this.loggingEvent.setMessage(message);
        this.loggingEvent.addArguments(args);
        this.log(this.loggingEvent);
    }
    
    @Override
    public void log(final Supplier<String> messageSupplier) {
        if (messageSupplier == null) {
            this.log((String)null);
        }
        else {
            this.log(messageSupplier.get());
        }
    }
    
    protected void log(final LoggingEvent aLoggingEvent) {
        this.setCallerBoundary(DefaultLoggingEventBuilder.DLEB_FQCN);
        if (this.logger instanceof LoggingEventAware) {
            ((LoggingEventAware)this.logger).log(aLoggingEvent);
        }
        else {
            this.logViaPublicSLF4JLoggerAPI(aLoggingEvent);
        }
    }
    
    private void logViaPublicSLF4JLoggerAPI(final LoggingEvent aLoggingEvent) {
        final Object[] argArray = aLoggingEvent.getArgumentArray();
        final int argLen = (argArray == null) ? 0 : argArray.length;
        final Throwable t = aLoggingEvent.getThrowable();
        final int tLen = (t != null) ? 1 : 0;
        String msg = aLoggingEvent.getMessage();
        final Object[] combinedArguments = new Object[argLen + tLen];
        if (argArray != null) {
            System.arraycopy(argArray, 0, combinedArguments, 0, argLen);
        }
        if (t != null) {
            combinedArguments[argLen] = t;
        }
        msg = this.mergeMarkersAndKeyValuePairs(aLoggingEvent, msg);
        switch (aLoggingEvent.getLevel()) {
            case TRACE: {
                this.logger.trace(msg, combinedArguments);
                break;
            }
            case DEBUG: {
                this.logger.debug(msg, combinedArguments);
                break;
            }
            case INFO: {
                this.logger.info(msg, combinedArguments);
                break;
            }
            case WARN: {
                this.logger.warn(msg, combinedArguments);
                break;
            }
            case ERROR: {
                this.logger.error(msg, combinedArguments);
                break;
            }
        }
    }
    
    private String mergeMarkersAndKeyValuePairs(final LoggingEvent aLoggingEvent, final String msg) {
        StringBuilder sb = null;
        if (aLoggingEvent.getMarkers() != null) {
            sb = new StringBuilder();
            for (final Marker marker : aLoggingEvent.getMarkers()) {
                sb.append(marker);
                sb.append(' ');
            }
        }
        if (aLoggingEvent.getKeyValuePairs() != null) {
            if (sb == null) {
                sb = new StringBuilder();
            }
            for (final KeyValuePair kvp : aLoggingEvent.getKeyValuePairs()) {
                sb.append(kvp.key);
                sb.append('=');
                sb.append(kvp.value);
                sb.append(' ');
            }
        }
        if (sb != null) {
            sb.append(msg);
            return sb.toString();
        }
        return msg;
    }
    
    @Override
    public LoggingEventBuilder addKeyValue(final String key, final Object value) {
        this.loggingEvent.addKeyValue(key, value);
        return this;
    }
    
    @Override
    public LoggingEventBuilder addKeyValue(final String key, final Supplier<Object> value) {
        this.loggingEvent.addKeyValue(key, value.get());
        return this;
    }
    
    static {
        DefaultLoggingEventBuilder.DLEB_FQCN = DefaultLoggingEventBuilder.class.getName();
    }
}
