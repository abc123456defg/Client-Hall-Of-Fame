// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j.helpers;

import org.slf4j.Marker;
import org.slf4j.Logger;

public class NOPLogger extends NamedLoggerBase implements Logger
{
    private static final long serialVersionUID = -517220405410904473L;
    public static final NOPLogger NOP_LOGGER;
    
    protected NOPLogger() {
    }
    
    @Override
    public String getName() {
        return "NOP";
    }
    
    @Override
    public final boolean isTraceEnabled() {
        return false;
    }
    
    @Override
    public final void trace(final String msg) {
    }
    
    @Override
    public final void trace(final String format, final Object arg) {
    }
    
    @Override
    public final void trace(final String format, final Object arg1, final Object arg2) {
    }
    
    @Override
    public final void trace(final String format, final Object... argArray) {
    }
    
    @Override
    public final void trace(final String msg, final Throwable t) {
    }
    
    @Override
    public final boolean isDebugEnabled() {
        return false;
    }
    
    @Override
    public final void debug(final String msg) {
    }
    
    @Override
    public final void debug(final String format, final Object arg) {
    }
    
    @Override
    public final void debug(final String format, final Object arg1, final Object arg2) {
    }
    
    @Override
    public final void debug(final String format, final Object... argArray) {
    }
    
    @Override
    public final void debug(final String msg, final Throwable t) {
    }
    
    @Override
    public final boolean isInfoEnabled() {
        return false;
    }
    
    @Override
    public final void info(final String msg) {
    }
    
    @Override
    public final void info(final String format, final Object arg1) {
    }
    
    @Override
    public final void info(final String format, final Object arg1, final Object arg2) {
    }
    
    @Override
    public final void info(final String format, final Object... argArray) {
    }
    
    @Override
    public final void info(final String msg, final Throwable t) {
    }
    
    @Override
    public final boolean isWarnEnabled() {
        return false;
    }
    
    @Override
    public final void warn(final String msg) {
    }
    
    @Override
    public final void warn(final String format, final Object arg1) {
    }
    
    @Override
    public final void warn(final String format, final Object arg1, final Object arg2) {
    }
    
    @Override
    public final void warn(final String format, final Object... argArray) {
    }
    
    @Override
    public final void warn(final String msg, final Throwable t) {
    }
    
    @Override
    public final boolean isErrorEnabled() {
        return false;
    }
    
    @Override
    public final void error(final String msg) {
    }
    
    @Override
    public final void error(final String format, final Object arg1) {
    }
    
    @Override
    public final void error(final String format, final Object arg1, final Object arg2) {
    }
    
    @Override
    public final void error(final String format, final Object... argArray) {
    }
    
    @Override
    public final void error(final String msg, final Throwable t) {
    }
    
    @Override
    public final boolean isTraceEnabled(final Marker marker) {
        return false;
    }
    
    @Override
    public final void trace(final Marker marker, final String msg) {
    }
    
    @Override
    public final void trace(final Marker marker, final String format, final Object arg) {
    }
    
    @Override
    public final void trace(final Marker marker, final String format, final Object arg1, final Object arg2) {
    }
    
    @Override
    public final void trace(final Marker marker, final String format, final Object... argArray) {
    }
    
    @Override
    public final void trace(final Marker marker, final String msg, final Throwable t) {
    }
    
    @Override
    public final boolean isDebugEnabled(final Marker marker) {
        return false;
    }
    
    @Override
    public final void debug(final Marker marker, final String msg) {
    }
    
    @Override
    public final void debug(final Marker marker, final String format, final Object arg) {
    }
    
    @Override
    public final void debug(final Marker marker, final String format, final Object arg1, final Object arg2) {
    }
    
    @Override
    public final void debug(final Marker marker, final String format, final Object... arguments) {
    }
    
    @Override
    public final void debug(final Marker marker, final String msg, final Throwable t) {
    }
    
    @Override
    public boolean isInfoEnabled(final Marker marker) {
        return false;
    }
    
    @Override
    public final void info(final Marker marker, final String msg) {
    }
    
    @Override
    public final void info(final Marker marker, final String format, final Object arg) {
    }
    
    @Override
    public final void info(final Marker marker, final String format, final Object arg1, final Object arg2) {
    }
    
    @Override
    public final void info(final Marker marker, final String format, final Object... arguments) {
    }
    
    @Override
    public final void info(final Marker marker, final String msg, final Throwable t) {
    }
    
    @Override
    public final boolean isWarnEnabled(final Marker marker) {
        return false;
    }
    
    @Override
    public final void warn(final Marker marker, final String msg) {
    }
    
    @Override
    public final void warn(final Marker marker, final String format, final Object arg) {
    }
    
    @Override
    public final void warn(final Marker marker, final String format, final Object arg1, final Object arg2) {
    }
    
    @Override
    public final void warn(final Marker marker, final String format, final Object... arguments) {
    }
    
    @Override
    public final void warn(final Marker marker, final String msg, final Throwable t) {
    }
    
    @Override
    public final boolean isErrorEnabled(final Marker marker) {
        return false;
    }
    
    @Override
    public final void error(final Marker marker, final String msg) {
    }
    
    @Override
    public final void error(final Marker marker, final String format, final Object arg) {
    }
    
    @Override
    public final void error(final Marker marker, final String format, final Object arg1, final Object arg2) {
    }
    
    @Override
    public final void error(final Marker marker, final String format, final Object... arguments) {
    }
    
    @Override
    public final void error(final Marker marker, final String msg, final Throwable t) {
    }
    
    static {
        NOP_LOGGER = new NOPLogger();
    }
}
