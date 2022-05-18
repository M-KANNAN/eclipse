package Training;

import java.util.Scanner;

public class Program48 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the no of rows");
		int noOfRows=scanner.nextInt();
		
		for(int i=0;i<noOfRows;i++) {
			for(int j=2*(noOfRows-i);j>=1;j--) {
				System.out.print(" ");
			}
			for(int k=noOfRows - i;k<=noOfRows;k++) {
				System.out.print(" "+k);
			}
			for(int l=noOfRows - i;l<noOfRows;l++) {
				System.out.print(" "+l);
			}
			System.out.println();
		}
		scanner.close();

	}

}
