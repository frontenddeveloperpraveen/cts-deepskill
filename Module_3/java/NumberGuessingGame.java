import java.util.Scanner;

public class NumberGuessingGame {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int target = (int) (Math.random() * 100) + 1;
    int guess;
    System.out.println("Guess a number between 1 and 100.");
    do {
      System.out.print("Your guess: ");
      guess = sc.nextInt();
      if (guess < target) System.out.println("Too low.");
      else if (guess > target) System.out.println("Too high.");
      else System.out.println("Correct!");
    } while (guess != target);
  }
}
