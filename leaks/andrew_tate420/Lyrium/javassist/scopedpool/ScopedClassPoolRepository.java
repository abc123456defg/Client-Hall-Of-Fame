// 
// Decompiled by Procyon v0.5.36
// 

package javassist.scopedpool;

import java.util.Map;
import javassist.ClassPool;

public interface ScopedClassPoolRepository
{
    void setClassPoolFactory(final ScopedClassPoolFactory factory);
    
    ScopedClassPoolFactory getClassPoolFactory();
    
    boolean isPrune();
    
    void setPrune(final boolean prune);
    
    ScopedClassPool createScopedClassPool(final ClassLoader cl, final ClassPool src);
    
    ClassPool findClassPool(final ClassLoader cl);
    
    ClassPool registerClassLoader(final ClassLoader ucl);
    
    Map getRegisteredCLs();
    
    void clearUnregisteredClassLoaders();
    
    void unregisterClassLoader(final ClassLoader cl);
}
