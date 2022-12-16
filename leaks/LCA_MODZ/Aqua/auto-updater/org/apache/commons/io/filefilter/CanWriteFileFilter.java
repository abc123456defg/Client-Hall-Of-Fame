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

public class CanWriteFileFilter extends AbstractFileFilter implements Serializable
{
    public static final IOFileFilter CAN_WRITE;
    public static final IOFileFilter CANNOT_WRITE;
    private static final long serialVersionUID = 5132005214688990379L;
    
    protected CanWriteFileFilter() {
    }
    
    @Override
    public boolean accept(final File file) {
        return file.canWrite();
    }
    
    @Override
    public FileVisitResult accept(final Path file, final BasicFileAttributes attributes) {
        return AbstractFileFilter.toFileVisitResult(Files.isWritable(file), file);
    }
    
    static {
        CAN_WRITE = new CanWriteFileFilter();
        CANNOT_WRITE = CanWriteFileFilter.CAN_WRITE.negate();
    }
}
