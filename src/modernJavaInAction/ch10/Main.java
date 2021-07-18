package modernJavaInAction.ch10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		List<String> numbers = Arrays.asList("2two", "1one", "3three");
		numbers.forEach(new Consumer<String>() {

			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		});
		numbers.stream().forEach(System.out::println);

		numbers.sort(Comparator.comparing(String::length).thenComparing(String::compareTo));
		numbers.forEach(System.out::println);

		// 10.3 java DSL 만드는 패턴과 기법
		Order order = new Order();
		order.setCustomer("BigBank");

		Trade trade1 = new Trade();
		trade1.setType(Trade.Type.BUY);

		Stock stock1 = new Stock();
		stock1.setSymbol("IBM");
		stock1.setMarket("NYSE");

		trade1.setStock(stock1);
		trade1.setPrice(125.00);
		trade1.setQuantity(80);
		order.addTrade(trade1);

		Trade trade2 = new Trade();
		trade2.setType(Trade.Type.BUY);

		Stock stock2 = new Stock();
		stock2.setSymbol("GOOGLE");
		stock2.setMarket("NASDAQ");

		trade2.setStock(stock2);
		trade2.setPrice(375.00);
		trade2.setQuantity(50);
		order.addTrade(trade2);

		Order methodChainOrder = MethodChainingOrderBuilder.forCustomer("BigBank").buy(80).stock("IBM").on("NYSE")
				.at(125.00).sell(50).stock("GOOGLE").on("NASDAQ").at(375.00).end();
	}
}
