// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

public class SystemInfo
{
    public static final String OS_NAME;
    public static final String OS_VERSION;
    public static final String JAVA_VERSION;
    public static final String JAVA_RUNTIME_VERSION;
    protected static final String _OS_NAME;
    public static final boolean isWindows;
    public static final boolean isOS2;
    public static final boolean isMac;
    public static final boolean isLinux;
    public static final boolean isUnix;
    public static final boolean isFileSystemCaseSensitive;
    public static final boolean isMacOSLion;
    public static final boolean isAppleJvm;
    public static final boolean isOracleJvm;
    public static final boolean isSunJvm;
    public static final boolean isJetbrainsJvm;
    
    public static boolean isOsVersionAtLeast(final String version) {
        return compareVersionNumbers(SystemInfo.OS_VERSION, version) >= 0;
    }
    
    private static boolean isTiger() {
        return SystemInfo.isMac && !SystemInfo.OS_VERSION.startsWith("10.0") && !SystemInfo.OS_VERSION.startsWith("10.1") && !SystemInfo.OS_VERSION.startsWith("10.2") && !SystemInfo.OS_VERSION.startsWith("10.3");
    }
    
    private static boolean isLeopard() {
        return SystemInfo.isMac && isTiger() && !SystemInfo.OS_VERSION.startsWith("10.4");
    }
    
    private static boolean isSnowLeopard() {
        return SystemInfo.isMac && isLeopard() && !SystemInfo.OS_VERSION.startsWith("10.5");
    }
    
    private static boolean isLion() {
        return SystemInfo.isMac && isSnowLeopard() && !SystemInfo.OS_VERSION.startsWith("10.6");
    }
    
    private static boolean isMountainLion() {
        return SystemInfo.isMac && isLion() && !SystemInfo.OS_VERSION.startsWith("10.7");
    }
    
    public static int compareVersionNumbers(final String v1, final String v2) {
        if (v1 == null && v2 == null) {
            return 0;
        }
        if (v1 == null) {
            return -1;
        }
        if (v2 == null) {
            return 1;
        }
        String[] part1;
        String[] part2;
        int idx;
        String p1;
        String p2;
        int cmp;
        for (part1 = v1.split("[\\.\\_\\-]"), part2 = v2.split("[\\.\\_\\-]"), idx = 0; idx < part1.length && idx < part2.length; ++idx) {
            p1 = part1[idx];
            p2 = part2[idx];
            if (p1.matches("\\d+") && p2.matches("\\d+")) {
                cmp = new Integer(p1).compareTo(new Integer(p2));
            }
            else {
                cmp = part1[idx].compareTo(part2[idx]);
            }
            if (cmp != 0) {
                return cmp;
            }
        }
        if (part1.length == part2.length) {
            return 0;
        }
        if (part1.length > idx) {
            return 1;
        }
        return -1;
    }
    
    public static boolean isJavaVersionAtLeast(final String v) {
        return StringUtil.compareVersionNumbers(SystemInfo.JAVA_RUNTIME_VERSION, v) >= 0;
    }
    
    private static boolean isOracleJvm() {
        final String vendor = getJavaVmVendor();
        return vendor != null && StringUtil.containsIgnoreCase(vendor, "Oracle");
    }
    
    private static boolean isSunJvm() {
        final String vendor = getJavaVmVendor();
        return vendor != null && StringUtil.containsIgnoreCase(vendor, "Sun") && StringUtil.containsIgnoreCase(vendor, "Microsystems");
    }
    
    private static boolean isAppleJvm() {
        final String vendor = getJavaVmVendor();
        return vendor != null && StringUtil.containsIgnoreCase(vendor, "Apple");
    }
    
    public static String getJavaVmVendor() {
        return System.getProperty("java.vm.vendor");
    }
    
    private static boolean isJetbrainsJvm() {
        final String vendor = System.getProperty("java.vendor");
        return vendor != null && StringUtil.containsIgnoreCase(vendor, "jetbrains");
    }
    
    static {
        OS_NAME = System.getProperty("os.name");
        OS_VERSION = System.getProperty("os.version").toLowerCase();
        JAVA_VERSION = System.getProperty("java.version");
        JAVA_RUNTIME_VERSION = System.getProperty("java.runtime.version");
        _OS_NAME = SystemInfo.OS_NAME.toLowerCase();
        isWindows = SystemInfo._OS_NAME.startsWith("windows");
        isOS2 = (SystemInfo._OS_NAME.startsWith("os/2") || SystemInfo._OS_NAME.startsWith("os2"));
        isMac = SystemInfo._OS_NAME.startsWith("mac");
        isLinux = SystemInfo._OS_NAME.startsWith("linux");
        isUnix = (!SystemInfo.isWindows && !SystemInfo.isOS2);
        isFileSystemCaseSensitive = (SystemInfo.isUnix && !SystemInfo.isMac);
        isMacOSLion = isLion();
        isAppleJvm = isAppleJvm();
        isOracleJvm = isOracleJvm();
        isSunJvm = isSunJvm();
        isJetbrainsJvm = isJetbrainsJvm();
    }
}
