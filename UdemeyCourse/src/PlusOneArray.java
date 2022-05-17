import java.util.Arrays;
import java.util.Scanner;

public class PlusOneArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//arr[]={1,2,3}
		//output : 124
		
		Scanner  scanner=new Scanner(System.in);
		System.out.println("Enter the length of an array ");
		int len=scanner.nextInt();
		int arr[]=new int[len];
		System.out.println("Enter the array elements ");
		for(int i =0;i<len;i++) {
			arr[i]=scanner.nextInt();
		}
		StringBuilder builder=new StringBuilder();
		for(int i: arr) {
			builder.append(i);
		}
		int number=Integer.parseInt(builder.toString());
		System.out.println("Number is : "+ ++number);

	}

}
