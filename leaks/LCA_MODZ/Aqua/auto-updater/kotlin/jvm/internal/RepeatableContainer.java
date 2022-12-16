// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.ANNOTATION_TYPE })
@SinceKotlin(version = "1.6")
public @interface RepeatableContainer {
}
