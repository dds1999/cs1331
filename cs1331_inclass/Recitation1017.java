import java.util.*;
import java.io.*;

public class Recitation1017 {
	public static void main(String[] args) throws FileNotFoundException{
/* CREATING AN EXCEPTION
		try {
			File f = new File(args[0]);
			System.out.println("Won't print because exception has been thrown. Oh no!");
			Scanner scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Program terminated.");	
		} 
*/	
/* ORDER OF CATCH STATEMENTS MATTER
		try {
			File f = new File(args[0]);
			Scanner scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Program terminated.");	
		} catch (InputMismatchException e) {
			System.out.println("InputMismatchException exception");
		} catch(Exception e) {
			System.out.println("Exception caught..");
		}
*/
/* CAN ENSURE INPUT VALIDATION WITH WHILE LOOP
		boolean done = false;
		while (!done) {
			try {
				Scanner scan = new Scanner(System.in);
				int a = scan.nextInt();
				int b = scan.nextInt();
				System.out.println(a + b);
				done = true;	
			} catch (InputMismatchException e) {
				System.out.println("You entered a non-number.");
			}			
		}
*/
	}
}