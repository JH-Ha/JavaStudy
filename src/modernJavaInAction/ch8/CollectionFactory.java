package modernJavaInAction.ch8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

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

		// 8.3.4 compute pattern

		Map<String, List<String>> friendsToMovies = new HashMap<>();
		friendsToMovies.computeIfAbsent("momo", name -> new ArrayList<>()).add("dark night");
		friendsToMovies.forEach((key, value) -> System.out.println(value));

		// 8.3.6 replace pattern

		Map<String, String> favoriteMovies = new HashMap<>();
		favoriteMovies.put("Raphael", "Star Wars");
		favoriteMovies.replaceAll((friend, movie) -> movie.toUpperCase());
		System.out.println(favoriteMovies);

		// 8.3.7 merge

		Map<String, String> friendsMap = Map.ofEntries(Map.entry("Cristina", "James Bond"));
		Map<String, String> familyMap = Map.ofEntries(Map.entry("Cristina", "Star Wars"));
		Map<String, String> everyone = new HashMap<>(familyMap);

		friendsMap.forEach((k, v) -> {
			everyone.merge(k, v, (movie1, movie2) -> movie1 + " & " + movie2);
		});
		System.out.println(everyone);

		// 8.4.1 reduce

		ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
		long parallelismThreshold = 1;
		map.put("10", 10L);
		map.put("20", 20L);
		Optional<Long> maxValue = Optional.ofNullable(map.reduceValues(parallelismThreshold, Long::max));

		System.out.println(maxValue);

	}
}
