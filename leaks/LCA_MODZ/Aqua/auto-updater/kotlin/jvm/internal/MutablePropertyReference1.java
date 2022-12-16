// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm.internal;

import kotlin.reflect.KProperty;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KCallable;
import kotlin.SinceKotlin;
import kotlin.reflect.KMutableProperty1;

public abstract class MutablePropertyReference1 extends MutablePropertyReference implements KMutableProperty1
{
    public MutablePropertyReference1() {
    }
    
    @SinceKotlin(version = "1.1")
    public MutablePropertyReference1(final Object receiver) {
        super(receiver);
    }
    
    @SinceKotlin(version = "1.4")
    public MutablePropertyReference1(final Object receiver, final Class owner, final String name, final String signature, final int flags) {
        super(receiver, owner, name, signature, flags);
    }
    
    @Override
    protected KCallable computeReflected() {
        return Reflection.mutableProperty1(this);
    }
    
    @Override
    public Object invoke(final Object receiver) {
        return this.get(receiver);
    }
    
    @Override
    public KProperty1.Getter getGetter() {
        return ((KMutableProperty1)this.getReflected()).getGetter();
    }
    
    @Override
    public KMutableProperty1.Setter getSetter() {
        return ((KMutableProperty1)this.getReflected()).getSetter();
    }
    
    @SinceKotlin(version = "1.1")
    @Override
    public Object getDelegate(final Object receiver) {
        return ((KMutableProperty1)this.getReflected()).getDelegate(receiver);
    }
}
