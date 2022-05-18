package AreaCalculation;

import java.util.Scanner;

public class RectangleMensuration {
	
	Scanner scanner=new Scanner(System.in);

	public void findRectangle() {
		System.out.println("Welcome to Rectangle menu");
		System.out.println("*************************");
		System.out.println("Eneter length of the Rectangle in (cm)");
		double length=scanner.nextDouble();
		System.out.println("Enter width of the Rectangle in (cm)");
		double width=scanner.nextDouble();
		
		if(length > 0 && width >0) {
			System.out.println("Area of the Rectangle : "+(length*width)+" (cm)");
			System.out.println("Perimeter of the Rectangle : "+(2*(length+width))+" (cm)");
		}
		else {
			System.out.println("!!! Invalid input !!!");
		}
		
		
	}

}
