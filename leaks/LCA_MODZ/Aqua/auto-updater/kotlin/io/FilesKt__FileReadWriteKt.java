// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.io;

import kotlin.sequences.Sequence;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import java.io.Closeable;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.BufferedReader;
import kotlin.text.Charsets;
import kotlin.internal.InlineOnly;
import java.io.InputStream;
import java.io.FileInputStream;
import kotlin.jvm.internal.Intrinsics;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.io.File;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a!\u0010\n\u001a\u00020\u000b*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\u0087\b\u001a!\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\u0087\b\u001aB\u0010\u0010\u001a\u00020\u0001*\u00020\u000226\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00010\u0012\u001aJ\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\r26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00010\u0012\u001a7\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00010\u0019\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0002H\u0087\b\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u0002H\u0087\b\u001a\u0017\u0010\u001f\u001a\u00020 *\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\u0087\b\u001a\n\u0010!\u001a\u00020\u0004*\u00020\u0002\u001a\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070#*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0014\u0010$\u001a\u00020\u0007*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0017\u0010%\u001a\u00020&*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\u0087\b\u001a?\u0010'\u001a\u0002H(\"\u0004\b\u0000\u0010(*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\u0018\u0010)\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070*\u0012\u0004\u0012\u0002H(0\u0019H\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010+\u001a\u0012\u0010,\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0017\u0010.\u001a\u00020/*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00060" }, d2 = { "appendBytes", "", "Ljava/io/File;", "array", "", "appendText", "text", "", "charset", "Ljava/nio/charset/Charset;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "bufferedWriter", "Ljava/io/BufferedWriter;", "forEachBlock", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "buffer", "bytesRead", "blockSize", "forEachLine", "Lkotlin/Function1;", "line", "inputStream", "Ljava/io/FileInputStream;", "outputStream", "Ljava/io/FileOutputStream;", "printWriter", "Ljava/io/PrintWriter;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "useLines", "T", "block", "Lkotlin/sequences/Sequence;", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "writeText", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib" }, xs = "kotlin/io/FilesKt")
class FilesKt__FileReadWriteKt extends FilesKt__FilePathComponentsKt
{
    @InlineOnly
    private static final InputStreamReader reader(final File $this$reader, final Charset charset) {
        Intrinsics.checkNotNullParameter($this$reader, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new InputStreamReader(new FileInputStream($this$reader), charset);
    }
    
    @InlineOnly
    private static final BufferedReader bufferedReader(final File $this$bufferedReader, final Charset charset, final int bufferSize) {
        Intrinsics.checkNotNullParameter($this$bufferedReader, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        final InputStreamReader in = new InputStreamReader(new FileInputStream($this$bufferedReader), charset);
        return (in instanceof BufferedReader) ? in : new BufferedReader(in, bufferSize);
    }
    
    @InlineOnly
    private static final OutputStreamWriter writer(final File $this$writer, final Charset charset) {
        Intrinsics.checkNotNullParameter($this$writer, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new OutputStreamWriter(new FileOutputStream($this$writer), charset);
    }
    
    @InlineOnly
    private static final BufferedWriter bufferedWriter(final File $this$bufferedWriter, final Charset charset, final int bufferSize) {
        Intrinsics.checkNotNullParameter($this$bufferedWriter, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        final OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream($this$bufferedWriter), charset);
        return (out instanceof BufferedWriter) ? out : new BufferedWriter(out, bufferSize);
    }
    
    @InlineOnly
    private static final PrintWriter printWriter(final File $this$printWriter, final Charset charset) {
        Intrinsics.checkNotNullParameter($this$printWriter, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        final int sz = 8192;
        final OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream($this$printWriter), charset);
        return new PrintWriter((out instanceof BufferedWriter) ? out : new BufferedWriter(out, sz));
    }
    
    @NotNull
    public static final byte[] readBytes(@NotNull final File $this$readBytes) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: new             Ljava/io/FileInputStream;
        //     9: dup            
        //    10: aload_0         /* $this$readBytes */
        //    11: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    14: checkcast       Ljava/io/Closeable;
        //    17: astore_1       
        //    18: aconst_null    
        //    19: astore_2       
        //    20: nop            
        //    21: aload_1        
        //    22: checkcast       Ljava/io/FileInputStream;
        //    25: astore_3        /* input */
        //    26: iconst_0       
        //    27: istore          $i$a$-use-FilesKt__FileReadWriteKt$readBytes$1
        //    29: iconst_0       
        //    30: istore          offset
        //    32: aload_0         /* $this$readBytes */
        //    33: invokevirtual   java/io/File.length:()J
        //    36: lstore          6
        //    38: lload           6
        //    40: lstore          length
        //    42: iconst_0       
        //    43: istore          $i$a$-also-FilesKt__FileReadWriteKt$readBytes$1$remaining$1
        //    45: lload           length
        //    47: ldc2_w          2147483647
        //    50: lcmp           
        //    51: ifle            96
        //    54: new             Ljava/lang/OutOfMemoryError;
        //    57: dup            
        //    58: new             Ljava/lang/StringBuilder;
        //    61: dup            
        //    62: invokespecial   java/lang/StringBuilder.<init>:()V
        //    65: ldc             "File "
        //    67: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    70: aload_0         /* $this$readBytes */
        //    71: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    74: ldc             " is too big ("
        //    76: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    79: lload           length
        //    81: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //    84: ldc             " bytes) to fit in memory."
        //    86: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    89: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    92: invokespecial   java/lang/OutOfMemoryError.<init>:(Ljava/lang/String;)V
        //    95: athrow         
        //    96: nop            
        //    97: lload           6
        //    99: l2i            
        //   100: istore          remaining
        //   102: iload           remaining
        //   104: newarray        B
        //   106: astore          result
        //   108: iload           remaining
        //   110: ifle            147
        //   113: aload_3         /* input */
        //   114: aload           result
        //   116: iload           offset
        //   118: iload           remaining
        //   120: invokevirtual   java/io/FileInputStream.read:([BII)I
        //   123: istore          read
        //   125: iload           read
        //   127: iflt            147
        //   130: iload           remaining
        //   132: iload           read
        //   134: isub           
        //   135: istore          remaining
        //   137: iload           offset
        //   139: iload           read
        //   141: iadd           
        //   142: istore          offset
        //   144: goto            108
        //   147: iload           remaining
        //   149: ifle            168
        //   152: aload           result
        //   154: iload           offset
        //   156: invokestatic    java/util/Arrays.copyOf:([BI)[B
        //   159: dup            
        //   160: ldc             "copyOf(this, newSize)"
        //   162: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   165: goto            298
        //   168: aload_3         /* input */
        //   169: invokevirtual   java/io/FileInputStream.read:()I
        //   172: istore          extraByte
        //   174: iload           extraByte
        //   176: iconst_m1      
        //   177: if_icmpne       185
        //   180: aload           result
        //   182: goto            298
        //   185: new             Lkotlin/io/ExposingBufferByteArrayOutputStream;
        //   188: dup            
        //   189: sipush          8193
        //   192: invokespecial   kotlin/io/ExposingBufferByteArrayOutputStream.<init>:(I)V
        //   195: astore          extra
        //   197: aload           extra
        //   199: iload           extraByte
        //   201: invokevirtual   kotlin/io/ExposingBufferByteArrayOutputStream.write:(I)V
        //   204: aload_3         /* input */
        //   205: checkcast       Ljava/io/InputStream;
        //   208: aload           extra
        //   210: checkcast       Ljava/io/OutputStream;
        //   213: iconst_0       
        //   214: iconst_2       
        //   215: aconst_null    
        //   216: invokestatic    kotlin/io/ByteStreamsKt.copyTo$default:(Ljava/io/InputStream;Ljava/io/OutputStream;IILjava/lang/Object;)J
        //   219: pop2           
        //   220: aload           result
        //   222: arraylength    
        //   223: aload           extra
        //   225: invokevirtual   kotlin/io/ExposingBufferByteArrayOutputStream.size:()I
        //   228: iadd           
        //   229: istore          resultingSize
        //   231: iload           resultingSize
        //   233: ifge            268
        //   236: new             Ljava/lang/OutOfMemoryError;
        //   239: dup            
        //   240: new             Ljava/lang/StringBuilder;
        //   243: dup            
        //   244: invokespecial   java/lang/StringBuilder.<init>:()V
        //   247: ldc             "File "
        //   249: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   252: aload_0         /* $this$readBytes */
        //   253: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   256: ldc             " is too big to fit in memory."
        //   258: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   261: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   264: invokespecial   java/lang/OutOfMemoryError.<init>:(Ljava/lang/String;)V
        //   267: athrow         
        //   268: aload           extra
        //   270: invokevirtual   kotlin/io/ExposingBufferByteArrayOutputStream.getBuffer:()[B
        //   273: aload           result
        //   275: iload           resultingSize
        //   277: invokestatic    java/util/Arrays.copyOf:([BI)[B
        //   280: dup            
        //   281: ldc             "copyOf(this, newSize)"
        //   283: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   286: aload           result
        //   288: arraylength    
        //   289: iconst_0       
        //   290: aload           extra
        //   292: invokevirtual   kotlin/io/ExposingBufferByteArrayOutputStream.size:()I
        //   295: invokestatic    kotlin/collections/ArraysKt.copyInto:([B[BIII)[B
        //   298: astore_3        /* input */
        //   299: aload_1        
        //   300: aload_2        
        //   301: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //   304: aload_3        
        //   305: goto            321
        //   308: astore_3       
        //   309: aload_3        
        //   310: astore_2       
        //   311: aload_3        
        //   312: athrow         
        //   313: astore_3       
        //   314: aload_1        
        //   315: aload_2        
        //   316: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //   319: aload_3        
        //   320: athrow         
        //   321: areturn        
        //    StackMapTable: 00 0A FF 00 60 00 09 07 00 3A 07 00 6D 05 07 00 15 01 01 04 04 01 00 00 FF 00 0B 00 0B 07 00 3A 07 00 6D 05 07 00 15 01 01 07 00 D5 00 04 01 01 00 00 26 14 FC 00 10 01 FC 00 52 07 00 A5 FF 00 1D 00 0B 07 00 3A 07 00 6D 05 07 00 15 01 01 07 00 D5 00 04 01 01 00 01 07 00 D5 FF 00 09 00 03 07 00 3A 07 00 6D 05 00 01 07 00 6B FF 00 04 00 03 07 00 3A 07 00 6D 07 00 6B 00 01 07 00 6B FF 00 07 00 0B 07 00 3A 07 00 6D 05 07 00 D5 01 01 07 00 D5 00 04 01 01 00 01 07 00 D5
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  20     299    308    313    Ljava/lang/Throwable;
        //  20     299    313    321    Any
        //  308    313    313    321    Any
        //  313    314    313    321    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.remove(ArrayList.java:535)
        //     at com.strobel.assembler.ir.StackMappingVisitor.pop(StackMappingVisitor.java:267)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:595)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static final void writeBytes(@NotNull final File $this$writeBytes, @NotNull final byte[] array) {
        Intrinsics.checkNotNullParameter($this$writeBytes, "<this>");
        Intrinsics.checkNotNullParameter(array, "array");
        final FileOutputStream $this$closeFinally = new FileOutputStream($this$writeBytes);
        Throwable cause = null;
        try {
            final FileOutputStream it = $this$closeFinally;
            final int n = 0;
            it.write(array);
            final Unit instance = Unit.INSTANCE;
        }
        catch (Throwable t) {
            cause = t;
            throw t;
        }
        finally {
            CloseableKt.closeFinally($this$closeFinally, cause);
        }
    }
    
    public static final void appendBytes(@NotNull final File $this$appendBytes, @NotNull final byte[] array) {
        Intrinsics.checkNotNullParameter($this$appendBytes, "<this>");
        Intrinsics.checkNotNullParameter(array, "array");
        final FileOutputStream $this$closeFinally = new FileOutputStream($this$appendBytes, true);
        Throwable cause = null;
        try {
            final FileOutputStream it = $this$closeFinally;
            final int n = 0;
            it.write(array);
            final Unit instance = Unit.INSTANCE;
        }
        catch (Throwable t) {
            cause = t;
            throw t;
        }
        finally {
            CloseableKt.closeFinally($this$closeFinally, cause);
        }
    }
    
    @NotNull
    public static final String readText(@NotNull final File $this$readText, @NotNull final Charset charset) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* charset */
        //     7: ldc             "charset"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: aload_0         /* $this$readText */
        //    13: astore_2       
        //    14: new             Ljava/io/InputStreamReader;
        //    17: dup            
        //    18: new             Ljava/io/FileInputStream;
        //    21: dup            
        //    22: aload_2        
        //    23: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    26: checkcast       Ljava/io/InputStream;
        //    29: aload_1         /* charset */
        //    30: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
        //    33: checkcast       Ljava/io/Closeable;
        //    36: astore_2       
        //    37: aconst_null    
        //    38: astore_3       
        //    39: nop            
        //    40: aload_2        
        //    41: checkcast       Ljava/io/InputStreamReader;
        //    44: astore          it
        //    46: iconst_0       
        //    47: istore          $i$a$-use-FilesKt__FileReadWriteKt$readText$1
        //    49: aload           it
        //    51: checkcast       Ljava/io/Reader;
        //    54: invokestatic    kotlin/io/TextStreamsKt.readText:(Ljava/io/Reader;)Ljava/lang/String;
        //    57: astore          null
        //    59: aload_2        
        //    60: aload_3        
        //    61: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //    64: aload           4
        //    66: goto            87
        //    69: astore          4
        //    71: aload           4
        //    73: astore_3       
        //    74: aload           4
        //    76: athrow         
        //    77: astore          4
        //    79: aload_2        
        //    80: aload_3        
        //    81: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //    84: aload           4
        //    86: athrow         
        //    87: areturn        
        //    StackMapTable: 00 03 FF 00 45 00 04 07 00 3A 07 00 3C 07 00 6D 05 00 01 07 00 6B FF 00 07 00 04 07 00 3A 07 00 3C 07 00 6D 07 00 6B 00 01 07 00 6B FF 00 09 00 06 07 00 3A 07 00 3C 07 00 6D 05 07 00 F8 01 00 01 07 00 F8
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  39     59     69     77     Ljava/lang/Throwable;
        //  39     59     77     87     Any
        //  69     77     77     87     Any
        //  77     79     77     87     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.remove(ArrayList.java:535)
        //     at com.strobel.assembler.ir.StackMappingVisitor.pop(StackMappingVisitor.java:267)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:595)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static final void writeText(@NotNull final File $this$writeText, @NotNull final String text, @NotNull final Charset charset) {
        Intrinsics.checkNotNullParameter($this$writeText, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        final byte[] bytes = text.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        writeBytes($this$writeText, bytes);
    }
    
    public static final void appendText(@NotNull final File $this$appendText, @NotNull final String text, @NotNull final Charset charset) {
        Intrinsics.checkNotNullParameter($this$appendText, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        final byte[] bytes = text.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        appendBytes($this$appendText, bytes);
    }
    
    public static final void forEachBlock(@NotNull final File $this$forEachBlock, @NotNull final Function2<? super byte[], ? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter($this$forEachBlock, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        forEachBlock($this$forEachBlock, 4096, action);
    }
    
    public static final void forEachBlock(@NotNull final File $this$forEachBlock, final int blockSize, @NotNull final Function2<? super byte[], ? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter($this$forEachBlock, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        final byte[] arr = new byte[RangesKt___RangesKt.coerceAtLeast(blockSize, 512)];
        final FileInputStream $this$closeFinally = new FileInputStream($this$forEachBlock);
        Throwable cause = null;
        try {
            final FileInputStream input = $this$closeFinally;
            final int n = 0;
            while (true) {
                final int size = input.read(arr);
                if (size <= 0) {
                    break;
                }
                action.invoke(arr, size);
            }
            final Unit instance = Unit.INSTANCE;
        }
        catch (Throwable t) {
            cause = t;
            throw t;
        }
        finally {
            CloseableKt.closeFinally($this$closeFinally, cause);
        }
    }
    
    public static final void forEachLine(@NotNull final File $this$forEachLine, @NotNull final Charset charset, @NotNull final Function1<? super String, Unit> action) {
        Intrinsics.checkNotNullParameter($this$forEachLine, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(action, "action");
        TextStreamsKt.forEachLine(new BufferedReader(new InputStreamReader(new FileInputStream($this$forEachLine), charset)), action);
    }
    
    @InlineOnly
    private static final FileInputStream inputStream(final File $this$inputStream) {
        Intrinsics.checkNotNullParameter($this$inputStream, "<this>");
        return new FileInputStream($this$inputStream);
    }
    
    @InlineOnly
    private static final FileOutputStream outputStream(final File $this$outputStream) {
        Intrinsics.checkNotNullParameter($this$outputStream, "<this>");
        return new FileOutputStream($this$outputStream);
    }
    
    @NotNull
    public static final List<String> readLines(@NotNull final File $this$readLines, @NotNull final Charset charset) {
        Intrinsics.checkNotNullParameter($this$readLines, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        final ArrayList result = new ArrayList();
        forEachLine($this$readLines, charset, (Function1<? super String, Unit>)new FilesKt__FileReadWriteKt$readLines.FilesKt__FileReadWriteKt$readLines$1(result));
        return (List<String>)result;
    }
    
    public static final <T> T useLines(@NotNull final File $this$useLines, @NotNull final Charset charset, @NotNull final Function1<? super Sequence<String>, ? extends T> block) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* charset */
        //     7: ldc             "charset"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: aload_2         /* block */
        //    13: ldc_w           "block"
        //    16: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    19: iconst_0       
        //    20: istore_3        /* $i$f$useLines */
        //    21: aload_0         /* $this$useLines */
        //    22: astore          4
        //    24: sipush          8192
        //    27: istore          5
        //    29: aload           4
        //    31: astore          6
        //    33: new             Ljava/io/InputStreamReader;
        //    36: dup            
        //    37: new             Ljava/io/FileInputStream;
        //    40: dup            
        //    41: aload           6
        //    43: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    46: checkcast       Ljava/io/InputStream;
        //    49: aload_1         /* charset */
        //    50: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
        //    53: checkcast       Ljava/io/Reader;
        //    56: astore          6
        //    58: aload           6
        //    60: instanceof      Ljava/io/BufferedReader;
        //    63: ifeq            74
        //    66: aload           6
        //    68: checkcast       Ljava/io/BufferedReader;
        //    71: goto            85
        //    74: new             Ljava/io/BufferedReader;
        //    77: dup            
        //    78: aload           6
        //    80: iload           5
        //    82: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;I)V
        //    85: checkcast       Ljava/io/Closeable;
        //    88: astore          4
        //    90: aconst_null    
        //    91: astore          5
        //    93: nop            
        //    94: aload           4
        //    96: checkcast       Ljava/io/BufferedReader;
        //    99: astore          it
        //   101: iconst_0       
        //   102: istore          $i$a$-use-FilesKt__FileReadWriteKt$useLines$1
        //   104: aload_2         /* block */
        //   105: aload           it
        //   107: invokestatic    kotlin/io/TextStreamsKt.lineSequence:(Ljava/io/BufferedReader;)Lkotlin/sequences/Sequence;
        //   110: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   115: astore          null
        //   117: iconst_1       
        //   118: invokestatic    kotlin/jvm/internal/InlineMarker.finallyStart:(I)V
        //   121: aload           4
        //   123: aload           5
        //   125: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //   128: iconst_1       
        //   129: invokestatic    kotlin/jvm/internal/InlineMarker.finallyEnd:(I)V
        //   132: aload           6
        //   134: goto            166
        //   137: astore          6
        //   139: aload           6
        //   141: astore          5
        //   143: aload           6
        //   145: athrow         
        //   146: astore          6
        //   148: iconst_1       
        //   149: invokestatic    kotlin/jvm/internal/InlineMarker.finallyStart:(I)V
        //   152: aload           4
        //   154: aload           5
        //   156: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //   159: iconst_1       
        //   160: invokestatic    kotlin/jvm/internal/InlineMarker.finallyEnd:(I)V
        //   163: aload           6
        //   165: athrow         
        //   166: areturn        
        //    Signature:
        //  <T:Ljava/lang/Object;>(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1<-Lkotlin/sequences/Sequence<Ljava/lang/String;>;+TT;>;)TT;
        //    StackMapTable: 00 05 FF 00 4A 00 07 07 00 3A 07 00 3C 07 01 5C 01 07 00 3A 01 07 00 2D 00 00 4A 07 00 2F FF 00 33 00 07 07 00 3A 07 00 3C 07 01 5C 01 07 00 6D 05 07 00 3E 00 01 07 00 6B FF 00 08 00 07 07 00 3A 07 00 3C 07 01 5C 01 07 00 6D 07 00 6B 07 00 3E 00 01 07 00 6B FF 00 13 00 08 07 00 3A 07 00 3C 07 01 5C 01 07 00 6D 05 07 00 3E 01 00 01 07 00 3E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  93     117    137    146    Ljava/lang/Throwable;
        //  93     117    146    166    Any
        //  137    146    146    166    Any
        //  146    148    146    166    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.remove(ArrayList.java:535)
        //     at com.strobel.assembler.ir.StackMappingVisitor.pop(StackMappingVisitor.java:267)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:595)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public FilesKt__FileReadWriteKt() {
    }
}
