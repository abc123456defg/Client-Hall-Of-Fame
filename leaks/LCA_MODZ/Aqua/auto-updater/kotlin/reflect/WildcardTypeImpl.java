// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.reflect;

import kotlin.jvm.internal.DefaultConstructorMarker;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import java.lang.reflect.Type;
import org.jetbrains.annotations.NotNull;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import java.lang.reflect.WildcardType;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015" }, d2 = { "Lkotlin/reflect/WildcardTypeImpl;", "Ljava/lang/reflect/WildcardType;", "Lkotlin/reflect/TypeImpl;", "upperBound", "Ljava/lang/reflect/Type;", "lowerBound", "(Ljava/lang/reflect/Type;Ljava/lang/reflect/Type;)V", "equals", "", "other", "", "getLowerBounds", "", "()[Ljava/lang/reflect/Type;", "getTypeName", "", "getUpperBounds", "hashCode", "", "toString", "Companion", "kotlin-stdlib" })
@ExperimentalStdlibApi
final class WildcardTypeImpl implements WildcardType, TypeImpl
{
    @NotNull
    public static final Companion Companion;
    @Nullable
    private final Type upperBound;
    @Nullable
    private final Type lowerBound;
    @NotNull
    private static final WildcardTypeImpl STAR;
    
    public WildcardTypeImpl(@Nullable final Type upperBound, @Nullable final Type lowerBound) {
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
    }
    
    @NotNull
    @Override
    public Type[] getUpperBounds() {
        final Type[] array = { null };
        final int n = 0;
        Type upperBound;
        if ((upperBound = this.upperBound) == null) {
            upperBound = Object.class;
        }
        array[n] = upperBound;
        return array;
    }
    
    @NotNull
    @Override
    public Type[] getLowerBounds() {
        Type[] array;
        if (this.lowerBound == null) {
            final int $i$f$emptyArray = 0;
            array = new Type[0];
        }
        else {
            array = new Type[] { this.lowerBound };
        }
        return array;
    }
    
    @NotNull
    @Override
    public String getTypeName() {
        return (this.lowerBound != null) ? ("? super " + TypesJVMKt.access$typeToString(this.lowerBound)) : ((this.upperBound != null && !Intrinsics.areEqual(this.upperBound, Object.class)) ? ("? extends " + TypesJVMKt.access$typeToString(this.upperBound)) : "?");
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        return other instanceof WildcardType && Arrays.equals(this.getUpperBounds(), ((WildcardType)other).getUpperBounds()) && Arrays.equals(this.getLowerBounds(), ((WildcardType)other).getLowerBounds());
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.getUpperBounds()) ^ Arrays.hashCode(this.getLowerBounds());
    }
    
    @NotNull
    @Override
    public String toString() {
        return this.getTypeName();
    }
    
    public static final /* synthetic */ WildcardTypeImpl access$getSTAR$cp() {
        return WildcardTypeImpl.STAR;
    }
    
    static {
        Companion = new Companion(null);
        STAR = new WildcardTypeImpl(null, null);
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007" }, d2 = { "Lkotlin/reflect/WildcardTypeImpl$Companion;", "", "()V", "STAR", "Lkotlin/reflect/WildcardTypeImpl;", "getSTAR", "()Lkotlin/reflect/WildcardTypeImpl;", "kotlin-stdlib" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @NotNull
        public final WildcardTypeImpl getSTAR() {
            return WildcardTypeImpl.access$getSTAR$cp();
        }
    }
}
