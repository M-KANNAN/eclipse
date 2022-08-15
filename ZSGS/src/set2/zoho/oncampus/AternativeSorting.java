package set2.zoho.oncampus;

import java.util.Arrays;
import java.util.Scanner;

public class AternativeSorting {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a size of an array");
		int arr[]=new int[scanner.nextInt()];
		System.out.println("Enter array elements");
		for(int i=0;i<arr.length;i++) {
			arr[i]=scanner.nextInt();
		}
		new AternativeSorting().alternateSorting(arr);
		scanner.close();

	}

	private void alternateSorting(int[] arr) {
		int temp=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i] > arr[j]) {
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		int j=arr.length-1;
		for(int i=0;i<arr.length;i++) {
			if(i<j) {
				System.out.print(arr[j] +" "+arr[i]+" ");
				j--;
			}
			else {
				System.out.print(arr[i]);
				break;
			}
		}
		
	}

}
