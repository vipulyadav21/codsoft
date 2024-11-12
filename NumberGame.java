import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int range = 100;
        int score = 0;

        while (true) {
            int targetNumber = random.nextInt(range) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Guess a number between 1 and " + range);

            while (!guessedCorrectly && attempts < 10) {
                System.out.print("Attempt " + (attempts + 1) + ": ");
                
                try {
                    int guess = scanner.nextInt();
                    attempts++;

                    if (guess == targetNumber) {
                        guessedCorrectly = true;
                        System.out.println("Congratulations! You guessed correctly.");
                        score++;
                    } else if (guess < targetNumber) {
                        System.out.println("Too low!");
                    } else {
                        System.out.println("Too high!");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); // Clear the invalid input
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! The correct number was " + targetNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            scanner.nextLine(); // Clear newline character
            String playAgain = scanner.nextLine();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Your score: " + score);
        scanner.close();
    }
}
