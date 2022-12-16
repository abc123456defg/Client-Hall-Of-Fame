// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm.internal;

import kotlin.reflect.KVariance;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;
import java.lang.annotation.Annotation;
import org.jetbrains.annotations.Nullable;
import kotlin.reflect.KTypeProjection;
import java.util.List;
import kotlin.reflect.KClassifier;
import org.jetbrains.annotations.NotNull;
import kotlin.SinceKotlin;
import kotlin.Metadata;
import kotlin.reflect.KType;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\bH\u0002J\u0013\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0096\u0002J\b\u0010'\u001a\u00020\fH\u0016J\b\u0010(\u001a\u00020\u001eH\u0016J\f\u0010\"\u001a\u00020\u001e*\u00020\u0006H\u0002R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u000b\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0019R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006*" }, d2 = { "Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "classifier", "Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "isMarkedNullable", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "platformTypeUpperBound", "flags", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Lkotlin/reflect/KType;I)V", "annotations", "", "getAnnotations", "()Ljava/util/List;", "getArguments", "getClassifier", "()Lkotlin/reflect/KClassifier;", "getFlags$kotlin_stdlib$annotations", "()V", "getFlags$kotlin_stdlib", "()I", "()Z", "getPlatformTypeUpperBound$kotlin_stdlib$annotations", "getPlatformTypeUpperBound$kotlin_stdlib", "()Lkotlin/reflect/KType;", "arrayClassName", "", "Ljava/lang/Class;", "getArrayClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "asString", "convertPrimitiveToWrapper", "equals", "other", "", "hashCode", "toString", "Companion", "kotlin-stdlib" })
@SinceKotlin(version = "1.4")
public final class TypeReference implements KType
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final KClassifier classifier;
    @NotNull
    private final List<KTypeProjection> arguments;
    @Nullable
    private final KType platformTypeUpperBound;
    private final int flags;
    public static final int IS_MARKED_NULLABLE = 1;
    public static final int IS_MUTABLE_COLLECTION_TYPE = 2;
    public static final int IS_NOTHING_TYPE = 4;
    
    @SinceKotlin(version = "1.6")
    public TypeReference(@NotNull final KClassifier classifier, @NotNull final List<KTypeProjection> arguments, @Nullable final KType platformTypeUpperBound, final int flags) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.classifier = classifier;
        this.arguments = arguments;
        this.platformTypeUpperBound = platformTypeUpperBound;
        this.flags = flags;
    }
    
    @NotNull
    @Override
    public KClassifier getClassifier() {
        return this.classifier;
    }
    
    @NotNull
    @Override
    public List<KTypeProjection> getArguments() {
        return this.arguments;
    }
    
    @Nullable
    public final KType getPlatformTypeUpperBound$kotlin_stdlib() {
        return this.platformTypeUpperBound;
    }
    
    public final int getFlags$kotlin_stdlib() {
        return this.flags;
    }
    
    public TypeReference(@NotNull final KClassifier classifier, @NotNull final List<KTypeProjection> arguments, final boolean isMarkedNullable) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this(classifier, arguments, null, isMarkedNullable ? 1 : 0);
    }
    
    @NotNull
    @Override
    public List<Annotation> getAnnotations() {
        return CollectionsKt__CollectionsKt.emptyList();
    }
    
    @Override
    public boolean isMarkedNullable() {
        return (this.flags & 0x1) != 0x0;
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        return other instanceof TypeReference && Intrinsics.areEqual(this.getClassifier(), ((TypeReference)other).getClassifier()) && Intrinsics.areEqual(this.getArguments(), ((TypeReference)other).getArguments()) && Intrinsics.areEqual(this.platformTypeUpperBound, ((TypeReference)other).platformTypeUpperBound) && this.flags == ((TypeReference)other).flags;
    }
    
    @Override
    public int hashCode() {
        return (this.getClassifier().hashCode() * 31 + this.getArguments().hashCode()) * 31 + Integer.valueOf(this.flags).hashCode();
    }
    
    @NotNull
    @Override
    public String toString() {
        return this.asString(false) + " (Kotlin reflection is not available)";
    }
    
    private final String asString(final boolean convertPrimitiveToWrapper) {
        final KClassifier classifier = this.getClassifier();
        final KClass<Object> $this$java = (classifier instanceof KClass) ? ((KClass<Object>)classifier) : null;
        final Class javaClass = ($this$java != null) ? JvmClassMappingKt.getJavaClass($this$java) : null;
        String s;
        if (javaClass == null) {
            s = this.getClassifier().toString();
        }
        else if ((this.flags & 0x4) != 0x0) {
            s = "kotlin.Nothing";
        }
        else if (javaClass.isArray()) {
            s = this.getArrayClassName(javaClass);
        }
        else if (convertPrimitiveToWrapper && javaClass.isPrimitive()) {
            final KClassifier classifier2 = this.getClassifier();
            Intrinsics.checkNotNull(classifier2, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            s = JvmClassMappingKt.getJavaObjectType((KClass<Object>)classifier2).getName();
        }
        else {
            s = javaClass.getName();
        }
        final String klass = s;
        final String args = this.getArguments().isEmpty() ? "" : CollectionsKt___CollectionsKt.joinToString$default(this.getArguments(), ", ", "<", ">", 0, null, (Function1)new TypeReference$asString$args.TypeReference$asString$args$1(this), 24, null);
        final String nullable = this.isMarkedNullable() ? "?" : "";
        final String result = klass + args + nullable;
        final KType upper = this.platformTypeUpperBound;
        String s2;
        if (upper instanceof TypeReference) {
            final String renderedUpper = ((TypeReference)upper).asString(true);
            s2 = (Intrinsics.areEqual(renderedUpper, result) ? result : (Intrinsics.areEqual(renderedUpper, result + '?') ? (result + '!') : ('(' + result + ".." + renderedUpper + ')')));
        }
        else {
            s2 = result;
        }
        return s2;
    }
    
    private final String getArrayClassName(final Class<?> $this$arrayClassName) {
        return Intrinsics.areEqual($this$arrayClassName, boolean[].class) ? "kotlin.BooleanArray" : (Intrinsics.areEqual($this$arrayClassName, char[].class) ? "kotlin.CharArray" : (Intrinsics.areEqual($this$arrayClassName, byte[].class) ? "kotlin.ByteArray" : (Intrinsics.areEqual($this$arrayClassName, short[].class) ? "kotlin.ShortArray" : (Intrinsics.areEqual($this$arrayClassName, int[].class) ? "kotlin.IntArray" : (Intrinsics.areEqual($this$arrayClassName, float[].class) ? "kotlin.FloatArray" : (Intrinsics.areEqual($this$arrayClassName, long[].class) ? "kotlin.LongArray" : (Intrinsics.areEqual($this$arrayClassName, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array")))))));
    }
    
    private final String asString(final KTypeProjection $this$asString) {
        if ($this$asString.getVariance() == null) {
            return "*";
        }
        final KType type = $this$asString.getType();
        final TypeReference typeReference = (type instanceof TypeReference) ? ((TypeReference)type) : null;
        String s;
        if (typeReference == null || (s = typeReference.asString(true)) == null) {
            s = String.valueOf($this$asString.getType());
        }
        final String typeString = s;
        String s2 = null;
        switch (WhenMappings.$EnumSwitchMapping$0[$this$asString.getVariance().ordinal()]) {
            case 1: {
                s2 = typeString;
                break;
            }
            case 2: {
                s2 = "in " + typeString;
                break;
            }
            case 3: {
                s2 = "out " + typeString;
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return s2;
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0007" }, d2 = { "Lkotlin/jvm/internal/TypeReference$Companion;", "", "()V", "IS_MARKED_NULLABLE", "", "IS_MUTABLE_COLLECTION_TYPE", "IS_NOTHING_TYPE", "kotlin-stdlib" })
    public static final class Companion
    {
        private Companion() {
        }
    }
}
