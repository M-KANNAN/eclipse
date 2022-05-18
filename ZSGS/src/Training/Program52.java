package Training;

import java.util.Scanner;

public class Program52 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the String :");
		String s1=scanner.nextLine();
		String arr[]=s1.split(" ");
		for(int i=arr.length-1;i>=0;i--) {
			System.out.print(arr[i]+" ");
		}
		scanner.close();
	}

}
