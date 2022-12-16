// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.SinceKotlin;
import java.io.Serializable;

@SinceKotlin(version = "1.7")
public class FunInterfaceConstructorReference extends FunctionReference implements Serializable
{
    private final Class funInterface;
    
    public FunInterfaceConstructorReference(final Class funInterface) {
        super(1);
        this.funInterface = funInterface;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FunInterfaceConstructorReference)) {
            return false;
        }
        final FunInterfaceConstructorReference other = (FunInterfaceConstructorReference)o;
        return this.funInterface.equals(other.funInterface);
    }
    
    @Override
    public int hashCode() {
        return this.funInterface.hashCode();
    }
    
    @Override
    public String toString() {
        return "fun interface " + this.funInterface.getName();
    }
    
    @Override
    protected KFunction getReflected() {
        throw new UnsupportedOperationException("Functional interface constructor does not support reflection");
    }
}
