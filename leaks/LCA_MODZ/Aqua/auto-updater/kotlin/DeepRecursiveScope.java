// 
// Decompiled by Procyon v0.5.36
// 

package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.RestrictsSuspension;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0000H¦@\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0007J5\u0010\u0005\u001a\u0002H\b\"\u0004\b\u0002\u0010\t\"\u0004\b\u0003\u0010\b*\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\b0\n2\u0006\u0010\u0006\u001a\u0002H\tH¦@\u00f8\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001f\u0010\f\u001a\u00020\r*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0087\u0002\u0082\u0001\u0001\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f" }, d2 = { "Lkotlin/DeepRecursiveScope;", "T", "R", "", "()V", "callRecursive", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "S", "U", "Lkotlin/DeepRecursiveFunction;", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "", "Lkotlin/DeepRecursiveScopeImpl;", "kotlin-stdlib" })
@RestrictsSuspension
@SinceKotlin(version = "1.7")
@WasExperimental(markerClass = { ExperimentalStdlibApi.class })
public abstract class DeepRecursiveScope<T, R>
{
    private DeepRecursiveScope() {
    }
    
    @Nullable
    public abstract Object callRecursive(final T p0, @NotNull final Continuation<? super R> p1);
    
    @Nullable
    public abstract <U, S> Object callRecursive(@NotNull final DeepRecursiveFunction<U, S> p0, final U p1, @NotNull final Continuation<? super S> p2);
    
    @Deprecated(message = "'invoke' should not be called from DeepRecursiveScope. Use 'callRecursive' to do recursion in the heap instead of the call stack.", replaceWith = @ReplaceWith(expression = "this.callRecursive(value)", imports = {}), level = DeprecationLevel.ERROR)
    @NotNull
    @java.lang.Deprecated
    public final Void invoke(@NotNull final DeepRecursiveFunction<?, ?> $this$invoke, @Nullable final Object value) {
        Intrinsics.checkNotNullParameter($this$invoke, "<this>");
        throw new UnsupportedOperationException("Should not be called from DeepRecursiveScope");
    }
}
