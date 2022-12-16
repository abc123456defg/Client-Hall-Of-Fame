// 
// Decompiled by Procyon v0.5.36
// 

package org.intellij.lang.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.SOURCE)
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE, ElementType.METHOD })
public @interface MagicConstant {
    long[] intValues() default {};
    
    String[] stringValues() default {};
    
    long[] flags() default {};
    
    Class valuesFromClass() default void.class;
    
    Class flagsFromClass() default void.class;
}
