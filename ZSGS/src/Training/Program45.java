package Training;

import java.util.Scanner;

public class Program45 {

	public static void main(String[] args) {
	
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the size of an array :");
		int len=scanner.nextInt();
		System.out.println("Enter the array elements ");
		int arr[]=new int[len];
		for(int i=0;i<len;i++) {
			arr[i]=scanner.nextInt();
		}
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum=sum+arr[i];
		}
		System.out.println("Sum of array elements are :"+sum);
		scanner.close();
	}

}
