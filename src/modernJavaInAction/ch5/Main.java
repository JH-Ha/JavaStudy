package modernJavaInAction.ch5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import modernJavaInAction.ch4.Dish;

public class Main {
	public static void main(String[] args) {
		List<Dish> specialMenu = Arrays.asList(new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("chicken", false, 400, Dish.Type.MEAT), new Dish("french fries", true, 530, Dish.Type.OTHER));
		List<Dish> filteredMenu = specialMenu.stream().filter(dish -> dish.getCalories() < 320)
				.collect(Collectors.toList());
		filteredMenu.forEach(a -> System.out.println(a));

		// takeWhile�� ���ĵ� list�� �������� �����ϰ� �ȴ�.
		// calory�� �������� �����ϰ� �Ǹ�, ���ϴ� ����� ������ �ʰ� �ȴ�.

		// specialMenu.sort((a, b) -> b.getCalories() - a.getCalories());

		List<Dish> slicedMenu1 = specialMenu.stream().takeWhile(dish -> dish.getCalories() < 320)
				.collect(Collectors.toList());
		slicedMenu1.forEach(a -> System.out.println(a));

		List<Dish> slicedMenu2 = specialMenu.stream().dropWhile(dish -> dish.getCalories() < 320)
				.collect(Collectors.toList());
		slicedMenu2.forEach(a -> System.out.println(a));
	}
}
