// 
// Decompiled by Procyon v0.5.36
// 

package edu.umd.cs.findbugs.annotations;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import javax.annotation.meta.TypeQualifierDefault;
import javax.annotation.Nonnull;
import java.lang.annotation.Documented;
import java.lang.annotation.Annotation;

@Documented
@Nonnull
@TypeQualifierDefault({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
public @interface ReturnValuesAreNonnullByDefault {
}
