package Training;

import java.util.Scanner;

public class Program29 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter character : ");
		String s1=scanner.next().toUpperCase();
		char ch=s1.charAt(0);
		if(ch == 'A'|| ch == 'E' || ch == 'I'|| ch == 'O' || ch == 'U') {
			System.out.println("The given character is vovel");
		}
		else {
			System.out.println("The given character is consonent");
		}
		scanner.close();
	}

}
