// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.coroutines.cancellation;

import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0087\b*\u001a\b\u0007\u0010\u0000\"\u00020\u00012\u00020\u0001B\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¨\u0006\n" }, d2 = { "CancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlin/coroutines/cancellation/CancellationException;", "message", "", "cause", "", "Lkotlin/SinceKotlin;", "version", "1.4", "kotlin-stdlib" })
public final class CancellationExceptionKt
{
    @InlineOnly
    @SinceKotlin(version = "1.4")
    private static final CancellationException CancellationException(final String message, final Throwable cause) {
        final CancellationException it = new CancellationException(message);
        final int n = 0;
        it.initCause(cause);
        return it;
    }
    
    @InlineOnly
    @SinceKotlin(version = "1.4")
    private static final CancellationException CancellationException(final Throwable cause) {
        final CancellationException it = new CancellationException((cause != null) ? cause.toString() : null);
        final int n = 0;
        it.initCause(cause);
        return it;
    }
}
