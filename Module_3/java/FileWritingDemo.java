import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class FileWritingDemo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter text to write to file: ");
    String text = sc.nextLine();
    try (FileWriter fw = new FileWriter("output.txt")) {
      fw.write(text);
      System.out.println("Data written to output.txt");
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
