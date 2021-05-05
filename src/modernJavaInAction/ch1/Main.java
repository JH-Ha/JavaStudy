package modernJavaInAction.ch1;

import java.util.ArrayList;
import java.util.List;

public class Main {
	final static String GREEN = "green";

	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (GREEN.equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}

	public interface Predicate<T> {
		boolean test(T t);
	}

	public static List<Apple> filterGreenApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<Apple> inventory = new ArrayList<>();
		inventory.add(new Apple("green"));
		inventory.add(new Apple("red"));
		List<Apple> result = filterGreenApples(inventory);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getColor());
		}
		result = filterGreenApples(inventory, Apple::isGreenAple);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getColor());
		}

		result = filterGreenApples(inventory, (Apple a) -> GREEN.equals(a.getColor()));
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getColor());
		}
		System.out.println("========");
		System.out.println("stream result");
		inventory.stream().filter(Apple::isGreenAple).forEach(a -> System.out.println(a.getColor()));
		System.out.println("========");
		System.out.println("parellel stream result");
		inventory.parallelStream().filter(Apple::isGreenAple).forEach(a -> System.out.println(a.getColor()));
	}
}
