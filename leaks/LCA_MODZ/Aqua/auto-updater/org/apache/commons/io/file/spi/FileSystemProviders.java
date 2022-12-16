// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.file.spi;

import java.net.URL;
import java.net.URI;
import java.util.Iterator;
import java.nio.file.FileSystems;
import java.util.Objects;
import java.nio.file.Path;
import java.nio.file.spi.FileSystemProvider;
import java.util.List;

public class FileSystemProviders
{
    private static final FileSystemProviders INSTALLED;
    private final List<FileSystemProvider> providers;
    
    public static FileSystemProvider getFileSystemProvider(final Path path) {
        return Objects.requireNonNull(path, "path").getFileSystem().provider();
    }
    
    public static FileSystemProviders installed() {
        return FileSystemProviders.INSTALLED;
    }
    
    private FileSystemProviders(final List<FileSystemProvider> providers) {
        this.providers = providers;
    }
    
    public FileSystemProvider getFileSystemProvider(final String scheme) {
        Objects.requireNonNull(scheme, "scheme");
        if (scheme.equalsIgnoreCase("file")) {
            return FileSystems.getDefault().provider();
        }
        if (this.providers != null) {
            for (final FileSystemProvider provider : this.providers) {
                if (provider.getScheme().equalsIgnoreCase(scheme)) {
                    return provider;
                }
            }
        }
        return null;
    }
    
    public FileSystemProvider getFileSystemProvider(final URI uri) {
        return this.getFileSystemProvider(Objects.requireNonNull(uri, "uri").getScheme());
    }
    
    public FileSystemProvider getFileSystemProvider(final URL url) {
        return this.getFileSystemProvider(Objects.requireNonNull(url, "url").getProtocol());
    }
    
    static {
        INSTALLED = new FileSystemProviders(FileSystemProvider.installedProviders());
    }
}
