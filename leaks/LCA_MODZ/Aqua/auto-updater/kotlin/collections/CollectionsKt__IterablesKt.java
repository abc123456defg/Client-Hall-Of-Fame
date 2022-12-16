// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections;

import kotlin.TuplesKt;
import kotlin.Pair;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import kotlin.PublishedApi;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000*\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\b\u00f8\u0001\u0000\u001a \u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0001\u001a\u001f\u0010\t\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0001¢\u0006\u0002\u0010\n\u001a\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a@\u0010\r\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\f0\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000f*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000f0\u000e0\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010" }, d2 = { "Iterable", "", "T", "iterator", "Lkotlin/Function0;", "", "collectionSizeOrDefault", "", "default", "collectionSizeOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "flatten", "", "unzip", "Lkotlin/Pair;", "R", "kotlin-stdlib" }, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__IterablesKt extends CollectionsKt__CollectionsKt
{
    @InlineOnly
    private static final <T> Iterable<T> Iterable(final Function0<? extends Iterator<? extends T>> iterator) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        return (Iterable<T>)new CollectionsKt__IterablesKt$Iterable.CollectionsKt__IterablesKt$Iterable$1((Function0)iterator);
    }
    
    @PublishedApi
    @Nullable
    public static final <T> Integer collectionSizeOrNull(@NotNull final Iterable<? extends T> $this$collectionSizeOrNull) {
        Intrinsics.checkNotNullParameter($this$collectionSizeOrNull, "<this>");
        return ($this$collectionSizeOrNull instanceof Collection) ? Integer.valueOf(((Collection)$this$collectionSizeOrNull).size()) : null;
    }
    
    @PublishedApi
    public static final <T> int collectionSizeOrDefault(@NotNull final Iterable<? extends T> $this$collectionSizeOrDefault, final int default) {
        Intrinsics.checkNotNullParameter($this$collectionSizeOrDefault, "<this>");
        return ($this$collectionSizeOrDefault instanceof Collection) ? ((Collection)$this$collectionSizeOrDefault).size() : default;
    }
    
    @NotNull
    public static final <T> List<T> flatten(@NotNull final Iterable<? extends Iterable<? extends T>> $this$flatten) {
        Intrinsics.checkNotNullParameter($this$flatten, "<this>");
        final ArrayList result = new ArrayList();
        for (final Iterable element : $this$flatten) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super Object>)result, (Iterable<?>)element);
        }
        return (List<T>)result;
    }
    
    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> unzip(@NotNull final Iterable<? extends Pair<? extends T, ? extends R>> $this$unzip) {
        Intrinsics.checkNotNullParameter($this$unzip, "<this>");
        final int expectedSize = collectionSizeOrDefault((Iterable<?>)$this$unzip, 10);
        final ArrayList listT = new ArrayList(expectedSize);
        final ArrayList listR = new ArrayList(expectedSize);
        for (final Pair pair : $this$unzip) {
            listT.add(pair.getFirst());
            listR.add(pair.getSecond());
        }
        return TuplesKt.to((List<T>)listT, (List<R>)listR);
    }
    
    public CollectionsKt__IterablesKt() {
    }
}
