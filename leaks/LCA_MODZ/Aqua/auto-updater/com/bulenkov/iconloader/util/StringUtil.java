// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import org.jetbrains.annotations.Nullable;
import java.util.Iterator;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringUtil
{
    public static List<String> split(final String s, final String separator) {
        return split(s, separator, true);
    }
    
    public static List<String> split(final String s, final String separator, final boolean excludeSeparator) {
        return split(s, separator, excludeSeparator, true);
    }
    
    public static List<String> split(final String s, final String separator, final boolean excludeSeparator, final boolean excludeEmptyStrings) {
        if (separator.isEmpty()) {
            return Collections.singletonList(s);
        }
        final List<String> result = new ArrayList<String>();
        int pos = 0;
        while (true) {
            final int index = s.indexOf(separator, pos);
            if (index == -1) {
                break;
            }
            final int nextPos = index + separator.length();
            final String token = s.substring(pos, excludeSeparator ? index : nextPos);
            if (!token.isEmpty() || !excludeEmptyStrings) {
                result.add(token);
            }
            pos = nextPos;
        }
        if (pos < s.length() || (!excludeEmptyStrings && pos == s.length())) {
            result.add(s.substring(pos, s.length()));
        }
        return result;
    }
    
    public static int indexOfIgnoreCase(final String where, final String what, int fromIndex) {
        final int targetCount = what.length();
        final int sourceCount = where.length();
        if (fromIndex >= sourceCount) {
            return (targetCount == 0) ? sourceCount : -1;
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }
        final char first = what.charAt(0);
        for (int max = sourceCount - targetCount, i = fromIndex; i <= max; ++i) {
            if (!charsEqualIgnoreCase(where.charAt(i), first)) {
                while (++i <= max && !charsEqualIgnoreCase(where.charAt(i), first)) {}
            }
            if (i <= max) {
                int j = i + 1;
                final int end = j + targetCount - 1;
                for (int k = 1; j < end && charsEqualIgnoreCase(where.charAt(j), what.charAt(k)); ++j, ++k) {}
                if (j == end) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public static int indexOfIgnoreCase(final String where, final char what, int fromIndex) {
        final int sourceCount = where.length();
        if (fromIndex >= sourceCount) {
            return -1;
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        for (int i = fromIndex; i < sourceCount; ++i) {
            if (charsEqualIgnoreCase(where.charAt(i), what)) {
                return i;
            }
        }
        return -1;
    }
    
    public static boolean containsIgnoreCase(final String where, final String what) {
        return indexOfIgnoreCase(where, what, 0) >= 0;
    }
    
    public static boolean charsEqualIgnoreCase(final char a, final char b) {
        return a == b || toUpperCase(a) == toUpperCase(b) || toLowerCase(a) == toLowerCase(b);
    }
    
    public static char toUpperCase(final char a) {
        if (a < 'a') {
            return a;
        }
        if (a <= 'z') {
            return (char)(a - 32);
        }
        return Character.toUpperCase(a);
    }
    
    public static char toLowerCase(final char a) {
        if (a < 'A' || (a >= 'a' && a <= 'z')) {
            return a;
        }
        if (a <= 'Z') {
            return (char)(a + ' ');
        }
        return Character.toLowerCase(a);
    }
    
    public static int compareVersionNumbers(final String v1, final String v2) {
        if (v1 == null && v2 == null) {
            return 0;
        }
        if (v1 == null) {
            return -1;
        }
        if (v2 == null) {
            return 1;
        }
        String[] part1;
        String[] part2;
        int idx;
        String p1;
        String p2;
        int cmp;
        for (part1 = v1.split("[\\.\\_\\-]"), part2 = v2.split("[\\.\\_\\-]"), idx = 0; idx < part1.length && idx < part2.length; ++idx) {
            p1 = part1[idx];
            p2 = part2[idx];
            if (p1.matches("\\d+") && p2.matches("\\d+")) {
                cmp = new Integer(p1).compareTo(new Integer(p2));
            }
            else {
                cmp = part1[idx].compareTo(part2[idx]);
            }
            if (cmp != 0) {
                return cmp;
            }
        }
        if (part1.length == part2.length) {
            return 0;
        }
        final boolean left = part1.length > idx;
        for (String[] parts = left ? part1 : part2; idx < parts.length; ++idx) {
            final String p3 = parts[idx];
            int cmp2;
            if (p3.matches("\\d+")) {
                cmp2 = new Integer(p3).compareTo(0);
            }
            else {
                cmp2 = 1;
            }
            if (cmp2 != 0) {
                return left ? cmp2 : (-cmp2);
            }
        }
        return 0;
    }
    
    public static boolean startsWithChar(final CharSequence s, final char prefix) {
        return s != null && s.length() != 0 && s.charAt(0) == prefix;
    }
    
    public static boolean endsWithChar(final CharSequence s, final char suffix) {
        return s != null && s.length() != 0 && s.charAt(s.length() - 1) == suffix;
    }
    
    public static String stripQuotesAroundValue(String text) {
        if (startsWithChar(text, '\"') || startsWithChar(text, '\'')) {
            text = text.substring(1);
        }
        if (endsWithChar(text, '\"') || endsWithChar(text, '\'')) {
            text = text.substring(0, text.length() - 1);
        }
        return text;
    }
    
    public static boolean startsWithConcatenation(final String string, final String... prefixes) {
        int offset = 0;
        for (final String prefix : prefixes) {
            final int prefixLen = prefix.length();
            if (!string.regionMatches(offset, prefix, 0, prefixLen)) {
                return false;
            }
            offset += prefixLen;
        }
        return true;
    }
    
    public static String getFileExtension(final String fileName) {
        final int index = fileName.lastIndexOf(46);
        if (index < 0) {
            return "";
        }
        return fileName.substring(index + 1);
    }
    
    public static String getFileNameWithoutExtension(String name) {
        final int i = name.lastIndexOf(46);
        if (i != -1) {
            name = name.substring(0, i);
        }
        return name;
    }
    
    @NotNull
    @Contract(pure = true)
    public static String join(@NotNull final Collection<String> strings, @NotNull final String separator) {
        if (strings == null) {
            $$$reportNull$$$0(0);
        }
        if (separator == null) {
            $$$reportNull$$$0(1);
        }
        if (strings.size() <= 1) {
            final String notNullize = notNullize(getFirstItem(strings));
            if (notNullize == null) {
                $$$reportNull$$$0(2);
            }
            return notNullize;
        }
        final StringBuilder result = new StringBuilder();
        join(strings, separator, result);
        final String string = result.toString();
        if (string == null) {
            $$$reportNull$$$0(3);
        }
        return string;
    }
    
    @Contract(pure = true)
    public static String join(@NotNull final Iterable<?> items, @NotNull @NonNls final String separator) {
        if (items == null) {
            $$$reportNull$$$0(4);
        }
        if (separator == null) {
            $$$reportNull$$$0(5);
        }
        final StringBuilder result = new StringBuilder();
        for (final Object item : items) {
            result.append(item).append(separator);
        }
        if (result.length() > 0) {
            result.setLength(result.length() - separator.length());
        }
        return result.toString();
    }
    
    @NotNull
    public static String notNullize(@Nullable final String s) {
        final String notNullize = notNullize(s, "");
        if (notNullize == null) {
            $$$reportNull$$$0(6);
        }
        return notNullize;
    }
    
    @NotNull
    public static String notNullize(@Nullable final String s, @NotNull final String defaultValue) {
        if (defaultValue == null) {
            $$$reportNull$$$0(7);
        }
        String s2;
        String s3;
        if (s == null) {
            s2 = defaultValue;
            s3 = defaultValue;
        }
        else {
            s2 = s;
            s3 = s;
        }
        if (s3 == null) {
            $$$reportNull$$$0(8);
        }
        return s2;
    }
    
    public static void join(@NotNull final Collection<String> strings, @NotNull final String separator, @NotNull final StringBuilder result) {
        if (strings == null) {
            $$$reportNull$$$0(9);
        }
        if (separator == null) {
            $$$reportNull$$$0(10);
        }
        if (result == null) {
            $$$reportNull$$$0(11);
        }
        boolean isFirst = true;
        for (final String string : strings) {
            if (string != null) {
                if (isFirst) {
                    isFirst = false;
                }
                else {
                    result.append(separator);
                }
                result.append(string);
            }
        }
    }
    
    @Nullable
    public static <T> T getFirstItem(@Nullable final Collection<T> items) {
        return (items == null || items.isEmpty()) ? null : items.iterator().next();
    }
    
    private static /* synthetic */ void $$$reportNull$$$0(final int n) {
        String format = null;
        switch (n) {
            default: {
                format = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
            }
            case 2:
            case 3:
            case 6:
            case 8: {
                format = "@NotNull method %s.%s must not return null";
                break;
            }
        }
        int n2 = 0;
        switch (n) {
            default: {
                n2 = 3;
                break;
            }
            case 2:
            case 3:
            case 6:
            case 8: {
                n2 = 2;
                break;
            }
        }
        final Object[] args = new Object[n2];
        switch (n) {
            default: {
                args[0] = "strings";
                break;
            }
            case 1:
            case 5:
            case 10: {
                args[0] = "separator";
                break;
            }
            case 2:
            case 3:
            case 6:
            case 8: {
                args[0] = "com/bulenkov/iconloader/util/StringUtil";
                break;
            }
            case 4: {
                args[0] = "items";
                break;
            }
            case 7: {
                args[0] = "defaultValue";
                break;
            }
            case 11: {
                args[0] = "result";
                break;
            }
        }
        switch (n) {
            default: {
                args[1] = "com/bulenkov/iconloader/util/StringUtil";
                break;
            }
            case 2:
            case 3: {
                args[1] = "join";
                break;
            }
            case 6:
            case 8: {
                args[1] = "notNullize";
                break;
            }
        }
        switch (n) {
            default: {
                args[2] = "join";
                break;
            }
            case 2:
            case 3:
            case 6:
            case 8: {
                break;
            }
            case 7: {
                args[2] = "notNullize";
                break;
            }
        }
        final String format2 = String.format(format, args);
        RuntimeException ex = null;
        switch (n) {
            default: {
                ex = new IllegalArgumentException(format2);
                break;
            }
            case 2:
            case 3:
            case 6:
            case 8: {
                ex = new IllegalStateException(format2);
                break;
            }
        }
        throw ex;
    }
}
