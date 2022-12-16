// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

public class FunctionReferenceImpl extends FunctionReference
{
    public FunctionReferenceImpl(final int arity, final KDeclarationContainer owner, final String name, final String signature) {
        super(arity, FunctionReferenceImpl.NO_RECEIVER, ((ClassBasedDeclarationContainer)owner).getJClass(), name, signature, (owner instanceof KClass) ? 0 : 1);
    }
    
    @SinceKotlin(version = "1.4")
    public FunctionReferenceImpl(final int arity, final Class owner, final String name, final String signature, final int flags) {
        super(arity, FunctionReferenceImpl.NO_RECEIVER, owner, name, signature, flags);
    }
    
    @SinceKotlin(version = "1.4")
    public FunctionReferenceImpl(final int arity, final Object receiver, final Class owner, final String name, final String signature, final int flags) {
        super(arity, receiver, owner, name, signature, flags);
    }
}
