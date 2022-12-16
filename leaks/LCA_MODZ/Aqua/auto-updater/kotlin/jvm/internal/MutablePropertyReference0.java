// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm.internal;

import kotlin.reflect.KProperty;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KCallable;
import kotlin.SinceKotlin;
import kotlin.reflect.KMutableProperty0;

public abstract class MutablePropertyReference0 extends MutablePropertyReference implements KMutableProperty0
{
    public MutablePropertyReference0() {
    }
    
    @SinceKotlin(version = "1.1")
    public MutablePropertyReference0(final Object receiver) {
        super(receiver);
    }
    
    @SinceKotlin(version = "1.4")
    public MutablePropertyReference0(final Object receiver, final Class owner, final String name, final String signature, final int flags) {
        super(receiver, owner, name, signature, flags);
    }
    
    @Override
    protected KCallable computeReflected() {
        return Reflection.mutableProperty0(this);
    }
    
    @Override
    public Object invoke() {
        return this.get();
    }
    
    @Override
    public KProperty0.Getter getGetter() {
        return ((KMutableProperty0)this.getReflected()).getGetter();
    }
    
    @Override
    public KMutableProperty0.Setter getSetter() {
        return ((KMutableProperty0)this.getReflected()).getSetter();
    }
    
    @SinceKotlin(version = "1.1")
    @Override
    public Object getDelegate() {
        return ((KMutableProperty0)this.getReflected()).getDelegate();
    }
}
