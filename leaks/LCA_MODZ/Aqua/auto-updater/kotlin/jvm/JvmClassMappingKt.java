// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm;

import kotlin.internal.InlineOnly;
import kotlin.SinceKotlin;
import java.lang.annotation.Annotation;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Deprecated;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.Nullable;
import java.io.Serializable;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.reflect.KClass;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u001f\u0010\u001f\u001a\u00020 \"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0014*\u0006\u0012\u0002\b\u00030!¢\u0006\u0002\u0010\"\"'\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"5\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t*\u0002H\b8\u00c6\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"-\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00018G¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"&\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\u0002H\u00028\u00c6\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0015\";\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00018\u00c7\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"+\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012\"-\u0010\u001a\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0012\"+\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006#" }, d2 = { "annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "declaringJavaClass", "Ljava/lang/Class;", "E", "", "getDeclaringJavaClass$annotations", "(Ljava/lang/Enum;)V", "getDeclaringJavaClass", "(Ljava/lang/Enum;)Ljava/lang/Class;", "java", "getJavaClass$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "getRuntimeClassOfKClassInstance$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib" })
@JvmName(name = "JvmClassMappingKt")
public final class JvmClassMappingKt
{
    @JvmName(name = "getJavaClass")
    @NotNull
    public static final <T> Class<T> getJavaClass(@NotNull final KClass<T> $this$java) {
        Intrinsics.checkNotNullParameter($this$java, "<this>");
        final Class<?> jClass = ((ClassBasedDeclarationContainer)$this$java).getJClass();
        Intrinsics.checkNotNull(jClass, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return (Class<T>)jClass;
    }
    
    @Nullable
    public static final <T> Class<T> getJavaPrimitiveType(@NotNull final KClass<T> $this$javaPrimitiveType) {
        Intrinsics.checkNotNullParameter($this$javaPrimitiveType, "<this>");
        final Class thisJClass = ((ClassBasedDeclarationContainer)$this$javaPrimitiveType).getJClass();
        if (thisJClass.isPrimitive()) {
            Intrinsics.checkNotNull(thisJClass, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaPrimitiveType>>");
            return (Class<T>)thisJClass;
        }
        final String name = thisJClass.getName();
        if (name != null) {
            switch (name) {
                case "java.lang.Float": {
                    final Serializable s = Float.TYPE;
                    return (Class<T>)s;
                }
                case "java.lang.Void": {
                    final Serializable s = Void.TYPE;
                    return (Class<T>)s;
                }
                case "java.lang.Character": {
                    final Serializable s = Character.TYPE;
                    return (Class<T>)s;
                }
                case "java.lang.Long": {
                    final Serializable s = Long.TYPE;
                    return (Class<T>)s;
                }
                case "java.lang.Double": {
                    final Serializable s = Double.TYPE;
                    return (Class<T>)s;
                }
                case "java.lang.Short": {
                    final Serializable s = Short.TYPE;
                    return (Class<T>)s;
                }
                case "java.lang.Boolean": {
                    final Serializable s = Boolean.TYPE;
                    return (Class<T>)s;
                }
                case "java.lang.Byte": {
                    final Serializable s = Byte.TYPE;
                    return (Class<T>)s;
                }
                case "java.lang.Integer": {
                    final Serializable s = Integer.TYPE;
                    return (Class<T>)s;
                }
                default:
                    break;
            }
        }
        final Serializable s = null;
        return (Class<T>)s;
    }
    
    @NotNull
    public static final <T> Class<T> getJavaObjectType(@NotNull final KClass<T> $this$javaObjectType) {
        Intrinsics.checkNotNullParameter($this$javaObjectType, "<this>");
        final Class thisJClass = ((ClassBasedDeclarationContainer)$this$javaObjectType).getJClass();
        if (!thisJClass.isPrimitive()) {
            Intrinsics.checkNotNull(thisJClass, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return (Class<T>)thisJClass;
        }
        final String name = thisJClass.getName();
        Serializable object = null;
        Serializable s = null;
        Label_0282: {
            if (name != null) {
                switch (name) {
                    case "boolean": {
                        s = (object = Boolean.class);
                        break Label_0282;
                    }
                    case "void": {
                        s = (object = Void.class);
                        break Label_0282;
                    }
                    case "byte": {
                        s = (object = Byte.class);
                        break Label_0282;
                    }
                    case "double": {
                        s = (object = Double.class);
                        break Label_0282;
                    }
                    case "char": {
                        s = (object = Character.class);
                        break Label_0282;
                    }
                    case "short": {
                        s = (object = Short.class);
                        break Label_0282;
                    }
                    case "float": {
                        s = (object = Float.class);
                        break Label_0282;
                    }
                    case "int": {
                        s = (object = Integer.class);
                        break Label_0282;
                    }
                    case "long": {
                        s = (object = Long.class);
                        break Label_0282;
                    }
                    default:
                        break;
                }
            }
            s = (object = thisJClass);
        }
        Intrinsics.checkNotNull(object, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return (Class<T>)s;
    }
    
    @JvmName(name = "getKotlinClass")
    @NotNull
    public static final <T> KClass<T> getKotlinClass(@NotNull final Class<T> $this$kotlin) {
        Intrinsics.checkNotNullParameter($this$kotlin, "<this>");
        return (KClass<T>)Reflection.getOrCreateKotlinClass($this$kotlin);
    }
    
    @NotNull
    public static final <T> Class<T> getJavaClass(@NotNull final T $this$javaClass) {
        Intrinsics.checkNotNullParameter($this$javaClass, "<this>");
        final int $i$f$getJavaClass = 0;
        final Class<?> class1 = $this$javaClass.getClass();
        Intrinsics.checkNotNull(class1, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>");
        return (Class<T>)class1;
    }
    
    @JvmName(name = "getRuntimeClassOfKClassInstance")
    @NotNull
    @java.lang.Deprecated
    public static final <T> Class<KClass<T>> getRuntimeClassOfKClassInstance(@NotNull final KClass<T> $this$javaClass) {
        Intrinsics.checkNotNullParameter($this$javaClass, "<this>");
        final int $i$f$getRuntimeClassOfKClassInstance = 0;
        final Class<? extends KClass> class1 = $this$javaClass.getClass();
        Intrinsics.checkNotNull(class1, "null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>>");
        return (Class<KClass<T>>)class1;
    }
    
    @NotNull
    public static final <T extends Annotation> KClass<? extends T> getAnnotationClass(@NotNull final T $this$annotationClass) {
        Intrinsics.checkNotNullParameter($this$annotationClass, "<this>");
        final Class<? extends Annotation> annotationType = $this$annotationClass.annotationType();
        Intrinsics.checkNotNullExpressionValue(annotationType, "this as java.lang.annota\u2026otation).annotationType()");
        final KClass<Object> kotlinClass = getKotlinClass((Class<Object>)annotationType);
        Intrinsics.checkNotNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return (KClass<? extends T>)kotlinClass;
    }
    
    private static final <E extends Enum<E>> Class<E> getDeclaringJavaClass(final E $this$declaringJavaClass) {
        Intrinsics.checkNotNullParameter($this$declaringJavaClass, "<this>");
        final Class<E> declaringClass = $this$declaringJavaClass.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "this as java.lang.Enum<E>).declaringClass");
        return declaringClass;
    }
}
