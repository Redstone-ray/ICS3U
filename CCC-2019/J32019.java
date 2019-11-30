package c3.homework;
import java.util.Scanner;

public class J32019 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int totalLine = input.nextInt();
		for (int i = 0; i < totalLine; i++){
			StringBuilder output = new StringBuilder();
			String line = input.nextLine();
			String current = String.valueOf(line.charAt(0));
			int countSameChar = 0;
			for (int x = 0; x < line.length(); x++){
				String character = String.valueOf(line.charAt(x));
				if (character.equals(current)){
					countSameChar++;
					continue;
				}
				output.append(countSameChar);
				output.append(" ");
				output.append(current);
				output.append(" ");
				countSameChar = 1;
				current = character;
			}
			output.append(countSameChar);
			output.append(" ");
			output.append(current);
			System.out.println(output.toString());
		}
		input.close();
	}
}

