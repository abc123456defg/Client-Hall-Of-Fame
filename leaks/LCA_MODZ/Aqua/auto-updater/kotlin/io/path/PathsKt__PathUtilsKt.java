// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.io.path;

import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.net.URI;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.FileTime;
import java.util.Map;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.PublishedApi;
import kotlin.KotlinNothingValueException;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.FileStore;
import java.nio.file.attribute.FileAttribute;
import java.util.Iterator;
import java.io.Closeable;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.InlineMarker;
import java.nio.file.DirectoryStream;
import kotlin.Unit;
import kotlin.sequences.Sequence;
import kotlin.jvm.functions.Function1;
import java.util.List;
import java.nio.file.LinkOption;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.nio.file.StandardCopyOption;
import java.nio.file.CopyOption;
import org.jetbrains.annotations.Nullable;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Deprecated;
import kotlin.internal.InlineOnly;
import kotlin.WasExperimental;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import java.nio.file.Path;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 5, xi = 49, d1 = { "\u0000\u00cc\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a*\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00012\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001a\"\u00020\u0001H\u0087\b¢\u0006\u0002\u0010\u001b\u001a?\u0010\u001c\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007¢\u0006\u0002\u0010!\u001a6\u0010\u001c\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010\"\u001aK\u0010#\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007¢\u0006\u0002\u0010%\u001aB\u0010#\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010&\u001a\u001c\u0010'\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u00022\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0001\u001a4\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020,2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.¢\u0006\u0002\b1H\u0007\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\r\u00102\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u00103\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a.\u00104\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u0002070\u001a\"\u000207H\u0087\b¢\u0006\u0002\u00108\u001a\u001f\u00104\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\b\b\u0002\u00109\u001a\u00020:H\u0087\b\u001a.\u0010;\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010<\u001a.\u0010=\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010<\u001a.\u0010>\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010<\u001a\u0015\u0010?\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u0002H\u0087\b\u001a6\u0010@\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010A\u001a\r\u0010B\u001a\u000200*\u00020\u0002H\u0087\b\u001a\r\u0010C\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\u0015\u0010D\u001a\u00020\u0002*\u00020\u00022\u0006\u0010E\u001a\u00020\u0002H\u0087\n\u001a\u0015\u0010D\u001a\u00020\u0002*\u00020\u00022\u0006\u0010E\u001a\u00020\u0001H\u0087\n\u001a&\u0010F\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\u0087\b¢\u0006\u0002\u0010H\u001a2\u0010I\u001a\u0002HJ\"\n\b\u0000\u0010J\u0018\u0001*\u00020K*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\u0087\b¢\u0006\u0002\u0010L\u001a4\u0010M\u001a\u0004\u0018\u0001HJ\"\n\b\u0000\u0010J\u0018\u0001*\u00020K*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\u0087\b¢\u0006\u0002\u0010L\u001a\r\u0010N\u001a\u00020O*\u00020\u0002H\u0087\b\u001a\r\u0010P\u001a\u00020Q*\u00020\u0002H\u0087\b\u001a.\u0010R\u001a\u000200*\u00020\u00022\b\b\u0002\u0010S\u001a\u00020\u00012\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002000.H\u0087\b\u00f8\u0001\u0000\u001a0\u0010U\u001a\u0004\u0018\u00010V*\u00020\u00022\u0006\u0010W\u001a\u00020\u00012\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\u0087\b¢\u0006\u0002\u0010X\u001a&\u0010Y\u001a\u00020Z*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\u0087\b¢\u0006\u0002\u0010[\u001a(\u0010\\\u001a\u0004\u0018\u00010]*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\u0087\b¢\u0006\u0002\u0010^\u001a,\u0010_\u001a\b\u0012\u0004\u0012\u00020a0`*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\u0087\b¢\u0006\u0002\u0010b\u001a&\u0010c\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\u0087\b¢\u0006\u0002\u0010H\u001a\r\u0010d\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\r\u0010e\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\r\u0010f\u001a\u00020:*\u00020\u0002H\u0087\b\u001a&\u0010g\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\u0087\b¢\u0006\u0002\u0010H\u001a\u0015\u0010h\u001a\u00020:*\u00020\u00022\u0006\u0010E\u001a\u00020\u0002H\u0087\b\u001a\r\u0010i\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\r\u0010j\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\u001c\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00020l*\u00020\u00022\b\b\u0002\u0010S\u001a\u00020\u0001H\u0007\u001a.\u0010m\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u0002070\u001a\"\u000207H\u0087\b¢\u0006\u0002\u00108\u001a\u001f\u0010m\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\b\b\u0002\u00109\u001a\u00020:H\u0087\b\u001a&\u0010n\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\u0087\b¢\u0006\u0002\u0010H\u001a2\u0010o\u001a\u0002Hp\"\n\b\u0000\u0010p\u0018\u0001*\u00020q*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\u0087\b¢\u0006\u0002\u0010r\u001a<\u0010o\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010V0s*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00012\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\u0087\b¢\u0006\u0002\u0010t\u001a\r\u0010u\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0014\u0010v\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a\u0016\u0010w\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a\u0014\u0010x\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a8\u0010y\u001a\u00020\u0002*\u00020\u00022\u0006\u0010W\u001a\u00020\u00012\b\u0010z\u001a\u0004\u0018\u00010V2\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020G0\u001a\"\u00020GH\u0087\b¢\u0006\u0002\u0010{\u001a\u0015\u0010|\u001a\u00020\u0002*\u00020\u00022\u0006\u0010z\u001a\u00020ZH\u0087\b\u001a\u0015\u0010}\u001a\u00020\u0002*\u00020\u00022\u0006\u0010z\u001a\u00020]H\u0087\b\u001a\u001b\u0010~\u001a\u00020\u0002*\u00020\u00022\f\u0010z\u001a\b\u0012\u0004\u0012\u00020a0`H\u0087\b\u001a\u000e\u0010\u007f\u001a\u00020\u0002*\u00030\u0080\u0001H\u0087\b\u001aF\u0010\u0081\u0001\u001a\u0003H\u0082\u0001\"\u0005\b\u0000\u0010\u0082\u0001*\u00020\u00022\b\b\u0002\u0010S\u001a\u00020\u00012\u001b\u0010\u0083\u0001\u001a\u0016\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00020\u0084\u0001\u0012\u0005\u0012\u0003H\u0082\u00010.H\u0087\b\u00f8\u0001\u0000¢\u0006\u0003\u0010\u0085\u0001\u001a3\u0010\u0086\u0001\u001a\u000200*\u00020\u00022\r\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020,2\n\b\u0002\u0010\u0088\u0001\u001a\u00030\u0089\u00012\t\b\u0002\u0010\u008a\u0001\u001a\u00020:H\u0007\u001aJ\u0010\u0086\u0001\u001a\u000200*\u00020\u00022\n\b\u0002\u0010\u0088\u0001\u001a\u00030\u0089\u00012\t\b\u0002\u0010\u008a\u0001\u001a\u00020:2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.¢\u0006\u0002\b1H\u0007\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001\u001a0\u0010\u008b\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u0084\u0001*\u00020\u00022\u0014\u00106\u001a\u000b\u0012\u0007\b\u0001\u0012\u00030\u008c\u00010\u001a\"\u00030\u008c\u0001H\u0007¢\u0006\u0003\u0010\u008d\u0001\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020\u00028\u00c6\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u001e\u0010\r\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u001e\u0010\u0010\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00028\u00c6\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u008e\u0001" }, d2 = { "extension", "", "Ljava/nio/file/Path;", "getExtension$annotations", "(Ljava/nio/file/Path;)V", "getExtension", "(Ljava/nio/file/Path;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath$annotations", "getInvariantSeparatorsPath", "invariantSeparatorsPathString", "getInvariantSeparatorsPathString$annotations", "getInvariantSeparatorsPathString", "name", "getName$annotations", "getName", "nameWithoutExtension", "getNameWithoutExtension$annotations", "getNameWithoutExtension", "pathString", "getPathString$annotations", "getPathString", "Path", "path", "base", "subpaths", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", "createTempDirectory", "directory", "prefix", "attributes", "Ljava/nio/file/attribute/FileAttribute;", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createTempFile", "suffix", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "fileAttributeViewNotAvailable", "", "attributeViewClass", "Ljava/lang/Class;", "fileVisitor", "Ljava/nio/file/FileVisitor;", "builderAction", "Lkotlin/Function1;", "Lkotlin/io/path/FileVisitorBuilder;", "", "Lkotlin/ExtensionFunctionType;", "absolute", "absolutePathString", "copyTo", "target", "options", "Ljava/nio/file/CopyOption;", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;", "overwrite", "", "createDirectories", "(Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createDirectory", "createFile", "createLinkPointingTo", "createSymbolicLinkPointingTo", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "deleteExisting", "deleteIfExists", "div", "other", "exists", "Ljava/nio/file/LinkOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "fileAttributesView", "V", "Ljava/nio/file/attribute/FileAttributeView;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileAttributeView;", "fileAttributesViewOrNull", "fileSize", "", "fileStore", "Ljava/nio/file/FileStore;", "forEachDirectoryEntry", "glob", "action", "getAttribute", "", "attribute", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "getLastModifiedTime", "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileTime;", "getOwner", "Ljava/nio/file/attribute/UserPrincipal;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/UserPrincipal;", "getPosixFilePermissions", "", "Ljava/nio/file/attribute/PosixFilePermission;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/util/Set;", "isDirectory", "isExecutable", "isHidden", "isReadable", "isRegularFile", "isSameFileAs", "isSymbolicLink", "isWritable", "listDirectoryEntries", "", "moveTo", "notExists", "readAttributes", "A", "Ljava/nio/file/attribute/BasicFileAttributes;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/BasicFileAttributes;", "", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/util/Map;", "readSymbolicLink", "relativeTo", "relativeToOrNull", "relativeToOrSelf", "setAttribute", "value", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/Object;[Ljava/nio/file/LinkOption;)Ljava/nio/file/Path;", "setLastModifiedTime", "setOwner", "setPosixFilePermissions", "toPath", "Ljava/net/URI;", "useDirectoryEntries", "T", "block", "Lkotlin/sequences/Sequence;", "(Ljava/nio/file/Path;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "visitFileTree", "visitor", "maxDepth", "", "followLinks", "walk", "Lkotlin/io/path/PathWalkOption;", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)Lkotlin/sequences/Sequence;", "kotlin-stdlib-jdk7" }, xs = "kotlin/io/path/PathsKt")
class PathsKt__PathUtilsKt extends PathsKt__PathReadWriteKt
{
    @NotNull
    public static final String getName(@NotNull final Path $this$name) {
        Intrinsics.checkNotNullParameter($this$name, "<this>");
        final Path fileName = $this$name.getFileName();
        String s = (fileName != null) ? fileName.toString() : null;
        if (s == null) {
            s = "";
        }
        return s;
    }
    
    @NotNull
    public static final String getNameWithoutExtension(@NotNull final Path $this$nameWithoutExtension) {
        Intrinsics.checkNotNullParameter($this$nameWithoutExtension, "<this>");
        final Path fileName = $this$nameWithoutExtension.getFileName();
        if (fileName != null) {
            final String string = fileName.toString();
            final String substringBeforeLast$default;
            if (string != null && (substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(string, ".", null, 2, null)) != null) {
                return substringBeforeLast$default;
            }
        }
        return "";
    }
    
    @NotNull
    public static final String getExtension(@NotNull final Path $this$extension) {
        Intrinsics.checkNotNullParameter($this$extension, "<this>");
        final Path fileName = $this$extension.getFileName();
        if (fileName != null) {
            final String string = fileName.toString();
            final String substringAfterLast;
            if (string != null && (substringAfterLast = StringsKt__StringsKt.substringAfterLast(string, '.', "")) != null) {
                return substringAfterLast;
            }
        }
        return "";
    }
    
    private static final String getPathString(final Path $this$pathString) {
        Intrinsics.checkNotNullParameter($this$pathString, "<this>");
        return $this$pathString.toString();
    }
    
    @NotNull
    public static final String getInvariantSeparatorsPathString(@NotNull final Path $this$invariantSeparatorsPathString) {
        Intrinsics.checkNotNullParameter($this$invariantSeparatorsPathString, "<this>");
        final String separator = $this$invariantSeparatorsPathString.getFileSystem().getSeparator();
        String s;
        if (!Intrinsics.areEqual(separator, "/")) {
            final String string = $this$invariantSeparatorsPathString.toString();
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            s = StringsKt__StringsJVMKt.replace$default(string, separator, "/", false, 4, null);
        }
        else {
            s = $this$invariantSeparatorsPathString.toString();
        }
        return s;
    }
    
    @java.lang.Deprecated
    private static final String getInvariantSeparatorsPath(final Path $this$invariantSeparatorsPath) {
        Intrinsics.checkNotNullParameter($this$invariantSeparatorsPath, "<this>");
        return getInvariantSeparatorsPathString($this$invariantSeparatorsPath);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path absolute(final Path $this$absolute) {
        Intrinsics.checkNotNullParameter($this$absolute, "<this>");
        final Path absolutePath = $this$absolute.toAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "toAbsolutePath()");
        return absolutePath;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final String absolutePathString(final Path $this$absolutePathString) {
        Intrinsics.checkNotNullParameter($this$absolutePathString, "<this>");
        return $this$absolutePathString.toAbsolutePath().toString();
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @NotNull
    public static final Path relativeTo(@NotNull final Path $this$relativeTo, @NotNull final Path base) {
        Intrinsics.checkNotNullParameter($this$relativeTo, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        Path tryRelativeTo;
        try {
            tryRelativeTo = PathRelativizer.INSTANCE.tryRelativeTo($this$relativeTo, base);
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage() + "\nthis path: " + $this$relativeTo + "\nbase path: " + base, e);
        }
        return tryRelativeTo;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @NotNull
    public static final Path relativeToOrSelf(@NotNull final Path $this$relativeToOrSelf, @NotNull final Path base) {
        Intrinsics.checkNotNullParameter($this$relativeToOrSelf, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        Path relativeToOrNull;
        if ((relativeToOrNull = relativeToOrNull($this$relativeToOrSelf, base)) == null) {
            relativeToOrNull = $this$relativeToOrSelf;
        }
        return relativeToOrNull;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @Nullable
    public static final Path relativeToOrNull(@NotNull final Path $this$relativeToOrNull, @NotNull final Path base) {
        Intrinsics.checkNotNullParameter($this$relativeToOrNull, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        Path tryRelativeTo;
        try {
            tryRelativeTo = PathRelativizer.INSTANCE.tryRelativeTo($this$relativeToOrNull, base);
        }
        catch (IllegalArgumentException e) {
            tryRelativeTo = null;
        }
        return tryRelativeTo;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path copyTo(final Path $this$copyTo, final Path target, final boolean overwrite) throws IOException {
        Intrinsics.checkNotNullParameter($this$copyTo, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        CopyOption[] array;
        if (overwrite) {
            array = new CopyOption[] { StandardCopyOption.REPLACE_EXISTING };
        }
        else {
            final int $i$f$emptyArray = 0;
            array = new CopyOption[0];
        }
        final CopyOption[] options = array;
        final Path copy = Files.copy($this$copyTo, target, (CopyOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(copy, "copy(this, target, *options)");
        return copy;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path copyTo(final Path $this$copyTo, final Path target, final CopyOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$copyTo, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(options, "options");
        final Path copy = Files.copy($this$copyTo, target, (CopyOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(copy, "copy(this, target, *options)");
        return copy;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final boolean exists(final Path $this$exists, final LinkOption... options) {
        Intrinsics.checkNotNullParameter($this$exists, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.exists($this$exists, (LinkOption[])Arrays.copyOf(options, options.length));
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final boolean notExists(final Path $this$notExists, final LinkOption... options) {
        Intrinsics.checkNotNullParameter($this$notExists, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.notExists($this$notExists, (LinkOption[])Arrays.copyOf(options, options.length));
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final boolean isRegularFile(final Path $this$isRegularFile, final LinkOption... options) {
        Intrinsics.checkNotNullParameter($this$isRegularFile, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.isRegularFile($this$isRegularFile, (LinkOption[])Arrays.copyOf(options, options.length));
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final boolean isDirectory(final Path $this$isDirectory, final LinkOption... options) {
        Intrinsics.checkNotNullParameter($this$isDirectory, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.isDirectory($this$isDirectory, (LinkOption[])Arrays.copyOf(options, options.length));
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final boolean isSymbolicLink(final Path $this$isSymbolicLink) {
        Intrinsics.checkNotNullParameter($this$isSymbolicLink, "<this>");
        return Files.isSymbolicLink($this$isSymbolicLink);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final boolean isExecutable(final Path $this$isExecutable) {
        Intrinsics.checkNotNullParameter($this$isExecutable, "<this>");
        return Files.isExecutable($this$isExecutable);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final boolean isHidden(final Path $this$isHidden) throws IOException {
        Intrinsics.checkNotNullParameter($this$isHidden, "<this>");
        return Files.isHidden($this$isHidden);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final boolean isReadable(final Path $this$isReadable) {
        Intrinsics.checkNotNullParameter($this$isReadable, "<this>");
        return Files.isReadable($this$isReadable);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final boolean isWritable(final Path $this$isWritable) {
        Intrinsics.checkNotNullParameter($this$isWritable, "<this>");
        return Files.isWritable($this$isWritable);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final boolean isSameFileAs(final Path $this$isSameFileAs, final Path other) throws IOException {
        Intrinsics.checkNotNullParameter($this$isSameFileAs, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Files.isSameFile($this$isSameFileAs, other);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @NotNull
    public static final List<Path> listDirectoryEntries(@NotNull final Path $this$listDirectoryEntries, @NotNull final String glob) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* glob */
        //     7: ldc_w           "glob"
        //    10: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    13: aload_0         /* $this$listDirectoryEntries */
        //    14: aload_1         /* glob */
        //    15: invokestatic    java/nio/file/Files.newDirectoryStream:(Ljava/nio/file/Path;Ljava/lang/String;)Ljava/nio/file/DirectoryStream;
        //    18: checkcast       Ljava/io/Closeable;
        //    21: astore_2       
        //    22: aconst_null    
        //    23: astore_3       
        //    24: nop            
        //    25: aload_2        
        //    26: checkcast       Ljava/nio/file/DirectoryStream;
        //    29: astore          it
        //    31: iconst_0       
        //    32: istore          $i$a$-use-PathsKt__PathUtilsKt$listDirectoryEntries$1
        //    34: aload           it
        //    36: ldc_w           "it"
        //    39: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    42: aload           it
        //    44: checkcast       Ljava/lang/Iterable;
        //    47: invokestatic    kotlin/collections/CollectionsKt.toList:(Ljava/lang/Iterable;)Ljava/util/List;
        //    50: astore          null
        //    52: aload_2        
        //    53: aload_3        
        //    54: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //    57: aload           4
        //    59: goto            80
        //    62: astore          4
        //    64: aload           4
        //    66: astore_3       
        //    67: aload           4
        //    69: athrow         
        //    70: astore          4
        //    72: aload_2        
        //    73: aload_3        
        //    74: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //    77: aload           4
        //    79: athrow         
        //    80: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    Signature:
        //  (Ljava/nio/file/Path;Ljava/lang/String;)Ljava/util/List<Ljava/nio/file/Path;>;
        //    StackMapTable: 00 03 FF 00 3E 00 04 07 00 11 07 00 21 07 01 10 05 00 01 07 00 9E FF 00 07 00 04 07 00 11 07 00 21 07 01 10 07 00 9E 00 01 07 00 9E FF 00 09 00 06 07 00 11 07 00 21 07 01 10 05 07 01 27 01 00 01 07 01 27
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  24     52     62     70     Ljava/lang/Throwable;
        //  24     52     70     80     Any
        //  62     70     70     80     Any
        //  70     72     70     80     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.remove(ArrayList.java:535)
        //     at com.strobel.assembler.ir.StackMappingVisitor.pop(StackMappingVisitor.java:267)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:595)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final <T> T useDirectoryEntries(final Path $this$useDirectoryEntries, final String glob, final Function1<? super Sequence<? extends Path>, ? extends T> block) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* glob */
        //     7: ldc_w           "glob"
        //    10: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    13: aload_2         /* block */
        //    14: ldc_w           "block"
        //    17: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    20: aload_0         /* $this$useDirectoryEntries */
        //    21: aload_1         /* glob */
        //    22: invokestatic    java/nio/file/Files.newDirectoryStream:(Ljava/nio/file/Path;Ljava/lang/String;)Ljava/nio/file/DirectoryStream;
        //    25: checkcast       Ljava/io/Closeable;
        //    28: astore_3       
        //    29: aconst_null    
        //    30: astore          4
        //    32: nop            
        //    33: aload_3        
        //    34: checkcast       Ljava/nio/file/DirectoryStream;
        //    37: astore          it
        //    39: iconst_0       
        //    40: istore          $i$a$-use-PathsKt__PathUtilsKt$useDirectoryEntries$1
        //    42: aload_2         /* block */
        //    43: aload           it
        //    45: ldc_w           "it"
        //    48: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    51: aload           it
        //    53: checkcast       Ljava/lang/Iterable;
        //    56: invokestatic    kotlin/collections/CollectionsKt.asSequence:(Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;
        //    59: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //    64: astore          null
        //    66: iconst_1       
        //    67: invokestatic    kotlin/jvm/internal/InlineMarker.finallyStart:(I)V
        //    70: aload_3        
        //    71: aload           4
        //    73: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //    76: iconst_1       
        //    77: invokestatic    kotlin/jvm/internal/InlineMarker.finallyEnd:(I)V
        //    80: aload           5
        //    82: goto            113
        //    85: astore          5
        //    87: aload           5
        //    89: astore          4
        //    91: aload           5
        //    93: athrow         
        //    94: astore          5
        //    96: iconst_1       
        //    97: invokestatic    kotlin/jvm/internal/InlineMarker.finallyStart:(I)V
        //   100: aload_3        
        //   101: aload           4
        //   103: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //   106: iconst_1       
        //   107: invokestatic    kotlin/jvm/internal/InlineMarker.finallyEnd:(I)V
        //   110: aload           5
        //   112: athrow         
        //   113: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    Signature:
        //  <T:Ljava/lang/Object;>(Ljava/nio/file/Path;Ljava/lang/String;Lkotlin/jvm/functions/Function1<-Lkotlin/sequences/Sequence<+Ljava/nio/file/Path;>;+TT;>;)TT;
        //    StackMapTable: 00 03 FF 00 55 00 05 07 00 11 07 00 21 07 01 38 07 01 10 05 00 01 07 00 9E FF 00 08 00 05 07 00 11 07 00 21 07 01 38 07 01 10 07 00 9E 00 01 07 00 9E FF 00 12 00 07 07 00 11 07 00 21 07 01 38 07 01 10 05 07 00 17 01 00 01 07 00 17
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  32     66     85     94     Ljava/lang/Throwable;
        //  32     66     94     113    Any
        //  85     94     94     113    Any
        //  94     96     94     113    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.remove(ArrayList.java:535)
        //     at com.strobel.assembler.ir.StackMappingVisitor.pop(StackMappingVisitor.java:267)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:595)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final void forEachDirectoryEntry(final Path $this$forEachDirectoryEntry, final String glob, final Function1<? super Path, Unit> action) throws IOException {
        Intrinsics.checkNotNullParameter($this$forEachDirectoryEntry, "<this>");
        Intrinsics.checkNotNullParameter(glob, "glob");
        Intrinsics.checkNotNullParameter(action, "action");
        final DirectoryStream<Path> $this$closeFinally = Files.newDirectoryStream($this$forEachDirectoryEntry, glob);
        Throwable cause = null;
        try {
            final DirectoryStream it = $this$closeFinally;
            final int n = 0;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            final Iterable $this$forEach$iv = it;
            final int $i$f$forEach = 0;
            for (final Object element$iv : $this$forEach$iv) {
                action.invoke((Object)element$iv);
            }
            final Unit instance = Unit.INSTANCE;
        }
        catch (Throwable t) {
            cause = t;
            throw t;
        }
        finally {
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally($this$closeFinally, cause);
            InlineMarker.finallyEnd(1);
        }
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final long fileSize(final Path $this$fileSize) throws IOException {
        Intrinsics.checkNotNullParameter($this$fileSize, "<this>");
        return Files.size($this$fileSize);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final void deleteExisting(final Path $this$deleteExisting) throws IOException {
        Intrinsics.checkNotNullParameter($this$deleteExisting, "<this>");
        Files.delete($this$deleteExisting);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final boolean deleteIfExists(final Path $this$deleteIfExists) throws IOException {
        Intrinsics.checkNotNullParameter($this$deleteIfExists, "<this>");
        return Files.deleteIfExists($this$deleteIfExists);
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path createDirectory(final Path $this$createDirectory, final FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter($this$createDirectory, "<this>");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        final Path directory = Files.createDirectory($this$createDirectory, (FileAttribute<?>[])Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(directory, "createDirectory(this, *attributes)");
        return directory;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path createDirectories(final Path $this$createDirectories, final FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter($this$createDirectories, "<this>");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        final Path directories = Files.createDirectories($this$createDirectories, (FileAttribute<?>[])Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(directories, "createDirectories(this, *attributes)");
        return directories;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path moveTo(final Path $this$moveTo, final Path target, final CopyOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$moveTo, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(options, "options");
        final Path move = Files.move($this$moveTo, target, (CopyOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(move, "move(this, target, *options)");
        return move;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path moveTo(final Path $this$moveTo, final Path target, final boolean overwrite) throws IOException {
        Intrinsics.checkNotNullParameter($this$moveTo, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        CopyOption[] array;
        if (overwrite) {
            array = new CopyOption[] { StandardCopyOption.REPLACE_EXISTING };
        }
        else {
            final int $i$f$emptyArray = 0;
            array = new CopyOption[0];
        }
        final CopyOption[] options = array;
        final Path move = Files.move($this$moveTo, target, (CopyOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(move, "move(this, target, *options)");
        return move;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final FileStore fileStore(final Path $this$fileStore) throws IOException {
        Intrinsics.checkNotNullParameter($this$fileStore, "<this>");
        final FileStore fileStore = Files.getFileStore($this$fileStore);
        Intrinsics.checkNotNullExpressionValue(fileStore, "getFileStore(this)");
        return fileStore;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Object getAttribute(final Path $this$getAttribute, final String attribute, final LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$getAttribute, "<this>");
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.getAttribute($this$getAttribute, attribute, (LinkOption[])Arrays.copyOf(options, options.length));
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path setAttribute(final Path $this$setAttribute, final String attribute, final Object value, final LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$setAttribute, "<this>");
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        Intrinsics.checkNotNullParameter(options, "options");
        final Path setAttribute = Files.setAttribute($this$setAttribute, attribute, value, (LinkOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(setAttribute, "setAttribute(this, attribute, value, *options)");
        return setAttribute;
    }
    
    @PublishedApi
    @NotNull
    public static final Void fileAttributeViewNotAvailable(@NotNull final Path path, @NotNull final Class<?> attributeViewClass) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(attributeViewClass, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + attributeViewClass + " is not available for the file " + path + '.');
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Map<String, Object> readAttributes(final Path $this$readAttributes, final String attributes, final LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$readAttributes, "<this>");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(options, "options");
        final Map<String, Object> attributes2 = Files.readAttributes($this$readAttributes, attributes, (LinkOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(attributes2, "readAttributes(this, attributes, *options)");
        return attributes2;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final FileTime getLastModifiedTime(final Path $this$getLastModifiedTime, final LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$getLastModifiedTime, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        final FileTime lastModifiedTime = Files.getLastModifiedTime($this$getLastModifiedTime, (LinkOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(lastModifiedTime, "getLastModifiedTime(this, *options)");
        return lastModifiedTime;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path setLastModifiedTime(final Path $this$setLastModifiedTime, final FileTime value) throws IOException {
        Intrinsics.checkNotNullParameter($this$setLastModifiedTime, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        final Path setLastModifiedTime = Files.setLastModifiedTime($this$setLastModifiedTime, value);
        Intrinsics.checkNotNullExpressionValue(setLastModifiedTime, "setLastModifiedTime(this, value)");
        return setLastModifiedTime;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final UserPrincipal getOwner(final Path $this$getOwner, final LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$getOwner, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.getOwner($this$getOwner, (LinkOption[])Arrays.copyOf(options, options.length));
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path setOwner(final Path $this$setOwner, final UserPrincipal value) throws IOException {
        Intrinsics.checkNotNullParameter($this$setOwner, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        final Path setOwner = Files.setOwner($this$setOwner, value);
        Intrinsics.checkNotNullExpressionValue(setOwner, "setOwner(this, value)");
        return setOwner;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Set<PosixFilePermission> getPosixFilePermissions(final Path $this$getPosixFilePermissions, final LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$getPosixFilePermissions, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        final Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions($this$getPosixFilePermissions, (LinkOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(posixFilePermissions, "getPosixFilePermissions(this, *options)");
        return posixFilePermissions;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path setPosixFilePermissions(final Path $this$setPosixFilePermissions, final Set<? extends PosixFilePermission> value) throws IOException {
        Intrinsics.checkNotNullParameter($this$setPosixFilePermissions, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        final Path setPosixFilePermissions = Files.setPosixFilePermissions($this$setPosixFilePermissions, (Set<PosixFilePermission>)value);
        Intrinsics.checkNotNullExpressionValue(setPosixFilePermissions, "setPosixFilePermissions(this, value)");
        return setPosixFilePermissions;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path createLinkPointingTo(final Path $this$createLinkPointingTo, final Path target) throws IOException {
        Intrinsics.checkNotNullParameter($this$createLinkPointingTo, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        final Path link = Files.createLink($this$createLinkPointingTo, target);
        Intrinsics.checkNotNullExpressionValue(link, "createLink(this, target)");
        return link;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path createSymbolicLinkPointingTo(final Path $this$createSymbolicLinkPointingTo, final Path target, final FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter($this$createSymbolicLinkPointingTo, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        final Path symbolicLink = Files.createSymbolicLink($this$createSymbolicLinkPointingTo, target, (FileAttribute<?>[])Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(symbolicLink, "createSymbolicLink(this, target, *attributes)");
        return symbolicLink;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path readSymbolicLink(final Path $this$readSymbolicLink) throws IOException {
        Intrinsics.checkNotNullParameter($this$readSymbolicLink, "<this>");
        final Path symbolicLink = Files.readSymbolicLink($this$readSymbolicLink);
        Intrinsics.checkNotNullExpressionValue(symbolicLink, "readSymbolicLink(this)");
        return symbolicLink;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path createFile(final Path $this$createFile, final FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter($this$createFile, "<this>");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        final Path file = Files.createFile($this$createFile, (FileAttribute<?>[])Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(file, "createFile(this, *attributes)");
        return file;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path createTempFile(final String prefix, final String suffix, final FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        final Path tempFile = Files.createTempFile(prefix, suffix, (FileAttribute<?>[])Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(tempFile, "createTempFile(prefix, suffix, *attributes)");
        return tempFile;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @NotNull
    public static final Path createTempFile(@Nullable final Path directory, @Nullable final String prefix, @Nullable final String suffix, @NotNull final FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Path path;
        if (directory != null) {
            Intrinsics.checkNotNullExpressionValue(path = Files.createTempFile(directory, prefix, suffix, (FileAttribute<?>[])Arrays.copyOf(attributes, attributes.length)), "createTempFile(directory\u2026fix, suffix, *attributes)");
        }
        else {
            Intrinsics.checkNotNullExpressionValue(path = Files.createTempFile(prefix, suffix, (FileAttribute<?>[])Arrays.copyOf(attributes, attributes.length)), "createTempFile(prefix, suffix, *attributes)");
        }
        return path;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path createTempDirectory(final String prefix, final FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        final Path tempDirectory = Files.createTempDirectory(prefix, (FileAttribute<?>[])Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(tempDirectory, "createTempDirectory(prefix, *attributes)");
        return tempDirectory;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @NotNull
    public static final Path createTempDirectory(@Nullable final Path directory, @Nullable final String prefix, @NotNull final FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Path path;
        if (directory != null) {
            Intrinsics.checkNotNullExpressionValue(path = Files.createTempDirectory(directory, prefix, (FileAttribute<?>[])Arrays.copyOf(attributes, attributes.length)), "createTempDirectory(dire\u2026ory, prefix, *attributes)");
        }
        else {
            Intrinsics.checkNotNullExpressionValue(path = Files.createTempDirectory(prefix, (FileAttribute<?>[])Arrays.copyOf(attributes, attributes.length)), "createTempDirectory(prefix, *attributes)");
        }
        return path;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path div(final Path $this$div, final Path other) {
        Intrinsics.checkNotNullParameter($this$div, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        final Path resolve = $this$div.resolve(other);
        Intrinsics.checkNotNullExpressionValue(resolve, "this.resolve(other)");
        return resolve;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path div(final Path $this$div, final String other) {
        Intrinsics.checkNotNullParameter($this$div, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        final Path resolve = $this$div.resolve(other);
        Intrinsics.checkNotNullExpressionValue(resolve, "this.resolve(other)");
        return resolve;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path Path(final String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        final Path value = Paths.get(path, new String[0]);
        Intrinsics.checkNotNullExpressionValue(value, "get(path)");
        return value;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path Path(final String base, final String... subpaths) {
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(subpaths, "subpaths");
        final Path value = Paths.get(base, (String[])Arrays.copyOf(subpaths, subpaths.length));
        Intrinsics.checkNotNullExpressionValue(value, "get(base, *subpaths)");
        return value;
    }
    
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = { ExperimentalPathApi.class })
    @InlineOnly
    private static final Path toPath(final URI $this$toPath) {
        Intrinsics.checkNotNullParameter($this$toPath, "<this>");
        final Path value = Paths.get($this$toPath);
        Intrinsics.checkNotNullExpressionValue(value, "get(this)");
        return value;
    }
    
    @ExperimentalPathApi
    @SinceKotlin(version = "1.7")
    @NotNull
    public static final Sequence<Path> walk(@NotNull final Path $this$walk, @NotNull final PathWalkOption... options) {
        Intrinsics.checkNotNullParameter($this$walk, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return new PathTreeWalk($this$walk, options);
    }
    
    @ExperimentalPathApi
    @SinceKotlin(version = "1.7")
    public static final void visitFileTree(@NotNull final Path $this$visitFileTree, @NotNull final FileVisitor<Path> visitor, final int maxDepth, final boolean followLinks) {
        Intrinsics.checkNotNullParameter($this$visitFileTree, "<this>");
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        final Set options = followLinks ? SetsKt__SetsJVMKt.setOf(FileVisitOption.FOLLOW_LINKS) : SetsKt__SetsKt.emptySet();
        Files.walkFileTree($this$visitFileTree, options, maxDepth, visitor);
    }
    
    @ExperimentalPathApi
    @SinceKotlin(version = "1.7")
    public static final void visitFileTree(@NotNull final Path $this$visitFileTree, final int maxDepth, final boolean followLinks, @NotNull final Function1<? super FileVisitorBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter($this$visitFileTree, "<this>");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        visitFileTree($this$visitFileTree, fileVisitor(builderAction), maxDepth, followLinks);
    }
    
    @ExperimentalPathApi
    @SinceKotlin(version = "1.7")
    @NotNull
    public static final FileVisitor<Path> fileVisitor(@NotNull final Function1<? super FileVisitorBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        final FileVisitorBuilderImpl fileVisitorBuilderImpl = new FileVisitorBuilderImpl();
        builderAction.invoke(fileVisitorBuilderImpl);
        return fileVisitorBuilderImpl.build();
    }
    
    public PathsKt__PathUtilsKt() {
    }
}
