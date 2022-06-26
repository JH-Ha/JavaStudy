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

		// 1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오

		transactions.stream().filter(trns -> trns.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue))
				.forEach(trns -> System.out.println(trns));

		// 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오
		System.out.println("number 2");
		transactions.stream().map(trns -> trns.getTrader().getCity()).distinct()
				.forEach(city -> System.out.println(city));

		// 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
		System.out.println("");
		System.out.println("number 3");
		transactions.stream().map(trns -> trns.getTrader()).filter(trader -> "Cambridge".equals(trader.getCity()))
				.distinct().sorted(Comparator.comparing(Trader::getName))
				.forEach(trader -> System.out.println(trader.getName()));

		// 4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
		System.out.println("");
		System.out.println("number 4");
		transactions.stream().map(trns -> trns.getTrader().getName()).distinct().sorted()
				.forEach(name -> System.out.println(name));

		// 5. 밀라노에는 거래자가 있는가?
		System.out.println("");
		System.out.println("number 5");
		boolean milan = transactions.stream().map(trns -> trns.getTrader().getCity())
				.anyMatch(city -> "Milan".equals(city));
		System.out.println("milan " + milan);

		// 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
		System.out.println("");
		System.out.println("number 6");
		transactions.stream().filter(trns -> "Cambridge".equals(trns.getTrader().getCity()))
				.forEach(trns -> System.out.println(trns.getValue()));

		// 7. 전체 트랜잭션 중 최댓값을 얼마인가?
		System.out.println("");
		System.out.println("number 7");
		Optional<Integer> maxValue = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
		System.out.println("maxValue : " + maxValue);

		// 8. 전체 트랜잭션 중 최소값을 얼마인가?
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