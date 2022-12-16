// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.text;

import org.jetbrains.annotations.Nullable;
import kotlin.ULong;
import kotlin.UInt;
import kotlin.UShort;
import kotlin.UByte;
import kotlin.KotlinNothingValueException;
import kotlin.UnsignedKt;
import org.jetbrains.annotations.NotNull;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.WasExperimental;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.JvmName;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0002*\u00020\u0001H\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u001c\u0010\u0010\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007\u00f8\u0001\u0000\u001a\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u001a\u0014\u0010\u0014\u001a\u00020\u0007*\u00020\u0001H\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010\u0014\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u0001H\u0007\u00f8\u0001\u0000\u001a\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u001a\u0014\u0010\u0018\u001a\u00020\n*\u00020\u0001H\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u0018\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a\u0011\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u0001H\u0007\u00f8\u0001\u0000\u001a\u0019\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u001a\u0014\u0010\u001c\u001a\u00020\r*\u00020\u0001H\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a\u001c\u0010\u001c\u001a\u00020\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a\u0011\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u0001H\u0007\u00f8\u0001\u0000\u001a\u0019\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 " }, d2 = { "toString", "", "Lkotlin/UByte;", "radix", "", "toString-LxnNnR4", "(BI)Ljava/lang/String;", "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "toString-JSWoG40", "(JI)Ljava/lang/String;", "Lkotlin/UShort;", "toString-olVBNx4", "(SI)Ljava/lang/String;", "toUByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toUByteOrNull", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toUIntOrNull", "toULong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "toULongOrNull", "toUShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toUShortOrNull", "kotlin-stdlib" })
@JvmName(name = "UStringsKt")
public final class UStringsKt
{
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @NotNull
    public static final String toString-LxnNnR4(final byte $this$toString_u2dLxnNnR4, final int radix) {
        final String string = Integer.toString($this$toString_u2dLxnNnR4 & 0xFF, CharsKt__CharJVMKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
        return string;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @NotNull
    public static final String toString-olVBNx4(final short $this$toString_u2dolVBNx4, final int radix) {
        final String string = Integer.toString($this$toString_u2dolVBNx4 & 0xFFFF, CharsKt__CharJVMKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
        return string;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @NotNull
    public static final String toString-V7xB4Y4(final int $this$toString_u2dV7xB4Y4, final int radix) {
        final String string = Long.toString((long)$this$toString_u2dV7xB4Y4 & 0xFFFFFFFFL, CharsKt__CharJVMKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
        return string;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @NotNull
    public static final String toString-JSWoG40(final long $this$toString_u2dJSWoG40, final int radix) {
        return UnsignedKt.ulongToString($this$toString_u2dJSWoG40, CharsKt__CharJVMKt.checkRadix(radix));
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final byte toUByte(@NotNull final String $this$toUByte) {
        Intrinsics.checkNotNullParameter($this$toUByte, "<this>");
        final UByte uByteOrNull = toUByteOrNull($this$toUByte);
        if (uByteOrNull != null) {
            return uByteOrNull.unbox-impl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError($this$toUByte);
        throw new KotlinNothingValueException();
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final byte toUByte(@NotNull final String $this$toUByte, final int radix) {
        Intrinsics.checkNotNullParameter($this$toUByte, "<this>");
        final UByte uByteOrNull = toUByteOrNull($this$toUByte, radix);
        if (uByteOrNull != null) {
            return uByteOrNull.unbox-impl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError($this$toUByte);
        throw new KotlinNothingValueException();
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final short toUShort(@NotNull final String $this$toUShort) {
        Intrinsics.checkNotNullParameter($this$toUShort, "<this>");
        final UShort uShortOrNull = toUShortOrNull($this$toUShort);
        if (uShortOrNull != null) {
            return uShortOrNull.unbox-impl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError($this$toUShort);
        throw new KotlinNothingValueException();
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final short toUShort(@NotNull final String $this$toUShort, final int radix) {
        Intrinsics.checkNotNullParameter($this$toUShort, "<this>");
        final UShort uShortOrNull = toUShortOrNull($this$toUShort, radix);
        if (uShortOrNull != null) {
            return uShortOrNull.unbox-impl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError($this$toUShort);
        throw new KotlinNothingValueException();
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final int toUInt(@NotNull final String $this$toUInt) {
        Intrinsics.checkNotNullParameter($this$toUInt, "<this>");
        final UInt uIntOrNull = toUIntOrNull($this$toUInt);
        if (uIntOrNull != null) {
            return uIntOrNull.unbox-impl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError($this$toUInt);
        throw new KotlinNothingValueException();
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final int toUInt(@NotNull final String $this$toUInt, final int radix) {
        Intrinsics.checkNotNullParameter($this$toUInt, "<this>");
        final UInt uIntOrNull = toUIntOrNull($this$toUInt, radix);
        if (uIntOrNull != null) {
            return uIntOrNull.unbox-impl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError($this$toUInt);
        throw new KotlinNothingValueException();
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final long toULong(@NotNull final String $this$toULong) {
        Intrinsics.checkNotNullParameter($this$toULong, "<this>");
        final ULong uLongOrNull = toULongOrNull($this$toULong);
        if (uLongOrNull != null) {
            return uLongOrNull.unbox-impl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError($this$toULong);
        throw new KotlinNothingValueException();
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    public static final long toULong(@NotNull final String $this$toULong, final int radix) {
        Intrinsics.checkNotNullParameter($this$toULong, "<this>");
        final ULong uLongOrNull = toULongOrNull($this$toULong, radix);
        if (uLongOrNull != null) {
            return uLongOrNull.unbox-impl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError($this$toULong);
        throw new KotlinNothingValueException();
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @Nullable
    public static final UByte toUByteOrNull(@NotNull final String $this$toUByteOrNull) {
        Intrinsics.checkNotNullParameter($this$toUByteOrNull, "<this>");
        return toUByteOrNull($this$toUByteOrNull, 10);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @Nullable
    public static final UByte toUByteOrNull(@NotNull final String $this$toUByteOrNull, final int radix) {
        Intrinsics.checkNotNullParameter($this$toUByteOrNull, "<this>");
        final UInt uIntOrNull = toUIntOrNull($this$toUByteOrNull, radix);
        if (uIntOrNull == null) {
            return null;
        }
        final int int1 = uIntOrNull.unbox-impl();
        if (UnsignedKt.uintCompare(int1, UInt.constructor-impl(-1 & 0xFF)) > 0) {
            return null;
        }
        return UByte.box-impl(UByte.constructor-impl((byte)int1));
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @Nullable
    public static final UShort toUShortOrNull(@NotNull final String $this$toUShortOrNull) {
        Intrinsics.checkNotNullParameter($this$toUShortOrNull, "<this>");
        return toUShortOrNull($this$toUShortOrNull, 10);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @Nullable
    public static final UShort toUShortOrNull(@NotNull final String $this$toUShortOrNull, final int radix) {
        Intrinsics.checkNotNullParameter($this$toUShortOrNull, "<this>");
        final UInt uIntOrNull = toUIntOrNull($this$toUShortOrNull, radix);
        if (uIntOrNull == null) {
            return null;
        }
        final int int1 = uIntOrNull.unbox-impl();
        if (UnsignedKt.uintCompare(int1, UInt.constructor-impl(-1 & 0xFFFF)) > 0) {
            return null;
        }
        return UShort.box-impl(UShort.constructor-impl((short)int1));
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @Nullable
    public static final UInt toUIntOrNull(@NotNull final String $this$toUIntOrNull) {
        Intrinsics.checkNotNullParameter($this$toUIntOrNull, "<this>");
        return toUIntOrNull($this$toUIntOrNull, 10);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @Nullable
    public static final UInt toUIntOrNull(@NotNull final String $this$toUIntOrNull, final int radix) {
        Intrinsics.checkNotNullParameter($this$toUIntOrNull, "<this>");
        CharsKt__CharJVMKt.checkRadix(radix);
        final int length = $this$toUIntOrNull.length();
        if (length == 0) {
            return null;
        }
        final int limit = -1;
        int start = 0;
        final char firstChar = $this$toUIntOrNull.charAt(0);
        if (Intrinsics.compare(firstChar, 48) < 0) {
            if (length == 1 || firstChar != '+') {
                return null;
            }
            start = 1;
        }
        else {
            start = 0;
        }
        int limitBeforeMul;
        final int limitForMaxRadix = limitBeforeMul = 119304647;
        final int uradix = UInt.constructor-impl(radix);
        int result = 0;
        for (int i = start; i < length; ++i) {
            final int digit = CharsKt__CharJVMKt.digitOf($this$toUIntOrNull.charAt(i), radix);
            if (digit < 0) {
                return null;
            }
            if (UnsignedKt.uintCompare(result, limitBeforeMul) > 0) {
                if (limitBeforeMul != limitForMaxRadix) {
                    return null;
                }
                limitBeforeMul = UnsignedKt.uintDivide-J1ME1BU(limit, uradix);
                if (UnsignedKt.uintCompare(result, limitBeforeMul) > 0) {
                    return null;
                }
            }
            final int beforeAdding;
            result = (beforeAdding = UInt.constructor-impl(result * uradix));
            result = UInt.constructor-impl(result + UInt.constructor-impl(digit));
            if (UnsignedKt.uintCompare(result, beforeAdding) < 0) {
                return null;
            }
        }
        return UInt.box-impl(result);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @Nullable
    public static final ULong toULongOrNull(@NotNull final String $this$toULongOrNull) {
        Intrinsics.checkNotNullParameter($this$toULongOrNull, "<this>");
        return toULongOrNull($this$toULongOrNull, 10);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalUnsignedTypes.class })
    @Nullable
    public static final ULong toULongOrNull(@NotNull final String $this$toULongOrNull, final int radix) {
        Intrinsics.checkNotNullParameter($this$toULongOrNull, "<this>");
        CharsKt__CharJVMKt.checkRadix(radix);
        final int length = $this$toULongOrNull.length();
        if (length == 0) {
            return null;
        }
        final long limit = -1L;
        int start = 0;
        final char firstChar = $this$toULongOrNull.charAt(0);
        if (Intrinsics.compare(firstChar, 48) < 0) {
            if (length == 1 || firstChar != '+') {
                return null;
            }
            start = 1;
        }
        else {
            start = 0;
        }
        long limitBeforeMul;
        final long limitForMaxRadix = limitBeforeMul = 512409557603043100L;
        final long uradix = ULong.constructor-impl(radix);
        long result = 0L;
        for (int i = start; i < length; ++i) {
            final int digit = CharsKt__CharJVMKt.digitOf($this$toULongOrNull.charAt(i), radix);
            if (digit < 0) {
                return null;
            }
            if (UnsignedKt.ulongCompare(result, limitBeforeMul) > 0) {
                if (limitBeforeMul != limitForMaxRadix) {
                    return null;
                }
                limitBeforeMul = UnsignedKt.ulongDivide-eb3DHEI(limit, uradix);
                if (UnsignedKt.ulongCompare(result, limitBeforeMul) > 0) {
                    return null;
                }
            }
            final long beforeAdding;
            result = (beforeAdding = ULong.constructor-impl(result * uradix));
            result = ULong.constructor-impl(result + ULong.constructor-impl((long)UInt.constructor-impl(digit) & 0xFFFFFFFFL));
            if (UnsignedKt.ulongCompare(result, beforeAdding) < 0) {
                return null;
            }
        }
        return ULong.box-impl(result);
    }
}
