package modernJavaInAction.ch5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

		// takeWhile은 정렬된 list를 기준으로 동작하게 된다.
		// calory를 역순으로 정렬하게 되면, 원하는 결과가 나오지 않게 된다.

		// specialMenu.sort((a, b) -> b.getCalories() - a.getCalories());

		List<Dish> slicedMenu1 = specialMenu.stream().takeWhile(dish -> dish.getCalories() < 320)
				.collect(Collectors.toList());
		slicedMenu1.forEach(a -> System.out.println(a));

		List<Dish> slicedMenu2 = specialMenu.stream().dropWhile(dish -> dish.getCalories() < 320)
				.collect(Collectors.toList());
		slicedMenu2.forEach(a -> System.out.println(a));

		// anyMatch
		if (specialMenu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("The menu is vegetarian friendly!!");
		}

		// allMatch
		boolean isHealthy = specialMenu.stream().allMatch(dish -> dish.getCalories() < 1000);
		System.out.println("isHealthy " + isHealthy);

		// noneMatch

		isHealthy = specialMenu.stream().noneMatch(d -> d.getCalories() >= 1000);
		System.out.println("isHealthy noneMatch : " + isHealthy);

		// Optional findAny

		specialMenu.stream().filter(Dish::isVegetarian).findAny().ifPresent(dish -> System.out.println(dish.getName()));

		// 5.4.4 find first result

		List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
		Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream().map(n -> n * n).filter(n -> n % 3 == 0)
				.findFirst();
		firstSquareDivisibleByThree.ifPresent(number -> System.out.println(number));

		// reduce
		int sum = someNumbers.stream().reduce(0, (a, b) -> a + b);
		System.out.println("sum : " + sum);
		sum = someNumbers.stream().reduce(0, Integer::sum);
		System.out.println("sum Integer::sum : " + sum);

	}
}
