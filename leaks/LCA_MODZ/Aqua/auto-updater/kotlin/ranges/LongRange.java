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

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001aB\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0096\u0002J\u0013\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u001a\u0010\b\u001a\u00020\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b" }, d2 = { "Lkotlin/ranges/LongRange;", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/ClosedRange;", "", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "(JJ)V", "endExclusive", "getEndExclusive$annotations", "()V", "getEndExclusive", "()Ljava/lang/Long;", "getEndInclusive", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib" })
public final class LongRange extends LongProgression implements ClosedRange<Long>, OpenEndRange<Long>
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final LongRange EMPTY;
    
    public LongRange(final long start, final long endInclusive) {
        super(start, endInclusive, 1L);
    }
    
    @NotNull
    @Override
    public Long getStart() {
        return this.getFirst();
    }
    
    @NotNull
    @Override
    public Long getEndInclusive() {
        return this.getLast();
    }
    
    @NotNull
    @Override
    @java.lang.Deprecated
    public Long getEndExclusive() {
        if (this.getLast() == Long.MAX_VALUE) {
            throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
        }
        return this.getLast() + 1L;
    }
    
    public boolean contains(final long value) {
        return this.getFirst() <= value && value <= this.getLast();
    }
    
    @Override
    public boolean isEmpty() {
        return this.getFirst() > this.getLast();
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        return other instanceof LongRange && ((this.isEmpty() && ((LongRange)other).isEmpty()) || (this.getFirst() == ((LongRange)other).getFirst() && this.getLast() == ((LongRange)other).getLast()));
    }
    
    @Override
    public int hashCode() {
        return this.isEmpty() ? -1 : ((int)(31 * (this.getFirst() ^ this.getFirst() >>> 32) + (this.getLast() ^ this.getLast() >>> 32)));
    }
    
    @NotNull
    @Override
    public String toString() {
        return this.getFirst() + ".." + this.getLast();
    }
    
    public static final /* synthetic */ LongRange access$getEMPTY$cp() {
        return LongRange.EMPTY;
    }
    
    static {
        Companion = new Companion(null);
        EMPTY = new LongRange(1L, 0L);
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007" }, d2 = { "Lkotlin/ranges/LongRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/LongRange;", "getEMPTY", "()Lkotlin/ranges/LongRange;", "kotlin-stdlib" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @NotNull
        public final LongRange getEMPTY() {
            return LongRange.access$getEMPTY$cp();
        }
    }
}
