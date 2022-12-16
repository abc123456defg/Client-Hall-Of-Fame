// 
// Decompiled by Procyon v0.5.36
// 

package kotlin;

import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.internal.InlineOnly;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\f\n\u0002\b\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0001H\u0087\b\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028\u00c6\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b" }, d2 = { "code", "", "", "getCode$annotations", "(C)V", "getCode", "(C)I", "Char", "kotlin-stdlib" })
public final class CharCodeKt
{
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final char Char(final int code) {
        if (code < 0 || code > 65535) {
            throw new IllegalArgumentException("Invalid Char code: " + code);
        }
        return (char)code;
    }
    
    private static final int getCode(final char $this$code) {
        return $this$code;
    }
}
