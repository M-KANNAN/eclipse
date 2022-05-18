package Training;

import java.util.Scanner;

public class Program15 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the height in cm :");
		double heigth=scanner.nextDouble();
		System.out.println("Enter the radius in cm :");
		double radius =scanner.nextDouble();
		System.out.println("Area of square : "+(2*3.14*radius*(radius+heigth))+" (cm)");
		scanner.close();
		

	}

}
