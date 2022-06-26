package modernJavaInAction.ch1;

public class Apple {
	private String color;

	public Apple(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public static boolean isGreenAple(Apple apple) {
		return "green".equals(apple.getColor());
	}
}
