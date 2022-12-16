// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm.internal;

import kotlin.reflect.KProperty;
import kotlin.reflect.KCallable;
import kotlin.SinceKotlin;
import kotlin.reflect.KProperty0;

public abstract class PropertyReference0 extends PropertyReference implements KProperty0
{
    public PropertyReference0() {
    }
    
    @SinceKotlin(version = "1.1")
    public PropertyReference0(final Object receiver) {
        super(receiver);
    }
    
    @SinceKotlin(version = "1.4")
    public PropertyReference0(final Object receiver, final Class owner, final String name, final String signature, final int flags) {
        super(receiver, owner, name, signature, flags);
    }
    
    @Override
    protected KCallable computeReflected() {
        return Reflection.property0(this);
    }
    
    @Override
    public Object invoke() {
        return this.get();
    }
    
    @Override
    public KProperty0.Getter getGetter() {
        return ((KProperty0)this.getReflected()).getGetter();
    }
    
    @SinceKotlin(version = "1.1")
    @Override
    public Object getDelegate() {
        return ((KProperty0)this.getReflected()).getDelegate();
    }
}
