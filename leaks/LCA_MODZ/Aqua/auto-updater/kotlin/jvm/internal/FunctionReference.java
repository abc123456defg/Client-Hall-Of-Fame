// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.SinceKotlin;
import kotlin.reflect.KFunction;

public class FunctionReference extends CallableReference implements FunctionBase, KFunction
{
    private final int arity;
    @SinceKotlin(version = "1.4")
    private final int flags;
    
    public FunctionReference(final int arity) {
        this(arity, FunctionReference.NO_RECEIVER, null, null, null, 0);
    }
    
    @SinceKotlin(version = "1.1")
    public FunctionReference(final int arity, final Object receiver) {
        this(arity, receiver, null, null, null, 0);
    }
    
    @SinceKotlin(version = "1.4")
    public FunctionReference(final int arity, final Object receiver, final Class owner, final String name, final String signature, final int flags) {
        super(receiver, owner, name, signature, (flags & 0x1) == 0x1);
        this.arity = arity;
        this.flags = flags >> 1;
    }
    
    @Override
    public int getArity() {
        return this.arity;
    }
    
    @SinceKotlin(version = "1.1")
    @Override
    protected KFunction getReflected() {
        return (KFunction)super.getReflected();
    }
    
    @SinceKotlin(version = "1.1")
    @Override
    protected KCallable computeReflected() {
        return Reflection.function(this);
    }
    
    @SinceKotlin(version = "1.1")
    @Override
    public boolean isInline() {
        return this.getReflected().isInline();
    }
    
    @SinceKotlin(version = "1.1")
    @Override
    public boolean isExternal() {
        return this.getReflected().isExternal();
    }
    
    @SinceKotlin(version = "1.1")
    @Override
    public boolean isOperator() {
        return this.getReflected().isOperator();
    }
    
    @SinceKotlin(version = "1.1")
    @Override
    public boolean isInfix() {
        return this.getReflected().isInfix();
    }
    
    @SinceKotlin(version = "1.1")
    @Override
    public boolean isSuspend() {
        return this.getReflected().isSuspend();
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            final FunctionReference other = (FunctionReference)obj;
            return this.getName().equals(other.getName()) && this.getSignature().equals(other.getSignature()) && this.flags == other.flags && this.arity == other.arity && Intrinsics.areEqual(this.getBoundReceiver(), other.getBoundReceiver()) && Intrinsics.areEqual(this.getOwner(), other.getOwner());
        }
        return obj instanceof KFunction && obj.equals(this.compute());
    }
    
    @Override
    public int hashCode() {
        return (((this.getOwner() == null) ? 0 : (this.getOwner().hashCode() * 31)) + this.getName().hashCode()) * 31 + this.getSignature().hashCode();
    }
    
    @Override
    public String toString() {
        final KCallable reflected = this.compute();
        if (reflected != this) {
            return reflected.toString();
        }
        return "<init>".equals(this.getName()) ? "constructor (Kotlin reflection is not available)" : ("function " + this.getName() + " (Kotlin reflection is not available)");
    }
}
