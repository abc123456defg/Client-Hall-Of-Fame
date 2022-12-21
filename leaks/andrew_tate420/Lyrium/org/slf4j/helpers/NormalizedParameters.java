// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j.helpers;

import org.slf4j.event.LoggingEvent;

public class NormalizedParameters
{
    final String message;
    final Object[] arguments;
    final Throwable throwable;
    
    public NormalizedParameters(final String message, final Object[] arguments, final Throwable throwable) {
        this.message = message;
        this.arguments = arguments;
        this.throwable = throwable;
    }
    
    public NormalizedParameters(final String message, final Object[] arguments) {
        this(message, arguments, null);
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public Object[] getArguments() {
        return this.arguments;
    }
    
    public Throwable getThrowable() {
        return this.throwable;
    }
    
    public static Throwable getThrowableCandidate(final Object[] argArray) {
        if (argArray == null || argArray.length == 0) {
            return null;
        }
        final Object lastEntry = argArray[argArray.length - 1];
        if (lastEntry instanceof Throwable) {
            return (Throwable)lastEntry;
        }
        return null;
    }
    
    public static Object[] trimmedCopy(final Object[] argArray) {
        if (argArray == null || argArray.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        final int trimmedLen = argArray.length - 1;
        final Object[] trimmed = new Object[trimmedLen];
        if (trimmedLen > 0) {
            System.arraycopy(argArray, 0, trimmed, 0, trimmedLen);
        }
        return trimmed;
    }
    
    public static NormalizedParameters normalize(final String msg, final Object[] arguments, final Throwable t) {
        if (t != null) {
            return new NormalizedParameters(msg, arguments, t);
        }
        if (arguments == null || arguments.length == 0) {
            return new NormalizedParameters(msg, arguments, t);
        }
        final Throwable throwableCandidate = getThrowableCandidate(arguments);
        if (throwableCandidate != null) {
            final Object[] trimmedArguments = MessageFormatter.trimmedCopy(arguments);
            return new NormalizedParameters(msg, trimmedArguments, throwableCandidate);
        }
        return new NormalizedParameters(msg, arguments);
    }
    
    public static NormalizedParameters normalize(final LoggingEvent event) {
        return normalize(event.getMessage(), event.getArgumentArray(), event.getThrowable());
    }
}
