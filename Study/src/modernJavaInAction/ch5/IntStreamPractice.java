package modernJavaInAction.ch5;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamPractice {
	public static void main(String[] args) {
		// IntStream.rangeClosed(1, 100).forEach(a -> System.out.println(a));

		// final int a = 1;
		Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(1, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed()
						.map(b -> new int[] { a, b, (int) Math.sqrt(a * a + b * b) }));

		pythagoreanTriples.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

		Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(1, 100)
						.mapToObj(b -> new double[] { a, b, Math.sqrt(a * a + b * b) }).filter(t -> t[2] % 1 == 0));

		pythagoreanTriples2.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

	}
}
