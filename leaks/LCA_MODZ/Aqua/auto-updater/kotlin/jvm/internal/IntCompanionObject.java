// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002¨\u0006\n" }, d2 = { "Lkotlin/jvm/internal/IntCompanionObject;", "", "()V", "MAX_VALUE", "", "MIN_VALUE", "SIZE_BITS", "getSIZE_BITS$annotations", "SIZE_BYTES", "getSIZE_BYTES$annotations", "kotlin-stdlib" })
public final class IntCompanionObject
{
    @NotNull
    public static final IntCompanionObject INSTANCE;
    public static final int MIN_VALUE = Integer.MIN_VALUE;
    public static final int MAX_VALUE = Integer.MAX_VALUE;
    public static final int SIZE_BYTES = 4;
    public static final int SIZE_BITS = 32;
    
    private IntCompanionObject() {
    }
    
    static {
        INSTANCE = new IntCompanionObject();
    }
}
