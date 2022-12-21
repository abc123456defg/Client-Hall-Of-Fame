// 
// Decompiled by Procyon v0.5.36
// 

package lombok;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Annotation;

@Target({ ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.CLASS)
public @interface Generated {
}
