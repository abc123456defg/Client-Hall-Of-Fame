// 
// Decompiled by Procyon v0.5.36
// 

package skid;

import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import javax.swing.UIManager;
import kotlin.jvm.internal.Intrinsics;
import javax.swing.JProgressBar;
import javax.swing.JPanel;
import javax.swing.JFrame;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0017\u001a\u00020\u0000J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0003R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b" }, d2 = { "Lskid/Window;", "", "title", "", "(Ljava/lang/String;)V", "frame", "Ljavax/swing/JFrame;", "getFrame", "()Ljavax/swing/JFrame;", "setFrame", "(Ljavax/swing/JFrame;)V", "panel", "Ljavax/swing/JPanel;", "getPanel", "()Ljavax/swing/JPanel;", "setPanel", "(Ljavax/swing/JPanel;)V", "progressBar", "Ljavax/swing/JProgressBar;", "getProgressBar", "()Ljavax/swing/JProgressBar;", "setProgressBar", "(Ljavax/swing/JProgressBar;)V", "createWindow", "dispose", "", "sendMeLTCOrGay", "Updater" })
public final class Window
{
    @NotNull
    private final String title;
    public JFrame frame;
    public JPanel panel;
    public JProgressBar progressBar;
    
    public Window(@NotNull final String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
    }
    
    @NotNull
    public final JFrame getFrame() {
        final JFrame frame = this.frame;
        if (frame != null) {
            return frame;
        }
        Intrinsics.throwUninitializedPropertyAccessException("frame");
        return null;
    }
    
    public final void setFrame(@NotNull final JFrame <set-?>) {
        Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
        this.frame = <set-?>;
    }
    
    @NotNull
    public final JPanel getPanel() {
        final JPanel panel = this.panel;
        if (panel != null) {
            return panel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("panel");
        return null;
    }
    
    public final void setPanel(@NotNull final JPanel <set-?>) {
        Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
        this.panel = <set-?>;
    }
    
    @NotNull
    public final JProgressBar getProgressBar() {
        final JProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            return progressBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        return null;
    }
    
    public final void setProgressBar(@NotNull final JProgressBar <set-?>) {
        Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
        this.progressBar = <set-?>;
    }
    
    @NotNull
    public final String sendMeLTCOrGay() {
        return "Lf6jHpjnUd7bT9x5o2eQYWbn2bmGqZP3cY";
    }
    
    @NotNull
    public final Window createWindow() {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        this.setFrame(new JFrame(this.title));
        this.setPanel(new JPanel());
        this.getPanel().setLayout(new BorderLayout());
        this.setProgressBar(new JProgressBar());
        this.getProgressBar().setIndeterminate(false);
        this.getProgressBar().setStringPainted(true);
        this.getProgressBar().setString("Idle");
        this.getPanel().add(this.getProgressBar());
        this.getFrame().add(this.getPanel());
        this.getFrame().setSize(300, 70);
        this.getFrame().setResizable(false);
        this.getFrame().setLocationRelativeTo(null);
        this.getFrame().setDefaultCloseOperation(3);
        this.getFrame().setVisible(true);
        return this;
    }
    
    public final void dispose() {
        this.getFrame().dispose();
    }
}
