// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.io.path;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;
import org.jetbrains.annotations.Nullable;
import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.jvm.functions.Function2;
import kotlin.Metadata;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bw\u0012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tH\u0016R$\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014" }, d2 = { "Lkotlin/io/path/FileVisitorImpl;", "Ljava/nio/file/SimpleFileVisitor;", "Ljava/nio/file/Path;", "onPreVisitDirectory", "Lkotlin/Function2;", "Ljava/nio/file/attribute/BasicFileAttributes;", "Ljava/nio/file/FileVisitResult;", "onVisitFile", "onVisitFileFailed", "Ljava/io/IOException;", "onPostVisitDirectory", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "postVisitDirectory", "dir", "exc", "preVisitDirectory", "attrs", "visitFile", "file", "visitFileFailed", "kotlin-stdlib-jdk7" })
final class FileVisitorImpl extends SimpleFileVisitor<Path>
{
    @Nullable
    private final Function2<Path, BasicFileAttributes, FileVisitResult> onPreVisitDirectory;
    @Nullable
    private final Function2<Path, BasicFileAttributes, FileVisitResult> onVisitFile;
    @Nullable
    private final Function2<Path, IOException, FileVisitResult> onVisitFileFailed;
    @Nullable
    private final Function2<Path, IOException, FileVisitResult> onPostVisitDirectory;
    
    public FileVisitorImpl(@Nullable final Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> onPreVisitDirectory, @Nullable final Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> onVisitFile, @Nullable final Function2<? super Path, ? super IOException, ? extends FileVisitResult> onVisitFileFailed, @Nullable final Function2<? super Path, ? super IOException, ? extends FileVisitResult> onPostVisitDirectory) {
        this.onPreVisitDirectory = (Function2<Path, BasicFileAttributes, FileVisitResult>)onPreVisitDirectory;
        this.onVisitFile = (Function2<Path, BasicFileAttributes, FileVisitResult>)onVisitFile;
        this.onVisitFileFailed = (Function2<Path, IOException, FileVisitResult>)onVisitFileFailed;
        this.onPostVisitDirectory = (Function2<Path, IOException, FileVisitResult>)onPostVisitDirectory;
    }
    
    @NotNull
    @Override
    public FileVisitResult preVisitDirectory(@NotNull final Path dir, @NotNull final BasicFileAttributes attrs) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        final Function2<Path, BasicFileAttributes, FileVisitResult> onPreVisitDirectory = this.onPreVisitDirectory;
        FileVisitResult preVisitDirectory;
        if (onPreVisitDirectory == null || (preVisitDirectory = onPreVisitDirectory.invoke(dir, attrs)) == null) {
            Intrinsics.checkNotNullExpressionValue(preVisitDirectory = super.preVisitDirectory(dir, attrs), "super.preVisitDirectory(dir, attrs)");
        }
        return preVisitDirectory;
    }
    
    @NotNull
    @Override
    public FileVisitResult visitFile(@NotNull final Path file, @NotNull final BasicFileAttributes attrs) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        final Function2<Path, BasicFileAttributes, FileVisitResult> onVisitFile = this.onVisitFile;
        FileVisitResult visitFile;
        if (onVisitFile == null || (visitFile = onVisitFile.invoke(file, attrs)) == null) {
            Intrinsics.checkNotNullExpressionValue(visitFile = super.visitFile(file, attrs), "super.visitFile(file, attrs)");
        }
        return visitFile;
    }
    
    @NotNull
    @Override
    public FileVisitResult visitFileFailed(@NotNull final Path file, @NotNull final IOException exc) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(exc, "exc");
        final Function2<Path, IOException, FileVisitResult> onVisitFileFailed = this.onVisitFileFailed;
        FileVisitResult visitFileFailed;
        if (onVisitFileFailed == null || (visitFileFailed = onVisitFileFailed.invoke(file, exc)) == null) {
            Intrinsics.checkNotNullExpressionValue(visitFileFailed = super.visitFileFailed(file, exc), "super.visitFileFailed(file, exc)");
        }
        return visitFileFailed;
    }
    
    @NotNull
    @Override
    public FileVisitResult postVisitDirectory(@NotNull final Path dir, @Nullable final IOException exc) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        final Function2<Path, IOException, FileVisitResult> onPostVisitDirectory = this.onPostVisitDirectory;
        FileVisitResult postVisitDirectory;
        if (onPostVisitDirectory == null || (postVisitDirectory = onPostVisitDirectory.invoke(dir, exc)) == null) {
            Intrinsics.checkNotNullExpressionValue(postVisitDirectory = super.postVisitDirectory(dir, exc), "super.postVisitDirectory(dir, exc)");
        }
        return postVisitDirectory;
    }
}
