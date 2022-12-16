// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.ranges;

import kotlin.jvm.internal.DefaultConstructorMarker;
import java.util.NoSuchElementException;
import kotlin.UnsignedKt;
import kotlin.SinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.UInt;
import java.util.Iterator;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B \u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0096\u0002J\u0016\u0010\f\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\b\u001a\u00020\u0002X\u0082\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u00020\u0002X\u0082\u000e\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0005\u001a\u00020\u0002X\u0082\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u000f" }, d2 = { "Lkotlin/ranges/UIntProgressionIterator;", "", "Lkotlin/UInt;", "first", "last", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "I", "hasNext", "", "next", "next-pVg5ArA", "()I", "kotlin-stdlib" })
@SinceKotlin(version = "1.3")
final class UIntProgressionIterator implements Iterator<UInt>, KMappedMarker
{
    private final int finalElement;
    private boolean hasNext;
    private final int step;
    private int next;
    
    private UIntProgressionIterator(final int first, final int last, final int step) {
        this.finalElement = last;
        this.hasNext = ((step > 0) ? (UnsignedKt.uintCompare(first, last) <= 0) : (UnsignedKt.uintCompare(first, last) >= 0));
        this.step = UInt.constructor-impl(step);
        this.next = (this.hasNext ? first : this.finalElement);
    }
    
    @Override
    public boolean hasNext() {
        return this.hasNext;
    }
    
    public int next-pVg5ArA() {
        final int value = this.next;
        if (value == this.finalElement) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        }
        else {
            this.next = UInt.constructor-impl(this.next + this.step);
        }
        return value;
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
