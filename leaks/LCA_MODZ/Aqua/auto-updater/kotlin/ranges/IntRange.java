// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.ranges;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.Deprecated;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u0019B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0096\u0002J\u0013\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\b\u001a\u00020\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a" }, d2 = { "Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", "", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "(II)V", "endExclusive", "getEndExclusive$annotations", "()V", "getEndExclusive", "()Ljava/lang/Integer;", "getEndInclusive", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "isEmpty", "toString", "", "Companion", "kotlin-stdlib" })
public final class IntRange extends IntProgression implements ClosedRange<Integer>, OpenEndRange<Integer>
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final IntRange EMPTY;
    
    public IntRange(final int start, final int endInclusive) {
        super(start, endInclusive, 1);
    }
    
    @NotNull
    @Override
    public Integer getStart() {
        return this.getFirst();
    }
    
    @NotNull
    @Override
    public Integer getEndInclusive() {
        return this.getLast();
    }
    
    @NotNull
    @Override
    @java.lang.Deprecated
    public Integer getEndExclusive() {
        if (this.getLast() == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
        }
        return this.getLast() + 1;
    }
    
    public boolean contains(final int value) {
        return this.getFirst() <= value && value <= this.getLast();
    }
    
    @Override
    public boolean isEmpty() {
        return this.getFirst() > this.getLast();
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        return other instanceof IntRange && ((this.isEmpty() && ((IntRange)other).isEmpty()) || (this.getFirst() == ((IntRange)other).getFirst() && this.getLast() == ((IntRange)other).getLast()));
    }
    
    @Override
    public int hashCode() {
        return this.isEmpty() ? -1 : (31 * this.getFirst() + this.getLast());
    }
    
    @NotNull
    @Override
    public String toString() {
        return this.getFirst() + ".." + this.getLast();
    }
    
    public static final /* synthetic */ IntRange access$getEMPTY$cp() {
        return IntRange.EMPTY;
    }
    
    static {
        Companion = new Companion(null);
        EMPTY = new IntRange(1, 0);
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007" }, d2 = { "Lkotlin/ranges/IntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/IntRange;", "getEMPTY", "()Lkotlin/ranges/IntRange;", "kotlin-stdlib" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @NotNull
        public final IntRange getEMPTY() {
            return IntRange.access$getEMPTY$cp();
        }
    }
}
