// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005" }, d2 = { "Lkotlin/collections/CollectionSystemProperties;", "", "()V", "brittleContainsOptimizationEnabled", "", "kotlin-stdlib" })
public final class CollectionSystemProperties
{
    @NotNull
    public static final CollectionSystemProperties INSTANCE;
    @JvmField
    public static final boolean brittleContainsOptimizationEnabled;
    
    private CollectionSystemProperties() {
    }
    
    static {
        INSTANCE = new CollectionSystemProperties();
        final String property = System.getProperty("kotlin.collections.convert_arg_to_set_in_removeAll");
        brittleContainsOptimizationEnabled = (property != null && Boolean.parseBoolean(property));
    }
}
