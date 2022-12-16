// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

public class MutablePropertyReference0Impl extends MutablePropertyReference0
{
    public MutablePropertyReference0Impl(final KDeclarationContainer owner, final String name, final String signature) {
        super(MutablePropertyReference0Impl.NO_RECEIVER, ((ClassBasedDeclarationContainer)owner).getJClass(), name, signature, (owner instanceof KClass) ? 0 : 1);
    }
    
    @SinceKotlin(version = "1.4")
    public MutablePropertyReference0Impl(final Class owner, final String name, final String signature, final int flags) {
        super(MutablePropertyReference0Impl.NO_RECEIVER, owner, name, signature, flags);
    }
    
    @SinceKotlin(version = "1.4")
    public MutablePropertyReference0Impl(final Object receiver, final Class owner, final String name, final String signature, final int flags) {
        super(receiver, owner, name, signature, flags);
    }
    
    @Override
    public Object get() {
        return this.getGetter().call(new Object[0]);
    }
    
    @Override
    public void set(final Object value) {
        this.getSetter().call(value);
    }
}
