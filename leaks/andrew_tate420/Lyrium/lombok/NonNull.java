// 
// Decompiled by Procyon v0.5.36
// 

package lombok;

import java.lang.annotation.Documented;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Annotation;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
@Retention(RetentionPolicy.CLASS)
@Documented
public @interface NonNull {
}
