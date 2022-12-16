// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.text;

import java.math.BigInteger;
import kotlin.jvm.JvmName;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.SinceKotlin;
import java.math.BigDecimal;
import java.util.Comparator;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import kotlin.jvm.functions.Function1;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ReplaceWith;
import kotlin.Deprecated;
import java.util.TreeSet;
import java.util.SortedSet;
import org.jetbrains.annotations.NotNull;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000B\n\u0000\n\u0002\u0010\f\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0006\u001a;\u0010\u0007\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t*\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\b0\u000bH\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\f\u001a/\u0010\r\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010\u000e\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010\u000fj\n\u0012\u0006\b\u0000\u0012\u00020\u0001`\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0006\u001a;\u0010\u0013\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t*\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\b0\u000bH\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\f\u001a/\u0010\u0014\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010\u000e\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010\u000fj\n\u0012\u0006\b\u0000\u0012\u00020\u0001`\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a)\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u000bH\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\b\u0017\u001a)\u0010\u0015\u001a\u00020\u0018*\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00180\u000bH\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\b\u0019\u001a\u0010\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u001b*\u00020\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c" }, d2 = { "elementAt", "", "", "index", "", "max", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "maxBy", "R", "", "selector", "Lkotlin/Function1;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/CharSequence;Ljava/util/Comparator;)Ljava/lang/Character;", "min", "minBy", "minWith", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "Ljava/math/BigInteger;", "sumOfBigInteger", "toSortedSet", "Ljava/util/SortedSet;", "kotlin-stdlib" }, xs = "kotlin/text/StringsKt")
class StringsKt___StringsJvmKt extends StringsKt__StringsKt
{
    @InlineOnly
    private static final char elementAt(final CharSequence $this$elementAt, final int index) {
        Intrinsics.checkNotNullParameter($this$elementAt, "<this>");
        return $this$elementAt.charAt(index);
    }
    
    @NotNull
    public static final SortedSet<Character> toSortedSet(@NotNull final CharSequence $this$toSortedSet) {
        Intrinsics.checkNotNullParameter($this$toSortedSet, "<this>");
        return StringsKt___StringsKt.toCollection($this$toSortedSet, new TreeSet<Character>());
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "sumOfBigDecimal")
    @InlineOnly
    private static final BigDecimal sumOfBigDecimal(final CharSequence $this$sumOf, final Function1<? super Character, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final BigDecimal value = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        BigDecimal sum = value;
        for (int i = 0; i < $this$sumOf.length(); ++i) {
            final char element = $this$sumOf.charAt(i);
            final BigDecimal add = sum.add((BigDecimal)selector.invoke(element));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "sumOfBigInteger")
    @InlineOnly
    private static final BigInteger sumOfBigInteger(final CharSequence $this$sumOf, final Function1<? super Character, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final BigInteger value = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        BigInteger sum = value;
        for (int i = 0; i < $this$sumOf.length(); ++i) {
            final char element = $this$sumOf.charAt(i);
            final BigInteger add = sum.add((BigInteger)selector.invoke(element));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }
    
    public StringsKt___StringsJvmKt() {
    }
}
