import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class LambdaDemo {
  public static void main(String[] args) {
    List<String> words = Arrays.asList("banana", "apple", "cherry", "date");
    Collections.sort(words, (a, b) -> a.compareTo(b));
    System.out.println("Sorted: " + words);
  }
}
