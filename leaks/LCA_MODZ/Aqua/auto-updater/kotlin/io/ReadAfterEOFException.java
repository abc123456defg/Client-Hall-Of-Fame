// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.io;

import org.jetbrains.annotations.Nullable;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006" }, d2 = { "Lkotlin/io/ReadAfterEOFException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "(Ljava/lang/String;)V", "kotlin-stdlib" })
public final class ReadAfterEOFException extends RuntimeException
{
    public ReadAfterEOFException(@Nullable final String message) {
        super(message);
    }
}
