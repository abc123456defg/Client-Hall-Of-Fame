// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.filefilter;

import java.io.IOException;
import org.apache.commons.io.file.PathUtils;
import java.nio.file.LinkOption;
import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Path;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.util.Date;
import java.io.Serializable;

public class AgeFileFilter extends AbstractFileFilter implements Serializable
{
    private static final long serialVersionUID = -2132740084016138541L;
    private final boolean acceptOlder;
    private final long cutoffMillis;
    
    public AgeFileFilter(final Date cutoffDate) {
        this(cutoffDate, true);
    }
    
    public AgeFileFilter(final Date cutoffDate, final boolean acceptOlder) {
        this(cutoffDate.getTime(), acceptOlder);
    }
    
    public AgeFileFilter(final File cutoffReference) {
        this(cutoffReference, true);
    }
    
    public AgeFileFilter(final File cutoffReference, final boolean acceptOlder) {
        this(FileUtils.lastModifiedUnchecked(cutoffReference), acceptOlder);
    }
    
    public AgeFileFilter(final long cutoffMillis) {
        this(cutoffMillis, true);
    }
    
    public AgeFileFilter(final long cutoffMillis, final boolean acceptOlder) {
        this.acceptOlder = acceptOlder;
        this.cutoffMillis = cutoffMillis;
    }
    
    @Override
    public boolean accept(final File file) {
        final boolean newer = FileUtils.isFileNewer(file, this.cutoffMillis);
        return this.acceptOlder != newer;
    }
    
    @Override
    public FileVisitResult accept(final Path file, final BasicFileAttributes attributes) {
        boolean newer;
        try {
            newer = PathUtils.isNewer(file, this.cutoffMillis, new LinkOption[0]);
        }
        catch (IOException e) {
            return this.handle(e);
        }
        return AbstractFileFilter.toFileVisitResult(this.acceptOlder != newer, file);
    }
    
    @Override
    public String toString() {
        final String condition = this.acceptOlder ? "<=" : ">";
        return super.toString() + "(" + condition + this.cutoffMillis + ")";
    }
}
