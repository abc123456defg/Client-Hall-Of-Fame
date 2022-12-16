// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections;

import org.jetbrains.annotations.NotNull;
import kotlin.ULongArray;
import kotlin.UnsignedKt;
import kotlin.UIntArray;
import kotlin.UShortArray;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.UByteArray;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001\u00f8\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0014\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001\u00f8\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0016\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001\u00f8\u0001\u0000¢\u0006\u0004\b \u0010\u0018\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001\u00f8\u0001\u0000¢\u0006\u0004\b!\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\"" }, d2 = { "partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib" })
public final class UArraySortingKt
{
    @ExperimentalUnsignedTypes
    private static final int partition-4UcCI2c(final byte[] array, final int left, final int right) {
        int i = left;
        int j = right;
        final byte pivot = UByteArray.get-w2LRezQ(array, (left + right) / 2);
        while (i <= j) {
            while (Intrinsics.compare(UByteArray.get-w2LRezQ(array, i) & 0xFF, pivot & 0xFF) < 0) {
                ++i;
            }
            while (Intrinsics.compare(UByteArray.get-w2LRezQ(array, j) & 0xFF, pivot & 0xFF) > 0) {
                --j;
            }
            if (i <= j) {
                final byte tmp = UByteArray.get-w2LRezQ(array, i);
                UByteArray.set-VurrAj0(array, i, UByteArray.get-w2LRezQ(array, j));
                UByteArray.set-VurrAj0(array, j, tmp);
                ++i;
                --j;
            }
        }
        return i;
    }
    
    @ExperimentalUnsignedTypes
    private static final void quickSort-4UcCI2c(final byte[] array, final int left, final int right) {
        final int index = partition-4UcCI2c(array, left, right);
        if (left < index - 1) {
            quickSort-4UcCI2c(array, left, index - 1);
        }
        if (index < right) {
            quickSort-4UcCI2c(array, index, right);
        }
    }
    
    @ExperimentalUnsignedTypes
    private static final int partition-Aa5vz7o(final short[] array, final int left, final int right) {
        int i = left;
        int j = right;
        final short pivot = UShortArray.get-Mh2AYeg(array, (left + right) / 2);
        while (i <= j) {
            while (Intrinsics.compare(UShortArray.get-Mh2AYeg(array, i) & 0xFFFF, pivot & 0xFFFF) < 0) {
                ++i;
            }
            while (Intrinsics.compare(UShortArray.get-Mh2AYeg(array, j) & 0xFFFF, pivot & 0xFFFF) > 0) {
                --j;
            }
            if (i <= j) {
                final short tmp = UShortArray.get-Mh2AYeg(array, i);
                UShortArray.set-01HTLdE(array, i, UShortArray.get-Mh2AYeg(array, j));
                UShortArray.set-01HTLdE(array, j, tmp);
                ++i;
                --j;
            }
        }
        return i;
    }
    
    @ExperimentalUnsignedTypes
    private static final void quickSort-Aa5vz7o(final short[] array, final int left, final int right) {
        final int index = partition-Aa5vz7o(array, left, right);
        if (left < index - 1) {
            quickSort-Aa5vz7o(array, left, index - 1);
        }
        if (index < right) {
            quickSort-Aa5vz7o(array, index, right);
        }
    }
    
    @ExperimentalUnsignedTypes
    private static final int partition-oBK06Vg(final int[] array, final int left, final int right) {
        int i = left;
        int j = right;
        final int pivot = UIntArray.get-pVg5ArA(array, (left + right) / 2);
        while (i <= j) {
            while (UnsignedKt.uintCompare(UIntArray.get-pVg5ArA(array, i), pivot) < 0) {
                ++i;
            }
            while (UnsignedKt.uintCompare(UIntArray.get-pVg5ArA(array, j), pivot) > 0) {
                --j;
            }
            if (i <= j) {
                final int tmp = UIntArray.get-pVg5ArA(array, i);
                UIntArray.set-VXSXFK8(array, i, UIntArray.get-pVg5ArA(array, j));
                UIntArray.set-VXSXFK8(array, j, tmp);
                ++i;
                --j;
            }
        }
        return i;
    }
    
    @ExperimentalUnsignedTypes
    private static final void quickSort-oBK06Vg(final int[] array, final int left, final int right) {
        final int index = partition-oBK06Vg(array, left, right);
        if (left < index - 1) {
            quickSort-oBK06Vg(array, left, index - 1);
        }
        if (index < right) {
            quickSort-oBK06Vg(array, index, right);
        }
    }
    
    @ExperimentalUnsignedTypes
    private static final int partition--nroSd4(final long[] array, final int left, final int right) {
        int i = left;
        int j = right;
        final long pivot = ULongArray.get-s-VKNKU(array, (left + right) / 2);
        while (i <= j) {
            while (UnsignedKt.ulongCompare(ULongArray.get-s-VKNKU(array, i), pivot) < 0) {
                ++i;
            }
            while (UnsignedKt.ulongCompare(ULongArray.get-s-VKNKU(array, j), pivot) > 0) {
                --j;
            }
            if (i <= j) {
                final long tmp = ULongArray.get-s-VKNKU(array, i);
                ULongArray.set-k8EXiF4(array, i, ULongArray.get-s-VKNKU(array, j));
                ULongArray.set-k8EXiF4(array, j, tmp);
                ++i;
                --j;
            }
        }
        return i;
    }
    
    @ExperimentalUnsignedTypes
    private static final void quickSort--nroSd4(final long[] array, final int left, final int right) {
        final int index = partition--nroSd4(array, left, right);
        if (left < index - 1) {
            quickSort--nroSd4(array, left, index - 1);
        }
        if (index < right) {
            quickSort--nroSd4(array, index, right);
        }
    }
    
    @ExperimentalUnsignedTypes
    public static final void sortArray-4UcCI2c(@NotNull final byte[] array, final int fromIndex, final int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        quickSort-4UcCI2c(array, fromIndex, toIndex - 1);
    }
    
    @ExperimentalUnsignedTypes
    public static final void sortArray-Aa5vz7o(@NotNull final short[] array, final int fromIndex, final int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        quickSort-Aa5vz7o(array, fromIndex, toIndex - 1);
    }
    
    @ExperimentalUnsignedTypes
    public static final void sortArray-oBK06Vg(@NotNull final int[] array, final int fromIndex, final int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        quickSort-oBK06Vg(array, fromIndex, toIndex - 1);
    }
    
    @ExperimentalUnsignedTypes
    public static final void sortArray--nroSd4(@NotNull final long[] array, final int fromIndex, final int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        quickSort--nroSd4(array, fromIndex, toIndex - 1);
    }
}
