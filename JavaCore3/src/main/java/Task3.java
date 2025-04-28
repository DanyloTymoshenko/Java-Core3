import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<String> memberNames = Arrays.asList(
                "Amitabh", "Shekhar", "Aman", "Rahul",
                "Shahrukh", "Abibaba", "Salman", "Yana", "Lokesh"
        );

        memberNames.stream()
                .filter(name -> name.startsWith("A"))
                .filter(name -> name.length() > 5)
                .forEach(System.out::println);

        memberNames.stream()
                .map(String::toLowerCase)
                .sorted()
                .forEach(System.out::println);

        System.out.println(memberNames.stream().allMatch(name -> name.contains("S")));
        System.out.println(memberNames.stream().anyMatch(name -> name.contains("S")));
        System.out.println(memberNames.stream().noneMatch(name -> name.contains("H")));

        long countA = memberNames.stream()
                .filter(name -> name.startsWith("A"))
                .count();
        System.out.println(countA);

        memberNames.stream()
                .filter(name -> name.startsWith("L"))
                .findFirst()
                .ifPresent(System.out::println);
    }
}


