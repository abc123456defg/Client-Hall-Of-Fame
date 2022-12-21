// 
// Decompiled by Procyon v0.5.36
// 

package lombok.experimental;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Annotation;

@Target({ ElementType.TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.SOURCE)
public @interface Accessors {
    boolean fluent() default false;
    
    boolean chain() default false;
    
    boolean makeFinal() default false;
    
    String[] prefix() default {};
}
