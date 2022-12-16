// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.text;

import org.jetbrains.annotations.Nullable;
import kotlin.jvm.functions.Function1;
import kotlin.internal.InlineOnly;
import kotlin.ExperimentalStdlibApi;
import kotlin.WasExperimental;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000:\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005\"\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007\u001a9\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\n\u001a\u0002H\u00012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH\u0000¢\u0006\u0002\u0010\r\u001a\u0015\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u0003H\u0087\b\u001a\u001d\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a\u001f\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0006H\u0087\b\u001a7\u0010\u0010\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015" }, d2 = { "append", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "value", "", "", "(Ljava/lang/Appendable;[Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "appendElement", "", "element", "transform", "Lkotlin/Function1;", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "appendLine", "", "appendRange", "startIndex", "", "endIndex", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;II)Ljava/lang/Appendable;", "kotlin-stdlib" }, xs = "kotlin/text/StringsKt")
class StringsKt__AppendableKt
{
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @NotNull
    public static final <T extends Appendable> T appendRange(@NotNull final T $this$appendRange, @NotNull final CharSequence value, final int startIndex, final int endIndex) {
        Intrinsics.checkNotNullParameter($this$appendRange, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        final Appendable append = $this$appendRange.append(value, startIndex, endIndex);
        Intrinsics.checkNotNull(append, "null cannot be cast to non-null type T of kotlin.text.StringsKt__AppendableKt.appendRange");
        return (T)append;
    }
    
    @NotNull
    public static final <T extends Appendable> T append(@NotNull final T $this$append, @NotNull final CharSequence... value) {
        Intrinsics.checkNotNullParameter($this$append, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        for (int i = 0; i < value.length; ++i) {
            final CharSequence item = value[i];
            $this$append.append(item);
        }
        return $this$append;
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final Appendable appendLine(final Appendable $this$appendLine) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        final Appendable append = $this$appendLine.append('\n');
        Intrinsics.checkNotNullExpressionValue(append, "append('\\n')");
        return append;
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final Appendable appendLine(final Appendable $this$appendLine, final CharSequence value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        final Appendable append = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        final Appendable append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, "append('\\n')");
        return append2;
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final Appendable appendLine(final Appendable $this$appendLine, final char value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        final Appendable append = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        final Appendable append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, "append('\\n')");
        return append2;
    }
    
    public static final <T> void appendElement(@NotNull final Appendable $this$appendElement, final T element, @Nullable final Function1<? super T, ? extends CharSequence> transform) {
        Intrinsics.checkNotNullParameter($this$appendElement, "<this>");
        if (transform != null) {
            $this$appendElement.append((CharSequence)transform.invoke(element));
        }
        else if (element == null || element instanceof CharSequence) {
            $this$appendElement.append((CharSequence)element);
        }
        else if (element instanceof Character) {
            $this$appendElement.append((char)element);
        }
        else {
            $this$appendElement.append(String.valueOf(element));
        }
    }
    
    public StringsKt__AppendableKt() {
    }
}
