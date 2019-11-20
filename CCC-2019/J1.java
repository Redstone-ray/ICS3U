package c3.homework;

import java.util.Scanner;

public class J12019 {
	public static void main(String[] args) {
		int apple=0,banana=0,inputScore=0;
		Scanner input = new Scanner(System.in);
		for (int i=3; i>=1; i--) {
			inputScore=input.nextInt();
			apple+=inputScore*i;
		}
		for (int i=3; i>=1; i--) {
			inputScore=input.nextInt();
			banana+=inputScore*i;
		}
		input.close();
		if (apple>banana) {
			System.out.println("A");
		}
		else if (apple<banana) {
			System.out.println("B");
		}
		else {
			System.out.println("T");
		}


	}
}
