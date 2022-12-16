// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.ranges;

import kotlin.UShort;
import kotlin.UByte;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ExperimentalStdlibApi;
import kotlin.random.URandomKt;
import kotlin.internal.InlineOnly;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.WasExperimental;
import kotlin.random.Random;
import kotlin.ULong;
import org.jetbrains.annotations.Nullable;
import kotlin.UInt;
import kotlin.SinceKotlin;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0006\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001e\u0010\u0000\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001e\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0004\u001a\u001e\u0010\u000e\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0007\u001a\u001e\u0010\u000e\u001a\u00020\b*\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u0012\u0010\n\u001a\u001e\u0010\u000e\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u0013\u0010\r\u001a&\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a&\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a$\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a&\u0010\u0014\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a$\u0010\u0014\u001a\u00020\b*\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aH\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a&\u0010\u0014\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007\u00f8\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0002\u00f8\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0087\n\u00f8\u0001\u0000¢\u0006\u0002\b*\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\bH\u0087\u0002\u00f8\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u000bH\u0087\u0002\u00f8\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0002\u00f8\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0005H\u0087\u0002\u00f8\u0001\u0000¢\u0006\u0004\b2\u00103\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\b\u0010)\u001a\u0004\u0018\u00010\bH\u0087\n\u00f8\u0001\u0000¢\u0006\u0002\b4\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u000bH\u0087\u0002\u00f8\u0001\u0000¢\u0006\u0004\b5\u00106\u001a\u001f\u00107\u001a\u000208*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0087\u0004\u00f8\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a\u001f\u00107\u001a\u000208*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004\u00f8\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a\u001f\u00107\u001a\u00020>*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\u0004\u00f8\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a\u001f\u00107\u001a\u000208*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004\u00f8\u0001\u0000¢\u0006\u0004\bA\u0010B\u001a\u0014\u0010C\u001a\u00020\u0005*\u000208H\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010D\u001a\u0014\u0010C\u001a\u00020\b*\u00020>H\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010E\u001a\u0011\u0010F\u001a\u0004\u0018\u00010\u0005*\u000208H\u0007\u00f8\u0001\u0000\u001a\u0011\u0010F\u001a\u0004\u0018\u00010\b*\u00020>H\u0007\u00f8\u0001\u0000\u001a\u0014\u0010G\u001a\u00020\u0005*\u000208H\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010D\u001a\u0014\u0010G\u001a\u00020\b*\u00020>H\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010E\u001a\u0011\u0010H\u001a\u0004\u0018\u00010\u0005*\u000208H\u0007\u00f8\u0001\u0000\u001a\u0011\u0010H\u001a\u0004\u0018\u00010\b*\u00020>H\u0007\u00f8\u0001\u0000\u001a\u0015\u0010I\u001a\u00020\u0005*\u00020%H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010J\u001a\u001c\u0010I\u001a\u00020\u0005*\u00020%2\u0006\u0010I\u001a\u00020KH\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010L\u001a\u0015\u0010I\u001a\u00020\b*\u00020/H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010M\u001a\u001c\u0010I\u001a\u00020\b*\u00020/2\u0006\u0010I\u001a\u00020KH\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010N\u001a\u0012\u0010O\u001a\u0004\u0018\u00010\u0005*\u00020%H\u0087\b\u00f8\u0001\u0000\u001a\u0019\u0010O\u001a\u0004\u0018\u00010\u0005*\u00020%2\u0006\u0010I\u001a\u00020KH\u0007\u00f8\u0001\u0000\u001a\u0012\u0010O\u001a\u0004\u0018\u00010\b*\u00020/H\u0087\b\u00f8\u0001\u0000\u001a\u0019\u0010O\u001a\u0004\u0018\u00010\b*\u00020/2\u0006\u0010I\u001a\u00020KH\u0007\u00f8\u0001\u0000\u001a\u001f\u0010P\u001a\u00020%*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\bQ\u0010R\u001a\u001f\u0010P\u001a\u00020%*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u001f\u0010P\u001a\u00020/*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\bU\u0010V\u001a\u001f\u0010P\u001a\u00020%*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\bW\u0010X\u001a\f\u0010Y\u001a\u000208*\u000208H\u0007\u001a\f\u0010Y\u001a\u00020>*\u00020>H\u0007\u001a\u0015\u0010Z\u001a\u000208*\u0002082\u0006\u0010Z\u001a\u00020[H\u0087\u0004\u001a\u0015\u0010Z\u001a\u00020>*\u00020>2\u0006\u0010Z\u001a\u00020\\H\u0087\u0004\u001a\u001f\u0010]\u001a\u00020%*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0087\u0004\u00f8\u0001\u0000¢\u0006\u0004\b^\u0010R\u001a\u001f\u0010]\u001a\u00020%*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004\u00f8\u0001\u0000¢\u0006\u0004\b_\u0010T\u001a\u001f\u0010]\u001a\u00020/*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\u0004\u00f8\u0001\u0000¢\u0006\u0004\b`\u0010V\u001a\u001f\u0010]\u001a\u00020%*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004\u00f8\u0001\u0000¢\u0006\u0004\ba\u0010X\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006b" }, d2 = { "coerceAtLeast", "Lkotlin/UByte;", "minimumValue", "coerceAtLeast-Kr8caGY", "(BB)B", "Lkotlin/UInt;", "coerceAtLeast-J1ME1BU", "(II)I", "Lkotlin/ULong;", "coerceAtLeast-eb3DHEI", "(JJ)J", "Lkotlin/UShort;", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-Kr8caGY", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-WZ9TVnA", "(III)I", "range", "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "coerceIn-VKSA0NQ", "(SSS)S", "contains", "", "Lkotlin/ranges/UIntRange;", "value", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "element", "contains-biwQdVI", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "Lkotlin/ranges/ULongRange;", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-GYNo2lE", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", "Lkotlin/ranges/UIntProgression;", "to", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ULongProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "first", "(Lkotlin/ranges/UIntProgression;)I", "(Lkotlin/ranges/ULongProgression;)J", "firstOrNull", "last", "lastOrNull", "random", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;)J", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "rangeUntil", "rangeUntil-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "rangeUntil-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "rangeUntil-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "rangeUntil-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "reversed", "step", "", "", "until", "until-Kr8caGY", "until-J1ME1BU", "until-eb3DHEI", "until-5PvTz6A", "kotlin-stdlib" }, xs = "kotlin/ranges/URangesKt")
class URangesKt___URangesKt
{
    @SinceKotlin(version = "1.7")
    public static final int first(@NotNull final UIntProgression $this$first) {
        Intrinsics.checkNotNullParameter($this$first, "<this>");
        if ($this$first.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$first + " is empty.");
        }
        return $this$first.getFirst-pVg5ArA();
    }
    
    @SinceKotlin(version = "1.7")
    public static final long first(@NotNull final ULongProgression $this$first) {
        Intrinsics.checkNotNullParameter($this$first, "<this>");
        if ($this$first.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$first + " is empty.");
        }
        return $this$first.getFirst-s-VKNKU();
    }
    
    @SinceKotlin(version = "1.7")
    @Nullable
    public static final UInt firstOrNull(@NotNull final UIntProgression $this$firstOrNull) {
        Intrinsics.checkNotNullParameter($this$firstOrNull, "<this>");
        return $this$firstOrNull.isEmpty() ? null : UInt.box-impl($this$firstOrNull.getFirst-pVg5ArA());
    }
    
    @SinceKotlin(version = "1.7")
    @Nullable
    public static final ULong firstOrNull(@NotNull final ULongProgression $this$firstOrNull) {
        Intrinsics.checkNotNullParameter($this$firstOrNull, "<this>");
        return $this$firstOrNull.isEmpty() ? null : ULong.box-impl($this$firstOrNull.getFirst-s-VKNKU());
    }
    
    @SinceKotlin(version = "1.7")
    public static final int last(@NotNull final UIntProgression $this$last) {
        Intrinsics.checkNotNullParameter($this$last, "<this>");
        if ($this$last.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$last + " is empty.");
        }
        return $this$last.getLast-pVg5ArA();
    }
    
    @SinceKotlin(version = "1.7")
    public static final long last(@NotNull final ULongProgression $this$last) {
        Intrinsics.checkNotNullParameter($this$last, "<this>");
        if ($this$last.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$last + " is empty.");
        }
        return $this$last.getLast-s-VKNKU();
    }
    
    @SinceKotlin(version = "1.7")
    @Nullable
    public static final UInt lastOrNull(@NotNull final UIntProgression $this$lastOrNull) {
        Intrinsics.checkNotNullParameter($this$lastOrNull, "<this>");
        return $this$lastOrNull.isEmpty() ? null : UInt.box-impl($this$lastOrNull.getLast-pVg5ArA());
    }
    
    @SinceKotlin(version = "1.7")
    @Nullable
    public static final ULong lastOrNull(@NotNull final ULongProgression $this$lastOrNull) {
        Intrinsics.checkNotNullParameter($this$lastOrNull, "<this>");
        return $this$lastOrNull.isEmpty() ? null : ULong.box-impl($this$lastOrNull.getLast-s-VKNKU());
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @InlineOnly
    private static final int random(final UIntRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return random($this$random, Random.Default);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @InlineOnly
    private static final long random(final ULongRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return random($this$random, Random.Default);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final int random(@NotNull final UIntRange $this$random, @NotNull final Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextUInt(random, $this$random);
        }
        catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final long random(@NotNull final ULongRange $this$random, @NotNull final Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextULong(random, $this$random);
        }
        catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class })
    @InlineOnly
    private static final UInt randomOrNull(final UIntRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return randomOrNull($this$randomOrNull, Random.Default);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class })
    @InlineOnly
    private static final ULong randomOrNull(final ULongRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return randomOrNull($this$randomOrNull, Random.Default);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class })
    @Nullable
    public static final UInt randomOrNull(@NotNull final UIntRange $this$randomOrNull, @NotNull final Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return UInt.box-impl(URandomKt.nextUInt(random, $this$randomOrNull));
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class })
    @Nullable
    public static final ULong randomOrNull(@NotNull final ULongRange $this$randomOrNull, @NotNull final Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return ULong.box-impl(URandomKt.nextULong(random, $this$randomOrNull));
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @InlineOnly
    private static final boolean contains-biwQdVI(final UIntRange $this$contains_u2dbiwQdVI, final UInt element) {
        Intrinsics.checkNotNullParameter($this$contains_u2dbiwQdVI, "$this$contains");
        return element != null && $this$contains_u2dbiwQdVI.contains-WZ4Q5Ns(element.unbox-impl());
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @InlineOnly
    private static final boolean contains-GYNo2lE(final ULongRange $this$contains_u2dGYNo2lE, final ULong element) {
        Intrinsics.checkNotNullParameter($this$contains_u2dGYNo2lE, "$this$contains");
        return element != null && $this$contains_u2dGYNo2lE.contains-VKZWuLQ(element.unbox-impl());
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final boolean contains-68kG9v0(@NotNull final UIntRange $this$contains_u2d68kG9v0, final byte value) {
        Intrinsics.checkNotNullParameter($this$contains_u2d68kG9v0, "$this$contains");
        return $this$contains_u2d68kG9v0.contains-WZ4Q5Ns(UInt.constructor-impl(value & 0xFF));
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final boolean contains-ULb-yJY(@NotNull final ULongRange $this$contains_u2dULb_u2dyJY, final byte value) {
        Intrinsics.checkNotNullParameter($this$contains_u2dULb_u2dyJY, "$this$contains");
        return $this$contains_u2dULb_u2dyJY.contains-VKZWuLQ(ULong.constructor-impl((long)value & 0xFFL));
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final boolean contains-Gab390E(@NotNull final ULongRange $this$contains_u2dGab390E, final int value) {
        Intrinsics.checkNotNullParameter($this$contains_u2dGab390E, "$this$contains");
        return $this$contains_u2dGab390E.contains-VKZWuLQ(ULong.constructor-impl((long)value & 0xFFFFFFFFL));
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final boolean contains-fz5IDCE(@NotNull final UIntRange $this$contains_u2dfz5IDCE, final long value) {
        Intrinsics.checkNotNullParameter($this$contains_u2dfz5IDCE, "$this$contains");
        return ULong.constructor-impl(value >>> 32) == 0L && $this$contains_u2dfz5IDCE.contains-WZ4Q5Ns(UInt.constructor-impl((int)value));
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final boolean contains-ZsK3CEQ(@NotNull final UIntRange $this$contains_u2dZsK3CEQ, final short value) {
        Intrinsics.checkNotNullParameter($this$contains_u2dZsK3CEQ, "$this$contains");
        return $this$contains_u2dZsK3CEQ.contains-WZ4Q5Ns(UInt.constructor-impl(value & 0xFFFF));
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final boolean contains-uhHAxoY(@NotNull final ULongRange $this$contains_u2duhHAxoY, final short value) {
        Intrinsics.checkNotNullParameter($this$contains_u2duhHAxoY, "$this$contains");
        return $this$contains_u2duhHAxoY.contains-VKZWuLQ(ULong.constructor-impl((long)value & 0xFFFFL));
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @NotNull
    public static final UIntProgression downTo-Kr8caGY(final byte $this$downTo_u2dKr8caGY, final byte to) {
        return UIntProgression.Companion.fromClosedRange-Nkh28Cs(UInt.constructor-impl($this$downTo_u2dKr8caGY & 0xFF), UInt.constructor-impl(to & 0xFF), -1);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @NotNull
    public static final UIntProgression downTo-J1ME1BU(final int $this$downTo_u2dJ1ME1BU, final int to) {
        return UIntProgression.Companion.fromClosedRange-Nkh28Cs($this$downTo_u2dJ1ME1BU, to, -1);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @NotNull
    public static final ULongProgression downTo-eb3DHEI(final long $this$downTo_u2deb3DHEI, final long to) {
        return ULongProgression.Companion.fromClosedRange-7ftBX0g($this$downTo_u2deb3DHEI, to, -1L);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @NotNull
    public static final UIntProgression downTo-5PvTz6A(final short $this$downTo_u2d5PvTz6A, final short to) {
        return UIntProgression.Companion.fromClosedRange-Nkh28Cs(UInt.constructor-impl($this$downTo_u2d5PvTz6A & 0xFFFF), UInt.constructor-impl(to & 0xFFFF), -1);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final UIntRange rangeUntil-Kr8caGY(final byte $this$rangeUntil_u2dKr8caGY, final byte to) {
        return until-Kr8caGY($this$rangeUntil_u2dKr8caGY, to);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final UIntRange rangeUntil-J1ME1BU(final int $this$rangeUntil_u2dJ1ME1BU, final int to) {
        return until-J1ME1BU($this$rangeUntil_u2dJ1ME1BU, to);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final ULongRange rangeUntil-eb3DHEI(final long $this$rangeUntil_u2deb3DHEI, final long to) {
        return until-eb3DHEI($this$rangeUntil_u2deb3DHEI, to);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final UIntRange rangeUntil-5PvTz6A(final short $this$rangeUntil_u2d5PvTz6A, final short to) {
        return until-5PvTz6A($this$rangeUntil_u2d5PvTz6A, to);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @NotNull
    public static final UIntProgression reversed(@NotNull final UIntProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return UIntProgression.Companion.fromClosedRange-Nkh28Cs($this$reversed.getLast-pVg5ArA(), $this$reversed.getFirst-pVg5ArA(), -$this$reversed.getStep());
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @NotNull
    public static final ULongProgression reversed(@NotNull final ULongProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return ULongProgression.Companion.fromClosedRange-7ftBX0g($this$reversed.getLast-s-VKNKU(), $this$reversed.getFirst-s-VKNKU(), -$this$reversed.getStep());
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @NotNull
    public static final UIntProgression step(@NotNull final UIntProgression $this$step, final int step) {
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(step > 0, step);
        return UIntProgression.Companion.fromClosedRange-Nkh28Cs($this$step.getFirst-pVg5ArA(), $this$step.getLast-pVg5ArA(), ($this$step.getStep() > 0) ? step : (-step));
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @NotNull
    public static final ULongProgression step(@NotNull final ULongProgression $this$step, final long step) {
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(step > 0L, step);
        return ULongProgression.Companion.fromClosedRange-7ftBX0g($this$step.getFirst-s-VKNKU(), $this$step.getLast-s-VKNKU(), ($this$step.getStep() > 0L) ? step : (-step));
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @NotNull
    public static final UIntRange until-Kr8caGY(final byte $this$until_u2dKr8caGY, final byte to) {
        if (Intrinsics.compare(to & 0xFF, 0x0 & 0xFF) <= 0) {
            return UIntRange.Companion.getEMPTY();
        }
        return new UIntRange(UInt.constructor-impl($this$until_u2dKr8caGY & 0xFF), UInt.constructor-impl(UInt.constructor-impl(to & 0xFF) - 1), null);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @NotNull
    public static final UIntRange until-J1ME1BU(final int $this$until_u2dJ1ME1BU, final int to) {
        if (UnsignedKt.uintCompare(to, 0) <= 0) {
            return UIntRange.Companion.getEMPTY();
        }
        return new UIntRange($this$until_u2dJ1ME1BU, UInt.constructor-impl(to - 1), null);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @NotNull
    public static final ULongRange until-eb3DHEI(final long $this$until_u2deb3DHEI, final long to) {
        if (UnsignedKt.ulongCompare(to, 0L) <= 0) {
            return ULongRange.Companion.getEMPTY();
        }
        return new ULongRange($this$until_u2deb3DHEI, ULong.constructor-impl(to - ULong.constructor-impl((long)1 & 0xFFFFFFFFL)), null);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @NotNull
    public static final UIntRange until-5PvTz6A(final short $this$until_u2d5PvTz6A, final short to) {
        if (Intrinsics.compare(to & 0xFFFF, 0x0 & 0xFFFF) <= 0) {
            return UIntRange.Companion.getEMPTY();
        }
        return new UIntRange(UInt.constructor-impl($this$until_u2d5PvTz6A & 0xFFFF), UInt.constructor-impl(UInt.constructor-impl(to & 0xFFFF) - 1), null);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final int coerceAtLeast-J1ME1BU(final int $this$coerceAtLeast_u2dJ1ME1BU, final int minimumValue) {
        return (UnsignedKt.uintCompare($this$coerceAtLeast_u2dJ1ME1BU, minimumValue) < 0) ? minimumValue : $this$coerceAtLeast_u2dJ1ME1BU;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final long coerceAtLeast-eb3DHEI(final long $this$coerceAtLeast_u2deb3DHEI, final long minimumValue) {
        return (UnsignedKt.ulongCompare($this$coerceAtLeast_u2deb3DHEI, minimumValue) < 0) ? minimumValue : $this$coerceAtLeast_u2deb3DHEI;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final byte coerceAtLeast-Kr8caGY(final byte $this$coerceAtLeast_u2dKr8caGY, final byte minimumValue) {
        return (Intrinsics.compare($this$coerceAtLeast_u2dKr8caGY & 0xFF, minimumValue & 0xFF) < 0) ? minimumValue : $this$coerceAtLeast_u2dKr8caGY;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final short coerceAtLeast-5PvTz6A(final short $this$coerceAtLeast_u2d5PvTz6A, final short minimumValue) {
        return (Intrinsics.compare($this$coerceAtLeast_u2d5PvTz6A & 0xFFFF, minimumValue & 0xFFFF) < 0) ? minimumValue : $this$coerceAtLeast_u2d5PvTz6A;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final int coerceAtMost-J1ME1BU(final int $this$coerceAtMost_u2dJ1ME1BU, final int maximumValue) {
        return (UnsignedKt.uintCompare($this$coerceAtMost_u2dJ1ME1BU, maximumValue) > 0) ? maximumValue : $this$coerceAtMost_u2dJ1ME1BU;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final long coerceAtMost-eb3DHEI(final long $this$coerceAtMost_u2deb3DHEI, final long maximumValue) {
        return (UnsignedKt.ulongCompare($this$coerceAtMost_u2deb3DHEI, maximumValue) > 0) ? maximumValue : $this$coerceAtMost_u2deb3DHEI;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final byte coerceAtMost-Kr8caGY(final byte $this$coerceAtMost_u2dKr8caGY, final byte maximumValue) {
        return (Intrinsics.compare($this$coerceAtMost_u2dKr8caGY & 0xFF, maximumValue & 0xFF) > 0) ? maximumValue : $this$coerceAtMost_u2dKr8caGY;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final short coerceAtMost-5PvTz6A(final short $this$coerceAtMost_u2d5PvTz6A, final short maximumValue) {
        return (Intrinsics.compare($this$coerceAtMost_u2d5PvTz6A & 0xFFFF, maximumValue & 0xFFFF) > 0) ? maximumValue : $this$coerceAtMost_u2d5PvTz6A;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final int coerceIn-WZ9TVnA(final int $this$coerceIn_u2dWZ9TVnA, final int minimumValue, final int maximumValue) {
        if (UnsignedKt.uintCompare(minimumValue, maximumValue) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + (Object)UInt.toString-impl(maximumValue) + " is less than minimum " + (Object)UInt.toString-impl(minimumValue) + '.');
        }
        if (UnsignedKt.uintCompare($this$coerceIn_u2dWZ9TVnA, minimumValue) < 0) {
            return minimumValue;
        }
        if (UnsignedKt.uintCompare($this$coerceIn_u2dWZ9TVnA, maximumValue) > 0) {
            return maximumValue;
        }
        return $this$coerceIn_u2dWZ9TVnA;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final long coerceIn-sambcqE(final long $this$coerceIn_u2dsambcqE, final long minimumValue, final long maximumValue) {
        if (UnsignedKt.ulongCompare(minimumValue, maximumValue) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + (Object)ULong.toString-impl(maximumValue) + " is less than minimum " + (Object)ULong.toString-impl(minimumValue) + '.');
        }
        if (UnsignedKt.ulongCompare($this$coerceIn_u2dsambcqE, minimumValue) < 0) {
            return minimumValue;
        }
        if (UnsignedKt.ulongCompare($this$coerceIn_u2dsambcqE, maximumValue) > 0) {
            return maximumValue;
        }
        return $this$coerceIn_u2dsambcqE;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final byte coerceIn-b33U2AM(final byte $this$coerceIn_u2db33U2AM, final byte minimumValue, final byte maximumValue) {
        if (Intrinsics.compare(minimumValue & 0xFF, maximumValue & 0xFF) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + (Object)UByte.toString-impl(maximumValue) + " is less than minimum " + (Object)UByte.toString-impl(minimumValue) + '.');
        }
        if (Intrinsics.compare($this$coerceIn_u2db33U2AM & 0xFF, minimumValue & 0xFF) < 0) {
            return minimumValue;
        }
        if (Intrinsics.compare($this$coerceIn_u2db33U2AM & 0xFF, maximumValue & 0xFF) > 0) {
            return maximumValue;
        }
        return $this$coerceIn_u2db33U2AM;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final short coerceIn-VKSA0NQ(final short $this$coerceIn_u2dVKSA0NQ, final short minimumValue, final short maximumValue) {
        if (Intrinsics.compare(minimumValue & 0xFFFF, maximumValue & 0xFFFF) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + (Object)UShort.toString-impl(maximumValue) + " is less than minimum " + (Object)UShort.toString-impl(minimumValue) + '.');
        }
        if (Intrinsics.compare($this$coerceIn_u2dVKSA0NQ & 0xFFFF, minimumValue & 0xFFFF) < 0) {
            return minimumValue;
        }
        if (Intrinsics.compare($this$coerceIn_u2dVKSA0NQ & 0xFFFF, maximumValue & 0xFFFF) > 0) {
            return maximumValue;
        }
        return $this$coerceIn_u2dVKSA0NQ;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final int coerceIn-wuiCnnA(final int $this$coerceIn_u2dwuiCnnA, @NotNull final ClosedRange<UInt> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return RangesKt___RangesKt.coerceIn(UInt.box-impl($this$coerceIn_u2dwuiCnnA), (ClosedFloatingPointRange<UInt>)range).unbox-impl();
        }
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
        }
        return (UnsignedKt.uintCompare($this$coerceIn_u2dwuiCnnA, range.getStart().unbox-impl()) < 0) ? range.getStart().unbox-impl() : ((UnsignedKt.uintCompare($this$coerceIn_u2dwuiCnnA, range.getEndInclusive().unbox-impl()) > 0) ? range.getEndInclusive().unbox-impl() : $this$coerceIn_u2dwuiCnnA);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final long coerceIn-JPwROB0(final long $this$coerceIn_u2dJPwROB0, @NotNull final ClosedRange<ULong> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return RangesKt___RangesKt.coerceIn(ULong.box-impl($this$coerceIn_u2dJPwROB0), (ClosedFloatingPointRange<ULong>)range).unbox-impl();
        }
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
        }
        return (UnsignedKt.ulongCompare($this$coerceIn_u2dJPwROB0, range.getStart().unbox-impl()) < 0) ? range.getStart().unbox-impl() : ((UnsignedKt.ulongCompare($this$coerceIn_u2dJPwROB0, range.getEndInclusive().unbox-impl()) > 0) ? range.getEndInclusive().unbox-impl() : $this$coerceIn_u2dJPwROB0);
    }
    
    public URangesKt___URangesKt() {
    }
}
