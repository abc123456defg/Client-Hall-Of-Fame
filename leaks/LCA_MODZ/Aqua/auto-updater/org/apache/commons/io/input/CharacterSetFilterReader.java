// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.input;

import java.util.Collection;
import java.util.HashSet;
import java.util.Arrays;
import java.io.Reader;
import java.util.Collections;
import java.util.function.IntPredicate;
import java.util.Set;

public class CharacterSetFilterReader extends AbstractCharacterFilterReader
{
    private static IntPredicate toIntPredicate(final Set<Integer> skip) {
        if (skip == null) {
            return CharacterSetFilterReader.SKIP_NONE;
        }
        final Set<Integer> unmodifiableSet = Collections.unmodifiableSet((Set<? extends Integer>)skip);
        return c -> unmodifiableSet.contains(c);
    }
    
    public CharacterSetFilterReader(final Reader reader, final Integer... skip) {
        this(reader, new HashSet<Integer>(Arrays.asList(skip)));
    }
    
    public CharacterSetFilterReader(final Reader reader, final Set<Integer> skip) {
        super(reader, toIntPredicate(skip));
    }
}
