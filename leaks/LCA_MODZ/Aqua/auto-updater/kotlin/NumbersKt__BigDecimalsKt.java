// 
// Decompiled by Procyon v0.5.36
// 

package kotlin;

import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import java.math.BigDecimal;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\nH\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0087\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\rH\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u000b\u001a\u00020\fH\u0087\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u000eH\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0087\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u000fH\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u0001*\u00020\u0001H\u0087\n¨\u0006\u0011" }, d2 = { "dec", "Ljava/math/BigDecimal;", "div", "other", "inc", "minus", "plus", "rem", "times", "toBigDecimal", "", "mathContext", "Ljava/math/MathContext;", "", "", "", "unaryMinus", "kotlin-stdlib" }, xs = "kotlin/NumbersKt")
class NumbersKt__BigDecimalsKt
{
    @InlineOnly
    private static final BigDecimal plus(final BigDecimal $this$plus, final BigDecimal other) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        final BigDecimal add = $this$plus.add(other);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
        return add;
    }
    
    @InlineOnly
    private static final BigDecimal minus(final BigDecimal $this$minus, final BigDecimal other) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        final BigDecimal subtract = $this$minus.subtract(other);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(other)");
        return subtract;
    }
    
    @InlineOnly
    private static final BigDecimal times(final BigDecimal $this$times, final BigDecimal other) {
        Intrinsics.checkNotNullParameter($this$times, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        final BigDecimal multiply = $this$times.multiply(other);
        Intrinsics.checkNotNullExpressionValue(multiply, "this.multiply(other)");
        return multiply;
    }
    
    @InlineOnly
    private static final BigDecimal div(final BigDecimal $this$div, final BigDecimal other) {
        Intrinsics.checkNotNullParameter($this$div, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        final BigDecimal divide = $this$div.divide(other, RoundingMode.HALF_EVEN);
        Intrinsics.checkNotNullExpressionValue(divide, "this.divide(other, RoundingMode.HALF_EVEN)");
        return divide;
    }
    
    @InlineOnly
    private static final BigDecimal rem(final BigDecimal $this$rem, final BigDecimal other) {
        Intrinsics.checkNotNullParameter($this$rem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        final BigDecimal remainder = $this$rem.remainder(other);
        Intrinsics.checkNotNullExpressionValue(remainder, "this.remainder(other)");
        return remainder;
    }
    
    @InlineOnly
    private static final BigDecimal unaryMinus(final BigDecimal $this$unaryMinus) {
        Intrinsics.checkNotNullParameter($this$unaryMinus, "<this>");
        final BigDecimal negate = $this$unaryMinus.negate();
        Intrinsics.checkNotNullExpressionValue(negate, "this.negate()");
        return negate;
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal inc(final BigDecimal $this$inc) {
        Intrinsics.checkNotNullParameter($this$inc, "<this>");
        final BigDecimal add = $this$inc.add(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(BigDecimal.ONE)");
        return add;
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal dec(final BigDecimal $this$dec) {
        Intrinsics.checkNotNullParameter($this$dec, "<this>");
        final BigDecimal subtract = $this$dec.subtract(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(BigDecimal.ONE)");
        return subtract;
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(final int $this$toBigDecimal) {
        final BigDecimal value = BigDecimal.valueOf($this$toBigDecimal);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        return value;
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(final int $this$toBigDecimal, final MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal($this$toBigDecimal, mathContext);
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(final long $this$toBigDecimal) {
        final BigDecimal value = BigDecimal.valueOf($this$toBigDecimal);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this)");
        return value;
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(final long $this$toBigDecimal, final MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal($this$toBigDecimal, mathContext);
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(final float $this$toBigDecimal) {
        return new BigDecimal(String.valueOf($this$toBigDecimal));
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(final float $this$toBigDecimal, final MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(String.valueOf($this$toBigDecimal), mathContext);
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(final double $this$toBigDecimal) {
        return new BigDecimal(String.valueOf($this$toBigDecimal));
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(final double $this$toBigDecimal, final MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(String.valueOf($this$toBigDecimal), mathContext);
    }
    
    public NumbersKt__BigDecimalsKt() {
    }
}
