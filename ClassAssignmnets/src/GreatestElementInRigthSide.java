import java.util.Arrays;
import java.util.Scanner;

public class GreatestElementInRigthSide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a size of array ");
		int len=scanner.nextInt();
		System.out.println("Enter a array elements");
		int arr[]=new int[len];
		for(int i=0;i<arr.length;i++) {
			arr[i]=scanner.nextInt();
		}
		new GreatestElementInRigthSide().logicalFunction(arr);
		scanner.close();

	}

	private void logicalFunction(int[] arr) {
		int result[]=new int[arr.length];
		result[result.length -1]=-1;
		int value=arr[arr.length-1];
		for(int i=arr.length-2;i>=0;i--) {
			result[i]=value;
			if(arr[i] > value) {
				value=arr[i];
			}
		}
		
		System.out.println(Arrays.toString(result));
		
	}

}
