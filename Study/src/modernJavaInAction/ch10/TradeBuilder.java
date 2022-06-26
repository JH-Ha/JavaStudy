package modernJavaInAction.ch10;

import modernJavaInAction.ch10.Trade.Type;

public class TradeBuilder {
	private final MethodChainingOrderBuilder builder;
	public final Trade trade = new Trade();

	public TradeBuilder(MethodChainingOrderBuilder methodChainingOrderBuilder, Type type, int quantity) {
		// TODO Auto-generated constructor stub
		builder = methodChainingOrderBuilder;
		trade.setType(type);
		trade.setQuantity(quantity);
	}

	public StockBuilder stock(String symbol) {
		return new StockBuilder(builder, trade, symbol);
	}

}
