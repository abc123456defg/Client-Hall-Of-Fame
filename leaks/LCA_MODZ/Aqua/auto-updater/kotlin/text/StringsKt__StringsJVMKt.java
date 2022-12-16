// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.text;

import java.util.Comparator;
import kotlin.internal.LowPriorityInOverloadResolution;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import java.util.Collection;
import kotlin.ranges.IntRange;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.StringCompanionObject;
import java.util.Arrays;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.Charset;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.ByteBuffer;
import java.nio.charset.CodingErrorAction;
import kotlin.collections.AbstractList;
import kotlin.ExperimentalStdlibApi;
import kotlin.WasExperimental;
import kotlin.SinceKotlin;
import java.util.Locale;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ReplaceWith;
import kotlin.Deprecated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u0011\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0087\b\u001a\u0019\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\b\u001a)\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0087\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\b\u001a\f\u0010\u0017\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010\u0017\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\u0015\u0010\u001a\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0087\b\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0087\b\u001a\u001d\u0010\u001d\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010 \u001a\u00020\u0011*\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a\f\u0010$\u001a\u00020\u0002*\u00020\u0014H\u0007\u001a \u0010$\u001a\u00020\u0002*\u00020\u00142\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\u0019\u0010&\u001a\u00020#*\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010'H\u0087\u0004\u001a \u0010&\u001a\u00020#*\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010'2\u0006\u0010\"\u001a\u00020#H\u0007\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0087\b\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0087\b\u001a\f\u0010)\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010)\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\f\u0010*\u001a\u00020\u0002*\u00020\rH\u0007\u001a*\u0010*\u001a\u00020\u0002*\u00020\r2\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020#H\u0007\u001a\f\u0010,\u001a\u00020\r*\u00020\u0002H\u0007\u001a*\u0010,\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020#H\u0007\u001a\u001c\u0010-\u001a\u00020#*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a \u0010/\u001a\u00020#*\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a2\u00100\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0002\u00104\u001a6\u00100\u001a\u00020\u0002*\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0004\b5\u00104\u001a*\u00100\u001a\u00020\u0002*\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0002\u00106\u001a:\u00100\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0002\u00107\u001a>\u00100\u001a\u00020\u0002*\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0004\b5\u00107\u001a2\u00100\u001a\u00020\u0002*\u00020\u00042\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0002\u00108\u001a\r\u00109\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\n\u0010:\u001a\u00020#*\u00020'\u001a\r\u0010;\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010;\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\u001a\u001d\u0010<\u001a\u00020\u0011*\u00020\u00022\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010<\u001a\u00020\u0011*\u00020\u00022\u0006\u0010@\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010A\u001a\u00020\u0011*\u00020\u00022\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010A\u001a\u00020\u0011*\u00020\u00022\u0006\u0010@\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010B\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010C\u001a\u00020\u0011H\u0087\b\u001a4\u0010D\u001a\u00020#*\u00020'2\u0006\u0010E\u001a\u00020\u00112\u0006\u0010!\u001a\u00020'2\u0006\u0010F\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a4\u0010D\u001a\u00020#*\u00020\u00022\u0006\u0010E\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a\u0012\u0010G\u001a\u00020\u0002*\u00020'2\u0006\u0010H\u001a\u00020\u0011\u001a$\u0010I\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020>2\u0006\u0010K\u001a\u00020>2\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010I\u001a\u00020\u0002*\u00020\u00022\u0006\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020>2\u0006\u0010K\u001a\u00020>2\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a\"\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00020P*\u00020'2\u0006\u0010Q\u001a\u00020R2\b\b\u0002\u0010S\u001a\u00020\u0011\u001a\u001c\u0010T\u001a\u00020#*\u00020\u00022\u0006\u0010U\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010T\u001a\u00020#*\u00020\u00022\u0006\u0010U\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a\u0015\u0010V\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0011H\u0087\b\u001a\u001d\u0010V\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0087\b\u001a\u0017\u0010W\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a\r\u0010X\u001a\u00020\u0014*\u00020\u0002H\u0087\b\u001a3\u0010X\u001a\u00020\u0014*\u00020\u00022\u0006\u0010Y\u001a\u00020\u00142\b\b\u0002\u0010Z\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0087\b\u001a \u0010X\u001a\u00020\u0014*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\r\u0010[\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010[\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\u001a\u0017\u0010\\\u001a\u00020R*\u00020\u00022\b\b\u0002\u0010]\u001a\u00020\u0011H\u0087\b\u001a\r\u0010^\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010^\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\u001a\r\u0010_\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010_\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\"%\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006`" }, d2 = { "CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "Lkotlin/String$Companion;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "String", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "bytes", "", "charset", "Ljava/nio/charset/Charset;", "offset", "", "length", "chars", "", "codePoints", "", "capitalize", "locale", "Ljava/util/Locale;", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "endIndex", "compareTo", "other", "ignoreCase", "", "concatToString", "startIndex", "contentEquals", "", "charSequence", "decapitalize", "decodeToString", "throwOnInvalidSequence", "encodeToByteArray", "endsWith", "suffix", "equals", "format", "args", "", "", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "formatNullable", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "isBlank", "lowercase", "nativeIndexOf", "ch", "", "fromIndex", "str", "nativeLastIndexOf", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "repeat", "n", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "split", "", "regex", "Ljava/util/regex/Pattern;", "limit", "startsWith", "prefix", "substring", "toByteArray", "toCharArray", "destination", "destinationOffset", "toLowerCase", "toPattern", "flags", "toUpperCase", "uppercase", "kotlin-stdlib" }, xs = "kotlin/text/StringsKt")
class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt
{
    @InlineOnly
    private static final int nativeIndexOf(final String $this$nativeIndexOf, final char ch, final int fromIndex) {
        Intrinsics.checkNotNullParameter($this$nativeIndexOf, "<this>");
        return $this$nativeIndexOf.indexOf(ch, fromIndex);
    }
    
    @InlineOnly
    private static final int nativeIndexOf(final String $this$nativeIndexOf, final String str, final int fromIndex) {
        Intrinsics.checkNotNullParameter($this$nativeIndexOf, "<this>");
        Intrinsics.checkNotNullParameter(str, "str");
        return $this$nativeIndexOf.indexOf(str, fromIndex);
    }
    
    @InlineOnly
    private static final int nativeLastIndexOf(final String $this$nativeLastIndexOf, final char ch, final int fromIndex) {
        Intrinsics.checkNotNullParameter($this$nativeLastIndexOf, "<this>");
        return $this$nativeLastIndexOf.lastIndexOf(ch, fromIndex);
    }
    
    @InlineOnly
    private static final int nativeLastIndexOf(final String $this$nativeLastIndexOf, final String str, final int fromIndex) {
        Intrinsics.checkNotNullParameter($this$nativeLastIndexOf, "<this>");
        Intrinsics.checkNotNullParameter(str, "str");
        return $this$nativeLastIndexOf.lastIndexOf(str, fromIndex);
    }
    
    public static final boolean equals(@Nullable final String $this$equals, @Nullable final String other, final boolean ignoreCase) {
        if ($this$equals == null) {
            return other == null;
        }
        return ignoreCase ? $this$equals.equalsIgnoreCase(other) : $this$equals.equals(other);
    }
    
    @NotNull
    public static final String replace(@NotNull final String $this$replace, final char oldChar, final char newChar, final boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$replace, "<this>");
        if (!ignoreCase) {
            final String replace = $this$replace.replace(oldChar, newChar);
            Intrinsics.checkNotNullExpressionValue(replace, "this as java.lang.String\u2026replace(oldChar, newChar)");
            return replace;
        }
        final StringBuilder $this$replace_u24lambda_u241 = new StringBuilder($this$replace.length());
        final int n = 0;
        final CharSequence $this$forEach$iv = $this$replace;
        final int $i$f$forEach = 0;
        for (int i = 0; i < $this$forEach$iv.length(); ++i) {
            final char c;
            final char element$iv = c = $this$forEach$iv.charAt(i);
            final int n2 = 0;
            $this$replace_u24lambda_u241.append(CharsKt__CharKt.equals(c, oldChar, ignoreCase) ? newChar : c);
        }
        final String string = $this$replace_u24lambda_u241.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).\u2026builderAction).toString()");
        return string;
    }
    
    @NotNull
    public static final String replace(@NotNull final String $this$replace, @NotNull final String oldValue, @NotNull final String newValue, final boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$replace, "<this>");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        final String $this$replace_u24lambda_u242 = $this$replace;
        final int n = 0;
        int occurrenceIndex = StringsKt__StringsKt.indexOf($this$replace_u24lambda_u242, oldValue, 0, ignoreCase);
        if (occurrenceIndex < 0) {
            return $this$replace_u24lambda_u242;
        }
        final int oldValueLength = oldValue.length();
        final int searchStep = RangesKt___RangesKt.coerceAtLeast(oldValueLength, 1);
        final int newLengthHint = $this$replace_u24lambda_u242.length() - oldValueLength + newValue.length();
        if (newLengthHint < 0) {
            throw new OutOfMemoryError();
        }
        final StringBuilder stringBuilder = new StringBuilder(newLengthHint);
        int i = 0;
        do {
            stringBuilder.append($this$replace_u24lambda_u242, i, occurrenceIndex).append(newValue);
            i = occurrenceIndex + oldValueLength;
            if (occurrenceIndex >= $this$replace_u24lambda_u242.length()) {
                break;
            }
            occurrenceIndex = StringsKt__StringsKt.indexOf($this$replace_u24lambda_u242, oldValue, occurrenceIndex + searchStep, ignoreCase);
        } while (occurrenceIndex > 0);
        final String string = stringBuilder.append($this$replace_u24lambda_u242, i, $this$replace_u24lambda_u242.length()).toString();
        Intrinsics.checkNotNullExpressionValue(string, "stringBuilder.append(this, i, length).toString()");
        return string;
    }
    
    @NotNull
    public static final String replaceFirst(@NotNull final String $this$replaceFirst, final char oldChar, final char newChar, final boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$replaceFirst, "<this>");
        final int index = StringsKt__StringsKt.indexOf$default($this$replaceFirst, oldChar, 0, ignoreCase, 2, null);
        return (index < 0) ? $this$replaceFirst : StringsKt__StringsKt.replaceRange((CharSequence)$this$replaceFirst, index, index + 1, String.valueOf(newChar)).toString();
    }
    
    @NotNull
    public static final String replaceFirst(@NotNull final String $this$replaceFirst, @NotNull final String oldValue, @NotNull final String newValue, final boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$replaceFirst, "<this>");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        final int index = StringsKt__StringsKt.indexOf$default($this$replaceFirst, oldValue, 0, ignoreCase, 2, null);
        return (index < 0) ? $this$replaceFirst : StringsKt__StringsKt.replaceRange((CharSequence)$this$replaceFirst, index, index + oldValue.length(), newValue).toString();
    }
    
    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(Locale.getDefault())", imports = { "java.util.Locale" }))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    @java.lang.Deprecated
    private static final String toUpperCase(final String $this$toUpperCase) {
        Intrinsics.checkNotNullParameter($this$toUpperCase, "<this>");
        final String upperCase = $this$toUpperCase.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
        return upperCase;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final String uppercase(final String $this$uppercase) {
        Intrinsics.checkNotNullParameter($this$uppercase, "<this>");
        final String upperCase = $this$uppercase.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase;
    }
    
    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(Locale.getDefault())", imports = { "java.util.Locale" }))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    @java.lang.Deprecated
    private static final String toLowerCase(final String $this$toLowerCase) {
        Intrinsics.checkNotNullParameter($this$toLowerCase, "<this>");
        final String lowerCase = $this$toLowerCase.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        return lowerCase;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final String lowercase(final String $this$lowercase) {
        Intrinsics.checkNotNullParameter($this$lowercase, "<this>");
        final String lowerCase = $this$lowercase.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @NotNull
    public static final String concatToString(@NotNull final char[] $this$concatToString) {
        Intrinsics.checkNotNullParameter($this$concatToString, "<this>");
        return new String($this$concatToString);
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @NotNull
    public static final String concatToString(@NotNull final char[] $this$concatToString, final int startIndex, final int endIndex) {
        Intrinsics.checkNotNullParameter($this$concatToString, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, $this$concatToString.length);
        return new String($this$concatToString, startIndex, endIndex - startIndex);
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @NotNull
    public static final char[] toCharArray(@NotNull final String $this$toCharArray, final int startIndex, final int endIndex) {
        Intrinsics.checkNotNullParameter($this$toCharArray, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, $this$toCharArray.length());
        final char[] dst = new char[endIndex - startIndex];
        $this$toCharArray.getChars(startIndex, endIndex, dst, 0);
        return dst;
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @NotNull
    public static final String decodeToString(@NotNull final byte[] $this$decodeToString) {
        Intrinsics.checkNotNullParameter($this$decodeToString, "<this>");
        return new String($this$decodeToString, Charsets.UTF_8);
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @NotNull
    public static final String decodeToString(@NotNull final byte[] $this$decodeToString, final int startIndex, final int endIndex, final boolean throwOnInvalidSequence) {
        Intrinsics.checkNotNullParameter($this$decodeToString, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, $this$decodeToString.length);
        if (!throwOnInvalidSequence) {
            return new String($this$decodeToString, startIndex, endIndex - startIndex, Charsets.UTF_8);
        }
        final CharsetDecoder decoder = Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
        final String string = decoder.decode(ByteBuffer.wrap($this$decodeToString, startIndex, endIndex - startIndex)).toString();
        Intrinsics.checkNotNullExpressionValue(string, "decoder.decode(ByteBuffe\u2026- startIndex)).toString()");
        return string;
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @NotNull
    public static final byte[] encodeToByteArray(@NotNull final String $this$encodeToByteArray) {
        Intrinsics.checkNotNullParameter($this$encodeToByteArray, "<this>");
        final byte[] bytes = $this$encodeToByteArray.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @NotNull
    public static final byte[] encodeToByteArray(@NotNull final String $this$encodeToByteArray, final int startIndex, final int endIndex, final boolean throwOnInvalidSequence) {
        Intrinsics.checkNotNullParameter($this$encodeToByteArray, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, $this$encodeToByteArray.length());
        if (!throwOnInvalidSequence) {
            final String substring = $this$encodeToByteArray.substring(startIndex, endIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            final String object = substring;
            final Charset utf_8 = Charsets.UTF_8;
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type java.lang.String");
            final byte[] bytes = object.getBytes(utf_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes;
        }
        final CharsetEncoder encoder = Charsets.UTF_8.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
        final ByteBuffer byteBuffer = encoder.encode(CharBuffer.wrap($this$encodeToByteArray, startIndex, endIndex));
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            final int remaining = byteBuffer.remaining();
            final byte[] array = byteBuffer.array();
            Intrinsics.checkNotNull(array);
            if (remaining == array.length) {
                final byte[] array2;
                Intrinsics.checkNotNullExpressionValue(array2 = byteBuffer.array(), "{\n        byteBuffer.array()\n    }");
                return array2;
            }
        }
        final byte[] it = new byte[byteBuffer.remaining()];
        final int n = 0;
        byteBuffer.get(it);
        return it;
    }
    
    @InlineOnly
    private static final char[] toCharArray(final String $this$toCharArray) {
        Intrinsics.checkNotNullParameter($this$toCharArray, "<this>");
        final char[] charArray = $this$toCharArray.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        return charArray;
    }
    
    @InlineOnly
    private static final char[] toCharArray(final String $this$toCharArray, final char[] destination, final int destinationOffset, final int startIndex, final int endIndex) {
        Intrinsics.checkNotNullParameter($this$toCharArray, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        $this$toCharArray.getChars(startIndex, endIndex, destination, destinationOffset);
        return destination;
    }
    
    @InlineOnly
    private static final String format(final String $this$format, final Object... args) {
        Intrinsics.checkNotNullParameter($this$format, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        final String format = String.format($this$format, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        return format;
    }
    
    @InlineOnly
    private static final String format(final StringCompanionObject $this$format, final String format, final Object... args) {
        Intrinsics.checkNotNullParameter($this$format, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        final String format2 = String.format(format, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return format2;
    }
    
    @SinceKotlin(version = "1.4")
    @JvmName(name = "formatNullable")
    @InlineOnly
    private static final String formatNullable(final String $this$format, final Locale locale, final Object... args) {
        Intrinsics.checkNotNullParameter($this$format, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        final String format = String.format(locale, $this$format, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, this, *args)");
        return format;
    }
    
    @SinceKotlin(version = "1.4")
    @JvmName(name = "formatNullable")
    @InlineOnly
    private static final String formatNullable(final StringCompanionObject $this$format, final Locale locale, final String format, final Object... args) {
        Intrinsics.checkNotNullParameter($this$format, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        final String format2 = String.format(locale, format, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(format2, "format(locale, format, *args)");
        return format2;
    }
    
    @NotNull
    public static final List<String> split(@NotNull final CharSequence $this$split, @NotNull final Pattern regex, final int limit) {
        Intrinsics.checkNotNullParameter($this$split, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        StringsKt__StringsKt.requireNonNegativeLimit(limit);
        final String[] split = regex.split($this$split, (limit == 0) ? -1 : limit);
        Intrinsics.checkNotNullExpressionValue(split, "regex.split(this, if (limit == 0) -1 else limit)");
        return ArraysKt___ArraysJvmKt.asList(split);
    }
    
    @InlineOnly
    private static final String substring(final String $this$substring, final int startIndex) {
        Intrinsics.checkNotNullParameter($this$substring, "<this>");
        final String substring = $this$substring.substring(startIndex);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }
    
    @InlineOnly
    private static final String substring(final String $this$substring, final int startIndex, final int endIndex) {
        Intrinsics.checkNotNullParameter($this$substring, "<this>");
        final String substring = $this$substring.substring(startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }
    
    public static final boolean startsWith(@NotNull final String $this$startsWith, @NotNull final String prefix, final boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!ignoreCase) {
            return $this$startsWith.startsWith(prefix);
        }
        return regionMatches($this$startsWith, 0, prefix, 0, prefix.length(), ignoreCase);
    }
    
    public static final boolean startsWith(@NotNull final String $this$startsWith, @NotNull final String prefix, final int startIndex, final boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!ignoreCase) {
            return $this$startsWith.startsWith(prefix, startIndex);
        }
        return regionMatches($this$startsWith, startIndex, prefix, 0, prefix.length(), ignoreCase);
    }
    
    public static final boolean endsWith(@NotNull final String $this$endsWith, @NotNull final String suffix, final boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$endsWith, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (!ignoreCase) {
            return $this$endsWith.endsWith(suffix);
        }
        return regionMatches($this$endsWith, $this$endsWith.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }
    
    @InlineOnly
    private static final String String(final byte[] bytes, final int offset, final int length, final Charset charset) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(bytes, offset, length, charset);
    }
    
    @InlineOnly
    private static final String String(final byte[] bytes, final Charset charset) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(bytes, charset);
    }
    
    @InlineOnly
    private static final String String(final byte[] bytes, final int offset, final int length) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return new String(bytes, offset, length, Charsets.UTF_8);
    }
    
    @InlineOnly
    private static final String String(final byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return new String(bytes, Charsets.UTF_8);
    }
    
    @InlineOnly
    private static final String String(final char[] chars) {
        Intrinsics.checkNotNullParameter(chars, "chars");
        return new String(chars);
    }
    
    @InlineOnly
    private static final String String(final char[] chars, final int offset, final int length) {
        Intrinsics.checkNotNullParameter(chars, "chars");
        return new String(chars, offset, length);
    }
    
    @InlineOnly
    private static final String String(final int[] codePoints, final int offset, final int length) {
        Intrinsics.checkNotNullParameter(codePoints, "codePoints");
        return new String(codePoints, offset, length);
    }
    
    @InlineOnly
    private static final String String(final StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(stringBuffer, "stringBuffer");
        return new String(stringBuffer);
    }
    
    @InlineOnly
    private static final String String(final StringBuilder stringBuilder) {
        Intrinsics.checkNotNullParameter(stringBuilder, "stringBuilder");
        return new String(stringBuilder);
    }
    
    @InlineOnly
    private static final int codePointAt(final String $this$codePointAt, final int index) {
        Intrinsics.checkNotNullParameter($this$codePointAt, "<this>");
        return $this$codePointAt.codePointAt(index);
    }
    
    @InlineOnly
    private static final int codePointBefore(final String $this$codePointBefore, final int index) {
        Intrinsics.checkNotNullParameter($this$codePointBefore, "<this>");
        return $this$codePointBefore.codePointBefore(index);
    }
    
    @InlineOnly
    private static final int codePointCount(final String $this$codePointCount, final int beginIndex, final int endIndex) {
        Intrinsics.checkNotNullParameter($this$codePointCount, "<this>");
        return $this$codePointCount.codePointCount(beginIndex, endIndex);
    }
    
    public static final int compareTo(@NotNull final String $this$compareTo, @NotNull final String other, final boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$compareTo, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (ignoreCase) {
            return $this$compareTo.compareToIgnoreCase(other);
        }
        return $this$compareTo.compareTo(other);
    }
    
    @InlineOnly
    private static final boolean contentEquals(final String $this$contentEquals, final CharSequence charSequence) {
        Intrinsics.checkNotNullParameter($this$contentEquals, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        return $this$contentEquals.contentEquals(charSequence);
    }
    
    @InlineOnly
    private static final boolean contentEquals(final String $this$contentEquals, final StringBuffer stringBuilder) {
        Intrinsics.checkNotNullParameter($this$contentEquals, "<this>");
        Intrinsics.checkNotNullParameter(stringBuilder, "stringBuilder");
        return $this$contentEquals.contentEquals(stringBuilder);
    }
    
    @SinceKotlin(version = "1.5")
    public static final boolean contentEquals(@Nullable final CharSequence $this$contentEquals, @Nullable final CharSequence other) {
        return ($this$contentEquals instanceof String && other != null) ? ((String)$this$contentEquals).contentEquals(other) : StringsKt__StringsKt.contentEqualsImpl($this$contentEquals, other);
    }
    
    @SinceKotlin(version = "1.5")
    public static final boolean contentEquals(@Nullable final CharSequence $this$contentEquals, @Nullable final CharSequence other, final boolean ignoreCase) {
        return ignoreCase ? StringsKt__StringsKt.contentEqualsIgnoreCaseImpl($this$contentEquals, other) : contentEquals($this$contentEquals, other);
    }
    
    @InlineOnly
    private static final String intern(final String $this$intern) {
        Intrinsics.checkNotNullParameter($this$intern, "<this>");
        final String intern = $this$intern.intern();
        Intrinsics.checkNotNullExpressionValue(intern, "this as java.lang.String).intern()");
        return intern;
    }
    
    public static final boolean isBlank(@NotNull final CharSequence $this$isBlank) {
        Intrinsics.checkNotNullParameter($this$isBlank, "<this>");
        if ($this$isBlank.length() != 0) {
            final Iterable $this$all$iv = StringsKt__StringsKt.getIndices($this$isBlank);
            final int $i$f$all = 0;
            boolean b = false;
            Label_0099: {
                if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                    b = true;
                }
                else {
                    final Iterator iterator = $this$all$iv.iterator();
                    while (iterator.hasNext()) {
                        final int it;
                        final int element$iv = it = ((IntIterator)iterator).nextInt();
                        final int n = 0;
                        if (!CharsKt__CharJVMKt.isWhitespace($this$isBlank.charAt(it))) {
                            b = false;
                            break Label_0099;
                        }
                    }
                    b = true;
                }
            }
            if (!b) {
                return false;
            }
        }
        return true;
    }
    
    @InlineOnly
    private static final int offsetByCodePoints(final String $this$offsetByCodePoints, final int index, final int codePointOffset) {
        Intrinsics.checkNotNullParameter($this$offsetByCodePoints, "<this>");
        return $this$offsetByCodePoints.offsetByCodePoints(index, codePointOffset);
    }
    
    public static final boolean regionMatches(@NotNull final CharSequence $this$regionMatches, final int thisOffset, @NotNull final CharSequence other, final int otherOffset, final int length, final boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$regionMatches, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if ($this$regionMatches instanceof String && other instanceof String) {
            return regionMatches((String)$this$regionMatches, thisOffset, (String)other, otherOffset, length, ignoreCase);
        }
        return StringsKt__StringsKt.regionMatchesImpl($this$regionMatches, thisOffset, other, otherOffset, length, ignoreCase);
    }
    
    public static final boolean regionMatches(@NotNull final String $this$regionMatches, final int thisOffset, @NotNull final String other, final int otherOffset, final int length, final boolean ignoreCase) {
        Intrinsics.checkNotNullParameter($this$regionMatches, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return ignoreCase ? $this$regionMatches.regionMatches(ignoreCase, thisOffset, other, otherOffset, length) : $this$regionMatches.regionMatches(thisOffset, other, otherOffset, length);
    }
    
    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    @java.lang.Deprecated
    private static final String toLowerCase(final String $this$toLowerCase, final Locale locale) {
        Intrinsics.checkNotNullParameter($this$toLowerCase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        final String lowerCase = $this$toLowerCase.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final String lowercase(final String $this$lowercase, final Locale locale) {
        Intrinsics.checkNotNullParameter($this$lowercase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        final String lowerCase = $this$lowercase.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }
    
    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    @java.lang.Deprecated
    private static final String toUpperCase(final String $this$toUpperCase, final Locale locale) {
        Intrinsics.checkNotNullParameter($this$toUpperCase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        final String upperCase = $this$toUpperCase.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final String uppercase(final String $this$uppercase, final Locale locale) {
        Intrinsics.checkNotNullParameter($this$uppercase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        final String upperCase = $this$uppercase.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }
    
    @InlineOnly
    private static final byte[] toByteArray(final String $this$toByteArray, final Charset charset) {
        Intrinsics.checkNotNullParameter($this$toByteArray, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        final byte[] bytes = $this$toByteArray.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }
    
    @InlineOnly
    private static final Pattern toPattern(final String $this$toPattern, final int flags) {
        Intrinsics.checkNotNullParameter($this$toPattern, "<this>");
        final Pattern compile = Pattern.compile($this$toPattern, flags);
        Intrinsics.checkNotNullExpressionValue(compile, "compile(this, flags)");
        return compile;
    }
    
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", imports = { "java.util.Locale" }))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @NotNull
    @java.lang.Deprecated
    public static final String capitalize(@NotNull final String $this$capitalize) {
        Intrinsics.checkNotNullParameter($this$capitalize, "<this>");
        final Locale default1 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(default1, "getDefault()");
        return capitalize($this$capitalize, default1);
    }
    
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @LowPriorityInOverloadResolution
    @NotNull
    @java.lang.Deprecated
    public static final String capitalize(@NotNull final String $this$capitalize, @NotNull final Locale locale) {
        Intrinsics.checkNotNullParameter($this$capitalize, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        if ($this$capitalize.length() > 0) {
            final char firstChar = $this$capitalize.charAt(0);
            if (Character.isLowerCase(firstChar)) {
                final StringBuilder $this$capitalize_u24lambda_u245;
                final StringBuilder sb = $this$capitalize_u24lambda_u245 = new StringBuilder();
                final int n = 0;
                final char titleChar = Character.toTitleCase(firstChar);
                if (titleChar != Character.toUpperCase(firstChar)) {
                    $this$capitalize_u24lambda_u245.append(titleChar);
                }
                else {
                    final StringBuilder sb2 = $this$capitalize_u24lambda_u245;
                    final String substring = $this$capitalize.substring(0, 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    final String object = substring;
                    Intrinsics.checkNotNull(object, "null cannot be cast to non-null type java.lang.String");
                    final String upperCase = object.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                    sb2.append(upperCase);
                }
                final StringBuilder sb3 = $this$capitalize_u24lambda_u245;
                final String substring2 = $this$capitalize.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                sb3.append(substring2);
                final String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            }
        }
        return $this$capitalize;
    }
    
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(Locale.getDefault()) }", imports = { "java.util.Locale" }))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @NotNull
    @java.lang.Deprecated
    public static final String decapitalize(@NotNull final String $this$decapitalize) {
        Intrinsics.checkNotNullParameter($this$decapitalize, "<this>");
        String string;
        if ($this$decapitalize.length() > 0 && !Character.isLowerCase($this$decapitalize.charAt(0))) {
            final StringBuilder sb = new StringBuilder();
            final String substring = $this$decapitalize.substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            final String object = substring;
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type java.lang.String");
            final String lowerCase = object.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            final StringBuilder append = sb.append(lowerCase);
            final String substring2 = $this$decapitalize.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            string = append.append(substring2).toString();
        }
        else {
            string = $this$decapitalize;
        }
        return string;
    }
    
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(locale) }", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @LowPriorityInOverloadResolution
    @NotNull
    @java.lang.Deprecated
    public static final String decapitalize(@NotNull final String $this$decapitalize, @NotNull final Locale locale) {
        Intrinsics.checkNotNullParameter($this$decapitalize, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String string;
        if ($this$decapitalize.length() > 0 && !Character.isLowerCase($this$decapitalize.charAt(0))) {
            final StringBuilder sb = new StringBuilder();
            final String substring = $this$decapitalize.substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            final String object = substring;
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type java.lang.String");
            final String lowerCase = object.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            final StringBuilder append = sb.append(lowerCase);
            final String substring2 = $this$decapitalize.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            string = append.append(substring2).toString();
        }
        else {
            string = $this$decapitalize;
        }
        return string;
    }
    
    @NotNull
    public static final String repeat(@NotNull final CharSequence $this$repeat, final int n) {
        Intrinsics.checkNotNullParameter($this$repeat, "<this>");
        if (n < 0) {
            final int n2 = 0;
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + n + '.').toString());
        }
        String string = null;
        Label_0267: {
            switch (n) {
                case 0: {
                    string = "";
                    break;
                }
                case 1: {
                    string = $this$repeat.toString();
                    break;
                }
                default: {
                    switch ($this$repeat.length()) {
                        case 0: {
                            string = "";
                            break Label_0267;
                        }
                        case 1: {
                            final char char1 = $this$repeat.charAt(0);
                            final int n3 = 0;
                            int j = 0;
                            final char[] value = new char[n];
                            while (j < n) {
                                value[j] = char1;
                                ++j;
                            }
                            string = new String(value);
                            break Label_0267;
                        }
                        default: {
                            final StringBuilder sb = new StringBuilder(n * $this$repeat.length());
                            final IntIterator iterator = new IntRange(1, n).iterator();
                            while (iterator.hasNext()) {
                                final int i = iterator.nextInt();
                                sb.append($this$repeat);
                            }
                            final String string2 = sb.toString();
                            Intrinsics.checkNotNullExpressionValue(string2, "{\n                    va\u2026tring()\n                }");
                            string = string2;
                            break Label_0267;
                        }
                    }
                    break;
                }
            }
        }
        return string;
    }
    
    @NotNull
    public static final Comparator<String> getCASE_INSENSITIVE_ORDER(@NotNull final StringCompanionObject $this$CASE_INSENSITIVE_ORDER) {
        Intrinsics.checkNotNullParameter($this$CASE_INSENSITIVE_ORDER, "<this>");
        final Comparator<String> case_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.checkNotNullExpressionValue(case_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        return case_INSENSITIVE_ORDER;
    }
    
    public StringsKt__StringsJVMKt() {
    }
}
