// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections.builders;

import kotlin.jvm.internal.DefaultConstructorMarker;
import java.io.ObjectInput;
import java.util.Iterator;
import java.io.ObjectOutput;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;
import java.io.Externalizable;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0019\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012" }, d2 = { "Lkotlin/collections/builders/SerializedCollection;", "Ljava/io/Externalizable;", "()V", "collection", "", "tag", "", "(Ljava/util/Collection;I)V", "readExternal", "", "input", "Ljava/io/ObjectInput;", "readResolve", "", "writeExternal", "output", "Ljava/io/ObjectOutput;", "Companion", "kotlin-stdlib" })
public final class SerializedCollection implements Externalizable
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private Collection<?> collection;
    private final int tag;
    private static final long serialVersionUID = 0L;
    public static final int tagList = 0;
    public static final int tagSet = 1;
    
    public SerializedCollection(@NotNull final Collection<?> collection, final int tag) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        this.collection = collection;
        this.tag = tag;
    }
    
    public SerializedCollection() {
        this(CollectionsKt__CollectionsKt.emptyList(), 0);
    }
    
    @Override
    public void writeExternal(@NotNull final ObjectOutput output) {
        Intrinsics.checkNotNullParameter(output, "output");
        output.writeByte(this.tag);
        output.writeInt(this.collection.size());
        for (final Object element : this.collection) {
            output.writeObject(element);
        }
    }
    
    @Override
    public void readExternal(@NotNull final ObjectInput input) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "input"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* input */
        //     7: invokeinterface java/io/ObjectInput.readByte:()B
        //    12: istore_2        /* flags */
        //    13: iload_2         /* flags */
        //    14: iconst_1       
        //    15: iand           
        //    16: istore_3        /* tag */
        //    17: iload_2         /* flags */
        //    18: bipush          -2
        //    20: iand           
        //    21: istore          other
        //    23: iload           other
        //    25: ifeq            60
        //    28: new             Ljava/io/InvalidObjectException;
        //    31: dup            
        //    32: new             Ljava/lang/StringBuilder;
        //    35: dup            
        //    36: invokespecial   java/lang/StringBuilder.<init>:()V
        //    39: ldc             "Unsupported flags value: "
        //    41: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    44: iload_2         /* flags */
        //    45: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    48: bipush          46
        //    50: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //    53: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    56: invokespecial   java/io/InvalidObjectException.<init>:(Ljava/lang/String;)V
        //    59: athrow         
        //    60: aload_1         /* input */
        //    61: invokeinterface java/io/ObjectInput.readInt:()I
        //    66: istore          size
        //    68: iload           size
        //    70: ifge            106
        //    73: new             Ljava/io/InvalidObjectException;
        //    76: dup            
        //    77: new             Ljava/lang/StringBuilder;
        //    80: dup            
        //    81: invokespecial   java/lang/StringBuilder.<init>:()V
        //    84: ldc             "Illegal size value: "
        //    86: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    89: iload           size
        //    91: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    94: bipush          46
        //    96: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //    99: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   102: invokespecial   java/io/InvalidObjectException.<init>:(Ljava/lang/String;)V
        //   105: athrow         
        //   106: aload_0         /* this */
        //   107: iload_3         /* tag */
        //   108: tableswitch {
        //                0: 132
        //                1: 199
        //          default: 266
        //        }
        //   132: iload           size
        //   134: invokestatic    kotlin/collections/CollectionsKt.createListBuilder:(I)Ljava/util/List;
        //   137: astore          6
        //   139: aload           6
        //   141: astore          7
        //   143: astore          12
        //   145: iconst_0       
        //   146: istore          $i$a$-buildList-SerializedCollection$readExternal$1
        //   148: iconst_0       
        //   149: istore          9
        //   151: iload           9
        //   153: iload           size
        //   155: if_icmpge       185
        //   158: iload           9
        //   160: istore          it
        //   162: iconst_0       
        //   163: istore          $i$a$-repeat-SerializedCollection$readExternal$1$1
        //   165: aload           $this$readExternal_u24lambda_u241
        //   167: aload_1         /* input */
        //   168: invokeinterface java/io/ObjectInput.readObject:()Ljava/lang/Object;
        //   173: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   178: pop            
        //   179: iinc            9, 1
        //   182: goto            151
        //   185: nop            
        //   186: aload           12
        //   188: aload           6
        //   190: invokestatic    kotlin/collections/CollectionsKt.build:(Ljava/util/List;)Ljava/util/List;
        //   193: checkcast       Ljava/util/Collection;
        //   196: goto            298
        //   199: iload           size
        //   201: invokestatic    kotlin/collections/SetsKt.createSetBuilder:(I)Ljava/util/Set;
        //   204: astore          6
        //   206: aload           6
        //   208: astore          7
        //   210: astore          12
        //   212: iconst_0       
        //   213: istore          $i$a$-buildSet-SerializedCollection$readExternal$2
        //   215: iconst_0       
        //   216: istore          9
        //   218: iload           9
        //   220: iload           size
        //   222: if_icmpge       252
        //   225: iload           9
        //   227: istore          it
        //   229: iconst_0       
        //   230: istore          $i$a$-repeat-SerializedCollection$readExternal$2$1
        //   232: aload           $this$readExternal_u24lambda_u243
        //   234: aload_1         /* input */
        //   235: invokeinterface java/io/ObjectInput.readObject:()Ljava/lang/Object;
        //   240: invokeinterface java/util/Set.add:(Ljava/lang/Object;)Z
        //   245: pop            
        //   246: iinc            9, 1
        //   249: goto            218
        //   252: nop            
        //   253: aload           12
        //   255: aload           6
        //   257: invokestatic    kotlin/collections/SetsKt.build:(Ljava/util/Set;)Ljava/util/Set;
        //   260: checkcast       Ljava/util/Collection;
        //   263: goto            298
        //   266: new             Ljava/io/InvalidObjectException;
        //   269: dup            
        //   270: new             Ljava/lang/StringBuilder;
        //   273: dup            
        //   274: invokespecial   java/lang/StringBuilder.<init>:()V
        //   277: ldc             "Unsupported collection type tag: "
        //   279: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   282: iload_3         /* tag */
        //   283: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   286: bipush          46
        //   288: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   291: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   294: invokespecial   java/io/InvalidObjectException.<init>:(Ljava/lang/String;)V
        //   297: athrow         
        //   298: putfield        kotlin/collections/builders/SerializedCollection.collection:Ljava/util/Collection;
        //   301: return         
        //    StackMapTable: 00 0A FE 00 3C 01 01 01 FC 00 2D 01 59 07 00 02 FF 00 12 00 0D 07 00 02 07 00 54 01 01 01 01 07 00 7E 07 00 7E 01 01 00 00 07 00 02 00 00 21 FF 00 0D 00 06 07 00 02 07 00 54 01 01 01 01 00 01 07 00 02 FF 00 12 00 0D 07 00 02 07 00 54 01 01 01 01 07 00 8E 07 00 8E 01 01 00 00 07 00 02 00 00 21 FF 00 0D 00 06 07 00 02 07 00 54 01 01 01 01 00 01 07 00 02 FF 00 1F 00 0D 07 00 02 07 00 54 01 01 01 01 07 00 04 07 00 04 01 01 00 00 07 00 02 00 02 07 00 02 07 00 26
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private final Object readResolve() {
        return this.collection;
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b" }, d2 = { "Lkotlin/collections/builders/SerializedCollection$Companion;", "", "()V", "serialVersionUID", "", "tagList", "", "tagSet", "kotlin-stdlib" })
    public static final class Companion
    {
        private Companion() {
        }
    }
}
