package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		int customercount = scan.nextInt();

		for (int i=0; i<customercount; i++) {
			String fname = scan.next();
			String lname = scan.next();
			int itemcount = scan.nextInt();
			
			char initial = fname.charAt(0);
			double total = 0.00;
			
			for (int j=0; j<itemcount; j++) {
				int singleitemcount = scan.nextInt();
				String item = scan.next();
				double cost = scan.nextDouble();
				total = total + singleitemcount * cost;
			}
			String t = String.format("%.2f", total);
			System.out.println(initial + ". " + lname + ": " + t);	
		}
	}
}
