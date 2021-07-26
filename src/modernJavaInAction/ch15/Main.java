package modernJavaInAction.ch15;

import java.util.Arrays;
import java.util.stream.LongStream;

public class Main {
	public static void main(String[] args) {
		long sum = 0;
		long[] stats;
		long start, end;
		stats = LongStream.range(0, 100_000_000).toArray();
		start = System.currentTimeMillis();
		for (int i = 0; i < 100_000_000; i++) {
			sum += stats[i];
		}
		end = System.currentTimeMillis();
		System.out.println(sum + " : " + (end - start));
		start = System.currentTimeMillis();
		sum = Arrays.stream(stats).parallel().sum();
		end = System.currentTimeMillis();
		System.out.println("parallel : " + sum + " : " + (end - start));
	}
}
