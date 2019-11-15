package flowcontrol;

import java.io.DataInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.System.*;

public class Snippet {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws IOException {
        DataInputStream input = new DataInputStream(in);
        String choice, choiceStock;
        double bankBalance, intRate, endingBal, trumpStock;
        int number, ageToTrade=0,trumpStockNumber=0;
        NumberFormat d = new DecimalFormat("#0.00");
        //what's the point of this?
        NumberFormat e = new DecimalFormat("#0.00");
        NumberFormat w = new DecimalFormat("#0");
        Random rand = new Random();
        Random startingRate = new Random();
        Random stockUse = new Random();

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
        Snippet startAgeObject=new Snippet();
        //applys the age
        int age = startAgeObject.getRandomAge(ageAtStart);
        // prompt the use to enter starting balance
        out.println("You started at the age of " + age + ", with a balance of: $" + w.format(bankBalance));

        // randomly generate the intRate
        intRate = 2.5 + (8.5 - 2.5) * startingRate.nextDouble();
        out.println("Your rate of interest is " + e.format(intRate) + "%, good luck!");

        //Trade age for extra starting interest rate
        out.println("Would you like to trade some years of your life for "+d.format(intRate)+ "% plus higher percent of interest rate? (To a maximum of 5 years)");
        out.println("A number between 0-5 indicates the age you want to trade off");
        ageToTrade=Integer.parseInt(input.readLine());
        if (ageToTrade>=1 && ageToTrade<=5) {
            intRate+=ageToTrade;
            age+=ageToTrade;
            //show a message of new age if the user input a ageToTrade>0
            out.println("Success, your new interest is now: "+d.format(intRate)+"%");
            out.println(ageToTrade+" years had been added to your age, you are now "+age);
        }
        else if (ageToTrade==0) {
            out.println("Ok, continue without trading age");
        }

        endingBal = bankBalance + bankBalance * (intRate / 100);

        //set a value for trumpstock, stock 1
        trumpStock  = 125.5 + (603.5 - 125.5) * stockUse.nextDouble();

        while (age<= 80) {

            out.println("The balance at age " + age + " is $" + d.format(endingBal));
            endingBal = endingBal + endingBal * (intRate / 100);

            // lottery system
            //
            //
            out.print(
                    "Would you like to play lottery for $200?\n Winning will double your interest rate y/n");
            choice = input.readLine();
            if (choice.equalsIgnoreCase("Y") && endingBal >= 200) {
                endingBal -= 200;
                double n = rand.nextInt(5);
                out.println("Please enter a Natural Number between 0-5");
                number = Integer.parseInt(input.readLine());
                if (number == n) {
                    intRate += intRate;
                    out.println("The number is correct! Your Interest Rate is now %" + e.format(intRate));
                } else {
                    out.println("Sorry, you lose the lottery!");
                }
            } else if (endingBal <= 50) {
                out.println("You don't have enough money! Poor you!");

            } else {
                out.println("OK, no lottery");

            }
            // end of lottery system
            //
            //


            //Start of stock system
            out.println("You have "+trumpStockNumber+" trumpStock on your account;");
            out.println("Would you like to purchase stocks? Y/N");
            choiceStock=input.readLine();
            double stockIncreaseDecrease = rand.nextInt(8);
            double stockChangeAmount=0.0 + (0.10 - 0.0) * stockUse.nextDouble();
            if (stockIncreaseDecrease<=3) {
                //increase the stock by percent
                trumpStock+=trumpStock*stockChangeAmount;
            }
            else if (stockIncreaseDecrease<=7) {
                //decrease the stock
                trumpStock-=trumpStock*stockChangeAmount;
            }
            else if (stockIncreaseDecrease==8)
            {
                trumpStock=trumpStock*1.1;
            }
            else {
                trumpStock=trumpStock*0.9;
            }
            String plusOrMinus="";
            if(choiceStock.equalsIgnoreCase("y")) {
                out.println("*******************");
                out.println("Here are the current stock(s) open today");
                out.println();
                out.println("Stock name\tprice\tchange");
                //Show percent increase/decrease
                if (stockIncreaseDecrease<=3) {
                    plusOrMinus="+"+d.format(stockChangeAmount*100)+"%";
                }
                else if (stockIncreaseDecrease<=7) {
                    plusOrMinus="-"+d.format(stockChangeAmount*100)+"%";
                }
                else if (stockIncreaseDecrease==8)
                {
                    plusOrMinus="+10%";
                }
                else if (stockIncreaseDecrease==9)
                {
                    plusOrMinus="-10%";
                }

                out.println("1.TrumpStock\t"+d.format(trumpStock)+"\t"+plusOrMinus);
                out.println("*******************");
                out.println("Press 'b' for buy, 's' for sell, enter any other key to proceed to next year");
                int buyOrSellAmount;
                String buyOrSell=input.readLine();
                //buy, add current amount of stock
                if (buyOrSell.equalsIgnoreCase("b")) {
                    out.print("Input buy amount(number of stocks):");
                    buyOrSellAmount=Integer.parseInt(input.readLine());
                    //check for enough money
                    if (buyOrSellAmount>0 && endingBal<=trumpStock*buyOrSellAmount) {
                        endingBal=endingBal-(trumpStock*buyOrSellAmount);
                        trumpStockNumber+=buyOrSellAmount;
                        out.println("Success, you purchased "+buyOrSellAmount+" stocks");
                        out.println("You now have "+trumpStockNumber+ "stocks");
                    }
                    else {
                        out.println("Invaild number, you might not have enough money");
                    }
                }
                else if (buyOrSell.equalsIgnoreCase("s")) {
                    out.print("Input sell amount:");
                    buyOrSellAmount=Integer.parseInt(input.readLine());
                    if (trumpStockNumber<=buyOrSellAmount){
                        endingBal=endingBal+(trumpStock*buyOrSellAmount);
                        trumpStockNumber-=buyOrSellAmount;
                        out.println("Success, you sold "+buyOrSellAmount+" stocks");
                        out.println("You now have "+trumpStockNumber+ "stocks");
                    }
                    else {
                        out.println("Sorry, that is an invaild number, please enter a number between 0 and "+trumpStockNumber);
                    }
                }
                else {
                    out.println("OK, proceeding to next year");
                }

            }
            out.println("-----------------------------------------");
            out.println("You have reached the level:");

            String lvl="";
            int lvlmon=0;


            if (endingBal <= 50) {
                out.println("1.Slave");
                lvl = "Poor";
                lvlmon = 500;
            } else if (endingBal <= 500) {
                out.println("2.Poor");
                lvl = "Communist";
                lvlmon = 1000;
            } else if (endingBal <= 1000) {
                out.println("3.Communist");
                lvl = "Medium Class";
                lvlmon = 2000;
            } else if (endingBal <= 2000) {
                out.println("4.Medium Class");
                lvl = "Capitalist";
                lvlmon = 5000;
            } else if (endingBal <= 5000) {
                out.println("5.Capitalist");
                lvl = "Dictatorship";
                lvlmon = 10000;
            } else if (endingBal <= 10000) {
                out.println("6.Dictatorship");
                lvl = "Java Programmer";
                lvlmon = 20000;
            } else if (endingBal <= 20000) {
                out.println("7.Java Programmer");
                lvl = "Html coder";
                lvlmon = 100000;
            } else if (endingBal <= 100000) {
                out.println("8.Html coder");
                lvl = "Bank Rubber";
                lvlmon = 200000;
            } else if (endingBal <= 200000) {
                out.println("9.Bank Rubber");
                lvl = "Bank Rubber";
                lvlmon = 800000;
            } else if (endingBal <= 800000) {
                out.println("10.Stock master");
                lvl = "Godlike";
                lvlmon = 2000000;
            } else if (endingBal <= 2000000) {
                out.println("11.Godlike");
                lvl = "Tax collector";
                lvlmon = 6000000;
            } else if (endingBal <= 6000000) {
                out.println("11.Tax collector");
                lvl = "Donald Trump";
                lvlmon = 10000000;

            }
            else if (endingBal <= 10000000) {
                out.println("Donald Trump");
                out.println("You win the game!");
            }

           if (endingBal < 10000000) {
               out.println("You need $" + d.format(lvlmon - endingBal) + " to reach " + lvl);
           }
           out.println("-----------------------------------------");
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

