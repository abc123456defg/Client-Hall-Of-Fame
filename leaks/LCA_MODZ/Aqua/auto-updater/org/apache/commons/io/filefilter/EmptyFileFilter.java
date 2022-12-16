// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.filefilter;

import java.util.stream.Stream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Path;
import org.apache.commons.io.IOUtils;
import java.io.File;
import java.io.Serializable;

public class EmptyFileFilter extends AbstractFileFilter implements Serializable
{
    public static final IOFileFilter EMPTY;
    public static final IOFileFilter NOT_EMPTY;
    private static final long serialVersionUID = 3631422087512832211L;
    
    protected EmptyFileFilter() {
    }
    
    @Override
    public boolean accept(final File file) {
        if (file.isDirectory()) {
            final File[] files = file.listFiles();
            return IOUtils.length(files) == 0;
        }
        return file.length() == 0L;
    }
    
    @Override
    public FileVisitResult accept(final Path file, final BasicFileAttributes attributes) {
        try {
            if (Files.isDirectory(file, new LinkOption[0])) {
                try (final Stream<Path> stream = Files.list(file)) {
                    return AbstractFileFilter.toFileVisitResult(!stream.findFirst().isPresent(), file);
                }
            }
            return AbstractFileFilter.toFileVisitResult(Files.size(file) == 0L, file);
        }
        catch (IOException e) {
            return this.handle(e);
        }
    }
    
    static {
        EMPTY = new EmptyFileFilter();
        NOT_EMPTY = EmptyFileFilter.EMPTY.negate();
    }
}
