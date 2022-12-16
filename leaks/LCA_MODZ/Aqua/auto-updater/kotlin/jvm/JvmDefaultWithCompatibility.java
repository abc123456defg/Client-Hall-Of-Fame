// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm;

import kotlin.SinceKotlin;
import kotlin.Metadata;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(AnnotationRetention.SOURCE)
@Target(allowedTargets = { AnnotationTarget.CLASS })
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
@java.lang.annotation.Target({ ElementType.TYPE })
@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b10\u0001¨\u0006\u0002" }, d2 = { "Lkotlin/jvm/JvmDefaultWithCompatibility;", "", "kotlin-stdlib" })
@SinceKotlin(version = "1.6")
public @interface JvmDefaultWithCompatibility {
}
