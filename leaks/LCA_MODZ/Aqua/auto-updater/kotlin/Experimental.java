// 
// Decompiled by Procyon v0.5.36
// 

package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Target;
import java.lang.annotation.Annotation;

@Target(allowedTargets = { AnnotationTarget.ANNOTATION_CLASS })
@Retention(AnnotationRetention.BINARY)
@DeprecatedSinceKotlin(warningSince = "1.4", errorSince = "1.6")
@Deprecated(message = "Please use RequiresOptIn instead.")
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
@java.lang.annotation.Target({ ElementType.ANNOTATION_TYPE })
@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\n\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0006" }, d2 = { "Lkotlin/Experimental;", "", "level", "Lkotlin/Experimental$Level;", "()Lkotlin/Experimental$Level;", "Level", "kotlin-stdlib" })
@SinceKotlin(version = "1.2")
public @interface Experimental {
    Level level() default Level.ERROR;
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005" }, d2 = { "Lkotlin/Experimental$Level;", "", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "kotlin-stdlib" })
    public enum Level
    {
        WARNING, 
        ERROR;
        
        private static final /* synthetic */ Level[] $values() {
            return new Level[] { Level.WARNING, Level.ERROR };
        }
        
        static {
            $VALUES = $values();
        }
    }
}
