// 
// Decompiled by Procyon v0.5.36
// 

package kotlin;

import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.jvm.functions.Function3;
import kotlin.coroutines.Continuation;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004BK\u00129\u0010\u0005\u001a5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\b\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u00f8\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u0015\u001a\u00028\u00012\u0006\u0010\t\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0016Jc\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000429\u0010\u0018\u001a5\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\b\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0002\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u001b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016\u00f8\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u000b\u0010\u001d\u001a\u00028\u0001¢\u0006\u0002\u0010\u001eJ5\u0010\u0015\u001a\u0002H\u001f\"\u0004\b\u0002\u0010 \"\u0004\b\u0003\u0010\u001f*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\u001f0!2\u0006\u0010\t\u001a\u0002H H\u0096@\u00f8\u0001\u0000¢\u0006\u0002\u0010\"R\u0018\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fRF\u0010\u0010\u001a5\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\b\bX\u0082\u000e\u00f8\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0011R\u001e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0013X\u0082\u000e\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006#" }, d2 = { "Lkotlin/DeepRecursiveScopeImpl;", "T", "R", "Lkotlin/DeepRecursiveScope;", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function3;", "", "Lkotlin/ExtensionFunctionType;", "value", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;)V", "cont", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "function", "Lkotlin/jvm/functions/Function3;", "result", "Lkotlin/Result;", "Ljava/lang/Object;", "callRecursive", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "crossFunctionCompletion", "currentFunction", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "resumeWith", "", "(Ljava/lang/Object;)V", "runCallLoop", "()Ljava/lang/Object;", "S", "U", "Lkotlin/DeepRecursiveFunction;", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib" })
final class DeepRecursiveScopeImpl<T, R> extends DeepRecursiveScope<T, R> implements Continuation<R>
{
    @NotNull
    private Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ?> function;
    @Nullable
    private Object value;
    @Nullable
    private Continuation<Object> cont;
    @NotNull
    private Object result;
    
    public DeepRecursiveScopeImpl(@NotNull final Function3<? super DeepRecursiveScope<T, R>, ? super T, ? super Continuation<? super R>, ?> block, final T value) {
        Intrinsics.checkNotNullParameter(block, "block");
        super(null);
        this.function = (Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ?>)block;
        this.value = value;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.cont = (Continuation<Object>)this;
        this.result = DeepRecursiveKt.access$getUNDEFINED_RESULT$p();
    }
    
    @NotNull
    @Override
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
    
    @Override
    public void resumeWith(@NotNull final Object result) {
        this.cont = null;
        this.result = result;
    }
    
    @Nullable
    @Override
    public Object callRecursive(final T value, @NotNull final Continuation<? super R> $completion) {
        final Continuation cont = $completion;
        final int n = 0;
        Intrinsics.checkNotNull(cont, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.cont = (Continuation<Object>)cont;
        this.value = value;
        final Object coroutine_SUSPENDED = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_SUSPENDED == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return coroutine_SUSPENDED;
    }
    
    @Nullable
    @Override
    public <U, S> Object callRecursive(@NotNull final DeepRecursiveFunction<U, S> $this$callRecursive, final U value, @NotNull final Continuation<? super S> $completion) {
        final Continuation cont = $completion;
        final int n = 0;
        final Function3<DeepRecursiveScope<U, S>, U, Continuation<? super S>, Object> block$kotlin_stdlib = $this$callRecursive.getBlock$kotlin_stdlib();
        Intrinsics.checkNotNull(block$kotlin_stdlib, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<kotlin.DeepRecursiveScope<*, *>, kotlin.Any?, kotlin.Any?>{ kotlin.DeepRecursiveKt.DeepRecursiveFunctionBlock }");
        final Function3 function = block$kotlin_stdlib;
        final DeepRecursiveScopeImpl $this$callRecursive_u24lambda_u242_u24lambda_u241 = this;
        final int n2 = 0;
        final Function3 currentFunction = $this$callRecursive_u24lambda_u242_u24lambda_u241.function;
        if (function != currentFunction) {
            $this$callRecursive_u24lambda_u242_u24lambda_u241.function = (Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ?>)function;
            final DeepRecursiveScopeImpl deepRecursiveScopeImpl = $this$callRecursive_u24lambda_u242_u24lambda_u241;
            final DeepRecursiveScopeImpl deepRecursiveScopeImpl2 = $this$callRecursive_u24lambda_u242_u24lambda_u241;
            final Function3 currentFunction2 = currentFunction;
            Intrinsics.checkNotNull(cont, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            deepRecursiveScopeImpl.cont = (Continuation<Object>)deepRecursiveScopeImpl2.crossFunctionCompletion(currentFunction2, cont);
        }
        else {
            final DeepRecursiveScopeImpl deepRecursiveScopeImpl3 = $this$callRecursive_u24lambda_u242_u24lambda_u241;
            Intrinsics.checkNotNull(cont, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            deepRecursiveScopeImpl3.cont = (Continuation<Object>)cont;
        }
        $this$callRecursive_u24lambda_u242_u24lambda_u241.value = value;
        final Object coroutine_SUSPENDED = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_SUSPENDED == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return coroutine_SUSPENDED;
    }
    
    private final Continuation<Object> crossFunctionCompletion(final Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ?> currentFunction, final Continuation<Object> cont) {
        return new Continuation<Object>(EmptyCoroutineContext.INSTANCE, this, currentFunction, cont) {
            @NotNull
            @Override
            public CoroutineContext getContext() {
                return this.$context;
            }
            
            @Override
            public void resumeWith(@NotNull final Object result) {
                final Object it = result;
                final int n = 0;
                DeepRecursiveScopeImpl.access$setFunction$p(this.this$0, this.$currentFunction$inlined);
                DeepRecursiveScopeImpl.access$setCont$p(this.this$0, this.$cont$inlined);
                DeepRecursiveScopeImpl.access$setResult$p(this.this$0, it);
            }
        };
    }
    
    public final R runCallLoop() {
        Object result;
        while (true) {
            result = this.result;
            final Continuation<Object> cont2 = this.cont;
            if (cont2 == null) {
                break;
            }
            final Continuation cont = cont2;
            if (Result.equals-impl0(DeepRecursiveKt.access$getUNDEFINED_RESULT$p(), result)) {
                Object invoke;
                try {
                    final Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ?> function = this.function;
                    final Object value = this.value;
                    Intrinsics.checkNotNull(function, "null cannot be cast to non-null type kotlin.Function3<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.startCoroutineUninterceptedOrReturn, P of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.startCoroutineUninterceptedOrReturn, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.startCoroutineUninterceptedOrReturn>, kotlin.Any?>");
                    invoke = ((Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(function, 3)).invoke(this, value, cont);
                }
                catch (Throwable e) {
                    final Continuation continuation = cont;
                    final Result.Companion companion = Result.Companion;
                    continuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(e)));
                    continue;
                }
                final Object r = invoke;
                if (r == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    continue;
                }
                final Continuation continuation2 = cont;
                final Result.Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.constructor-impl(r));
            }
            else {
                this.result = DeepRecursiveKt.access$getUNDEFINED_RESULT$p();
                cont.resumeWith(result);
            }
        }
        final Object $this$throwOnFailure = result;
        ResultKt.throwOnFailure($this$throwOnFailure);
        return (R)$this$throwOnFailure;
    }
    
    public static final /* synthetic */ void access$setFunction$p(final DeepRecursiveScopeImpl $this, final Function3 <set-?>) {
        $this.function = (Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ?>)<set-?>;
    }
    
    public static final /* synthetic */ void access$setCont$p(final DeepRecursiveScopeImpl $this, final Continuation <set-?>) {
        $this.cont = (Continuation<Object>)<set-?>;
    }
    
    public static final /* synthetic */ void access$setResult$p(final DeepRecursiveScopeImpl $this, final Object <set-?>) {
        $this.result = <set-?>;
    }
}
