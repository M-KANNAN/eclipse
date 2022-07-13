import java.util.Arrays;
import java.util.Scanner;

public class NextValidNumber {

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
		
		new NextValidNumber().functionalLogic(arr);

	}

	private void functionalLogic(int[] arr) {
		// TODO Auto-generated method stub
		
		int result[]=new int[arr.length];
		int index=0;
		for(int i=0;i<arr.length;i++) {
			if(i < arr.length-1  && arr[i] != 0 && arr[i] == arr[i+1]) {
				arr[i] = arr[i]*2;
				arr[i+1]=0;
			}
			
		}
		
		System.out.println(Arrays.toString(arr));
		
	}

}
