// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Constructor;
import ch.qos.logback.core.util.Loader;
import ch.qos.logback.classic.selector.ContextJNDISelector;
import ch.qos.logback.classic.selector.DefaultContextSelector;
import ch.qos.logback.core.util.OptionHelper;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.util.StatusPrinter;
import ch.qos.logback.core.joran.spi.JoranException;
import org.slf4j.helpers.Util;
import ch.qos.logback.classic.util.ContextInitializer;
import ch.qos.logback.classic.selector.ContextSelector;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.spi.LoggerFactoryBinder;

public class StaticLoggerBinder implements LoggerFactoryBinder
{
    public static String REQUESTED_API_VERSION;
    static final String NULL_CS_URL = "http://logback.qos.ch/codes.html#null_CS";
    private static StaticLoggerBinder SINGLETON;
    private boolean initialized;
    private LoggerContext defaultLoggerContext;
    private ContextSelector contextSelector;
    
    private StaticLoggerBinder() {
        this.initialized = false;
        (this.defaultLoggerContext = new LoggerContext()).setName("default");
    }
    
    public static StaticLoggerBinder getSingleton() {
        return StaticLoggerBinder.SINGLETON;
    }
    
    static void reset() {
        (StaticLoggerBinder.SINGLETON = new StaticLoggerBinder()).init();
    }
    
    void init() {
        try {
            try {
                new ContextInitializer(this.defaultLoggerContext).autoConfig();
            }
            catch (JoranException je) {
                Util.reportFailure("Failed to auto configure default logger context", (Throwable)je);
            }
            StatusPrinter.printInCaseOfErrorsOrWarnings((Context)this.defaultLoggerContext);
            final String contextSelectorStr = OptionHelper.getSystemProperty("logback.ContextSelector");
            if (contextSelectorStr == null) {
                this.contextSelector = (ContextSelector)new DefaultContextSelector(this.defaultLoggerContext);
            }
            else if (contextSelectorStr.equals("JNDI")) {
                this.contextSelector = (ContextSelector)new ContextJNDISelector(this.defaultLoggerContext);
            }
            else {
                this.contextSelector = dynamicalContextSelector(this.defaultLoggerContext, contextSelectorStr);
            }
            this.initialized = true;
        }
        catch (Throwable t) {
            Util.reportFailure("Failed to instantiate [" + LoggerContext.class.getName() + "]", t);
        }
    }
    
    static ContextSelector dynamicalContextSelector(final LoggerContext defaultLoggerContext, final String contextSelectorStr) throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
        final Class<?> contextSelectorClass = (Class<?>)Loader.loadClass(contextSelectorStr);
        final Constructor cons = contextSelectorClass.getConstructor(LoggerContext.class);
        return cons.newInstance(defaultLoggerContext);
    }
    
    public ILoggerFactory getLoggerFactory() {
        if (!this.initialized) {
            return (ILoggerFactory)this.defaultLoggerContext;
        }
        if (this.contextSelector == null) {
            throw new IllegalStateException("contextSelector cannot be null. See also http://logback.qos.ch/codes.html#null_CS");
        }
        return (ILoggerFactory)this.contextSelector.getLoggerContext();
    }
    
    public String getLoggerFactoryClassStr() {
        return this.contextSelector.getClass().getName();
    }
    
    public ContextSelector getContextSelector() {
        return this.contextSelector;
    }
    
    static {
        StaticLoggerBinder.REQUESTED_API_VERSION = "1.5.6";
        (StaticLoggerBinder.SINGLETON = new StaticLoggerBinder()).init();
    }
}
