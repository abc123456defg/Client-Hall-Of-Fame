// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.reflect;

import org.jetbrains.annotations.NotNull;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import java.lang.reflect.Type;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bc\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004" }, d2 = { "Lkotlin/reflect/TypeImpl;", "Ljava/lang/reflect/Type;", "getTypeName", "", "kotlin-stdlib" })
@ExperimentalStdlibApi
interface TypeImpl extends Type
{
    @NotNull
    String getTypeName();
}
