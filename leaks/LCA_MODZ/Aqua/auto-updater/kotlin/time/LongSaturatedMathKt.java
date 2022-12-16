// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.time;

import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u00f8\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\"\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u00f8\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\"\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u00f8\u0001\u0000¢\u0006\u0004\b\f\u0010\n\u001a \u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0000\u00f8\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010" }, d2 = { "checkInfiniteSumDefined", "", "longNs", "duration", "Lkotlin/time/Duration;", "durationNs", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "saturatingAdd", "saturatingAdd-pTJri5U", "(JJ)J", "saturatingAddInHalves", "saturatingAddInHalves-pTJri5U", "saturatingDiff", "valueNs", "originNs", "kotlin-stdlib" })
public final class LongSaturatedMathKt
{
    public static final long saturatingAdd-pTJri5U(final long longNs, final long duration) {
        final long durationNs = Duration.getInWholeNanoseconds-impl(duration);
        if ((longNs - 1L | 0x1L) == Long.MAX_VALUE) {
            return checkInfiniteSumDefined-PjuGub4(longNs, duration, durationNs);
        }
        if ((durationNs - 1L | 0x1L) == Long.MAX_VALUE) {
            return saturatingAddInHalves-pTJri5U(longNs, duration);
        }
        final long result = longNs + durationNs;
        if (((longNs ^ result) & (durationNs ^ result)) < 0L) {
            return (longNs < 0L) ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        return result;
    }
    
    private static final long checkInfiniteSumDefined-PjuGub4(final long longNs, final long duration, final long durationNs) {
        if (Duration.isInfinite-impl(duration) && (longNs ^ durationNs) < 0L) {
            throw new IllegalArgumentException("Summing infinities of different signs");
        }
        return longNs;
    }
    
    private static final long saturatingAddInHalves-pTJri5U(final long longNs, final long duration) {
        final long half = Duration.div-UwyO8pc(duration, 2);
        if ((Duration.getInWholeNanoseconds-impl(half) - 1L | 0x1L) == Long.MAX_VALUE) {
            return (long)(longNs + Duration.toDouble-impl(duration, DurationUnit.NANOSECONDS));
        }
        return saturatingAdd-pTJri5U(saturatingAdd-pTJri5U(longNs, half), half);
    }
    
    public static final long saturatingDiff(final long valueNs, final long originNs) {
        if ((originNs - 1L | 0x1L) == Long.MAX_VALUE) {
            return Duration.unaryMinus-UwyO8pc(DurationKt.toDuration(originNs, DurationUnit.DAYS));
        }
        final long result = valueNs - originNs;
        if (((result ^ valueNs) & ~(result ^ originNs)) < 0L) {
            final long resultMs = valueNs / 1000000 - originNs / 1000000;
            final long resultNs = valueNs % 1000000 - originNs % 1000000;
            final Duration.Companion companion = Duration.Companion;
            final long duration = DurationKt.toDuration(resultMs, DurationUnit.MILLISECONDS);
            final Duration.Companion companion2 = Duration.Companion;
            return Duration.plus-LRDsOJo(duration, DurationKt.toDuration(resultNs, DurationUnit.NANOSECONDS));
        }
        final Duration.Companion companion3 = Duration.Companion;
        return DurationKt.toDuration(result, DurationUnit.NANOSECONDS);
    }
}
