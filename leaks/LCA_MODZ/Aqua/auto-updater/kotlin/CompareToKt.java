// 
// Decompiled by Procyon v0.5.36
// 

package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000f\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0087\f¢\u0006\u0002\u0010\u0005¨\u0006\u0006" }, d2 = { "compareTo", "", "T", "", "other", "(Ljava/lang/Comparable;Ljava/lang/Object;)I", "kotlin-stdlib" })
public final class CompareToKt
{
    @InlineOnly
    @SinceKotlin(version = "1.6")
    private static final <T> int compareTo(final Comparable<? super T> $this$compareTo, final T other) {
        Intrinsics.checkNotNullParameter($this$compareTo, "<this>");
        return $this$compareTo.compareTo(other);
    }
}
