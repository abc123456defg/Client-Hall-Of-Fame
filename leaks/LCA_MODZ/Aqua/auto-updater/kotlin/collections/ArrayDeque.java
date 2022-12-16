// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function1;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import java.util.NoSuchElementException;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import kotlin.ExperimentalStdlibApi;
import kotlin.WasExperimental;
import kotlin.SinceKotlin;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u0000 P*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001PB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u0015\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0016\u0010\u001a\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0013\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\b\u0010\u001e\u001a\u00020\u0017H\u0016J\u0016\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0016J\u001e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004H\u0002J\u001d\u0010'\u001a\u00020\u00142\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140)H\u0082\bJ\u000b\u0010*\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010,\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0016\u0010-\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u00100\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u0016\u00102\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0004H\u0083\b¢\u0006\u0002\u0010.J\u0011\u0010!\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0083\bJM\u00103\u001a\u00020\u00172>\u00104\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u000e\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u001705H\u0000¢\u0006\u0002\b8J\b\u00109\u001a\u00020\u0014H\u0016J\u000b\u0010:\u001a\u00028\u0000¢\u0006\u0002\u0010+J\u0015\u0010;\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\r\u0010<\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010>\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u0010?\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0016\u0010@\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0015\u0010A\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010.J\u000b\u0010B\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010C\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u000b\u0010D\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010E\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0016\u0010F\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u001e\u0010G\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010HJ\u0017\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0000¢\u0006\u0004\bJ\u0010KJ)\u0010I\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0000¢\u0006\u0004\bJ\u0010NJ\u0015\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0016¢\u0006\u0002\u0010KJ'\u0010O\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0016¢\u0006\u0002\u0010NR\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006Q" }, d2 = { "Lkotlin/collections/ArrayDeque;", "E", "Lkotlin/collections/AbstractMutableList;", "initialCapacity", "", "(I)V", "()V", "elements", "", "(Ljava/util/Collection;)V", "elementData", "", "", "[Ljava/lang/Object;", "head", "<set-?>", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "addFirst", "(Ljava/lang/Object;)V", "addLast", "clear", "contains", "copyCollectionElements", "internalIndex", "copyElements", "newCapacity", "decremented", "ensureCapacity", "minCapacity", "filterInPlace", "predicate", "Lkotlin/Function1;", "first", "()Ljava/lang/Object;", "firstOrNull", "get", "(I)Ljava/lang/Object;", "incremented", "indexOf", "(Ljava/lang/Object;)I", "internalGet", "internalStructure", "structure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "internalStructure$kotlin_stdlib", "isEmpty", "last", "lastIndexOf", "lastOrNull", "negativeMod", "positiveMod", "remove", "removeAll", "removeAt", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "testToArray", "testToArray$kotlin_stdlib", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toArray", "Companion", "kotlin-stdlib" })
@SinceKotlin(version = "1.4")
@WasExperimental(markerClass = { ExperimentalStdlibApi.class })
public final class ArrayDeque<E> extends AbstractMutableList<E>
{
    @NotNull
    public static final Companion Companion;
    private int head;
    @NotNull
    private Object[] elementData;
    private int size;
    @NotNull
    private static final Object[] emptyElementData;
    private static final int maxArraySize = 2147483639;
    private static final int defaultMinCapacity = 10;
    
    @Override
    public int getSize() {
        return this.size;
    }
    
    public ArrayDeque(final int initialCapacity) {
        Object[] emptyElementData;
        if (initialCapacity == 0) {
            emptyElementData = ArrayDeque.emptyElementData;
        }
        else {
            if (initialCapacity <= 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
            }
            emptyElementData = new Object[initialCapacity];
        }
        this.elementData = emptyElementData;
    }
    
    public ArrayDeque() {
        this.elementData = ArrayDeque.emptyElementData;
    }
    
    public ArrayDeque(@NotNull final Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        final Collection $this$toTypedArray$iv = elements;
        final int $i$f$toTypedArray = 0;
        final Collection thisCollection$iv = $this$toTypedArray$iv;
        final Object[] array = thisCollection$iv.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.elementData = array;
        this.size = this.elementData.length;
        if (this.elementData.length == 0) {
            this.elementData = ArrayDeque.emptyElementData;
        }
    }
    
    private final void ensureCapacity(final int minCapacity) {
        if (minCapacity < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        if (minCapacity <= this.elementData.length) {
            return;
        }
        if (this.elementData == ArrayDeque.emptyElementData) {
            this.elementData = new Object[RangesKt___RangesKt.coerceAtLeast(minCapacity, 10)];
            return;
        }
        final int newCapacity = ArrayDeque.Companion.newCapacity$kotlin_stdlib(this.elementData.length, minCapacity);
        this.copyElements(newCapacity);
    }
    
    private final void copyElements(final int newCapacity) {
        final Object[] newElements = new Object[newCapacity];
        ArraysKt___ArraysJvmKt.copyInto(this.elementData, newElements, 0, this.head, this.elementData.length);
        ArraysKt___ArraysJvmKt.copyInto(this.elementData, newElements, this.elementData.length - this.head, 0, this.head);
        this.head = 0;
        this.elementData = newElements;
    }
    
    @InlineOnly
    private final E internalGet(final int internalIndex) {
        return (E)this.elementData[internalIndex];
    }
    
    private final int positiveMod(final int index) {
        return (index >= this.elementData.length) ? (index - this.elementData.length) : index;
    }
    
    private final int negativeMod(final int index) {
        return (index < 0) ? (index + this.elementData.length) : index;
    }
    
    @InlineOnly
    private final int internalIndex(final int index) {
        return this.positiveMod(this.head + index);
    }
    
    private final int incremented(final int index) {
        return (index == ArraysKt___ArraysKt.getLastIndex(this.elementData)) ? 0 : (index + 1);
    }
    
    private final int decremented(final int index) {
        return (index == 0) ? ArraysKt___ArraysKt.getLastIndex(this.elementData) : (index - 1);
    }
    
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    public final E first() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E)this.elementData[this.head];
    }
    
    @Nullable
    public final E firstOrNull() {
        return (E)(this.isEmpty() ? null : this.elementData[this.head]);
    }
    
    public final E last() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E)this.elementData[this.positiveMod(this.head + CollectionsKt__CollectionsKt.getLastIndex((List<?>)this))];
    }
    
    @Nullable
    public final E lastOrNull() {
        return (E)(this.isEmpty() ? null : this.elementData[this.positiveMod(this.head + CollectionsKt__CollectionsKt.getLastIndex((List<?>)this))]);
    }
    
    public final void addFirst(final E element) {
        this.ensureCapacity(this.size() + 1);
        this.head = this.decremented(this.head);
        this.elementData[this.head] = element;
        this.size = this.size() + 1;
    }
    
    public final void addLast(final E element) {
        this.ensureCapacity(this.size() + 1);
        this.elementData[this.positiveMod(this.head + this.size())] = element;
        this.size = this.size() + 1;
    }
    
    public final E removeFirst() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        final Object element = this.elementData[this.head];
        this.elementData[this.head] = null;
        this.head = this.incremented(this.head);
        this.size = this.size() - 1;
        return (E)element;
    }
    
    @Nullable
    public final E removeFirstOrNull() {
        return this.isEmpty() ? null : this.removeFirst();
    }
    
    public final E removeLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        final int internalLastIndex = this.positiveMod(this.head + CollectionsKt__CollectionsKt.getLastIndex((List<?>)this));
        final Object element = this.elementData[internalLastIndex];
        this.elementData[internalLastIndex] = null;
        this.size = this.size() - 1;
        return (E)element;
    }
    
    @Nullable
    public final E removeLastOrNull() {
        return this.isEmpty() ? null : this.removeLast();
    }
    
    @Override
    public boolean add(final E element) {
        this.addLast(element);
        return true;
    }
    
    @Override
    public void add(final int index, final E element) {
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.size());
        if (index == this.size()) {
            this.addLast(element);
            return;
        }
        if (index == 0) {
            this.addFirst(element);
            return;
        }
        this.ensureCapacity(this.size() + 1);
        final int internalIndex = this.positiveMod(this.head + index);
        if (index < this.size() + 1 >> 1) {
            final int decrementedInternalIndex = this.decremented(internalIndex);
            final int decrementedHead = this.decremented(this.head);
            if (decrementedInternalIndex >= this.head) {
                this.elementData[decrementedHead] = this.elementData[this.head];
                ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, this.head, this.head + 1, decrementedInternalIndex + 1);
            }
            else {
                ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, this.head - 1, this.head, this.elementData.length);
                this.elementData[this.elementData.length - 1] = this.elementData[0];
                ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, 0, 1, decrementedInternalIndex + 1);
            }
            this.elementData[decrementedInternalIndex] = element;
            this.head = decrementedHead;
        }
        else {
            final int tail = this.positiveMod(this.head + this.size());
            if (internalIndex < tail) {
                ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, internalIndex + 1, internalIndex, tail);
            }
            else {
                ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, 1, 0, tail);
                this.elementData[0] = this.elementData[this.elementData.length - 1];
                ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, internalIndex + 1, internalIndex, this.elementData.length - 1);
            }
            this.elementData[internalIndex] = element;
        }
        this.size = this.size() + 1;
    }
    
    private final void copyCollectionElements(final int internalIndex, final Collection<? extends E> elements) {
        final Iterator iterator = elements.iterator();
        for (int index = internalIndex; index < this.elementData.length && iterator.hasNext(); ++index) {
            this.elementData[index] = iterator.next();
        }
        for (int index = 0; index < this.head && iterator.hasNext(); ++index) {
            this.elementData[index] = iterator.next();
        }
        this.size = this.size() + elements.size();
    }
    
    @Override
    public boolean addAll(@NotNull final Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        this.ensureCapacity(this.size() + elements.size());
        this.copyCollectionElements(this.positiveMod(this.head + this.size()), elements);
        return true;
    }
    
    @Override
    public boolean addAll(final int index, @NotNull final Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.size());
        if (elements.isEmpty()) {
            return false;
        }
        if (index == this.size()) {
            return this.addAll(elements);
        }
        this.ensureCapacity(this.size() + elements.size());
        final int tail = this.positiveMod(this.head + this.size());
        final int internalIndex = this.positiveMod(this.head + index);
        final int elementsSize = elements.size();
        if (index < this.size() + 1 >> 1) {
            int shiftedHead = this.head - elementsSize;
            if (internalIndex >= this.head) {
                if (shiftedHead >= 0) {
                    ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, shiftedHead, this.head, internalIndex);
                }
                else {
                    shiftedHead += this.elementData.length;
                    final int elementsToShift = internalIndex - this.head;
                    final int shiftToBack = this.elementData.length - shiftedHead;
                    if (shiftToBack >= elementsToShift) {
                        ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, shiftedHead, this.head, internalIndex);
                    }
                    else {
                        ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, shiftedHead, this.head, this.head + shiftToBack);
                        ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, 0, this.head + shiftToBack, internalIndex);
                    }
                }
            }
            else {
                ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, shiftedHead, this.head, this.elementData.length);
                if (elementsSize >= internalIndex) {
                    ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, this.elementData.length - elementsSize, 0, internalIndex);
                }
                else {
                    ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, this.elementData.length - elementsSize, 0, elementsSize);
                    ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, 0, elementsSize, internalIndex);
                }
            }
            this.head = shiftedHead;
            this.copyCollectionElements(this.negativeMod(internalIndex - elementsSize), elements);
        }
        else {
            final int shiftedInternalIndex = internalIndex + elementsSize;
            if (internalIndex < tail) {
                if (tail + elementsSize <= this.elementData.length) {
                    ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, shiftedInternalIndex, internalIndex, tail);
                }
                else if (shiftedInternalIndex >= this.elementData.length) {
                    ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, shiftedInternalIndex - this.elementData.length, internalIndex, tail);
                }
                else {
                    final int shiftToFront = tail + elementsSize - this.elementData.length;
                    ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, 0, tail - shiftToFront, tail);
                    ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, shiftedInternalIndex, internalIndex, tail - shiftToFront);
                }
            }
            else {
                ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, elementsSize, 0, tail);
                if (shiftedInternalIndex >= this.elementData.length) {
                    ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, shiftedInternalIndex - this.elementData.length, internalIndex, this.elementData.length);
                }
                else {
                    ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, 0, this.elementData.length - elementsSize, this.elementData.length);
                    ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, shiftedInternalIndex, internalIndex, this.elementData.length - elementsSize);
                }
            }
            this.copyCollectionElements(internalIndex, elements);
        }
        return true;
    }
    
    @Override
    public E get(final int index) {
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.size());
        return (E)this.elementData[this.positiveMod(this.head + index)];
    }
    
    @Override
    public E set(final int index, final E element) {
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.size());
        final int internalIndex = this.positiveMod(this.head + index);
        final Object oldElement = this.elementData[internalIndex];
        this.elementData[internalIndex] = element;
        return (E)oldElement;
    }
    
    @Override
    public boolean contains(final Object element) {
        return this.indexOf(element) != -1;
    }
    
    @Override
    public int indexOf(final Object element) {
        final int tail = this.positiveMod(this.head + this.size());
        if (this.head < tail) {
            for (int index = this.head; index < tail; ++index) {
                if (Intrinsics.areEqual(element, this.elementData[index])) {
                    return index - this.head;
                }
            }
        }
        else if (this.head >= tail) {
            for (int index = this.head; index < this.elementData.length; ++index) {
                if (Intrinsics.areEqual(element, this.elementData[index])) {
                    return index - this.head;
                }
            }
            for (int index = 0; index < tail; ++index) {
                if (Intrinsics.areEqual(element, this.elementData[index])) {
                    return index + this.elementData.length - this.head;
                }
            }
        }
        return -1;
    }
    
    @Override
    public int lastIndexOf(final Object element) {
        final int tail = this.positiveMod(this.head + this.size());
        if (this.head < tail) {
            int index = tail - 1;
            final int head = this.head;
            if (head <= index) {
                while (!Intrinsics.areEqual(element, this.elementData[index])) {
                    if (index == head) {
                        return -1;
                    }
                    --index;
                }
                return index - this.head;
            }
        }
        else if (this.head > tail) {
            for (int index = tail - 1; -1 < index; --index) {
                if (Intrinsics.areEqual(element, this.elementData[index])) {
                    return index + this.elementData.length - this.head;
                }
            }
            int index = ArraysKt___ArraysKt.getLastIndex(this.elementData);
            final int head2 = this.head;
            if (head2 <= index) {
                while (!Intrinsics.areEqual(element, this.elementData[index])) {
                    if (index == head2) {
                        return -1;
                    }
                    --index;
                }
                return index - this.head;
            }
        }
        return -1;
    }
    
    @Override
    public boolean remove(final Object element) {
        final int index = this.indexOf(element);
        if (index == -1) {
            return false;
        }
        this.remove(index);
        return true;
    }
    
    @Override
    public E removeAt(final int index) {
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.size());
        if (index == CollectionsKt__CollectionsKt.getLastIndex((List<?>)this)) {
            return this.removeLast();
        }
        if (index == 0) {
            return this.removeFirst();
        }
        final int internalIndex = this.positiveMod(this.head + index);
        final Object element = this.elementData[internalIndex];
        if (index < this.size() >> 1) {
            if (internalIndex >= this.head) {
                ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, this.head + 1, this.head, internalIndex);
            }
            else {
                ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, 1, 0, internalIndex);
                this.elementData[0] = this.elementData[this.elementData.length - 1];
                ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, this.head + 1, this.head, this.elementData.length - 1);
            }
            this.elementData[this.head] = null;
            this.head = this.incremented(this.head);
        }
        else {
            final int internalLastIndex = this.positiveMod(this.head + CollectionsKt__CollectionsKt.getLastIndex((List<?>)this));
            if (internalIndex <= internalLastIndex) {
                ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, internalIndex, internalIndex + 1, internalLastIndex + 1);
            }
            else {
                ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, internalIndex, internalIndex + 1, this.elementData.length);
                this.elementData[this.elementData.length - 1] = this.elementData[0];
                ArraysKt___ArraysJvmKt.copyInto(this.elementData, this.elementData, 0, 1, internalLastIndex + 1);
            }
            this.elementData[internalLastIndex] = null;
        }
        this.size = this.size() - 1;
        return (E)element;
    }
    
    @Override
    public boolean removeAll(@NotNull final Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        final ArrayDeque this_$iv = this;
        final int $i$f$filterInPlace = 0;
        boolean b;
        if (this_$iv.isEmpty() || this_$iv.elementData.length == 0) {
            b = false;
        }
        else {
            final ArrayDeque arrayDeque = this_$iv;
            final int tail$iv = arrayDeque.positiveMod(arrayDeque.head + this_$iv.size());
            int newTail$iv = this_$iv.head;
            boolean modified$iv = false;
            if (this_$iv.head < tail$iv) {
                for (int index$iv = this_$iv.head; index$iv < tail$iv; ++index$iv) {
                    final Object it;
                    final Object element$iv = it = this_$iv.elementData[index$iv];
                    final int n = 0;
                    if (!elements.contains(it)) {
                        this_$iv.elementData[newTail$iv++] = element$iv;
                    }
                    else {
                        modified$iv = true;
                    }
                }
                ArraysKt___ArraysJvmKt.fill(this_$iv.elementData, null, newTail$iv, tail$iv);
            }
            else {
                for (int index$iv = this_$iv.head; index$iv < this_$iv.elementData.length; ++index$iv) {
                    final Object element$iv2 = this_$iv.elementData[index$iv];
                    this_$iv.elementData[index$iv] = null;
                    final Object it2 = element$iv2;
                    final int n2 = 0;
                    if (!elements.contains(it2)) {
                        this_$iv.elementData[newTail$iv++] = element$iv2;
                    }
                    else {
                        modified$iv = true;
                    }
                }
                newTail$iv = this_$iv.positiveMod(newTail$iv);
                for (int index$iv = 0; index$iv < tail$iv; ++index$iv) {
                    final Object element$iv = this_$iv.elementData[index$iv];
                    this_$iv.elementData[index$iv] = null;
                    final Object it2 = element$iv;
                    final int n2 = 0;
                    if (!elements.contains(it2)) {
                        this_$iv.elementData[newTail$iv] = element$iv;
                        newTail$iv = this_$iv.incremented(newTail$iv);
                    }
                    else {
                        modified$iv = true;
                    }
                }
            }
            if (modified$iv) {
                this_$iv.size = this_$iv.negativeMod(newTail$iv - this_$iv.head);
            }
            b = modified$iv;
        }
        return b;
    }
    
    @Override
    public boolean retainAll(@NotNull final Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        final ArrayDeque this_$iv = this;
        final int $i$f$filterInPlace = 0;
        boolean b;
        if (this_$iv.isEmpty() || this_$iv.elementData.length == 0) {
            b = false;
        }
        else {
            final ArrayDeque arrayDeque = this_$iv;
            final int tail$iv = arrayDeque.positiveMod(arrayDeque.head + this_$iv.size());
            int newTail$iv = this_$iv.head;
            boolean modified$iv = false;
            if (this_$iv.head < tail$iv) {
                for (int index$iv = this_$iv.head; index$iv < tail$iv; ++index$iv) {
                    final Object it;
                    final Object element$iv = it = this_$iv.elementData[index$iv];
                    final int n = 0;
                    if (elements.contains(it)) {
                        this_$iv.elementData[newTail$iv++] = element$iv;
                    }
                    else {
                        modified$iv = true;
                    }
                }
                ArraysKt___ArraysJvmKt.fill(this_$iv.elementData, null, newTail$iv, tail$iv);
            }
            else {
                for (int index$iv = this_$iv.head; index$iv < this_$iv.elementData.length; ++index$iv) {
                    final Object element$iv2 = this_$iv.elementData[index$iv];
                    this_$iv.elementData[index$iv] = null;
                    final Object it2 = element$iv2;
                    final int n2 = 0;
                    if (elements.contains(it2)) {
                        this_$iv.elementData[newTail$iv++] = element$iv2;
                    }
                    else {
                        modified$iv = true;
                    }
                }
                newTail$iv = this_$iv.positiveMod(newTail$iv);
                for (int index$iv = 0; index$iv < tail$iv; ++index$iv) {
                    final Object element$iv = this_$iv.elementData[index$iv];
                    this_$iv.elementData[index$iv] = null;
                    final Object it2 = element$iv;
                    final int n2 = 0;
                    if (elements.contains(it2)) {
                        this_$iv.elementData[newTail$iv] = element$iv;
                        newTail$iv = this_$iv.incremented(newTail$iv);
                    }
                    else {
                        modified$iv = true;
                    }
                }
            }
            if (modified$iv) {
                this_$iv.size = this_$iv.negativeMod(newTail$iv - this_$iv.head);
            }
            b = modified$iv;
        }
        return b;
    }
    
    private final boolean filterInPlace(final Function1<? super E, Boolean> predicate) {
        final int $i$f$filterInPlace = 0;
        if (this.isEmpty() || this.elementData.length == 0) {
            return false;
        }
        final int tail = this.positiveMod(this.head + this.size());
        int newTail = this.head;
        boolean modified = false;
        if (this.head < tail) {
            for (int index = this.head; index < tail; ++index) {
                final Object element = this.elementData[index];
                if (predicate.invoke((Object)element)) {
                    this.elementData[newTail++] = element;
                }
                else {
                    modified = true;
                }
            }
            ArraysKt___ArraysJvmKt.fill(this.elementData, null, newTail, tail);
        }
        else {
            for (int index = this.head; index < this.elementData.length; ++index) {
                final Object element2 = this.elementData[index];
                this.elementData[index] = null;
                if (predicate.invoke((Object)element2)) {
                    this.elementData[newTail++] = element2;
                }
                else {
                    modified = true;
                }
            }
            newTail = this.positiveMod(newTail);
            for (int index = 0; index < tail; ++index) {
                final Object element = this.elementData[index];
                this.elementData[index] = null;
                if (predicate.invoke((Object)element)) {
                    this.elementData[newTail] = element;
                    newTail = this.incremented(newTail);
                }
                else {
                    modified = true;
                }
            }
        }
        if (modified) {
            this.size = this.negativeMod(newTail - this.head);
        }
        return modified;
    }
    
    @Override
    public void clear() {
        final int tail = this.positiveMod(this.head + this.size());
        if (this.head < tail) {
            ArraysKt___ArraysJvmKt.fill(this.elementData, null, this.head, tail);
        }
        else if (!this.isEmpty()) {
            ArraysKt___ArraysJvmKt.fill(this.elementData, null, this.head, this.elementData.length);
            ArraysKt___ArraysJvmKt.fill(this.elementData, null, 0, tail);
        }
        this.head = 0;
        this.size = 0;
    }
    
    @NotNull
    @Override
    public <T> T[] toArray(@NotNull final T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        Object[] array2;
        T[] arrayOfNulls;
        if (array.length >= this.size()) {
            array2 = array;
            arrayOfNulls = array;
        }
        else {
            array2 = (arrayOfNulls = ArraysKt__ArraysJVMKt.arrayOfNulls(array, this.size()));
        }
        Intrinsics.checkNotNull(arrayOfNulls, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        final Object[] dest = array2;
        final int tail = this.positiveMod(this.head + this.size());
        if (this.head < tail) {
            ArraysKt___ArraysJvmKt.copyInto$default(this.elementData, dest, 0, this.head, tail, 2, null);
        }
        else if (!this.isEmpty()) {
            ArraysKt___ArraysJvmKt.copyInto(this.elementData, dest, 0, this.head, this.elementData.length);
            ArraysKt___ArraysJvmKt.copyInto(this.elementData, dest, this.elementData.length - this.head, 0, tail);
        }
        if (dest.length > this.size()) {
            dest[this.size()] = null;
        }
        return (T[])dest;
    }
    
    @NotNull
    @Override
    public Object[] toArray() {
        return this.toArray(new Object[this.size()]);
    }
    
    @NotNull
    public final <T> T[] testToArray$kotlin_stdlib(@NotNull final T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[])this.toArray((Object[])array);
    }
    
    @NotNull
    public final Object[] testToArray$kotlin_stdlib() {
        return this.toArray();
    }
    
    public final void internalStructure$kotlin_stdlib(@NotNull final Function2<? super Integer, ? super Object[], Unit> structure) {
        Intrinsics.checkNotNullParameter(structure, "structure");
        final int tail = this.positiveMod(this.head + this.size());
        final int head = (this.isEmpty() || this.head < tail) ? this.head : (this.head - this.elementData.length);
        structure.invoke(head, this.toArray());
    }
    
    static {
        Companion = new Companion(null);
        final int $i$f$emptyArray = 0;
        emptyElementData = new Object[0];
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r" }, d2 = { "Lkotlin/collections/ArrayDeque$Companion;", "", "()V", "defaultMinCapacity", "", "emptyElementData", "", "[Ljava/lang/Object;", "maxArraySize", "newCapacity", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "kotlin-stdlib" })
    public static final class Companion
    {
        private Companion() {
        }
        
        public final int newCapacity$kotlin_stdlib(final int oldCapacity, final int minCapacity) {
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0) {
                newCapacity = minCapacity;
            }
            if (newCapacity - 2147483639 > 0) {
                newCapacity = ((minCapacity > 2147483639) ? Integer.MAX_VALUE : 2147483639);
            }
            return newCapacity;
        }
    }
}
