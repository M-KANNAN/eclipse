import java.util.Arrays;
import java.util.Scanner;

public class MergingTwoSortedArrayWithoutDuplicates {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int len1,len2;
		System.out.println("Enter the size of array 1");
		len1=scanner.nextInt();
		int a[]=new int[len1];
		System.out.println("Enter the 1 array elements");
		for(int i=0;i<len1;i++) {
			a[i]=scanner.nextInt();

		}
		System.out.println("Enter the size of array 2");
		len2=scanner.nextInt();
		int b[]=new int[len2];
		System.out.println("Enter the 2 array elements");
		for(int i=0;i<len2;i++) {
			b[i]=scanner.nextInt();
		}
		
		//Sorting array 1
		
		for(int i=0;i<len1;i++) {
			for(int j=i+1;j<len1;j++) {
				if(a[j]<a[i]) {
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
					
				}
			}
		
		}
		//Print sorted array 1
		System.out.println("Sorted array1 : "+Arrays.toString(a));

		//Sorting array 2
		for(int i=0;i<len2;i++) {
			for(int j=i+1;j<len2;j++) {
				if(b[j]<b[i]) {
					int temp=b[i];
					b[i]=b[j];
					b[j]=temp;
				}
			}
		}
		
		//Printing the sorted array 2
		System.out.println("Sorted Array 2 : "+ Arrays.toString(b));
		
		
		//Merging array without duplicate elements
		int len3=len1+len2;
		
		int c[]=new int[len3];
		
		for(int i=0;i<len1;i++) {
			c[i]=a[i];
			for(int j=0;j<len2;j++) {
				if(a[i]==b[j]) {
					
				}
				 if(a[i]!=b[j]) {
					c[j]=b[j];
					j++;
				}
				
			}
		}
		System.out.println("Merged array Without Duplicates : "+Arrays.toString(c));
		
		
	}

}
