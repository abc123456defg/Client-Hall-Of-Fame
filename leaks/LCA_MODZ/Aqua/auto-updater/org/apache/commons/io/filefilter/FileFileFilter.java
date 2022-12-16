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

public class FileFileFilter extends AbstractFileFilter implements Serializable
{
    public static final IOFileFilter INSTANCE;
    @Deprecated
    public static final IOFileFilter FILE;
    private static final long serialVersionUID = 5345244090827540862L;
    
    protected FileFileFilter() {
    }
    
    @Override
    public boolean accept(final File file) {
        return file.isFile();
    }
    
    @Override
    public FileVisitResult accept(final Path file, final BasicFileAttributes attributes) {
        return AbstractFileFilter.toFileVisitResult(Files.isRegularFile(file, new LinkOption[0]), file);
    }
    
    static {
        INSTANCE = new FileFileFilter();
        FILE = FileFileFilter.INSTANCE;
    }
}
