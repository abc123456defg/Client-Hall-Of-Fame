// 
// Decompiled by Procyon v0.5.36
// 

package skid;

import java.awt.Component;
import javax.swing.JOptionPane;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006" }, d2 = { "main", "", "args", "", "", "([Ljava/lang/String;)V", "Updater" })
public final class MainKt
{
    public static final void main(@NotNull final String[] args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (args.length != 0 && Intrinsics.areEqual(args[0], "--update")) {
            Updater.INSTANCE.update();
            return;
        }
        JOptionPane.showMessageDialog(null, "Don't execute this manually!", "Aqua Client (Skid)", 0);
        throw new Exception("No arguments given");
    }
}
