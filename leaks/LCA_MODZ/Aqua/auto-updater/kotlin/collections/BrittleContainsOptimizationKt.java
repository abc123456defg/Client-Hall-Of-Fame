// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections;

import kotlin.sequences.Sequence;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000 \n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0004\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0000\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0000\u001a,\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0000\u001a\u0018\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0002¨\u0006\u000b" }, d2 = { "convertToSetForSetOperation", "", "T", "", "([Ljava/lang/Object;)Ljava/util/Collection;", "", "Lkotlin/sequences/Sequence;", "convertToSetForSetOperationWith", "source", "safeToConvertToSet", "", "kotlin-stdlib" })
public final class BrittleContainsOptimizationKt
{
    private static final <T> boolean safeToConvertToSet(final Collection<? extends T> $this$safeToConvertToSet) {
        final int $i$f$brittleContainsOptimizationEnabled = 0;
        return CollectionSystemProperties.brittleContainsOptimizationEnabled && $this$safeToConvertToSet.size() > 2 && $this$safeToConvertToSet instanceof ArrayList;
    }
    
    @NotNull
    public static final <T> Collection<T> convertToSetForSetOperationWith(@NotNull final Iterable<? extends T> $this$convertToSetForSetOperationWith, @NotNull final Iterable<? extends T> source) {
        Intrinsics.checkNotNullParameter($this$convertToSetForSetOperationWith, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Object o;
        if ($this$convertToSetForSetOperationWith instanceof Set) {
            o = $this$convertToSetForSetOperationWith;
        }
        else if ($this$convertToSetForSetOperationWith instanceof Collection) {
            o = ((source instanceof Collection && ((Collection)source).size() < 2) ? ((Collection<? extends T>)$this$convertToSetForSetOperationWith) : (safeToConvertToSet((Collection<?>)$this$convertToSetForSetOperationWith) ? ((HashSet<Object>)CollectionsKt___CollectionsKt.toHashSet((Iterable<?>)$this$convertToSetForSetOperationWith)) : ((Collection<? extends T>)$this$convertToSetForSetOperationWith)));
        }
        else {
            final int $i$f$brittleContainsOptimizationEnabled = 0;
            o = (CollectionSystemProperties.brittleContainsOptimizationEnabled ? ((HashSet<Object>)CollectionsKt___CollectionsKt.toHashSet((Iterable<?>)$this$convertToSetForSetOperationWith)) : ((List<Object>)CollectionsKt___CollectionsKt.toList((Iterable<?>)$this$convertToSetForSetOperationWith)));
        }
        return (Collection<T>)o;
    }
    
    @NotNull
    public static final <T> Collection<T> convertToSetForSetOperation(@NotNull final Iterable<? extends T> $this$convertToSetForSetOperation) {
        Intrinsics.checkNotNullParameter($this$convertToSetForSetOperation, "<this>");
        Object o;
        if ($this$convertToSetForSetOperation instanceof Set) {
            o = $this$convertToSetForSetOperation;
        }
        else if ($this$convertToSetForSetOperation instanceof Collection) {
            o = (safeToConvertToSet((Collection<?>)$this$convertToSetForSetOperation) ? ((HashSet<Object>)CollectionsKt___CollectionsKt.toHashSet((Iterable<?>)$this$convertToSetForSetOperation)) : ((Collection<? extends T>)$this$convertToSetForSetOperation));
        }
        else {
            final int $i$f$brittleContainsOptimizationEnabled = 0;
            o = (CollectionSystemProperties.brittleContainsOptimizationEnabled ? ((HashSet<Object>)CollectionsKt___CollectionsKt.toHashSet((Iterable<?>)$this$convertToSetForSetOperation)) : ((List<Object>)CollectionsKt___CollectionsKt.toList((Iterable<?>)$this$convertToSetForSetOperation)));
        }
        return (Collection<T>)o;
    }
    
    @NotNull
    public static final <T> Collection<T> convertToSetForSetOperation(@NotNull final Sequence<? extends T> $this$convertToSetForSetOperation) {
        Intrinsics.checkNotNullParameter($this$convertToSetForSetOperation, "<this>");
        final int $i$f$brittleContainsOptimizationEnabled = 0;
        return (Collection<T>)(CollectionSystemProperties.brittleContainsOptimizationEnabled ? ((HashSet<Object>)SequencesKt___SequencesKt.toHashSet((Sequence<?>)$this$convertToSetForSetOperation)) : ((List<Object>)SequencesKt___SequencesKt.toList((Sequence<?>)$this$convertToSetForSetOperation)));
    }
    
    @NotNull
    public static final <T> Collection<T> convertToSetForSetOperation(@NotNull final T[] $this$convertToSetForSetOperation) {
        Intrinsics.checkNotNullParameter($this$convertToSetForSetOperation, "<this>");
        final int $i$f$brittleContainsOptimizationEnabled = 0;
        return (Collection<T>)(CollectionSystemProperties.brittleContainsOptimizationEnabled ? ((HashSet<T>)ArraysKt___ArraysKt.toHashSet($this$convertToSetForSetOperation)) : ((List<T>)ArraysKt___ArraysJvmKt.asList($this$convertToSetForSetOperation)));
    }
}
