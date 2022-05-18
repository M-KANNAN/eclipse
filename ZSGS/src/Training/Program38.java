package Training;

import java.util.Arrays;
import java.util.Scanner;

public class Program38 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of an array  : ");
		int len=scanner.nextInt();
		int arr[]=new int[len];
		System.out.println("Enter the array elements ");
		for(int i=0;i<arr.length;i++) {
			arr[i]=scanner.nextInt();
		}
		Arrays.sort(arr);
		System.out.println("Largest element in a array is :"+arr[arr.length-1]);
		scanner.close();

	}

}
