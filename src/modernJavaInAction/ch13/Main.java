package modernJavaInAction.ch13;

interface A {
	default void hello() {
		System.out.println("hello A");
	}
}

interface B extends A {
	default void hello() {
		System.out.println("hello B");
	}
}

class D implements A {

}

class C extends D implements A, B {

}

public class Main {
	public static void main(String[] args) {
		new C().hello();
	}
}
