// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

public class Base64Converter
{
    private static final char[] alphabet;
    private static final byte[] decodeTable;
    
    public static String encode(final String s) {
        return encode(s.getBytes());
    }
    
    public static String encode(final byte[] octetString) {
        char[] out;
        int outIndex;
        int i;
        int bits24;
        int bits25;
        for (out = new char[((octetString.length - 1) / 3 + 1) * 4], outIndex = 0, i = 0; i + 3 <= octetString.length; bits24 = (octetString[i++] & 0xFF) << 16, bits24 |= (octetString[i++] & 0xFF) << 8, bits24 |= (octetString[i++] & 0xFF), bits25 = (bits24 & 0xFC0000) >> 18, out[outIndex++] = Base64Converter.alphabet[bits25], bits25 = (bits24 & 0x3F000) >> 12, out[outIndex++] = Base64Converter.alphabet[bits25], bits25 = (bits24 & 0xFC0) >> 6, out[outIndex++] = Base64Converter.alphabet[bits25], bits25 = (bits24 & 0x3F), out[outIndex++] = Base64Converter.alphabet[bits25]) {}
        if (octetString.length - i == 2) {
            bits24 = (octetString[i] & 0xFF) << 16;
            bits24 |= (octetString[i + 1] & 0xFF) << 8;
            bits25 = (bits24 & 0xFC0000) >> 18;
            out[outIndex++] = Base64Converter.alphabet[bits25];
            bits25 = (bits24 & 0x3F000) >> 12;
            out[outIndex++] = Base64Converter.alphabet[bits25];
            bits25 = (bits24 & 0xFC0) >> 6;
            out[outIndex++] = Base64Converter.alphabet[bits25];
            out[outIndex] = '=';
        }
        else if (octetString.length - i == 1) {
            bits24 = (octetString[i] & 0xFF) << 16;
            bits25 = (bits24 & 0xFC0000) >> 18;
            out[outIndex++] = Base64Converter.alphabet[bits25];
            bits25 = (bits24 & 0x3F000) >> 12;
            out[outIndex++] = Base64Converter.alphabet[bits25];
            out[outIndex] = (out[outIndex++] = '=');
        }
        return StringFactory.createShared(out);
    }
    
    public static String decode(final String s) {
        return new String(decode(s.getBytes()));
    }
    
    public static byte[] decode(final byte[] bytes) {
        int paddingCount = 0;
        int realLength = 0;
        for (int i = bytes.length - 1; i >= 0; --i) {
            if (bytes[i] > 32) {
                ++realLength;
            }
            if (bytes[i] == 61) {
                ++paddingCount;
            }
        }
        if (realLength % 4 != 0) {
            throw new IllegalArgumentException("Incorrect length " + realLength + ". Must be a multiple of 4");
        }
        final byte[] out = new byte[realLength / 4 * 3 - paddingCount];
        final byte[] t = new byte[4];
        int outIndex = 0;
        int index = 0;
        final byte[] array = t;
        final int n = 0;
        final byte[] array2 = t;
        final int n2 = 1;
        final byte[] array3 = t;
        final int n3 = 2;
        final byte[] array4 = t;
        final int n4 = 3;
        final byte b = 61;
        array3[n3] = (array4[n4] = b);
        array[n] = (array2[n2] = b);
        for (final byte c : bytes) {
            if (c > 32) {
                t[index++] = c;
            }
            if (index == 4) {
                outIndex += decode(out, outIndex, t[0], t[1], t[2], t[3]);
                index = 0;
                final byte[] array5 = t;
                final int n5 = 0;
                final byte[] array6 = t;
                final int n6 = 1;
                final byte[] array7 = t;
                final int n7 = 2;
                final byte[] array8 = t;
                final int n8 = 3;
                final byte b2 = 61;
                array7[n7] = (array8[n8] = b2);
                array5[n5] = (array6[n6] = b2);
            }
        }
        if (index > 0) {
            decode(out, outIndex, t[0], t[1], t[2], t[3]);
        }
        return out;
    }
    
    private static int decode(final byte[] output, int outIndex, final byte a, final byte b, final byte c, final byte d) {
        final byte da = Base64Converter.decodeTable[a];
        final byte db = Base64Converter.decodeTable[b];
        final byte dc = Base64Converter.decodeTable[c];
        final byte dd = Base64Converter.decodeTable[d];
        if (da == -1 || db == -1 || (dc == -1 && c != 61) || (dd == -1 && d != 61)) {
            throw new IllegalArgumentException("Invalid character [" + (a & 0xFF) + ", " + (b & 0xFF) + ", " + (c & 0xFF) + ", " + (d & 0xFF) + "]");
        }
        output[outIndex++] = (byte)(da << 2 | db >>> 4);
        if (c == 61) {
            return 1;
        }
        output[outIndex++] = (byte)(db << 4 | dc >>> 2);
        if (d == 61) {
            return 2;
        }
        output[outIndex] = (byte)(dc << 6 | dd);
        return 3;
    }
    
    static {
        alphabet = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };
        decodeTable = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    }
}
