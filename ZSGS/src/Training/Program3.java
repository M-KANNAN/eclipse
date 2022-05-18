package Training;

import java.util.Scanner;

public class Program3 {

	public static void main(String[] args) {
	
		StringBuilder builder=new StringBuilder();
		builder.trimToSize();
		System.out.println("Enter a number :");
		Scanner scanner=new Scanner(System.in);
		builder.append(scanner.next());
		try {
			System.out.println(Integer.parseInt(builder.toString()) - Integer.parseInt(builder.reverse().toString()));
			scanner.close();
		} catch (NumberFormatException e) {
			System.out.println("!!! Invalid input !!!");
		}
		
	}

}
