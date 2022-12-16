// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.filefilter;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Arrays;
import java.io.RandomAccessFile;
import java.io.File;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;
import java.io.Serializable;

public class MagicNumberFileFilter extends AbstractFileFilter implements Serializable
{
    private static final long serialVersionUID = -547733176983104172L;
    private final byte[] magicNumbers;
    private final long byteOffset;
    
    public MagicNumberFileFilter(final byte[] magicNumber) {
        this(magicNumber, 0L);
    }
    
    public MagicNumberFileFilter(final byte[] magicNumber, final long offset) {
        if (magicNumber == null) {
            throw new IllegalArgumentException("The magic number cannot be null");
        }
        if (magicNumber.length == 0) {
            throw new IllegalArgumentException("The magic number must contain at least one byte");
        }
        if (offset < 0L) {
            throw new IllegalArgumentException("The offset cannot be negative");
        }
        System.arraycopy(magicNumber, 0, this.magicNumbers = IOUtils.byteArray(magicNumber.length), 0, magicNumber.length);
        this.byteOffset = offset;
    }
    
    public MagicNumberFileFilter(final String magicNumber) {
        this(magicNumber, 0L);
    }
    
    public MagicNumberFileFilter(final String magicNumber, final long offset) {
        if (magicNumber == null) {
            throw new IllegalArgumentException("The magic number cannot be null");
        }
        if (magicNumber.isEmpty()) {
            throw new IllegalArgumentException("The magic number must contain at least one byte");
        }
        if (offset < 0L) {
            throw new IllegalArgumentException("The offset cannot be negative");
        }
        this.magicNumbers = magicNumber.getBytes(Charset.defaultCharset());
        this.byteOffset = offset;
    }
    
    @Override
    public boolean accept(final File file) {
        if (file != null && file.isFile() && file.canRead()) {
            try (final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {
                final byte[] fileBytes = IOUtils.byteArray(this.magicNumbers.length);
                randomAccessFile.seek(this.byteOffset);
                final int read = randomAccessFile.read(fileBytes);
                if (read != this.magicNumbers.length) {
                    return false;
                }
                return Arrays.equals(this.magicNumbers, fileBytes);
            }
            catch (IOException ex) {}
        }
        return false;
    }
    
    @Override
    public FileVisitResult accept(final Path file, final BasicFileAttributes attributes) {
        if (file != null && Files.isRegularFile(file, new LinkOption[0]) && Files.isReadable(file)) {
            try (final FileChannel fileChannel = FileChannel.open(file, new OpenOption[0])) {
                final ByteBuffer byteBuffer = ByteBuffer.allocate(this.magicNumbers.length);
                final int read = fileChannel.read(byteBuffer);
                if (read != this.magicNumbers.length) {
                    return FileVisitResult.TERMINATE;
                }
                return AbstractFileFilter.toFileVisitResult(Arrays.equals(this.magicNumbers, byteBuffer.array()), file);
            }
            catch (IOException ex) {}
        }
        return FileVisitResult.TERMINATE;
    }
    
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(super.toString());
        builder.append("(");
        builder.append(new String(this.magicNumbers, Charset.defaultCharset()));
        builder.append(",");
        builder.append(this.byteOffset);
        builder.append(")");
        return builder.toString();
    }
}
