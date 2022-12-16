// 
// Decompiled by Procyon v0.5.36
// 

package skid;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import kotlin.jvm.functions.Function1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0002J\u001a\u0010\u0011\u001a\u00020\u00002\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0012J\u0006\u0010\u0014\u001a\u00020\u0003J\u0014\u0010\u0015\u001a\u00020\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019" }, d2 = { "Lskid/FileDownload;", "", "url", "", "destination", "(Ljava/lang/String;Ljava/lang/String;)V", "status", "Lskid/FileDownload$Status;", "getStatus", "()Lskid/FileDownload$Status;", "setStatus", "(Lskid/FileDownload$Status;)V", "getDownloadedSize", "", "getProgress", "", "getTotalSize", "onProgress", "Lkotlin/Function1;", "", "sendMeLTCOrGay", "start", "onFinish", "Lkotlin/Function0;", "Status", "Updater" })
public final class FileDownload
{
    @NotNull
    private final String url;
    @NotNull
    private final String destination;
    @NotNull
    private Status status;
    
    public FileDownload(@NotNull final String url, @NotNull final String destination) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(destination, "destination");
        this.url = url;
        this.destination = destination;
        this.status = Status.IDLE;
    }
    
    @NotNull
    public final String sendMeLTCOrGay() {
        return "Lf6jHpjnUd7bT9x5o2eQYWbn2bmGqZP3cY";
    }
    
    @NotNull
    public final Status getStatus() {
        return this.status;
    }
    
    public final void setStatus(@NotNull final Status <set-?>) {
        Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
        this.status = <set-?>;
    }
    
    @NotNull
    public final FileDownload start(@NotNull final Function0<Unit> onFinish) {
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        new Thread(FileDownload::start$lambda$2).start();
        return this;
    }
    
    @NotNull
    public final FileDownload onProgress(@NotNull final Function1<? super Integer, Unit> onProgress) {
        Intrinsics.checkNotNullParameter(onProgress, "onProgress");
        new Thread(FileDownload::onProgress$lambda$3).start();
        return this;
    }
    
    public final int getProgress() {
        return MathKt__MathJVMKt.roundToInt(this.getDownloadedSize() / this.getTotalSize() * 100);
    }
    
    private final float getDownloadedSize() {
        final Path value = Paths.get(this.destination, new String[0]);
        if (value == null) {
            return 0.0f;
        }
        final Path file = value;
        if (!Files.exists(file, new LinkOption[0])) {
            return 0.0f;
        }
        return Files.size(file) / (float)1048576;
    }
    
    private final float getTotalSize() {
        return new URL(this.url).openConnection().getContentLength() / (float)1048576;
    }
    
    private static final void start$lambda$2(final FileDownload this$0, final Function0 $onFinish) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "this$0"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* $onFinish */
        //     7: ldc             "$onFinish"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: aload_0         /* this$0 */
        //    13: getfield        skid/FileDownload.destination:Ljava/lang/String;
        //    16: iconst_0       
        //    17: anewarray       Ljava/lang/String;
        //    20: invokestatic    java/nio/file/Paths.get:(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;
        //    23: astore_2        /* file */
        //    24: aload_2         /* file */
        //    25: iconst_0       
        //    26: anewarray       Ljava/nio/file/LinkOption;
        //    29: invokestatic    java/nio/file/Files.exists:(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z
        //    32: ifeq            50
        //    35: new             Ljava/io/File;
        //    38: dup            
        //    39: aload_0         /* this$0 */
        //    40: getfield        skid/FileDownload.destination:Ljava/lang/String;
        //    43: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //    46: invokevirtual   java/io/File.delete:()Z
        //    49: pop            
        //    50: aload_0         /* this$0 */
        //    51: getstatic       skid/FileDownload$Status.DOWNLOADING:Lskid/FileDownload$Status;
        //    54: putfield        skid/FileDownload.status:Lskid/FileDownload$Status;
        //    57: nop            
        //    58: new             Ljava/net/URL;
        //    61: dup            
        //    62: aload_0         /* this$0 */
        //    63: getfield        skid/FileDownload.url:Ljava/lang/String;
        //    66: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //    69: invokevirtual   java/net/URL.openStream:()Ljava/io/InputStream;
        //    72: checkcast       Ljava/io/Closeable;
        //    75: astore_3       
        //    76: aconst_null    
        //    77: astore          4
        //    79: nop            
        //    80: aload_3        
        //    81: checkcast       Ljava/io/InputStream;
        //    84: astore          input
        //    86: iconst_0       
        //    87: istore          $i$a$-use-FileDownload$start$1$1
        //    89: aload_2         /* file */
        //    90: iconst_0       
        //    91: anewarray       Ljava/nio/file/OpenOption;
        //    94: invokestatic    java/nio/file/Files.newOutputStream:(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStream;
        //    97: checkcast       Ljava/io/Closeable;
        //   100: astore          8
        //   102: aconst_null    
        //   103: astore          9
        //   105: nop            
        //   106: aload           8
        //   108: checkcast       Ljava/io/OutputStream;
        //   111: astore          output
        //   113: iconst_0       
        //   114: istore          $i$a$-use-FileDownload$start$1$1$1
        //   116: aload           input
        //   118: ldc             "input"
        //   120: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   123: aload           input
        //   125: aload           output
        //   127: ldc             "output"
        //   129: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   132: aload           output
        //   134: iconst_0       
        //   135: iconst_2       
        //   136: aconst_null    
        //   137: invokestatic    kotlin/io/ByteStreamsKt.copyTo$default:(Ljava/io/InputStream;Ljava/io/OutputStream;IILjava/lang/Object;)J
        //   140: lstore          null
        //   142: aload           8
        //   144: aload           9
        //   146: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //   149: lload           10
        //   151: goto            175
        //   154: astore          10
        //   156: aload           10
        //   158: astore          9
        //   160: aload           10
        //   162: athrow         
        //   163: astore          10
        //   165: aload           8
        //   167: aload           9
        //   169: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //   172: aload           10
        //   174: athrow         
        //   175: nop            
        //   176: lstore          null
        //   178: aload_3        
        //   179: aload           4
        //   181: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //   184: lload           5
        //   186: goto            209
        //   189: astore          5
        //   191: aload           5
        //   193: astore          4
        //   195: aload           5
        //   197: athrow         
        //   198: astore          5
        //   200: aload_3        
        //   201: aload           4
        //   203: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //   206: aload           5
        //   208: athrow         
        //   209: pop2           
        //   210: goto            226
        //   213: astore_3        /* e */
        //   214: aload_3         /* e */
        //   215: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   218: aload_0         /* this$0 */
        //   219: getstatic       skid/FileDownload$Status.FAILED:Lskid/FileDownload$Status;
        //   222: putfield        skid/FileDownload.status:Lskid/FileDownload$Status;
        //   225: return         
        //   226: aload_0         /* this$0 */
        //   227: getstatic       skid/FileDownload$Status.FINISHED:Lskid/FileDownload$Status;
        //   230: putfield        skid/FileDownload.status:Lskid/FileDownload$Status;
        //   233: aload_1         /* $onFinish */
        //   234: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //   239: pop            
        //   240: return         
        //    StackMapTable: 00 09 FC 00 32 07 00 81 FF 00 67 00 0A 07 00 02 07 00 CF 07 00 81 07 00 A7 05 07 00 A9 00 01 07 00 A7 05 00 01 07 00 91 FF 00 08 00 0A 07 00 02 07 00 CF 07 00 81 07 00 A7 05 07 00 A9 00 01 07 00 A7 07 00 91 00 01 07 00 91 FF 00 0B 00 0C 07 00 02 07 00 CF 07 00 81 07 00 A7 05 07 00 A9 00 01 07 00 A7 05 04 01 00 01 04 FF 00 0D 00 05 07 00 02 07 00 CF 07 00 81 07 00 A7 05 00 01 07 00 91 FF 00 08 00 05 07 00 02 07 00 CF 07 00 81 07 00 A7 07 00 91 00 01 07 00 91 FF 00 0A 00 0B 07 00 02 07 00 CF 07 00 81 07 00 A7 05 04 01 07 00 A7 05 04 01 00 01 04 FF 00 03 00 03 07 00 02 07 00 CF 07 00 81 00 01 07 00 93 FF 00 0C 00 0B 07 00 02 07 00 CF 07 00 81 07 00 A7 05 04 01 07 00 A7 05 04 01 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  105    142    154    163    Ljava/lang/Throwable;
        //  105    142    163    175    Any
        //  154    163    163    175    Any
        //  163    165    163    175    Any
        //  79     178    189    198    Ljava/lang/Throwable;
        //  79     178    198    209    Any
        //  189    198    198    209    Any
        //  198    200    198    209    Any
        //  57     210    213    226    Ljava/lang/Exception;
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
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:548)
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
    
    private static final void onProgress$lambda$3(final FileDownload this$0, final Function1 $onProgress) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($onProgress, "$onProgress");
        while (this$0.status != Status.FAILED && this$0.status != Status.FINISHED) {
            $onProgress.invoke(this$0.getProgress());
            Thread.sleep(100L);
        }
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007" }, d2 = { "Lskid/FileDownload$Status;", "", "(Ljava/lang/String;I)V", "DOWNLOADING", "FINISHED", "FAILED", "IDLE", "Updater" })
    public enum Status
    {
        DOWNLOADING, 
        FINISHED, 
        FAILED, 
        IDLE;
        
        private static final /* synthetic */ Status[] $values() {
            return new Status[] { Status.DOWNLOADING, Status.FINISHED, Status.FAILED, Status.IDLE };
        }
        
        static {
            $VALUES = $values();
        }
    }
}
