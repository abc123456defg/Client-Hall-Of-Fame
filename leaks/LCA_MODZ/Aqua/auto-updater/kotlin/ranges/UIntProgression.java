// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.ranges;

import org.jetbrains.annotations.Nullable;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import java.util.Iterator;
import kotlin.internal.UProgressionUtilKt;
import org.jetbrains.annotations.NotNull;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.WasExperimental;
import kotlin.SinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.UInt;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\"\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0012\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0086\u0002\u00f8\u0001\u0000J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0019\u0010\b\u001a\u00020\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001a" }, d2 = { "Lkotlin/ranges/UIntProgression;", "", "Lkotlin/UInt;", "start", "endInclusive", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst-pVg5ArA", "()I", "I", "last", "getLast-pVg5ArA", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "", "toString", "", "Companion", "kotlin-stdlib" })
@SinceKotlin(version = "1.5")
@WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
public class UIntProgression implements Iterable<UInt>, KMappedMarker
{
    @NotNull
    public static final Companion Companion;
    private final int first;
    private final int last;
    private final int step;
    
    private UIntProgression(final int start, final int endInclusive, final int step) {
        if (step == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (step == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.first = start;
        this.last = UProgressionUtilKt.getProgressionLastElement-Nkh28Cs(start, endInclusive, step);
        this.step = step;
    }
    
    public final int getFirst-pVg5ArA() {
        return this.first;
    }
    
    public final int getLast-pVg5ArA() {
        return this.last;
    }
    
    public final int getStep() {
        return this.step;
    }
    
    @NotNull
    @Override
    public final Iterator<UInt> iterator() {
        return new UIntProgressionIterator(this.first, this.last, this.step, null);
    }
    
    public boolean isEmpty() {
        return (this.step > 0) ? (UnsignedKt.uintCompare(this.first, this.last) > 0) : (UnsignedKt.uintCompare(this.first, this.last) < 0);
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        return other instanceof UIntProgression && ((this.isEmpty() && ((UIntProgression)other).isEmpty()) || (this.first == ((UIntProgression)other).first && this.last == ((UIntProgression)other).last && this.step == ((UIntProgression)other).step));
    }
    
    @Override
    public int hashCode() {
        return this.isEmpty() ? -1 : (31 * (31 * this.first + this.last) + this.step);
    }
    
    @NotNull
    @Override
    public String toString() {
        return (this.step > 0) ? ((Object)UInt.toString-impl(this.first) + ".." + (Object)UInt.toString-impl(this.last) + " step " + this.step) : ((Object)UInt.toString-impl(this.first) + " downTo " + (Object)UInt.toString-impl(this.last) + " step " + -this.step);
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t\u00f8\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f" }, d2 = { "Lkotlin/ranges/UIntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/UIntProgression;", "rangeStart", "Lkotlin/UInt;", "rangeEnd", "step", "", "fromClosedRange-Nkh28Cs", "(III)Lkotlin/ranges/UIntProgression;", "kotlin-stdlib" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @NotNull
        public final UIntProgression fromClosedRange-Nkh28Cs(final int rangeStart, final int rangeEnd, final int step) {
            return new UIntProgression(rangeStart, rangeEnd, step, null);
        }
    }
}
