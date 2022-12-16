// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.text;

import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\tH\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0087\b\u001a%\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\b\u001a-\u0010\u000b\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0087\b\u001a-\u0010\u000b\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0087\b\u001a\u0014\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012*\u00060\u0011j\u0002`\u0012H\u0007\u001a\u001d\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012*\u00060\u0011j\u0002`\u00122\u0006\u0010\u0003\u001a\u00020\u0013H\u0087\b\u001a\u001f\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012*\u00060\u0011j\u0002`\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u000fH\u0087\b\u001a\u0014\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0007\u001a\u001f\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0087\b\u001a\u001f\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0014H\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0015H\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0013H\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\fH\u0087\b\u001a\u001f\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u000fH\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\tH\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0087\b\u001a\u001f\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0016H\u0087\b\u001a%\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\b\u001a\u0014\u0010\u0017\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0007\u001a\u001d\u0010\u0018\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0019\u001a\u00020\bH\u0087\b\u001a%\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0087\b\u001a5\u0010\u001b\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0087\b\u001a5\u0010\u001b\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0087\b\u001a!\u0010\u001c\u001a\u00020\u001d*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0013H\u0087\n\u001a-\u0010\u001e\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0016H\u0087\b\u001a7\u0010\u001f\u001a\u00020\u001d*\u00060\u0001j\u0002`\u00022\u0006\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\bH\u0087\b¨\u0006\"" }, d2 = { "appendLine", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "value", "Ljava/lang/StringBuffer;", "", "", "", "", "", "", "appendRange", "", "startIndex", "endIndex", "", "appendln", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "", "", "", "", "clear", "deleteAt", "index", "deleteRange", "insertRange", "set", "", "setRange", "toCharArray", "destination", "destinationOffset", "kotlin-stdlib" }, xs = "kotlin/text/StringsKt")
class StringsKt__StringBuilderJVMKt extends StringsKt__RegexExtensionsKt
{
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final StringBuilder clear(@NotNull final StringBuilder $this$clear) {
        Intrinsics.checkNotNullParameter($this$clear, "<this>");
        final StringBuilder $this$clear_u24lambda_u240 = $this$clear;
        final int n = 0;
        $this$clear_u24lambda_u240.setLength(0);
        return $this$clear;
    }
    
    @InlineOnly
    private static final void set(final StringBuilder $this$set, final int index, final char value) {
        Intrinsics.checkNotNullParameter($this$set, "<this>");
        $this$set.setCharAt(index, value);
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final StringBuilder setRange(final StringBuilder $this$setRange, final int startIndex, final int endIndex, final String value) {
        Intrinsics.checkNotNullParameter($this$setRange, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        final StringBuilder replace = $this$setRange.replace(startIndex, endIndex, value);
        Intrinsics.checkNotNullExpressionValue(replace, "this.replace(startIndex, endIndex, value)");
        return replace;
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final StringBuilder deleteAt(final StringBuilder $this$deleteAt, final int index) {
        Intrinsics.checkNotNullParameter($this$deleteAt, "<this>");
        final StringBuilder deleteChar = $this$deleteAt.deleteCharAt(index);
        Intrinsics.checkNotNullExpressionValue(deleteChar, "this.deleteCharAt(index)");
        return deleteChar;
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final StringBuilder deleteRange(final StringBuilder $this$deleteRange, final int startIndex, final int endIndex) {
        Intrinsics.checkNotNullParameter($this$deleteRange, "<this>");
        final StringBuilder delete = $this$deleteRange.delete(startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(delete, "this.delete(startIndex, endIndex)");
        return delete;
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final void toCharArray(final StringBuilder $this$toCharArray, final char[] destination, final int destinationOffset, final int startIndex, final int endIndex) {
        Intrinsics.checkNotNullParameter($this$toCharArray, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        $this$toCharArray.getChars(startIndex, endIndex, destination, destinationOffset);
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final StringBuilder appendRange(final StringBuilder $this$appendRange, final char[] value, final int startIndex, final int endIndex) {
        Intrinsics.checkNotNullParameter($this$appendRange, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        final StringBuilder append = $this$appendRange.append(value, startIndex, endIndex - startIndex);
        Intrinsics.checkNotNullExpressionValue(append, "this.append(value, start\u2026x, endIndex - startIndex)");
        return append;
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final StringBuilder appendRange(final StringBuilder $this$appendRange, final CharSequence value, final int startIndex, final int endIndex) {
        Intrinsics.checkNotNullParameter($this$appendRange, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        final StringBuilder append = $this$appendRange.append(value, startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(append, "this.append(value, startIndex, endIndex)");
        return append;
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final StringBuilder insertRange(final StringBuilder $this$insertRange, final int index, final char[] value, final int startIndex, final int endIndex) {
        Intrinsics.checkNotNullParameter($this$insertRange, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        final StringBuilder insert = $this$insertRange.insert(index, value, startIndex, endIndex - startIndex);
        Intrinsics.checkNotNullExpressionValue(insert, "this.insert(index, value\u2026x, endIndex - startIndex)");
        return insert;
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final StringBuilder insertRange(final StringBuilder $this$insertRange, final int index, final CharSequence value, final int startIndex, final int endIndex) {
        Intrinsics.checkNotNullParameter($this$insertRange, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        final StringBuilder insert = $this$insertRange.insert(index, value, startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(insert, "this.insert(index, value, startIndex, endIndex)");
        return insert;
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(final StringBuilder $this$appendLine, final StringBuffer value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        final StringBuilder append = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        final StringBuilder append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, "append('\\n')");
        return append2;
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(final StringBuilder $this$appendLine, final StringBuilder value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        final StringBuilder append = $this$appendLine.append((CharSequence)value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        final StringBuilder append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, "append('\\n')");
        return append2;
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(final StringBuilder $this$appendLine, final int value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        final StringBuilder append = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        final StringBuilder append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, "append('\\n')");
        return append2;
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(final StringBuilder $this$appendLine, final short value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        final StringBuilder append = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value.toInt())");
        final StringBuilder append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, "append('\\n')");
        return append2;
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(final StringBuilder $this$appendLine, final byte value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        final StringBuilder append = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value.toInt())");
        final StringBuilder append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, "append('\\n')");
        return append2;
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(final StringBuilder $this$appendLine, final long value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        final StringBuilder append = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        final StringBuilder append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, "append('\\n')");
        return append2;
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(final StringBuilder $this$appendLine, final float value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        final StringBuilder append = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        final StringBuilder append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, "append('\\n')");
        return append2;
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(final StringBuilder $this$appendLine, final double value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        final StringBuilder append = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        final StringBuilder append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, "append('\\n')");
        return append2;
    }
    
    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}), level = DeprecationLevel.WARNING)
    @NotNull
    @java.lang.Deprecated
    public static final Appendable appendln(@NotNull final Appendable $this$appendln) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        final Appendable append = $this$appendln.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(append, "append(SystemProperties.LINE_SEPARATOR)");
        return append;
    }
    
    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}), level = DeprecationLevel.WARNING)
    @InlineOnly
    @java.lang.Deprecated
    private static final Appendable appendln(final Appendable $this$appendln, final CharSequence value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        final Appendable append = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        return appendln(append);
    }
    
    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}), level = DeprecationLevel.WARNING)
    @InlineOnly
    @java.lang.Deprecated
    private static final Appendable appendln(final Appendable $this$appendln, final char value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        final Appendable append = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        return appendln(append);
    }
    
    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}), level = DeprecationLevel.WARNING)
    @NotNull
    @java.lang.Deprecated
    public static final StringBuilder appendln(@NotNull final StringBuilder $this$appendln) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        final StringBuilder append = $this$appendln.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(append, "append(SystemProperties.LINE_SEPARATOR)");
        return append;
    }
    
    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}), level = DeprecationLevel.WARNING)
    @InlineOnly
    @java.lang.Deprecated
    private static final StringBuilder appendln(final StringBuilder $this$appendln, final StringBuffer value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        final StringBuilder append = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        return appendln(append);
    }
    
    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}), level = DeprecationLevel.WARNING)
    @InlineOnly
    @java.lang.Deprecated
    private static final StringBuilder appendln(final StringBuilder $this$appendln, final CharSequence value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        final StringBuilder append = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        return appendln(append);
    }
    
    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}), level = DeprecationLevel.WARNING)
    @InlineOnly
    @java.lang.Deprecated
    private static final StringBuilder appendln(final StringBuilder $this$appendln, final String value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        final StringBuilder append = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        return appendln(append);
    }
    
    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}), level = DeprecationLevel.WARNING)
    @InlineOnly
    @java.lang.Deprecated
    private static final StringBuilder appendln(final StringBuilder $this$appendln, final Object value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        final StringBuilder append = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        return appendln(append);
    }
    
    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}), level = DeprecationLevel.WARNING)
    @InlineOnly
    @java.lang.Deprecated
    private static final StringBuilder appendln(final StringBuilder $this$appendln, final StringBuilder value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        final StringBuilder append = $this$appendln.append((CharSequence)value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        return appendln(append);
    }
    
    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}), level = DeprecationLevel.WARNING)
    @InlineOnly
    @java.lang.Deprecated
    private static final StringBuilder appendln(final StringBuilder $this$appendln, final char[] value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        final StringBuilder append = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        return appendln(append);
    }
    
    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}), level = DeprecationLevel.WARNING)
    @InlineOnly
    @java.lang.Deprecated
    private static final StringBuilder appendln(final StringBuilder $this$appendln, final char value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        final StringBuilder append = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        return appendln(append);
    }
    
    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}), level = DeprecationLevel.WARNING)
    @InlineOnly
    @java.lang.Deprecated
    private static final StringBuilder appendln(final StringBuilder $this$appendln, final boolean value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        final StringBuilder append = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        return appendln(append);
    }
    
    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}), level = DeprecationLevel.WARNING)
    @InlineOnly
    @java.lang.Deprecated
    private static final StringBuilder appendln(final StringBuilder $this$appendln, final int value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        final StringBuilder append = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        return appendln(append);
    }
    
    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}), level = DeprecationLevel.WARNING)
    @InlineOnly
    @java.lang.Deprecated
    private static final StringBuilder appendln(final StringBuilder $this$appendln, final short value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        final StringBuilder append = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value.toInt())");
        return appendln(append);
    }
    
    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}), level = DeprecationLevel.WARNING)
    @InlineOnly
    @java.lang.Deprecated
    private static final StringBuilder appendln(final StringBuilder $this$appendln, final byte value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        final StringBuilder append = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value.toInt())");
        return appendln(append);
    }
    
    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}), level = DeprecationLevel.WARNING)
    @InlineOnly
    @java.lang.Deprecated
    private static final StringBuilder appendln(final StringBuilder $this$appendln, final long value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        final StringBuilder append = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        return appendln(append);
    }
    
    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}), level = DeprecationLevel.WARNING)
    @InlineOnly
    @java.lang.Deprecated
    private static final StringBuilder appendln(final StringBuilder $this$appendln, final float value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        final StringBuilder append = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        return appendln(append);
    }
    
    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}), level = DeprecationLevel.WARNING)
    @InlineOnly
    @java.lang.Deprecated
    private static final StringBuilder appendln(final StringBuilder $this$appendln, final double value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        final StringBuilder append = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        return appendln(append);
    }
    
    public StringsKt__StringBuilderJVMKt() {
    }
}
