// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.filefilter;

import java.util.Objects;
import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Path;
import java.io.File;
import java.util.List;
import org.apache.commons.io.IOCase;
import java.io.Serializable;

public class NameFileFilter extends AbstractFileFilter implements Serializable
{
    private static final long serialVersionUID = 176844364689077340L;
    private final String[] names;
    private final IOCase caseSensitivity;
    
    public NameFileFilter(final List<String> names) {
        this(names, null);
    }
    
    public NameFileFilter(final List<String> names, final IOCase caseSensitivity) {
        if (names == null) {
            throw new IllegalArgumentException("The list of names must not be null");
        }
        this.names = names.toArray(NameFileFilter.EMPTY_STRING_ARRAY);
        this.caseSensitivity = this.toIOCase(caseSensitivity);
    }
    
    public NameFileFilter(final String name) {
        this(name, IOCase.SENSITIVE);
    }
    
    public NameFileFilter(final String... names) {
        this(names, IOCase.SENSITIVE);
    }
    
    public NameFileFilter(final String name, final IOCase caseSensitivity) {
        if (name == null) {
            throw new IllegalArgumentException("The wildcard must not be null");
        }
        this.names = new String[] { name };
        this.caseSensitivity = this.toIOCase(caseSensitivity);
    }
    
    public NameFileFilter(final String[] names, final IOCase caseSensitivity) {
        if (names == null) {
            throw new IllegalArgumentException("The array of names must not be null");
        }
        System.arraycopy(names, 0, this.names = new String[names.length], 0, names.length);
        this.caseSensitivity = this.toIOCase(caseSensitivity);
    }
    
    @Override
    public boolean accept(final File file) {
        return this.acceptBaseName(file.getName());
    }
    
    @Override
    public boolean accept(final File dir, final String name) {
        return this.acceptBaseName(name);
    }
    
    @Override
    public FileVisitResult accept(final Path file, final BasicFileAttributes attributes) {
        return AbstractFileFilter.toFileVisitResult(this.acceptBaseName(Objects.toString(file.getFileName(), null)), file);
    }
    
    private boolean acceptBaseName(final String baseName) {
        for (final String testName : this.names) {
            if (this.caseSensitivity.checkEquals(baseName, testName)) {
                return true;
            }
        }
        return false;
    }
    
    private IOCase toIOCase(final IOCase caseSensitivity) {
        return (caseSensitivity == null) ? IOCase.SENSITIVE : caseSensitivity;
    }
    
    @Override
    public String toString() {
        final StringBuilder buffer = new StringBuilder();
        buffer.append(super.toString());
        buffer.append("(");
        if (this.names != null) {
            for (int i = 0; i < this.names.length; ++i) {
                if (i > 0) {
                    buffer.append(",");
                }
                buffer.append(this.names[i]);
            }
        }
        buffer.append(")");
        return buffer.toString();
    }
}
