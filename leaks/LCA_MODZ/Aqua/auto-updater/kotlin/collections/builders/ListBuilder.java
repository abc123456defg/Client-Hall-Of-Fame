// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections.builders;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.collections.ArrayDeque;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.collections.AbstractList;
import java.io.NotSerializableException;
import java.util.Collection;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableList;
import java.io.Serializable;
import java.util.RandomAccess;
import java.util.List;
import kotlin.collections.AbstractMutableList;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0001VB\u0007\b\u0016¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bBM\b\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0002\u0010\u0014J\u0015\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001b\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010!\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J&\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010&\u001a\u00020\nH\u0002J\u001d\u0010'\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010 J\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0016J\u0014\u0010,\u001a\u00020\u00112\n\u0010-\u001a\u0006\u0012\u0002\b\u00030)H\u0002J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\nH\u0002J\u0010\u00100\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\nH\u0002J\u0013\u00101\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u000102H\u0096\u0002J\u0016\u00103\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\nH\u0096\u0002¢\u0006\u0002\u00104J\b\u00105\u001a\u00020\nH\u0016J\u0015\u00106\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00107J\u0018\u00108\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002J\b\u00109\u001a\u00020\u0011H\u0016J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;H\u0096\u0002J\u0015\u0010<\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00107J\u000e\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000>H\u0016J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000>2\u0006\u0010\u001f\u001a\u00020\nH\u0016J\u0015\u0010?\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0016\u0010@\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0015\u0010A\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\nH\u0016¢\u0006\u0002\u00104J\u0015\u0010B\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\nH\u0002¢\u0006\u0002\u00104J\u0018\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\nH\u0002J\u0016\u0010F\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J.\u0010G\u001a\u00020\n2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010H\u001a\u00020\u0011H\u0002J\u001e\u0010I\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010JJ\u001e\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\nH\u0016J\u0015\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\rH\u0016¢\u0006\u0002\u0010OJ'\u0010N\u001a\b\u0012\u0004\u0012\u0002HP0\r\"\u0004\b\u0001\u0010P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HP0\rH\u0016¢\u0006\u0002\u0010RJ\b\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u000202H\u0002R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006W" }, d2 = { "Lkotlin/collections/builders/ListBuilder;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "initialCapacity", "", "(I)V", "array", "", "offset", "length", "isReadOnly", "", "backing", "root", "([Ljava/lang/Object;IIZLkotlin/collections/builders/ListBuilder;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "isEffectivelyReadOnly", "()Z", "size", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "addAllInternal", "i", "n", "addAtInternal", "build", "", "checkIsMutable", "clear", "contentEquals", "other", "ensureCapacity", "minCapacity", "ensureExtraCapacity", "equals", "", "get", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "insertAtInternal", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", "T", "destination", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "writeReplace", "Itr", "kotlin-stdlib" })
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList
{
    @NotNull
    private E[] array;
    private int offset;
    private int length;
    private boolean isReadOnly;
    @Nullable
    private final ListBuilder<E> backing;
    @Nullable
    private final ListBuilder<E> root;
    
    private ListBuilder(final E[] array, final int offset, final int length, final boolean isReadOnly, final ListBuilder<E> backing, final ListBuilder<E> root) {
        this.array = array;
        this.offset = offset;
        this.length = length;
        this.isReadOnly = isReadOnly;
        this.backing = backing;
        this.root = root;
    }
    
    public ListBuilder() {
        this(10);
    }
    
    public ListBuilder(final int initialCapacity) {
        this(ListBuilderKt.arrayOfUninitializedElements(initialCapacity), 0, 0, false, null, null);
    }
    
    @NotNull
    public final List<E> build() {
        if (this.backing != null) {
            throw new IllegalStateException();
        }
        this.checkIsMutable();
        this.isReadOnly = true;
        return this;
    }
    
    private final Object writeReplace() {
        if (this.isEffectivelyReadOnly()) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }
    
    @Override
    public int getSize() {
        return this.length;
    }
    
    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }
    
    @Override
    public E get(final int index) {
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
        return this.array[this.offset + index];
    }
    
    @Override
    public E set(final int index, final E element) {
        this.checkIsMutable();
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
        final Object old = this.array[this.offset + index];
        this.array[this.offset + index] = element;
        return (E)old;
    }
    
    @Override
    public int indexOf(final Object element) {
        for (int i = 0; i < this.length; ++i) {
            if (Intrinsics.areEqual(this.array[this.offset + i], element)) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public int lastIndexOf(final Object element) {
        for (int i = this.length - 1; i >= 0; --i) {
            if (Intrinsics.areEqual(this.array[this.offset + i], element)) {
                return i;
            }
        }
        return -1;
    }
    
    @NotNull
    @Override
    public Iterator<E> iterator() {
        return new Itr<E>(this, 0);
    }
    
    @NotNull
    @Override
    public ListIterator<E> listIterator() {
        return new Itr<E>(this, 0);
    }
    
    @NotNull
    @Override
    public ListIterator<E> listIterator(final int index) {
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
        return new Itr<E>(this, index);
    }
    
    @Override
    public boolean add(final E element) {
        this.checkIsMutable();
        this.addAtInternal(this.offset + this.length, element);
        return true;
    }
    
    @Override
    public void add(final int index, final E element) {
        this.checkIsMutable();
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
        this.addAtInternal(this.offset + index, element);
    }
    
    @Override
    public boolean addAll(@NotNull final Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.checkIsMutable();
        final int n = elements.size();
        this.addAllInternal(this.offset + this.length, elements, n);
        return n > 0;
    }
    
    @Override
    public boolean addAll(final int index, @NotNull final Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.checkIsMutable();
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
        final int n = elements.size();
        this.addAllInternal(this.offset + index, elements, n);
        return n > 0;
    }
    
    @Override
    public void clear() {
        this.checkIsMutable();
        this.removeRangeInternal(this.offset, this.length);
    }
    
    @Override
    public E removeAt(final int index) {
        this.checkIsMutable();
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
        return this.removeAtInternal(this.offset + index);
    }
    
    @Override
    public boolean remove(final Object element) {
        this.checkIsMutable();
        final int i = this.indexOf(element);
        if (i >= 0) {
            this.remove(i);
        }
        return i >= 0;
    }
    
    @Override
    public boolean removeAll(@NotNull final Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.checkIsMutable();
        return this.retainOrRemoveAllInternal(this.offset, this.length, (Collection<? extends E>)elements, false) > 0;
    }
    
    @Override
    public boolean retainAll(@NotNull final Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.checkIsMutable();
        return this.retainOrRemoveAllInternal(this.offset, this.length, (Collection<? extends E>)elements, true) > 0;
    }
    
    @NotNull
    @Override
    public List<E> subList(final int fromIndex, final int toIndex) {
        kotlin.collections.AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, this.length);
        final E[] array = this.array;
        final int offset = this.offset + fromIndex;
        final int length = toIndex - fromIndex;
        final boolean isReadOnly = this.isReadOnly;
        ListBuilder<E> root;
        if ((root = this.root) == null) {
            root = this;
        }
        return (List<E>)new ListBuilder<Object>(array, offset, length, isReadOnly, (ListBuilder<Object>)this, (ListBuilder<Object>)root);
    }
    
    @NotNull
    @Override
    public <T> T[] toArray(@NotNull final T[] destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (destination.length < this.length) {
            final Object[] copyOfRange = Arrays.copyOfRange(this.array, this.offset, this.offset + this.length, (Class<? extends T[]>)destination.getClass());
            Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(array, offse\u2026h, destination.javaClass)");
            return (T[])copyOfRange;
        }
        final E[] array = this.array;
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.builders.ListBuilder.toArray>");
        ArraysKt___ArraysJvmKt.copyInto(array, destination, 0, this.offset, this.offset + this.length);
        if (destination.length > this.length) {
            destination[this.length] = null;
        }
        return destination;
    }
    
    @NotNull
    @Override
    public Object[] toArray() {
        final E[] copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(this.array, this.offset, this.offset + this.length);
        Intrinsics.checkNotNull(copyOfRange, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return copyOfRange;
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        return other == this || (other instanceof List && this.contentEquals((List<?>)other));
    }
    
    @Override
    public int hashCode() {
        return ListBuilderKt.access$subarrayContentHashCode(this.array, this.offset, this.length);
    }
    
    @NotNull
    @Override
    public String toString() {
        return ListBuilderKt.access$subarrayContentToString(this.array, this.offset, this.length);
    }
    
    private final void ensureCapacity(final int minCapacity) {
        if (this.backing != null) {
            throw new IllegalStateException();
        }
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        if (minCapacity > this.array.length) {
            final int newSize = ArrayDeque.Companion.newCapacity$kotlin_stdlib(this.array.length, minCapacity);
            this.array = ListBuilderKt.copyOfUninitializedElements(this.array, newSize);
        }
    }
    
    private final void checkIsMutable() {
        if (this.isEffectivelyReadOnly()) {
            throw new UnsupportedOperationException();
        }
    }
    
    private final boolean isEffectivelyReadOnly() {
        return this.isReadOnly || (this.root != null && this.root.isReadOnly);
    }
    
    private final void ensureExtraCapacity(final int n) {
        this.ensureCapacity(this.length + n);
    }
    
    private final boolean contentEquals(final List<?> other) {
        return ListBuilderKt.access$subarrayContentEquals(this.array, this.offset, this.length, other);
    }
    
    private final void insertAtInternal(final int i, final int n) {
        this.ensureExtraCapacity(n);
        ArraysKt___ArraysJvmKt.copyInto(this.array, this.array, i + n, i, this.offset + this.length);
        this.length += n;
    }
    
    private final void addAtInternal(final int i, final E element) {
        if (this.backing != null) {
            this.backing.addAtInternal(i, element);
            this.array = this.backing.array;
            ++this.length;
        }
        else {
            this.insertAtInternal(i, 1);
            this.array[i] = element;
        }
    }
    
    private final void addAllInternal(final int i, final Collection<? extends E> elements, final int n) {
        if (this.backing != null) {
            this.backing.addAllInternal(i, elements, n);
            this.array = this.backing.array;
            this.length += n;
        }
        else {
            this.insertAtInternal(i, n);
            int j = 0;
            final Iterator it = elements.iterator();
            while (j < n) {
                this.array[i + j] = it.next();
                ++j;
            }
        }
    }
    
    private final E removeAtInternal(final int i) {
        if (this.backing != null) {
            final Object old = this.backing.removeAtInternal(i);
            --this.length;
            return (E)old;
        }
        final Object old = this.array[i];
        ArraysKt___ArraysJvmKt.copyInto(this.array, this.array, i, i + 1, this.offset + this.length);
        ListBuilderKt.resetAt(this.array, this.offset + this.length - 1);
        --this.length;
        return (E)old;
    }
    
    private final void removeRangeInternal(final int rangeOffset, final int rangeLength) {
        if (this.backing != null) {
            this.backing.removeRangeInternal(rangeOffset, rangeLength);
        }
        else {
            ArraysKt___ArraysJvmKt.copyInto(this.array, this.array, rangeOffset, rangeOffset + rangeLength, this.length);
            ListBuilderKt.resetRange(this.array, this.length - rangeLength, this.length);
        }
        this.length -= rangeLength;
    }
    
    private final int retainOrRemoveAllInternal(final int rangeOffset, final int rangeLength, final Collection<? extends E> elements, final boolean retain) {
        if (this.backing != null) {
            final int removed = this.backing.retainOrRemoveAllInternal(rangeOffset, rangeLength, elements, retain);
            this.length -= removed;
            return removed;
        }
        int i = 0;
        int j = 0;
        while (i < rangeLength) {
            if (elements.contains(this.array[rangeOffset + i]) == retain) {
                this.array[rangeOffset + j++] = this.array[rangeOffset + i++];
            }
            else {
                ++i;
            }
        }
        final int removed2 = rangeLength - j;
        ArraysKt___ArraysJvmKt.copyInto(this.array, this.array, rangeOffset + j, rangeOffset + rangeLength, this.length);
        ListBuilderKt.resetRange(this.array, this.length - removed2, this.length);
        this.length -= removed2;
        return removed2;
    }
    
    public static final /* synthetic */ int access$getLength$p(final ListBuilder $this) {
        return $this.length;
    }
    
    public static final /* synthetic */ Object[] access$getArray$p(final ListBuilder $this) {
        return $this.array;
    }
    
    public static final /* synthetic */ int access$getOffset$p(final ListBuilder $this) {
        return $this.offset;
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\r\u0010\u0013\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017" }, d2 = { "Lkotlin/collections/builders/ListBuilder$Itr;", "E", "", "list", "Lkotlin/collections/builders/ListBuilder;", "index", "", "(Lkotlin/collections/builders/ListBuilder;I)V", "lastIndex", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib" })
    private static final class Itr<E> implements ListIterator<E>, KMutableListIterator
    {
        @NotNull
        private final ListBuilder<E> list;
        private int index;
        private int lastIndex;
        
        public Itr(@NotNull final ListBuilder<E> list, final int index) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
            this.index = index;
            this.lastIndex = -1;
        }
        
        @Override
        public boolean hasPrevious() {
            return this.index > 0;
        }
        
        @Override
        public boolean hasNext() {
            return this.index < ListBuilder.access$getLength$p((ListBuilder<Object>)this.list);
        }
        
        @Override
        public int previousIndex() {
            return this.index - 1;
        }
        
        @Override
        public int nextIndex() {
            return this.index;
        }
        
        @Override
        public E previous() {
            if (this.index <= 0) {
                throw new NoSuchElementException();
            }
            --this.index;
            this.lastIndex = this.index;
            return (E)ListBuilder.access$getArray$p((ListBuilder<Object>)this.list)[ListBuilder.access$getOffset$p((ListBuilder<Object>)this.list) + this.lastIndex];
        }
        
        @Override
        public E next() {
            if (this.index >= ListBuilder.access$getLength$p((ListBuilder<Object>)this.list)) {
                throw new NoSuchElementException();
            }
            this.lastIndex = this.index++;
            return (E)ListBuilder.access$getArray$p((ListBuilder<Object>)this.list)[ListBuilder.access$getOffset$p((ListBuilder<Object>)this.list) + this.lastIndex];
        }
        
        @Override
        public void set(final E element) {
            if (this.lastIndex == -1) {
                final int n = 0;
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            }
            this.list.set(this.lastIndex, element);
        }
        
        @Override
        public void add(final E element) {
            this.list.add(this.index++, element);
            this.lastIndex = -1;
        }
        
        @Override
        public void remove() {
            if (this.lastIndex == -1) {
                final int n = 0;
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            }
            this.list.remove(this.lastIndex);
            this.index = this.lastIndex;
            this.lastIndex = -1;
        }
    }
}
