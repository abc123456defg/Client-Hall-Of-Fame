// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.output;

import java.util.Iterator;
import org.apache.commons.io.IOExceptionList;
import org.apache.commons.io.IOIndexedException;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Collection;
import java.io.Writer;

public class FilterCollectionWriter extends Writer
{
    protected final Collection<Writer> EMPTY_WRITERS;
    protected final Collection<Writer> writers;
    
    protected FilterCollectionWriter(final Collection<Writer> writers) {
        this.EMPTY_WRITERS = (Collection<Writer>)Collections.emptyList();
        this.writers = ((writers == null) ? this.EMPTY_WRITERS : writers);
    }
    
    protected FilterCollectionWriter(final Writer... writers) {
        this.EMPTY_WRITERS = (Collection<Writer>)Collections.emptyList();
        this.writers = ((writers == null) ? this.EMPTY_WRITERS : Arrays.asList(writers));
    }
    
    private List<Exception> add(List<Exception> causeList, final int i, final IOException e) {
        if (causeList == null) {
            causeList = new ArrayList<Exception>();
        }
        causeList.add(new IOIndexedException(i, e));
        return causeList;
    }
    
    @Override
    public Writer append(final char c) throws IOException {
        List<Exception> causeList = null;
        int i = 0;
        for (final Writer w : this.writers) {
            if (w != null) {
                try {
                    w.append(c);
                }
                catch (IOException e) {
                    causeList = this.add(causeList, i, e);
                }
            }
            ++i;
        }
        if (this.notEmpty(causeList)) {
            throw new IOExceptionList("append", causeList);
        }
        return this;
    }
    
    @Override
    public Writer append(final CharSequence csq) throws IOException {
        List<Exception> causeList = null;
        int i = 0;
        for (final Writer w : this.writers) {
            if (w != null) {
                try {
                    w.append(csq);
                }
                catch (IOException e) {
                    causeList = this.add(causeList, i, e);
                }
            }
            ++i;
        }
        if (this.notEmpty(causeList)) {
            throw new IOExceptionList("append", causeList);
        }
        return this;
    }
    
    @Override
    public Writer append(final CharSequence csq, final int start, final int end) throws IOException {
        List<Exception> causeList = null;
        int i = 0;
        for (final Writer w : this.writers) {
            if (w != null) {
                try {
                    w.append(csq, start, end);
                }
                catch (IOException e) {
                    causeList = this.add(causeList, i, e);
                }
            }
            ++i;
        }
        if (this.notEmpty(causeList)) {
            throw new IOExceptionList("append", causeList);
        }
        return this;
    }
    
    @Override
    public void close() throws IOException {
        List<Exception> causeList = null;
        int i = 0;
        for (final Writer w : this.writers) {
            if (w != null) {
                try {
                    w.close();
                }
                catch (IOException e) {
                    causeList = this.add(causeList, i, e);
                }
            }
            ++i;
        }
        if (this.notEmpty(causeList)) {
            throw new IOExceptionList("close", causeList);
        }
    }
    
    @Override
    public void flush() throws IOException {
        List<Exception> causeList = null;
        int i = 0;
        for (final Writer w : this.writers) {
            if (w != null) {
                try {
                    w.flush();
                }
                catch (IOException e) {
                    causeList = this.add(causeList, i, e);
                }
            }
            ++i;
        }
        if (this.notEmpty(causeList)) {
            throw new IOExceptionList("flush", causeList);
        }
    }
    
    private boolean notEmpty(final List<Exception> causeList) {
        return causeList != null && !causeList.isEmpty();
    }
    
    @Override
    public void write(final char[] cbuf) throws IOException {
        List<Exception> causeList = null;
        int i = 0;
        for (final Writer w : this.writers) {
            if (w != null) {
                try {
                    w.write(cbuf);
                }
                catch (IOException e) {
                    causeList = this.add(causeList, i, e);
                }
            }
            ++i;
        }
        if (this.notEmpty(causeList)) {
            throw new IOExceptionList("write", causeList);
        }
    }
    
    @Override
    public void write(final char[] cbuf, final int off, final int len) throws IOException {
        List<Exception> causeList = null;
        int i = 0;
        for (final Writer w : this.writers) {
            if (w != null) {
                try {
                    w.write(cbuf, off, len);
                }
                catch (IOException e) {
                    causeList = this.add(causeList, i, e);
                }
            }
            ++i;
        }
        if (this.notEmpty(causeList)) {
            throw new IOExceptionList("write", causeList);
        }
    }
    
    @Override
    public void write(final int c) throws IOException {
        List<Exception> causeList = null;
        int i = 0;
        for (final Writer w : this.writers) {
            if (w != null) {
                try {
                    w.write(c);
                }
                catch (IOException e) {
                    causeList = this.add(causeList, i, e);
                }
            }
            ++i;
        }
        if (this.notEmpty(causeList)) {
            throw new IOExceptionList("write", causeList);
        }
    }
    
    @Override
    public void write(final String str) throws IOException {
        List<Exception> causeList = null;
        int i = 0;
        for (final Writer w : this.writers) {
            if (w != null) {
                try {
                    w.write(str);
                }
                catch (IOException e) {
                    causeList = this.add(causeList, i, e);
                }
            }
            ++i;
        }
        if (this.notEmpty(causeList)) {
            throw new IOExceptionList("write", causeList);
        }
    }
    
    @Override
    public void write(final String str, final int off, final int len) throws IOException {
        List<Exception> causeList = null;
        int i = 0;
        for (final Writer w : this.writers) {
            if (w != null) {
                try {
                    w.write(str, off, len);
                }
                catch (IOException e) {
                    causeList = this.add(causeList, i, e);
                }
            }
            ++i;
        }
        if (this.notEmpty(causeList)) {
            throw new IOExceptionList("write", causeList);
        }
    }
}
