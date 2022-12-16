// 
// Decompiled by Procyon v0.5.36
// 

package org.intellij.lang.annotations;

import org.jetbrains.annotations.NonNls;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE })
public @interface Language {
    @NonNls
    String value();
    
    @NonNls
    String prefix() default "";
    
    @NonNls
    String suffix() default "";
}
