// 
// Decompiled by Procyon v0.5.36
// 

package kotlin;

import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.UIntRange;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.jvm.JvmInline;

@JvmInline
@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001tB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00f8\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\n\u00f8\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0010J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013J\u001b\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#H\u00d6\u0003¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\b\u00f8\u0001\u0000¢\u0006\u0004\b'\u0010\u0010J\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0000¢\u0006\u0004\b(\u0010\u0013J\u001b\u0010&\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\b\u00f8\u0001\u0000¢\u0006\u0004\b)\u0010\u001fJ\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000¢\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rH\u00d6\u0001¢\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b/\u0010\u0005J\u0016\u00100\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b1\u0010\u0005J\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\b3\u0010\u0010J\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\b4\u0010\u0013J\u001b\u00102\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\b5\u0010\u001fJ\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\b6\u0010\u0018J\u001b\u00107\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\b\u00f8\u0001\u0000¢\u0006\u0004\b8\u00109J\u001b\u00107\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0000¢\u0006\u0004\b:\u0010\u0013J\u001b\u00107\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\b\u00f8\u0001\u0000¢\u0006\u0004\b;\u0010\u001fJ\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000¢\u0006\u0004\b<\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000¢\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\b@\u0010\u0010J\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\bA\u0010\u0013J\u001b\u0010?\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\bB\u0010\u001fJ\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\bC\u0010\u0018J\u001b\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001b\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\bI\u0010\u0010J\u001b\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\bJ\u0010\u0013J\u001b\u0010H\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\bK\u0010\u001fJ\u001b\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\bL\u0010\u0018J\u001b\u0010M\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\bN\u0010\u0010J\u001b\u0010M\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\bO\u0010\u0013J\u001b\u0010M\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\bP\u0010\u001fJ\u001b\u0010M\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000¢\u0006\u0004\bQ\u0010\u0018J\u0010\u0010R\u001a\u00020SH\u0087\b¢\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020WH\u0087\b¢\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020[H\u0087\b¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020\rH\u0087\b¢\u0006\u0004\b_\u0010-J\u0010\u0010`\u001a\u00020aH\u0087\b¢\u0006\u0004\bb\u0010cJ\u0010\u0010d\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\be\u0010\u0005J\u000f\u0010f\u001a\u00020gH\u0016¢\u0006\u0004\bh\u0010iJ\u0016\u0010j\u001a\u00020\u000eH\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\bk\u0010UJ\u0016\u0010l\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\bm\u0010-J\u0016\u0010n\u001a\u00020\u0014H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\bo\u0010cJ\u0016\u0010p\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\bq\u0010\u0005J\u001b\u0010r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000¢\u0006\u0004\bs\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006u" }, d2 = { "Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "getData$annotations", "()V", "and", "other", "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-Mh2AYeg", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(S)I", "inc", "inc-Mh2AYeg", "inv", "inv-Mh2AYeg", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(SB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "or", "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib" })
@SinceKotlin(version = "1.5")
@WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
public final class UShort implements Comparable<UShort>
{
    @NotNull
    public static final Companion Companion;
    private final short data = data;
    public static final short MIN_VALUE = 0;
    public static final short MAX_VALUE = -1;
    public static final int SIZE_BYTES = 2;
    public static final int SIZE_BITS = 16;
    
    @InlineOnly
    private static final int compareTo-7apg3OU(final short arg0, final byte other) {
        return Intrinsics.compare(arg0 & 0xFFFF, other & 0xFF);
    }
    
    @InlineOnly
    private static int compareTo-xj2QHRw(final short arg0, final short other) {
        return Intrinsics.compare(arg0 & 0xFFFF, other & 0xFFFF);
    }
    
    @InlineOnly
    private int compareTo-xj2QHRw(final short other) {
        return Intrinsics.compare(this.unbox-impl() & 0xFFFF, other & 0xFFFF);
    }
    
    @InlineOnly
    private static final int compareTo-WZ4Q5Ns(final short arg0, final int other) {
        return UnsignedKt.uintCompare(UInt.constructor-impl(arg0 & 0xFFFF), other);
    }
    
    @InlineOnly
    private static final int compareTo-VKZWuLQ(final short arg0, final long other) {
        return UnsignedKt.ulongCompare(ULong.constructor-impl((long)arg0 & 0xFFFFL), other);
    }
    
    @InlineOnly
    private static final int plus-7apg3OU(final short arg0, final byte other) {
        return UInt.constructor-impl(UInt.constructor-impl(arg0 & 0xFFFF) + UInt.constructor-impl(other & 0xFF));
    }
    
    @InlineOnly
    private static final int plus-xj2QHRw(final short arg0, final short other) {
        return UInt.constructor-impl(UInt.constructor-impl(arg0 & 0xFFFF) + UInt.constructor-impl(other & 0xFFFF));
    }
    
    @InlineOnly
    private static final int plus-WZ4Q5Ns(final short arg0, final int other) {
        return UInt.constructor-impl(UInt.constructor-impl(arg0 & 0xFFFF) + other);
    }
    
    @InlineOnly
    private static final long plus-VKZWuLQ(final short arg0, final long other) {
        return ULong.constructor-impl(ULong.constructor-impl((long)arg0 & 0xFFFFL) + other);
    }
    
    @InlineOnly
    private static final int minus-7apg3OU(final short arg0, final byte other) {
        return UInt.constructor-impl(UInt.constructor-impl(arg0 & 0xFFFF) - UInt.constructor-impl(other & 0xFF));
    }
    
    @InlineOnly
    private static final int minus-xj2QHRw(final short arg0, final short other) {
        return UInt.constructor-impl(UInt.constructor-impl(arg0 & 0xFFFF) - UInt.constructor-impl(other & 0xFFFF));
    }
    
    @InlineOnly
    private static final int minus-WZ4Q5Ns(final short arg0, final int other) {
        return UInt.constructor-impl(UInt.constructor-impl(arg0 & 0xFFFF) - other);
    }
    
    @InlineOnly
    private static final long minus-VKZWuLQ(final short arg0, final long other) {
        return ULong.constructor-impl(ULong.constructor-impl((long)arg0 & 0xFFFFL) - other);
    }
    
    @InlineOnly
    private static final int times-7apg3OU(final short arg0, final byte other) {
        return UInt.constructor-impl(UInt.constructor-impl(arg0 & 0xFFFF) * UInt.constructor-impl(other & 0xFF));
    }
    
    @InlineOnly
    private static final int times-xj2QHRw(final short arg0, final short other) {
        return UInt.constructor-impl(UInt.constructor-impl(arg0 & 0xFFFF) * UInt.constructor-impl(other & 0xFFFF));
    }
    
    @InlineOnly
    private static final int times-WZ4Q5Ns(final short arg0, final int other) {
        return UInt.constructor-impl(UInt.constructor-impl(arg0 & 0xFFFF) * other);
    }
    
    @InlineOnly
    private static final long times-VKZWuLQ(final short arg0, final long other) {
        return ULong.constructor-impl(ULong.constructor-impl((long)arg0 & 0xFFFFL) * other);
    }
    
    @InlineOnly
    private static final int div-7apg3OU(final short arg0, final byte other) {
        return UnsignedKt.uintDivide-J1ME1BU(UInt.constructor-impl(arg0 & 0xFFFF), UInt.constructor-impl(other & 0xFF));
    }
    
    @InlineOnly
    private static final int div-xj2QHRw(final short arg0, final short other) {
        return UnsignedKt.uintDivide-J1ME1BU(UInt.constructor-impl(arg0 & 0xFFFF), UInt.constructor-impl(other & 0xFFFF));
    }
    
    @InlineOnly
    private static final int div-WZ4Q5Ns(final short arg0, final int other) {
        return UnsignedKt.uintDivide-J1ME1BU(UInt.constructor-impl(arg0 & 0xFFFF), other);
    }
    
    @InlineOnly
    private static final long div-VKZWuLQ(final short arg0, final long other) {
        return UnsignedKt.ulongDivide-eb3DHEI(ULong.constructor-impl((long)arg0 & 0xFFFFL), other);
    }
    
    @InlineOnly
    private static final int rem-7apg3OU(final short arg0, final byte other) {
        return UnsignedKt.uintRemainder-J1ME1BU(UInt.constructor-impl(arg0 & 0xFFFF), UInt.constructor-impl(other & 0xFF));
    }
    
    @InlineOnly
    private static final int rem-xj2QHRw(final short arg0, final short other) {
        return UnsignedKt.uintRemainder-J1ME1BU(UInt.constructor-impl(arg0 & 0xFFFF), UInt.constructor-impl(other & 0xFFFF));
    }
    
    @InlineOnly
    private static final int rem-WZ4Q5Ns(final short arg0, final int other) {
        return UnsignedKt.uintRemainder-J1ME1BU(UInt.constructor-impl(arg0 & 0xFFFF), other);
    }
    
    @InlineOnly
    private static final long rem-VKZWuLQ(final short arg0, final long other) {
        return UnsignedKt.ulongRemainder-eb3DHEI(ULong.constructor-impl((long)arg0 & 0xFFFFL), other);
    }
    
    @InlineOnly
    private static final int floorDiv-7apg3OU(final short arg0, final byte other) {
        return UnsignedKt.uintDivide-J1ME1BU(UInt.constructor-impl(arg0 & 0xFFFF), UInt.constructor-impl(other & 0xFF));
    }
    
    @InlineOnly
    private static final int floorDiv-xj2QHRw(final short arg0, final short other) {
        return UnsignedKt.uintDivide-J1ME1BU(UInt.constructor-impl(arg0 & 0xFFFF), UInt.constructor-impl(other & 0xFFFF));
    }
    
    @InlineOnly
    private static final int floorDiv-WZ4Q5Ns(final short arg0, final int other) {
        return UnsignedKt.uintDivide-J1ME1BU(UInt.constructor-impl(arg0 & 0xFFFF), other);
    }
    
    @InlineOnly
    private static final long floorDiv-VKZWuLQ(final short arg0, final long other) {
        return UnsignedKt.ulongDivide-eb3DHEI(ULong.constructor-impl((long)arg0 & 0xFFFFL), other);
    }
    
    @InlineOnly
    private static final byte mod-7apg3OU(final short arg0, final byte other) {
        return UByte.constructor-impl((byte)UnsignedKt.uintRemainder-J1ME1BU(UInt.constructor-impl(arg0 & 0xFFFF), UInt.constructor-impl(other & 0xFF)));
    }
    
    @InlineOnly
    private static final short mod-xj2QHRw(final short arg0, final short other) {
        return constructor-impl((short)UnsignedKt.uintRemainder-J1ME1BU(UInt.constructor-impl(arg0 & 0xFFFF), UInt.constructor-impl(other & 0xFFFF)));
    }
    
    @InlineOnly
    private static final int mod-WZ4Q5Ns(final short arg0, final int other) {
        return UnsignedKt.uintRemainder-J1ME1BU(UInt.constructor-impl(arg0 & 0xFFFF), other);
    }
    
    @InlineOnly
    private static final long mod-VKZWuLQ(final short arg0, final long other) {
        return UnsignedKt.ulongRemainder-eb3DHEI(ULong.constructor-impl((long)arg0 & 0xFFFFL), other);
    }
    
    @InlineOnly
    private static final short inc-Mh2AYeg(final short arg0) {
        return constructor-impl((short)(arg0 + 1));
    }
    
    @InlineOnly
    private static final short dec-Mh2AYeg(final short arg0) {
        return constructor-impl((short)(arg0 - 1));
    }
    
    @InlineOnly
    private static final UIntRange rangeTo-xj2QHRw(final short arg0, final short other) {
        return new UIntRange(UInt.constructor-impl(arg0 & 0xFFFF), UInt.constructor-impl(other & 0xFFFF), null);
    }
    
    @InlineOnly
    private static final short and-xj2QHRw(final short arg0, final short other) {
        return constructor-impl((short)(arg0 & other));
    }
    
    @InlineOnly
    private static final short or-xj2QHRw(final short arg0, final short other) {
        return constructor-impl((short)(arg0 | other));
    }
    
    @InlineOnly
    private static final short xor-xj2QHRw(final short arg0, final short other) {
        return constructor-impl((short)(arg0 ^ other));
    }
    
    @InlineOnly
    private static final short inv-Mh2AYeg(final short arg0) {
        return constructor-impl((short)~arg0);
    }
    
    @InlineOnly
    private static final byte toByte-impl(final short arg0) {
        return (byte)arg0;
    }
    
    @InlineOnly
    private static final short toShort-impl(final short arg0) {
        return arg0;
    }
    
    @InlineOnly
    private static final int toInt-impl(final short arg0) {
        return arg0 & 0xFFFF;
    }
    
    @InlineOnly
    private static final long toLong-impl(final short arg0) {
        return (long)arg0 & 0xFFFFL;
    }
    
    @InlineOnly
    private static final byte toUByte-w2LRezQ(final short arg0) {
        return UByte.constructor-impl((byte)arg0);
    }
    
    @InlineOnly
    private static final short toUShort-Mh2AYeg(final short arg0) {
        return arg0;
    }
    
    @InlineOnly
    private static final int toUInt-pVg5ArA(final short arg0) {
        return UInt.constructor-impl(arg0 & 0xFFFF);
    }
    
    @InlineOnly
    private static final long toULong-s-VKNKU(final short arg0) {
        return ULong.constructor-impl((long)arg0 & 0xFFFFL);
    }
    
    @InlineOnly
    private static final float toFloat-impl(final short arg0) {
        return (float)(arg0 & 0xFFFF);
    }
    
    @InlineOnly
    private static final double toDouble-impl(final short arg0) {
        return arg0 & 0xFFFF;
    }
    
    @NotNull
    public static String toString-impl(final short arg0) {
        return String.valueOf(arg0 & 0xFFFF);
    }
    
    @NotNull
    @Override
    public String toString() {
        return toString-impl(this.data);
    }
    
    public static int hashCode-impl(final short arg0) {
        return arg0;
    }
    
    @Override
    public int hashCode() {
        return hashCode-impl(this.data);
    }
    
    public static boolean equals-impl(final short arg0, final Object other) {
        return other instanceof UShort && arg0 == ((UShort)other).unbox-impl();
    }
    
    @Override
    public boolean equals(final Object other) {
        return equals-impl(this.data, other);
    }
    
    @IntrinsicConstEvaluation
    @PublishedApi
    public static short constructor-impl(final short data) {
        return data;
    }
    
    public final /* synthetic */ short unbox-impl() {
        return this.data;
    }
    
    public static final boolean equals-impl0(final short p1, final short p2) {
        return p1 == p2;
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004X\u0086T\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0086T\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n" }, d2 = { "Lkotlin/UShort$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UShort;", "S", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib" })
    public static final class Companion
    {
        private Companion() {
        }
    }
}
