// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import java.util.Map;
import kotlin.jvm.JvmName;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000.\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aK\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u0002H\u0002*\u0015\u0012\u0006\b\u0000\u0012\u00020\u0004\u0012\t\u0012\u0007H\u0002¢\u0006\u0002\b\u00050\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0087\n¢\u0006\u0002\u0010\n\u001aO\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u0002H\u0002*\u0017\u0012\u0006\b\u0000\u0012\u00020\u0004\u0012\u000b\b\u0001\u0012\u0007H\u0002¢\u0006\u0002\b\u00050\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0087\n¢\u0006\u0004\b\f\u0010\n\u001aF\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0006\b\u0000\u0012\u00020\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u000f\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\u0010¨\u0006\u0011" }, d2 = { "getValue", "V1", "V", "", "", "Lkotlin/internal/Exact;", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "", "getVar", "setValue", "", "value", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib" })
@JvmName(name = "MapAccessorsKt")
public final class MapAccessorsKt
{
    @InlineOnly
    private static final <V, V1 extends V> V1 getValue(final Map<? super String, ? extends V> $this$getValue, final Object thisRef, final KProperty<?> property) {
        Intrinsics.checkNotNullParameter($this$getValue, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        return MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable((Map<String, ? extends V1>)$this$getValue, property.getName());
    }
    
    @JvmName(name = "getVar")
    @InlineOnly
    private static final <V, V1 extends V> V1 getVar(final Map<? super String, ? extends V> $this$getValue, final Object thisRef, final KProperty<?> property) {
        Intrinsics.checkNotNullParameter($this$getValue, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        return MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable((Map<String, ? extends V1>)$this$getValue, property.getName());
    }
    
    @InlineOnly
    private static final <V> void setValue(final Map<? super String, ? super V> $this$setValue, final Object thisRef, final KProperty<?> property, final V value) {
        Intrinsics.checkNotNullParameter($this$setValue, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        $this$setValue.put(property.getName(), value);
    }
}
