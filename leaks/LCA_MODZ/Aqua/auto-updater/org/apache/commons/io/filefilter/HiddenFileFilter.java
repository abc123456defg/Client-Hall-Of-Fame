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

public class HiddenFileFilter extends AbstractFileFilter implements Serializable
{
    public static final IOFileFilter HIDDEN;
    private static final long serialVersionUID = 8930842316112759062L;
    public static final IOFileFilter VISIBLE;
    
    protected HiddenFileFilter() {
    }
    
    @Override
    public boolean accept(final File file) {
        return file.isHidden();
    }
    
    @Override
    public FileVisitResult accept(final Path file, final BasicFileAttributes attributes) {
        try {
            return AbstractFileFilter.toFileVisitResult(Files.isHidden(file), file);
        }
        catch (IOException e) {
            return this.handle(e);
        }
    }
    
    static {
        HIDDEN = new HiddenFileFilter();
        VISIBLE = HiddenFileFilter.HIDDEN.negate();
    }
}
