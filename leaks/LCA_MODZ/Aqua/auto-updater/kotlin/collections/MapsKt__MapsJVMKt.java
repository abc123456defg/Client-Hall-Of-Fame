// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections;

import java.util.Properties;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.SortedMap;
import kotlin.jvm.functions.Function0;
import java.util.concurrent.ConcurrentMap;
import kotlin.collections.builders.MapBuilder;
import kotlin.internal.InlineOnly;
import kotlin.SinceKotlin;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import java.util.Collections;
import kotlin.jvm.internal.Intrinsics;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import kotlin.Pair;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000d\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a4\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0007H\u0001\u001aQ\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\t\u001a\u00020\u00012#\u0010\n\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0007\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\rH\u0081\b\u00f8\u0001\u0000\u001aI\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052#\u0010\n\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0007\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\rH\u0081\b\u00f8\u0001\u0000\u001a \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0007\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005H\u0001\u001a(\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0007\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\t\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0001\u001a2\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0013\u001aa\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0015\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00040\u00172*\u0010\u0018\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00130\u0019\"\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0013H\u0007¢\u0006\u0002\u0010\u001a\u001aY\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0015\"\u000e\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u001b\"\u0004\b\u0001\u0010\u00052*\u0010\u0018\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00130\u0019\"\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0013¢\u0006\u0002\u0010\u001c\u001aC\u0010\u001d\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u001e2\u0006\u0010\u001f\u001a\u0002H\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00050!H\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\"\u001a\u0019\u0010#\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0\u0003H\u0087\b\u001a2\u0010&\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003H\u0000\u001a1\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003H\u0081\b\u001a:\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0015\"\u000e\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u001b\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\u001a@\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0015\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00040\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)" }, d2 = { "INT_MAX_POWER_OF_TWO", "", "build", "", "K", "V", "builder", "", "buildMapInternal", "capacity", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "createMapBuilder", "mapCapacity", "expectedSize", "mapOf", "pair", "Lkotlin/Pair;", "sortedMapOf", "Ljava/util/SortedMap;", "comparator", "Ljava/util/Comparator;", "pairs", "", "(Ljava/util/Comparator;[Lkotlin/Pair;)Ljava/util/SortedMap;", "", "([Lkotlin/Pair;)Ljava/util/SortedMap;", "getOrPut", "Ljava/util/concurrent/ConcurrentMap;", "key", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "toProperties", "Ljava/util/Properties;", "", "toSingletonMap", "toSingletonMapOrSelf", "toSortedMap", "kotlin-stdlib" }, xs = "kotlin/collections/MapsKt")
class MapsKt__MapsJVMKt extends MapsKt__MapWithDefaultKt
{
    private static final int INT_MAX_POWER_OF_TWO = 1073741824;
    
    @NotNull
    public static final <K, V> Map<K, V> mapOf(@NotNull final Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        final Map<? extends K, ? extends V> singletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        Intrinsics.checkNotNullExpressionValue(singletonMap, "singletonMap(pair.first, pair.second)");
        return (Map<K, V>)singletonMap;
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <K, V> Map<K, V> buildMapInternal(final Function1<? super Map<K, V>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        final Map<K, V> mapBuilder = createMapBuilder();
        builderAction.invoke(mapBuilder);
        return build(mapBuilder);
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <K, V> Map<K, V> buildMapInternal(final int capacity, final Function1<? super Map<K, V>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        final Map<K, V> mapBuilder = createMapBuilder(capacity);
        builderAction.invoke(mapBuilder);
        return build(mapBuilder);
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <K, V> Map<K, V> createMapBuilder() {
        return new MapBuilder<K, V>();
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <K, V> Map<K, V> createMapBuilder(final int capacity) {
        return new MapBuilder<K, V>(capacity);
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <K, V> Map<K, V> build(@NotNull final Map<K, V> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return ((MapBuilder<K, V>)builder).build();
    }
    
    public static final <K, V> V getOrPut(@NotNull final ConcurrentMap<K, V> $this$getOrPut, final K key, @NotNull final Function0<? extends V> defaultValue) {
        Intrinsics.checkNotNullParameter($this$getOrPut, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        final int $i$f$getOrPut = 0;
        Object o;
        if ((o = $this$getOrPut.get(key)) == null) {
            final Object default1 = defaultValue.invoke();
            final int n = 0;
            if ((o = $this$getOrPut.putIfAbsent((K)key, (V)default1)) == null) {
                o = default1;
            }
        }
        return (V)o;
    }
    
    @NotNull
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> toSortedMap(@NotNull final Map<? extends K, ? extends V> $this$toSortedMap) {
        Intrinsics.checkNotNullParameter($this$toSortedMap, "<this>");
        return new TreeMap<K, V>($this$toSortedMap);
    }
    
    @NotNull
    public static final <K, V> SortedMap<K, V> toSortedMap(@NotNull final Map<? extends K, ? extends V> $this$toSortedMap, @NotNull final Comparator<? super K> comparator) {
        Intrinsics.checkNotNullParameter($this$toSortedMap, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        final TreeMap $this$toSortedMap_u24lambda_u241;
        final TreeMap treeMap = $this$toSortedMap_u24lambda_u241 = new TreeMap((Comparator<? super K>)comparator);
        final int n = 0;
        $this$toSortedMap_u24lambda_u241.putAll($this$toSortedMap);
        return (TreeMap<K, V>)treeMap;
    }
    
    @NotNull
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> sortedMapOf(@NotNull final Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        final TreeMap $this$sortedMapOf_u24lambda_u242;
        final TreeMap treeMap = $this$sortedMapOf_u24lambda_u242 = new TreeMap();
        final int n = 0;
        MapsKt__MapsKt.putAll((Map<? super Object, ? super Object>)$this$sortedMapOf_u24lambda_u242, (Pair<?, ?>[])pairs);
        return (TreeMap<K, V>)treeMap;
    }
    
    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <K, V> SortedMap<K, V> sortedMapOf(@NotNull final Comparator<? super K> comparator, @NotNull final Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        final TreeMap $this$sortedMapOf_u24lambda_u243;
        final TreeMap treeMap = $this$sortedMapOf_u24lambda_u243 = new TreeMap((Comparator<? super K>)comparator);
        final int n = 0;
        MapsKt__MapsKt.putAll((Map<? super Object, ? super Object>)$this$sortedMapOf_u24lambda_u243, (Pair<?, ?>[])pairs);
        return (TreeMap<K, V>)treeMap;
    }
    
    @InlineOnly
    private static final Properties toProperties(final Map<String, String> $this$toProperties) {
        Intrinsics.checkNotNullParameter($this$toProperties, "<this>");
        final Properties $this$toProperties_u24lambda_u244 = new Properties();
        final int n = 0;
        $this$toProperties_u24lambda_u244.putAll($this$toProperties);
        return $this$toProperties_u24lambda_u244;
    }
    
    @InlineOnly
    private static final <K, V> Map<K, V> toSingletonMapOrSelf(final Map<K, ? extends V> $this$toSingletonMapOrSelf) {
        Intrinsics.checkNotNullParameter($this$toSingletonMapOrSelf, "<this>");
        return (Map<K, V>)toSingletonMap((Map<?, ?>)$this$toSingletonMapOrSelf);
    }
    
    @NotNull
    public static final <K, V> Map<K, V> toSingletonMap(@NotNull final Map<? extends K, ? extends V> $this$toSingletonMap) {
        Intrinsics.checkNotNullParameter($this$toSingletonMap, "<this>");
        final Map.Entry $this$toSingletonMap_u24lambda_u245 = (Map.Entry)$this$toSingletonMap.entrySet().iterator().next();
        final int n = 0;
        final Map<K, V> singletonMap = Collections.singletonMap($this$toSingletonMap_u24lambda_u245.getKey(), $this$toSingletonMap_u24lambda_u245.getValue());
        Intrinsics.checkNotNullExpressionValue(singletonMap, "with(entries.iterator().\u2026ingletonMap(key, value) }");
        return singletonMap;
    }
    
    @PublishedApi
    public static final int mapCapacity(final int expectedSize) {
        return (expectedSize < 0) ? expectedSize : ((expectedSize < 3) ? (expectedSize + 1) : ((expectedSize < 1073741824) ? ((int)(expectedSize / 0.75f + 1.0f)) : Integer.MAX_VALUE));
    }
    
    public MapsKt__MapsJVMKt() {
    }
}
