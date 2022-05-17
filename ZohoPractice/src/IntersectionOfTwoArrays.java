import java.util.HashSet;
import java.util.Scanner;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		int len1,len2;
		System.out.println("Enter the size of array1");
		len1=scanner.nextInt();
		int arr1[]=new int[len1];
		System.out.println("Enter the array elements");
		for(int i=0;i<len1;i++) {
			arr1[i]=scanner.nextInt();
		}
		System.out.println("Enter the size of array2");
		len2=scanner.nextInt();
		int arr2[]=new int[len2];
		System.out.println("Ente rthe array elements");
		for(int i=0;i<len2;i++) {
			arr2[i]=scanner.nextInt();
		}
		
		printIntersectionOfArray(arr1,arr2);
		

	}

	private static void printIntersectionOfArray(int[] arr1, int[] arr2) {
		// TODO Auto-generated method stub
		
		//introducing HashSet for the easiest checking
		//procedure :
		//first save the array1 elements to the HashSet
		//check the elements of HashSet with the Array2 if they are present print the elements
		
		HashSet<Integer> hs=new HashSet<Integer>();
		
		int flag=0;
		
		for(int i=0;i<arr1.length;i++) {
			hs.add(arr1[i]);
		}
		
		for(int i=0;i<arr2.length;i++) {
			if(hs.contains(arr2[i])) {
				System.out.println(arr2[i]);
				flag=1;
			}
		}
		if(flag==0) {
			System.out.println("No intersection Found");
		}
		
		
	}

}
