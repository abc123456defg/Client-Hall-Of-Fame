// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.io;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function1;
import java.util.List;
import kotlin.Deprecated;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import java.io.File;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0007\u001a*\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0007\u001a8\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u001a\b\u0002\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u001a&\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u001a\n\u0010\u0019\u001a\u00020\u000f*\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\n\u0010\u001c\u001a\u00020\u0002*\u00020\u0002\u001a\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d*\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0002¢\u0006\u0002\b\u001e\u001a\u0011\u0010\u001c\u001a\u00020\u001f*\u00020\u001fH\u0002¢\u0006\u0002\b\u001e\u001a\u0012\u0010 \u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0014\u0010\"\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010#\u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\u0012\u0010(\u001a\u00020\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u001b\u0010)\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002H\u0002¢\u0006\u0002\b*\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006+" }, d2 = { "extension", "", "Ljava/io/File;", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath", "nameWithoutExtension", "getNameWithoutExtension", "createTempDir", "prefix", "suffix", "directory", "createTempFile", "copyRecursively", "", "target", "overwrite", "onError", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "copyTo", "bufferSize", "", "deleteRecursively", "endsWith", "other", "normalize", "", "normalize$FilesKt__UtilsKt", "Lkotlin/io/FilePathComponents;", "relativeTo", "base", "relativeToOrNull", "relativeToOrSelf", "resolve", "relative", "resolveSibling", "startsWith", "toRelativeString", "toRelativeStringOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "kotlin-stdlib" }, xs = "kotlin/io/FilesKt")
class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt
{
    @Deprecated(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    @NotNull
    @java.lang.Deprecated
    public static final File createTempDir(@NotNull final String prefix, @Nullable final String suffix, @Nullable final File directory) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        final File dir = File.createTempFile(prefix, suffix, directory);
        dir.delete();
        if (dir.mkdir()) {
            Intrinsics.checkNotNullExpressionValue(dir, "dir");
            return dir;
        }
        throw new IOException("Unable to create temporary directory " + dir + '.');
    }
    
    @Deprecated(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    @NotNull
    @java.lang.Deprecated
    public static final File createTempFile(@NotNull final String prefix, @Nullable final String suffix, @Nullable final File directory) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        final File tempFile = File.createTempFile(prefix, suffix, directory);
        Intrinsics.checkNotNullExpressionValue(tempFile, "createTempFile(prefix, suffix, directory)");
        return tempFile;
    }
    
    @NotNull
    public static final String getExtension(@NotNull final File $this$extension) {
        Intrinsics.checkNotNullParameter($this$extension, "<this>");
        final String name = $this$extension.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return StringsKt__StringsKt.substringAfterLast(name, '.', "");
    }
    
    @NotNull
    public static final String getInvariantSeparatorsPath(@NotNull final File $this$invariantSeparatorsPath) {
        Intrinsics.checkNotNullParameter($this$invariantSeparatorsPath, "<this>");
        String s;
        if (File.separatorChar != '/') {
            final String path = $this$invariantSeparatorsPath.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "path");
            s = StringsKt__StringsJVMKt.replace$default(path, File.separatorChar, '/', false, 4, null);
        }
        else {
            Intrinsics.checkNotNullExpressionValue(s = $this$invariantSeparatorsPath.getPath(), "path");
        }
        return s;
    }
    
    @NotNull
    public static final String getNameWithoutExtension(@NotNull final File $this$nameWithoutExtension) {
        Intrinsics.checkNotNullParameter($this$nameWithoutExtension, "<this>");
        final String name = $this$nameWithoutExtension.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return StringsKt__StringsKt.substringBeforeLast$default(name, ".", null, 2, null);
    }
    
    @NotNull
    public static final String toRelativeString(@NotNull final File $this$toRelativeString, @NotNull final File base) {
        Intrinsics.checkNotNullParameter($this$toRelativeString, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        final String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt($this$toRelativeString, base);
        if (relativeStringOrNull$FilesKt__UtilsKt == null) {
            throw new IllegalArgumentException("this and base files have different roots: " + $this$toRelativeString + " and " + base + '.');
        }
        return relativeStringOrNull$FilesKt__UtilsKt;
    }
    
    @NotNull
    public static final File relativeTo(@NotNull final File $this$relativeTo, @NotNull final File base) {
        Intrinsics.checkNotNullParameter($this$relativeTo, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        return new File(toRelativeString($this$relativeTo, base));
    }
    
    @NotNull
    public static final File relativeToOrSelf(@NotNull final File $this$relativeToOrSelf, @NotNull final File base) {
        Intrinsics.checkNotNullParameter($this$relativeToOrSelf, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        final String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt($this$relativeToOrSelf, base);
        File file;
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            final String p0 = relativeStringOrNull$FilesKt__UtilsKt;
            final int n = 0;
            file = new File(p0);
        }
        else {
            file = $this$relativeToOrSelf;
        }
        return file;
    }
    
    @Nullable
    public static final File relativeToOrNull(@NotNull final File $this$relativeToOrNull, @NotNull final File base) {
        Intrinsics.checkNotNullParameter($this$relativeToOrNull, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        final String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt($this$relativeToOrNull, base);
        File file;
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            final String p0 = relativeStringOrNull$FilesKt__UtilsKt;
            final int n = 0;
            file = new File(p0);
        }
        else {
            file = null;
        }
        return file;
    }
    
    private static final String toRelativeStringOrNull$FilesKt__UtilsKt(final File $this$toRelativeStringOrNull, final File base) {
        final FilePathComponents thisComponents = normalize$FilesKt__UtilsKt(FilesKt__FilePathComponentsKt.toComponents($this$toRelativeStringOrNull));
        final FilePathComponents baseComponents = normalize$FilesKt__UtilsKt(FilesKt__FilePathComponentsKt.toComponents(base));
        if (!Intrinsics.areEqual(thisComponents.getRoot(), baseComponents.getRoot())) {
            return null;
        }
        final int baseCount = baseComponents.getSize();
        final int thisCount = thisComponents.getSize();
        final File $this$toRelativeStringOrNull_u24lambda_u241 = $this$toRelativeStringOrNull;
        final int n = 0;
        int i = 0;
        for (int maxSameCount = Math.min(thisCount, baseCount); i < maxSameCount && Intrinsics.areEqual(thisComponents.getSegments().get(i), baseComponents.getSegments().get(i)); ++i) {}
        final int sameCount = i;
        final StringBuilder res = new StringBuilder();
        int j = baseCount - 1;
        Label_0198: {
            if (sameCount <= j) {
                while (!Intrinsics.areEqual(baseComponents.getSegments().get(j).getName(), "..")) {
                    res.append("..");
                    if (j != sameCount) {
                        res.append(File.separatorChar);
                    }
                    if (j == sameCount) {
                        break Label_0198;
                    }
                    --j;
                }
                return null;
            }
        }
        if (sameCount < thisCount) {
            if (sameCount < baseCount) {
                res.append(File.separatorChar);
            }
            final List<Object> list = CollectionsKt___CollectionsKt.drop((Iterable<?>)thisComponents.getSegments(), sameCount);
            final StringBuilder sb = res;
            final String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            CollectionsKt___CollectionsKt.joinTo$default(list, sb, separator, null, null, 0, null, null, 124, null);
        }
        return res.toString();
    }
    
    @NotNull
    public static final File copyTo(@NotNull final File $this$copyTo, @NotNull final File target, final boolean overwrite, final int bufferSize) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* target */
        //     7: ldc             "target"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: aload_0         /* $this$copyTo */
        //    13: invokevirtual   java/io/File.exists:()Z
        //    16: ifne            33
        //    19: new             Lkotlin/io/NoSuchFileException;
        //    22: dup            
        //    23: aload_0         /* $this$copyTo */
        //    24: aconst_null    
        //    25: ldc             "The source file doesn't exist."
        //    27: iconst_2       
        //    28: aconst_null    
        //    29: invokespecial   kotlin/io/NoSuchFileException.<init>:(Ljava/io/File;Ljava/io/File;Ljava/lang/String;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
        //    32: athrow         
        //    33: aload_1         /* target */
        //    34: invokevirtual   java/io/File.exists:()Z
        //    37: ifeq            75
        //    40: iload_2         /* overwrite */
        //    41: ifne            56
        //    44: new             Lkotlin/io/FileAlreadyExistsException;
        //    47: dup            
        //    48: aload_0         /* $this$copyTo */
        //    49: aload_1         /* target */
        //    50: ldc             "The destination file already exists."
        //    52: invokespecial   kotlin/io/FileAlreadyExistsException.<init>:(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V
        //    55: athrow         
        //    56: aload_1         /* target */
        //    57: invokevirtual   java/io/File.delete:()Z
        //    60: ifne            75
        //    63: new             Lkotlin/io/FileAlreadyExistsException;
        //    66: dup            
        //    67: aload_0         /* $this$copyTo */
        //    68: aload_1         /* target */
        //    69: ldc             "Tried to overwrite the destination, but failed to delete it."
        //    71: invokespecial   kotlin/io/FileAlreadyExistsException.<init>:(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V
        //    74: athrow         
        //    75: aload_0         /* $this$copyTo */
        //    76: invokevirtual   java/io/File.isDirectory:()Z
        //    79: ifeq            102
        //    82: aload_1         /* target */
        //    83: invokevirtual   java/io/File.mkdirs:()Z
        //    86: ifne            258
        //    89: new             Lkotlin/io/FileSystemException;
        //    92: dup            
        //    93: aload_0         /* $this$copyTo */
        //    94: aload_1         /* target */
        //    95: ldc_w           "Failed to create target directory."
        //    98: invokespecial   kotlin/io/FileSystemException.<init>:(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V
        //   101: athrow         
        //   102: aload_1         /* target */
        //   103: invokevirtual   java/io/File.getParentFile:()Ljava/io/File;
        //   106: dup            
        //   107: ifnull          117
        //   110: invokevirtual   java/io/File.mkdirs:()Z
        //   113: pop            
        //   114: goto            118
        //   117: pop            
        //   118: new             Ljava/io/FileInputStream;
        //   121: dup            
        //   122: aload_0         /* $this$copyTo */
        //   123: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //   126: checkcast       Ljava/io/Closeable;
        //   129: astore          4
        //   131: aconst_null    
        //   132: astore          5
        //   134: nop            
        //   135: aload           4
        //   137: checkcast       Ljava/io/FileInputStream;
        //   140: astore          input
        //   142: iconst_0       
        //   143: istore          $i$a$-use-FilesKt__UtilsKt$copyTo$1
        //   145: new             Ljava/io/FileOutputStream;
        //   148: dup            
        //   149: aload_1         /* target */
        //   150: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //   153: checkcast       Ljava/io/Closeable;
        //   156: astore          9
        //   158: aconst_null    
        //   159: astore          10
        //   161: nop            
        //   162: aload           9
        //   164: checkcast       Ljava/io/FileOutputStream;
        //   167: astore          output
        //   169: iconst_0       
        //   170: istore          $i$a$-use-FilesKt__UtilsKt$copyTo$1$1
        //   172: aload           input
        //   174: checkcast       Ljava/io/InputStream;
        //   177: aload           output
        //   179: checkcast       Ljava/io/OutputStream;
        //   182: iload_3         /* bufferSize */
        //   183: invokestatic    kotlin/io/ByteStreamsKt.copyTo:(Ljava/io/InputStream;Ljava/io/OutputStream;I)J
        //   186: lstore          null
        //   188: aload           9
        //   190: aload           10
        //   192: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //   195: lload           11
        //   197: goto            221
        //   200: astore          11
        //   202: aload           11
        //   204: astore          10
        //   206: aload           11
        //   208: athrow         
        //   209: astore          11
        //   211: aload           9
        //   213: aload           10
        //   215: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //   218: aload           11
        //   220: athrow         
        //   221: nop            
        //   222: lstore          null
        //   224: aload           4
        //   226: aload           5
        //   228: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //   231: lload           6
        //   233: goto            257
        //   236: astore          6
        //   238: aload           6
        //   240: astore          5
        //   242: aload           6
        //   244: athrow         
        //   245: astore          6
        //   247: aload           4
        //   249: aload           5
        //   251: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //   254: aload           6
        //   256: athrow         
        //   257: pop2           
        //   258: aload_1         /* target */
        //   259: areturn        
        //    StackMapTable: 00 0D 21 16 12 1A 4E 07 00 15 00 FF 00 51 00 0B 07 00 15 07 00 15 01 01 07 01 0F 05 07 01 0A 00 01 07 01 0F 05 00 01 07 00 E5 FF 00 08 00 0B 07 00 15 07 00 15 01 01 07 01 0F 05 07 01 0A 00 01 07 01 0F 07 00 E5 00 01 07 00 E5 FF 00 0B 00 0D 07 00 15 07 00 15 01 01 07 01 0F 05 07 01 0A 00 01 07 01 0F 05 04 01 00 01 04 FF 00 0E 00 06 07 00 15 07 00 15 01 01 07 01 0F 05 00 01 07 00 E5 FF 00 08 00 06 07 00 15 07 00 15 01 01 07 01 0F 07 00 E5 00 01 07 00 E5 FF 00 0B 00 0C 07 00 15 07 00 15 01 01 07 01 0F 05 04 01 07 01 0F 05 04 01 00 01 04 FF 00 00 00 04 07 00 15 07 00 15 01 01 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  161    188    200    209    Ljava/lang/Throwable;
        //  161    188    209    221    Any
        //  200    209    209    221    Any
        //  209    211    209    221    Any
        //  134    224    236    245    Ljava/lang/Throwable;
        //  134    224    245    257    Any
        //  236    245    245    257    Any
        //  245    247    245    257    Any
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
    
    public static /* synthetic */ File copyTo$default(final File $this$copyTo, final File target, boolean overwrite, int bufferSize, final int n, final Object o) {
        if ((n & 0x2) != 0x0) {
            overwrite = false;
        }
        if ((n & 0x4) != 0x0) {
            bufferSize = 8192;
        }
        return copyTo($this$copyTo, target, overwrite, bufferSize);
    }
    
    public static final boolean copyRecursively(@NotNull final File $this$copyRecursively, @NotNull final File target, final boolean overwrite, @NotNull final Function2<? super File, ? super IOException, ? extends OnErrorAction> onError) {
        Intrinsics.checkNotNullParameter($this$copyRecursively, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (!$this$copyRecursively.exists()) {
            return onError.invoke($this$copyRecursively, new NoSuchFileException($this$copyRecursively, null, "The source file doesn't exist.", 2, null)) != OnErrorAction.TERMINATE;
        }
        try {
            for (final File src : FilesKt__FileTreeWalkKt.walkTopDown($this$copyRecursively).onFail((Function2<? super File, ? super IOException, Unit>)new FilesKt__UtilsKt$copyRecursively.FilesKt__UtilsKt$copyRecursively$2((Function2)onError))) {
                if (!src.exists()) {
                    if (onError.invoke(src, new NoSuchFileException(src, null, "The source file doesn't exist.", 2, null)) == OnErrorAction.TERMINATE) {
                        return false;
                    }
                    continue;
                }
                else {
                    final String relPath = toRelativeString(src, $this$copyRecursively);
                    final File dstFile = new File(target, relPath);
                    if (dstFile.exists() && (!src.isDirectory() || !dstFile.isDirectory())) {
                        final boolean stillExists = !overwrite || (dstFile.isDirectory() ? (!deleteRecursively(dstFile)) : (!dstFile.delete()));
                        if (stillExists) {
                            if (onError.invoke(dstFile, new FileAlreadyExistsException(src, dstFile, "The destination file already exists.")) == OnErrorAction.TERMINATE) {
                                return false;
                            }
                            continue;
                        }
                    }
                    if (src.isDirectory()) {
                        dstFile.mkdirs();
                    }
                    else {
                        if (copyTo$default(src, dstFile, overwrite, 0, 4, null).length() != src.length() && onError.invoke(src, new IOException("Source file wasn't copied completely, length of destination file differs.")) == OnErrorAction.TERMINATE) {
                            return false;
                        }
                        continue;
                    }
                }
            }
            return true;
        }
        catch (TerminateException e) {
            return false;
        }
    }
    
    public static final boolean deleteRecursively(@NotNull final File $this$deleteRecursively) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* $this$deleteRecursively */
        //     7: invokestatic    kotlin/io/FilesKt.walkBottomUp:(Ljava/io/File;)Lkotlin/io/FileTreeWalk;
        //    10: checkcast       Lkotlin/sequences/Sequence;
        //    13: astore_1       
        //    14: iconst_1       
        //    15: istore_2        /* initial$iv */
        //    16: iconst_0       
        //    17: istore_3        /* $i$f$fold */
        //    18: iload_2         /* initial$iv */
        //    19: istore          accumulator$iv
        //    21: aload_1         /* $this$fold$iv */
        //    22: invokeinterface kotlin/sequences/Sequence.iterator:()Ljava/util/Iterator;
        //    27: astore          5
        //    29: aload           5
        //    31: invokeinterface java/util/Iterator.hasNext:()Z
        //    36: ifeq            93
        //    39: aload           5
        //    41: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    46: astore          element$iv
        //    48: iload           accumulator$iv
        //    50: aload           element$iv
        //    52: checkcast       Ljava/io/File;
        //    55: astore          7
        //    57: istore          res
        //    59: iconst_0       
        //    60: istore          $i$a$-fold-FilesKt__UtilsKt$deleteRecursively$1
        //    62: aload           it
        //    64: invokevirtual   java/io/File.delete:()Z
        //    67: ifne            78
        //    70: aload           it
        //    72: invokevirtual   java/io/File.exists:()Z
        //    75: ifne            87
        //    78: iload           res
        //    80: ifeq            87
        //    83: iconst_1       
        //    84: goto            88
        //    87: iconst_0       
        //    88: istore          accumulator$iv
        //    90: goto            29
        //    93: iload           accumulator$iv
        //    95: ireturn        
        //    StackMapTable: 00 05 FF 00 1D 00 06 07 00 15 07 01 84 01 01 01 07 01 57 00 00 FF 00 30 00 0A 07 00 15 07 01 84 01 01 01 07 01 57 07 01 91 07 00 15 01 01 00 00 08 40 01 FF 00 04 00 06 07 00 15 07 01 84 01 01 01 07 01 57 00 00
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static final boolean startsWith(@NotNull final File $this$startsWith, @NotNull final File other) {
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        final FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents($this$startsWith);
        final FilePathComponents otherComponents = FilesKt__FilePathComponentsKt.toComponents(other);
        return Intrinsics.areEqual(components.getRoot(), otherComponents.getRoot()) && components.getSize() >= otherComponents.getSize() && components.getSegments().subList(0, otherComponents.getSize()).equals(otherComponents.getSegments());
    }
    
    public static final boolean startsWith(@NotNull final File $this$startsWith, @NotNull final String other) {
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return startsWith($this$startsWith, new File(other));
    }
    
    public static final boolean endsWith(@NotNull final File $this$endsWith, @NotNull final File other) {
        Intrinsics.checkNotNullParameter($this$endsWith, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        final FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents($this$endsWith);
        final FilePathComponents otherComponents = FilesKt__FilePathComponentsKt.toComponents(other);
        if (otherComponents.isRooted()) {
            return Intrinsics.areEqual($this$endsWith, other);
        }
        final int shift = components.getSize() - otherComponents.getSize();
        return shift >= 0 && components.getSegments().subList(shift, components.getSize()).equals(otherComponents.getSegments());
    }
    
    public static final boolean endsWith(@NotNull final File $this$endsWith, @NotNull final String other) {
        Intrinsics.checkNotNullParameter($this$endsWith, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return endsWith($this$endsWith, new File(other));
    }
    
    @NotNull
    public static final File normalize(@NotNull final File $this$normalize) {
        Intrinsics.checkNotNullParameter($this$normalize, "<this>");
        final FilePathComponents $this$normalize_u24lambda_u245 = FilesKt__FilePathComponentsKt.toComponents($this$normalize);
        final int n = 0;
        final File root = $this$normalize_u24lambda_u245.getRoot();
        final List<File> list = normalize$FilesKt__UtilsKt($this$normalize_u24lambda_u245.getSegments());
        final String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        return resolve(root, CollectionsKt___CollectionsKt.joinToString$default(list, separator, null, null, 0, null, null, 62, null));
    }
    
    private static final FilePathComponents normalize$FilesKt__UtilsKt(final FilePathComponents $this$normalize) {
        return new FilePathComponents($this$normalize.getRoot(), normalize$FilesKt__UtilsKt($this$normalize.getSegments()));
    }
    
    private static final List<File> normalize$FilesKt__UtilsKt(final List<? extends File> $this$normalize) {
        final List list = new ArrayList($this$normalize.size());
        for (final File file : $this$normalize) {
            final String name = file.getName();
            if (!Intrinsics.areEqual(name, ".")) {
                if (Intrinsics.areEqual(name, "..")) {
                    if (!list.isEmpty() && !Intrinsics.areEqual(CollectionsKt___CollectionsKt.last((List<? extends File>)list).getName(), "..")) {
                        list.remove(list.size() - 1);
                    }
                    else {
                        list.add(file);
                    }
                }
                else {
                    list.add(file);
                }
            }
        }
        return (List<File>)list;
    }
    
    @NotNull
    public static final File resolve(@NotNull final File $this$resolve, @NotNull final File relative) {
        Intrinsics.checkNotNullParameter($this$resolve, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        if (FilesKt__FilePathComponentsKt.isRooted(relative)) {
            return relative;
        }
        final String string = $this$resolve.toString();
        Intrinsics.checkNotNullExpressionValue(string, "this.toString()");
        final String baseName = string;
        return (baseName.length() == 0 || StringsKt__StringsKt.endsWith$default(baseName, File.separatorChar, false, 2, null)) ? new File(baseName + relative) : new File(baseName + File.separatorChar + relative);
    }
    
    @NotNull
    public static final File resolve(@NotNull final File $this$resolve, @NotNull final String relative) {
        Intrinsics.checkNotNullParameter($this$resolve, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        return resolve($this$resolve, new File(relative));
    }
    
    @NotNull
    public static final File resolveSibling(@NotNull final File $this$resolveSibling, @NotNull final File relative) {
        Intrinsics.checkNotNullParameter($this$resolveSibling, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        final FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents($this$resolveSibling);
        final File parentSubPath = (components.getSize() == 0) ? new File("..") : components.subPath(0, components.getSize() - 1);
        return resolve(resolve(components.getRoot(), parentSubPath), relative);
    }
    
    @NotNull
    public static final File resolveSibling(@NotNull final File $this$resolveSibling, @NotNull final String relative) {
        Intrinsics.checkNotNullParameter($this$resolveSibling, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        return resolveSibling($this$resolveSibling, new File(relative));
    }
    
    public FilesKt__UtilsKt() {
    }
}
