package modernJavaInAction.ch5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Practice {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// 1. 2011�⿡ �Ͼ ��� Ʈ������� ã�� ���� ������������ �����Ͻÿ�

		transactions.stream().filter(trns -> trns.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue))
				.forEach(trns -> System.out.println(trns));

		// 2. �ŷ��ڰ� �ٹ��ϴ� ��� ���ø� �ߺ� ���� �����Ͻÿ�
		System.out.println("number 2");
		transactions.stream().map(trns -> trns.getTrader().getCity()).distinct()
				.forEach(city -> System.out.println(city));

		// 3. ���Ӻ긮������ �ٹ��ϴ� ��� �ŷ��ڸ� ã�Ƽ� �̸������� �����Ͻÿ�.
		System.out.println("");
		System.out.println("number 3");
		transactions.stream().map(trns -> trns.getTrader()).filter(trader -> "Cambridge".equals(trader.getCity()))
				.distinct().sorted(Comparator.comparing(Trader::getName))
				.forEach(trader -> System.out.println(trader.getName()));

		// 4. ��� �ŷ����� �̸��� ���ĺ������� �����ؼ� ��ȯ�Ͻÿ�.
		System.out.println("");
		System.out.println("number 4");
		transactions.stream().map(trns -> trns.getTrader().getName()).distinct().sorted()
				.forEach(name -> System.out.println(name));

		// 5. �ж�뿡�� �ŷ��ڰ� �ִ°�?
		System.out.println("");
		System.out.println("number 5");
		boolean milan = transactions.stream().map(trns -> trns.getTrader().getCity())
				.anyMatch(city -> "Milan".equals(city));
		System.out.println("milan " + milan);

		// 6. ���Ӻ긮���� �����ϴ� �ŷ����� ��� Ʈ����ǰ��� ����Ͻÿ�.
		System.out.println("");
		System.out.println("number 6");
		transactions.stream().filter(trns -> "Cambridge".equals(trns.getTrader().getCity()))
				.forEach(trns -> System.out.println(trns.getValue()));

		// 7. ��ü Ʈ����� �� �ִ��� ���ΰ�?
		System.out.println("");
		System.out.println("number 7");
		Optional<Integer> maxValue = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
		System.out.println("maxValue : " + maxValue);

		// 8. ��ü Ʈ����� �� �ּҰ��� ���ΰ�?
		System.out.println("");
		System.out.println("number 7");
		Optional<Integer> minValue = transactions.stream().map(Transaction::getValue).reduce(Integer::min);
		System.out.println("minValue : " + minValue);
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

class Transaction {
	private final Trader trader;
	private final int year;
	private final int value;

	public Trader getTrader() {
		return trader;
	}

	public int getYear() {
		return year;
	}

	public int getValue() {
		return value;
	}

	public Transaction(Trader trader, int year, int value) {
		super();
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Transaction [trader=" + trader + ", year=" + year + ", value=" + value + "]";
	}

}