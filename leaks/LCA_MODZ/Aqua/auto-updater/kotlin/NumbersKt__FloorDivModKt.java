// 
// Decompiled by Procyon v0.5.36
// 

package kotlin;

import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.internal.InlineOnly;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b¨\u0006\t" }, d2 = { "floorDiv", "", "", "other", "", "", "mod", "", "", "kotlin-stdlib" }, xs = "kotlin/NumbersKt")
class NumbersKt__FloorDivModKt extends NumbersKt__BigIntegersKt
{
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int floorDiv(final byte $this$floorDiv, final byte other) {
        int n = $this$floorDiv / other;
        if (($this$floorDiv ^ other) < 0 && n * other != $this$floorDiv) {
            --n;
        }
        return n;
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final byte mod(final byte $this$mod, final byte other) {
        final int n = $this$mod % other;
        return (byte)(n + (other & ((n ^ other) & (n | -n)) >> 31));
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int floorDiv(final byte $this$floorDiv, final short other) {
        int n = $this$floorDiv / other;
        if (($this$floorDiv ^ other) < 0 && n * other != $this$floorDiv) {
            --n;
        }
        return n;
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final short mod(final byte $this$mod, final short other) {
        final int n = $this$mod % other;
        return (short)(n + (other & ((n ^ other) & (n | -n)) >> 31));
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int floorDiv(final byte $this$floorDiv, final int other) {
        int n = $this$floorDiv / other;
        if (($this$floorDiv ^ other) < 0 && n * other != $this$floorDiv) {
            --n;
        }
        return n;
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int mod(final byte $this$mod, final int other) {
        final int n = $this$mod % other;
        return n + (other & ((n ^ other) & (n | -n)) >> 31);
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long floorDiv(final byte $this$floorDiv, final long other) {
        final long n = $this$floorDiv;
        long n2 = n / other;
        if ((n ^ other) < 0L && n2 * other != n) {
            --n2;
        }
        return n2;
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long mod(final byte $this$mod, final long other) {
        final long n = $this$mod % other;
        return n + (other & ((n ^ other) & (n | -n)) >> 63);
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int floorDiv(final short $this$floorDiv, final byte other) {
        int n = $this$floorDiv / other;
        if (($this$floorDiv ^ other) < 0 && n * other != $this$floorDiv) {
            --n;
        }
        return n;
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final byte mod(final short $this$mod, final byte other) {
        final int n = $this$mod % other;
        return (byte)(n + (other & ((n ^ other) & (n | -n)) >> 31));
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int floorDiv(final short $this$floorDiv, final short other) {
        int n = $this$floorDiv / other;
        if (($this$floorDiv ^ other) < 0 && n * other != $this$floorDiv) {
            --n;
        }
        return n;
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final short mod(final short $this$mod, final short other) {
        final int n = $this$mod % other;
        return (short)(n + (other & ((n ^ other) & (n | -n)) >> 31));
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int floorDiv(final short $this$floorDiv, final int other) {
        int n = $this$floorDiv / other;
        if (($this$floorDiv ^ other) < 0 && n * other != $this$floorDiv) {
            --n;
        }
        return n;
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int mod(final short $this$mod, final int other) {
        final int n = $this$mod % other;
        return n + (other & ((n ^ other) & (n | -n)) >> 31);
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long floorDiv(final short $this$floorDiv, final long other) {
        final long n = $this$floorDiv;
        long n2 = n / other;
        if ((n ^ other) < 0L && n2 * other != n) {
            --n2;
        }
        return n2;
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long mod(final short $this$mod, final long other) {
        final long n = $this$mod % other;
        return n + (other & ((n ^ other) & (n | -n)) >> 63);
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int floorDiv(final int $this$floorDiv, final byte other) {
        int n = $this$floorDiv / other;
        if (($this$floorDiv ^ other) < 0 && n * other != $this$floorDiv) {
            --n;
        }
        return n;
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final byte mod(final int $this$mod, final byte other) {
        final int n = $this$mod % other;
        return (byte)(n + (other & ((n ^ other) & (n | -n)) >> 31));
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int floorDiv(final int $this$floorDiv, final short other) {
        int n = $this$floorDiv / other;
        if (($this$floorDiv ^ other) < 0 && n * other != $this$floorDiv) {
            --n;
        }
        return n;
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final short mod(final int $this$mod, final short other) {
        final int n = $this$mod % other;
        return (short)(n + (other & ((n ^ other) & (n | -n)) >> 31));
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int floorDiv(final int $this$floorDiv, final int other) {
        int q = $this$floorDiv / other;
        if (($this$floorDiv ^ other) < 0 && q * other != $this$floorDiv) {
            --q;
        }
        return q;
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int mod(final int $this$mod, final int other) {
        final int r = $this$mod % other;
        return r + (other & ((r ^ other) & (r | -r)) >> 31);
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long floorDiv(final int $this$floorDiv, final long other) {
        final long n = $this$floorDiv;
        long n2 = n / other;
        if ((n ^ other) < 0L && n2 * other != n) {
            --n2;
        }
        return n2;
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long mod(final int $this$mod, final long other) {
        final long n = $this$mod % other;
        return n + (other & ((n ^ other) & (n | -n)) >> 63);
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long floorDiv(final long $this$floorDiv, final byte other) {
        final long n = other;
        long n2 = $this$floorDiv / n;
        if (($this$floorDiv ^ n) < 0L && n2 * n != $this$floorDiv) {
            --n2;
        }
        return n2;
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final byte mod(final long $this$mod, final byte other) {
        final long n = other;
        final long n2 = $this$mod % n;
        return (byte)(n2 + (n & ((n2 ^ n) & (n2 | -n2)) >> 63));
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long floorDiv(final long $this$floorDiv, final short other) {
        final long n = other;
        long n2 = $this$floorDiv / n;
        if (($this$floorDiv ^ n) < 0L && n2 * n != $this$floorDiv) {
            --n2;
        }
        return n2;
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final short mod(final long $this$mod, final short other) {
        final long n = other;
        final long n2 = $this$mod % n;
        return (short)(n2 + (n & ((n2 ^ n) & (n2 | -n2)) >> 63));
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long floorDiv(final long $this$floorDiv, final int other) {
        final long n = other;
        long n2 = $this$floorDiv / n;
        if (($this$floorDiv ^ n) < 0L && n2 * n != $this$floorDiv) {
            --n2;
        }
        return n2;
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int mod(final long $this$mod, final int other) {
        final long n = other;
        final long n2 = $this$mod % n;
        return (int)(n2 + (n & ((n2 ^ n) & (n2 | -n2)) >> 63));
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long floorDiv(final long $this$floorDiv, final long other) {
        long q = $this$floorDiv / other;
        if (($this$floorDiv ^ other) < 0L && q * other != $this$floorDiv) {
            --q;
        }
        return q;
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long mod(final long $this$mod, final long other) {
        final long r = $this$mod % other;
        return r + (other & ((r ^ other) & (r | -r)) >> 63);
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final float mod(final float $this$mod, final float other) {
        final float r = $this$mod % other;
        return (r != 0.0f && Math.signum(r) != Math.signum(other)) ? (r + other) : r;
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final double mod(final float $this$mod, final double other) {
        final double d = $this$mod % other;
        return (d != 0.0 && Math.signum(d) != Math.signum(other)) ? (d + other) : d;
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final double mod(final double $this$mod, final float other) {
        final double d = other;
        final double d2 = $this$mod % d;
        return (d2 != 0.0 && Math.signum(d2) != Math.signum(d)) ? (d2 + d) : d2;
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final double mod(final double $this$mod, final double other) {
        final double r = $this$mod % other;
        return (r != 0.0 && Math.signum(r) != Math.signum(other)) ? (r + other) : r;
    }
    
    public NumbersKt__FloorDivModKt() {
    }
}
