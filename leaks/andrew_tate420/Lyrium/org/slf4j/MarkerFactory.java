// 
// Decompiled by Procyon v0.5.36
// 

package org.slf4j;

import org.slf4j.spi.SLF4JServiceProvider;
import org.slf4j.helpers.BasicMarkerFactory;
import org.slf4j.helpers.Util;

public class MarkerFactory
{
    static IMarkerFactory MARKER_FACTORY;
    
    private MarkerFactory() {
    }
    
    public static Marker getMarker(final String name) {
        return MarkerFactory.MARKER_FACTORY.getMarker(name);
    }
    
    public static Marker getDetachedMarker(final String name) {
        return MarkerFactory.MARKER_FACTORY.getDetachedMarker(name);
    }
    
    public static IMarkerFactory getIMarkerFactory() {
        return MarkerFactory.MARKER_FACTORY;
    }
    
    static {
        final SLF4JServiceProvider provider = LoggerFactory.getProvider();
        if (provider != null) {
            MarkerFactory.MARKER_FACTORY = provider.getMarkerFactory();
        }
        else {
            Util.report("Failed to find provider");
            Util.report("Defaulting to BasicMarkerFactory.");
            MarkerFactory.MARKER_FACTORY = new BasicMarkerFactory();
        }
    }
}
