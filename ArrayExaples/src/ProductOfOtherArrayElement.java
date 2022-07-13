import java.util.Arrays;
import java.util.Scanner;

public class ProductOfOtherArrayElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a array size");
		int len=scanner.nextInt();
		int arr1[] =new int[len];
		int arr2[] =new int[len];
		System.out.println("Enter a array elements");
		for(int i=0;i<arr1.length;i++) {
			arr1[i]=scanner.nextInt();
		}
		int product=1;
		for(int i=0;i<arr1.length;i++) {
			 product=1;
			for(int j=0;j<arr1.length;j++) {
				if(i != j) {
					product=product*arr1[j];
				}
			}
			arr2[i]=product;
		}
		System.out.println(Arrays.toString(arr2));

	}

}
