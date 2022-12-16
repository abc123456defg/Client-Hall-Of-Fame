// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.io.path;

import java.nio.file.Paths;
import kotlin.jvm.internal.Intrinsics;
import java.nio.file.Path;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n" }, d2 = { "Lkotlin/io/path/PathRelativizer;", "", "()V", "emptyPath", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "parentPath", "tryRelativeTo", "path", "base", "kotlin-stdlib-jdk7" })
final class PathRelativizer
{
    @NotNull
    public static final PathRelativizer INSTANCE;
    private static final Path emptyPath;
    private static final Path parentPath;
    
    private PathRelativizer() {
    }
    
    @NotNull
    public final Path tryRelativeTo(@NotNull final Path path, @NotNull final Path base) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(base, "base");
        final Path bn = base.normalize();
        final Path pn = path.normalize();
        final Path rn = bn.relativize(pn);
        for (int i = 0; i < Math.min(bn.getNameCount(), pn.getNameCount()) && Intrinsics.areEqual(bn.getName(i), PathRelativizer.parentPath); ++i) {
            if (!Intrinsics.areEqual(pn.getName(i), PathRelativizer.parentPath)) {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
        }
        Path path2;
        if (!Intrinsics.areEqual(pn, bn) && Intrinsics.areEqual(bn, PathRelativizer.emptyPath)) {
            path2 = pn;
        }
        else {
            final String string;
            final String rnString = string = rn.toString();
            final String separator = rn.getFileSystem().getSeparator();
            Intrinsics.checkNotNullExpressionValue(separator, "rn.fileSystem.separator");
            path2 = (StringsKt__StringsJVMKt.endsWith$default(string, separator, false, 2, null) ? rn.getFileSystem().getPath(StringsKt___StringsKt.dropLast(rnString, rn.getFileSystem().getSeparator().length()), new String[0]) : rn);
        }
        final Path r = path2;
        Intrinsics.checkNotNullExpressionValue(r, "r");
        return r;
    }
    
    static {
        INSTANCE = new PathRelativizer();
        emptyPath = Paths.get("", new String[0]);
        parentPath = Paths.get("..", new String[0]);
    }
}
