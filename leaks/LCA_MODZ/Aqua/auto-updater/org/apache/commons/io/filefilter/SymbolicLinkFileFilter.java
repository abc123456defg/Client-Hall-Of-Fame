// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.filefilter;

import java.nio.file.Files;
import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Path;
import java.io.File;
import java.io.Serializable;

public class SymbolicLinkFileFilter extends AbstractFileFilter implements Serializable
{
    public static final SymbolicLinkFileFilter INSTANCE;
    private static final long serialVersionUID = 1L;
    
    protected SymbolicLinkFileFilter() {
    }
    
    @Override
    public boolean accept(final File file) {
        return file.isFile();
    }
    
    @Override
    public FileVisitResult accept(final Path file, final BasicFileAttributes attributes) {
        return AbstractFileFilter.toFileVisitResult(Files.isSymbolicLink(file), file);
    }
    
    static {
        INSTANCE = new SymbolicLinkFileFilter();
    }
}
