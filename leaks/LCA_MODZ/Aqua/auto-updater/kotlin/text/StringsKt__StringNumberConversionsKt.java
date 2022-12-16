// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.text;

import org.jetbrains.annotations.Nullable;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\f\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015" }, d2 = { "numberFormatError", "", "input", "", "toByteOrNull", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib" }, xs = "kotlin/text/StringsKt")
class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt
{
    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Byte toByteOrNull(@NotNull final String $this$toByteOrNull) {
        Intrinsics.checkNotNullParameter($this$toByteOrNull, "<this>");
        return toByteOrNull($this$toByteOrNull, 10);
    }
    
    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Byte toByteOrNull(@NotNull final String $this$toByteOrNull, final int radix) {
        Intrinsics.checkNotNullParameter($this$toByteOrNull, "<this>");
        final Integer intOrNull = toIntOrNull($this$toByteOrNull, radix);
        if (intOrNull == null) {
            return null;
        }
        final int int1 = intOrNull;
        if (int1 < -128 || int1 > 127) {
            return null;
        }
        return (byte)int1;
    }
    
    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Short toShortOrNull(@NotNull final String $this$toShortOrNull) {
        Intrinsics.checkNotNullParameter($this$toShortOrNull, "<this>");
        return toShortOrNull($this$toShortOrNull, 10);
    }
    
    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Short toShortOrNull(@NotNull final String $this$toShortOrNull, final int radix) {
        Intrinsics.checkNotNullParameter($this$toShortOrNull, "<this>");
        final Integer intOrNull = toIntOrNull($this$toShortOrNull, radix);
        if (intOrNull == null) {
            return null;
        }
        final int int1 = intOrNull;
        if (int1 < -32768 || int1 > 32767) {
            return null;
        }
        return (short)int1;
    }
    
    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Integer toIntOrNull(@NotNull final String $this$toIntOrNull) {
        Intrinsics.checkNotNullParameter($this$toIntOrNull, "<this>");
        return toIntOrNull($this$toIntOrNull, 10);
    }
    
    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Integer toIntOrNull(@NotNull final String $this$toIntOrNull, final int radix) {
        Intrinsics.checkNotNullParameter($this$toIntOrNull, "<this>");
        CharsKt__CharJVMKt.checkRadix(radix);
        final int length = $this$toIntOrNull.length();
        if (length == 0) {
            return null;
        }
        int start = 0;
        boolean isNegative = false;
        int limit = 0;
        final char firstChar = $this$toIntOrNull.charAt(0);
        if (Intrinsics.compare(firstChar, 48) < 0) {
            if (length == 1) {
                return null;
            }
            start = 1;
            if (firstChar == '-') {
                isNegative = true;
                limit = Integer.MIN_VALUE;
            }
            else {
                if (firstChar != '+') {
                    return null;
                }
                isNegative = false;
                limit = -2147483647;
            }
        }
        else {
            start = 0;
            isNegative = false;
            limit = -2147483647;
        }
        int limitBeforeMul;
        final int limitForMaxRadix = limitBeforeMul = -59652323;
        int result = 0;
        for (int i = start; i < length; ++i) {
            final int digit = CharsKt__CharJVMKt.digitOf($this$toIntOrNull.charAt(i), radix);
            if (digit < 0) {
                return null;
            }
            if (result < limitBeforeMul) {
                if (limitBeforeMul != limitForMaxRadix) {
                    return null;
                }
                limitBeforeMul = limit / radix;
                if (result < limitBeforeMul) {
                    return null;
                }
            }
            result *= radix;
            if (result < limit + digit) {
                return null;
            }
            result -= digit;
        }
        return isNegative ? Integer.valueOf(result) : Integer.valueOf(-result);
    }
    
    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Long toLongOrNull(@NotNull final String $this$toLongOrNull) {
        Intrinsics.checkNotNullParameter($this$toLongOrNull, "<this>");
        return toLongOrNull($this$toLongOrNull, 10);
    }
    
    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Long toLongOrNull(@NotNull final String $this$toLongOrNull, final int radix) {
        Intrinsics.checkNotNullParameter($this$toLongOrNull, "<this>");
        CharsKt__CharJVMKt.checkRadix(radix);
        final int length = $this$toLongOrNull.length();
        if (length == 0) {
            return null;
        }
        int start = 0;
        boolean isNegative = false;
        long limit = 0L;
        final char firstChar = $this$toLongOrNull.charAt(0);
        if (Intrinsics.compare(firstChar, 48) < 0) {
            if (length == 1) {
                return null;
            }
            start = 1;
            if (firstChar == '-') {
                isNegative = true;
                limit = Long.MIN_VALUE;
            }
            else {
                if (firstChar != '+') {
                    return null;
                }
                isNegative = false;
                limit = -9223372036854775807L;
            }
        }
        else {
            start = 0;
            isNegative = false;
            limit = -9223372036854775807L;
        }
        long limitBeforeMul;
        final long limitForMaxRadix = limitBeforeMul = -256204778801521550L;
        long result = 0L;
        for (int i = start; i < length; ++i) {
            final int digit = CharsKt__CharJVMKt.digitOf($this$toLongOrNull.charAt(i), radix);
            if (digit < 0) {
                return null;
            }
            if (result < limitBeforeMul) {
                if (limitBeforeMul != limitForMaxRadix) {
                    return null;
                }
                limitBeforeMul = limit / radix;
                if (result < limitBeforeMul) {
                    return null;
                }
            }
            result *= radix;
            if (result < limit + digit) {
                return null;
            }
            result -= digit;
        }
        return isNegative ? Long.valueOf(result) : Long.valueOf(-result);
    }
    
    @NotNull
    public static final Void numberFormatError(@NotNull final String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + '\'');
    }
    
    public StringsKt__StringNumberConversionsKt() {
    }
}
