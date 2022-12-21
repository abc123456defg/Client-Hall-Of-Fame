// 
// Decompiled by Procyon v0.5.36
// 

package edu.umd.cs.findbugs.annotations;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Documented;
import java.lang.annotation.Annotation;

@Documented
@Target({ ElementType.METHOD, ElementType.CONSTRUCTOR })
@Retention(RetentionPolicy.CLASS)
@Deprecated
public @interface CheckReturnValue {
    @Deprecated
    Priority priority() default Priority.MEDIUM;
    
    Confidence confidence() default Confidence.MEDIUM;
    
    String explanation() default "";
}
