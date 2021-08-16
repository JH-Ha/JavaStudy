package syncronized;

public class TaskRunner {

	private static volatile int number;
	private static boolean ready;

	private static class Reader extends Thread {

		@Override
		public void run() {
			// number �� volatile�� ������� ������,
			// main thread���� 42�� update�� ���� ��µ��� �ʰ�,
			// 0�� ��µ� �� �ִ�.
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