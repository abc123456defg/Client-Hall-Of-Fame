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

public class CanReadFileFilter extends AbstractFileFilter implements Serializable
{
    public static final IOFileFilter CAN_READ;
    public static final IOFileFilter CANNOT_READ;
    public static final IOFileFilter READ_ONLY;
    private static final long serialVersionUID = 3179904805251622989L;
    
    protected CanReadFileFilter() {
    }
    
    @Override
    public boolean accept(final File file) {
        return file.canRead();
    }
    
    @Override
    public FileVisitResult accept(final Path file, final BasicFileAttributes attributes) {
        return AbstractFileFilter.toFileVisitResult(Files.isReadable(file), file);
    }
    
    static {
        CAN_READ = new CanReadFileFilter();
        CANNOT_READ = CanReadFileFilter.CAN_READ.negate();
        READ_ONLY = CanReadFileFilter.CAN_READ.and(CanWriteFileFilter.CANNOT_WRITE);
    }
}
