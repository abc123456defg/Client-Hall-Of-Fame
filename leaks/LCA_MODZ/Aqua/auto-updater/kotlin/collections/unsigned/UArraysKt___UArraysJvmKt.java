// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections.unsigned;

import java.math.BigInteger;
import kotlin.jvm.JvmName;
import kotlin.OverloadResolutionByLambdaReturnType;
import java.math.BigDecimal;
import java.util.Comparator;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import kotlin.jvm.functions.Function1;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ReplaceWith;
import kotlin.Deprecated;
import kotlin.UnsignedKt;
import kotlin.collections.AbstractList;
import kotlin.UShort;
import kotlin.UByte;
import kotlin.ULong;
import kotlin.UInt;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import kotlin.UShortArray;
import kotlin.UByteArray;
import kotlin.ULongArray;
import kotlin.internal.InlineOnly;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.UIntArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000h\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\n0\u0001*\u00020\u000bH\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u000fH\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001f\u0010\u001f\u001a\u00020\u0002*\u00020\u00032\u0006\u0010 \u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010\u001f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010 \u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010\u001f\u001a\u00020\n*\u00020\u000b2\u0006\u0010 \u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u001f\u0010\u001f\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010 \u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u0018\u0010)\u001a\u0004\u0018\u00010\u0002*\u00020\u0003H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u0018\u0010)\u001a\u0004\u0018\u00010\u0006*\u00020\u0007H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a\u0018\u0010)\u001a\u0004\u0018\u00010\n*\u00020\u000bH\u0007\u00f8\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a\u0018\u0010)\u001a\u0004\u0018\u00010\u000e*\u00020\u000fH\u0007\u00f8\u0001\u0000¢\u0006\u0004\b0\u00101\u001a@\u00102\u001a\u0004\u0018\u00010\u0002\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H306H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b7\u00108\u001a@\u00102\u001a\u0004\u0018\u00010\u0006\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H306H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a@\u00102\u001a\u0004\u0018\u00010\n\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H306H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a@\u00102\u001a\u0004\u0018\u00010\u000e\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H306H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a4\u0010?\u001a\u0004\u0018\u00010\u0002*\u00020\u00032\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00020Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`BH\u0007\u00f8\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a4\u0010?\u001a\u0004\u0018\u00010\u0006*\u00020\u00072\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00060Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0006`BH\u0007\u00f8\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a4\u0010?\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\n0Aj\n\u0012\u0006\b\u0000\u0012\u00020\n`BH\u0007\u00f8\u0001\u0000¢\u0006\u0004\bG\u0010H\u001a4\u0010?\u001a\u0004\u0018\u00010\u000e*\u00020\u000f2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000e0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000e`BH\u0007\u00f8\u0001\u0000¢\u0006\u0004\bI\u0010J\u001a\u0018\u0010K\u001a\u0004\u0018\u00010\u0002*\u00020\u0003H\u0007\u00f8\u0001\u0000¢\u0006\u0004\bL\u0010+\u001a\u0018\u0010K\u001a\u0004\u0018\u00010\u0006*\u00020\u0007H\u0007\u00f8\u0001\u0000¢\u0006\u0004\bM\u0010-\u001a\u0018\u0010K\u001a\u0004\u0018\u00010\n*\u00020\u000bH\u0007\u00f8\u0001\u0000¢\u0006\u0004\bN\u0010/\u001a\u0018\u0010K\u001a\u0004\u0018\u00010\u000e*\u00020\u000fH\u0007\u00f8\u0001\u0000¢\u0006\u0004\bO\u00101\u001a@\u0010P\u001a\u0004\u0018\u00010\u0002\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H306H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\bQ\u00108\u001a@\u0010P\u001a\u0004\u0018\u00010\u0006\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H306H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\bR\u0010:\u001a@\u0010P\u001a\u0004\u0018\u00010\n\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H306H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\bS\u0010<\u001a@\u0010P\u001a\u0004\u0018\u00010\u000e\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H306H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\bT\u0010>\u001a4\u0010U\u001a\u0004\u0018\u00010\u0002*\u00020\u00032\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00020Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`BH\u0007\u00f8\u0001\u0000¢\u0006\u0004\bV\u0010D\u001a4\u0010U\u001a\u0004\u0018\u00010\u0006*\u00020\u00072\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00060Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0006`BH\u0007\u00f8\u0001\u0000¢\u0006\u0004\bW\u0010F\u001a4\u0010U\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\n0Aj\n\u0012\u0006\b\u0000\u0012\u00020\n`BH\u0007\u00f8\u0001\u0000¢\u0006\u0004\bX\u0010H\u001a4\u0010U\u001a\u0004\u0018\u00010\u000e*\u00020\u000f2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000e0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000e`BH\u0007\u00f8\u0001\u0000¢\u0006\u0004\bY\u0010J\u001a.\u0010Z\u001a\u00020[*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020[06H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b\\\u0010]\u001a.\u0010Z\u001a\u00020^*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020^06H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b_\u0010`\u001a.\u0010Z\u001a\u00020[*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020[06H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b\\\u0010a\u001a.\u0010Z\u001a\u00020^*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020^06H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b_\u0010b\u001a.\u0010Z\u001a\u00020[*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020[06H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b\\\u0010c\u001a.\u0010Z\u001a\u00020^*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020^06H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b_\u0010d\u001a.\u0010Z\u001a\u00020[*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020[06H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b\\\u0010e\u001a.\u0010Z\u001a\u00020^*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020^06H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b_\u0010f\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006g" }, d2 = { "asList", "", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "asList-GBYM_sE", "([B)Ljava/util/List;", "Lkotlin/UInt;", "Lkotlin/UIntArray;", "asList--ajY-9A", "([I)Ljava/util/List;", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "asList-QwZRm1k", "([J)Ljava/util/List;", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "", "element", "fromIndex", "toIndex", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-EtDCXyQ", "([SSII)I", "elementAt", "index", "elementAt-PpDY95g", "([BI)B", "elementAt-qFRl0hI", "([II)I", "elementAt-r7IrZao", "([JI)J", "elementAt-nggk6HY", "([SI)S", "max", "max-GBYM_sE", "([B)Lkotlin/UByte;", "max--ajY-9A", "([I)Lkotlin/UInt;", "max-QwZRm1k", "([J)Lkotlin/ULong;", "max-rL5Bavg", "([S)Lkotlin/UShort;", "maxBy", "R", "", "selector", "Lkotlin/Function1;", "maxBy-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)Lkotlin/UByte;", "maxBy-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)Lkotlin/UInt;", "maxBy-MShoTSo", "([JLkotlin/jvm/functions/Function1;)Lkotlin/ULong;", "maxBy-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)Lkotlin/UShort;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "maxWith-XMRcp5o", "([BLjava/util/Comparator;)Lkotlin/UByte;", "maxWith-YmdZ_VM", "([ILjava/util/Comparator;)Lkotlin/UInt;", "maxWith-zrEWJaI", "([JLjava/util/Comparator;)Lkotlin/ULong;", "maxWith-eOHTfZs", "([SLjava/util/Comparator;)Lkotlin/UShort;", "min", "min-GBYM_sE", "min--ajY-9A", "min-QwZRm1k", "min-rL5Bavg", "minBy", "minBy-JOV_ifY", "minBy-jgv0xPQ", "minBy-MShoTSo", "minBy-xTcfx_M", "minWith", "minWith-XMRcp5o", "minWith-YmdZ_VM", "minWith-zrEWJaI", "minWith-eOHTfZs", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib" }, xs = "kotlin/collections/unsigned/UArraysKt", pn = "kotlin.collections")
class UArraysKt___UArraysJvmKt
{
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int elementAt-qFRl0hI(final int[] $this$elementAt_u2dqFRl0hI, final int index) {
        Intrinsics.checkNotNullParameter($this$elementAt_u2dqFRl0hI, "$this$elementAt");
        return UIntArray.get-pVg5ArA($this$elementAt_u2dqFRl0hI, index);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long elementAt-r7IrZao(final long[] $this$elementAt_u2dr7IrZao, final int index) {
        Intrinsics.checkNotNullParameter($this$elementAt_u2dr7IrZao, "$this$elementAt");
        return ULongArray.get-s-VKNKU($this$elementAt_u2dr7IrZao, index);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte elementAt-PpDY95g(final byte[] $this$elementAt_u2dPpDY95g, final int index) {
        Intrinsics.checkNotNullParameter($this$elementAt_u2dPpDY95g, "$this$elementAt");
        return UByteArray.get-w2LRezQ($this$elementAt_u2dPpDY95g, index);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short elementAt-nggk6HY(final short[] $this$elementAt_u2dnggk6HY, final int index) {
        Intrinsics.checkNotNullParameter($this$elementAt_u2dnggk6HY, "$this$elementAt");
        return UShortArray.get-Mh2AYeg($this$elementAt_u2dnggk6HY, index);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<UInt> asList--ajY-9A(@NotNull final int[] $this$asList_u2d_u2dajY_u2d9A) {
        Intrinsics.checkNotNullParameter($this$asList_u2d_u2dajY_u2d9A, "$this$asList");
        return (List<UInt>)new UArraysKt___UArraysJvmKt$asList.UArraysKt___UArraysJvmKt$asList$1($this$asList_u2d_u2dajY_u2d9A);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<ULong> asList-QwZRm1k(@NotNull final long[] $this$asList_u2dQwZRm1k) {
        Intrinsics.checkNotNullParameter($this$asList_u2dQwZRm1k, "$this$asList");
        return (List<ULong>)new UArraysKt___UArraysJvmKt$asList.UArraysKt___UArraysJvmKt$asList$2($this$asList_u2dQwZRm1k);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<UByte> asList-GBYM_sE(@NotNull final byte[] $this$asList_u2dGBYM_sE) {
        Intrinsics.checkNotNullParameter($this$asList_u2dGBYM_sE, "$this$asList");
        return (List<UByte>)new UArraysKt___UArraysJvmKt$asList.UArraysKt___UArraysJvmKt$asList$3($this$asList_u2dGBYM_sE);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final List<UShort> asList-rL5Bavg(@NotNull final short[] $this$asList_u2drL5Bavg) {
        Intrinsics.checkNotNullParameter($this$asList_u2drL5Bavg, "$this$asList");
        return (List<UShort>)new UArraysKt___UArraysJvmKt$asList.UArraysKt___UArraysJvmKt$asList$4($this$asList_u2drL5Bavg);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int binarySearch-2fe2U9s(@NotNull final int[] $this$binarySearch_u2d2fe2U9s, final int element, final int fromIndex, final int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch_u2d2fe2U9s, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, UIntArray.getSize-impl($this$binarySearch_u2d2fe2U9s));
        final int signedElement = element;
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            final int mid = low + high >>> 1;
            final int midVal = $this$binarySearch_u2d2fe2U9s[mid];
            final int cmp = UnsignedKt.uintCompare(midVal, signedElement);
            if (cmp < 0) {
                low = mid + 1;
            }
            else {
                if (cmp <= 0) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -(low + 1);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int binarySearch-K6DWlUc(@NotNull final long[] $this$binarySearch_u2dK6DWlUc, final long element, final int fromIndex, final int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch_u2dK6DWlUc, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, ULongArray.getSize-impl($this$binarySearch_u2dK6DWlUc));
        final long signedElement = element;
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            final int mid = low + high >>> 1;
            final long midVal = $this$binarySearch_u2dK6DWlUc[mid];
            final int cmp = UnsignedKt.ulongCompare(midVal, signedElement);
            if (cmp < 0) {
                low = mid + 1;
            }
            else {
                if (cmp <= 0) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -(low + 1);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int binarySearch-WpHrYlw(@NotNull final byte[] $this$binarySearch_u2dWpHrYlw, final byte element, final int fromIndex, final int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch_u2dWpHrYlw, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, UByteArray.getSize-impl($this$binarySearch_u2dWpHrYlw));
        final int signedElement = element & 0xFF;
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            final int mid = low + high >>> 1;
            final byte midVal = $this$binarySearch_u2dWpHrYlw[mid];
            final int cmp = UnsignedKt.uintCompare(midVal, signedElement);
            if (cmp < 0) {
                low = mid + 1;
            }
            else {
                if (cmp <= 0) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -(low + 1);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int binarySearch-EtDCXyQ(@NotNull final short[] $this$binarySearch_u2dEtDCXyQ, final short element, final int fromIndex, final int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch_u2dEtDCXyQ, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, UShortArray.getSize-impl($this$binarySearch_u2dEtDCXyQ));
        final int signedElement = element & 0xFFFF;
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            final int mid = low + high >>> 1;
            final short midVal = $this$binarySearch_u2dEtDCXyQ[mid];
            final int cmp = UnsignedKt.uintCompare(midVal, signedElement);
            if (cmp < 0) {
                low = mid + 1;
            }
            else {
                if (cmp <= 0) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -(low + 1);
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "sumOfBigDecimal")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final BigDecimal sumOfBigDecimal(final int[] $this$sumOf_u2djgv0xPQ, final Function1<? super UInt, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2djgv0xPQ, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final BigDecimal value = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        BigDecimal sum = value;
        for (int i = 0; i < UIntArray.getSize-impl($this$sumOf_u2djgv0xPQ); ++i) {
            final int element = UIntArray.get-pVg5ArA($this$sumOf_u2djgv0xPQ, i);
            final BigDecimal add = sum.add((BigDecimal)selector.invoke(UInt.box-impl(element)));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "sumOfBigDecimal")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final BigDecimal sumOfBigDecimal(final long[] $this$sumOf_u2dMShoTSo, final Function1<? super ULong, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dMShoTSo, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final BigDecimal value = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        BigDecimal sum = value;
        for (int i = 0; i < ULongArray.getSize-impl($this$sumOf_u2dMShoTSo); ++i) {
            final long element = ULongArray.get-s-VKNKU($this$sumOf_u2dMShoTSo, i);
            final BigDecimal add = sum.add((BigDecimal)selector.invoke(ULong.box-impl(element)));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "sumOfBigDecimal")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final BigDecimal sumOfBigDecimal(final byte[] $this$sumOf_u2dJOV_ifY, final Function1<? super UByte, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dJOV_ifY, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final BigDecimal value = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        BigDecimal sum = value;
        for (int i = 0; i < UByteArray.getSize-impl($this$sumOf_u2dJOV_ifY); ++i) {
            final byte element = UByteArray.get-w2LRezQ($this$sumOf_u2dJOV_ifY, i);
            final BigDecimal add = sum.add((BigDecimal)selector.invoke(UByte.box-impl(element)));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "sumOfBigDecimal")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final BigDecimal sumOfBigDecimal(final short[] $this$sumOf_u2dxTcfx_M, final Function1<? super UShort, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dxTcfx_M, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final BigDecimal value = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        BigDecimal sum = value;
        for (int i = 0; i < UShortArray.getSize-impl($this$sumOf_u2dxTcfx_M); ++i) {
            final short element = UShortArray.get-Mh2AYeg($this$sumOf_u2dxTcfx_M, i);
            final BigDecimal add = sum.add((BigDecimal)selector.invoke(UShort.box-impl(element)));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "sumOfBigInteger")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final BigInteger sumOfBigInteger(final int[] $this$sumOf_u2djgv0xPQ, final Function1<? super UInt, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2djgv0xPQ, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final BigInteger value = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        BigInteger sum = value;
        for (int i = 0; i < UIntArray.getSize-impl($this$sumOf_u2djgv0xPQ); ++i) {
            final int element = UIntArray.get-pVg5ArA($this$sumOf_u2djgv0xPQ, i);
            final BigInteger add = sum.add((BigInteger)selector.invoke(UInt.box-impl(element)));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "sumOfBigInteger")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final BigInteger sumOfBigInteger(final long[] $this$sumOf_u2dMShoTSo, final Function1<? super ULong, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dMShoTSo, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final BigInteger value = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        BigInteger sum = value;
        for (int i = 0; i < ULongArray.getSize-impl($this$sumOf_u2dMShoTSo); ++i) {
            final long element = ULongArray.get-s-VKNKU($this$sumOf_u2dMShoTSo, i);
            final BigInteger add = sum.add((BigInteger)selector.invoke(ULong.box-impl(element)));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "sumOfBigInteger")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final BigInteger sumOfBigInteger(final byte[] $this$sumOf_u2dJOV_ifY, final Function1<? super UByte, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dJOV_ifY, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final BigInteger value = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        BigInteger sum = value;
        for (int i = 0; i < UByteArray.getSize-impl($this$sumOf_u2dJOV_ifY); ++i) {
            final byte element = UByteArray.get-w2LRezQ($this$sumOf_u2dJOV_ifY, i);
            final BigInteger add = sum.add((BigInteger)selector.invoke(UByte.box-impl(element)));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "sumOfBigInteger")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final BigInteger sumOfBigInteger(final short[] $this$sumOf_u2dxTcfx_M, final Function1<? super UShort, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf_u2dxTcfx_M, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final BigInteger value = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        BigInteger sum = value;
        for (int i = 0; i < UShortArray.getSize-impl($this$sumOf_u2dxTcfx_M); ++i) {
            final short element = UShortArray.get-Mh2AYeg($this$sumOf_u2dxTcfx_M, i);
            final BigInteger add = sum.add((BigInteger)selector.invoke(UShort.box-impl(element)));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }
    
    public UArraysKt___UArraysJvmKt() {
    }
}
