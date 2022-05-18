package Training;

import java.util.Arrays;
import java.util.Scanner;

public class Program40 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of an array : ");
		int len=scanner.nextInt();
		int arr[]=new int[len];
		System.out.println("Enter the array elements ");
		for(int i=0;i<arr.length;i++) {
			arr[i]=scanner.nextInt();
		}
		System.out.println("Array elements are : "+Arrays.toString(arr));
		scanner.close();
	}
	

}
