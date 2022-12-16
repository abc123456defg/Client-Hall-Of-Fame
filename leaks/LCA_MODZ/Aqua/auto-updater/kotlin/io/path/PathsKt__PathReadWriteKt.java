// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.io.path;

import java.util.List;
import java.io.InputStream;
import java.util.Iterator;
import kotlin.sequences.Sequence;
import kotlin.jvm.internal.InlineMarker;
import kotlin.io.TextStreamsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import java.io.OutputStream;
import java.io.Closeable;
import kotlin.io.CloseableKt;
import org.jetbrains.annotations.NotNull;
import java.nio.file.StandardOpenOption;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.BufferedReader;
import kotlin.text.Charsets;
import kotlin.internal.InlineOnly;
import kotlin.WasExperimental;
import kotlin.SinceKotlin;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import java.io.InputStreamReader;
import java.nio.file.OpenOption;
import java.nio.charset.Charset;
import java.nio.file.Path;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u001e\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a:\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010\u0015\u001a:\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010\u0018\u001a=\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00010\u001bH\u0087\b\u00f8\u0001\u0000\u001a&\u0010 \u001a\u00020!*\u00020\u00022\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010\"\u001a&\u0010#\u001a\u00020$*\u00020\u00022\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010%\u001a\r\u0010&\u001a\u00020\u0004*\u00020\u0002H\u0087\b\u001a\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0(*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0016\u0010)\u001a\u00020\u001c*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a0\u0010*\u001a\u00020+*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010,\u001a?\u0010-\u001a\u0002H.\"\u0004\b\u0000\u0010.*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0018\u0010/\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u000b\u0012\u0004\u0012\u0002H.0\u001bH\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u00100\u001a.\u00101\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u00102\u001a>\u00103\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u00104\u001a>\u00103\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u00105\u001a7\u00106\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007¢\u0006\u0002\u00107\u001a0\u00108\u001a\u000209*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0087\b¢\u0006\u0002\u0010:\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006;" }, d2 = { "appendBytes", "", "Ljava/nio/file/Path;", "array", "", "appendLines", "lines", "", "", "charset", "Ljava/nio/charset/Charset;", "Lkotlin/sequences/Sequence;", "appendText", "text", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedReader;", "bufferedWriter", "Ljava/io/BufferedWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedWriter;", "forEachLine", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "line", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStream;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/InputStreamReader;", "useLines", "T", "block", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "(Ljava/nio/file/Path;[B[Ljava/nio/file/OpenOption;)V", "writeLines", "(Ljava/nio/file/Path;Ljava/lang/Iterable;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "(Ljava/nio/file/Path;Lkotlin/sequences/Sequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "writeText", "(Ljava/nio/file/Path;Ljava/lang/CharSequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)V", "writer", "Ljava/io/OutputStreamWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStreamWriter;", "kotlin-stdlib-jdk7" }, xs = "kotlin/io/path/PathsKt")
class PathsKt__PathReadWriteKt
{
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final InputStreamReader reader(final Path $this$reader, final Charset charset, final OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$reader, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        return new InputStreamReader(Files.newInputStream($this$reader, (OpenOption[])Arrays.copyOf(options, options.length)), charset);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final BufferedReader bufferedReader(final Path $this$bufferedReader, final Charset charset, final int bufferSize, final OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$bufferedReader, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream($this$bufferedReader, (OpenOption[])Arrays.copyOf(options, options.length)), charset), bufferSize);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final OutputStreamWriter writer(final Path $this$writer, final Charset charset, final OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$writer, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        return new OutputStreamWriter(Files.newOutputStream($this$writer, (OpenOption[])Arrays.copyOf(options, options.length)), charset);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final BufferedWriter bufferedWriter(final Path $this$bufferedWriter, final Charset charset, final int bufferSize, final OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$bufferedWriter, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream($this$bufferedWriter, (OpenOption[])Arrays.copyOf(options, options.length)), charset), bufferSize);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final byte[] readBytes(final Path $this$readBytes) throws IOException {
        Intrinsics.checkNotNullParameter($this$readBytes, "<this>");
        final byte[] allBytes = Files.readAllBytes($this$readBytes);
        Intrinsics.checkNotNullExpressionValue(allBytes, "readAllBytes(this)");
        return allBytes;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final void writeBytes(final Path $this$writeBytes, final byte[] array, final OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$writeBytes, "<this>");
        Intrinsics.checkNotNullParameter(array, "array");
        Intrinsics.checkNotNullParameter(options, "options");
        Files.write($this$writeBytes, array, (OpenOption[])Arrays.copyOf(options, options.length));
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final void appendBytes(final Path $this$appendBytes, final byte[] array) throws IOException {
        Intrinsics.checkNotNullParameter($this$appendBytes, "<this>");
        Intrinsics.checkNotNullParameter(array, "array");
        Files.write($this$appendBytes, array, StandardOpenOption.APPEND);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @NotNull
    public static final String readText(@NotNull final Path $this$readText, @NotNull final Charset charset) throws IOException {
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
        //    14: iconst_0       
        //    15: anewarray       Ljava/nio/file/OpenOption;
        //    18: astore_3       
        //    19: new             Ljava/io/InputStreamReader;
        //    22: dup            
        //    23: aload_2        
        //    24: aload_3        
        //    25: aload_3        
        //    26: arraylength    
        //    27: invokestatic    java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //    30: checkcast       [Ljava/nio/file/OpenOption;
        //    33: invokestatic    java/nio/file/Files.newInputStream:(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/InputStream;
        //    36: aload_1         /* charset */
        //    37: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
        //    40: checkcast       Ljava/io/Closeable;
        //    43: astore_2       
        //    44: aconst_null    
        //    45: astore_3       
        //    46: nop            
        //    47: aload_2        
        //    48: checkcast       Ljava/io/InputStreamReader;
        //    51: astore          it
        //    53: iconst_0       
        //    54: istore          $i$a$-use-PathsKt__PathReadWriteKt$readText$1
        //    56: aload           it
        //    58: checkcast       Ljava/io/Reader;
        //    61: invokestatic    kotlin/io/TextStreamsKt.readText:(Ljava/io/Reader;)Ljava/lang/String;
        //    64: astore          null
        //    66: aload_2        
        //    67: aload_3        
        //    68: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //    71: aload           4
        //    73: goto            94
        //    76: astore          4
        //    78: aload           4
        //    80: astore_3       
        //    81: aload           4
        //    83: athrow         
        //    84: astore          4
        //    86: aload_2        
        //    87: aload_3        
        //    88: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //    91: aload           4
        //    93: athrow         
        //    94: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 03 FF 00 4C 00 04 07 00 9D 07 00 9F 07 00 8C 05 00 01 07 00 8A FF 00 07 00 04 07 00 9D 07 00 9F 07 00 8C 07 00 8A 00 01 07 00 8A FF 00 09 00 06 07 00 9D 07 00 9F 07 00 8C 05 07 00 A1 01 00 01 07 00 A1
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  46     66     76     84     Ljava/lang/Throwable;
        //  46     66     84     94     Any
        //  76     84     84     94     Any
        //  84     86     84     94     Any
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
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    public static final void writeText(@NotNull final Path $this$writeText, @NotNull final CharSequence text, @NotNull final Charset charset, @NotNull final OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$writeText, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        final OutputStream outputStream = Files.newOutputStream($this$writeText, (OpenOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(outputStream, "newOutputStream(this, *options)");
        final OutputStreamWriter $this$closeFinally = new OutputStreamWriter(outputStream, charset);
        Throwable cause = null;
        try {
            final OutputStreamWriter it = $this$closeFinally;
            final int n = 0;
            it.append(text);
        }
        catch (Throwable t) {
            cause = t;
            throw t;
        }
        finally {
            CloseableKt.closeFinally($this$closeFinally, cause);
        }
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    public static final void appendText(@NotNull final Path $this$appendText, @NotNull final CharSequence text, @NotNull final Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter($this$appendText, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        final OutputStream outputStream = Files.newOutputStream($this$appendText, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(outputStream, "newOutputStream(this, StandardOpenOption.APPEND)");
        final OutputStreamWriter $this$closeFinally = new OutputStreamWriter(outputStream, charset);
        Throwable cause = null;
        try {
            final OutputStreamWriter it = $this$closeFinally;
            final int n = 0;
            it.append(text);
        }
        catch (Throwable t) {
            cause = t;
            throw t;
        }
        finally {
            CloseableKt.closeFinally($this$closeFinally, cause);
        }
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final void forEachLine(final Path $this$forEachLine, final Charset charset, final Function1<? super String, Unit> action) throws IOException {
        Intrinsics.checkNotNullParameter($this$forEachLine, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(action, "action");
        final BufferedReader bufferedReader = Files.newBufferedReader($this$forEachLine, charset);
        Intrinsics.checkNotNullExpressionValue(bufferedReader, "newBufferedReader(this, charset)");
        final Reader $this$useLines$iv = bufferedReader;
        final int $i$f$useLines = 0;
        final BufferedReader $this$closeFinally = (BufferedReader)$this$useLines$iv;
        Throwable cause = null;
        try {
            final BufferedReader it$iv = $this$closeFinally;
            final int n = 0;
            final Sequence it = TextStreamsKt.lineSequence(it$iv);
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
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally($this$closeFinally, cause);
            InlineMarker.finallyEnd(1);
        }
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final InputStream inputStream(final Path $this$inputStream, final OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$inputStream, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        final InputStream inputStream = Files.newInputStream($this$inputStream, (OpenOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(inputStream, "newInputStream(this, *options)");
        return inputStream;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final OutputStream outputStream(final Path $this$outputStream, final OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$outputStream, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        final OutputStream outputStream = Files.newOutputStream($this$outputStream, (OpenOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(outputStream, "newOutputStream(this, *options)");
        return outputStream;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final List<String> readLines(final Path $this$readLines, final Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter($this$readLines, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        final List<String> allLines = Files.readAllLines($this$readLines, charset);
        Intrinsics.checkNotNullExpressionValue(allLines, "readAllLines(this, charset)");
        return allLines;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final <T> T useLines(final Path $this$useLines, final Charset charset, final Function1<? super Sequence<String>, ? extends T> block) throws IOException {
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
        //    19: aload_0         /* $this$useLines */
        //    20: aload_1         /* charset */
        //    21: invokestatic    java/nio/file/Files.newBufferedReader:(Ljava/nio/file/Path;Ljava/nio/charset/Charset;)Ljava/io/BufferedReader;
        //    24: checkcast       Ljava/io/Closeable;
        //    27: astore_3       
        //    28: aconst_null    
        //    29: astore          4
        //    31: nop            
        //    32: aload_3        
        //    33: checkcast       Ljava/io/BufferedReader;
        //    36: astore          it
        //    38: iconst_0       
        //    39: istore          $i$a$-use-PathsKt__PathReadWriteKt$useLines$1
        //    41: aload_2         /* block */
        //    42: aload           it
        //    44: ldc_w           "it"
        //    47: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    50: aload           it
        //    52: invokestatic    kotlin/io/TextStreamsKt.lineSequence:(Ljava/io/BufferedReader;)Lkotlin/sequences/Sequence;
        //    55: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //    60: astore          null
        //    62: iconst_1       
        //    63: invokestatic    kotlin/jvm/internal/InlineMarker.finallyStart:(I)V
        //    66: aload_3        
        //    67: aload           4
        //    69: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //    72: iconst_1       
        //    73: invokestatic    kotlin/jvm/internal/InlineMarker.finallyEnd:(I)V
        //    76: aload           5
        //    78: goto            109
        //    81: astore          5
        //    83: aload           5
        //    85: astore          4
        //    87: aload           5
        //    89: athrow         
        //    90: astore          5
        //    92: iconst_1       
        //    93: invokestatic    kotlin/jvm/internal/InlineMarker.finallyStart:(I)V
        //    96: aload_3        
        //    97: aload           4
        //    99: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //   102: iconst_1       
        //   103: invokestatic    kotlin/jvm/internal/InlineMarker.finallyEnd:(I)V
        //   106: aload           5
        //   108: athrow         
        //   109: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    Signature:
        //  <T:Ljava/lang/Object;>(Ljava/nio/file/Path;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1<-Lkotlin/sequences/Sequence<Ljava/lang/String;>;+TT;>;)TT;
        //    StackMapTable: 00 03 FF 00 51 00 05 07 00 9D 07 00 9F 07 00 E6 07 00 8C 05 00 01 07 00 8A FF 00 08 00 05 07 00 9D 07 00 9F 07 00 E6 07 00 8C 07 00 8A 00 01 07 00 8A FF 00 12 00 07 07 00 9D 07 00 9F 07 00 E6 07 00 8C 05 07 00 04 01 00 01 07 00 04
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  31     62     81     90     Ljava/lang/Throwable;
        //  31     62     90     109    Any
        //  81     90     90     109    Any
        //  90     92     90     109    Any
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
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path writeLines(final Path $this$writeLines, final Iterable<? extends CharSequence> lines, final Charset charset, final OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$writeLines, "<this>");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        final Path write = Files.write($this$writeLines, lines, charset, (OpenOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(write, "write(this, lines, charset, *options)");
        return write;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path writeLines(final Path $this$writeLines, final Sequence<? extends CharSequence> lines, final Charset charset, final OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$writeLines, "<this>");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        final Path write = Files.write($this$writeLines, SequencesKt___SequencesKt.asIterable(lines), charset, (OpenOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(write, "write(this, lines.asIterable(), charset, *options)");
        return write;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path appendLines(final Path $this$appendLines, final Iterable<? extends CharSequence> lines, final Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter($this$appendLines, "<this>");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(charset, "charset");
        final Path write = Files.write($this$appendLines, lines, charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(write, "write(this, lines, chars\u2026tandardOpenOption.APPEND)");
        return write;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path appendLines(final Path $this$appendLines, final Sequence<? extends CharSequence> lines, final Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter($this$appendLines, "<this>");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(charset, "charset");
        final Path write = Files.write($this$appendLines, SequencesKt___SequencesKt.asIterable(lines), charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(write, "write(this, lines.asIter\u2026tandardOpenOption.APPEND)");
        return write;
    }
    
    public PathsKt__PathReadWriteKt() {
    }
}
