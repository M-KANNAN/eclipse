package Training;

import java.util.Scanner;

public class Program23 {

	public static void main(String[] args) {
		
		 Scanner scanner=new Scanner(System.in);
			System.out.println("Enter a value for Y :");
			short x=scanner.nextShort();
			System.out.println(" ++x – x++ + –x : "+(++x - x++ + -x));
			scanner.close();


	}

}
