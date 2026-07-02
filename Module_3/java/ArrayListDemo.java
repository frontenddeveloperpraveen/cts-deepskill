import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> names = new ArrayList<>();
    System.out.println("Enter student names (type 'done' to stop):");
    while (true) {
      System.out.print("Name: ");
      String name = sc.nextLine();
      if (name.equalsIgnoreCase("done")) break;
      names.add(name);
    }
    System.out.println("\nAll students:");
    for (String n : names) {
      System.out.println("- " + n);
    }
  }
}
