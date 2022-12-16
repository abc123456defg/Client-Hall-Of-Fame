// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections;

import kotlin.jvm.internal.CollectionToArray;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import java.util.RandomAccess;
import java.io.Serializable;
import java.util.List;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u00c0\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u00042\u00060\u0005j\u0002`\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002J\u0016\u0010\u0011\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\u0011\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000bH\u0096\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0096\u0002J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 H\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\b\u0010!\u001a\u00020\u0016H\u0002J\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bH\u0016J\b\u0010%\u001a\u00020&H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006'" }, d2 = { "Lkotlin/collections/EmptyList;", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "()V", "serialVersionUID", "", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "equals", "other", "", "get", "index", "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "readResolve", "subList", "fromIndex", "toIndex", "toString", "", "kotlin-stdlib" })
public final class EmptyList implements List, Serializable, RandomAccess, KMappedMarker
{
    @NotNull
    public static final EmptyList INSTANCE;
    private static final long serialVersionUID = -7390468764508069838L;
    
    private EmptyList() {
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        return other instanceof List && ((List)other).isEmpty();
    }
    
    @Override
    public int hashCode() {
        return 1;
    }
    
    @NotNull
    @Override
    public String toString() {
        return "[]";
    }
    
    public int getSize() {
        return 0;
    }
    
    @Override
    public boolean isEmpty() {
        return true;
    }
    
    public boolean contains(@NotNull final Void element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return false;
    }
    
    @Override
    public boolean containsAll(@NotNull final Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.isEmpty();
    }
    
    @NotNull
    @Override
    public Void get(final int index) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + index + '.');
    }
    
    public int indexOf(@NotNull final Void element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return -1;
    }
    
    public int lastIndexOf(@NotNull final Void element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return -1;
    }
    
    @NotNull
    @Override
    public Iterator iterator() {
        return EmptyIterator.INSTANCE;
    }
    
    @NotNull
    @Override
    public ListIterator listIterator() {
        return EmptyIterator.INSTANCE;
    }
    
    @NotNull
    @Override
    public ListIterator listIterator(final int index) {
        if (index != 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return EmptyIterator.INSTANCE;
    }
    
    @NotNull
    @Override
    public List subList(final int fromIndex, final int toIndex) {
        if (fromIndex == 0 && toIndex == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + fromIndex + ", toIndex: " + toIndex);
    }
    
    private final Object readResolve() {
        return EmptyList.INSTANCE;
    }
    
    public boolean add(final Void element) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
    
    public void add(final int index, final Void element) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
    
    @Override
    public boolean addAll(final int index, final Collection elements) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
    
    @Override
    public boolean addAll(final Collection elements) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
    
    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
    
    @Override
    public boolean remove(final Object element) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
    
    @Override
    public boolean removeAll(final Collection elements) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
    
    @Override
    public Void remove(final int index) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
    
    @Override
    public boolean retainAll(final Collection elements) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
    
    public Void set(final int index, final Void element) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
    
    @Override
    public final /* bridge */ int size() {
        return this.getSize();
    }
    
    @Override
    public final /* bridge */ boolean contains(final Object element) {
        return element instanceof Void && this.contains((Void)element);
    }
    
    @Override
    public final /* bridge */ int indexOf(final Object element) {
        if (!(element instanceof Void)) {
            return -1;
        }
        return this.indexOf((Void)element);
    }
    
    @Override
    public final /* bridge */ int lastIndexOf(final Object element) {
        if (!(element instanceof Void)) {
            return -1;
        }
        return this.lastIndexOf((Void)element);
    }
    
    @Override
    public <T> T[] toArray(final T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[])CollectionToArray.toArray(this, array);
    }
    
    @Override
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }
    
    static {
        INSTANCE = new EmptyList();
    }
}
