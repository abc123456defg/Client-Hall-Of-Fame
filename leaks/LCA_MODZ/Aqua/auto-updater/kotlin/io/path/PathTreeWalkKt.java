// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.io.path;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0002\u0010\u0007\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002¨\u0006\u000b" }, d2 = { "keyOf", "", "path", "Ljava/nio/file/Path;", "linkOptions", "", "Ljava/nio/file/LinkOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "createsCycle", "", "Lkotlin/io/path/PathNode;", "kotlin-stdlib-jdk7" })
public final class PathTreeWalkKt
{
    private static final Object keyOf(final Path path, final LinkOption[] linkOptions) {
        Object fileKey;
        try {
            final LinkOption[] original = Arrays.copyOf(linkOptions, linkOptions.length);
            final BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class, (LinkOption[])Arrays.copyOf(original, original.length));
            Intrinsics.checkNotNullExpressionValue(attributes, "readAttributes(this, A::class.java, *options)");
            fileKey = attributes.fileKey();
        }
        catch (Throwable exception) {
            fileKey = null;
        }
        return fileKey;
    }
    
    private static final boolean createsCycle(final PathNode $this$createsCycle) {
        for (PathNode ancestor = $this$createsCycle.getParent(); ancestor != null; ancestor = ancestor.getParent()) {
            if (ancestor.getKey() != null && $this$createsCycle.getKey() != null) {
                if (Intrinsics.areEqual(ancestor.getKey(), $this$createsCycle.getKey())) {
                    return true;
                }
            }
            else {
                try {
                    if (Files.isSameFile(ancestor.getPath(), $this$createsCycle.getPath())) {
                        return true;
                    }
                }
                catch (IOException ex) {}
                catch (SecurityException ex2) {}
            }
        }
        return false;
    }
}
