// 
// Decompiled by Procyon v0.5.36
// 

package com.mojang.patchy;

import javax.naming.NamingException;
import javax.naming.NoInitialContextException;
import javax.naming.spi.InitialContextFactory;
import java.util.Hashtable;
import javax.naming.spi.NamingManager;
import com.google.common.base.Predicate;
import javax.naming.spi.InitialContextFactoryBuilder;

public class BlockingICFB implements InitialContextFactoryBuilder
{
    private final Predicate<String> blockList;
    
    public BlockingICFB(final Predicate<String> blockList) {
        this.blockList = blockList;
    }
    
    public static void install() {
        try {
            System.getProperties().setProperty("sun.net.spi.nameservice.provider.1", "dns,sun");
            NamingManager.setInitialContextFactoryBuilder(new BlockingICFB(new Predicate<String>() {
                @Override
                public boolean apply(final String input) {
                    return BlockedServers.isBlockedServer(input);
                }
            }));
        }
        catch (Throwable e) {
            System.out.println("Block failed :(");
            e.printStackTrace();
        }
    }
    
    @Override
    public InitialContextFactory createInitialContextFactory(final Hashtable<?, ?> env) throws NamingException {
        final String className = (String)env.get("java.naming.factory.initial");
        try {
            final InitialContextFactory original = (InitialContextFactory)Class.forName(className).newInstance();
            if ("com.sun.jndi.dns.DnsContextFactory".equals(className)) {
                return new BlockingICF(this.blockList, original);
            }
            return original;
        }
        catch (Exception e) {
            final NoInitialContextException ne = new NoInitialContextException("Cannot instantiate class: " + className);
            ne.setRootCause(e);
            throw ne;
        }
    }
}
