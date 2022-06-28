import static net.bytebuddy.matcher.ElementMatchers.named;

import java.io.File;
import java.io.IOException;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;

public class Main {

  public static void main(String[] args) {
    ClassLoader classLoader = Main.class.getClassLoader();
    TypePool typePool = TypePool.Default.of(classLoader);
    try {
      new ByteBuddy().redefine(typePool.describe("Moja").resolve(),
              ClassFileLocator.ForClassLoader.of(classLoader))
          .method(named("pullOut")).intercept(FixedValue.value("Rabbit!!"))
          .make().saveIn(new File(
              "D:\\workspace\\JavaStudy\\ByteCodeInstrumentation\\build\\classes\\java\\main"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(new Moja().pullOut());
  }

}

