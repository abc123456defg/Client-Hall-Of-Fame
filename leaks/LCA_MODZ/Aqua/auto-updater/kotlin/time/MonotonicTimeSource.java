// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.time;

import org.jetbrains.annotations.NotNull;
import kotlin.SinceKotlin;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u00c1\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t\u00f8\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006\u00f8\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u0006H\u0016\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0015" }, d2 = { "Lkotlin/time/MonotonicTimeSource;", "Lkotlin/time/TimeSource;", "()V", "zero", "", "adjustReading", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "timeMark", "duration", "Lkotlin/time/Duration;", "adjustReading-6QKq23U", "(JJ)J", "elapsedFrom", "elapsedFrom-6eNON_k", "(J)J", "markNow", "markNow-z9LOYto", "()J", "read", "toString", "", "kotlin-stdlib" })
@SinceKotlin(version = "1.3")
@ExperimentalTime
public final class MonotonicTimeSource implements TimeSource
{
    @NotNull
    public static final MonotonicTimeSource INSTANCE;
    private static final long zero;
    
    private MonotonicTimeSource() {
    }
    
    private final long read() {
        return System.nanoTime() - MonotonicTimeSource.zero;
    }
    
    @NotNull
    @Override
    public String toString() {
        return "TimeSource(System.nanoTime())";
    }
    
    public long markNow-z9LOYto() {
        return Monotonic.ValueTimeMark.constructor-impl(this.read());
    }
    
    public final long elapsedFrom-6eNON_k(final long timeMark) {
        return LongSaturatedMathKt.saturatingDiff(this.read(), timeMark);
    }
    
    public final long adjustReading-6QKq23U(final long timeMark, final long duration) {
        return Monotonic.ValueTimeMark.constructor-impl(LongSaturatedMathKt.saturatingAdd-pTJri5U(timeMark, duration));
    }
    
    static {
        INSTANCE = new MonotonicTimeSource();
        zero = System.nanoTime();
    }
}
