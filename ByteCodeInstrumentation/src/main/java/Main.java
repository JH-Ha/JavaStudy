import static net.bytebuddy.matcher.ElementMatchers.named;

import java.io.File;
import java.io.IOException;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

public class Main {

  public static void main(String[] args) {
//    try {
//      new ByteBuddy().redefine(Moja.class)
//              .method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))
//              .make().saveIn(new File("D:\\workspace\\JavaStudy\\ByteCodeInstrumentation\\build\\classes\\java\\main"));
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
    System.out.println(new Moja().pullOut());
  }

}

