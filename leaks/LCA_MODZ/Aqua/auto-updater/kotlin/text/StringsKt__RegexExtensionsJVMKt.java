// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.text;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import java.util.regex.Pattern;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b¨\u0006\u0003" }, d2 = { "toRegex", "Lkotlin/text/Regex;", "Ljava/util/regex/Pattern;", "kotlin-stdlib" }, xs = "kotlin/text/StringsKt")
class StringsKt__RegexExtensionsJVMKt extends StringsKt__IndentKt
{
    @InlineOnly
    private static final Regex toRegex(final Pattern $this$toRegex) {
        Intrinsics.checkNotNullParameter($this$toRegex, "<this>");
        return new Regex($this$toRegex);
    }
    
    public StringsKt__RegexExtensionsJVMKt() {
    }
}
