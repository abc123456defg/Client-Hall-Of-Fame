// 
// Decompiled by Procyon v0.5.36
// 

package com.mojang.patchy;

import java.io.IOException;
import java.util.Collection;
import org.apache.commons.io.IOUtils;
import java.net.URL;
import org.apache.commons.io.Charsets;
import com.google.common.collect.Sets;
import com.google.common.hash.Hashing;
import java.util.Iterator;
import java.util.List;
import com.google.common.collect.Lists;
import java.nio.charset.Charset;
import com.google.common.base.Splitter;
import com.google.common.base.Joiner;
import com.google.common.annotations.VisibleForTesting;
import java.util.Set;

public class BlockedServers
{
    @VisibleForTesting
    static final Set<String> BLOCKED_SERVERS;
    private static final String SRV_PREFIX = "_minecraft._tcp.";
    private static final Joiner DOT_JOINER;
    private static final Splitter DOT_SPLITTER;
    private static final Charset HASH_CHARSET;
    
    public static boolean isBlockedServer(String server) {
        if (server == null || server.isEmpty()) {
            return false;
        }
        if (server.startsWith("_minecraft._tcp.")) {
            server = server.substring("_minecraft._tcp.".length());
        }
        while (server.charAt(server.length() - 1) == '.') {
            server = server.substring(0, server.length() - 1);
        }
        if (isBlockedServerHostName(server)) {
            return true;
        }
        final List<String> parts = (List<String>)Lists.newArrayList((Iterable<?>)BlockedServers.DOT_SPLITTER.split(server));
        final boolean isIp = isIp(parts);
        if (!isIp && isBlockedServerHostName("*." + server)) {
            return true;
        }
        while (parts.size() > 1) {
            parts.remove(isIp ? (parts.size() - 1) : 0);
            final String starredPart = isIp ? (BlockedServers.DOT_JOINER.join(parts) + ".*") : ("*." + BlockedServers.DOT_JOINER.join(parts));
            if (isBlockedServerHostName(starredPart)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean isIp(final List<String> address) {
        if (address.size() != 4) {
            return false;
        }
        for (final String s : address) {
            try {
                final int part = Integer.parseInt(s);
                if (part < 0 || part > 255) {
                    return false;
                }
                continue;
            }
            catch (NumberFormatException ignored) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isBlockedServerHostName(final String server) {
        return BlockedServers.BLOCKED_SERVERS.contains(Hashing.sha1().hashBytes(server.toLowerCase().getBytes(BlockedServers.HASH_CHARSET)).toString());
    }
    
    static {
        BLOCKED_SERVERS = Sets.newHashSet();
        DOT_JOINER = Joiner.on('.');
        DOT_SPLITTER = Splitter.on('.');
        HASH_CHARSET = Charsets.ISO_8859_1;
        try {
            BlockedServers.BLOCKED_SERVERS.addAll(IOUtils.readLines(new URL("https://sessionserver.mojang.com/blockedservers").openConnection().getInputStream(), BlockedServers.HASH_CHARSET));
        }
        catch (IOException ex) {}
    }
}
