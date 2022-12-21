// 
// Decompiled by Procyon v0.5.36
// 

package lombok;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Annotation;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.SOURCE)
public @interface NoArgsConstructor {
    String staticName() default "";
    
    AnyAnnotation[] onConstructor() default {};
    
    AccessLevel access() default AccessLevel.PUBLIC;
    
    boolean force() default false;
    
    @Deprecated
    @Retention(RetentionPolicy.SOURCE)
    @Target({})
    public @interface AnyAnnotation {
    }
}
