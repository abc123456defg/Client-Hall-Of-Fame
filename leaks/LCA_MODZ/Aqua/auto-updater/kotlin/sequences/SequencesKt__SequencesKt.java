// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.sequences;

import kotlin.internal.LowPriorityInOverloadResolution;
import org.jetbrains.annotations.Nullable;
import kotlin.random.Random;
import kotlin.TuplesKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\b\u00f8\u0001\u0000\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001ab\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\f2\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00050\u000eH\u0000\u001a&\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004\u001a<\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000e\u001a=\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u0001H\u00022\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000eH\u0007¢\u0006\u0002\u0010\u0014\u001a+\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0017\"\u0002H\u0002¢\u0006\u0002\u0010\u0018\u001a\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001aC\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00050\u000eH\u0002¢\u0006\u0002\b\u001c\u001a)\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001d0\u0001H\u0007¢\u0006\u0002\b\u001e\u001a\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a2\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0007\u001a!\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\b\u001a\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a&\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0007\u001a@\u0010%\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0'0&\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0&0\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006(" }, d2 = { "Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", "", "emptySequence", "flatMapIndexed", "R", "C", "source", "transform", "Lkotlin/Function2;", "", "Lkotlin/Function1;", "generateSequence", "", "nextFunction", "seedFunction", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "flatten$SequencesKt__SequencesKt", "", "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "shuffled", "random", "Lkotlin/random/Random;", "unzip", "Lkotlin/Pair;", "", "kotlin-stdlib" }, xs = "kotlin/sequences/SequencesKt")
class SequencesKt__SequencesKt extends SequencesKt__SequencesJVMKt
{
    @InlineOnly
    private static final <T> Sequence<T> Sequence(final Function0<? extends Iterator<? extends T>> iterator) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        return (Sequence<T>)new SequencesKt__SequencesKt$Sequence.SequencesKt__SequencesKt$Sequence$1((Function0)iterator);
    }
    
    @NotNull
    public static final <T> Sequence<T> asSequence(@NotNull final Iterator<? extends T> $this$asSequence) {
        Intrinsics.checkNotNullParameter($this$asSequence, "<this>");
        return constrainOnce((Sequence<? extends T>)new Sequence<T>($this$asSequence) {
            @NotNull
            @Override
            public Iterator<T> iterator() {
                final int n = 0;
                return (Iterator<T>)this.$this_asSequence$inlined;
            }
        });
    }
    
    @NotNull
    public static final <T> Sequence<T> sequenceOf(@NotNull final T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return (elements.length == 0) ? emptySequence() : ArraysKt___ArraysKt.asSequence(elements);
    }
    
    @NotNull
    public static final <T> Sequence<T> emptySequence() {
        return (Sequence<T>)EmptySequence.INSTANCE;
    }
    
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Sequence<T> orEmpty(final Sequence<? extends T> $this$orEmpty) {
        Sequence<T> emptySequence = (Sequence<T>)$this$orEmpty;
        if ($this$orEmpty == null) {
            emptySequence = emptySequence();
        }
        return emptySequence;
    }
    
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> Sequence<T> ifEmpty(@NotNull final Sequence<? extends T> $this$ifEmpty, @NotNull final Function0<? extends Sequence<? extends T>> defaultValue) {
        Intrinsics.checkNotNullParameter($this$ifEmpty, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return SequencesKt__SequenceBuilderKt.sequence((Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ?>)new SequencesKt__SequencesKt$ifEmpty.SequencesKt__SequencesKt$ifEmpty$1((Sequence)$this$ifEmpty, (Function0)defaultValue, (Continuation)null));
    }
    
    @NotNull
    public static final <T> Sequence<T> flatten(@NotNull final Sequence<? extends Sequence<? extends T>> $this$flatten) {
        Intrinsics.checkNotNullParameter($this$flatten, "<this>");
        return flatten$SequencesKt__SequencesKt((Sequence<?>)$this$flatten, (Function1<? super Object, ? extends Iterator<? extends T>>)SequencesKt__SequencesKt$flatten.SequencesKt__SequencesKt$flatten$1.INSTANCE);
    }
    
    @JvmName(name = "flattenSequenceOfIterable")
    @NotNull
    public static final <T> Sequence<T> flattenSequenceOfIterable(@NotNull final Sequence<? extends Iterable<? extends T>> $this$flatten) {
        Intrinsics.checkNotNullParameter($this$flatten, "<this>");
        return flatten$SequencesKt__SequencesKt((Sequence<?>)$this$flatten, (Function1<? super Object, ? extends Iterator<? extends T>>)SequencesKt__SequencesKt$flatten.SequencesKt__SequencesKt$flatten$2.INSTANCE);
    }
    
    private static final <T, R> Sequence<R> flatten$SequencesKt__SequencesKt(final Sequence<? extends T> $this$flatten, final Function1<? super T, ? extends Iterator<? extends R>> iterator) {
        if ($this$flatten instanceof TransformingSequence) {
            return ((TransformingSequence<Object, Object>)$this$flatten).flatten$kotlin_stdlib((Function1<? super Object, ? extends Iterator<? extends R>>)iterator);
        }
        return new FlatteningSequence<Object, Object, R>($this$flatten, (Function1<? super Object, ?>)SequencesKt__SequencesKt$flatten.SequencesKt__SequencesKt$flatten$3.INSTANCE, (Function1<? super Object, ? extends Iterator<? extends R>>)iterator);
    }
    
    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> unzip(@NotNull final Sequence<? extends Pair<? extends T, ? extends R>> $this$unzip) {
        Intrinsics.checkNotNullParameter($this$unzip, "<this>");
        final ArrayList listT = new ArrayList();
        final ArrayList listR = new ArrayList();
        for (final Pair pair : $this$unzip) {
            listT.add(pair.getFirst());
            listR.add(pair.getSecond());
        }
        return TuplesKt.to((List<T>)listT, (List<R>)listR);
    }
    
    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> Sequence<T> shuffled(@NotNull final Sequence<? extends T> $this$shuffled) {
        Intrinsics.checkNotNullParameter($this$shuffled, "<this>");
        return shuffled($this$shuffled, (Random)Random.Default);
    }
    
    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> Sequence<T> shuffled(@NotNull final Sequence<? extends T> $this$shuffled, @NotNull final Random random) {
        Intrinsics.checkNotNullParameter($this$shuffled, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        return SequencesKt__SequenceBuilderKt.sequence((Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ?>)new SequencesKt__SequencesKt$shuffled.SequencesKt__SequencesKt$shuffled$1((Sequence)$this$shuffled, random, (Continuation)null));
    }
    
    @NotNull
    public static final <T, C, R> Sequence<R> flatMapIndexed(@NotNull final Sequence<? extends T> source, @NotNull final Function2<? super Integer, ? super T, ? extends C> transform, @NotNull final Function1<? super C, ? extends Iterator<? extends R>> iterator) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        return SequencesKt__SequenceBuilderKt.sequence((Function2<? super SequenceScope<? super R>, ? super Continuation<? super Unit>, ?>)new SequencesKt__SequencesKt$flatMapIndexed.SequencesKt__SequencesKt$flatMapIndexed$1((Sequence)source, (Function2)transform, (Function1)iterator, (Continuation)null));
    }
    
    @NotNull
    public static final <T> Sequence<T> constrainOnce(@NotNull final Sequence<? extends T> $this$constrainOnce) {
        Intrinsics.checkNotNullParameter($this$constrainOnce, "<this>");
        return ($this$constrainOnce instanceof ConstrainedOnceSequence) ? $this$constrainOnce : ((ConstrainedOnceSequence<T>)new ConstrainedOnceSequence<T>($this$constrainOnce));
    }
    
    @NotNull
    public static final <T> Sequence<T> generateSequence(@NotNull final Function0<? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return constrainOnce((Sequence<? extends T>)new GeneratorSequence<Object>(nextFunction, (Function1<? super Object, ?>)new SequencesKt__SequencesKt$generateSequence.SequencesKt__SequencesKt$generateSequence$1((Function0)nextFunction)));
    }
    
    @LowPriorityInOverloadResolution
    @NotNull
    public static final <T> Sequence<T> generateSequence(@Nullable final T seed, @NotNull final Function1<? super T, ? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return (Sequence<T>)((seed == null) ? ((EmptySequence)EmptySequence.INSTANCE) : ((GeneratorSequence)new GeneratorSequence<T>((Function0)new SequencesKt__SequencesKt$generateSequence.SequencesKt__SequencesKt$generateSequence$2((Object)seed), nextFunction)));
    }
    
    @NotNull
    public static final <T> Sequence<T> generateSequence(@NotNull final Function0<? extends T> seedFunction, @NotNull final Function1<? super T, ? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(seedFunction, "seedFunction");
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return new GeneratorSequence<T>(seedFunction, nextFunction);
    }
    
    public SequencesKt__SequencesKt() {
    }
}
