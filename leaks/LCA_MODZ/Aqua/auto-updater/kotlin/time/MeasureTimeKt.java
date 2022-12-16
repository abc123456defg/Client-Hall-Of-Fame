// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.time;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u001a3\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\n\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\f\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019¨\u0006\r" }, d2 = { "measureTime", "Lkotlin/time/Duration;", "block", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)J", "measureTimedValue", "Lkotlin/time/TimedValue;", "T", "Lkotlin/time/TimeSource;", "(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)J", "Lkotlin/time/TimeSource$Monotonic;", "(Lkotlin/time/TimeSource$Monotonic;Lkotlin/jvm/functions/Function0;)J", "kotlin-stdlib" })
public final class MeasureTimeKt
{
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final long measureTime(@NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        final int $i$f$measureTime = 0;
        final TimeSource.Monotonic $this$measureTime$iv = TimeSource.Monotonic.INSTANCE;
        final int $i$f$measureTime2 = 0;
        final long mark$iv = $this$measureTime$iv.markNow-z9LOYto();
        block.invoke();
        return TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(mark$iv);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final long measureTime(@NotNull final TimeSource $this$measureTime, @NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter($this$measureTime, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        final int $i$f$measureTime = 0;
        final TimeMark mark = $this$measureTime.markNow();
        block.invoke();
        return mark.elapsedNow-UwyO8pc();
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalTime
    public static final long measureTime(@NotNull final TimeSource.Monotonic $this$measureTime, @NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter($this$measureTime, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        final int $i$f$measureTime = 0;
        final long mark = $this$measureTime.markNow-z9LOYto();
        block.invoke();
        return TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(mark);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    @NotNull
    public static final <T> TimedValue<T> measureTimedValue(@NotNull final Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        final int $i$f$measureTimedValue = 0;
        final TimeSource.Monotonic $this$measureTimedValue$iv = TimeSource.Monotonic.INSTANCE;
        final int $i$f$measureTimedValue2 = 0;
        final long mark$iv = $this$measureTimedValue$iv.markNow-z9LOYto();
        final Object result$iv = block.invoke();
        return new TimedValue<T>(result$iv, TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(mark$iv), null);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    @NotNull
    public static final <T> TimedValue<T> measureTimedValue(@NotNull final TimeSource $this$measureTimedValue, @NotNull final Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter($this$measureTimedValue, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        final int $i$f$measureTimedValue = 0;
        final TimeMark mark = $this$measureTimedValue.markNow();
        final Object result = block.invoke();
        return new TimedValue<T>(result, mark.elapsedNow-UwyO8pc(), null);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalTime
    @NotNull
    public static final <T> TimedValue<T> measureTimedValue(@NotNull final TimeSource.Monotonic $this$measureTimedValue, @NotNull final Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter($this$measureTimedValue, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        final int $i$f$measureTimedValue = 0;
        final long mark = $this$measureTimedValue.markNow-z9LOYto();
        final Object result = block.invoke();
        return new TimedValue<T>(result, TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(mark), null);
    }
}
