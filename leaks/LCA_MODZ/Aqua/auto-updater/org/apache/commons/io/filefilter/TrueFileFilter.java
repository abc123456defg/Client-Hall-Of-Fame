// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.filefilter;

import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Path;
import java.io.File;
import java.io.Serializable;

public class TrueFileFilter implements IOFileFilter, Serializable
{
    private static final String TO_STRING;
    private static final long serialVersionUID = 8782512160909720199L;
    public static final IOFileFilter TRUE;
    public static final IOFileFilter INSTANCE;
    
    protected TrueFileFilter() {
    }
    
    @Override
    public boolean accept(final File file) {
        return true;
    }
    
    @Override
    public boolean accept(final File dir, final String name) {
        return true;
    }
    
    @Override
    public FileVisitResult accept(final Path file, final BasicFileAttributes attributes) {
        return FileVisitResult.CONTINUE;
    }
    
    @Override
    public IOFileFilter negate() {
        return FalseFileFilter.INSTANCE;
    }
    
    @Override
    public IOFileFilter or(final IOFileFilter fileFilter) {
        return TrueFileFilter.INSTANCE;
    }
    
    @Override
    public IOFileFilter and(final IOFileFilter fileFilter) {
        return fileFilter;
    }
    
    @Override
    public String toString() {
        return TrueFileFilter.TO_STRING;
    }
    
    static {
        TO_STRING = Boolean.TRUE.toString();
        TRUE = new TrueFileFilter();
        INSTANCE = TrueFileFilter.TRUE;
    }
}
