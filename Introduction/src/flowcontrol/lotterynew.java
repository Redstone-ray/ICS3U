package flowcontrol;

import static java.lang.System.in;

import java.io.DataInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Snippet {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		DataInputStream input = new DataInputStream(in);
		String choice, choiceStock;
		double bankBalance, intRate, endingBal, trumpStock;
		int number, ageToTrade, trumpStockNumber = 0;
		NumberFormat d = new DecimalFormat("#0.00");
		NumberFormat w = new DecimalFormat("#0");
		Random rand = new Random();
		Random startingRate = new Random();
		Random stockUse = new Random();
		String yesorno, heal, heal2;
		int waiter = 0, waitHeal, waitHeal2, waitLot, waitStock, waitStock2;
		int waitBuy, waitSell, health = 100, hpCheck = 0;

		// Starting balance
		List<Integer> list = new ArrayList<>();
		list.add(200);
		list.add(200);
		list.add(200);
		list.add(500);
		list.add(500);
		list.add(500);
		list.add(1000);
		list.add(1000);
		list.add(1000);
		list.add(2000);
		list.add(2000);
		list.add(5000);
		list.add(10000);
		// randomly select an amount from the array list
		Snippet obj = new Snippet();

		// apply the bank balance
		bankBalance = obj.getRandomList(list);

		//random starting age
		List<Integer> ageAtStart = new ArrayList<>();
		ageAtStart.add(16);
		ageAtStart.add(18);
		ageAtStart.add(20);
		ageAtStart.add(24);
		ageAtStart.add(27);
		ageAtStart.add(30);
		Snippet startAgeObject = new Snippet();
		//applys the age
		int age = startAgeObject.getRandomAge(ageAtStart);
		// prompt the use to enter starting balance
		System.out.println("You started at the age of " + age + ", with a balance of: $" + w.format(bankBalance));

		//Health
		System.out.println("Your HP is currently at 100");
		System.out.println("");

		// randomly generate the intRate
		intRate = 2.5 + (8.5 - 2.5) * startingRate.nextDouble();
		System.out.println("Your rate of interest is " + d.format(intRate) + "%, good luck!");

		//Trade age for extra starting interest rate
		System.out.println("Would you like to trade some years of your life for " + d.format(intRate) + "% plus higher percent of interest rate? (To a maximum of 5 years)");
		System.out.print("A number between 0-5 indicates the age you want to trade off: ");
		ageToTrade = Integer.parseInt(input.readLine());
		if (ageToTrade >= 1 && ageToTrade <= 5) {
			intRate += ageToTrade;
			age += ageToTrade;
			//show a message of new age if the user input a ageToTrade>0
			System.out.println("Success, your new interest is now: " + d.format(intRate) + "%");
			System.out.println(ageToTrade + " year(s) had been added to your age, you are now " + age);
		} else if (ageToTrade == 0) {
			System.out.println("Ok, continue without trading age");
		}
		System.out.println("----------------------------------------");
		endingBal = bankBalance + bankBalance * (intRate / 100);

		//set a value for trumpstock, stock 1
		trumpStock = 125.5 + (603.5 - 125.5) * stockUse.nextDouble();

		while (age <= 80) {

			System.out.println("The balance at age " + age + " is $" + d.format(endingBal));
			endingBal = endingBal + endingBal * (intRate / 100);
			//Healing System
			System.out.println("Your HP is currently at " + health);
			if (health < 100) {
				waitHeal = 0;
				waitHeal2 = 0;
				while (waitHeal == 0) {
					System.out.print("Do you wish to heal yourself? (Y/N): ");
					heal = input.readLine();
					if (heal.equalsIgnoreCase("y")) {
						System.out.print("Healing will cost $" + ((100 - health) * (5 * age)) + "(Y/N): ");
						waitHeal = 1;
						heal2 = input.readLine();
						while (waitHeal2 == 0) {
							if (heal2.equalsIgnoreCase("y")) {
								endingBal = endingBal - ((100 - health) * (5 * age));
								health = 100;
								waitHeal2 = 1;
								System.out.println("OK\nYour Health is now at " + health);
							} else if (heal2.equalsIgnoreCase("n")) {
								System.out.println("OK");
								waitHeal2 = 1;
							} else {
								System.out.println("Use only 'Y' for yes and 'n' for no");
							}
						}
					} else if (heal.equalsIgnoreCase("n")) {
						System.out.println("OK");
						waitHeal = 1;
					} else {
						System.out.println("Use only 'Y' for yes and 'n' for no");
					}
				}
			}
			// lottery system
			//
			//
			waitLot = 0;
			System.out.println("");
			System.out.print("Would you like to play lottery for $200?\nWinning will double your interest rate (Y/N): ");
			while (waitLot == 0) {
				choice = input.readLine();
				if (choice.equalsIgnoreCase("Y") && endingBal >= 200) {
					endingBal -= 200;
					waitLot = 1;
					double n = rand.nextInt(5);
					System.out.print("Please enter a Natural Number between 0-5: ");
					number = Integer.parseInt(input.readLine());
					//Health Loss due to winning Lottery 2 or more times in a row
					if (number == n) {
						intRate += intRate;
						System.out.println("The number is correct! Your Interest Rate is now %" + d.format(intRate));
						System.out.println("");
						if (hpCheck == 0) {
							hpCheck = 1;
						} else {
							health = health - 25;
							System.out.println("You lost 25 HP due to excitement, your HP is now at " + health);
							System.out.println("Try not to win multiple lotteries in an row");
							System.out.println("");
						}
					} else {
						System.out.println("Sorry, you lose the lottery!");
						System.out.println("");
						hpCheck = 0;
					}
				} else if (choice.equalsIgnoreCase("N")) {
					System.out.println("OK, no lottery");
					System.out.println("");
					waitLot = 1;
				} else if (endingBal < 200) {
					System.out.println("You don't have enough money! Poor you!");
					System.out.println("");
					hpCheck = 0;
					waitLot = 1;
				} else {
					System.out.println("Please only use 'Y' for Yes and 'N' for No");
				}
			}
			// end of lottery system
			//
			//

			//Start of stock system
			waitStock = 0;
			waitStock2 = 0;
			System.out.println("You have " + trumpStockNumber + " trumpStock(s) on your account");
			System.out.print("Would you like to purchase stocks? (Y/N): ");
			while (waitStock == 0) {
				choiceStock = input.readLine();
				double stockIncreaseDecrease = rand.nextInt(8);
				double stockChangeAmount = 0.0 + (0.10 - 0.0) * stockUse.nextDouble();
				if (stockIncreaseDecrease <= 3) {
					//increase the stock by percent
					trumpStock += trumpStock * stockChangeAmount;
				} else if (stockIncreaseDecrease <= 7) {
					//decrease the stock
					trumpStock -= trumpStock * stockChangeAmount;
				} else if (stockIncreaseDecrease == 8) {
					trumpStock = trumpStock * 1.1;
				} else {
					trumpStock = trumpStock * 0.9;
				}
				String plusOrMinus = "";
				if (choiceStock.equalsIgnoreCase("y")) {
					waitStock = 1;
					System.out.println("*******************");
					System.out.println("Here are the current stock(s) open today");
					System.out.println();
					System.out.println("Stock name\t\tPrice\tChange");
					//Show percent increase/decrease
					if (stockIncreaseDecrease <= 3) {
						plusOrMinus = "+" + d.format(stockChangeAmount * 100) + "%";
					} else if (stockIncreaseDecrease <= 7) {
						plusOrMinus = "-" + d.format(stockChangeAmount * 100) + "%";
					} else if (stockIncreaseDecrease == 8) {
						plusOrMinus = "+10%";
					} else if (stockIncreaseDecrease == 9) {
						plusOrMinus = "-10%";
					}
					waitBuy = 0;
					waitSell = 0;
					System.out.println("1.TrumpStock\t$" + d.format(trumpStock) + "\t" + plusOrMinus);
					System.out.println("*******************");
					System.out.print("Press 'B' for buy, 'S' for sell, enter 'N' to proceed to the next year: ");
					int buyOrSellAmount;
					while (waitStock2 == 0) {
						String buyOrSell = input.readLine();
						//buy, add current amount of stock
						if (buyOrSell.equalsIgnoreCase("b")) {
							waitStock2 = 1;
							System.out.print("Input buy amount(number of stocks)(Enter 0 to cancel): ");
							while (waitBuy == 0) {
								buyOrSellAmount = Integer.parseInt(input.readLine());
								//check for enough money
								if (buyOrSellAmount > 0 && endingBal >= trumpStock * buyOrSellAmount) {
									endingBal = endingBal - trumpStock * buyOrSellAmount;
									trumpStockNumber += buyOrSellAmount;
									System.out.println("Success, you purchased " + buyOrSellAmount + " stock(s)");
									System.out.println("You now have " + trumpStockNumber + " stock(s)");
									waitBuy = 1;
								} else if (buyOrSellAmount == 0) {
									System.out.println("OK");
									waitBuy = 1;
								} else {
									System.out.println("Invaild number, you might not have enough money");
								}
							}
						} else if (buyOrSell.equalsIgnoreCase("s")) {
							if (trumpStockNumber == 0) {
								System.out.println("You don't have any stocks, please buy before selling");
							} else {
								System.out.print("Input sell amount(number of stocks)(Enter 0 to cancel): ");
								waitStock2 = 1;
								while (waitSell == 0) {
									buyOrSellAmount = Integer.parseInt(input.readLine());
									if (trumpStockNumber >= buyOrSellAmount) {
										endingBal = endingBal + trumpStock * buyOrSellAmount;
										trumpStockNumber -= buyOrSellAmount;
										System.out.println("Success, you sold " + buyOrSellAmount + " stock(s)");
										System.out.println("You now have " + trumpStockNumber + " stock(s)");
										waitSell = 1;
									} else if (buyOrSellAmount == 0) {
										System.out.println("OK");
										waitSell = 1;
									} else {
										System.out.println("Sorry, that is an invaild number, please enter a number within the amount you have: " + trumpStockNumber);
									}
								}
							}
						} else if (buyOrSell.equalsIgnoreCase("n")) {
							System.out.println("OK, proceeding to next year");
							waitStock2 = 1;
						} else {
							System.out.println("Please only enter 'B', 'S' or 'N'");
						}
					}
				} else if (choiceStock.equalsIgnoreCase("n")) {
					waitStock = 1;
					System.out.println("OK, proceeding to next year");
				} else {
					System.out.println("Please only enter 'Y' for Yes and 'N' for No");
				}
			}
			System.out.println("-----------------------------------------");
			System.out.println("You have reached the level:");

			String lvl = "";
			int lvlmon = 0;


			if (endingBal <= 50) {
				System.out.println("Lvl 1: Slave");
				lvl = "Poor";
				lvlmon = 500;
			} else if (endingBal <= 500) {
				System.out.println("Lvl 2: Poor");
				lvl = "Communist";
				lvlmon = 1000;
			} else if (endingBal <= 1000) {
				System.out.println("Lvl 3: Communist");
				lvl = "Medium Class";
				lvlmon = 2000;
			} else if (endingBal <= 2000) {
				System.out.println("Lvl 4: Medium Class");
				lvl = "Capitalist";
				lvlmon = 5000;
			} else if (endingBal <= 5000) {
				System.out.println("Lvl 5: Capitalist");
				lvl = "Dictatorship";
				lvlmon = 10000;
			} else if (endingBal <= 10000) {
				System.out.println("Lvl 6: Dictatorship");
				lvl = "Java Programmer";
				lvlmon = 20000;
			} else if (endingBal <= 20000) {
				System.out.println("Lvl 7: Java Programmer");
				lvl = "Html coder";
				lvlmon = 100000;
			} else if (endingBal <= 100000) {
				System.out.println("Lvl 8: Html Coder");
				lvl = "Bank Rubber";
				lvlmon = 200000;
			} else if (endingBal <= 200000) {
				System.out.println("Lvl 9: Bank Rubber");
				lvl = "Bank Rubber";
				lvlmon = 800000;
			} else if (endingBal <= 800000) {
				System.out.println("Lvl 10: Stock Master");
				lvl = "Godlike";
				lvlmon = 2000000;
			} else if (endingBal <= 2000000) {
				System.out.println("Lvl 11: Godlike");
				lvl = "Tax collector";
				lvlmon = 6000000;
			} else if (endingBal <= 6000000) {
				System.out.println("Lvl 12: Tax Collector");
				lvl = "Donald Trump";
				lvlmon = 10000000;

			} else if (endingBal >= 6000000 && waiter == 0) {
				System.out.println("Lvl MAX: Donald Trump");
				System.out.println("You win the game!");
				System.out.print("Continue? Y/N: ");
				while (waiter == 0) {
					yesorno = input.readLine();
					if (yesorno.equalsIgnoreCase("n")) {
						System.exit(0);
					} else if
					(yesorno.equalsIgnoreCase("y")) {
						System.out.println("OK");
						waiter = 1;
						lvl = "Donald Trump";
					} else {
						System.out.println("Use 'y' for Yes and 'n' for no");
					}
				}
			} else {
				System.out.println("Lvl MAX: Donald Trump");
				lvl = "Donald Trump";
			}

			if (lvl.equals("Donald Trump")) {
				System.out.println("");
			} else {
				System.out.println("You need $" + d.format(lvlmon - endingBal) + " to reach the next level: " + lvl);
			}
			System.out.println("-----------------------------------------");
			age++;
		}
	}

	public int getRandomList(List<Integer> list) {

		// 0-5
		int index = ThreadLocalRandom.current().nextInt(list.size());
		return list.get(index);
	}

	public int getRandomAge(List<Integer> age) {

		// 0-5
		int index = ThreadLocalRandom.current().nextInt(age.size());
		return age.get(index);
	}
}
