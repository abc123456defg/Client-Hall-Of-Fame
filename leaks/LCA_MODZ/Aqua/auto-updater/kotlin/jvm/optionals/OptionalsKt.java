// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm.optionals;

import kotlin.sequences.Sequence;
import java.util.Set;
import java.util.List;
import java.util.Collection;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import java.util.Optional;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0000\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0004H\u0007\u001a4\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006\"\n\b\u0001\u0010\u0002*\u0004\b\u0002H\u0006*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0007\u001a\u0002H\u0006H\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010\b\u001a>\u0010\t\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006\"\n\b\u0001\u0010\u0002*\u0004\b\u0002H\u0006*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a#\u0010\f\u001a\u0004\u0018\u0001H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007¢\u0006\u0002\u0010\r\u001a;\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0010\b\u0001\u0010\u000f*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0011\u001a\u0002H\u000fH\u0007¢\u0006\u0002\u0010\u0012\u001a$\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0014\"\b\b\u0000\u0010\u0002*\u00020\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0004H\u0007\u001a$\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0016\"\b\b\u0000\u0010\u0002*\u00020\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0004H\u0007\u0082\u0002\u000b\n\u0002\b9\n\u0005\b\u009920\u0001¨\u0006\u0017" }, d2 = { "asSequence", "Lkotlin/sequences/Sequence;", "T", "", "Ljava/util/Optional;", "getOrDefault", "R", "defaultValue", "(Ljava/util/Optional;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Ljava/util/Optional;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrNull", "(Ljava/util/Optional;)Ljava/lang/Object;", "toCollection", "C", "", "destination", "(Ljava/util/Optional;Ljava/util/Collection;)Ljava/util/Collection;", "toList", "", "toSet", "", "kotlin-stdlib-jdk8" })
public final class OptionalsKt
{
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @Nullable
    public static final <T> T getOrNull(@NotNull final Optional<T> $this$getOrNull) {
        Intrinsics.checkNotNullParameter($this$getOrNull, "<this>");
        return $this$getOrNull.orElse(null);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    public static final <R, T extends R> R getOrDefault(@NotNull final Optional<T> $this$getOrDefault, final R defaultValue) {
        Intrinsics.checkNotNullParameter($this$getOrDefault, "<this>");
        return $this$getOrDefault.isPresent() ? $this$getOrDefault.get() : defaultValue;
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    public static final <R, T extends R> R getOrElse(@NotNull final Optional<T> $this$getOrElse, @NotNull final Function0<? extends R> defaultValue) {
        Intrinsics.checkNotNullParameter($this$getOrElse, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        final int $i$f$getOrElse = 0;
        return $this$getOrElse.isPresent() ? $this$getOrElse.get() : defaultValue.invoke();
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @NotNull
    public static final <T, C extends Collection<? super T>> C toCollection(@NotNull final Optional<T> $this$toCollection, @NotNull final C destination) {
        Intrinsics.checkNotNullParameter($this$toCollection, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if ($this$toCollection.isPresent()) {
            final T value = $this$toCollection.get();
            Intrinsics.checkNotNullExpressionValue(value, "get()");
            destination.add((Object)value);
        }
        return destination;
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @NotNull
    public static final <T> List<T> toList(@NotNull final Optional<? extends T> $this$toList) {
        Intrinsics.checkNotNullParameter($this$toList, "<this>");
        return (List<T>)($this$toList.isPresent() ? CollectionsKt__CollectionsJVMKt.listOf($this$toList.get()) : CollectionsKt__CollectionsKt.emptyList());
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @NotNull
    public static final <T> Set<T> toSet(@NotNull final Optional<? extends T> $this$toSet) {
        Intrinsics.checkNotNullParameter($this$toSet, "<this>");
        return (Set<T>)($this$toSet.isPresent() ? SetsKt__SetsJVMKt.setOf($this$toSet.get()) : SetsKt__SetsKt.emptySet());
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @NotNull
    public static final <T> Sequence<T> asSequence(@NotNull final Optional<? extends T> $this$asSequence) {
        Intrinsics.checkNotNullParameter($this$asSequence, "<this>");
        return $this$asSequence.isPresent() ? SequencesKt__SequencesKt.sequenceOf($this$asSequence.get()) : SequencesKt__SequencesKt.emptySequence();
    }
}
