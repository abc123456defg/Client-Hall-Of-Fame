// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.coroutines.jvm.internal;

import kotlin.jvm.JvmField;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f" }, d2 = { "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib" })
final class ModuleNameRetriever
{
    @NotNull
    public static final ModuleNameRetriever INSTANCE;
    @NotNull
    private static final Cache notOnJava9;
    @Nullable
    private static Cache cache;
    
    private ModuleNameRetriever() {
    }
    
    @Nullable
    public final String getModuleName(@NotNull final BaseContinuationImpl continuation) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Cache cache2;
        if ((cache2 = ModuleNameRetriever.cache) == null) {
            cache2 = this.buildCache(continuation);
        }
        final Cache cache = cache2;
        if (cache == ModuleNameRetriever.notOnJava9) {
            return null;
        }
        final Method getModuleMethod = cache.getModuleMethod;
        final Object o = (getModuleMethod != null) ? getModuleMethod.invoke(continuation.getClass(), new Object[0]) : null;
        if (o == null) {
            return null;
        }
        final Object module = o;
        final Method getDescriptorMethod = cache.getDescriptorMethod;
        final Object o2 = (getDescriptorMethod != null) ? getDescriptorMethod.invoke(module, new Object[0]) : null;
        if (o2 == null) {
            return null;
        }
        final Object descriptor = o2;
        final Method nameMethod = cache.nameMethod;
        final Object o3 = (nameMethod != null) ? nameMethod.invoke(descriptor, new Object[0]) : null;
        return (o3 instanceof String) ? ((String)o3) : null;
    }
    
    private final Cache buildCache(final BaseContinuationImpl continuation) {
        try {
            final Method getModuleMethod = Class.class.getDeclaredMethod("getModule", (Class<?>[])new Class[0]);
            final Class methodClass = continuation.getClass().getClassLoader().loadClass("java.lang.Module");
            final Method getDescriptorMethod = methodClass.getDeclaredMethod("getDescriptor", (Class[])new Class[0]);
            final Class moduleDescriptorClass = continuation.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor");
            final Method nameMethod = moduleDescriptorClass.getDeclaredMethod("name", (Class[])new Class[0]);
            final Cache it = new Cache(getModuleMethod, getDescriptorMethod, nameMethod);
            final int n = 0;
            final ModuleNameRetriever instance = ModuleNameRetriever.INSTANCE;
            return ModuleNameRetriever.cache = it;
        }
        catch (Exception ignored) {
            final Cache it2 = ModuleNameRetriever.notOnJava9;
            final int n2 = 0;
            final ModuleNameRetriever instance2 = ModuleNameRetriever.INSTANCE;
            return ModuleNameRetriever.cache = it2;
        }
    }
    
    static {
        INSTANCE = new ModuleNameRetriever();
        notOnJava9 = new Cache(null, null, null);
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007" }, d2 = { "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib" })
    private static final class Cache
    {
        @JvmField
        @Nullable
        public final Method getModuleMethod;
        @JvmField
        @Nullable
        public final Method getDescriptorMethod;
        @JvmField
        @Nullable
        public final Method nameMethod;
        
        public Cache(@Nullable final Method getModuleMethod, @Nullable final Method getDescriptorMethod, @Nullable final Method nameMethod) {
            this.getModuleMethod = getModuleMethod;
            this.getDescriptorMethod = getDescriptorMethod;
            this.nameMethod = nameMethod;
        }
    }
}
