// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.time;

import org.jetbrains.annotations.Nullable;
import kotlin.DeprecatedSinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ReplaceWith;
import kotlin.Deprecated;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.LongRange;
import org.jetbrains.annotations.NotNull;
import kotlin.WasExperimental;
import kotlin.SinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@JvmInline
@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087@\u0018\u0000 ¤\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002¤\u0001B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00f8\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u0003H\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\bG\u0010HJ\u001b\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u0000H\u0096\u0002\u00f8\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u001e\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u000fH\u0086\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u001e\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\tH\u0086\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\bO\u0010QJ\u001b\u0010M\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002\u00f8\u0001\u0000¢\u0006\u0004\bR\u0010SJ\u001a\u0010T\u001a\u00020U2\b\u0010J\u001a\u0004\u0018\u00010VH\u00d6\u0003¢\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020\tH\u00d6\u0001¢\u0006\u0004\bZ\u0010\rJ\r\u0010[\u001a\u00020U¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020UH\u0002¢\u0006\u0004\b_\u0010]J\u000f\u0010`\u001a\u00020UH\u0002¢\u0006\u0004\ba\u0010]J\r\u0010b\u001a\u00020U¢\u0006\u0004\bc\u0010]J\r\u0010d\u001a\u00020U¢\u0006\u0004\be\u0010]J\r\u0010f\u001a\u00020U¢\u0006\u0004\bg\u0010]J\u001b\u0010h\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002\u00f8\u0001\u0000¢\u0006\u0004\bi\u0010jJ\u001b\u0010k\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002\u00f8\u0001\u0000¢\u0006\u0004\bl\u0010jJ\u001e\u0010m\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u000fH\u0086\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\bn\u0010PJ\u001e\u0010m\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\tH\u0086\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\bn\u0010QJ\u009d\u0001\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2u\u0010q\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(u\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(v\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0rH\u0086\b\u00f8\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010{J\u0088\u0001\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2`\u0010q\u001a\\\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(v\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0|H\u0086\b\u00f8\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010}Js\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2K\u0010q\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0~H\u0086\b\u00f8\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010\u007fJ`\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p27\u0010q\u001a3\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0\u0080\u0001H\u0086\b\u00f8\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0005\bz\u0010\u0081\u0001J\u0019\u0010\u0082\u0001\u001a\u00020\u000f2\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0019\u0010\u0086\u0001\u001a\u00020\t2\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u0011\u0010\u0089\u0001\u001a\u00030\u008a\u0001¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0019\u0010\u008d\u0001\u001a\u00020\u00032\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u0011\u0010\u0090\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0091\u0001\u0010\u0005J\u0011\u0010\u0092\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0093\u0001\u0010\u0005J\u0013\u0010\u0094\u0001\u001a\u00030\u008a\u0001H\u0016¢\u0006\u0006\b\u0095\u0001\u0010\u008c\u0001J%\u0010\u0094\u0001\u001a\u00030\u008a\u00012\u0007\u0010\u0083\u0001\u001a\u00020=2\t\b\u0002\u0010\u0096\u0001\u001a\u00020\t¢\u0006\u0006\b\u0095\u0001\u0010\u0097\u0001J\u0018\u0010\u0098\u0001\u001a\u00020\u0000H\u0086\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0005\b\u0099\u0001\u0010\u0005JK\u0010\u009a\u0001\u001a\u00030\u009b\u0001*\b0\u009c\u0001j\u0003`\u009d\u00012\u0007\u0010\u009e\u0001\u001a\u00020\t2\u0007\u0010\u009f\u0001\u001a\u00020\t2\u0007\u0010 \u0001\u001a\u00020\t2\b\u0010\u0083\u0001\u001a\u00030\u008a\u00012\u0007\u0010¡\u0001\u001a\u00020UH\u0002¢\u0006\u0006\b¢\u0001\u0010£\u0001R\u0017\u0010\u0006\u001a\u00020\u00008F\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\u0012R\u001a\u0010\"\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\u0012R\u0011\u0010%\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b&\u0010\u0005R\u0011\u0010'\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b(\u0010\u0005R\u0011\u0010)\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b*\u0010\u0005R\u0011\u0010+\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010\u0005R\u0011\u0010-\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b.\u0010\u0005R\u0011\u0010/\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010\u0005R\u0011\u00101\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b2\u0010\u0005R\u001a\u00103\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b4\u0010\u000b\u001a\u0004\b5\u0010\rR\u001a\u00106\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b7\u0010\u000b\u001a\u0004\b8\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b:\u0010\u000b\u001a\u0004\b;\u0010\rR\u0014\u0010<\u001a\u00020=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0015\u0010@\u001a\u00020\t8\u00c2\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\rR\u0014\u0010B\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u00f8\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006¥\u0001" }, d2 = { "Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "absoluteValue", "getAbsoluteValue-UwyO8pc", "hoursComponent", "", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "(J)I", "inDays", "", "getInDays$annotations", "getInDays-impl", "(J)D", "inHours", "getInHours$annotations", "getInHours-impl", "inMicroseconds", "getInMicroseconds$annotations", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds$annotations", "getInMilliseconds-impl", "inMinutes", "getInMinutes$annotations", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds$annotations", "getInNanoseconds-impl", "inSeconds", "getInSeconds$annotations", "getInSeconds-impl", "inWholeDays", "getInWholeDays-impl", "inWholeHours", "getInWholeHours-impl", "inWholeMicroseconds", "getInWholeMicroseconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds-impl", "inWholeMinutes", "getInWholeMinutes-impl", "inWholeNanoseconds", "getInWholeNanoseconds-impl", "inWholeSeconds", "getInWholeSeconds-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "storageUnit", "Lkotlin/time/DurationUnit;", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "unitDiscriminator", "getUnitDiscriminator-impl", "value", "getValue-impl", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "compareTo", "other", "compareTo-LRDsOJo", "(JJ)I", "div", "scale", "div-UwyO8pc", "(JD)J", "(JI)J", "div-LRDsOJo", "(JJ)D", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(J)Z", "isInMillis", "isInMillis-impl", "isInNanos", "isInNanos-impl", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "(JJ)J", "plus", "plus-LRDsOJo", "times", "times-UwyO8pc", "toComponents", "T", "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", "unit", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toInt", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "toIsoString", "", "toIsoString-impl", "(J)Ljava/lang/String;", "toLong", "toLong-impl", "(JLkotlin/time/DurationUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "unaryMinus", "unaryMinus-UwyO8pc", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "Companion", "kotlin-stdlib" })
@SinceKotlin(version = "1.6")
@WasExperimental(markerClass = { ExperimentalTime.class })
public final class Duration implements Comparable<Duration>
{
    @NotNull
    public static final Companion Companion;
    private final long rawValue = rawValue;
    private static final long ZERO;
    private static final long INFINITE;
    private static final long NEG_INFINITE;
    
    private static final long getValue-impl(final long arg0) {
        return arg0 >> 1;
    }
    
    private static final int getUnitDiscriminator-impl(final long arg0) {
        final int n = 0;
        return (int)arg0 & 0x1;
    }
    
    private static final boolean isInNanos-impl(final long arg0) {
        final int n = 0;
        return ((int)arg0 & 0x1) == 0x0;
    }
    
    private static final boolean isInMillis-impl(final long arg0) {
        final int n = 0;
        return ((int)arg0 & 0x1) == 0x1;
    }
    
    private static final DurationUnit getStorageUnit-impl(final long arg0) {
        return isInNanos-impl(arg0) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }
    
    public static final long unaryMinus-UwyO8pc(final long arg0) {
        final long normalValue = -getValue-impl(arg0);
        final int n = 0;
        return DurationKt.access$durationOf(normalValue, (int)arg0 & 0x1);
    }
    
    public static final long plus-LRDsOJo(final long arg0, final long other) {
        if (isInfinite-impl(arg0)) {
            if (isFinite-impl(other) || (arg0 ^ other) >= 0L) {
                return arg0;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        else {
            if (isInfinite-impl(other)) {
                return other;
            }
            int n = 0;
            final int n2 = (int)arg0 & 0x1;
            n = 0;
            long n3;
            if (n2 == ((int)other & 0x1)) {
                final long result = getValue-impl(arg0) + getValue-impl(other);
                n3 = (isInNanos-impl(arg0) ? DurationKt.access$durationOfNanosNormalized(result) : DurationKt.access$durationOfMillisNormalized(result));
            }
            else {
                n3 = (isInMillis-impl(arg0) ? addValuesMixedRanges-UwyO8pc(arg0, getValue-impl(arg0), getValue-impl(other)) : addValuesMixedRanges-UwyO8pc(arg0, getValue-impl(other), getValue-impl(arg0)));
            }
            return n3;
        }
    }
    
    private static final long addValuesMixedRanges-UwyO8pc(final long arg0, final long thisMillis, final long otherNanos) {
        final long otherMillis = DurationKt.access$nanosToMillis(otherNanos);
        final long resultMillis = thisMillis + otherMillis;
        long n;
        if (new LongRange(-4611686018426L, 4611686018426L).contains(resultMillis)) {
            final long otherNanoRemainder = otherNanos - DurationKt.access$millisToNanos(otherMillis);
            n = DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(resultMillis) + otherNanoRemainder);
        }
        else {
            n = DurationKt.access$durationOfMillis(RangesKt___RangesKt.coerceIn(resultMillis, -4611686018427387903L, 4611686018427387903L));
        }
        return n;
    }
    
    public static final long minus-LRDsOJo(final long arg0, final long other) {
        return plus-LRDsOJo(arg0, unaryMinus-UwyO8pc(other));
    }
    
    public static final long times-UwyO8pc(final long arg0, final int scale) {
        if (isInfinite-impl(arg0)) {
            if (scale == 0) {
                throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
            }
            return (scale > 0) ? arg0 : unaryMinus-UwyO8pc(arg0);
        }
        else {
            if (scale == 0) {
                return Duration.ZERO;
            }
            final long value = getValue-impl(arg0);
            final long result = value * scale;
            long n;
            if (isInNanos-impl(arg0)) {
                if (new LongRange(-2147483647L, 2147483647L).contains(value)) {
                    n = DurationKt.access$durationOfNanos(result);
                }
                else if (result / scale == value) {
                    n = DurationKt.access$durationOfNanosNormalized(result);
                }
                else {
                    final long millis = DurationKt.access$nanosToMillis(value);
                    final long remNanos = value - DurationKt.access$millisToNanos(millis);
                    final long resultMillis = millis * scale;
                    final long totalMillis = resultMillis + DurationKt.access$nanosToMillis(remNanos * scale);
                    n = ((resultMillis / scale == millis && (totalMillis ^ resultMillis) >= 0L) ? DurationKt.access$durationOfMillis(RangesKt___RangesKt.coerceIn(totalMillis, new LongRange(-4611686018427387903L, 4611686018427387903L))) : ((MathKt__MathJVMKt.getSign(value) * MathKt__MathJVMKt.getSign(scale) > 0) ? Duration.INFINITE : Duration.NEG_INFINITE));
                }
            }
            else {
                n = ((result / scale == value) ? DurationKt.access$durationOfMillis(RangesKt___RangesKt.coerceIn(result, new LongRange(-4611686018427387903L, 4611686018427387903L))) : ((MathKt__MathJVMKt.getSign(value) * MathKt__MathJVMKt.getSign(scale) > 0) ? Duration.INFINITE : Duration.NEG_INFINITE));
            }
            return n;
        }
    }
    
    public static final long times-UwyO8pc(final long arg0, final double scale) {
        final int intScale = MathKt__MathJVMKt.roundToInt(scale);
        if (intScale == scale) {
            return times-UwyO8pc(arg0, intScale);
        }
        final DurationUnit unit = getStorageUnit-impl(arg0);
        final double result = toDouble-impl(arg0, unit) * scale;
        return DurationKt.toDuration(result, unit);
    }
    
    public static final long div-UwyO8pc(final long arg0, final int scale) {
        if (scale == 0) {
            long n;
            if (isPositive-impl(arg0)) {
                n = Duration.INFINITE;
            }
            else {
                if (!isNegative-impl(arg0)) {
                    throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
                }
                n = Duration.NEG_INFINITE;
            }
            return n;
        }
        if (isInNanos-impl(arg0)) {
            return DurationKt.access$durationOfNanos(getValue-impl(arg0) / scale);
        }
        if (isInfinite-impl(arg0)) {
            return times-UwyO8pc(arg0, MathKt__MathJVMKt.getSign(scale));
        }
        final long result = getValue-impl(arg0) / scale;
        if (new LongRange(-4611686018426L, 4611686018426L).contains(result)) {
            final long rem = DurationKt.access$millisToNanos(getValue-impl(arg0) - result * scale) / scale;
            return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(result) + rem);
        }
        return DurationKt.access$durationOfMillis(result);
    }
    
    public static final long div-UwyO8pc(final long arg0, final double scale) {
        final int intScale = MathKt__MathJVMKt.roundToInt(scale);
        if (intScale == scale && intScale != 0) {
            return div-UwyO8pc(arg0, intScale);
        }
        final DurationUnit unit = getStorageUnit-impl(arg0);
        final double result = toDouble-impl(arg0, unit) / scale;
        return DurationKt.toDuration(result, unit);
    }
    
    public static final double div-LRDsOJo(final long arg0, final long other) {
        final DurationUnit coarserUnit = ComparisonsKt___ComparisonsJvmKt.maxOf(getStorageUnit-impl(arg0), getStorageUnit-impl(other));
        return toDouble-impl(arg0, coarserUnit) / toDouble-impl(other, coarserUnit);
    }
    
    public static final boolean isNegative-impl(final long arg0) {
        return arg0 < 0L;
    }
    
    public static final boolean isPositive-impl(final long arg0) {
        return arg0 > 0L;
    }
    
    public static final boolean isInfinite-impl(final long arg0) {
        return arg0 == Duration.INFINITE || arg0 == Duration.NEG_INFINITE;
    }
    
    public static final boolean isFinite-impl(final long arg0) {
        return !isInfinite-impl(arg0);
    }
    
    public static final long getAbsoluteValue-UwyO8pc(final long arg0) {
        return isNegative-impl(arg0) ? unaryMinus-UwyO8pc(arg0) : arg0;
    }
    
    public static int compareTo-LRDsOJo(final long arg0, final long other) {
        final long compareBits = arg0 ^ other;
        if (compareBits < 0L || ((int)compareBits & 0x1) == 0x0) {
            return Intrinsics.compare(arg0, other);
        }
        int n = 0;
        final int n2 = (int)arg0 & 0x1;
        n = 0;
        final int r = n2 - ((int)other & 0x1);
        return isNegative-impl(arg0) ? (-r) : r;
    }
    
    public int compareTo-LRDsOJo(final long other) {
        return compareTo-LRDsOJo(this.rawValue, other);
    }
    
    public static final <T> T toComponents-impl(final long arg0, @NotNull final Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        final int n = 0;
        return (T)action.invoke(getInWholeDays-impl(arg0), getHoursComponent-impl(arg0), getMinutesComponent-impl(arg0), getSecondsComponent-impl(arg0), getNanosecondsComponent-impl(arg0));
    }
    
    public static final <T> T toComponents-impl(final long arg0, @NotNull final Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        final int n = 0;
        return (T)action.invoke(getInWholeHours-impl(arg0), getMinutesComponent-impl(arg0), getSecondsComponent-impl(arg0), getNanosecondsComponent-impl(arg0));
    }
    
    public static final <T> T toComponents-impl(final long arg0, @NotNull final Function3<? super Long, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        final int n = 0;
        return (T)action.invoke(getInWholeMinutes-impl(arg0), getSecondsComponent-impl(arg0), getNanosecondsComponent-impl(arg0));
    }
    
    public static final <T> T toComponents-impl(final long arg0, @NotNull final Function2<? super Long, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        final int n = 0;
        return (T)action.invoke(getInWholeSeconds-impl(arg0), getNanosecondsComponent-impl(arg0));
    }
    
    public static final int getHoursComponent-impl(final long arg0) {
        return isInfinite-impl(arg0) ? 0 : ((int)(getInWholeHours-impl(arg0) % 24));
    }
    
    public static final int getMinutesComponent-impl(final long arg0) {
        return isInfinite-impl(arg0) ? 0 : ((int)(getInWholeMinutes-impl(arg0) % 60));
    }
    
    public static final int getSecondsComponent-impl(final long arg0) {
        return isInfinite-impl(arg0) ? 0 : ((int)(getInWholeSeconds-impl(arg0) % 60));
    }
    
    public static final int getNanosecondsComponent-impl(final long arg0) {
        return isInfinite-impl(arg0) ? 0 : (isInMillis-impl(arg0) ? ((int)DurationKt.access$millisToNanos(getValue-impl(arg0) % 1000)) : ((int)(getValue-impl(arg0) % 1000000000)));
    }
    
    public static final double toDouble-impl(final long arg0, @NotNull final DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (arg0 == Duration.INFINITE) ? Double.POSITIVE_INFINITY : ((arg0 == Duration.NEG_INFINITE) ? Double.NEGATIVE_INFINITY : DurationUnitKt__DurationUnitJvmKt.convertDurationUnit((double)getValue-impl(arg0), getStorageUnit-impl(arg0), unit));
    }
    
    public static final long toLong-impl(final long arg0, @NotNull final DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (arg0 == Duration.INFINITE) ? Long.MAX_VALUE : ((arg0 == Duration.NEG_INFINITE) ? Long.MIN_VALUE : DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(getValue-impl(arg0), getStorageUnit-impl(arg0), unit));
    }
    
    public static final int toInt-impl(final long arg0, @NotNull final DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (int)RangesKt___RangesKt.coerceIn(toLong-impl(arg0, unit), -2147483648L, 2147483647L);
    }
    
    @java.lang.Deprecated
    public static final double getInDays-impl(final long arg0) {
        return toDouble-impl(arg0, DurationUnit.DAYS);
    }
    
    @java.lang.Deprecated
    public static final double getInHours-impl(final long arg0) {
        return toDouble-impl(arg0, DurationUnit.HOURS);
    }
    
    @java.lang.Deprecated
    public static final double getInMinutes-impl(final long arg0) {
        return toDouble-impl(arg0, DurationUnit.MINUTES);
    }
    
    @java.lang.Deprecated
    public static final double getInSeconds-impl(final long arg0) {
        return toDouble-impl(arg0, DurationUnit.SECONDS);
    }
    
    @java.lang.Deprecated
    public static final double getInMilliseconds-impl(final long arg0) {
        return toDouble-impl(arg0, DurationUnit.MILLISECONDS);
    }
    
    @java.lang.Deprecated
    public static final double getInMicroseconds-impl(final long arg0) {
        return toDouble-impl(arg0, DurationUnit.MICROSECONDS);
    }
    
    @java.lang.Deprecated
    public static final double getInNanoseconds-impl(final long arg0) {
        return toDouble-impl(arg0, DurationUnit.NANOSECONDS);
    }
    
    public static final long getInWholeDays-impl(final long arg0) {
        return toLong-impl(arg0, DurationUnit.DAYS);
    }
    
    public static final long getInWholeHours-impl(final long arg0) {
        return toLong-impl(arg0, DurationUnit.HOURS);
    }
    
    public static final long getInWholeMinutes-impl(final long arg0) {
        return toLong-impl(arg0, DurationUnit.MINUTES);
    }
    
    public static final long getInWholeSeconds-impl(final long arg0) {
        return toLong-impl(arg0, DurationUnit.SECONDS);
    }
    
    public static final long getInWholeMilliseconds-impl(final long arg0) {
        return (isInMillis-impl(arg0) && isFinite-impl(arg0)) ? getValue-impl(arg0) : toLong-impl(arg0, DurationUnit.MILLISECONDS);
    }
    
    public static final long getInWholeMicroseconds-impl(final long arg0) {
        return toLong-impl(arg0, DurationUnit.MICROSECONDS);
    }
    
    public static final long getInWholeNanoseconds-impl(final long arg0) {
        final long value = getValue-impl(arg0);
        return isInNanos-impl(arg0) ? value : ((value > 9223372036854L) ? Long.MAX_VALUE : ((value < -9223372036854L) ? Long.MIN_VALUE : DurationKt.access$millisToNanos(value)));
    }
    
    @Deprecated(message = "Use inWholeNanoseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeNanoseconds", imports = {}))
    @ExperimentalTime
    @java.lang.Deprecated
    public static final long toLongNanoseconds-impl(final long arg0) {
        return getInWholeNanoseconds-impl(arg0);
    }
    
    @Deprecated(message = "Use inWholeMilliseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeMilliseconds", imports = {}))
    @ExperimentalTime
    @java.lang.Deprecated
    public static final long toLongMilliseconds-impl(final long arg0) {
        return getInWholeMilliseconds-impl(arg0);
    }
    
    @NotNull
    public static String toString-impl(final long arg0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: lstore_2       
        //     2: lload_2        
        //     3: lconst_0       
        //     4: lcmp           
        //     5: ifne            14
        //     8: ldc_w           "0s"
        //    11: goto            486
        //    14: lload_2        
        //    15: getstatic       kotlin/time/Duration.INFINITE:J
        //    18: lcmp           
        //    19: ifne            28
        //    22: ldc_w           "Infinity"
        //    25: goto            486
        //    28: lload_2        
        //    29: getstatic       kotlin/time/Duration.NEG_INFINITE:J
        //    32: lcmp           
        //    33: ifne            42
        //    36: ldc_w           "-Infinity"
        //    39: goto            486
        //    42: lload_0         /* arg0 */
        //    43: invokestatic    kotlin/time/Duration.isNegative-impl:(J)Z
        //    46: istore          isNegative
        //    48: new             Ljava/lang/StringBuilder;
        //    51: dup            
        //    52: invokespecial   java/lang/StringBuilder.<init>:()V
        //    55: astore          5
        //    57: aload           5
        //    59: astore          $this$toString_impl_u24lambda_u245
        //    61: iconst_0       
        //    62: istore          $i$a$-buildString-Duration$toString$1
        //    64: iload           isNegative
        //    66: ifeq            77
        //    69: aload           $this$toString_impl_u24lambda_u245
        //    71: bipush          45
        //    73: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //    76: pop            
        //    77: lload_0         /* arg0 */
        //    78: invokestatic    kotlin/time/Duration.getAbsoluteValue-UwyO8pc:(J)J
        //    81: lstore          arg0$iv
        //    83: iconst_0       
        //    84: istore          $i$f$toComponents-impl
        //    86: nop            
        //    87: lload           arg0$iv
        //    89: invokestatic    kotlin/time/Duration.getInWholeDays-impl:(J)J
        //    92: lload           arg0$iv
        //    94: invokestatic    kotlin/time/Duration.getHoursComponent-impl:(J)I
        //    97: lload           arg0$iv
        //    99: invokestatic    kotlin/time/Duration.getMinutesComponent-impl:(J)I
        //   102: lload           arg0$iv
        //   104: invokestatic    kotlin/time/Duration.getSecondsComponent-impl:(J)I
        //   107: lload           arg0$iv
        //   109: invokestatic    kotlin/time/Duration.getNanosecondsComponent-impl:(J)I
        //   112: istore          11
        //   114: istore          12
        //   116: istore          13
        //   118: istore          14
        //   120: lstore          days
        //   122: iconst_0       
        //   123: istore          $i$a$-toComponents-impl-Duration$toString$1$1
        //   125: lload           days
        //   127: lconst_0       
        //   128: lcmp           
        //   129: ifeq            136
        //   132: iconst_1       
        //   133: goto            137
        //   136: iconst_0       
        //   137: istore          hasDays
        //   139: iload           hours
        //   141: ifeq            148
        //   144: iconst_1       
        //   145: goto            149
        //   148: iconst_0       
        //   149: istore          hasHours
        //   151: iload           minutes
        //   153: ifeq            160
        //   156: iconst_1       
        //   157: goto            161
        //   160: iconst_0       
        //   161: istore          hasMinutes
        //   163: iload           seconds
        //   165: ifne            173
        //   168: iload           nanoseconds
        //   170: ifeq            177
        //   173: iconst_1       
        //   174: goto            178
        //   177: iconst_0       
        //   178: istore          hasSeconds
        //   180: iconst_0       
        //   181: istore          components
        //   183: iload           hasDays
        //   185: ifeq            204
        //   188: aload           $this$toString_impl_u24lambda_u245
        //   190: lload           days
        //   192: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //   195: bipush          100
        //   197: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   200: pop            
        //   201: iinc            components, 1
        //   204: iload           hasHours
        //   206: ifne            224
        //   209: iload           hasDays
        //   211: ifeq            253
        //   214: iload           hasMinutes
        //   216: ifne            224
        //   219: iload           hasSeconds
        //   221: ifeq            253
        //   224: iload           components
        //   226: iinc            components, 1
        //   229: ifle            240
        //   232: aload           $this$toString_impl_u24lambda_u245
        //   234: bipush          32
        //   236: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   239: pop            
        //   240: aload           $this$toString_impl_u24lambda_u245
        //   242: iload           hours
        //   244: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   247: bipush          104
        //   249: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   252: pop            
        //   253: iload           hasMinutes
        //   255: ifne            273
        //   258: iload           hasSeconds
        //   260: ifeq            302
        //   263: iload           hasHours
        //   265: ifne            273
        //   268: iload           hasDays
        //   270: ifeq            302
        //   273: iload           components
        //   275: iinc            components, 1
        //   278: ifle            289
        //   281: aload           $this$toString_impl_u24lambda_u245
        //   283: bipush          32
        //   285: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   288: pop            
        //   289: aload           $this$toString_impl_u24lambda_u245
        //   291: iload           minutes
        //   293: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   296: bipush          109
        //   298: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   301: pop            
        //   302: iload           hasSeconds
        //   304: ifeq            446
        //   307: iload           components
        //   309: iinc            components, 1
        //   312: ifle            323
        //   315: aload           $this$toString_impl_u24lambda_u245
        //   317: bipush          32
        //   319: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   322: pop            
        //   323: nop            
        //   324: iload           seconds
        //   326: ifne            344
        //   329: iload           hasDays
        //   331: ifne            344
        //   334: iload           hasHours
        //   336: ifne            344
        //   339: iload           hasMinutes
        //   341: ifeq            363
        //   344: lload_0         /* arg0 */
        //   345: aload           $this$toString_impl_u24lambda_u245
        //   347: iload           seconds
        //   349: iload           nanoseconds
        //   351: bipush          9
        //   353: ldc_w           "s"
        //   356: iconst_0       
        //   357: invokestatic    kotlin/time/Duration.appendFractional-impl:(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V
        //   360: goto            446
        //   363: iload           nanoseconds
        //   365: ldc_w           1000000
        //   368: if_icmplt       398
        //   371: lload_0         /* arg0 */
        //   372: aload           $this$toString_impl_u24lambda_u245
        //   374: iload           nanoseconds
        //   376: ldc_w           1000000
        //   379: idiv           
        //   380: iload           nanoseconds
        //   382: ldc_w           1000000
        //   385: irem           
        //   386: bipush          6
        //   388: ldc_w           "ms"
        //   391: iconst_0       
        //   392: invokestatic    kotlin/time/Duration.appendFractional-impl:(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V
        //   395: goto            446
        //   398: iload           nanoseconds
        //   400: sipush          1000
        //   403: if_icmplt       432
        //   406: lload_0         /* arg0 */
        //   407: aload           $this$toString_impl_u24lambda_u245
        //   409: iload           nanoseconds
        //   411: sipush          1000
        //   414: idiv           
        //   415: iload           nanoseconds
        //   417: sipush          1000
        //   420: irem           
        //   421: iconst_3       
        //   422: ldc_w           "us"
        //   425: iconst_0       
        //   426: invokestatic    kotlin/time/Duration.appendFractional-impl:(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V
        //   429: goto            446
        //   432: aload           $this$toString_impl_u24lambda_u245
        //   434: iload           nanoseconds
        //   436: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   439: ldc_w           "ns"
        //   442: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   445: pop            
        //   446: iload           isNegative
        //   448: ifeq            471
        //   451: iload           components
        //   453: iconst_1       
        //   454: if_icmple       471
        //   457: aload           $this$toString_impl_u24lambda_u245
        //   459: iconst_1       
        //   460: bipush          40
        //   462: invokevirtual   java/lang/StringBuilder.insert:(IC)Ljava/lang/StringBuilder;
        //   465: bipush          41
        //   467: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   470: pop            
        //   471: nop            
        //   472: nop            
        //   473: nop            
        //   474: aload           5
        //   476: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   479: dup            
        //   480: ldc_w           "StringBuilder().apply(builderAction).toString()"
        //   483: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   486: areturn        
        //    StackMapTable: 00 1C FC 00 0E 04 0D 0D FF 00 22 00 06 04 04 01 07 01 89 07 01 89 01 00 00 FF 00 3A 00 0E 04 04 01 07 01 89 07 01 89 01 04 01 01 01 01 01 04 01 00 00 40 01 FC 00 0A 01 40 01 FC 00 0A 01 40 01 FC 00 0B 01 03 40 01 FD 00 19 01 01 13 0F 0C 13 0F 0C 14 14 12 22 21 0D 18 FF 00 0E 00 02 04 04 00 01 07 01 C7
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @NotNull
    @Override
    public String toString() {
        return toString-impl(this.rawValue);
    }
    
    private static final void appendFractional-impl(final long arg0, final StringBuilder $this$appendFractional, final int whole, final int fractional, final int fractionalSize, final String unit, final boolean isoZeroes) {
        $this$appendFractional.append(whole);
        if (fractional != 0) {
            $this$appendFractional.append('.');
            final String fracString = StringsKt__StringsKt.padStart(String.valueOf(fractional), fractionalSize, '0');
            final CharSequence $this$indexOfLast$iv = fracString;
            final int $i$f$indexOfLast = 0;
            int n = $this$indexOfLast$iv.length() - 1;
            int n3 = 0;
            Label_0107: {
                if (0 <= n) {
                    do {
                        final int index$iv = n;
                        --n;
                        final char it = $this$indexOfLast$iv.charAt(index$iv);
                        final int n2 = 0;
                        if (it != '0') {
                            n3 = index$iv;
                            break Label_0107;
                        }
                    } while (0 <= n);
                }
                n3 = -1;
            }
            final int nonZeroDigits = n3 + 1;
            if (!isoZeroes && nonZeroDigits < 3) {
                Intrinsics.checkNotNullExpressionValue($this$appendFractional.append(fracString, 0, nonZeroDigits), "this.append(value, startIndex, endIndex)");
            }
            else {
                Intrinsics.checkNotNullExpressionValue($this$appendFractional.append(fracString, 0, (nonZeroDigits + 2) / 3 * 3), "this.append(value, startIndex, endIndex)");
            }
        }
        $this$appendFractional.append(unit);
    }
    
    @NotNull
    public static final String toString-impl(final long arg0, @NotNull final DurationUnit unit, final int decimals) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (decimals < 0) {
            final int n = 0;
            throw new IllegalArgumentException(("decimals must be not negative, but was " + decimals).toString());
        }
        final double number = toDouble-impl(arg0, unit);
        if (Double.isInfinite(number)) {
            return String.valueOf(number);
        }
        return DurationJvmKt.formatToExactDecimals(number, RangesKt___RangesKt.coerceAtMost(decimals, 12)) + DurationUnitKt__DurationUnitKt.shortName(unit);
    }
    
    @NotNull
    public static final String toIsoString-impl(final long arg0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/lang/StringBuilder.<init>:()V
        //     7: astore_2       
        //     8: aload_2        
        //     9: astore_3        /* $this$toIsoString_impl_u24lambda_u249 */
        //    10: iconst_0       
        //    11: istore          $i$a$-buildString-Duration$toIsoString$1
        //    13: lload_0         /* arg0 */
        //    14: invokestatic    kotlin/time/Duration.isNegative-impl:(J)Z
        //    17: ifeq            27
        //    20: aload_3         /* $this$toIsoString_impl_u24lambda_u249 */
        //    21: bipush          45
        //    23: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //    26: pop            
        //    27: aload_3         /* $this$toIsoString_impl_u24lambda_u249 */
        //    28: ldc_w           "PT"
        //    31: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    34: pop            
        //    35: lload_0         /* arg0 */
        //    36: invokestatic    kotlin/time/Duration.getAbsoluteValue-UwyO8pc:(J)J
        //    39: lstore          arg0$iv
        //    41: iconst_0       
        //    42: istore          $i$f$toComponents-impl
        //    44: nop            
        //    45: lload           arg0$iv
        //    47: invokestatic    kotlin/time/Duration.getInWholeHours-impl:(J)J
        //    50: lload           arg0$iv
        //    52: invokestatic    kotlin/time/Duration.getMinutesComponent-impl:(J)I
        //    55: lload           arg0$iv
        //    57: invokestatic    kotlin/time/Duration.getSecondsComponent-impl:(J)I
        //    60: lload           arg0$iv
        //    62: invokestatic    kotlin/time/Duration.getNanosecondsComponent-impl:(J)I
        //    65: istore          8
        //    67: istore          9
        //    69: istore          10
        //    71: lstore          hours
        //    73: iconst_0       
        //    74: istore          $i$a$-toComponents-impl-Duration$toIsoString$1$1
        //    76: lload           hours
        //    78: lstore          hours
        //    80: lload_0         /* arg0 */
        //    81: invokestatic    kotlin/time/Duration.isInfinite-impl:(J)Z
        //    84: ifeq            92
        //    87: ldc2_w          9999999999999
        //    90: lstore          hours
        //    92: lload           hours
        //    94: lconst_0       
        //    95: lcmp           
        //    96: ifeq            103
        //    99: iconst_1       
        //   100: goto            104
        //   103: iconst_0       
        //   104: istore          hasHours
        //   106: iload           seconds
        //   108: ifne            116
        //   111: iload           nanoseconds
        //   113: ifeq            120
        //   116: iconst_1       
        //   117: goto            121
        //   120: iconst_0       
        //   121: istore          hasSeconds
        //   123: iload           minutes
        //   125: ifne            138
        //   128: iload           hasSeconds
        //   130: ifeq            142
        //   133: iload           hasHours
        //   135: ifeq            142
        //   138: iconst_1       
        //   139: goto            143
        //   142: iconst_0       
        //   143: istore          hasMinutes
        //   145: iload           hasHours
        //   147: ifeq            162
        //   150: aload_3         /* $this$toIsoString_impl_u24lambda_u249 */
        //   151: lload           hours
        //   153: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //   156: bipush          72
        //   158: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   161: pop            
        //   162: iload           hasMinutes
        //   164: ifeq            179
        //   167: aload_3         /* $this$toIsoString_impl_u24lambda_u249 */
        //   168: iload           minutes
        //   170: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   173: bipush          77
        //   175: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   178: pop            
        //   179: iload           hasSeconds
        //   181: ifne            194
        //   184: iload           hasHours
        //   186: ifne            209
        //   189: iload           hasMinutes
        //   191: ifne            209
        //   194: lload_0         /* arg0 */
        //   195: aload_3         /* $this$toIsoString_impl_u24lambda_u249 */
        //   196: iload           seconds
        //   198: iload           nanoseconds
        //   200: bipush          9
        //   202: ldc_w           "S"
        //   205: iconst_1       
        //   206: invokestatic    kotlin/time/Duration.appendFractional-impl:(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V
        //   209: nop            
        //   210: nop            
        //   211: nop            
        //   212: aload_2        
        //   213: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   216: dup            
        //   217: ldc_w           "StringBuilder().apply(builderAction).toString()"
        //   220: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   223: areturn        
        //    StackMapTable: 00 0E FE 00 1B 07 01 89 07 01 89 01 FF 00 40 00 0C 04 07 01 89 07 01 89 01 04 01 01 01 01 04 01 04 00 00 0A 40 01 FC 00 0B 01 03 40 01 FC 00 10 01 03 40 01 FC 00 12 01 10 0E 0E
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static int hashCode-impl(final long arg0) {
        return (int)(arg0 ^ arg0 >>> 32);
    }
    
    @Override
    public int hashCode() {
        return hashCode-impl(this.rawValue);
    }
    
    public static boolean equals-impl(final long arg0, final Object other) {
        return other instanceof Duration && arg0 == ((Duration)other).unbox-impl();
    }
    
    @Override
    public boolean equals(final Object other) {
        return equals-impl(this.rawValue, other);
    }
    
    public static long constructor-impl(final long rawValue) {
        if (DurationJvmKt.getDurationAssertionsEnabled()) {
            if (isInNanos-impl(rawValue)) {
                if (!new LongRange(-4611686018426999999L, 4611686018426999999L).contains(getValue-impl(rawValue))) {
                    throw new AssertionError((Object)(getValue-impl(rawValue) + " ns is out of nanoseconds range"));
                }
            }
            else {
                if (!new LongRange(-4611686018427387903L, 4611686018427387903L).contains(getValue-impl(rawValue))) {
                    throw new AssertionError((Object)(getValue-impl(rawValue) + " ms is out of milliseconds range"));
                }
                if (new LongRange(-4611686018426L, 4611686018426L).contains(getValue-impl(rawValue))) {
                    throw new AssertionError((Object)(getValue-impl(rawValue) + " ms is denormalized"));
                }
            }
        }
        return rawValue;
    }
    
    public static final /* synthetic */ Duration box-impl(final long v) {
        return new Duration(v);
    }
    
    public final /* synthetic */ long unbox-impl() {
        return this.rawValue;
    }
    
    public static final boolean equals-impl0(final long p1, final long p2) {
        return p1 == p2;
    }
    
    public static final /* synthetic */ long access$getZERO$cp() {
        return Duration.ZERO;
    }
    
    public static final /* synthetic */ long access$getINFINITE$cp() {
        return Duration.INFINITE;
    }
    
    public static final /* synthetic */ long access$getNEG_INFINITE$cp() {
        return Duration.NEG_INFINITE;
    }
    
    static {
        Companion = new Companion(null);
        ZERO = constructor-impl(0L);
        INFINITE = DurationKt.access$durationOfMillis(4611686018427387903L);
        NEG_INFINITE = DurationKt.access$durationOfMillis(-4611686018427387903L);
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0007J\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b/\u0010\u0011J\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b/\u0010\u0014J\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b/\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b0\u0010\u0011J\u001d\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b0\u0010\u0014J\u001d\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b0\u0010\u0017J\u001d\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b1\u0010\u0011J\u001d\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b1\u0010\u0014J\u001d\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b1\u0010\u0017J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b2\u0010\u0011J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b2\u0010\u0014J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b2\u0010\u0017J\u001d\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b3\u0010\u0011J\u001d\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b3\u0010\u0014J\u001d\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b3\u0010\u0017J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b4\u0010\u0011J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b4\u0010\u0014J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b4\u0010\u0017J\u001b\u00105\u001a\u00020\u00042\u0006\u0010+\u001a\u000206\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b7\u00108J\u001b\u00109\u001a\u00020\u00042\u0006\u0010+\u001a\u000206\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b:\u00108J\u001b\u0010;\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u000206\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0002\b<J\u001b\u0010=\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u000206\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0002\b>J\u001d\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b?\u0010\u0011J\u001d\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b?\u0010\u0014J\u001d\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b?\u0010\u0017R\u0019\u0010\u0003\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004X\u0080\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R%\u0010\f\u001a\u00020\u0004*\u00020\r8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R%\u0010\f\u001a\u00020\u0004*\u00020\u00128\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0010\u0010\u0014R%\u0010\f\u001a\u00020\u0004*\u00020\u00158\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017R%\u0010\u0018\u001a\u00020\u0004*\u00020\r8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R%\u0010\u0018\u001a\u00020\u0004*\u00020\u00128\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0014R%\u0010\u0018\u001a\u00020\u0004*\u00020\u00158\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0017R%\u0010\u001b\u001a\u00020\u0004*\u00020\r8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R%\u0010\u001b\u001a\u00020\u0004*\u00020\u00128\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0014R%\u0010\u001b\u001a\u00020\u0004*\u00020\u00158\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0017R%\u0010\u001e\u001a\u00020\u0004*\u00020\r8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011R%\u0010\u001e\u001a\u00020\u0004*\u00020\u00128\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u0014R%\u0010\u001e\u001a\u00020\u0004*\u00020\u00158\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0017R%\u0010!\u001a\u00020\u0004*\u00020\r8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011R%\u0010!\u001a\u00020\u0004*\u00020\u00128\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0014R%\u0010!\u001a\u00020\u0004*\u00020\u00158\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0017R%\u0010$\u001a\u00020\u0004*\u00020\r8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b%\u0010\u000f\u001a\u0004\b&\u0010\u0011R%\u0010$\u001a\u00020\u0004*\u00020\u00128\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b%\u0010\u0013\u001a\u0004\b&\u0010\u0014R%\u0010$\u001a\u00020\u0004*\u00020\u00158\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0017R%\u0010'\u001a\u00020\u0004*\u00020\r8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010\u0011R%\u0010'\u001a\u00020\u0004*\u00020\u00128\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010\u0014R%\u0010'\u001a\u00020\u0004*\u00020\u00158\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\f\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0017\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006@" }, d2 = { "Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE-UwyO8pc", "()J", "J", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "ZERO", "getZERO-UwyO8pc", "days", "", "getDays-UwyO8pc$annotations", "(D)V", "getDays-UwyO8pc", "(D)J", "", "(I)V", "(I)J", "", "(J)V", "(J)J", "hours", "getHours-UwyO8pc$annotations", "getHours-UwyO8pc", "microseconds", "getMicroseconds-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "milliseconds", "getMilliseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "minutes", "getMinutes-UwyO8pc$annotations", "getMinutes-UwyO8pc", "nanoseconds", "getNanoseconds-UwyO8pc$annotations", "getNanoseconds-UwyO8pc", "seconds", "getSeconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "convert", "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "days-UwyO8pc", "hours-UwyO8pc", "microseconds-UwyO8pc", "milliseconds-UwyO8pc", "minutes-UwyO8pc", "nanoseconds-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "parseOrNull", "parseOrNull-FghU774", "seconds-UwyO8pc", "kotlin-stdlib" })
    public static final class Companion
    {
        private Companion() {
        }
        
        public final long getZERO-UwyO8pc() {
            return Duration.access$getZERO$cp();
        }
        
        public final long getINFINITE-UwyO8pc() {
            return Duration.access$getINFINITE$cp();
        }
        
        public final long getNEG_INFINITE-UwyO8pc$kotlin_stdlib() {
            return Duration.access$getNEG_INFINITE$cp();
        }
        
        @ExperimentalTime
        public final double convert(final double value, @NotNull final DurationUnit sourceUnit, @NotNull final DurationUnit targetUnit) {
            Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
            return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(value, sourceUnit, targetUnit);
        }
        
        private final long getNanoseconds-UwyO8pc(final int $this$nanoseconds) {
            return DurationKt.toDuration($this$nanoseconds, DurationUnit.NANOSECONDS);
        }
        
        private final long getNanoseconds-UwyO8pc(final long $this$nanoseconds) {
            return DurationKt.toDuration($this$nanoseconds, DurationUnit.NANOSECONDS);
        }
        
        private final long getNanoseconds-UwyO8pc(final double $this$nanoseconds) {
            return DurationKt.toDuration($this$nanoseconds, DurationUnit.NANOSECONDS);
        }
        
        private final long getMicroseconds-UwyO8pc(final int $this$microseconds) {
            return DurationKt.toDuration($this$microseconds, DurationUnit.MICROSECONDS);
        }
        
        private final long getMicroseconds-UwyO8pc(final long $this$microseconds) {
            return DurationKt.toDuration($this$microseconds, DurationUnit.MICROSECONDS);
        }
        
        private final long getMicroseconds-UwyO8pc(final double $this$microseconds) {
            return DurationKt.toDuration($this$microseconds, DurationUnit.MICROSECONDS);
        }
        
        private final long getMilliseconds-UwyO8pc(final int $this$milliseconds) {
            return DurationKt.toDuration($this$milliseconds, DurationUnit.MILLISECONDS);
        }
        
        private final long getMilliseconds-UwyO8pc(final long $this$milliseconds) {
            return DurationKt.toDuration($this$milliseconds, DurationUnit.MILLISECONDS);
        }
        
        private final long getMilliseconds-UwyO8pc(final double $this$milliseconds) {
            return DurationKt.toDuration($this$milliseconds, DurationUnit.MILLISECONDS);
        }
        
        private final long getSeconds-UwyO8pc(final int $this$seconds) {
            return DurationKt.toDuration($this$seconds, DurationUnit.SECONDS);
        }
        
        private final long getSeconds-UwyO8pc(final long $this$seconds) {
            return DurationKt.toDuration($this$seconds, DurationUnit.SECONDS);
        }
        
        private final long getSeconds-UwyO8pc(final double $this$seconds) {
            return DurationKt.toDuration($this$seconds, DurationUnit.SECONDS);
        }
        
        private final long getMinutes-UwyO8pc(final int $this$minutes) {
            return DurationKt.toDuration($this$minutes, DurationUnit.MINUTES);
        }
        
        private final long getMinutes-UwyO8pc(final long $this$minutes) {
            return DurationKt.toDuration($this$minutes, DurationUnit.MINUTES);
        }
        
        private final long getMinutes-UwyO8pc(final double $this$minutes) {
            return DurationKt.toDuration($this$minutes, DurationUnit.MINUTES);
        }
        
        private final long getHours-UwyO8pc(final int $this$hours) {
            return DurationKt.toDuration($this$hours, DurationUnit.HOURS);
        }
        
        private final long getHours-UwyO8pc(final long $this$hours) {
            return DurationKt.toDuration($this$hours, DurationUnit.HOURS);
        }
        
        private final long getHours-UwyO8pc(final double $this$hours) {
            return DurationKt.toDuration($this$hours, DurationUnit.HOURS);
        }
        
        private final long getDays-UwyO8pc(final int $this$days) {
            return DurationKt.toDuration($this$days, DurationUnit.DAYS);
        }
        
        private final long getDays-UwyO8pc(final long $this$days) {
            return DurationKt.toDuration($this$days, DurationUnit.DAYS);
        }
        
        private final long getDays-UwyO8pc(final double $this$days) {
            return DurationKt.toDuration($this$days, DurationUnit.DAYS);
        }
        
        @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = { "kotlin.time.Duration.Companion.nanoseconds" }))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @SinceKotlin(version = "1.5")
        @ExperimentalTime
        @java.lang.Deprecated
        public final long nanoseconds-UwyO8pc(final int value) {
            return DurationKt.toDuration(value, DurationUnit.NANOSECONDS);
        }
        
        @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = { "kotlin.time.Duration.Companion.nanoseconds" }))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @SinceKotlin(version = "1.5")
        @ExperimentalTime
        @java.lang.Deprecated
        public final long nanoseconds-UwyO8pc(final long value) {
            return DurationKt.toDuration(value, DurationUnit.NANOSECONDS);
        }
        
        @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = { "kotlin.time.Duration.Companion.nanoseconds" }))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @SinceKotlin(version = "1.5")
        @ExperimentalTime
        @java.lang.Deprecated
        public final long nanoseconds-UwyO8pc(final double value) {
            return DurationKt.toDuration(value, DurationUnit.NANOSECONDS);
        }
        
        @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = { "kotlin.time.Duration.Companion.microseconds" }))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @SinceKotlin(version = "1.5")
        @ExperimentalTime
        @java.lang.Deprecated
        public final long microseconds-UwyO8pc(final int value) {
            return DurationKt.toDuration(value, DurationUnit.MICROSECONDS);
        }
        
        @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = { "kotlin.time.Duration.Companion.microseconds" }))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @SinceKotlin(version = "1.5")
        @ExperimentalTime
        @java.lang.Deprecated
        public final long microseconds-UwyO8pc(final long value) {
            return DurationKt.toDuration(value, DurationUnit.MICROSECONDS);
        }
        
        @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = { "kotlin.time.Duration.Companion.microseconds" }))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @SinceKotlin(version = "1.5")
        @ExperimentalTime
        @java.lang.Deprecated
        public final long microseconds-UwyO8pc(final double value) {
            return DurationKt.toDuration(value, DurationUnit.MICROSECONDS);
        }
        
        @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = { "kotlin.time.Duration.Companion.milliseconds" }))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @SinceKotlin(version = "1.5")
        @ExperimentalTime
        @java.lang.Deprecated
        public final long milliseconds-UwyO8pc(final int value) {
            return DurationKt.toDuration(value, DurationUnit.MILLISECONDS);
        }
        
        @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = { "kotlin.time.Duration.Companion.milliseconds" }))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @SinceKotlin(version = "1.5")
        @ExperimentalTime
        @java.lang.Deprecated
        public final long milliseconds-UwyO8pc(final long value) {
            return DurationKt.toDuration(value, DurationUnit.MILLISECONDS);
        }
        
        @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = { "kotlin.time.Duration.Companion.milliseconds" }))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @SinceKotlin(version = "1.5")
        @ExperimentalTime
        @java.lang.Deprecated
        public final long milliseconds-UwyO8pc(final double value) {
            return DurationKt.toDuration(value, DurationUnit.MILLISECONDS);
        }
        
        @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = { "kotlin.time.Duration.Companion.seconds" }))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @SinceKotlin(version = "1.5")
        @ExperimentalTime
        @java.lang.Deprecated
        public final long seconds-UwyO8pc(final int value) {
            return DurationKt.toDuration(value, DurationUnit.SECONDS);
        }
        
        @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = { "kotlin.time.Duration.Companion.seconds" }))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @SinceKotlin(version = "1.5")
        @ExperimentalTime
        @java.lang.Deprecated
        public final long seconds-UwyO8pc(final long value) {
            return DurationKt.toDuration(value, DurationUnit.SECONDS);
        }
        
        @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = { "kotlin.time.Duration.Companion.seconds" }))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @SinceKotlin(version = "1.5")
        @ExperimentalTime
        @java.lang.Deprecated
        public final long seconds-UwyO8pc(final double value) {
            return DurationKt.toDuration(value, DurationUnit.SECONDS);
        }
        
        @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = { "kotlin.time.Duration.Companion.minutes" }))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @SinceKotlin(version = "1.5")
        @ExperimentalTime
        @java.lang.Deprecated
        public final long minutes-UwyO8pc(final int value) {
            return DurationKt.toDuration(value, DurationUnit.MINUTES);
        }
        
        @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = { "kotlin.time.Duration.Companion.minutes" }))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @SinceKotlin(version = "1.5")
        @ExperimentalTime
        @java.lang.Deprecated
        public final long minutes-UwyO8pc(final long value) {
            return DurationKt.toDuration(value, DurationUnit.MINUTES);
        }
        
        @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = { "kotlin.time.Duration.Companion.minutes" }))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @SinceKotlin(version = "1.5")
        @ExperimentalTime
        @java.lang.Deprecated
        public final long minutes-UwyO8pc(final double value) {
            return DurationKt.toDuration(value, DurationUnit.MINUTES);
        }
        
        @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = { "kotlin.time.Duration.Companion.hours" }))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @SinceKotlin(version = "1.5")
        @ExperimentalTime
        @java.lang.Deprecated
        public final long hours-UwyO8pc(final int value) {
            return DurationKt.toDuration(value, DurationUnit.HOURS);
        }
        
        @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = { "kotlin.time.Duration.Companion.hours" }))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @SinceKotlin(version = "1.5")
        @ExperimentalTime
        @java.lang.Deprecated
        public final long hours-UwyO8pc(final long value) {
            return DurationKt.toDuration(value, DurationUnit.HOURS);
        }
        
        @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = { "kotlin.time.Duration.Companion.hours" }))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @SinceKotlin(version = "1.5")
        @ExperimentalTime
        @java.lang.Deprecated
        public final long hours-UwyO8pc(final double value) {
            return DurationKt.toDuration(value, DurationUnit.HOURS);
        }
        
        @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = { "kotlin.time.Duration.Companion.days" }))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @SinceKotlin(version = "1.5")
        @ExperimentalTime
        @java.lang.Deprecated
        public final long days-UwyO8pc(final int value) {
            return DurationKt.toDuration(value, DurationUnit.DAYS);
        }
        
        @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = { "kotlin.time.Duration.Companion.days" }))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @SinceKotlin(version = "1.5")
        @ExperimentalTime
        @java.lang.Deprecated
        public final long days-UwyO8pc(final long value) {
            return DurationKt.toDuration(value, DurationUnit.DAYS);
        }
        
        @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = { "kotlin.time.Duration.Companion.days" }))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @SinceKotlin(version = "1.5")
        @ExperimentalTime
        @java.lang.Deprecated
        public final long days-UwyO8pc(final double value) {
            return DurationKt.toDuration(value, DurationUnit.DAYS);
        }
        
        public final long parse-UwyO8pc(@NotNull final String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            long access$parseDuration;
            try {
                access$parseDuration = DurationKt.access$parseDuration(value, false);
            }
            catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid duration string format: '" + value + "'.", e);
            }
            return access$parseDuration;
        }
        
        public final long parseIsoString-UwyO8pc(@NotNull final String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            long access$parseDuration;
            try {
                access$parseDuration = DurationKt.access$parseDuration(value, true);
            }
            catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e);
            }
            return access$parseDuration;
        }
        
        @Nullable
        public final Duration parseOrNull-FghU774(@NotNull final String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Duration box-impl;
            try {
                box-impl = Duration.box-impl(DurationKt.access$parseDuration(value, false));
            }
            catch (IllegalArgumentException e) {
                box-impl = null;
            }
            return box-impl;
        }
        
        @Nullable
        public final Duration parseIsoStringOrNull-FghU774(@NotNull final String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Duration box-impl;
            try {
                box-impl = Duration.box-impl(DurationKt.access$parseDuration(value, true));
            }
            catch (IllegalArgumentException e) {
                box-impl = null;
            }
            return box-impl;
        }
    }
}
