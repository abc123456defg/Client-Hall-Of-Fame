// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.coroutines.intrinsics;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.Nullable;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function2;
import kotlin.internal.InlineOnly;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.Intrinsics;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\u001c\b\u0004\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0083\b¢\u0006\u0002\b\b\u001aD\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010\n\u001a]\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u001aA\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aZ\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0013\u001an\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0014\"\u0004\b\u0002\u0010\u0003*)\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0015¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\u0006\u0010\u0016\u001a\u0002H\u00142\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0081\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018" }, d2 = { "createCoroutineFromSuspendFunction", "Lkotlin/coroutines/Continuation;", "", "T", "completion", "block", "Lkotlin/Function1;", "", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "P", "Lkotlin/Function3;", "param", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib" }, xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
class IntrinsicsKt__IntrinsicsJvmKt
{
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object startCoroutineUninterceptedOrReturn(final Function1<? super Continuation<? super T>, ?> $this$startCoroutineUninterceptedOrReturn, final Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter($this$startCoroutineUninterceptedOrReturn, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        return ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity($this$startCoroutineUninterceptedOrReturn, 1)).invoke(completion);
    }
    
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> Object startCoroutineUninterceptedOrReturn(final Function2<? super R, ? super Continuation<? super T>, ?> $this$startCoroutineUninterceptedOrReturn, final R receiver, final Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter($this$startCoroutineUninterceptedOrReturn, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        return ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity($this$startCoroutineUninterceptedOrReturn, 2)).invoke(receiver, completion);
    }
    
    @InlineOnly
    private static final <R, P, T> Object startCoroutineUninterceptedOrReturn(final Function3<? super R, ? super P, ? super Continuation<? super T>, ?> $this$startCoroutineUninterceptedOrReturn, final R receiver, final P param, final Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter($this$startCoroutineUninterceptedOrReturn, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        return ((Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity($this$startCoroutineUninterceptedOrReturn, 3)).invoke(receiver, param, completion);
    }
    
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> Continuation<Unit> createCoroutineUnintercepted(@NotNull final Function1<? super Continuation<? super T>, ?> $this$createCoroutineUnintercepted, @NotNull final Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter($this$createCoroutineUnintercepted, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        final Continuation probeCompletion = DebugProbesKt.probeCoroutineCreated((Continuation<? super Object>)completion);
        Object create;
        if ($this$createCoroutineUnintercepted instanceof BaseContinuationImpl) {
            create = ((BaseContinuationImpl)$this$createCoroutineUnintercepted).create(probeCompletion);
        }
        else {
            final int $i$f$createCoroutineFromSuspendFunction = 0;
            final CoroutineContext context$iv = probeCompletion.getContext();
            create = ((context$iv == EmptyCoroutineContext.INSTANCE) ? ((IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1)new RestrictedContinuationImpl(probeCompletion, $this$createCoroutineUnintercepted) {
                private int label;
                
                @Nullable
                @Override
                protected Object invokeSuspend(@NotNull final Object result) {
                    Object invoke = null;
                    switch (this.label) {
                        case 0: {
                            this.label = 1;
                            ResultKt.throwOnFailure(result);
                            final Continuation it = this;
                            final int n = 0;
                            Intrinsics.checkNotNull(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$0>, kotlin.Any?>");
                            invoke = ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(this.$this_createCoroutineUnintercepted$inlined, 1)).invoke(it);
                            break;
                        }
                        case 1: {
                            this.label = 2;
                            ResultKt.throwOnFailure(result);
                            invoke = result;
                            break;
                        }
                        default: {
                            throw new IllegalStateException("This coroutine had already completed".toString());
                        }
                    }
                    return invoke;
                }
            }) : ((IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2)new ContinuationImpl(probeCompletion, context$iv, $this$createCoroutineUnintercepted) {
                private int label;
                
                @Nullable
                @Override
                protected Object invokeSuspend(@NotNull final Object result) {
                    Object invoke = null;
                    switch (this.label) {
                        case 0: {
                            this.label = 1;
                            ResultKt.throwOnFailure(result);
                            final Continuation it = this;
                            final int n = 0;
                            Intrinsics.checkNotNull(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$0>, kotlin.Any?>");
                            invoke = ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(this.$this_createCoroutineUnintercepted$inlined, 1)).invoke(it);
                            break;
                        }
                        case 1: {
                            this.label = 2;
                            ResultKt.throwOnFailure(result);
                            invoke = result;
                            break;
                        }
                        default: {
                            throw new IllegalStateException("This coroutine had already completed".toString());
                        }
                    }
                    return invoke;
                }
            }));
        }
        return (Continuation<Unit>)create;
    }
    
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <R, T> Continuation<Unit> createCoroutineUnintercepted(@NotNull final Function2<? super R, ? super Continuation<? super T>, ?> $this$createCoroutineUnintercepted, final R receiver, @NotNull final Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter($this$createCoroutineUnintercepted, "<this>");
        Intrinsics.checkNotNullParameter(completion, "completion");
        final Continuation probeCompletion = DebugProbesKt.probeCoroutineCreated((Continuation<? super Object>)completion);
        Object create;
        if ($this$createCoroutineUnintercepted instanceof BaseContinuationImpl) {
            create = ((BaseContinuationImpl)$this$createCoroutineUnintercepted).create(receiver, probeCompletion);
        }
        else {
            final int $i$f$createCoroutineFromSuspendFunction = 0;
            final CoroutineContext context$iv = probeCompletion.getContext();
            create = ((context$iv == EmptyCoroutineContext.INSTANCE) ? ((IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3)new RestrictedContinuationImpl(probeCompletion, $this$createCoroutineUnintercepted, receiver) {
                private int label;
                
                @Nullable
                @Override
                protected Object invokeSuspend(@NotNull final Object result) {
                    Object invoke = null;
                    switch (this.label) {
                        case 0: {
                            this.label = 1;
                            ResultKt.throwOnFailure(result);
                            final Continuation it = this;
                            final int n = 0;
                            Intrinsics.checkNotNull(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                            invoke = ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, it);
                            break;
                        }
                        case 1: {
                            this.label = 2;
                            ResultKt.throwOnFailure(result);
                            invoke = result;
                            break;
                        }
                        default: {
                            throw new IllegalStateException("This coroutine had already completed".toString());
                        }
                    }
                    return invoke;
                }
            }) : ((IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4)new ContinuationImpl(probeCompletion, context$iv, $this$createCoroutineUnintercepted, receiver) {
                private int label;
                
                @Nullable
                @Override
                protected Object invokeSuspend(@NotNull final Object result) {
                    Object invoke = null;
                    switch (this.label) {
                        case 0: {
                            this.label = 1;
                            ResultKt.throwOnFailure(result);
                            final Continuation it = this;
                            final int n = 0;
                            Intrinsics.checkNotNull(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                            invoke = ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, it);
                            break;
                        }
                        case 1: {
                            this.label = 2;
                            ResultKt.throwOnFailure(result);
                            invoke = result;
                            break;
                        }
                        default: {
                            throw new IllegalStateException("This coroutine had already completed".toString());
                        }
                    }
                    return invoke;
                }
            }));
        }
        return (Continuation<Unit>)create;
    }
    
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> Continuation<T> intercepted(@NotNull final Continuation<? super T> $this$intercepted) {
        Intrinsics.checkNotNullParameter($this$intercepted, "<this>");
        final ContinuationImpl continuationImpl = ($this$intercepted instanceof ContinuationImpl) ? ((ContinuationImpl)$this$intercepted) : null;
        Continuation<Object> intercepted;
        if (continuationImpl == null || (intercepted = continuationImpl.intercepted()) == null) {
            intercepted = (Continuation<Object>)$this$intercepted;
        }
        return (Continuation<T>)intercepted;
    }
    
    @SinceKotlin(version = "1.3")
    private static final <T> Continuation<Unit> createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(final Continuation<? super T> completion, final Function1<? super Continuation<? super T>, ?> block) {
        final int $i$f$createCoroutineFromSuspendFunction = 0;
        final CoroutineContext context = completion.getContext();
        return (Continuation<Unit>)((context == EmptyCoroutineContext.INSTANCE) ? new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1((Continuation)completion, (Function1)block) : ((Continuation<Unit>)new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2((Continuation)completion, context, (Function1)block)));
    }
    
    public IntrinsicsKt__IntrinsicsJvmKt() {
    }
}
