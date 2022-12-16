// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm.internal;

import kotlin.reflect.KProperty;
import kotlin.reflect.KCallable;
import kotlin.SinceKotlin;
import kotlin.reflect.KProperty2;

public abstract class PropertyReference2 extends PropertyReference implements KProperty2
{
    public PropertyReference2() {
    }
    
    @SinceKotlin(version = "1.4")
    public PropertyReference2(final Class owner, final String name, final String signature, final int flags) {
        super(PropertyReference2.NO_RECEIVER, owner, name, signature, flags);
    }
    
    @Override
    protected KCallable computeReflected() {
        return Reflection.property2(this);
    }
    
    @Override
    public Object invoke(final Object receiver1, final Object receiver2) {
        return this.get(receiver1, receiver2);
    }
    
    @Override
    public KProperty2.Getter getGetter() {
        return ((KProperty2)this.getReflected()).getGetter();
    }
    
    @SinceKotlin(version = "1.1")
    @Override
    public Object getDelegate(final Object receiver1, final Object receiver2) {
        return ((KProperty2)this.getReflected()).getDelegate(receiver1, receiver2);
    }
}
