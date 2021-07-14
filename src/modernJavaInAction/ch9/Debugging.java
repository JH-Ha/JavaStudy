package modernJavaInAction.ch9;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Debugging {
	public static void main(String[] args) {
		// 9.4 오류가 날경우 제대로 확인하기 어렵다
		try {
			List<Point> points = Arrays.asList(new Point(12, 2), null);
			points.stream().map(p -> p.getX()).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 9.4.2
		List<Integer> numbers = Arrays.asList(2, 3, 4, 5);
		numbers.stream().map(x -> x + 17).peek(x -> System.out.println("after map : " + x)).filter(x -> x % 2 == 0)
				.peek(x -> System.out.println("after filter: " + x)).collect(Collectors.toList());

		Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
				.peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase)
				.peek(e -> System.out.println("Mapped value: " + e)).collect(Collectors.toList());
	}
}
