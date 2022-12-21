// 
// Decompiled by Procyon v0.5.36
// 

package javassist.bytecode.annotation;

public interface MemberValueVisitor
{
    void visitAnnotationMemberValue(final AnnotationMemberValue node);
    
    void visitArrayMemberValue(final ArrayMemberValue node);
    
    void visitBooleanMemberValue(final BooleanMemberValue node);
    
    void visitByteMemberValue(final ByteMemberValue node);
    
    void visitCharMemberValue(final CharMemberValue node);
    
    void visitDoubleMemberValue(final DoubleMemberValue node);
    
    void visitEnumMemberValue(final EnumMemberValue node);
    
    void visitFloatMemberValue(final FloatMemberValue node);
    
    void visitIntegerMemberValue(final IntegerMemberValue node);
    
    void visitLongMemberValue(final LongMemberValue node);
    
    void visitShortMemberValue(final ShortMemberValue node);
    
    void visitStringMemberValue(final StringMemberValue node);
    
    void visitClassMemberValue(final ClassMemberValue node);
}
