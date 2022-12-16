// 
// Decompiled by Procyon v0.5.36
// 

package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.functions.Function0;
import kotlin.internal.InlineOnly;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\b\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007" }, d2 = { "assert", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "kotlin-stdlib" }, xs = "kotlin/PreconditionsKt")
class PreconditionsKt__AssertionsJVMKt
{
    @InlineOnly
    private static final void assert(final boolean value) {
        if (_Assertions.ENABLED && !value) {
            final int n = 0;
            throw new AssertionError((Object)"Assertion failed");
        }
    }
    
    @InlineOnly
    private static final void assert(final boolean value, final Function0<?> lazyMessage) {
        Intrinsics.checkNotNullParameter(lazyMessage, "lazyMessage");
        if (_Assertions.ENABLED && !value) {
            final Object message = lazyMessage.invoke();
            throw new AssertionError(message);
        }
    }
    
    public PreconditionsKt__AssertionsJVMKt() {
    }
}
