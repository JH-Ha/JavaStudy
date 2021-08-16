package syncronized;

public class TaskRunner {

	private static volatile int number;
	private static boolean ready;

	private static class Reader extends Thread {

		@Override
		public void run() {
			// number 에 volatile을 사용하지 않으면,
			// main thread에서 42로 update한 값이 출력되지 않고,
			// 0이 출력될 수 있다.
			while (!ready) {
				Thread.yield();
			}

			System.out.println(number);
		}
	}

	public static void main(String[] args) {
		new Reader().start();
		number = 42;
		ready = true;
	}
}