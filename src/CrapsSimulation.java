import java.util.Random;
import java.util.Scanner;

public class CrapsSimulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        boolean playAgain = true;

        while (playAgain) {
            // Initial roll of two dice
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            // Display roll results
            System.out.println("Roll: Die 1 = " + die1 + ", Die 2 = " + die2 + ", Sum = " + sum);

            // Check the result of the roll
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose!");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win!");
            } else {
                System.out.println("Point is: " + sum);
                int point = sum;
                boolean continueRolling = true;

                while (continueRolling) {
                    // Subsequent rolls
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;

                    // Display roll results
                    System.out.println("Roll: Die 1 = " + die1 + ", Die 2 = " + die2 + ", Sum = " + sum);

                    if (sum == point) {
                        System.out.println("Made point! You win!");
                        continueRolling = false;
                    } else if (sum == 7) {
                        System.out.println("Seven out! You lose!");
                        continueRolling = false;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            // Prompt to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.nextLine().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }
        scanner.close();
    }
}
