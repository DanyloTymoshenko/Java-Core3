import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        stream.forEach(System.out::println);

        List<Integer> randomNumbers = Stream.generate(() -> new Random().nextInt(100))
                .limit(20)
                .collect(Collectors.toList());
        randomNumbers.forEach(System.out::println);

        List<Integer> evenNumbers = randomNumbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        evenNumbers.forEach(System.out::println);
    }
}