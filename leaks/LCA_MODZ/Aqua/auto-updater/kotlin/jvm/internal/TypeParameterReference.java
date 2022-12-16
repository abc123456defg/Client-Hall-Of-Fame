// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm.internal;

import kotlin.reflect.KType;
import java.util.List;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.SinceKotlin;
import kotlin.Metadata;
import kotlin.reflect.KTypeParameter;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u001d2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\b\u0010\u001e\u001a\u00020\u0005H\u0016R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006 " }, d2 = { "Lkotlin/jvm/internal/TypeParameterReference;", "Lkotlin/reflect/KTypeParameter;", "container", "", "name", "", "variance", "Lkotlin/reflect/KVariance;", "isReified", "", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", "bounds", "", "Lkotlin/reflect/KType;", "()Z", "getName", "()Ljava/lang/String;", "upperBounds", "getUpperBounds$annotations", "()V", "getUpperBounds", "()Ljava/util/List;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", "hashCode", "", "setUpperBounds", "", "toString", "Companion", "kotlin-stdlib" })
@SinceKotlin(version = "1.4")
public final class TypeParameterReference implements KTypeParameter
{
    @NotNull
    public static final Companion Companion;
    @Nullable
    private final Object container;
    @NotNull
    private final String name;
    @NotNull
    private final KVariance variance;
    private final boolean isReified;
    @Nullable
    private volatile List<? extends KType> bounds;
    
    public TypeParameterReference(@Nullable final Object container, @NotNull final String name, @NotNull final KVariance variance, final boolean isReified) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(variance, "variance");
        this.container = container;
        this.name = name;
        this.variance = variance;
        this.isReified = isReified;
    }
    
    @NotNull
    @Override
    public String getName() {
        return this.name;
    }
    
    @NotNull
    @Override
    public KVariance getVariance() {
        return this.variance;
    }
    
    @Override
    public boolean isReified() {
        return this.isReified;
    }
    
    @NotNull
    @Override
    public List<KType> getUpperBounds() {
        List<? extends KType> bounds;
        if ((bounds = this.bounds) == null) {
            final List it;
            final List list = it = CollectionsKt__CollectionsJVMKt.listOf(Reflection.nullableTypeOf(Object.class));
            final int n = 0;
            this.bounds = (List<? extends KType>)it;
            bounds = (List<? extends KType>)list;
        }
        return (List<KType>)bounds;
    }
    
    public final void setUpperBounds(@NotNull final List<? extends KType> upperBounds) {
        Intrinsics.checkNotNullParameter(upperBounds, "upperBounds");
        if (this.bounds != null) {
            throw new IllegalStateException(("Upper bounds of type parameter '" + this + "' have already been initialized.").toString());
        }
        this.bounds = upperBounds;
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        return other instanceof TypeParameterReference && Intrinsics.areEqual(this.container, ((TypeParameterReference)other).container) && Intrinsics.areEqual(this.getName(), ((TypeParameterReference)other).getName());
    }
    
    @Override
    public int hashCode() {
        final Object container = this.container;
        return ((container != null) ? container.hashCode() : 0) * 31 + this.getName().hashCode();
    }
    
    @NotNull
    @Override
    public String toString() {
        return TypeParameterReference.Companion.toString(this);
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007" }, d2 = { "Lkotlin/jvm/internal/TypeParameterReference$Companion;", "", "()V", "toString", "", "typeParameter", "Lkotlin/reflect/KTypeParameter;", "kotlin-stdlib" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @NotNull
        public final String toString(@NotNull final KTypeParameter typeParameter) {
            Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
            final StringBuilder $this$toString_u24lambda_u240;
            final StringBuilder sb = $this$toString_u24lambda_u240 = new StringBuilder();
            final int n = 0;
            switch (WhenMappings.$EnumSwitchMapping$0[typeParameter.getVariance().ordinal()]) {
                case 2: {
                    $this$toString_u24lambda_u240.append("in ");
                    break;
                }
                case 3: {
                    $this$toString_u24lambda_u240.append("out ");
                    break;
                }
            }
            $this$toString_u24lambda_u240.append(typeParameter.getName());
            final String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }
}
