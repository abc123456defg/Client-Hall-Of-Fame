// 
// Decompiled by Procyon v0.5.36
// 

package lombok;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Annotation;

@Target({ ElementType.LOCAL_VARIABLE })
@Retention(RetentionPolicy.SOURCE)
public @interface Cleanup {
    String value() default "close";
}
