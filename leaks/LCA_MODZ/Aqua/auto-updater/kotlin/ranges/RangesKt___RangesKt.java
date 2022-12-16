// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.ranges;

import kotlin.DeprecatedSinceKotlin;
import kotlin.Deprecated;
import kotlin.jvm.JvmName;
import kotlin.ExperimentalStdlibApi;
import kotlin.WasExperimental;
import kotlin.random.RandomKt;
import kotlin.internal.InlineOnly;
import kotlin.random.Random;
import org.jetbrains.annotations.Nullable;
import kotlin.SinceKotlin;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000t\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001e\u001a'\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006\u001a\u0012\u0010\u0000\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007\u001a\u0012\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\b\u001a\u0012\u0010\u0000\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\t\u001a\u0012\u0010\u0000\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\n\u001a'\u0010\u000b\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0006\u0010\f\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u000b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005\u001a\u0012\u0010\u000b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006\u001a\u0012\u0010\u000b\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007\u001a\u0012\u0010\u000b\u001a\u00020\b*\u00020\b2\u0006\u0010\f\u001a\u00020\b\u001a\u0012\u0010\u000b\u001a\u00020\t*\u00020\t2\u0006\u0010\f\u001a\u00020\t\u001a\u0012\u0010\u000b\u001a\u00020\n*\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a3\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00012\b\u0010\f\u001a\u0004\u0018\u0001H\u0001¢\u0006\u0002\u0010\u000e\u001a/\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a-\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0012¢\u0006\u0002\u0010\u0013\u001a\u001a\u0010\r\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005\u001a\u001a\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006\u001a\u001a\u0010\r\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007\u001a\u001a\u0010\r\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b\u001a\u0018\u0010\r\u001a\u00020\b*\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0012\u001a\u001a\u0010\r\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t\u001a\u0018\u0010\r\u001a\u00020\t*\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0012\u001a\u001a\u0010\r\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0087\n¢\u0006\u0002\u0010\u0019\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b \u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020!2\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0087\n¢\u0006\u0002\u0010\"\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0006\u0010\u001a\u001a\u00020\tH\u0087\n\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0006\u0010\u001a\u001a\u00020\nH\u0087\n\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\n\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0006\u0010\u001a\u001a\u00020\bH\u0087\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020#2\b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0087\n¢\u0006\u0002\u0010$\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0006\u0010\u001a\u001a\u00020\nH\u0087\n\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b \u001a\u0015\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\u00052\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020**\u00020\u00182\u0006\u0010(\u001a\u00020\u0018H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\b2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\b2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\b2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\n2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\n2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\n2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\f\u0010+\u001a\u00020\u0018*\u00020*H\u0007\u001a\f\u0010+\u001a\u00020\b*\u00020'H\u0007\u001a\f\u0010+\u001a\u00020\t*\u00020)H\u0007\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\u0018*\u00020*H\u0007¢\u0006\u0002\u0010-\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\b*\u00020'H\u0007¢\u0006\u0002\u0010.\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\t*\u00020)H\u0007¢\u0006\u0002\u0010/\u001a\f\u00100\u001a\u00020\u0018*\u00020*H\u0007\u001a\f\u00100\u001a\u00020\b*\u00020'H\u0007\u001a\f\u00100\u001a\u00020\t*\u00020)H\u0007\u001a\u0013\u00101\u001a\u0004\u0018\u00010\u0018*\u00020*H\u0007¢\u0006\u0002\u0010-\u001a\u0013\u00101\u001a\u0004\u0018\u00010\b*\u00020'H\u0007¢\u0006\u0002\u0010.\u001a\u0013\u00101\u001a\u0004\u0018\u00010\t*\u00020)H\u0007¢\u0006\u0002\u0010/\u001a\r\u00102\u001a\u00020\u0018*\u00020\u0016H\u0087\b\u001a\u0014\u00102\u001a\u00020\u0018*\u00020\u00162\u0006\u00102\u001a\u000203H\u0007\u001a\r\u00102\u001a\u00020\b*\u00020!H\u0087\b\u001a\u0014\u00102\u001a\u00020\b*\u00020!2\u0006\u00102\u001a\u000203H\u0007\u001a\r\u00102\u001a\u00020\t*\u00020#H\u0087\b\u001a\u0014\u00102\u001a\u00020\t*\u00020#2\u0006\u00102\u001a\u000203H\u0007\u001a\u0014\u00104\u001a\u0004\u0018\u00010\u0018*\u00020\u0016H\u0087\b¢\u0006\u0002\u00105\u001a\u001b\u00104\u001a\u0004\u0018\u00010\u0018*\u00020\u00162\u0006\u00102\u001a\u000203H\u0007¢\u0006\u0002\u00106\u001a\u0014\u00104\u001a\u0004\u0018\u00010\b*\u00020!H\u0087\b¢\u0006\u0002\u00107\u001a\u001b\u00104\u001a\u0004\u0018\u00010\b*\u00020!2\u0006\u00102\u001a\u000203H\u0007¢\u0006\u0002\u00108\u001a\u0014\u00104\u001a\u0004\u0018\u00010\t*\u00020#H\u0087\b¢\u0006\u0002\u00109\u001a\u001b\u00104\u001a\u0004\u0018\u00010\t*\u00020#2\u0006\u00102\u001a\u000203H\u0007¢\u0006\u0002\u0010:\u001a\u0015\u0010;\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0087\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\bH\u0087\n\u001a\u0015\u0010;\u001a\u00020#*\u00020\u00052\u0006\u0010(\u001a\u00020\tH\u0087\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\nH\u0087\n\u001a\u0015\u0010;\u001a\u00020\u0016*\u00020\u00182\u0006\u0010(\u001a\u00020\u0018H\u0087\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\u0005H\u0087\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0087\n\u001a\u0015\u0010;\u001a\u00020#*\u00020\b2\u0006\u0010(\u001a\u00020\tH\u0087\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\nH\u0087\n\u001a\u0015\u0010;\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\u0005H\u0087\n\u001a\u0015\u0010;\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\bH\u0087\n\u001a\u0015\u0010;\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0087\n\u001a\u0015\u0010;\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\nH\u0087\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\u0005H\u0087\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\bH\u0087\n\u001a\u0015\u0010;\u001a\u00020#*\u00020\n2\u0006\u0010(\u001a\u00020\tH\u0087\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0087\n\u001a\n\u0010<\u001a\u00020**\u00020*\u001a\n\u0010<\u001a\u00020'*\u00020'\u001a\n\u0010<\u001a\u00020)*\u00020)\u001a\u0015\u0010=\u001a\u00020**\u00020*2\u0006\u0010=\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010=\u001a\u00020'*\u00020'2\u0006\u0010=\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010=\u001a\u00020)*\u00020)2\u0006\u0010=\u001a\u00020\tH\u0086\u0004\u001a\u0013\u0010>\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0000¢\u0006\u0002\u0010?\u001a\u0013\u0010>\u001a\u0004\u0018\u00010\u0005*\u00020\u0007H\u0000¢\u0006\u0002\u0010@\u001a\u0013\u0010>\u001a\u0004\u0018\u00010\u0005*\u00020\bH\u0000¢\u0006\u0002\u0010A\u001a\u0013\u0010>\u001a\u0004\u0018\u00010\u0005*\u00020\tH\u0000¢\u0006\u0002\u0010B\u001a\u0013\u0010>\u001a\u0004\u0018\u00010\u0005*\u00020\nH\u0000¢\u0006\u0002\u0010C\u001a\u0013\u0010D\u001a\u0004\u0018\u00010\b*\u00020\u0006H\u0000¢\u0006\u0002\u0010E\u001a\u0013\u0010D\u001a\u0004\u0018\u00010\b*\u00020\u0007H\u0000¢\u0006\u0002\u0010F\u001a\u0013\u0010D\u001a\u0004\u0018\u00010\b*\u00020\tH\u0000¢\u0006\u0002\u0010G\u001a\u0013\u0010H\u001a\u0004\u0018\u00010\t*\u00020\u0006H\u0000¢\u0006\u0002\u0010I\u001a\u0013\u0010H\u001a\u0004\u0018\u00010\t*\u00020\u0007H\u0000¢\u0006\u0002\u0010J\u001a\u0013\u0010K\u001a\u0004\u0018\u00010\n*\u00020\u0006H\u0000¢\u0006\u0002\u0010L\u001a\u0013\u0010K\u001a\u0004\u0018\u00010\n*\u00020\u0007H\u0000¢\u0006\u0002\u0010M\u001a\u0013\u0010K\u001a\u0004\u0018\u00010\n*\u00020\bH\u0000¢\u0006\u0002\u0010N\u001a\u0013\u0010K\u001a\u0004\u0018\u00010\n*\u00020\tH\u0000¢\u0006\u0002\u0010O\u001a\u0015\u0010P\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020#*\u00020\u00052\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020\u0016*\u00020\u00182\u0006\u0010(\u001a\u00020\u0018H\u0086\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020#*\u00020\b2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010P\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020#*\u00020\n2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0086\u0004¨\u0006Q" }, d2 = { "coerceAtLeast", "T", "", "minimumValue", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "coerceAtMost", "maximumValue", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "Lkotlin/ranges/ClosedRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "contains", "", "Lkotlin/ranges/CharRange;", "element", "", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "value", "byteRangeContains", "doubleRangeContains", "floatRangeContains", "intRangeContains", "longRangeContains", "shortRangeContains", "Lkotlin/ranges/IntRange;", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "Lkotlin/ranges/LongRange;", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "Lkotlin/ranges/OpenEndRange;", "downTo", "Lkotlin/ranges/IntProgression;", "to", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/CharProgression;", "first", "firstOrNull", "(Lkotlin/ranges/CharProgression;)Ljava/lang/Character;", "(Lkotlin/ranges/IntProgression;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongProgression;)Ljava/lang/Long;", "last", "lastOrNull", "random", "Lkotlin/random/Random;", "randomOrNull", "(Lkotlin/ranges/CharRange;)Ljava/lang/Character;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)Ljava/lang/Character;", "(Lkotlin/ranges/IntRange;)Ljava/lang/Integer;", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;)Ljava/lang/Long;", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)Ljava/lang/Long;", "rangeUntil", "reversed", "step", "toByteExactOrNull", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "toIntExactOrNull", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "(J)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "until", "kotlin-stdlib" }, xs = "kotlin/ranges/RangesKt")
class RangesKt___RangesKt extends RangesKt__RangesKt
{
    @SinceKotlin(version = "1.7")
    public static final int first(@NotNull final IntProgression $this$first) {
        Intrinsics.checkNotNullParameter($this$first, "<this>");
        if ($this$first.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$first + " is empty.");
        }
        return $this$first.getFirst();
    }
    
    @SinceKotlin(version = "1.7")
    public static final long first(@NotNull final LongProgression $this$first) {
        Intrinsics.checkNotNullParameter($this$first, "<this>");
        if ($this$first.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$first + " is empty.");
        }
        return $this$first.getFirst();
    }
    
    @SinceKotlin(version = "1.7")
    public static final char first(@NotNull final CharProgression $this$first) {
        Intrinsics.checkNotNullParameter($this$first, "<this>");
        if ($this$first.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$first + " is empty.");
        }
        return $this$first.getFirst();
    }
    
    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Integer firstOrNull(@NotNull final IntProgression $this$firstOrNull) {
        Intrinsics.checkNotNullParameter($this$firstOrNull, "<this>");
        return $this$firstOrNull.isEmpty() ? null : Integer.valueOf($this$firstOrNull.getFirst());
    }
    
    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Long firstOrNull(@NotNull final LongProgression $this$firstOrNull) {
        Intrinsics.checkNotNullParameter($this$firstOrNull, "<this>");
        return $this$firstOrNull.isEmpty() ? null : Long.valueOf($this$firstOrNull.getFirst());
    }
    
    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Character firstOrNull(@NotNull final CharProgression $this$firstOrNull) {
        Intrinsics.checkNotNullParameter($this$firstOrNull, "<this>");
        return $this$firstOrNull.isEmpty() ? null : Character.valueOf($this$firstOrNull.getFirst());
    }
    
    @SinceKotlin(version = "1.7")
    public static final int last(@NotNull final IntProgression $this$last) {
        Intrinsics.checkNotNullParameter($this$last, "<this>");
        if ($this$last.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$last + " is empty.");
        }
        return $this$last.getLast();
    }
    
    @SinceKotlin(version = "1.7")
    public static final long last(@NotNull final LongProgression $this$last) {
        Intrinsics.checkNotNullParameter($this$last, "<this>");
        if ($this$last.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$last + " is empty.");
        }
        return $this$last.getLast();
    }
    
    @SinceKotlin(version = "1.7")
    public static final char last(@NotNull final CharProgression $this$last) {
        Intrinsics.checkNotNullParameter($this$last, "<this>");
        if ($this$last.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$last + " is empty.");
        }
        return $this$last.getLast();
    }
    
    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Integer lastOrNull(@NotNull final IntProgression $this$lastOrNull) {
        Intrinsics.checkNotNullParameter($this$lastOrNull, "<this>");
        return $this$lastOrNull.isEmpty() ? null : Integer.valueOf($this$lastOrNull.getLast());
    }
    
    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Long lastOrNull(@NotNull final LongProgression $this$lastOrNull) {
        Intrinsics.checkNotNullParameter($this$lastOrNull, "<this>");
        return $this$lastOrNull.isEmpty() ? null : Long.valueOf($this$lastOrNull.getLast());
    }
    
    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Character lastOrNull(@NotNull final CharProgression $this$lastOrNull) {
        Intrinsics.checkNotNullParameter($this$lastOrNull, "<this>");
        return $this$lastOrNull.isEmpty() ? null : Character.valueOf($this$lastOrNull.getLast());
    }
    
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final int random(final IntRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return random($this$random, Random.Default);
    }
    
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final long random(final LongRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return random($this$random, Random.Default);
    }
    
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final char random(final CharRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return random($this$random, Random.Default);
    }
    
    @SinceKotlin(version = "1.3")
    public static final int random(@NotNull final IntRange $this$random, @NotNull final Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return RandomKt.nextInt(random, $this$random);
        }
        catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }
    
    @SinceKotlin(version = "1.3")
    public static final long random(@NotNull final LongRange $this$random, @NotNull final Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return RandomKt.nextLong(random, $this$random);
        }
        catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }
    
    @SinceKotlin(version = "1.3")
    public static final char random(@NotNull final CharRange $this$random, @NotNull final Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return (char)random.nextInt($this$random.getFirst(), $this$random.getLast() + '\u0001');
        }
        catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final Integer randomOrNull(final IntRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return randomOrNull($this$randomOrNull, Random.Default);
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final Long randomOrNull(final LongRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return randomOrNull($this$randomOrNull, Random.Default);
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final Character randomOrNull(final CharRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return randomOrNull($this$randomOrNull, Random.Default);
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @Nullable
    public static final Integer randomOrNull(@NotNull final IntRange $this$randomOrNull, @NotNull final Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return RandomKt.nextInt(random, $this$randomOrNull);
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @Nullable
    public static final Long randomOrNull(@NotNull final LongRange $this$randomOrNull, @NotNull final Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return RandomKt.nextLong(random, $this$randomOrNull);
    }
    
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @Nullable
    public static final Character randomOrNull(@NotNull final CharRange $this$randomOrNull, @NotNull final Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return (char)random.nextInt($this$randomOrNull.getFirst(), $this$randomOrNull.getLast() + '\u0001');
    }
    
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean contains(final IntRange $this$contains, final Integer element) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return element != null && $this$contains.contains((int)element);
    }
    
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean contains(final LongRange $this$contains, final Long element) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return element != null && $this$contains.contains((long)element);
    }
    
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean contains(final CharRange $this$contains, final Character element) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return element != null && $this$contains.contains((char)element);
    }
    
    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@NotNull final ClosedRange<Integer> $this$contains, final byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((int)value);
    }
    
    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@NotNull final ClosedRange<Long> $this$contains, final byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((long)value);
    }
    
    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@NotNull final ClosedRange<Short> $this$contains, final byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((short)value);
    }
    
    @JvmName(name = "intRangeContains")
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    public static final boolean intRangeContains(@NotNull final OpenEndRange<Integer> $this$contains, final byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((int)value);
    }
    
    @JvmName(name = "longRangeContains")
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    public static final boolean longRangeContains(@NotNull final OpenEndRange<Long> $this$contains, final byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((long)value);
    }
    
    @JvmName(name = "shortRangeContains")
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    public static final boolean shortRangeContains(@NotNull final OpenEndRange<Short> $this$contains, final byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((short)value);
    }
    
    @InlineOnly
    private static final boolean contains(final IntRange $this$contains, final byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return intRangeContains((ClosedRange<Integer>)$this$contains, value);
    }
    
    @InlineOnly
    private static final boolean contains(final LongRange $this$contains, final byte value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return longRangeContains((ClosedRange<Long>)$this$contains, value);
    }
    
    @JvmName(name = "floatRangeContains")
    public static final boolean floatRangeContains(@NotNull final ClosedRange<Float> $this$contains, final double value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((float)value);
    }
    
    @JvmName(name = "doubleRangeContains")
    public static final boolean doubleRangeContains(@NotNull final ClosedRange<Double> $this$contains, final float value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((double)value);
    }
    
    @JvmName(name = "doubleRangeContains")
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    public static final boolean doubleRangeContains(@NotNull final OpenEndRange<Double> $this$contains, final float value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((double)value);
    }
    
    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@NotNull final ClosedRange<Long> $this$contains, final int value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((long)value);
    }
    
    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@NotNull final ClosedRange<Byte> $this$contains, final int value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        final Byte it = toByteExactOrNull(value);
        final int n = 0;
        final Byte b = it;
        return b != null && $this$contains.contains(b);
    }
    
    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@NotNull final ClosedRange<Short> $this$contains, final int value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        final Short it = toShortExactOrNull(value);
        final int n = 0;
        final Short n2 = it;
        return n2 != null && $this$contains.contains(n2);
    }
    
    @JvmName(name = "longRangeContains")
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    public static final boolean longRangeContains(@NotNull final OpenEndRange<Long> $this$contains, final int value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((long)value);
    }
    
    @JvmName(name = "byteRangeContains")
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    public static final boolean byteRangeContains(@NotNull final OpenEndRange<Byte> $this$contains, final int value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        final Byte it = toByteExactOrNull(value);
        final int n = 0;
        final Byte b = it;
        return b != null && $this$contains.contains(b);
    }
    
    @JvmName(name = "shortRangeContains")
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    public static final boolean shortRangeContains(@NotNull final OpenEndRange<Short> $this$contains, final int value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        final Short it = toShortExactOrNull(value);
        final int n = 0;
        final Short n2 = it;
        return n2 != null && $this$contains.contains(n2);
    }
    
    @InlineOnly
    private static final boolean contains(final LongRange $this$contains, final int value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return longRangeContains((ClosedRange<Long>)$this$contains, value);
    }
    
    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@NotNull final ClosedRange<Integer> $this$contains, final long value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        final Integer it = toIntExactOrNull(value);
        final int n = 0;
        final Integer n2 = it;
        return n2 != null && $this$contains.contains(n2);
    }
    
    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@NotNull final ClosedRange<Byte> $this$contains, final long value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        final Byte it = toByteExactOrNull(value);
        final int n = 0;
        final Byte b = it;
        return b != null && $this$contains.contains(b);
    }
    
    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@NotNull final ClosedRange<Short> $this$contains, final long value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        final Short it = toShortExactOrNull(value);
        final int n = 0;
        final Short n2 = it;
        return n2 != null && $this$contains.contains(n2);
    }
    
    @JvmName(name = "intRangeContains")
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    public static final boolean intRangeContains(@NotNull final OpenEndRange<Integer> $this$contains, final long value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        final Integer it = toIntExactOrNull(value);
        final int n = 0;
        final Integer n2 = it;
        return n2 != null && $this$contains.contains(n2);
    }
    
    @JvmName(name = "byteRangeContains")
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    public static final boolean byteRangeContains(@NotNull final OpenEndRange<Byte> $this$contains, final long value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        final Byte it = toByteExactOrNull(value);
        final int n = 0;
        final Byte b = it;
        return b != null && $this$contains.contains(b);
    }
    
    @JvmName(name = "shortRangeContains")
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    public static final boolean shortRangeContains(@NotNull final OpenEndRange<Short> $this$contains, final long value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        final Short it = toShortExactOrNull(value);
        final int n = 0;
        final Short n2 = it;
        return n2 != null && $this$contains.contains(n2);
    }
    
    @InlineOnly
    private static final boolean contains(final IntRange $this$contains, final long value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return intRangeContains((ClosedRange<Integer>)$this$contains, value);
    }
    
    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@NotNull final ClosedRange<Integer> $this$contains, final short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((int)value);
    }
    
    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@NotNull final ClosedRange<Long> $this$contains, final short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((long)value);
    }
    
    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@NotNull final ClosedRange<Byte> $this$contains, final short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        final Byte it = toByteExactOrNull(value);
        final int n = 0;
        final Byte b = it;
        return b != null && $this$contains.contains(b);
    }
    
    @JvmName(name = "intRangeContains")
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    public static final boolean intRangeContains(@NotNull final OpenEndRange<Integer> $this$contains, final short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((int)value);
    }
    
    @JvmName(name = "longRangeContains")
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    public static final boolean longRangeContains(@NotNull final OpenEndRange<Long> $this$contains, final short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return $this$contains.contains((long)value);
    }
    
    @JvmName(name = "byteRangeContains")
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    public static final boolean byteRangeContains(@NotNull final OpenEndRange<Byte> $this$contains, final short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        final Byte it = toByteExactOrNull(value);
        final int n = 0;
        final Byte b = it;
        return b != null && $this$contains.contains(b);
    }
    
    @InlineOnly
    private static final boolean contains(final IntRange $this$contains, final short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return intRangeContains((ClosedRange<Integer>)$this$contains, value);
    }
    
    @InlineOnly
    private static final boolean contains(final LongRange $this$contains, final short value) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        return longRangeContains((ClosedRange<Long>)$this$contains, value);
    }
    
    @NotNull
    public static final IntProgression downTo(final int $this$downTo, final byte to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }
    
    @NotNull
    public static final LongProgression downTo(final long $this$downTo, final byte to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, to, -1L);
    }
    
    @NotNull
    public static final IntProgression downTo(final byte $this$downTo, final byte to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }
    
    @NotNull
    public static final IntProgression downTo(final short $this$downTo, final byte to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }
    
    @NotNull
    public static final CharProgression downTo(final char $this$downTo, final char to) {
        return CharProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }
    
    @NotNull
    public static final IntProgression downTo(final int $this$downTo, final int to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }
    
    @NotNull
    public static final LongProgression downTo(final long $this$downTo, final int to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, to, -1L);
    }
    
    @NotNull
    public static final IntProgression downTo(final byte $this$downTo, final int to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }
    
    @NotNull
    public static final IntProgression downTo(final short $this$downTo, final int to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }
    
    @NotNull
    public static final LongProgression downTo(final int $this$downTo, final long to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, to, -1L);
    }
    
    @NotNull
    public static final LongProgression downTo(final long $this$downTo, final long to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, to, -1L);
    }
    
    @NotNull
    public static final LongProgression downTo(final byte $this$downTo, final long to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, to, -1L);
    }
    
    @NotNull
    public static final LongProgression downTo(final short $this$downTo, final long to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, to, -1L);
    }
    
    @NotNull
    public static final IntProgression downTo(final int $this$downTo, final short to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }
    
    @NotNull
    public static final LongProgression downTo(final long $this$downTo, final short to) {
        return LongProgression.Companion.fromClosedRange($this$downTo, to, -1L);
    }
    
    @NotNull
    public static final IntProgression downTo(final byte $this$downTo, final short to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }
    
    @NotNull
    public static final IntProgression downTo(final short $this$downTo, final short to) {
        return IntProgression.Companion.fromClosedRange($this$downTo, to, -1);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(final int $this$rangeUntil, final byte to) {
        return until($this$rangeUntil, to);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final LongRange rangeUntil(final long $this$rangeUntil, final byte to) {
        return until($this$rangeUntil, to);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(final byte $this$rangeUntil, final byte to) {
        return until($this$rangeUntil, to);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(final short $this$rangeUntil, final byte to) {
        return until($this$rangeUntil, to);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final CharRange rangeUntil(final char $this$rangeUntil, final char to) {
        return until($this$rangeUntil, to);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(final int $this$rangeUntil, final int to) {
        return until($this$rangeUntil, to);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final LongRange rangeUntil(final long $this$rangeUntil, final int to) {
        return until($this$rangeUntil, to);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(final byte $this$rangeUntil, final int to) {
        return until($this$rangeUntil, to);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(final short $this$rangeUntil, final int to) {
        return until($this$rangeUntil, to);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final LongRange rangeUntil(final int $this$rangeUntil, final long to) {
        return until($this$rangeUntil, to);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final LongRange rangeUntil(final long $this$rangeUntil, final long to) {
        return until($this$rangeUntil, to);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final LongRange rangeUntil(final byte $this$rangeUntil, final long to) {
        return until($this$rangeUntil, to);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final LongRange rangeUntil(final short $this$rangeUntil, final long to) {
        return until($this$rangeUntil, to);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(final int $this$rangeUntil, final short to) {
        return until($this$rangeUntil, to);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final LongRange rangeUntil(final long $this$rangeUntil, final short to) {
        return until($this$rangeUntil, to);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(final byte $this$rangeUntil, final short to) {
        return until($this$rangeUntil, to);
    }
    
    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(final short $this$rangeUntil, final short to) {
        return until($this$rangeUntil, to);
    }
    
    @NotNull
    public static final IntProgression reversed(@NotNull final IntProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return IntProgression.Companion.fromClosedRange($this$reversed.getLast(), $this$reversed.getFirst(), -$this$reversed.getStep());
    }
    
    @NotNull
    public static final LongProgression reversed(@NotNull final LongProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return LongProgression.Companion.fromClosedRange($this$reversed.getLast(), $this$reversed.getFirst(), -$this$reversed.getStep());
    }
    
    @NotNull
    public static final CharProgression reversed(@NotNull final CharProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return CharProgression.Companion.fromClosedRange($this$reversed.getLast(), $this$reversed.getFirst(), -$this$reversed.getStep());
    }
    
    @NotNull
    public static final IntProgression step(@NotNull final IntProgression $this$step, final int step) {
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(step > 0, step);
        return IntProgression.Companion.fromClosedRange($this$step.getFirst(), $this$step.getLast(), ($this$step.getStep() > 0) ? step : (-step));
    }
    
    @NotNull
    public static final LongProgression step(@NotNull final LongProgression $this$step, final long step) {
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(step > 0L, step);
        return LongProgression.Companion.fromClosedRange($this$step.getFirst(), $this$step.getLast(), ($this$step.getStep() > 0L) ? step : (-step));
    }
    
    @NotNull
    public static final CharProgression step(@NotNull final CharProgression $this$step, final int step) {
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(step > 0, step);
        return CharProgression.Companion.fromClosedRange($this$step.getFirst(), $this$step.getLast(), ($this$step.getStep() > 0) ? step : (-step));
    }
    
    @Nullable
    public static final Byte toByteExactOrNull(final int $this$toByteExactOrNull) {
        return new IntRange(-128, 127).contains($this$toByteExactOrNull) ? Byte.valueOf((byte)$this$toByteExactOrNull) : null;
    }
    
    @Nullable
    public static final Byte toByteExactOrNull(final long $this$toByteExactOrNull) {
        return new LongRange(-128L, 127L).contains($this$toByteExactOrNull) ? Byte.valueOf((byte)$this$toByteExactOrNull) : null;
    }
    
    @Nullable
    public static final Byte toByteExactOrNull(final short $this$toByteExactOrNull) {
        return intRangeContains((ClosedRange<Integer>)new IntRange(-128, 127), $this$toByteExactOrNull) ? Byte.valueOf((byte)$this$toByteExactOrNull) : null;
    }
    
    @Nullable
    public static final Byte toByteExactOrNull(final double $this$toByteExactOrNull) {
        return (-128.0 <= $this$toByteExactOrNull && $this$toByteExactOrNull <= 127.0) ? Byte.valueOf((byte)$this$toByteExactOrNull) : null;
    }
    
    @Nullable
    public static final Byte toByteExactOrNull(final float $this$toByteExactOrNull) {
        return (-128.0f <= $this$toByteExactOrNull && $this$toByteExactOrNull <= 127.0f) ? Byte.valueOf((byte)$this$toByteExactOrNull) : null;
    }
    
    @Nullable
    public static final Integer toIntExactOrNull(final long $this$toIntExactOrNull) {
        return new LongRange(-2147483648L, 2147483647L).contains($this$toIntExactOrNull) ? Integer.valueOf((int)$this$toIntExactOrNull) : null;
    }
    
    @Nullable
    public static final Integer toIntExactOrNull(final double $this$toIntExactOrNull) {
        return (-2.147483648E9 <= $this$toIntExactOrNull && $this$toIntExactOrNull <= 2.147483647E9) ? Integer.valueOf((int)$this$toIntExactOrNull) : null;
    }
    
    @Nullable
    public static final Integer toIntExactOrNull(final float $this$toIntExactOrNull) {
        return (-2.14748365E9f <= $this$toIntExactOrNull && $this$toIntExactOrNull <= 2.14748365E9f) ? Integer.valueOf((int)$this$toIntExactOrNull) : null;
    }
    
    @Nullable
    public static final Long toLongExactOrNull(final double $this$toLongExactOrNull) {
        return (-9.223372036854776E18 <= $this$toLongExactOrNull && $this$toLongExactOrNull <= 9.223372036854776E18) ? Long.valueOf((long)$this$toLongExactOrNull) : null;
    }
    
    @Nullable
    public static final Long toLongExactOrNull(final float $this$toLongExactOrNull) {
        return (-9.223372E18f <= $this$toLongExactOrNull && $this$toLongExactOrNull <= 9.223372E18f) ? Long.valueOf((long)$this$toLongExactOrNull) : null;
    }
    
    @Nullable
    public static final Short toShortExactOrNull(final int $this$toShortExactOrNull) {
        return new IntRange(-32768, 32767).contains($this$toShortExactOrNull) ? Short.valueOf((short)$this$toShortExactOrNull) : null;
    }
    
    @Nullable
    public static final Short toShortExactOrNull(final long $this$toShortExactOrNull) {
        return new LongRange(-32768L, 32767L).contains($this$toShortExactOrNull) ? Short.valueOf((short)$this$toShortExactOrNull) : null;
    }
    
    @Nullable
    public static final Short toShortExactOrNull(final double $this$toShortExactOrNull) {
        return (-32768.0 <= $this$toShortExactOrNull && $this$toShortExactOrNull <= 32767.0) ? Short.valueOf((short)$this$toShortExactOrNull) : null;
    }
    
    @Nullable
    public static final Short toShortExactOrNull(final float $this$toShortExactOrNull) {
        return (-32768.0f <= $this$toShortExactOrNull && $this$toShortExactOrNull <= 32767.0f) ? Short.valueOf((short)$this$toShortExactOrNull) : null;
    }
    
    @NotNull
    public static final IntRange until(final int $this$until, final byte to) {
        return new IntRange($this$until, to - 1);
    }
    
    @NotNull
    public static final LongRange until(final long $this$until, final byte to) {
        return new LongRange($this$until, to - 1L);
    }
    
    @NotNull
    public static final IntRange until(final byte $this$until, final byte to) {
        return new IntRange($this$until, to - 1);
    }
    
    @NotNull
    public static final IntRange until(final short $this$until, final byte to) {
        return new IntRange($this$until, to - 1);
    }
    
    @NotNull
    public static final CharRange until(final char $this$until, final char to) {
        if (Intrinsics.compare(to, 0) <= 0) {
            return CharRange.Companion.getEMPTY();
        }
        return new CharRange($this$until, (char)(to - '\u0001'));
    }
    
    @NotNull
    public static final IntRange until(final int $this$until, final int to) {
        if (to <= Integer.MIN_VALUE) {
            return IntRange.Companion.getEMPTY();
        }
        return new IntRange($this$until, to - 1);
    }
    
    @NotNull
    public static final LongRange until(final long $this$until, final int to) {
        return new LongRange($this$until, to - 1L);
    }
    
    @NotNull
    public static final IntRange until(final byte $this$until, final int to) {
        if (to <= Integer.MIN_VALUE) {
            return IntRange.Companion.getEMPTY();
        }
        return new IntRange($this$until, to - 1);
    }
    
    @NotNull
    public static final IntRange until(final short $this$until, final int to) {
        if (to <= Integer.MIN_VALUE) {
            return IntRange.Companion.getEMPTY();
        }
        return new IntRange($this$until, to - 1);
    }
    
    @NotNull
    public static final LongRange until(final int $this$until, final long to) {
        if (to <= Long.MIN_VALUE) {
            return LongRange.Companion.getEMPTY();
        }
        return new LongRange($this$until, to - 1L);
    }
    
    @NotNull
    public static final LongRange until(final long $this$until, final long to) {
        if (to <= Long.MIN_VALUE) {
            return LongRange.Companion.getEMPTY();
        }
        return new LongRange($this$until, to - 1L);
    }
    
    @NotNull
    public static final LongRange until(final byte $this$until, final long to) {
        if (to <= Long.MIN_VALUE) {
            return LongRange.Companion.getEMPTY();
        }
        return new LongRange($this$until, to - 1L);
    }
    
    @NotNull
    public static final LongRange until(final short $this$until, final long to) {
        if (to <= Long.MIN_VALUE) {
            return LongRange.Companion.getEMPTY();
        }
        return new LongRange($this$until, to - 1L);
    }
    
    @NotNull
    public static final IntRange until(final int $this$until, final short to) {
        return new IntRange($this$until, to - 1);
    }
    
    @NotNull
    public static final LongRange until(final long $this$until, final short to) {
        return new LongRange($this$until, to - 1L);
    }
    
    @NotNull
    public static final IntRange until(final byte $this$until, final short to) {
        return new IntRange($this$until, to - 1);
    }
    
    @NotNull
    public static final IntRange until(final short $this$until, final short to) {
        return new IntRange($this$until, to - 1);
    }
    
    @NotNull
    public static final <T extends Comparable<? super T>> T coerceAtLeast(@NotNull final T $this$coerceAtLeast, @NotNull final T minimumValue) {
        Intrinsics.checkNotNullParameter($this$coerceAtLeast, "<this>");
        Intrinsics.checkNotNullParameter(minimumValue, "minimumValue");
        return ($this$coerceAtLeast.compareTo((Object)minimumValue) < 0) ? minimumValue : $this$coerceAtLeast;
    }
    
    public static final byte coerceAtLeast(final byte $this$coerceAtLeast, final byte minimumValue) {
        return ($this$coerceAtLeast < minimumValue) ? minimumValue : $this$coerceAtLeast;
    }
    
    public static final short coerceAtLeast(final short $this$coerceAtLeast, final short minimumValue) {
        return ($this$coerceAtLeast < minimumValue) ? minimumValue : $this$coerceAtLeast;
    }
    
    public static final int coerceAtLeast(final int $this$coerceAtLeast, final int minimumValue) {
        return ($this$coerceAtLeast < minimumValue) ? minimumValue : $this$coerceAtLeast;
    }
    
    public static final long coerceAtLeast(final long $this$coerceAtLeast, final long minimumValue) {
        return ($this$coerceAtLeast < minimumValue) ? minimumValue : $this$coerceAtLeast;
    }
    
    public static final float coerceAtLeast(final float $this$coerceAtLeast, final float minimumValue) {
        return ($this$coerceAtLeast < minimumValue) ? minimumValue : $this$coerceAtLeast;
    }
    
    public static final double coerceAtLeast(final double $this$coerceAtLeast, final double minimumValue) {
        return ($this$coerceAtLeast < minimumValue) ? minimumValue : $this$coerceAtLeast;
    }
    
    @NotNull
    public static final <T extends Comparable<? super T>> T coerceAtMost(@NotNull final T $this$coerceAtMost, @NotNull final T maximumValue) {
        Intrinsics.checkNotNullParameter($this$coerceAtMost, "<this>");
        Intrinsics.checkNotNullParameter(maximumValue, "maximumValue");
        return ($this$coerceAtMost.compareTo((Object)maximumValue) > 0) ? maximumValue : $this$coerceAtMost;
    }
    
    public static final byte coerceAtMost(final byte $this$coerceAtMost, final byte maximumValue) {
        return ($this$coerceAtMost > maximumValue) ? maximumValue : $this$coerceAtMost;
    }
    
    public static final short coerceAtMost(final short $this$coerceAtMost, final short maximumValue) {
        return ($this$coerceAtMost > maximumValue) ? maximumValue : $this$coerceAtMost;
    }
    
    public static final int coerceAtMost(final int $this$coerceAtMost, final int maximumValue) {
        return ($this$coerceAtMost > maximumValue) ? maximumValue : $this$coerceAtMost;
    }
    
    public static final long coerceAtMost(final long $this$coerceAtMost, final long maximumValue) {
        return ($this$coerceAtMost > maximumValue) ? maximumValue : $this$coerceAtMost;
    }
    
    public static final float coerceAtMost(final float $this$coerceAtMost, final float maximumValue) {
        return ($this$coerceAtMost > maximumValue) ? maximumValue : $this$coerceAtMost;
    }
    
    public static final double coerceAtMost(final double $this$coerceAtMost, final double maximumValue) {
        return ($this$coerceAtMost > maximumValue) ? maximumValue : $this$coerceAtMost;
    }
    
    @NotNull
    public static final <T extends Comparable<? super T>> T coerceIn(@NotNull final T $this$coerceIn, @Nullable final T minimumValue, @Nullable final T maximumValue) {
        Intrinsics.checkNotNullParameter($this$coerceIn, "<this>");
        if (minimumValue != null && maximumValue != null) {
            if (minimumValue.compareTo((Object)maximumValue) > 0) {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + maximumValue + " is less than minimum " + minimumValue + '.');
            }
            if ($this$coerceIn.compareTo((Object)minimumValue) < 0) {
                return minimumValue;
            }
            if ($this$coerceIn.compareTo((Object)maximumValue) > 0) {
                return maximumValue;
            }
        }
        else {
            if (minimumValue != null && $this$coerceIn.compareTo((Object)minimumValue) < 0) {
                return minimumValue;
            }
            if (maximumValue != null && $this$coerceIn.compareTo((Object)maximumValue) > 0) {
                return maximumValue;
            }
        }
        return $this$coerceIn;
    }
    
    public static final byte coerceIn(final byte $this$coerceIn, final byte minimumValue, final byte maximumValue) {
        if (minimumValue > maximumValue) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + maximumValue + " is less than minimum " + minimumValue + '.');
        }
        if ($this$coerceIn < minimumValue) {
            return minimumValue;
        }
        if ($this$coerceIn > maximumValue) {
            return maximumValue;
        }
        return $this$coerceIn;
    }
    
    public static final short coerceIn(final short $this$coerceIn, final short minimumValue, final short maximumValue) {
        if (minimumValue > maximumValue) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + maximumValue + " is less than minimum " + minimumValue + '.');
        }
        if ($this$coerceIn < minimumValue) {
            return minimumValue;
        }
        if ($this$coerceIn > maximumValue) {
            return maximumValue;
        }
        return $this$coerceIn;
    }
    
    public static final int coerceIn(final int $this$coerceIn, final int minimumValue, final int maximumValue) {
        if (minimumValue > maximumValue) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + maximumValue + " is less than minimum " + minimumValue + '.');
        }
        if ($this$coerceIn < minimumValue) {
            return minimumValue;
        }
        if ($this$coerceIn > maximumValue) {
            return maximumValue;
        }
        return $this$coerceIn;
    }
    
    public static final long coerceIn(final long $this$coerceIn, final long minimumValue, final long maximumValue) {
        if (minimumValue > maximumValue) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + maximumValue + " is less than minimum " + minimumValue + '.');
        }
        if ($this$coerceIn < minimumValue) {
            return minimumValue;
        }
        if ($this$coerceIn > maximumValue) {
            return maximumValue;
        }
        return $this$coerceIn;
    }
    
    public static final float coerceIn(final float $this$coerceIn, final float minimumValue, final float maximumValue) {
        if (minimumValue > maximumValue) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + maximumValue + " is less than minimum " + minimumValue + '.');
        }
        if ($this$coerceIn < minimumValue) {
            return minimumValue;
        }
        if ($this$coerceIn > maximumValue) {
            return maximumValue;
        }
        return $this$coerceIn;
    }
    
    public static final double coerceIn(final double $this$coerceIn, final double minimumValue, final double maximumValue) {
        if (minimumValue > maximumValue) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + maximumValue + " is less than minimum " + minimumValue + '.');
        }
        if ($this$coerceIn < minimumValue) {
            return minimumValue;
        }
        if ($this$coerceIn > maximumValue) {
            return maximumValue;
        }
        return $this$coerceIn;
    }
    
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T coerceIn(@NotNull final T $this$coerceIn, @NotNull final ClosedFloatingPointRange<T> range) {
        Intrinsics.checkNotNullParameter($this$coerceIn, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
        }
        return (range.lessThanOrEquals((Comparable<? super T>)$this$coerceIn, range.getStart()) && !range.lessThanOrEquals(range.getStart(), $this$coerceIn)) ? range.getStart() : ((range.lessThanOrEquals(range.getEndInclusive(), (Comparable<? super T>)$this$coerceIn) && !range.lessThanOrEquals((Comparable<? super T>)$this$coerceIn, range.getEndInclusive())) ? range.getEndInclusive() : $this$coerceIn);
    }
    
    @NotNull
    public static final <T extends Comparable<? super T>> T coerceIn(@NotNull final T $this$coerceIn, @NotNull final ClosedRange<T> range) {
        Intrinsics.checkNotNullParameter($this$coerceIn, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return coerceIn($this$coerceIn, (ClosedFloatingPointRange<T>)range);
        }
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
        }
        return ($this$coerceIn.compareTo((Object)range.getStart()) < 0) ? range.getStart() : (($this$coerceIn.compareTo((Object)range.getEndInclusive()) > 0) ? range.getEndInclusive() : $this$coerceIn);
    }
    
    public static final int coerceIn(final int $this$coerceIn, @NotNull final ClosedRange<Integer> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return coerceIn(Integer.valueOf($this$coerceIn), (ClosedFloatingPointRange<Integer>)range).intValue();
        }
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
        }
        return ($this$coerceIn < range.getStart().intValue()) ? range.getStart().intValue() : (($this$coerceIn > range.getEndInclusive().intValue()) ? range.getEndInclusive().intValue() : $this$coerceIn);
    }
    
    public static final long coerceIn(final long $this$coerceIn, @NotNull final ClosedRange<Long> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return coerceIn(Long.valueOf($this$coerceIn), (ClosedFloatingPointRange<Long>)range).longValue();
        }
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
        }
        return ($this$coerceIn < range.getStart().longValue()) ? range.getStart().longValue() : (($this$coerceIn > range.getEndInclusive().longValue()) ? range.getEndInclusive().longValue() : $this$coerceIn);
    }
    
    public RangesKt___RangesKt() {
    }
}
