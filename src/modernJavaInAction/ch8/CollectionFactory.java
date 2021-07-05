package modernJavaInAction.ch8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionFactory {
	public static void main(String[] args) {
		// 1. use ArrayList
		List<String> friends = new ArrayList<>();
		friends.add("1");
		friends.add("2");
		friends.add("3");

		// 2. use factory method Java 9 immutableCollections
		List<String> friends2 = List.of("1", "2", "3");
		try {
			friends2.add("4");
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		}
		friends2.stream().forEach(a -> System.out.println(a));

		// 3. Set Factory
		Set<String> friends3 = Set.of("1", "2", "3");
		friends3.stream().forEach(a -> System.out.println(a));

		// 4. Map Factory
		Map<String, Integer> ageOfFriends = Map.of("1", 10, "2", 20);
		System.out.println(ageOfFriends);

		// 8.2 replaceAll
		List<String> referenceCodes = new ArrayList<>();
		referenceCodes.add("a12");
		referenceCodes.add("c14");
		referenceCodes.add("b13");
		referenceCodes.replaceAll(code -> Character.toUpperCase(code.charAt(0)) + code.substring(1));
		referenceCodes.stream().forEach(a -> System.out.println(a));
	}
}
