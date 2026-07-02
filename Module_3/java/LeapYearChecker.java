import java.util.Scanner;

public class LeapYearChecker {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a year: ");
    int year = sc.nextInt();
    boolean leap = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    System.out.println(year + (leap ? " is a leap year." : " is not a leap year."));
  }
}
