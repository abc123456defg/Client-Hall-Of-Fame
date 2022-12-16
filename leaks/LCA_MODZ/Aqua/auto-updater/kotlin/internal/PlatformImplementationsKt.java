// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.internal;

import kotlin.SinceKotlin;
import kotlin.PublishedApi;
import kotlin.KotlinVersion;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.jvm.JvmField;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0001\u001a\"\u0010\b\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0083\b¢\u0006\u0002\u0010\f\u001a\b\u0010\r\u001a\u00020\u0005H\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e" }, d2 = { "IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", "T", "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "kotlin-stdlib" })
public final class PlatformImplementationsKt
{
    @JvmField
    @NotNull
    public static final PlatformImplementations IMPLEMENTATIONS;
    
    private static final int getJavaVersion() {
        final int default1 = 65542;
        final String property = System.getProperty("java.specification.version");
        if (property == null) {
            return default1;
        }
        final String version = property;
        final int firstDot = StringsKt__StringsKt.indexOf$default(version, '.', 0, false, 6, null);
        if (firstDot < 0) {
            int n;
            try {
                n = Integer.parseInt(version) * 65536;
            }
            catch (NumberFormatException e) {
                n = default1;
            }
            return n;
        }
        int secondDot = StringsKt__StringsKt.indexOf$default(version, '.', firstDot + 1, false, 4, null);
        if (secondDot < 0) {
            secondDot = version.length();
        }
        final String substring = version.substring(0, firstDot);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        final String firstPart = substring;
        final String substring2 = version.substring(firstDot + 1, secondDot);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        final String secondPart = substring2;
        int n2;
        try {
            n2 = Integer.parseInt(firstPart) * 65536 + Integer.parseInt(secondPart);
        }
        catch (NumberFormatException e2) {
            n2 = default1;
        }
        return n2;
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.2")
    public static final boolean apiVersionIsAtLeast(final int major, final int minor, final int patch) {
        return KotlinVersion.CURRENT.isAtLeast(major, minor, patch);
    }
    
    static {
        final int n = 0;
        final int version = getJavaVersion();
        PlatformImplementations implementations = null;
        Label_0489: {
            Label_0244: {
                if (version < 65544) {
                    if (version >= 65536) {
                        break Label_0244;
                    }
                }
                try {
                    final Object instance = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                    Intrinsics.checkNotNullExpressionValue(instance, "forName(\"kotlin.internal\u2026entations\").newInstance()");
                    final Object o = instance;
                    try {
                        final Object o2 = o;
                        if (o2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        implementations = (PlatformImplementations)o2;
                    }
                    catch (ClassCastException ex) {
                        final ClassLoader classLoader = ((PlatformImplementations)o).getClass().getClassLoader();
                        final ClassLoader classLoader2 = PlatformImplementations.class.getClassLoader();
                        if (!Intrinsics.areEqual(classLoader, classLoader2)) {
                            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, ex);
                        }
                        throw ex;
                    }
                    break Label_0489;
                }
                catch (ClassNotFoundException ex5) {
                    try {
                        final Object instance2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                        Intrinsics.checkNotNullExpressionValue(instance2, "forName(\"kotlin.internal\u2026entations\").newInstance()");
                        final Object o3 = instance2;
                        try {
                            final Object o4 = o3;
                            if (o4 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                            }
                            implementations = (PlatformImplementations)o4;
                        }
                        catch (ClassCastException ex2) {
                            final ClassLoader classLoader3 = ((PlatformImplementations)o3).getClass().getClassLoader();
                            final ClassLoader classLoader4 = PlatformImplementations.class.getClassLoader();
                            if (!Intrinsics.areEqual(classLoader3, classLoader4)) {
                                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, ex2);
                            }
                            throw ex2;
                        }
                    }
                    catch (ClassNotFoundException ex6) {}
                }
            }
            Label_0482: {
                if (version < 65543) {
                    if (version >= 65536) {
                        break Label_0482;
                    }
                }
                try {
                    final Object instance3 = Class.forName("kotlin.internal.jdk7.JDK7PlatformImplementations").newInstance();
                    Intrinsics.checkNotNullExpressionValue(instance3, "forName(\"kotlin.internal\u2026entations\").newInstance()");
                    final Object o5 = instance3;
                    try {
                        final Object o6 = o5;
                        if (o6 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        implementations = (PlatformImplementations)o6;
                    }
                    catch (ClassCastException ex3) {
                        final ClassLoader classLoader5 = ((PlatformImplementations)o5).getClass().getClassLoader();
                        final ClassLoader classLoader6 = PlatformImplementations.class.getClassLoader();
                        if (!Intrinsics.areEqual(classLoader5, classLoader6)) {
                            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, ex3);
                        }
                        throw ex3;
                    }
                    break Label_0489;
                }
                catch (ClassNotFoundException ex7) {
                    try {
                        final Object instance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                        Intrinsics.checkNotNullExpressionValue(instance4, "forName(\"kotlin.internal\u2026entations\").newInstance()");
                        final Object o7 = instance4;
                        try {
                            final Object o8 = o7;
                            if (o8 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                            }
                            implementations = (PlatformImplementations)o8;
                        }
                        catch (ClassCastException ex4) {
                            final ClassLoader classLoader7 = ((PlatformImplementations)o7).getClass().getClassLoader();
                            final ClassLoader classLoader8 = PlatformImplementations.class.getClassLoader();
                            if (!Intrinsics.areEqual(classLoader7, classLoader8)) {
                                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, ex4);
                            }
                            throw ex4;
                        }
                    }
                    catch (ClassNotFoundException ex8) {}
                }
            }
            implementations = new PlatformImplementations();
        }
        IMPLEMENTATIONS = implementations;
    }
}
