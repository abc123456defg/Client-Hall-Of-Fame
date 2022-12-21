// 
// Decompiled by Procyon v0.5.36
// 

package javassist.util.proxy;

public interface ProxyObject extends Proxy
{
    void setHandler(final MethodHandler mi);
    
    MethodHandler getHandler();
}
