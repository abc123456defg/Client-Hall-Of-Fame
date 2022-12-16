// 
// Decompiled by Procyon v0.5.36
// 

package kotlin;

import java.math.MathContext;
import java.math.BigDecimal;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import java.math.BigInteger;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0087\f\u001a\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0087\f\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\u0010\u001a\u00020\u0011*\u00020\u0001H\u0087\b\u001a!\u0010\u0010\u001a\u00020\u0011*\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\rH\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0016H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f¨\u0006\u0019" }, d2 = { "and", "Ljava/math/BigInteger;", "other", "dec", "div", "inc", "inv", "minus", "or", "plus", "rem", "shl", "n", "", "shr", "times", "toBigDecimal", "Ljava/math/BigDecimal;", "scale", "mathContext", "Ljava/math/MathContext;", "toBigInteger", "", "unaryMinus", "xor", "kotlin-stdlib" }, xs = "kotlin/NumbersKt")
class NumbersKt__BigIntegersKt extends NumbersKt__BigDecimalsKt
{
    @InlineOnly
    private static final BigInteger plus(final BigInteger $this$plus, final BigInteger other) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        final BigInteger add = $this$plus.add(other);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
        return add;
    }
    
    @InlineOnly
    private static final BigInteger minus(final BigInteger $this$minus, final BigInteger other) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        final BigInteger subtract = $this$minus.subtract(other);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(other)");
        return subtract;
    }
    
    @InlineOnly
    private static final BigInteger times(final BigInteger $this$times, final BigInteger other) {
        Intrinsics.checkNotNullParameter($this$times, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        final BigInteger multiply = $this$times.multiply(other);
        Intrinsics.checkNotNullExpressionValue(multiply, "this.multiply(other)");
        return multiply;
    }
    
    @InlineOnly
    private static final BigInteger div(final BigInteger $this$div, final BigInteger other) {
        Intrinsics.checkNotNullParameter($this$div, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        final BigInteger divide = $this$div.divide(other);
        Intrinsics.checkNotNullExpressionValue(divide, "this.divide(other)");
        return divide;
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final BigInteger rem(final BigInteger $this$rem, final BigInteger other) {
        Intrinsics.checkNotNullParameter($this$rem, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        final BigInteger remainder = $this$rem.remainder(other);
        Intrinsics.checkNotNullExpressionValue(remainder, "this.remainder(other)");
        return remainder;
    }
    
    @InlineOnly
    private static final BigInteger unaryMinus(final BigInteger $this$unaryMinus) {
        Intrinsics.checkNotNullParameter($this$unaryMinus, "<this>");
        final BigInteger negate = $this$unaryMinus.negate();
        Intrinsics.checkNotNullExpressionValue(negate, "this.negate()");
        return negate;
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger inc(final BigInteger $this$inc) {
        Intrinsics.checkNotNullParameter($this$inc, "<this>");
        final BigInteger add = $this$inc.add(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(BigInteger.ONE)");
        return add;
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger dec(final BigInteger $this$dec) {
        Intrinsics.checkNotNullParameter($this$dec, "<this>");
        final BigInteger subtract = $this$dec.subtract(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(BigInteger.ONE)");
        return subtract;
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger inv(final BigInteger $this$inv) {
        Intrinsics.checkNotNullParameter($this$inv, "<this>");
        final BigInteger not = $this$inv.not();
        Intrinsics.checkNotNullExpressionValue(not, "this.not()");
        return not;
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger and(final BigInteger $this$and, final BigInteger other) {
        Intrinsics.checkNotNullParameter($this$and, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        final BigInteger and = $this$and.and(other);
        Intrinsics.checkNotNullExpressionValue(and, "this.and(other)");
        return and;
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger or(final BigInteger $this$or, final BigInteger other) {
        Intrinsics.checkNotNullParameter($this$or, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        final BigInteger or = $this$or.or(other);
        Intrinsics.checkNotNullExpressionValue(or, "this.or(other)");
        return or;
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger xor(final BigInteger $this$xor, final BigInteger other) {
        Intrinsics.checkNotNullParameter($this$xor, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        final BigInteger xor = $this$xor.xor(other);
        Intrinsics.checkNotNullExpressionValue(xor, "this.xor(other)");
        return xor;
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger shl(final BigInteger $this$shl, final int n) {
        Intrinsics.checkNotNullParameter($this$shl, "<this>");
        final BigInteger shiftLeft = $this$shl.shiftLeft(n);
        Intrinsics.checkNotNullExpressionValue(shiftLeft, "this.shiftLeft(n)");
        return shiftLeft;
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger shr(final BigInteger $this$shr, final int n) {
        Intrinsics.checkNotNullParameter($this$shr, "<this>");
        final BigInteger shiftRight = $this$shr.shiftRight(n);
        Intrinsics.checkNotNullExpressionValue(shiftRight, "this.shiftRight(n)");
        return shiftRight;
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger toBigInteger(final int $this$toBigInteger) {
        final BigInteger value = BigInteger.valueOf($this$toBigInteger);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this.toLong())");
        return value;
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger toBigInteger(final long $this$toBigInteger) {
        final BigInteger value = BigInteger.valueOf($this$toBigInteger);
        Intrinsics.checkNotNullExpressionValue(value, "valueOf(this)");
        return value;
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(final BigInteger $this$toBigDecimal) {
        Intrinsics.checkNotNullParameter($this$toBigDecimal, "<this>");
        return new BigDecimal($this$toBigDecimal);
    }
    
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(final BigInteger $this$toBigDecimal, final int scale, final MathContext mathContext) {
        Intrinsics.checkNotNullParameter($this$toBigDecimal, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal($this$toBigDecimal, scale, mathContext);
    }
    
    public NumbersKt__BigIntegersKt() {
    }
}
