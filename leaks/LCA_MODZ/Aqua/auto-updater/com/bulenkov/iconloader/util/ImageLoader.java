// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import com.bulenkov.iconloader.RetinaImage;
import java.util.Iterator;
import java.io.IOException;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import com.bulenkov.iconloader.IconLoader;
import javax.swing.Icon;
import java.awt.Toolkit;
import java.io.InputStream;
import org.jetbrains.annotations.NonNls;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageFilter;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import java.net.URL;
import java.awt.MediaTracker;
import java.awt.image.ImageObserver;
import java.awt.Component;
import java.awt.Image;
import java.util.concurrent.ConcurrentMap;
import java.io.Serializable;

public class ImageLoader implements Serializable
{
    private static final ConcurrentMap<String, Image> ourCache;
    public static final Component ourComponent;
    
    private static boolean waitForImage(final Image image) {
        if (image == null) {
            return false;
        }
        if (image.getWidth(null) > 0) {
            return true;
        }
        final MediaTracker mediatracker = new MediaTracker(ImageLoader.ourComponent);
        mediatracker.addImage(image, 1);
        try {
            mediatracker.waitForID(1, 5000L);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return !mediatracker.isErrorID(1);
    }
    
    @Nullable
    public static Image loadFromUrl(@NotNull final URL url) {
        if (url == null) {
            $$$reportNull$$$0(0);
        }
        return loadFromUrl(url, true);
    }
    
    @Nullable
    public static Image loadFromUrl(@NotNull final URL url, final boolean allowFloatScaling) {
        if (url == null) {
            $$$reportNull$$$0(1);
        }
        return loadFromUrl(url, allowFloatScaling, null);
    }
    
    @Nullable
    public static Image loadFromUrl(@NotNull final URL url, final boolean allowFloatScaling, final ImageFilter filter) {
        if (url == null) {
            $$$reportNull$$$0(2);
        }
        final float scaleFactor = calcScaleFactor(allowFloatScaling);
        final boolean scaleImages = scaleFactor > 1.0f && !UIUtil.isRetina();
        final boolean loadRetinaImages = UIUtil.isRetina() || scaleImages;
        return ImageDescList.create(url.toString(), null, UIUtil.isUnderDarcula(), loadRetinaImages, allowFloatScaling).load(ImageConverterChain.create().withFilter(filter).withRetina().with(new ImageConverter() {
            @Override
            public Image convert(final Image source, final ImageDesc desc) {
                if (source == null || !scaleImages) {
                    return source;
                }
                if (desc.path.contains("@2x")) {
                    return scaleImage(source, scaleFactor / 2.0f);
                }
                return scaleImage(source, scaleFactor);
            }
        }));
    }
    
    private static float calcScaleFactor(final boolean allowFloatScaling) {
        final float scaleFactor = allowFloatScaling ? JBUI.scale(1.0f) : ((JBUI.scale(1.0f) > 1.5f) ? 2.0f : 1.0f);
        assert scaleFactor >= 1.0f : "By design, only scale factors >= 1.0 are supported";
        return scaleFactor;
    }
    
    @NotNull
    private static Image scaleImage(final Image image, final float scale) {
        final int w = image.getWidth(null);
        final int h = image.getHeight(null);
        if (w <= 0 || h <= 0) {
            if (image == null) {
                $$$reportNull$$$0(3);
            }
            return image;
        }
        final int width = (int)(scale * w);
        final int height = (int)(scale * h);
        final BufferedImage resize = Scalr.resize(ImageUtil.toBufferedImage(image), Scalr.Method.QUALITY, width, height, new BufferedImageOp[0]);
        if (resize == null) {
            $$$reportNull$$$0(4);
        }
        return resize;
    }
    
    @Nullable
    public static Image loadFromUrl(final URL url, final boolean dark, final boolean retina) {
        return loadFromUrl(url, dark, retina, null);
    }
    
    @Nullable
    public static Image loadFromUrl(final URL url, final boolean dark, final boolean retina, final ImageFilter filter) {
        return ImageDescList.create(url.toString(), null, dark, retina, true).load(ImageConverterChain.create().withFilter(filter).withRetina());
    }
    
    @Nullable
    public static Image loadFromResource(@NonNls @NotNull final String s) {
        if (s == null) {
            $$$reportNull$$$0(5);
        }
        final Class callerClass = ReflectionUtil.getGrandCallerClass();
        if (callerClass == null) {
            return null;
        }
        return loadFromResource(s, callerClass);
    }
    
    @Nullable
    public static Image loadFromResource(@NonNls @NotNull final String path, @NotNull final Class aClass) {
        if (path == null) {
            $$$reportNull$$$0(6);
        }
        if (aClass == null) {
            $$$reportNull$$$0(7);
        }
        return ImageDescList.create(path, aClass, UIUtil.isUnderDarcula(), UIUtil.isRetina() || JBUI.scale(1.0f) >= 1.5f, true).load(ImageConverterChain.create().withRetina());
    }
    
    public static Image loadFromStream(@NotNull final InputStream inputStream) {
        if (inputStream == null) {
            $$$reportNull$$$0(8);
        }
        return loadFromStream(inputStream, 1);
    }
    
    public static Image loadFromStream(@NotNull final InputStream inputStream, final int scale) {
        if (inputStream == null) {
            $$$reportNull$$$0(9);
        }
        return loadFromStream(inputStream, scale, null);
    }
    
    public static Image loadFromStream(@NotNull final InputStream inputStream, final int scale, final ImageFilter filter) {
        if (inputStream == null) {
            $$$reportNull$$$0(10);
        }
        final Image image = load(inputStream, scale);
        final ImageDesc desc = new ImageDesc("", null, (float)scale, ImageDesc.Type.UNDEFINED);
        return ImageConverterChain.create().withFilter(filter).withRetina().convert(image, desc);
    }
    
    private static Image load(@NotNull final InputStream inputStream, final int scale) {
        if (inputStream == null) {
            $$$reportNull$$$0(11);
        }
        if (scale <= 0) {
            throw new IllegalArgumentException("Scale must be 1 or greater");
        }
        try {
            final BufferExposingByteArrayOutputStream outputStream = new BufferExposingByteArrayOutputStream();
            try {
                final byte[] buffer = new byte[1024];
                while (true) {
                    final int n = inputStream.read(buffer);
                    if (n < 0) {
                        break;
                    }
                    outputStream.write(buffer, 0, n);
                }
            }
            finally {
                inputStream.close();
            }
            final Image image = Toolkit.getDefaultToolkit().createImage(outputStream.getInternalBuffer(), 0, outputStream.size());
            waitForImage(image);
            return image;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static boolean isGoodSize(final Icon icon) {
        return IconLoader.isGoodSize(icon);
    }
    
    @Deprecated
    public static List<Pair<String, Integer>> getFileNames(@NotNull final String file) {
        if (file == null) {
            $$$reportNull$$$0(12);
        }
        return getFileNames(file, false, false);
    }
    
    @Deprecated
    public static List<Pair<String, Integer>> getFileNames(@NotNull final String file, final boolean dark, final boolean retina) {
        if (file == null) {
            $$$reportNull$$$0(13);
        }
        new UnsupportedOperationException("unsupported method").printStackTrace();
        return new ArrayList<Pair<String, Integer>>();
    }
    
    @NotNull
    public static String getNameWithoutExtension(@NotNull String name) {
        if (name == null) {
            $$$reportNull$$$0(14);
        }
        final int i = name.lastIndexOf(46);
        if (i != -1) {
            name = name.substring(0, i);
        }
        final String s = name;
        if (s == null) {
            $$$reportNull$$$0(15);
        }
        return s;
    }
    
    @NotNull
    public static String getExtension(@NotNull final String fileName) {
        if (fileName == null) {
            $$$reportNull$$$0(16);
        }
        final int index = fileName.lastIndexOf(46);
        if (index < 0) {
            final String s = "";
            if (s == null) {
                $$$reportNull$$$0(17);
            }
            return s;
        }
        final String substring = fileName.substring(index + 1);
        if (substring == null) {
            $$$reportNull$$$0(18);
        }
        return substring;
    }
    
    static {
        ourCache = new ConcurrentSoftValueHashMap<String, Image>();
        ourComponent = new Component() {};
    }
    
    private static /* synthetic */ void $$$reportNull$$$0(final int n) {
        String format = null;
        switch (n) {
            default: {
                format = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
            }
            case 3:
            case 4:
            case 15:
            case 17:
            case 18: {
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
            case 3:
            case 4:
            case 15:
            case 17:
            case 18: {
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
            case 3:
            case 4:
            case 15:
            case 17:
            case 18: {
                args[0] = "com/bulenkov/iconloader/util/ImageLoader";
                break;
            }
            case 5: {
                args[0] = "s";
                break;
            }
            case 6: {
                args[0] = "path";
                break;
            }
            case 7: {
                args[0] = "aClass";
                break;
            }
            case 8:
            case 9:
            case 10:
            case 11: {
                args[0] = "inputStream";
                break;
            }
            case 12:
            case 13: {
                args[0] = "file";
                break;
            }
            case 14: {
                args[0] = "name";
                break;
            }
            case 16: {
                args[0] = "fileName";
                break;
            }
        }
        switch (n) {
            default: {
                args[1] = "com/bulenkov/iconloader/util/ImageLoader";
                break;
            }
            case 3:
            case 4: {
                args[1] = "scaleImage";
                break;
            }
            case 15: {
                args[1] = "getNameWithoutExtension";
                break;
            }
            case 17:
            case 18: {
                args[1] = "getExtension";
                break;
            }
        }
        switch (n) {
            default: {
                args[2] = "loadFromUrl";
                break;
            }
            case 3:
            case 4:
            case 15:
            case 17:
            case 18: {
                break;
            }
            case 5:
            case 6:
            case 7: {
                args[2] = "loadFromResource";
                break;
            }
            case 8:
            case 9:
            case 10: {
                args[2] = "loadFromStream";
                break;
            }
            case 11: {
                args[2] = "load";
                break;
            }
            case 12:
            case 13: {
                args[2] = "getFileNames";
                break;
            }
            case 14: {
                args[2] = "getNameWithoutExtension";
                break;
            }
            case 16: {
                args[2] = "getExtension";
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
            case 3:
            case 4:
            case 15:
            case 17:
            case 18: {
                ex = new IllegalStateException(format2);
                break;
            }
        }
        throw ex;
    }
    
    private static class ImageDesc
    {
        public final String path;
        @Nullable
        public final Class cls;
        public final float scale;
        public final Type type;
        public final boolean original;
        
        public ImageDesc(final String path, final Class cls, final float scale, final Type type) {
            this(path, cls, scale, type, false);
        }
        
        public ImageDesc(final String path, final Class cls, final float scale, final Type type, final boolean original) {
            this.path = path;
            this.cls = cls;
            this.scale = scale;
            this.type = type;
            this.original = original;
        }
        
        @Nullable
        public Image load() throws IOException {
            String cacheKey = null;
            InputStream stream = null;
            URL url = null;
            if (this.cls != null) {
                stream = this.cls.getResourceAsStream(this.path);
                if (stream == null) {
                    return null;
                }
            }
            if (stream == null) {
                url = new URL(this.path);
                final URLConnection connection = url.openConnection();
                if (connection instanceof HttpURLConnection) {
                    if (!this.original) {
                        return null;
                    }
                    connection.addRequestProperty("User-Agent", "IntelliJ");
                    cacheKey = this.path;
                    final Image image = (Image)ImageLoader.ourCache.get(cacheKey);
                    if (image != null) {
                        return image;
                    }
                }
                stream = connection.getInputStream();
            }
            final Image image2 = this.type.load(url, stream, this.scale);
            if (image2 != null && cacheKey != null) {
                ImageLoader.ourCache.put(cacheKey, image2);
            }
            return image2;
        }
        
        @Override
        public String toString() {
            return this.path + ", scale: " + this.scale + ", type: " + this.type;
        }
        
        public enum Type
        {
            PNG, 
            UNDEFINED;
            
            public Image load(final URL url, final InputStream stream, final float scale) throws IOException {
                return load(stream, (int)scale);
            }
        }
    }
    
    private static class ImageDescList extends ArrayList<ImageDesc>
    {
        @Nullable
        public Image load() {
            return this.load(ImageConverterChain.create());
        }
        
        @Nullable
        public Image load(@NotNull final ImageConverterChain converters) {
            if (converters == null) {
                $$$reportNull$$$0(0);
            }
            for (final ImageDesc desc : this) {
                try {
                    final Image image = desc.load();
                    if (image == null) {
                        continue;
                    }
                    return converters.convert(image, desc);
                }
                catch (IOException ex) {
                    continue;
                }
                break;
            }
            return null;
        }
        
        public static ImageDescList create(@NotNull final String file, @Nullable final Class cls, final boolean dark, final boolean retina, final boolean allowFloatScaling) {
            if (file == null) {
                $$$reportNull$$$0(1);
            }
            final ImageDescList vars = new ImageDescList();
            if (retina || dark) {
                final String name = ImageLoader.getNameWithoutExtension(file);
                final String ext = ImageLoader.getExtension(file);
                final float scale = calcScaleFactor(allowFloatScaling);
                if (dark && retina) {
                    vars.add(new ImageDesc(name + "@2x_dark." + ext, cls, 2.0f, ImageDesc.Type.PNG));
                }
                if (dark) {
                    vars.add(new ImageDesc(name + "_dark." + ext, cls, 1.0f, ImageDesc.Type.PNG));
                }
                if (retina) {
                    vars.add(new ImageDesc(name + "@2x." + ext, cls, 2.0f, ImageDesc.Type.PNG));
                }
            }
            vars.add(new ImageDesc(file, cls, 1.0f, ImageDesc.Type.PNG, true));
            return vars;
        }
        
        private static /* synthetic */ void $$$reportNull$$$0(final int n) {
            final String format = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            final Object[] args = new Object[3];
            switch (n) {
                default: {
                    args[0] = "converters";
                    break;
                }
                case 1: {
                    args[0] = "file";
                    break;
                }
            }
            args[1] = "com/bulenkov/iconloader/util/ImageLoader$ImageDescList";
            switch (n) {
                default: {
                    args[2] = "load";
                    break;
                }
                case 1: {
                    args[2] = "create";
                    break;
                }
            }
            throw new IllegalArgumentException(String.format(format, args));
        }
    }
    
    private static class ImageConverterChain extends ArrayList<ImageConverter>
    {
        public static ImageConverterChain create() {
            return new ImageConverterChain();
        }
        
        public ImageConverterChain withFilter(final ImageFilter filter) {
            return this.with(new ImageConverter() {
                @Override
                public Image convert(final Image source, final ImageDesc desc) {
                    return ImageUtil.filter(source, filter);
                }
            });
        }
        
        public ImageConverterChain withRetina() {
            return this.with(new ImageConverter() {
                @Override
                public Image convert(final Image source, final ImageDesc desc) {
                    if (source != null && UIUtil.isRetina() && desc.scale > 1.0f) {
                        return RetinaImage.createFrom(source, (int)desc.scale, ImageLoader.ourComponent);
                    }
                    return source;
                }
            });
        }
        
        public ImageConverterChain with(final ImageConverter f) {
            this.add(f);
            return this;
        }
        
        public Image convert(Image image, final ImageDesc desc) {
            for (final ImageConverter f : this) {
                image = f.convert(image, desc);
            }
            return image;
        }
    }
    
    private interface ImageConverter
    {
        Image convert(@Nullable final Image p0, final ImageDesc p1);
    }
}
