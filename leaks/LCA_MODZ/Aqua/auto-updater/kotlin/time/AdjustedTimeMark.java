// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.time;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0015\u0010\u000b\u001a\u00020\u0004H\u0016\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b\f\u0010\u0007J\u001b\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0004H\u0096\u0002\u00f8\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0011" }, d2 = { "Lkotlin/time/AdjustedTimeMark;", "Lkotlin/time/TimeMark;", "mark", "adjustment", "Lkotlin/time/Duration;", "(Lkotlin/time/TimeMark;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdjustment-UwyO8pc", "()J", "J", "getMark", "()Lkotlin/time/TimeMark;", "elapsedNow", "elapsedNow-UwyO8pc", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "kotlin-stdlib" })
@ExperimentalTime
final class AdjustedTimeMark implements TimeMark
{
    @NotNull
    private final TimeMark mark;
    private final long adjustment;
    
    private AdjustedTimeMark(final TimeMark mark, final long adjustment) {
        this.mark = mark;
        this.adjustment = adjustment;
    }
    
    @NotNull
    public final TimeMark getMark() {
        return this.mark;
    }
    
    public final long getAdjustment-UwyO8pc() {
        return this.adjustment;
    }
    
    @Override
    public long elapsedNow-UwyO8pc() {
        return Duration.minus-LRDsOJo(this.mark.elapsedNow-UwyO8pc(), this.adjustment);
    }
    
    @NotNull
    @Override
    public TimeMark plus-LRDsOJo(final long duration) {
        return new AdjustedTimeMark(this.mark, Duration.plus-LRDsOJo(this.adjustment, duration), null);
    }
    
    @NotNull
    @Override
    public TimeMark minus-LRDsOJo(final long duration) {
        return DefaultImpls.minus-LRDsOJo(this, duration);
    }
    
    @Override
    public boolean hasPassedNow() {
        return DefaultImpls.hasPassedNow(this);
    }
    
    @Override
    public boolean hasNotPassedNow() {
        return DefaultImpls.hasNotPassedNow(this);
    }
}
