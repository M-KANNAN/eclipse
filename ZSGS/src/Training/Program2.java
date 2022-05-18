package Training;

import java.util.Scanner;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a character  :");
		String ch=scanner.next().toUpperCase();
		for(char i=ch.charAt(0) ;i <= 'Z';i++) {
			System.out.print(i);
		}
		scanner.close();
	}

}
