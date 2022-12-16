// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.file;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.util.Objects;
import java.nio.file.Path;
import java.nio.file.DirectoryStream;

public class DirectoryStreamFilter implements DirectoryStream.Filter<Path>
{
    private final PathFilter pathFilter;
    
    public DirectoryStreamFilter(final PathFilter pathFilter) {
        this.pathFilter = Objects.requireNonNull(pathFilter, "pathFilter");
    }
    
    @Override
    public boolean accept(final Path path) throws IOException {
        return this.pathFilter.accept(path, PathUtils.readBasicFileAttributes(path)) == FileVisitResult.CONTINUE;
    }
    
    public PathFilter getPathFilter() {
        return this.pathFilter;
    }
}
