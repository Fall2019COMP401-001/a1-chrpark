package a1;

import java.util.Scanner;

public class A1Adept {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		int totalitemcount = scan.nextInt();
		String[] items = new String [totalitemcount*2];
		
		//total list of items
		for (int i=0; i<items.length; i++) {
			items[i] = scan.next();
		}
		int customercount = scan.nextInt();
		
		String[] totals = new String [customercount*3];
		
		int maxindex = 0;
		int minindex = 0;
		double cur_max = 0;
		double cur_min = 0;
		double sum = 0;
		double average = 0;
		
		//main for loop
		for (int j=0; j<customercount; j++) {
			double total = 0.0;
			String fname = scan.next();
			String lname = scan.next();
			int itemcount = scan.nextInt();
			
			String[] list = new String [2+itemcount*2];
			list[0] = fname;
			list[1] = lname;
			
			for (int k=2; k<list.length; k++) {
				list[k] = scan.next();
			}
			//add names into 0, 1, 3, 4, 6, 7
			totals[3*j] = fname;
			totals[3*j+1] = lname;
			
			//m is whole list of items; n is customers list of items
			for (int n=2; n<2+itemcount*2; n+=2) {
				String finaltotal = "";
				for (int m=0; m<items.length; m+=2) {
					if (list[n+1].equals(items[m])) {
						double cost = Double.parseDouble(items[m+1]);
						int quantity = Integer.parseInt(list[n]);
						total = total + cost*quantity;
						finaltotal = String.valueOf(total);
					}
					else {
						continue;
					}
				}
				//add total into 2, 5, 8
				totals[3*j+2] = finaltotal;
			}
		}
		//max
		cur_max = Double.parseDouble(totals[2]);
		for (int a=5; a<totals.length; a+=3) {
			double temp = Double.parseDouble(totals[a]);
			if (temp > cur_max) {
				cur_max = temp;
				maxindex = a-2;
			}
		}
		//min
		cur_min = Double.parseDouble(totals[2]);
		for (int b=5; b<totals.length; b+=3) {
			double temp = Double.parseDouble(totals[b]);
			if (temp < cur_min) {
				cur_min = temp;
				minindex = b-2;
			}
		}
		//average
		int count = 0;
		for (int c=2; c<totals.length; c+=3) {
			count++;
			sum = (sum + Double.parseDouble(totals[c]));
			average = sum/count;
		}
		String stringcur_max = String.format("%.2f", cur_max);
		String stringcur_min = String.format("%.2f", cur_min);
		String stringaverage = String.format("%.2f", average);
		System.out.println("Biggest: " + totals[maxindex] + " " + totals[maxindex+1]
			+ " (" + stringcur_max + ")");
		System.out.println("Smallest: " + totals[minindex] + " " + totals[minindex+1]
				+ " (" + stringcur_min + ")");
		System.out.println("Average: " + stringaverage);
	}
}
