package modernJavaInAction.ch5;

public class Practice {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
	}
}

class Trader {

	private final String name;
	private final String city;

	public Trader(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "Trader [name=" + name + ", city=" + city + "]";
	}

}