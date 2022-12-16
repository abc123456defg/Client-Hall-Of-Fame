// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.filefilter;

import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;
import java.util.Objects;
import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import org.apache.commons.io.file.PathVisitor;

public abstract class AbstractFileFilter implements IOFileFilter, PathVisitor
{
    static FileVisitResult toFileVisitResult(final boolean accept, final Path path) {
        return accept ? FileVisitResult.CONTINUE : FileVisitResult.TERMINATE;
    }
    
    @Override
    public boolean accept(final File file) {
        Objects.requireNonNull(file, "file");
        return this.accept(file.getParentFile(), file.getName());
    }
    
    @Override
    public boolean accept(final File dir, final String name) {
        Objects.requireNonNull(name, "name");
        return this.accept(new File(dir, name));
    }
    
    protected FileVisitResult handle(final Throwable t) {
        return FileVisitResult.TERMINATE;
    }
    
    @Override
    public FileVisitResult postVisitDirectory(final Path dir, final IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
    
    @Override
    public FileVisitResult preVisitDirectory(final Path dir, final BasicFileAttributes attributes) throws IOException {
        return this.accept(dir, attributes);
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
    
    @Override
    public FileVisitResult visitFile(final Path file, final BasicFileAttributes attributes) throws IOException {
        return this.accept(file, attributes);
    }
    
    @Override
    public FileVisitResult visitFileFailed(final Path file, final IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}
