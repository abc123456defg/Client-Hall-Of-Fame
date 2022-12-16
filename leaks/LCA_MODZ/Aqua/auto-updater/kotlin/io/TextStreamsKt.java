// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.io;

import kotlin.text.Charsets;
import java.nio.charset.Charset;
import java.net.URL;
import java.io.StringWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import kotlin.sequences.Sequence;
import java.io.Closeable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import java.io.BufferedWriter;
import java.io.Writer;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import java.io.BufferedReader;
import java.io.Reader;
import kotlin.jvm.JvmName;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r\u001a\u0010\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013\u001a\u0010\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015*\u00020\u0002\u001a\n\u0010\u0016\u001a\u00020\u000e*\u00020\u0002\u001a\u0017\u0010\u0016\u001a\u00020\u000e*\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u001a*\u00020\u000eH\u0087\b\u001a5\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c*\u00020\u00022\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0010\u0012\u0004\u0012\u0002H\u001c0\rH\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f" }, d2 = { "buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "copyTo", "", "out", "forEachLine", "", "action", "Lkotlin/Function1;", "", "lineSequence", "Lkotlin/sequences/Sequence;", "readBytes", "", "Ljava/net/URL;", "readLines", "", "readText", "charset", "Ljava/nio/charset/Charset;", "reader", "Ljava/io/StringReader;", "useLines", "T", "block", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib" })
@JvmName(name = "TextStreamsKt")
public final class TextStreamsKt
{
    @InlineOnly
    private static final BufferedReader buffered(final Reader $this$buffered, final int bufferSize) {
        Intrinsics.checkNotNullParameter($this$buffered, "<this>");
        return (BufferedReader)(($this$buffered instanceof BufferedReader) ? $this$buffered : new BufferedReader($this$buffered, bufferSize));
    }
    
    @InlineOnly
    private static final BufferedWriter buffered(final Writer $this$buffered, final int bufferSize) {
        Intrinsics.checkNotNullParameter($this$buffered, "<this>");
        return (BufferedWriter)(($this$buffered instanceof BufferedWriter) ? $this$buffered : new BufferedWriter($this$buffered, bufferSize));
    }
    
    public static final void forEachLine(@NotNull final Reader $this$forEachLine, @NotNull final Function1<? super String, Unit> action) {
        Intrinsics.checkNotNullParameter($this$forEachLine, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        final Reader $this$useLines$iv = $this$forEachLine;
        final int $i$f$useLines = 0;
        final Reader in = $this$useLines$iv;
        final int sz = 8192;
        final BufferedReader $this$closeFinally = (BufferedReader)((in instanceof BufferedReader) ? in : new BufferedReader(in, sz));
        Throwable cause = null;
        try {
            final BufferedReader it$iv = $this$closeFinally;
            final int n = 0;
            final Sequence it = lineSequence(it$iv);
            final int n2 = 0;
            final Sequence $this$forEach$iv = it;
            final int $i$f$forEach = 0;
            for (final Object element$iv : $this$forEach$iv) {
                action.invoke((Object)element$iv);
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
    
    @NotNull
    public static final List<String> readLines(@NotNull final Reader $this$readLines) {
        Intrinsics.checkNotNullParameter($this$readLines, "<this>");
        final ArrayList result = new ArrayList();
        forEachLine($this$readLines, (Function1<? super String, Unit>)new TextStreamsKt$readLines.TextStreamsKt$readLines$1(result));
        return (List<String>)result;
    }
    
    public static final <T> T useLines(@NotNull final Reader $this$useLines, @NotNull final Function1<? super Sequence<String>, ? extends T> block) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* block */
        //     7: ldc             "block"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: iconst_0       
        //    13: istore_2        /* $i$f$useLines */
        //    14: aload_0         /* $this$useLines */
        //    15: astore_3       
        //    16: sipush          8192
        //    19: istore          4
        //    21: aload_3        
        //    22: instanceof      Ljava/io/BufferedReader;
        //    25: ifeq            35
        //    28: aload_3        
        //    29: checkcast       Ljava/io/BufferedReader;
        //    32: goto            45
        //    35: new             Ljava/io/BufferedReader;
        //    38: dup            
        //    39: aload_3        
        //    40: iload           4
        //    42: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;I)V
        //    45: checkcast       Ljava/io/Closeable;
        //    48: astore_3       
        //    49: aconst_null    
        //    50: astore          4
        //    52: nop            
        //    53: aload_3        
        //    54: checkcast       Ljava/io/BufferedReader;
        //    57: astore          it
        //    59: iconst_0       
        //    60: istore          $i$a$-use-TextStreamsKt$useLines$1
        //    62: aload_1         /* block */
        //    63: aload           it
        //    65: invokestatic    kotlin/io/TextStreamsKt.lineSequence:(Ljava/io/BufferedReader;)Lkotlin/sequences/Sequence;
        //    68: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //    73: astore          null
        //    75: iconst_1       
        //    76: invokestatic    kotlin/jvm/internal/InlineMarker.finallyStart:(I)V
        //    79: aload_3        
        //    80: aload           4
        //    82: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //    85: iconst_1       
        //    86: invokestatic    kotlin/jvm/internal/InlineMarker.finallyEnd:(I)V
        //    89: aload           5
        //    91: goto            122
        //    94: astore          5
        //    96: aload           5
        //    98: astore          4
        //   100: aload           5
        //   102: athrow         
        //   103: astore          5
        //   105: iconst_1       
        //   106: invokestatic    kotlin/jvm/internal/InlineMarker.finallyStart:(I)V
        //   109: aload_3        
        //   110: aload           4
        //   112: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //   115: iconst_1       
        //   116: invokestatic    kotlin/jvm/internal/InlineMarker.finallyEnd:(I)V
        //   119: aload           5
        //   121: athrow         
        //   122: areturn        
        //    Signature:
        //  <T:Ljava/lang/Object;>(Ljava/io/Reader;Lkotlin/jvm/functions/Function1<-Lkotlin/sequences/Sequence<Ljava/lang/String;>;+TT;>;)TT;
        //    StackMapTable: 00 05 FE 00 23 01 07 00 64 01 49 07 00 11 FF 00 30 00 05 07 00 64 07 00 44 01 07 00 2E 05 00 01 07 00 2A FF 00 08 00 05 07 00 64 07 00 44 01 07 00 2E 07 00 2A 00 01 07 00 2A FF 00 12 00 07 07 00 64 07 00 44 01 07 00 2E 05 07 00 04 01 00 01 07 00 04
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  52     75     94     103    Ljava/lang/Throwable;
        //  52     75     103    122    Any
        //  94     103    103    122    Any
        //  103    105    103    122    Any
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
    
    @InlineOnly
    private static final StringReader reader(final String $this$reader) {
        Intrinsics.checkNotNullParameter($this$reader, "<this>");
        return new StringReader($this$reader);
    }
    
    @NotNull
    public static final Sequence<String> lineSequence(@NotNull final BufferedReader $this$lineSequence) {
        Intrinsics.checkNotNullParameter($this$lineSequence, "<this>");
        return SequencesKt__SequencesKt.constrainOnce((Sequence<? extends String>)new LinesSequence($this$lineSequence));
    }
    
    @NotNull
    public static final String readText(@NotNull final Reader $this$readText) {
        Intrinsics.checkNotNullParameter($this$readText, "<this>");
        final StringWriter buffer = new StringWriter();
        copyTo$default($this$readText, buffer, 0, 2, null);
        final String string = buffer.toString();
        Intrinsics.checkNotNullExpressionValue(string, "buffer.toString()");
        return string;
    }
    
    public static final long copyTo(@NotNull final Reader $this$copyTo, @NotNull final Writer out, final int bufferSize) {
        Intrinsics.checkNotNullParameter($this$copyTo, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        long charsCopied = 0L;
        final char[] buffer = new char[bufferSize];
        for (int chars = $this$copyTo.read(buffer); chars >= 0; chars = $this$copyTo.read(buffer)) {
            out.write(buffer, 0, chars);
            charsCopied += chars;
        }
        return charsCopied;
    }
    
    public static /* synthetic */ long copyTo$default(final Reader $this$copyTo, final Writer out, int bufferSize, final int n, final Object o) {
        if ((n & 0x2) != 0x0) {
            bufferSize = 8192;
        }
        return copyTo($this$copyTo, out, bufferSize);
    }
    
    @InlineOnly
    private static final String readText(final URL $this$readText, final Charset charset) {
        Intrinsics.checkNotNullParameter($this$readText, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(readBytes($this$readText), charset);
    }
    
    @NotNull
    public static final byte[] readBytes(@NotNull final URL $this$readBytes) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* $this$readBytes */
        //     7: invokevirtual   java/net/URL.openStream:()Ljava/io/InputStream;
        //    10: checkcast       Ljava/io/Closeable;
        //    13: astore_1       
        //    14: aconst_null    
        //    15: astore_2       
        //    16: nop            
        //    17: aload_1        
        //    18: checkcast       Ljava/io/InputStream;
        //    21: astore_3       
        //    22: iconst_0       
        //    23: istore          $i$a$-use-TextStreamsKt$readBytes$1
        //    25: aload_3        
        //    26: ldc             "it"
        //    28: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    31: aload_3        
        //    32: invokestatic    kotlin/io/ByteStreamsKt.readBytes:(Ljava/io/InputStream;)[B
        //    35: astore_3       
        //    36: aload_1        
        //    37: aload_2        
        //    38: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //    41: aload_3        
        //    42: goto            58
        //    45: astore_3       
        //    46: aload_3        
        //    47: astore_2       
        //    48: aload_3        
        //    49: athrow         
        //    50: astore_3       
        //    51: aload_1        
        //    52: aload_2        
        //    53: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //    56: aload_3        
        //    57: athrow         
        //    58: areturn        
        //    StackMapTable: 00 03 FF 00 2D 00 03 07 00 E1 07 00 2E 05 00 01 07 00 2A FF 00 04 00 03 07 00 E1 07 00 2E 07 00 2A 00 01 07 00 2A FF 00 07 00 05 07 00 E1 07 00 2E 05 07 00 F2 01 00 01 07 00 F2
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  16     36     45     50     Ljava/lang/Throwable;
        //  16     36     50     58     Any
        //  45     50     50     58     Any
        //  50     51     50     58     Any
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
}
