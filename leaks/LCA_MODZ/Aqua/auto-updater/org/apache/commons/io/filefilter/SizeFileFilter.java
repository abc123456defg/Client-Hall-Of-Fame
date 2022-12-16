// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.filefilter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Path;
import java.io.File;
import java.io.Serializable;

public class SizeFileFilter extends AbstractFileFilter implements Serializable
{
    private static final long serialVersionUID = 7388077430788600069L;
    private final boolean acceptLarger;
    private final long size;
    
    public SizeFileFilter(final long size) {
        this(size, true);
    }
    
    public SizeFileFilter(final long size, final boolean acceptLarger) {
        if (size < 0L) {
            throw new IllegalArgumentException("The size must be non-negative");
        }
        this.size = size;
        this.acceptLarger = acceptLarger;
    }
    
    @Override
    public boolean accept(final File file) {
        return this.accept(file.length());
    }
    
    private boolean accept(final long length) {
        return this.acceptLarger != length < this.size;
    }
    
    @Override
    public FileVisitResult accept(final Path file, final BasicFileAttributes attributes) {
        try {
            return AbstractFileFilter.toFileVisitResult(this.accept(Files.size(file)), file);
        }
        catch (IOException e) {
            return this.handle(e);
        }
    }
    
    @Override
    public String toString() {
        final String condition = this.acceptLarger ? ">=" : "<";
        return super.toString() + "(" + condition + this.size + ")";
    }
    
    @Override
    public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
        return AbstractFileFilter.toFileVisitResult(this.accept(Files.size(file)), file);
    }
}
