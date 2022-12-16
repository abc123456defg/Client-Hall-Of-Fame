// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.filefilter;

import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Path;
import java.io.File;
import org.apache.commons.io.file.PathFilter;
import java.io.FilenameFilter;
import java.io.FileFilter;

public interface IOFileFilter extends FileFilter, FilenameFilter, PathFilter
{
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    
    boolean accept(final File p0);
    
    boolean accept(final File p0, final String p1);
    
    default FileVisitResult accept(final Path path, final BasicFileAttributes attributes) {
        return AbstractFileFilter.toFileVisitResult(this.accept(path.toFile()), path);
    }
    
    default IOFileFilter and(final IOFileFilter fileFilter) {
        return new AndFileFilter(this, fileFilter);
    }
    
    default IOFileFilter negate() {
        return new NotFileFilter(this);
    }
    
    default IOFileFilter or(final IOFileFilter fileFilter) {
        return new OrFileFilter(this, fileFilter);
    }
}
