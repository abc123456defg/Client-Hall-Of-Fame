// 
// Decompiled by Procyon v0.5.36
// 

package javassist.bytecode.annotation;

import java.io.IOException;
import javassist.bytecode.Descriptor;
import java.lang.reflect.Method;
import javassist.ClassPool;
import javassist.bytecode.ConstPool;

public abstract class MemberValue
{
    ConstPool cp;
    char tag;
    
    MemberValue(final char tag, final ConstPool cp) {
        this.cp = cp;
        this.tag = tag;
    }
    
    abstract Object getValue(final ClassLoader cl, final ClassPool cp, final Method m) throws ClassNotFoundException;
    
    abstract Class getType(final ClassLoader cl) throws ClassNotFoundException;
    
    static Class loadClass(final ClassLoader cl, final String classname) throws ClassNotFoundException, NoSuchClassError {
        try {
            return Class.forName(convertFromArray(classname), true, cl);
        }
        catch (LinkageError e) {
            throw new NoSuchClassError(classname, e);
        }
    }
    
    private static String convertFromArray(final String classname) {
        int index = classname.indexOf("[]");
        if (index != -1) {
            final String rawType = classname.substring(0, index);
            final StringBuffer sb = new StringBuffer(Descriptor.of(rawType));
            while (index != -1) {
                sb.insert(0, "[");
                index = classname.indexOf("[]", index + 1);
            }
            return sb.toString().replace('/', '.');
        }
        return classname;
    }
    
    public abstract void accept(final MemberValueVisitor visitor);
    
    public abstract void write(final AnnotationsWriter w) throws IOException;
}
