// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;
import java.util.RandomAccess;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001d\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\u0013\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0018\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0096\u0002J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0006J\u0015\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0014¢\u0006\u0002\u0010#J'\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00010\t\"\u0004\b\u0001\u0010\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00010\tH\u0014¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u0006*\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0082\bR\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'" }, d2 = { "Lkotlin/collections/RingBuffer;", "T", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "capacity", "", "(I)V", "buffer", "", "", "filledSize", "([Ljava/lang/Object;I)V", "[Ljava/lang/Object;", "<set-?>", "size", "getSize", "()I", "startIndex", "add", "", "element", "(Ljava/lang/Object;)V", "expanded", "maxCapacity", "get", "index", "(I)Ljava/lang/Object;", "isFull", "", "iterator", "", "removeFirst", "n", "toArray", "()[Ljava/lang/Object;", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "forward", "kotlin-stdlib" })
final class RingBuffer<T> extends AbstractList<T> implements RandomAccess
{
    @NotNull
    private final Object[] buffer;
    private final int capacity;
    private int startIndex;
    private int size;
    
    public RingBuffer(@NotNull final Object[] buffer, final int filledSize) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.buffer = buffer;
        if (filledSize < 0) {
            final int n = 0;
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + filledSize).toString());
        }
        if (filledSize > this.buffer.length) {
            final int n2 = 0;
            throw new IllegalArgumentException(("ring buffer filled size: " + filledSize + " cannot be larger than the buffer size: " + this.buffer.length).toString());
        }
        this.capacity = this.buffer.length;
        this.size = filledSize;
    }
    
    public RingBuffer(final int capacity) {
        this(new Object[capacity], 0);
    }
    
    @Override
    public int getSize() {
        return this.size;
    }
    
    @Override
    public T get(final int index) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: iload_1         /* index */
        //     4: aload_0         /* this */
        //     5: invokevirtual   kotlin/collections/RingBuffer.size:()I
        //     8: invokevirtual   kotlin/collections/AbstractList$Companion.checkElementIndex$kotlin_stdlib:(II)V
        //    11: aload_0         /* this */
        //    12: getfield        kotlin/collections/RingBuffer.buffer:[Ljava/lang/Object;
        //    15: aload_0         /* this */
        //    16: astore_2       
        //    17: aload_0         /* this */
        //    18: getfield        kotlin/collections/RingBuffer.startIndex:I
        //    21: istore_3        /* $this$forward$iv */
        //    22: iconst_0       
        //    23: istore          $i$f$forward
        //    25: iload_3         /* $this$forward$iv */
        //    26: iload_1         /* index */
        //    27: iadd           
        //    28: aload_2         /* this_$iv */
        //    29: invokestatic    kotlin/collections/RingBuffer.access$getCapacity$p:(Lkotlin/collections/RingBuffer;)I
        //    32: irem           
        //    33: aaload         
        //    34: areturn        
        //    Signature:
        //  (I)TT;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public final boolean isFull() {
        return this.size() == this.capacity;
    }
    
    @NotNull
    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>)new RingBuffer$iterator.RingBuffer$iterator$1(this);
    }
    
    @NotNull
    @Override
    public <T> T[] toArray(@NotNull final T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        T[] copy;
        if (array.length < this.size()) {
            Intrinsics.checkNotNullExpressionValue(copy = Arrays.copyOf(array, this.size()), "copyOf(this, newSize)");
        }
        else {
            copy = array;
        }
        final Object[] result = copy;
        final int size = this.size();
        int widx = 0;
        for (int idx = this.startIndex; widx < size && idx < this.capacity; ++widx, ++idx) {
            result[widx] = this.buffer[idx];
        }
        for (int idx = 0; widx < size; ++widx, ++idx) {
            result[widx] = this.buffer[idx];
        }
        if (result.length > this.size()) {
            result[this.size()] = null;
        }
        Intrinsics.checkNotNull(result, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.RingBuffer.toArray>");
        return (T[])result;
    }
    
    @NotNull
    @Override
    public Object[] toArray() {
        return this.toArray(new Object[this.size()]);
    }
    
    @NotNull
    public final RingBuffer<T> expanded(final int maxCapacity) {
        final int newCapacity = RangesKt___RangesKt.coerceAtMost(this.capacity + (this.capacity >> 1) + 1, maxCapacity);
        Object[] array;
        if (this.startIndex == 0) {
            Intrinsics.checkNotNullExpressionValue(array = Arrays.copyOf(this.buffer, newCapacity), "copyOf(this, newSize)");
        }
        else {
            array = this.toArray(new Object[newCapacity]);
        }
        final Object[] newBuffer = array;
        return new RingBuffer<T>(newBuffer, this.size());
    }
    
    public final void add(final T element) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   kotlin/collections/RingBuffer.isFull:()Z
        //     4: ifeq            17
        //     7: new             Ljava/lang/IllegalStateException;
        //    10: dup            
        //    11: ldc             "ring buffer is full"
        //    13: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    16: athrow         
        //    17: aload_0         /* this */
        //    18: getfield        kotlin/collections/RingBuffer.buffer:[Ljava/lang/Object;
        //    21: aload_0         /* this */
        //    22: astore_2       
        //    23: aload_0         /* this */
        //    24: getfield        kotlin/collections/RingBuffer.startIndex:I
        //    27: istore_3       
        //    28: aload_0         /* this */
        //    29: invokevirtual   kotlin/collections/RingBuffer.size:()I
        //    32: istore          n$iv
        //    34: iconst_0       
        //    35: istore          $i$f$forward
        //    37: iload_3         /* $this$forward$iv */
        //    38: iload           n$iv
        //    40: iadd           
        //    41: aload_2         /* this_$iv */
        //    42: invokestatic    kotlin/collections/RingBuffer.access$getCapacity$p:(Lkotlin/collections/RingBuffer;)I
        //    45: irem           
        //    46: aload_1         /* element */
        //    47: aastore        
        //    48: aload_0         /* this */
        //    49: invokevirtual   kotlin/collections/RingBuffer.size:()I
        //    52: istore_2       
        //    53: aload_0         /* this */
        //    54: iload_2        
        //    55: iconst_1       
        //    56: iadd           
        //    57: putfield        kotlin/collections/RingBuffer.size:I
        //    60: return         
        //    Signature:
        //  (TT;)V
        //    StackMapTable: 00 01 11
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public final void removeFirst(final int n) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iflt            8
        //     4: iconst_1       
        //     5: goto            9
        //     8: iconst_0       
        //     9: istore_2       
        //    10: iload_2        
        //    11: ifne            48
        //    14: iconst_0       
        //    15: istore_3        /* $i$a$-require-RingBuffer$removeFirst$1 */
        //    16: new             Ljava/lang/StringBuilder;
        //    19: dup            
        //    20: invokespecial   java/lang/StringBuilder.<init>:()V
        //    23: ldc             "n shouldn't be negative but it is "
        //    25: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    28: iload_1         /* n */
        //    29: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    32: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    35: astore_3        /* $i$a$-require-RingBuffer$removeFirst$1 */
        //    36: new             Ljava/lang/IllegalArgumentException;
        //    39: dup            
        //    40: aload_3        
        //    41: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //    44: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //    47: athrow         
        //    48: iload_1         /* n */
        //    49: aload_0         /* this */
        //    50: invokevirtual   kotlin/collections/RingBuffer.size:()I
        //    53: if_icmpgt       60
        //    56: iconst_1       
        //    57: goto            61
        //    60: iconst_0       
        //    61: istore_2       
        //    62: iload_2        
        //    63: ifne            112
        //    66: iconst_0       
        //    67: istore_3        /* $i$a$-require-RingBuffer$removeFirst$2 */
        //    68: new             Ljava/lang/StringBuilder;
        //    71: dup            
        //    72: invokespecial   java/lang/StringBuilder.<init>:()V
        //    75: ldc             "n shouldn't be greater than the buffer size: n = "
        //    77: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    80: iload_1         /* n */
        //    81: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    84: ldc             ", size = "
        //    86: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    89: aload_0         /* this */
        //    90: invokevirtual   kotlin/collections/RingBuffer.size:()I
        //    93: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    96: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    99: astore_3        /* $i$a$-require-RingBuffer$removeFirst$2 */
        //   100: new             Ljava/lang/IllegalArgumentException;
        //   103: dup            
        //   104: aload_3        
        //   105: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //   108: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //   111: athrow         
        //   112: iload_1         /* n */
        //   113: ifle            197
        //   116: aload_0         /* this */
        //   117: getfield        kotlin/collections/RingBuffer.startIndex:I
        //   120: istore_2        /* start */
        //   121: aload_0         /* this */
        //   122: astore          4
        //   124: iload_2         /* start */
        //   125: istore          $this$forward$iv
        //   127: iconst_0       
        //   128: istore          $i$f$forward
        //   130: iload           $this$forward$iv
        //   132: iload_1         /* n */
        //   133: iadd           
        //   134: aload           this_$iv
        //   136: invokestatic    kotlin/collections/RingBuffer.access$getCapacity$p:(Lkotlin/collections/RingBuffer;)I
        //   139: irem           
        //   140: istore_3        /* end */
        //   141: iload_2         /* start */
        //   142: iload_3         /* end */
        //   143: if_icmple       172
        //   146: aload_0         /* this */
        //   147: getfield        kotlin/collections/RingBuffer.buffer:[Ljava/lang/Object;
        //   150: aconst_null    
        //   151: iload_2         /* start */
        //   152: aload_0         /* this */
        //   153: getfield        kotlin/collections/RingBuffer.capacity:I
        //   156: invokestatic    kotlin/collections/ArraysKt.fill:([Ljava/lang/Object;Ljava/lang/Object;II)V
        //   159: aload_0         /* this */
        //   160: getfield        kotlin/collections/RingBuffer.buffer:[Ljava/lang/Object;
        //   163: aconst_null    
        //   164: iconst_0       
        //   165: iload_3         /* end */
        //   166: invokestatic    kotlin/collections/ArraysKt.fill:([Ljava/lang/Object;Ljava/lang/Object;II)V
        //   169: goto            182
        //   172: aload_0         /* this */
        //   173: getfield        kotlin/collections/RingBuffer.buffer:[Ljava/lang/Object;
        //   176: aconst_null    
        //   177: iload_2         /* start */
        //   178: iload_3         /* end */
        //   179: invokestatic    kotlin/collections/ArraysKt.fill:([Ljava/lang/Object;Ljava/lang/Object;II)V
        //   182: aload_0         /* this */
        //   183: iload_3         /* end */
        //   184: putfield        kotlin/collections/RingBuffer.startIndex:I
        //   187: aload_0         /* this */
        //   188: aload_0         /* this */
        //   189: invokevirtual   kotlin/collections/RingBuffer.size:()I
        //   192: iload_1         /* n */
        //   193: isub           
        //   194: putfield        kotlin/collections/RingBuffer.size:I
        //   197: return         
        //    StackMapTable: 00 09 08 40 01 FC 00 26 01 0B 40 01 32 FF 00 3B 00 07 07 00 02 01 01 01 07 00 02 01 01 00 00 09 FF 00 0E 00 03 07 00 02 01 01 00 00
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private final int forward(final int $this$forward, final int n) {
        final int $i$f$forward = 0;
        return ($this$forward + n) % access$getCapacity$p(this);
    }
    
    public static final /* synthetic */ int access$getCapacity$p(final RingBuffer $this) {
        return $this.capacity;
    }
}
