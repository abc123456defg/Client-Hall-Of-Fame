// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.sequences;

import java.math.BigInteger;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.OverloadResolutionByLambdaReturnType;
import java.math.BigDecimal;
import kotlin.SinceKotlin;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ReplaceWith;
import kotlin.Deprecated;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.SortedSet;
import java.util.Iterator;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001aA\u0010\u0005\u001a\u0002H\u0006\"\u0010\b\u0000\u0010\u0006*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0007\"\u0004\b\u0001\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\b\u001a\u0002H\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¢\u0006\u0002\u0010\t\u001a)\u0010\n\u001a\u0004\u0018\u0001H\u000b\"\u000e\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f*\b\u0012\u0004\u0012\u0002H\u000b0\u0001H\u0007¢\u0006\u0002\u0010\r\u001a\u0019\u0010\n\u001a\u0004\u0018\u00010\u000e*\b\u0012\u0004\u0012\u00020\u000e0\u0001H\u0007¢\u0006\u0002\u0010\u000f\u001a\u0019\u0010\n\u001a\u0004\u0018\u00010\u0010*\b\u0012\u0004\u0012\u00020\u00100\u0001H\u0007¢\u0006\u0002\u0010\u0011\u001aG\u0010\u0012\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f*\b\u0012\u0004\u0012\u0002H\u000b0\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u00020\u0014H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a;\u0010\u0016\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00012\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000b0\u0018j\n\u0012\u0006\b\u0000\u0012\u0002H\u000b`\u0019H\u0007¢\u0006\u0002\u0010\u001a\u001a)\u0010\u001b\u001a\u0004\u0018\u0001H\u000b\"\u000e\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f*\b\u0012\u0004\u0012\u0002H\u000b0\u0001H\u0007¢\u0006\u0002\u0010\r\u001a\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u000e*\b\u0012\u0004\u0012\u00020\u000e0\u0001H\u0007¢\u0006\u0002\u0010\u000f\u001a\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u0010*\b\u0012\u0004\u0012\u00020\u00100\u0001H\u0007¢\u0006\u0002\u0010\u0011\u001aG\u0010\u001c\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f*\b\u0012\u0004\u0012\u0002H\u000b0\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u00020\u0014H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a;\u0010\u001d\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00012\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000b0\u0018j\n\u0012\u0006\b\u0000\u0012\u0002H\u000b`\u0019H\u0007¢\u0006\u0002\u0010\u001a\u001a5\u0010\u001e\u001a\u00020\u001f\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u001f0\u0014H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\b \u001a5\u0010\u001e\u001a\u00020!\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020!0\u0014H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\b\"\u001a&\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u000b0$\"\u000e\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f*\b\u0012\u0004\u0012\u0002H\u000b0\u0001\u001a8\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u000b0$\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00012\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000b0\u0018j\n\u0012\u0006\b\u0000\u0012\u0002H\u000b`\u0019\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006%" }, d2 = { "filterIsInstance", "Lkotlin/sequences/Sequence;", "R", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", "", "destination", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "max", "T", "", "(Lkotlin/sequences/Sequence;)Ljava/lang/Comparable;", "", "(Lkotlin/sequences/Sequence;)Ljava/lang/Double;", "", "(Lkotlin/sequences/Sequence;)Ljava/lang/Float;", "maxBy", "selector", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Lkotlin/sequences/Sequence;Ljava/util/Comparator;)Ljava/lang/Object;", "min", "minBy", "minWith", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "Ljava/math/BigInteger;", "sumOfBigInteger", "toSortedSet", "Ljava/util/SortedSet;", "kotlin-stdlib" }, xs = "kotlin/sequences/SequencesKt")
class SequencesKt___SequencesJvmKt extends SequencesKt__SequencesKt
{
    @NotNull
    public static final <R> Sequence<R> filterIsInstance(@NotNull final Sequence<?> $this$filterIsInstance, @NotNull final Class<R> klass) {
        Intrinsics.checkNotNullParameter($this$filterIsInstance, "<this>");
        Intrinsics.checkNotNullParameter(klass, "klass");
        final Sequence<Object> filter = (Sequence<Object>)SequencesKt___SequencesKt.filter((Sequence<? extends R>)$this$filterIsInstance, (Function1<? super R, Boolean>)new SequencesKt___SequencesJvmKt$filterIsInstance.SequencesKt___SequencesJvmKt$filterIsInstance$1((Class)klass));
        Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesJvmKt.filterIsInstance>");
        return (Sequence<R>)filter;
    }
    
    @NotNull
    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(@NotNull final Sequence<?> $this$filterIsInstanceTo, @NotNull final C destination, @NotNull final Class<R> klass) {
        Intrinsics.checkNotNullParameter($this$filterIsInstanceTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(klass, "klass");
        for (final Object element : $this$filterIsInstanceTo) {
            if (klass.isInstance(element)) {
                destination.add((Object)element);
            }
        }
        return destination;
    }
    
    @NotNull
    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(@NotNull final Sequence<? extends T> $this$toSortedSet) {
        Intrinsics.checkNotNullParameter($this$toSortedSet, "<this>");
        return SequencesKt___SequencesKt.toCollection((Sequence<?>)$this$toSortedSet, (TreeSet<T>)new TreeSet<T>());
    }
    
    @NotNull
    public static final <T> SortedSet<T> toSortedSet(@NotNull final Sequence<? extends T> $this$toSortedSet, @NotNull final Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter($this$toSortedSet, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return SequencesKt___SequencesKt.toCollection((Sequence<?>)$this$toSortedSet, (TreeSet<T>)new TreeSet<T>(comparator));
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "sumOfBigDecimal")
    @InlineOnly
    private static final <T> BigDecimal sumOfBigDecimal(final Sequence<? extends T> $this$sumOf, final Function1<? super T, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final BigDecimal value = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        BigDecimal sum = value;
        for (final Object element : $this$sumOf) {
            final BigDecimal add = sum.add((BigDecimal)selector.invoke((Object)element));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "sumOfBigInteger")
    @InlineOnly
    private static final <T> BigInteger sumOfBigInteger(final Sequence<? extends T> $this$sumOf, final Function1<? super T, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final BigInteger value = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        BigInteger sum = value;
        for (final Object element : $this$sumOf) {
            final BigInteger add = sum.add((BigInteger)selector.invoke((Object)element));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }
    
    public SequencesKt___SequencesJvmKt() {
    }
}
