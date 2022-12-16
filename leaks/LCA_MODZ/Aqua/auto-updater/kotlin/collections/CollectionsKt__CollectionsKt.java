// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections;

import kotlin.PublishedApi;
import java.util.Comparator;
import kotlin.random.Random;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.IntRange;
import kotlin.ExperimentalStdlibApi;
import kotlin.WasExperimental;
import kotlin.BuilderInference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;
import kotlin.SinceKotlin;
import java.util.ArrayList;
import kotlin.internal.InlineOnly;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aC\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u00072\u0006\u0010\f\u001a\u00020\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u00070\u000eH\u0087\b\u00f8\u0001\u0000\u001aC\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u00072\u0006\u0010\f\u001a\u00020\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u00070\u000eH\u0087\b\u00f8\u0001\u0000\u001a\u001f\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u0002H\u00070\u0015j\b\u0012\u0004\u0012\u0002H\u0007`\u0016\"\u0004\b\u0000\u0010\u0007H\u0087\b\u001a5\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u0002H\u00070\u0015j\b\u0012\u0004\u0012\u0002H\u0007`\u0016\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010\u0019\u001aN\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u001f\b\u0001\u0010\u001d\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u0013\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\u0002\b\u001fH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001aF\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\b\"\u0004\b\u0000\u0010\u001b2\u001f\b\u0001\u0010\u001d\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u0013\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\u0002\b\u001fH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\u0012\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007\u001a\u0015\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007H\u0087\b\u001a+\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010\"\u001a%\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\b\b\u0000\u0010\u0007*\u00020$2\b\u0010%\u001a\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010&\u001a3\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\b\b\u0000\u0010\u0007*\u00020$2\u0016\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00070\u0018\"\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010\"\u001a\u0015\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u0007H\u0087\b\u001a+\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010\"\u001a%\u0010(\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0002\b+\u001a\b\u0010,\u001a\u00020\u001eH\u0001\u001a\b\u0010-\u001a\u00020\u001eH\u0001\u001a%\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018H\u0000¢\u0006\u0002\u0010/\u001aS\u00100\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b2\u0006\u0010%\u001a\u0002H\u00072\u001a\u00101\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000702j\n\u0012\u0006\b\u0000\u0012\u0002H\u0007`32\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u0006¢\u0006\u0002\u00104\u001a>\u00100\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b2\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u00062\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00060\u000e\u001aE\u00100\u001a\u00020\u0006\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u000706*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\b2\b\u0010%\u001a\u0004\u0018\u0001H\u00072\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u0006¢\u0006\u0002\u00107\u001ag\u00108\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\u000e\b\u0001\u00109*\b\u0012\u0004\u0012\u0002H906*\b\u0012\u0004\u0012\u0002H\u00070\b2\b\u0010:\u001a\u0004\u0018\u0001H92\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u00062\u0016\b\u0004\u0010;\u001a\u0010\u0012\u0004\u0012\u0002H\u0007\u0012\u0006\u0012\u0004\u0018\u0001H90\u000eH\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010<\u001a,\u0010=\u001a\u00020>\"\t\b\u0000\u0010\u0007¢\u0006\u0002\b?*\b\u0012\u0004\u0012\u0002H\u00070\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002H\u0087\b\u001a;\u0010@\u001a\u0002HA\"\u0010\b\u0000\u0010B*\u0006\u0012\u0002\b\u00030\u0002*\u0002HA\"\u0004\b\u0001\u0010A*\u0002HB2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002HA0DH\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010E\u001a\u0019\u0010F\u001a\u00020>\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0002H\u0087\b\u001a,\u0010G\u001a\u00020>\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\u001e\u0010H\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\bH\u0000\u001a!\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0002H\u0087\b\u001a!\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\bH\u0087\b\u001a&\u0010J\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070K2\u0006\u0010L\u001a\u00020MH\u0007\"\u0019\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"!\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006N" }, d2 = { "indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "lastIndex", "", "T", "", "getLastIndex", "(Ljava/util/List;)I", "List", "size", "init", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "MutableList", "", "arrayListOf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "elements", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "buildList", "E", "capacity", "builderAction", "", "Lkotlin/ExtensionFunctionType;", "emptyList", "listOf", "([Ljava/lang/Object;)Ljava/util/List;", "listOfNotNull", "", "element", "(Ljava/lang/Object;)Ljava/util/List;", "mutableListOf", "rangeCheck", "fromIndex", "toIndex", "rangeCheck$CollectionsKt__CollectionsKt", "throwCountOverflow", "throwIndexOverflow", "asCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "binarySearch", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "comparison", "", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "binarySearchBy", "K", "key", "selector", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "containsAll", "", "Lkotlin/internal/OnlyInputTypes;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "isNullOrEmpty", "optimizeReadOnlyList", "orEmpty", "shuffled", "", "random", "Lkotlin/random/Random;", "kotlin-stdlib" }, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt
{
    @NotNull
    public static final <T> Collection<T> asCollection(@NotNull final T[] $this$asCollection) {
        Intrinsics.checkNotNullParameter($this$asCollection, "<this>");
        return new ArrayAsCollection<T>($this$asCollection, false);
    }
    
    @NotNull
    public static final <T> List<T> emptyList() {
        return (List<T>)EmptyList.INSTANCE;
    }
    
    @NotNull
    public static final <T> List<T> listOf(@NotNull final T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (elements.length > 0) ? ArraysKt___ArraysJvmKt.asList(elements) : emptyList();
    }
    
    @InlineOnly
    private static final <T> List<T> listOf() {
        return (List<T>)emptyList();
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> mutableListOf() {
        return new ArrayList<T>();
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> ArrayList<T> arrayListOf() {
        return new ArrayList<T>();
    }
    
    @NotNull
    public static final <T> List<T> mutableListOf(@NotNull final T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (elements.length == 0) ? new ArrayList<T>() : new ArrayList<T>((Collection<? extends T>)new ArrayAsCollection<T>((T[])elements, true));
    }
    
    @NotNull
    public static final <T> ArrayList<T> arrayListOf(@NotNull final T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (elements.length == 0) ? new ArrayList<T>() : new ArrayList<T>((Collection<? extends T>)new ArrayAsCollection<T>((T[])elements, true));
    }
    
    @NotNull
    public static final <T> List<T> listOfNotNull(@Nullable final T element) {
        return (element != null) ? CollectionsKt__CollectionsJVMKt.listOf(element) : emptyList();
    }
    
    @NotNull
    public static final <T> List<T> listOfNotNull(@NotNull final T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt___ArraysKt.filterNotNull(elements);
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> List(final int size, final Function1<? super Integer, ? extends T> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        final ArrayList<T> list = new ArrayList<T>(size);
        for (int i = 0; i < size; ++i) {
            list.add((T)init.invoke(i));
        }
        return list;
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> MutableList(final int size, final Function1<? super Integer, ? extends T> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        final ArrayList list = new ArrayList(size);
        for (int i = 0; i < size; ++i) {
            final int index = i;
            final int n = 0;
            list.add(init.invoke(index));
        }
        return (List<T>)list;
    }
    
    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final <E> List<E> buildList(@BuilderInference final Function1<? super List<E>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        final List<E> listBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder();
        builderAction.invoke(listBuilder);
        return CollectionsKt__CollectionsJVMKt.build(listBuilder);
    }
    
    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final <E> List<E> buildList(final int capacity, @BuilderInference final Function1<? super List<E>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        final List<E> listBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder(capacity);
        builderAction.invoke(listBuilder);
        return CollectionsKt__CollectionsJVMKt.build(listBuilder);
    }
    
    @NotNull
    public static final IntRange getIndices(@NotNull final Collection<?> $this$indices) {
        Intrinsics.checkNotNullParameter($this$indices, "<this>");
        return new IntRange(0, $this$indices.size() - 1);
    }
    
    public static final <T> int getLastIndex(@NotNull final List<? extends T> $this$lastIndex) {
        Intrinsics.checkNotNullParameter($this$lastIndex, "<this>");
        return $this$lastIndex.size() - 1;
    }
    
    @InlineOnly
    private static final <T> boolean isNotEmpty(final Collection<? extends T> $this$isNotEmpty) {
        Intrinsics.checkNotNullParameter($this$isNotEmpty, "<this>");
        return !$this$isNotEmpty.isEmpty();
    }
    
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> boolean isNullOrEmpty(final Collection<? extends T> $this$isNullOrEmpty) {
        return $this$isNullOrEmpty == null || $this$isNullOrEmpty.isEmpty();
    }
    
    @InlineOnly
    private static final <T> Collection<T> orEmpty(final Collection<? extends T> $this$orEmpty) {
        Object o = $this$orEmpty;
        if ($this$orEmpty == null) {
            o = emptyList();
        }
        return (Collection<T>)o;
    }
    
    @InlineOnly
    private static final <T> List<T> orEmpty(final List<? extends T> $this$orEmpty) {
        List<T> emptyList = (List<T>)$this$orEmpty;
        if ($this$orEmpty == null) {
            emptyList = emptyList();
        }
        return emptyList;
    }
    
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <C extends java.util.Collection, R> R ifEmpty(final C $this$ifEmpty, final Function0<? extends R> defaultValue) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "defaultValue"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* $this$ifEmpty */
        //     7: invokeinterface java/util/Collection.isEmpty:()Z
        //    12: ifeq            24
        //    15: aload_1         /* defaultValue */
        //    16: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //    21: goto            25
        //    24: aload_0         /* $this$ifEmpty */
        //    25: areturn        
        //    Signature:
        //  <C::Ljava/util/Collection<*>;:TR;R:Ljava/lang/Object;>(TC;Lkotlin/jvm/functions/Function0<+TR;>;)TR;
        //    StackMapTable: 00 02 18 40 07 00 4F
        // 
        // The error that occurred was:
        // 
        // java.lang.StackOverflowError
        //     at com.strobel.assembler.metadata.CompoundTypeReference.getBaseType(CompoundTypeReference.java:34)
        //     at com.strobel.assembler.metadata.MetadataHelper$9.visitCompoundType(MetadataHelper.java:2103)
        //     at com.strobel.assembler.metadata.MetadataHelper$9.visitCompoundType(MetadataHelper.java:2075)
        //     at com.strobel.assembler.metadata.CompoundTypeReference.accept(CompoundTypeReference.java:97)
        //     at com.strobel.assembler.metadata.DefaultTypeVisitor.visit(DefaultTypeVisitor.java:25)
        //     at com.strobel.assembler.metadata.DefaultTypeVisitor.visit(DefaultTypeVisitor.java:21)
        //     at com.strobel.assembler.metadata.MetadataHelper.getSuperType(MetadataHelper.java:1264)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        //     at com.strobel.assembler.metadata.MetadataHelper.isSubType(MetadataHelper.java:1283)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @InlineOnly
    private static final <T> boolean containsAll(final Collection<? extends T> $this$containsAll, final Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$containsAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return $this$containsAll.containsAll(elements);
    }
    
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> List<T> shuffled(@NotNull final Iterable<? extends T> $this$shuffled, @NotNull final Random random) {
        Intrinsics.checkNotNullParameter($this$shuffled, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        final List $this$shuffled_u24lambda_u244;
        final List list = $this$shuffled_u24lambda_u244 = CollectionsKt___CollectionsKt.toMutableList((Iterable<?>)$this$shuffled);
        final int n = 0;
        CollectionsKt___CollectionsKt.shuffle((List<Object>)$this$shuffled_u24lambda_u244, random);
        return (List<T>)list;
    }
    
    @NotNull
    public static final <T> List<T> optimizeReadOnlyList(@NotNull final List<? extends T> $this$optimizeReadOnlyList) {
        Intrinsics.checkNotNullParameter($this$optimizeReadOnlyList, "<this>");
        Object o = null;
        switch ($this$optimizeReadOnlyList.size()) {
            case 0: {
                o = emptyList();
                break;
            }
            case 1: {
                o = CollectionsKt__CollectionsJVMKt.listOf($this$optimizeReadOnlyList.get(0));
                break;
            }
            default: {
                o = $this$optimizeReadOnlyList;
                break;
            }
        }
        return (List<T>)o;
    }
    
    public static final <T extends Comparable<? super T>> int binarySearch(@NotNull final List<? extends T> $this$binarySearch, @Nullable final T element, final int fromIndex, final int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch, "<this>");
        rangeCheck$CollectionsKt__CollectionsKt($this$binarySearch.size(), fromIndex, toIndex);
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            final int mid = low + high >>> 1;
            final Comparable midVal = (Comparable)$this$binarySearch.get(mid);
            final int cmp = ComparisonsKt__ComparisonsKt.compareValues((T)midVal, element);
            if (cmp < 0) {
                low = mid + 1;
            }
            else {
                if (cmp <= 0) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -(low + 1);
    }
    
    public static final <T> int binarySearch(@NotNull final List<? extends T> $this$binarySearch, final T element, @NotNull final Comparator<? super T> comparator, final int fromIndex, final int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        rangeCheck$CollectionsKt__CollectionsKt($this$binarySearch.size(), fromIndex, toIndex);
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            final int mid = low + high >>> 1;
            final Object midVal = $this$binarySearch.get(mid);
            final int cmp = comparator.compare((Object)midVal, (Object)element);
            if (cmp < 0) {
                low = mid + 1;
            }
            else {
                if (cmp <= 0) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -(low + 1);
    }
    
    public static final <T, K extends Comparable<? super K>> int binarySearchBy(@NotNull final List<? extends T> $this$binarySearchBy, @Nullable final K key, final int fromIndex, final int toIndex, @NotNull final Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter($this$binarySearchBy, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final int $i$f$binarySearchBy = 0;
        return binarySearch((List<?>)$this$binarySearchBy, fromIndex, toIndex, (Function1<? super Object, Integer>)new CollectionsKt__CollectionsKt$binarySearchBy.CollectionsKt__CollectionsKt$binarySearchBy$1((Function1)selector, (Comparable)key));
    }
    
    public static final <T> int binarySearch(@NotNull final List<? extends T> $this$binarySearch, final int fromIndex, final int toIndex, @NotNull final Function1<? super T, Integer> comparison) {
        Intrinsics.checkNotNullParameter($this$binarySearch, "<this>");
        Intrinsics.checkNotNullParameter(comparison, "comparison");
        rangeCheck$CollectionsKt__CollectionsKt($this$binarySearch.size(), fromIndex, toIndex);
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            final int mid = low + high >>> 1;
            final Object midVal = $this$binarySearch.get(mid);
            final int cmp = comparison.invoke((Object)midVal).intValue();
            if (cmp < 0) {
                low = mid + 1;
            }
            else {
                if (cmp <= 0) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -(low + 1);
    }
    
    private static final void rangeCheck$CollectionsKt__CollectionsKt(final int size, final int fromIndex, final int toIndex) {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex (" + fromIndex + ") is greater than toIndex (" + toIndex + ").");
        }
        if (fromIndex < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + fromIndex + ") is less than zero.");
        }
        if (toIndex > size) {
            throw new IndexOutOfBoundsException("toIndex (" + toIndex + ") is greater than size (" + size + ").");
        }
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.3")
    public static final void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.3")
    public static final void throwCountOverflow() {
        throw new ArithmeticException("Count overflow has happened.");
    }
    
    public CollectionsKt__CollectionsKt() {
    }
}
