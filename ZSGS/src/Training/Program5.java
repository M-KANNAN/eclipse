package Training;

import java.util.Scanner;

public class Program5 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a character  :");  
		String s1=scanner.next().toUpperCase();
		char ch=s1.charAt(0);
		for(char i=ch;i>='A';i--) {
			for(char j=i;j>='A';j--) {
				System.out.print(i);
			}
			System.out.println();
		}
		scanner.close();
	
	}

}
