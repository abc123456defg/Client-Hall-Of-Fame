// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KVisibility;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.SinceKotlin;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.reflect.KFunction;
import kotlin.KotlinNothingValueException;
import kotlin.reflect.KCallable;
import java.util.Collection;
import org.jetbrains.annotations.Nullable;
import java.util.HashMap;
import kotlin.Function;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;
import kotlin.reflect.KClass;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001OB\u0011\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010F\u001a\u00020\u00122\b\u0010G\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010H\u001a\u00020IH\u0002J\b\u0010J\u001a\u00020KH\u0016J\u0012\u0010L\u001a\u00020\u00122\b\u0010M\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010N\u001a\u000201H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010 \u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0014\u001a\u0004\b \u0010\u0015R\u001a\u0010\"\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0014\u001a\u0004\b\"\u0010\u0015R\u001a\u0010$\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0014\u001a\u0004\b$\u0010\u0015R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001e\u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0010R\u001e\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0010R\u0016\u0010-\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0016\u00100\u001a\u0004\u0018\u0001018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R(\u00104\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0014\u001a\u0004\b6\u0010\u000bR\u0016\u00107\u001a\u0004\u0018\u0001018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00103R \u00109\u001a\b\u0012\u0004\u0012\u00020:0\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0014\u001a\u0004\b<\u0010\u000bR \u0010=\u001a\b\u0012\u0004\u0012\u00020>0\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b?\u0010\u0014\u001a\u0004\b@\u0010\u000bR\u001c\u0010A\u001a\u0004\u0018\u00010B8VX\u0097\u0004¢\u0006\f\u0012\u0004\bC\u0010\u0014\u001a\u0004\bD\u0010E¨\u0006P" }, d2 = { "Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isFun", "isFun$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "isValue", "isValue$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "error", "", "hashCode", "", "isInstance", "value", "toString", "Companion", "kotlin-stdlib" })
public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Class<?> jClass;
    @NotNull
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES;
    @NotNull
    private static final HashMap<String, String> primitiveFqNames;
    @NotNull
    private static final HashMap<String, String> primitiveWrapperFqNames;
    @NotNull
    private static final HashMap<String, String> classFqNames;
    @NotNull
    private static final Map<String, String> simpleNames;
    
    public ClassReference(@NotNull final Class<?> jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.jClass = jClass;
    }
    
    @NotNull
    @Override
    public Class<?> getJClass() {
        return this.jClass;
    }
    
    @Nullable
    @Override
    public String getSimpleName() {
        return ClassReference.Companion.getClassSimpleName(this.getJClass());
    }
    
    @Nullable
    @Override
    public String getQualifiedName() {
        return ClassReference.Companion.getClassQualifiedName(this.getJClass());
    }
    
    @NotNull
    @Override
    public Collection<KCallable<?>> getMembers() {
        this.error();
        throw new KotlinNothingValueException();
    }
    
    @NotNull
    @Override
    public Collection<KFunction<Object>> getConstructors() {
        this.error();
        throw new KotlinNothingValueException();
    }
    
    @NotNull
    @Override
    public Collection<KClass<?>> getNestedClasses() {
        this.error();
        throw new KotlinNothingValueException();
    }
    
    @NotNull
    @Override
    public List<Annotation> getAnnotations() {
        this.error();
        throw new KotlinNothingValueException();
    }
    
    @Nullable
    @Override
    public Object getObjectInstance() {
        this.error();
        throw new KotlinNothingValueException();
    }
    
    @SinceKotlin(version = "1.1")
    @Override
    public boolean isInstance(@Nullable final Object value) {
        return ClassReference.Companion.isInstance(value, this.getJClass());
    }
    
    @NotNull
    @Override
    public List<KTypeParameter> getTypeParameters() {
        this.error();
        throw new KotlinNothingValueException();
    }
    
    @NotNull
    @Override
    public List<KType> getSupertypes() {
        this.error();
        throw new KotlinNothingValueException();
    }
    
    @NotNull
    @Override
    public List<KClass<?>> getSealedSubclasses() {
        this.error();
        throw new KotlinNothingValueException();
    }
    
    @Nullable
    @Override
    public KVisibility getVisibility() {
        this.error();
        throw new KotlinNothingValueException();
    }
    
    @Override
    public boolean isFinal() {
        this.error();
        throw new KotlinNothingValueException();
    }
    
    @Override
    public boolean isOpen() {
        this.error();
        throw new KotlinNothingValueException();
    }
    
    @Override
    public boolean isAbstract() {
        this.error();
        throw new KotlinNothingValueException();
    }
    
    @Override
    public boolean isSealed() {
        this.error();
        throw new KotlinNothingValueException();
    }
    
    @Override
    public boolean isData() {
        this.error();
        throw new KotlinNothingValueException();
    }
    
    @Override
    public boolean isInner() {
        this.error();
        throw new KotlinNothingValueException();
    }
    
    @Override
    public boolean isCompanion() {
        this.error();
        throw new KotlinNothingValueException();
    }
    
    @Override
    public boolean isFun() {
        this.error();
        throw new KotlinNothingValueException();
    }
    
    @Override
    public boolean isValue() {
        this.error();
        throw new KotlinNothingValueException();
    }
    
    private final Void error() {
        throw new KotlinReflectionNotSupportedError();
    }
    
    @Override
    public boolean equals(@Nullable final Object other) {
        return other instanceof ClassReference && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType((KClass<Object>)this), JvmClassMappingKt.getJavaObjectType((KClass<Object>)other));
    }
    
    @Override
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType((KClass<Object>)this).hashCode();
    }
    
    @NotNull
    @Override
    public String toString() {
        return this.getJClass().toString() + " (Kotlin reflection is not available)";
    }
    
    public static final /* synthetic */ Map access$getSimpleNames$cp() {
        return ClassReference.simpleNames;
    }
    
    public static final /* synthetic */ HashMap access$getClassFqNames$cp() {
        return ClassReference.classFqNames;
    }
    
    public static final /* synthetic */ Map access$getFUNCTION_CLASSES$cp() {
        return ClassReference.FUNCTION_CLASSES;
    }
    
    static {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aconst_null    
        //     5: invokespecial   kotlin/jvm/internal/ClassReference$Companion.<init>:(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        //     8: putstatic       kotlin/jvm/internal/ClassReference.Companion:Lkotlin/jvm/internal/ClassReference$Companion;
        //    11: bipush          23
        //    13: anewarray       Ljava/lang/Class;
        //    16: astore_0       
        //    17: aload_0        
        //    18: iconst_0       
        //    19: ldc             Lkotlin/jvm/functions/Function0;.class
        //    21: aastore        
        //    22: aload_0        
        //    23: iconst_1       
        //    24: ldc             Lkotlin/jvm/functions/Function1;.class
        //    26: aastore        
        //    27: aload_0        
        //    28: iconst_2       
        //    29: ldc             Lkotlin/jvm/functions/Function2;.class
        //    31: aastore        
        //    32: aload_0        
        //    33: iconst_3       
        //    34: ldc             Lkotlin/jvm/functions/Function3;.class
        //    36: aastore        
        //    37: aload_0        
        //    38: iconst_4       
        //    39: ldc             Lkotlin/jvm/functions/Function4;.class
        //    41: aastore        
        //    42: aload_0        
        //    43: iconst_5       
        //    44: ldc             Lkotlin/jvm/functions/Function5;.class
        //    46: aastore        
        //    47: aload_0        
        //    48: bipush          6
        //    50: ldc             Lkotlin/jvm/functions/Function6;.class
        //    52: aastore        
        //    53: aload_0        
        //    54: bipush          7
        //    56: ldc             Lkotlin/jvm/functions/Function7;.class
        //    58: aastore        
        //    59: aload_0        
        //    60: bipush          8
        //    62: ldc             Lkotlin/jvm/functions/Function8;.class
        //    64: aastore        
        //    65: aload_0        
        //    66: bipush          9
        //    68: ldc             Lkotlin/jvm/functions/Function9;.class
        //    70: aastore        
        //    71: aload_0        
        //    72: bipush          10
        //    74: ldc             Lkotlin/jvm/functions/Function10;.class
        //    76: aastore        
        //    77: aload_0        
        //    78: bipush          11
        //    80: ldc             Lkotlin/jvm/functions/Function11;.class
        //    82: aastore        
        //    83: aload_0        
        //    84: bipush          12
        //    86: ldc             Lkotlin/jvm/functions/Function12;.class
        //    88: aastore        
        //    89: aload_0        
        //    90: bipush          13
        //    92: ldc             Lkotlin/jvm/functions/Function13;.class
        //    94: aastore        
        //    95: aload_0        
        //    96: bipush          14
        //    98: ldc             Lkotlin/jvm/functions/Function14;.class
        //   100: aastore        
        //   101: aload_0        
        //   102: bipush          15
        //   104: ldc             Lkotlin/jvm/functions/Function15;.class
        //   106: aastore        
        //   107: aload_0        
        //   108: bipush          16
        //   110: ldc             Lkotlin/jvm/functions/Function16;.class
        //   112: aastore        
        //   113: aload_0        
        //   114: bipush          17
        //   116: ldc             Lkotlin/jvm/functions/Function17;.class
        //   118: aastore        
        //   119: aload_0        
        //   120: bipush          18
        //   122: ldc             Lkotlin/jvm/functions/Function18;.class
        //   124: aastore        
        //   125: aload_0        
        //   126: bipush          19
        //   128: ldc             Lkotlin/jvm/functions/Function19;.class
        //   130: aastore        
        //   131: aload_0        
        //   132: bipush          20
        //   134: ldc             Lkotlin/jvm/functions/Function20;.class
        //   136: aastore        
        //   137: aload_0        
        //   138: bipush          21
        //   140: ldc             Lkotlin/jvm/functions/Function21;.class
        //   142: aastore        
        //   143: aload_0        
        //   144: bipush          22
        //   146: ldc             Lkotlin/jvm/functions/Function22;.class
        //   148: aastore        
        //   149: aload_0        
        //   150: invokestatic    kotlin/collections/CollectionsKt.listOf:([Ljava/lang/Object;)Ljava/util/List;
        //   153: checkcast       Ljava/lang/Iterable;
        //   156: astore_0       
        //   157: nop            
        //   158: iconst_0       
        //   159: istore_1        /* $i$f$mapIndexed */
        //   160: aload_0         /* $this$mapIndexed$iv */
        //   161: astore_2       
        //   162: new             Ljava/util/ArrayList;
        //   165: dup            
        //   166: aload_0         /* $this$mapIndexed$iv */
        //   167: bipush          10
        //   169: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   172: invokespecial   java/util/ArrayList.<init>:(I)V
        //   175: checkcast       Ljava/util/Collection;
        //   178: astore_3        /* destination$iv$iv */
        //   179: iconst_0       
        //   180: istore          $i$f$mapIndexedTo
        //   182: iconst_0       
        //   183: istore          index$iv$iv
        //   185: aload_2         /* $this$mapIndexedTo$iv$iv */
        //   186: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   191: astore          6
        //   193: aload           6
        //   195: invokeinterface java/util/Iterator.hasNext:()Z
        //   200: ifeq            266
        //   203: aload           6
        //   205: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   210: astore          item$iv$iv
        //   212: aload_3         /* destination$iv$iv */
        //   213: iload           index$iv$iv
        //   215: iinc            index$iv$iv, 1
        //   218: istore          8
        //   220: iload           8
        //   222: ifge            228
        //   225: invokestatic    kotlin/collections/CollectionsKt.throwIndexOverflow:()V
        //   228: iload           8
        //   230: aload           item$iv$iv
        //   232: checkcast       Ljava/lang/Class;
        //   235: astore          9
        //   237: istore          10
        //   239: astore          15
        //   241: iconst_0       
        //   242: istore          $i$a$-mapIndexed-ClassReference$Companion$FUNCTION_CLASSES$1
        //   244: aload           clazz
        //   246: iload           i
        //   248: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   251: invokestatic    kotlin/TuplesKt.to:(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;
        //   254: aload           15
        //   256: swap           
        //   257: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   262: pop            
        //   263: goto            193
        //   266: aload_3         /* destination$iv$iv */
        //   267: checkcast       Ljava/util/List;
        //   270: nop            
        //   271: checkcast       Ljava/lang/Iterable;
        //   274: invokestatic    kotlin/collections/MapsKt.toMap:(Ljava/lang/Iterable;)Ljava/util/Map;
        //   277: putstatic       kotlin/jvm/internal/ClassReference.FUNCTION_CLASSES:Ljava/util/Map;
        //   280: new             Ljava/util/HashMap;
        //   283: dup            
        //   284: invokespecial   java/util/HashMap.<init>:()V
        //   287: astore_0       
        //   288: aload_0        
        //   289: astore_1        /* $this$primitiveFqNames_u24lambda_u241 */
        //   290: iconst_0       
        //   291: istore_2        /* $i$a$-apply-ClassReference$Companion$primitiveFqNames$1 */
        //   292: aload_1         /* $this$primitiveFqNames_u24lambda_u241 */
        //   293: ldc_w           "boolean"
        //   296: ldc_w           "kotlin.Boolean"
        //   299: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   302: pop            
        //   303: aload_1         /* $this$primitiveFqNames_u24lambda_u241 */
        //   304: ldc_w           "char"
        //   307: ldc_w           "kotlin.Char"
        //   310: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   313: pop            
        //   314: aload_1         /* $this$primitiveFqNames_u24lambda_u241 */
        //   315: ldc_w           "byte"
        //   318: ldc_w           "kotlin.Byte"
        //   321: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   324: pop            
        //   325: aload_1         /* $this$primitiveFqNames_u24lambda_u241 */
        //   326: ldc_w           "short"
        //   329: ldc_w           "kotlin.Short"
        //   332: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   335: pop            
        //   336: aload_1         /* $this$primitiveFqNames_u24lambda_u241 */
        //   337: ldc_w           "int"
        //   340: ldc_w           "kotlin.Int"
        //   343: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   346: pop            
        //   347: aload_1         /* $this$primitiveFqNames_u24lambda_u241 */
        //   348: ldc_w           "float"
        //   351: ldc_w           "kotlin.Float"
        //   354: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   357: pop            
        //   358: aload_1         /* $this$primitiveFqNames_u24lambda_u241 */
        //   359: ldc_w           "long"
        //   362: ldc_w           "kotlin.Long"
        //   365: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   368: pop            
        //   369: aload_1         /* $this$primitiveFqNames_u24lambda_u241 */
        //   370: ldc_w           "double"
        //   373: ldc_w           "kotlin.Double"
        //   376: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   379: pop            
        //   380: nop            
        //   381: aload_0        
        //   382: putstatic       kotlin/jvm/internal/ClassReference.primitiveFqNames:Ljava/util/HashMap;
        //   385: new             Ljava/util/HashMap;
        //   388: dup            
        //   389: invokespecial   java/util/HashMap.<init>:()V
        //   392: astore_0       
        //   393: aload_0        
        //   394: astore_1        /* $this$primitiveWrapperFqNames_u24lambda_u242 */
        //   395: iconst_0       
        //   396: istore_2        /* $i$a$-apply-ClassReference$Companion$primitiveWrapperFqNames$1 */
        //   397: aload_1         /* $this$primitiveWrapperFqNames_u24lambda_u242 */
        //   398: ldc_w           "java.lang.Boolean"
        //   401: ldc_w           "kotlin.Boolean"
        //   404: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   407: pop            
        //   408: aload_1         /* $this$primitiveWrapperFqNames_u24lambda_u242 */
        //   409: ldc_w           "java.lang.Character"
        //   412: ldc_w           "kotlin.Char"
        //   415: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   418: pop            
        //   419: aload_1         /* $this$primitiveWrapperFqNames_u24lambda_u242 */
        //   420: ldc_w           "java.lang.Byte"
        //   423: ldc_w           "kotlin.Byte"
        //   426: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   429: pop            
        //   430: aload_1         /* $this$primitiveWrapperFqNames_u24lambda_u242 */
        //   431: ldc_w           "java.lang.Short"
        //   434: ldc_w           "kotlin.Short"
        //   437: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   440: pop            
        //   441: aload_1         /* $this$primitiveWrapperFqNames_u24lambda_u242 */
        //   442: ldc_w           "java.lang.Integer"
        //   445: ldc_w           "kotlin.Int"
        //   448: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   451: pop            
        //   452: aload_1         /* $this$primitiveWrapperFqNames_u24lambda_u242 */
        //   453: ldc_w           "java.lang.Float"
        //   456: ldc_w           "kotlin.Float"
        //   459: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   462: pop            
        //   463: aload_1         /* $this$primitiveWrapperFqNames_u24lambda_u242 */
        //   464: ldc_w           "java.lang.Long"
        //   467: ldc_w           "kotlin.Long"
        //   470: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   473: pop            
        //   474: aload_1         /* $this$primitiveWrapperFqNames_u24lambda_u242 */
        //   475: ldc_w           "java.lang.Double"
        //   478: ldc_w           "kotlin.Double"
        //   481: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   484: pop            
        //   485: nop            
        //   486: aload_0        
        //   487: putstatic       kotlin/jvm/internal/ClassReference.primitiveWrapperFqNames:Ljava/util/HashMap;
        //   490: new             Ljava/util/HashMap;
        //   493: dup            
        //   494: invokespecial   java/util/HashMap.<init>:()V
        //   497: astore_0       
        //   498: aload_0        
        //   499: astore_1        /* $this$classFqNames_u24lambda_u244 */
        //   500: iconst_0       
        //   501: istore_2        /* $i$a$-apply-ClassReference$Companion$classFqNames$1 */
        //   502: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   503: ldc_w           "java.lang.Object"
        //   506: ldc_w           "kotlin.Any"
        //   509: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   512: pop            
        //   513: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   514: ldc_w           "java.lang.String"
        //   517: ldc_w           "kotlin.String"
        //   520: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   523: pop            
        //   524: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   525: ldc_w           "java.lang.CharSequence"
        //   528: ldc_w           "kotlin.CharSequence"
        //   531: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   534: pop            
        //   535: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   536: ldc_w           "java.lang.Throwable"
        //   539: ldc_w           "kotlin.Throwable"
        //   542: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   545: pop            
        //   546: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   547: ldc_w           "java.lang.Cloneable"
        //   550: ldc_w           "kotlin.Cloneable"
        //   553: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   556: pop            
        //   557: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   558: ldc_w           "java.lang.Number"
        //   561: ldc_w           "kotlin.Number"
        //   564: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   567: pop            
        //   568: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   569: ldc_w           "java.lang.Comparable"
        //   572: ldc_w           "kotlin.Comparable"
        //   575: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   578: pop            
        //   579: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   580: ldc_w           "java.lang.Enum"
        //   583: ldc_w           "kotlin.Enum"
        //   586: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   589: pop            
        //   590: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   591: ldc_w           "java.lang.annotation.Annotation"
        //   594: ldc_w           "kotlin.Annotation"
        //   597: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   600: pop            
        //   601: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   602: ldc_w           "java.lang.Iterable"
        //   605: ldc_w           "kotlin.collections.Iterable"
        //   608: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   611: pop            
        //   612: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   613: ldc_w           "java.util.Iterator"
        //   616: ldc_w           "kotlin.collections.Iterator"
        //   619: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   622: pop            
        //   623: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   624: ldc_w           "java.util.Collection"
        //   627: ldc_w           "kotlin.collections.Collection"
        //   630: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   633: pop            
        //   634: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   635: ldc_w           "java.util.List"
        //   638: ldc_w           "kotlin.collections.List"
        //   641: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   644: pop            
        //   645: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   646: ldc_w           "java.util.Set"
        //   649: ldc_w           "kotlin.collections.Set"
        //   652: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   655: pop            
        //   656: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   657: ldc_w           "java.util.ListIterator"
        //   660: ldc_w           "kotlin.collections.ListIterator"
        //   663: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   666: pop            
        //   667: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   668: ldc_w           "java.util.Map"
        //   671: ldc_w           "kotlin.collections.Map"
        //   674: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   677: pop            
        //   678: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   679: ldc_w           "java.util.Map$Entry"
        //   682: ldc_w           "kotlin.collections.Map.Entry"
        //   685: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   688: pop            
        //   689: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   690: ldc_w           "kotlin.jvm.internal.StringCompanionObject"
        //   693: ldc_w           "kotlin.String.Companion"
        //   696: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   699: pop            
        //   700: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   701: ldc_w           "kotlin.jvm.internal.EnumCompanionObject"
        //   704: ldc_w           "kotlin.Enum.Companion"
        //   707: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   710: pop            
        //   711: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   712: getstatic       kotlin/jvm/internal/ClassReference.primitiveFqNames:Ljava/util/HashMap;
        //   715: checkcast       Ljava/util/Map;
        //   718: invokevirtual   java/util/HashMap.putAll:(Ljava/util/Map;)V
        //   721: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   722: getstatic       kotlin/jvm/internal/ClassReference.primitiveWrapperFqNames:Ljava/util/HashMap;
        //   725: checkcast       Ljava/util/Map;
        //   728: invokevirtual   java/util/HashMap.putAll:(Ljava/util/Map;)V
        //   731: getstatic       kotlin/jvm/internal/ClassReference.primitiveFqNames:Ljava/util/HashMap;
        //   734: invokevirtual   java/util/HashMap.values:()Ljava/util/Collection;
        //   737: dup            
        //   738: ldc_w           "primitiveFqNames.values"
        //   741: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   744: checkcast       Ljava/lang/Iterable;
        //   747: astore_3        /* $this$associateTo$iv */
        //   748: iconst_0       
        //   749: istore          $i$f$associateTo
        //   751: aload_3         /* $this$associateTo$iv */
        //   752: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   757: astore          5
        //   759: aload           5
        //   761: invokeinterface java/util/Iterator.hasNext:()Z
        //   766: ifeq            884
        //   769: aload           5
        //   771: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   776: astore          element$iv
        //   778: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   779: checkcast       Ljava/util/Map;
        //   782: astore          7
        //   784: aload           element$iv
        //   786: checkcast       Ljava/lang/String;
        //   789: astore          kotlinName
        //   791: iconst_0       
        //   792: istore          $i$a$-associateTo-ClassReference$Companion$classFqNames$1$1
        //   794: new             Ljava/lang/StringBuilder;
        //   797: dup            
        //   798: invokespecial   java/lang/StringBuilder.<init>:()V
        //   801: ldc_w           "kotlin.jvm.internal."
        //   804: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   807: aload           kotlinName
        //   809: ldc_w           "kotlinName"
        //   812: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   815: aload           kotlinName
        //   817: bipush          46
        //   819: aconst_null    
        //   820: iconst_2       
        //   821: aconst_null    
        //   822: invokestatic    kotlin/text/StringsKt.substringAfterLast$default:(Ljava/lang/String;CLjava/lang/String;ILjava/lang/Object;)Ljava/lang/String;
        //   825: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   828: ldc_w           "CompanionObject"
        //   831: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   834: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   837: new             Ljava/lang/StringBuilder;
        //   840: dup            
        //   841: invokespecial   java/lang/StringBuilder.<init>:()V
        //   844: aload           kotlinName
        //   846: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   849: ldc_w           ".Companion"
        //   852: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   855: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   858: invokestatic    kotlin/TuplesKt.to:(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;
        //   861: astore          null
        //   863: aload           7
        //   865: aload           8
        //   867: invokevirtual   kotlin/Pair.getFirst:()Ljava/lang/Object;
        //   870: aload           8
        //   872: invokevirtual   kotlin/Pair.getSecond:()Ljava/lang/Object;
        //   875: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   880: pop            
        //   881: goto            759
        //   884: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   885: checkcast       Ljava/util/Map;
        //   888: pop            
        //   889: getstatic       kotlin/jvm/internal/ClassReference.FUNCTION_CLASSES:Ljava/util/Map;
        //   892: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //   897: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //   902: astore_3       
        //   903: aload_3        
        //   904: invokeinterface java/util/Iterator.hasNext:()Z
        //   909: ifeq            984
        //   912: aload_3        
        //   913: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   918: checkcast       Ljava/util/Map$Entry;
        //   921: astore          4
        //   923: aload           4
        //   925: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   930: checkcast       Ljava/lang/Class;
        //   933: astore          klass
        //   935: aload           4
        //   937: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   942: checkcast       Ljava/lang/Number;
        //   945: invokevirtual   java/lang/Number.intValue:()I
        //   948: istore          arity
        //   950: aload_1         /* $this$classFqNames_u24lambda_u244 */
        //   951: aload           klass
        //   953: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //   956: new             Ljava/lang/StringBuilder;
        //   959: dup            
        //   960: invokespecial   java/lang/StringBuilder.<init>:()V
        //   963: ldc_w           "kotlin.Function"
        //   966: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   969: iload           arity
        //   971: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   974: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   977: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   980: pop            
        //   981: goto            903
        //   984: nop            
        //   985: aload_0        
        //   986: putstatic       kotlin/jvm/internal/ClassReference.classFqNames:Ljava/util/HashMap;
        //   989: getstatic       kotlin/jvm/internal/ClassReference.classFqNames:Ljava/util/HashMap;
        //   992: checkcast       Ljava/util/Map;
        //   995: astore_0        /* $this$mapValues$iv */
        //   996: iconst_0       
        //   997: istore_1        /* $i$f$mapValues */
        //   998: aload_0         /* $this$mapValues$iv */
        //   999: astore_2       
        //  1000: new             Ljava/util/LinkedHashMap;
        //  1003: dup            
        //  1004: aload_0         /* $this$mapValues$iv */
        //  1005: invokeinterface java/util/Map.size:()I
        //  1010: invokestatic    kotlin/collections/MapsKt.mapCapacity:(I)I
        //  1013: invokespecial   java/util/LinkedHashMap.<init>:(I)V
        //  1016: checkcast       Ljava/util/Map;
        //  1019: astore_3        /* destination$iv$iv */
        //  1020: iconst_0       
        //  1021: istore          $i$f$mapValuesTo
        //  1023: aload_2         /* $this$mapValuesTo$iv$iv */
        //  1024: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //  1029: checkcast       Ljava/lang/Iterable;
        //  1032: astore          $this$associateByTo$iv$iv$iv
        //  1034: iconst_0       
        //  1035: istore          $i$f$associateByTo
        //  1037: aload           $this$associateByTo$iv$iv$iv
        //  1039: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //  1044: astore          7
        //  1046: aload           7
        //  1048: invokeinterface java/util/Iterator.hasNext:()Z
        //  1053: ifeq            1141
        //  1056: aload           7
        //  1058: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //  1063: astore          element$iv$iv$iv
        //  1065: aload_3         /* destination$iv$iv */
        //  1066: aload           element$iv$iv$iv
        //  1068: checkcast       Ljava/util/Map$Entry;
        //  1071: astore          9
        //  1073: astore          10
        //  1075: iconst_0       
        //  1076: istore          $i$a$-associateByTo-MapsKt__MapsKt$mapValuesTo$1$iv$iv
        //  1078: aload           it$iv$iv
        //  1080: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //  1085: aload           10
        //  1087: swap           
        //  1088: aload           element$iv$iv$iv
        //  1090: checkcast       Ljava/util/Map$Entry;
        //  1093: astore          12
        //  1095: astore          16
        //  1097: astore          15
        //  1099: iconst_0       
        //  1100: istore          $i$a$-mapValues-ClassReference$Companion$simpleNames$1
        //  1102: aload           12
        //  1104: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //  1109: checkcast       Ljava/lang/String;
        //  1112: astore          fqName
        //  1114: aload           fqName
        //  1116: bipush          46
        //  1118: aconst_null    
        //  1119: iconst_2       
        //  1120: aconst_null    
        //  1121: invokestatic    kotlin/text/StringsKt.substringAfterLast$default:(Ljava/lang/String;CLjava/lang/String;ILjava/lang/Object;)Ljava/lang/String;
        //  1124: astore          17
        //  1126: aload           15
        //  1128: aload           16
        //  1130: aload           17
        //  1132: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  1137: pop            
        //  1138: goto            1046
        //  1141: aload_3         /* destination$iv$iv */
        //  1142: nop            
        //  1143: nop            
        //  1144: putstatic       kotlin/jvm/internal/ClassReference.simpleNames:Ljava/util/Map;
        //  1147: return         
        //    StackMapTable: 00 09 FF 00 C1 00 07 07 00 DE 01 07 00 DE 07 00 E9 01 01 07 00 EF 00 00 FF 00 22 00 09 07 00 DE 01 07 00 DE 07 00 E9 01 01 07 00 EF 07 00 05 01 00 01 07 00 E9 F9 00 25 FF 01 EC 00 07 07 01 11 07 01 11 01 07 00 DE 01 07 00 EF 07 00 05 00 00 FB 00 7C FF 00 12 00 06 07 01 11 07 01 11 01 07 00 EF 00 07 00 05 00 00 FB 00 50 FF 00 3D 00 08 07 01 9A 01 07 01 9A 07 01 9A 01 07 00 DE 01 07 00 EF 00 00 FB 00 5E
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005R&\u0010\u0003\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015" }, d2 = { "Lkotlin/jvm/internal/ClassReference$Companion;", "", "()V", "FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "classFqNames", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "primitiveFqNames", "primitiveWrapperFqNames", "simpleNames", "getClassQualifiedName", "jClass", "getClassSimpleName", "isInstance", "", "value", "kotlin-stdlib" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @Nullable
        public final String getClassSimpleName(@NotNull final Class<?> jClass) {
            Intrinsics.checkNotNullParameter(jClass, "jClass");
            String s;
            if (jClass.isAnonymousClass()) {
                s = null;
            }
            else if (jClass.isLocalClass()) {
                final String name = jClass.getSimpleName();
                final Method enclosingMethod = jClass.getEnclosingMethod();
                if (enclosingMethod != null) {
                    final Method method = enclosingMethod;
                    final int n = 0;
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    if ((s = StringsKt__StringsKt.substringAfter$default(name, method.getName() + '$', null, 2, null)) != null) {
                        return s;
                    }
                }
                final Constructor enclosingConstructor = jClass.getEnclosingConstructor();
                if (enclosingConstructor != null) {
                    final Constructor constructor = enclosingConstructor;
                    final int n2 = 0;
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    s = StringsKt__StringsKt.substringAfter$default(name, constructor.getName() + '$', null, 2, null);
                }
                else {
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    s = StringsKt__StringsKt.substringAfter$default(name, '$', null, 2, null);
                }
            }
            else if (jClass.isArray()) {
                final Class componentType = jClass.getComponentType();
                String s2;
                if (componentType.isPrimitive()) {
                    final String str = ClassReference.access$getSimpleNames$cp().get(componentType.getName());
                    s = (s2 = ((str != null) ? (str + "Array") : null));
                }
                else {
                    s = (s2 = null);
                }
                if (s2 == null) {
                    s = "Array";
                }
            }
            else if ((s = ClassReference.access$getSimpleNames$cp().get(jClass.getName())) == null) {
                s = jClass.getSimpleName();
            }
            return s;
        }
        
        @Nullable
        public final String getClassQualifiedName(@NotNull final Class<?> jClass) {
            Intrinsics.checkNotNullParameter(jClass, "jClass");
            String canonicalName;
            if (jClass.isAnonymousClass()) {
                canonicalName = null;
            }
            else if (jClass.isLocalClass()) {
                canonicalName = null;
            }
            else if (jClass.isArray()) {
                final Class componentType = jClass.getComponentType();
                String s;
                if (componentType.isPrimitive()) {
                    final String str = ClassReference.access$getClassFqNames$cp().get(componentType.getName());
                    canonicalName = (s = ((str != null) ? (str + "Array") : null));
                }
                else {
                    canonicalName = (s = null);
                }
                if (s == null) {
                    canonicalName = "kotlin.Array";
                }
            }
            else if ((canonicalName = ClassReference.access$getClassFqNames$cp().get(jClass.getName())) == null) {
                canonicalName = jClass.getCanonicalName();
            }
            return canonicalName;
        }
        
        public final boolean isInstance(@Nullable final Object value, @NotNull final Class<?> jClass) {
            Intrinsics.checkNotNullParameter(jClass, "jClass");
            final Map access$getFUNCTION_CLASSES$cp = ClassReference.access$getFUNCTION_CLASSES$cp();
            Intrinsics.checkNotNull(access$getFUNCTION_CLASSES$cp, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            final Integer n = access$getFUNCTION_CLASSES$cp.get(jClass);
            if (n != null) {
                final int arity = n.intValue();
                final int n2 = 0;
                return TypeIntrinsics.isFunctionOfArity(value, arity);
            }
            final Class objectType = jClass.isPrimitive() ? JvmClassMappingKt.getJavaObjectType((KClass<?>)JvmClassMappingKt.getKotlinClass(jClass)) : jClass;
            return objectType.isInstance(value);
        }
    }
}
