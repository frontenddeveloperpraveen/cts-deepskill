import java.util.HashMap;
import java.util.Scanner;

public class HashMapDemo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    HashMap<Integer, String> students = new HashMap<>();
    System.out.println("Enter student ID and name (ID 0 to stop):");
    while (true) {
      System.out.print("ID: ");
      int id = sc.nextInt();
      sc.nextLine();
      if (id == 0) break;
      System.out.print("Name: ");
      String name = sc.nextLine();
      students.put(id, name);
    }
    System.out.print("Enter ID to look up: ");
    int search = sc.nextInt();
    System.out.println("Name: " + students.getOrDefault(search, "Not found"));
  }
}
