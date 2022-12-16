// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.filefilter;

import java.util.Collections;
import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Path;
import java.util.Iterator;
import java.io.File;
import java.util.Collection;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class OrFileFilter extends AbstractFileFilter implements ConditionalFileFilter, Serializable
{
    private static final long serialVersionUID = 5767770777065432721L;
    private final List<IOFileFilter> fileFilters;
    
    public OrFileFilter() {
        this(0);
    }
    
    private OrFileFilter(final ArrayList<IOFileFilter> initialList) {
        this.fileFilters = Objects.requireNonNull(initialList, "initialList");
    }
    
    private OrFileFilter(final int initialCapacity) {
        this(new ArrayList<IOFileFilter>(initialCapacity));
    }
    
    public OrFileFilter(final IOFileFilter... fileFilters) {
        this(Objects.requireNonNull(fileFilters, "fileFilters").length);
        this.addFileFilter(fileFilters);
    }
    
    public OrFileFilter(final IOFileFilter filter1, final IOFileFilter filter2) {
        this(2);
        this.addFileFilter(filter1);
        this.addFileFilter(filter2);
    }
    
    public OrFileFilter(final List<IOFileFilter> fileFilters) {
        this(new ArrayList<IOFileFilter>(Objects.requireNonNull(fileFilters, "fileFilters")));
    }
    
    @Override
    public boolean accept(final File file) {
        for (final IOFileFilter fileFilter : this.fileFilters) {
            if (fileFilter.accept(file)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean accept(final File file, final String name) {
        for (final IOFileFilter fileFilter : this.fileFilters) {
            if (fileFilter.accept(file, name)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public FileVisitResult accept(final Path file, final BasicFileAttributes attributes) {
        for (final IOFileFilter fileFilter : this.fileFilters) {
            if (fileFilter.accept(file, attributes) == FileVisitResult.CONTINUE) {
                return FileVisitResult.CONTINUE;
            }
        }
        return FileVisitResult.TERMINATE;
    }
    
    @Override
    public void addFileFilter(final IOFileFilter fileFilter) {
        this.fileFilters.add(Objects.requireNonNull(fileFilter, "fileFilter"));
    }
    
    public void addFileFilter(final IOFileFilter... fileFilters) {
        for (final IOFileFilter fileFilter : Objects.requireNonNull(fileFilters, "fileFilters")) {
            this.addFileFilter(fileFilter);
        }
    }
    
    @Override
    public List<IOFileFilter> getFileFilters() {
        return Collections.unmodifiableList((List<? extends IOFileFilter>)this.fileFilters);
    }
    
    @Override
    public boolean removeFileFilter(final IOFileFilter fileFilter) {
        return this.fileFilters.remove(fileFilter);
    }
    
    @Override
    public void setFileFilters(final List<IOFileFilter> fileFilters) {
        this.fileFilters.clear();
        this.fileFilters.addAll(Objects.requireNonNull(fileFilters, "fileFilters"));
    }
    
    @Override
    public String toString() {
        final StringBuilder buffer = new StringBuilder();
        buffer.append(super.toString());
        buffer.append("(");
        if (this.fileFilters != null) {
            for (int i = 0; i < this.fileFilters.size(); ++i) {
                if (i > 0) {
                    buffer.append(",");
                }
                buffer.append(this.fileFilters.get(i));
            }
        }
        buffer.append(")");
        return buffer.toString();
    }
}
