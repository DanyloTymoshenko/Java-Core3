import java.util.*;
import java.util.stream.Collectors;
public class Task5 {
    public static void main(String[] args) {
        Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123", "s", "555-3389", "a"));
        people.put("Mary", Arrays.asList("555-2243", "z", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242", "d"));
        List<String> letters = people.values().stream()
                .flatMap(Collection::stream)
                .filter(value -> value.length() == 1)
                .collect(Collectors.toList());
        letters.forEach(System.out::println);
    }
}