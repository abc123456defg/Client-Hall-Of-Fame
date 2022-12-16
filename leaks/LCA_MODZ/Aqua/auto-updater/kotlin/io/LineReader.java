// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.io;

import java.nio.charset.CoderResult;
import org.jetbrains.annotations.Nullable;
import kotlin.jvm.internal.Intrinsics;
import java.nio.charset.Charset;
import java.io.InputStream;
import java.nio.CharBuffer;
import java.nio.ByteBuffer;
import java.nio.charset.CharsetDecoder;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$" }, d2 = { "Lkotlin/io/LineReader;", "", "()V", "BUFFER_SIZE", "", "byteBuf", "Ljava/nio/ByteBuffer;", "bytes", "", "charBuf", "Ljava/nio/CharBuffer;", "chars", "", "decoder", "Ljava/nio/charset/CharsetDecoder;", "directEOL", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "compactBytes", "decode", "endOfInput", "decodeEndOfInput", "nBytes", "nChars", "readLine", "", "inputStream", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "resetAll", "", "trimStringBuilder", "updateCharset", "kotlin-stdlib" })
public final class LineReader
{
    @NotNull
    public static final LineReader INSTANCE;
    private static final int BUFFER_SIZE = 32;
    private static CharsetDecoder decoder;
    private static boolean directEOL;
    @NotNull
    private static final byte[] bytes;
    @NotNull
    private static final char[] chars;
    @NotNull
    private static final ByteBuffer byteBuf;
    @NotNull
    private static final CharBuffer charBuf;
    @NotNull
    private static final StringBuilder sb;
    
    private LineReader() {
    }
    
    @Nullable
    public final synchronized String readLine(@NotNull final InputStream inputStream, @NotNull final Charset charset) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Label_0047: {
            if (LineReader.decoder != null) {
                CharsetDecoder decoder;
                if ((decoder = LineReader.decoder) == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("decoder");
                    decoder = null;
                }
                if (Intrinsics.areEqual(decoder.charset(), charset)) {
                    break Label_0047;
                }
            }
            this.updateCharset(charset);
        }
        int nBytes = 0;
        int nChars = 0;
        while (true) {
            final int readByte = inputStream.read();
            if (readByte == -1) {
                if (LineReader.sb.length() == 0 && nBytes == 0 && nChars == 0) {
                    return null;
                }
                nChars = this.decodeEndOfInput(nBytes, nChars);
                break;
            }
            else {
                LineReader.bytes[nBytes++] = (byte)readByte;
                if (readByte != 10 && nBytes != 32 && LineReader.directEOL) {
                    continue;
                }
                LineReader.byteBuf.limit(nBytes);
                LineReader.charBuf.position(nChars);
                nChars = this.decode(false);
                if (nChars > 0 && LineReader.chars[nChars - 1] == '\n') {
                    LineReader.byteBuf.position(0);
                    break;
                }
                nBytes = this.compactBytes();
            }
        }
        if (nChars > 0 && LineReader.chars[nChars - 1] == '\n' && --nChars > 0 && LineReader.chars[nChars - 1] == '\r') {
            --nChars;
        }
        if (LineReader.sb.length() == 0) {
            return new String(LineReader.chars, 0, nChars);
        }
        LineReader.sb.append(LineReader.chars, 0, nChars);
        final String string = LineReader.sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        final String result = string;
        if (LineReader.sb.length() > 32) {
            this.trimStringBuilder();
        }
        LineReader.sb.setLength(0);
        return result;
    }
    
    private final int decode(final boolean endOfInput) {
        int nChars;
        while (true) {
            CharsetDecoder decoder;
            if ((decoder = LineReader.decoder) == null) {
                Intrinsics.throwUninitializedPropertyAccessException("decoder");
                decoder = null;
            }
            final CoderResult decode = decoder.decode(LineReader.byteBuf, LineReader.charBuf, endOfInput);
            Intrinsics.checkNotNullExpressionValue(decode, "decoder.decode(byteBuf, charBuf, endOfInput)");
            final CoderResult coderResult = decode;
            if (coderResult.isError()) {
                this.resetAll();
                coderResult.throwException();
            }
            nChars = LineReader.charBuf.position();
            if (!coderResult.isOverflow()) {
                break;
            }
            LineReader.sb.append(LineReader.chars, 0, nChars - 1);
            LineReader.charBuf.position(0);
            LineReader.charBuf.limit(32);
            LineReader.charBuf.put(LineReader.chars[nChars - 1]);
        }
        return nChars;
    }
    
    private final int compactBytes() {
        final ByteBuffer $this$compactBytes_u24lambda_u241 = LineReader.byteBuf;
        final int n = 0;
        $this$compactBytes_u24lambda_u241.compact();
        final int it = $this$compactBytes_u24lambda_u241.position();
        final int n2 = 0;
        $this$compactBytes_u24lambda_u241.position(0);
        return it;
    }
    
    private final int decodeEndOfInput(final int nBytes, final int nChars) {
        LineReader.byteBuf.limit(nBytes);
        LineReader.charBuf.position(nChars);
        final int it = this.decode(true);
        final int n = 0;
        CharsetDecoder decoder;
        if ((decoder = LineReader.decoder) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            decoder = null;
        }
        decoder.reset();
        LineReader.byteBuf.position(0);
        return it;
    }
    
    private final void updateCharset(final Charset charset) {
        final CharsetDecoder decoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(decoder, "charset.newDecoder()");
        LineReader.decoder = decoder;
        LineReader.byteBuf.clear();
        LineReader.charBuf.clear();
        LineReader.byteBuf.put((byte)10);
        LineReader.byteBuf.flip();
        CharsetDecoder decoder2;
        if ((decoder2 = LineReader.decoder) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            decoder2 = null;
        }
        decoder2.decode(LineReader.byteBuf, LineReader.charBuf, false);
        LineReader.directEOL = (LineReader.charBuf.position() == 1 && LineReader.charBuf.get(0) == '\n');
        this.resetAll();
    }
    
    private final void resetAll() {
        CharsetDecoder decoder;
        if ((decoder = LineReader.decoder) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            decoder = null;
        }
        decoder.reset();
        LineReader.byteBuf.position(0);
        LineReader.sb.setLength(0);
    }
    
    private final void trimStringBuilder() {
        LineReader.sb.setLength(32);
        LineReader.sb.trimToSize();
    }
    
    static {
        INSTANCE = new LineReader();
        bytes = new byte[32];
        chars = new char[32];
        final ByteBuffer wrap = ByteBuffer.wrap(LineReader.bytes);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(bytes)");
        byteBuf = wrap;
        final CharBuffer wrap2 = CharBuffer.wrap(LineReader.chars);
        Intrinsics.checkNotNullExpressionValue(wrap2, "wrap(chars)");
        charBuf = wrap2;
        sb = new StringBuilder();
    }
}
