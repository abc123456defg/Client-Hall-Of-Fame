// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.filefilter;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Path;
import java.io.File;
import java.io.Serializable;

public class DirectoryFileFilter extends AbstractFileFilter implements Serializable
{
    public static final IOFileFilter DIRECTORY;
    public static final IOFileFilter INSTANCE;
    private static final long serialVersionUID = -5148237843784525732L;
    
    protected DirectoryFileFilter() {
    }
    
    @Override
    public boolean accept(final File file) {
        return file.isDirectory();
    }
    
    @Override
    public FileVisitResult accept(final Path file, final BasicFileAttributes attributes) {
        return AbstractFileFilter.toFileVisitResult(Files.isDirectory(file, new LinkOption[0]), file);
    }
    
    static {
        DIRECTORY = new DirectoryFileFilter();
        INSTANCE = DirectoryFileFilter.DIRECTORY;
    }
}
