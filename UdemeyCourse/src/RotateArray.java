import java.util.*;
public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the length of an array");
		int len=scanner.nextInt();
		System.out.println("Enter the array elements");
		int arr[]=new int[len];
		for(int i=0;i<len;i++) {
			arr[i]=scanner.nextInt();
		}
		System.out.println("Enter the rotation elements");
		int rotate=scanner.nextInt();
		int result[]=new int[len];
		int count=0;
		int k=0;
		if(rotate > len) {
			 k=rotate%len;
			}
		else{
			k=rotate;
		}
		for(int i=len-1;i>=k;i--) {
			result[count]=arr[i];
			count++;
		}
		for(int i=0;i<len-k;i++) {
			result[count]=arr[i];
			count++;
		}
		System.out.println(Arrays.toString(result));
	}
		
}


