// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import java.awt.color.ColorSpace;
import java.awt.image.Kernel;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImagingOpException;
import java.awt.image.BufferedImageOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.RescaleOp;
import java.awt.image.ConvolveOp;

public class Scalr
{
    public static final String DEBUG_PROPERTY_NAME = "imgscalr.debug";
    public static final String LOG_PREFIX_PROPERTY_NAME = "imgscalr.logPrefix";
    public static final boolean DEBUG;
    public static final String LOG_PREFIX;
    public static final ConvolveOp OP_ANTIALIAS;
    public static final RescaleOp OP_DARKER;
    public static final RescaleOp OP_BRIGHTER;
    public static final ColorConvertOp OP_GRAYSCALE;
    public static final int THRESHOLD_BALANCED_SPEED = 1600;
    public static final int THRESHOLD_QUALITY_BALANCED = 800;
    
    public static BufferedImage apply(BufferedImage src, final BufferedImageOp... ops) throws IllegalArgumentException, ImagingOpException {
        final long t = System.currentTimeMillis();
        if (src == null) {
            throw new IllegalArgumentException("src cannot be null");
        }
        if (ops == null || ops.length == 0) {
            throw new IllegalArgumentException("ops cannot be null or empty");
        }
        final int type = src.getType();
        if (type != 1 && type != 2) {
            src = copyToOptimalImage(src);
        }
        if (Scalr.DEBUG) {
            log(0, "Applying %d BufferedImageOps...", ops.length);
        }
        boolean hasReassignedSrc = false;
        for (int i = 0; i < ops.length; ++i) {
            final long subT = System.currentTimeMillis();
            final BufferedImageOp op = ops[i];
            if (op != null) {
                if (Scalr.DEBUG) {
                    log(1, "Applying BufferedImageOp [class=%s, toString=%s]...", op.getClass(), op.toString());
                }
                final Rectangle2D resultBounds = op.getBounds2D(src);
                if (resultBounds == null) {
                    throw new ImagingOpException("BufferedImageOp [" + op.toString() + "] getBounds2D(src) returned null bounds for the target image; this should not happen and indicates a problem with application of this type of op.");
                }
                final BufferedImage dest = createOptimalImage(src, (int)Math.round(resultBounds.getWidth()), (int)Math.round(resultBounds.getHeight()));
                final BufferedImage result = op.filter(src, dest);
                if (hasReassignedSrc) {
                    src.flush();
                }
                src = result;
                hasReassignedSrc = true;
                if (Scalr.DEBUG) {
                    log(1, "Applied BufferedImageOp in %d ms, result [width=%d, height=%d]", System.currentTimeMillis() - subT, result.getWidth(), result.getHeight());
                }
            }
        }
        if (Scalr.DEBUG) {
            log(0, "All %d BufferedImageOps applied in %d ms", ops.length, System.currentTimeMillis() - t);
        }
        return src;
    }
    
    public static BufferedImage crop(final BufferedImage src, final int width, final int height, final BufferedImageOp... ops) throws IllegalArgumentException, ImagingOpException {
        return crop(src, 0, 0, width, height, ops);
    }
    
    public static BufferedImage crop(final BufferedImage src, final int x, final int y, final int width, final int height, final BufferedImageOp... ops) throws IllegalArgumentException, ImagingOpException {
        final long t = System.currentTimeMillis();
        if (src == null) {
            throw new IllegalArgumentException("src cannot be null");
        }
        if (x < 0 || y < 0 || width < 0 || height < 0) {
            throw new IllegalArgumentException("Invalid crop bounds: x [" + x + "], y [" + y + "], width [" + width + "] and height [" + height + "] must all be >= 0");
        }
        final int srcWidth = src.getWidth();
        final int srcHeight = src.getHeight();
        if (x + width > srcWidth) {
            throw new IllegalArgumentException("Invalid crop bounds: x + width [" + (x + width) + "] must be <= src.getWidth() [" + srcWidth + "]");
        }
        if (y + height > srcHeight) {
            throw new IllegalArgumentException("Invalid crop bounds: y + height [" + (y + height) + "] must be <= src.getHeight() [" + srcHeight + "]");
        }
        if (Scalr.DEBUG) {
            log(0, "Cropping Image [width=%d, height=%d] to [x=%d, y=%d, width=%d, height=%d]...", srcWidth, srcHeight, x, y, width, height);
        }
        BufferedImage result = createOptimalImage(src, width, height);
        final Graphics g = result.getGraphics();
        g.drawImage(src, 0, 0, width, height, x, y, x + width, y + height, null);
        g.dispose();
        if (Scalr.DEBUG) {
            log(0, "Cropped Image in %d ms", System.currentTimeMillis() - t);
        }
        if (ops != null && ops.length > 0) {
            result = apply(result, ops);
        }
        return result;
    }
    
    public static BufferedImage pad(final BufferedImage src, final int padding, final BufferedImageOp... ops) throws IllegalArgumentException, ImagingOpException {
        return pad(src, padding, Color.BLACK, new BufferedImageOp[0]);
    }
    
    public static BufferedImage pad(final BufferedImage src, final int padding, final Color color, final BufferedImageOp... ops) throws IllegalArgumentException, ImagingOpException {
        final long t = System.currentTimeMillis();
        if (src == null) {
            throw new IllegalArgumentException("src cannot be null");
        }
        if (padding < 1) {
            throw new IllegalArgumentException("padding [" + padding + "] must be > 0");
        }
        if (color == null) {
            throw new IllegalArgumentException("color cannot be null");
        }
        final int srcWidth = src.getWidth();
        final int srcHeight = src.getHeight();
        final int sizeDiff = padding * 2;
        final int newWidth = srcWidth + sizeDiff;
        final int newHeight = srcHeight + sizeDiff;
        if (Scalr.DEBUG) {
            log(0, "Padding Image from [originalWidth=%d, originalHeight=%d, padding=%d] to [newWidth=%d, newHeight=%d]...", srcWidth, srcHeight, padding, newWidth, newHeight);
        }
        final boolean colorHasAlpha = color.getAlpha() != 255;
        final boolean imageHasAlpha = src.getTransparency() != 1;
        BufferedImage result;
        if (colorHasAlpha || imageHasAlpha) {
            if (Scalr.DEBUG) {
                log(1, "Transparency FOUND in source image or color, using ARGB image type...", new Object[0]);
            }
            result = new BufferedImage(newWidth, newHeight, 2);
        }
        else {
            if (Scalr.DEBUG) {
                log(1, "Transparency NOT FOUND in source image or color, using RGB image type...", new Object[0]);
            }
            result = new BufferedImage(newWidth, newHeight, 1);
        }
        final Graphics g = result.getGraphics();
        g.setColor(color);
        g.fillRect(0, 0, newWidth, newHeight);
        g.drawImage(src, padding, padding, null);
        g.dispose();
        if (Scalr.DEBUG) {
            log(0, "Padding Applied in %d ms", System.currentTimeMillis() - t);
        }
        if (ops != null && ops.length > 0) {
            result = apply(result, ops);
        }
        return result;
    }
    
    public static BufferedImage resize(final BufferedImage src, final int targetSize, final BufferedImageOp... ops) throws IllegalArgumentException, ImagingOpException {
        return resize(src, Method.AUTOMATIC, Mode.AUTOMATIC, targetSize, targetSize, ops);
    }
    
    public static BufferedImage resize(final BufferedImage src, final Method scalingMethod, final int targetSize, final BufferedImageOp... ops) throws IllegalArgumentException, ImagingOpException {
        return resize(src, scalingMethod, Mode.AUTOMATIC, targetSize, targetSize, ops);
    }
    
    public static BufferedImage resize(final BufferedImage src, final Mode resizeMode, final int targetSize, final BufferedImageOp... ops) throws IllegalArgumentException, ImagingOpException {
        return resize(src, Method.AUTOMATIC, resizeMode, targetSize, targetSize, ops);
    }
    
    public static BufferedImage resize(final BufferedImage src, final Method scalingMethod, final Mode resizeMode, final int targetSize, final BufferedImageOp... ops) throws IllegalArgumentException, ImagingOpException {
        return resize(src, scalingMethod, resizeMode, targetSize, targetSize, ops);
    }
    
    public static BufferedImage resize(final BufferedImage src, final int targetWidth, final int targetHeight, final BufferedImageOp... ops) throws IllegalArgumentException, ImagingOpException {
        return resize(src, Method.AUTOMATIC, Mode.AUTOMATIC, targetWidth, targetHeight, ops);
    }
    
    public static BufferedImage resize(final BufferedImage src, final Method scalingMethod, final int targetWidth, final int targetHeight, final BufferedImageOp... ops) {
        return resize(src, scalingMethod, Mode.AUTOMATIC, targetWidth, targetHeight, ops);
    }
    
    public static BufferedImage resize(final BufferedImage src, final Mode resizeMode, final int targetWidth, final int targetHeight, final BufferedImageOp... ops) throws IllegalArgumentException, ImagingOpException {
        return resize(src, Method.AUTOMATIC, resizeMode, targetWidth, targetHeight, ops);
    }
    
    public static BufferedImage resize(final BufferedImage src, Method scalingMethod, final Mode resizeMode, int targetWidth, int targetHeight, final BufferedImageOp... ops) throws IllegalArgumentException, ImagingOpException {
        final long t = System.currentTimeMillis();
        if (src == null) {
            throw new IllegalArgumentException("src cannot be null");
        }
        if (targetWidth < 0) {
            throw new IllegalArgumentException("targetWidth must be >= 0");
        }
        if (targetHeight < 0) {
            throw new IllegalArgumentException("targetHeight must be >= 0");
        }
        if (scalingMethod == null) {
            throw new IllegalArgumentException("scalingMethod cannot be null. A good default value is Method.AUTOMATIC.");
        }
        if (resizeMode == null) {
            throw new IllegalArgumentException("resizeMode cannot be null. A good default value is Mode.AUTOMATIC.");
        }
        BufferedImage result = null;
        final int currentWidth = src.getWidth();
        final int currentHeight = src.getHeight();
        final float ratio = currentHeight / (float)currentWidth;
        if (Scalr.DEBUG) {
            log(0, "Resizing Image [size=%dx%d, resizeMode=%s, orientation=%s, ratio(H/W)=%f] to [targetSize=%dx%d]", currentWidth, currentHeight, resizeMode, (ratio <= 1.0f) ? "Landscape/Square" : "Portrait", ratio, targetWidth, targetHeight);
        }
        if (resizeMode != Mode.FIT_EXACT) {
            if ((ratio <= 1.0f && resizeMode == Mode.AUTOMATIC) || resizeMode == Mode.FIT_TO_WIDTH) {
                if (targetWidth == src.getWidth()) {
                    return src;
                }
                final int originalTargetHeight = targetHeight;
                targetHeight = Math.round(targetWidth * ratio);
                if (Scalr.DEBUG && originalTargetHeight != targetHeight) {
                    log(1, "Auto-Corrected targetHeight [from=%d to=%d] to honor image proportions.", originalTargetHeight, targetHeight);
                }
            }
            else {
                if (targetHeight == src.getHeight()) {
                    return src;
                }
                final int originalTargetWidth = targetWidth;
                targetWidth = Math.round(targetHeight / ratio);
                if (Scalr.DEBUG && originalTargetWidth != targetWidth) {
                    log(1, "Auto-Corrected targetWidth [from=%d to=%d] to honor image proportions.", originalTargetWidth, targetWidth);
                }
            }
        }
        else if (Scalr.DEBUG) {
            log(1, "Resize Mode FIT_EXACT used, no width/height checking or re-calculation will be done.", new Object[0]);
        }
        if (scalingMethod == Method.AUTOMATIC) {
            scalingMethod = determineScalingMethod(targetWidth, targetHeight, ratio);
        }
        if (Scalr.DEBUG) {
            log(1, "Using Scaling Method: %s", scalingMethod);
        }
        if (scalingMethod == Method.SPEED) {
            result = scaleImage(src, targetWidth, targetHeight, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        }
        else if (scalingMethod == Method.BALANCED) {
            result = scaleImage(src, targetWidth, targetHeight, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        }
        else if (scalingMethod == Method.QUALITY || scalingMethod == Method.ULTRA_QUALITY) {
            if (targetWidth > currentWidth || targetHeight > currentHeight) {
                if (Scalr.DEBUG) {
                    log(1, "QUALITY scale-up, a single BICUBIC scale operation will be used...", new Object[0]);
                }
                result = scaleImage(src, targetWidth, targetHeight, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            }
            else {
                if (Scalr.DEBUG) {
                    log(1, "QUALITY scale-down, incremental scaling will be used...", new Object[0]);
                }
                result = scaleImageIncrementally(src, targetWidth, targetHeight, scalingMethod, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            }
        }
        if (Scalr.DEBUG) {
            log(0, "Resized Image in %d ms", System.currentTimeMillis() - t);
        }
        if (ops != null && ops.length > 0) {
            result = apply(result, ops);
        }
        return result;
    }
    
    public static BufferedImage rotate(final BufferedImage src, final Rotation rotation, final BufferedImageOp... ops) throws IllegalArgumentException, ImagingOpException {
        final long t = System.currentTimeMillis();
        if (src == null) {
            throw new IllegalArgumentException("src cannot be null");
        }
        if (rotation == null) {
            throw new IllegalArgumentException("rotation cannot be null");
        }
        if (Scalr.DEBUG) {
            log(0, "Rotating Image [%s]...", rotation);
        }
        int newWidth = src.getWidth();
        int newHeight = src.getHeight();
        final AffineTransform tx = new AffineTransform();
        switch (rotation) {
            case CW_90: {
                newWidth = src.getHeight();
                newHeight = src.getWidth();
                tx.translate(newWidth, 0.0);
                tx.rotate(Math.toRadians(90.0));
                break;
            }
            case CW_270: {
                newWidth = src.getHeight();
                newHeight = src.getWidth();
                tx.translate(0.0, newHeight);
                tx.rotate(Math.toRadians(-90.0));
                break;
            }
            case CW_180: {
                tx.translate(newWidth, newHeight);
                tx.rotate(Math.toRadians(180.0));
                break;
            }
            case FLIP_HORZ: {
                tx.translate(newWidth, 0.0);
                tx.scale(-1.0, 1.0);
                break;
            }
            case FLIP_VERT: {
                tx.translate(0.0, newHeight);
                tx.scale(1.0, -1.0);
                break;
            }
        }
        BufferedImage result = createOptimalImage(src, newWidth, newHeight);
        final Graphics2D g2d = result.createGraphics();
        g2d.drawImage(src, tx, null);
        g2d.dispose();
        if (Scalr.DEBUG) {
            log(0, "Rotation Applied in %d ms, result [width=%d, height=%d]", System.currentTimeMillis() - t, result.getWidth(), result.getHeight());
        }
        if (ops != null && ops.length > 0) {
            result = apply(result, ops);
        }
        return result;
    }
    
    protected static void log(final int depth, final String message, final Object... params) {
        if (Scalr.DEBUG) {
            System.out.print(Scalr.LOG_PREFIX);
            for (int i = 0; i < depth; ++i) {
                System.out.print("\t");
            }
            System.out.printf(message, params);
            System.out.println();
        }
    }
    
    protected static BufferedImage createOptimalImage(final BufferedImage src) {
        return createOptimalImage(src, src.getWidth(), src.getHeight());
    }
    
    protected static BufferedImage createOptimalImage(final BufferedImage src, final int width, final int height) throws IllegalArgumentException {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("width [" + width + "] and height [" + height + "] must be >= 0");
        }
        return new BufferedImage(width, height, (src.getTransparency() == 1) ? 1 : 2);
    }
    
    protected static BufferedImage copyToOptimalImage(final BufferedImage src) throws IllegalArgumentException {
        if (src == null) {
            throw new IllegalArgumentException("src cannot be null");
        }
        final int type = (src.getTransparency() == 1) ? 1 : 2;
        final BufferedImage result = new BufferedImage(src.getWidth(), src.getHeight(), type);
        final Graphics g = result.getGraphics();
        g.drawImage(src, 0, 0, null);
        g.dispose();
        return result;
    }
    
    protected static Method determineScalingMethod(final int targetWidth, final int targetHeight, final float ratio) {
        final int length = (ratio <= 1.0f) ? targetWidth : targetHeight;
        Method result = Method.SPEED;
        if (length <= 800) {
            result = Method.QUALITY;
        }
        else if (length <= 1600) {
            result = Method.BALANCED;
        }
        if (Scalr.DEBUG) {
            log(2, "AUTOMATIC scaling method selected: %s", result.name());
        }
        return result;
    }
    
    protected static BufferedImage scaleImage(final BufferedImage src, final int targetWidth, final int targetHeight, final Object interpolationHintValue) {
        final BufferedImage result = createOptimalImage(src, targetWidth, targetHeight);
        final Graphics2D resultGraphics = result.createGraphics();
        resultGraphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, interpolationHintValue);
        resultGraphics.drawImage(src, 0, 0, targetWidth, targetHeight, null);
        resultGraphics.dispose();
        return result;
    }
    
    protected static BufferedImage scaleImageIncrementally(BufferedImage src, final int targetWidth, final int targetHeight, final Method scalingMethod, final Object interpolationHintValue) {
        boolean hasReassignedSrc = false;
        int incrementCount = 0;
        int currentWidth = src.getWidth();
        int currentHeight = src.getHeight();
        final int fraction = (scalingMethod == Method.ULTRA_QUALITY) ? 7 : 2;
        do {
            final int prevCurrentWidth = currentWidth;
            final int prevCurrentHeight = currentHeight;
            if (currentWidth > targetWidth) {
                currentWidth -= currentWidth / fraction;
                if (currentWidth < targetWidth) {
                    currentWidth = targetWidth;
                }
            }
            if (currentHeight > targetHeight) {
                currentHeight -= currentHeight / fraction;
                if (currentHeight < targetHeight) {
                    currentHeight = targetHeight;
                }
            }
            if (prevCurrentWidth == currentWidth && prevCurrentHeight == currentHeight) {
                break;
            }
            if (Scalr.DEBUG) {
                log(2, "Scaling from [%d x %d] to [%d x %d]", prevCurrentWidth, prevCurrentHeight, currentWidth, currentHeight);
            }
            final BufferedImage incrementalImage = scaleImage(src, currentWidth, currentHeight, interpolationHintValue);
            if (hasReassignedSrc) {
                src.flush();
            }
            src = incrementalImage;
            hasReassignedSrc = true;
            ++incrementCount;
        } while (currentWidth != targetWidth || currentHeight != targetHeight);
        if (Scalr.DEBUG) {
            log(2, "Incrementally Scaled Image in %d steps.", incrementCount);
        }
        return src;
    }
    
    static {
        DEBUG = Boolean.getBoolean("imgscalr.debug");
        LOG_PREFIX = System.getProperty("imgscalr.logPrefix", "[imgscalr] ");
        OP_ANTIALIAS = new ConvolveOp(new Kernel(3, 3, new float[] { 0.0f, 0.08f, 0.0f, 0.08f, 0.68f, 0.08f, 0.0f, 0.08f, 0.0f }), 1, null);
        OP_DARKER = new RescaleOp(0.9f, 0.0f, null);
        OP_BRIGHTER = new RescaleOp(1.1f, 0.0f, null);
        OP_GRAYSCALE = new ColorConvertOp(ColorSpace.getInstance(1003), null);
        log(0, "Debug output ENABLED", new Object[0]);
    }
    
    public enum Method
    {
        AUTOMATIC, 
        SPEED, 
        BALANCED, 
        QUALITY, 
        ULTRA_QUALITY;
    }
    
    public enum Mode
    {
        AUTOMATIC, 
        FIT_EXACT, 
        FIT_TO_WIDTH, 
        FIT_TO_HEIGHT;
    }
    
    public enum Rotation
    {
        CW_90, 
        CW_180, 
        CW_270, 
        FLIP_HORZ, 
        FLIP_VERT;
    }
}
