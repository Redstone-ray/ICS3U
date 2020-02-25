import java.util.Scanner;

public class HappyOrSad {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String pharse=input.nextLine();
		int happy=0, sad=0;
		for (int i=0; i<pharse.length()-2; i++) {
			if (pharse.substring(i, i+3).equals(":-)")) {
				happy++;
			}
			else if (pharse.substring(i, i+3).equals(":-(")) {
				sad++;
			}
			else {
			}
		
		}
		if (happy==0 && sad==0) {
			System.out.println("none");
		}
		else if (happy==sad) {
			System.out.println("unsure");
		}
		else if(happy>sad) {
			System.out.println("happy");
		}
		else {
			System.out.println("sad");
		}
		
	}
}
