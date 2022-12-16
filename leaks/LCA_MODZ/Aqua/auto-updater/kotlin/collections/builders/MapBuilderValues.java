// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections.builders;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableCollection;
import java.util.Collection;
import kotlin.collections.AbstractMutableCollection;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0019\b\u0000\u0012\u0010\u0010\u0004\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0010J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0096\u0002J\u0015\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\u0016\u0010\u001b\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016J\u0016\u0010\u001c\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016R\u001b\u0010\u0004\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d" }, d2 = { "Lkotlin/collections/builders/MapBuilderValues;", "V", "", "Lkotlin/collections/AbstractMutableCollection;", "backing", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "getBacking", "()Lkotlin/collections/builders/MapBuilder;", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "contains", "isEmpty", "iterator", "", "remove", "removeAll", "retainAll", "kotlin-stdlib" })
public final class MapBuilderValues<V> extends AbstractMutableCollection<V> implements Collection<V>, KMutableCollection
{
    @NotNull
    private final MapBuilder<?, V> backing;
    
    public MapBuilderValues(@NotNull final MapBuilder<?, V> backing) {
        Intrinsics.checkNotNullParameter(backing, "backing");
        this.backing = backing;
    }
    
    @NotNull
    public final MapBuilder<?, V> getBacking() {
        return this.backing;
    }
    
    @Override
    public int getSize() {
        return this.backing.size();
    }
    
    @Override
    public boolean isEmpty() {
        return this.backing.isEmpty();
    }
    
    @Override
    public boolean contains(final Object element) {
        return this.backing.containsValue(element);
    }
    
    @Override
    public boolean add(final V element) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean addAll(@NotNull final Collection<? extends V> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void clear() {
        this.backing.clear();
    }
    
    @NotNull
    @Override
    public Iterator<V> iterator() {
        return this.backing.valuesIterator$kotlin_stdlib();
    }
    
    @Override
    public boolean remove(final Object element) {
        return this.backing.removeValue$kotlin_stdlib((V)element);
    }
    
    @Override
    public boolean removeAll(@NotNull final Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.removeAll(elements);
    }
    
    @Override
    public boolean retainAll(@NotNull final Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.retainAll(elements);
    }
}
