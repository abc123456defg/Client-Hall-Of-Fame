// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.io;

import java.io.InputStream;
import java.nio.charset.Charset;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\bH\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\nH\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\fH\u0087\b\u001a\t\u0010\r\u001a\u00020\u0001H\u0087\b\u001a\u0013\u0010\r\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005H\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\bH\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\nH\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\fH\u0087\b\u001a\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u001a\b\u0010\u0010\u001a\u00020\u000fH\u0007\u001a\n\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0007¨\u0006\u0012" }, d2 = { "print", "", "message", "", "", "", "", "", "", "", "", "", "", "println", "readLine", "", "readln", "readlnOrNull", "kotlin-stdlib" })
@JvmName(name = "ConsoleKt")
public final class ConsoleKt
{
    @InlineOnly
    private static final void print(final Object message) {
        System.out.print(message);
    }
    
    @InlineOnly
    private static final void print(final int message) {
        System.out.print(message);
    }
    
    @InlineOnly
    private static final void print(final long message) {
        System.out.print(message);
    }
    
    @InlineOnly
    private static final void print(final byte message) {
        System.out.print((Object)message);
    }
    
    @InlineOnly
    private static final void print(final short message) {
        System.out.print((Object)message);
    }
    
    @InlineOnly
    private static final void print(final char message) {
        System.out.print(message);
    }
    
    @InlineOnly
    private static final void print(final boolean message) {
        System.out.print(message);
    }
    
    @InlineOnly
    private static final void print(final float message) {
        System.out.print(message);
    }
    
    @InlineOnly
    private static final void print(final double message) {
        System.out.print(message);
    }
    
    @InlineOnly
    private static final void print(final char[] message) {
        Intrinsics.checkNotNullParameter(message, "message");
        System.out.print(message);
    }
    
    @InlineOnly
    private static final void println(final Object message) {
        System.out.println(message);
    }
    
    @InlineOnly
    private static final void println(final int message) {
        System.out.println(message);
    }
    
    @InlineOnly
    private static final void println(final long message) {
        System.out.println(message);
    }
    
    @InlineOnly
    private static final void println(final byte message) {
        System.out.println((Object)message);
    }
    
    @InlineOnly
    private static final void println(final short message) {
        System.out.println((Object)message);
    }
    
    @InlineOnly
    private static final void println(final char message) {
        System.out.println(message);
    }
    
    @InlineOnly
    private static final void println(final boolean message) {
        System.out.println(message);
    }
    
    @InlineOnly
    private static final void println(final float message) {
        System.out.println(message);
    }
    
    @InlineOnly
    private static final void println(final double message) {
        System.out.println(message);
    }
    
    @InlineOnly
    private static final void println(final char[] message) {
        Intrinsics.checkNotNullParameter(message, "message");
        System.out.println(message);
    }
    
    @InlineOnly
    private static final void println() {
        System.out.println();
    }
    
    @SinceKotlin(version = "1.6")
    @NotNull
    public static final String readln() {
        final String readlnOrNull = readlnOrNull();
        if (readlnOrNull == null) {
            throw new ReadAfterEOFException("EOF has already been reached");
        }
        return readlnOrNull;
    }
    
    @SinceKotlin(version = "1.6")
    @Nullable
    public static final String readlnOrNull() {
        return readLine();
    }
    
    @Nullable
    public static final String readLine() {
        final LineReader instance = LineReader.INSTANCE;
        final InputStream in = System.in;
        Intrinsics.checkNotNullExpressionValue(in, "`in`");
        final Charset defaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(defaultCharset, "defaultCharset()");
        return instance.readLine(in, defaultCharset);
    }
}
