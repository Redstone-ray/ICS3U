package flowcontrol;

import java.util.Scanner;

public class ManyMovieTickets {
	public static void main(String[] args) {
		int age;
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a age between 1-120, enter 999 to exit:");
		age = input.nextInt();
		while (age != 999) {
			if (age < 1) {
				System.out.println("Your age is invaild");
			}

			else if (age > 120) {
				System.out.println("You are too old to watch a movie");
			}

			else if (age <= 12) {
				System.out.println("A child's ticket will cost $6.00");
			}

			else if (age <= 65) {
				System.out.println("A adult's ticket will cost $12.00");
			}

			else{
				System.out.println("A senior's ticket will cost $8.00");
			}

			System.out.print("Please enter a age between 1-100, enter 999 to exit:");
			age = input.nextInt();
			if (age==999) {
				System.out.println("Thankyou and goodbye");
			}
		}
		input.close();
	}
}
