// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections;

import java.util.Comparator;
import java.util.TreeSet;
import kotlin.collections.builders.SetBuilder;
import kotlin.internal.InlineOnly;
import kotlin.SinceKotlin;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import kotlin.jvm.internal.Intrinsics;
import java.util.Collections;
import java.util.Set;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000B\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0001\u001a?\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u001d\u0010\b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\u0081\b\u00f8\u0001\u0000\u001a7\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001d\u0010\b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\u0081\b\u00f8\u0001\u0000\u001a\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u0002H\u0001\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0001\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u0002H\u000e¢\u0006\u0002\u0010\u0010\u001a+\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0012\"\u0004\b\u0000\u0010\u000e2\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000e0\u0014\"\u0002H\u000e¢\u0006\u0002\u0010\u0015\u001aG\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0012\"\u0004\b\u0000\u0010\u000e2\u001a\u0010\u0016\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0\u0017j\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`\u00182\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000e0\u0014\"\u0002H\u000e¢\u0006\u0002\u0010\u0019\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001a" }, d2 = { "build", "", "E", "builder", "", "buildSetInternal", "capacity", "", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "createSetBuilder", "setOf", "T", "element", "(Ljava/lang/Object;)Ljava/util/Set;", "sortedSetOf", "Ljava/util/TreeSet;", "elements", "", "([Ljava/lang/Object;)Ljava/util/TreeSet;", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/Comparator;[Ljava/lang/Object;)Ljava/util/TreeSet;", "kotlin-stdlib" }, xs = "kotlin/collections/SetsKt")
class SetsKt__SetsJVMKt
{
    @NotNull
    public static final <T> Set<T> setOf(final T element) {
        final Set<T> singleton = Collections.singleton(element);
        Intrinsics.checkNotNullExpressionValue(singleton, "singleton(element)");
        return singleton;
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <E> Set<E> buildSetInternal(final Function1<? super Set<E>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        final Set<E> setBuilder = createSetBuilder();
        builderAction.invoke(setBuilder);
        return build(setBuilder);
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <E> Set<E> buildSetInternal(final int capacity, final Function1<? super Set<E>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        final Set<E> setBuilder = createSetBuilder(capacity);
        builderAction.invoke(setBuilder);
        return build(setBuilder);
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <E> Set<E> createSetBuilder() {
        return new SetBuilder<E>();
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <E> Set<E> createSetBuilder(final int capacity) {
        return new SetBuilder<E>(capacity);
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <E> Set<E> build(@NotNull final Set<E> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return ((SetBuilder<E>)builder).build();
    }
    
    @NotNull
    public static final <T> TreeSet<T> sortedSetOf(@NotNull final T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt___ArraysKt.toCollection(elements, new TreeSet<T>());
    }
    
    @NotNull
    public static final <T> TreeSet<T> sortedSetOf(@NotNull final Comparator<? super T> comparator, @NotNull final T... elements) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt___ArraysKt.toCollection(elements, new TreeSet<T>(comparator));
    }
    
    public SetsKt__SetsJVMKt() {
    }
}
