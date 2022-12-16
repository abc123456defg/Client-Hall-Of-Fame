// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.internal.jdk7;

import org.jetbrains.annotations.Nullable;
import kotlin.jvm.JvmField;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;
import kotlin.internal.PlatformImplementations;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000f" }, d2 = { "Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "Lkotlin/internal/PlatformImplementations;", "()V", "addSuppressed", "", "cause", "", "exception", "getSuppressed", "", "sdkIsNullOrAtLeast", "", "version", "", "ReflectSdkVersion", "kotlin-stdlib-jdk7" })
public class JDK7PlatformImplementations extends PlatformImplementations
{
    private final boolean sdkIsNullOrAtLeast(final int version) {
        return ReflectSdkVersion.sdkVersion == null || ReflectSdkVersion.sdkVersion >= version;
    }
    
    @Override
    public void addSuppressed(@NotNull final Throwable cause, @NotNull final Throwable exception) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (this.sdkIsNullOrAtLeast(19)) {
            cause.addSuppressed(exception);
        }
        else {
            super.addSuppressed(cause, exception);
        }
    }
    
    @NotNull
    @Override
    public List<Throwable> getSuppressed(@NotNull final Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        List<Throwable> list;
        if (this.sdkIsNullOrAtLeast(19)) {
            final Throwable[] suppressed = exception.getSuppressed();
            Intrinsics.checkNotNullExpressionValue(suppressed, "exception.suppressed");
            list = ArraysKt___ArraysJvmKt.asList(suppressed);
        }
        else {
            list = super.getSuppressed(exception);
        }
        return list;
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0006" }, d2 = { "Lkotlin/internal/jdk7/JDK7PlatformImplementations$ReflectSdkVersion;", "", "()V", "sdkVersion", "", "Ljava/lang/Integer;", "kotlin-stdlib-jdk7" })
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
