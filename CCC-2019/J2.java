package c3.homework;

//CCC 2019 J2
import java.util.Scanner;

public class J22019 {

	public static void main(String[] args) {

		// Input how many lines of "secrate message"
		Scanner input = new Scanner(System.in);
		int loopTime = input.nextInt();

		// Make two arrays based on the "lines of secrate message"
		int[] symbolsN = new int[loopTime];
		String[] code = new String[loopTime];

		// input numbers of outprint and char
		for (int i = 0; i < loopTime; i++) {
			symbolsN[i] = input.nextInt();
			code [i] = input.nextLine();
			code [i] = code [i].trim();
		}
		input.close();

		// Output
		for (int i = 0; i < loopTime; i++) {
			for (int j = 0; j < symbolsN[i]; j++) {
				System.out.print(code [i]);
			}
			System.out.println();
		}

	}

}
