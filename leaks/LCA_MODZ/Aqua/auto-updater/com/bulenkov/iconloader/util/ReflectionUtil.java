// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import org.jetbrains.annotations.Nullable;

public class ReflectionUtil
{
    @Nullable
    public static Class getGrandCallerClass() {
        int stackFrameCount;
        Class callerClass;
        for (stackFrameCount = 3, callerClass = findCallerClass(stackFrameCount); callerClass != null && callerClass.getClassLoader() == null; callerClass = findCallerClass(++stackFrameCount)) {}
        if (callerClass == null) {
            callerClass = findCallerClass(2);
        }
        return callerClass;
    }
    
    @Nullable
    public static Class findCallerClass(final int framesToSkip) {
        try {
            final Class[] stack = MySecurityManager.INSTANCE.getStack();
            final int indexFromTop = 1 + framesToSkip;
            return (stack.length > indexFromTop) ? stack[indexFromTop] : null;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    private ReflectionUtil() {
    }
    
    private static class MySecurityManager extends SecurityManager
    {
        private static final MySecurityManager INSTANCE;
        
        public Class[] getStack() {
            return this.getClassContext();
        }
        
        static {
            INSTANCE = new MySecurityManager();
        }
    }
}
