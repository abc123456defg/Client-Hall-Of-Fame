// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.time;

import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000 \n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0001\u001a \u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0001\u001a \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0001\u001a\f\u0010\b\u001a\u00020\u0004*\u00020\tH\u0007\u001a\f\u0010\n\u001a\u00020\t*\u00020\u0004H\u0007¨\u0006\u000b" }, d2 = { "convertDurationUnit", "", "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "", "convertDurationUnitOverflow", "toDurationUnit", "Ljava/util/concurrent/TimeUnit;", "toTimeUnit", "kotlin-stdlib" }, xs = "kotlin/time/DurationUnitKt")
class DurationUnitKt__DurationUnitJvmKt
{
    @SinceKotlin(version = "1.6")
    @ExperimentalTime
    @NotNull
    public static final TimeUnit toTimeUnit(@NotNull final DurationUnit $this$toTimeUnit) {
        Intrinsics.checkNotNullParameter($this$toTimeUnit, "<this>");
        return $this$toTimeUnit.getTimeUnit$kotlin_stdlib();
    }
    
    @SinceKotlin(version = "1.6")
    @ExperimentalTime
    @NotNull
    public static final DurationUnit toDurationUnit(@NotNull final TimeUnit $this$toDurationUnit) {
        Intrinsics.checkNotNullParameter($this$toDurationUnit, "<this>");
        DurationUnit durationUnit = null;
        switch (WhenMappings.$EnumSwitchMapping$0[$this$toDurationUnit.ordinal()]) {
            case 1: {
                durationUnit = DurationUnit.NANOSECONDS;
                break;
            }
            case 2: {
                durationUnit = DurationUnit.MICROSECONDS;
                break;
            }
            case 3: {
                durationUnit = DurationUnit.MILLISECONDS;
                break;
            }
            case 4: {
                durationUnit = DurationUnit.SECONDS;
                break;
            }
            case 5: {
                durationUnit = DurationUnit.MINUTES;
                break;
            }
            case 6: {
                durationUnit = DurationUnit.HOURS;
                break;
            }
            case 7: {
                durationUnit = DurationUnit.DAYS;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return durationUnit;
    }
    
    @SinceKotlin(version = "1.3")
    public static final double convertDurationUnit(final double value, @NotNull final DurationUnit sourceUnit, @NotNull final DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
        final long sourceInTargets = targetUnit.getTimeUnit$kotlin_stdlib().convert(1L, sourceUnit.getTimeUnit$kotlin_stdlib());
        if (sourceInTargets > 0L) {
            return value * sourceInTargets;
        }
        final long otherInThis = sourceUnit.getTimeUnit$kotlin_stdlib().convert(1L, targetUnit.getTimeUnit$kotlin_stdlib());
        return value / otherInThis;
    }
    
    @SinceKotlin(version = "1.5")
    public static final long convertDurationUnitOverflow(final long value, @NotNull final DurationUnit sourceUnit, @NotNull final DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(value, sourceUnit.getTimeUnit$kotlin_stdlib());
    }
    
    @SinceKotlin(version = "1.5")
    public static final long convertDurationUnit(final long value, @NotNull final DurationUnit sourceUnit, @NotNull final DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(value, sourceUnit.getTimeUnit$kotlin_stdlib());
    }
    
    public DurationUnitKt__DurationUnitJvmKt() {
    }
}
