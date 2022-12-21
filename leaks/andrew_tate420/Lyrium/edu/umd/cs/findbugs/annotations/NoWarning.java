// 
// Decompiled by Procyon v0.5.36
// 

package edu.umd.cs.findbugs.annotations;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.CLASS)
public @interface NoWarning {
    String value();
    
    Confidence confidence() default Confidence.LOW;
    
    int rank() default 20;
}
