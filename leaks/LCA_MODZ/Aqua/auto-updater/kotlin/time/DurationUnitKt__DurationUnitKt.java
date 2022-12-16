// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.time;

import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0001\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0001¨\u0006\t" }, d2 = { "durationUnitByIsoChar", "Lkotlin/time/DurationUnit;", "isoChar", "", "isTimeComponent", "", "durationUnitByShortName", "shortName", "", "kotlin-stdlib" }, xs = "kotlin/time/DurationUnitKt")
class DurationUnitKt__DurationUnitKt extends DurationUnitKt__DurationUnitJvmKt
{
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final String shortName(@NotNull final DurationUnit $this$shortName) {
        Intrinsics.checkNotNullParameter($this$shortName, "<this>");
        String s = null;
        switch (WhenMappings.$EnumSwitchMapping$0[$this$shortName.ordinal()]) {
            case 1: {
                s = "ns";
                break;
            }
            case 2: {
                s = "us";
                break;
            }
            case 3: {
                s = "ms";
                break;
            }
            case 4: {
                s = "s";
                break;
            }
            case 5: {
                s = "m";
                break;
            }
            case 6: {
                s = "h";
                break;
            }
            case 7: {
                s = "d";
                break;
            }
            default: {
                throw new IllegalStateException(("Unknown unit: " + $this$shortName).toString());
            }
        }
        return s;
    }
    
    @SinceKotlin(version = "1.5")
    @NotNull
    public static final DurationUnit durationUnitByShortName(@NotNull final String shortName) {
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        switch (shortName) {
            case "s": {
                return DurationUnit.SECONDS;
            }
            case "d": {
                return DurationUnit.DAYS;
            }
            case "ns": {
                return DurationUnit.NANOSECONDS;
            }
            case "ms": {
                return DurationUnit.MILLISECONDS;
            }
            case "h": {
                return DurationUnit.HOURS;
            }
            case "m": {
                return DurationUnit.MINUTES;
            }
            case "us": {
                return DurationUnit.MICROSECONDS;
            }
            default:
                break;
        }
        throw new IllegalArgumentException("Unknown duration unit short name: " + shortName);
    }
    
    @SinceKotlin(version = "1.5")
    @NotNull
    public static final DurationUnit durationUnitByIsoChar(final char isoChar, final boolean isTimeComponent) {
        DurationUnit durationUnit;
        if (!isTimeComponent) {
            if (isoChar != 'D') {
                throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + isoChar);
            }
            durationUnit = DurationUnit.DAYS;
        }
        else if (isoChar == 'H') {
            durationUnit = DurationUnit.HOURS;
        }
        else if (isoChar == 'M') {
            durationUnit = DurationUnit.MINUTES;
        }
        else {
            if (isoChar != 'S') {
                throw new IllegalArgumentException("Invalid duration ISO time unit: " + isoChar);
            }
            durationUnit = DurationUnit.SECONDS;
        }
        return durationUnit;
    }
    
    public DurationUnitKt__DurationUnitKt() {
    }
}
