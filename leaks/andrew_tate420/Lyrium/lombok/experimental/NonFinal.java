// 
// Decompiled by Procyon v0.5.36
// 

package lombok.experimental;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Annotation;

@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.SOURCE)
public @interface NonFinal {
}
