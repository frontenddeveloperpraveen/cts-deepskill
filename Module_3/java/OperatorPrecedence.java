public class OperatorPrecedence {
  public static void main(String[] args) {
    int result = 10 + 5 * 2;
    System.out.println("10 + 5 * 2 = " + result + " (multiplication first)");

    int result2 = (10 + 5) * 2;
    System.out.println("(10 + 5) * 2 = " + result2 + " (parentheses override)");

    int result3 = 20 / 4 * 3;
    System.out.println("20 / 4 * 3 = " + result3 + " (left to right)");
  }
}
