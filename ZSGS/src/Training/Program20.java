package Training;

import java.util.Scanner;

public class Program20 {

	public static void main(String[] args) {
		 Scanner scanner=new Scanner(System.in);
			System.out.println("Enter a value for X :");
			short x=scanner.nextShort();
			System.out.println(" x++ * 2 + 3 * –x : "+( x++ * 2 + 3 * --x));
			scanner.close();

	}

}
