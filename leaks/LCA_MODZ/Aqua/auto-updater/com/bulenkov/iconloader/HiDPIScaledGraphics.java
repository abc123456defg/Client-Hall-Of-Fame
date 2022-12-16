// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader;

import java.awt.Polygon;
import java.awt.FontMetrics;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.Color;
import java.util.Map;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.Paint;
import java.awt.Composite;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.font.GlyphVector;
import java.text.AttributedCharacterIterator;
import java.awt.image.renderable.RenderableImage;
import java.awt.image.RenderedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.geom.AffineTransform;
import java.awt.Image;
import java.awt.Shape;
import com.bulenkov.iconloader.util.GraphicsUtil;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

class HiDPIScaledGraphics extends Graphics2D
{
    protected final Graphics2D myPeer;
    private BufferedImage myImage;
    
    public HiDPIScaledGraphics(final Graphics g, final BufferedImage image) {
        this.myImage = image;
        this.myPeer = (Graphics2D)g;
        this.scale(2.0, 2.0);
        GraphicsUtil.setupAAPainting(this.myPeer);
    }
    
    @Override
    public void draw3DRect(final int x, final int y, final int width, final int height, final boolean raised) {
        this.myPeer.draw3DRect(x, y, width, height, raised);
    }
    
    @Override
    public void fill3DRect(final int x, final int y, final int width, final int height, final boolean raised) {
        this.myPeer.fill3DRect(x, y, width, height, raised);
    }
    
    @Override
    public void draw(final Shape s) {
        this.myPeer.draw(s);
    }
    
    @Override
    public boolean drawImage(final Image img, final AffineTransform xform, final ImageObserver obs) {
        return this.myPeer.drawImage(img, xform, obs);
    }
    
    @Override
    public void drawImage(final BufferedImage img, final BufferedImageOp op, final int x, final int y) {
        this.myPeer.drawImage(img, op, x, y);
    }
    
    @Override
    public void drawRenderedImage(final RenderedImage img, final AffineTransform xform) {
        this.myPeer.drawRenderedImage(img, xform);
    }
    
    @Override
    public void drawRenderableImage(final RenderableImage img, final AffineTransform xform) {
        this.myPeer.drawRenderableImage(img, xform);
    }
    
    @Override
    public void drawString(final String str, final int x, final int y) {
        this.myPeer.drawString(str, x, y);
    }
    
    @Override
    public void drawString(final String str, final float x, final float y) {
        this.myPeer.drawString(str, x, y);
    }
    
    @Override
    public void drawString(final AttributedCharacterIterator iterator, final int x, final int y) {
        this.myPeer.drawString(iterator, x, y);
    }
    
    @Override
    public void drawString(final AttributedCharacterIterator iterator, final float x, final float y) {
        this.myPeer.drawString(iterator, x, y);
    }
    
    @Override
    public void drawGlyphVector(final GlyphVector g, final float x, final float y) {
        this.myPeer.drawGlyphVector(g, x, y);
    }
    
    @Override
    public void fill(final Shape s) {
        this.myPeer.fill(s);
    }
    
    @Override
    public boolean hit(final Rectangle rect, final Shape s, final boolean onStroke) {
        return this.myPeer.hit(rect, s, onStroke);
    }
    
    @Override
    public GraphicsConfiguration getDeviceConfiguration() {
        return this.myPeer.getDeviceConfiguration();
    }
    
    @Override
    public void setComposite(final Composite comp) {
        this.myPeer.setComposite(comp);
    }
    
    @Override
    public void setPaint(final Paint paint) {
        this.myPeer.setPaint(paint);
    }
    
    @Override
    public void setStroke(final Stroke s) {
        this.myPeer.setStroke(s);
    }
    
    @Override
    public void setRenderingHint(final RenderingHints.Key hintKey, final Object hintValue) {
        this.myPeer.setRenderingHint(hintKey, hintValue);
    }
    
    @Override
    public Object getRenderingHint(final RenderingHints.Key hintKey) {
        return this.myPeer.getRenderingHint(hintKey);
    }
    
    @Override
    public void setRenderingHints(final Map<?, ?> hints) {
        this.myPeer.setRenderingHints(hints);
    }
    
    @Override
    public void addRenderingHints(final Map<?, ?> hints) {
        this.myPeer.addRenderingHints(hints);
    }
    
    @Override
    public RenderingHints getRenderingHints() {
        return this.myPeer.getRenderingHints();
    }
    
    @Override
    public void translate(final int x, final int y) {
        this.myPeer.translate(x, y);
    }
    
    @Override
    public void translate(final double tx, final double ty) {
        this.myPeer.translate(tx, ty);
    }
    
    @Override
    public void rotate(final double theta) {
        this.myPeer.rotate(theta);
    }
    
    @Override
    public void rotate(final double theta, final double x, final double y) {
        this.myPeer.rotate(theta, x, y);
    }
    
    @Override
    public void scale(final double sx, final double sy) {
        this.myPeer.scale(sx, sy);
    }
    
    @Override
    public void shear(final double shx, final double shy) {
        this.myPeer.shear(shx, shy);
    }
    
    @Override
    public void transform(final AffineTransform Tx) {
        this.myPeer.transform(Tx);
    }
    
    @Override
    public void setTransform(final AffineTransform Tx) {
        this.myPeer.setTransform(Tx);
    }
    
    @Override
    public AffineTransform getTransform() {
        return this.myPeer.getTransform();
    }
    
    @Override
    public Paint getPaint() {
        return this.myPeer.getPaint();
    }
    
    @Override
    public Composite getComposite() {
        return this.myPeer.getComposite();
    }
    
    @Override
    public void setBackground(final Color color) {
        this.myPeer.setBackground(color);
    }
    
    @Override
    public Color getBackground() {
        return this.myPeer.getBackground();
    }
    
    @Override
    public Stroke getStroke() {
        return this.myPeer.getStroke();
    }
    
    @Override
    public void clip(final Shape s) {
        this.myPeer.clip(s);
    }
    
    @Override
    public FontRenderContext getFontRenderContext() {
        return this.myPeer.getFontRenderContext();
    }
    
    @Override
    public Graphics create() {
        final Graphics g = this.myPeer.create();
        return g;
    }
    
    @Override
    public Graphics create(final int x, final int y, final int width, final int height) {
        return this.myPeer.create(x, y, width, height);
    }
    
    @Override
    public Color getColor() {
        return this.myPeer.getColor();
    }
    
    @Override
    public void setColor(final Color c) {
        this.myPeer.setColor(c);
    }
    
    @Override
    public void setPaintMode() {
        this.myPeer.setPaintMode();
    }
    
    @Override
    public void setXORMode(final Color c1) {
        this.myPeer.setXORMode(c1);
    }
    
    @Override
    public Font getFont() {
        return this.myPeer.getFont();
    }
    
    @Override
    public void setFont(final Font font) {
        this.myPeer.setFont(font);
    }
    
    @Override
    public FontMetrics getFontMetrics() {
        return this.myPeer.getFontMetrics();
    }
    
    @Override
    public FontMetrics getFontMetrics(final Font f) {
        return this.myPeer.getFontMetrics(f);
    }
    
    @Override
    public Rectangle getClipBounds() {
        return this.myPeer.getClipBounds();
    }
    
    @Override
    public void clipRect(final int x, final int y, final int width, final int height) {
        this.myPeer.clipRect(x, y, width, height);
    }
    
    @Override
    public void setClip(final int x, final int y, final int width, final int height) {
        this.myPeer.setClip(x, y, width, height);
    }
    
    @Override
    public Shape getClip() {
        return this.myPeer.getClip();
    }
    
    @Override
    public void setClip(final Shape clip) {
        this.myPeer.setClip(clip);
    }
    
    @Override
    public void copyArea(final int x, final int y, final int width, final int height, final int dx, final int dy) {
        this.myPeer.copyArea(x, y, width, height, dx, dy);
    }
    
    @Override
    public void drawLine(final int x1, final int y1, final int x2, final int y2) {
        this.myPeer.drawLine(x1, y1, x2, y2);
    }
    
    @Override
    public void fillRect(final int x, final int y, final int width, final int height) {
        this.myPeer.fillRect(x, y, width, height);
    }
    
    @Override
    public void drawRect(final int x, final int y, final int width, final int height) {
        this.myPeer.drawRect(x, y, width, height);
    }
    
    @Override
    public void clearRect(final int x, final int y, final int width, final int height) {
        this.myPeer.clearRect(x, y, width, height);
    }
    
    @Override
    public void drawRoundRect(final int x, final int y, final int width, final int height, final int arcWidth, final int arcHeight) {
        this.myPeer.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
    }
    
    @Override
    public void fillRoundRect(final int x, final int y, final int width, final int height, final int arcWidth, final int arcHeight) {
        this.myPeer.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
    }
    
    @Override
    public void drawOval(final int x, final int y, final int width, final int height) {
        this.myPeer.drawOval(x, y, width, height);
    }
    
    @Override
    public void fillOval(final int x, final int y, final int width, final int height) {
        this.myPeer.fillOval(x, y, width, height);
    }
    
    @Override
    public void drawArc(final int x, final int y, final int width, final int height, final int startAngle, final int arcAngle) {
        this.myPeer.drawArc(x, y, width, height, startAngle, arcAngle);
    }
    
    @Override
    public void fillArc(final int x, final int y, final int width, final int height, final int startAngle, final int arcAngle) {
        this.myPeer.fillArc(x, y, width, height, startAngle, arcAngle);
    }
    
    @Override
    public void drawPolyline(final int[] xPoints, final int[] yPoints, final int nPoints) {
        this.myPeer.drawPolyline(xPoints, yPoints, nPoints);
    }
    
    @Override
    public void drawPolygon(final int[] xPoints, final int[] yPoints, final int nPoints) {
        this.myPeer.drawPolygon(xPoints, yPoints, nPoints);
    }
    
    @Override
    public void drawPolygon(final Polygon p) {
        this.myPeer.drawPolygon(p);
    }
    
    @Override
    public void fillPolygon(final int[] xPoints, final int[] yPoints, final int nPoints) {
        this.myPeer.fillPolygon(xPoints, yPoints, nPoints);
    }
    
    @Override
    public void fillPolygon(final Polygon p) {
        this.myPeer.fillPolygon(p);
    }
    
    @Override
    public void drawChars(final char[] data, final int offset, final int length, final int x, final int y) {
        this.myPeer.drawChars(data, offset, length, x, y);
    }
    
    @Override
    public void drawBytes(final byte[] data, final int offset, final int length, final int x, final int y) {
        this.myPeer.drawBytes(data, offset, length, x, y);
    }
    
    @Override
    public boolean drawImage(final Image img, final int x, final int y, final ImageObserver observer) {
        return this.myPeer.drawImage(img, x, y, observer);
    }
    
    @Override
    public boolean drawImage(final Image img, final int x, final int y, final int width, final int height, final ImageObserver observer) {
        return this.myPeer.drawImage(img, x, y, width, height, observer);
    }
    
    @Override
    public boolean drawImage(final Image img, final int x, final int y, final Color bgcolor, final ImageObserver observer) {
        return this.myPeer.drawImage(img, x, y, bgcolor, observer);
    }
    
    @Override
    public boolean drawImage(final Image img, final int x, final int y, final int width, final int height, final Color bgcolor, final ImageObserver observer) {
        return this.myPeer.drawImage(img, x, y, width, height, bgcolor, observer);
    }
    
    @Override
    public boolean drawImage(final Image img, final int dx1, final int dy1, final int dx2, final int dy2, final int sx1, final int sy1, final int sx2, final int sy2, final ImageObserver observer) {
        return this.myPeer.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer);
    }
    
    @Override
    public boolean drawImage(final Image img, final int dx1, final int dy1, final int dx2, final int dy2, final int sx1, final int sy1, final int sx2, final int sy2, final Color bgcolor, final ImageObserver observer) {
        return this.myPeer.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, bgcolor, observer);
    }
    
    @Override
    public void dispose() {
        this.myPeer.dispose();
    }
    
    @Override
    public void finalize() {
        this.myPeer.finalize();
    }
    
    @Override
    public String toString() {
        return this.myPeer.toString();
    }
    
    @Deprecated
    @Override
    public Rectangle getClipRect() {
        return this.myPeer.getClipRect();
    }
    
    @Override
    public boolean hitClip(final int x, final int y, final int width, final int height) {
        return this.myPeer.hitClip(x, y, width, height);
    }
    
    @Override
    public Rectangle getClipBounds(final Rectangle r) {
        return this.myPeer.getClipBounds(r);
    }
}
