// 
// Decompiled by Procyon v0.5.36
// 

package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.functions.Function1;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\u0002\u0010\u0007\u001a\u001f\u0010\b\u001a\u00020\u00012\n\u0010\t\u001a\u00020\u0001\"\u00020\u0006H\u0087\b\u00f8\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019¨\u0006\f" }, d2 = { "ULongArray", "Lkotlin/ULongArray;", "size", "", "init", "Lkotlin/Function1;", "Lkotlin/ULong;", "(ILkotlin/jvm/functions/Function1;)[J", "ulongArrayOf", "elements", "ulongArrayOf-QwZRm1k", "([J)[J", "kotlin-stdlib" })
public final class ULongArrayKt
{
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long[] ULongArray(final int size, final Function1<? super Integer, ULong> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        int i = 0;
        final long[] storage = new long[size];
        while (i < size) {
            final int j = i;
            storage[j] = init.invoke(j).unbox-impl();
            ++i;
        }
        return ULongArray.constructor-impl(storage);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long[] ulongArrayOf-QwZRm1k(final long... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements;
    }
}
