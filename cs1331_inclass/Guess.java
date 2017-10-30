import java.util.Random;
import java.util.Scanner;

public class Guess {
	public static void main(String[] args) {
		Random rand = new Random();
		// if you specify seed you would get the same sequence of psuedorandom numbers all the time. good for debugging
		int secretNumber = rand.nextInt(10) + 1;
		int secretNumber2 = rand.nextInt();
		//System.out.println(System.currentTimeMillis());
		// System.currentTimeMillis is a long. Longs are integers tahat can represent a LOT MORE than ints can
		System.out.println(secretNumber);
		//System.out.println(secretNumber2);
		boolean guessedCorrectly = false;
		while (!guessedCorrectly) {
			// get user input
			Scanner s = new Scanner(System.in);
			String input = s.next();
			int guess = Integer.parseInt(input);
			if (guess == secretNumber) {
				guessedCorrectly = true;
				System.out.println("Correct!");
			} else {
				System.out.println("Wrong. Try again.");
			}
		}
		// TRY CATCH VERSION
		boolean inputIsValid = false;
		while(!inputIsValid) {
			try {

				p[l]
			}
		}
	}
}