package modernJavaInAction.ch2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(3);
		numbers.add(5);
		numbers.add(2);
		Collections.sort(numbers, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}
		});
		numbers.stream().forEach(a -> System.out.println(a));

		System.out.println("lambda");
		numbers.sort((a, b) -> b - a);
		numbers.stream().forEach(a -> System.out.println(a));
	}
}
