// 
// Decompiled by Procyon v0.5.36
// 

package kotlin;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.CollectionToArray;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.markers.KMappedMarker;
import java.util.Collection;

@JvmInline
@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00f8\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b\u00f8\u0001\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016\u00f8\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0086\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004H\u00d6\u0001¢\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u000fH\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&H\u0096\u0002\u00f8\u0001\u0000¢\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0086\u0002\u00f8\u0001\u0000¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020/H\u00d6\u0001¢\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\r\u0088\u0001\u0007\u0092\u0001\u00020\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u00063" }, d2 = { "Lkotlin/UIntArray;", "", "Lkotlin/UInt;", "size", "", "constructor-impl", "(I)[I", "storage", "", "([I)[I", "getSize-impl", "([I)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-WZ4Q5Ns", "([II)Z", "containsAll", "elements", "containsAll-impl", "([ILjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([ILjava/lang/Object;)Z", "get", "index", "get-pVg5ArA", "([II)I", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([I)Z", "iterator", "", "iterator-impl", "([I)Ljava/util/Iterator;", "set", "", "value", "set-VXSXFK8", "([III)V", "toString", "", "toString-impl", "([I)Ljava/lang/String;", "Iterator", "kotlin-stdlib" })
@SinceKotlin(version = "1.3")
@ExperimentalUnsignedTypes
public final class UIntArray implements Collection<UInt>, KMappedMarker
{
    @NotNull
    private final int[] storage = storage;
    
    @NotNull
    public static int[] constructor-impl(final int size) {
        return constructor-impl(new int[size]);
    }
    
    public static final int get-pVg5ArA(final int[] arg0, final int index) {
        return UInt.constructor-impl(arg0[index]);
    }
    
    public static final void set-VXSXFK8(final int[] arg0, final int index, final int value) {
        arg0[index] = value;
    }
    
    public static int getSize-impl(final int[] arg0) {
        return arg0.length;
    }
    
    public int getSize() {
        return getSize-impl(this.storage);
    }
    
    @NotNull
    public static java.util.Iterator<UInt> iterator-impl(final int[] arg0) {
        return new Iterator(arg0);
    }
    
    @NotNull
    @Override
    public java.util.Iterator<UInt> iterator() {
        return iterator-impl(this.storage);
    }
    
    public static boolean contains-WZ4Q5Ns(final int[] arg0, final int element) {
        return ArraysKt___ArraysKt.contains(arg0, element);
    }
    
    public boolean contains-WZ4Q5Ns(final int element) {
        return contains-WZ4Q5Ns(this.storage, element);
    }
    
    public static boolean containsAll-impl(final int[] arg0, @NotNull final Collection<UInt> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        final Iterable $this$all$iv = elements;
        final int $i$f$all = 0;
        boolean b;
        if (((Collection)$this$all$iv).isEmpty()) {
            b = true;
        }
        else {
            for (final Object it : $this$all$iv) {
                final Object element$iv = it;
                final int n = 0;
                if (!(it instanceof UInt) || !ArraysKt___ArraysKt.contains(arg0, ((UInt)it).unbox-impl())) {
                    b = false;
                    return b;
                }
            }
            b = true;
        }
        return b;
    }
    
    @Override
    public boolean containsAll(@NotNull final Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return containsAll-impl(this.storage, (Collection<UInt>)elements);
    }
    
    public static boolean isEmpty-impl(final int[] arg0) {
        return arg0.length == 0;
    }
    
    @Override
    public boolean isEmpty() {
        return isEmpty-impl(this.storage);
    }
    
    public static String toString-impl(final int[] arg0) {
        return "UIntArray(storage=" + Arrays.toString(arg0) + ')';
    }
    
    @Override
    public String toString() {
        return toString-impl(this.storage);
    }
    
    public static int hashCode-impl(final int[] arg0) {
        return Arrays.hashCode(arg0);
    }
    
    @Override
    public int hashCode() {
        return hashCode-impl(this.storage);
    }
    
    public static boolean equals-impl(final int[] arg0, final Object other) {
        return other instanceof UIntArray && Intrinsics.areEqual(arg0, ((UIntArray)other).unbox-impl());
    }
    
    @Override
    public boolean equals(final Object other) {
        return equals-impl(this.storage, other);
    }
    
    public boolean add-WZ4Q5Ns(final int element) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
    
    @Override
    public boolean addAll(final Collection<? extends UInt> elements) {
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
    public boolean removeAll(final Collection<?> elements) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
    
    @Override
    public boolean retainAll(final Collection<?> elements) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
    
    @PublishedApi
    @NotNull
    public static int[] constructor-impl(@NotNull final int[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }
    
    public final /* synthetic */ int[] unbox-impl() {
        return this.storage;
    }
    
    public static final boolean equals-impl0(final int[] p1, final int[] p2) {
        return Intrinsics.areEqual(p1, p2);
    }
    
    @Override
    public final /* bridge */ boolean contains(final Object element) {
        return element instanceof UInt && this.contains-WZ4Q5Ns(((UInt)element).unbox-impl());
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
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\u0016\u0010\n\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u00f8\u0001\u0001\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\r" }, d2 = { "Lkotlin/UIntArray$Iterator;", "", "Lkotlin/UInt;", "array", "", "([I)V", "index", "", "hasNext", "", "next", "next-pVg5ArA", "()I", "kotlin-stdlib" })
    private static final class Iterator implements java.util.Iterator<UInt>, KMappedMarker
    {
        @NotNull
        private final int[] array;
        private int index;
        
        public Iterator(@NotNull final int[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.array = array;
        }
        
        @Override
        public boolean hasNext() {
            return this.index < this.array.length;
        }
        
        public int next-pVg5ArA() {
            if (this.index < this.array.length) {
                return UInt.constructor-impl(this.array[this.index++]);
            }
            throw new NoSuchElementException(String.valueOf(this.index));
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }
}
