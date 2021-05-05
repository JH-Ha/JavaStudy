package modernJavaInAction.ch4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 430, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER));

		List<String> threeHighCaloricDishNames = menu.stream().filter(dish -> dish.getCalories() > 300)
				.sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName).limit(3)
				.collect(Collectors.toList());
		threeHighCaloricDishNames.stream().forEach(a -> System.out.println(a));

	}
}
