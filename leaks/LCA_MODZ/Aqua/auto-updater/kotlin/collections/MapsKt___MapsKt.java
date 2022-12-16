// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.collections;

import kotlin.jvm.functions.Function2;
import java.util.Comparator;
import java.util.Set;
import kotlin.internal.HidesMembers;
import kotlin.Unit;
import java.util.Collection;
import kotlin.jvm.JvmName;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.sequences.Sequence;
import java.util.ArrayList;
import kotlin.Pair;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import kotlin.internal.InlineOnly;
import kotlin.SinceKotlin;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.functions.Function1;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000f\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aJ\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\b\u00f8\u0001\u0000\u001a$\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001aJ\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\b\u00f8\u0001\u0000\u001a9\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004H\u0087\b\u001a6\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001a'\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004H\u0087\b\u001aJ\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\b\u00f8\u0001\u0000\u001a[\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a]\u0010\u0014\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a\\\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\n0\u0006H\u0086\b\u00f8\u0001\u0000\u001aa\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\f0\u0006H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\b\u0017\u001au\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\n0\u0006H\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u001c\u001aw\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\f0\u0006H\u0087\b\u00f8\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001c\u001aJ\u0010\u001e\u001a\u00020\u001f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010 \u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001f0\u0006H\u0087\b\u00f8\u0001\u0000\u001aV\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0086\b\u00f8\u0001\u0000\u001a\\\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0086\b\u00f8\u0001\u0000\u001au\u0010#\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u001c\u001ao\u0010$\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u001c\u001ak\u0010%\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\b(\u001ah\u0010)\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000\u001a_\u0010*\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010+\u001aJ\u0010*\u001a\u00020,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\b\u00f8\u0001\u0000\u001aJ\u0010*\u001a\u00020-\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020-0\u0006H\u0087\b\u00f8\u0001\u0000\u001aa\u0010.\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010+\u001aQ\u0010.\u001a\u0004\u0018\u00010,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010/\u001aQ\u0010.\u001a\u0004\u0018\u00010-\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020-0\u0006H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u00100\u001aq\u00101\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00102\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u001003j\n\u0012\u0006\b\u0000\u0012\u0002H\u0010`42\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u00105\u001as\u00106\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00102\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u001003j\n\u0012\u0006\b\u0000\u0012\u0002H\u0010`42\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u00105\u001al\u00107\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00102\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000703j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`4H\u0087\b¢\u0006\u0002\b8\u001ai\u00109\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00102\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000703j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`4H\u0087\b\u001ak\u0010:\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\b;\u001ah\u0010<\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000\u001a_\u0010=\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010+\u001aJ\u0010=\u001a\u00020,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\b\u00f8\u0001\u0000\u001aJ\u0010=\u001a\u00020-\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020-0\u0006H\u0087\b\u00f8\u0001\u0000\u001aa\u0010>\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010+\u001aQ\u0010>\u001a\u0004\u0018\u00010,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010/\u001aQ\u0010>\u001a\u0004\u0018\u00010-\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020-0\u0006H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u00100\u001aq\u0010?\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00102\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u001003j\n\u0012\u0006\b\u0000\u0012\u0002H\u0010`42\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u00105\u001as\u0010@\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00102\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u001003j\n\u0012\u0006\b\u0000\u0012\u0002H\u0010`42\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u00105\u001al\u0010A\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00102\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000703j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`4H\u0087\b¢\u0006\u0002\bB\u001ai\u0010C\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00102\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000703j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`4H\u0087\b\u001a$\u0010D\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001aJ\u0010D\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\b\u00f8\u0001\u0000\u001aY\u0010E\u001a\u0002HF\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0016\b\u0002\u0010F*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004*\u0002HF2\u001e\u0010 \u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001f0\u0006H\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010G\u001an\u0010H\u001a\u0002HF\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0016\b\u0002\u0010F*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004*\u0002HF23\u0010 \u001a/\u0012\u0013\u0012\u00110\u000e¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001f0IH\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010M\u001a6\u0010N\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030O0\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006P" }, d2 = { "all", "", "K", "V", "", "predicate", "Lkotlin/Function1;", "", "any", "asIterable", "", "asSequence", "Lkotlin/sequences/Sequence;", "count", "", "firstNotNullOf", "R", "", "transform", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstNotNullOfOrNull", "flatMap", "", "flatMapSequence", "flatMapTo", "C", "", "destination", "(Ljava/util/Map;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "flatMapSequenceTo", "forEach", "", "action", "map", "mapNotNull", "mapNotNullTo", "mapTo", "maxBy", "", "selector", "maxByOrThrow", "maxByOrNull", "maxOf", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "", "", "maxOfOrNull", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "maxOfWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/Map;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "maxOfWithOrNull", "maxWith", "maxWithOrThrow", "maxWithOrNull", "minBy", "minByOrThrow", "minByOrNull", "minOf", "minOfOrNull", "minOfWith", "minOfWithOrNull", "minWith", "minWithOrThrow", "minWithOrNull", "none", "onEach", "M", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "onEachIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "toList", "Lkotlin/Pair;", "kotlin-stdlib" }, xs = "kotlin/collections/MapsKt")
class MapsKt___MapsKt extends MapsKt___MapsJvmKt
{
    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <K, V, R> R firstNotNullOf(final Map<? extends K, ? extends V> $this$firstNotNullOf, final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Intrinsics.checkNotNullParameter($this$firstNotNullOf, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        final Iterator<Map.Entry<? extends K, ? extends V>> iterator = $this$firstNotNullOf.entrySet().iterator();
        while (true) {
            while (iterator.hasNext()) {
                final Object invoke;
                final Object o;
                if ((o = (invoke = transform.invoke((Object)iterator.next()))) == null) {
                    continue;
                }
                if (o == null) {
                    throw new NoSuchElementException("No element of the map was transformed to a non-null value.");
                }
                return (R)invoke;
            }
            Object o;
            Object invoke = o = null;
            continue;
        }
    }
    
    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <K, V, R> R firstNotNullOfOrNull(final Map<? extends K, ? extends V> $this$firstNotNullOfOrNull, final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Intrinsics.checkNotNullParameter($this$firstNotNullOfOrNull, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (final Map.Entry element : $this$firstNotNullOfOrNull.entrySet()) {
            final Object result = transform.invoke((Object)element);
            if (result != null) {
                return (R)result;
            }
        }
        return null;
    }
    
    @NotNull
    public static final <K, V> List<Pair<K, V>> toList(@NotNull final Map<? extends K, ? extends V> $this$toList) {
        Intrinsics.checkNotNullParameter($this$toList, "<this>");
        if ($this$toList.size() == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        final Iterator iterator = $this$toList.entrySet().iterator();
        if (!iterator.hasNext()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        final Map.Entry first = (Map.Entry)iterator.next();
        if (!iterator.hasNext()) {
            final Map.Entry entry = first;
            return CollectionsKt__CollectionsJVMKt.listOf(new Pair<K, V>(entry.getKey(), entry.getValue()));
        }
        final ArrayList<Pair<Object, V>> list;
        final ArrayList result = list = new ArrayList<Pair<Object, V>>($this$toList.size());
        final Map.Entry entry2 = first;
        list.add((Pair<Object, V>)new Pair<Object, Object>(entry2.getKey(), entry2.getValue()));
        do {
            final ArrayList list2 = result;
            final Map.Entry<Object, V> entry3 = iterator.next();
            list2.add(new Pair<Object, Object>(entry3.getKey(), entry3.getValue()));
        } while (iterator.hasNext());
        return (List<Pair<K, V>>)result;
    }
    
    @NotNull
    public static final <K, V, R> List<R> flatMap(@NotNull final Map<? extends K, ? extends V> $this$flatMap, @NotNull final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> transform) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* transform */
        //     7: ldc             "transform"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: iconst_0       
        //    13: istore_2        /* $i$f$flatMap */
        //    14: aload_0         /* $this$flatMap */
        //    15: astore_3       
        //    16: new             Ljava/util/ArrayList;
        //    19: dup            
        //    20: invokespecial   java/util/ArrayList.<init>:()V
        //    23: checkcast       Ljava/util/Collection;
        //    26: astore          destination$iv
        //    28: iconst_0       
        //    29: istore          $i$f$flatMapTo
        //    31: aload_3         /* $this$flatMapTo$iv */
        //    32: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //    37: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    42: astore          6
        //    44: aload           6
        //    46: invokeinterface java/util/Iterator.hasNext:()Z
        //    51: ifeq            90
        //    54: aload           6
        //    56: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    61: checkcast       Ljava/util/Map$Entry;
        //    64: astore          element$iv
        //    66: aload_1         /* transform */
        //    67: aload           element$iv
        //    69: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //    74: checkcast       Ljava/lang/Iterable;
        //    77: astore          list$iv
        //    79: aload           destination$iv
        //    81: aload           list$iv
        //    83: invokestatic    kotlin/collections/CollectionsKt.addAll:(Ljava/util/Collection;Ljava/lang/Iterable;)Z
        //    86: pop            
        //    87: goto            44
        //    90: aload           destination$iv
        //    92: checkcast       Ljava/util/List;
        //    95: areturn        
        //    Signature:
        //  <K:Ljava/lang/Object;V:Ljava/lang/Object;R:Ljava/lang/Object;>(Ljava/util/Map<+TK;+TV;>;Lkotlin/jvm/functions/Function1<-Ljava/util/Map$Entry<+TK;+TV;>;+Ljava/lang/Iterable<+TR;>;>;)Ljava/util/List<TR;>;
        //    StackMapTable: 00 02 FF 00 2C 00 07 07 00 17 07 00 2F 01 07 00 17 07 00 7A 01 07 00 23 00 00 2D
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "flatMapSequence")
    @NotNull
    public static final <K, V, R> List<R> flatMapSequence(@NotNull final Map<? extends K, ? extends V> $this$flatMap, @NotNull final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> transform) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* transform */
        //     7: ldc             "transform"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: iconst_0       
        //    13: istore_2        /* $i$f$flatMapSequence */
        //    14: aload_0         /* $this$flatMap */
        //    15: astore_3       
        //    16: new             Ljava/util/ArrayList;
        //    19: dup            
        //    20: invokespecial   java/util/ArrayList.<init>:()V
        //    23: checkcast       Ljava/util/Collection;
        //    26: astore          destination$iv
        //    28: iconst_0       
        //    29: istore          $i$f$flatMapSequenceTo
        //    31: aload_3         /* $this$flatMapTo$iv */
        //    32: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //    37: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    42: astore          6
        //    44: aload           6
        //    46: invokeinterface java/util/Iterator.hasNext:()Z
        //    51: ifeq            90
        //    54: aload           6
        //    56: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    61: checkcast       Ljava/util/Map$Entry;
        //    64: astore          element$iv
        //    66: aload_1         /* transform */
        //    67: aload           element$iv
        //    69: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //    74: checkcast       Lkotlin/sequences/Sequence;
        //    77: astore          list$iv
        //    79: aload           destination$iv
        //    81: aload           list$iv
        //    83: invokestatic    kotlin/collections/CollectionsKt.addAll:(Ljava/util/Collection;Lkotlin/sequences/Sequence;)Z
        //    86: pop            
        //    87: goto            44
        //    90: aload           destination$iv
        //    92: checkcast       Ljava/util/List;
        //    95: areturn        
        //    Signature:
        //  <K:Ljava/lang/Object;V:Ljava/lang/Object;R:Ljava/lang/Object;>(Ljava/util/Map<+TK;+TV;>;Lkotlin/jvm/functions/Function1<-Ljava/util/Map$Entry<+TK;+TV;>;+Lkotlin/sequences/Sequence<+TR;>;>;)Ljava/util/List<TR;>;
        //    StackMapTable: 00 02 FF 00 2C 00 07 07 00 17 07 00 2F 01 07 00 17 07 00 7A 01 07 00 23 00 00 2D
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @NotNull
    public static final <K, V, R, C extends Collection<? super R>> C flatMapTo(@NotNull final Map<? extends K, ? extends V> $this$flatMapTo, @NotNull final C destination, @NotNull final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter($this$flatMapTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        final int $i$f$flatMapTo = 0;
        for (final Map.Entry element : $this$flatMapTo.entrySet()) {
            final Iterable list = (Iterable)transform.invoke((Object)element);
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super Object>)destination, (Iterable<?>)list);
        }
        return destination;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "flatMapSequenceTo")
    @NotNull
    public static final <K, V, R, C extends Collection<? super R>> C flatMapSequenceTo(@NotNull final Map<? extends K, ? extends V> $this$flatMapTo, @NotNull final C destination, @NotNull final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter($this$flatMapTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        final int $i$f$flatMapSequenceTo = 0;
        for (final Map.Entry element : $this$flatMapTo.entrySet()) {
            final Sequence list = (Sequence)transform.invoke((Object)element);
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super Object>)destination, (Sequence<?>)list);
        }
        return destination;
    }
    
    @NotNull
    public static final <K, V, R> List<R> map(@NotNull final Map<? extends K, ? extends V> $this$map, @NotNull final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* transform */
        //     7: ldc             "transform"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: iconst_0       
        //    13: istore_2        /* $i$f$map */
        //    14: aload_0         /* $this$map */
        //    15: astore_3       
        //    16: new             Ljava/util/ArrayList;
        //    19: dup            
        //    20: aload_0         /* $this$map */
        //    21: invokeinterface java/util/Map.size:()I
        //    26: invokespecial   java/util/ArrayList.<init>:(I)V
        //    29: checkcast       Ljava/util/Collection;
        //    32: astore          destination$iv
        //    34: iconst_0       
        //    35: istore          $i$f$mapTo
        //    37: aload_3         /* $this$mapTo$iv */
        //    38: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //    43: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    48: astore          6
        //    50: aload           6
        //    52: invokeinterface java/util/Iterator.hasNext:()Z
        //    57: ifeq            91
        //    60: aload           6
        //    62: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    67: checkcast       Ljava/util/Map$Entry;
        //    70: astore          item$iv
        //    72: aload           destination$iv
        //    74: aload_1         /* transform */
        //    75: aload           item$iv
        //    77: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //    82: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //    87: pop            
        //    88: goto            50
        //    91: aload           destination$iv
        //    93: checkcast       Ljava/util/List;
        //    96: areturn        
        //    Signature:
        //  <K:Ljava/lang/Object;V:Ljava/lang/Object;R:Ljava/lang/Object;>(Ljava/util/Map<+TK;+TV;>;Lkotlin/jvm/functions/Function1<-Ljava/util/Map$Entry<+TK;+TV;>;+TR;>;)Ljava/util/List<TR;>;
        //    StackMapTable: 00 02 FF 00 32 00 07 07 00 17 07 00 2F 01 07 00 17 07 00 7A 01 07 00 23 00 00 28
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @NotNull
    public static final <K, V, R> List<R> mapNotNull(@NotNull final Map<? extends K, ? extends V> $this$mapNotNull, @NotNull final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* transform */
        //     7: ldc             "transform"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: iconst_0       
        //    13: istore_2        /* $i$f$mapNotNull */
        //    14: aload_0         /* $this$mapNotNull */
        //    15: astore_3       
        //    16: new             Ljava/util/ArrayList;
        //    19: dup            
        //    20: invokespecial   java/util/ArrayList.<init>:()V
        //    23: checkcast       Ljava/util/Collection;
        //    26: astore          destination$iv
        //    28: iconst_0       
        //    29: istore          $i$f$mapNotNullTo
        //    31: aload_3         /* $this$mapNotNullTo$iv */
        //    32: astore          $this$forEach$iv$iv
        //    34: iconst_0       
        //    35: istore          $i$f$forEach
        //    37: aload           $this$forEach$iv$iv
        //    39: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //    44: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    49: astore          8
        //    51: aload           8
        //    53: invokeinterface java/util/Iterator.hasNext:()Z
        //    58: ifeq            120
        //    61: aload           8
        //    63: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    68: checkcast       Ljava/util/Map$Entry;
        //    71: astore          element$iv$iv
        //    73: aload           element$iv$iv
        //    75: astore          element$iv
        //    77: iconst_0       
        //    78: istore          $i$a$-forEach-MapsKt___MapsKt$mapNotNullTo$1$iv
        //    80: aload_1         /* transform */
        //    81: aload           element$iv
        //    83: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //    88: dup            
        //    89: ifnull          114
        //    92: astore          12
        //    94: aload           12
        //    96: astore          it$iv
        //    98: iconst_0       
        //    99: istore          $i$a$-let-MapsKt___MapsKt$mapNotNullTo$1$1$iv
        //   101: aload           destination$iv
        //   103: aload           it$iv
        //   105: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   110: pop            
        //   111: goto            116
        //   114: pop            
        //   115: nop            
        //   116: nop            
        //   117: goto            51
        //   120: nop            
        //   121: aload           destination$iv
        //   123: checkcast       Ljava/util/List;
        //   126: areturn        
        //    Signature:
        //  <K:Ljava/lang/Object;V:Ljava/lang/Object;R:Ljava/lang/Object;>(Ljava/util/Map<+TK;+TV;>;Lkotlin/jvm/functions/Function1<-Ljava/util/Map$Entry<+TK;+TV;>;+TR;>;)Ljava/util/List<TR;>;
        //    StackMapTable: 00 04 FF 00 33 00 09 07 00 17 07 00 2F 01 07 00 17 07 00 7A 01 07 00 17 01 07 00 23 00 00 FF 00 3E 00 0C 07 00 17 07 00 2F 01 07 00 17 07 00 7A 01 07 00 17 01 07 00 23 07 00 2D 07 00 2D 01 00 01 07 00 40 01 F8 00 03
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @NotNull
    public static final <K, V, R, C extends Collection<? super R>> C mapNotNullTo(@NotNull final Map<? extends K, ? extends V> $this$mapNotNullTo, @NotNull final C destination, @NotNull final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Intrinsics.checkNotNullParameter($this$mapNotNullTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        final int $i$f$mapNotNullTo = 0;
        final Map $this$forEach$iv = $this$mapNotNullTo;
        final int $i$f$forEach = 0;
        for (final Map.Entry element : $this$forEach$iv.entrySet()) {
            final Map.Entry element$iv = element;
            final int n = 0;
            final R invoke = (R)transform.invoke((Object)element);
            if (invoke != null) {
                final Object it = invoke;
                final int n2 = 0;
                destination.add((Object)it);
            }
        }
        return destination;
    }
    
    @NotNull
    public static final <K, V, R, C extends Collection<? super R>> C mapTo(@NotNull final Map<? extends K, ? extends V> $this$mapTo, @NotNull final C destination, @NotNull final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Intrinsics.checkNotNullParameter($this$mapTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        final int $i$f$mapTo = 0;
        for (final Map.Entry item : $this$mapTo.entrySet()) {
            destination.add((Object)transform.invoke((Object)item));
        }
        return destination;
    }
    
    public static final <K, V> boolean all(@NotNull final Map<? extends K, ? extends V> $this$all, @NotNull final Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$all, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        final int $i$f$all = 0;
        if ($this$all.isEmpty()) {
            return true;
        }
        for (final Map.Entry element : $this$all.entrySet()) {
            if (!predicate.invoke((Object)element)) {
                return false;
            }
        }
        return true;
    }
    
    public static final <K, V> boolean any(@NotNull final Map<? extends K, ? extends V> $this$any) {
        Intrinsics.checkNotNullParameter($this$any, "<this>");
        return !$this$any.isEmpty();
    }
    
    public static final <K, V> boolean any(@NotNull final Map<? extends K, ? extends V> $this$any, @NotNull final Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$any, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        final int $i$f$any = 0;
        if ($this$any.isEmpty()) {
            return false;
        }
        for (final Map.Entry element : $this$any.entrySet()) {
            if (predicate.invoke((Object)element)) {
                return true;
            }
        }
        return false;
    }
    
    @InlineOnly
    private static final <K, V> int count(final Map<? extends K, ? extends V> $this$count) {
        Intrinsics.checkNotNullParameter($this$count, "<this>");
        return $this$count.size();
    }
    
    public static final <K, V> int count(@NotNull final Map<? extends K, ? extends V> $this$count, @NotNull final Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$count, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        final int $i$f$count = 0;
        if ($this$count.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (final Map.Entry element : $this$count.entrySet()) {
            if (predicate.invoke((Object)element)) {
                ++count;
            }
        }
        return count;
    }
    
    @HidesMembers
    public static final <K, V> void forEach(@NotNull final Map<? extends K, ? extends V> $this$forEach, @NotNull final Function1<? super Map.Entry<? extends K, ? extends V>, Unit> action) {
        Intrinsics.checkNotNullParameter($this$forEach, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        final int $i$f$forEach = 0;
        for (final Map.Entry element : $this$forEach.entrySet()) {
            action.invoke((Object)element);
        }
    }
    
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxByOrThrow(final Map<? extends K, ? extends V> $this$maxBy, final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Intrinsics.checkNotNullParameter($this$maxBy, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final Iterable $this$maxBy$iv = $this$maxBy.entrySet();
        final int $i$f$maxByOrThrow = 0;
        final Iterator iterator$iv = $this$maxBy$iv.iterator();
        if (!iterator$iv.hasNext()) {
            throw new NoSuchElementException();
        }
        Object maxElem$iv = iterator$iv.next();
        Object o;
        if (!iterator$iv.hasNext()) {
            o = maxElem$iv;
        }
        else {
            Comparable maxValue$iv = (Comparable)selector.invoke((Object)maxElem$iv);
            do {
                final Object e$iv = iterator$iv.next();
                final Comparable v$iv = (Comparable)selector.invoke((Object)e$iv);
                if (maxValue$iv.compareTo(v$iv) < 0) {
                    maxElem$iv = e$iv;
                    maxValue$iv = v$iv;
                }
            } while (iterator$iv.hasNext());
            o = maxElem$iv;
        }
        return (Map.Entry<K, V>)o;
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxByOrNull(final Map<? extends K, ? extends V> $this$maxByOrNull, final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Intrinsics.checkNotNullParameter($this$maxByOrNull, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final Iterable $this$maxByOrNull$iv = $this$maxByOrNull.entrySet();
        final int $i$f$maxByOrNull = 0;
        final Iterator iterator$iv = $this$maxByOrNull$iv.iterator();
        Object o;
        if (!iterator$iv.hasNext()) {
            o = null;
        }
        else {
            Object maxElem$iv = iterator$iv.next();
            if (!iterator$iv.hasNext()) {
                o = maxElem$iv;
            }
            else {
                Comparable maxValue$iv = (Comparable)selector.invoke((Object)maxElem$iv);
                do {
                    final Object e$iv = iterator$iv.next();
                    final Comparable v$iv = (Comparable)selector.invoke((Object)e$iv);
                    if (maxValue$iv.compareTo(v$iv) < 0) {
                        maxElem$iv = e$iv;
                        maxValue$iv = v$iv;
                    }
                } while (iterator$iv.hasNext());
                o = maxElem$iv;
            }
        }
        return (Map.Entry<K, V>)o;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> double maxOf(final Map<? extends K, ? extends V> $this$maxOf, final Function1<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        Intrinsics.checkNotNullParameter($this$maxOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final Iterator<? super Map.Entry<? extends K, ? extends V>> iterator = $this$maxOf.entrySet().iterator();
        if (!iterator.hasNext()) {
            throw new NoSuchElementException();
        }
        double a = selector.invoke(iterator.next()).doubleValue();
        while (iterator.hasNext()) {
            a = Math.max(a, selector.invoke(iterator.next()).doubleValue());
        }
        return a;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> float maxOf(final Map<? extends K, ? extends V> $this$maxOf, final Function1<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        Intrinsics.checkNotNullParameter($this$maxOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final Iterator<? super Map.Entry<? extends K, ? extends V>> iterator = $this$maxOf.entrySet().iterator();
        if (!iterator.hasNext()) {
            throw new NoSuchElementException();
        }
        float a = selector.invoke(iterator.next()).floatValue();
        while (iterator.hasNext()) {
            a = Math.max(a, selector.invoke(iterator.next()).floatValue());
        }
        return a;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> R maxOf(final Map<? extends K, ? extends V> $this$maxOf, final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Intrinsics.checkNotNullParameter($this$maxOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final Iterator<? super Map.Entry<? extends K, ? extends V>> iterator = $this$maxOf.entrySet().iterator();
        if (!iterator.hasNext()) {
            throw new NoSuchElementException();
        }
        Comparable<Comparable> comparable = (Comparable<Comparable>)selector.invoke(iterator.next());
        while (iterator.hasNext()) {
            final Comparable comparable2 = (Comparable)selector.invoke(iterator.next());
            if (comparable.compareTo(comparable2) < 0) {
                comparable = (Comparable<Comparable>)comparable2;
            }
        }
        return (R)comparable;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> Double maxOfOrNull(final Map<? extends K, ? extends V> $this$maxOfOrNull, final Function1<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        Intrinsics.checkNotNullParameter($this$maxOfOrNull, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final Iterator<Object> iterator = $this$maxOfOrNull.entrySet().iterator();
        Double value;
        if (!iterator.hasNext()) {
            value = null;
        }
        else {
            double n = selector.invoke((Object)iterator.next()).doubleValue();
            while (iterator.hasNext()) {
                n = Math.max(n, selector.invoke((Object)iterator.next()).doubleValue());
            }
            value = n;
        }
        return value;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> Float maxOfOrNull(final Map<? extends K, ? extends V> $this$maxOfOrNull, final Function1<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        Intrinsics.checkNotNullParameter($this$maxOfOrNull, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final Iterator<Object> iterator = $this$maxOfOrNull.entrySet().iterator();
        Float value;
        if (!iterator.hasNext()) {
            value = null;
        }
        else {
            float n = selector.invoke((Object)iterator.next()).floatValue();
            while (iterator.hasNext()) {
                n = Math.max(n, selector.invoke((Object)iterator.next()).floatValue());
            }
            value = n;
        }
        return value;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> R maxOfOrNull(final Map<? extends K, ? extends V> $this$maxOfOrNull, final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Intrinsics.checkNotNullParameter($this$maxOfOrNull, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final Iterator<Object> iterator = $this$maxOfOrNull.entrySet().iterator();
        Comparable<? super R> comparable;
        if (!iterator.hasNext()) {
            comparable = null;
        }
        else {
            Comparable<? super Comparable> comparable2 = (Comparable<? super Comparable>)selector.invoke((Object)iterator.next());
            while (iterator.hasNext()) {
                final Comparable comparable3 = (Comparable)selector.invoke((Object)iterator.next());
                if (comparable2.compareTo(comparable3) < 0) {
                    comparable2 = (Comparable<? super Comparable>)comparable3;
                }
            }
            comparable = comparable2;
        }
        return (R)comparable;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R> R maxOfWith(final Map<? extends K, ? extends V> $this$maxOfWith, final Comparator<? super R> comparator, final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Intrinsics.checkNotNullParameter($this$maxOfWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final Iterator<? super Map.Entry<? extends K, ? extends V>> iterator = $this$maxOfWith.entrySet().iterator();
        if (!iterator.hasNext()) {
            throw new NoSuchElementException();
        }
        R invoke = (R)selector.invoke(iterator.next());
        while (iterator.hasNext()) {
            final R invoke2 = (R)selector.invoke(iterator.next());
            if (comparator.compare(invoke, invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R> R maxOfWithOrNull(final Map<? extends K, ? extends V> $this$maxOfWithOrNull, final Comparator<? super R> comparator, final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Intrinsics.checkNotNullParameter($this$maxOfWithOrNull, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final Iterator<Object> iterator = $this$maxOfWithOrNull.entrySet().iterator();
        R r;
        if (!iterator.hasNext()) {
            r = null;
        }
        else {
            R invoke = (R)selector.invoke((Object)iterator.next());
            while (iterator.hasNext()) {
                final R invoke2 = (R)selector.invoke((Object)iterator.next());
                if (comparator.compare(invoke, invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            r = invoke;
        }
        return r;
    }
    
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    @InlineOnly
    private static final <K, V> Map.Entry<K, V> maxWithOrThrow(final Map<? extends K, ? extends V> $this$maxWith, final Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.checkNotNullParameter($this$maxWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (Map.Entry<K, V>)CollectionsKt___CollectionsKt.maxWithOrThrow((Iterable<? extends Map.Entry>)$this$maxWith.entrySet(), (Comparator<? super Map.Entry>)comparator);
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V> Map.Entry<K, V> maxWithOrNull(final Map<? extends K, ? extends V> $this$maxWithOrNull, final Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.checkNotNullParameter($this$maxWithOrNull, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (Map.Entry<K, V>)CollectionsKt___CollectionsKt.maxWithOrNull((Iterable<? extends Map.Entry>)$this$maxWithOrNull.entrySet(), (Comparator<? super Map.Entry>)comparator);
    }
    
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minByOrThrow(final Map<? extends K, ? extends V> $this$minBy, final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Intrinsics.checkNotNullParameter($this$minBy, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final Iterable $this$minBy$iv = $this$minBy.entrySet();
        final int $i$f$minByOrThrow = 0;
        final Iterator iterator$iv = $this$minBy$iv.iterator();
        if (!iterator$iv.hasNext()) {
            throw new NoSuchElementException();
        }
        Object minElem$iv = iterator$iv.next();
        Object o;
        if (!iterator$iv.hasNext()) {
            o = minElem$iv;
        }
        else {
            Comparable minValue$iv = (Comparable)selector.invoke((Object)minElem$iv);
            do {
                final Object e$iv = iterator$iv.next();
                final Comparable v$iv = (Comparable)selector.invoke((Object)e$iv);
                if (minValue$iv.compareTo(v$iv) > 0) {
                    minElem$iv = e$iv;
                    minValue$iv = v$iv;
                }
            } while (iterator$iv.hasNext());
            o = minElem$iv;
        }
        return (Map.Entry<K, V>)o;
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minByOrNull(final Map<? extends K, ? extends V> $this$minByOrNull, final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Intrinsics.checkNotNullParameter($this$minByOrNull, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final Iterable $this$minByOrNull$iv = $this$minByOrNull.entrySet();
        final int $i$f$minByOrNull = 0;
        final Iterator iterator$iv = $this$minByOrNull$iv.iterator();
        Object o;
        if (!iterator$iv.hasNext()) {
            o = null;
        }
        else {
            Object minElem$iv = iterator$iv.next();
            if (!iterator$iv.hasNext()) {
                o = minElem$iv;
            }
            else {
                Comparable minValue$iv = (Comparable)selector.invoke((Object)minElem$iv);
                do {
                    final Object e$iv = iterator$iv.next();
                    final Comparable v$iv = (Comparable)selector.invoke((Object)e$iv);
                    if (minValue$iv.compareTo(v$iv) > 0) {
                        minElem$iv = e$iv;
                        minValue$iv = v$iv;
                    }
                } while (iterator$iv.hasNext());
                o = minElem$iv;
            }
        }
        return (Map.Entry<K, V>)o;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> double minOf(final Map<? extends K, ? extends V> $this$minOf, final Function1<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        Intrinsics.checkNotNullParameter($this$minOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final Iterator<? super Map.Entry<? extends K, ? extends V>> iterator = $this$minOf.entrySet().iterator();
        if (!iterator.hasNext()) {
            throw new NoSuchElementException();
        }
        double a = selector.invoke(iterator.next()).doubleValue();
        while (iterator.hasNext()) {
            a = Math.min(a, selector.invoke(iterator.next()).doubleValue());
        }
        return a;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> float minOf(final Map<? extends K, ? extends V> $this$minOf, final Function1<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        Intrinsics.checkNotNullParameter($this$minOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final Iterator<? super Map.Entry<? extends K, ? extends V>> iterator = $this$minOf.entrySet().iterator();
        if (!iterator.hasNext()) {
            throw new NoSuchElementException();
        }
        float a = selector.invoke(iterator.next()).floatValue();
        while (iterator.hasNext()) {
            a = Math.min(a, selector.invoke(iterator.next()).floatValue());
        }
        return a;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> R minOf(final Map<? extends K, ? extends V> $this$minOf, final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Intrinsics.checkNotNullParameter($this$minOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final Iterator<? super Map.Entry<? extends K, ? extends V>> iterator = $this$minOf.entrySet().iterator();
        if (!iterator.hasNext()) {
            throw new NoSuchElementException();
        }
        Comparable<Comparable> comparable = (Comparable<Comparable>)selector.invoke(iterator.next());
        while (iterator.hasNext()) {
            final Comparable comparable2 = (Comparable)selector.invoke(iterator.next());
            if (comparable.compareTo(comparable2) > 0) {
                comparable = (Comparable<Comparable>)comparable2;
            }
        }
        return (R)comparable;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> Double minOfOrNull(final Map<? extends K, ? extends V> $this$minOfOrNull, final Function1<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        Intrinsics.checkNotNullParameter($this$minOfOrNull, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final Iterator<Object> iterator = $this$minOfOrNull.entrySet().iterator();
        Double value;
        if (!iterator.hasNext()) {
            value = null;
        }
        else {
            double n = selector.invoke((Object)iterator.next()).doubleValue();
            while (iterator.hasNext()) {
                n = Math.min(n, selector.invoke((Object)iterator.next()).doubleValue());
            }
            value = n;
        }
        return value;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> Float minOfOrNull(final Map<? extends K, ? extends V> $this$minOfOrNull, final Function1<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        Intrinsics.checkNotNullParameter($this$minOfOrNull, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final Iterator<Object> iterator = $this$minOfOrNull.entrySet().iterator();
        Float value;
        if (!iterator.hasNext()) {
            value = null;
        }
        else {
            float n = selector.invoke((Object)iterator.next()).floatValue();
            while (iterator.hasNext()) {
                n = Math.min(n, selector.invoke((Object)iterator.next()).floatValue());
            }
            value = n;
        }
        return value;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> R minOfOrNull(final Map<? extends K, ? extends V> $this$minOfOrNull, final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Intrinsics.checkNotNullParameter($this$minOfOrNull, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final Iterator<Object> iterator = $this$minOfOrNull.entrySet().iterator();
        Comparable<? super R> comparable;
        if (!iterator.hasNext()) {
            comparable = null;
        }
        else {
            Comparable<? super Comparable> comparable2 = (Comparable<? super Comparable>)selector.invoke((Object)iterator.next());
            while (iterator.hasNext()) {
                final Comparable comparable3 = (Comparable)selector.invoke((Object)iterator.next());
                if (comparable2.compareTo(comparable3) > 0) {
                    comparable2 = (Comparable<? super Comparable>)comparable3;
                }
            }
            comparable = comparable2;
        }
        return (R)comparable;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R> R minOfWith(final Map<? extends K, ? extends V> $this$minOfWith, final Comparator<? super R> comparator, final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Intrinsics.checkNotNullParameter($this$minOfWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final Iterator<? super Map.Entry<? extends K, ? extends V>> iterator = $this$minOfWith.entrySet().iterator();
        if (!iterator.hasNext()) {
            throw new NoSuchElementException();
        }
        R invoke = (R)selector.invoke(iterator.next());
        while (iterator.hasNext()) {
            final R invoke2 = (R)selector.invoke(iterator.next());
            if (comparator.compare(invoke, invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }
    
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R> R minOfWithOrNull(final Map<? extends K, ? extends V> $this$minOfWithOrNull, final Comparator<? super R> comparator, final Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Intrinsics.checkNotNullParameter($this$minOfWithOrNull, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        final Iterator<Object> iterator = $this$minOfWithOrNull.entrySet().iterator();
        R r;
        if (!iterator.hasNext()) {
            r = null;
        }
        else {
            R invoke = (R)selector.invoke((Object)iterator.next());
            while (iterator.hasNext()) {
                final R invoke2 = (R)selector.invoke((Object)iterator.next());
                if (comparator.compare(invoke, invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            r = invoke;
        }
        return r;
    }
    
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    @InlineOnly
    private static final <K, V> Map.Entry<K, V> minWithOrThrow(final Map<? extends K, ? extends V> $this$minWith, final Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.checkNotNullParameter($this$minWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (Map.Entry<K, V>)CollectionsKt___CollectionsKt.minWithOrThrow((Iterable<? extends Map.Entry>)$this$minWith.entrySet(), (Comparator<? super Map.Entry>)comparator);
    }
    
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V> Map.Entry<K, V> minWithOrNull(final Map<? extends K, ? extends V> $this$minWithOrNull, final Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.checkNotNullParameter($this$minWithOrNull, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (Map.Entry<K, V>)CollectionsKt___CollectionsKt.minWithOrNull((Iterable<? extends Map.Entry>)$this$minWithOrNull.entrySet(), (Comparator<? super Map.Entry>)comparator);
    }
    
    public static final <K, V> boolean none(@NotNull final Map<? extends K, ? extends V> $this$none) {
        Intrinsics.checkNotNullParameter($this$none, "<this>");
        return $this$none.isEmpty();
    }
    
    public static final <K, V> boolean none(@NotNull final Map<? extends K, ? extends V> $this$none, @NotNull final Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$none, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        final int $i$f$none = 0;
        if ($this$none.isEmpty()) {
            return true;
        }
        for (final Map.Entry element : $this$none.entrySet()) {
            if (predicate.invoke((Object)element)) {
                return false;
            }
        }
        return true;
    }
    
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <K, V, M extends Map<? extends K, ? extends V>> M onEach(@NotNull final M $this$onEach, @NotNull final Function1<? super Map.Entry<? extends K, ? extends V>, Unit> action) {
        Intrinsics.checkNotNullParameter($this$onEach, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        final int $i$f$onEach = 0;
        final Map $this$onEach_u24lambda_u242 = $this$onEach;
        final int n = 0;
        for (final Map.Entry element : $this$onEach_u24lambda_u242.entrySet()) {
            action.invoke((Object)element);
        }
        return $this$onEach;
    }
    
    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <K, V, M extends Map<? extends K, ? extends V>> M onEachIndexed(@NotNull final M $this$onEachIndexed, @NotNull final Function2<? super Integer, ? super Map.Entry<? extends K, ? extends V>, Unit> action) {
        Intrinsics.checkNotNullParameter($this$onEachIndexed, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        final int $i$f$onEachIndexed = 0;
        final Map $this$onEachIndexed_u24lambda_u243 = $this$onEachIndexed;
        final int n = 0;
        final Iterable $this$forEachIndexed$iv = $this$onEachIndexed_u24lambda_u243.entrySet();
        final int $i$f$forEachIndexed = 0;
        int index$iv = 0;
        for (final Object item$iv : $this$forEachIndexed$iv) {
            final int i = index$iv++;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            action.invoke(Integer.valueOf(i), (Object)item$iv);
        }
        return $this$onEachIndexed;
    }
    
    @InlineOnly
    private static final <K, V> Iterable<Map.Entry<K, V>> asIterable(final Map<? extends K, ? extends V> $this$asIterable) {
        Intrinsics.checkNotNullParameter($this$asIterable, "<this>");
        return (Iterable<Map.Entry<K, V>>)$this$asIterable.entrySet();
    }
    
    @NotNull
    public static final <K, V> Sequence<Map.Entry<K, V>> asSequence(@NotNull final Map<? extends K, ? extends V> $this$asSequence) {
        Intrinsics.checkNotNullParameter($this$asSequence, "<this>");
        return CollectionsKt___CollectionsKt.asSequence((Iterable<? extends Map.Entry<K, V>>)$this$asSequence.entrySet());
    }
    
    public MapsKt___MapsKt() {
    }
}
