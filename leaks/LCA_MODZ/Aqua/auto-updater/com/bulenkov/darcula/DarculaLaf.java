// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula;

import java.util.Hashtable;
import javax.swing.KeyStroke;
import javax.swing.InputMap;
import javax.swing.Icon;
import java.util.List;
import javax.swing.plaf.ColorUIResource;
import java.awt.Color;
import com.bulenkov.iconloader.util.ColorUtil;
import javax.swing.plaf.InsetsUIResource;
import com.bulenkov.iconloader.util.StringUtil;
import java.util.Iterator;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.lang.reflect.Field;
import java.io.InputStream;
import sun.awt.AppContext;
import javax.swing.text.html.HTMLEditorKit;
import java.net.URL;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.text.html.StyleSheet;
import com.bulenkov.iconloader.util.EmptyIcon;
import javax.swing.plaf.IconUIResource;
import com.bulenkov.iconloader.IconLoader;
import java.awt.Dimension;
import java.lang.reflect.Method;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import com.bulenkov.iconloader.util.SystemInfo;
import javax.swing.plaf.basic.BasicLookAndFeel;

public final class DarculaLaf extends BasicLookAndFeel
{
    public static final String NAME = "Darcula";
    BasicLookAndFeel base;
    
    public DarculaLaf() {
        try {
            if (SystemInfo.isWindows || SystemInfo.isLinux) {
                this.base = new MetalLookAndFeel();
                MetalLookAndFeel.setCurrentTheme(new DarculaMetalTheme());
            }
            else {
                final String name = UIManager.getSystemLookAndFeelClassName();
                this.base = (BasicLookAndFeel)Class.forName(name).newInstance();
            }
        }
        catch (Exception ignore) {
            log(ignore);
        }
    }
    
    private void callInit(final String method, final UIDefaults defaults) {
        try {
            final Method superMethod = BasicLookAndFeel.class.getDeclaredMethod(method, UIDefaults.class);
            superMethod.setAccessible(true);
            superMethod.invoke(this.base, defaults);
        }
        catch (Exception ignore) {
            log(ignore);
        }
    }
    
    private static void log(final Throwable e) {
    }
    
    @Override
    public UIDefaults getDefaults() {
        try {
            final Method superMethod = BasicLookAndFeel.class.getDeclaredMethod("getDefaults", (Class<?>[])new Class[0]);
            superMethod.setAccessible(true);
            final UIDefaults metalDefaults = (UIDefaults)superMethod.invoke(new MetalLookAndFeel(), new Object[0]);
            final UIDefaults defaults = (UIDefaults)superMethod.invoke(this.base, new Object[0]);
            initInputMapDefaults(defaults);
            initIdeaDefaults(defaults);
            patchStyledEditorKit();
            patchComboBox(metalDefaults, defaults);
            defaults.remove("Spinner.arrowButtonBorder");
            defaults.put("Spinner.arrowButtonSize", new Dimension(16, 5));
            defaults.put("Tree.collapsedIcon", new IconUIResource(IconLoader.getIcon("/com/bulenkov/darcula/icons/treeNodeCollapsed.png")));
            defaults.put("Tree.expandedIcon", new IconUIResource(IconLoader.getIcon("/com/bulenkov/darcula/icons/treeNodeExpanded.png")));
            defaults.put("Menu.arrowIcon", new IconUIResource(IconLoader.getIcon("/com/bulenkov/darcula/icons/menuItemArrowIcon.png")));
            defaults.put("CheckBoxMenuItem.checkIcon", EmptyIcon.create(16));
            defaults.put("RadioButtonMenuItem.checkIcon", EmptyIcon.create(16));
            defaults.put("InternalFrame.icon", new IconUIResource(IconLoader.getIcon("/com/bulenkov/darcula/icons/internalFrame.png")));
            defaults.put("OptionPane.informationIcon", new IconUIResource(IconLoader.getIcon("/com/bulenkov/darcula/icons/option_pane_info.png")));
            defaults.put("OptionPane.questionIcon", new IconUIResource(IconLoader.getIcon("/com/bulenkov/darcula/icons/option_pane_question.png")));
            defaults.put("OptionPane.warningIcon", new IconUIResource(IconLoader.getIcon("/com/bulenkov/darcula/icons/option_pane_warning.png")));
            defaults.put("OptionPane.errorIcon", new IconUIResource(IconLoader.getIcon("/com/bulenkov/darcula/icons/option_pane_error.png")));
            if (SystemInfo.isMac && !"true".equalsIgnoreCase(System.getProperty("apple.laf.useScreenMenuBar", "false"))) {
                defaults.put("MenuBarUI", "com.bulenkov.darcula.ui.DarculaMenuBarUI");
                defaults.put("MenuUI", "javax.swing.plaf.basic.BasicMenuUI");
            }
            return defaults;
        }
        catch (Exception ignore) {
            log(ignore);
            return super.getDefaults();
        }
    }
    
    private static void patchComboBox(final UIDefaults metalDefaults, final UIDefaults defaults) {
        defaults.remove("ComboBox.ancestorInputMap");
        defaults.remove("ComboBox.actionMap");
        defaults.put("ComboBox.ancestorInputMap", metalDefaults.get("ComboBox.ancestorInputMap"));
        defaults.put("ComboBox.actionMap", metalDefaults.get("ComboBox.actionMap"));
    }
    
    private static void patchStyledEditorKit() {
        try {
            final StyleSheet defaultStyles = new StyleSheet();
            final InputStream is = DarculaLaf.class.getResourceAsStream("darcula.css");
            final Reader r = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            defaultStyles.loadRules(r, null);
            r.close();
            final Field keyField = HTMLEditorKit.class.getDeclaredField("DEFAULT_STYLES_KEY");
            keyField.setAccessible(true);
            final Object key = keyField.get(null);
            AppContext.getAppContext().put(key, defaultStyles);
        }
        catch (Throwable e) {
            log(e);
        }
    }
    
    private void call(final String method) {
        try {
            final Method superMethod = BasicLookAndFeel.class.getDeclaredMethod(method, (Class<?>[])new Class[0]);
            superMethod.setAccessible(true);
            superMethod.invoke(this.base, new Object[0]);
        }
        catch (Exception ignore) {
            log(ignore);
        }
    }
    
    public void initComponentDefaults(final UIDefaults defaults) {
        this.callInit("initComponentDefaults", defaults);
    }
    
    static void initIdeaDefaults(final UIDefaults defaults) {
        loadDefaults(defaults);
        defaults.put("Table.ancestorInputMap", new UIDefaults.LazyInputMap(new Object[] { "ctrl C", "copy", "ctrl V", "paste", "ctrl X", "cut", "COPY", "copy", "PASTE", "paste", "CUT", "cut", "control INSERT", "copy", "shift INSERT", "paste", "shift DELETE", "cut", "RIGHT", "selectNextColumn", "KP_RIGHT", "selectNextColumn", "LEFT", "selectPreviousColumn", "KP_LEFT", "selectPreviousColumn", "DOWN", "selectNextRow", "KP_DOWN", "selectNextRow", "UP", "selectPreviousRow", "KP_UP", "selectPreviousRow", "shift RIGHT", "selectNextColumnExtendSelection", "shift KP_RIGHT", "selectNextColumnExtendSelection", "shift LEFT", "selectPreviousColumnExtendSelection", "shift KP_LEFT", "selectPreviousColumnExtendSelection", "shift DOWN", "selectNextRowExtendSelection", "shift KP_DOWN", "selectNextRowExtendSelection", "shift UP", "selectPreviousRowExtendSelection", "shift KP_UP", "selectPreviousRowExtendSelection", "PAGE_UP", "scrollUpChangeSelection", "PAGE_DOWN", "scrollDownChangeSelection", "HOME", "selectFirstColumn", "END", "selectLastColumn", "shift PAGE_UP", "scrollUpExtendSelection", "shift PAGE_DOWN", "scrollDownExtendSelection", "shift HOME", "selectFirstColumnExtendSelection", "shift END", "selectLastColumnExtendSelection", "ctrl PAGE_UP", "scrollLeftChangeSelection", "ctrl PAGE_DOWN", "scrollRightChangeSelection", "ctrl HOME", "selectFirstRow", "ctrl END", "selectLastRow", "ctrl shift PAGE_UP", "scrollRightExtendSelection", "ctrl shift PAGE_DOWN", "scrollLeftExtendSelection", "ctrl shift HOME", "selectFirstRowExtendSelection", "ctrl shift END", "selectLastRowExtendSelection", "TAB", "selectNextColumnCell", "shift TAB", "selectPreviousColumnCell", "shift ENTER", "selectPreviousRowCell", "ctrl A", "selectAll", "meta A", "selectAll", "F2", "startEditing" }));
    }
    
    private static void loadDefaults(final UIDefaults defaults) {
        final Properties properties = new Properties();
        final String osSuffix = SystemInfo.isMac ? "mac" : (SystemInfo.isWindows ? "windows" : "linux");
        try {
            InputStream stream = DarculaLaf.class.getResourceAsStream("darcula.properties");
            properties.load(stream);
            stream.close();
            stream = DarculaLaf.class.getResourceAsStream("darcula_" + osSuffix + ".properties");
            properties.load(stream);
            stream.close();
            final HashMap<String, Object> darculaGlobalSettings = new HashMap<String, Object>();
            final String prefix = "darcula.";
            for (final String key : properties.stringPropertyNames()) {
                if (key.startsWith("darcula.")) {
                    darculaGlobalSettings.put(key.substring("darcula.".length()), parseValue(key, properties.getProperty(key)));
                }
            }
            for (final Object key2 : ((Hashtable<Object, V>)defaults).keySet()) {
                if (key2 instanceof String && ((String)key2).contains(".")) {
                    final String s = (String)key2;
                    final String darculaKey = s.substring(s.lastIndexOf(46) + 1);
                    if (!darculaGlobalSettings.containsKey(darculaKey)) {
                        continue;
                    }
                    defaults.put(key2, darculaGlobalSettings.get(darculaKey));
                }
            }
            for (final String key : properties.stringPropertyNames()) {
                final String value = properties.getProperty(key);
                defaults.put(key, parseValue(key, value));
            }
        }
        catch (IOException e) {
            log(e);
        }
    }
    
    private static Object parseValue(final String key, final String value) {
        if ("null".equals(value)) {
            return null;
        }
        if (key.endsWith("Insets")) {
            final List<String> numbers = StringUtil.split(value, ",");
            return new InsetsUIResource(Integer.parseInt(numbers.get(0)), Integer.parseInt(numbers.get(1)), Integer.parseInt(numbers.get(2)), Integer.parseInt(numbers.get(3)));
        }
        if (key.endsWith(".border")) {
            try {
                return Class.forName(value).newInstance();
            }
            catch (Exception e) {
                log(e);
                return value;
            }
        }
        final Color color = ColorUtil.fromHex(value, null);
        final Integer invVal = getInteger(value);
        final Boolean boolVal = "true".equals(value) ? Boolean.TRUE : ("false".equals(value) ? Boolean.FALSE : null);
        final Icon icon = key.toLowerCase().endsWith("icon") ? null : null;
        if (color != null) {
            return new ColorUIResource(color);
        }
        if (invVal != null) {
            return invVal;
        }
        if (icon != null) {
            return new IconUIResource(icon);
        }
        if (boolVal != null) {
            return boolVal;
        }
        return value;
    }
    
    private static Integer getInteger(final String value) {
        try {
            return Integer.parseInt(value);
        }
        catch (NumberFormatException e) {
            return null;
        }
    }
    
    @Override
    public String getName() {
        return "Darcula";
    }
    
    @Override
    public String getID() {
        return this.getName();
    }
    
    @Override
    public String getDescription() {
        return "IntelliJ Dark Look and Feel";
    }
    
    @Override
    public boolean isNativeLookAndFeel() {
        return true;
    }
    
    @Override
    public boolean isSupportedLookAndFeel() {
        return true;
    }
    
    @Override
    protected void initSystemColorDefaults(final UIDefaults defaults) {
        this.callInit("initSystemColorDefaults", defaults);
    }
    
    @Override
    protected void initClassDefaults(final UIDefaults defaults) {
        this.callInit("initClassDefaults", defaults);
    }
    
    @Override
    public void initialize() {
        this.call("initialize");
    }
    
    @Override
    public void uninitialize() {
        this.call("uninitialize");
    }
    
    @Override
    protected void loadSystemColors(final UIDefaults defaults, final String[] systemColors, final boolean useNative) {
        try {
            final Method superMethod = BasicLookAndFeel.class.getDeclaredMethod("loadSystemColors", UIDefaults.class, String[].class, Boolean.TYPE);
            superMethod.setAccessible(true);
            superMethod.invoke(this.base, defaults, systemColors, useNative);
        }
        catch (Exception ignore) {
            log(ignore);
        }
    }
    
    @Override
    public boolean getSupportsWindowDecorations() {
        return true;
    }
    
    public static void initInputMapDefaults(final UIDefaults defaults) {
        final InputMap treeInputMap = (InputMap)defaults.get("Tree.focusInputMap");
        if (treeInputMap != null) {
            treeInputMap.put(KeyStroke.getKeyStroke(10, 0), "toggle");
        }
        final InputMap textAreaInputMap = (InputMap)defaults.get("TextArea.focusInputMap");
        if (textAreaInputMap != null) {
            installCutCopyPasteShortcuts(textAreaInputMap, false);
        }
        final InputMap textFieldInputMap = (InputMap)defaults.get("TextField.focusInputMap");
        if (textFieldInputMap != null) {
            installCutCopyPasteShortcuts(textFieldInputMap, false);
        }
        final InputMap passwordFieldInputMap = (InputMap)defaults.get("PasswordField.focusInputMap");
        if (passwordFieldInputMap != null) {
            installCutCopyPasteShortcuts(passwordFieldInputMap, false);
        }
        final InputMap tableInputMap = (InputMap)defaults.get("Table.ancestorInputMap");
        if (tableInputMap != null) {
            installCutCopyPasteShortcuts(tableInputMap, true);
        }
    }
    
    private static void installCutCopyPasteShortcuts(final InputMap inputMap, final boolean useSimpleActionKeys) {
        final String copyActionKey = useSimpleActionKeys ? "copy" : "copy-to-clipboard";
        final String pasteActionKey = useSimpleActionKeys ? "paste" : "paste-from-clipboard";
        final String cutActionKey = useSimpleActionKeys ? "cut" : "cut-to-clipboard";
        inputMap.put(KeyStroke.getKeyStroke(155, 130), copyActionKey);
        inputMap.put(KeyStroke.getKeyStroke(155, 65), pasteActionKey);
        inputMap.put(KeyStroke.getKeyStroke(127, 65), cutActionKey);
        inputMap.put(KeyStroke.getKeyStroke(67, 130), copyActionKey);
        inputMap.put(KeyStroke.getKeyStroke(86, 130), pasteActionKey);
        inputMap.put(KeyStroke.getKeyStroke(88, 130), "cut-to-clipboard");
    }
}
