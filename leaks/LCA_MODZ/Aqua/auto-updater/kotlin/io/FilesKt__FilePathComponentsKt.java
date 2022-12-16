// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.io;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import java.io.File;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u000b\u001a\u00020\f*\u00020\bH\u0002¢\u0006\u0002\b\r\u001a\u001c\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0000\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0002H\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0002*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0013" }, d2 = { "isRooted", "", "Ljava/io/File;", "(Ljava/io/File;)Z", "root", "getRoot", "(Ljava/io/File;)Ljava/io/File;", "rootName", "", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "getRootLength", "", "getRootLength$FilesKt__FilePathComponentsKt", "subPath", "beginIndex", "endIndex", "toComponents", "Lkotlin/io/FilePathComponents;", "kotlin-stdlib" }, xs = "kotlin/io/FilesKt")
class FilesKt__FilePathComponentsKt
{
    private static final int getRootLength$FilesKt__FilePathComponentsKt(final String $this$getRootLength) {
        int first = StringsKt__StringsKt.indexOf$default($this$getRootLength, File.separatorChar, 0, false, 4, null);
        if (first == 0) {
            if ($this$getRootLength.length() > 1 && $this$getRootLength.charAt(1) == File.separatorChar) {
                first = StringsKt__StringsKt.indexOf$default($this$getRootLength, File.separatorChar, 2, false, 4, null);
                if (first >= 0) {
                    first = StringsKt__StringsKt.indexOf$default($this$getRootLength, File.separatorChar, first + 1, false, 4, null);
                    if (first >= 0) {
                        return first + 1;
                    }
                    return $this$getRootLength.length();
                }
            }
            return 1;
        }
        if (first > 0 && $this$getRootLength.charAt(first - 1) == ':') {
            return ++first;
        }
        if (first == -1 && StringsKt__StringsKt.endsWith$default($this$getRootLength, ':', false, 2, null)) {
            return $this$getRootLength.length();
        }
        return 0;
    }
    
    @NotNull
    public static final String getRootName(@NotNull final File $this$rootName) {
        Intrinsics.checkNotNullParameter($this$rootName, "<this>");
        final String path = $this$rootName.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        final String s = path;
        final int beginIndex = 0;
        final String path2 = $this$rootName.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "path");
        final String substring = s.substring(beginIndex, getRootLength$FilesKt__FilePathComponentsKt(path2));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }
    
    @NotNull
    public static final File getRoot(@NotNull final File $this$root) {
        Intrinsics.checkNotNullParameter($this$root, "<this>");
        return new File(getRootName($this$root));
    }
    
    public static final boolean isRooted(@NotNull final File $this$isRooted) {
        Intrinsics.checkNotNullParameter($this$isRooted, "<this>");
        final String path = $this$isRooted.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        return getRootLength$FilesKt__FilePathComponentsKt(path) > 0;
    }
    
    @NotNull
    public static final FilePathComponents toComponents(@NotNull final File $this$toComponents) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* $this$toComponents */
        //     7: invokevirtual   java/io/File.getPath:()Ljava/lang/String;
        //    10: astore_1        /* path */
        //    11: aload_1         /* path */
        //    12: ldc             "path"
        //    14: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    17: aload_1         /* path */
        //    18: invokestatic    kotlin/io/FilesKt__FilePathComponentsKt.getRootLength$FilesKt__FilePathComponentsKt:(Ljava/lang/String;)I
        //    21: istore_2        /* rootLength */
        //    22: aload_1         /* path */
        //    23: astore          4
        //    25: iconst_0       
        //    26: istore          5
        //    28: aload           4
        //    30: iload           5
        //    32: iload_2         /* rootLength */
        //    33: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //    36: dup            
        //    37: ldc             "this as java.lang.String\u2026ing(startIndex, endIndex)"
        //    39: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    42: astore_3        /* rootName */
        //    43: aload_1         /* path */
        //    44: iload_2         /* rootLength */
        //    45: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //    48: dup            
        //    49: ldc             "this as java.lang.String).substring(startIndex)"
        //    51: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    54: astore          subPath
        //    56: aload           subPath
        //    58: checkcast       Ljava/lang/CharSequence;
        //    61: invokeinterface java/lang/CharSequence.length:()I
        //    66: ifne            73
        //    69: iconst_1       
        //    70: goto            74
        //    73: iconst_0       
        //    74: ifeq            83
        //    77: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //    80: goto            213
        //    83: aload           subPath
        //    85: checkcast       Ljava/lang/CharSequence;
        //    88: iconst_1       
        //    89: newarray        C
        //    91: astore          6
        //    93: aload           6
        //    95: iconst_0       
        //    96: getstatic       java/io/File.separatorChar:C
        //    99: castore        
        //   100: aload           6
        //   102: iconst_0       
        //   103: iconst_0       
        //   104: bipush          6
        //   106: aconst_null    
        //   107: invokestatic    kotlin/text/StringsKt.split$default:(Ljava/lang/CharSequence;[CZIILjava/lang/Object;)Ljava/util/List;
        //   110: checkcast       Ljava/lang/Iterable;
        //   113: astore          $this$map$iv
        //   115: iconst_0       
        //   116: istore          $i$f$map
        //   118: aload           $this$map$iv
        //   120: astore          8
        //   122: new             Ljava/util/ArrayList;
        //   125: dup            
        //   126: aload           $this$map$iv
        //   128: bipush          10
        //   130: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   133: invokespecial   java/util/ArrayList.<init>:(I)V
        //   136: checkcast       Ljava/util/Collection;
        //   139: astore          destination$iv$iv
        //   141: iconst_0       
        //   142: istore          $i$f$mapTo
        //   144: aload           $this$mapTo$iv$iv
        //   146: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   151: astore          11
        //   153: aload           11
        //   155: invokeinterface java/util/Iterator.hasNext:()Z
        //   160: ifeq            207
        //   163: aload           11
        //   165: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   170: astore          item$iv$iv
        //   172: aload           destination$iv$iv
        //   174: aload           item$iv$iv
        //   176: checkcast       Ljava/lang/String;
        //   179: astore          13
        //   181: astore          15
        //   183: iconst_0       
        //   184: istore          $i$a$-map-FilesKt__FilePathComponentsKt$toComponents$list$1
        //   186: new             Ljava/io/File;
        //   189: dup            
        //   190: aload           p0
        //   192: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //   195: aload           15
        //   197: swap           
        //   198: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   203: pop            
        //   204: goto            153
        //   207: aload           destination$iv$iv
        //   209: checkcast       Ljava/util/List;
        //   212: nop            
        //   213: astore          list
        //   215: new             Lkotlin/io/FilePathComponents;
        //   218: dup            
        //   219: new             Ljava/io/File;
        //   222: dup            
        //   223: aload_3         /* rootName */
        //   224: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //   227: aload           list
        //   229: invokespecial   kotlin/io/FilePathComponents.<init>:(Ljava/io/File;Ljava/util/List;)V
        //   232: areturn        
        //    StackMapTable: 00 06 FF 00 49 00 06 07 00 0A 07 00 16 01 07 00 16 07 00 16 01 00 00 40 01 08 FF 00 45 00 0C 07 00 0A 07 00 16 01 07 00 16 07 00 16 01 07 00 66 01 07 00 66 07 00 71 01 07 00 77 00 00 35 FF 00 05 00 06 07 00 0A 07 00 16 01 07 00 16 07 00 16 01 00 01 07 00 85
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @NotNull
    public static final File subPath(@NotNull final File $this$subPath, final int beginIndex, final int endIndex) {
        Intrinsics.checkNotNullParameter($this$subPath, "<this>");
        return toComponents($this$subPath).subPath(beginIndex, endIndex);
    }
    
    public FilesKt__FilePathComponentsKt() {
    }
}
