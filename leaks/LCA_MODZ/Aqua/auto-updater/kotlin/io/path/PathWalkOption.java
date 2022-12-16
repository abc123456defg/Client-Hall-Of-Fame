// 
// Decompiled by Procyon v0.5.36
// 

package kotlin.io.path;

import kotlin.SinceKotlin;
import kotlin.Metadata;

@Metadata(mv = { 1, 7, 1 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006" }, d2 = { "Lkotlin/io/path/PathWalkOption;", "", "(Ljava/lang/String;I)V", "INCLUDE_DIRECTORIES", "BREADTH_FIRST", "FOLLOW_LINKS", "kotlin-stdlib-jdk7" })
@ExperimentalPathApi
@SinceKotlin(version = "1.7")
public enum PathWalkOption
{
    INCLUDE_DIRECTORIES, 
    BREADTH_FIRST, 
    FOLLOW_LINKS;
    
    private static final /* synthetic */ PathWalkOption[] $values() {
        return new PathWalkOption[] { PathWalkOption.INCLUDE_DIRECTORIES, PathWalkOption.BREADTH_FIRST, PathWalkOption.FOLLOW_LINKS };
    }
    
    static {
        $VALUES = $values();
    }
}
