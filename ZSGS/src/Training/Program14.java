package Training;

import java.util.Scanner;

public class Program14 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the length in cm :");
		double length=scanner.nextDouble();
		System.out.println("Enter the breath in cm :");
		double breath=scanner.nextDouble();
		System.out.println("Area of square : "+(length*breath)+" (cm)");
		scanner.close();

	}

}
