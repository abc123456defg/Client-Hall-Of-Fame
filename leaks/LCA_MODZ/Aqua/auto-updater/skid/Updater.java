// 
// Decompiled by Procyon v0.5.36
// 

package skid;

import kotlin.jvm.functions.Function1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007" }, d2 = { "Lskid/Updater;", "", "()V", "URL_BASE", "", "update", "", "Updater" })
public final class Updater
{
    @NotNull
    public static final Updater INSTANCE;
    @NotNull
    private static final String URL_BASE = "https://aquaclient.github.io/";
    
    private Updater() {
    }
    
    public final void update() {
        System.out.println((Object)"Starting update...");
        if (new File("Aqua.jar").delete()) {
            System.out.println((Object)"Deleted old Aqua.jar");
        }
        else {
            System.out.println((Object)"Failed to delete old Aqua.jar");
        }
        final Window window = new Window("Updating Aqua Client").createWindow();
        final FileDownload fileDownload = new FileDownload("https://aquaclient.github.io/Client.jar", "Aqua.jar");
        fileDownload.start((Function0<Unit>)new Updater$update.Updater$update$1(window));
        System.out.println((Object)"Started download");
        fileDownload.onProgress((Function1<? super Integer, Unit>)new Updater$update.Updater$update$2(window));
    }
    
    static {
        INSTANCE = new Updater();
    }
}
