// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.text;

import java.util.List;
import kotlin.sequences.Sequence;
import kotlin.jvm.functions.Function1;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0082\b¢\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\f\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0016\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002H\u0007¨\u0006\u0015" }, d2 = { "getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib" }, xs = "kotlin/text/StringsKt")
class StringsKt__IndentKt extends StringsKt__AppendableKt
{
    @IntrinsicConstEvaluation
    @NotNull
    public static final String trimMargin(@NotNull final String $this$trimMargin, @NotNull final String marginPrefix) {
        Intrinsics.checkNotNullParameter($this$trimMargin, "<this>");
        Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        return replaceIndentByMargin($this$trimMargin, "", marginPrefix);
    }
    
    @NotNull
    public static final String replaceIndentByMargin(@NotNull final String $this$replaceIndentByMargin, @NotNull final String newIndent, @NotNull final String marginPrefix) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* newIndent */
        //     7: ldc             "newIndent"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: aload_2         /* marginPrefix */
        //    13: ldc             "marginPrefix"
        //    15: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    18: aload_2         /* marginPrefix */
        //    19: checkcast       Ljava/lang/CharSequence;
        //    22: invokestatic    kotlin/text/StringsKt.isBlank:(Ljava/lang/CharSequence;)Z
        //    25: ifne            32
        //    28: iconst_1       
        //    29: goto            33
        //    32: iconst_0       
        //    33: istore_3       
        //    34: iload_3        
        //    35: ifne            58
        //    38: iconst_0       
        //    39: istore          $i$a$-require-StringsKt__IndentKt$replaceIndentByMargin$1
        //    41: ldc             "marginPrefix must be non-blank string."
        //    43: astore          null
        //    45: new             Ljava/lang/IllegalArgumentException;
        //    48: dup            
        //    49: aload           4
        //    51: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //    54: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //    57: athrow         
        //    58: aload_0         /* $this$replaceIndentByMargin */
        //    59: checkcast       Ljava/lang/CharSequence;
        //    62: invokestatic    kotlin/text/StringsKt.lines:(Ljava/lang/CharSequence;)Ljava/util/List;
        //    65: astore_3        /* lines */
        //    66: aload_3         /* lines */
        //    67: astore          4
        //    69: aload_0         /* $this$replaceIndentByMargin */
        //    70: invokevirtual   java/lang/String.length:()I
        //    73: aload_1         /* newIndent */
        //    74: invokevirtual   java/lang/String.length:()I
        //    77: aload_3         /* lines */
        //    78: invokeinterface java/util/List.size:()I
        //    83: imul           
        //    84: iadd           
        //    85: istore          5
        //    87: aload_1         /* newIndent */
        //    88: invokestatic    kotlin/text/StringsKt__IndentKt.getIndentFunction$StringsKt__IndentKt:(Ljava/lang/String;)Lkotlin/jvm/functions/Function1;
        //    91: astore          indentAddFunction$iv
        //    93: iconst_0       
        //    94: istore          $i$f$reindent
        //    96: aload           $this$reindent$iv
        //    98: invokestatic    kotlin/collections/CollectionsKt.getLastIndex:(Ljava/util/List;)I
        //   101: istore          lastIndex$iv
        //   103: aload           $this$reindent$iv
        //   105: checkcast       Ljava/lang/Iterable;
        //   108: astore          $this$mapIndexedNotNull$iv$iv
        //   110: iconst_0       
        //   111: istore          $i$f$mapIndexedNotNull
        //   113: aload           $this$mapIndexedNotNull$iv$iv
        //   115: astore          11
        //   117: new             Ljava/util/ArrayList;
        //   120: dup            
        //   121: invokespecial   java/util/ArrayList.<init>:()V
        //   124: checkcast       Ljava/util/Collection;
        //   127: astore          destination$iv$iv$iv
        //   129: iconst_0       
        //   130: istore          $i$f$mapIndexedNotNullTo
        //   132: aload           $this$mapIndexedNotNullTo$iv$iv$iv
        //   134: astore          $this$forEachIndexed$iv$iv$iv$iv
        //   136: iconst_0       
        //   137: istore          $i$f$forEachIndexed
        //   139: iconst_0       
        //   140: istore          index$iv$iv$iv$iv
        //   142: aload           $this$forEachIndexed$iv$iv$iv$iv
        //   144: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   149: astore          17
        //   151: aload           17
        //   153: invokeinterface java/util/Iterator.hasNext:()Z
        //   158: ifeq            438
        //   161: aload           17
        //   163: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   168: astore          item$iv$iv$iv$iv
        //   170: iload           index$iv$iv$iv$iv
        //   172: iinc            index$iv$iv$iv$iv, 1
        //   175: istore          19
        //   177: iload           19
        //   179: ifge            185
        //   182: invokestatic    kotlin/collections/CollectionsKt.throwIndexOverflow:()V
        //   185: iload           19
        //   187: aload           item$iv$iv$iv$iv
        //   189: astore          20
        //   191: istore          index$iv$iv$iv
        //   193: iconst_0       
        //   194: istore          $i$a$-forEachIndexed-CollectionsKt___CollectionsKt$mapIndexedNotNullTo$1$iv$iv$iv
        //   196: iload           index$iv$iv$iv
        //   198: aload           element$iv$iv$iv
        //   200: checkcast       Ljava/lang/String;
        //   203: astore          23
        //   205: istore          index$iv
        //   207: iconst_0       
        //   208: istore          $i$a$-mapIndexedNotNull-StringsKt__IndentKt$reindent$1$iv
        //   210: iload           index$iv
        //   212: ifeq            222
        //   215: iload           index$iv
        //   217: iload           lastIndex$iv
        //   219: if_icmpne       237
        //   222: aload           value$iv
        //   224: checkcast       Ljava/lang/CharSequence;
        //   227: invokestatic    kotlin/text/StringsKt.isBlank:(Ljava/lang/CharSequence;)Z
        //   230: ifeq            237
        //   233: aconst_null    
        //   234: goto            405
        //   237: aload           value$iv
        //   239: astore          line
        //   241: iconst_0       
        //   242: istore          $i$a$-reindent-StringsKt__IndentKt$replaceIndentByMargin$2
        //   244: aload           line
        //   246: checkcast       Ljava/lang/CharSequence;
        //   249: astore          $this$indexOfFirst$iv
        //   251: iconst_0       
        //   252: istore          $i$f$indexOfFirst
        //   254: iconst_0       
        //   255: istore          index$iv
        //   257: aload           $this$indexOfFirst$iv
        //   259: invokeinterface java/lang/CharSequence.length:()I
        //   264: istore          31
        //   266: iload           index$iv
        //   268: iload           31
        //   270: if_icmpge       314
        //   273: aload           $this$indexOfFirst$iv
        //   275: iload           index$iv
        //   277: invokeinterface java/lang/CharSequence.charAt:(I)C
        //   282: istore          it
        //   284: iconst_0       
        //   285: istore          $i$a$-indexOfFirst-StringsKt__IndentKt$replaceIndentByMargin$2$firstNonWhitespaceIndex$1
        //   287: iload           it
        //   289: invokestatic    kotlin/text/CharsKt.isWhitespace:(C)Z
        //   292: ifne            299
        //   295: iconst_1       
        //   296: goto            300
        //   299: iconst_0       
        //   300: ifeq            308
        //   303: iload           index$iv
        //   305: goto            315
        //   308: iinc            index$iv, 1
        //   311: goto            266
        //   314: iconst_m1      
        //   315: istore          firstNonWhitespaceIndex
        //   317: nop            
        //   318: iload           firstNonWhitespaceIndex
        //   320: iconst_m1      
        //   321: if_icmpne       328
        //   324: aconst_null    
        //   325: goto            379
        //   328: aload           line
        //   330: aload_2         /* marginPrefix */
        //   331: iload           firstNonWhitespaceIndex
        //   333: iconst_0       
        //   334: iconst_4       
        //   335: aconst_null    
        //   336: invokestatic    kotlin/text/StringsKt.startsWith$default:(Ljava/lang/String;Ljava/lang/String;IZILjava/lang/Object;)Z
        //   339: ifeq            378
        //   342: aload           line
        //   344: astore          28
        //   346: iload           firstNonWhitespaceIndex
        //   348: aload_2         /* marginPrefix */
        //   349: invokevirtual   java/lang/String.length:()I
        //   352: iadd           
        //   353: istore          29
        //   355: aload           28
        //   357: ldc             "null cannot be cast to non-null type java.lang.String"
        //   359: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   362: aload           28
        //   364: iload           29
        //   366: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //   369: dup            
        //   370: ldc             "this as java.lang.String).substring(startIndex)"
        //   372: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   375: goto            379
        //   378: aconst_null    
        //   379: nop            
        //   380: dup            
        //   381: ifnull          402
        //   384: astore          35
        //   386: aload           indentAddFunction$iv
        //   388: aload           35
        //   390: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   395: checkcast       Ljava/lang/String;
        //   398: dup            
        //   399: ifnonnull       405
        //   402: pop            
        //   403: aload           value$iv
        //   405: nop            
        //   406: dup            
        //   407: ifnull          432
        //   410: astore          36
        //   412: aload           36
        //   414: astore          it$iv$iv$iv
        //   416: iconst_0       
        //   417: istore          $i$a$-let-CollectionsKt___CollectionsKt$mapIndexedNotNullTo$1$1$iv$iv$iv
        //   419: aload           destination$iv$iv$iv
        //   421: aload           it$iv$iv$iv
        //   423: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   428: pop            
        //   429: goto            434
        //   432: pop            
        //   433: nop            
        //   434: nop            
        //   435: goto            151
        //   438: nop            
        //   439: aload           destination$iv$iv$iv
        //   441: checkcast       Ljava/util/List;
        //   444: nop            
        //   445: checkcast       Ljava/lang/Iterable;
        //   448: new             Ljava/lang/StringBuilder;
        //   451: dup            
        //   452: iload           resultSizeEstimate$iv
        //   454: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //   457: checkcast       Ljava/lang/Appendable;
        //   460: ldc             "\n"
        //   462: checkcast       Ljava/lang/CharSequence;
        //   465: aconst_null    
        //   466: aconst_null    
        //   467: iconst_0       
        //   468: aconst_null    
        //   469: aconst_null    
        //   470: bipush          124
        //   472: aconst_null    
        //   473: invokestatic    kotlin/collections/CollectionsKt.joinTo$default:(Ljava/lang/Iterable;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)Ljava/lang/Appendable;
        //   476: checkcast       Ljava/lang/StringBuilder;
        //   479: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   482: dup            
        //   483: ldc             "mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()"
        //   485: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   488: nop            
        //   489: areturn        
        //    StackMapTable: 00 15 20 40 01 FC 00 18 01 FF 00 5C 00 12 07 00 3E 07 00 3E 07 00 3E 07 00 44 07 00 44 01 07 00 8A 01 01 07 00 53 01 07 00 53 07 00 5A 01 07 00 53 01 01 07 00 60 00 00 FD 00 21 07 00 30 01 FF 00 24 00 1A 07 00 3E 07 00 3E 07 00 3E 07 00 44 07 00 44 01 07 00 8A 01 01 07 00 53 01 07 00 53 07 00 5A 01 07 00 53 01 01 07 00 60 07 00 30 01 07 00 30 01 01 07 00 3E 01 01 00 00 0E FF 00 1C 00 20 07 00 3E 07 00 3E 07 00 3E 07 00 44 07 00 44 01 07 00 8A 01 01 07 00 53 01 07 00 53 07 00 5A 01 07 00 53 01 01 07 00 60 07 00 30 01 07 00 30 01 01 07 00 3E 01 01 07 00 3E 01 07 00 26 01 01 01 00 00 FD 00 20 01 01 40 01 07 F9 00 05 40 01 FE 00 0C 00 00 01 31 FF 00 00 00 23 07 00 3E 07 00 3E 07 00 3E 07 00 44 07 00 44 01 07 00 8A 01 01 07 00 53 01 07 00 53 07 00 5A 01 07 00 53 01 01 07 00 60 07 00 30 01 07 00 30 01 01 07 00 3E 01 01 07 00 3E 01 07 00 30 01 01 01 00 00 01 00 01 07 00 3E 56 07 00 3E FF 00 02 00 1A 07 00 3E 07 00 3E 07 00 3E 07 00 44 07 00 44 01 07 00 8A 01 01 07 00 53 01 07 00 53 07 00 5A 01 07 00 53 01 01 07 00 60 07 00 30 01 07 00 30 01 01 07 00 3E 01 01 00 01 07 00 3E 5A 07 00 3E 01 FF 00 03 00 12 07 00 3E 07 00 3E 07 00 3E 07 00 44 07 00 44 01 07 00 8A 01 01 07 00 53 01 07 00 53 07 00 5A 01 07 00 53 01 01 07 00 60 00 00
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @IntrinsicConstEvaluation
    @NotNull
    public static final String trimIndent(@NotNull final String $this$trimIndent) {
        Intrinsics.checkNotNullParameter($this$trimIndent, "<this>");
        return replaceIndent($this$trimIndent, "");
    }
    
    @NotNull
    public static final String replaceIndent(@NotNull final String $this$replaceIndent, @NotNull final String newIndent) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* newIndent */
        //     7: ldc             "newIndent"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: aload_0         /* $this$replaceIndent */
        //    13: checkcast       Ljava/lang/CharSequence;
        //    16: invokestatic    kotlin/text/StringsKt.lines:(Ljava/lang/CharSequence;)Ljava/util/List;
        //    19: astore_2        /* lines */
        //    20: aload_2         /* lines */
        //    21: checkcast       Ljava/lang/Iterable;
        //    24: astore          5
        //    26: nop            
        //    27: iconst_0       
        //    28: istore          $i$f$filter
        //    30: aload           $this$filter$iv
        //    32: astore          7
        //    34: new             Ljava/util/ArrayList;
        //    37: dup            
        //    38: invokespecial   java/util/ArrayList.<init>:()V
        //    41: checkcast       Ljava/util/Collection;
        //    44: astore          destination$iv$iv
        //    46: iconst_0       
        //    47: istore          $i$f$filterTo
        //    49: aload           $this$filterTo$iv$iv
        //    51: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    56: astore          10
        //    58: aload           10
        //    60: invokeinterface java/util/Iterator.hasNext:()Z
        //    65: ifeq            119
        //    68: aload           10
        //    70: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    75: astore          element$iv$iv
        //    77: aload           element$iv$iv
        //    79: checkcast       Ljava/lang/String;
        //    82: astore          p0
        //    84: iconst_0       
        //    85: istore          $i$a$-filter-StringsKt__IndentKt$replaceIndent$minCommonIndent$1
        //    87: aload           p0
        //    89: checkcast       Ljava/lang/CharSequence;
        //    92: invokestatic    kotlin/text/StringsKt.isBlank:(Ljava/lang/CharSequence;)Z
        //    95: ifne            102
        //    98: iconst_1       
        //    99: goto            103
        //   102: iconst_0       
        //   103: ifeq            58
        //   106: aload           destination$iv$iv
        //   108: aload           element$iv$iv
        //   110: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   115: pop            
        //   116: goto            58
        //   119: aload           destination$iv$iv
        //   121: checkcast       Ljava/util/List;
        //   124: nop            
        //   125: checkcast       Ljava/lang/Iterable;
        //   128: astore          5
        //   130: nop            
        //   131: iconst_0       
        //   132: istore          $i$f$map
        //   134: aload           $this$map$iv
        //   136: astore          7
        //   138: new             Ljava/util/ArrayList;
        //   141: dup            
        //   142: aload           $this$map$iv
        //   144: bipush          10
        //   146: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   149: invokespecial   java/util/ArrayList.<init>:(I)V
        //   152: checkcast       Ljava/util/Collection;
        //   155: astore          destination$iv$iv
        //   157: iconst_0       
        //   158: istore          $i$f$mapTo
        //   160: aload           $this$mapTo$iv$iv
        //   162: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   167: astore          10
        //   169: aload           10
        //   171: invokeinterface java/util/Iterator.hasNext:()Z
        //   176: ifeq            222
        //   179: aload           10
        //   181: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   186: astore          item$iv$iv
        //   188: aload           destination$iv$iv
        //   190: aload           item$iv$iv
        //   192: checkcast       Ljava/lang/String;
        //   195: astore          12
        //   197: astore          32
        //   199: iconst_0       
        //   200: istore          $i$a$-map-StringsKt__IndentKt$replaceIndent$minCommonIndent$2
        //   202: aload           p0
        //   204: invokestatic    kotlin/text/StringsKt__IndentKt.indentWidth$StringsKt__IndentKt:(Ljava/lang/String;)I
        //   207: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   210: aload           32
        //   212: swap           
        //   213: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   218: pop            
        //   219: goto            169
        //   222: aload           destination$iv$iv
        //   224: checkcast       Ljava/util/List;
        //   227: nop            
        //   228: checkcast       Ljava/lang/Iterable;
        //   231: invokestatic    kotlin/collections/CollectionsKt.minOrNull:(Ljava/lang/Iterable;)Ljava/lang/Comparable;
        //   234: checkcast       Ljava/lang/Integer;
        //   237: dup            
        //   238: ifnull          247
        //   241: invokevirtual   java/lang/Integer.intValue:()I
        //   244: goto            249
        //   247: pop            
        //   248: iconst_0       
        //   249: istore_3        /* minCommonIndent */
        //   250: aload_2         /* lines */
        //   251: astore          4
        //   253: aload_0         /* $this$replaceIndent */
        //   254: invokevirtual   java/lang/String.length:()I
        //   257: aload_1         /* newIndent */
        //   258: invokevirtual   java/lang/String.length:()I
        //   261: aload_2         /* lines */
        //   262: invokeinterface java/util/List.size:()I
        //   267: imul           
        //   268: iadd           
        //   269: istore          5
        //   271: aload_1         /* newIndent */
        //   272: invokestatic    kotlin/text/StringsKt__IndentKt.getIndentFunction$StringsKt__IndentKt:(Ljava/lang/String;)Lkotlin/jvm/functions/Function1;
        //   275: astore          indentAddFunction$iv
        //   277: iconst_0       
        //   278: istore          $i$f$reindent
        //   280: aload           $this$reindent$iv
        //   282: invokestatic    kotlin/collections/CollectionsKt.getLastIndex:(Ljava/util/List;)I
        //   285: istore          lastIndex$iv
        //   287: aload           $this$reindent$iv
        //   289: checkcast       Ljava/lang/Iterable;
        //   292: astore          $this$mapIndexedNotNull$iv$iv
        //   294: iconst_0       
        //   295: istore          $i$f$mapIndexedNotNull
        //   297: aload           $this$mapIndexedNotNull$iv$iv
        //   299: astore          11
        //   301: new             Ljava/util/ArrayList;
        //   304: dup            
        //   305: invokespecial   java/util/ArrayList.<init>:()V
        //   308: checkcast       Ljava/util/Collection;
        //   311: astore          destination$iv$iv$iv
        //   313: iconst_0       
        //   314: istore          $i$f$mapIndexedNotNullTo
        //   316: aload           $this$mapIndexedNotNullTo$iv$iv$iv
        //   318: astore          $this$forEachIndexed$iv$iv$iv$iv
        //   320: iconst_0       
        //   321: istore          $i$f$forEachIndexed
        //   323: iconst_0       
        //   324: istore          index$iv$iv$iv$iv
        //   326: aload           $this$forEachIndexed$iv$iv$iv$iv
        //   328: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   333: astore          17
        //   335: aload           17
        //   337: invokeinterface java/util/Iterator.hasNext:()Z
        //   342: ifeq            492
        //   345: aload           17
        //   347: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   352: astore          item$iv$iv$iv$iv
        //   354: iload           index$iv$iv$iv$iv
        //   356: iinc            index$iv$iv$iv$iv, 1
        //   359: istore          19
        //   361: iload           19
        //   363: ifge            369
        //   366: invokestatic    kotlin/collections/CollectionsKt.throwIndexOverflow:()V
        //   369: iload           19
        //   371: aload           item$iv$iv$iv$iv
        //   373: astore          20
        //   375: istore          index$iv$iv$iv
        //   377: iconst_0       
        //   378: istore          $i$a$-forEachIndexed-CollectionsKt___CollectionsKt$mapIndexedNotNullTo$1$iv$iv$iv
        //   380: iload           index$iv$iv$iv
        //   382: aload           element$iv$iv$iv
        //   384: checkcast       Ljava/lang/String;
        //   387: astore          23
        //   389: istore          index$iv
        //   391: iconst_0       
        //   392: istore          $i$a$-mapIndexedNotNull-StringsKt__IndentKt$reindent$1$iv
        //   394: iload           index$iv
        //   396: ifeq            406
        //   399: iload           index$iv
        //   401: iload           lastIndex$iv
        //   403: if_icmpne       421
        //   406: aload           value$iv
        //   408: checkcast       Ljava/lang/CharSequence;
        //   411: invokestatic    kotlin/text/StringsKt.isBlank:(Ljava/lang/CharSequence;)Z
        //   414: ifeq            421
        //   417: aconst_null    
        //   418: goto            459
        //   421: aload           value$iv
        //   423: astore          line
        //   425: iconst_0       
        //   426: istore          $i$a$-reindent-StringsKt__IndentKt$replaceIndent$1
        //   428: aload           line
        //   430: iload_3         /* minCommonIndent */
        //   431: invokestatic    kotlin/text/StringsKt.drop:(Ljava/lang/String;I)Ljava/lang/String;
        //   434: dup            
        //   435: ifnull          456
        //   438: astore          28
        //   440: aload           indentAddFunction$iv
        //   442: aload           28
        //   444: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   449: checkcast       Ljava/lang/String;
        //   452: dup            
        //   453: ifnonnull       459
        //   456: pop            
        //   457: aload           value$iv
        //   459: nop            
        //   460: dup            
        //   461: ifnull          486
        //   464: astore          29
        //   466: aload           29
        //   468: astore          it$iv$iv$iv
        //   470: iconst_0       
        //   471: istore          $i$a$-let-CollectionsKt___CollectionsKt$mapIndexedNotNullTo$1$1$iv$iv$iv
        //   473: aload           destination$iv$iv$iv
        //   475: aload           it$iv$iv$iv
        //   477: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   482: pop            
        //   483: goto            488
        //   486: pop            
        //   487: nop            
        //   488: nop            
        //   489: goto            335
        //   492: nop            
        //   493: aload           destination$iv$iv$iv
        //   495: checkcast       Ljava/util/List;
        //   498: nop            
        //   499: checkcast       Ljava/lang/Iterable;
        //   502: new             Ljava/lang/StringBuilder;
        //   505: dup            
        //   506: iload           resultSizeEstimate$iv
        //   508: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //   511: checkcast       Ljava/lang/Appendable;
        //   514: ldc             "\n"
        //   516: checkcast       Ljava/lang/CharSequence;
        //   519: aconst_null    
        //   520: aconst_null    
        //   521: iconst_0       
        //   522: aconst_null    
        //   523: aconst_null    
        //   524: bipush          124
        //   526: aconst_null    
        //   527: invokestatic    kotlin/collections/CollectionsKt.joinTo$default:(Ljava/lang/Iterable;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)Ljava/lang/Appendable;
        //   530: checkcast       Ljava/lang/StringBuilder;
        //   533: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   536: dup            
        //   537: ldc             "mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()"
        //   539: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   542: nop            
        //   543: areturn        
        //    StackMapTable: 00 11 FF 00 3A 00 0B 07 00 3E 07 00 3E 07 00 44 00 00 07 00 53 01 07 00 53 07 00 5A 01 07 00 60 00 00 FE 00 2B 07 00 30 07 00 3E 01 40 01 F8 00 0F 31 34 58 07 00 DC 41 01 FF 00 55 00 12 07 00 3E 07 00 3E 07 00 44 01 07 00 44 01 07 00 8A 01 01 07 00 53 01 07 00 53 07 00 5A 01 07 00 53 01 01 07 00 60 00 00 FD 00 21 07 00 30 01 FF 00 24 00 1A 07 00 3E 07 00 3E 07 00 44 01 07 00 44 01 07 00 8A 01 01 07 00 53 01 07 00 53 07 00 5A 01 07 00 53 01 01 07 00 60 07 00 30 01 07 00 30 01 01 07 00 3E 01 01 00 00 0E FF 00 22 00 1C 07 00 3E 07 00 3E 07 00 44 01 07 00 44 01 07 00 8A 01 01 07 00 53 01 07 00 53 07 00 5A 01 07 00 53 01 01 07 00 60 07 00 30 01 07 00 30 01 01 07 00 3E 01 01 07 00 3E 01 00 01 07 00 3E FF 00 02 00 1A 07 00 3E 07 00 3E 07 00 44 01 07 00 44 01 07 00 8A 01 01 07 00 53 01 07 00 53 07 00 5A 01 07 00 53 01 01 07 00 60 07 00 30 01 07 00 30 01 01 07 00 3E 01 01 00 01 07 00 3E 5A 07 00 3E 01 FF 00 03 00 12 07 00 3E 07 00 3E 07 00 44 01 07 00 44 01 07 00 8A 01 01 07 00 53 01 07 00 53 07 00 5A 01 07 00 53 01 01 07 00 60 00 00
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @NotNull
    public static final String prependIndent(@NotNull final String $this$prependIndent, @NotNull final String indent) {
        Intrinsics.checkNotNullParameter($this$prependIndent, "<this>");
        Intrinsics.checkNotNullParameter(indent, "indent");
        return SequencesKt___SequencesKt.joinToString$default(SequencesKt___SequencesKt.map((Sequence<?>)StringsKt__StringsKt.lineSequence($this$prependIndent), (Function1<? super Object, ?>)new StringsKt__IndentKt$prependIndent.StringsKt__IndentKt$prependIndent$1(indent)), "\n", null, null, 0, null, null, 62, null);
    }
    
    private static final int indentWidth$StringsKt__IndentKt(final String $this$indentWidth) {
        final CharSequence $this$indexOfFirst$iv = $this$indentWidth;
        final int $i$f$indexOfFirst = 0;
        while (true) {
            for (int index$iv = 0; index$iv < $this$indexOfFirst$iv.length(); ++index$iv) {
                final char it = $this$indexOfFirst$iv.charAt(index$iv);
                final int n = 0;
                if (!CharsKt__CharJVMKt.isWhitespace(it)) {
                    final int n2 = index$iv;
                    final int it2 = n2;
                    final int n3 = 0;
                    return (it2 == -1) ? $this$indentWidth.length() : it2;
                }
            }
            final int n2 = -1;
            continue;
        }
    }
    
    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(final String indent) {
        return (Function1<String, String>)((indent.length() == 0) ? StringsKt__IndentKt$getIndentFunction.StringsKt__IndentKt$getIndentFunction$1.INSTANCE : ((Function1<String, String>)new StringsKt__IndentKt$getIndentFunction.StringsKt__IndentKt$getIndentFunction$2(indent)));
    }
    
    private static final String reindent$StringsKt__IndentKt(final List<String> $this$reindent, final int resultSizeEstimate, final Function1<? super String, String> indentAddFunction, final Function1<? super String, String> indentCutFunction) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore          $i$f$reindent
        //     3: aload_0         /* $this$reindent */
        //     4: invokestatic    kotlin/collections/CollectionsKt.getLastIndex:(Ljava/util/List;)I
        //     7: istore          lastIndex
        //     9: aload_0         /* $this$reindent */
        //    10: checkcast       Ljava/lang/Iterable;
        //    13: astore          $this$mapIndexedNotNull$iv
        //    15: iconst_0       
        //    16: istore          $i$f$mapIndexedNotNull
        //    18: aload           $this$mapIndexedNotNull$iv
        //    20: astore          8
        //    22: new             Ljava/util/ArrayList;
        //    25: dup            
        //    26: invokespecial   java/util/ArrayList.<init>:()V
        //    29: checkcast       Ljava/util/Collection;
        //    32: astore          destination$iv$iv
        //    34: iconst_0       
        //    35: istore          $i$f$mapIndexedNotNullTo
        //    37: aload           $this$mapIndexedNotNullTo$iv$iv
        //    39: astore          $this$forEachIndexed$iv$iv$iv
        //    41: iconst_0       
        //    42: istore          $i$f$forEachIndexed
        //    44: iconst_0       
        //    45: istore          index$iv$iv$iv
        //    47: aload           $this$forEachIndexed$iv$iv$iv
        //    49: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    54: astore          14
        //    56: aload           14
        //    58: invokeinterface java/util/Iterator.hasNext:()Z
        //    63: ifeq            210
        //    66: aload           14
        //    68: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    73: astore          item$iv$iv$iv
        //    75: iload           index$iv$iv$iv
        //    77: iinc            index$iv$iv$iv, 1
        //    80: istore          16
        //    82: iload           16
        //    84: ifge            90
        //    87: invokestatic    kotlin/collections/CollectionsKt.throwIndexOverflow:()V
        //    90: iload           16
        //    92: aload           item$iv$iv$iv
        //    94: astore          17
        //    96: istore          index$iv$iv
        //    98: iconst_0       
        //    99: istore          $i$a$-forEachIndexed-CollectionsKt___CollectionsKt$mapIndexedNotNullTo$1$iv$iv
        //   101: iload           index$iv$iv
        //   103: aload           element$iv$iv
        //   105: checkcast       Ljava/lang/String;
        //   108: astore          20
        //   110: istore          index
        //   112: iconst_0       
        //   113: istore          $i$a$-mapIndexedNotNull-StringsKt__IndentKt$reindent$1
        //   115: iload           index
        //   117: ifeq            127
        //   120: iload           index
        //   122: iload           lastIndex
        //   124: if_icmpne       142
        //   127: aload           value
        //   129: checkcast       Ljava/lang/CharSequence;
        //   132: invokestatic    kotlin/text/StringsKt.isBlank:(Ljava/lang/CharSequence;)Z
        //   135: ifeq            142
        //   138: aconst_null    
        //   139: goto            177
        //   142: aload_3         /* indentCutFunction */
        //   143: aload           value
        //   145: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   150: checkcast       Ljava/lang/String;
        //   153: dup            
        //   154: ifnull          174
        //   157: astore          23
        //   159: aload_2         /* indentAddFunction */
        //   160: aload           23
        //   162: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   167: checkcast       Ljava/lang/String;
        //   170: dup            
        //   171: ifnonnull       177
        //   174: pop            
        //   175: aload           value
        //   177: nop            
        //   178: dup            
        //   179: ifnull          204
        //   182: astore          24
        //   184: aload           24
        //   186: astore          it$iv$iv
        //   188: iconst_0       
        //   189: istore          $i$a$-let-CollectionsKt___CollectionsKt$mapIndexedNotNullTo$1$1$iv$iv
        //   191: aload           destination$iv$iv
        //   193: aload           it$iv$iv
        //   195: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   200: pop            
        //   201: goto            206
        //   204: pop            
        //   205: nop            
        //   206: nop            
        //   207: goto            56
        //   210: nop            
        //   211: aload           destination$iv$iv
        //   213: checkcast       Ljava/util/List;
        //   216: nop            
        //   217: checkcast       Ljava/lang/Iterable;
        //   220: new             Ljava/lang/StringBuilder;
        //   223: dup            
        //   224: iload_1         /* resultSizeEstimate */
        //   225: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //   228: checkcast       Ljava/lang/Appendable;
        //   231: ldc             "\n"
        //   233: checkcast       Ljava/lang/CharSequence;
        //   236: aconst_null    
        //   237: aconst_null    
        //   238: iconst_0       
        //   239: aconst_null    
        //   240: aconst_null    
        //   241: bipush          124
        //   243: aconst_null    
        //   244: invokestatic    kotlin/collections/CollectionsKt.joinTo$default:(Ljava/lang/Iterable;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)Ljava/lang/Appendable;
        //   247: checkcast       Ljava/lang/StringBuilder;
        //   250: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   253: dup            
        //   254: ldc             "mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()"
        //   256: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   259: areturn        
        //    Signature:
        //  (Ljava/util/List<Ljava/lang/String;>;ILkotlin/jvm/functions/Function1<-Ljava/lang/String;Ljava/lang/String;>;Lkotlin/jvm/functions/Function1<-Ljava/lang/String;Ljava/lang/String;>;)Ljava/lang/String;
        //    StackMapTable: 00 09 FF 00 38 00 0F 07 00 44 01 07 00 8A 07 00 8A 01 01 07 00 53 01 07 00 53 07 00 5A 01 07 00 53 01 01 07 00 60 00 00 FD 00 21 07 00 30 01 FF 00 24 00 17 07 00 44 01 07 00 8A 07 00 8A 01 01 07 00 53 01 07 00 53 07 00 5A 01 07 00 53 01 01 07 00 60 07 00 30 01 07 00 30 01 01 07 00 3E 01 01 00 00 0E 5F 07 00 3E 42 07 00 3E 5A 07 00 3E 01 FF 00 03 00 0F 07 00 44 01 07 00 8A 07 00 8A 01 01 07 00 53 01 07 00 53 07 00 5A 01 07 00 53 01 01 07 00 60 00 00
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public StringsKt__IndentKt() {
    }
}
