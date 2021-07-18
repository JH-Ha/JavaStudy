package modernJavaInAction.ch10;

public class StockBuilder {
	private final MethodChainingOrderBuilder builder;

	private final Trade trade;
	private final Stock stock = new Stock();

	public StockBuilder(MethodChainingOrderBuilder builder, Trade trade, String symbol) {
		// TODO Auto-generated constructor stub
		this.builder = builder;
		this.trade = trade;
		this.stock.setSymbol(symbol);

	}

	public TradeBuilderWithStock on(String market) {
		stock.setMarket(market);
		trade.setStock(stock);
		return new TradeBuilderWithStock(builder, trade);
	}
}
