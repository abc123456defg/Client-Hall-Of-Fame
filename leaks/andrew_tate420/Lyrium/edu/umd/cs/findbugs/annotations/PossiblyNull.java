// 
// Decompiled by Procyon v0.5.36
// 

package edu.umd.cs.findbugs.annotations;

import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.When;
import javax.annotation.Nonnull;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Documented;
import java.lang.annotation.Annotation;

@Documented
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE })
@Retention(RetentionPolicy.CLASS)
@Nonnull(when = When.MAYBE)
@Deprecated
@TypeQualifierNickname
public @interface PossiblyNull {
}
