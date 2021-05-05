package modernJavaInAction.ch3;

import java.util.concurrent.Callable;

@FunctionalInterface
interface MyMath {
	int add(int a, int b);
}

class Test {
	void testMath(MyMath myMath) {
		System.out.println(myMath.add(1, 2));
	}
}

public class Main {
	public static void main(String[] args) throws InterruptedException {
		new Test().testMath((a, b) -> a + b);
		Runnable r = () -> System.out.println("test runable");
		Thread t = new Thread(r);
		t.start();
		t.join();
	}

	public Callable<String> fetch() {
		return new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return "test";
			}
		};
	}
}