// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.reflect;

import org.jetbrains.annotations.Nullable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028\u00c0\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005" }, d2 = { "qualifiedOrSimpleName", "", "Lkotlin/reflect/KClass;", "getQualifiedOrSimpleName", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", "kotlin-stdlib" })
public final class KClassesImplKt
{
    @Nullable
    public static final String getQualifiedOrSimpleName(@NotNull final KClass<?> $this$qualifiedOrSimpleName) {
        Intrinsics.checkNotNullParameter($this$qualifiedOrSimpleName, "<this>");
        final int $i$f$getQualifiedOrSimpleName = 0;
        return $this$qualifiedOrSimpleName.getQualifiedName();
    }
}
