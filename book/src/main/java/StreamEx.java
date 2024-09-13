import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx {
    public static void main(String[] args) {
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);

        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream1 = list.stream();

        Stream<String> builderStream = Stream.<String>builder()
                .add("a").add("b").add("c")
                .build();

        Stream<String> stream2 = Stream.generate(() -> "a").limit(3);

        Stream<Integer> stream3 = Stream.iterate(0, n -> n + 2).limit(5);

        stream1.forEach(System.out::print);
        list.stream().map(String::toUpperCase).forEach(System.out::print);
    }
}
