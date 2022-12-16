// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.io.path;

import kotlin.jvm.internal.Intrinsics;
import java.util.Iterator;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import java.nio.file.Path;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0006R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013" }, d2 = { "Lkotlin/io/path/PathNode;", "", "path", "Ljava/nio/file/Path;", "key", "parent", "(Ljava/nio/file/Path;Ljava/lang/Object;Lkotlin/io/path/PathNode;)V", "contentIterator", "", "getContentIterator", "()Ljava/util/Iterator;", "setContentIterator", "(Ljava/util/Iterator;)V", "getKey", "()Ljava/lang/Object;", "getParent", "()Lkotlin/io/path/PathNode;", "getPath", "()Ljava/nio/file/Path;", "kotlin-stdlib-jdk7" })
final class PathNode
{
    @NotNull
    private final Path path;
    @Nullable
    private final Object key;
    @Nullable
    private final PathNode parent;
    @Nullable
    private Iterator<PathNode> contentIterator;
    
    public PathNode(@NotNull final Path path, @Nullable final Object key, @Nullable final PathNode parent) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
        this.key = key;
        this.parent = parent;
    }
    
    @NotNull
    public final Path getPath() {
        return this.path;
    }
    
    @Nullable
    public final Object getKey() {
        return this.key;
    }
    
    @Nullable
    public final PathNode getParent() {
        return this.parent;
    }
    
    @Nullable
    public final Iterator<PathNode> getContentIterator() {
        return this.contentIterator;
    }
    
    public final void setContentIterator(@Nullable final Iterator<PathNode> <set-?>) {
        this.contentIterator = <set-?>;
    }
}
