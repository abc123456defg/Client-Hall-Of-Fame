// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.time;

import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;
import kotlin.SinceKotlin;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0006" }, d2 = { "Lkotlin/time/TimeSource;", "", "markNow", "Lkotlin/time/TimeMark;", "Companion", "Monotonic", "kotlin-stdlib" })
@SinceKotlin(version = "1.3")
@ExperimentalTime
public interface TimeSource
{
    @NotNull
    public static final Companion Companion = TimeSource.Companion.$$INSTANCE;
    
    @NotNull
    TimeMark markNow();
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u0004H\u0016\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\n" }, d2 = { "Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource;", "()V", "markNow", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "toString", "", "ValueTimeMark", "kotlin-stdlib" })
    public static final class Monotonic implements TimeSource
    {
        @NotNull
        public static final Monotonic INSTANCE;
        
        private Monotonic() {
        }
        
        public long markNow-z9LOYto() {
            return MonotonicTimeSource.INSTANCE.markNow-z9LOYto();
        }
        
        @NotNull
        @Override
        public String toString() {
            return MonotonicTimeSource.INSTANCE.toString();
        }
        
        static {
            INSTANCE = new Monotonic();
        }
        
        @JvmInline
        @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0018\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u00f8\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\bH\u0016\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b\t\u0010\u0006J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\bH\u0096\u0002\u00f8\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\bH\u0096\u0002\u00f8\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001cJ\u0010\u0010\u001f\u001a\u00020 H\u00d6\u0001¢\u0006\u0004\b!\u0010\"R\u0012\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006#" }, d2 = { "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "Lkotlin/time/TimeMark;", "reading", "", "Lkotlin/time/ValueTimeMarkReading;", "constructor-impl", "(J)J", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "equals", "", "other", "", "equals-impl", "(JLjava/lang/Object;)Z", "hasNotPassedNow", "hasNotPassedNow-impl", "(J)Z", "hasPassedNow", "hasPassedNow-impl", "hashCode", "", "hashCode-impl", "(J)I", "minus", "duration", "minus-LRDsOJo", "(JJ)J", "plus", "plus-LRDsOJo", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "kotlin-stdlib" })
        @ExperimentalTime
        @SinceKotlin(version = "1.7")
        public static final class ValueTimeMark implements TimeMark
        {
            private final long reading = reading;
            
            public static long elapsedNow-UwyO8pc(final long arg0) {
                return MonotonicTimeSource.INSTANCE.elapsedFrom-6eNON_k(arg0);
            }
            
            @Override
            public long elapsedNow-UwyO8pc() {
                return elapsedNow-UwyO8pc(this.reading);
            }
            
            public static long plus-LRDsOJo(final long arg0, final long duration) {
                return MonotonicTimeSource.INSTANCE.adjustReading-6QKq23U(arg0, duration);
            }
            
            public long plus-LRDsOJo(final long duration) {
                return plus-LRDsOJo(this.reading, duration);
            }
            
            public static long minus-LRDsOJo(final long arg0, final long duration) {
                return MonotonicTimeSource.INSTANCE.adjustReading-6QKq23U(arg0, Duration.unaryMinus-UwyO8pc(duration));
            }
            
            public long minus-LRDsOJo(final long duration) {
                return minus-LRDsOJo(this.reading, duration);
            }
            
            public static boolean hasPassedNow-impl(final long arg0) {
                return !Duration.isNegative-impl(elapsedNow-UwyO8pc(arg0));
            }
            
            @Override
            public boolean hasPassedNow() {
                return hasPassedNow-impl(this.reading);
            }
            
            public static boolean hasNotPassedNow-impl(final long arg0) {
                return Duration.isNegative-impl(elapsedNow-UwyO8pc(arg0));
            }
            
            @Override
            public boolean hasNotPassedNow() {
                return hasNotPassedNow-impl(this.reading);
            }
            
            public static String toString-impl(final long arg0) {
                return "ValueTimeMark(reading=" + arg0 + ')';
            }
            
            @Override
            public String toString() {
                return toString-impl(this.reading);
            }
            
            public static int hashCode-impl(final long arg0) {
                return (int)(arg0 ^ arg0 >>> 32);
            }
            
            @Override
            public int hashCode() {
                return hashCode-impl(this.reading);
            }
            
            public static boolean equals-impl(final long arg0, final Object other) {
                return other instanceof ValueTimeMark && arg0 == ((ValueTimeMark)other).unbox-impl();
            }
            
            @Override
            public boolean equals(final Object other) {
                return equals-impl(this.reading, other);
            }
            
            public static long constructor-impl(final long reading) {
                return reading;
            }
            
            public final /* synthetic */ long unbox-impl() {
                return this.reading;
            }
            
            public static final boolean equals-impl0(final long p1, final long p2) {
                return p1 == p2;
            }
        }
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003" }, d2 = { "Lkotlin/time/TimeSource$Companion;", "", "()V", "kotlin-stdlib" })
    public static final class Companion
    {
        static final /* synthetic */ Companion $$INSTANCE;
        
        private Companion() {
        }
        
        static {
            $$INSTANCE = new Companion();
        }
    }
}
