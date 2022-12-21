// 
// Decompiled by Procyon v0.5.36
// 

package javassist.compiler;

import javassist.compiler.ast.ASTList;
import javassist.bytecode.Bytecode;

public interface ProceedHandler
{
    void doit(final JvstCodeGen gen, final Bytecode b, final ASTList args) throws CompileError;
    
    void setReturnType(final JvstTypeChecker c, final ASTList args) throws CompileError;
}
