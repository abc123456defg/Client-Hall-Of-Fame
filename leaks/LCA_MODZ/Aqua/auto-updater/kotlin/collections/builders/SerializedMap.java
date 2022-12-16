// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections.builders;

import kotlin.jvm.internal.DefaultConstructorMarker;
import java.io.ObjectInput;
import java.util.Iterator;
import java.io.ObjectOutput;
import kotlin.jvm.internal.Intrinsics;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;
import java.io.Externalizable;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010" }, d2 = { "Lkotlin/collections/builders/SerializedMap;", "Ljava/io/Externalizable;", "()V", "map", "", "(Ljava/util/Map;)V", "readExternal", "", "input", "Ljava/io/ObjectInput;", "readResolve", "", "writeExternal", "output", "Ljava/io/ObjectOutput;", "Companion", "kotlin-stdlib" })
final class SerializedMap implements Externalizable
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private Map<?, ?> map;
    private static final long serialVersionUID = 0L;
    
    public SerializedMap(@NotNull final Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
    }
    
    public SerializedMap() {
        this(MapsKt__MapsKt.emptyMap());
    }
    
    @Override
    public void writeExternal(@NotNull final ObjectOutput output) {
        Intrinsics.checkNotNullParameter(output, "output");
        output.writeByte(0);
        output.writeInt(this.map.size());
        for (final Map.Entry entry : this.map.entrySet()) {
            output.writeObject(entry.getKey());
            output.writeObject(entry.getValue());
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
        //    14: ifeq            44
        //    17: new             Ljava/io/InvalidObjectException;
        //    20: dup            
        //    21: new             Ljava/lang/StringBuilder;
        //    24: dup            
        //    25: invokespecial   java/lang/StringBuilder.<init>:()V
        //    28: ldc             "Unsupported flags value: "
        //    30: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    33: iload_2         /* flags */
        //    34: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    37: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    40: invokespecial   java/io/InvalidObjectException.<init>:(Ljava/lang/String;)V
        //    43: athrow         
        //    44: aload_1         /* input */
        //    45: invokeinterface java/io/ObjectInput.readInt:()I
        //    50: istore_3        /* size */
        //    51: iload_3         /* size */
        //    52: ifge            87
        //    55: new             Ljava/io/InvalidObjectException;
        //    58: dup            
        //    59: new             Ljava/lang/StringBuilder;
        //    62: dup            
        //    63: invokespecial   java/lang/StringBuilder.<init>:()V
        //    66: ldc             "Illegal size value: "
        //    68: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    71: iload_3         /* size */
        //    72: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    75: bipush          46
        //    77: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //    80: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    83: invokespecial   java/io/InvalidObjectException.<init>:(Ljava/lang/String;)V
        //    86: athrow         
        //    87: aload_0         /* this */
        //    88: iload_3         /* size */
        //    89: invokestatic    kotlin/collections/MapsKt.createMapBuilder:(I)Ljava/util/Map;
        //    92: astore          4
        //    94: aload           4
        //    96: astore          5
        //    98: astore          12
        //   100: iconst_0       
        //   101: istore          $i$a$-buildMap-SerializedMap$readExternal$1
        //   103: iconst_0       
        //   104: istore          7
        //   106: iload           7
        //   108: iload_3         /* size */
        //   109: if_icmpge       154
        //   112: iload           7
        //   114: istore          it
        //   116: iconst_0       
        //   117: istore          $i$a$-repeat-SerializedMap$readExternal$1$1
        //   119: aload_1         /* input */
        //   120: invokeinterface java/io/ObjectInput.readObject:()Ljava/lang/Object;
        //   125: astore          key
        //   127: aload_1         /* input */
        //   128: invokeinterface java/io/ObjectInput.readObject:()Ljava/lang/Object;
        //   133: astore          value
        //   135: aload           $this$readExternal_u24lambda_u241
        //   137: aload           key
        //   139: aload           value
        //   141: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   146: pop            
        //   147: nop            
        //   148: iinc            7, 1
        //   151: goto            106
        //   154: nop            
        //   155: aload           12
        //   157: aload           4
        //   159: invokestatic    kotlin/collections/MapsKt.build:(Ljava/util/Map;)Ljava/util/Map;
        //   162: putfield        kotlin/collections/builders/SerializedMap.map:Ljava/util/Map;
        //   165: return         
        //    StackMapTable: 00 04 FC 00 2C 01 FC 00 2A 01 FF 00 12 00 0D 07 00 02 07 00 5E 01 01 07 00 2E 07 00 2E 01 01 00 00 00 00 07 00 02 00 00 2F
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private final Object readResolve() {
        return this.map;
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005" }, d2 = { "Lkotlin/collections/builders/SerializedMap$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib" })
    public static final class Companion
    {
        private Companion() {
        }
    }
}
