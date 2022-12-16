// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.coroutines;

import org.jetbrains.annotations.Nullable;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0007¨\u0006\b" }, d2 = { "getPolymorphicElement", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusPolymorphicKey", "Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib" })
public final class CoroutineContextImplKt
{
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @Nullable
    public static final <E extends CoroutineContext.Element> E getPolymorphicElement(@NotNull final CoroutineContext.Element $this$getPolymorphicElement, @NotNull final CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter($this$getPolymorphicElement, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (key instanceof AbstractCoroutineContextKey) {
            CoroutineContext.Element element;
            if (((AbstractCoroutineContextKey)key).isSubKey$kotlin_stdlib($this$getPolymorphicElement.getKey())) {
                final CoroutineContext.Element tryCast$kotlin_stdlib = ((AbstractCoroutineContextKey<B, CoroutineContext.Element>)key).tryCast$kotlin_stdlib($this$getPolymorphicElement);
                element = ((tryCast$kotlin_stdlib instanceof CoroutineContext.Element) ? tryCast$kotlin_stdlib : null);
            }
            else {
                element = null;
            }
            return (E)element;
        }
        return (E)(($this$getPolymorphicElement.getKey() == key) ? $this$getPolymorphicElement : null);
    }
    
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    public static final CoroutineContext minusPolymorphicKey(@NotNull final CoroutineContext.Element $this$minusPolymorphicKey, @NotNull final CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter($this$minusPolymorphicKey, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (key instanceof AbstractCoroutineContextKey) {
            return (CoroutineContext)((((AbstractCoroutineContextKey)key).isSubKey$kotlin_stdlib($this$minusPolymorphicKey.getKey()) && ((AbstractCoroutineContextKey<?, ?>)key).tryCast$kotlin_stdlib($this$minusPolymorphicKey) != null) ? ((EmptyCoroutineContext)EmptyCoroutineContext.INSTANCE) : ((CoroutineContext.Element)$this$minusPolymorphicKey));
        }
        return (CoroutineContext)(($this$minusPolymorphicKey.getKey() == key) ? ((EmptyCoroutineContext)EmptyCoroutineContext.INSTANCE) : ((CoroutineContext.Element)$this$minusPolymorphicKey));
    }
}
