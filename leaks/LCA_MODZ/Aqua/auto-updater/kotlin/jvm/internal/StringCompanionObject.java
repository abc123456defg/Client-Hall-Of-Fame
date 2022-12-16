// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm.internal;

import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003" }, d2 = { "Lkotlin/jvm/internal/StringCompanionObject;", "", "()V", "kotlin-stdlib" })
public final class StringCompanionObject
{
    @NotNull
    public static final StringCompanionObject INSTANCE;
    
    private StringCompanionObject() {
    }
    
    static {
        INSTANCE = new StringCompanionObject();
    }
}
