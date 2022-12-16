// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.ranges;

import kotlin.internal.InlineOnly;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a@\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0007*\u00020\b\"\u0018\b\u0001\u0010\t*\b\u0012\u0004\u0012\u0002H\u00070\n*\b\u0012\u0004\u0012\u0002H\u00070\u000b*\u0002H\t2\b\u0010\f\u001a\u0004\u0018\u0001H\u0007H\u0087\n¢\u0006\u0002\u0010\r\u001a@\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0007*\u00020\b\"\u0018\b\u0001\u0010\t*\b\u0012\u0004\u0012\u0002H\u00070\u000e*\b\u0012\u0004\u0012\u0002H\u00070\u000b*\u0002H\t2\b\u0010\f\u001a\u0004\u0018\u0001H\u0007H\u0087\n¢\u0006\u0002\u0010\u000f\u001a0\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00070\n\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0011*\u0002H\u00072\u0006\u0010\u0012\u001a\u0002H\u0007H\u0086\u0002¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014*\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0015H\u0087\u0002\u001a\u001b\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00160\u0014*\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0016H\u0087\u0002\u001a0\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000e\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0011*\u0002H\u00072\u0006\u0010\u0012\u001a\u0002H\u0007H\u0087\u0002¢\u0006\u0002\u0010\u0018\u001a\u001b\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e*\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0015H\u0087\u0002\u001a\u001b\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e*\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0016H\u0087\u0002¨\u0006\u0019" }, d2 = { "checkStepIsPositive", "", "isPositive", "", "step", "", "contains", "T", "", "R", "Lkotlin/ranges/ClosedRange;", "", "element", "(Lkotlin/ranges/ClosedRange;Ljava/lang/Object;)Z", "Lkotlin/ranges/OpenEndRange;", "(Lkotlin/ranges/OpenEndRange;Ljava/lang/Object;)Z", "rangeTo", "", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "", "rangeUntil", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/OpenEndRange;", "kotlin-stdlib" }, xs = "kotlin/ranges/RangesKt")
class RangesKt__RangesKt
{
    @NotNull
    public static final <T extends Comparable<? super T>> ClosedRange<T> rangeTo(@NotNull final T $this$rangeTo, @NotNull final T that) {
        Intrinsics.checkNotNullParameter($this$rangeTo, "<this>");
        Intrinsics.checkNotNullParameter(that, "that");
        return new ComparableRange<T>($this$rangeTo, that);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @NotNull
    public static final <T extends Comparable<? super T>> OpenEndRange<T> rangeUntil(@NotNull final T $this$rangeUntil, @NotNull final T that) {
        Intrinsics.checkNotNullParameter($this$rangeUntil, "<this>");
        Intrinsics.checkNotNullParameter(that, "that");
        return new ComparableOpenEndRange<T>($this$rangeUntil, that);
    }
    
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final ClosedFloatingPointRange<Double> rangeTo(final double $this$rangeTo, final double that) {
        return new ClosedDoubleRange($this$rangeTo, that);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @NotNull
    public static final OpenEndRange<Double> rangeUntil(final double $this$rangeUntil, final double that) {
        return new OpenEndDoubleRange($this$rangeUntil, that);
    }
    
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final ClosedFloatingPointRange<Float> rangeTo(final float $this$rangeTo, final float that) {
        return new ClosedFloatRange($this$rangeTo, that);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @NotNull
    public static final OpenEndRange<Float> rangeUntil(final float $this$rangeUntil, final float that) {
        return new OpenEndFloatRange($this$rangeUntil, that);
    }
    
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T, R extends kotlin.ranges.ClosedRange> boolean contains(final R $this$contains, final T element) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return element != null && ((ClosedRange<Comparable>)$this$contains).contains((Comparable)element);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final <T, R extends kotlin.ranges.OpenEndRange> boolean contains(final R $this$contains, final T element) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return element != null && ((OpenEndRange<Comparable>)$this$contains).contains((Comparable)element);
    }
    
    public static final void checkStepIsPositive(final boolean isPositive, @NotNull final Number step) {
        Intrinsics.checkNotNullParameter(step, "step");
        if (!isPositive) {
            throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
        }
    }
    
    public RangesKt__RangesKt() {
    }
}
