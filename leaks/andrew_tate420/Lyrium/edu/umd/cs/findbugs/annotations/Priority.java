// 
// Decompiled by Procyon v0.5.36
// 

package edu.umd.cs.findbugs.annotations;

@Deprecated
public enum Priority
{
    HIGH(1), 
    MEDIUM(2), 
    LOW(3), 
    IGNORE(5);
    
    private final int priorityValue;
    
    public int getPriorityValue() {
        return this.priorityValue;
    }
    
    private Priority(final int p) {
        this.priorityValue = p;
    }
}
