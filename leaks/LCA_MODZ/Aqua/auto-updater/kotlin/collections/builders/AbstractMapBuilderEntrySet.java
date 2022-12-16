// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections.builders;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
import java.util.Map;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b \u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0002*\u0004\b\u0001\u0010\u0003*\u0004\b\u0002\u0010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0002H&¨\u0006\f" }, d2 = { "Lkotlin/collections/builders/AbstractMapBuilderEntrySet;", "E", "", "K", "V", "Lkotlin/collections/AbstractMutableSet;", "()V", "contains", "", "element", "(Ljava/util/Map$Entry;)Z", "containsEntry", "kotlin-stdlib" })
public abstract class AbstractMapBuilderEntrySet<E extends Map.Entry<? extends K, ? extends V>, K, V> extends AbstractMutableSet<E>
{
    public final boolean contains(@NotNull final E element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.containsEntry(element);
    }
    
    public abstract boolean containsEntry(@NotNull final Map.Entry<? extends K, ? extends V> p0);
    
    @Override
    public final /* bridge */ boolean contains(final Object element) {
        return element instanceof Map.Entry && this.contains((E)element);
    }
    
    public /* bridge */ boolean remove(final Map.Entry<?, ?> element) {
        return super.remove(element);
    }
    
    @Override
    public final /* bridge */ boolean remove(final Object element) {
        return element instanceof Map.Entry && this.remove((Map.Entry<?, ?>)element);
    }
}
