// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j;

import java.util.Arrays;
import org.slf4j.event.LoggingEvent;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Collection;
import org.slf4j.event.SubstituteLoggingEvent;
import org.slf4j.helpers.SubstituteLogger;
import java.util.Enumeration;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.net.URL;
import java.util.Set;
import org.slf4j.helpers.Util;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.ServiceLoader;
import java.util.List;
import org.slf4j.spi.SLF4JServiceProvider;
import org.slf4j.helpers.NOP_FallbackServiceProvider;
import org.slf4j.helpers.SubstituteServiceProvider;

public final class LoggerFactory
{
    static final String CODES_PREFIX = "http://www.slf4j.org/codes.html";
    static final String NO_PROVIDERS_URL = "http://www.slf4j.org/codes.html#noProviders";
    static final String IGNORED_BINDINGS_URL = "http://www.slf4j.org/codes.html#ignoredBindings";
    static final String NO_STATICLOGGERBINDER_URL = "http://www.slf4j.org/codes.html#StaticLoggerBinder";
    static final String MULTIPLE_BINDINGS_URL = "http://www.slf4j.org/codes.html#multiple_bindings";
    static final String NULL_LF_URL = "http://www.slf4j.org/codes.html#null_LF";
    static final String VERSION_MISMATCH = "http://www.slf4j.org/codes.html#version_mismatch";
    static final String SUBSTITUTE_LOGGER_URL = "http://www.slf4j.org/codes.html#substituteLogger";
    static final String LOGGER_NAME_MISMATCH_URL = "http://www.slf4j.org/codes.html#loggerNameMismatch";
    static final String REPLAY_URL = "http://www.slf4j.org/codes.html#replay";
    static final String UNSUCCESSFUL_INIT_URL = "http://www.slf4j.org/codes.html#unsuccessfulInit";
    static final String UNSUCCESSFUL_INIT_MSG = "org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit";
    static final int UNINITIALIZED = 0;
    static final int ONGOING_INITIALIZATION = 1;
    static final int FAILED_INITIALIZATION = 2;
    static final int SUCCESSFUL_INITIALIZATION = 3;
    static final int NOP_FALLBACK_INITIALIZATION = 4;
    static volatile int INITIALIZATION_STATE;
    static final SubstituteServiceProvider SUBST_PROVIDER;
    static final NOP_FallbackServiceProvider NOP_FALLBACK_SERVICE_PROVIDER;
    static final String DETECT_LOGGER_NAME_MISMATCH_PROPERTY = "slf4j.detectLoggerNameMismatch";
    static final String JAVA_VENDOR_PROPERTY = "java.vendor.url";
    static boolean DETECT_LOGGER_NAME_MISMATCH;
    static volatile SLF4JServiceProvider PROVIDER;
    private static final String[] API_COMPATIBILITY_LIST;
    private static final String STATIC_LOGGER_BINDER_PATH = "org/slf4j/impl/StaticLoggerBinder.class";
    
    private static List<SLF4JServiceProvider> findServiceProviders() {
        final ServiceLoader<SLF4JServiceProvider> serviceLoader = ServiceLoader.load(SLF4JServiceProvider.class);
        final List<SLF4JServiceProvider> providerList = new ArrayList<SLF4JServiceProvider>();
        for (final SLF4JServiceProvider provider : serviceLoader) {
            providerList.add(provider);
        }
        return providerList;
    }
    
    private LoggerFactory() {
    }
    
    static void reset() {
        LoggerFactory.INITIALIZATION_STATE = 0;
    }
    
    private static final void performInitialization() {
        bind();
        if (LoggerFactory.INITIALIZATION_STATE == 3) {
            versionSanityCheck();
        }
    }
    
    private static final void bind() {
        try {
            final List<SLF4JServiceProvider> providersList = findServiceProviders();
            reportMultipleBindingAmbiguity(providersList);
            if (providersList != null && !providersList.isEmpty()) {
                (LoggerFactory.PROVIDER = providersList.get(0)).initialize();
                LoggerFactory.INITIALIZATION_STATE = 3;
                reportActualBinding(providersList);
            }
            else {
                LoggerFactory.INITIALIZATION_STATE = 4;
                Util.report("No SLF4J providers were found.");
                Util.report("Defaulting to no-operation (NOP) logger implementation");
                Util.report("See http://www.slf4j.org/codes.html#noProviders for further details.");
                final Set<URL> staticLoggerBinderPathSet = findPossibleStaticLoggerBinderPathSet();
                reportIgnoredStaticLoggerBinders(staticLoggerBinderPathSet);
            }
            postBindCleanUp();
        }
        catch (Exception e) {
            failedBinding(e);
            throw new IllegalStateException("Unexpected initialization failure", e);
        }
    }
    
    private static void reportIgnoredStaticLoggerBinders(final Set<URL> staticLoggerBinderPathSet) {
        if (staticLoggerBinderPathSet.isEmpty()) {
            return;
        }
        Util.report("Class path contains SLF4J bindings targeting slf4j-api versions prior to 1.8.");
        for (final URL path : staticLoggerBinderPathSet) {
            Util.report("Ignoring binding found at [" + path + "]");
        }
        Util.report("See http://www.slf4j.org/codes.html#ignoredBindings for an explanation.");
    }
    
    static Set<URL> findPossibleStaticLoggerBinderPathSet() {
        final Set<URL> staticLoggerBinderPathSet = new LinkedHashSet<URL>();
        try {
            final ClassLoader loggerFactoryClassLoader = LoggerFactory.class.getClassLoader();
            Enumeration<URL> paths;
            if (loggerFactoryClassLoader == null) {
                paths = ClassLoader.getSystemResources("org/slf4j/impl/StaticLoggerBinder.class");
            }
            else {
                paths = loggerFactoryClassLoader.getResources("org/slf4j/impl/StaticLoggerBinder.class");
            }
            while (paths.hasMoreElements()) {
                final URL path = paths.nextElement();
                staticLoggerBinderPathSet.add(path);
            }
        }
        catch (IOException ioe) {
            Util.report("Error getting resources from path", ioe);
        }
        return staticLoggerBinderPathSet;
    }
    
    private static void postBindCleanUp() {
        fixSubstituteLoggers();
        replayEvents();
        LoggerFactory.SUBST_PROVIDER.getSubstituteLoggerFactory().clear();
    }
    
    private static void fixSubstituteLoggers() {
        synchronized (LoggerFactory.SUBST_PROVIDER) {
            LoggerFactory.SUBST_PROVIDER.getSubstituteLoggerFactory().postInitialization();
            for (final SubstituteLogger substLogger : LoggerFactory.SUBST_PROVIDER.getSubstituteLoggerFactory().getLoggers()) {
                final Logger logger = getLogger(substLogger.getName());
                substLogger.setDelegate(logger);
            }
        }
    }
    
    static void failedBinding(final Throwable t) {
        LoggerFactory.INITIALIZATION_STATE = 2;
        Util.report("Failed to instantiate SLF4J LoggerFactory", t);
    }
    
    private static void replayEvents() {
        final LinkedBlockingQueue<SubstituteLoggingEvent> queue = LoggerFactory.SUBST_PROVIDER.getSubstituteLoggerFactory().getEventQueue();
        final int queueSize = queue.size();
        int count = 0;
        final int maxDrain = 128;
        final List<SubstituteLoggingEvent> eventList = new ArrayList<SubstituteLoggingEvent>(128);
        while (true) {
            final int numDrained = queue.drainTo(eventList, 128);
            if (numDrained == 0) {
                break;
            }
            for (final SubstituteLoggingEvent event : eventList) {
                replaySingleEvent(event);
                if (count++ == 0) {
                    emitReplayOrSubstituionWarning(event, queueSize);
                }
            }
            eventList.clear();
        }
    }
    
    private static void emitReplayOrSubstituionWarning(final SubstituteLoggingEvent event, final int queueSize) {
        if (event.getLogger().isDelegateEventAware()) {
            emitReplayWarning(queueSize);
        }
        else if (!event.getLogger().isDelegateNOP()) {
            emitSubstitutionWarning();
        }
    }
    
    private static void replaySingleEvent(final SubstituteLoggingEvent event) {
        if (event == null) {
            return;
        }
        final SubstituteLogger substLogger = event.getLogger();
        final String loggerName = substLogger.getName();
        if (substLogger.isDelegateNull()) {
            throw new IllegalStateException("Delegate logger cannot be null at this state.");
        }
        if (!substLogger.isDelegateNOP()) {
            if (substLogger.isDelegateEventAware()) {
                substLogger.log(event);
            }
            else {
                Util.report(loggerName);
            }
        }
    }
    
    private static void emitSubstitutionWarning() {
        Util.report("The following set of substitute loggers may have been accessed");
        Util.report("during the initialization phase. Logging calls during this");
        Util.report("phase were not honored. However, subsequent logging calls to these");
        Util.report("loggers will work as normally expected.");
        Util.report("See also http://www.slf4j.org/codes.html#substituteLogger");
    }
    
    private static void emitReplayWarning(final int eventCount) {
        Util.report("A number (" + eventCount + ") of logging calls during the initialization phase have been intercepted and are");
        Util.report("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        Util.report("See also http://www.slf4j.org/codes.html#replay");
    }
    
    private static final void versionSanityCheck() {
        try {
            final String requested = LoggerFactory.PROVIDER.getRequestedApiVersion();
            boolean match = false;
            for (final String aAPI_COMPATIBILITY_LIST : LoggerFactory.API_COMPATIBILITY_LIST) {
                if (requested.startsWith(aAPI_COMPATIBILITY_LIST)) {
                    match = true;
                }
            }
            if (!match) {
                Util.report("The requested version " + requested + " by your slf4j binding is not compatible with " + Arrays.asList(LoggerFactory.API_COMPATIBILITY_LIST).toString());
                Util.report("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
            }
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        catch (Throwable e) {
            Util.report("Unexpected problem occured during version sanity check", e);
        }
    }
    
    private static boolean isAmbiguousProviderList(final List<SLF4JServiceProvider> providerList) {
        return providerList.size() > 1;
    }
    
    private static void reportMultipleBindingAmbiguity(final List<SLF4JServiceProvider> providerList) {
        if (isAmbiguousProviderList(providerList)) {
            Util.report("Class path contains multiple SLF4J providers.");
            for (final SLF4JServiceProvider provider : providerList) {
                Util.report("Found provider [" + provider + "]");
            }
            Util.report("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }
    
    private static void reportActualBinding(final List<SLF4JServiceProvider> providerList) {
        if (!providerList.isEmpty() && isAmbiguousProviderList(providerList)) {
            Util.report("Actual provider is of type [" + providerList.get(0) + "]");
        }
    }
    
    public static Logger getLogger(final String name) {
        final ILoggerFactory iLoggerFactory = getILoggerFactory();
        return iLoggerFactory.getLogger(name);
    }
    
    public static Logger getLogger(final Class<?> clazz) {
        final Logger logger = getLogger(clazz.getName());
        if (LoggerFactory.DETECT_LOGGER_NAME_MISMATCH) {
            final Class<?> autoComputedCallingClass = Util.getCallingClass();
            if (autoComputedCallingClass != null && nonMatchingClasses(clazz, autoComputedCallingClass)) {
                Util.report(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", logger.getName(), autoComputedCallingClass.getName()));
                Util.report("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
            }
        }
        return logger;
    }
    
    private static boolean nonMatchingClasses(final Class<?> clazz, final Class<?> autoComputedCallingClass) {
        return !autoComputedCallingClass.isAssignableFrom(clazz);
    }
    
    public static ILoggerFactory getILoggerFactory() {
        return getProvider().getLoggerFactory();
    }
    
    static SLF4JServiceProvider getProvider() {
        if (LoggerFactory.INITIALIZATION_STATE == 0) {
            synchronized (LoggerFactory.class) {
                if (LoggerFactory.INITIALIZATION_STATE == 0) {
                    LoggerFactory.INITIALIZATION_STATE = 1;
                    performInitialization();
                }
            }
        }
        switch (LoggerFactory.INITIALIZATION_STATE) {
            case 3: {
                return LoggerFactory.PROVIDER;
            }
            case 4: {
                return LoggerFactory.NOP_FALLBACK_SERVICE_PROVIDER;
            }
            case 2: {
                throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
            }
            case 1: {
                return LoggerFactory.SUBST_PROVIDER;
            }
            default: {
                throw new IllegalStateException("Unreachable code");
            }
        }
    }
    
    static {
        LoggerFactory.INITIALIZATION_STATE = 0;
        SUBST_PROVIDER = new SubstituteServiceProvider();
        NOP_FALLBACK_SERVICE_PROVIDER = new NOP_FallbackServiceProvider();
        LoggerFactory.DETECT_LOGGER_NAME_MISMATCH = Util.safeGetBooleanSystemProperty("slf4j.detectLoggerNameMismatch");
        API_COMPATIBILITY_LIST = new String[] { "2.0" };
    }
}
