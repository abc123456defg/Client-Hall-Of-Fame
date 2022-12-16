// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.internal;

import kotlin.jvm.JvmField;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import org.jetbrains.annotations.Nullable;
import kotlin.text.MatchGroup;
import java.util.regex.MatchResult;
import java.util.List;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u0013" }, d2 = { "Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "getSuppressed", "", "ReflectThrowable", "kotlin-stdlib" })
public class PlatformImplementations
{
    public void addSuppressed(@NotNull final Throwable cause, @NotNull final Throwable exception) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(exception, "exception");
        final Method addSuppressed = ReflectThrowable.addSuppressed;
        if (addSuppressed != null) {
            addSuppressed.invoke(cause, exception);
        }
    }
    
    @NotNull
    public List<Throwable> getSuppressed(@NotNull final Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        final Method getSuppressed = ReflectThrowable.getSuppressed;
        if (getSuppressed != null) {
            final Object invoke = getSuppressed.invoke(exception, new Object[0]);
            if (invoke != null) {
                final Object it = invoke;
                final int n = 0;
                final List<Throwable> list;
                if ((list = ArraysKt___ArraysJvmKt.asList((Throwable[])it)) != null) {
                    return list;
                }
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }
    
    @Nullable
    public MatchGroup getMatchResultNamedGroup(@NotNull final MatchResult matchResult, @NotNull final String name) {
        Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        Intrinsics.checkNotNullParameter(name, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
    
    @NotNull
    public Random defaultPlatformRandom() {
        return new FallbackThreadLocalRandom();
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006" }, d2 = { "Lkotlin/internal/PlatformImplementations$ReflectThrowable;", "", "()V", "addSuppressed", "Ljava/lang/reflect/Method;", "getSuppressed", "kotlin-stdlib" })
    private static final class ReflectThrowable
    {
        @NotNull
        public static final ReflectThrowable INSTANCE;
        @JvmField
        @Nullable
        public static final Method addSuppressed;
        @JvmField
        @Nullable
        public static final Method getSuppressed;
        
        static {
            INSTANCE = new ReflectThrowable();
            final Class throwableClass = Throwable.class;
            final Method[] throwableMethods = throwableClass.getMethods();
            Intrinsics.checkNotNullExpressionValue(throwableMethods, "throwableMethods");
            final Method[] array = throwableMethods;
            while (true) {
                for (int i = 0; i < array.length; ++i) {
                    Method it;
                    final Method method = it = array[i];
                    final int n = 0;
                    boolean b = false;
                    Label_0092: {
                        if (Intrinsics.areEqual(it.getName(), "addSuppressed")) {
                            final Class<?>[] parameterTypes = it.getParameterTypes();
                            Intrinsics.checkNotNullExpressionValue(parameterTypes, "it.parameterTypes");
                            if (Intrinsics.areEqual(ArraysKt___ArraysKt.singleOrNull(parameterTypes), throwableClass)) {
                                b = true;
                                break Label_0092;
                            }
                        }
                        b = false;
                    }
                    if (b) {
                        final Method addSuppressed2 = method;
                        addSuppressed = addSuppressed2;
                        final Method[] array2 = throwableMethods;
                        while (true) {
                            for (int j = 0; j < array2.length; ++j) {
                                it = array2[j];
                                final int n2 = 0;
                                if (Intrinsics.areEqual(it.getName(), "getSuppressed")) {
                                    final Method getSuppressed2 = it;
                                    getSuppressed = getSuppressed2;
                                    return;
                                }
                            }
                            final Method getSuppressed2 = null;
                            continue;
                        }
                    }
                }
                final Method addSuppressed2 = null;
                continue;
            }
        }
    }
}
