// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.text;

import kotlin.jvm.functions.Function1;
import java.math.MathContext;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.jvm.JvmName;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Deprecated;
import kotlin.internal.InlineOnly;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000Z\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0005H\u0082\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\r\u0010\b\u001a\u00020\t*\u00020\u0003H\u0087\b\u001a\u0015\u0010\b\u001a\u00020\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u0003H\u0007\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\r\u0010\r\u001a\u00020\u000e*\u00020\u0003H\u0087\b\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u000e\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007\u001a\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\r\u0010\u0012\u001a\u00020\u0013*\u00020\u0003H\u0087\b\u001a\u0014\u0010\u0012\u001a\u00020\u0013*\u0004\u0018\u00010\u0003H\u0087\b¢\u0006\u0002\b\u0014\u001a\r\u0010\u0015\u001a\u00020\u0016*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0015\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0018*\u00020\u0003H\u0087\b\u001a\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0018*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u001a\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0003H\u0087\b\u001a\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001c*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u001e\u001a\r\u0010\u001f\u001a\u00020\u0010*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u001f\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\r\u0010 \u001a\u00020!*\u00020\u0003H\u0087\b\u001a\u0015\u0010 \u001a\u00020!*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\r\u0010\"\u001a\u00020#*\u00020\u0003H\u0087\b\u001a\u0015\u0010\"\u001a\u00020#*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010$\u001a\u00020\u0003*\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010$\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010$\u001a\u00020\u0003*\u00020!2\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010$\u001a\u00020\u0003*\u00020#2\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b¨\u0006%" }, d2 = { "screenFloatValue", "T", "str", "", "parse", "Lkotlin/Function1;", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toBigDecimal", "Ljava/math/BigDecimal;", "mathContext", "Ljava/math/MathContext;", "toBigDecimalOrNull", "toBigInteger", "Ljava/math/BigInteger;", "radix", "", "toBigIntegerOrNull", "toBoolean", "", "toBooleanNullable", "toByte", "", "toDouble", "", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "toFloat", "", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toInt", "toLong", "", "toShort", "", "toString", "kotlin-stdlib" }, xs = "kotlin/text/StringsKt")
class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt
{
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String toString(final byte $this$toString, final int radix) {
        final String string = Integer.toString($this$toString, CharsKt__CharJVMKt.checkRadix(CharsKt__CharJVMKt.checkRadix(radix)));
        Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
        return string;
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String toString(final short $this$toString, final int radix) {
        final String string = Integer.toString($this$toString, CharsKt__CharJVMKt.checkRadix(CharsKt__CharJVMKt.checkRadix(radix)));
        Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
        return string;
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String toString(final int $this$toString, final int radix) {
        final String string = Integer.toString($this$toString, CharsKt__CharJVMKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
        return string;
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String toString(final long $this$toString, final int radix) {
        final String string = Long.toString($this$toString, CharsKt__CharJVMKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
        return string;
    }
    
    @JvmName(name = "toBooleanNullable")
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final boolean toBooleanNullable(final String $this$toBoolean) {
        return Boolean.parseBoolean($this$toBoolean);
    }
    
    @InlineOnly
    private static final byte toByte(final String $this$toByte) {
        Intrinsics.checkNotNullParameter($this$toByte, "<this>");
        return Byte.parseByte($this$toByte);
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte toByte(final String $this$toByte, final int radix) {
        Intrinsics.checkNotNullParameter($this$toByte, "<this>");
        return Byte.parseByte($this$toByte, CharsKt__CharJVMKt.checkRadix(radix));
    }
    
    @InlineOnly
    private static final short toShort(final String $this$toShort) {
        Intrinsics.checkNotNullParameter($this$toShort, "<this>");
        return Short.parseShort($this$toShort);
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short toShort(final String $this$toShort, final int radix) {
        Intrinsics.checkNotNullParameter($this$toShort, "<this>");
        return Short.parseShort($this$toShort, CharsKt__CharJVMKt.checkRadix(radix));
    }
    
    @InlineOnly
    private static final int toInt(final String $this$toInt) {
        Intrinsics.checkNotNullParameter($this$toInt, "<this>");
        return Integer.parseInt($this$toInt);
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int toInt(final String $this$toInt, final int radix) {
        Intrinsics.checkNotNullParameter($this$toInt, "<this>");
        return Integer.parseInt($this$toInt, CharsKt__CharJVMKt.checkRadix(radix));
    }
    
    @InlineOnly
    private static final long toLong(final String $this$toLong) {
        Intrinsics.checkNotNullParameter($this$toLong, "<this>");
        return Long.parseLong($this$toLong);
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long toLong(final String $this$toLong, final int radix) {
        Intrinsics.checkNotNullParameter($this$toLong, "<this>");
        return Long.parseLong($this$toLong, CharsKt__CharJVMKt.checkRadix(radix));
    }
    
    @InlineOnly
    private static final float toFloat(final String $this$toFloat) {
        Intrinsics.checkNotNullParameter($this$toFloat, "<this>");
        return Float.parseFloat($this$toFloat);
    }
    
    @InlineOnly
    private static final double toDouble(final String $this$toDouble) {
        Intrinsics.checkNotNullParameter($this$toDouble, "<this>");
        return Double.parseDouble($this$toDouble);
    }
    
    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Float toFloatOrNull(@NotNull final String $this$toFloatOrNull) {
        Intrinsics.checkNotNullParameter($this$toFloatOrNull, "<this>");
        final int $i$f$screenFloatValue = 0;
        Float n2;
        try {
            Float value;
            if (ScreenFloatValueRegEx.value.matches($this$toFloatOrNull)) {
                final String p0 = $this$toFloatOrNull;
                final int n = 0;
                value = Float.parseFloat(p0);
            }
            else {
                value = null;
            }
            n2 = value;
        }
        catch (NumberFormatException e$iv) {
            n2 = null;
        }
        return n2;
    }
    
    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Double toDoubleOrNull(@NotNull final String $this$toDoubleOrNull) {
        Intrinsics.checkNotNullParameter($this$toDoubleOrNull, "<this>");
        final int $i$f$screenFloatValue = 0;
        Double n2;
        try {
            Double value;
            if (ScreenFloatValueRegEx.value.matches($this$toDoubleOrNull)) {
                final String p0 = $this$toDoubleOrNull;
                final int n = 0;
                value = Double.parseDouble(p0);
            }
            else {
                value = null;
            }
            n2 = value;
        }
        catch (NumberFormatException e$iv) {
            n2 = null;
        }
        return n2;
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger toBigInteger(final String $this$toBigInteger) {
        Intrinsics.checkNotNullParameter($this$toBigInteger, "<this>");
        return new BigInteger($this$toBigInteger);
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger toBigInteger(final String $this$toBigInteger, final int radix) {
        Intrinsics.checkNotNullParameter($this$toBigInteger, "<this>");
        return new BigInteger($this$toBigInteger, CharsKt__CharJVMKt.checkRadix(radix));
    }
    
    @SinceKotlin(version = "1.2")
    @Nullable
    public static final BigInteger toBigIntegerOrNull(@NotNull final String $this$toBigIntegerOrNull) {
        Intrinsics.checkNotNullParameter($this$toBigIntegerOrNull, "<this>");
        return toBigIntegerOrNull($this$toBigIntegerOrNull, 10);
    }
    
    @SinceKotlin(version = "1.2")
    @Nullable
    public static final BigInteger toBigIntegerOrNull(@NotNull final String $this$toBigIntegerOrNull, final int radix) {
        Intrinsics.checkNotNullParameter($this$toBigIntegerOrNull, "<this>");
        CharsKt__CharJVMKt.checkRadix(radix);
        final int length = $this$toBigIntegerOrNull.length();
        switch (length) {
            case 0: {
                return null;
            }
            case 1: {
                if (CharsKt__CharJVMKt.digitOf($this$toBigIntegerOrNull.charAt(0), radix) < 0) {
                    return null;
                }
                break;
            }
            default: {
                int index;
                for (int start = index = (($this$toBigIntegerOrNull.charAt(0) == '-') ? 1 : 0); index < length; ++index) {
                    if (CharsKt__CharJVMKt.digitOf($this$toBigIntegerOrNull.charAt(index), radix) < 0) {
                        return null;
                    }
                }
                break;
            }
        }
        return new BigInteger($this$toBigIntegerOrNull, CharsKt__CharJVMKt.checkRadix(radix));
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(final String $this$toBigDecimal) {
        Intrinsics.checkNotNullParameter($this$toBigDecimal, "<this>");
        return new BigDecimal($this$toBigDecimal);
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(final String $this$toBigDecimal, final MathContext mathContext) {
        Intrinsics.checkNotNullParameter($this$toBigDecimal, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal($this$toBigDecimal, mathContext);
    }
    
    @SinceKotlin(version = "1.2")
    @Nullable
    public static final BigDecimal toBigDecimalOrNull(@NotNull final String $this$toBigDecimalOrNull) {
        Intrinsics.checkNotNullParameter($this$toBigDecimalOrNull, "<this>");
        final int $i$f$screenFloatValue = 0;
        BigDecimal bigDecimal2;
        try {
            BigDecimal bigDecimal;
            if (ScreenFloatValueRegEx.value.matches($this$toBigDecimalOrNull)) {
                final String it = $this$toBigDecimalOrNull;
                final int n = 0;
                bigDecimal = new BigDecimal(it);
            }
            else {
                bigDecimal = null;
            }
            bigDecimal2 = bigDecimal;
        }
        catch (NumberFormatException e$iv) {
            bigDecimal2 = null;
        }
        return bigDecimal2;
    }
    
    @SinceKotlin(version = "1.2")
    @Nullable
    public static final BigDecimal toBigDecimalOrNull(@NotNull final String $this$toBigDecimalOrNull, @NotNull final MathContext mathContext) {
        Intrinsics.checkNotNullParameter($this$toBigDecimalOrNull, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        final int $i$f$screenFloatValue = 0;
        BigDecimal bigDecimal2;
        try {
            BigDecimal bigDecimal;
            if (ScreenFloatValueRegEx.value.matches($this$toBigDecimalOrNull)) {
                final String it = $this$toBigDecimalOrNull;
                final int n = 0;
                bigDecimal = new BigDecimal(it, mathContext);
            }
            else {
                bigDecimal = null;
            }
            bigDecimal2 = bigDecimal;
        }
        catch (NumberFormatException e$iv) {
            bigDecimal2 = null;
        }
        return bigDecimal2;
    }
    
    private static final <T> T screenFloatValue$StringsKt__StringNumberConversionsJVMKt(final String str, final Function1<? super String, ? extends T> parse) {
        final int $i$f$screenFloatValue = 0;
        T t;
        try {
            t = (ScreenFloatValueRegEx.value.matches(str) ? parse.invoke(str) : null);
        }
        catch (NumberFormatException e) {
            t = null;
        }
        return t;
    }
    
    public StringsKt__StringNumberConversionsJVMKt() {
    }
}
