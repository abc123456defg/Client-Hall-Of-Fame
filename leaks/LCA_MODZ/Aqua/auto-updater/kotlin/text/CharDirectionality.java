// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.text;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import java.util.Map;
import kotlin.Lazy;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\u0001\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001c" }, d2 = { "Lkotlin/text/CharDirectionality;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", "LEFT_TO_RIGHT", "RIGHT_TO_LEFT", "RIGHT_TO_LEFT_ARABIC", "EUROPEAN_NUMBER", "EUROPEAN_NUMBER_SEPARATOR", "EUROPEAN_NUMBER_TERMINATOR", "ARABIC_NUMBER", "COMMON_NUMBER_SEPARATOR", "NONSPACING_MARK", "BOUNDARY_NEUTRAL", "PARAGRAPH_SEPARATOR", "SEGMENT_SEPARATOR", "WHITESPACE", "OTHER_NEUTRALS", "LEFT_TO_RIGHT_EMBEDDING", "LEFT_TO_RIGHT_OVERRIDE", "RIGHT_TO_LEFT_EMBEDDING", "RIGHT_TO_LEFT_OVERRIDE", "POP_DIRECTIONAL_FORMAT", "Companion", "kotlin-stdlib" })
public enum CharDirectionality
{
    @NotNull
    public static final Companion Companion;
    private final int value;
    @NotNull
    private static final Lazy<Map<Integer, CharDirectionality>> directionalityMap$delegate;
    
    UNDEFINED(-1), 
    LEFT_TO_RIGHT(0), 
    RIGHT_TO_LEFT(1), 
    RIGHT_TO_LEFT_ARABIC(2), 
    EUROPEAN_NUMBER(3), 
    EUROPEAN_NUMBER_SEPARATOR(4), 
    EUROPEAN_NUMBER_TERMINATOR(5), 
    ARABIC_NUMBER(6), 
    COMMON_NUMBER_SEPARATOR(7), 
    NONSPACING_MARK(8), 
    BOUNDARY_NEUTRAL(9), 
    PARAGRAPH_SEPARATOR(10), 
    SEGMENT_SEPARATOR(11), 
    WHITESPACE(12), 
    OTHER_NEUTRALS(13), 
    LEFT_TO_RIGHT_EMBEDDING(14), 
    LEFT_TO_RIGHT_OVERRIDE(15), 
    RIGHT_TO_LEFT_EMBEDDING(16), 
    RIGHT_TO_LEFT_OVERRIDE(17), 
    POP_DIRECTIONAL_FORMAT(18);
    
    private CharDirectionality(final int value) {
        this.value = value;
    }
    
    public final int getValue() {
        return this.value;
    }
    
    private static final /* synthetic */ CharDirectionality[] $values() {
        return new CharDirectionality[] { CharDirectionality.UNDEFINED, CharDirectionality.LEFT_TO_RIGHT, CharDirectionality.RIGHT_TO_LEFT, CharDirectionality.RIGHT_TO_LEFT_ARABIC, CharDirectionality.EUROPEAN_NUMBER, CharDirectionality.EUROPEAN_NUMBER_SEPARATOR, CharDirectionality.EUROPEAN_NUMBER_TERMINATOR, CharDirectionality.ARABIC_NUMBER, CharDirectionality.COMMON_NUMBER_SEPARATOR, CharDirectionality.NONSPACING_MARK, CharDirectionality.BOUNDARY_NEUTRAL, CharDirectionality.PARAGRAPH_SEPARATOR, CharDirectionality.SEGMENT_SEPARATOR, CharDirectionality.WHITESPACE, CharDirectionality.OTHER_NEUTRALS, CharDirectionality.LEFT_TO_RIGHT_EMBEDDING, CharDirectionality.LEFT_TO_RIGHT_OVERRIDE, CharDirectionality.RIGHT_TO_LEFT_EMBEDDING, CharDirectionality.RIGHT_TO_LEFT_OVERRIDE, CharDirectionality.POP_DIRECTIONAL_FORMAT };
    }
    
    public static final /* synthetic */ Lazy access$getDirectionalityMap$delegate$cp() {
        return CharDirectionality.directionalityMap$delegate;
    }
    
    static {
        $VALUES = $values();
        Companion = new Companion(null);
        directionalityMap$delegate = LazyKt__LazyJVMKt.lazy((Function0<? extends Map<Integer, CharDirectionality>>)CharDirectionality$Companion$directionalityMap.CharDirectionality$Companion$directionalityMap$2.INSTANCE);
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0005R'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\r" }, d2 = { "Lkotlin/text/CharDirectionality$Companion;", "", "()V", "directionalityMap", "", "", "Lkotlin/text/CharDirectionality;", "getDirectionalityMap", "()Ljava/util/Map;", "directionalityMap$delegate", "Lkotlin/Lazy;", "valueOf", "directionality", "kotlin-stdlib" })
    public static final class Companion
    {
        private Companion() {
        }
        
        private final Map<Integer, CharDirectionality> getDirectionalityMap() {
            return CharDirectionality.access$getDirectionalityMap$delegate$cp().getValue();
        }
        
        @NotNull
        public final CharDirectionality valueOf(final int directionality) {
            final CharDirectionality charDirectionality = this.getDirectionalityMap().get(directionality);
            if (charDirectionality == null) {
                throw new IllegalArgumentException("Directionality #" + directionality + " is not defined.");
            }
            return charDirectionality;
        }
    }
}
