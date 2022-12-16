// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.reflect;

import kotlin.PublishedApi;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.SinceKotlin;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016" }, d2 = { "Lkotlin/reflect/KTypeProjection;", "", "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "getVariance", "()Lkotlin/reflect/KVariance;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib" })
@SinceKotlin(version = "1.1")
public final class KTypeProjection
{
    @NotNull
    public static final Companion Companion;
    @Nullable
    private final KVariance variance;
    @Nullable
    private final KType type;
    @JvmField
    @NotNull
    public static final KTypeProjection star;
    
    public KTypeProjection(@Nullable final KVariance variance, @Nullable final KType type) {
        this.variance = variance;
        this.type = type;
        if (this.variance == null != (this.type == null)) {
            final int n = 0;
            throw new IllegalArgumentException(((this.variance == null) ? "Star projection must have no type specified." : ("The projection variance " + this.variance + " requires type to be specified.")).toString());
        }
    }
    
    @Nullable
    public final KVariance getVariance() {
        return this.variance;
    }
    
    @Nullable
    public final KType getType() {
        return this.type;
    }
    
    @NotNull
    @Override
    public String toString() {
        final KVariance variance = this.variance;
        String s = null;
        switch ((variance == null) ? -1 : WhenMappings.$EnumSwitchMapping$0[variance.ordinal()]) {
            case -1: {
                s = "*";
                break;
            }
            case 1: {
                s = String.valueOf(this.type);
                break;
            }
            case 2: {
                s = "in " + this.type;
                break;
            }
            case 3: {
                s = "out " + this.type;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return s;
    }
    
    @Nullable
    public final KVariance component1() {
        return this.variance;
    }
    
    @Nullable
    public final KType component2() {
        return this.type;
    }
    
    @NotNull
    public final KTypeProjection copy(@Nullable final KVariance variance, @Nullable final KType type) {
        return new KTypeProjection(variance, type);
    }
    
    @Override
    public int hashCode() {
        int result = (this.variance == null) ? 0 : this.variance.hashCode();
        result = result * 31 + ((this.type == null) ? 0 : this.type.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KTypeProjection)) {
            return false;
        }
        final KTypeProjection kTypeProjection = (KTypeProjection)other;
        return this.variance == kTypeProjection.variance && Intrinsics.areEqual(this.type, kTypeProjection.type);
    }
    
    @JvmStatic
    @NotNull
    public static final KTypeProjection invariant(@NotNull final KType type) {
        return KTypeProjection.Companion.invariant(type);
    }
    
    @JvmStatic
    @NotNull
    public static final KTypeProjection contravariant(@NotNull final KType type) {
        return KTypeProjection.Companion.contravariant(type);
    }
    
    @JvmStatic
    @NotNull
    public static final KTypeProjection covariant(@NotNull final KType type) {
        return KTypeProjection.Companion.covariant(type);
    }
    
    static {
        Companion = new Companion(null);
        star = new KTypeProjection(null, null);
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002¨\u0006\u000e" }, d2 = { "Lkotlin/reflect/KTypeProjection$Companion;", "", "()V", "STAR", "Lkotlin/reflect/KTypeProjection;", "getSTAR", "()Lkotlin/reflect/KTypeProjection;", "star", "getStar$annotations", "contravariant", "type", "Lkotlin/reflect/KType;", "covariant", "invariant", "kotlin-stdlib" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @NotNull
        public final KTypeProjection getSTAR() {
            return KTypeProjection.star;
        }
        
        @JvmStatic
        @NotNull
        public final KTypeProjection invariant(@NotNull final KType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new KTypeProjection(KVariance.INVARIANT, type);
        }
        
        @JvmStatic
        @NotNull
        public final KTypeProjection contravariant(@NotNull final KType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new KTypeProjection(KVariance.IN, type);
        }
        
        @JvmStatic
        @NotNull
        public final KTypeProjection covariant(@NotNull final KType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new KTypeProjection(KVariance.OUT, type);
        }
    }
}
