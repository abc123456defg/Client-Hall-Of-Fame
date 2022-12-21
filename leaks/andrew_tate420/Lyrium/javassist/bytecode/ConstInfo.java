// 
// Decompiled by Procyon v0.5.36
// 

package javassist.bytecode;

import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.DataOutputStream;
import java.util.Map;
import java.util.HashMap;

abstract class ConstInfo
{
    int index;
    
    public ConstInfo(final int i) {
        this.index = i;
    }
    
    public abstract int getTag();
    
    public String getClassName(final ConstPool cp) {
        return null;
    }
    
    public void renameClass(final ConstPool cp, final String oldName, final String newName, final HashMap cache) {
    }
    
    public void renameClass(final ConstPool cp, final Map classnames, final HashMap cache) {
    }
    
    public abstract int copy(final ConstPool src, final ConstPool dest, final Map classnames);
    
    public abstract void write(final DataOutputStream out) throws IOException;
    
    public abstract void print(final PrintWriter out);
    
    @Override
    public String toString() {
        final ByteArrayOutputStream bout = new ByteArrayOutputStream();
        final PrintWriter out = new PrintWriter(bout);
        this.print(out);
        return bout.toString();
    }
}
