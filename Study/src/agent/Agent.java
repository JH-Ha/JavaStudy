//package agent;
//
//import java.lang.instrument.Instrumentation;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class Agent {
//
//  static Logger LOGGER = LoggerFactory.getLogger(Agent.class);
//
//  //  public static void premain(String args, Instrumentation instrumentation) {
////    ClassLogger transformer = new ClassLogger();
////    instrumentation.addTransformer(transformer);
////  }
//  public static void premain(
//      String agentArgs, Instrumentation inst) {
//
//    LOGGER.info("[Agent] In premain method");
//    String className = "com.baeldung.instrumentation.application.MyAtm";
//    transformClass(className, inst);
//  }
//
//  private static void transformClass(
//      String className, Instrumentation instrumentation) {
//    Class<?> targetCls = null;
//    ClassLoader targetClassLoader = null;
//    // see if we can get the class using forName
//    try {
//      targetCls = Class.forName(className);
//      targetClassLoader = targetCls.getClassLoader();
//      transform(targetCls, targetClassLoader, instrumentation);
//      return;
//    } catch (Exception ex) {
//      LOGGER.error("Class [{}] not found with Class.forName");
//    }
//    // otherwise iterate all loaded classes and find what we want
//    for(Class<?> clazz: instrumentation.getAllLoadedClasses()) {
//      if(clazz.getName().equals(className)) {
//        targetCls = clazz;
//        targetClassLoader = targetCls.getClassLoader();
//        transform(targetCls, targetClassLoader, instrumentation);
//        return;
//      }
//    }
//    throw new RuntimeException(
//        "Failed to find class [" + className + "]");
//  }
//
//  private static void transform(
//      Class<?> clazz,
//      ClassLoader classLoader,
//      Instrumentation instrumentation) {
//    AtmTransformer dt = new AtmTransformer(
//        clazz.getName(), classLoader);
//    instrumentation.addTransformer(dt, true);
//    try {
//      instrumentation.retransformClasses(clazz);
//    } catch (Exception ex) {
//      throw new RuntimeException(
//          "Transform failed for: [" + clazz.getName() + "]", ex);
//    }
//  }
//}
