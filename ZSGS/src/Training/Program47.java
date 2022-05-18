package Training;

import java.util.Scanner;

public class Program47 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the no of rows");
		int noOfRows=scanner.nextInt();
		int rowCount=1;
		for(int i=0;i<noOfRows;i++) {
			for(int j=2*(noOfRows-i);j>=1;j--) {
				System.out.print(" ");
			}
			for(int j=1;j<=rowCount;j++) {
				System.out.print(" "+j);
			}
			for(int j=rowCount-1;j>=1;j--) {
				System.out.print(" "+j);
			}
			System.out.println();
			rowCount++;
			 
		}

		scanner.close();

	}

}
