import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the size of an array :");
		int len=scanner.nextInt();
		int arr[]=new int[len];
		System.out.println("Enter the array elements in ascending order : ");
		for(int i=0;i<len;i++) {
			arr[i]=scanner.nextInt();
		}
		System.out.println("Enter the search element : ");
		int search=scanner.nextInt();
		int result=binarySearch(arr,search);
		if(result == -1) {
			System.out.println("Element "+search+" Not fount in the given array");
		}
		else {
			System.out.println("Element "+search+"  fount in the position : "+result);
		}

	}

	private static int binarySearch(int[] arr, int search) {
		// TODO Auto-generated method stub
		int right=arr.length-1;
		int left=0;
		while(left<=right) {
			int mid=(left+right)/2;
			System.out.println("MID : "+mid);
			if(arr[mid] == search) {
				return mid;
			}
			else if(search > arr[mid]) {
				left=mid+1;
			}
			else {
				right=mid-1;
			}
				
		}
		return -1;
	}

}
