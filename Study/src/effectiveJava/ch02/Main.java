package effectiveJava.ch02;

public class Main {

  public static void main(String[] args) {
    long time1 = System.currentTimeMillis();
    Long sum1 = 0L;
    for (long i = 0; i <= Integer.MAX_VALUE; i++) {
      sum1 += i;
    }
    long time2 = System.currentTimeMillis();
    long sum2 = 0;
    for (long i = 0; i <= Integer.MAX_VALUE; i++) {
      sum2 += i;
    }
    long time3 = System.currentTimeMillis();

    System.out.println("sum1 : " + (time2 - time1) + " sum2 : " + (time3 - time2));
  }
}
