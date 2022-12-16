// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.io;

import org.jetbrains.annotations.Nullable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import java.io.File;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0003J#\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0013H\u00d6\u0001J\u0016\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0013J\t\u0010\u001f\u001a\u00020\rH\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006 " }, d2 = { "Lkotlin/io/FilePathComponents;", "", "root", "Ljava/io/File;", "segments", "", "(Ljava/io/File;Ljava/util/List;)V", "isRooted", "", "()Z", "getRoot", "()Ljava/io/File;", "rootName", "", "getRootName", "()Ljava/lang/String;", "getSegments", "()Ljava/util/List;", "size", "", "getSize", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "subPath", "beginIndex", "endIndex", "toString", "kotlin-stdlib" })
public final class FilePathComponents
{
    @NotNull
    private final File root;
    @NotNull
    private final List<File> segments;
    
    public FilePathComponents(@NotNull final File root, @NotNull final List<? extends File> segments) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(segments, "segments");
        this.root = root;
        this.segments = (List<File>)segments;
    }
    
    @NotNull
    public final File getRoot() {
        return this.root;
    }
    
    @NotNull
    public final List<File> getSegments() {
        return this.segments;
    }
    
    @NotNull
    public final String getRootName() {
        final String path = this.root.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "root.path");
        return path;
    }
    
    public final boolean isRooted() {
        final String path = this.root.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "root.path");
        return path.length() > 0;
    }
    
    public final int getSize() {
        return this.segments.size();
    }
    
    @NotNull
    public final File subPath(final int beginIndex, final int endIndex) {
        if (beginIndex < 0 || beginIndex > endIndex || endIndex > this.getSize()) {
            throw new IllegalArgumentException();
        }
        final List<File> list = this.segments.subList(beginIndex, endIndex);
        final String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        return new File(CollectionsKt___CollectionsKt.joinToString$default(list, separator, null, null, 0, null, null, 62, null));
    }
    
    @NotNull
    public final File component1() {
        return this.root;
    }
    
    @NotNull
    public final List<File> component2() {
        return this.segments;
    }
    
    @NotNull
    public final FilePathComponents copy(@NotNull final File root, @NotNull final List<? extends File> segments) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(segments, "segments");
        return new FilePathComponents(root, segments);
    }
    
    @NotNull
    @Override
    public String toString() {
        return "FilePathComponents(root=" + this.root + ", segments=" + this.segments + ')';
    }
    
    @Override
    public int hashCode() {
        int result = this.root.hashCode();
        result = result * 31 + this.segments.hashCode();
        return result;
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilePathComponents)) {
            return false;
        }
        final FilePathComponents filePathComponents = (FilePathComponents)other;
        return Intrinsics.areEqual(this.root, filePathComponents.root) && Intrinsics.areEqual(this.segments, filePathComponents.segments);
    }
}
