// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.filefilter;

import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Path;
import java.io.File;
import java.io.Serializable;

public class NotFileFilter extends AbstractFileFilter implements Serializable
{
    private static final long serialVersionUID = 6131563330944994230L;
    private final IOFileFilter filter;
    
    public NotFileFilter(final IOFileFilter filter) {
        if (filter == null) {
            throw new IllegalArgumentException("The filter must not be null");
        }
        this.filter = filter;
    }
    
    @Override
    public boolean accept(final File file) {
        return !this.filter.accept(file);
    }
    
    @Override
    public boolean accept(final File file, final String name) {
        return !this.filter.accept(file, name);
    }
    
    @Override
    public FileVisitResult accept(final Path file, final BasicFileAttributes attributes) {
        return this.not(this.filter.accept(file, attributes));
    }
    
    private FileVisitResult not(final FileVisitResult accept) {
        return (accept == FileVisitResult.CONTINUE) ? FileVisitResult.TERMINATE : FileVisitResult.CONTINUE;
    }
    
    @Override
    public String toString() {
        return "NOT (" + this.filter.toString() + ")";
    }
}
