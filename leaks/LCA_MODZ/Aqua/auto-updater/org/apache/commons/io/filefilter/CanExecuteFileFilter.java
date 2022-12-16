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

public class CanExecuteFileFilter extends AbstractFileFilter implements Serializable
{
    public static final IOFileFilter CAN_EXECUTE;
    public static final IOFileFilter CANNOT_EXECUTE;
    private static final long serialVersionUID = 3179904805251622989L;
    
    protected CanExecuteFileFilter() {
    }
    
    @Override
    public boolean accept(final File file) {
        return file.canExecute();
    }
    
    @Override
    public FileVisitResult accept(final Path file, final BasicFileAttributes attributes) {
        return AbstractFileFilter.toFileVisitResult(Files.isExecutable(file), file);
    }
    
    static {
        CAN_EXECUTE = new CanExecuteFileFilter();
        CANNOT_EXECUTE = CanExecuteFileFilter.CAN_EXECUTE.negate();
    }
}
