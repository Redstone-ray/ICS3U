package flowcontrol;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class bankBalance {
	public static void main(String[] args) {
		NumberFormat d = new DecimalFormat("#0.00");
		double bankBal=1000, intRate=0.015;
		int year=1;
		System.out.println("Year\tStarting Balance\tInterest\tEnd Balance");
		
		while(bankBal<2000) {
			StringBuilder builder=new StringBuilder();
			builder.append(year);
			builder.append("\t     ");
		
			builder.append(d.format(bankBal));
			builder.append(" \t");
			builder.append("\t");
			builder.append(d.format(bankBal*intRate));
			
			builder.append(" \t");
			builder.append("\t");
			builder.append(d.format((bankBal+bankBal*intRate)));
			System.out.println(builder.toString());
			year++;
			bankBal+=bankBal*intRate;
		}
	}
}
