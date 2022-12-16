// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.comparator;

import java.util.List;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.util.Comparator;
import java.io.Serializable;

public class LastModifiedFileComparator extends AbstractFileComparator implements Serializable
{
    private static final long serialVersionUID = 7372168004395734046L;
    public static final Comparator<File> LASTMODIFIED_COMPARATOR;
    public static final Comparator<File> LASTMODIFIED_REVERSE;
    
    @Override
    public int compare(final File file1, final File file2) {
        final long result = FileUtils.lastModifiedUnchecked(file1) - FileUtils.lastModifiedUnchecked(file2);
        if (result < 0L) {
            return -1;
        }
        if (result > 0L) {
            return 1;
        }
        return 0;
    }
    
    static {
        LASTMODIFIED_COMPARATOR = new LastModifiedFileComparator();
        LASTMODIFIED_REVERSE = new ReverseFileComparator(LastModifiedFileComparator.LASTMODIFIED_COMPARATOR);
    }
}
