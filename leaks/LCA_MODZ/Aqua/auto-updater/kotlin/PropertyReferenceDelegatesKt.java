// 
// Decompiled by Procyon v0.5.36
// 

package kotlin;

import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KMutableProperty0;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty0;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u00004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0087\n¢\u0006\u0002\u0010\u0007\u001a>\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00010\t2\u0006\u0010\u0003\u001a\u0002H\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0087\n¢\u0006\u0002\u0010\n\u001a<\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000e\u001a\u0002H\u0001H\u0087\n¢\u0006\u0002\u0010\u000f\u001aF\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00010\u00102\u0006\u0010\u0003\u001a\u0002H\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000e\u001a\u0002H\u0001H\u0087\n¢\u0006\u0002\u0010\u0011¨\u0006\u0012" }, d2 = { "getValue", "V", "Lkotlin/reflect/KProperty0;", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Lkotlin/reflect/KProperty0;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "T", "Lkotlin/reflect/KProperty1;", "(Lkotlin/reflect/KProperty1;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "Lkotlin/reflect/KMutableProperty0;", "value", "(Lkotlin/reflect/KMutableProperty0;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "Lkotlin/reflect/KMutableProperty1;", "(Lkotlin/reflect/KMutableProperty1;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib" })
public final class PropertyReferenceDelegatesKt
{
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <V> V getValue(final KProperty0<? extends V> $this$getValue, final Object thisRef, final KProperty<?> property) {
        Intrinsics.checkNotNullParameter($this$getValue, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        return (V)$this$getValue.get();
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <V> void setValue(final KMutableProperty0<V> $this$setValue, final Object thisRef, final KProperty<?> property, final V value) {
        Intrinsics.checkNotNullParameter($this$setValue, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        $this$setValue.set(value);
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <T, V> V getValue(final KProperty1<T, ? extends V> $this$getValue, final T thisRef, final KProperty<?> property) {
        Intrinsics.checkNotNullParameter($this$getValue, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        return (V)$this$getValue.get(thisRef);
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <T, V> void setValue(final KMutableProperty1<T, V> $this$setValue, final T thisRef, final KProperty<?> property, final V value) {
        Intrinsics.checkNotNullParameter($this$setValue, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        $this$setValue.set(thisRef, value);
    }
}
