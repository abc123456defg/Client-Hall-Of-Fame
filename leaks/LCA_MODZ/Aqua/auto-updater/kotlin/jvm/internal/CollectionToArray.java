// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.Arrays;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import kotlin.jvm.JvmName;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\t\u0010\f\u001a~\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00112(\u0010\u0012\u001a$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0013H\u0082\b¢\u0006\u0002\u0010\u0014\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015" }, d2 = { "EMPTY", "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib" })
@JvmName(name = "CollectionToArray")
public final class CollectionToArray
{
    @NotNull
    private static final Object[] EMPTY;
    private static final int MAX_SIZE = 2147483645;
    
    @JvmName(name = "toArray")
    @NotNull
    public static final Object[] toArray(@NotNull final Collection<?> collection) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "collection"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: iconst_0       
        //     7: istore_1        /* $i$f$toArrayImpl */
        //     8: aload_0         /* collection */
        //     9: invokeinterface java/util/Collection.size:()I
        //    14: istore_2        /* size$iv */
        //    15: iload_2         /* size$iv */
        //    16: ifne            27
        //    19: iconst_0       
        //    20: istore_3        /* $i$a$-toArrayImpl-CollectionToArray$collectionToArray$1 */
        //    21: getstatic       kotlin/jvm/internal/CollectionToArray.EMPTY:[Ljava/lang/Object;
        //    24: goto            195
        //    27: aload_0         /* collection */
        //    28: invokeinterface java/util/Collection.iterator:()Ljava/util/Iterator;
        //    33: astore_3        /* iter$iv */
        //    34: aload_3         /* iter$iv */
        //    35: invokeinterface java/util/Iterator.hasNext:()Z
        //    40: ifne            52
        //    43: iconst_0       
        //    44: istore          $i$a$-toArrayImpl-CollectionToArray$collectionToArray$1
        //    46: getstatic       kotlin/jvm/internal/CollectionToArray.EMPTY:[Ljava/lang/Object;
        //    49: goto            195
        //    52: iload_2         /* size$iv */
        //    53: istore          size
        //    55: iconst_0       
        //    56: istore          $i$a$-toArrayImpl-CollectionToArray$collectionToArray$2
        //    58: iload           size
        //    60: anewarray       Ljava/lang/Object;
        //    63: astore          result$iv
        //    65: iconst_0       
        //    66: istore          i$iv
        //    68: nop            
        //    69: aload           result$iv
        //    71: iload           i$iv
        //    73: iinc            i$iv, 1
        //    76: aload_3         /* iter$iv */
        //    77: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    82: aastore        
        //    83: iload           i$iv
        //    85: aload           result$iv
        //    87: arraylength    
        //    88: if_icmplt       159
        //    91: aload_3         /* iter$iv */
        //    92: invokeinterface java/util/Iterator.hasNext:()Z
        //    97: ifne            105
        //   100: aload           result$iv
        //   102: goto            195
        //   105: iload           i$iv
        //   107: iconst_3       
        //   108: imul           
        //   109: iconst_1       
        //   110: iadd           
        //   111: iconst_1       
        //   112: iushr          
        //   113: istore          newSize$iv
        //   115: iload           newSize$iv
        //   117: iload           i$iv
        //   119: if_icmpgt       141
        //   122: iload           i$iv
        //   124: ldc             2147483645
        //   126: if_icmplt       137
        //   129: new             Ljava/lang/OutOfMemoryError;
        //   132: dup            
        //   133: invokespecial   java/lang/OutOfMemoryError.<init>:()V
        //   136: athrow         
        //   137: ldc             2147483645
        //   139: istore          newSize$iv
        //   141: aload           result$iv
        //   143: iload           newSize$iv
        //   145: invokestatic    java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //   148: dup            
        //   149: ldc             "copyOf(result, newSize)"
        //   151: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   154: astore          result$iv
        //   156: goto            68
        //   159: aload_3         /* iter$iv */
        //   160: invokeinterface java/util/Iterator.hasNext:()Z
        //   165: ifne            68
        //   168: aload           result$iv
        //   170: iload           i$iv
        //   172: istore          7
        //   174: astore          result
        //   176: iconst_0       
        //   177: istore          $i$a$-toArrayImpl-CollectionToArray$collectionToArray$3
        //   179: aload           result
        //   181: iload           size
        //   183: invokestatic    java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //   186: dup            
        //   187: ldc             "copyOf(result, size)"
        //   189: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   192: goto            195
        //   195: areturn        
        //    Signature:
        //  (Ljava/util/Collection<*>;)[Ljava/lang/Object;
        //    StackMapTable: 00 08 FD 00 1B 01 01 FC 00 18 07 00 22 FD 00 0F 07 00 4C 01 24 FC 00 1F 01 03 FA 00 11 FF 00 23 00 03 07 00 14 01 01 00 01 07 00 4C
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @JvmName(name = "toArray")
    @NotNull
    public static final Object[] toArray(@NotNull final Collection<?> collection, @Nullable final Object[] a) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "collection"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* a */
        //     7: ifnonnull       18
        //    10: new             Ljava/lang/NullPointerException;
        //    13: dup            
        //    14: invokespecial   java/lang/NullPointerException.<init>:()V
        //    17: athrow         
        //    18: iconst_0       
        //    19: istore_2        /* $i$f$toArrayImpl */
        //    20: aload_0         /* collection */
        //    21: invokeinterface java/util/Collection.size:()I
        //    26: istore_3        /* size$iv */
        //    27: iload_3         /* size$iv */
        //    28: ifne            47
        //    31: iconst_0       
        //    32: istore          $i$a$-toArrayImpl-CollectionToArray$collectionToArray$4
        //    34: aload_1         /* a */
        //    35: arraylength    
        //    36: ifle            43
        //    39: aload_1         /* a */
        //    40: iconst_0       
        //    41: aconst_null    
        //    42: aastore        
        //    43: aload_1         /* a */
        //    44: goto            270
        //    47: aload_0         /* collection */
        //    48: invokeinterface java/util/Collection.iterator:()Ljava/util/Iterator;
        //    53: astore          iter$iv
        //    55: aload           iter$iv
        //    57: invokeinterface java/util/Iterator.hasNext:()Z
        //    62: ifne            81
        //    65: iconst_0       
        //    66: istore          $i$a$-toArrayImpl-CollectionToArray$collectionToArray$4
        //    68: aload_1         /* a */
        //    69: arraylength    
        //    70: ifle            77
        //    73: aload_1         /* a */
        //    74: iconst_0       
        //    75: aconst_null    
        //    76: aastore        
        //    77: aload_1         /* a */
        //    78: goto            270
        //    81: iload_3         /* size$iv */
        //    82: istore          size
        //    84: iconst_0       
        //    85: istore          $i$a$-toArrayImpl-CollectionToArray$collectionToArray$5
        //    87: iload           size
        //    89: aload_1         /* a */
        //    90: arraylength    
        //    91: if_icmpgt       98
        //    94: aload_1         /* a */
        //    95: goto            119
        //    98: aload_1         /* a */
        //    99: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //   102: invokevirtual   java/lang/Class.getComponentType:()Ljava/lang/Class;
        //   105: iload           size
        //   107: invokestatic    java/lang/reflect/Array.newInstance:(Ljava/lang/Class;I)Ljava/lang/Object;
        //   110: dup            
        //   111: ldc             "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>"
        //   113: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   116: checkcast       [Ljava/lang/Object;
        //   119: astore          result$iv
        //   121: iconst_0       
        //   122: istore          i$iv
        //   124: nop            
        //   125: aload           result$iv
        //   127: iload           i$iv
        //   129: iinc            i$iv, 1
        //   132: aload           iter$iv
        //   134: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   139: aastore        
        //   140: iload           i$iv
        //   142: aload           result$iv
        //   144: arraylength    
        //   145: if_icmplt       217
        //   148: aload           iter$iv
        //   150: invokeinterface java/util/Iterator.hasNext:()Z
        //   155: ifne            163
        //   158: aload           result$iv
        //   160: goto            270
        //   163: iload           i$iv
        //   165: iconst_3       
        //   166: imul           
        //   167: iconst_1       
        //   168: iadd           
        //   169: iconst_1       
        //   170: iushr          
        //   171: istore          newSize$iv
        //   173: iload           newSize$iv
        //   175: iload           i$iv
        //   177: if_icmpgt       199
        //   180: iload           i$iv
        //   182: ldc             2147483645
        //   184: if_icmplt       195
        //   187: new             Ljava/lang/OutOfMemoryError;
        //   190: dup            
        //   191: invokespecial   java/lang/OutOfMemoryError.<init>:()V
        //   194: athrow         
        //   195: ldc             2147483645
        //   197: istore          newSize$iv
        //   199: aload           result$iv
        //   201: iload           newSize$iv
        //   203: invokestatic    java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //   206: dup            
        //   207: ldc             "copyOf(result, newSize)"
        //   209: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   212: astore          result$iv
        //   214: goto            124
        //   217: aload           iter$iv
        //   219: invokeinterface java/util/Iterator.hasNext:()Z
        //   224: ifne            124
        //   227: aload           result$iv
        //   229: iload           i$iv
        //   231: istore          8
        //   233: astore          result
        //   235: iconst_0       
        //   236: istore          $i$a$-toArrayImpl-CollectionToArray$collectionToArray$6
        //   238: aload           result
        //   240: aload_1         /* a */
        //   241: if_acmpne       253
        //   244: aload_1         /* a */
        //   245: iload           size
        //   247: aconst_null    
        //   248: aastore        
        //   249: aload_1         /* a */
        //   250: goto            266
        //   253: aload           result
        //   255: iload           size
        //   257: invokestatic    java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //   260: dup            
        //   261: ldc             "copyOf(result, size)"
        //   263: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   266: nop            
        //   267: goto            270
        //   270: areturn        
        //    Signature:
        //  (Ljava/util/Collection<*>;[Ljava/lang/Object;)[Ljava/lang/Object;
        //    StackMapTable: 00 0F 12 FE 00 18 01 01 01 FA 00 03 FD 00 1D 01 07 00 22 FF 00 03 00 06 07 00 14 07 00 4C 01 01 00 07 00 22 00 00 FF 00 10 00 07 07 00 14 07 00 4C 01 01 01 07 00 22 01 00 00 54 07 00 4C FC 00 04 07 00 4C 26 1F 03 11 FE 00 23 01 07 00 4C 01 4C 07 00 4C FF 00 03 00 05 07 00 14 07 00 4C 01 01 01 00 01 07 00 4C
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static final Object[] toArrayImpl(final Collection<?> collection, final Function0<Object[]> empty, final Function1<? super Integer, Object[]> alloc, final Function2<? super Object[], ? super Integer, Object[]> trim) {
        final int $i$f$toArrayImpl = 0;
        final int size = collection.size();
        if (size == 0) {
            return empty.invoke();
        }
        final Iterator iter = collection.iterator();
        if (!iter.hasNext()) {
            return empty.invoke();
        }
        Object[] result = alloc.invoke(size);
        int i = 0;
        while (true) {
            result[i++] = iter.next();
            if (i >= result.length) {
                if (!iter.hasNext()) {
                    return result;
                }
                int newSize = i * 3 + 1 >>> 1;
                if (newSize <= i) {
                    if (i >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                    newSize = 2147483645;
                }
                final Object[] copy = Arrays.copyOf(result, newSize);
                Intrinsics.checkNotNullExpressionValue(copy, "copyOf(result, newSize)");
                result = copy;
            }
            else {
                if (!iter.hasNext()) {
                    return trim.invoke(result, i);
                }
                continue;
            }
        }
    }
    
    static {
        final int $i$f$emptyArray = 0;
        EMPTY = new Object[0];
    }
}
