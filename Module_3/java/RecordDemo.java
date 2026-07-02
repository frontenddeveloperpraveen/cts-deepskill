import java.util.List;

record Person(String name, int age) {}

public class RecordDemo {
  public static void main(String[] args) {
    Person p1 = new Person("Alice", 25);
    Person p2 = new Person("Bob", 17);
    Person p3 = new Person("Charlie", 30);
    System.out.println(p1);

    List<Person> people = List.of(p1, p2, p3);
    List<Person> adults = people.stream()
      .filter(p -> p.age() >= 18)
      .toList();
    System.out.println("Adults: " + adults);
  }
}
