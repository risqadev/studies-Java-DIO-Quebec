import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex2Investigation {
  public static void main(String[] args) {
    final List<String> questions = List.of(
      "Did you call the victim?",
      "Were you at the crime scene?",
      "Do you live near the victim?",
      "Did you owe it to the victim?",
      "Have you ever worked with the victim?"
    );
    List<Integer> answers = new ArrayList<>();
    String options = " (0 - No / 1 - Yes): ";

    Scanner scanner = new Scanner(System.in);
    for (String question : questions) {
      System.out.print(question + options);
      int input = scanner.nextInt();
      answers.add(input);
    }
    scanner.close();

    int sum = 0;
    for (int value : answers) sum += value;
    
    System.out.println("Sum: " + sum);

    if (sum == 5) System.out.println("Conclusion: The person is to blame.");
    else if (sum == 3 || sum == 4) System.out.println("The person is an accomplice.");
    else if (sum == 2) System.out.println("Conclusion: The person is suspicious.");
    else System.out.println("Conclusion: The person is innocent.");
  }
}
