import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        while (playAgain) {
            int score = playGame(random, scanner);
            totalScore += score;
            System.out.println("Your score for this round: " + score);
            System.out.println("Your total score: " + totalScore);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static int playGame(Random random, Scanner scanner) {
        int randomNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int score = 0;

        System.out.println("Guess the number between 1 and 100.");

        while (attempts < 5) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number!");
                score = (5 - attempts + 1) * 10;
                break;
            } else if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        if (attempts == 5) {
            System.out.println("Sorry, you have used all your attempts. The correct number was: " + randomNumber);
        }

        return score;
    }
}

