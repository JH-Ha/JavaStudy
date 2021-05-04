package syncronized;

class Counter {
	long count = 0;
	long countSync = 0;

	public void increase(long value) {
		this.count += value;
	}

	public synchronized void increaseSync(long value) {
		this.countSync += value;
	}

}

class CounterThread extends Thread {
	Counter counter;

	public CounterThread(Counter counter) {
		this.counter = counter;
	}

	public void run() {
		for (int i = 0; i < 100000; i++) {
			counter.increase(1);
		}
		for (int i = 0; i < 100000; i++) {
			counter.increaseSync(1);
		}
	}
}

public class Main {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("syncronized test");
		Counter counter = new Counter();

		Thread threadA = new CounterThread(counter);
		Thread threadB = new CounterThread(counter);

		threadA.start();
		threadB.start();
		threadA.join();
		threadB.join();
		System.out.println("count : " + counter.count);
		System.out.println("count sync: " + counter.countSync);
	}
}