package reflection;


import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

  public static void main(String[] args)
      throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, UnsupportedEncodingException {
    Class testClass = Class.forName("reflection.Test");
    //Method[] m = testClass.getMethods();

    SampleClass sampleObject = new SampleClass();

    Field field = SampleClass.class.getField("sampleField");

    field.setBoolean(sampleObject, false);

    System.out.println(field.getBoolean(sampleObject));
  }
}

class SampleClass {

  public static boolean sampleField = true;
}