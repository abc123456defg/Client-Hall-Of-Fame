// 
// Decompiled by Procyon v0.5.36
// 

package kotlin;

import java.util.List;
import kotlin.internal.HidesMembers;
import kotlin.internal.PlatformImplementationsKt;
import java.io.Writer;
import java.io.StringWriter;
import org.jetbrains.annotations.NotNull;
import java.io.PrintStream;
import java.io.PrintWriter;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u00004\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0007\u001a\r\u0010\u0010\u001a\u00020\u000e*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0010\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0087\b\u001a\u0015\u0010\u0010\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0087\b\u001a\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0003H\u0007\"!\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017" }, d2 = { "stackTrace", "", "Ljava/lang/StackTraceElement;", "", "getStackTrace$annotations", "(Ljava/lang/Throwable;)V", "getStackTrace", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "suppressedExceptions", "", "getSuppressedExceptions$annotations", "getSuppressedExceptions", "(Ljava/lang/Throwable;)Ljava/util/List;", "addSuppressed", "", "exception", "printStackTrace", "stream", "Ljava/io/PrintStream;", "writer", "Ljava/io/PrintWriter;", "stackTraceToString", "", "kotlin-stdlib" }, xs = "kotlin/ExceptionsKt")
class ExceptionsKt__ExceptionsKt
{
    @InlineOnly
    private static final void printStackTrace(final Throwable $this$printStackTrace) {
        Intrinsics.checkNotNullParameter($this$printStackTrace, "<this>");
        $this$printStackTrace.printStackTrace();
    }
    
    @InlineOnly
    private static final void printStackTrace(final Throwable $this$printStackTrace, final PrintWriter writer) {
        Intrinsics.checkNotNullParameter($this$printStackTrace, "<this>");
        Intrinsics.checkNotNullParameter(writer, "writer");
        $this$printStackTrace.printStackTrace(writer);
    }
    
    @InlineOnly
    private static final void printStackTrace(final Throwable $this$printStackTrace, final PrintStream stream) {
        Intrinsics.checkNotNullParameter($this$printStackTrace, "<this>");
        Intrinsics.checkNotNullParameter(stream, "stream");
        $this$printStackTrace.printStackTrace(stream);
    }
    
    @NotNull
    public static final StackTraceElement[] getStackTrace(@NotNull final Throwable $this$stackTrace) {
        Intrinsics.checkNotNullParameter($this$stackTrace, "<this>");
        final StackTraceElement[] stackTrace = $this$stackTrace.getStackTrace();
        Intrinsics.checkNotNull(stackTrace);
        return stackTrace;
    }
    
    @SinceKotlin(version = "1.4")
    @NotNull
    public static final String stackTraceToString(@NotNull final Throwable $this$stackTraceToString) {
        Intrinsics.checkNotNullParameter($this$stackTraceToString, "<this>");
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw);
        $this$stackTraceToString.printStackTrace(pw);
        pw.flush();
        final String string = sw.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sw.toString()");
        return string;
    }
    
    @SinceKotlin(version = "1.1")
    @HidesMembers
    public static final void addSuppressed(@NotNull final Throwable $this$addSuppressed, @NotNull final Throwable exception) {
        Intrinsics.checkNotNullParameter($this$addSuppressed, "<this>");
        Intrinsics.checkNotNullParameter(exception, "exception");
        if ($this$addSuppressed != exception) {
            PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed($this$addSuppressed, exception);
        }
    }
    
    @NotNull
    public static final List<Throwable> getSuppressedExceptions(@NotNull final Throwable $this$suppressedExceptions) {
        Intrinsics.checkNotNullParameter($this$suppressedExceptions, "<this>");
        return PlatformImplementationsKt.IMPLEMENTATIONS.getSuppressed($this$suppressedExceptions);
    }
    
    public ExceptionsKt__ExceptionsKt() {
    }
}
