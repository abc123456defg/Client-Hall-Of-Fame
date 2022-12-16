// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.time;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.SinceKotlin;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH$R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f" }, d2 = { "Lkotlin/time/AbstractDoubleTimeSource;", "Lkotlin/time/TimeSource;", "unit", "Lkotlin/time/DurationUnit;", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "markNow", "Lkotlin/time/TimeMark;", "read", "", "DoubleTimeMark", "kotlin-stdlib" })
@SinceKotlin(version = "1.3")
@ExperimentalTime
public abstract class AbstractDoubleTimeSource implements TimeSource
{
    @NotNull
    private final DurationUnit unit;
    
    public AbstractDoubleTimeSource(@NotNull final DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.unit = unit;
    }
    
    @NotNull
    protected final DurationUnit getUnit() {
        return this.unit;
    }
    
    protected abstract double read();
    
    @NotNull
    @Override
    public TimeMark markNow() {
        return new DoubleTimeMark(this.read(), this, Duration.Companion.getZERO-UwyO8pc(), null);
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00f8\u0001\u0000¢\u0006\u0002\u0010\bJ\u0015\u0010\n\u001a\u00020\u0007H\u0016\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0007H\u0096\u0002\u00f8\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0011" }, d2 = { "Lkotlin/time/AbstractDoubleTimeSource$DoubleTimeMark;", "Lkotlin/time/TimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractDoubleTimeSource;", "offset", "Lkotlin/time/Duration;", "(DLkotlin/time/AbstractDoubleTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "kotlin-stdlib" })
    private static final class DoubleTimeMark implements TimeMark
    {
        private final double startedAt;
        @NotNull
        private final AbstractDoubleTimeSource timeSource;
        private final long offset;
        
        private DoubleTimeMark(final double startedAt, final AbstractDoubleTimeSource timeSource, final long offset) {
            this.startedAt = startedAt;
            this.timeSource = timeSource;
            this.offset = offset;
        }
        
        @Override
        public long elapsedNow-UwyO8pc() {
            return Duration.minus-LRDsOJo(DurationKt.toDuration(this.timeSource.read() - this.startedAt, this.timeSource.getUnit()), this.offset);
        }
        
        @NotNull
        @Override
        public TimeMark plus-LRDsOJo(final long duration) {
            return new DoubleTimeMark(this.startedAt, this.timeSource, Duration.plus-LRDsOJo(this.offset, duration), null);
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
}
