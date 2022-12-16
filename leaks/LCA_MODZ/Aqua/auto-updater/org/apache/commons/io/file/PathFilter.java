// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.file;

import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Path;

@FunctionalInterface
public interface PathFilter
{
    FileVisitResult accept(final Path p0, final BasicFileAttributes p1);
}
