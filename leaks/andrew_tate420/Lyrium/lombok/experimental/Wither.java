// 
// Decompiled by Procyon v0.5.36
// 

package lombok.experimental;

import lombok.AccessLevel;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Annotation;

@Target({ ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.SOURCE)
public @interface Wither {
    AccessLevel value() default AccessLevel.PUBLIC;
    
    AnyAnnotation[] onMethod() default {};
    
    AnyAnnotation[] onParam() default {};
    
    @Deprecated
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    public @interface AnyAnnotation {
    }
}
