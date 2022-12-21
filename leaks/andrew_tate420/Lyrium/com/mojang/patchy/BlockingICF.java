// 
// Decompiled by Procyon v0.5.36
// 

package com.mojang.patchy;

import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.Context;
import java.util.Hashtable;
import com.google.common.base.Predicate;
import javax.naming.spi.InitialContextFactory;

public class BlockingICF implements InitialContextFactory
{
    private final Predicate<String> blockList;
    private final InitialContextFactory parent;
    
    public BlockingICF(final Predicate<String> blockList, final InitialContextFactory parent) {
        this.blockList = blockList;
        this.parent = parent;
    }
    
    @Override
    public Context getInitialContext(final Hashtable<?, ?> environment) throws NamingException {
        return new BlockingDC(this.blockList, (DirContext)this.parent.getInitialContext(environment));
    }
}
