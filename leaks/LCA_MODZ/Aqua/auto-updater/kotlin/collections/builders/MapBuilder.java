// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections.builders;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import java.util.Iterator;
import java.util.Arrays;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import java.io.NotSerializableException;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableMap;
import java.io.Serializable;
import java.util.Map;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 {*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00060\u0004j\u0002`\u0005:\u0007{|}~\u007f\u0080\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tBE\b\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0002\u0010\u0012J\u0017\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00028\u0000H\u0000¢\u0006\u0004\b4\u00105J\u0013\u00106\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0002¢\u0006\u0002\u00107J\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109J\r\u0010:\u001a\u00020;H\u0000¢\u0006\u0002\b<J\b\u0010=\u001a\u00020;H\u0016J\b\u0010>\u001a\u00020;H\u0002J\u0019\u0010?\u001a\u00020!2\n\u0010@\u001a\u0006\u0012\u0002\b\u00030AH\u0000¢\u0006\u0002\bBJ!\u0010C\u001a\u00020!2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010EH\u0000¢\u0006\u0002\bFJ\u0015\u0010G\u001a\u00020!2\u0006\u00103\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010HJ\u0015\u0010I\u001a\u00020!2\u0006\u0010J\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010HJ\u0018\u0010K\u001a\u00020!2\u000e\u0010L\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u000309H\u0002J\u0010\u0010M\u001a\u00020;2\u0006\u0010\u0013\u001a\u00020\bH\u0002J\u0010\u0010N\u001a\u00020;2\u0006\u0010O\u001a\u00020\bH\u0002J\u0019\u0010P\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010QH\u0000¢\u0006\u0002\bRJ\u0013\u0010S\u001a\u00020!2\b\u0010L\u001a\u0004\u0018\u00010TH\u0096\u0002J\u0015\u0010U\u001a\u00020\b2\u0006\u00103\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00105J\u0015\u0010V\u001a\u00020\b2\u0006\u0010J\u001a\u00028\u0001H\u0002¢\u0006\u0002\u00105J\u0018\u0010W\u001a\u0004\u0018\u00018\u00012\u0006\u00103\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010XJ\u0015\u0010Y\u001a\u00020\b2\u0006\u00103\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00105J\b\u0010Z\u001a\u00020\bH\u0016J\b\u0010[\u001a\u00020!H\u0016J\u0019\u0010\\\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010]H\u0000¢\u0006\u0002\b^J\u001f\u0010_\u001a\u0004\u0018\u00018\u00012\u0006\u00103\u001a\u00028\u00002\u0006\u0010J\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010`J\u001e\u0010a\u001a\u00020;2\u0014\u0010b\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109H\u0016J\"\u0010c\u001a\u00020!2\u0018\u0010b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010E0AH\u0002J\u001c\u0010d\u001a\u00020!2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010EH\u0002J\u0010\u0010e\u001a\u00020!2\u0006\u0010f\u001a\u00020\bH\u0002J\u0010\u0010g\u001a\u00020;2\u0006\u0010h\u001a\u00020\bH\u0002J\u0017\u0010i\u001a\u0004\u0018\u00018\u00012\u0006\u00103\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010XJ!\u0010j\u001a\u00020!2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010EH\u0000¢\u0006\u0002\bkJ\u0010\u0010l\u001a\u00020;2\u0006\u0010m\u001a\u00020\bH\u0002J\u0017\u0010n\u001a\u00020\b2\u0006\u00103\u001a\u00028\u0000H\u0000¢\u0006\u0004\bo\u00105J\u0010\u0010p\u001a\u00020;2\u0006\u0010q\u001a\u00020\bH\u0002J\u0017\u0010r\u001a\u00020!2\u0006\u0010s\u001a\u00028\u0001H\u0000¢\u0006\u0004\bt\u0010HJ\b\u0010u\u001a\u00020vH\u0016J\u0019\u0010w\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010xH\u0000¢\u0006\u0002\byJ\b\u0010z\u001a\u00020TH\u0002R\u0014\u0010\u0013\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00180\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u001e\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001aR\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0015R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u0016\u00100\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0081\u0001" }, d2 = { "Lkotlin/collections/builders/MapBuilder;", "K", "V", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "initialCapacity", "", "(I)V", "keysArray", "", "valuesArray", "presenceArray", "", "hashArray", "maxProbeDistance", "length", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "capacity", "getCapacity", "()I", "entries", "", "", "getEntries", "()Ljava/util/Set;", "entriesView", "Lkotlin/collections/builders/MapBuilderEntries;", "hashShift", "hashSize", "getHashSize", "<set-?>", "", "isReadOnly", "isReadOnly$kotlin_stdlib", "()Z", "keys", "getKeys", "[Ljava/lang/Object;", "keysView", "Lkotlin/collections/builders/MapBuilderKeys;", "size", "getSize", "values", "", "getValues", "()Ljava/util/Collection;", "valuesView", "Lkotlin/collections/builders/MapBuilderValues;", "addKey", "key", "addKey$kotlin_stdlib", "(Ljava/lang/Object;)I", "allocateValuesArray", "()[Ljava/lang/Object;", "build", "", "checkIsMutable", "", "checkIsMutable$kotlin_stdlib", "clear", "compact", "containsAllEntries", "m", "", "containsAllEntries$kotlin_stdlib", "containsEntry", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "value", "contentEquals", "other", "ensureCapacity", "ensureExtraCapacity", "n", "entriesIterator", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "equals", "", "findKey", "findValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hash", "hashCode", "isEmpty", "keysIterator", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "putAllEntries", "putEntry", "putRehash", "i", "rehash", "newHashSize", "remove", "removeEntry", "removeEntry$kotlin_stdlib", "removeHashAt", "removedHash", "removeKey", "removeKey$kotlin_stdlib", "removeKeyAt", "index", "removeValue", "element", "removeValue$kotlin_stdlib", "toString", "", "valuesIterator", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "writeReplace", "Companion", "EntriesItr", "EntryRef", "Itr", "KeysItr", "ValuesItr", "kotlin-stdlib" })
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, KMutableMap
{
    @NotNull
    private static final Companion Companion;
    @NotNull
    private K[] keysArray;
    @Nullable
    private V[] valuesArray;
    @NotNull
    private int[] presenceArray;
    @NotNull
    private int[] hashArray;
    private int maxProbeDistance;
    private int length;
    private int hashShift;
    private int size;
    @Nullable
    private MapBuilderKeys<K> keysView;
    @Nullable
    private MapBuilderValues<V> valuesView;
    @Nullable
    private MapBuilderEntries<K, V> entriesView;
    private boolean isReadOnly;
    @Deprecated
    private static final int MAGIC = -1640531527;
    @Deprecated
    private static final int INITIAL_CAPACITY = 8;
    @Deprecated
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    @Deprecated
    private static final int TOMBSTONE = -1;
    
    private MapBuilder(final K[] keysArray, final V[] valuesArray, final int[] presenceArray, final int[] hashArray, final int maxProbeDistance, final int length) {
        this.keysArray = keysArray;
        this.valuesArray = valuesArray;
        this.presenceArray = presenceArray;
        this.hashArray = hashArray;
        this.maxProbeDistance = maxProbeDistance;
        this.length = length;
        this.hashShift = MapBuilder.Companion.computeShift(this.getHashSize());
    }
    
    public int getSize() {
        return this.size;
    }
    
    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }
    
    public MapBuilder() {
        this(8);
    }
    
    public MapBuilder(final int initialCapacity) {
        this(ListBuilderKt.arrayOfUninitializedElements(initialCapacity), null, new int[initialCapacity], new int[MapBuilder.Companion.computeHashSize(initialCapacity)], 2, 0);
    }
    
    @NotNull
    public final Map<K, V> build() {
        this.checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        return this;
    }
    
    private final Object writeReplace() {
        if (this.isReadOnly) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }
    
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    @Override
    public boolean containsKey(final Object key) {
        return this.findKey(key) >= 0;
    }
    
    @Override
    public boolean containsValue(final Object value) {
        return this.findValue(value) >= 0;
    }
    
    @Nullable
    @Override
    public V get(final Object key) {
        final int index = this.findKey(key);
        if (index < 0) {
            return null;
        }
        final V[] valuesArray = this.valuesArray;
        Intrinsics.checkNotNull(valuesArray);
        return valuesArray[index];
    }
    
    @Nullable
    @Override
    public V put(final K key, final V value) {
        this.checkIsMutable$kotlin_stdlib();
        final int index = this.addKey$kotlin_stdlib(key);
        final Object[] valuesArray = this.allocateValuesArray();
        if (index < 0) {
            final Object oldValue = valuesArray[-index - 1];
            valuesArray[-index - 1] = value;
            return (V)oldValue;
        }
        valuesArray[index] = value;
        return null;
    }
    
    @Override
    public void putAll(@NotNull final Map<? extends K, ? extends V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        this.checkIsMutable$kotlin_stdlib();
        this.putAllEntries((Collection<? extends Map.Entry<? extends K, ? extends V>>)from.entrySet());
    }
    
    @Nullable
    @Override
    public V remove(final Object key) {
        final int index = this.removeKey$kotlin_stdlib(key);
        if (index < 0) {
            return null;
        }
        final V[] valuesArray2 = this.valuesArray;
        Intrinsics.checkNotNull(valuesArray2);
        final Object[] valuesArray = valuesArray2;
        final Object oldValue = valuesArray[index];
        ListBuilderKt.resetAt(valuesArray, index);
        return (V)oldValue;
    }
    
    @Override
    public void clear() {
        this.checkIsMutable$kotlin_stdlib();
        final IntIterator iterator = new IntRange(0, this.length - 1).iterator();
        while (iterator.hasNext()) {
            final int i = iterator.nextInt();
            final int hash = this.presenceArray[i];
            if (hash >= 0) {
                this.hashArray[hash] = 0;
                this.presenceArray[i] = -1;
            }
        }
        ListBuilderKt.resetRange(this.keysArray, 0, this.length);
        final V[] valuesArray = this.valuesArray;
        if (valuesArray != null) {
            ListBuilderKt.resetRange(valuesArray, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
    }
    
    @NotNull
    public Set<K> getKeys() {
        final MapBuilderKeys cur = this.keysView;
        MapBuilderKeys mapBuilderKeys;
        if (cur == null) {
            final MapBuilderKeys new1 = new MapBuilderKeys((MapBuilder<E, ?>)this);
            this.keysView = (MapBuilderKeys<K>)new1;
            mapBuilderKeys = new1;
        }
        else {
            mapBuilderKeys = cur;
        }
        return (Set<K>)mapBuilderKeys;
    }
    
    @NotNull
    public Collection<V> getValues() {
        final MapBuilderValues cur = this.valuesView;
        MapBuilderValues mapBuilderValues;
        if (cur == null) {
            final MapBuilderValues new1 = new MapBuilderValues((MapBuilder<?, V>)this);
            this.valuesView = (MapBuilderValues<V>)new1;
            mapBuilderValues = new1;
        }
        else {
            mapBuilderValues = cur;
        }
        return (Collection<V>)mapBuilderValues;
    }
    
    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        final MapBuilderEntries cur = this.entriesView;
        if (cur == null) {
            final MapBuilderEntries new1 = new MapBuilderEntries((MapBuilder<K, V>)this);
            this.entriesView = (MapBuilderEntries<K, V>)new1;
            return (Set<Map.Entry<K, V>>)new1;
        }
        return (Set<Map.Entry<K, V>>)cur;
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        return other == this || (other instanceof Map && this.contentEquals((Map<?, ?>)other));
    }
    
    @Override
    public int hashCode() {
        int result = 0;
        final EntriesItr it = this.entriesIterator$kotlin_stdlib();
        while (((Itr)it).hasNext()) {
            result += it.nextHashCode$kotlin_stdlib();
        }
        return result;
    }
    
    @NotNull
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(2 + this.size() * 3);
        sb.append("{");
        int i = 0;
        final EntriesItr it = this.entriesIterator$kotlin_stdlib();
        while (((Itr)it).hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            it.nextAppendString(sb);
            ++i;
        }
        sb.append("}");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }
    
    private final int getCapacity() {
        return this.keysArray.length;
    }
    
    private final int getHashSize() {
        return this.hashArray.length;
    }
    
    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }
    
    private final void ensureExtraCapacity(final int n) {
        this.ensureCapacity(this.length + n);
    }
    
    private final void ensureCapacity(final int capacity) {
        if (capacity < 0) {
            throw new OutOfMemoryError();
        }
        if (capacity > this.getCapacity()) {
            int newSize = this.getCapacity() * 3 / 2;
            if (capacity > newSize) {
                newSize = capacity;
            }
            this.keysArray = ListBuilderKt.copyOfUninitializedElements(this.keysArray, newSize);
            final V[] valuesArray = this.valuesArray;
            this.valuesArray = (V[])((valuesArray != null) ? ListBuilderKt.copyOfUninitializedElements(valuesArray, newSize) : null);
            final int[] copy = Arrays.copyOf(this.presenceArray, newSize);
            Intrinsics.checkNotNullExpressionValue(copy, "copyOf(this, newSize)");
            this.presenceArray = copy;
            final int newHashSize = MapBuilder.Companion.computeHashSize(newSize);
            if (newHashSize > this.getHashSize()) {
                this.rehash(newHashSize);
            }
        }
        else if (this.length + capacity - this.size() > this.getCapacity()) {
            this.rehash(this.getHashSize());
        }
    }
    
    private final V[] allocateValuesArray() {
        final Object[] curValuesArray = this.valuesArray;
        if (curValuesArray != null) {
            return (V[])curValuesArray;
        }
        final Object[] newValuesArray = ListBuilderKt.arrayOfUninitializedElements(this.getCapacity());
        return this.valuesArray = (V[])newValuesArray;
    }
    
    private final int hash(final K key) {
        return ((key != null) ? key.hashCode() : 0) * -1640531527 >>> this.hashShift;
    }
    
    private final void compact() {
        int i = 0;
        int j = 0;
        final Object[] valuesArray = this.valuesArray;
        while (i < this.length) {
            if (this.presenceArray[i] >= 0) {
                this.keysArray[j] = this.keysArray[i];
                if (valuesArray != null) {
                    valuesArray[j] = valuesArray[i];
                }
                ++j;
            }
            ++i;
        }
        ListBuilderKt.resetRange(this.keysArray, j, this.length);
        final Object[] $this$resetRange = valuesArray;
        if ($this$resetRange != null) {
            ListBuilderKt.resetRange($this$resetRange, j, this.length);
        }
        this.length = j;
    }
    
    private final void rehash(final int newHashSize) {
        if (this.length > this.size()) {
            this.compact();
        }
        if (newHashSize != this.getHashSize()) {
            this.hashArray = new int[newHashSize];
            this.hashShift = MapBuilder.Companion.computeShift(newHashSize);
        }
        else {
            ArraysKt___ArraysJvmKt.fill(this.hashArray, 0, 0, this.getHashSize());
        }
        int i = 0;
        while (i < this.length) {
            if (!this.putRehash(i++)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
        }
    }
    
    private final boolean putRehash(final int i) {
        int hash = this.hash(this.keysArray[i]);
        int probesLeft = this.maxProbeDistance;
        while (true) {
            final int index = this.hashArray[hash];
            if (index == 0) {
                this.hashArray[hash] = i + 1;
                this.presenceArray[i] = hash;
                return true;
            }
            if (--probesLeft < 0) {
                return false;
            }
            if (hash-- != 0) {
                continue;
            }
            hash = this.getHashSize() - 1;
        }
    }
    
    private final int findKey(final K key) {
        int hash = this.hash(key);
        int probesLeft = this.maxProbeDistance;
        while (true) {
            final int index = this.hashArray[hash];
            if (index == 0) {
                return -1;
            }
            if (index > 0 && Intrinsics.areEqual(this.keysArray[index - 1], key)) {
                return index - 1;
            }
            if (--probesLeft < 0) {
                return -1;
            }
            if (hash-- != 0) {
                continue;
            }
            hash = this.getHashSize() - 1;
        }
    }
    
    private final int findValue(final V value) {
        int i = this.length;
        while (--i >= 0) {
            if (this.presenceArray[i] >= 0) {
                final V[] valuesArray = this.valuesArray;
                Intrinsics.checkNotNull(valuesArray);
                if (Intrinsics.areEqual(valuesArray[i], value)) {
                    return i;
                }
                continue;
            }
        }
        return -1;
    }
    
    public final int addKey$kotlin_stdlib(final K key) {
        this.checkIsMutable$kotlin_stdlib();
        while (true) {
            int hash = this.hash(key);
            final int tentativeMaxProbeDistance = RangesKt___RangesKt.coerceAtMost(this.maxProbeDistance * 2, this.getHashSize() / 2);
            int probeDistance = 0;
            while (true) {
                final int index = this.hashArray[hash];
                if (index <= 0) {
                    if (this.length >= this.getCapacity()) {
                        this.ensureExtraCapacity(1);
                        break;
                    }
                    final int putIndex = this.length++;
                    this.keysArray[putIndex] = key;
                    this.presenceArray[putIndex] = hash;
                    this.hashArray[hash] = putIndex + 1;
                    this.size = this.size() + 1;
                    if (probeDistance > this.maxProbeDistance) {
                        this.maxProbeDistance = probeDistance;
                    }
                    return putIndex;
                }
                else {
                    if (Intrinsics.areEqual(this.keysArray[index - 1], key)) {
                        return -index;
                    }
                    if (++probeDistance > tentativeMaxProbeDistance) {
                        this.rehash(this.getHashSize() * 2);
                        break;
                    }
                    if (hash-- != 0) {
                        continue;
                    }
                    hash = this.getHashSize() - 1;
                }
            }
        }
    }
    
    public final int removeKey$kotlin_stdlib(final K key) {
        this.checkIsMutable$kotlin_stdlib();
        final int index = this.findKey(key);
        if (index < 0) {
            return -1;
        }
        this.removeKeyAt(index);
        return index;
    }
    
    private final void removeKeyAt(final int index) {
        ListBuilderKt.resetAt(this.keysArray, index);
        this.removeHashAt(this.presenceArray[index]);
        this.presenceArray[index] = -1;
        this.size = this.size() - 1;
    }
    
    private final void removeHashAt(final int removedHash) {
        int hash = removedHash;
        int hole = removedHash;
        int probeDistance = 0;
        int patchAttemptsLeft = RangesKt___RangesKt.coerceAtMost(this.maxProbeDistance * 2, this.getHashSize() / 2);
        do {
            if (hash-- == 0) {
                hash = this.getHashSize() - 1;
            }
            if (++probeDistance > this.maxProbeDistance) {
                this.hashArray[hole] = 0;
                return;
            }
            final int index = this.hashArray[hash];
            if (index == 0) {
                this.hashArray[hole] = 0;
                return;
            }
            if (index < 0) {
                this.hashArray[hole] = -1;
                hole = hash;
                probeDistance = 0;
            }
            else {
                final int otherHash = this.hash(this.keysArray[index - 1]);
                if ((otherHash - hash & this.getHashSize() - 1) < probeDistance) {
                    continue;
                }
                this.hashArray[hole] = index;
                this.presenceArray[index - 1] = hole;
                hole = hash;
                probeDistance = 0;
            }
        } while (--patchAttemptsLeft >= 0);
        this.hashArray[hole] = -1;
    }
    
    public final boolean containsEntry$kotlin_stdlib(@NotNull final Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        final int index = this.findKey(entry.getKey());
        if (index < 0) {
            return false;
        }
        final V[] valuesArray = this.valuesArray;
        Intrinsics.checkNotNull(valuesArray);
        return Intrinsics.areEqual(valuesArray[index], entry.getValue());
    }
    
    private final boolean contentEquals(final Map<?, ?> other) {
        return this.size() == other.size() && this.containsAllEntries$kotlin_stdlib(other.entrySet());
    }
    
    public final boolean containsAllEntries$kotlin_stdlib(@NotNull final Collection<?> m) {
        Intrinsics.checkNotNullParameter(m, "m");
        for (final Object entry : m) {
            try {
                if (entry == null || !this.containsEntry$kotlin_stdlib((Map.Entry<? extends K, ? extends V>)entry)) {
                    return false;
                }
                continue;
            }
            catch (ClassCastException e) {
                return false;
            }
            break;
        }
        return true;
    }
    
    private final boolean putEntry(final Map.Entry<? extends K, ? extends V> entry) {
        final int index = this.addKey$kotlin_stdlib(entry.getKey());
        final Object[] valuesArray = this.allocateValuesArray();
        if (index >= 0) {
            valuesArray[index] = entry.getValue();
            return true;
        }
        final Object oldValue = valuesArray[-index - 1];
        if (!Intrinsics.areEqual(entry.getValue(), oldValue)) {
            valuesArray[-index - 1] = entry.getValue();
            return true;
        }
        return false;
    }
    
    private final boolean putAllEntries(final Collection<? extends Map.Entry<? extends K, ? extends V>> from) {
        if (from.isEmpty()) {
            return false;
        }
        this.ensureExtraCapacity(from.size());
        final Iterator it = from.iterator();
        boolean updated = false;
        while (it.hasNext()) {
            if (this.putEntry(it.next())) {
                updated = true;
            }
        }
        return updated;
    }
    
    public final boolean removeEntry$kotlin_stdlib(@NotNull final Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        this.checkIsMutable$kotlin_stdlib();
        final int index = this.findKey(entry.getKey());
        if (index < 0) {
            return false;
        }
        final V[] valuesArray = this.valuesArray;
        Intrinsics.checkNotNull(valuesArray);
        if (!Intrinsics.areEqual(valuesArray[index], entry.getValue())) {
            return false;
        }
        this.removeKeyAt(index);
        return true;
    }
    
    public final boolean removeValue$kotlin_stdlib(final V element) {
        this.checkIsMutable$kotlin_stdlib();
        final int index = this.findValue(element);
        if (index < 0) {
            return false;
        }
        this.removeKeyAt(index);
        return true;
    }
    
    @NotNull
    public final KeysItr<K, V> keysIterator$kotlin_stdlib() {
        return new KeysItr<K, V>(this);
    }
    
    @NotNull
    public final ValuesItr<K, V> valuesIterator$kotlin_stdlib() {
        return new ValuesItr<K, V>(this);
    }
    
    @NotNull
    public final EntriesItr<K, V> entriesIterator$kotlin_stdlib() {
        return new EntriesItr<K, V>(this);
    }
    
    @Override
    public final /* bridge */ int size() {
        return this.getSize();
    }
    
    @Override
    public final /* bridge */ Set<K> keySet() {
        return this.getKeys();
    }
    
    @Override
    public final /* bridge */ Collection<V> values() {
        return this.getValues();
    }
    
    @Override
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return this.getEntries();
    }
    
    public static final /* synthetic */ int access$getLength$p(final MapBuilder $this) {
        return $this.length;
    }
    
    public static final /* synthetic */ int[] access$getPresenceArray$p(final MapBuilder $this) {
        return $this.presenceArray;
    }
    
    public static final /* synthetic */ Object[] access$getKeysArray$p(final MapBuilder $this) {
        return $this.keysArray;
    }
    
    public static final /* synthetic */ Object[] access$getValuesArray$p(final MapBuilder $this) {
        return $this.valuesArray;
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f" }, d2 = { "Lkotlin/collections/builders/MapBuilder$Companion;", "", "()V", "INITIAL_CAPACITY", "", "INITIAL_MAX_PROBE_DISTANCE", "MAGIC", "TOMBSTONE", "computeHashSize", "capacity", "computeShift", "hashSize", "kotlin-stdlib" })
    private static final class Companion
    {
        private final int computeHashSize(final int capacity) {
            return Integer.highestOneBit(RangesKt___RangesKt.coerceAtLeast(capacity, 1) * 3);
        }
        
        private final int computeShift(final int hashSize) {
            return Integer.numberOfLeadingZeros(hashSize) + 1;
        }
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\u0006\u0010\u0017\u001a\u00020\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018" }, d2 = { "Lkotlin/collections/builders/MapBuilder$Itr;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "index", "", "getIndex$kotlin_stdlib", "()I", "setIndex$kotlin_stdlib", "(I)V", "lastIndex", "getLastIndex$kotlin_stdlib", "setLastIndex$kotlin_stdlib", "getMap$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "hasNext", "", "initNext", "", "initNext$kotlin_stdlib", "remove", "kotlin-stdlib" })
    public static class Itr<K, V>
    {
        @NotNull
        private final MapBuilder<K, V> map;
        private int index;
        private int lastIndex;
        
        public Itr(@NotNull final MapBuilder<K, V> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
            this.lastIndex = -1;
            this.initNext$kotlin_stdlib();
        }
        
        @NotNull
        public final MapBuilder<K, V> getMap$kotlin_stdlib() {
            return this.map;
        }
        
        public final int getIndex$kotlin_stdlib() {
            return this.index;
        }
        
        public final void setIndex$kotlin_stdlib(final int <set-?>) {
            this.index = <set-?>;
        }
        
        public final int getLastIndex$kotlin_stdlib() {
            return this.lastIndex;
        }
        
        public final void setLastIndex$kotlin_stdlib(final int <set-?>) {
            this.lastIndex = <set-?>;
        }
        
        public final void initNext$kotlin_stdlib() {
            while (this.index < MapBuilder.access$getLength$p((MapBuilder<Object, Object>)this.map) && MapBuilder.access$getPresenceArray$p((MapBuilder<Object, Object>)this.map)[this.index] < 0) {
                ++this.index;
            }
        }
        
        public final boolean hasNext() {
            return this.index < MapBuilder.access$getLength$p((MapBuilder<Object, Object>)this.map);
        }
        
        public final void remove() {
            if (this.lastIndex == -1) {
                final int n = 0;
                throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
            }
            this.map.checkIsMutable$kotlin_stdlib();
            ((MapBuilder<Object, Object>)this.map).removeKeyAt(this.lastIndex);
            this.lastIndex = -1;
        }
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n" }, d2 = { "Lkotlin/collections/builders/MapBuilder$KeysItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib" })
    public static final class KeysItr<K, V> extends Itr<K, V> implements Iterator<K>, KMutableIterator
    {
        public KeysItr(@NotNull final MapBuilder<K, V> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            super(map);
        }
        
        @Override
        public K next() {
            if (this.getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(this.getMap$kotlin_stdlib())) {
                throw new NoSuchElementException();
            }
            final int index$kotlin_stdlib = this.getIndex$kotlin_stdlib();
            this.setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            this.setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            final Object result = MapBuilder.access$getKeysArray$p(this.getMap$kotlin_stdlib())[this.getLastIndex$kotlin_stdlib()];
            this.initNext$kotlin_stdlib();
            return (K)result;
        }
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n" }, d2 = { "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib" })
    public static final class ValuesItr<K, V> extends Itr<K, V> implements Iterator<V>, KMutableIterator
    {
        public ValuesItr(@NotNull final MapBuilder<K, V> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            super(map);
        }
        
        @Override
        public V next() {
            if (this.getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(this.getMap$kotlin_stdlib())) {
                throw new NoSuchElementException();
            }
            final int index$kotlin_stdlib = this.getIndex$kotlin_stdlib();
            this.setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            this.setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            final Object[] access$getValuesArray$p = MapBuilder.access$getValuesArray$p(this.getMap$kotlin_stdlib());
            Intrinsics.checkNotNull(access$getValuesArray$p);
            final Object result = access$getValuesArray$p[this.getLastIndex$kotlin_stdlib()];
            this.initNext$kotlin_stdlib();
            return (V)result;
        }
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00050\u0004B\u0019\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nH\u0096\u0002J\u0012\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fJ\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012¨\u0006\u0013" }, d2 = { "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "Lkotlin/collections/builders/MapBuilder$EntryRef;", "nextAppendString", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nextHashCode", "", "nextHashCode$kotlin_stdlib", "kotlin-stdlib" })
    public static final class EntriesItr<K, V> extends Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator
    {
        public EntriesItr(@NotNull final MapBuilder<K, V> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            super(map);
        }
        
        @NotNull
        @Override
        public EntryRef<K, V> next() {
            if (this.getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(this.getMap$kotlin_stdlib())) {
                throw new NoSuchElementException();
            }
            final int index$kotlin_stdlib = this.getIndex$kotlin_stdlib();
            this.setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            this.setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            final EntryRef result = new EntryRef((MapBuilder<K, V>)this.getMap$kotlin_stdlib(), this.getLastIndex$kotlin_stdlib());
            this.initNext$kotlin_stdlib();
            return (EntryRef<K, V>)result;
        }
        
        public final int nextHashCode$kotlin_stdlib() {
            if (this.getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(this.getMap$kotlin_stdlib())) {
                throw new NoSuchElementException();
            }
            final int index$kotlin_stdlib = this.getIndex$kotlin_stdlib();
            this.setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            this.setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            final Object o = MapBuilder.access$getKeysArray$p(this.getMap$kotlin_stdlib())[this.getLastIndex$kotlin_stdlib()];
            final int n = (o != null) ? o.hashCode() : 0;
            final Object[] access$getValuesArray$p = MapBuilder.access$getValuesArray$p(this.getMap$kotlin_stdlib());
            Intrinsics.checkNotNull(access$getValuesArray$p);
            final Object o2 = access$getValuesArray$p[this.getLastIndex$kotlin_stdlib()];
            final int result = n ^ ((o2 != null) ? o2.hashCode() : 0);
            this.initNext$kotlin_stdlib();
            return result;
        }
        
        public final void nextAppendString(@NotNull final StringBuilder sb) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            if (this.getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(this.getMap$kotlin_stdlib())) {
                throw new NoSuchElementException();
            }
            final int index$kotlin_stdlib = this.getIndex$kotlin_stdlib();
            this.setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            this.setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            final Object key = MapBuilder.access$getKeysArray$p(this.getMap$kotlin_stdlib())[this.getLastIndex$kotlin_stdlib()];
            if (Intrinsics.areEqual(key, this.getMap$kotlin_stdlib())) {
                sb.append("(this Map)");
            }
            else {
                sb.append(key);
            }
            sb.append('=');
            final Object[] access$getValuesArray$p = MapBuilder.access$getValuesArray$p(this.getMap$kotlin_stdlib());
            Intrinsics.checkNotNull(access$getValuesArray$p);
            final Object value = access$getValuesArray$p[this.getLastIndex$kotlin_stdlib()];
            if (Intrinsics.areEqual(value, this.getMap$kotlin_stdlib())) {
                sb.append("(this Map)");
            }
            else {
                sb.append(value);
            }
            this.initNext$kotlin_stdlib();
        }
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B!\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0015\u0010\u0013\u001a\u00028\u00032\u0006\u0010\u0014\u001a\u00028\u0003H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00028\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018" }, d2 = { "Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "index", "", "(Lkotlin/collections/builders/MapBuilder;I)V", "key", "getKey", "()Ljava/lang/Object;", "value", "getValue", "equals", "", "other", "", "hashCode", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "kotlin-stdlib" })
    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMutableMap.Entry
    {
        @NotNull
        private final MapBuilder<K, V> map;
        private final int index;
        
        public EntryRef(@NotNull final MapBuilder<K, V> map, final int index) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
            this.index = index;
        }
        
        @Override
        public K getKey() {
            return (K)MapBuilder.access$getKeysArray$p((MapBuilder<Object, Object>)this.map)[this.index];
        }
        
        @Override
        public V getValue() {
            final Object[] access$getValuesArray$p = MapBuilder.access$getValuesArray$p((MapBuilder<Object, Object>)this.map);
            Intrinsics.checkNotNull(access$getValuesArray$p);
            return (V)access$getValuesArray$p[this.index];
        }
        
        @Override
        public V setValue(final V newValue) {
            this.map.checkIsMutable$kotlin_stdlib();
            final Object[] valuesArray = ((MapBuilder<Object, Object>)this.map).allocateValuesArray();
            final Object oldValue = valuesArray[this.index];
            valuesArray[this.index] = newValue;
            return (V)oldValue;
        }
        
        @Override
        public boolean equals(@Nullable final Object other) {
            return other instanceof Map.Entry && Intrinsics.areEqual(((Map.Entry)other).getKey(), this.getKey()) && Intrinsics.areEqual(((Map.Entry)other).getValue(), this.getValue());
        }
        
        @Override
        public int hashCode() {
            final K key = this.getKey();
            final int n = (key != null) ? key.hashCode() : 0;
            final V value = this.getValue();
            return n ^ ((value != null) ? value.hashCode() : 0);
        }
        
        @NotNull
        @Override
        public String toString() {
            return new StringBuilder().append(this.getKey()).append('=').append(this.getValue()).toString();
        }
    }
}
