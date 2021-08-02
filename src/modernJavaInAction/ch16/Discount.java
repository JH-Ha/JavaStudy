package modernJavaInAction.ch16;

public class Discount {
	public enum Code {
		NONE(0), SILBER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

		private final int percentage;

		Code(int percentage) {
			this.percentage = percentage;
		}
	}

	public static String applyDiscount(Quote quote) throws InterruptedException {
		return quote.getShopName() + " price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
	}

	private static double apply(double price, Code code) throws InterruptedException {
		delay();
		return (price * (100 - code.percentage) / 100);
	}

	public static void delay() throws InterruptedException {
		Thread.sleep(1000L);
	}
}
