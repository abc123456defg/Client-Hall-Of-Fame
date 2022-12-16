// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.random;

import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\t\u0010\u0000\u001a\u00020\u0001H\u0081\b\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0007\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0007¨\u0006\n" }, d2 = { "defaultPlatformRandom", "Lkotlin/random/Random;", "doubleFromParts", "", "hi26", "", "low27", "asJavaRandom", "Ljava/util/Random;", "asKotlinRandom", "kotlin-stdlib" })
public final class PlatformRandomKt
{
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final java.util.Random asJavaRandom(@NotNull final Random $this$asJavaRandom) {
        Intrinsics.checkNotNullParameter($this$asJavaRandom, "<this>");
        final AbstractPlatformRandom abstractPlatformRandom = ($this$asJavaRandom instanceof AbstractPlatformRandom) ? ((AbstractPlatformRandom)$this$asJavaRandom) : null;
        java.util.Random impl;
        if (abstractPlatformRandom == null || (impl = abstractPlatformRandom.getImpl()) == null) {
            impl = new KotlinRandom($this$asJavaRandom);
        }
        return impl;
    }
    
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final Random asKotlinRandom(@NotNull final java.util.Random $this$asKotlinRandom) {
        Intrinsics.checkNotNullParameter($this$asKotlinRandom, "<this>");
        final KotlinRandom kotlinRandom = ($this$asKotlinRandom instanceof KotlinRandom) ? ((KotlinRandom)$this$asKotlinRandom) : null;
        Random impl;
        if (kotlinRandom == null || (impl = kotlinRandom.getImpl()) == null) {
            impl = new PlatformRandom($this$asKotlinRandom);
        }
        return impl;
    }
    
    @InlineOnly
    private static final Random defaultPlatformRandom() {
        return PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    }
    
    public static final double doubleFromParts(final int hi26, final int low27) {
        return (((long)hi26 << 27) + low27) / 9.007199254740992E15;
    }
}
