// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.internal.jdk8;

import kotlin.jvm.JvmField;
import kotlin.random.jdk8.PlatformThreadLocalRandom;
import kotlin.random.Random;
import org.jetbrains.annotations.Nullable;
import kotlin.ranges.IntRange;
import java.util.regex.Matcher;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import org.jetbrains.annotations.NotNull;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.internal.jdk7.JDK7PlatformImplementations;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u0010" }, d2 = { "Lkotlin/internal/jdk8/JDK8PlatformImplementations;", "Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "()V", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "sdkIsNullOrAtLeast", "", "version", "", "ReflectSdkVersion", "kotlin-stdlib-jdk8" })
public class JDK8PlatformImplementations extends JDK7PlatformImplementations
{
    private final boolean sdkIsNullOrAtLeast(final int version) {
        return ReflectSdkVersion.sdkVersion == null || ReflectSdkVersion.sdkVersion >= version;
    }
    
    @Nullable
    @Override
    public MatchGroup getMatchResultNamedGroup(@NotNull final MatchResult matchResult, @NotNull final String name) {
        Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        Intrinsics.checkNotNullParameter(name, "name");
        final Matcher matcher2 = (matchResult instanceof Matcher) ? ((Matcher)matchResult) : null;
        if (matcher2 == null) {
            throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
        }
        final Matcher matcher = matcher2;
        final IntRange range = new IntRange(matcher.start(name), matcher.end(name) - 1);
        MatchGroup matchGroup;
        if (range.getStart() >= 0) {
            final String group;
            matchGroup = new MatchGroup(group, range);
            group = matcher.group(name);
            Intrinsics.checkNotNullExpressionValue(group, "matcher.group(name)");
        }
        else {
            matchGroup = null;
        }
        return matchGroup;
    }
    
    @NotNull
    @Override
    public Random defaultPlatformRandom() {
        return this.sdkIsNullOrAtLeast(34) ? ((PlatformThreadLocalRandom)new PlatformThreadLocalRandom()) : super.defaultPlatformRandom();
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0006" }, d2 = { "Lkotlin/internal/jdk8/JDK8PlatformImplementations$ReflectSdkVersion;", "", "()V", "sdkVersion", "", "Ljava/lang/Integer;", "kotlin-stdlib-jdk8" })
    private static final class ReflectSdkVersion
    {
        @NotNull
        public static final ReflectSdkVersion INSTANCE;
        @JvmField
        @Nullable
        public static final Integer sdkVersion;
        
        static {
            INSTANCE = new ReflectSdkVersion();
            Integer n;
            try {
                final Object value = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
                n = ((value instanceof Integer) ? ((Integer)value) : null);
            }
            catch (Throwable e) {
                n = null;
            }
            final Integer n2 = n;
            Integer sdkVersion2;
            if (n2 != null) {
                final Integer n3 = n2;
                final int it = n3.intValue();
                final int n4 = 0;
                sdkVersion2 = ((it > 0) ? n3 : null);
            }
            else {
                sdkVersion2 = null;
            }
            sdkVersion = sdkVersion2;
        }
    }
}
