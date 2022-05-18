package Training;

import java.util.Scanner;

public class Program17 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter radius for big circle :");
		float radius1=scanner.nextFloat();
		System.out.println("Enter the radius for small circle ");
		float radius2=scanner.nextFloat();
		System.out.println("Area between two concentric circles :"+(3.14*(radius1*radius1 - radius2*radius2)));
		scanner.close();
	}

}
