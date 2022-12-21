// 
// Decompiled by Procyon v0.5.36
// 

package lombok.launch;

import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.Completion;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import java.lang.reflect.Field;
import sun.misc.Unsafe;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.SourceVersion;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;

class AnnotationProcessorHider
{
    public static class AstModificationNotifierData
    {
        public static volatile boolean lombokInvoked;
        
        static {
            AstModificationNotifierData.lombokInvoked = false;
        }
    }
    
    public static class AnnotationProcessor extends AbstractProcessor
    {
        private final AbstractProcessor instance;
        
        public AnnotationProcessor() {
            this.instance = createWrappedInstance();
        }
        
        @Override
        public Set<String> getSupportedOptions() {
            return this.instance.getSupportedOptions();
        }
        
        @Override
        public Set<String> getSupportedAnnotationTypes() {
            return this.instance.getSupportedAnnotationTypes();
        }
        
        @Override
        public SourceVersion getSupportedSourceVersion() {
            return this.instance.getSupportedSourceVersion();
        }
        
        @Override
        public void init(final ProcessingEnvironment processingEnv) {
            this.disableJava9SillyWarning();
            AstModificationNotifierData.lombokInvoked = true;
            this.instance.init(processingEnv);
            super.init(processingEnv);
        }
        
        private void disableJava9SillyWarning() {
            try {
                final Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
                theUnsafe.setAccessible(true);
                final Unsafe u = (Unsafe)theUnsafe.get(null);
                final Class<?> cls = Class.forName("jdk.internal.module.IllegalAccessLogger");
                final Field logger = cls.getDeclaredField("logger");
                u.putObjectVolatile(cls, u.staticFieldOffset(logger), null);
            }
            catch (Throwable t) {}
        }
        
        @Override
        public boolean process(final Set<? extends TypeElement> annotations, final RoundEnvironment roundEnv) {
            return this.instance.process(annotations, roundEnv);
        }
        
        @Override
        public Iterable<? extends Completion> getCompletions(final Element element, final AnnotationMirror annotation, final ExecutableElement member, final String userText) {
            return this.instance.getCompletions(element, annotation, member, userText);
        }
        
        private static AbstractProcessor createWrappedInstance() {
            final ClassLoader cl = Main.getShadowClassLoader();
            try {
                final Class<?> mc = cl.loadClass("lombok.core.AnnotationProcessor");
                return (AbstractProcessor)mc.getDeclaredConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
            }
            catch (Throwable t) {
                if (t instanceof Error) {
                    throw (Error)t;
                }
                if (t instanceof RuntimeException) {
                    throw (RuntimeException)t;
                }
                throw new RuntimeException(t);
            }
        }
    }
    
    @SupportedAnnotationTypes({ "lombok.*" })
    public static class ClaimingProcessor extends AbstractProcessor
    {
        @Override
        public boolean process(final Set<? extends TypeElement> annotations, final RoundEnvironment roundEnv) {
            return true;
        }
        
        @Override
        public SourceVersion getSupportedSourceVersion() {
            return SourceVersion.latest();
        }
    }
}
