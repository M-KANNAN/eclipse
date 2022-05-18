package Training;

import java.util.Scanner;

public class Program33 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter character: ");
		char ch=scanner.next().charAt(0);
		if(Character.isAlphabetic(ch)) {
			System.out.println("Given character is a Alpaphet");
		}
		else {
			System.out.println("Given character is a not Alpaphet");
		}
		scanner.close();
	}

}
