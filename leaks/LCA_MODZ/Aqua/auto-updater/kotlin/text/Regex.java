// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.text;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.sequences.SequenceScope;
import kotlin.jvm.functions.Function2;
import java.util.ArrayList;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.WasExperimental;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function0;
import kotlin.sequences.Sequence;
import java.util.regex.Matcher;
import java.util.Collections;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.functions.Function1;
import java.util.EnumSet;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import java.util.Set;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;
import java.io.Serializable;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 02\u00060\u0001j\u0002`\u0002:\u000201B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0001\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001bH\u0007J\u0010\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u0011\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\u0004J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001bH\u0007J\"\u0010#\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170%J\u0016\u0010#\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004J\u0016\u0010'\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040)2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u001bJ \u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u001bH\u0007J\u0006\u0010,\u001a\u00020\rJ\b\u0010-\u001a\u00020\u0004H\u0016J\b\u0010.\u001a\u00020/H\u0002R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u00062" }, d2 = { "Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchAt", "index", "matchEntire", "matches", "matchesAt", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "splitToSequence", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib" })
public final class Regex implements Serializable
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Pattern nativePattern;
    @Nullable
    private Set<? extends RegexOption> _options;
    
    @PublishedApi
    public Regex(@NotNull final Pattern nativePattern) {
        Intrinsics.checkNotNullParameter(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }
    
    public Regex(@NotNull final String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        final Pattern compile = Pattern.compile(pattern);
        Intrinsics.checkNotNullExpressionValue(compile, "compile(pattern)");
        this(compile);
    }
    
    public Regex(@NotNull final String pattern, @NotNull final RegexOption option) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(option, "option");
        final Pattern compile = Pattern.compile(pattern, Regex.Companion.ensureUnicodeCase(option.getValue()));
        Intrinsics.checkNotNullExpressionValue(compile, "compile(pattern, ensureUnicodeCase(option.value))");
        this(compile);
    }
    
    public Regex(@NotNull final String pattern, @NotNull final Set<? extends RegexOption> options) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(options, "options");
        final Pattern compile = Pattern.compile(pattern, Regex.Companion.ensureUnicodeCase(RegexKt.access$toInt(options)));
        Intrinsics.checkNotNullExpressionValue(compile, "compile(pattern, ensureU\u2026odeCase(options.toInt()))");
        this(compile);
    }
    
    @NotNull
    public final String getPattern() {
        final String pattern = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(pattern, "nativePattern.pattern()");
        return pattern;
    }
    
    @NotNull
    public final Set<RegexOption> getOptions() {
        Set<? extends RegexOption> options;
        if ((options = this._options) == null) {
            final int value$iv = this.nativePattern.flags();
            final int $i$f$fromInt = 0;
            final EnumSet $this$fromInt_u24lambda_u241$iv;
            final EnumSet set = $this$fromInt_u24lambda_u241$iv = EnumSet.allOf(RegexOption.class);
            final int n = 0;
            Intrinsics.checkNotNullExpressionValue($this$fromInt_u24lambda_u241$iv, "fromInt$lambda$1");
            CollectionsKt__MutableCollectionsKt.retainAll((Iterable<?>)$this$fromInt_u24lambda_u241$iv, (Function1<? super Object, Boolean>)new Function1<RegexOption, Boolean>(value$iv) {
                @NotNull
                @Override
                public final Boolean invoke(final RegexOption it) {
                    return (this.$value & it.getMask()) == it.getValue();
                }
            });
            final Set<Object> unmodifiableSet = Collections.unmodifiableSet((Set<?>)set);
            Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(EnumSet.\u2026mask == it.value }\n    })");
            final Set it;
            final Set set2 = it = unmodifiableSet;
            final int n2 = 0;
            this._options = (Set<? extends RegexOption>)it;
            options = (Set<? extends RegexOption>)set2;
        }
        return (Set<RegexOption>)options;
    }
    
    public final boolean matches(@NotNull final CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).matches();
    }
    
    public final boolean containsMatchIn(@NotNull final CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).find();
    }
    
    @Nullable
    public final MatchResult find(@NotNull final CharSequence input, final int startIndex) {
        Intrinsics.checkNotNullParameter(input, "input");
        final Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, "nativePattern.matcher(input)");
        return RegexKt.access$findNext(matcher, startIndex, input);
    }
    
    public static /* synthetic */ MatchResult find$default(final Regex regex, final CharSequence input, int startIndex, final int n, final Object o) {
        if ((n & 0x2) != 0x0) {
            startIndex = 0;
        }
        return regex.find(input, startIndex);
    }
    
    @NotNull
    public final Sequence<MatchResult> findAll(@NotNull final CharSequence input, final int startIndex) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (startIndex < 0 || startIndex > input.length()) {
            throw new IndexOutOfBoundsException("Start index out of bounds: " + startIndex + ", input length: " + input.length());
        }
        return SequencesKt__SequencesKt.generateSequence((Function0<? extends MatchResult>)new Regex$findAll.Regex$findAll$1(this, input, startIndex), (Function1<? super MatchResult, ? extends MatchResult>)Regex$findAll.Regex$findAll$2.INSTANCE);
    }
    
    @Nullable
    public final MatchResult matchEntire(@NotNull final CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        final Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, "nativePattern.matcher(input)");
        return RegexKt.access$matchEntire(matcher, input);
    }
    
    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @Nullable
    public final MatchResult matchAt(@NotNull final CharSequence input, final int index) {
        Intrinsics.checkNotNullParameter(input, "input");
        final Matcher $this$matchAt_u24lambda_u241 = this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(index, input.length());
        final int n = 0;
        MatcherMatchResult matcherMatchResult;
        if ($this$matchAt_u24lambda_u241.lookingAt()) {
            matcherMatchResult = new MatcherMatchResult($this$matchAt_u24lambda_u241, input);
            Intrinsics.checkNotNullExpressionValue($this$matchAt_u24lambda_u241, "this");
        }
        else {
            matcherMatchResult = null;
        }
        return matcherMatchResult;
    }
    
    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    public final boolean matchesAt(@NotNull final CharSequence input, final int index) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(index, input.length()).lookingAt();
    }
    
    @NotNull
    public final String replace(@NotNull final CharSequence input, @NotNull final String replacement) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        final String replaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        Intrinsics.checkNotNullExpressionValue(replaceAll, "nativePattern.matcher(in\u2026).replaceAll(replacement)");
        return replaceAll;
    }
    
    @NotNull
    public final String replace(@NotNull final CharSequence input, @NotNull final Function1<? super MatchResult, ? extends CharSequence> transform) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(transform, "transform");
        final MatchResult find$default = find$default(this, input, 0, 2, null);
        if (find$default == null) {
            return input.toString();
        }
        MatchResult match = find$default;
        int lastStart = 0;
        final int length = input.length();
        final StringBuilder sb = new StringBuilder(length);
        do {
            final MatchResult foundMatch = match;
            sb.append(input, lastStart, foundMatch.getRange().getStart());
            sb.append((CharSequence)transform.invoke(foundMatch));
            lastStart = foundMatch.getRange().getEndInclusive() + 1;
            match = foundMatch.next();
        } while (lastStart < length && match != null);
        if (lastStart < length) {
            sb.append(input, lastStart, length);
        }
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }
    
    @NotNull
    public final String replaceFirst(@NotNull final CharSequence input, @NotNull final String replacement) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        final String replaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        Intrinsics.checkNotNullExpressionValue(replaceFirst, "nativePattern.matcher(in\u2026replaceFirst(replacement)");
        return replaceFirst;
    }
    
    @NotNull
    public final List<String> split(@NotNull final CharSequence input, final int limit) {
        Intrinsics.checkNotNullParameter(input, "input");
        StringsKt__StringsKt.requireNonNegativeLimit(limit);
        final Matcher matcher = this.nativePattern.matcher(input);
        if (limit == 1 || !matcher.find()) {
            return CollectionsKt__CollectionsJVMKt.listOf(input.toString());
        }
        final ArrayList result = new ArrayList((limit > 0) ? RangesKt___RangesKt.coerceAtMost(limit, 10) : 10);
        int lastStart = 0;
        final int lastSplit = limit - 1;
        do {
            result.add(input.subSequence(lastStart, matcher.start()).toString());
            lastStart = matcher.end();
        } while ((lastSplit < 0 || result.size() != lastSplit) && matcher.find());
        result.add(input.subSequence(lastStart, input.length()).toString());
        return (List<String>)result;
    }
    
    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @NotNull
    public final Sequence<String> splitToSequence(@NotNull final CharSequence input, final int limit) {
        Intrinsics.checkNotNullParameter(input, "input");
        StringsKt__StringsKt.requireNonNegativeLimit(limit);
        return SequencesKt__SequenceBuilderKt.sequence((Function2<? super SequenceScope<? super String>, ? super Continuation<? super Unit>, ?>)new Regex$splitToSequence.Regex$splitToSequence$1(this, input, limit, (Continuation)null));
    }
    
    @NotNull
    @Override
    public String toString() {
        final String string = this.nativePattern.toString();
        Intrinsics.checkNotNullExpressionValue(string, "nativePattern.toString()");
        return string;
    }
    
    @NotNull
    public final Pattern toPattern() {
        return this.nativePattern;
    }
    
    private final Object writeReplace() {
        final String pattern = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(pattern, "nativePattern.pattern()");
        return new Serialized(pattern, this.nativePattern.flags());
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f" }, d2 = { "Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib" })
    private static final class Serialized implements Serializable
    {
        @NotNull
        public static final Companion Companion;
        @NotNull
        private final String pattern;
        private final int flags;
        private static final long serialVersionUID = 0L;
        
        public Serialized(@NotNull final String pattern, final int flags) {
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            this.pattern = pattern;
            this.flags = flags;
        }
        
        @NotNull
        public final String getPattern() {
            return this.pattern;
        }
        
        public final int getFlags() {
            return this.flags;
        }
        
        private final Object readResolve() {
            final Pattern compile = Pattern.compile(this.pattern, this.flags);
            Intrinsics.checkNotNullExpressionValue(compile, "compile(pattern, flags)");
            return new Regex(compile);
        }
        
        static {
            Companion = new Companion(null);
        }
        
        @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005" }, d2 = { "Lkotlin/text/Regex$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib" })
        public static final class Companion
        {
            private Companion() {
            }
        }
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007¨\u0006\f" }, d2 = { "Lkotlin/text/Regex$Companion;", "", "()V", "ensureUnicodeCase", "", "flags", "escape", "", "literal", "escapeReplacement", "fromLiteral", "Lkotlin/text/Regex;", "kotlin-stdlib" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @NotNull
        public final Regex fromLiteral(@NotNull final String literal) {
            Intrinsics.checkNotNullParameter(literal, "literal");
            return new Regex(literal, RegexOption.LITERAL);
        }
        
        @NotNull
        public final String escape(@NotNull final String literal) {
            Intrinsics.checkNotNullParameter(literal, "literal");
            final String quote = Pattern.quote(literal);
            Intrinsics.checkNotNullExpressionValue(quote, "quote(literal)");
            return quote;
        }
        
        @NotNull
        public final String escapeReplacement(@NotNull final String literal) {
            Intrinsics.checkNotNullParameter(literal, "literal");
            final String quoteReplacement = Matcher.quoteReplacement(literal);
            Intrinsics.checkNotNullExpressionValue(quoteReplacement, "quoteReplacement(literal)");
            return quoteReplacement;
        }
        
        private final int ensureUnicodeCase(final int flags) {
            return ((flags & 0x2) != 0x0) ? (flags | 0x40) : flags;
        }
    }
}
