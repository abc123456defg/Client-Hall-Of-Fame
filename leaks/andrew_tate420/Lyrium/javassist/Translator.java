// 
// Decompiled by Procyon v0.5.36
// 

package javassist;

public interface Translator
{
    void start(final ClassPool pool) throws NotFoundException, CannotCompileException;
    
    void onLoad(final ClassPool pool, final String classname) throws NotFoundException, CannotCompileException;
}
