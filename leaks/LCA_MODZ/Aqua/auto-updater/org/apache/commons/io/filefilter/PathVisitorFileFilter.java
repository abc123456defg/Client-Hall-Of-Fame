// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.filefilter;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import org.apache.commons.io.file.PathUtils;
import java.io.File;
import org.apache.commons.io.file.NoopPathVisitor;
import org.apache.commons.io.file.PathVisitor;

public class PathVisitorFileFilter extends AbstractFileFilter
{
    private final PathVisitor pathVisitor;
    
    public PathVisitorFileFilter(final PathVisitor pathVisitor) {
        this.pathVisitor = ((pathVisitor == null) ? NoopPathVisitor.INSTANCE : pathVisitor);
    }
    
    @Override
    public boolean accept(final File file) {
        try {
            final Path path = file.toPath();
            return this.visitFile(path, file.exists() ? PathUtils.readBasicFileAttributes(path) : null) == FileVisitResult.CONTINUE;
        }
        catch (IOException e) {
            return this.handle(e) == FileVisitResult.CONTINUE;
        }
    }
    
    @Override
    public boolean accept(final File dir, final String name) {
        try {
            final Path path = dir.toPath().resolve(name);
            return this.accept(path, PathUtils.readBasicFileAttributes(path)) == FileVisitResult.CONTINUE;
        }
        catch (IOException e) {
            return this.handle(e) == FileVisitResult.CONTINUE;
        }
    }
    
    @Override
    public FileVisitResult accept(final Path path, final BasicFileAttributes attributes) {
        try {
            return Files.isDirectory(path, new LinkOption[0]) ? this.pathVisitor.postVisitDirectory(path, null) : this.visitFile(path, attributes);
        }
        catch (IOException e) {
            return this.handle(e);
        }
    }
    
    @Override
    public FileVisitResult visitFile(final Path path, final BasicFileAttributes attributes) throws IOException {
        return this.pathVisitor.visitFile(path, attributes);
    }
}
