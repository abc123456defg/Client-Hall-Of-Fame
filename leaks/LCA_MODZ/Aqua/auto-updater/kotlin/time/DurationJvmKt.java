// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.time;

import kotlin.jvm.internal.Intrinsics;
import java.math.RoundingMode;
import org.jetbrains.annotations.NotNull;
import java.text.DecimalFormat;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0011" }, d2 = { "durationAssertionsEnabled", "", "getDurationAssertionsEnabled", "()Z", "precisionFormats", "", "Ljava/lang/ThreadLocal;", "Ljava/text/DecimalFormat;", "[Ljava/lang/ThreadLocal;", "createFormatForDecimals", "decimals", "", "formatToExactDecimals", "", "value", "", "formatUpToDecimals", "kotlin-stdlib" })
public final class DurationJvmKt
{
    private static final boolean durationAssertionsEnabled;
    @NotNull
    private static final ThreadLocal<DecimalFormat>[] precisionFormats;
    
    public static final boolean getDurationAssertionsEnabled() {
        return DurationJvmKt.durationAssertionsEnabled;
    }
    
    private static final DecimalFormat createFormatForDecimals(final int decimals) {
        final DecimalFormat $this$createFormatForDecimals_u24lambda_u240;
        final DecimalFormat decimalFormat = $this$createFormatForDecimals_u24lambda_u240 = new DecimalFormat("0");
        final int n = 0;
        if (decimals > 0) {
            $this$createFormatForDecimals_u24lambda_u240.setMinimumFractionDigits(decimals);
        }
        $this$createFormatForDecimals_u24lambda_u240.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat;
    }
    
    @NotNull
    public static final String formatToExactDecimals(final double value, final int decimals) {
        DecimalFormat formatForDecimals2;
        if (decimals < DurationJvmKt.precisionFormats.length) {
            final ThreadLocal<DecimalFormat> threadLocal = DurationJvmKt.precisionFormats[decimals];
            final DecimalFormat value2;
            final DecimalFormat decimalFormat = value2 = threadLocal.get();
            DecimalFormat decimalFormat2;
            if (value2 == null) {
                final int n = 0;
                final DecimalFormat formatForDecimals = createFormatForDecimals(decimals);
                threadLocal.set(formatForDecimals);
                decimalFormat2 = formatForDecimals;
            }
            else {
                Intrinsics.checkNotNullExpressionValue(value2, "get() ?: default().also(this::set)");
                decimalFormat2 = decimalFormat;
            }
            formatForDecimals2 = decimalFormat2;
        }
        else {
            formatForDecimals2 = createFormatForDecimals(decimals);
        }
        final DecimalFormat format = formatForDecimals2;
        final String format2 = format.format(value);
        Intrinsics.checkNotNullExpressionValue(format2, "format.format(value)");
        return format2;
    }
    
    @NotNull
    public static final String formatUpToDecimals(final double value, final int decimals) {
        final DecimalFormat $this$formatUpToDecimals_u24lambda_u242 = createFormatForDecimals(0);
        final int n = 0;
        $this$formatUpToDecimals_u24lambda_u242.setMaximumFractionDigits(decimals);
        final String format = $this$formatUpToDecimals_u24lambda_u242.format(value);
        Intrinsics.checkNotNullExpressionValue(format, "createFormatForDecimals(\u2026 }\n        .format(value)");
        return format;
    }
    
    static {
        durationAssertionsEnabled = Duration.class.desiredAssertionStatus();
        int i = 0;
        final ThreadLocal[] precisionFormats2 = new ThreadLocal[4];
        while (i < 4) {
            precisionFormats2[i] = new ThreadLocal<DecimalFormat>();
            ++i;
        }
        precisionFormats = precisionFormats2;
    }
}
