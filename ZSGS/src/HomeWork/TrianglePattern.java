package HomeWork;

import java.util.Scanner;

public class TrianglePattern {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the row ");
		int row =scanner.nextInt();
		for(int i=0;i<row;i++) {
			for(int j=(row-i);j>0;j--) {
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++) {
				System.out.print(" *");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0;i<row;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(" ");
			}
			for(int j=(row-i);j>0;j--) {
				System.out.print(" *");
			}
			System.out.println();
		}

	}

}
