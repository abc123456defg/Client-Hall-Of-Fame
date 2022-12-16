// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.comparisons;

import kotlin.internal.InlineOnly;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000F\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\b\u001a!\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\b\u001a!\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007\u001a-\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\b\u001a!\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\b\u001a!\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007¨\u0006\u0018" }, d2 = { "maxOf", "T", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "c", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "other", "", "(Ljava/lang/Comparable;[Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "", "", "", "", "", "", "minOf", "kotlin-stdlib" }, xs = "kotlin/comparisons/ComparisonsKt")
class ComparisonsKt___ComparisonsJvmKt extends ComparisonsKt__ComparisonsKt
{
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T maxOf(@NotNull final T a, @NotNull final T b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        return (a.compareTo((Object)b) >= 0) ? a : b;
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte maxOf(final byte a, final byte b) {
        return (byte)Math.max(a, b);
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short maxOf(final short a, final short b) {
        return (short)Math.max(a, b);
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int maxOf(final int a, final int b) {
        return Math.max(a, b);
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long maxOf(final long a, final long b) {
        return Math.max(a, b);
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float maxOf(final float a, final float b) {
        return Math.max(a, b);
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double maxOf(final double a, final double b) {
        return Math.max(a, b);
    }
    
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T maxOf(@NotNull final T a, @NotNull final T b, @NotNull final T c) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Intrinsics.checkNotNullParameter(c, "c");
        return maxOf(a, maxOf(b, c));
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte maxOf(final byte a, final byte b, final byte c) {
        return (byte)Math.max(a, Math.max(b, c));
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short maxOf(final short a, final short b, final short c) {
        return (short)Math.max(a, Math.max(b, c));
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int maxOf(final int a, final int b, final int c) {
        return Math.max(a, Math.max(b, c));
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long maxOf(final long a, final long b, final long c) {
        return Math.max(a, Math.max(b, c));
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float maxOf(final float a, final float b, final float c) {
        return Math.max(a, Math.max(b, c));
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double maxOf(final double a, final double b, final double c) {
        return Math.max(a, Math.max(b, c));
    }
    
    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T extends Comparable<? super T>> T maxOf(@NotNull final T a, @NotNull final T... other) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(other, "other");
        Comparable max = a;
        for (int i = 0; i < other.length; ++i) {
            final Comparable e = other[i];
            max = maxOf(max, e);
        }
        return (T)max;
    }
    
    @SinceKotlin(version = "1.4")
    public static final byte maxOf(final byte a, @NotNull final byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        byte max = a;
        for (int i = 0; i < other.length; ++i) {
            final byte e = other[i];
            max = (byte)Math.max(max, e);
        }
        return max;
    }
    
    @SinceKotlin(version = "1.4")
    public static final short maxOf(final short a, @NotNull final short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        short max = a;
        for (int i = 0; i < other.length; ++i) {
            final short e = other[i];
            max = (short)Math.max(max, e);
        }
        return max;
    }
    
    @SinceKotlin(version = "1.4")
    public static final int maxOf(final int a, @NotNull final int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int max = a;
        for (int i = 0; i < other.length; ++i) {
            final int e = other[i];
            max = Math.max(max, e);
        }
        return max;
    }
    
    @SinceKotlin(version = "1.4")
    public static final long maxOf(final long a, @NotNull final long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        long max = a;
        for (int i = 0; i < other.length; ++i) {
            final long e = other[i];
            max = Math.max(max, e);
        }
        return max;
    }
    
    @SinceKotlin(version = "1.4")
    public static final float maxOf(final float a, @NotNull final float... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        float max = a;
        for (int i = 0; i < other.length; ++i) {
            final float e = other[i];
            max = Math.max(max, e);
        }
        return max;
    }
    
    @SinceKotlin(version = "1.4")
    public static final double maxOf(final double a, @NotNull final double... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        double max = a;
        for (int i = 0; i < other.length; ++i) {
            final double e = other[i];
            max = Math.max(max, e);
        }
        return max;
    }
    
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T minOf(@NotNull final T a, @NotNull final T b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        return (a.compareTo((Object)b) <= 0) ? a : b;
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte minOf(final byte a, final byte b) {
        return (byte)Math.min(a, b);
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short minOf(final short a, final short b) {
        return (short)Math.min(a, b);
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int minOf(final int a, final int b) {
        return Math.min(a, b);
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long minOf(final long a, final long b) {
        return Math.min(a, b);
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float minOf(final float a, final float b) {
        return Math.min(a, b);
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double minOf(final double a, final double b) {
        return Math.min(a, b);
    }
    
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T minOf(@NotNull final T a, @NotNull final T b, @NotNull final T c) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Intrinsics.checkNotNullParameter(c, "c");
        return minOf(a, minOf(b, c));
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte minOf(final byte a, final byte b, final byte c) {
        return (byte)Math.min(a, Math.min(b, c));
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short minOf(final short a, final short b, final short c) {
        return (short)Math.min(a, Math.min(b, c));
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int minOf(final int a, final int b, final int c) {
        return Math.min(a, Math.min(b, c));
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long minOf(final long a, final long b, final long c) {
        return Math.min(a, Math.min(b, c));
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float minOf(final float a, final float b, final float c) {
        return Math.min(a, Math.min(b, c));
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double minOf(final double a, final double b, final double c) {
        return Math.min(a, Math.min(b, c));
    }
    
    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T extends Comparable<? super T>> T minOf(@NotNull final T a, @NotNull final T... other) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(other, "other");
        Comparable min = a;
        for (int i = 0; i < other.length; ++i) {
            final Comparable e = other[i];
            min = minOf(min, e);
        }
        return (T)min;
    }
    
    @SinceKotlin(version = "1.4")
    public static final byte minOf(final byte a, @NotNull final byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        byte min = a;
        for (int i = 0; i < other.length; ++i) {
            final byte e = other[i];
            min = (byte)Math.min(min, e);
        }
        return min;
    }
    
    @SinceKotlin(version = "1.4")
    public static final short minOf(final short a, @NotNull final short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        short min = a;
        for (int i = 0; i < other.length; ++i) {
            final short e = other[i];
            min = (short)Math.min(min, e);
        }
        return min;
    }
    
    @SinceKotlin(version = "1.4")
    public static final int minOf(final int a, @NotNull final int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int min = a;
        for (int i = 0; i < other.length; ++i) {
            final int e = other[i];
            min = Math.min(min, e);
        }
        return min;
    }
    
    @SinceKotlin(version = "1.4")
    public static final long minOf(final long a, @NotNull final long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        long min = a;
        for (int i = 0; i < other.length; ++i) {
            final long e = other[i];
            min = Math.min(min, e);
        }
        return min;
    }
    
    @SinceKotlin(version = "1.4")
    public static final float minOf(final float a, @NotNull final float... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        float min = a;
        for (int i = 0; i < other.length; ++i) {
            final float e = other[i];
            min = Math.min(min, e);
        }
        return min;
    }
    
    @SinceKotlin(version = "1.4")
    public static final double minOf(final double a, @NotNull final double... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        double min = a;
        for (int i = 0; i < other.length; ++i) {
            final double e = other[i];
            min = Math.min(min, e);
        }
        return min;
    }
    
    public ComparisonsKt___ComparisonsJvmKt() {
    }
}
