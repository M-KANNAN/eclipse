package Training;

import java.util.Scanner;

public class Program46 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the size of an array ");
		int len=scanner.nextInt();
		System.out.println("Enter the array elements ");
		int arr[]=new int[len];
		for(int i=0;i<len;i++) {
			arr[i]=scanner.nextInt();
		}
		System.out.println("Enter the times of rotation ");
		int n=scanner.nextInt();
		int first=0;
		for(int i=0;i<n;i++) {
			first=arr[i];
			for(int j=0;j<arr.length-1;j++) {
				arr[j]=arr[j+1];
			}
			arr[arr.length-1]=first;
		}
		System.out.println("right rotated array elements are :");
		for(int i =arr.length-1;i>=0;i--) {
			System.out.print(arr[i]+" ");
		}
		scanner.close();

	}

}
