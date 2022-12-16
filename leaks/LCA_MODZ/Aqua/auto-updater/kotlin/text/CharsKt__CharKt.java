// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.text;

import kotlin.ranges.CharRange;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.Nullable;
import kotlin.ExperimentalStdlibApi;
import kotlin.WasExperimental;
import kotlin.SinceKotlin;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000\u001e\n\u0000\n\u0002\u0010\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0001H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u00020\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a\n\u0010\f\u001a\u00020\t*\u00020\u0001\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000eH\u0087\n\u001a\f\u0010\u000f\u001a\u00020\u000e*\u00020\u0001H\u0007¨\u0006\u0010" }, d2 = { "digitToChar", "", "", "radix", "digitToInt", "digitToIntOrNull", "(C)Ljava/lang/Integer;", "(CI)Ljava/lang/Integer;", "equals", "", "other", "ignoreCase", "isSurrogate", "plus", "", "titlecase", "kotlin-stdlib" }, xs = "kotlin/text/CharsKt")
class CharsKt__CharKt extends CharsKt__CharJVMKt
{
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    public static final int digitToInt(final char $this$digitToInt) {
        final int it = CharsKt__CharJVMKt.digitOf($this$digitToInt, 10);
        final int n = 0;
        if (it < 0) {
            throw new IllegalArgumentException("Char " + $this$digitToInt + " is not a decimal digit");
        }
        return it;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    public static final int digitToInt(final char $this$digitToInt, final int radix) {
        final Integer digitToIntOrNull = digitToIntOrNull($this$digitToInt, radix);
        if (digitToIntOrNull != null) {
            return digitToIntOrNull;
        }
        throw new IllegalArgumentException("Char " + $this$digitToInt + " is not a digit in the given radix=" + radix);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @Nullable
    public static final Integer digitToIntOrNull(final char $this$digitToIntOrNull) {
        final Integer value = CharsKt__CharJVMKt.digitOf($this$digitToIntOrNull, 10);
        final int it = value.intValue();
        final int n = 0;
        return (it >= 0) ? value : null;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @Nullable
    public static final Integer digitToIntOrNull(final char $this$digitToIntOrNull, final int radix) {
        CharsKt__CharJVMKt.checkRadix(radix);
        final Integer value = CharsKt__CharJVMKt.digitOf($this$digitToIntOrNull, radix);
        final int it = value.intValue();
        final int n = 0;
        return (it >= 0) ? value : null;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    public static final char digitToChar(final int $this$digitToChar) {
        if (new IntRange(0, 9).contains($this$digitToChar)) {
            return (char)(48 + $this$digitToChar);
        }
        throw new IllegalArgumentException("Int " + $this$digitToChar + " is not a decimal digit");
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    public static final char digitToChar(final int $this$digitToChar, final int radix) {
        if (!new IntRange(2, 36).contains(radix)) {
            throw new IllegalArgumentException("Invalid radix: " + radix + ". Valid radix values are in range 2..36");
        }
        if ($this$digitToChar < 0 || $this$digitToChar >= radix) {
            throw new IllegalArgumentException("Digit " + $this$digitToChar + " does not represent a valid digit in radix " + radix);
        }
        return ($this$digitToChar < 10) ? ((char)(48 + $this$digitToChar)) : ((char)((char)(65 + $this$digitToChar) - '\n'));
    }
    
    @SinceKotlin(version = "1.5")
    @NotNull
    public static final String titlecase(final char $this$titlecase) {
        return _OneToManyTitlecaseMappingsKt.titlecaseImpl($this$titlecase);
    }
    
    @InlineOnly
    private static final String plus(final char $this$plus, final String other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return $this$plus + other;
    }
    
    public static final boolean equals(final char $this$equals, final char other, final boolean ignoreCase) {
        if ($this$equals == other) {
            return true;
        }
        if (!ignoreCase) {
            return false;
        }
        final char thisUpper = Character.toUpperCase($this$equals);
        final char otherUpper = Character.toUpperCase(other);
        return thisUpper == otherUpper || Character.toLowerCase(thisUpper) == Character.toLowerCase(otherUpper);
    }
    
    public static final boolean isSurrogate(final char $this$isSurrogate) {
        return new CharRange('\ud800', '\udfff').contains($this$isSurrogate);
    }
    
    public CharsKt__CharKt() {
    }
}
