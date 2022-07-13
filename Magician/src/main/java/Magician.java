import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.agent.builder.AgentBuilder.Default;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

public class Magician {

  public static void premain(String agentArgs, Instrumentation inst) {
//    inst.addTransformer(new ClassFileTransformer() {
//      @Override
//      public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
//          ProtectionDomain protectionDomain, byte[] classfileBuffer)
//          throws IllegalClassFormatException {
//
//        System.out.println("className : " + className);
//        return ClassFileTransformer.super.transform(loader, className, classBeingRedefined,
//            protectionDomain, classfileBuffer);
//      }
//    });

//    inst.addTransformer(new ClassFileTransformer() {
//      @Override
//      public byte[] transform(ClassLoader loader, String className,
//          Class<?> classBeingRedefined,
//          ProtectionDomain protectionDomain,
//          byte[] classfileBuffer)
//          throws IllegalClassFormatException {
//        return null;
//      }
//    });

//    new Default()
//        .type(ElementMatchers.any())
//        .transform((builder, type, classLoader, module) -> {
//              System.out.println("builder : " + builder);
//              System.out.println("type : " + type);
//              System.out.println("classLoader : " + classLoader);
//              System.out.println("module : " + module);
//              return builder.method(target -> {
//                    System.out.println(target);
//                    return true;
//                  })
//                  .intercept(MethodDelegation.to(TimingInterceptor.class));
//            }
//        ).installOn(inst);

    new AgentBuilder.Default()
        .type(ElementMatchers.nameEndsWith("Service"))
        .transform((builder, typeDescription, classLoader, module) ->
            builder.method(ElementMatchers.any())
                .intercept(MethodDelegation.to(TimingInterceptor.class)))
        .installOn(inst);
//        .transform(
//            (builder, typeDescription, classLoader, module) ->
//                builder.method(ElementMatchers.definedMethod(target -> {
//
//                      AnnotationList annotationList = target.getDeclaredAnnotations();
//                      boolean ret = annotationList.stream().map(annotation ->
//                          annotation.getAnnotationType().getCanonicalName()
//                      ).anyMatch(a -> a.contains("LogExecutionTime"));
//                      System.out.println(target + " : " + ret);
//                      return ret;
//                    }))
//                    .intercept(MethodDelegation.to(TimingInterceptor.class)))
//        .installOn(inst);
  }
}
