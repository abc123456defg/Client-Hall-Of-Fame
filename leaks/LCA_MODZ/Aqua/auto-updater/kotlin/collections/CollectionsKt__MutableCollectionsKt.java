// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections;

import kotlin.ranges.IntRange;
import java.util.RandomAccess;
import org.jetbrains.annotations.Nullable;
import kotlin.ExperimentalStdlibApi;
import kotlin.WasExperimental;
import kotlin.SinceKotlin;
import java.util.NoSuchElementException;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Deprecated;
import kotlin.jvm.functions.Function1;
import java.util.List;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import kotlin.sequences.Sequence;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.Intrinsics;
import java.util.Collection;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000R\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\t\u001a-\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a9\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u000e\u001a9\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u000e\u001a(\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u0006\u0010\u0012\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\u0013\u001a.\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\n¢\u0006\u0002\u0010\u0014\u001a)\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0087\n\u001a)\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\n\u001a(\u0010\u0015\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u0006\u0010\u0012\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\u0013\u001a.\u0010\u0015\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\n¢\u0006\u0002\u0010\u0014\u001a)\u0010\u0015\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0087\n\u001a)\u0010\u0015\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\n\u001a-\u0010\u0016\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0017*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\u0012\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0018\u001a&\u0010\u0016\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0087\b¢\u0006\u0002\u0010\u001b\u001a-\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a.\u0010\u001c\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0017*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001dH\u0087\b\u001a*\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f\u001a*\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f\u001a\u001d\u0010\u001e\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0007¢\u0006\u0002\u0010\u001f\u001a\u001f\u0010 \u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0007¢\u0006\u0002\u0010\u001f\u001a\u001d\u0010!\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0007¢\u0006\u0002\u0010\u001f\u001a\u001f\u0010\"\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\u0007¢\u0006\u0002\u0010\u001f\u001a-\u0010#\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010#\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010#\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a.\u0010#\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0017*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001dH\u0087\b\u001a*\u0010#\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f\u001a*\u0010#\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f\u001a\u0015\u0010$\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0002\b%¨\u0006&" }, d2 = { "addAll", "", "T", "", "elements", "", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "", "Lkotlin/sequences/Sequence;", "filterInPlace", "", "predicate", "Lkotlin/Function1;", "predicateResultToRemove", "filterInPlace$CollectionsKt__MutableCollectionsKt", "", "minusAssign", "", "element", "(Ljava/util/Collection;Ljava/lang/Object;)V", "(Ljava/util/Collection;[Ljava/lang/Object;)V", "plusAssign", "remove", "Lkotlin/internal/OnlyInputTypes;", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "index", "", "(Ljava/util/List;I)Ljava/lang/Object;", "removeAll", "", "removeFirst", "(Ljava/util/List;)Ljava/lang/Object;", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "retainNothing", "retainNothing$CollectionsKt__MutableCollectionsKt", "kotlin-stdlib" }, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__MutableCollectionsKt extends CollectionsKt__MutableCollectionsJVMKt
{
    @InlineOnly
    private static final <T> boolean remove(final Collection<? extends T> $this$remove, final T element) {
        Intrinsics.checkNotNullParameter($this$remove, "<this>");
        return TypeIntrinsics.asMutableCollection($this$remove).remove(element);
    }
    
    @InlineOnly
    private static final <T> boolean removeAll(final Collection<? extends T> $this$removeAll, final Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$removeAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return TypeIntrinsics.asMutableCollection($this$removeAll).removeAll(elements);
    }
    
    @InlineOnly
    private static final <T> boolean retainAll(final Collection<? extends T> $this$retainAll, final Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$retainAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return TypeIntrinsics.asMutableCollection($this$retainAll).retainAll(elements);
    }
    
    @InlineOnly
    private static final <T> void plusAssign(final Collection<? super T> $this$plusAssign, final T element) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        $this$plusAssign.add(element);
    }
    
    @InlineOnly
    private static final <T> void plusAssign(final Collection<? super T> $this$plusAssign, final Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        addAll((Collection<? super Object>)$this$plusAssign, (Iterable<?>)elements);
    }
    
    @InlineOnly
    private static final <T> void plusAssign(final Collection<? super T> $this$plusAssign, final T[] elements) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        addAll($this$plusAssign, elements);
    }
    
    @InlineOnly
    private static final <T> void plusAssign(final Collection<? super T> $this$plusAssign, final Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        addAll((Collection<? super Object>)$this$plusAssign, (Sequence<?>)elements);
    }
    
    @InlineOnly
    private static final <T> void minusAssign(final Collection<? super T> $this$minusAssign, final T element) {
        Intrinsics.checkNotNullParameter($this$minusAssign, "<this>");
        $this$minusAssign.remove(element);
    }
    
    @InlineOnly
    private static final <T> void minusAssign(final Collection<? super T> $this$minusAssign, final Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$minusAssign, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        removeAll((Collection<? super Object>)$this$minusAssign, (Iterable<?>)elements);
    }
    
    @InlineOnly
    private static final <T> void minusAssign(final Collection<? super T> $this$minusAssign, final T[] elements) {
        Intrinsics.checkNotNullParameter($this$minusAssign, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        removeAll($this$minusAssign, elements);
    }
    
    @InlineOnly
    private static final <T> void minusAssign(final Collection<? super T> $this$minusAssign, final Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$minusAssign, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        removeAll((Collection<? super Object>)$this$minusAssign, (Sequence<?>)elements);
    }
    
    public static final <T> boolean addAll(@NotNull final Collection<? super T> $this$addAll, @NotNull final Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$addAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            return $this$addAll.addAll((Collection<? extends T>)elements);
        }
        boolean result = false;
        for (final Object item : elements) {
            if ($this$addAll.add((Object)item)) {
                result = true;
            }
        }
        return result;
    }
    
    public static final <T> boolean addAll(@NotNull final Collection<? super T> $this$addAll, @NotNull final Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$addAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean result = false;
        for (final Object item : elements) {
            if ($this$addAll.add((Object)item)) {
                result = true;
            }
        }
        return result;
    }
    
    public static final <T> boolean addAll(@NotNull final Collection<? super T> $this$addAll, @NotNull final T[] elements) {
        Intrinsics.checkNotNullParameter($this$addAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return $this$addAll.addAll((Collection<? extends T>)ArraysKt___ArraysJvmKt.asList(elements));
    }
    
    public static final <T> boolean removeAll(@NotNull final Collection<? super T> $this$removeAll, @NotNull final Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$removeAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return TypeIntrinsics.asMutableCollection($this$removeAll).removeAll(BrittleContainsOptimizationKt.convertToSetForSetOperationWith((Iterable<?>)elements, (Iterable<?>)$this$removeAll));
    }
    
    public static final <T> boolean removeAll(@NotNull final Collection<? super T> $this$removeAll, @NotNull final Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$removeAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        final Collection set = BrittleContainsOptimizationKt.convertToSetForSetOperation((Sequence<?>)elements);
        return !set.isEmpty() && $this$removeAll.removeAll(set);
    }
    
    public static final <T> boolean removeAll(@NotNull final Collection<? super T> $this$removeAll, @NotNull final T[] elements) {
        Intrinsics.checkNotNullParameter($this$removeAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length != 0 && $this$removeAll.removeAll(BrittleContainsOptimizationKt.convertToSetForSetOperation((Object[])elements));
    }
    
    public static final <T> boolean retainAll(@NotNull final Collection<? super T> $this$retainAll, @NotNull final Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$retainAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return TypeIntrinsics.asMutableCollection($this$retainAll).retainAll(BrittleContainsOptimizationKt.convertToSetForSetOperationWith((Iterable<?>)elements, (Iterable<?>)$this$retainAll));
    }
    
    public static final <T> boolean retainAll(@NotNull final Collection<? super T> $this$retainAll, @NotNull final T[] elements) {
        Intrinsics.checkNotNullParameter($this$retainAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.length != 0) {
            return $this$retainAll.retainAll(BrittleContainsOptimizationKt.convertToSetForSetOperation((Object[])elements));
        }
        return retainNothing$CollectionsKt__MutableCollectionsKt($this$retainAll);
    }
    
    public static final <T> boolean retainAll(@NotNull final Collection<? super T> $this$retainAll, @NotNull final Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$retainAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        final Collection set = BrittleContainsOptimizationKt.convertToSetForSetOperation((Sequence<?>)elements);
        if (!set.isEmpty()) {
            return $this$retainAll.retainAll(set);
        }
        return retainNothing$CollectionsKt__MutableCollectionsKt($this$retainAll);
    }
    
    private static final boolean retainNothing$CollectionsKt__MutableCollectionsKt(final Collection<?> $this$retainNothing) {
        final boolean result = !$this$retainNothing.isEmpty();
        $this$retainNothing.clear();
        return result;
    }
    
    public static final <T> boolean removeAll(@NotNull final Iterable<? extends T> $this$removeAll, @NotNull final Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$removeAll, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((Iterable<?>)$this$removeAll, (Function1<? super Object, Boolean>)predicate, true);
    }
    
    public static final <T> boolean retainAll(@NotNull final Iterable<? extends T> $this$retainAll, @NotNull final Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$retainAll, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((Iterable<?>)$this$retainAll, (Function1<? super Object, Boolean>)predicate, false);
    }
    
    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(final Iterable<? extends T> $this$filterInPlace, final Function1<? super T, Boolean> predicate, final boolean predicateResultToRemove) {
        boolean result = false;
        final Iterator $this$filterInPlace_u24lambda_u240 = $this$filterInPlace.iterator();
        final int n = 0;
        while ($this$filterInPlace_u24lambda_u240.hasNext()) {
            if (predicate.invoke($this$filterInPlace_u24lambda_u240.next()) == predicateResultToRemove) {
                $this$filterInPlace_u24lambda_u240.remove();
                result = true;
            }
        }
        return result;
    }
    
    @Deprecated(message = "Use removeAt(index) instead.", replaceWith = @ReplaceWith(expression = "removeAt(index)", imports = {}), level = DeprecationLevel.ERROR)
    @InlineOnly
    @java.lang.Deprecated
    private static final <T> T remove(final List<T> $this$remove, final int index) {
        Intrinsics.checkNotNullParameter($this$remove, "<this>");
        return $this$remove.remove(index);
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    public static final <T> T removeFirst(@NotNull final List<T> $this$removeFirst) {
        Intrinsics.checkNotNullParameter($this$removeFirst, "<this>");
        if ($this$removeFirst.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return $this$removeFirst.remove(0);
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @Nullable
    public static final <T> T removeFirstOrNull(@NotNull final List<T> $this$removeFirstOrNull) {
        Intrinsics.checkNotNullParameter($this$removeFirstOrNull, "<this>");
        return $this$removeFirstOrNull.isEmpty() ? null : $this$removeFirstOrNull.remove(0);
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    public static final <T> T removeLast(@NotNull final List<T> $this$removeLast) {
        Intrinsics.checkNotNullParameter($this$removeLast, "<this>");
        if ($this$removeLast.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return $this$removeLast.remove(CollectionsKt__CollectionsKt.getLastIndex((List<?>)$this$removeLast));
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @Nullable
    public static final <T> T removeLastOrNull(@NotNull final List<T> $this$removeLastOrNull) {
        Intrinsics.checkNotNullParameter($this$removeLastOrNull, "<this>");
        return $this$removeLastOrNull.isEmpty() ? null : $this$removeLastOrNull.remove(CollectionsKt__CollectionsKt.getLastIndex((List<?>)$this$removeLastOrNull));
    }
    
    public static final <T> boolean removeAll(@NotNull final List<T> $this$removeAll, @NotNull final Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$removeAll, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt($this$removeAll, predicate, true);
    }
    
    public static final <T> boolean retainAll(@NotNull final List<T> $this$retainAll, @NotNull final Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$retainAll, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt($this$retainAll, predicate, false);
    }
    
    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(final List<T> $this$filterInPlace, final Function1<? super T, Boolean> predicate, final boolean predicateResultToRemove) {
        if (!($this$filterInPlace instanceof RandomAccess)) {
            Intrinsics.checkNotNull($this$filterInPlace, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return filterInPlace$CollectionsKt__MutableCollectionsKt((Iterable<?>)TypeIntrinsics.asMutableIterable($this$filterInPlace), (Function1<? super Object, Boolean>)predicate, predicateResultToRemove);
        }
        int writeIndex = 0;
        final IntIterator iterator = new IntRange(0, CollectionsKt__CollectionsKt.getLastIndex((List<?>)$this$filterInPlace)).iterator();
        while (iterator.hasNext()) {
            final int readIndex = iterator.nextInt();
            final Object element = $this$filterInPlace.get(readIndex);
            if (predicate.invoke(element) == predicateResultToRemove) {
                continue;
            }
            if (writeIndex != readIndex) {
                $this$filterInPlace.set(writeIndex, (T)element);
            }
            ++writeIndex;
        }
        if (writeIndex < $this$filterInPlace.size()) {
            int removeIndex = CollectionsKt__CollectionsKt.getLastIndex((List<?>)$this$filterInPlace);
            final int n = writeIndex;
            if (n <= removeIndex) {
                while (true) {
                    $this$filterInPlace.remove(removeIndex);
                    if (removeIndex == n) {
                        break;
                    }
                    --removeIndex;
                }
            }
            return true;
        }
        return false;
    }
    
    public CollectionsKt__MutableCollectionsKt() {
    }
}
