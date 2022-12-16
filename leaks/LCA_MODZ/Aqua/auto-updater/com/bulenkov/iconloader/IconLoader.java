// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader;

import javax.swing.JLabel;
import javax.swing.JComponent;
import java.awt.image.BufferedImageOp;
import com.bulenkov.iconloader.util.Scalr;
import java.util.LinkedHashMap;
import java.util.Collections;
import java.util.HashMap;
import com.bulenkov.iconloader.util.SoftReference;
import com.bulenkov.iconloader.util.ImageLoader;
import java.lang.ref.Reference;
import com.bulenkov.iconloader.util.ScalableIcon;
import com.bulenkov.iconloader.util.JBUI;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.awt.Composite;
import java.awt.AlphaComposite;
import com.bulenkov.iconloader.util.RetrievableIcon;
import java.awt.Graphics2D;
import com.bulenkov.iconloader.util.ImageUtil;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import com.bulenkov.iconloader.util.UIUtil;
import java.awt.image.ImageObserver;
import com.bulenkov.iconloader.util.ConcurrencyUtil;
import java.util.List;
import com.bulenkov.iconloader.util.StringUtil;
import org.jetbrains.annotations.Nullable;
import java.lang.reflect.Field;
import com.bulenkov.iconloader.util.ReflectionUtil;
import org.jetbrains.annotations.NonNls;
import com.bulenkov.iconloader.util.Registry;
import com.bulenkov.iconloader.util.JBImageIcon;
import org.jetbrains.annotations.NotNull;
import java.awt.Image;
import java.awt.Component;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.ImageIcon;
import java.awt.image.ImageFilter;
import javax.swing.Icon;
import java.util.Map;
import java.net.URL;
import java.util.concurrent.ConcurrentMap;

public final class IconLoader
{
    public static boolean STRICT;
    private static boolean USE_DARK_ICONS;
    private static final ConcurrentMap<URL, CachedImageIcon> ourIconsCache;
    private static final Map<Icon, Icon> ourIcon2DisabledIcon;
    private static float SCALE;
    private static ImageFilter IMAGE_FILTER;
    private static final ImageIcon EMPTY_ICON;
    private static AtomicBoolean ourIsActivated;
    private static AtomicBoolean ourIsSaveRealIconPath;
    public static final Component ourComponent;
    
    private IconLoader() {
    }
    
    @Deprecated
    public static Icon getIcon(@NotNull final Image image) {
        if (image == null) {
            $$$reportNull$$$0(0);
        }
        return new JBImageIcon(image);
    }
    
    public static void setUseDarkIcons(final boolean useDarkIcons) {
        IconLoader.USE_DARK_ICONS = useDarkIcons;
        clearCache();
    }
    
    public static void setScale(final float scale) {
        if (scale != IconLoader.SCALE) {
            IconLoader.SCALE = scale;
            clearCache();
        }
    }
    
    public static void setFilter(ImageFilter filter) {
        if (!Registry.is("color.blindness.icon.filter")) {
            filter = null;
        }
        if (IconLoader.IMAGE_FILTER != filter) {
            IconLoader.IMAGE_FILTER = filter;
            clearCache();
        }
    }
    
    private static void clearCache() {
        IconLoader.ourIconsCache.clear();
        IconLoader.ourIcon2DisabledIcon.clear();
    }
    
    @NotNull
    public static Icon getIcon(@NonNls @NotNull final String path) {
        if (path == null) {
            $$$reportNull$$$0(1);
        }
        final Class callerClass = ReflectionUtil.getGrandCallerClass();
        assert callerClass != null : path;
        final Icon icon = getIcon(path, callerClass);
        if (icon == null) {
            $$$reportNull$$$0(2);
        }
        return icon;
    }
    
    @Nullable
    private static Icon getReflectiveIcon(@NotNull final String path, final ClassLoader classLoader) {
        if (path == null) {
            $$$reportNull$$$0(3);
        }
        try {
            final String pckg = path.startsWith("AllIcons.") ? "com.intellij.icons." : "icons.";
            final Class cur = Class.forName(pckg + path.substring(0, path.lastIndexOf(46)).replace('.', '$'), true, classLoader);
            final Field field = cur.getField(path.substring(path.lastIndexOf(46) + 1));
            return (Icon)field.get(null);
        }
        catch (Exception e) {
            return null;
        }
    }
    
    @Nullable
    public static Icon findIcon(@NonNls @NotNull final String path) {
        if (path == null) {
            $$$reportNull$$$0(4);
        }
        final Class callerClass = ReflectionUtil.getGrandCallerClass();
        if (callerClass == null) {
            return null;
        }
        return findIcon(path, callerClass);
    }
    
    @NotNull
    public static Icon getIcon(@NotNull final String path, @NotNull final Class aClass) {
        if (path == null) {
            $$$reportNull$$$0(5);
        }
        if (aClass == null) {
            $$$reportNull$$$0(6);
        }
        final Icon icon = findIcon(path, aClass);
        if (icon == null) {
            System.err.println("Icon cannot be found in '" + path + "', aClass='" + aClass + "'");
        }
        final Icon icon2 = icon;
        if (icon2 == null) {
            $$$reportNull$$$0(7);
        }
        return icon2;
    }
    
    public static void activate() {
        IconLoader.ourIsActivated.set(true);
    }
    
    public static void disable() {
        IconLoader.ourIsActivated.set(false);
    }
    
    public static boolean isLoaderDisabled() {
        return !IconLoader.ourIsActivated.get();
    }
    
    static void enableSaveRealIconPath() {
        IconLoader.ourIsSaveRealIconPath.set(true);
    }
    
    @Nullable
    public static Icon findIcon(@NotNull final String path, @NotNull final Class aClass) {
        if (path == null) {
            $$$reportNull$$$0(8);
        }
        if (aClass == null) {
            $$$reportNull$$$0(9);
        }
        return findIcon(path, aClass, false);
    }
    
    @Nullable
    public static Icon findIcon(@NotNull final String path, @NotNull final Class aClass, final boolean computeNow) {
        if (path == null) {
            $$$reportNull$$$0(10);
        }
        if (aClass == null) {
            $$$reportNull$$$0(11);
        }
        return findIcon(path, aClass, computeNow, IconLoader.STRICT);
    }
    
    @Nullable
    public static Icon findIcon(@NotNull String path, @NotNull final Class aClass, final boolean computeNow, final boolean strict) {
        if (path == null) {
            $$$reportNull$$$0(12);
        }
        if (aClass == null) {
            $$$reportNull$$$0(13);
        }
        final String originalPath = path;
        path = patchPath(path);
        if (isReflectivePath(path)) {
            return getReflectiveIcon(path, aClass.getClassLoader());
        }
        final URL myURL = aClass.getResource(path);
        if (myURL != null) {
            final Icon icon = findIcon(myURL);
            if (icon instanceof CachedImageIcon) {
                ((CachedImageIcon)icon).myOriginalPath = originalPath;
                ((CachedImageIcon)icon).myClassLoader = aClass.getClassLoader();
            }
            return icon;
        }
        if (strict) {
            throw new RuntimeException("Can't find icon in '" + path + "' near " + aClass);
        }
        return null;
    }
    
    private static String patchPath(@NotNull final String path) {
        if (path == null) {
            $$$reportNull$$$0(14);
        }
        return path;
    }
    
    private static boolean isReflectivePath(@NotNull final String path) {
        if (path == null) {
            $$$reportNull$$$0(15);
        }
        final List<String> paths = StringUtil.split(path, ".");
        return paths.size() > 1 && paths.get(0).endsWith("Icons");
    }
    
    @Nullable
    public static Icon findIcon(final URL url) {
        return findIcon(url, true);
    }
    
    @Nullable
    public static Icon findIcon(final URL url, final boolean useCache) {
        if (url == null) {
            return null;
        }
        CachedImageIcon icon = IconLoader.ourIconsCache.get(url);
        if (icon == null) {
            icon = new CachedImageIcon(url);
            if (useCache) {
                icon = ConcurrencyUtil.cacheOrGet(IconLoader.ourIconsCache, url, icon);
            }
        }
        return icon;
    }
    
    @Nullable
    public static Icon findIcon(@NotNull String path, @NotNull final ClassLoader classLoader) {
        if (path == null) {
            $$$reportNull$$$0(16);
        }
        if (classLoader == null) {
            $$$reportNull$$$0(17);
        }
        final String originalPath = path;
        path = patchPath(path);
        if (isReflectivePath(path)) {
            return getReflectiveIcon(path, classLoader);
        }
        if (!StringUtil.startsWithChar(path, '/')) {
            return null;
        }
        final URL url = classLoader.getResource(path.substring(1));
        final Icon icon = findIcon(url);
        if (icon instanceof CachedImageIcon) {
            ((CachedImageIcon)icon).myOriginalPath = originalPath;
            ((CachedImageIcon)icon).myClassLoader = classLoader;
        }
        return icon;
    }
    
    @Nullable
    private static ImageIcon checkIcon(final Image image, @NotNull final URL url) {
        if (url == null) {
            $$$reportNull$$$0(18);
        }
        if (image == null || image.getHeight(LabelHolder.ourFakeComponent) < 1) {
            return null;
        }
        final Icon icon = getIcon(image);
        if (icon != null && !isGoodSize(icon)) {
            return IconLoader.EMPTY_ICON;
        }
        return (ImageIcon)icon;
    }
    
    public static boolean isGoodSize(@NotNull final Icon icon) {
        if (icon == null) {
            $$$reportNull$$$0(19);
        }
        return icon.getIconWidth() > 0 && icon.getIconHeight() > 0;
    }
    
    @Nullable
    public static Icon getDisabledIcon(Icon icon) {
        if (icon instanceof LazyIcon) {
            icon = ((LazyIcon)icon).getOrComputeIcon();
        }
        if (icon == null) {
            return null;
        }
        Icon disabledIcon = IconLoader.ourIcon2DisabledIcon.get(icon);
        if (disabledIcon == null) {
            if (!isGoodSize(icon)) {
                return IconLoader.EMPTY_ICON;
            }
            final int scale = UIUtil.isRetina() ? 2 : 1;
            final BufferedImage image = new BufferedImage(scale * icon.getIconWidth(), scale * icon.getIconHeight(), 2);
            final Graphics2D graphics = image.createGraphics();
            graphics.setColor(UIUtil.TRANSPARENT_COLOR);
            graphics.fillRect(0, 0, icon.getIconWidth(), icon.getIconHeight());
            graphics.scale(scale, scale);
            icon.paintIcon(LabelHolder.ourFakeComponent, graphics, 0, 0);
            graphics.dispose();
            Image img = ImageUtil.filter(image, UIUtil.getGrayFilter());
            if (UIUtil.isRetina()) {
                img = RetinaImage.createFrom(img);
            }
            disabledIcon = new JBImageIcon(img);
            IconLoader.ourIcon2DisabledIcon.put(icon, disabledIcon);
        }
        return disabledIcon;
    }
    
    public static Icon getTransparentIcon(@NotNull final Icon icon) {
        if (icon == null) {
            $$$reportNull$$$0(20);
        }
        return getTransparentIcon(icon, 0.5f);
    }
    
    public static Icon getTransparentIcon(@NotNull final Icon icon, final float alpha) {
        if (icon == null) {
            $$$reportNull$$$0(21);
        }
        return new RetrievableIcon() {
            @Nullable
            @Override
            public Icon retrieveIcon() {
                return icon;
            }
            
            @Override
            public int getIconHeight() {
                return icon.getIconHeight();
            }
            
            @Override
            public int getIconWidth() {
                return icon.getIconWidth();
            }
            
            @Override
            public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
                final Graphics2D g2 = (Graphics2D)g;
                final Composite saveComposite = g2.getComposite();
                g2.setComposite(AlphaComposite.getInstance(10, alpha));
                icon.paintIcon(c, g2, x, y);
                g2.setComposite(saveComposite);
            }
        };
    }
    
    @NotNull
    public static Icon getIconSnapshot(@NotNull final Icon icon) {
        if (icon == null) {
            $$$reportNull$$$0(22);
        }
        if (icon instanceof CachedImageIcon) {
            final ImageIcon access$200 = ((CachedImageIcon)icon).getRealIcon();
            if (access$200 == null) {
                $$$reportNull$$$0(23);
            }
            return access$200;
        }
        if (icon == null) {
            $$$reportNull$$$0(24);
        }
        return icon;
    }
    
    static {
        IconLoader.STRICT = false;
        IconLoader.USE_DARK_ICONS = UIUtil.isUnderDarcula();
        ourIconsCache = new ConcurrentHashMap<URL, CachedImageIcon>(100, 0.9f, 2);
        ourIcon2DisabledIcon = new WeakHashMap<Icon, Icon>(200);
        IconLoader.SCALE = JBUI.scale(1.0f);
        EMPTY_ICON = new ImageIcon(UIUtil.createImage(1, 1, 5)) {
            @NonNls
            @Override
            public String toString() {
                return "Empty icon " + super.toString();
            }
        };
        IconLoader.ourIsActivated = new AtomicBoolean(true);
        IconLoader.ourIsSaveRealIconPath = new AtomicBoolean(false);
        ourComponent = new Component() {};
    }
    
    private static /* synthetic */ void $$$reportNull$$$0(final int n) {
        String format = null;
        switch (n) {
            default: {
                format = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
            }
            case 2:
            case 7:
            case 23:
            case 24: {
                format = "@NotNull method %s.%s must not return null";
                break;
            }
        }
        int n2 = 0;
        switch (n) {
            default: {
                n2 = 3;
                break;
            }
            case 2:
            case 7:
            case 23:
            case 24: {
                n2 = 2;
                break;
            }
        }
        final Object[] args = new Object[n2];
        switch (n) {
            default: {
                args[0] = "image";
                break;
            }
            case 1:
            case 3:
            case 4:
            case 5:
            case 8:
            case 10:
            case 12:
            case 14:
            case 15:
            case 16: {
                args[0] = "path";
                break;
            }
            case 2:
            case 7:
            case 23:
            case 24: {
                args[0] = "com/bulenkov/iconloader/IconLoader";
                break;
            }
            case 6:
            case 9:
            case 11:
            case 13: {
                args[0] = "aClass";
                break;
            }
            case 17: {
                args[0] = "classLoader";
                break;
            }
            case 18: {
                args[0] = "url";
                break;
            }
            case 19:
            case 20:
            case 21:
            case 22: {
                args[0] = "icon";
                break;
            }
        }
        switch (n) {
            default: {
                args[1] = "com/bulenkov/iconloader/IconLoader";
                break;
            }
            case 2:
            case 7: {
                args[1] = "getIcon";
                break;
            }
            case 23:
            case 24: {
                args[1] = "getIconSnapshot";
                break;
            }
        }
        switch (n) {
            default: {
                args[2] = "getIcon";
                break;
            }
            case 2:
            case 7:
            case 23:
            case 24: {
                break;
            }
            case 3: {
                args[2] = "getReflectiveIcon";
                break;
            }
            case 4:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 16:
            case 17: {
                args[2] = "findIcon";
                break;
            }
            case 14: {
                args[2] = "patchPath";
                break;
            }
            case 15: {
                args[2] = "isReflectivePath";
                break;
            }
            case 18: {
                args[2] = "checkIcon";
                break;
            }
            case 19: {
                args[2] = "isGoodSize";
                break;
            }
            case 20:
            case 21: {
                args[2] = "getTransparentIcon";
                break;
            }
            case 22: {
                args[2] = "getIconSnapshot";
                break;
            }
        }
        final String format2 = String.format(format, args);
        RuntimeException ex = null;
        switch (n) {
            default: {
                ex = new IllegalArgumentException(format2);
                break;
            }
            case 2:
            case 7:
            case 23:
            case 24: {
                ex = new IllegalStateException(format2);
                break;
            }
        }
        throw ex;
    }
    
    public static final class CachedImageIcon implements ScalableIcon
    {
        private volatile Object myRealIcon;
        public String myOriginalPath;
        private ClassLoader myClassLoader;
        @NotNull
        private URL myUrl;
        private volatile boolean dark;
        private volatile float scale;
        private volatile int numberOfPatchers;
        private volatile ImageFilter filter;
        private final MyScaledIconsCache myScaledIconsCache;
        
        public CachedImageIcon(@NotNull final URL url) {
            if (url == null) {
                $$$reportNull$$$0(0);
            }
            this.numberOfPatchers = 0;
            this.myScaledIconsCache = new MyScaledIconsCache();
            this.myUrl = url;
            this.dark = IconLoader.USE_DARK_ICONS;
            this.scale = IconLoader.SCALE;
            this.filter = IconLoader.IMAGE_FILTER;
        }
        
        @NotNull
        private synchronized ImageIcon getRealIcon() {
            if (IconLoader.isLoaderDisabled() && (this.myRealIcon == null || this.dark != IconLoader.USE_DARK_ICONS || this.scale != IconLoader.SCALE || this.filter != IconLoader.IMAGE_FILTER)) {
                final ImageIcon access$700 = IconLoader.EMPTY_ICON;
                if (access$700 == null) {
                    $$$reportNull$$$0(1);
                }
                return access$700;
            }
            if (!this.isValid()) {
                this.myRealIcon = null;
                this.dark = IconLoader.USE_DARK_ICONS;
                this.scale = IconLoader.SCALE;
                this.filter = IconLoader.IMAGE_FILTER;
                this.myScaledIconsCache.clear();
            }
            Object realIcon = this.myRealIcon;
            if (realIcon instanceof Icon) {
                final ImageIcon imageIcon = (ImageIcon)realIcon;
                if (imageIcon == null) {
                    $$$reportNull$$$0(2);
                }
                return imageIcon;
            }
            if (realIcon instanceof Reference) {
                final ImageIcon icon = ((Reference)realIcon).get();
                if (icon != null) {
                    final ImageIcon imageIcon2 = icon;
                    if (imageIcon2 == null) {
                        $$$reportNull$$$0(3);
                    }
                    return imageIcon2;
                }
            }
            final Image image = ImageLoader.loadFromUrl(this.myUrl, true, this.filter);
            final ImageIcon icon = checkIcon(image, this.myUrl);
            if (icon != null) {
                if (icon.getIconWidth() < 50 && icon.getIconHeight() < 50) {
                    realIcon = icon;
                }
                else {
                    realIcon = new SoftReference(icon);
                }
                this.myRealIcon = realIcon;
            }
            final ImageIcon imageIcon3 = (icon == null) ? IconLoader.EMPTY_ICON : icon;
            if (imageIcon3 == null) {
                $$$reportNull$$$0(4);
            }
            return imageIcon3;
        }
        
        private boolean isValid() {
            return this.dark == IconLoader.USE_DARK_ICONS && this.scale == IconLoader.SCALE && this.filter == IconLoader.IMAGE_FILTER;
        }
        
        @Override
        public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
            this.getRealIcon().paintIcon(c, g, x, y);
        }
        
        @Override
        public int getIconWidth() {
            return this.getRealIcon().getIconWidth();
        }
        
        @Override
        public int getIconHeight() {
            return this.getRealIcon().getIconHeight();
        }
        
        @Override
        public String toString() {
            return this.myUrl.toString();
        }
        
        @Override
        public Icon scale(final float scaleFactor) {
            if (scaleFactor == 1.0f) {
                return this;
            }
            if (!this.isValid()) {
                this.getRealIcon();
            }
            final Icon icon = this.myScaledIconsCache.getScaledIcon(scaleFactor);
            if (icon != null) {
                return icon;
            }
            return this;
        }
        
        private static /* synthetic */ void $$$reportNull$$$0(final int n) {
            String format = null;
            switch (n) {
                default: {
                    format = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
                }
                case 1:
                case 2:
                case 3:
                case 4: {
                    format = "@NotNull method %s.%s must not return null";
                    break;
                }
            }
            int n2 = 0;
            switch (n) {
                default: {
                    n2 = 3;
                    break;
                }
                case 1:
                case 2:
                case 3:
                case 4: {
                    n2 = 2;
                    break;
                }
            }
            final Object[] args = new Object[n2];
            switch (n) {
                default: {
                    args[0] = "url";
                    break;
                }
                case 1:
                case 2:
                case 3:
                case 4: {
                    args[0] = "com/bulenkov/iconloader/IconLoader$CachedImageIcon";
                    break;
                }
            }
            switch (n) {
                default: {
                    args[1] = "com/bulenkov/iconloader/IconLoader$CachedImageIcon";
                    break;
                }
                case 1:
                case 2:
                case 3:
                case 4: {
                    args[1] = "getRealIcon";
                    break;
                }
            }
            switch (n) {
                default: {
                    args[2] = "<init>";
                    break;
                }
                case 1:
                case 2:
                case 3:
                case 4: {
                    break;
                }
            }
            final String format2 = String.format(format, args);
            RuntimeException ex = null;
            switch (n) {
                default: {
                    ex = new IllegalArgumentException(format2);
                    break;
                }
                case 1:
                case 2:
                case 3:
                case 4: {
                    ex = new IllegalStateException(format2);
                    break;
                }
            }
            throw ex;
        }
        
        private class MyScaledIconsCache
        {
            private Map<Boolean, SoftReference<Image>> origImagesCache;
            private static final int SCALED_ICONS_CACHE_LIMIT = 5;
            private Map<Float, SoftReference<Icon>> scaledIconsCache;
            
            private MyScaledIconsCache() {
                this.origImagesCache = Collections.synchronizedMap(new HashMap<Boolean, SoftReference<Image>>(2));
                this.scaledIconsCache = Collections.synchronizedMap((Map<Float, SoftReference<Icon>>)new LinkedHashMap<Float, SoftReference<Icon>>(5) {
                    public boolean removeEldestEntry(final Map.Entry<Float, SoftReference<Icon>> entry) {
                        return this.size() > 5;
                    }
                });
            }
            
            public Image getOrigImage(final boolean retina) {
                Image img = SoftReference.dereference(this.origImagesCache.get(retina));
                if (img == null) {
                    img = ImageLoader.loadFromUrl(CachedImageIcon.this.myUrl, UIUtil.isUnderDarcula(), retina, CachedImageIcon.this.filter);
                    this.origImagesCache.put(retina, new SoftReference<Image>(img));
                }
                return img;
            }
            
            public Icon getScaledIcon(final float scale) {
                final float effectiveScale = scale * JBUI.scale(1.0f);
                Icon icon = SoftReference.dereference(this.scaledIconsCache.get(effectiveScale));
                if (icon == null) {
                    final boolean needRetinaImage = effectiveScale >= 1.5f || UIUtil.isRetina();
                    final Image image = this.getOrigImage(needRetinaImage);
                    if (image != null) {
                        final Image iconImage = CachedImageIcon.this.getRealIcon().getImage();
                        final int width = (int)(ImageUtil.getRealWidth(iconImage) * scale);
                        final int height = (int)(ImageUtil.getRealHeight(iconImage) * scale);
                        Image resizedImage = Scalr.resize(ImageUtil.toBufferedImage(image), Scalr.Method.ULTRA_QUALITY, width, height, new BufferedImageOp[0]);
                        if (UIUtil.isRetina()) {
                            resizedImage = RetinaImage.createFrom(resizedImage);
                        }
                        icon = IconLoader.getIcon(resizedImage);
                        this.scaledIconsCache.put(effectiveScale, new SoftReference<Icon>(icon));
                    }
                }
                return icon;
            }
            
            public void clear() {
                this.scaledIconsCache.clear();
                this.origImagesCache.clear();
            }
        }
    }
    
    public abstract static class LazyIcon implements Icon
    {
        private boolean myWasComputed;
        private Icon myIcon;
        private boolean isDarkVariant;
        private float scale;
        private ImageFilter filter;
        
        public LazyIcon() {
            this.isDarkVariant = IconLoader.USE_DARK_ICONS;
            this.scale = IconLoader.SCALE;
            this.filter = IconLoader.IMAGE_FILTER;
        }
        
        @Override
        public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
            final Icon icon = this.getOrComputeIcon();
            if (icon != null) {
                icon.paintIcon(c, g, x, y);
            }
        }
        
        @Override
        public int getIconWidth() {
            final Icon icon = this.getOrComputeIcon();
            return (icon != null) ? icon.getIconWidth() : 0;
        }
        
        @Override
        public int getIconHeight() {
            final Icon icon = this.getOrComputeIcon();
            return (icon != null) ? icon.getIconHeight() : 0;
        }
        
        protected final synchronized Icon getOrComputeIcon() {
            if (!this.myWasComputed || this.isDarkVariant != IconLoader.USE_DARK_ICONS || this.scale != IconLoader.SCALE || this.filter != IconLoader.IMAGE_FILTER) {
                this.isDarkVariant = IconLoader.USE_DARK_ICONS;
                this.scale = IconLoader.SCALE;
                this.filter = IconLoader.IMAGE_FILTER;
                this.myWasComputed = true;
                this.myIcon = this.compute();
            }
            return this.myIcon;
        }
        
        public final void load() {
            this.getIconWidth();
        }
        
        protected abstract Icon compute();
    }
    
    private static class LabelHolder
    {
        private static final JComponent ourFakeComponent;
        
        static {
            ourFakeComponent = new JLabel();
        }
    }
}
