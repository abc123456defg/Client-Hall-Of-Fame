// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.util;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.util.Arrays;

public class Comparing
{
    private Comparing() {
    }
    
    public static <T> boolean equal(final T arg1, final T arg2) {
        if (arg1 == arg2) {
            return true;
        }
        if (arg1 == null || arg2 == null) {
            return false;
        }
        if (arg1 instanceof Object[] && arg2 instanceof Object[]) {
            final Object[] arr1 = (Object)arg1;
            final Object[] arr2 = (Object)arg2;
            return Arrays.equals(arr1, arr2);
        }
        if (arg1 instanceof CharSequence && arg2 instanceof CharSequence) {
            return equal((CharSequence)arg1, (CharSequence)arg2, true);
        }
        return arg1.equals(arg2);
    }
    
    public static <T> boolean equal(final T[] arr1, final T[] arr2) {
        if (arr1 == null || arr2 == null) {
            return arr1 == arr2;
        }
        return Arrays.equals(arr1, arr2);
    }
    
    public static boolean equal(final CharSequence s1, final CharSequence s2) {
        return equal(s1, s2, true);
    }
    
    public static boolean equal(final String arg1, final String arg2) {
        return (arg1 == null) ? (arg2 == null) : arg1.equals(arg2);
    }
    
    public static boolean equal(final CharSequence s1, final CharSequence s2, final boolean caseSensitive) {
        if (s1 == s2) {
            return true;
        }
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int to = 0;
        int po = 0;
        int len = s1.length();
        while (len-- > 0) {
            final char c1 = s1.charAt(to++);
            final char c2 = s2.charAt(po++);
            if (c1 == c2) {
                continue;
            }
            if (!caseSensitive && charsEqualIgnoreCase(c1, c2)) {
                continue;
            }
            return false;
        }
        return true;
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
    
    public static boolean equal(final String arg1, final String arg2, final boolean caseSensitive) {
        if (arg1 == null || arg2 == null) {
            return arg1 == arg2;
        }
        return caseSensitive ? arg1.equals(arg2) : arg1.equalsIgnoreCase(arg2);
    }
    
    public static boolean strEqual(final String arg1, final String arg2) {
        return strEqual(arg1, arg2, true);
    }
    
    public static boolean strEqual(final String arg1, final String arg2, final boolean caseSensitive) {
        return equal((arg1 == null) ? "" : arg1, (arg2 == null) ? "" : arg2, caseSensitive);
    }
    
    public static <T> boolean haveEqualElements(final Collection<? extends T> a, final Collection<? extends T> b) {
        if (a.size() != b.size()) {
            return false;
        }
        final Set<T> aSet = new HashSet<T>(a);
        for (final T t : b) {
            if (!aSet.contains(t)) {
                return false;
            }
        }
        return true;
    }
    
    public static <T> boolean haveEqualElements(final T[] a, final T[] b) {
        if (a == null || b == null) {
            return a == b;
        }
        if (a.length != b.length) {
            return false;
        }
        final Set<T> aSet = new HashSet<T>((Collection<? extends T>)Arrays.asList(a));
        for (final T t : b) {
            if (!aSet.contains(t)) {
                return false;
            }
        }
        return true;
    }
    
    public static int hashcode(final Object obj) {
        return (obj == null) ? 0 : obj.hashCode();
    }
    
    public static int hashcode(final Object obj1, final Object obj2) {
        return hashcode(obj1) ^ hashcode(obj2);
    }
    
    public static int compare(final byte o1, final byte o2) {
        return (o1 < o2) ? -1 : ((o1 == o2) ? 0 : 1);
    }
    
    public static int compare(final boolean o1, final boolean o2) {
        return (o1 == o2) ? 0 : (o1 ? 1 : -1);
    }
    
    public static int compare(final int o1, final int o2) {
        return (o1 < o2) ? -1 : ((o1 == o2) ? 0 : 1);
    }
    
    public static int compare(final long o1, final long o2) {
        return (o1 < o2) ? -1 : ((o1 == o2) ? 0 : 1);
    }
    
    public static int compare(final double o1, final double o2) {
        return (o1 < o2) ? -1 : ((o1 == o2) ? 0 : 1);
    }
    
    public static int compare(final byte[] o1, final byte[] o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return 1;
        }
        if (o2 == null) {
            return -1;
        }
        if (o1.length > o2.length) {
            return 1;
        }
        if (o1.length < o2.length) {
            return -1;
        }
        for (int i = 0; i < o1.length; ++i) {
            if (o1[i] > o2[i]) {
                return 1;
            }
            if (o1[i] < o2[i]) {
                return -1;
            }
        }
        return 0;
    }
    
    public static <T extends Comparable<T>> int compare(final T o1, final T o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return o1.compareTo(o2);
    }
    
    public static <T> int compare(final T o1, final T o2, final Comparator<T> notNullComparator) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return notNullComparator.compare(o1, o2);
    }
}
