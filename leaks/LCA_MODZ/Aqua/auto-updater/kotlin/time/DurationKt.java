// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.time;

import kotlin.jvm.functions.Function1;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import java.util.Collection;
import kotlin.ranges.IntRange;
import kotlin.ranges.CharRange;
import kotlin.internal.InlineOnly;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ReplaceWith;
import kotlin.Deprecated;
import kotlin.ranges.LongRange;
import kotlin.WasExperimental;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000>\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b*\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0005H\u0002\u00f8\u0001\u0000¢\u0006\u0002\u0010&\u001a\u0018\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0001H\u0002\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0001H\u0002\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0001H\u0002\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0001H\u0002\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0010\u0010/\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u0001H\u0002\u001a\u0010\u00100\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002\u001a \u00101\u001a\u00020\u00072\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002\u00f8\u0001\u0000¢\u0006\u0002\u00106\u001a\u0010\u00107\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0002\u001a)\u00108\u001a\u00020\u0005*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001a)\u0010=\u001a\u000203*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001a\u001f\u0010>\u001a\u00020\u0007*\u00020\b2\u0006\u0010?\u001a\u00020\u0007H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a\u001f\u0010>\u001a\u00020\u0007*\u00020\u00052\u0006\u0010?\u001a\u00020\u0007H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\bB\u0010C\u001a\u001c\u0010D\u001a\u00020\u0007*\u00020\b2\u0006\u0010E\u001a\u00020FH\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010G\u001a\u001c\u0010D\u001a\u00020\u0007*\u00020\u00052\u0006\u0010E\u001a\u00020FH\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010H\u001a\u001c\u0010D\u001a\u00020\u0007*\u00020\u00012\u0006\u0010E\u001a\u00020FH\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"!\u0010\u0006\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004\u00f8\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"!\u0010\u0006\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00f8\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\r\u001a\u0004\b\u000b\u0010\u000e\"!\u0010\u0006\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00f8\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\u000f\u001a\u0004\b\u000b\u0010\u0010\"!\u0010\u0011\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004\u00f8\u0001\u0000¢\u0006\f\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"!\u0010\u0011\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00f8\u0001\u0000¢\u0006\f\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000e\"!\u0010\u0011\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00f8\u0001\u0000¢\u0006\f\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010\"!\u0010\u0014\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004\u00f8\u0001\u0000¢\u0006\f\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\"!\u0010\u0014\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00f8\u0001\u0000¢\u0006\f\u0012\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000e\"!\u0010\u0014\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00f8\u0001\u0000¢\u0006\f\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0010\"!\u0010\u0017\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004\u00f8\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"!\u0010\u0017\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00f8\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000e\"!\u0010\u0017\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00f8\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0010\"!\u0010\u001a\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004\u00f8\u0001\u0000¢\u0006\f\u0012\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\f\"!\u0010\u001a\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00f8\u0001\u0000¢\u0006\f\u0012\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000e\"!\u0010\u001a\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00f8\u0001\u0000¢\u0006\f\u0012\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0010\"!\u0010\u001d\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004\u00f8\u0001\u0000¢\u0006\f\u0012\u0004\b\u001e\u0010\n\u001a\u0004\b\u001f\u0010\f\"!\u0010\u001d\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00f8\u0001\u0000¢\u0006\f\u0012\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000e\"!\u0010\u001d\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00f8\u0001\u0000¢\u0006\f\u0012\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0010\"!\u0010 \u001a\u00020\u0007*\u00020\b8FX\u0087\u0004\u00f8\u0001\u0000¢\u0006\f\u0012\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\f\"!\u0010 \u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00f8\u0001\u0000¢\u0006\f\u0012\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000e\"!\u0010 \u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00f8\u0001\u0000¢\u0006\f\u0012\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006J" }, d2 = { "MAX_MILLIS", "", "MAX_NANOS", "MAX_NANOS_IN_MILLIS", "NANOS_IN_MILLIS", "", "days", "Lkotlin/time/Duration;", "", "getDays$annotations", "(D)V", "getDays", "(D)J", "(I)V", "(I)J", "(J)V", "(J)J", "hours", "getHours$annotations", "getHours", "microseconds", "getMicroseconds$annotations", "getMicroseconds", "milliseconds", "getMilliseconds$annotations", "getMilliseconds", "minutes", "getMinutes$annotations", "getMinutes", "nanoseconds", "getNanoseconds$annotations", "getNanoseconds", "seconds", "getSeconds$annotations", "getSeconds", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfMillis", "normalMillis", "durationOfMillisNormalized", "millis", "durationOfNanos", "normalNanos", "durationOfNanosNormalized", "nanos", "millisToNanos", "nanosToMillis", "parseDuration", "value", "", "strictIso", "", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "skipWhile", "startIndex", "predicate", "Lkotlin/Function1;", "", "substringWhile", "times", "duration", "times-kIfJnKk", "(DJ)J", "times-mvk6XK0", "(IJ)J", "toDuration", "unit", "Lkotlin/time/DurationUnit;", "(DLkotlin/time/DurationUnit;)J", "(ILkotlin/time/DurationUnit;)J", "(JLkotlin/time/DurationUnit;)J", "kotlin-stdlib" })
public final class DurationKt
{
    public static final int NANOS_IN_MILLIS = 1000000;
    public static final long MAX_NANOS = 4611686018426999999L;
    public static final long MAX_MILLIS = 4611686018427387903L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    
    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = { ExperimentalTime.class })
    public static final long toDuration(final int $this$toDuration, @NotNull final DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (unit.compareTo((DurationUnit)DurationUnit.SECONDS) <= 0) ? durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow($this$toDuration, unit, DurationUnit.NANOSECONDS)) : toDuration((long)$this$toDuration, unit);
    }
    
    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = { ExperimentalTime.class })
    public static final long toDuration(final long $this$toDuration, @NotNull final DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        final long maxNsInUnit = DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(4611686018426999999L, DurationUnit.NANOSECONDS, unit);
        if (new LongRange(-maxNsInUnit, maxNsInUnit).contains($this$toDuration)) {
            return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow($this$toDuration, unit, DurationUnit.NANOSECONDS));
        }
        final long millis = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit($this$toDuration, unit, DurationUnit.MILLISECONDS);
        return durationOfMillis(RangesKt___RangesKt.coerceIn(millis, -4611686018427387903L, 4611686018427387903L));
    }
    
    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = { ExperimentalTime.class })
    public static final long toDuration(final double $this$toDuration, @NotNull final DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        final double valueInNs = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit($this$toDuration, unit, DurationUnit.NANOSECONDS);
        if (Double.isNaN(valueInNs)) {
            final int n = 0;
            throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
        }
        final long nanos = MathKt__MathJVMKt.roundToLong(valueInNs);
        long n2;
        if (new LongRange(-4611686018426999999L, 4611686018426999999L).contains(nanos)) {
            n2 = durationOfNanos(nanos);
        }
        else {
            final long millis = MathKt__MathJVMKt.roundToLong(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit($this$toDuration, unit, DurationUnit.MILLISECONDS));
            n2 = durationOfMillisNormalized(millis);
        }
        return n2;
    }
    
    @java.lang.Deprecated
    public static final long getNanoseconds(final int $this$nanoseconds) {
        return toDuration($this$nanoseconds, DurationUnit.NANOSECONDS);
    }
    
    @java.lang.Deprecated
    public static final long getNanoseconds(final long $this$nanoseconds) {
        return toDuration($this$nanoseconds, DurationUnit.NANOSECONDS);
    }
    
    @java.lang.Deprecated
    public static final long getNanoseconds(final double $this$nanoseconds) {
        return toDuration($this$nanoseconds, DurationUnit.NANOSECONDS);
    }
    
    @java.lang.Deprecated
    public static final long getMicroseconds(final int $this$microseconds) {
        return toDuration($this$microseconds, DurationUnit.MICROSECONDS);
    }
    
    @java.lang.Deprecated
    public static final long getMicroseconds(final long $this$microseconds) {
        return toDuration($this$microseconds, DurationUnit.MICROSECONDS);
    }
    
    @java.lang.Deprecated
    public static final long getMicroseconds(final double $this$microseconds) {
        return toDuration($this$microseconds, DurationUnit.MICROSECONDS);
    }
    
    @java.lang.Deprecated
    public static final long getMilliseconds(final int $this$milliseconds) {
        return toDuration($this$milliseconds, DurationUnit.MILLISECONDS);
    }
    
    @java.lang.Deprecated
    public static final long getMilliseconds(final long $this$milliseconds) {
        return toDuration($this$milliseconds, DurationUnit.MILLISECONDS);
    }
    
    @java.lang.Deprecated
    public static final long getMilliseconds(final double $this$milliseconds) {
        return toDuration($this$milliseconds, DurationUnit.MILLISECONDS);
    }
    
    @java.lang.Deprecated
    public static final long getSeconds(final int $this$seconds) {
        return toDuration($this$seconds, DurationUnit.SECONDS);
    }
    
    @java.lang.Deprecated
    public static final long getSeconds(final long $this$seconds) {
        return toDuration($this$seconds, DurationUnit.SECONDS);
    }
    
    @java.lang.Deprecated
    public static final long getSeconds(final double $this$seconds) {
        return toDuration($this$seconds, DurationUnit.SECONDS);
    }
    
    @java.lang.Deprecated
    public static final long getMinutes(final int $this$minutes) {
        return toDuration($this$minutes, DurationUnit.MINUTES);
    }
    
    @java.lang.Deprecated
    public static final long getMinutes(final long $this$minutes) {
        return toDuration($this$minutes, DurationUnit.MINUTES);
    }
    
    @java.lang.Deprecated
    public static final long getMinutes(final double $this$minutes) {
        return toDuration($this$minutes, DurationUnit.MINUTES);
    }
    
    @java.lang.Deprecated
    public static final long getHours(final int $this$hours) {
        return toDuration($this$hours, DurationUnit.HOURS);
    }
    
    @java.lang.Deprecated
    public static final long getHours(final long $this$hours) {
        return toDuration($this$hours, DurationUnit.HOURS);
    }
    
    @java.lang.Deprecated
    public static final long getHours(final double $this$hours) {
        return toDuration($this$hours, DurationUnit.HOURS);
    }
    
    @java.lang.Deprecated
    public static final long getDays(final int $this$days) {
        return toDuration($this$days, DurationUnit.DAYS);
    }
    
    @java.lang.Deprecated
    public static final long getDays(final long $this$days) {
        return toDuration($this$days, DurationUnit.DAYS);
    }
    
    @java.lang.Deprecated
    public static final long getDays(final double $this$days) {
        return toDuration($this$days, DurationUnit.DAYS);
    }
    
    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = { ExperimentalTime.class })
    @InlineOnly
    private static final long times-mvk6XK0(final int $this$times_u2dmvk6XK0, final long duration) {
        return Duration.times-UwyO8pc(duration, $this$times_u2dmvk6XK0);
    }
    
    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = { ExperimentalTime.class })
    @InlineOnly
    private static final long times-kIfJnKk(final double $this$times_u2dkIfJnKk, final long duration) {
        return Duration.times-UwyO8pc(duration, $this$times_u2dkIfJnKk);
    }
    
    private static final long parseDuration(final String value, final boolean strictIso) {
        int length = value.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        int index = 0;
        long result = Duration.Companion.getZERO-UwyO8pc();
        final String infinityString = "Infinity";
        final char char1 = value.charAt(index);
        if (char1 == '+' || char1 == '-') {
            ++index;
        }
        final boolean hasSign = index > 0;
        final boolean isNegative = hasSign && StringsKt__StringsKt.startsWith$default(value, '-', false, 2, null);
        if (length <= index) {
            throw new IllegalArgumentException("No components");
        }
        if (value.charAt(index) == 'P') {
            if (++index == length) {
                throw new IllegalArgumentException();
            }
            final String nonDigitSymbols = "+-.";
            boolean isTimeComponent = false;
            DurationUnit prevUnit = null;
            while (index < length) {
                if (value.charAt(index) == 'T') {
                    if (isTimeComponent || ++index == length) {
                        throw new IllegalArgumentException();
                    }
                    isTimeComponent = true;
                }
                else {
                    final String $this$substringWhile$iv = value;
                    final int $i$f$substringWhile = 0;
                    final String object = $this$substringWhile$iv;
                    final String $this$skipWhile$iv$iv = $this$substringWhile$iv;
                    final int $i$f$skipWhile = 0;
                    int i$iv$iv;
                    for (i$iv$iv = index; i$iv$iv < $this$skipWhile$iv$iv.length(); ++i$iv$iv) {
                        final char it = $this$skipWhile$iv$iv.charAt(i$iv$iv);
                        final int n = 0;
                        if (!new CharRange('0', '9').contains(it) && !StringsKt__StringsKt.contains$default(nonDigitSymbols, it, false, 2, null)) {
                            break;
                        }
                    }
                    final int endIndex = i$iv$iv;
                    Intrinsics.checkNotNull(object, "null cannot be cast to non-null type java.lang.String");
                    final String substring = object.substring(index, endIndex);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    final String component = substring;
                    if (component.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    index += component.length();
                    final String $this$lastIndex = value;
                    if (index < 0 || index > StringsKt__StringsKt.getLastIndex($this$lastIndex)) {
                        final int it2 = index;
                        final int n2 = 0;
                        throw new IllegalArgumentException("Missing unit for value " + component);
                    }
                    final char unitChar = $this$lastIndex.charAt(index);
                    ++index;
                    final DurationUnit unit = DurationUnitKt__DurationUnitKt.durationUnitByIsoChar(unitChar, isTimeComponent);
                    if (prevUnit != null && prevUnit.compareTo((DurationUnit)unit) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    prevUnit = unit;
                    final int dotIndex = StringsKt__StringsKt.indexOf$default(component, '.', 0, false, 6, null);
                    if (unit == DurationUnit.SECONDS && dotIndex > 0) {
                        final String object2 = component;
                        final int beginIndex = 0;
                        Intrinsics.checkNotNull(object2, "null cannot be cast to non-null type java.lang.String");
                        final String substring2 = object2.substring(beginIndex, dotIndex);
                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        final String whole = substring2;
                        final long plus-LRDsOJo;
                        result = (plus-LRDsOJo = Duration.plus-LRDsOJo(result, toDuration(parseOverLongIsoComponent(whole), unit)));
                        final String object3 = component;
                        Intrinsics.checkNotNull(object3, "null cannot be cast to non-null type java.lang.String");
                        final String substring3 = object3.substring(dotIndex);
                        Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                        result = Duration.plus-LRDsOJo(plus-LRDsOJo, toDuration(Double.parseDouble(substring3), unit));
                    }
                    else {
                        result = Duration.plus-LRDsOJo(result, toDuration(parseOverLongIsoComponent(component), unit));
                    }
                }
            }
        }
        else {
            if (strictIso) {
                throw new IllegalArgumentException();
            }
            if (StringsKt__StringsJVMKt.regionMatches(value, index, infinityString, 0, Math.max(length - index, infinityString.length()), true)) {
                result = Duration.Companion.getINFINITE-UwyO8pc();
            }
            else {
                DurationUnit prevUnit2 = null;
                boolean afterFirst = false;
                boolean allowSpaces = !hasSign;
                if (hasSign && value.charAt(index) == '(' && StringsKt___StringsKt.last(value) == ')') {
                    allowSpaces = true;
                    if (++index == --length) {
                        throw new IllegalArgumentException("No components");
                    }
                }
                while (index < length) {
                    if (afterFirst && allowSpaces) {
                        final String $this$skipWhile$iv = value;
                        final int $i$f$skipWhile2 = 0;
                        int i$iv;
                        for (i$iv = index; i$iv < $this$skipWhile$iv.length(); ++i$iv) {
                            final char it3 = $this$skipWhile$iv.charAt(i$iv);
                            final int n3 = 0;
                            if (it3 != ' ') {
                                break;
                            }
                        }
                        index = i$iv;
                    }
                    afterFirst = true;
                    final String $this$substringWhile$iv = value;
                    final int $i$f$substringWhile = 0;
                    final String object4 = $this$substringWhile$iv;
                    final String $this$skipWhile$iv$iv = $this$substringWhile$iv;
                    final int $i$f$skipWhile = 0;
                    int i$iv$iv;
                    for (i$iv$iv = index; i$iv$iv < $this$skipWhile$iv$iv.length(); ++i$iv$iv) {
                        final char it = $this$skipWhile$iv$iv.charAt(i$iv$iv);
                        final int n4 = 0;
                        if (!new CharRange('0', '9').contains(it) && it != '.') {
                            break;
                        }
                    }
                    final int endIndex2 = i$iv$iv;
                    Intrinsics.checkNotNull(object4, "null cannot be cast to non-null type java.lang.String");
                    final String substring4 = object4.substring(index, endIndex2);
                    Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    final String component = substring4;
                    if (component.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    index += component.length();
                    final String $this$substringWhile$iv2 = value;
                    final int $i$f$substringWhile2 = 0;
                    final String object5 = $this$substringWhile$iv2;
                    final String $this$skipWhile$iv$iv2 = $this$substringWhile$iv2;
                    final int $i$f$skipWhile3 = 0;
                    int i$iv$iv2;
                    for (i$iv$iv2 = index; i$iv$iv2 < $this$skipWhile$iv$iv2.length(); ++i$iv$iv2) {
                        final char it4 = $this$skipWhile$iv$iv2.charAt(i$iv$iv2);
                        final int n5 = 0;
                        if (!new CharRange('a', 'z').contains(it4)) {
                            break;
                        }
                    }
                    final int endIndex3 = i$iv$iv2;
                    Intrinsics.checkNotNull(object5, "null cannot be cast to non-null type java.lang.String");
                    final String substring5 = object5.substring(index, endIndex3);
                    Intrinsics.checkNotNullExpressionValue(substring5, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    final String unitName = substring5;
                    index += unitName.length();
                    final DurationUnit unit = DurationUnitKt__DurationUnitKt.durationUnitByShortName(unitName);
                    if (prevUnit2 != null && prevUnit2.compareTo((DurationUnit)unit) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    prevUnit2 = unit;
                    final int dotIndex = StringsKt__StringsKt.indexOf$default(component, '.', 0, false, 6, null);
                    if (dotIndex > 0) {
                        final String object6 = component;
                        final int beginIndex2 = 0;
                        Intrinsics.checkNotNull(object6, "null cannot be cast to non-null type java.lang.String");
                        final String substring6 = object6.substring(beginIndex2, dotIndex);
                        Intrinsics.checkNotNullExpressionValue(substring6, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        final String whole = substring6;
                        final long plus-LRDsOJo2;
                        result = (plus-LRDsOJo2 = Duration.plus-LRDsOJo(result, toDuration(Long.parseLong(whole), unit)));
                        final String object7 = component;
                        Intrinsics.checkNotNull(object7, "null cannot be cast to non-null type java.lang.String");
                        final String substring7 = object7.substring(dotIndex);
                        Intrinsics.checkNotNullExpressionValue(substring7, "this as java.lang.String).substring(startIndex)");
                        result = Duration.plus-LRDsOJo(plus-LRDsOJo2, toDuration(Double.parseDouble(substring7), unit));
                        if (index < length) {
                            throw new IllegalArgumentException("Fractional component must be last");
                        }
                        continue;
                    }
                    else {
                        result = Duration.plus-LRDsOJo(result, toDuration(Long.parseLong(component), unit));
                    }
                }
            }
        }
        return isNegative ? Duration.unaryMinus-UwyO8pc(result) : result;
    }
    
    private static final long parseOverLongIsoComponent(final String value) {
        final int length = value.length();
        int startIndex = 0;
        if (length > 0 && StringsKt__StringsKt.contains$default("+-", value.charAt(0), false, 2, null)) {
            ++startIndex;
        }
        if (length - startIndex > 16) {
            final Iterable $this$all$iv = new IntRange(startIndex, StringsKt__StringsKt.getLastIndex(value));
            final int $i$f$all = 0;
            boolean b = false;
            Label_0150: {
                if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                    b = true;
                }
                else {
                    final Iterator iterator = $this$all$iv.iterator();
                    while (iterator.hasNext()) {
                        final int it;
                        final int element$iv = it = ((IntIterator)iterator).nextInt();
                        final int n = 0;
                        if (!new CharRange('0', '9').contains(value.charAt(it))) {
                            b = false;
                            break Label_0150;
                        }
                    }
                    b = true;
                }
            }
            if (b) {
                return (value.charAt(0) == '-') ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
        }
        return StringsKt__StringsJVMKt.startsWith$default(value, "+", false, 2, null) ? Long.parseLong(StringsKt___StringsKt.drop(value, 1)) : Long.parseLong(value);
    }
    
    private static final String substringWhile(final String $this$substringWhile, final int startIndex, final Function1<? super Character, Boolean> predicate) {
        final int $i$f$substringWhile = 0;
        final String $this$skipWhile$iv = $this$substringWhile;
        final int $i$f$skipWhile = 0;
        int i$iv;
        for (i$iv = startIndex; i$iv < $this$skipWhile$iv.length() && predicate.invoke($this$skipWhile$iv.charAt(i$iv)); ++i$iv) {}
        final int endIndex = i$iv;
        Intrinsics.checkNotNull($this$substringWhile, "null cannot be cast to non-null type java.lang.String");
        final String substring = $this$substringWhile.substring(startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }
    
    private static final int skipWhile(final String $this$skipWhile, final int startIndex, final Function1<? super Character, Boolean> predicate) {
        final int $i$f$skipWhile = 0;
        int i;
        for (i = startIndex; i < $this$skipWhile.length() && predicate.invoke($this$skipWhile.charAt(i)); ++i) {}
        return i;
    }
    
    private static final long nanosToMillis(final long nanos) {
        return nanos / 1000000;
    }
    
    private static final long millisToNanos(final long millis) {
        return millis * 1000000;
    }
    
    private static final long durationOfNanos(final long normalNanos) {
        return Duration.constructor-impl(normalNanos << 1);
    }
    
    private static final long durationOfMillis(final long normalMillis) {
        return Duration.constructor-impl((normalMillis << 1) + 1L);
    }
    
    private static final long durationOf(final long normalValue, final int unitDiscriminator) {
        return Duration.constructor-impl((normalValue << 1) + unitDiscriminator);
    }
    
    private static final long durationOfNanosNormalized(final long nanos) {
        return new LongRange(-4611686018426999999L, 4611686018426999999L).contains(nanos) ? durationOfNanos(nanos) : durationOfMillis(nanosToMillis(nanos));
    }
    
    private static final long durationOfMillisNormalized(final long millis) {
        return new LongRange(-4611686018426L, 4611686018426L).contains(millis) ? durationOfNanos(millisToNanos(millis)) : durationOfMillis(RangesKt___RangesKt.coerceIn(millis, -4611686018427387903L, 4611686018427387903L));
    }
}
