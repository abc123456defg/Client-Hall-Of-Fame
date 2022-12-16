// 
// Decompiled by Procyon v0.5.36
// 

package org.intellij.lang.annotations;

import java.lang.annotation.Annotation;

@Pattern("(?:[^%]|%%|(?:%(?:\\d+\\$)?(?:[-#+ 0,(<]*)?(?:\\d+)?(?:\\.\\d+)?(?:[tT])?(?:[a-zA-Z%])))*")
public @interface PrintFormat {
}
