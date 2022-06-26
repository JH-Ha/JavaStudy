package modernJavaInAction.ch1;

import java.util.stream.LongStream;

public class PerformanceCheck {

	public static void main(String[] args) {
		final Long MAX_NUM = 100_000_000L;
		LongStream longStream = LongStream.range(0, MAX_NUM);
		Long start = System.currentTimeMillis();
		Long sumNormal = longStream.sum();
		Long end = System.currentTimeMillis();
		System.out.println(end - start + "ms");
		System.out.println("ans : " + sumNormal);
		start = System.currentTimeMillis();
		Long sumParellel = LongStream.range(0, MAX_NUM).parallel().sum();
		end = System.currentTimeMillis();
		System.out.println(end - start + "ms");
		System.out.println("ans : " + sumParellel);

	}
}
