// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.coroutines.intrinsics;

import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0081\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006" }, d2 = { "Lkotlin/coroutines/intrinsics/CoroutineSingletons;", "", "(Ljava/lang/String;I)V", "COROUTINE_SUSPENDED", "UNDECIDED", "RESUMED", "kotlin-stdlib" })
@SinceKotlin(version = "1.3")
@PublishedApi
public enum CoroutineSingletons
{
    COROUTINE_SUSPENDED, 
    UNDECIDED, 
    RESUMED;
    
    private static final /* synthetic */ CoroutineSingletons[] $values() {
        return new CoroutineSingletons[] { CoroutineSingletons.COROUTINE_SUSPENDED, CoroutineSingletons.UNDECIDED, CoroutineSingletons.RESUMED };
    }
    
    static {
        $VALUES = $values();
    }
}
