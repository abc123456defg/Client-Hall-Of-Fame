// 
// Decompiled by Procyon v0.5.36
// 

package kotlin;

import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.jvm.JvmInline;
import java.io.Serializable;

@JvmInline
@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087@\u0018\u0000 \"*\u0006\b\u0000\u0010\u0001 \u00012\u00060\u0002j\u0002`\u0003:\u0002\"#B\u0016\b\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00f8\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u00d6\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00018\u0000H\u0087\b¢\u0006\u0004\b\u0019\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u0088\u0001\u0004\u0092\u0001\u0004\u0018\u00010\u0005\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$" }, d2 = { "Lkotlin/Result;", "T", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "value", "", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isFailure", "", "isFailure-impl", "(Ljava/lang/Object;)Z", "isSuccess", "isSuccess-impl", "getValue$annotations", "()V", "equals", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "Failure", "kotlin-stdlib" })
@SinceKotlin(version = "1.3")
public final class Result<T> implements Serializable
{
    @NotNull
    public static final Companion Companion;
    @Nullable
    private final Object value = value;
    
    public static final boolean isSuccess-impl(final Object arg0) {
        return !(arg0 instanceof Failure);
    }
    
    public static final boolean isFailure-impl(final Object arg0) {
        return arg0 instanceof Failure;
    }
    
    @InlineOnly
    private static final T getOrNull-impl(final Object arg0) {
        return (T)(isFailure-impl(arg0) ? null : arg0);
    }
    
    @Nullable
    public static final Throwable exceptionOrNull-impl(final Object arg0) {
        return (arg0 instanceof Failure) ? ((Failure)arg0).exception : null;
    }
    
    @NotNull
    public static String toString-impl(final Object arg0) {
        return (arg0 instanceof Failure) ? ((Failure)arg0).toString() : ("Success(" + arg0 + ')');
    }
    
    @NotNull
    @Override
    public String toString() {
        return toString-impl(this.value);
    }
    
    public static int hashCode-impl(final Object arg0) {
        return (arg0 == null) ? 0 : arg0.hashCode();
    }
    
    @Override
    public int hashCode() {
        return hashCode-impl(this.value);
    }
    
    public static boolean equals-impl(final Object arg0, final Object other) {
        return other instanceof Result && Intrinsics.areEqual(arg0, ((Result)other).unbox-impl());
    }
    
    @Override
    public boolean equals(final Object other) {
        return equals-impl(this.value, other);
    }
    
    @PublishedApi
    @NotNull
    public static <T> Object constructor-impl(@Nullable final Object value) {
        return value;
    }
    
    public final /* synthetic */ Object unbox-impl() {
        return this.value;
    }
    
    public static final boolean equals-impl0(final Object p1, final Object p2) {
        return Intrinsics.areEqual(p1, p2);
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\n\u001a\u0002H\u0005H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f" }, d2 = { "Lkotlin/Result$Companion;", "", "()V", "failure", "Lkotlin/Result;", "T", "exception", "", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "success", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @InlineOnly
        @JvmName(name = "success")
        private final <T> Object success(final T value) {
            return Result.constructor-impl(value);
        }
        
        @InlineOnly
        @JvmName(name = "failure")
        private final <T> Object failure(final Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            return Result.constructor-impl(ResultKt.createFailure(exception));
        }
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e" }, d2 = { "Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "exception", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib" })
    public static final class Failure implements Serializable
    {
        @JvmField
        @NotNull
        public final Throwable exception;
        
        public Failure(@NotNull final Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.exception = exception;
        }
        
        @Override
        public boolean equals(@Nullable final Object other) {
            return other instanceof Failure && Intrinsics.areEqual(this.exception, ((Failure)other).exception);
        }
        
        @Override
        public int hashCode() {
            return this.exception.hashCode();
        }
        
        @NotNull
        @Override
        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }
}
