public class PatternMatchingDemo {

  static void describe(Object obj) {
    switch (obj) {
      case Integer i -> System.out.println("Integer: " + i);
      case String s -> System.out.println("String: \"" + s + "\"");
      case Double d -> System.out.println("Double: " + d);
      case null -> System.out.println("Null value");
      default -> System.out.println("Unknown type: " + obj.getClass());
    }
  }

  public static void main(String[] args) {
    describe(42);
    describe("Hello");
    describe(3.14);
    describe(null);
    describe(true);
  }
}
