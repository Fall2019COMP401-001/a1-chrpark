package a1;

import java.util.Scanner;

public class A1Jedi {

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
		
		int[] count = new int [totalitemcount*2];

		//main for loop
		for (int j=0; j<customercount; j++) {
			int[] repeats = new int [totalitemcount*2];
			String fname = scan.next();
			String lname = scan.next();
			int itemcount = scan.nextInt();
			
			String[] list = new String [itemcount*2];
			for (int k=0; k<list.length; k++) {
				list[k] = scan.next();
			}
			
			//m is whole list of items; n is customers list of items
			for (int n=1; n<itemcount*2; n+=2) {
				for (int m=0; m<items.length; m+=2) {
					if (list[n].equals(items[m])) {
						count[m]++;
						count[m+1] = count[m+1] + Integer.parseInt(list[n-1]);
						repeats[m]++;
						if (repeats[m]>1) {
							count[m] = count[m] - 1;
						}
						else {
							continue;
						}
					}
				}
			}
		}
		for (int p=0; p<count.length; p+=2) {
			if (count[p] <= 0) {
				System.out.println("No customers bought " + items[p]);
			}
			else {
				System.out.println(count[p] + " customers bought " + count[p+1] + " " + items[p]);
			}
		}
	}
}
