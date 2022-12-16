// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.sequences;

import kotlin.SinceKotlin;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.BuilderInference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000:\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2/\b\u0001\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aM\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\n0\u0014\"\u0004\b\u0000\u0010\n2/\b\u0001\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0015\"\u0012\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0004\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0005\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0007\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000*\f\b\u0002\u0010\u0016\"\u00020\u00012\u00020\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017" }, d2 = { "State_Done", "", "Lkotlin/sequences/State;", "State_Failed", "State_ManyNotReady", "State_ManyReady", "State_NotReady", "State_Ready", "iterator", "", "T", "block", "Lkotlin/Function2;", "Lkotlin/sequences/SequenceScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "sequence", "Lkotlin/sequences/Sequence;", "(Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", "State", "kotlin-stdlib" }, xs = "kotlin/sequences/SequencesKt")
class SequencesKt__SequenceBuilderKt
{
    private static final int State_NotReady = 0;
    private static final int State_ManyNotReady = 1;
    private static final int State_ManyReady = 2;
    private static final int State_Ready = 3;
    private static final int State_Done = 4;
    private static final int State_Failed = 5;
    
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> Sequence<T> sequence(@BuilderInference @NotNull final Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ?> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return new Sequence<T>(block) {
            @NotNull
            @Override
            public Iterator<T> iterator() {
                final int n = 0;
                return SequencesKt__SequenceBuilderKt.iterator((Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ?>)this.$block$inlined);
            }
        };
    }
    
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> Iterator<T> iterator(@BuilderInference @NotNull final Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ?> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        final SequenceBuilderIterator iterator = new SequenceBuilderIterator();
        iterator.setNextStep(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted((Function2<? super SequenceBuilderIterator, ? super Continuation<? super Object>, ?>)block, iterator, (Continuation<? super Object>)iterator));
        return (Iterator<T>)iterator;
    }
    
    public SequencesKt__SequenceBuilderKt() {
    }
}
