package Training;

import java.util.Scanner;

public class Program13 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the side in cm :");
		double side=scanner.nextDouble();
		System.out.println("Area of square : "+(side*side)+" (cm)");
		scanner.close();

	}

}
