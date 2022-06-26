package modernJavaInAction.ch10;

public class TradeBuilderWithStock {
	private final MethodChainingOrderBuilder builder;
	private final Trade trade;

	public TradeBuilderWithStock(MethodChainingOrderBuilder builder, Trade trade) {
		// TODO Auto-generated constructor stub
		this.builder = builder;
		this.trade = trade;
	}

	public MethodChainingOrderBuilder at(double price) {
		trade.setPrice(price);
		return builder.addTrade(trade);
	}

}
