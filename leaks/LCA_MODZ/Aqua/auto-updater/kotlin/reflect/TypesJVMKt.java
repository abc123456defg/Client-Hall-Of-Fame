// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.reflect;

import kotlin.sequences.Sequence;
import kotlin.jvm.functions.Function1;
import kotlin.NoWhenBranchMatchedException;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.KTypeBase;
import kotlin.jvm.internal.Intrinsics;
import java.lang.reflect.Type;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 2, xi = 48, d1 = { "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\"\u0010\n\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0003\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0003\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00078BX\u0083\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\b\u001a\u0004\b\u0005\u0010\t¨\u0006\u0015" }, d2 = { "javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "Lkotlin/reflect/KTypeProjection;", "(Lkotlin/reflect/KTypeProjection;)V", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "createPossiblyInnerType", "jClass", "Ljava/lang/Class;", "arguments", "", "typeToString", "", "type", "computeJavaType", "forceWrapper", "", "kotlin-stdlib" })
public final class TypesJVMKt
{
    @NotNull
    public static final Type getJavaType(@NotNull final KType $this$javaType) {
        Intrinsics.checkNotNullParameter($this$javaType, "<this>");
        if ($this$javaType instanceof KTypeBase) {
            final Type javaType = ((KTypeBase)$this$javaType).getJavaType();
            if (javaType != null) {
                final Type it = javaType;
                final int n = 0;
                return it;
            }
        }
        return computeJavaType$default($this$javaType, false, 1, null);
    }
    
    @ExperimentalStdlibApi
    private static final Type computeJavaType(final KType $this$computeJavaType, final boolean forceWrapper) {
        final KClassifier classifier = $this$computeJavaType.getClassifier();
        if (classifier instanceof KTypeParameter) {
            return new TypeVariableImpl((KTypeParameter)classifier);
        }
        if (!(classifier instanceof KClass)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + $this$computeJavaType);
        }
        final Class jClass = forceWrapper ? JvmClassMappingKt.getJavaObjectType((KClass<Object>)classifier) : JvmClassMappingKt.getJavaClass((KClass<Object>)classifier);
        final List arguments = $this$computeJavaType.getArguments();
        if (arguments.isEmpty()) {
            return jClass;
        }
        if (!jClass.isArray()) {
            return createPossiblyInnerType(jClass, arguments);
        }
        if (jClass.getComponentType().isPrimitive()) {
            return jClass;
        }
        final KTypeProjection kTypeProjection = CollectionsKt___CollectionsKt.singleOrNull((List<? extends KTypeProjection>)arguments);
        if (kTypeProjection == null) {
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + $this$computeJavaType);
        }
        final KTypeProjection kTypeProjection2 = kTypeProjection;
        final KVariance variance = kTypeProjection2.component1();
        final KType elementType = kTypeProjection2.component2();
        final KVariance kVariance = variance;
        Type type = null;
        switch ((kVariance == null) ? -1 : WhenMappings.$EnumSwitchMapping$0[kVariance.ordinal()]) {
            case -1:
            case 1: {
                type = jClass;
                break;
            }
            case 2:
            case 3: {
                final KType object = elementType;
                Intrinsics.checkNotNull(object);
                final Type javaElementType = computeJavaType$default(object, false, 1, null);
                type = ((javaElementType instanceof Class) ? ((Class)jClass) : ((GenericArrayTypeImpl)new GenericArrayTypeImpl(javaElementType)));
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return type;
    }
    
    static /* synthetic */ Type computeJavaType$default(final KType $this$computeJavaType, boolean forceWrapper, final int n, final Object o) {
        if ((n & 0x1) != 0x0) {
            forceWrapper = false;
        }
        return computeJavaType($this$computeJavaType, forceWrapper);
    }
    
    @ExperimentalStdlibApi
    private static final Type createPossiblyInnerType(final Class<?> jClass, final List<KTypeProjection> arguments) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   java/lang/Class.getDeclaringClass:()Ljava/lang/Class;
        //     4: astore_3       
        //     5: aload_3        
        //     6: ifnonnull       146
        //     9: aload_0         /* jClass */
        //    10: aconst_null    
        //    11: aload_1         /* arguments */
        //    12: checkcast       Ljava/lang/Iterable;
        //    15: astore          4
        //    17: astore          14
        //    19: astore          13
        //    21: iconst_0       
        //    22: istore          $i$f$map
        //    24: aload           $this$map$iv
        //    26: astore          6
        //    28: new             Ljava/util/ArrayList;
        //    31: dup            
        //    32: aload           $this$map$iv
        //    34: bipush          10
        //    36: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    39: invokespecial   java/util/ArrayList.<init>:(I)V
        //    42: checkcast       Ljava/util/Collection;
        //    45: astore          destination$iv$iv
        //    47: iconst_0       
        //    48: istore          $i$f$mapTo
        //    50: aload           $this$mapTo$iv$iv
        //    52: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    57: astore          9
        //    59: aload           9
        //    61: invokeinterface java/util/Iterator.hasNext:()Z
        //    66: ifeq            109
        //    69: aload           9
        //    71: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    76: astore          item$iv$iv
        //    78: aload           destination$iv$iv
        //    80: aload           item$iv$iv
        //    82: checkcast       Lkotlin/reflect/KTypeProjection;
        //    85: astore          11
        //    87: astore          15
        //    89: iconst_0       
        //    90: istore          $i$a$-map-TypesJVMKt$createPossiblyInnerType$ownerClass$1
        //    92: aload           p0
        //    94: invokestatic    kotlin/reflect/TypesJVMKt.getJavaType:(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;
        //    97: aload           15
        //    99: swap           
        //   100: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   105: pop            
        //   106: goto            59
        //   109: aload           destination$iv$iv
        //   111: checkcast       Ljava/util/List;
        //   114: nop            
        //   115: astore          15
        //   117: aload           13
        //   119: aload           14
        //   121: aload           15
        //   123: astore          16
        //   125: astore          17
        //   127: astore          18
        //   129: new             Lkotlin/reflect/ParameterizedTypeImpl;
        //   132: dup            
        //   133: aload           18
        //   135: aload           17
        //   137: aload           16
        //   139: invokespecial   kotlin/reflect/ParameterizedTypeImpl.<init>:(Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/util/List;)V
        //   142: checkcast       Ljava/lang/reflect/Type;
        //   145: areturn        
        //   146: aload_3        
        //   147: astore_2        /* ownerClass */
        //   148: aload_0         /* jClass */
        //   149: invokevirtual   java/lang/Class.getModifiers:()I
        //   152: invokestatic    java/lang/reflect/Modifier.isStatic:(I)Z
        //   155: ifeq            295
        //   158: aload_0         /* jClass */
        //   159: aload_2         /* ownerClass */
        //   160: checkcast       Ljava/lang/reflect/Type;
        //   163: aload_1         /* arguments */
        //   164: checkcast       Ljava/lang/Iterable;
        //   167: astore_3       
        //   168: astore          14
        //   170: astore          13
        //   172: iconst_0       
        //   173: istore          $i$f$map
        //   175: aload_3         /* $this$map$iv */
        //   176: astore          5
        //   178: new             Ljava/util/ArrayList;
        //   181: dup            
        //   182: aload_3         /* $this$map$iv */
        //   183: bipush          10
        //   185: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   188: invokespecial   java/util/ArrayList.<init>:(I)V
        //   191: checkcast       Ljava/util/Collection;
        //   194: astore          destination$iv$iv
        //   196: iconst_0       
        //   197: istore          $i$f$mapTo
        //   199: aload           $this$mapTo$iv$iv
        //   201: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   206: astore          8
        //   208: aload           8
        //   210: invokeinterface java/util/Iterator.hasNext:()Z
        //   215: ifeq            258
        //   218: aload           8
        //   220: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   225: astore          item$iv$iv
        //   227: aload           destination$iv$iv
        //   229: aload           item$iv$iv
        //   231: checkcast       Lkotlin/reflect/KTypeProjection;
        //   234: astore          10
        //   236: astore          15
        //   238: iconst_0       
        //   239: istore          $i$a$-map-TypesJVMKt$createPossiblyInnerType$1
        //   241: aload           p0
        //   243: invokestatic    kotlin/reflect/TypesJVMKt.getJavaType:(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;
        //   246: aload           15
        //   248: swap           
        //   249: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   254: pop            
        //   255: goto            208
        //   258: aload           destination$iv$iv
        //   260: checkcast       Ljava/util/List;
        //   263: nop            
        //   264: astore          15
        //   266: aload           13
        //   268: aload           14
        //   270: aload           15
        //   272: astore          19
        //   274: astore          20
        //   276: astore          21
        //   278: new             Lkotlin/reflect/ParameterizedTypeImpl;
        //   281: dup            
        //   282: aload           21
        //   284: aload           20
        //   286: aload           19
        //   288: invokespecial   kotlin/reflect/ParameterizedTypeImpl.<init>:(Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/util/List;)V
        //   291: checkcast       Ljava/lang/reflect/Type;
        //   294: areturn        
        //   295: aload_0         /* jClass */
        //   296: invokevirtual   java/lang/Class.getTypeParameters:()[Ljava/lang/reflect/TypeVariable;
        //   299: arraylength    
        //   300: istore_3        /* n */
        //   301: aload_0         /* jClass */
        //   302: aload_2         /* ownerClass */
        //   303: aload_1         /* arguments */
        //   304: iload_3         /* n */
        //   305: aload_1         /* arguments */
        //   306: invokeinterface java/util/List.size:()I
        //   311: invokeinterface java/util/List.subList:(II)Ljava/util/List;
        //   316: invokestatic    kotlin/reflect/TypesJVMKt.createPossiblyInnerType:(Ljava/lang/Class;Ljava/util/List;)Ljava/lang/reflect/Type;
        //   319: aload_1         /* arguments */
        //   320: iconst_0       
        //   321: iload_3         /* n */
        //   322: invokeinterface java/util/List.subList:(II)Ljava/util/List;
        //   327: checkcast       Ljava/lang/Iterable;
        //   330: astore          4
        //   332: astore          14
        //   334: astore          13
        //   336: iconst_0       
        //   337: istore          $i$f$map
        //   339: aload           $this$map$iv
        //   341: astore          6
        //   343: new             Ljava/util/ArrayList;
        //   346: dup            
        //   347: aload           $this$map$iv
        //   349: bipush          10
        //   351: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   354: invokespecial   java/util/ArrayList.<init>:(I)V
        //   357: checkcast       Ljava/util/Collection;
        //   360: astore          destination$iv$iv
        //   362: iconst_0       
        //   363: istore          $i$f$mapTo
        //   365: aload           $this$mapTo$iv$iv
        //   367: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   372: astore          9
        //   374: aload           9
        //   376: invokeinterface java/util/Iterator.hasNext:()Z
        //   381: ifeq            424
        //   384: aload           9
        //   386: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   391: astore          item$iv$iv
        //   393: aload           destination$iv$iv
        //   395: aload           item$iv$iv
        //   397: checkcast       Lkotlin/reflect/KTypeProjection;
        //   400: astore          11
        //   402: astore          15
        //   404: iconst_0       
        //   405: istore          $i$a$-map-TypesJVMKt$createPossiblyInnerType$2
        //   407: aload           p0
        //   409: invokestatic    kotlin/reflect/TypesJVMKt.getJavaType:(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;
        //   412: aload           15
        //   414: swap           
        //   415: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   420: pop            
        //   421: goto            374
        //   424: aload           destination$iv$iv
        //   426: checkcast       Ljava/util/List;
        //   429: nop            
        //   430: astore          15
        //   432: aload           13
        //   434: aload           14
        //   436: aload           15
        //   438: astore          22
        //   440: astore          23
        //   442: astore          24
        //   444: new             Lkotlin/reflect/ParameterizedTypeImpl;
        //   447: dup            
        //   448: aload           24
        //   450: aload           23
        //   452: aload           22
        //   454: invokespecial   kotlin/reflect/ParameterizedTypeImpl.<init>:(Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/util/List;)V
        //   457: checkcast       Ljava/lang/reflect/Type;
        //   460: areturn        
        //    Signature:
        //  (Ljava/lang/Class<*>;Ljava/util/List<Lkotlin/reflect/KTypeProjection;>;)Ljava/lang/reflect/Type;
        //    StackMapTable: 00 08 FF 00 3B 00 0F 07 00 4E 07 00 48 00 07 00 4E 07 00 B7 01 07 00 B7 07 00 C2 01 07 00 C8 00 00 00 07 00 4E 05 00 00 31 FF 00 24 00 04 07 00 4E 07 00 48 00 07 00 4E 00 00 FF 00 3D 00 0F 07 00 4E 07 00 48 07 00 4E 07 00 B7 01 07 00 B7 07 00 C2 01 07 00 C8 00 00 00 00 07 00 4E 07 00 37 00 00 31 FF 00 24 00 04 07 00 4E 07 00 48 07 00 4E 07 00 4E 00 00 FF 00 4E 00 0F 07 00 4E 07 00 48 07 00 4E 01 07 00 B7 01 07 00 B7 07 00 C2 01 07 00 C8 00 00 00 07 00 4E 07 00 37 00 00 31
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static final Type getJavaType(final KTypeProjection $this$javaType) {
        final KVariance variance2 = $this$javaType.getVariance();
        if (variance2 == null) {
            return WildcardTypeImpl.Companion.getSTAR();
        }
        final KVariance variance = variance2;
        final KType type2 = $this$javaType.getType();
        Intrinsics.checkNotNull(type2);
        final KType type = type2;
        Type computeJavaType = null;
        switch (WhenMappings.$EnumSwitchMapping$0[variance.ordinal()]) {
            case 2: {
                computeJavaType = computeJavaType(type, true);
                break;
            }
            case 1: {
                computeJavaType = new WildcardTypeImpl(null, computeJavaType(type, true));
                break;
            }
            case 3: {
                computeJavaType = new WildcardTypeImpl(computeJavaType(type, true), null);
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return computeJavaType;
    }
    
    private static final String typeToString(final Type type) {
        String string;
        if (type instanceof Class) {
            String s;
            if (((Class)type).isArray()) {
                final Sequence unwrap = SequencesKt__SequencesKt.generateSequence(type, (Function1<? super Type, ? extends Type>)TypesJVMKt$typeToString$unwrap.TypesJVMKt$typeToString$unwrap$1.INSTANCE);
                s = SequencesKt___SequencesKt.last((Sequence<? extends Class>)unwrap).getName() + StringsKt__StringsJVMKt.repeat("[]", SequencesKt___SequencesKt.count((Sequence<?>)unwrap));
            }
            else {
                s = ((Class)type).getName();
            }
            final String value = s;
            Intrinsics.checkNotNullExpressionValue(value, "{\n        if (type.isArr\u2026   } else type.name\n    }");
            string = value;
        }
        else {
            string = type.toString();
        }
        return string;
    }
}
