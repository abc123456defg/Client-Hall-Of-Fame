// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.coroutines.jvm.internal;

import java.util.Collection;
import java.util.ArrayList;
import java.lang.reflect.Field;
import org.jetbrains.annotations.Nullable;
import kotlin.jvm.JvmName;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0002\u001a\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u00020\bH\u0001¢\u0006\u0002\u0010\r\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\bH\u0001¢\u0006\u0002\b\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011" }, d2 = { "COROUTINES_DEBUG_METADATA_VERSION", "", "checkDebugMetadataVersion", "", "expected", "actual", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getLabel", "getSpilledVariableFieldMapping", "", "", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "kotlin-stdlib" })
public final class DebugMetadataKt
{
    private static final int COROUTINES_DEBUG_METADATA_VERSION = 1;
    
    @SinceKotlin(version = "1.3")
    @JvmName(name = "getStackTraceElement")
    @Nullable
    public static final StackTraceElement getStackTraceElement(@NotNull final BaseContinuationImpl $this$getStackTraceElementImpl) {
        Intrinsics.checkNotNullParameter($this$getStackTraceElementImpl, "<this>");
        final DebugMetadata debugMetadataAnnotation = getDebugMetadataAnnotation($this$getStackTraceElementImpl);
        if (debugMetadataAnnotation == null) {
            return null;
        }
        final DebugMetadata debugMetadata = debugMetadataAnnotation;
        checkDebugMetadataVersion(1, debugMetadata.v());
        final int label = getLabel($this$getStackTraceElementImpl);
        final int lineNumber = (label < 0) ? -1 : debugMetadata.l()[label];
        final String moduleName = ModuleNameRetriever.INSTANCE.getModuleName($this$getStackTraceElementImpl);
        final String moduleAndClass = (moduleName == null) ? debugMetadata.c() : (moduleName + '/' + debugMetadata.c());
        return new StackTraceElement(moduleAndClass, debugMetadata.m(), debugMetadata.f(), lineNumber);
    }
    
    private static final DebugMetadata getDebugMetadataAnnotation(final BaseContinuationImpl $this$getDebugMetadataAnnotation) {
        return $this$getDebugMetadataAnnotation.getClass().getAnnotation(DebugMetadata.class);
    }
    
    private static final int getLabel(final BaseContinuationImpl $this$getLabel) {
        int n2;
        try {
            final Field field = $this$getLabel.getClass().getDeclaredField("label");
            field.setAccessible(true);
            final Object value = field.get($this$getLabel);
            final Integer n = (value instanceof Integer) ? ((Integer)value) : null;
            n2 = ((n != null) ? n : 0) - 1;
        }
        catch (Exception e) {
            n2 = -1;
        }
        return n2;
    }
    
    private static final void checkDebugMetadataVersion(final int expected, final int actual) {
        if (actual > expected) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + expected + ", got " + actual + ". Please update the Kotlin standard library.").toString());
        }
    }
    
    @SinceKotlin(version = "1.3")
    @JvmName(name = "getSpilledVariableFieldMapping")
    @Nullable
    public static final String[] getSpilledVariableFieldMapping(@NotNull final BaseContinuationImpl $this$getSpilledVariableFieldMapping) {
        Intrinsics.checkNotNullParameter($this$getSpilledVariableFieldMapping, "<this>");
        final DebugMetadata debugMetadataAnnotation = getDebugMetadataAnnotation($this$getSpilledVariableFieldMapping);
        if (debugMetadataAnnotation == null) {
            return null;
        }
        final DebugMetadata debugMetadata = debugMetadataAnnotation;
        checkDebugMetadataVersion(1, debugMetadata.v());
        final ArrayList res = new ArrayList();
        final int label = getLabel($this$getSpilledVariableFieldMapping);
        final int[] j = debugMetadata.i();
        for (int k = 0; k < j.length; ++k) {
            final int i = k;
            final int labelOfIndex = j[k];
            if (labelOfIndex == label) {
                res.add(debugMetadata.s()[i]);
                res.add(debugMetadata.n()[i]);
            }
        }
        final Collection $this$toTypedArray$iv = res;
        final int $i$f$toTypedArray = 0;
        final Collection thisCollection$iv = $this$toTypedArray$iv;
        final String[] array = thisCollection$iv.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
