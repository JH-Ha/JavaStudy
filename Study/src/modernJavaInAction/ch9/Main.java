package modernJavaInAction.ch9;

class T1 {
	void testLambda() {
		Runnable r = () -> {
			System.out.println("lambda : " + this);
		};
		r.run();
	}

	void testAnonymous() {
		Runnable r = new Runnable() {
			public void run() {
				System.out.println("anonymous : " + this);
			}
		};
		r.run();
	}
}

interface WorkA {
	public void execute();
}

interface WorkB {
	public void execute();
}

public class Main {
	public static void doSomething(WorkA workA) {
		workA.execute();
	}

	public static void doSomething(WorkB workB) {
		workB.execute();
	}

	public static void main(String[] args) {

		// �͸� Ŭ������ ��ȣ���� ����.
		doSomething(new WorkA() {
			public void execute() {
				System.out.println("workA");
			}
		});

		// ���� ǥ������ ��ȣ���� �����. WorkA���� WorkB���� Ư���� �� ����.
		doSomething((WorkA) () -> {
			System.out.println("what is my work?");
		});

		T1 t = new T1();
		t.testLambda();
		t.testAnonymous();

		// 9.1.2 �͸� Ŭ������ ���� ǥ�������� �����͸��ϱ�
		Runnable rxx = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("hello");
			}
		};
		rxx.run();

		int a = 10;
		Runnable r1 = () -> {
			// int a = 2; // <- compile error
			System.out.println(a);
		};
		r1.run();
		Runnable r2 = new Runnable() {
			public void run() {
				int a = 2;
				System.out.println(a);
			}
		};
		r2.run();

	}
}
