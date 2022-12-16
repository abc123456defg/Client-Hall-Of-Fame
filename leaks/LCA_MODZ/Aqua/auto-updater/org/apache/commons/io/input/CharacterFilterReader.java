// 
// Decompiled by Procyon v0.5.36
// 

package org.apache.commons.io.input;

import java.util.function.IntPredicate;
import java.io.Reader;

public class CharacterFilterReader extends AbstractCharacterFilterReader
{
    public CharacterFilterReader(final Reader reader, final int skip) {
        super(reader, c -> c == skip);
    }
    
    public CharacterFilterReader(final Reader reader, final IntPredicate skip) {
        super(reader, skip);
    }
}
