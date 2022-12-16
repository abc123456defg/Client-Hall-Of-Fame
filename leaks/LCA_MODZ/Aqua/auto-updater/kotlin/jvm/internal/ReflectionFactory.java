// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm.internal;

import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import java.util.List;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KFunction;
import kotlin.SinceKotlin;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KClass;

public class ReflectionFactory
{
    private static final String KOTLIN_JVM_FUNCTIONS = "kotlin.jvm.functions.";
    
    public KClass createKotlinClass(final Class javaClass) {
        return new ClassReference(javaClass);
    }
    
    public KClass createKotlinClass(final Class javaClass, final String internalName) {
        return new ClassReference(javaClass);
    }
    
    public KDeclarationContainer getOrCreateKotlinPackage(final Class javaClass, final String moduleName) {
        return new PackageReference(javaClass, moduleName);
    }
    
    public KClass getOrCreateKotlinClass(final Class javaClass) {
        return new ClassReference(javaClass);
    }
    
    public KClass getOrCreateKotlinClass(final Class javaClass, final String internalName) {
        return new ClassReference(javaClass);
    }
    
    @SinceKotlin(version = "1.1")
    public String renderLambdaToString(final Lambda lambda) {
        return this.renderLambdaToString((FunctionBase)lambda);
    }
    
    @SinceKotlin(version = "1.3")
    public String renderLambdaToString(final FunctionBase lambda) {
        final String result = lambda.getClass().getGenericInterfaces()[0].toString();
        return result.startsWith("kotlin.jvm.functions.") ? result.substring("kotlin.jvm.functions.".length()) : result;
    }
    
    public KFunction function(final FunctionReference f) {
        return f;
    }
    
    public KProperty0 property0(final PropertyReference0 p) {
        return p;
    }
    
    public KMutableProperty0 mutableProperty0(final MutablePropertyReference0 p) {
        return p;
    }
    
    public KProperty1 property1(final PropertyReference1 p) {
        return p;
    }
    
    public KMutableProperty1 mutableProperty1(final MutablePropertyReference1 p) {
        return p;
    }
    
    public KProperty2 property2(final PropertyReference2 p) {
        return p;
    }
    
    public KMutableProperty2 mutableProperty2(final MutablePropertyReference2 p) {
        return p;
    }
    
    @SinceKotlin(version = "1.4")
    public KType typeOf(final KClassifier klass, final List<KTypeProjection> arguments, final boolean isMarkedNullable) {
        return new TypeReference(klass, arguments, isMarkedNullable);
    }
    
    @SinceKotlin(version = "1.4")
    public KTypeParameter typeParameter(final Object container, final String name, final KVariance variance, final boolean isReified) {
        return new TypeParameterReference(container, name, variance, isReified);
    }
    
    @SinceKotlin(version = "1.4")
    public void setUpperBounds(final KTypeParameter typeParameter, final List<KType> bounds) {
        ((TypeParameterReference)typeParameter).setUpperBounds(bounds);
    }
    
    @SinceKotlin(version = "1.6")
    public KType platformType(final KType lowerBound, final KType upperBound) {
        return new TypeReference(lowerBound.getClassifier(), lowerBound.getArguments(), upperBound, ((TypeReference)lowerBound).getFlags$kotlin_stdlib());
    }
    
    @SinceKotlin(version = "1.6")
    public KType mutableCollectionType(final KType type) {
        final TypeReference typeRef = (TypeReference)type;
        return new TypeReference(type.getClassifier(), type.getArguments(), typeRef.getPlatformTypeUpperBound$kotlin_stdlib(), typeRef.getFlags$kotlin_stdlib() | 0x2);
    }
    
    @SinceKotlin(version = "1.6")
    public KType nothingType(final KType type) {
        final TypeReference typeRef = (TypeReference)type;
        return new TypeReference(type.getClassifier(), type.getArguments(), typeRef.getPlatformTypeUpperBound$kotlin_stdlib(), typeRef.getFlags$kotlin_stdlib() | 0x4);
    }
}
