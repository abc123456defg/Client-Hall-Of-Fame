// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function2;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.SinceKotlin;
import java.util.Map;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000@\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u009e\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052b\u0010\u0006\u001a^\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\b\u00f8\u0001\u0000\u001a·\u0001\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u00102b\u0010\u0006\u001a^\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aI\u0010\u0014\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0016\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00150\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u0010H\u0007¢\u0006\u0002\u0010\u0016\u001a¿\u0001\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u000526\u0010\u0018\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u00192K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u001aH\u0087\b\u00f8\u0001\u0000\u001a\u007f\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u001b\u001a\u0002H\u000326\u0010\u0006\u001a2\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u0019H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u00d8\u0001\u0010\u001d\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u001026\u0010\u0018\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u00192K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u001aH\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a\u0093\u0001\u0010\u001d\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u00102\u0006\u0010\u001b\u001a\u0002H\u000326\u0010\u0006\u001a2\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u0019H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u001f\u001a\u008b\u0001\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0\u0001\"\u0004\b\u0000\u0010!\"\b\b\u0001\u0010\u0004*\u0002H!\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H!¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H!0\u001aH\u0087\b\u00f8\u0001\u0000\u001a¤\u0001\u0010\"\u001a\u0002H\u0010\"\u0004\b\u0000\u0010!\"\b\b\u0001\u0010\u0004*\u0002H!\"\u0004\b\u0002\u0010\u0002\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u00102K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H!¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H!0\u001aH\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010#\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$" }, d2 = { "aggregate", "", "K", "R", "T", "Lkotlin/collections/Grouping;", "operation", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "key", "accumulator", "element", "", "first", "aggregateTo", "M", "", "destination", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function4;)Ljava/util/Map;", "eachCountTo", "", "(Lkotlin/collections/Grouping;Ljava/util/Map;)Ljava/util/Map;", "fold", "initialValueSelector", "Lkotlin/Function2;", "Lkotlin/Function3;", "initialValue", "(Lkotlin/collections/Grouping;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "foldTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "(Lkotlin/collections/Grouping;Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "reduce", "S", "reduceTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "kotlin-stdlib" }, xs = "kotlin/collections/GroupingKt")
class GroupingKt__GroupingKt extends GroupingKt__GroupingJVMKt
{
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R> Map<K, R> aggregate(@NotNull final Grouping<T, ? extends K> $this$aggregate, @NotNull final Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> operation) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* operation */
        //     7: ldc             "operation"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: iconst_0       
        //    13: istore_2        /* $i$f$aggregate */
        //    14: aload_0         /* $this$aggregate */
        //    15: astore_3       
        //    16: new             Ljava/util/LinkedHashMap;
        //    19: dup            
        //    20: invokespecial   java/util/LinkedHashMap.<init>:()V
        //    23: checkcast       Ljava/util/Map;
        //    26: astore          4
        //    28: nop            
        //    29: iconst_0       
        //    30: istore          $i$f$aggregateTo
        //    32: aload_3         /* $this$aggregateTo$iv */
        //    33: invokeinterface kotlin/collections/Grouping.sourceIterator:()Ljava/util/Iterator;
        //    38: astore          6
        //    40: aload           6
        //    42: invokeinterface java/util/Iterator.hasNext:()Z
        //    47: ifeq            130
        //    50: aload           6
        //    52: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    57: astore          e$iv
        //    59: aload_3         /* $this$aggregateTo$iv */
        //    60: aload           e$iv
        //    62: invokeinterface kotlin/collections/Grouping.keyOf:(Ljava/lang/Object;)Ljava/lang/Object;
        //    67: astore          key$iv
        //    69: aload           destination$iv
        //    71: aload           key$iv
        //    73: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    78: astore          accumulator$iv
        //    80: aload           destination$iv
        //    82: aload           key$iv
        //    84: aload_1         /* operation */
        //    85: aload           key$iv
        //    87: aload           accumulator$iv
        //    89: aload           e$iv
        //    91: aload           accumulator$iv
        //    93: ifnonnull       112
        //    96: aload           destination$iv
        //    98: aload           key$iv
        //   100: invokeinterface java/util/Map.containsKey:(Ljava/lang/Object;)Z
        //   105: ifne            112
        //   108: iconst_1       
        //   109: goto            113
        //   112: iconst_0       
        //   113: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //   116: invokeinterface kotlin/jvm/functions/Function4.invoke:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   121: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   126: pop            
        //   127: goto            40
        //   130: aload           destination$iv
        //   132: areturn        
        //    Signature:
        //  <T:Ljava/lang/Object;K:Ljava/lang/Object;R:Ljava/lang/Object;>(Lkotlin/collections/Grouping<TT;+TK;>;Lkotlin/jvm/functions/Function4<-TK;-TR;-TT;-Ljava/lang/Boolean;+TR;>;)Ljava/util/Map<TK;TR;>;
        //    StackMapTable: 00 04 FF 00 28 00 07 07 00 1F 07 00 40 01 07 00 1F 07 00 1D 01 07 00 25 00 00 FF 00 47 00 0A 07 00 1F 07 00 40 01 07 00 1F 07 00 1D 01 07 00 25 07 00 57 07 00 57 07 00 57 00 06 07 00 1D 07 00 57 07 00 40 07 00 57 07 00 57 07 00 57 FF 00 00 00 0A 07 00 1F 07 00 40 01 07 00 1F 07 00 1D 01 07 00 25 07 00 57 07 00 57 07 00 57 00 07 07 00 1D 07 00 57 07 00 40 07 00 57 07 00 57 07 00 57 01 F8 00 10
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R, M extends Map<? super K, R>> M aggregateTo(@NotNull final Grouping<T, ? extends K> $this$aggregateTo, @NotNull final M destination, @NotNull final Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> operation) {
        Intrinsics.checkNotNullParameter($this$aggregateTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(operation, "operation");
        final int $i$f$aggregateTo = 0;
        final Iterator<T> sourceIterator = $this$aggregateTo.sourceIterator();
        while (sourceIterator.hasNext()) {
            final Object e = sourceIterator.next();
            final Object key = $this$aggregateTo.keyOf((T)e);
            final Object accumulator = ((Map<K, Object>)destination).get(key);
            destination.put((Object)key, (R)operation.invoke((Object)key, (Object)accumulator, (Object)e, Boolean.valueOf(accumulator == null && !destination.containsKey(key))));
        }
        return destination;
    }
    
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R> Map<K, R> fold(@NotNull final Grouping<T, ? extends K> $this$fold, @NotNull final Function2<? super K, ? super T, ? extends R> initialValueSelector, @NotNull final Function3<? super K, ? super R, ? super T, ? extends R> operation) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* initialValueSelector */
        //     7: ldc             "initialValueSelector"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: aload_2         /* operation */
        //    13: ldc             "operation"
        //    15: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    18: iconst_0       
        //    19: istore_3        /* $i$f$fold */
        //    20: aload_0         /* $this$fold */
        //    21: astore          $this$aggregate$iv
        //    23: iconst_0       
        //    24: istore          $i$f$aggregate
        //    26: aload           $this$aggregate$iv
        //    28: astore          6
        //    30: new             Ljava/util/LinkedHashMap;
        //    33: dup            
        //    34: invokespecial   java/util/LinkedHashMap.<init>:()V
        //    37: checkcast       Ljava/util/Map;
        //    40: astore          7
        //    42: nop            
        //    43: iconst_0       
        //    44: istore          $i$f$aggregateTo
        //    46: aload           $this$aggregateTo$iv$iv
        //    48: invokeinterface kotlin/collections/Grouping.sourceIterator:()Ljava/util/Iterator;
        //    53: astore          9
        //    55: aload           9
        //    57: invokeinterface java/util/Iterator.hasNext:()Z
        //    62: ifeq            190
        //    65: aload           9
        //    67: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    72: astore          e$iv$iv
        //    74: aload           $this$aggregateTo$iv$iv
        //    76: aload           e$iv$iv
        //    78: invokeinterface kotlin/collections/Grouping.keyOf:(Ljava/lang/Object;)Ljava/lang/Object;
        //    83: astore          key$iv$iv
        //    85: aload           destination$iv$iv
        //    87: aload           key$iv$iv
        //    89: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    94: astore          accumulator$iv$iv
        //    96: aload           destination$iv$iv
        //    98: aload           key$iv$iv
        //   100: aload           key$iv$iv
        //   102: aload           accumulator$iv$iv
        //   104: aload           e$iv$iv
        //   106: aload           accumulator$iv$iv
        //   108: ifnonnull       127
        //   111: aload           destination$iv$iv
        //   113: aload           key$iv$iv
        //   115: invokeinterface java/util/Map.containsKey:(Ljava/lang/Object;)Z
        //   120: ifne            127
        //   123: iconst_1       
        //   124: goto            128
        //   127: iconst_0       
        //   128: istore          13
        //   130: astore          14
        //   132: astore          15
        //   134: astore          16
        //   136: astore          19
        //   138: astore          18
        //   140: iconst_0       
        //   141: istore          $i$a$-aggregate-GroupingKt__GroupingKt$fold$1
        //   143: aload_2         /* operation */
        //   144: aload           key
        //   146: iload           first
        //   148: ifeq            164
        //   151: aload_1         /* initialValueSelector */
        //   152: aload           key
        //   154: aload           e
        //   156: invokeinterface kotlin/jvm/functions/Function2.invoke:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   161: goto            166
        //   164: aload           acc
        //   166: aload           e
        //   168: invokeinterface kotlin/jvm/functions/Function3.invoke:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   173: astore          20
        //   175: aload           18
        //   177: aload           19
        //   179: aload           20
        //   181: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   186: pop            
        //   187: goto            55
        //   190: aload           destination$iv$iv
        //   192: nop            
        //   193: areturn        
        //    Signature:
        //  <T:Ljava/lang/Object;K:Ljava/lang/Object;R:Ljava/lang/Object;>(Lkotlin/collections/Grouping<TT;+TK;>;Lkotlin/jvm/functions/Function2<-TK;-TT;+TR;>;Lkotlin/jvm/functions/Function3<-TK;-TR;-TT;+TR;>;)Ljava/util/Map<TK;TR;>;
        //    StackMapTable: 00 06 FF 00 37 00 0A 07 00 1F 07 00 67 07 00 6B 01 07 00 1F 01 07 00 1F 07 00 1D 01 07 00 25 00 00 FF 00 47 00 0D 07 00 1F 07 00 67 07 00 6B 01 07 00 1F 01 07 00 1F 07 00 1D 01 07 00 25 07 00 57 07 00 57 07 00 57 00 05 07 00 1D 07 00 57 07 00 57 07 00 57 07 00 57 FF 00 00 00 0D 07 00 1F 07 00 67 07 00 6B 01 07 00 1F 01 07 00 1F 07 00 1D 01 07 00 25 07 00 57 07 00 57 07 00 57 00 06 07 00 1D 07 00 57 07 00 57 07 00 57 07 00 57 01 FF 00 23 00 14 07 00 1F 07 00 67 07 00 6B 01 07 00 1F 01 07 00 1F 07 00 1D 01 07 00 25 07 00 57 07 00 57 07 00 57 01 07 00 57 07 00 57 07 00 57 01 07 00 1D 07 00 57 00 02 07 00 6B 07 00 57 FF 00 01 00 14 07 00 1F 07 00 67 07 00 6B 01 07 00 1F 01 07 00 1F 07 00 1D 01 07 00 25 07 00 57 07 00 57 07 00 57 01 07 00 57 07 00 57 07 00 57 01 07 00 1D 07 00 57 00 03 07 00 6B 07 00 57 07 00 57 FF 00 17 00 0A 07 00 1F 07 00 67 07 00 6B 01 07 00 1F 01 07 00 1F 07 00 1D 01 07 00 25 00 00
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R, M extends Map<? super K, R>> M foldTo(@NotNull final Grouping<T, ? extends K> $this$foldTo, @NotNull final M destination, @NotNull final Function2<? super K, ? super T, ? extends R> initialValueSelector, @NotNull final Function3<? super K, ? super R, ? super T, ? extends R> operation) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* destination */
        //     7: ldc             "destination"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: aload_2         /* initialValueSelector */
        //    13: ldc             "initialValueSelector"
        //    15: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    18: aload_3         /* operation */
        //    19: ldc             "operation"
        //    21: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    24: iconst_0       
        //    25: istore          $i$f$foldTo
        //    27: aload_0         /* $this$foldTo */
        //    28: astore          $this$aggregateTo$iv
        //    30: iconst_0       
        //    31: istore          $i$f$aggregateTo
        //    33: aload           $this$aggregateTo$iv
        //    35: invokeinterface kotlin/collections/Grouping.sourceIterator:()Ljava/util/Iterator;
        //    40: astore          7
        //    42: aload           7
        //    44: invokeinterface java/util/Iterator.hasNext:()Z
        //    49: ifeq            174
        //    52: aload           7
        //    54: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    59: astore          e$iv
        //    61: aload           $this$aggregateTo$iv
        //    63: aload           e$iv
        //    65: invokeinterface kotlin/collections/Grouping.keyOf:(Ljava/lang/Object;)Ljava/lang/Object;
        //    70: astore          key$iv
        //    72: aload_1         /* destination */
        //    73: aload           key$iv
        //    75: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    80: astore          accumulator$iv
        //    82: aload_1         /* destination */
        //    83: aload           key$iv
        //    85: aload           key$iv
        //    87: aload           accumulator$iv
        //    89: aload           e$iv
        //    91: aload           accumulator$iv
        //    93: ifnonnull       111
        //    96: aload_1         /* destination */
        //    97: aload           key$iv
        //    99: invokeinterface java/util/Map.containsKey:(Ljava/lang/Object;)Z
        //   104: ifne            111
        //   107: iconst_1       
        //   108: goto            112
        //   111: iconst_0       
        //   112: istore          11
        //   114: astore          12
        //   116: astore          13
        //   118: astore          14
        //   120: astore          17
        //   122: astore          16
        //   124: iconst_0       
        //   125: istore          $i$a$-aggregateTo-GroupingKt__GroupingKt$foldTo$1
        //   127: aload_3         /* operation */
        //   128: aload           key
        //   130: iload           first
        //   132: ifeq            148
        //   135: aload_2         /* initialValueSelector */
        //   136: aload           key
        //   138: aload           e
        //   140: invokeinterface kotlin/jvm/functions/Function2.invoke:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   145: goto            150
        //   148: aload           acc
        //   150: aload           e
        //   152: invokeinterface kotlin/jvm/functions/Function3.invoke:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   157: astore          18
        //   159: aload           16
        //   161: aload           17
        //   163: aload           18
        //   165: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   170: pop            
        //   171: goto            42
        //   174: aload_1         /* destination */
        //   175: areturn        
        //    Signature:
        //  <T:Ljava/lang/Object;K:Ljava/lang/Object;R:Ljava/lang/Object;M::Ljava/util/Map<-TK;TR;>;>(Lkotlin/collections/Grouping<TT;+TK;>;TM;Lkotlin/jvm/functions/Function2<-TK;-TT;+TR;>;Lkotlin/jvm/functions/Function3<-TK;-TR;-TT;+TR;>;)TM;
        //    StackMapTable: 00 06 FF 00 2A 00 08 07 00 1F 07 00 1D 07 00 67 07 00 6B 01 07 00 1F 01 07 00 25 00 00 FF 00 44 00 0B 07 00 1F 07 00 1D 07 00 67 07 00 6B 01 07 00 1F 01 07 00 25 07 00 57 07 00 57 07 00 57 00 05 07 00 1D 07 00 57 07 00 57 07 00 57 07 00 57 FF 00 00 00 0B 07 00 1F 07 00 1D 07 00 67 07 00 6B 01 07 00 1F 01 07 00 25 07 00 57 07 00 57 07 00 57 00 06 07 00 1D 07 00 57 07 00 57 07 00 57 07 00 57 01 FF 00 23 00 12 07 00 1F 07 00 1D 07 00 67 07 00 6B 01 07 00 1F 01 07 00 25 07 00 57 07 00 57 07 00 57 01 07 00 57 07 00 57 07 00 57 01 07 00 1D 07 00 57 00 02 07 00 6B 07 00 57 FF 00 01 00 12 07 00 1F 07 00 1D 07 00 67 07 00 6B 01 07 00 1F 01 07 00 25 07 00 57 07 00 57 07 00 57 01 07 00 57 07 00 57 07 00 57 01 07 00 1D 07 00 57 00 03 07 00 6B 07 00 57 07 00 57 FF 00 17 00 08 07 00 1F 07 00 1D 07 00 67 07 00 6B 01 07 00 1F 01 07 00 25 00 00
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R> Map<K, R> fold(@NotNull final Grouping<T, ? extends K> $this$fold, final R initialValue, @NotNull final Function2<? super R, ? super T, ? extends R> operation) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_2         /* operation */
        //     7: ldc             "operation"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: iconst_0       
        //    13: istore_3        /* $i$f$fold */
        //    14: aload_0         /* $this$fold */
        //    15: astore          $this$aggregate$iv
        //    17: iconst_0       
        //    18: istore          $i$f$aggregate
        //    20: aload           $this$aggregate$iv
        //    22: astore          6
        //    24: new             Ljava/util/LinkedHashMap;
        //    27: dup            
        //    28: invokespecial   java/util/LinkedHashMap.<init>:()V
        //    31: checkcast       Ljava/util/Map;
        //    34: astore          7
        //    36: nop            
        //    37: iconst_0       
        //    38: istore          $i$f$aggregateTo
        //    40: aload           $this$aggregateTo$iv$iv
        //    42: invokeinterface kotlin/collections/Grouping.sourceIterator:()Ljava/util/Iterator;
        //    47: astore          9
        //    49: aload           9
        //    51: invokeinterface java/util/Iterator.hasNext:()Z
        //    56: ifeq            169
        //    59: aload           9
        //    61: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    66: astore          e$iv$iv
        //    68: aload           $this$aggregateTo$iv$iv
        //    70: aload           e$iv$iv
        //    72: invokeinterface kotlin/collections/Grouping.keyOf:(Ljava/lang/Object;)Ljava/lang/Object;
        //    77: astore          key$iv$iv
        //    79: aload           destination$iv$iv
        //    81: aload           key$iv$iv
        //    83: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    88: astore          accumulator$iv$iv
        //    90: aload           destination$iv$iv
        //    92: aload           key$iv$iv
        //    94: aload           accumulator$iv$iv
        //    96: aload           e$iv$iv
        //    98: aload           accumulator$iv$iv
        //   100: ifnonnull       119
        //   103: aload           destination$iv$iv
        //   105: aload           key$iv$iv
        //   107: invokeinterface java/util/Map.containsKey:(Ljava/lang/Object;)Z
        //   112: ifne            119
        //   115: iconst_1       
        //   116: goto            120
        //   119: iconst_0       
        //   120: istore          13
        //   122: astore          14
        //   124: astore          15
        //   126: astore          18
        //   128: astore          17
        //   130: iconst_0       
        //   131: istore          $i$a$-aggregate-GroupingKt__GroupingKt$fold$2
        //   133: aload_2         /* operation */
        //   134: iload           first
        //   136: ifeq            143
        //   139: aload_1         /* initialValue */
        //   140: goto            145
        //   143: aload           acc
        //   145: aload           e
        //   147: invokeinterface kotlin/jvm/functions/Function2.invoke:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   152: astore          19
        //   154: aload           17
        //   156: aload           18
        //   158: aload           19
        //   160: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   165: pop            
        //   166: goto            49
        //   169: aload           destination$iv$iv
        //   171: nop            
        //   172: areturn        
        //    Signature:
        //  <T:Ljava/lang/Object;K:Ljava/lang/Object;R:Ljava/lang/Object;>(Lkotlin/collections/Grouping<TT;+TK;>;TR;Lkotlin/jvm/functions/Function2<-TR;-TT;+TR;>;)Ljava/util/Map<TK;TR;>;
        //    StackMapTable: 00 06 FF 00 31 00 0A 07 00 1F 07 00 57 07 00 67 01 07 00 1F 01 07 00 1F 07 00 1D 01 07 00 25 00 00 FF 00 45 00 0D 07 00 1F 07 00 57 07 00 67 01 07 00 1F 01 07 00 1F 07 00 1D 01 07 00 25 07 00 57 07 00 57 07 00 57 00 04 07 00 1D 07 00 57 07 00 57 07 00 57 FF 00 00 00 0D 07 00 1F 07 00 57 07 00 67 01 07 00 1F 01 07 00 1F 07 00 1D 01 07 00 25 07 00 57 07 00 57 07 00 57 00 05 07 00 1D 07 00 57 07 00 57 07 00 57 01 FF 00 16 00 13 07 00 1F 07 00 57 07 00 67 01 07 00 1F 01 07 00 1F 07 00 1D 01 07 00 25 07 00 57 07 00 57 07 00 57 01 07 00 57 07 00 57 01 07 00 1D 07 00 57 00 01 07 00 67 FF 00 01 00 13 07 00 1F 07 00 57 07 00 67 01 07 00 1F 01 07 00 1F 07 00 1D 01 07 00 25 07 00 57 07 00 57 07 00 57 01 07 00 57 07 00 57 01 07 00 1D 07 00 57 00 02 07 00 67 07 00 57 FF 00 17 00 0A 07 00 1F 07 00 57 07 00 67 01 07 00 1F 01 07 00 1F 07 00 1D 01 07 00 25 00 00
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R, M extends Map<? super K, R>> M foldTo(@NotNull final Grouping<T, ? extends K> $this$foldTo, @NotNull final M destination, final R initialValue, @NotNull final Function2<? super R, ? super T, ? extends R> operation) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* destination */
        //     7: ldc             "destination"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: aload_3         /* operation */
        //    13: ldc             "operation"
        //    15: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    18: iconst_0       
        //    19: istore          $i$f$foldTo
        //    21: aload_0         /* $this$foldTo */
        //    22: astore          $this$aggregateTo$iv
        //    24: iconst_0       
        //    25: istore          $i$f$aggregateTo
        //    27: aload           $this$aggregateTo$iv
        //    29: invokeinterface kotlin/collections/Grouping.sourceIterator:()Ljava/util/Iterator;
        //    34: astore          7
        //    36: aload           7
        //    38: invokeinterface java/util/Iterator.hasNext:()Z
        //    43: ifeq            153
        //    46: aload           7
        //    48: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    53: astore          e$iv
        //    55: aload           $this$aggregateTo$iv
        //    57: aload           e$iv
        //    59: invokeinterface kotlin/collections/Grouping.keyOf:(Ljava/lang/Object;)Ljava/lang/Object;
        //    64: astore          key$iv
        //    66: aload_1         /* destination */
        //    67: aload           key$iv
        //    69: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    74: astore          accumulator$iv
        //    76: aload_1         /* destination */
        //    77: aload           key$iv
        //    79: aload           accumulator$iv
        //    81: aload           e$iv
        //    83: aload           accumulator$iv
        //    85: ifnonnull       103
        //    88: aload_1         /* destination */
        //    89: aload           key$iv
        //    91: invokeinterface java/util/Map.containsKey:(Ljava/lang/Object;)Z
        //    96: ifne            103
        //    99: iconst_1       
        //   100: goto            104
        //   103: iconst_0       
        //   104: istore          11
        //   106: astore          12
        //   108: astore          13
        //   110: astore          16
        //   112: astore          15
        //   114: iconst_0       
        //   115: istore          $i$a$-aggregateTo-GroupingKt__GroupingKt$foldTo$2
        //   117: aload_3         /* operation */
        //   118: iload           first
        //   120: ifeq            127
        //   123: aload_2         /* initialValue */
        //   124: goto            129
        //   127: aload           acc
        //   129: aload           e
        //   131: invokeinterface kotlin/jvm/functions/Function2.invoke:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   136: astore          17
        //   138: aload           15
        //   140: aload           16
        //   142: aload           17
        //   144: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   149: pop            
        //   150: goto            36
        //   153: aload_1         /* destination */
        //   154: areturn        
        //    Signature:
        //  <T:Ljava/lang/Object;K:Ljava/lang/Object;R:Ljava/lang/Object;M::Ljava/util/Map<-TK;TR;>;>(Lkotlin/collections/Grouping<TT;+TK;>;TM;TR;Lkotlin/jvm/functions/Function2<-TR;-TT;+TR;>;)TM;
        //    StackMapTable: 00 06 FF 00 24 00 08 07 00 1F 07 00 1D 07 00 57 07 00 67 01 07 00 1F 01 07 00 25 00 00 FF 00 42 00 0B 07 00 1F 07 00 1D 07 00 57 07 00 67 01 07 00 1F 01 07 00 25 07 00 57 07 00 57 07 00 57 00 04 07 00 1D 07 00 57 07 00 57 07 00 57 FF 00 00 00 0B 07 00 1F 07 00 1D 07 00 57 07 00 67 01 07 00 1F 01 07 00 25 07 00 57 07 00 57 07 00 57 00 05 07 00 1D 07 00 57 07 00 57 07 00 57 01 FF 00 16 00 11 07 00 1F 07 00 1D 07 00 57 07 00 67 01 07 00 1F 01 07 00 25 07 00 57 07 00 57 07 00 57 01 07 00 57 07 00 57 01 07 00 1D 07 00 57 00 01 07 00 67 FF 00 01 00 11 07 00 1F 07 00 1D 07 00 57 07 00 67 01 07 00 1F 01 07 00 25 07 00 57 07 00 57 07 00 57 01 07 00 57 07 00 57 01 07 00 1D 07 00 57 00 02 07 00 67 07 00 57 FF 00 17 00 08 07 00 1F 07 00 1D 07 00 57 07 00 67 01 07 00 1F 01 07 00 25 00 00
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <S, T extends S, K> Map<K, S> reduce(@NotNull final Grouping<T, ? extends K> $this$reduce, @NotNull final Function3<? super K, ? super S, ? super T, ? extends S> operation) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* operation */
        //     7: ldc             "operation"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: iconst_0       
        //    13: istore_2        /* $i$f$reduce */
        //    14: aload_0         /* $this$reduce */
        //    15: astore_3        /* $this$aggregate$iv */
        //    16: iconst_0       
        //    17: istore          $i$f$aggregate
        //    19: aload_3         /* $this$aggregate$iv */
        //    20: astore          5
        //    22: new             Ljava/util/LinkedHashMap;
        //    25: dup            
        //    26: invokespecial   java/util/LinkedHashMap.<init>:()V
        //    29: checkcast       Ljava/util/Map;
        //    32: astore          6
        //    34: nop            
        //    35: iconst_0       
        //    36: istore          $i$f$aggregateTo
        //    38: aload           $this$aggregateTo$iv$iv
        //    40: invokeinterface kotlin/collections/Grouping.sourceIterator:()Ljava/util/Iterator;
        //    45: astore          8
        //    47: aload           8
        //    49: invokeinterface java/util/Iterator.hasNext:()Z
        //    54: ifeq            174
        //    57: aload           8
        //    59: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    64: astore          e$iv$iv
        //    66: aload           $this$aggregateTo$iv$iv
        //    68: aload           e$iv$iv
        //    70: invokeinterface kotlin/collections/Grouping.keyOf:(Ljava/lang/Object;)Ljava/lang/Object;
        //    75: astore          key$iv$iv
        //    77: aload           destination$iv$iv
        //    79: aload           key$iv$iv
        //    81: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    86: astore          accumulator$iv$iv
        //    88: aload           destination$iv$iv
        //    90: aload           key$iv$iv
        //    92: aload           key$iv$iv
        //    94: aload           accumulator$iv$iv
        //    96: aload           e$iv$iv
        //    98: aload           accumulator$iv$iv
        //   100: ifnonnull       119
        //   103: aload           destination$iv$iv
        //   105: aload           key$iv$iv
        //   107: invokeinterface java/util/Map.containsKey:(Ljava/lang/Object;)Z
        //   112: ifne            119
        //   115: iconst_1       
        //   116: goto            120
        //   119: iconst_0       
        //   120: istore          12
        //   122: astore          13
        //   124: astore          14
        //   126: astore          15
        //   128: astore          18
        //   130: astore          17
        //   132: iconst_0       
        //   133: istore          $i$a$-aggregate-GroupingKt__GroupingKt$reduce$1
        //   135: iload           first
        //   137: ifeq            145
        //   140: aload           e
        //   142: goto            157
        //   145: aload_1         /* operation */
        //   146: aload           key
        //   148: aload           acc
        //   150: aload           e
        //   152: invokeinterface kotlin/jvm/functions/Function3.invoke:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   157: astore          19
        //   159: aload           17
        //   161: aload           18
        //   163: aload           19
        //   165: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   170: pop            
        //   171: goto            47
        //   174: aload           destination$iv$iv
        //   176: nop            
        //   177: areturn        
        //    Signature:
        //  <S:Ljava/lang/Object;T:TS;K:Ljava/lang/Object;>(Lkotlin/collections/Grouping<TT;+TK;>;Lkotlin/jvm/functions/Function3<-TK;-TS;-TT;+TS;>;)Ljava/util/Map<TK;TS;>; [from metadata: <S:Ljava/lang/Object;T::TS;K:Ljava/lang/Object;>(Lkotlin/collections/Grouping<TT;+TK;>;Lkotlin/jvm/functions/Function3<-TK;-TS;-TT;+TS;>;)Ljava/util/Map<TK;TS;>;]
        //  
        //    StackMapTable: 00 06 FF 00 2F 00 09 07 00 1F 07 00 6B 01 07 00 1F 01 07 00 1F 07 00 1D 01 07 00 25 00 00 FF 00 47 00 0C 07 00 1F 07 00 6B 01 07 00 1F 01 07 00 1F 07 00 1D 01 07 00 25 07 00 57 07 00 57 07 00 57 00 05 07 00 1D 07 00 57 07 00 57 07 00 57 07 00 57 FF 00 00 00 0C 07 00 1F 07 00 6B 01 07 00 1F 01 07 00 1F 07 00 1D 01 07 00 25 07 00 57 07 00 57 07 00 57 00 06 07 00 1D 07 00 57 07 00 57 07 00 57 07 00 57 01 FF 00 18 00 13 07 00 1F 07 00 6B 01 07 00 1F 01 07 00 1F 07 00 1D 01 07 00 25 07 00 57 07 00 57 07 00 57 01 07 00 57 07 00 57 07 00 57 01 07 00 1D 07 00 57 00 00 4B 07 00 57 FF 00 10 00 09 07 00 1F 07 00 6B 01 07 00 1F 01 07 00 1F 07 00 1D 01 07 00 25 00 00
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <S, T extends S, K, M extends Map<? super K, S>> M reduceTo(@NotNull final Grouping<T, ? extends K> $this$reduceTo, @NotNull final M destination, @NotNull final Function3<? super K, ? super S, ? super T, ? extends S> operation) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* destination */
        //     7: ldc             "destination"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: aload_2         /* operation */
        //    13: ldc             "operation"
        //    15: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    18: iconst_0       
        //    19: istore_3        /* $i$f$reduceTo */
        //    20: aload_0         /* $this$reduceTo */
        //    21: astore          $this$aggregateTo$iv
        //    23: iconst_0       
        //    24: istore          $i$f$aggregateTo
        //    26: aload           $this$aggregateTo$iv
        //    28: invokeinterface kotlin/collections/Grouping.sourceIterator:()Ljava/util/Iterator;
        //    33: astore          6
        //    35: aload           6
        //    37: invokeinterface java/util/Iterator.hasNext:()Z
        //    42: ifeq            159
        //    45: aload           6
        //    47: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    52: astore          e$iv
        //    54: aload           $this$aggregateTo$iv
        //    56: aload           e$iv
        //    58: invokeinterface kotlin/collections/Grouping.keyOf:(Ljava/lang/Object;)Ljava/lang/Object;
        //    63: astore          key$iv
        //    65: aload_1         /* destination */
        //    66: aload           key$iv
        //    68: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    73: astore          accumulator$iv
        //    75: aload_1         /* destination */
        //    76: aload           key$iv
        //    78: aload           key$iv
        //    80: aload           accumulator$iv
        //    82: aload           e$iv
        //    84: aload           accumulator$iv
        //    86: ifnonnull       104
        //    89: aload_1         /* destination */
        //    90: aload           key$iv
        //    92: invokeinterface java/util/Map.containsKey:(Ljava/lang/Object;)Z
        //    97: ifne            104
        //   100: iconst_1       
        //   101: goto            105
        //   104: iconst_0       
        //   105: istore          10
        //   107: astore          11
        //   109: astore          12
        //   111: astore          13
        //   113: astore          16
        //   115: astore          15
        //   117: iconst_0       
        //   118: istore          $i$a$-aggregateTo-GroupingKt__GroupingKt$reduceTo$1
        //   120: iload           first
        //   122: ifeq            130
        //   125: aload           e
        //   127: goto            142
        //   130: aload_2         /* operation */
        //   131: aload           key
        //   133: aload           acc
        //   135: aload           e
        //   137: invokeinterface kotlin/jvm/functions/Function3.invoke:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   142: astore          17
        //   144: aload           15
        //   146: aload           16
        //   148: aload           17
        //   150: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   155: pop            
        //   156: goto            35
        //   159: aload_1         /* destination */
        //   160: areturn        
        //    Signature:
        //  <S:Ljava/lang/Object;T:TS;K:Ljava/lang/Object;M::Ljava/util/Map<-TK;TS;>;>(Lkotlin/collections/Grouping<TT;+TK;>;TM;Lkotlin/jvm/functions/Function3<-TK;-TS;-TT;+TS;>;)TM; [from metadata: <S:Ljava/lang/Object;T::TS;K:Ljava/lang/Object;M::Ljava/util/Map<-TK;TS;>;>(Lkotlin/collections/Grouping<TT;+TK;>;TM;Lkotlin/jvm/functions/Function3<-TK;-TS;-TT;+TS;>;)TM;]
        //  
        //    StackMapTable: 00 06 FF 00 23 00 07 07 00 1F 07 00 1D 07 00 6B 01 07 00 1F 01 07 00 25 00 00 FF 00 44 00 0A 07 00 1F 07 00 1D 07 00 6B 01 07 00 1F 01 07 00 25 07 00 57 07 00 57 07 00 57 00 05 07 00 1D 07 00 57 07 00 57 07 00 57 07 00 57 FF 00 00 00 0A 07 00 1F 07 00 1D 07 00 6B 01 07 00 1F 01 07 00 25 07 00 57 07 00 57 07 00 57 00 06 07 00 1D 07 00 57 07 00 57 07 00 57 07 00 57 01 FF 00 18 00 11 07 00 1F 07 00 1D 07 00 6B 01 07 00 1F 01 07 00 25 07 00 57 07 00 57 07 00 57 01 07 00 57 07 00 57 07 00 57 01 07 00 1D 07 00 57 00 00 4B 07 00 57 FF 00 10 00 07 07 00 1F 07 00 1D 07 00 6B 01 07 00 1F 01 07 00 25 00 00
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, M extends Map<? super K, Integer>> M eachCountTo(@NotNull final Grouping<T, ? extends K> $this$eachCountTo, @NotNull final M destination) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* destination */
        //     7: ldc             "destination"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: aload_0         /* $this$eachCountTo */
        //    13: astore_2       
        //    14: iconst_0       
        //    15: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    18: astore_3        /* initialValue$iv */
        //    19: iconst_0       
        //    20: istore          $i$f$foldTo
        //    22: aload_2         /* $this$foldTo$iv */
        //    23: astore          $this$aggregateTo$iv$iv
        //    25: iconst_0       
        //    26: istore          $i$f$aggregateTo
        //    28: aload           $this$aggregateTo$iv$iv
        //    30: invokeinterface kotlin/collections/Grouping.sourceIterator:()Ljava/util/Iterator;
        //    35: astore          7
        //    37: aload           7
        //    39: invokeinterface java/util/Iterator.hasNext:()Z
        //    44: ifeq            165
        //    47: aload           7
        //    49: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    54: astore          e$iv$iv
        //    56: aload           $this$aggregateTo$iv$iv
        //    58: aload           e$iv$iv
        //    60: invokeinterface kotlin/collections/Grouping.keyOf:(Ljava/lang/Object;)Ljava/lang/Object;
        //    65: astore          key$iv$iv
        //    67: aload_1         /* destination */
        //    68: aload           key$iv$iv
        //    70: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    75: astore          accumulator$iv$iv
        //    77: aload_1         /* destination */
        //    78: aload           key$iv$iv
        //    80: aload           accumulator$iv$iv
        //    82: aload           e$iv$iv
        //    84: aload           accumulator$iv$iv
        //    86: ifnonnull       104
        //    89: aload_1         /* destination */
        //    90: aload           key$iv$iv
        //    92: invokeinterface java/util/Map.containsKey:(Ljava/lang/Object;)Z
        //    97: ifne            104
        //   100: iconst_1       
        //   101: goto            105
        //   104: iconst_0       
        //   105: istore          11
        //   107: astore          12
        //   109: astore          13
        //   111: astore          14
        //   113: astore          15
        //   115: iconst_0       
        //   116: istore          $i$a$-aggregateTo-GroupingKt__GroupingKt$foldTo$2$iv
        //   118: iload           first$iv
        //   120: ifeq            127
        //   123: aload_3         /* initialValue$iv */
        //   124: goto            129
        //   127: aload           acc$iv
        //   129: checkcast       Ljava/lang/Number;
        //   132: invokevirtual   java/lang/Number.intValue:()I
        //   135: istore          acc
        //   137: iconst_0       
        //   138: istore          $i$a$-foldTo-GroupingKt__GroupingKt$eachCountTo$1
        //   140: iload           acc
        //   142: iconst_1       
        //   143: iadd           
        //   144: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   147: nop            
        //   148: astore          17
        //   150: aload           15
        //   152: aload           14
        //   154: aload           17
        //   156: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   161: pop            
        //   162: goto            37
        //   165: aload_1         /* destination */
        //   166: nop            
        //   167: areturn        
        //    Signature:
        //  <T:Ljava/lang/Object;K:Ljava/lang/Object;M::Ljava/util/Map<-TK;Ljava/lang/Integer;>;>(Lkotlin/collections/Grouping<TT;+TK;>;TM;)TM;
        //    StackMapTable: 00 06 FF 00 25 00 08 07 00 1F 07 00 1D 07 00 1F 07 00 9A 01 07 00 1F 01 07 00 25 00 00 FF 00 42 00 0B 07 00 1F 07 00 1D 07 00 1F 07 00 9A 01 07 00 1F 01 07 00 25 07 00 57 07 00 57 07 00 57 00 04 07 00 1D 07 00 57 07 00 57 07 00 57 FF 00 00 00 0B 07 00 1F 07 00 1D 07 00 1F 07 00 9A 01 07 00 1F 01 07 00 25 07 00 57 07 00 57 07 00 57 00 05 07 00 1D 07 00 57 07 00 57 07 00 57 01 FF 00 15 00 11 07 00 1F 07 00 1D 07 00 1F 07 00 9A 01 07 00 1F 01 07 00 25 07 00 57 07 00 57 07 00 57 01 07 00 57 07 00 57 07 00 57 07 00 1D 01 00 00 41 07 00 57 FF 00 23 00 08 07 00 1F 07 00 1D 07 00 1F 07 00 9A 01 07 00 1F 01 07 00 25 00 00
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public GroupingKt__GroupingKt() {
    }
}
