// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.text;

import org.jetbrains.annotations.NotNull;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003" }, d2 = { "titlecaseImpl", "", "", "kotlin-stdlib" })
public final class _OneToManyTitlecaseMappingsKt
{
    @NotNull
    public static final String titlecaseImpl(final char $this$titlecaseImpl) {
        final String value = String.valueOf($this$titlecaseImpl);
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type java.lang.String");
        final String upperCase = value.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        final String uppercase = upperCase;
        if (uppercase.length() > 1) {
            String string;
            if ($this$titlecaseImpl == '\u0149') {
                string = uppercase;
            }
            else {
                final char char1 = uppercase.charAt(0);
                final String object = uppercase;
                final int beginIndex = 1;
                Intrinsics.checkNotNull(object, "null cannot be cast to non-null type java.lang.String");
                final String substring = object.substring(beginIndex);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                final String object2 = substring;
                Intrinsics.checkNotNull(object2, "null cannot be cast to non-null type java.lang.String");
                final String lowerCase = object2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                string = char1 + lowerCase;
            }
            return string;
        }
        return String.valueOf(Character.toTitleCase($this$titlecaseImpl));
    }
}
