// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.streams.jdk8;

import java.util.Spliterators;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Supplier;
import java.util.stream.StreamSupport;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;
import kotlin.SinceKotlin;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import java.util.stream.Stream;
import kotlin.jvm.JvmName;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005H\u0007\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\tH\u0007\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\t\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u0001H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f*\u00020\u0003H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f*\u00020\u0005H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f*\u00020\u0007H\u0007\u001a\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\tH\u0007¨\u0006\r" }, d2 = { "asSequence", "Lkotlin/sequences/Sequence;", "", "Ljava/util/stream/DoubleStream;", "", "Ljava/util/stream/IntStream;", "", "Ljava/util/stream/LongStream;", "T", "Ljava/util/stream/Stream;", "asStream", "toList", "", "kotlin-stdlib-jdk8" }, pn = "kotlin.streams")
@JvmName(name = "StreamsKt")
public final class StreamsKt
{
    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> Sequence<T> asSequence(@NotNull final Stream<T> $this$asSequence) {
        Intrinsics.checkNotNullParameter($this$asSequence, "<this>");
        return new Sequence<T>($this$asSequence) {
            @NotNull
            @Override
            public Iterator<T> iterator() {
                final int n = 0;
                final Iterator iterator = this.$this_asSequence$inlined.iterator();
                Intrinsics.checkNotNullExpressionValue(iterator, "iterator()");
                return (Iterator<T>)iterator;
            }
        };
    }
    
    @SinceKotlin(version = "1.2")
    @NotNull
    public static final Sequence<Integer> asSequence(@NotNull final IntStream $this$asSequence) {
        Intrinsics.checkNotNullParameter($this$asSequence, "<this>");
        return new Sequence<Integer>($this$asSequence) {
            @NotNull
            @Override
            public Iterator<Integer> iterator() {
                final int n = 0;
                final PrimitiveIterator.OfInt iterator = this.$this_asSequence$inlined.iterator();
                Intrinsics.checkNotNullExpressionValue(iterator, "iterator()");
                return iterator;
            }
        };
    }
    
    @SinceKotlin(version = "1.2")
    @NotNull
    public static final Sequence<Long> asSequence(@NotNull final LongStream $this$asSequence) {
        Intrinsics.checkNotNullParameter($this$asSequence, "<this>");
        return new Sequence<Long>($this$asSequence) {
            @NotNull
            @Override
            public Iterator<Long> iterator() {
                final int n = 0;
                final PrimitiveIterator.OfLong iterator = this.$this_asSequence$inlined.iterator();
                Intrinsics.checkNotNullExpressionValue(iterator, "iterator()");
                return iterator;
            }
        };
    }
    
    @SinceKotlin(version = "1.2")
    @NotNull
    public static final Sequence<Double> asSequence(@NotNull final DoubleStream $this$asSequence) {
        Intrinsics.checkNotNullParameter($this$asSequence, "<this>");
        return new Sequence<Double>($this$asSequence) {
            @NotNull
            @Override
            public Iterator<Double> iterator() {
                final int n = 0;
                final PrimitiveIterator.OfDouble iterator = this.$this_asSequence$inlined.iterator();
                Intrinsics.checkNotNullExpressionValue(iterator, "iterator()");
                return iterator;
            }
        };
    }
    
    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> Stream<T> asStream(@NotNull final Sequence<? extends T> $this$asStream) {
        Intrinsics.checkNotNullParameter($this$asStream, "<this>");
        final Stream<Object> stream = (Stream<Object>)StreamSupport.stream((Supplier<? extends Spliterator<T>>)StreamsKt::asStream$lambda$4, 16, false);
        Intrinsics.checkNotNullExpressionValue(stream, "stream({ Spliterators.sp\u2026literator.ORDERED, false)");
        return (Stream<T>)stream;
    }
    
    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> List<T> toList(@NotNull final Stream<T> $this$toList) {
        Intrinsics.checkNotNullParameter($this$toList, "<this>");
        final List<T> collect = $this$toList.collect((Collector<? super T, ?, List<T>>)Collectors.toList());
        Intrinsics.checkNotNullExpressionValue(collect, "collect(Collectors.toList<T>())");
        return collect;
    }
    
    @SinceKotlin(version = "1.2")
    @NotNull
    public static final List<Integer> toList(@NotNull final IntStream $this$toList) {
        Intrinsics.checkNotNullParameter($this$toList, "<this>");
        final int[] array = $this$toList.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "toArray()");
        return ArraysKt___ArraysJvmKt.asList(array);
    }
    
    @SinceKotlin(version = "1.2")
    @NotNull
    public static final List<Long> toList(@NotNull final LongStream $this$toList) {
        Intrinsics.checkNotNullParameter($this$toList, "<this>");
        final long[] array = $this$toList.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "toArray()");
        return ArraysKt___ArraysJvmKt.asList(array);
    }
    
    @SinceKotlin(version = "1.2")
    @NotNull
    public static final List<Double> toList(@NotNull final DoubleStream $this$toList) {
        Intrinsics.checkNotNullParameter($this$toList, "<this>");
        final double[] array = $this$toList.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "toArray()");
        return ArraysKt___ArraysJvmKt.asList(array);
    }
    
    private static final Spliterator asStream$lambda$4(final Sequence $this_asStream) {
        Intrinsics.checkNotNullParameter($this_asStream, "$this_asStream");
        return Spliterators.spliteratorUnknownSize((Iterator<?>)$this_asStream.iterator(), 16);
    }
}
