// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j;

public class LoggerFactoryFriend
{
    public static void reset() {
        LoggerFactory.reset();
    }
    
    public static void setDetectLoggerNameMismatch(final boolean enabled) {
        LoggerFactory.DETECT_LOGGER_NAME_MISMATCH = enabled;
    }
}
