// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm.internal;

import kotlin.Function;
import kotlin.SinceKotlin;

@SinceKotlin(version = "1.4")
public interface FunctionAdapter
{
    Function<?> getFunctionDelegate();
}
