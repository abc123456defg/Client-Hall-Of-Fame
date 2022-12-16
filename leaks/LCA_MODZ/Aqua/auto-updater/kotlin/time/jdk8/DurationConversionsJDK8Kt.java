// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.time.jdk8;

import kotlin.internal.InlineOnly;
import kotlin.time.ExperimentalTime;
import kotlin.WasExperimental;
import kotlin.SinceKotlin;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.jvm.internal.Intrinsics;
import java.time.Duration;
import kotlin.jvm.JvmName;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u0002*\u00020\u0001H\u0087\b\u00f8\u0001\u0001¢\u0006\u0002\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0007" }, d2 = { "toJavaDuration", "Ljava/time/Duration;", "Lkotlin/time/Duration;", "toJavaDuration-LRDsOJo", "(J)Ljava/time/Duration;", "toKotlinDuration", "(Ljava/time/Duration;)J", "kotlin-stdlib-jdk8" }, pn = "kotlin.time")
@JvmName(name = "DurationConversionsJDK8Kt")
public final class DurationConversionsJDK8Kt
{
    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = { ExperimentalTime.class })
    @InlineOnly
    private static final long toKotlinDuration(final Duration $this$toKotlinDuration) {
        Intrinsics.checkNotNullParameter($this$toKotlinDuration, "<this>");
        return kotlin.time.Duration.plus-LRDsOJo(DurationKt.toDuration($this$toKotlinDuration.getSeconds(), DurationUnit.SECONDS), DurationKt.toDuration($this$toKotlinDuration.getNano(), DurationUnit.NANOSECONDS));
    }
    
    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = { ExperimentalTime.class })
    @InlineOnly
    private static final Duration toJavaDuration-LRDsOJo(final long $this$toJavaDuration_u2dLRDsOJo) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_2        /* $i$f$toComponents-impl */
        //     2: nop            
        //     3: lload_0         /* $this$toJavaDuration_u2dLRDsOJo */
        //     4: invokestatic    kotlin/time/Duration.getInWholeSeconds-impl:(J)J
        //     7: lload_0         /* $this$toJavaDuration_u2dLRDsOJo */
        //     8: invokestatic    kotlin/time/Duration.getNanosecondsComponent-impl:(J)I
        //    11: istore_3       
        //    12: lstore          seconds
        //    14: iconst_0       
        //    15: istore          $i$a$-toComponents-impl-DurationConversionsJDK8Kt$toJavaDuration$1
        //    17: lload           seconds
        //    19: iload_3         /* nanoseconds */
        //    20: i2l            
        //    21: invokestatic    java/time/Duration.ofSeconds:(JJ)Ljava/time/Duration;
        //    24: nop            
        //    25: dup            
        //    26: ldc             "toJavaDuration-LRDsOJo"
        //    28: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    31: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
