// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j.event;

public enum Level
{
    ERROR(40, "ERROR"), 
    WARN(30, "WARN"), 
    INFO(20, "INFO"), 
    DEBUG(10, "DEBUG"), 
    TRACE(0, "TRACE");
    
    private final int levelInt;
    private final String levelStr;
    
    private Level(final int i, final String s) {
        this.levelInt = i;
        this.levelStr = s;
    }
    
    public int toInt() {
        return this.levelInt;
    }
    
    public static Level intToLevel(final int levelInt) {
        switch (levelInt) {
            case 0: {
                return Level.TRACE;
            }
            case 10: {
                return Level.DEBUG;
            }
            case 20: {
                return Level.INFO;
            }
            case 30: {
                return Level.WARN;
            }
            case 40: {
                return Level.ERROR;
            }
            default: {
                throw new IllegalArgumentException("Level integer [" + levelInt + "] not recognized.");
            }
        }
    }
    
    @Override
    public String toString() {
        return this.levelStr;
    }
    
    private static /* synthetic */ Level[] $values() {
        return new Level[] { Level.ERROR, Level.WARN, Level.INFO, Level.DEBUG, Level.TRACE };
    }
    
    static {
        $VALUES = $values();
    }
}
