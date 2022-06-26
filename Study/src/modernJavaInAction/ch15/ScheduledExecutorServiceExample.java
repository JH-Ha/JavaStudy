package modernJavaInAction.ch15;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {
	public static void main(String[] args) throws InterruptedException {
		// A
		work1();
		Thread.sleep(1000);
		work2();
		// B
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
		work1();
		scheduledExecutorService.schedule(ScheduledExecutorServiceExample::work2, 1, TimeUnit.SECONDS);

		// B is better than A
	}

	public static void work1() {
		System.out.println("hello work1");
	}

	public static void work2() {
		System.out.println("hello work2");
	}
}
