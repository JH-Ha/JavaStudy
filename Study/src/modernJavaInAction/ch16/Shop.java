package modernJavaInAction.ch16;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
	String name;

	public Shop(String name) {
		this.name = name;
	}

	Random random = new Random();

	public double getPrice(String product) {
		return calculatePrice(product);
	}

	public Future<Double> getPriceAsync(String product) {
//		CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//		new Thread(() -> {
//			try {
//				double price = calculatePrice(product);
//				futurePrice.complete(price);
//			} catch (Exception ex) {
//				futurePrice.completeExceptionally(ex);
//			}
//		}).start();
//		return futurePrice;
		return CompletableFuture.supplyAsync(() -> {
			return calculatePrice(product);
		});
	}

	private double calculatePrice(String product) {
		delay();
		return random.nextDouble() * product.charAt(0) + product.charAt(1);
	}

	public static void delay() {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
