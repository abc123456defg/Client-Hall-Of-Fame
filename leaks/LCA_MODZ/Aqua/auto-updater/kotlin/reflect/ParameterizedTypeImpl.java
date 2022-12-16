// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.reflect;

import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import java.lang.reflect.Type;
import org.jetbrains.annotations.NotNull;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import java.lang.reflect.ParameterizedType;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010\tJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016¢\u0006\u0002\u0010\u0011J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0019" }, d2 = { "Lkotlin/reflect/ParameterizedTypeImpl;", "Ljava/lang/reflect/ParameterizedType;", "Lkotlin/reflect/TypeImpl;", "rawType", "Ljava/lang/Class;", "ownerType", "Ljava/lang/reflect/Type;", "typeArguments", "", "(Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/util/List;)V", "", "[Ljava/lang/reflect/Type;", "equals", "", "other", "", "getActualTypeArguments", "()[Ljava/lang/reflect/Type;", "getOwnerType", "getRawType", "getTypeName", "", "hashCode", "", "toString", "kotlin-stdlib" })
@ExperimentalStdlibApi
final class ParameterizedTypeImpl implements ParameterizedType, TypeImpl
{
    @NotNull
    private final Class<?> rawType;
    @Nullable
    private final Type ownerType;
    @NotNull
    private final Type[] typeArguments;
    
    public ParameterizedTypeImpl(@NotNull final Class<?> rawType, @Nullable final Type ownerType, @NotNull final List<? extends Type> typeArguments) {
        Intrinsics.checkNotNullParameter(rawType, "rawType");
        Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        this.rawType = rawType;
        this.ownerType = ownerType;
        final Collection $this$toTypedArray$iv = typeArguments;
        final int $i$f$toTypedArray = 0;
        final Collection thisCollection$iv = $this$toTypedArray$iv;
        final Type[] array = thisCollection$iv.toArray(new Type[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.typeArguments = array;
    }
    
    @NotNull
    @Override
    public Type getRawType() {
        return this.rawType;
    }
    
    @Nullable
    @Override
    public Type getOwnerType() {
        return this.ownerType;
    }
    
    @NotNull
    @Override
    public Type[] getActualTypeArguments() {
        return this.typeArguments;
    }
    
    @NotNull
    @Override
    public String getTypeName() {
        final StringBuilder $this$getTypeName_u24lambda_u240;
        final StringBuilder sb = $this$getTypeName_u24lambda_u240 = new StringBuilder();
        final int n = 0;
        if (this.ownerType != null) {
            $this$getTypeName_u24lambda_u240.append(TypesJVMKt.access$typeToString(this.ownerType));
            $this$getTypeName_u24lambda_u240.append("$");
            $this$getTypeName_u24lambda_u240.append(this.rawType.getSimpleName());
        }
        else {
            $this$getTypeName_u24lambda_u240.append(TypesJVMKt.access$typeToString(this.rawType));
        }
        if (this.typeArguments.length != 0) {
            ArraysKt___ArraysKt.joinTo$default(this.typeArguments, $this$getTypeName_u24lambda_u240, null, "<", ">", 0, null, (Function1)ParameterizedTypeImpl$getTypeName$1.ParameterizedTypeImpl$getTypeName$1$1.INSTANCE, 50, null);
        }
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        return other instanceof ParameterizedType && Intrinsics.areEqual(this.rawType, ((ParameterizedType)other).getRawType()) && Intrinsics.areEqual(this.ownerType, ((ParameterizedType)other).getOwnerType()) && Arrays.equals(this.getActualTypeArguments(), ((ParameterizedType)other).getActualTypeArguments());
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.rawType.hashCode();
        final Type ownerType = this.ownerType;
        return hashCode ^ ((ownerType != null) ? ownerType.hashCode() : 0) ^ Arrays.hashCode(this.getActualTypeArguments());
    }
    
    @NotNull
    @Override
    public String toString() {
        return this.getTypeName();
    }
}
