// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.comparisons;

import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import java.util.Comparator;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000\u0018\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\u001aG\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\b\u001a?\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\t\u001aK\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000b\"\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\f\u001aG\u0010\r\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\b\u001a?\u0010\r\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\t\u001aK\u0010\r\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000b\"\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\f¨\u0006\u000e" }, d2 = { "maxOf", "T", "a", "b", "c", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "other", "", "(Ljava/lang/Object;[Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "minOf", "kotlin-stdlib" }, xs = "kotlin/comparisons/ComparisonsKt")
class ComparisonsKt___ComparisonsKt extends ComparisonsKt___ComparisonsJvmKt
{
    @SinceKotlin(version = "1.1")
    public static final <T> T maxOf(final T a, final T b, final T c, @NotNull final Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return maxOf(a, maxOf(b, c, comparator), comparator);
    }
    
    @SinceKotlin(version = "1.1")
    public static final <T> T maxOf(final T a, final T b, @NotNull final Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (comparator.compare(a, b) >= 0) ? a : b;
    }
    
    @SinceKotlin(version = "1.4")
    public static final <T> T maxOf(final T a, @NotNull final T[] other, @NotNull final Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Object max = a;
        for (int i = 0; i < other.length; ++i) {
            final Object e = other[i];
            if (comparator.compare((Object)max, (Object)e) < 0) {
                max = e;
            }
        }
        return (T)max;
    }
    
    @SinceKotlin(version = "1.1")
    public static final <T> T minOf(final T a, final T b, final T c, @NotNull final Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return minOf(a, minOf(b, c, comparator), comparator);
    }
    
    @SinceKotlin(version = "1.1")
    public static final <T> T minOf(final T a, final T b, @NotNull final Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (comparator.compare(a, b) <= 0) ? a : b;
    }
    
    @SinceKotlin(version = "1.4")
    public static final <T> T minOf(final T a, @NotNull final T[] other, @NotNull final Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Object min = a;
        for (int i = 0; i < other.length; ++i) {
            final Object e = other[i];
            if (comparator.compare((Object)min, (Object)e) > 0) {
                min = e;
            }
        }
        return (T)min;
    }
    
    public ComparisonsKt___ComparisonsKt() {
    }
}
