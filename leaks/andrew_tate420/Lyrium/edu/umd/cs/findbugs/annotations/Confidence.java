// 
// Decompiled by Procyon v0.5.36
// 

package edu.umd.cs.findbugs.annotations;

public enum Confidence
{
    HIGH(1), 
    MEDIUM(2), 
    LOW(3), 
    IGNORE(5);
    
    private final int confidenceValue;
    
    public int getConfidenceValue() {
        return this.confidenceValue;
    }
    
    private Confidence(final int p) {
        this.confidenceValue = p;
    }
}
