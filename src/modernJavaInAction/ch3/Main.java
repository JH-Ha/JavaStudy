package modernJavaInAction.ch3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
interface MyMath {
	int add(int a, int b);
}

class Test {
	void testMath(MyMath myMath) {
		System.out.println(myMath.add(1, 2));
	}
}

enum COLOR {
	GREEN, RED
};

class Apple {
	COLOR color;
	int weight;

	public Apple() {

	}

	public Apple(COLOR color) {
		this.color = color;
	}

	public Apple(int weight) {
		this.weight = weight;
	}

	public COLOR getColor() {
		return color;
	}
}

public class Main {
	public static void main(String[] args) throws InterruptedException {
		new Test().testMath((a, b) -> a + b);
		Runnable r = () -> System.out.println("test runable");
		Thread t = new Thread(r);
		t.start();
		t.join();

		List<String> str = Arrays.asList("a", "b", "A", "B");
		str.sort(String::compareToIgnoreCase);
		str.stream().forEach(a -> System.out.println(a));

		// 3.6 생성자 참조
		Supplier<Apple> c1 = Apple::new;
		Apple a1 = c1.get();
		Function<COLOR, Apple> c2 = Apple::new;
		Apple a2 = c2.apply(COLOR.RED);

		List<Integer> weights = Arrays.asList(7, 3, 4, 10);
		List<Apple> apples = map(weights, Apple::new);

		apples.stream().forEach(a -> System.out.println(a.weight));
	}

	public static List<Apple> map(List<Integer> weights, Function<Integer, Apple> f) {
		List<Apple> result = new ArrayList<>();
		for (Integer weight : weights) {
			result.add(f.apply(weight));
		}
		return result;
	}

	public Callable<String> fetch() {
		return new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return "test";
			}
		};
	}
}