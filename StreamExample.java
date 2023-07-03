import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamExample {
	public static void main(String[] args) {
		// Creating a List
		List<String> names = new ArrayList<String>();
		// Adding elements in the List
		names.add("Alice");
		names.add("Bob");
		names.add("Charlie");
		names.add("Dave");
		names.stream().forEach(System.out::println);
//		names.remove("Charlie");
//		names.stream().forEach(System.out::println);
//		if (names.contains("Bob"))
//			;
//		names.stream().forEach(System.out::println);
//		names.removeAll(names);
//		names.stream().forEach(System.out::println);
		names.stream().filter(e -> !e.contains("Charlie"))
		.map(e -> if(e.equals("Bob") System.out.print(e)))
		.collect(Collectors.toList());
		
		names.stream().forEach(System.out::println);


	}
}
