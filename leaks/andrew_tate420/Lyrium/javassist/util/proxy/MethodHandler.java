// 
// Decompiled by Procyon v0.5.36
// 

package javassist.util.proxy;

import java.lang.reflect.Method;

public interface MethodHandler
{
    Object invoke(final Object self, final Method thisMethod, final Method proceed, final Object[] args) throws Throwable;
}
