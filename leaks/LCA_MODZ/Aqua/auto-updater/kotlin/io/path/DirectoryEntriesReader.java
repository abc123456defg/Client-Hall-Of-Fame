// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.io.path;

import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import kotlin.jvm.internal.Intrinsics;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import kotlin.collections.ArrayDeque;
import org.jetbrains.annotations.Nullable;
import kotlin.Metadata;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015" }, d2 = { "Lkotlin/io/path/DirectoryEntriesReader;", "Ljava/nio/file/SimpleFileVisitor;", "Ljava/nio/file/Path;", "followLinks", "", "(Z)V", "directoryNode", "Lkotlin/io/path/PathNode;", "entries", "Lkotlin/collections/ArrayDeque;", "getFollowLinks", "()Z", "preVisitDirectory", "Ljava/nio/file/FileVisitResult;", "dir", "attrs", "Ljava/nio/file/attribute/BasicFileAttributes;", "readEntries", "", "visitFile", "file", "kotlin-stdlib-jdk7" })
final class DirectoryEntriesReader extends SimpleFileVisitor<Path>
{
    private final boolean followLinks;
    @Nullable
    private PathNode directoryNode;
    @NotNull
    private ArrayDeque<PathNode> entries;
    
    public DirectoryEntriesReader(final boolean followLinks) {
        this.followLinks = followLinks;
        this.entries = new ArrayDeque<PathNode>();
    }
    
    public final boolean getFollowLinks() {
        return this.followLinks;
    }
    
    @NotNull
    public final List<PathNode> readEntries(@NotNull final PathNode directoryNode) {
        Intrinsics.checkNotNullParameter(directoryNode, "directoryNode");
        this.directoryNode = directoryNode;
        Files.walkFileTree(directoryNode.getPath(), LinkFollowing.INSTANCE.toVisitOptions(this.followLinks), 1, this);
        this.entries.removeFirst();
        final ArrayDeque it;
        final ArrayDeque arrayDeque = it = this.entries;
        final int n = 0;
        this.entries = new ArrayDeque<PathNode>();
        return (ArrayDeque<PathNode>)arrayDeque;
    }
    
    @NotNull
    @Override
    public FileVisitResult preVisitDirectory(@NotNull final Path dir, @NotNull final BasicFileAttributes attrs) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        final PathNode directoryEntry = new PathNode(dir, attrs.fileKey(), this.directoryNode);
        this.entries.add(directoryEntry);
        final FileVisitResult preVisitDirectory = super.preVisitDirectory(dir, attrs);
        Intrinsics.checkNotNullExpressionValue(preVisitDirectory, "super.preVisitDirectory(dir, attrs)");
        return preVisitDirectory;
    }
    
    @NotNull
    @Override
    public FileVisitResult visitFile(@NotNull final Path file, @NotNull final BasicFileAttributes attrs) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        final PathNode fileEntry = new PathNode(file, null, this.directoryNode);
        this.entries.add(fileEntry);
        final FileVisitResult visitFile = super.visitFile(file, attrs);
        Intrinsics.checkNotNullExpressionValue(visitFile, "super.visitFile(file, attrs)");
        return visitFile;
    }
}
