// 
// Decompiled by Procyon v0.5.36
// 

package lombok;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Annotation;

@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR })
@Retention(RetentionPolicy.SOURCE)
public @interface Builder {
    String builderMethodName() default "builder";
    
    String buildMethodName() default "build";
    
    String builderClassName() default "";
    
    boolean toBuilder() default false;
    
    AccessLevel access() default AccessLevel.PUBLIC;
    
    String setterPrefix() default "";
    
    @Target({ ElementType.FIELD })
    @Retention(RetentionPolicy.SOURCE)
    public @interface Default {
    }
    
    @Target({ ElementType.FIELD, ElementType.PARAMETER })
    @Retention(RetentionPolicy.SOURCE)
    public @interface ObtainVia {
        String field() default "";
        
        String method() default "";
        
        boolean isStatic() default false;
    }
}
