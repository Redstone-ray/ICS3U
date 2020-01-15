package lotterygame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	public static void main(String[] args) {
		int sysNextGen, lottopot, prize = 0;
		double money = 20;
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		int rightNum;

		ArrayList<Integer> sysGen = new ArrayList<Integer>(6);
		ArrayList<Integer> userIn = new ArrayList<Integer>(6);
		System.out.println("--------");
		System.out.println("|                        |        |                  --------");
		System.out.println("|                        |        |                 |        |");
		System.out.println("|--------|               |        |                 |        |");
		System.out.println("|        |               |--------|                 |        |");
		System.out.println("|        |                        |                  --------|");
		System.out.println("|--------|                        |                          |");
		System.out.println("                                  |                          |");
		System.out.println("You started with $" + money);
		System.out.print("Would you like to buy a lottory ticket? Y/N");
		String lottoYN = input.nextLine();
		while (true) {

			if (lottoYN.equalsIgnoreCase("Y") && money > 5) {
				money -= 5;
			} else if (lottoYN.equalsIgnoreCase("N") || money < 5) {
				if (money > 5) {
					System.out.print("Would you like to donate to the charity? Y/N");
					String charity = input.nextLine();
					if (charity.equalsIgnoreCase("Y")) {
						System.out.println("You have $" + money);
						System.out.println("How much do you want to donate?");
						double donate = input.nextDouble();
						if (donate > money) {
							System.out.println("You donated $" + donate + " to a random charity, thanks!");
							money -= donate;
							System.out.println("You have $" + money + " left");

						} else {
							System.out.println("You don't have that much money!");

						}

					} else {
						System.out.println("Ok, no donations");

					}

				} else {
					System.out.println("Please get help from http://www.gamblersanonymous.org/ga/");

				}
				break;

			} else {
				System.out.println("Please only enter Y/N!");
			}

			for (int i = 0; i < 6; i++) {

				while (true) {
					sysNextGen = rand.nextInt(48) + 1;
					if (!sysGen.contains(sysNextGen)) {

						sysGen.add(sysNextGen);
						break;
					}

				}

			}
			Collections.sort(sysGen);
			System.out.println("For testing purposes, here are the winning numbers");
			System.out.println("These numbers reset each game!");
			System.out.println(sysGen);
			System.out.println("-------------------------------------");

			for (int i = 1; i <= 6; i++) {

				while (true) {
					System.out.print("Please enter your " + i + " lottery number from 1-49: ");
					int nextInput = input.nextInt();
					if (!userIn.contains(nextInput) && nextInput >= 1 && nextInput <= 49) {
						userIn.add(nextInput);
						break;

					} else {
						System.out.println("Please enter a new, non-repeating number between 1 and 49");
					}

				}

			}
			Collections.sort(sysGen);
			Collections.sort(userIn);
			System.out.println("-------------------------------------");

			System.out.println("The numbers for the lottery is " + sysGen.toString());
			System.out.println("Your inputs are " + userIn);
			userIn.removeAll(sysGen);

			rightNum = 6 - (userIn.size());
			lottopot = rand.nextInt(10000000) + 400000;
			System.out.println("You got " + rightNum + " numbers correct");
			System.out.println("There are $" + lottopot + " in the prize pool");
			System.out.println("-------------------------------------");

			if (rightNum == 6) {
				prize = (int) ((int) lottopot * 0.8);
			} else if (rightNum == 5) {
				prize = (int) ((int) lottopot * 0.008);
			} else if (rightNum == 4) {
				prize = (int) ((int) lottopot * 0.003);
			} else if (rightNum == 3) {
				prize = (int) ((int) lottopot * 0.001);
			} else if (rightNum == 2) {
				prize = (int) ((int) lottopot * 0.000002);
			} else {
				System.out.println("No prize for you!");
			}
			if (rightNum >= 2) {
				System.out.println("Your total prize is $" + prize);
			}
			sysGen.clear();
			userIn.clear();
			System.out.print("Would you like to buy another lottory ticket? Y/N");
			lottoYN = input.nextLine();

		}
	}
}
