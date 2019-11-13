package flowcontrol;

import java.io.DataInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;




public class Snippet {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		DataInputStream input = new DataInputStream(System.in);
		String choice;
		double bankBalance, intRate, endingBal;
		int number;
		NumberFormat d = new DecimalFormat("#0.00");
		NumberFormat e = new DecimalFormat("#0.00");
		Random rand = new Random();
		Random startingRate = new Random();
		
		
		//Starting balance
		List<Integer> list = new ArrayList<Integer>();
		list.add(200);
		list.add(200);
		list.add(200);
		list.add(200);
		list.add(500);
		list.add(500);
		list.add(500);
		list.add(1000);
		list.add(1000);
		list.add(2000);
		list.add(2000);
		list.add(5000);
		list.add(10000);
		//randomly select an amount from the array list
		Snippet obj = new Snippet();
		
		//apply the bank balance
		bankBalance=obj.getRandomList(list);
		//prompte the use to enter starting balance
		System.out.println("Your started at the age of 20, with a balance of: $" +bankBalance);
		//randomly generate the intRate
		intRate = 1.5 + (5.5 - 2.5) * startingRate.nextDouble();
		System.out.print("Your rate of interest is "+e.format(intRate)+ "%, good luck!");
		endingBal = bankBalance + (bankBalance * (intRate / 100));
		for (int i = 20; i <= 80; i++) {

			System.out.println("The balance at age " + i + " years is " + d.format(endingBal));
			endingBal = endingBal + (endingBal * (intRate / 100));
			
			
			
			
			//stock system
			//
			//
			System.out.println(
					"Whould you like to play lottery for 200 dollors? Winning will double your interest rate y/n");
			choice = input.readLine();
			if (choice.equalsIgnoreCase("Y") && endingBal >= 200) {
				endingBal -= 200;
				double n = rand.nextInt(5);
				System.out.println("Please enter a Natural Number between 1-5");
				number = Integer.parseInt(input.readLine());
				if (number == n) {
					intRate += intRate;
					System.out.println("The number is correct! Your intRate is now " + intRate);
				} else {
					System.out.println("Sorry, you lose the lottery!");
				}
			} else if (endingBal <= 50) {
				System.out.println("You don't have enough money! Poor you!");

			} else {
				System.out.println("Okay, proceed to year " + (i + 1));

			}
			//end of stock system
			//
			//			
		
			
			if (endingBal <= 50) {
				System.out.println("Slave");
			} else if (endingBal <= 500) {
				System.out.println("Poor");
			} else if (endingBal <= 1000) {
				System.out.println("Communist");
			} else if (endingBal <= 2000) {
				System.out.println("Medium Class");
			} else if (endingBal <= 5000) {
				System.out.println("Capitalist");
			} else if (endingBal <= 10000) {
				System.out.println("Dictorship");
			} else if (endingBal <= 20000) {
				System.out.println("Java Programmer");
			} else if (endingBal <= 100000) {
				System.out.println("Overlord");
			} else if (endingBal <= 200000) {
				System.out.println("Bank Rubber");
			} else if (endingBal <= 500000) {
				System.out.println("Donald Trump");
			}

			}
		
		}
	public int getRandomList(List<Integer> list) {

	    //0-5
	    int index = ThreadLocalRandom.current().nextInt(list.size());		
	    return list.get(index);
	}
	}

