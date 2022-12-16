// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.time;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import kotlin.SinceKotlin;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0015\u0010\u0002\u001a\u00020\u0003H&\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001b\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002\u00f8\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002\u00f8\u0001\u0001¢\u0006\u0004\b\u000e\u0010\f\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\u000f" }, d2 = { "Lkotlin/time/TimeMark;", "", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "hasNotPassedNow", "", "hasPassedNow", "minus", "duration", "minus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "plus", "plus-LRDsOJo", "kotlin-stdlib" })
@SinceKotlin(version = "1.3")
@ExperimentalTime
public interface TimeMark
{
    long elapsedNow-UwyO8pc();
    
    @NotNull
    TimeMark plus-LRDsOJo(final long p0);
    
    @NotNull
    TimeMark minus-LRDsOJo(final long p0);
    
    boolean hasPassedNow();
    
    boolean hasNotPassedNow();
    
    @Metadata(mv = { 1, 7, 1 }, k = 3, xi = 48)
    public static final class DefaultImpls
    {
        @NotNull
        public static TimeMark plus-LRDsOJo(@NotNull final TimeMark $this, final long duration) {
            return new AdjustedTimeMark($this, duration, null);
        }
        
        @NotNull
        public static TimeMark minus-LRDsOJo(@NotNull final TimeMark $this, final long duration) {
            return $this.plus-LRDsOJo(Duration.unaryMinus-UwyO8pc(duration));
        }
        
        public static boolean hasPassedNow(@NotNull final TimeMark $this) {
            return !Duration.isNegative-impl($this.elapsedNow-UwyO8pc());
        }
        
        public static boolean hasNotPassedNow(@NotNull final TimeMark $this) {
            return Duration.isNegative-impl($this.elapsedNow-UwyO8pc());
        }
    }
}
