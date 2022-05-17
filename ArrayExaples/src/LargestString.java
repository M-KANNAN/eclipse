
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LargestString {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the number of String :");
		int len=scanner.nextInt();
		String arr[]=new String[len];
		for(int i=0;i<len;i++) {
			System.out.println("Ente the String "+(i+1));
			arr[i]=scanner.next();
		}
		for(int i=0;i<arr.length;i++) {
			String temp[]=arr[i].split("");
			Arrays.sort(temp,Collections.reverseOrder());
			System.out.println(String.join("", temp));
		}

	}

}
