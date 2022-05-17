import java.util.Arrays;
import java.util.Scanner;

public class ZeroToFontOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the length of an array ");
		int len=scanner.nextInt();
		int arr[]=new int[len];
		System.out.println("Enter the array elements ");
		for(int i=0;i<len;i++) {
			arr[i]=scanner.nextInt();
		}
		int current=0;
		for(int i=0;i<len;i++) {
			if(arr[i] != 0) {
				arr[current]=arr[i];
				current ++;
			}
		}
		for(int i=current;i<len;i++) {
			arr[i]=0;
		}
		
		System.out.println(Arrays.toString(arr));

	}

}
