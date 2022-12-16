// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.reflect;

import java.lang.annotation.Annotation;
import org.jetbrains.annotations.Nullable;
import java.lang.reflect.Type;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.TypeVariable;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\u0011\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\b\b\u0000\u0010\u0010*\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012¢\u0006\u0002\u0010\u0013J\u0011\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\fH\u0016¢\u0006\u0002\u0010\u0017J\u0011\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 " }, d2 = { "Lkotlin/reflect/TypeVariableImpl;", "Ljava/lang/reflect/TypeVariable;", "Ljava/lang/reflect/GenericDeclaration;", "Lkotlin/reflect/TypeImpl;", "typeParameter", "Lkotlin/reflect/KTypeParameter;", "(Lkotlin/reflect/KTypeParameter;)V", "equals", "", "other", "", "getAnnotatedBounds", "", "", "()[Ljava/lang/annotation/Annotation;", "getAnnotation", "T", "annotationClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;", "getAnnotations", "getBounds", "Ljava/lang/reflect/Type;", "()[Ljava/lang/reflect/Type;", "getDeclaredAnnotations", "getGenericDeclaration", "getName", "", "getTypeName", "hashCode", "", "toString", "kotlin-stdlib" })
@ExperimentalStdlibApi
final class TypeVariableImpl implements TypeVariable<GenericDeclaration>, TypeImpl
{
    @NotNull
    private final KTypeParameter typeParameter;
    
    public TypeVariableImpl(@NotNull final KTypeParameter typeParameter) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        this.typeParameter = typeParameter;
    }
    
    @NotNull
    @Override
    public String getName() {
        return this.typeParameter.getName();
    }
    
    @NotNull
    @Override
    public GenericDeclaration getGenericDeclaration() {
        throw new NotImplementedError("An operation is not implemented: " + ("getGenericDeclaration() is not yet supported for type variables created from KType: " + this.typeParameter));
    }
    
    @NotNull
    @Override
    public Type[] getBounds() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        kotlin/reflect/TypeVariableImpl.typeParameter:Lkotlin/reflect/KTypeParameter;
        //     4: invokeinterface kotlin/reflect/KTypeParameter.getUpperBounds:()Ljava/util/List;
        //     9: checkcast       Ljava/lang/Iterable;
        //    12: astore_1        /* $this$map$iv */
        //    13: iconst_0       
        //    14: istore_2        /* $i$f$map */
        //    15: aload_1         /* $this$map$iv */
        //    16: astore_3       
        //    17: new             Ljava/util/ArrayList;
        //    20: dup            
        //    21: aload_1         /* $this$map$iv */
        //    22: bipush          10
        //    24: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    27: invokespecial   java/util/ArrayList.<init>:(I)V
        //    30: checkcast       Ljava/util/Collection;
        //    33: astore          destination$iv$iv
        //    35: iconst_0       
        //    36: istore          $i$f$mapTo
        //    38: aload_3         /* $this$mapTo$iv$iv */
        //    39: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    44: astore          6
        //    46: aload           6
        //    48: invokeinterface java/util/Iterator.hasNext:()Z
        //    53: ifeq            97
        //    56: aload           6
        //    58: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    63: astore          item$iv$iv
        //    65: aload           destination$iv$iv
        //    67: aload           item$iv$iv
        //    69: checkcast       Lkotlin/reflect/KType;
        //    72: astore          8
        //    74: astore          10
        //    76: iconst_0       
        //    77: istore          $i$a$-map-TypeVariableImpl$getBounds$1
        //    79: aload           it
        //    81: iconst_1       
        //    82: invokestatic    kotlin/reflect/TypesJVMKt.access$computeJavaType:(Lkotlin/reflect/KType;Z)Ljava/lang/reflect/Type;
        //    85: aload           10
        //    87: swap           
        //    88: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //    93: pop            
        //    94: goto            46
        //    97: aload           destination$iv$iv
        //    99: checkcast       Ljava/util/List;
        //   102: nop            
        //   103: checkcast       Ljava/util/Collection;
        //   106: astore_1       
        //   107: nop            
        //   108: iconst_0       
        //   109: istore_2        /* $i$f$toTypedArray */
        //   110: aload_1         /* $this$toTypedArray$iv */
        //   111: astore_3        /* thisCollection$iv */
        //   112: aload_3         /* thisCollection$iv */
        //   113: iconst_0       
        //   114: anewarray       Ljava/lang/reflect/Type;
        //   117: invokeinterface java/util/Collection.toArray:([Ljava/lang/Object;)[Ljava/lang/Object;
        //   122: dup            
        //   123: ldc             "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
        //   125: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   128: checkcast       [Ljava/lang/reflect/Type;
        //   131: areturn        
        //    StackMapTable: 00 02 FF 00 2E 00 07 07 00 02 07 00 42 01 07 00 42 07 00 4F 01 07 00 55 00 00 32
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @NotNull
    @Override
    public String getTypeName() {
        return this.getName();
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        return other instanceof TypeVariable && Intrinsics.areEqual(this.getName(), ((TypeVariable)other).getName()) && Intrinsics.areEqual(this.getGenericDeclaration(), ((TypeVariable)other).getGenericDeclaration());
    }
    
    @Override
    public int hashCode() {
        return this.getName().hashCode() ^ this.getGenericDeclaration().hashCode();
    }
    
    @NotNull
    @Override
    public String toString() {
        return this.getTypeName();
    }
    
    @Nullable
    @Override
    public final <T extends Annotation> T getAnnotation(@NotNull final Class<T> annotationClass) {
        Intrinsics.checkNotNullParameter(annotationClass, "annotationClass");
        return null;
    }
    
    @NotNull
    @Override
    public final Annotation[] getAnnotations() {
        final int $i$f$emptyArray = 0;
        return new Annotation[0];
    }
    
    @NotNull
    @Override
    public final Annotation[] getDeclaredAnnotations() {
        final int $i$f$emptyArray = 0;
        return new Annotation[0];
    }
    
    @NotNull
    public final Annotation[] getAnnotatedBounds() {
        final int $i$f$emptyArray = 0;
        return new Annotation[0];
    }
}
