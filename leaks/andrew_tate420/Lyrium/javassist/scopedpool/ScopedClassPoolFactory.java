// 
// Decompiled by Procyon v0.5.36
// 

package javassist.scopedpool;

import javassist.ClassPool;

public interface ScopedClassPoolFactory
{
    ScopedClassPool create(final ClassLoader cl, final ClassPool src, final ScopedClassPoolRepository repository);
    
    ScopedClassPool create(final ClassPool src, final ScopedClassPoolRepository repository);
}
