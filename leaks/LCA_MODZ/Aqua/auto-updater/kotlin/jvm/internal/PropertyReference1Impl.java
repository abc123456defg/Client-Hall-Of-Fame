// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

public class PropertyReference1Impl extends PropertyReference1
{
    public PropertyReference1Impl(final KDeclarationContainer owner, final String name, final String signature) {
        super(PropertyReference1Impl.NO_RECEIVER, ((ClassBasedDeclarationContainer)owner).getJClass(), name, signature, (owner instanceof KClass) ? 0 : 1);
    }
    
    @SinceKotlin(version = "1.4")
    public PropertyReference1Impl(final Class owner, final String name, final String signature, final int flags) {
        super(PropertyReference1Impl.NO_RECEIVER, owner, name, signature, flags);
    }
    
    @SinceKotlin(version = "1.4")
    public PropertyReference1Impl(final Object receiver, final Class owner, final String name, final String signature, final int flags) {
        super(receiver, owner, name, signature, flags);
    }
    
    @Override
    public Object get(final Object receiver) {
        return this.getGetter().call(receiver);
    }
}
