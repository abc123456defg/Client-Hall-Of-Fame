// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.reflect;

import org.jetbrains.annotations.Nullable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import java.lang.reflect.Type;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import java.lang.reflect.GenericArrayType;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010" }, d2 = { "Lkotlin/reflect/GenericArrayTypeImpl;", "Ljava/lang/reflect/GenericArrayType;", "Lkotlin/reflect/TypeImpl;", "elementType", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "equals", "", "other", "", "getGenericComponentType", "getTypeName", "", "hashCode", "", "toString", "kotlin-stdlib" })
@ExperimentalStdlibApi
final class GenericArrayTypeImpl implements GenericArrayType, TypeImpl
{
    @NotNull
    private final Type elementType;
    
    public GenericArrayTypeImpl(@NotNull final Type elementType) {
        Intrinsics.checkNotNullParameter(elementType, "elementType");
        this.elementType = elementType;
    }
    
    @NotNull
    @Override
    public Type getGenericComponentType() {
        return this.elementType;
    }
    
    @NotNull
    @Override
    public String getTypeName() {
        return TypesJVMKt.access$typeToString(this.elementType) + "[]";
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        return other instanceof GenericArrayType && Intrinsics.areEqual(this.getGenericComponentType(), ((GenericArrayType)other).getGenericComponentType());
    }
    
    @Override
    public int hashCode() {
        return this.getGenericComponentType().hashCode();
    }
    
    @NotNull
    @Override
    public String toString() {
        return this.getTypeName();
    }
}
