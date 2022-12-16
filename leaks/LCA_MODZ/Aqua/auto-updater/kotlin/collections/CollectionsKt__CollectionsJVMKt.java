// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections;

import kotlin.internal.PlatformImplementationsKt;
import java.util.Arrays;
import kotlin.jvm.internal.CollectionToArray;
import java.util.Collection;
import java.util.Random;
import java.util.ArrayList;
import java.util.Enumeration;
import kotlin.collections.builders.ListBuilder;
import kotlin.internal.InlineOnly;
import kotlin.SinceKotlin;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import kotlin.jvm.internal.Intrinsics;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000R\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\b\f\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\t\u0010\u0000\u001a\u00020\u0001H\u0080\b\u001a\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H\u0001\u001a?\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\b\u001a\u00020\t2\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0006\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\rH\u0081\b\u00f8\u0001\u0000\u001a7\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0006\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\rH\u0081\b\u00f8\u0001\u0000\u001a\u0011\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0081\b\u001a\u0011\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0081\b\u001a\"\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00132\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0081\b¢\u0006\u0002\u0010\u0017\u001a4\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0013\"\u0004\b\u0000\u0010\u00182\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0013H\u0081\b¢\u0006\u0002\u0010\u001a\u001a\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006\"\u0004\b\u0000\u0010\u0004H\u0001\u001a\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006\"\u0004\b\u0000\u0010\u00042\u0006\u0010\b\u001a\u00020\tH\u0001\u001a\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0003\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u001d\u001a\u0002H\u0018¢\u0006\u0002\u0010\u001e\u001a1\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u0013\"\u0004\b\u0000\u0010\u0018*\n\u0012\u0006\b\u0001\u0012\u0002H\u00180\u00132\u0006\u0010 \u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010!\u001a\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0003\"\u0004\b\u0000\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00180#H\u0007\u001a&\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0003\"\u0004\b\u0000\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00180#2\u0006\u0010$\u001a\u00020%H\u0007\u001a\u001f\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0003\"\u0004\b\u0000\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00180'H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006(" }, d2 = { "brittleContainsOptimizationEnabled", "", "build", "", "E", "builder", "", "buildListInternal", "capacity", "", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "checkCountOverflow", "count", "checkIndexOverflow", "index", "copyToArrayImpl", "", "", "collection", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", "T", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "createListBuilder", "listOf", "element", "(Ljava/lang/Object;)Ljava/util/List;", "copyToArrayOfAny", "isVarargs", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "shuffled", "", "random", "Ljava/util/Random;", "toList", "Ljava/util/Enumeration;", "kotlin-stdlib" }, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__CollectionsJVMKt
{
    @NotNull
    public static final <T> List<T> listOf(final T element) {
        final List<T> singletonList = Collections.singletonList(element);
        Intrinsics.checkNotNullExpressionValue(singletonList, "singletonList(element)");
        return singletonList;
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <E> List<E> buildListInternal(final Function1<? super List<E>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        final List<E> listBuilder = createListBuilder();
        builderAction.invoke(listBuilder);
        return build(listBuilder);
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <E> List<E> buildListInternal(final int capacity, final Function1<? super List<E>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        final List<E> listBuilder = createListBuilder(capacity);
        builderAction.invoke(listBuilder);
        return build(listBuilder);
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <E> List<E> createListBuilder() {
        return new ListBuilder<E>();
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <E> List<E> createListBuilder(final int capacity) {
        return new ListBuilder<E>(capacity);
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <E> List<E> build(@NotNull final List<E> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return ((ListBuilder<E>)builder).build();
    }
    
    @InlineOnly
    private static final <T> List<T> toList(final Enumeration<T> $this$toList) {
        Intrinsics.checkNotNullParameter($this$toList, "<this>");
        final ArrayList<T> list = Collections.list($this$toList);
        Intrinsics.checkNotNullExpressionValue(list, "list(this)");
        return list;
    }
    
    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> List<T> shuffled(@NotNull final Iterable<? extends T> $this$shuffled) {
        Intrinsics.checkNotNullParameter($this$shuffled, "<this>");
        final List $this$shuffled_u24lambda_u240;
        final List list = $this$shuffled_u24lambda_u240 = CollectionsKt___CollectionsKt.toMutableList((Iterable<?>)$this$shuffled);
        final int n = 0;
        Collections.shuffle($this$shuffled_u24lambda_u240);
        return (List<T>)list;
    }
    
    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> List<T> shuffled(@NotNull final Iterable<? extends T> $this$shuffled, @NotNull final Random random) {
        Intrinsics.checkNotNullParameter($this$shuffled, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        final List $this$shuffled_u24lambda_u241;
        final List list = $this$shuffled_u24lambda_u241 = CollectionsKt___CollectionsKt.toMutableList((Iterable<?>)$this$shuffled);
        final int n = 0;
        Collections.shuffle($this$shuffled_u24lambda_u241, random);
        return (List<T>)list;
    }
    
    @InlineOnly
    private static final Object[] copyToArrayImpl(final Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        return CollectionToArray.toArray(collection);
    }
    
    @InlineOnly
    private static final <T> T[] copyToArrayImpl(final Collection<?> collection, final T[] array) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        Intrinsics.checkNotNullParameter(array, "array");
        final Object[] array2 = CollectionToArray.toArray(collection, array);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.CollectionsKt__CollectionsJVMKt.copyToArrayImpl>");
        return (T[])array2;
    }
    
    @NotNull
    public static final <T> Object[] copyToArrayOfAny(@NotNull final T[] $this$copyToArrayOfAny, final boolean isVarargs) {
        Intrinsics.checkNotNullParameter($this$copyToArrayOfAny, "<this>");
        Object[] copy;
        if (isVarargs && Intrinsics.areEqual($this$copyToArrayOfAny.getClass(), Object[].class)) {
            copy = $this$copyToArrayOfAny;
        }
        else {
            Intrinsics.checkNotNullExpressionValue(copy = Arrays.copyOf($this$copyToArrayOfAny, $this$copyToArrayOfAny.length, (Class<? extends Object[]>)Object[].class), "copyOf(this, this.size, Array<Any?>::class.java)");
        }
        return copy;
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final int checkIndexOverflow(final int index) {
        if (index < 0) {
            if (!PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            CollectionsKt.throwIndexOverflow();
        }
        return index;
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final int checkCountOverflow(final int count) {
        if (count < 0) {
            if (!PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                throw new ArithmeticException("Count overflow has happened.");
            }
            CollectionsKt.throwCountOverflow();
        }
        return count;
    }
    
    public static final boolean brittleContainsOptimizationEnabled() {
        final int $i$f$brittleContainsOptimizationEnabled = 0;
        return CollectionSystemProperties.brittleContainsOptimizationEnabled;
    }
    
    public CollectionsKt__CollectionsJVMKt() {
    }
}
