package AreaCalculation;

import java.util.Scanner;

public class SquareMensuration {

	Scanner scanner=new Scanner(System.in);
	public void findSquare() {
		
		System.out.println("Welcome to Square menu");
		System.out.println("*************************");
		System.out.println("Enter width of the Square in (cm)");
		double width=scanner.nextDouble();
		
		if(width > 0) {
			System.out.println("Area of the Rectangle : "+(width*width)+" (cm)");
			System.out.println("Perimeter of the Rectangle : "+(4*width)+" (cm)");
		}
		else {
			System.out.println("!!! Invalid input !!!");
		}
		
		
		
	}

}
