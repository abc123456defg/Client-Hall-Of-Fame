// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections;

import kotlin.internal.InlineOnly;
import kotlin.PublishedApi;
import java.util.Iterator;
import kotlin.jvm.internal.TypeIntrinsics;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.functions.Function1;
import kotlin.SinceKotlin;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000&\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\u001a0\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u0005H\u0007\u001aZ\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\b*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u00072\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\f\u0012\u0004\u0012\u0002H\b0\u000bH\u0081\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r" }, d2 = { "eachCount", "", "K", "", "T", "Lkotlin/collections/Grouping;", "mapValuesInPlace", "", "R", "V", "f", "Lkotlin/Function1;", "", "kotlin-stdlib" }, xs = "kotlin/collections/GroupingKt")
class GroupingKt__GroupingJVMKt
{
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K> Map<K, Integer> eachCount(@NotNull final Grouping<T, ? extends K> $this$eachCount) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* $this$eachCount */
        //     7: astore_1       
        //     8: new             Ljava/util/LinkedHashMap;
        //    11: dup            
        //    12: invokespecial   java/util/LinkedHashMap.<init>:()V
        //    15: checkcast       Ljava/util/Map;
        //    18: astore_2       
        //    19: nop            
        //    20: iconst_0       
        //    21: istore_3        /* $i$f$foldTo */
        //    22: aload_1         /* $this$foldTo$iv */
        //    23: astore          $this$aggregateTo$iv$iv
        //    25: iconst_0       
        //    26: istore          $i$f$aggregateTo
        //    28: aload           $this$aggregateTo$iv$iv
        //    30: invokeinterface kotlin/collections/Grouping.sourceIterator:()Ljava/util/Iterator;
        //    35: astore          6
        //    37: aload           6
        //    39: invokeinterface java/util/Iterator.hasNext:()Z
        //    44: ifeq            202
        //    47: aload           6
        //    49: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    54: astore          e$iv$iv
        //    56: aload           $this$aggregateTo$iv$iv
        //    58: aload           e$iv$iv
        //    60: invokeinterface kotlin/collections/Grouping.keyOf:(Ljava/lang/Object;)Ljava/lang/Object;
        //    65: astore          key$iv$iv
        //    67: aload_2         /* destination$iv */
        //    68: aload           key$iv$iv
        //    70: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    75: astore          accumulator$iv$iv
        //    77: aload_2         /* destination$iv */
        //    78: aload           key$iv$iv
        //    80: aload           key$iv$iv
        //    82: aload           accumulator$iv$iv
        //    84: aload           e$iv$iv
        //    86: aload           accumulator$iv$iv
        //    88: ifnonnull       106
        //    91: aload_2         /* destination$iv */
        //    92: aload           key$iv$iv
        //    94: invokeinterface java/util/Map.containsKey:(Ljava/lang/Object;)Z
        //    99: ifne            106
        //   102: iconst_1       
        //   103: goto            107
        //   106: iconst_0       
        //   107: istore          10
        //   109: astore          11
        //   111: astore          12
        //   113: astore          13
        //   115: astore          14
        //   117: astore          15
        //   119: iconst_0       
        //   120: istore          $i$a$-aggregateTo-GroupingKt__GroupingKt$foldTo$1$iv
        //   122: aload           key$iv
        //   124: iload           first$iv
        //   126: ifeq            147
        //   129: astore          24
        //   131: iconst_0       
        //   132: istore          $i$a$-foldTo-GroupingKt__GroupingJVMKt$eachCount$1
        //   134: new             Lkotlin/jvm/internal/Ref$IntRef;
        //   137: dup            
        //   138: invokespecial   kotlin/jvm/internal/Ref$IntRef.<init>:()V
        //   141: aload           24
        //   143: swap           
        //   144: goto            149
        //   147: aload           acc$iv
        //   149: checkcast       Lkotlin/jvm/internal/Ref$IntRef;
        //   152: astore          17
        //   154: pop            
        //   155: iconst_0       
        //   156: istore          $i$a$-foldTo-GroupingKt__GroupingJVMKt$eachCount$2
        //   158: aload           acc
        //   160: astore          21
        //   162: aload           21
        //   164: astore          $this$eachCount_u24lambda_u242_u24lambda_u241
        //   166: iconst_0       
        //   167: istore          $i$a$-apply-GroupingKt__GroupingJVMKt$eachCount$2$1
        //   169: aload           $this$eachCount_u24lambda_u242_u24lambda_u241
        //   171: aload           $this$eachCount_u24lambda_u242_u24lambda_u241
        //   173: getfield        kotlin/jvm/internal/Ref$IntRef.element:I
        //   176: iconst_1       
        //   177: iadd           
        //   178: putfield        kotlin/jvm/internal/Ref$IntRef.element:I
        //   181: aload           21
        //   183: nop            
        //   184: nop            
        //   185: astore          18
        //   187: aload           15
        //   189: aload           14
        //   191: aload           18
        //   193: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   198: pop            
        //   199: goto            37
        //   202: aload_2         /* destination$iv */
        //   203: nop            
        //   204: astore_1        /* $this$foldTo$iv */
        //   205: aload_1        
        //   206: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //   211: checkcast       Ljava/lang/Iterable;
        //   214: astore_2       
        //   215: aload_2        
        //   216: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   221: astore_3       
        //   222: aload_3        
        //   223: invokeinterface java/util/Iterator.hasNext:()Z
        //   228: ifeq            291
        //   231: aload_3        
        //   232: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   237: checkcast       Ljava/util/Map$Entry;
        //   240: astore          4
        //   242: aload           4
        //   244: ldc             "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4>"
        //   246: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   249: aload           4
        //   251: invokestatic    kotlin/jvm/internal/TypeIntrinsics.asMutableMapEntry:(Ljava/lang/Object;)Ljava/util/Map$Entry;
        //   254: aload           4
        //   256: astore          5
        //   258: astore          24
        //   260: iconst_0       
        //   261: istore          $i$a$-mapValuesInPlace-GroupingKt__GroupingJVMKt$eachCount$3
        //   263: aload           it
        //   265: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   270: checkcast       Lkotlin/jvm/internal/Ref$IntRef;
        //   273: getfield        kotlin/jvm/internal/Ref$IntRef.element:I
        //   276: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   279: aload           24
        //   281: swap           
        //   282: invokeinterface java/util/Map$Entry.setValue:(Ljava/lang/Object;)Ljava/lang/Object;
        //   287: pop            
        //   288: goto            222
        //   291: aload_1        
        //   292: invokestatic    kotlin/jvm/internal/TypeIntrinsics.asMutableMap:(Ljava/lang/Object;)Ljava/util/Map;
        //   295: areturn        
        //    Signature:
        //  <T:Ljava/lang/Object;K:Ljava/lang/Object;>(Lkotlin/collections/Grouping<TT;+TK;>;)Ljava/util/Map<TK;Ljava/lang/Integer;>;
        //    StackMapTable: 00 08 FF 00 25 00 07 07 00 1D 07 00 1D 07 00 1B 01 07 00 1D 01 07 00 23 00 00 FF 00 44 00 0A 07 00 1D 07 00 1D 07 00 1B 01 07 00 1D 01 07 00 23 07 00 04 07 00 04 07 00 04 00 05 07 00 1B 07 00 04 07 00 04 07 00 04 07 00 04 FF 00 00 00 0A 07 00 1D 07 00 1D 07 00 1B 01 07 00 1D 01 07 00 23 07 00 04 07 00 04 07 00 04 00 06 07 00 1B 07 00 04 07 00 04 07 00 04 07 00 04 01 FF 00 27 00 11 07 00 1D 07 00 1D 07 00 1B 01 07 00 1D 01 07 00 23 07 00 04 07 00 04 07 00 04 01 07 00 04 07 00 04 07 00 04 07 00 04 07 00 1B 01 00 01 07 00 04 FF 00 01 00 11 07 00 1D 07 00 1D 07 00 1B 01 07 00 1D 01 07 00 23 07 00 04 07 00 04 07 00 04 01 07 00 04 07 00 04 07 00 04 07 00 04 07 00 1B 01 00 02 07 00 04 07 00 04 FF 00 34 00 07 07 00 1D 07 00 1D 07 00 1B 01 07 00 1D 01 07 00 23 00 00 FF 00 13 00 05 07 00 1D 07 00 1B 07 00 47 07 00 23 07 00 04 00 00 FB 00 44
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @PublishedApi
    @InlineOnly
    private static final <K, V, R> Map<K, R> mapValuesInPlace(final Map<K, V> $this$mapValuesInPlace, final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> f) {
        Intrinsics.checkNotNullParameter($this$mapValuesInPlace, "<this>");
        Intrinsics.checkNotNullParameter(f, "f");
        final Iterable $this$forEach$iv = $this$mapValuesInPlace.entrySet();
        final int $i$f$forEach = 0;
        for (final Object element$iv : $this$forEach$iv) {
            final Map.Entry it = (Map.Entry)element$iv;
            final int n = 0;
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4>");
            TypeIntrinsics.asMutableMapEntry(it).setValue(f.invoke((Object)it));
        }
        return (Map<K, R>)TypeIntrinsics.asMutableMap($this$mapValuesInPlace);
    }
    
    public GroupingKt__GroupingJVMKt() {
    }
}
