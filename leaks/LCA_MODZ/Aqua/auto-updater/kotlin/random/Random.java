// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.random;

import java.io.Serializable;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.SinceKotlin;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b'\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016¨\u0006\u0018" }, d2 = { "Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Default", "kotlin-stdlib" })
@SinceKotlin(version = "1.3")
public abstract class Random
{
    @NotNull
    public static final Default Default;
    @NotNull
    private static final Random defaultRandom;
    
    public abstract int nextBits(final int p0);
    
    public int nextInt() {
        return this.nextBits(32);
    }
    
    public int nextInt(final int until) {
        return this.nextInt(0, until);
    }
    
    public int nextInt(final int from, final int until) {
        RandomKt.checkRangeBounds(from, until);
        final int n = until - from;
        if (n > 0 || n == Integer.MIN_VALUE) {
            int nextBits;
            if ((n & -n) == n) {
                final int bitCount = RandomKt.fastLog2(n);
                nextBits = this.nextBits(bitCount);
            }
            else {
                int v = 0;
                int bits;
                do {
                    bits = this.nextInt() >>> 1;
                    v = bits % n;
                } while (bits - v + (n - 1) < 0);
                nextBits = v;
            }
            final int rnd = nextBits;
            return from + rnd;
        }
        int rnd;
        do {
            rnd = this.nextInt();
        } while (from > rnd || rnd >= until);
        return rnd;
    }
    
    public long nextLong() {
        return ((long)this.nextInt() << 32) + this.nextInt();
    }
    
    public long nextLong(final long until) {
        return this.nextLong(0L, until);
    }
    
    public long nextLong(final long from, final long until) {
        RandomKt.checkRangeBounds(from, until);
        final long n = until - from;
        if (n > 0L) {
            long rnd = 0L;
            if ((n & -n) == n) {
                final int nLow = (int)n;
                final int nHigh = (int)(n >>> 32);
                long n2;
                if (nLow != 0) {
                    final int bitCount = RandomKt.fastLog2(nLow);
                    n2 = ((long)this.nextBits(bitCount) & 0xFFFFFFFFL);
                }
                else if (nHigh == 1) {
                    n2 = ((long)this.nextInt() & 0xFFFFFFFFL);
                }
                else {
                    final int bitCount = RandomKt.fastLog2(nHigh);
                    n2 = ((long)this.nextBits(bitCount) << 32) + ((long)this.nextInt() & 0xFFFFFFFFL);
                }
                rnd = n2;
            }
            else {
                long v = 0L;
                long bits;
                do {
                    bits = this.nextLong() >>> 1;
                    v = bits % n;
                } while (bits - v + (n - 1L) < 0L);
                rnd = v;
            }
            return from + rnd;
        }
        long rnd;
        do {
            rnd = this.nextLong();
        } while (from > rnd || rnd >= until);
        return rnd;
    }
    
    public boolean nextBoolean() {
        return this.nextBits(1) != 0;
    }
    
    public double nextDouble() {
        return PlatformRandomKt.doubleFromParts(this.nextBits(26), this.nextBits(27));
    }
    
    public double nextDouble(final double until) {
        return this.nextDouble(0.0, until);
    }
    
    public double nextDouble(final double from, final double until) {
        RandomKt.checkRangeBounds(from, until);
        final double size = until - from;
        double n;
        if (Double.isInfinite(size) && (!Double.isInfinite(from) && !Double.isNaN(from)) && (!Double.isInfinite(until) && !Double.isNaN(until))) {
            final double r1 = this.nextDouble() * (until / 2 - from / 2);
            n = from + r1 + r1;
        }
        else {
            n = from + this.nextDouble() * size;
        }
        final double r2 = n;
        return (r2 >= until) ? Math.nextAfter(until, Double.NEGATIVE_INFINITY) : r2;
    }
    
    public float nextFloat() {
        return this.nextBits(24) / 1.6777216E7f;
    }
    
    @NotNull
    public byte[] nextBytes(@NotNull final byte[] array, final int fromIndex, final int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (!new IntRange(0, array.length).contains(fromIndex) || !new IntRange(0, array.length).contains(toIndex)) {
            final int n = 0;
            throw new IllegalArgumentException(("fromIndex (" + fromIndex + ") or toIndex (" + toIndex + ") are out of range: 0.." + array.length + '.').toString());
        }
        if (fromIndex > toIndex) {
            final int n2 = 0;
            throw new IllegalArgumentException(("fromIndex (" + fromIndex + ") must be not greater than toIndex (" + toIndex + ").").toString());
        }
        final int steps = (toIndex - fromIndex) / 4;
        int position = 0;
        position = fromIndex;
        for (int j = 0; j < steps; ++j) {
            final int it = j;
            final int n3 = 0;
            final int v = this.nextInt();
            array[position] = (byte)v;
            array[position + 1] = (byte)(v >>> 8);
            array[position + 2] = (byte)(v >>> 16);
            array[position + 3] = (byte)(v >>> 24);
            position += 4;
        }
        final int remainder = toIndex - position;
        final int vr = this.nextBits(remainder * 8);
        for (int i = 0; i < remainder; ++i) {
            array[position + i] = (byte)(vr >>> i * 8);
        }
        return array;
    }
    
    @NotNull
    public byte[] nextBytes(@NotNull final byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return this.nextBytes(array, 0, array.length);
    }
    
    @NotNull
    public byte[] nextBytes(final int size) {
        return this.nextBytes(new byte[size]);
    }
    
    public static final /* synthetic */ Random access$getDefaultRandom$cp() {
        return Random.defaultRandom;
    }
    
    static {
        Default = new Default(null);
        defaultRandom = PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d" }, d2 = { "Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "writeReplace", "", "Serialized", "kotlin-stdlib" })
    public static final class Default extends Random implements Serializable
    {
        private Default() {
        }
        
        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }
        
        @Override
        public int nextBits(final int bitCount) {
            return Random.access$getDefaultRandom$cp().nextBits(bitCount);
        }
        
        @Override
        public int nextInt() {
            return Random.access$getDefaultRandom$cp().nextInt();
        }
        
        @Override
        public int nextInt(final int until) {
            return Random.access$getDefaultRandom$cp().nextInt(until);
        }
        
        @Override
        public int nextInt(final int from, final int until) {
            return Random.access$getDefaultRandom$cp().nextInt(from, until);
        }
        
        @Override
        public long nextLong() {
            return Random.access$getDefaultRandom$cp().nextLong();
        }
        
        @Override
        public long nextLong(final long until) {
            return Random.access$getDefaultRandom$cp().nextLong(until);
        }
        
        @Override
        public long nextLong(final long from, final long until) {
            return Random.access$getDefaultRandom$cp().nextLong(from, until);
        }
        
        @Override
        public boolean nextBoolean() {
            return Random.access$getDefaultRandom$cp().nextBoolean();
        }
        
        @Override
        public double nextDouble() {
            return Random.access$getDefaultRandom$cp().nextDouble();
        }
        
        @Override
        public double nextDouble(final double until) {
            return Random.access$getDefaultRandom$cp().nextDouble(until);
        }
        
        @Override
        public double nextDouble(final double from, final double until) {
            return Random.access$getDefaultRandom$cp().nextDouble(from, until);
        }
        
        @Override
        public float nextFloat() {
            return Random.access$getDefaultRandom$cp().nextFloat();
        }
        
        @NotNull
        @Override
        public byte[] nextBytes(@NotNull final byte[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return Random.access$getDefaultRandom$cp().nextBytes(array);
        }
        
        @NotNull
        @Override
        public byte[] nextBytes(final int size) {
            return Random.access$getDefaultRandom$cp().nextBytes(size);
        }
        
        @NotNull
        @Override
        public byte[] nextBytes(@NotNull final byte[] array, final int fromIndex, final int toIndex) {
            Intrinsics.checkNotNullParameter(array, "array");
            return Random.access$getDefaultRandom$cp().nextBytes(array, fromIndex, toIndex);
        }
        
        @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u00c2\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b" }, d2 = { "Lkotlin/random/Random$Default$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "readResolve", "", "kotlin-stdlib" })
        private static final class Serialized implements Serializable
        {
            @NotNull
            public static final Serialized INSTANCE;
            private static final long serialVersionUID = 0L;
            
            private final Object readResolve() {
                return Random.Default;
            }
            
            static {
                INSTANCE = new Serialized();
            }
        }
    }
}
