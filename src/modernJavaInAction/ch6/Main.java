package modernJavaInAction.ch6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {

		// old way
		Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();

		List<Transaction> transactions = new ArrayList<>();

		for (Transaction transaction : transactions) {
			Currency currency = transaction.getCurrency();
			List<Transaction> transactionForCurrency = transactionsByCurrencies.get(currency);
			if (transactionForCurrency == null) {
				transactionForCurrency = new ArrayList<>();
				transactionsByCurrencies.put(currency, transactionForCurrency);
			}
		}

		// using stream
		Map<Currency, List<Transaction>> transactionsByCurrencies2 = transactions.stream()
				.collect(Collectors.groupingBy(Transaction::getCurrency));
	}
}

class Currency {

}

class Transaction {
	Currency currency;

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
