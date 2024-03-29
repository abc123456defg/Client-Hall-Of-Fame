// 
// Decompiled by Procyon v0.5.36
// 

package intent.AquaDev.aqua.fontrenderer;

import java.util.Iterator;
import net.optifine.CustomColors;
import net.minecraft.src.Config;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import java.util.Locale;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.GlStateManager;
import java.awt.Font;
import java.util.Random;

public class GlyphPageFontRenderer implements BasicFontRenderer
{
    private final int[] colorCode;
    private final GlyphPage regularGlyphPage;
    private final GlyphPage boldGlyphPage;
    private final GlyphPage italicGlyphPage;
    private final GlyphPage boldItalicGlyphPage;
    public Random fontRandom;
    private float posX;
    private float posY;
    private float red;
    private float blue;
    private float green;
    private float alpha;
    private int textColor;
    private boolean randomStyle;
    private boolean boldStyle;
    private boolean italicStyle;
    private boolean underlineStyle;
    private boolean strikethroughStyle;
    
    public GlyphPageFontRenderer(final GlyphPage regularGlyphPage, final GlyphPage boldGlyphPage, final GlyphPage italicGlyphPage, final GlyphPage boldItalicGlyphPage) {
        this.colorCode = new int[32];
        this.fontRandom = new Random();
        this.regularGlyphPage = regularGlyphPage;
        this.boldGlyphPage = boldGlyphPage;
        this.italicGlyphPage = italicGlyphPage;
        this.boldItalicGlyphPage = boldItalicGlyphPage;
        for (int i = 0; i < 32; ++i) {
            final int j = (i >> 3 & 0x1) * 85;
            int k = (i >> 2 & 0x1) * 170 + j;
            int l = (i >> 1 & 0x1) * 170 + j;
            int i2 = (i & 0x1) * 170 + j;
            if (i == 6) {
                k += 85;
            }
            if (i >= 16) {
                k /= 4;
                l /= 4;
                i2 /= 4;
            }
            this.colorCode[i] = ((k & 0xFF) << 16 | (l & 0xFF) << 8 | (i2 & 0xFF));
        }
    }
    
    public static GlyphPageFontRenderer create(final String fontName, final int size, final boolean bold, final boolean italic, final boolean boldItalic) {
        final char[] chars = new char[256];
        for (int i = 0; i < chars.length; ++i) {
            chars[i] = (char)i;
        }
        final GlyphPage regularPage = new GlyphPage(new Font(fontName, 0, size), true, true);
        regularPage.generateGlyphPage(chars);
        regularPage.setupTexture();
        GlyphPage boldPage = regularPage;
        GlyphPage italicPage = regularPage;
        GlyphPage boldItalicPage = regularPage;
        if (bold) {
            boldPage = new GlyphPage(new Font(fontName, 1, size), true, true);
            boldPage.generateGlyphPage(chars);
            boldPage.setupTexture();
        }
        if (italic) {
            italicPage = new GlyphPage(new Font(fontName, 2, size), true, true);
            italicPage.generateGlyphPage(chars);
            italicPage.setupTexture();
        }
        if (boldItalic) {
            boldItalicPage = new GlyphPage(new Font(fontName, 3, size), true, true);
            boldItalicPage.generateGlyphPage(chars);
            boldItalicPage.setupTexture();
        }
        return new GlyphPageFontRenderer(regularPage, boldPage, italicPage, boldItalicPage);
    }
    
    public static String getFormatFromString(final String text) {
        String s = "";
        int i = -1;
        final int j = text.length();
        while ((i = text.indexOf(167, i + 1)) != -1) {
            if (i < j - 1) {
                final char c0 = text.charAt(i + 1);
                if (isFormatColor(c0)) {
                    s = "§" + c0;
                }
                else {
                    if (!isFormatSpecial(c0)) {
                        continue;
                    }
                    s = s + "§" + c0;
                }
            }
        }
        return s;
    }
    
    private static boolean isFormatColor(final char colorChar) {
        return (colorChar >= '0' && colorChar <= '9') || (colorChar >= 'a' && colorChar <= 'f') || (colorChar >= 'A' && colorChar <= 'F');
    }
    
    private static boolean isFormatSpecial(final char formatChar) {
        return (formatChar >= 'k' && formatChar <= 'o') || (formatChar >= 'K' && formatChar <= 'O') || formatChar == 'r' || formatChar == 'R';
    }
    
    @Override
    public int drawString(final String text, final float x, final float y, final int color, final boolean dropShadow) {
        GlStateManager.enableAlpha();
        this.resetStyles();
        int i;
        if (dropShadow) {
            i = this.renderString(text, x + 1.0f, y + 1.0f, color, true);
            i = Math.max(i, this.renderString(text, x, y, color, false));
        }
        else {
            i = this.renderString(text, x, y, color, false);
        }
        return i;
    }
    
    @Override
    public int drawStringWithShadow(final String text, final float x, final float y, final int color) {
        return this.drawString(text, x, y, color, true);
    }
    
    @Override
    public int drawString(final String text, final float x, final float y, final int color) {
        return this.drawString(text, x, y, color, false);
    }
    
    @Override
    public int drawCenteredString(final String text, final float x, final float y, final int color, final boolean dropShadow) {
        return this.drawString(text, x - this.getStringWidth(text) / 2, y, color, dropShadow);
    }
    
    public int drawCenteredScaledString(final String string, final float x, final float y, final float scale, final int color) {
        int i = 0;
        GlStateManager.pushMatrix();
        GlStateManager.scale(scale, scale, 0.0f);
        i = this.drawCenteredString(string, x / scale, y / scale, color, true);
        GlStateManager.popMatrix();
        return i;
    }
    
    private int renderString(final String text, final float x, final float y, int color, final boolean dropShadow) {
        if (text == null) {
            return 0;
        }
        if ((color & 0xFC000000) == 0x0) {
            color |= 0xFF000000;
        }
        if (dropShadow) {
            color = ((color & 0xFCFCFC) >> 2 | (color & 0xFF000000));
        }
        this.red = (color >> 16 & 0xFF) / 255.0f;
        this.blue = (color >> 8 & 0xFF) / 255.0f;
        this.green = (color & 0xFF) / 255.0f;
        this.alpha = (color >> 24 & 0xFF) / 255.0f;
        GlStateManager.color(this.red, this.blue, this.green, this.alpha);
        this.posX = x * 2.0f;
        this.posY = y * 2.0f;
        this.renderStringAtPos(text, dropShadow);
        return (int)(this.posX / 2.0f);
    }
    
    private void renderStringAtPos(final String text, final boolean shadow) {
        GlyphPage glyphPage = this.getCurrentGlyphPage();
        GL11.glPushMatrix();
        GL11.glScaled(0.5, 0.5, 0.5);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        GlStateManager.enableTexture2D();
        glyphPage.bindTexture();
        GL11.glTexParameteri(3553, 10240, 9729);
        for (int i = 0; i < text.length(); ++i) {
            final char c0 = text.charAt(i);
            if (c0 == '§' && i + 1 < text.length()) {
                int i2 = "0123456789abcdefklmnor".indexOf(text.toLowerCase(Locale.ENGLISH).charAt(i + 1));
                if (i2 < 16) {
                    this.randomStyle = false;
                    this.boldStyle = false;
                    this.strikethroughStyle = false;
                    this.underlineStyle = false;
                    this.italicStyle = false;
                    if (i2 < 0) {
                        i2 = 15;
                    }
                    if (shadow) {
                        i2 += 16;
                    }
                    final int j1 = this.colorCode[i2];
                    this.textColor = j1;
                    GlStateManager.color((j1 >> 16) / 255.0f, (j1 >> 8 & 0xFF) / 255.0f, (j1 & 0xFF) / 255.0f, this.alpha);
                }
                else if (i2 == 16) {
                    this.randomStyle = true;
                }
                else if (i2 == 17) {
                    this.boldStyle = true;
                }
                else if (i2 == 18) {
                    this.strikethroughStyle = true;
                }
                else if (i2 == 19) {
                    this.underlineStyle = true;
                }
                else if (i2 == 20) {
                    this.italicStyle = true;
                }
                else {
                    this.randomStyle = false;
                    this.boldStyle = false;
                    this.strikethroughStyle = false;
                    this.underlineStyle = false;
                    this.italicStyle = false;
                    GlStateManager.color(this.red, this.blue, this.green, this.alpha);
                }
                ++i;
            }
            else {
                glyphPage = this.getCurrentGlyphPage();
                glyphPage.bindTexture();
                final float f = glyphPage.drawChar(c0, this.posX, this.posY);
                this.doDraw(f, glyphPage);
            }
        }
        glyphPage.unbindTexture();
        GL11.glPopMatrix();
    }
    
    private void doDraw(final float f, final GlyphPage glyphPage) {
        if (this.strikethroughStyle) {
            final Tessellator tessellator = Tessellator.getInstance();
            final WorldRenderer worldrenderer = tessellator.getWorldRenderer();
            GlStateManager.disableTexture2D();
            worldrenderer.begin(7, DefaultVertexFormats.POSITION);
            worldrenderer.pos(this.posX, this.posY + glyphPage.getMaxFontHeight() / 2, 0.0).endVertex();
            worldrenderer.pos(this.posX + f, this.posY + glyphPage.getMaxFontHeight() / 2, 0.0).endVertex();
            worldrenderer.pos(this.posX + f, this.posY + glyphPage.getMaxFontHeight() / 2 - 1.0f, 0.0).endVertex();
            worldrenderer.pos(this.posX, this.posY + glyphPage.getMaxFontHeight() / 2 - 1.0f, 0.0).endVertex();
            tessellator.draw();
            GlStateManager.enableTexture2D();
        }
        if (this.underlineStyle) {
            final Tessellator tessellator2 = Tessellator.getInstance();
            final WorldRenderer worldrenderer2 = tessellator2.getWorldRenderer();
            GlStateManager.disableTexture2D();
            worldrenderer2.begin(7, DefaultVertexFormats.POSITION);
            final int l = this.underlineStyle ? -1 : 0;
            worldrenderer2.pos(this.posX + l, this.posY + glyphPage.getMaxFontHeight(), 0.0).endVertex();
            worldrenderer2.pos(this.posX + f, this.posY + glyphPage.getMaxFontHeight(), 0.0).endVertex();
            worldrenderer2.pos(this.posX + f, this.posY + glyphPage.getMaxFontHeight() - 1.0f, 0.0).endVertex();
            worldrenderer2.pos(this.posX + l, this.posY + glyphPage.getMaxFontHeight() - 1.0f, 0.0).endVertex();
            tessellator2.draw();
            GlStateManager.enableTexture2D();
        }
        this.posX += f;
    }
    
    private GlyphPage getCurrentGlyphPage() {
        if (this.boldStyle && this.italicStyle) {
            return this.boldItalicGlyphPage;
        }
        if (this.boldStyle) {
            return this.boldGlyphPage;
        }
        if (this.italicStyle) {
            return this.italicGlyphPage;
        }
        return this.regularGlyphPage;
    }
    
    private void resetStyles() {
        this.randomStyle = false;
        this.boldStyle = false;
        this.italicStyle = false;
        this.underlineStyle = false;
        this.strikethroughStyle = false;
    }
    
    @Override
    public int getFontHeight() {
        return this.regularGlyphPage.getMaxFontHeight() / 2;
    }
    
    @Override
    public int getStringWidth(String text) {
        if (text == null) {
            return 0;
        }
        int width = 0;
        final String abc = "0123456789abcdefklmnor";
        for (int i = 0; i < abc.length(); ++i) {
            text = text.replace("\ufffd" + abc.charAt(i), "");
        }
        final int size = text.length();
        boolean on = false;
        for (int j = 0; j < size; ++j) {
            char character = text.charAt(j);
            if (character == '\ufffd') {
                on = true;
            }
            else if (on && character >= '0' && character <= 'r') {
                final int colorIndex = "0123456789abcdefklmnor".indexOf(character);
                if (colorIndex < 16) {
                    this.boldStyle = false;
                    this.italicStyle = false;
                }
                else if (colorIndex == 17) {
                    this.boldStyle = true;
                }
                else if (colorIndex == 20) {
                    this.italicStyle = true;
                }
                else if (colorIndex == 21) {
                    this.boldStyle = false;
                    this.italicStyle = false;
                }
                ++j;
                on = false;
            }
            else {
                if (on) {
                    --j;
                }
                character = text.charAt(j);
                final GlyphPage currentPage = this.getCurrentGlyphPage();
                width += (int)(currentPage.getWidth(character) - 8.0f);
            }
        }
        return width / 2;
    }
    
    @Override
    public String trimStringToWidth(final String text, final int width) {
        return this.trimStringToWidth(text, width, false);
    }
    
    @Override
    public String trimStringToWidth(final String text, final int maxWidth, final boolean reverse) {
        final StringBuilder stringbuilder = new StringBuilder();
        boolean on = false;
        final int j = reverse ? (text.length() - 1) : 0;
        final int k = reverse ? -1 : 1;
        int width = 0;
        for (int i = j; i >= 0 && i < text.length() && i < maxWidth; i += k) {
            char character = text.charAt(i);
            if (character == '\ufffd') {
                on = true;
            }
            else if (on && character >= '0' && character <= 'r') {
                final int colorIndex = "0123456789abcdefklmnor".indexOf(character);
                if (colorIndex < 16) {
                    this.boldStyle = false;
                    this.italicStyle = false;
                }
                else if (colorIndex == 17) {
                    this.boldStyle = true;
                }
                else if (colorIndex == 20) {
                    this.italicStyle = true;
                }
                else if (colorIndex == 21) {
                    this.boldStyle = false;
                    this.italicStyle = false;
                }
                ++i;
                on = false;
            }
            else {
                if (on) {
                    --i;
                }
                character = text.charAt(i);
                final GlyphPage currentPage = this.getCurrentGlyphPage();
                width += (int)((currentPage.getWidth(character) - 8.0f) / 2.0f);
            }
            if (i > width) {
                break;
            }
            if (reverse) {
                stringbuilder.insert(0, character);
            }
            else {
                stringbuilder.append(character);
            }
        }
        return stringbuilder.toString();
    }
    
    @Override
    public int getCharWidth(final char c) {
        return this.getStringWidth("" + c);
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager resourceManager) {
    }
    
    @Override
    public boolean getBidiFlag() {
        return false;
    }
    
    @Override
    public void setBidiFlag(final boolean state) {
    }
    
    @Override
    public String wrapFormattedStringToWidth(final String str, final int wrapWidth) {
        final int i = this.sizeStringToWidth(str, wrapWidth);
        if (str.length() <= i) {
            return str;
        }
        final String s = str.substring(0, i);
        final char c0 = str.charAt(i);
        final boolean flag = c0 == ' ' || c0 == '\n';
        final String s2 = getFormatFromString(s) + str.substring(i + (flag ? 1 : 0));
        return s;
    }
    
    private int sizeStringToWidth(final String str, final int wrapWidth) {
        final int i = str.length();
        float f = 0.0f;
        int j = 0;
        int k = -1;
        boolean flag = false;
        while (j < i) {
            final char c0 = str.charAt(j);
            Label_0167: {
                switch (c0) {
                    case '\n': {
                        --j;
                        break Label_0167;
                    }
                    case ' ': {
                        k = j;
                        break;
                    }
                    case '§': {
                        if (j >= i - 1) {
                            break Label_0167;
                        }
                        ++j;
                        final char c2 = str.charAt(j);
                        if (c2 == 'l' || c2 == 'L') {
                            flag = true;
                            break Label_0167;
                        }
                        if (c2 == 'r' || c2 == 'R' || isFormatColor(c2)) {
                            flag = false;
                        }
                        break Label_0167;
                    }
                }
                f += this.getCharWidthFloat(c0);
                if (flag) {
                    ++f;
                }
            }
            if (c0 == '\n') {
                k = ++j;
                break;
            }
            if (f > wrapWidth) {
                break;
            }
            ++j;
        }
        return (j != i && k != -1 && k < j) ? k : j;
    }
    
    @Override
    public List listFormattedStringToWidth(final String str, final int wrapWidth) {
        return Arrays.asList(this.wrapFormattedStringToWidth(str, wrapWidth).split("\n"));
    }
    
    @Override
    public int getColorCode(final char character) {
        final int i = "0123456789abcdef".indexOf(character);
        if (i >= 0 && i < this.colorCode.length) {
            int j = this.colorCode[i];
            if (Config.isCustomColors()) {
                j = CustomColors.getTextColor(i, j);
            }
            return j;
        }
        return 16777215;
    }
    
    @Override
    public boolean isEnabled() {
        return true;
    }
    
    @Override
    public boolean setEnabled(final boolean state) {
        return true;
    }
    
    @Override
    public void setFontRandomSeed(final long seed) {
        this.fontRandom.setSeed(seed);
    }
    
    @Override
    public void drawSplitString(String str, final int x, final int y, final int wrapWidth, final int textColor) {
        this.resetStyles();
        this.textColor = textColor;
        str = this.trimStringNewline(str);
        this.renderSplitString(str, x, y, wrapWidth, false);
    }
    
    @Override
    public int splitStringWidth(final String p_78267_1_, final int p_78267_2_) {
        return this.getFontHeight() * this.listFormattedStringToWidth(p_78267_1_, p_78267_2_).size();
    }
    
    @Override
    public boolean getUnicodeFlag() {
        return false;
    }
    
    @Override
    public void setUnicodeFlag(final boolean state) {
    }
    
    private float getCharWidthFloat(final char p_getCharWidthFloat_1_) {
        return (float)this.getCharWidth(p_getCharWidthFloat_1_);
    }
    
    private int renderStringAligned(final String text, final int x, final int y, final int p_78274_4_, final int color, final boolean dropShadow) {
        return this.renderString(text, (float)x, (float)y, color, dropShadow);
    }
    
    private void renderSplitString(final String str, final int x, int y, final int wrapWidth, final boolean addShadow) {
        for (final Object s : this.listFormattedStringToWidth(str, wrapWidth)) {
            this.renderStringAligned((String)s, x, y, wrapWidth, this.textColor, addShadow);
            y += this.getFontHeight();
        }
    }
    
    private String trimStringNewline(String text) {
        while (text != null && text.endsWith("\n")) {
            text = text.substring(0, text.length() - 1);
        }
        return text;
    }
    
    public int drawScaledString(final String string, final float x, final float y, final float scale, final int color) {
        int i = 0;
        GlStateManager.pushMatrix();
        GlStateManager.scale(scale, scale, 0.0f);
        i = this.drawString(string, x / scale, y / scale, color);
        GlStateManager.popMatrix();
        return i;
    }
}
