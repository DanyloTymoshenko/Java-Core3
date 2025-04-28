import org.junit.Test;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTest {
    @Test
    public void testEvenNumbers() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> evens = list.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        assertEquals(Arrays.asList(2,4,6,8,10), evens);
    }
    @Test
    public void testStringsStartWithC() {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        List<String> filtered = myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        assertEquals(Arrays.asList("C2", "C1"), filtered);
    }
    @Test
    public void testNameCountStartWithA() {
        List<String> names = Arrays.asList("Amitabh", "Shekhar", "Aman", "Rahul", "Abibaba");
        long count = names.stream()
                .filter(name -> name.startsWith("A"))
                .count();
        assertEquals(3, count);
    }
    @Test
    public void testFlatMapList() {
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9);
        List<Integer> merged = Stream.of(list1, list2, list3)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        assertEquals(9, merged.size());
    }
    @Test
    public void testDistinctNumbers() {
        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7));
        List<Integer> distinct = numbersList.stream()
                .distinct()
                .collect(Collectors.toList());
        assertEquals(Arrays.asList(1,2,3,4,5,6,7), distinct);
    }
    @Test
    public void testMapLettersExtraction() {
        Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123", "s", "555-3389", "a"));
        people.put("Mary", Arrays.asList("555-2243", "z", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242", "d"));
        List<String> letters = people.values().stream()
                .flatMap(Collection::stream)
                .filter(value -> value.length() == 1)
                .collect(Collectors.toList());
        assertTrue(letters.containsAll(Arrays.asList("s", "a", "z", "d")));
    }
}