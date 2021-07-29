package modernJavaInAction.ch15;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CFComplete {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		int x = 1337;

		CompletableFuture<Integer> a = new CompletableFuture<>();
		executorService.submit(() -> a.complete(f(x)));
		int b = g(x);
		System.out.println(a.get() + b);

		CompletableFuture<Integer> a1 = new CompletableFuture<>();
		CompletableFuture<Integer> a2 = new CompletableFuture<>();
		CompletableFuture<Integer> a3 = a2.thenCombine(a1, (x1, x2) -> x1 + x2);

		executorService.submit(() -> a1.complete(f(x)));
		executorService.submit(() -> a2.complete(f(x)));
		System.out.println("a3 : " + a3.get());
		executorService.shutdown();
	}

	public static int f(int x) {
		return x + 10;
	}

	public static int g(int x) {
		return x * 10;
	}
}
