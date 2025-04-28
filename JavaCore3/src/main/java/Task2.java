import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }

        Integer[] array = list.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(array));

        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        List<String> result = myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}