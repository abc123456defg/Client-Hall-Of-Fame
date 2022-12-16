// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.text;

import org.jetbrains.annotations.NotNull;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.internal.InlineOnly;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000F\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\r\n\u0000\u001a>\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001b\u0010\u0004\u001a\u0017\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a6\u0010\u0000\u001a\u00020\u00012\u001b\u0010\u0004\u001a\u0017\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\u001f\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0087\b\u001a/\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000e\"\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u000f\u001a/\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000e\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u0007H\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u0012H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u0013H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u0014H\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0015H\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016" }, d2 = { "buildString", "", "capacity", "", "builderAction", "Lkotlin/Function1;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "append", "obj", "", "value", "", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "appendLine", "", "", "", "", "kotlin-stdlib" }, xs = "kotlin/text/StringsKt")
class StringsKt__StringBuilderKt extends StringsKt__StringBuilderJVMKt
{
    @Deprecated(message = "Use append(value: Any?) instead", replaceWith = @ReplaceWith(expression = "append(value = obj)", imports = {}), level = DeprecationLevel.WARNING)
    @InlineOnly
    @java.lang.Deprecated
    private static final StringBuilder append(final StringBuilder $this$append, final Object obj) {
        Intrinsics.checkNotNullParameter($this$append, "<this>");
        final StringBuilder append = $this$append.append(obj);
        Intrinsics.checkNotNullExpressionValue(append, "this.append(obj)");
        return append;
    }
    
    @InlineOnly
    private static final String buildString(final Function1<? super StringBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        final StringBuilder sb = new StringBuilder();
        builderAction.invoke(sb);
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String buildString(final int capacity, final Function1<? super StringBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        final StringBuilder sb = new StringBuilder(capacity);
        builderAction.invoke(sb);
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).\u2026builderAction).toString()");
        return string;
    }
    
    @NotNull
    public static final StringBuilder append(@NotNull final StringBuilder $this$append, @NotNull final String... value) {
        Intrinsics.checkNotNullParameter($this$append, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        for (int i = 0; i < value.length; ++i) {
            final String item = value[i];
            $this$append.append(item);
        }
        return $this$append;
    }
    
    @NotNull
    public static final StringBuilder append(@NotNull final StringBuilder $this$append, @NotNull final Object... value) {
        Intrinsics.checkNotNullParameter($this$append, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        for (int i = 0; i < value.length; ++i) {
            final Object item = value[i];
            $this$append.append(item);
        }
        return $this$append;
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(final StringBuilder $this$appendLine) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        final StringBuilder append = $this$appendLine.append('\n');
        Intrinsics.checkNotNullExpressionValue(append, "append('\\n')");
        return append;
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(final StringBuilder $this$appendLine, final CharSequence value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        final StringBuilder append = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        final StringBuilder append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, "append('\\n')");
        return append2;
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(final StringBuilder $this$appendLine, final String value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        final StringBuilder append = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        final StringBuilder append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, "append('\\n')");
        return append2;
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(final StringBuilder $this$appendLine, final Object value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        final StringBuilder append = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        final StringBuilder append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, "append('\\n')");
        return append2;
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(final StringBuilder $this$appendLine, final char[] value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        final StringBuilder append = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        final StringBuilder append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, "append('\\n')");
        return append2;
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(final StringBuilder $this$appendLine, final char value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        final StringBuilder append = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        final StringBuilder append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, "append('\\n')");
        return append2;
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder appendLine(final StringBuilder $this$appendLine, final boolean value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        final StringBuilder append = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        final StringBuilder append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, "append('\\n')");
        return append2;
    }
    
    public StringsKt__StringBuilderKt() {
    }
}
