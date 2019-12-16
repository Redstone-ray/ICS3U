package introduction;

import java.util.Scanner;

public class PasswordChecker {
	public static void main(String[] args) {
		int count=3;
		System.out.println("______                                              _   _____  _                  _                \r\n" +
				"| ___ \\                                            | | /  __ \\| |                | |               \r\n" +
				"| |_/ /  __ _  ___  ___ __      __  ___   _ __   __| | | /  \\/| |__    ___   ___ | | __  ___  _ __ \r\n" +
				"|  __/  / _` |/ __|/ __|\\ \\ /\\ / / / _ \\ | '__| / _` | | |    | '_ \\  / _ \\ / __|| |/ / / _ \\| '__|\r\n" +
				"| |    | (_| |\\__ \\\\__ \\ \\ V  V / | (_) || |   | (_| | | \\__/\\| | | ||  __/| (__ |   < |  __/| |   \r\n" +
				"\\_|     \\__,_||___/|___/  \\_/\\_/   \\___/ |_|    \\__,_|  \\____/|_| |_| \\___| \\___||_|\\_\\ \\___||_| ");
		System.out.println("Richard Ding 2019/12/12");
		System.out.println("===============================================================");
		System.out.print("Welcome to the defalut password checker program, ");
		Scanner input=new Scanner(System.in);

		do {
			System.out.print("Please enter your next password: ");
			String userInput=input.nextLine();
			if (userInput.equals(password)){
				System.out.println("Welcome!");
				break;
			}
			else if(!userInput.equals(password) && count > 1) {
				count--;
				System.out.println("Wrong password, you have "+count+" attempts left!");

			}
			else {
				System.out.println("!==!==!==!==!==!==!==!==!==!==!==!==!==!==!==!==!==!==!==!==!==!");
				System.out.print("You have no more attempts left, if you forgot your password, please enter \"forgot\", type any other char to exit: ");
				String forgot=input.nextLine();
				if (forgot.equalsIgnoreCase("forgot")){
					System.out.println("Why would I tell you any hints? What if you are a hacker?");
					System.out.println("It is the 'Default password checker program', so password must be 'Administrator'");
				}
				break;
			}
		} while(count>0);







	}
	public static String password="Administrator";
}
