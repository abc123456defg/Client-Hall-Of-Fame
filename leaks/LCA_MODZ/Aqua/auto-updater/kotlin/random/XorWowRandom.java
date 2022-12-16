// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.random;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;
import java.io.Serializable;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0000\u0018\u0000 \u00122\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u0012B\u0017\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007B7\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013" }, d2 = { "Lkotlin/random/XorWowRandom;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "seed1", "", "seed2", "(II)V", "x", "y", "z", "w", "v", "addend", "(IIIIII)V", "nextBits", "bitCount", "nextInt", "Companion", "kotlin-stdlib" })
public final class XorWowRandom extends Random implements Serializable
{
    @NotNull
    private static final Companion Companion;
    private int x;
    private int y;
    private int z;
    private int w;
    private int v;
    private int addend;
    @Deprecated
    private static final long serialVersionUID = 0L;
    
    public XorWowRandom(final int x, final int y, final int z, final int w, final int v, final int addend) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.v = v;
        this.addend = addend;
        if ((this.x | this.y | this.z | this.w | this.v) == 0x0) {
            final int n = 0;
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
        }
        for (int n2 = 64, i = 0; i < n2; ++i) {
            final int it = i;
            final int n3 = 0;
            this.nextInt();
        }
    }
    
    public XorWowRandom(final int seed1, final int seed2) {
        this(seed1, seed2, 0, 0, ~seed1, seed1 << 10 ^ seed2 >>> 4);
    }
    
    @Override
    public int nextInt() {
        int t = this.x;
        t ^= t >>> 2;
        this.x = this.y;
        this.y = this.z;
        this.z = this.w;
        final int v0 = this.v;
        this.w = v0;
        t = (t ^ t << 1 ^ v0 ^ v0 << 4);
        this.v = t;
        this.addend += 362437;
        return t + this.addend;
    }
    
    @Override
    public int nextBits(final int bitCount) {
        return RandomKt.takeUpperBits(this.nextInt(), bitCount);
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005" }, d2 = { "Lkotlin/random/XorWowRandom$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib" })
    private static final class Companion
    {
    }
}
