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

	public static void main(String[] args) {
		List<Apple> inventory = new ArrayList<>();
		inventory.add(new Apple("green"));
		inventory.add(new Apple("red"));
		List<Apple> result = filterGreenApples(inventory);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getColor());
		}
	}
}
