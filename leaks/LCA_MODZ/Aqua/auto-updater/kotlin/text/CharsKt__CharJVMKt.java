// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.text;

import kotlin.PublishedApi;
import kotlin.ranges.IntRange;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ExperimentalStdlibApi;
import kotlin.WasExperimental;
import kotlin.SinceKotlin;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ReplaceWith;
import kotlin.Deprecated;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0001\u001a\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0011\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0018\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u001a\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u001b\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\n\u0010\u001c\u001a\u00020\u000f*\u00020\u0002\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u0002H\u0087\b\u001a\u0014\u0010\u001d\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010!\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0014\u0010\"\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010#\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010$\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010%\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010&\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010'\u001a\u00020\u001e*\u00020\u0002H\u0087\b\u001a\u0014\u0010'\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010(\u001a\u00020\u0002*\u00020\u0002H\u0087\b\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006)" }, d2 = { "category", "Lkotlin/text/CharCategory;", "", "getCategory", "(C)Lkotlin/text/CharCategory;", "directionality", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "checkRadix", "", "radix", "digitOf", "char", "isDefined", "", "isDigit", "isHighSurrogate", "isISOControl", "isIdentifierIgnorable", "isJavaIdentifierPart", "isJavaIdentifierStart", "isLetter", "isLetterOrDigit", "isLowSurrogate", "isLowerCase", "isTitleCase", "isUpperCase", "isWhitespace", "lowercase", "", "locale", "Ljava/util/Locale;", "lowercaseChar", "titlecase", "titlecaseChar", "toLowerCase", "toTitleCase", "toUpperCase", "uppercase", "uppercaseChar", "kotlin-stdlib" }, xs = "kotlin/text/CharsKt")
class CharsKt__CharJVMKt
{
    @NotNull
    public static final CharCategory getCategory(final char $this$category) {
        return CharCategory.Companion.valueOf(Character.getType($this$category));
    }
    
    @InlineOnly
    private static final boolean isDefined(final char $this$isDefined) {
        return Character.isDefined($this$isDefined);
    }
    
    @InlineOnly
    private static final boolean isLetter(final char $this$isLetter) {
        return Character.isLetter($this$isLetter);
    }
    
    @InlineOnly
    private static final boolean isLetterOrDigit(final char $this$isLetterOrDigit) {
        return Character.isLetterOrDigit($this$isLetterOrDigit);
    }
    
    @InlineOnly
    private static final boolean isDigit(final char $this$isDigit) {
        return Character.isDigit($this$isDigit);
    }
    
    @InlineOnly
    private static final boolean isIdentifierIgnorable(final char $this$isIdentifierIgnorable) {
        return Character.isIdentifierIgnorable($this$isIdentifierIgnorable);
    }
    
    @InlineOnly
    private static final boolean isISOControl(final char $this$isISOControl) {
        return Character.isISOControl($this$isISOControl);
    }
    
    @InlineOnly
    private static final boolean isJavaIdentifierPart(final char $this$isJavaIdentifierPart) {
        return Character.isJavaIdentifierPart($this$isJavaIdentifierPart);
    }
    
    @InlineOnly
    private static final boolean isJavaIdentifierStart(final char $this$isJavaIdentifierStart) {
        return Character.isJavaIdentifierStart($this$isJavaIdentifierStart);
    }
    
    public static final boolean isWhitespace(final char $this$isWhitespace) {
        return Character.isWhitespace($this$isWhitespace) || Character.isSpaceChar($this$isWhitespace);
    }
    
    @InlineOnly
    private static final boolean isUpperCase(final char $this$isUpperCase) {
        return Character.isUpperCase($this$isUpperCase);
    }
    
    @InlineOnly
    private static final boolean isLowerCase(final char $this$isLowerCase) {
        return Character.isLowerCase($this$isLowerCase);
    }
    
    @Deprecated(message = "Use uppercaseChar() instead.", replaceWith = @ReplaceWith(expression = "uppercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    @java.lang.Deprecated
    private static final char toUpperCase(final char $this$toUpperCase) {
        return Character.toUpperCase($this$toUpperCase);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final char uppercaseChar(final char $this$uppercaseChar) {
        return Character.toUpperCase($this$uppercaseChar);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final String uppercase(final char $this$uppercase) {
        final String value = String.valueOf($this$uppercase);
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type java.lang.String");
        final String upperCase = value.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @NotNull
    public static final String uppercase(final char $this$uppercase, @NotNull final Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        final String value = String.valueOf($this$uppercase);
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type java.lang.String");
        final String upperCase = value.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }
    
    @Deprecated(message = "Use lowercaseChar() instead.", replaceWith = @ReplaceWith(expression = "lowercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    @java.lang.Deprecated
    private static final char toLowerCase(final char $this$toLowerCase) {
        return Character.toLowerCase($this$toLowerCase);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final char lowercaseChar(final char $this$lowercaseChar) {
        return Character.toLowerCase($this$lowercaseChar);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final String lowercase(final char $this$lowercase) {
        final String value = String.valueOf($this$lowercase);
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type java.lang.String");
        final String lowerCase = value.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @NotNull
    public static final String lowercase(final char $this$lowercase, @NotNull final Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        final String value = String.valueOf($this$lowercase);
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type java.lang.String");
        final String lowerCase = value.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }
    
    @InlineOnly
    private static final boolean isTitleCase(final char $this$isTitleCase) {
        return Character.isTitleCase($this$isTitleCase);
    }
    
    @Deprecated(message = "Use titlecaseChar() instead.", replaceWith = @ReplaceWith(expression = "titlecaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    @java.lang.Deprecated
    private static final char toTitleCase(final char $this$toTitleCase) {
        return Character.toTitleCase($this$toTitleCase);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final char titlecaseChar(final char $this$titlecaseChar) {
        return Character.toTitleCase($this$titlecaseChar);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @NotNull
    public static final String titlecase(final char $this$titlecase, @NotNull final Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        final String localizedUppercase = uppercase($this$titlecase, locale);
        if (localizedUppercase.length() > 1) {
            String string;
            if ($this$titlecase == '\u0149') {
                string = localizedUppercase;
            }
            else {
                final char char1 = localizedUppercase.charAt(0);
                final String object = localizedUppercase;
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
        final String first = localizedUppercase;
        final String value = String.valueOf($this$titlecase);
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type java.lang.String");
        final String upperCase = value.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (!Intrinsics.areEqual(first, upperCase)) {
            return localizedUppercase;
        }
        return String.valueOf(Character.toTitleCase($this$titlecase));
    }
    
    @NotNull
    public static final CharDirectionality getDirectionality(final char $this$directionality) {
        return CharDirectionality.Companion.valueOf(Character.getDirectionality($this$directionality));
    }
    
    @InlineOnly
    private static final boolean isHighSurrogate(final char $this$isHighSurrogate) {
        return Character.isHighSurrogate($this$isHighSurrogate);
    }
    
    @InlineOnly
    private static final boolean isLowSurrogate(final char $this$isLowSurrogate) {
        return Character.isLowSurrogate($this$isLowSurrogate);
    }
    
    public static final int digitOf(final char char, final int radix) {
        return Character.digit((int)char, radix);
    }
    
    @PublishedApi
    public static final int checkRadix(final int radix) {
        if (!new IntRange(2, 36).contains(radix)) {
            throw new IllegalArgumentException("radix " + radix + " was not in valid range " + new IntRange(2, 36));
        }
        return radix;
    }
    
    public CharsKt__CharJVMKt() {
    }
}
