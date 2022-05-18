package Training;

import java.util.Scanner;

public class program55 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number1 : ");
		int noOfRows=scanner.nextInt();
		for(int i=1;i<=noOfRows;i++) {
			for(int j=0;j<=noOfRows;j++) {
				if(i==1 || j == 1 || i == noOfRows) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		scanner.close();

	}

}
